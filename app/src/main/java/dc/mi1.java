package dc;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import org.jetbrains.annotations.Nullable;

/* compiled from: TextureLoadUtil.kt */
/* loaded from: classes3.dex */
public final class mi1 {
    public static final mi1 a = new mi1();

    public final int a(@Nullable Bitmap bitmap) {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        if (iArr[0] == 0) {
            return 0;
        }
        if (bitmap == null) {
            GLES20.glDeleteTextures(1, iArr, 0);
            return 0;
        }
        if (bitmap.isRecycled()) {
            xh1.c.b("TextureUtil", "bitmap isRecycled");
            return 0;
        }
        GLES20.glBindTexture(3553, iArr[0]);
        GLES20.glTexParameteri(3553, 10241, 9987);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLUtils.texImage2D(3553, 0, bitmap, 0);
        GLES20.glGenerateMipmap(3553);
        GLES20.glBindTexture(3553, 0);
        return iArr[0];
    }
}
