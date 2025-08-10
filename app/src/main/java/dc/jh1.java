package dc;

import android.opengl.GLES20;

/* compiled from: MaskShader.kt */
/* loaded from: classes3.dex */
public final class jh1 {
    public final int a;
    public final int b;
    public final int c;
    public final int d;

    public jh1(boolean z) {
        ji1 ji1Var;
        String str;
        if (z) {
            ji1Var = ji1.a;
            str = "precision mediump float;\nuniform sampler2D uTextureAlphaMask;\nvarying vec2 v_TexCoordinateAlphaMask;\nmat3 weight = mat3(0.0625,0.125,0.0625,0.125,0.25,0.125,0.0625,0.125,0.0625);\n int coreSize=3;\nfloat texelOffset = .01;\n\nvoid main() {\n   float alphaResult = 0.;\n   for(int y = 0; y < coreSize; y++) {\n       for(int x = 0;x < coreSize; x++) {\n           alphaResult += texture2D(uTextureAlphaMask, vec2(v_TexCoordinateAlphaMask.x + (-1.0 + float(x)) * texelOffset,v_TexCoordinateAlphaMask.y + (-1.0 + float(y)) * texelOffset)).a * weight[x][y];\n       }\n    }\n    gl_FragColor = vec4(0, 0, 0, alphaResult);\n}";
        } else {
            ji1Var = ji1.a;
            str = "precision mediump float;\nuniform sampler2D uTextureAlphaMask;\nvarying vec2 v_TexCoordinateAlphaMask;\n\nvoid main () {\n    vec4 alphaMaskColor = texture2D(uTextureAlphaMask, v_TexCoordinateAlphaMask);\n    gl_FragColor = vec4(0, 0, 0, alphaMaskColor.a);\n}";
        }
        int iC = ji1Var.c("attribute vec4 vPosition;\nattribute vec4 vTexCoordinateAlphaMask;\nvarying vec2 v_TexCoordinateAlphaMask;\n\nvoid main() {\n    v_TexCoordinateAlphaMask = vec2(vTexCoordinateAlphaMask.x, vTexCoordinateAlphaMask.y);\n    gl_Position = vPosition;\n}", str);
        this.a = iC;
        this.b = GLES20.glGetUniformLocation(iC, "uTextureAlphaMask");
        this.c = GLES20.glGetAttribLocation(iC, "vPosition");
        this.d = GLES20.glGetAttribLocation(iC, "vTexCoordinateAlphaMask");
    }
}
