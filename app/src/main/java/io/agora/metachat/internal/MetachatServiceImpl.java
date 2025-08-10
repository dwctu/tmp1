package io.agora.metachat.internal;

import android.content.Context;
import androidx.core.os.EnvironmentCompat;
import io.agora.metachat.IMetachatEventHandler;
import io.agora.metachat.IMetachatService;
import io.agora.metachat.MetachatConfig;
import io.agora.metachat.MetachatSceneConfig;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes4.dex */
public class MetachatServiceImpl extends IMetachatService {
    private static final String TAG = "MetachatServiceImpl";
    private long mNativeHandle = 0;

    private native int nativeAddEventHandler(long j, Object obj);

    private native int nativeCancelDownloadScene(long j, long j2);

    private native int nativeCleanScene(long j, long j2);

    private native int nativeCreateScene(long j, MetachatSceneConfig metachatSceneConfig);

    private static native int nativeDestroy(long j);

    private native int nativeDownloadScene(long j, long j2);

    private native int nativeGetSceneInfos(long j);

    private native int nativeIsSceneDownloaded(long j, long j2);

    private native long nativeObjectInit(MetachatConfig metachatConfig, long j);

    private native int nativeRemoveEventHandler(long j, Object obj);

    private native int nativeRenewToken(long j, String str);

    @Override // io.agora.metachat.IMetachatService
    public int addEventHandler(IMetachatEventHandler iMetachatEventHandler) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeAddEventHandler(j, iMetachatEventHandler);
    }

    @Override // io.agora.metachat.IMetachatService
    public int cancelDownloadScene(long j) {
        long j2 = this.mNativeHandle;
        if (j2 == 0) {
            return -7;
        }
        return nativeCancelDownloadScene(j2, j);
    }

    @Override // io.agora.metachat.IMetachatService
    public int cleanScene(long j) {
        long j2 = this.mNativeHandle;
        if (j2 == 0) {
            return -7;
        }
        return nativeCleanScene(j2, j);
    }

    @Override // io.agora.metachat.IMetachatService
    public int createScene(MetachatSceneConfig metachatSceneConfig) {
        if (metachatSceneConfig.mActivityContext == null) {
            return -2;
        }
        return nativeCreateScene(this.mNativeHandle, metachatSceneConfig);
    }

    @Override // io.agora.metachat.IMetachatService
    public int downloadScene(long j) {
        long j2 = this.mNativeHandle;
        if (j2 == 0) {
            return -7;
        }
        return nativeDownloadScene(j2, j);
    }

    public String getLauncherVersion(Context context) throws IOException {
        if (context == null) {
            return new String(EnvironmentCompat.MEDIA_UNKNOWN);
        }
        try {
            InputStream inputStreamOpen = context.getAssets().open("LauncherVersion.txt", 3);
            byte[] bytes = new byte[inputStreamOpen.available()];
            if (inputStreamOpen.read(bytes) <= 0) {
                bytes = EnvironmentCompat.MEDIA_UNKNOWN.getBytes();
            }
            inputStreamOpen.close();
            return new String(bytes, "UTF-8");
        } catch (IOException e) {
            String str = "get launcher version failed, " + e.getMessage();
            return "";
        }
    }

    @Override // io.agora.metachat.IMetachatService
    public int getSceneInfos() {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeGetSceneInfos(j);
    }

    @Override // io.agora.metachat.IMetachatService
    public int initialize(MetachatConfig metachatConfig) {
        if (metachatConfig.mRtcEngine == null || metachatConfig.mAppId.equals("")) {
            return -2;
        }
        metachatConfig.mRtcEngine.loadExtensionProvider("agora_rtm_loader_extension");
        long jNativeObjectInit = nativeObjectInit(metachatConfig, metachatConfig.mRtcEngine.getNativeHandle());
        this.mNativeHandle = jNativeObjectInit;
        return jNativeObjectInit == 0 ? -7 : 0;
    }

    @Override // io.agora.metachat.IMetachatService
    public int isSceneDownloaded(long j) {
        long j2 = this.mNativeHandle;
        if (j2 == 0) {
            return -7;
        }
        return nativeIsSceneDownloaded(j2, j);
    }

    @Override // io.agora.metachat.IMetachatService
    public int release() {
        long j = this.mNativeHandle;
        if (j == 0) {
            return 0;
        }
        nativeDestroy(j);
        this.mNativeHandle = 0L;
        return 0;
    }

    @Override // io.agora.metachat.IMetachatService
    public int removeEventHandler(IMetachatEventHandler iMetachatEventHandler) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeRemoveEventHandler(j, iMetachatEventHandler);
    }

    @Override // io.agora.metachat.IMetachatService
    public int renewToken(String str) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -7;
        }
        return nativeRenewToken(j, str);
    }
}
