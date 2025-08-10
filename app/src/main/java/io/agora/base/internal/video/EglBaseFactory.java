package io.agora.base.internal.video;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import io.agora.base.internal.video.EglBase;
import io.agora.base.internal.video.EglBase10;
import io.agora.base.internal.video.EglBase14;
import javax.microedition.khronos.egl.EGLContext;

/* loaded from: classes4.dex */
public class EglBaseFactory {
    public static EglBase create(@Nullable EglBase.Context context, int[] iArr) {
        return (EglBase14.isEGL14Supported() && (context == null || (context instanceof EglBase14.Context))) ? new EglBase14((EglBase14.Context) context, iArr) : new EglBase10((EglBase10.Context) context, iArr);
    }

    public static EglBase createEgl10(int[] iArr) {
        return new EglBase10(null, iArr);
    }

    public static EglBase.Context createEgl10Context(@NonNull EGLContext eGLContext) {
        return new EglBase10.Context(eGLContext);
    }

    public static EglBase createEgl14(int[] iArr) {
        return new EglBase14(null, iArr);
    }

    public static EglBase.Context createEgl14Context(@NonNull android.opengl.EGLContext eGLContext) {
        return new EglBase14.Context(eGLContext);
    }

    public static boolean isEglBase14(@NonNull EglBase.Context context) {
        return context instanceof EglBase14.Context;
    }

    public static EglBase createEgl10(EGLContext eGLContext, int[] iArr) {
        return new EglBase10(new EglBase10.Context(eGLContext), iArr);
    }

    public static EglBase createEgl14(android.opengl.EGLContext eGLContext, int[] iArr) {
        return new EglBase14(new EglBase14.Context(eGLContext), iArr);
    }

    public static EglBase create() {
        return create(null, EglBase.CONFIG_PLAIN);
    }

    public static EglBase create(EglBase.Context context) {
        return create(context, EglBase.CONFIG_PLAIN);
    }
}
