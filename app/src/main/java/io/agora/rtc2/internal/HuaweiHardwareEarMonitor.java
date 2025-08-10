package io.agora.rtc2.internal;

import android.content.Context;
import androidx.annotation.VisibleForTesting;
import io.agora.base.internal.ContextUtils;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import org.jivesoftware.smackx.muc.packet.Destroy;

/* loaded from: classes4.dex */
public class HuaweiHardwareEarMonitor implements IHardwareEarMonitor {
    private static final String TAG = "HuaweiHardwareEarMonitor";
    private Context mContext;
    private Class<?> mHwAudioKaraokeFeatureKitClass;
    private Class<?> mHwAudioKitClass;
    private HardwareEarMonitorListener mListener;
    private Class<?> mParamNameClass;
    private AudioKitCallbackImpl mAudioKitCallbackImpl = new AudioKitCallbackImpl();
    private Object mHwAudioKit = null;
    private Object mHwAudioKaraokeFeatureKit = null;
    private volatile boolean mInitialized = false;
    private volatile boolean mEarMonitorEnabled = false;

    public class AudioKitCallbackImpl implements InvocationHandler {
        private AudioKitCallbackImpl() {
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) {
            String str;
            String str2;
            try {
                Logging.i(HuaweiHardwareEarMonitor.TAG, "invoke, method: " + method.getName());
                if ("onResult".equals(method.getName())) {
                    int iIntValue = ((Integer) objArr[0]).intValue();
                    if (iIntValue == 0) {
                        str = HuaweiHardwareEarMonitor.TAG;
                        str2 = "IAudioKitCallback: HwAudioKit init success";
                    } else if (iIntValue == 2) {
                        str = HuaweiHardwareEarMonitor.TAG;
                        str2 = "IAudioKitCallback: audio kit not installed";
                    } else if (iIntValue != 1000) {
                        Logging.e(HuaweiHardwareEarMonitor.TAG, "IAudioKitCallback: onResult error number " + iIntValue);
                    } else {
                        HuaweiHardwareEarMonitor.this.mInitialized = true;
                        if (HuaweiHardwareEarMonitor.this.mListener != null) {
                            HuaweiHardwareEarMonitor.this.mListener.onInitSuccess();
                        }
                        str = HuaweiHardwareEarMonitor.TAG;
                        str2 = "IAudioKitCallback: HwAudioKaraokeFeatureKit init success ";
                    }
                    Logging.i(str, str2);
                }
            } catch (Exception e) {
                Logging.e(HuaweiHardwareEarMonitor.TAG, "AudioKitCallbackImpl invoke failed ", e);
            }
            return obj;
        }
    }

    public HuaweiHardwareEarMonitor(HardwareEarMonitorListener hardwareEarMonitorListener) {
        Logging.i(TAG, ">>ctor");
        this.mListener = hardwareEarMonitorListener;
        this.mContext = ContextUtils.getApplicationContext();
    }

