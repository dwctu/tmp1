package dc;

import android.opengl.GLES20;
import com.alibaba.fastjson.asm.Opcodes;
import com.google.android.exoplayer2.extractor.ts.PsExtractor;
import com.google.android.exoplayer2.extractor.ts.TsExtractor;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.google.android.vending.expansion.downloader.impl.DownloaderService;
import com.lovense.wear.R;
import java.nio.ByteBuffer;
import org.bouncycastle.asn1.eac.EACTags;
import org.bouncycastle.crypto.tls.CipherSuite;

/* compiled from: MagicAntiqueFilter.java */
/* loaded from: classes4.dex */
public class wh3 extends uh3 {
    public int[] k;
    public int l;

    /* compiled from: MagicAntiqueFilter.java */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            GLES20.glGenTextures(1, wh3.this.k, 0);
            GLES20.glBindTexture(3553, wh3.this.k[0]);
            GLES20.glTexParameterf(3553, 10240, 9729.0f);
            GLES20.glTexParameterf(3553, 10241, 9729.0f);
            GLES20.glTexParameterf(3553, 10242, 33071.0f);
            GLES20.glTexParameterf(3553, 10243, 33071.0f);
            byte[] bArr = new byte[2048];
            int[] iArr = {0, 1, 1, 2, 3, 3, 4, 5, 6, 6, 7, 8, 8, 9, 10, 11, 11, 12, 13, 14, 15, 15, 16, 17, 18, 19, 20, 21, 22, 23, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 48, 49, 50, 51, 52, 53, 55, 56, 57, 58, 59, 61, 62, 63, 64, 66, 67, 68, 69, 71, 72, 73, 74, 76, 77, 78, 79, 81, 82, 83, 85, 86, 87, 89, 90, 91, 93, 94, 95, 96, 98, 99, 100, 102, 103, 104, 106, 107, 108, 110, 111, 112, 114, 115, 116, 118, 119, 120, 122, 123, 124, 126, 127, 128, 130, 131, 132, 134, 135, CipherSuite.TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA, CipherSuite.TLS_DH_anon_WITH_CAMELLIA_256_CBC_SHA, CipherSuite.TLS_PSK_WITH_3DES_EDE_CBC_SHA, CipherSuite.TLS_PSK_WITH_AES_128_CBC_SHA, 141, CipherSuite.TLS_DHE_PSK_WITH_3DES_EDE_CBC_SHA, CipherSuite.TLS_DHE_PSK_WITH_AES_128_CBC_SHA, CipherSuite.TLS_DHE_PSK_WITH_AES_256_CBC_SHA, CipherSuite.TLS_RSA_PSK_WITH_RC4_128_SHA, 148, 149, CipherSuite.TLS_RSA_WITH_SEED_CBC_SHA, CipherSuite.TLS_DH_RSA_WITH_SEED_CBC_SHA, 153, 154, CipherSuite.TLS_DH_anon_WITH_SEED_CBC_SHA, 157, 158, 159, 160, 161, 163, CipherSuite.TLS_DH_DSS_WITH_AES_128_GCM_SHA256, 165, 166, CipherSuite.TLS_PSK_WITH_AES_128_GCM_SHA256, 169, 170, CipherSuite.TLS_DHE_PSK_WITH_AES_256_GCM_SHA384, 172, CipherSuite.TLS_RSA_PSK_WITH_AES_256_GCM_SHA384, 175, 176, 177, 178, CipherSuite.TLS_DHE_PSK_WITH_AES_256_CBC_SHA384, 180, 181, 183, 184, 185, 186, Opcodes.NEW, 188, PsExtractor.PRIVATE_STREAM_1, DownloaderService.STATUS_PENDING, 191, 192, 193, DownloaderService.STATUS_WAITING_TO_RETRY, DownloaderService.STATUS_WAITING_FOR_NETWORK, DownloaderService.STATUS_QUEUED_FOR_WIFI_OR_CELLULAR_PERMISSION, DownloaderService.STATUS_QUEUED_FOR_WIFI, Opcodes.IFNULL, Opcodes.IFNONNULL, 200, 201, 202, 203, 204, 205, 206, 207, 208, 209, 210, 211, 211, 212, 213, 214, 215, 216, 216, 217, 218, 219, 220, 220, 221, 222, 223, 223, 224, HideBottomViewOnScrollBehavior.ENTER_ANIMATION_DURATION, 226, 226, 227, 228, 228, 229, 230, 230, 231, 232, 232, 233, 234, 234, 235, 236, 236, 237, 238, 238, 239, 239, PsExtractor.VIDEO_STREAM_MASK, 241, 241, 242, 242, 243, 244, 244, 245, 245, 246, 247, 247, 248, 248, 249, 249, 250, 251, 251, 252, 252, 253, 253, 254, 254, 255};
            int[] iArr2 = {15, 15, 16, 17, 18, 19, 20, 20, 21, 22, 23, 23, 24, 25, 26, 27, 28, 29, 30, 31, 31, 32, 33, 34, 35, 37, 38, 39, 40, 41, 42, 43, 43, 44, 45, 46, 48, 49, 50, 51, 52, 53, 55, 56, 57, 57, 58, 59, 61, 62, 63, 64, 66, 67, 68, 69, 71, 72, 72, 73, 74, 76, 77, 78, 79, 81, 82, 83, 85, 86, 87, 87, 89, 90, 91, 93, 94, 95, 96, 98, 99, 100, 102, 102, 103, 104, 106, 107, 108, 110, 111, 112, 114, 115, 116, 118, 118, 119, 120, 122, 123, 124, 126, 127, 128, 130, 131, 132, 134, 134, 135, CipherSuite.TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA, CipherSuite.TLS_DH_anon_WITH_CAMELLIA_256_CBC_SHA, CipherSuite.TLS_PSK_WITH_3DES_EDE_CBC_SHA, CipherSuite.TLS_PSK_WITH_AES_128_CBC_SHA, 141, CipherSuite.TLS_DHE_PSK_WITH_3DES_EDE_CBC_SHA, CipherSuite.TLS_DHE_PSK_WITH_AES_128_CBC_SHA, CipherSuite.TLS_DHE_PSK_WITH_AES_256_CBC_SHA, CipherSuite.TLS_RSA_PSK_WITH_RC4_128_SHA, 148, 149, 149, CipherSuite.TLS_RSA_WITH_SEED_CBC_SHA, CipherSuite.TLS_DH_RSA_WITH_SEED_CBC_SHA, 153, 154, CipherSuite.TLS_DH_anon_WITH_SEED_CBC_SHA, 157, 158, 159, 160, 161, 163, 163, CipherSuite.TLS_DH_DSS_WITH_AES_128_GCM_SHA256, 165, 166, CipherSuite.TLS_PSK_WITH_AES_128_GCM_SHA256, 169, 170, CipherSuite.TLS_DHE_PSK_WITH_AES_256_GCM_SHA384, 172, CipherSuite.TLS_RSA_PSK_WITH_AES_256_GCM_SHA384, 175, 176, 177, 177, 178, CipherSuite.TLS_DHE_PSK_WITH_AES_256_CBC_SHA384, 180, 181, 183, 184, 185, 186, Opcodes.NEW, 188, PsExtractor.PRIVATE_STREAM_1, DownloaderService.STATUS_PENDING, DownloaderService.STATUS_PENDING, 191, 192, 193, DownloaderService.STATUS_WAITING_TO_RETRY, DownloaderService.STATUS_WAITING_FOR_NETWORK, DownloaderService.STATUS_QUEUED_FOR_WIFI_OR_CELLULAR_PERMISSION, DownloaderService.STATUS_QUEUED_FOR_WIFI, Opcodes.IFNULL, Opcodes.IFNONNULL, 200, 201, 202, 202, 203, 204, 205, 206, 207, 208, 209, 210, 211, 211, 212, 212, 213, 214, 215, 216, 216, 217, 218, 219, 220, 220, 221, 222, 222, 223, 223, 224, HideBottomViewOnScrollBehavior.ENTER_ANIMATION_DURATION, 226, 226, 227, 228, 228, 229, 230, 230, 230, 231, 232, 232, 233, 234, 234, 235, 236, 236, 237, 238, 238, 238, 239, 239, PsExtractor.VIDEO_STREAM_MASK, 241, 241, 242, 242, 243, 244, 244, 245, 245, 245, 246, 247, 247, 248, 248, 249, 249, 250, 251, 251, 252, 252, 252, 253, 253, 254, 254, 255};
            int[] iArr3 = {87, 89, 89, 90, 90, 91, 91, 93, 93, 94, 95, 95, 96, 96, 98, 98, 99, 100, 100, 102, 102, 103, 103, 104, 104, 106, 107, 107, 108, 108, 110, 110, 111, 112, 112, 114, 114, 115, 115, 116, 118, 118, 119, 119, 120, 120, 122, 123, 123, 124, 124, 126, 126, 127, 128, 128, 130, 130, 131, 131, 132, 134, 134, 135, 135, CipherSuite.TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA, CipherSuite.TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA, CipherSuite.TLS_DH_anon_WITH_CAMELLIA_256_CBC_SHA, CipherSuite.TLS_PSK_WITH_3DES_EDE_CBC_SHA, CipherSuite.TLS_PSK_WITH_3DES_EDE_CBC_SHA, CipherSuite.TLS_PSK_WITH_AES_128_CBC_SHA, CipherSuite.TLS_PSK_WITH_AES_128_CBC_SHA, 141, CipherSuite.TLS_DHE_PSK_WITH_3DES_EDE_CBC_SHA, CipherSuite.TLS_DHE_PSK_WITH_3DES_EDE_CBC_SHA, CipherSuite.TLS_DHE_PSK_WITH_AES_128_CBC_SHA, CipherSuite.TLS_DHE_PSK_WITH_AES_128_CBC_SHA, CipherSuite.TLS_DHE_PSK_WITH_AES_256_CBC_SHA, CipherSuite.TLS_RSA_PSK_WITH_RC4_128_SHA, CipherSuite.TLS_RSA_PSK_WITH_RC4_128_SHA, 148, 148, 149, CipherSuite.TLS_RSA_WITH_SEED_CBC_SHA, CipherSuite.TLS_RSA_WITH_SEED_CBC_SHA, CipherSuite.TLS_DH_RSA_WITH_SEED_CBC_SHA, CipherSuite.TLS_DH_RSA_WITH_SEED_CBC_SHA, 153, 154, 154, CipherSuite.TLS_DH_anon_WITH_SEED_CBC_SHA, CipherSuite.TLS_DH_anon_WITH_SEED_CBC_SHA, 157, 158, 158, 159, 159, 160, 161, 161, 163, 163, CipherSuite.TLS_DH_DSS_WITH_AES_128_GCM_SHA256, 165, 165, 166, CipherSuite.TLS_PSK_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_PSK_WITH_AES_128_GCM_SHA256, 169, 169, 170, CipherSuite.TLS_DHE_PSK_WITH_AES_256_GCM_SHA384, CipherSuite.TLS_DHE_PSK_WITH_AES_256_GCM_SHA384, 172, CipherSuite.TLS_RSA_PSK_WITH_AES_256_GCM_SHA384, CipherSuite.TLS_RSA_PSK_WITH_AES_256_GCM_SHA384, 175, 175, 176, 177, 177, 178, CipherSuite.TLS_DHE_PSK_WITH_AES_256_CBC_SHA384, CipherSuite.TLS_DHE_PSK_WITH_AES_256_CBC_SHA384, 180, 181, 181, 183, 183, 184, 185, 185, 186, Opcodes.NEW, Opcodes.NEW, 188, PsExtractor.PRIVATE_STREAM_1, PsExtractor.PRIVATE_STREAM_1, DownloaderService.STATUS_PENDING, 191, 191, 192, 193, 193, DownloaderService.STATUS_WAITING_TO_RETRY, DownloaderService.STATUS_WAITING_FOR_NETWORK, DownloaderService.STATUS_WAITING_FOR_NETWORK, DownloaderService.STATUS_QUEUED_FOR_WIFI_OR_CELLULAR_PERMISSION, DownloaderService.STATUS_QUEUED_FOR_WIFI, DownloaderService.STATUS_QUEUED_FOR_WIFI, Opcodes.IFNULL, Opcodes.IFNONNULL, Opcodes.IFNONNULL, 200, 201, 201, 202, 203, 204, 204, 205, 206, 206, 207, 208, 208, 209, 210, 211, 211, 211, 212, 212, 213, 214, 215, 215, 216, 216, 217, 217, 218, 219, 219, 220, 220, 221, 221, 222, 223, 223, 223, 224, HideBottomViewOnScrollBehavior.ENTER_ANIMATION_DURATION, 226, 226, 226, 227, 228, 228, 228, 229, 230, 230, 230, 231, 232, 232, 232, 233, 234, 234, 235, 235, 236, 236, 237, 238, 238, 238, 239, 239, PsExtractor.VIDEO_STREAM_MASK, PsExtractor.VIDEO_STREAM_MASK, 241, 241, 242, 242, 242, 243, 244, 244, 244, 245, 245, 246, 247, 247, 247, 248, 248, 249, 249, 249, 250, 251, 251, 252, 252, 252, 253, 253, 254, 254, 254, 255};
            int[] iArr4 = {0, 1, 1, 2, 3, 4, 4, 5, 6, 7, 7, 8, 9, 10, 10, 11, 12, 13, 13, 14, 15, 16, 17, 17, 18, 19, 20, 20, 21, 22, 23, 24, 24, 25, 26, 27, 28, 29, 29, 30, 31, 32, 33, 34, 35, 36, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 64, 65, 66, 67, 68, 69, 70, 72, 73, 74, 75, 76, 78, 79, 80, 81, 83, 84, 85, 86, 88, 89, 90, 91, 93, 94, 95, 97, 98, 99, 101, 102, 103, 105, 106, 107, 109, 110, 111, 113, 114, 115, 117, 118, 119, 121, 122, 123, EACTags.SECURE_MESSAGING_TEMPLATE, 126, 127, TsExtractor.TS_STREAM_TYPE_AC3, 130, 131, CipherSuite.TLS_DH_DSS_WITH_CAMELLIA_256_CBC_SHA, 134, CipherSuite.TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA, CipherSuite.TLS_DH_anon_WITH_CAMELLIA_256_CBC_SHA, 138, CipherSuite.TLS_PSK_WITH_AES_128_CBC_SHA, 141, 142, CipherSuite.TLS_DHE_PSK_WITH_AES_128_CBC_SHA, CipherSuite.TLS_DHE_PSK_WITH_AES_256_CBC_SHA, CipherSuite.TLS_RSA_PSK_WITH_RC4_128_SHA, 148, 149, CipherSuite.TLS_RSA_WITH_SEED_CBC_SHA, CipherSuite.TLS_DH_RSA_WITH_SEED_CBC_SHA, 153, 154, CipherSuite.TLS_RSA_WITH_AES_128_GCM_SHA256, 157, 158, 159, 161, 162, 163, 165, 166, 167, CipherSuite.TLS_PSK_WITH_AES_128_GCM_SHA256, 170, CipherSuite.TLS_DHE_PSK_WITH_AES_256_GCM_SHA384, 172, CipherSuite.TLS_RSA_PSK_WITH_AES_256_GCM_SHA384, 175, 176, 177, 178, 180, 181, 182, 183, 184, 186, Opcodes.NEW, 188, PsExtractor.PRIVATE_STREAM_1, DownloaderService.STATUS_PENDING, 191, 192, 193, DownloaderService.STATUS_WAITING_FOR_NETWORK, DownloaderService.STATUS_QUEUED_FOR_WIFI_OR_CELLULAR_PERMISSION, DownloaderService.STATUS_QUEUED_FOR_WIFI, Opcodes.IFNULL, Opcodes.IFNONNULL, 200, 201, 202, 203, 204, 205, 206, 207, 208, 209, 210, 211, 212, 213, 213, 214, 215, 216, 217, 218, 219, 219, 220, 221, 222, 223, 223, 224, HideBottomViewOnScrollBehavior.ENTER_ANIMATION_DURATION, 226, 227, 227, 228, 229, 230, 230, 231, 232, 232, 233, 234, 234, 235, 236, 236, 237, 238, 238, 239, PsExtractor.VIDEO_STREAM_MASK, PsExtractor.VIDEO_STREAM_MASK, 241, 242, 242, 243, 244, 244, 245, 245, 246, 247, 247, 248, 248, 249, 250, 250, 251, 251, 252, 253, 253, 254, 254, 255};
            for (int i = 0; i < 256; i++) {
                int i2 = i * 4;
                bArr[i2] = (byte) iArr[i];
                bArr[i2 + 1] = (byte) iArr2[i];
                bArr[i2 + 2] = (byte) iArr3[i];
                bArr[i2 + 3] = (byte) iArr4[i];
            }
            int[] iArr5 = {0, 0, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 5, 5, 5, 6, 6, 6, 7, 7, 8, 8, 8, 9, 9, 10, 10, 10, 11, 11, 11, 12, 12, 13, 13, 13, 14, 14, 14, 15, 15, 16, 16, 16, 17, 17, 17, 18, 18, 18, 19, 19, 20, 20, 20, 21, 21, 21, 22, 22, 23, 23, 23, 24, 24, 24, 25, 25, 25, 25, 26, 26, 27, 27, 28, 28, 28, 28, 29, 29, 30, 29, 31, 31, 31, 31, 32, 32, 33, 33, 34, 34, 34, 34, 35, 35, 36, 36, 37, 37, 37, 38, 38, 39, 39, 39, 40, 40, 40, 41, 42, 42, 43, 43, 44, 44, 45, 45, 45, 46, 47, 47, 48, 48, 49, 50, 51, 51, 52, 52, 53, 53, 54, 55, 55, 56, 57, 57, 58, 59, 60, 60, 61, 62, 63, 63, 64, 65, 66, 67, 68, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 88, 89, 90, 91, 93, 94, 95, 96, 97, 98, 100, 101, 103, 104, 105, 107, 108, 110, 111, 113, 115, 116, 118, 119, 120, 122, 123, EACTags.SECURE_MESSAGING_TEMPLATE, 127, 128, 130, 132, 134, 135, CipherSuite.TLS_DH_anon_WITH_CAMELLIA_256_CBC_SHA, CipherSuite.TLS_PSK_WITH_3DES_EDE_CBC_SHA, 141, CipherSuite.TLS_DHE_PSK_WITH_3DES_EDE_CBC_SHA, CipherSuite.TLS_DHE_PSK_WITH_AES_128_CBC_SHA, CipherSuite.TLS_RSA_PSK_WITH_RC4_128_SHA, 148, CipherSuite.TLS_RSA_WITH_SEED_CBC_SHA, CipherSuite.TLS_DH_RSA_WITH_SEED_CBC_SHA, 154, CipherSuite.TLS_RSA_WITH_AES_128_GCM_SHA256, 158, 160, 163, 165, 167, 169, CipherSuite.TLS_DHE_PSK_WITH_AES_256_GCM_SHA384, CipherSuite.TLS_RSA_PSK_WITH_AES_256_GCM_SHA384, 175, 178, 180, 182, 185, Opcodes.NEW, PsExtractor.PRIVATE_STREAM_1, 192, DownloaderService.STATUS_WAITING_TO_RETRY, DownloaderService.STATUS_QUEUED_FOR_WIFI, Opcodes.IFNONNULL, 201, 204, 206, 209, 211, 214, 216, 219, 221, 224, 226, 229, 232, 234, 236, 239, 241, 245, 247, 250, 252, 255};
            for (int i3 = 0; i3 < 256; i3++) {
                int i4 = (i3 * 4) + 1024;
                bArr[i4] = (byte) iArr5[i3];
                bArr[i4 + 1] = (byte) iArr5[i3];
                bArr[i4 + 2] = (byte) iArr5[i3];
                bArr[i4 + 3] = -1;
            }
            GLES20.glTexImage2D(3553, 0, 6408, 256, 2, 0, 6408, 5121, ByteBuffer.wrap(bArr));
        }
    }

    public wh3() {
        super("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", ii3.e(R.raw.antique));
        this.k = new int[]{-1};
    }

    @Override // dc.uh3
    public void e() {
        super.e();
        GLES20.glDeleteTextures(1, this.k, 0);
        this.k[0] = -1;
    }

    @Override // dc.uh3
    public void g() {
        if (this.k[0] != -1) {
            GLES20.glActiveTexture(33987);
            GLES20.glBindTexture(3553, 0);
            GLES20.glActiveTexture(33984);
        }
    }

    @Override // dc.uh3
    public void h() {
        if (this.k[0] != -1) {
            GLES20.glActiveTexture(33987);
            GLES20.glBindTexture(3553, this.k[0]);
            GLES20.glUniform1i(this.l, 3);
        }
    }

    @Override // dc.uh3
    public void j() {
        super.j();
        this.l = GLES20.glGetUniformLocation(this.d, "curve");
    }

    @Override // dc.uh3
    public void k() {
        super.k();
        m(new a());
    }
}
