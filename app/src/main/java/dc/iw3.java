package dc;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.math.BigDecimal;
import java.math.BigInteger;

/* compiled from: Backoff.java */
/* loaded from: classes4.dex */
public class iw3 {
    public long a = 100;
    public long b = 10000;
    public int c = 2;
    public double d;
    public int e;

    public long a() {
        BigInteger bigIntegerValueOf = BigInteger.valueOf(this.a);
        BigInteger bigIntegerValueOf2 = BigInteger.valueOf(this.c);
        int i = this.e;
        this.e = i + 1;
        BigInteger bigIntegerMultiply = bigIntegerValueOf.multiply(bigIntegerValueOf2.pow(i));
        if (this.d != FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            double dRandom = Math.random();
            BigInteger bigInteger = BigDecimal.valueOf(dRandom).multiply(BigDecimal.valueOf(this.d)).multiply(new BigDecimal(bigIntegerMultiply)).toBigInteger();
            bigIntegerMultiply = (((int) Math.floor(dRandom * 10.0d)) & 1) == 0 ? bigIntegerMultiply.subtract(bigInteger) : bigIntegerMultiply.add(bigInteger);
        }
        return bigIntegerMultiply.min(BigInteger.valueOf(this.b)).longValue();
    }

    public int b() {
        return this.e;
    }

    public void c() {
        this.e = 0;
    }

    public iw3 d(double d) {
        this.d = d;
        return this;
    }

    public iw3 e(long j) {
        this.b = j;
        return this;
    }

    public iw3 f(long j) {
        this.a = j;
        return this;
    }
}
