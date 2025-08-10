package dc;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import com.wear.util.MyApplication;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/* compiled from: OpenGlUtils.java */
/* loaded from: classes4.dex */
public class ii3 {
    public static Bitmap a(Context context, String str) throws IOException {
        Bitmap bitmapDecodeStream = null;
        try {
            InputStream inputStreamOpen = context.getResources().getAssets().open(str);
            bitmapDecodeStream = BitmapFactory.decodeStream(inputStreamOpen);
            inputStreamOpen.close();
            return bitmapDecodeStream;
        } catch (IOException e) {
            e.printStackTrace();
            return bitmapDecodeStream;
        }
    }

    public static int b(String str, String str2) {
        int iC;
        int[] iArr = new int[1];
        int iC2 = c(str, 35633);
        if (iC2 == 0 || (iC = c(str2, 35632)) == 0) {
            return 0;
        }
        int iGlCreateProgram = GLES20.glCreateProgram();
        GLES20.glAttachShader(iGlCreateProgram, iC2);
        GLES20.glAttachShader(iGlCreateProgram, iC);
        GLES20.glLinkProgram(iGlCreateProgram);
        GLES20.glGetProgramiv(iGlCreateProgram, 35714, iArr, 0);
        if (iArr[0] <= 0) {
            return 0;
        }
        GLES20.glDeleteShader(iC2);
        GLES20.glDeleteShader(iC);
        return iGlCreateProgram;
    }

    public static int c(String str, int i) {
        int[] iArr = new int[1];
        int iGlCreateShader = GLES20.glCreateShader(i);
        GLES20.glShaderSource(iGlCreateShader, str);
        GLES20.glCompileShader(iGlCreateShader);
        GLES20.glGetShaderiv(iGlCreateShader, 35713, iArr, 0);
        if (iArr[0] != 0) {
            return iGlCreateShader;
        }
        String str2 = "Compilation\n" + GLES20.glGetShaderInfoLog(iGlCreateShader);
        return 0;
    }

    public static int d(Context context, String str) throws IOException {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        if (iArr[0] != 0) {
            Bitmap bitmapA = a(context, str);
            GLES20.glBindTexture(3553, iArr[0]);
            GLES20.glTexParameteri(3553, 10240, 9729);
            GLES20.glTexParameteri(3553, 10241, 9729);
            GLES20.glTexParameteri(3553, 10242, 33071);
            GLES20.glTexParameteri(3553, 10243, 33071);
            GLUtils.texImage2D(3553, 0, bitmapA, 0);
            bitmapA.recycle();
        }
        if (iArr[0] != 0) {
            return iArr[0];
        }
        throw new RuntimeException("Error loading texture.");
    }

    public static String e(int i) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(MyApplication.N().getResources().openRawResource(i)));
        StringBuilder sb = new StringBuilder();
        while (true) {
            try {
                String line = bufferedReader.readLine();
                if (line == null) {
                    return sb.toString();
                }
                sb.append(line);
                sb.append('\n');
            } catch (IOException unused) {
                return null;
            }
        }
    }
}
