package dc;

import java.io.ByteArrayOutputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: MacBasedPRF.java */
/* loaded from: classes5.dex */
public class g84 implements j84 {
    public Mac a;
    public int b;
    public String c;
    public ByteArrayOutputStream d = new ByteArrayOutputStream(4096);

    public g84(String str) throws NoSuchAlgorithmException {
        this.c = str;
        try {
            Mac mac = Mac.getInstance(str);
            this.a = mac;
            this.b = mac.getMacLength();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // dc.j84
    public int a() {
        return this.b;
    }

    @Override // dc.j84
    public byte[] b(byte[] bArr) throws IllegalStateException {
        if (this.d.size() > 0) {
            d(0);
        }
        return this.a.doFinal(bArr);
    }

    public byte[] c(int i) throws IllegalStateException {
        if (this.d.size() > 0) {
            d(i);
        }
        return this.a.doFinal();
    }

    public final void d(int i) throws IllegalStateException {
        byte[] byteArray = this.d.toByteArray();
        int length = byteArray.length - i;
        int i2 = 0;
        while (i2 < length) {
            int i3 = i2 + 16;
            this.a.update(byteArray, i2, i3 <= length ? 16 : length - i2);
            i2 = i3;
        }
        this.d.reset();
    }

    public void e(byte[] bArr, int i, int i2) {
        try {
            if (this.d.size() + i2 > 4096) {
                d(0);
            }
            this.d.write(bArr, i, i2);
        } catch (IllegalStateException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // dc.j84
    public void init(byte[] bArr) throws InvalidKeyException {
        try {
            this.a.init(new SecretKeySpec(bArr, this.c));
        } catch (InvalidKeyException e) {
            throw new RuntimeException(e);
        }
    }
}
