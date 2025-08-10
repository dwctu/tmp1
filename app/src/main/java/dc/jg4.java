package dc;

import android.content.Context;
import android.graphics.Matrix;
import android.view.WindowManager;
import io.agora.rtc2.Constants;
import org.webrtc.TextureBufferImpl;
import org.webrtc.VideoFrame;

/* compiled from: CameraSession.java */
/* loaded from: classes5.dex */
public final /* synthetic */ class jg4 {
    public static VideoFrame.TextureBuffer a(TextureBufferImpl textureBufferImpl, boolean z, int i) {
        Matrix matrix = new Matrix();
        matrix.preTranslate(0.5f, 0.5f);
        if (z) {
            matrix.preScale(-1.0f, 1.0f);
        }
        matrix.preRotate(i);
        matrix.preTranslate(-0.5f, -0.5f);
        return textureBufferImpl.applyTransformMatrix(matrix, textureBufferImpl.getWidth(), textureBufferImpl.getHeight());
    }

    public static int b(Context context) {
        int rotation = ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRotation();
        if (rotation == 1) {
            return 90;
        }
        if (rotation == 2) {
            return 180;
        }
        if (rotation != 3) {
            return 0;
        }
        return Constants.VIDEO_ORIENTATION_270;
    }
}