    @Override // io.agora.rtc2.internal.IHardwareEarMonitor
    public void destroy() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        String str = TAG;
        Logging.i(str, ">>destroy");
        this.mListener = null;
        if (this.mInitialized) {
            this.mInitialized = false;
            try {
                this.mHwAudioKaraokeFeatureKitClass.getDeclaredMethod(Destroy.ELEMENT, new Class[0]).invoke(this.mHwAudioKaraokeFeatureKit, new Object[0]);
                this.mHwAudioKitClass.getDeclaredMethod(Destroy.ELEMENT, new Class[0]).invoke(this.mHwAudioKit, new Object[0]);
                Logging.i(str, ">>destroy success");
            } catch (Exception e) {
                Logging.e(TAG, "destroy failed ", e);
            }
        }
    }

    @Override // io.agora.rtc2.internal.IHardwareEarMonitor
    public int enableHardwareEarMonitor(boolean z) {
        String str = TAG;
        Logging.i(str, ">>enableHardwareEarMonitor " + z);
        if (!this.mInitialized) {
            return -7;
        }
        if (!isHardwareEarMonitorSupported()) {
            Logging.e(str, "karaoke not supported");
            return -1;
        }
        try {
            int iIntValue = ((Integer) this.mHwAudioKaraokeFeatureKitClass.getDeclaredMethod("enableKaraokeFeature", Boolean.TYPE).invoke(this.mHwAudioKaraokeFeatureKit, Boolean.valueOf(z))).intValue();
            if (iIntValue != 0) {
                Logging.e(str, "enableKaraokeFeature failed ret " + iIntValue);
                return -1;
            }
            this.mEarMonitorEnabled = z;
            if (this.mEarMonitorEnabled) {
                Logging.i(str, "latency: " + ((Integer) this.mHwAudioKaraokeFeatureKitClass.getDeclaredMethod("getKaraokeLatency", new Class[0]).invoke(this.mHwAudioKaraokeFeatureKit, new Object[0])).intValue());
            }
            return 0;
        } catch (Exception e) {
            Logging.e(TAG, "enableHardwareEarMonitor failed ", e);
            return -1;
        }
    }

    @VisibleForTesting
    public InvocationHandler getInvocationHandler() {
        return this.mAudioKitCallbackImpl;
    }

    @Override // io.agora.rtc2.internal.IHardwareEarMonitor
    public void initialize() throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        String str = TAG;
        Logging.i(str, ">>initialize");
        if (this.mContext == null) {
            Logging.e(str, "mContext is null!");
            return;
        }
        if (this.mInitialized) {
            Logging.w(str, "already initialized, ignore");
            return;
        }
        try {
            this.mHwAudioKaraokeFeatureKitClass = Class.forName("com.huawei.multimedia.audiokit.interfaces.HwAudioKaraokeFeatureKit");
            this.mHwAudioKitClass = Class.forName("com.huawei.multimedia.audiokit.interfaces.HwAudioKit");
            Class<?> cls = Class.forName("com.huawei.multimedia.audiokit.interfaces.IAudioKitCallback");
            Class<?> cls2 = Class.forName("com.huawei.multimedia.audiokit.interfaces.HwAudioKit$FeatureType");
            this.mParamNameClass = Class.forName("com.huawei.multimedia.audiokit.interfaces.HwAudioKaraokeFeatureKit$ParameName");
            this.mHwAudioKit = this.mHwAudioKitClass.getConstructor(Context.class, cls).newInstance(this.mContext, Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, this.mAudioKitCallbackImpl));
            this.mHwAudioKitClass.getDeclaredMethod("initialize", new Class[0]).invoke(this.mHwAudioKit, new Object[0]);
            this.mHwAudioKaraokeFeatureKit = this.mHwAudioKitClass.getDeclaredMethod("createFeature", cls2).invoke(this.mHwAudioKit, cls2.getEnumConstants()[0]);
            Logging.i(str, "initialize success ");
        } catch (Exception unused) {
            Logging.e(TAG, "initialize failed ");
        }
    }

    @Override // io.agora.rtc2.internal.IHardwareEarMonitor
    public boolean isHardwareEarMonitorSupported() {
        String str = TAG;
        Logging.i(str, ">>isHardwareEarMonitorSupported");
        if (!this.mInitialized) {
            return false;
        }
        try {
            boolean zBooleanValue = ((Boolean) this.mHwAudioKaraokeFeatureKitClass.getDeclaredMethod("isKaraokeFeatureSupport", new Class[0]).invoke(this.mHwAudioKaraokeFeatureKit, new Object[0])).booleanValue();
            Logging.i(str, "isSupported " + zBooleanValue);
            return zBooleanValue;
        } catch (Exception e) {
            Logging.e(TAG, "isHardwareEarMonitorSupported false ", e);
            return false;
        }
    }

    @Override // io.agora.rtc2.internal.IHardwareEarMonitor
    public int setHardwareEarMonitorVolume(int i) {
        if (!this.mInitialized || !this.mEarMonitorEnabled) {
            return -7;
        }
        String str = TAG;
        Logging.i(str, ">>setHardwareEarMonitorVolume " + i);
        if (i < 0) {
            i = 0;
        } else if (i > 100) {
            i = 100;
        }
        try {
            int iIntValue = ((Integer) this.mHwAudioKaraokeFeatureKitClass.getDeclaredMethod("setParameter", this.mParamNameClass, Integer.TYPE).invoke(this.mHwAudioKaraokeFeatureKit, this.mParamNameClass.getEnumConstants()[1], Integer.valueOf(i))).intValue();
            Logging.i(str, "setParameter ret " + iIntValue);
            return iIntValue != 0 ? -1 : 0;
        } catch (Exception e) {
            Logging.e(TAG, "setHardwareEarMonitorVolume failed ", e);
            return -1;
        }
    }

    @VisibleForTesting
    public void setHwAudioKaraokeFeatureKit(Object obj) {
        this.mHwAudioKaraokeFeatureKit = obj;
    }
}
