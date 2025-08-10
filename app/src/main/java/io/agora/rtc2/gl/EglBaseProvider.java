package io.agora.rtc2.gl;

import android.opengl.EGL14;
import android.opengl.EGLContext;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import io.agora.base.internal.CalledByNative;
import io.agora.base.internal.video.EglBase;
import io.agora.base.internal.video.EglBase10;
import io.agora.base.internal.video.EglBase14;
import io.agora.base.internal.video.EglBaseFactory;
import java.util.Objects;
import javax.microedition.khronos.egl.EGL10;

/* loaded from: classes4.dex */
public class EglBaseProvider {
    private static final String RELEASE_MESSAGE_TEMPLATE = "EglBaseProvider released %s unavailable";

    @Nullable
    private static volatile EglBaseProvider instance;
    private volatile boolean initialized = false;
    private EglBase localEglBase;
    private EglBase remoteEglBase;
    private EglBase rootEglBase;

    private EglBaseProvider() {
    }

    @CalledByNative
    public static void acquireEglBaseReadLock() {
        EglBase.rwlock.readLock().lock();
    }

    private void checkReleased(String str) {
        if (instance == null) {
            throw new IllegalStateException(String.format(RELEASE_MESSAGE_TEMPLATE, str));
        }
    }

    @CalledByNative
    public static void destroy() {
        synchronized (EglBaseProvider.class) {
            if (instance != null) {
                instance.release();
                instance = null;
            }
        }
    }

    @Nullable
    @CalledByNative
    public static EglBase.Context getCurrentEglContext() {
        if (EglBase14.isEGL14SupportedImpl()) {
            EGLContext eGLContextEglGetCurrentContext = EGL14.eglGetCurrentContext();
            if (Objects.equals(eGLContextEglGetCurrentContext, EGL14.EGL_NO_CONTEXT)) {
                return null;
            }
            return new EglBase14.Context(eGLContextEglGetCurrentContext);
        }
        EGL10 egl10 = (EGL10) javax.microedition.khronos.egl.EGLContext.getEGL();
        if (egl10 == null || !Objects.equals(egl10.eglGetCurrentContext(), EGL10.EGL_NO_CONTEXT)) {
            return null;
        }
        return new EglBase10.Context(egl10.eglGetCurrentContext());
    }

    private void initialize() {
        if (this.initialized) {
            return;
        }
        EglBase eglBaseCreate = EglBaseFactory.create();
        this.rootEglBase = eglBaseCreate;
        this.localEglBase = EglBaseFactory.create(eglBaseCreate.getEglBaseContext());
        this.remoteEglBase = EglBaseFactory.create(this.rootEglBase.getEglBaseContext());
        this.initialized = true;
    }

    @NonNull
    @CalledByNative
    public static EglBaseProvider instance() {
        EglBaseProvider eglBaseProvider;
        synchronized (EglBaseProvider.class) {
            if (instance == null) {
                instance = new EglBaseProvider();
            }
            eglBaseProvider = instance;
        }
        return eglBaseProvider;
    }

    @CalledByNative
    public static boolean isEgl14BaseContext(EglBase.Context context) {
        return context instanceof EglBase14.Context;
    }

    public static native void nativeExtensionNativeStartFunc(long j);

    public static native void nativeExtensionNativeStopFunc(long j);

    private void release() {
        synchronized (EglBaseProvider.class) {
            EglBase eglBase = this.remoteEglBase;
            if (eglBase != null) {
                eglBase.release();
            }
            EglBase eglBase2 = this.localEglBase;
            if (eglBase2 != null) {
                eglBase2.release();
            }
            EglBase eglBase3 = this.rootEglBase;
            if (eglBase3 != null) {
                eglBase3.release();
            }
            this.initialized = false;
        }
    }

    @CalledByNative
    public static void releaseEglBaseReadLock() {
        EglBase.rwlock.readLock().unlock();
    }

    @CalledByNative
    public static void startWithEglBaseLock(long j) {
        synchronized (EglBase.lock) {
            nativeExtensionNativeStartFunc(j);
        }
    }

    @CalledByNative
    public static void stopWithEglBaseLock(long j) {
        synchronized (EglBase.lock) {
            nativeExtensionNativeStopFunc(j);
        }
    }

    public EglBase getLocalEglBase() {
        EglBase eglBase;
        synchronized (EglBaseProvider.class) {
            checkReleased("getLocalEglBase");
            initialize();
            eglBase = instance.localEglBase;
        }
        return eglBase;
    }

    @CalledByNative
    public EglBase.Context getLocalEglBaseContext() {
        EglBase.Context eglBaseContext;
        synchronized (EglBaseProvider.class) {
            checkReleased("getLocalEglBaseContext");
            initialize();
            eglBaseContext = instance.localEglBase.getEglBaseContext();
        }
        return eglBaseContext;
    }

    public EglBase getRemoteEglBase() {
        EglBase eglBase;
        synchronized (EglBaseProvider.class) {
            checkReleased("getRemoteEglBase");
            initialize();
            eglBase = instance.remoteEglBase;
        }
        return eglBase;
    }

    @CalledByNative
    public EglBase.Context getRemoteEglBaseContext() {
        EglBase.Context eglBaseContext;
        synchronized (EglBaseProvider.class) {
            checkReleased("getRemoteEglBaseContext");
            initialize();
            eglBaseContext = instance.remoteEglBase.getEglBaseContext();
        }
        return eglBaseContext;
    }

    public EglBase getRootEglBase() {
        EglBase eglBase;
        synchronized (EglBaseProvider.class) {
            checkReleased("getRootEglBase");
            initialize();
            eglBase = instance.rootEglBase;
        }
        return eglBase;
    }

    @CalledByNative
    public void replaceRootBase(EglBase.Context context) {
        synchronized (EglBaseProvider.class) {
            release();
            EglBase eglBaseCreate = EglBaseFactory.create(context, EglBase.CONFIG_PLAIN);
            this.rootEglBase = eglBaseCreate;
            this.localEglBase = EglBaseFactory.create(eglBaseCreate.getEglBaseContext());
            this.remoteEglBase = EglBaseFactory.create(this.rootEglBase.getEglBaseContext());
            this.initialized = true;
        }
    }
}
