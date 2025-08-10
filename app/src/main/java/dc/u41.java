package dc;

import com.alibaba.fastjson.asm.Opcodes;
import com.google.android.exoplayer2.extractor.ts.PsExtractor;
import com.google.android.exoplayer2.extractor.ts.TsExtractor;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.google.android.vending.expansion.downloader.impl.DownloaderService;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.logging.Logger;
import org.bouncycastle.asn1.eac.EACTags;
import org.bouncycastle.crypto.tls.CipherSuite;
import org.slf4j.helpers.MessageFormatter;

/* compiled from: ExtensionDescriptor.java */
@s41(tags = {19, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 123, 124, EACTags.SECURE_MESSAGING_TEMPLATE, 126, 127, 128, TsExtractor.TS_STREAM_TYPE_AC3, 130, 131, 132, CipherSuite.TLS_DH_DSS_WITH_CAMELLIA_256_CBC_SHA, 134, 135, CipherSuite.TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA, CipherSuite.TLS_DH_anon_WITH_CAMELLIA_256_CBC_SHA, 138, CipherSuite.TLS_PSK_WITH_3DES_EDE_CBC_SHA, CipherSuite.TLS_PSK_WITH_AES_128_CBC_SHA, 141, 142, CipherSuite.TLS_DHE_PSK_WITH_3DES_EDE_CBC_SHA, CipherSuite.TLS_DHE_PSK_WITH_AES_128_CBC_SHA, CipherSuite.TLS_DHE_PSK_WITH_AES_256_CBC_SHA, CipherSuite.TLS_RSA_PSK_WITH_RC4_128_SHA, CipherSuite.TLS_RSA_PSK_WITH_3DES_EDE_CBC_SHA, 148, 149, CipherSuite.TLS_RSA_WITH_SEED_CBC_SHA, 151, CipherSuite.TLS_DH_RSA_WITH_SEED_CBC_SHA, 153, 154, CipherSuite.TLS_DH_anon_WITH_SEED_CBC_SHA, CipherSuite.TLS_RSA_WITH_AES_128_GCM_SHA256, 157, 158, 159, 160, 161, 162, 163, CipherSuite.TLS_DH_DSS_WITH_AES_128_GCM_SHA256, 165, 166, 167, CipherSuite.TLS_PSK_WITH_AES_128_GCM_SHA256, 169, 170, CipherSuite.TLS_DHE_PSK_WITH_AES_256_GCM_SHA384, 172, CipherSuite.TLS_RSA_PSK_WITH_AES_256_GCM_SHA384, CipherSuite.TLS_PSK_WITH_AES_128_CBC_SHA256, 175, 176, 177, 178, CipherSuite.TLS_DHE_PSK_WITH_AES_256_CBC_SHA384, 180, 181, 182, 183, 184, 185, 186, Opcodes.NEW, 188, PsExtractor.PRIVATE_STREAM_1, DownloaderService.STATUS_PENDING, 191, 192, 193, DownloaderService.STATUS_WAITING_TO_RETRY, DownloaderService.STATUS_WAITING_FOR_NETWORK, DownloaderService.STATUS_QUEUED_FOR_WIFI_OR_CELLULAR_PERMISSION, DownloaderService.STATUS_QUEUED_FOR_WIFI, Opcodes.IFNULL, Opcodes.IFNONNULL, 200, 201, 202, 203, 204, 205, 206, 207, 208, 209, 210, 211, 212, 213, 214, 215, 216, 217, 218, 219, 220, 221, 222, 223, 224, HideBottomViewOnScrollBehavior.ENTER_ANIMATION_DURATION, 226, 227, 228, 229, 230, 231, 232, 233, 234, 235, 236, 237, 238, 239, PsExtractor.VIDEO_STREAM_MASK, 241, 242, 243, 244, 245, 246, 247, 248, 249, 250, 251, 252, 253})
/* loaded from: classes2.dex */
public class u41 extends n41 {
    public byte[] d;

    static {
        Logger.getLogger(u41.class.getName());
    }

    @Override // dc.n41
    public void e(ByteBuffer byteBuffer) throws IOException {
        if (a() > 0) {
            byte[] bArr = new byte[this.b];
            this.d = bArr;
            byteBuffer.get(bArr);
        }
    }

    @Override // dc.n41
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ExtensionDescriptor");
        sb.append("{bytes=");
        byte[] bArr = this.d;
        sb.append(bArr == null ? "null" : bf0.a(bArr));
        sb.append(MessageFormatter.DELIM_STOP);
        return sb.toString();
    }
}
