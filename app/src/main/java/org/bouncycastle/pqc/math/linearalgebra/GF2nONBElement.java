package org.bouncycastle.pqc.math.linearalgebra;

import android.support.v4.media.session.PlaybackStateCompat;
import com.broadcom.bt.util.io.FileUtils;
import com.google.common.math.DoubleUtils;
import com.google.common.primitives.UnsignedInts;
import java.math.BigInteger;
import java.util.Random;
import kotlin.time.DurationKt;
import okhttp3.internal.ws.WebSocketProtocol;

/* loaded from: classes5.dex */
public class GF2nONBElement extends GF2nElement {
    private static final int MAXLONG = 64;
    private int mBit;
    private int mLength;
    private long[] mPol;
    private static final long[] mBitmask = {1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH, PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM, PlaybackStateCompat.ACTION_PLAY_FROM_URI, PlaybackStateCompat.ACTION_PREPARE, PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID, PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH, PlaybackStateCompat.ACTION_PREPARE_FROM_URI, PlaybackStateCompat.ACTION_SET_REPEAT_MODE, PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED, 1048576, PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE, PlaybackStateCompat.ACTION_SET_PLAYBACK_SPEED, 8388608, 16777216, 33554432, 67108864, 134217728, 268435456, 536870912, FileUtils.ONE_GB, 2147483648L, 4294967296L, 8589934592L, 17179869184L, 34359738368L, 68719476736L, 137438953472L, 274877906944L, 549755813888L, 1099511627776L, 2199023255552L, 4398046511104L, 8796093022208L, 17592186044416L, 35184372088832L, 70368744177664L, 140737488355328L, 281474976710656L, 562949953421312L, 1125899906842624L, 2251799813685248L, DoubleUtils.IMPLICIT_BIT, 9007199254740992L, 18014398509481984L, 36028797018963968L, 72057594037927936L, 144115188075855872L, 288230376151711744L, 576460752303423488L, 1152921504606846976L, 2305843009213693952L, 4611686018427387904L, Long.MIN_VALUE};
    private static final long[] mMaxmask = {1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191, 16383, 32767, WebSocketProtocol.PAYLOAD_SHORT_MAX, 131071, 262143, 524287, 1048575, 2097151, 4194303, 8388607, 16777215, 33554431, 67108863, 134217727, 268435455, 536870911, 1073741823, 2147483647L, UnsignedInts.INT_MASK, 8589934591L, 17179869183L, 34359738367L, 68719476735L, 137438953471L, 274877906943L, 549755813887L, 1099511627775L, 2199023255551L, 4398046511103L, 8796093022207L, 17592186044415L, 35184372088831L, 70368744177663L, 140737488355327L, 281474976710655L, 562949953421311L, 1125899906842623L, 2251799813685247L, DoubleUtils.SIGNIFICAND_MASK, 9007199254740991L, 18014398509481983L, 36028797018963967L, 72057594037927935L, 144115188075855871L, 288230376151711743L, 576460752303423487L, 1152921504606846975L, 2305843009213693951L, DurationKt.MAX_MILLIS, Long.MAX_VALUE, -1};
    private static final int[] mIBY64 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5};

    public GF2nONBElement(GF2nONBElement gF2nONBElement) {
        GF2nField gF2nField = gF2nONBElement.mField;
        this.mField = gF2nField;
        this.mDegree = gF2nField.getDegree();
        this.mLength = ((GF2nONBField) this.mField).getONBLength();
        this.mBit = ((GF2nONBField) this.mField).getONBBit();
        this.mPol = new long[this.mLength];
        assign(gF2nONBElement.getElement());
    }

    public GF2nONBElement(GF2nONBField gF2nONBField, BigInteger bigInteger) {
        this.mField = gF2nONBField;
        this.mDegree = gF2nONBField.getDegree();
        this.mLength = gF2nONBField.getONBLength();
        this.mBit = gF2nONBField.getONBBit();
        this.mPol = new long[this.mLength];
        assign(bigInteger);
    }

    public GF2nONBElement(GF2nONBField gF2nONBField, Random random) {
        this.mField = gF2nONBField;
        this.mDegree = gF2nONBField.getDegree();
        this.mLength = gF2nONBField.getONBLength();
        this.mBit = gF2nONBField.getONBBit();
        int i = this.mLength;
        long[] jArr = new long[i];
        this.mPol = jArr;
        if (i <= 1) {
            jArr[0] = random.nextLong();
            long[] jArr2 = this.mPol;
            jArr2[0] = jArr2[0] >>> (64 - this.mBit);
        } else {
            for (int i2 = 0; i2 < this.mLength - 1; i2++) {
                this.mPol[i2] = random.nextLong();
            }
            this.mPol[this.mLength - 1] = random.nextLong() >>> (64 - this.mBit);
        }
    }

    public GF2nONBElement(GF2nONBField gF2nONBField, byte[] bArr) {
        this.mField = gF2nONBField;
        this.mDegree = gF2nONBField.getDegree();
        this.mLength = gF2nONBField.getONBLength();
        this.mBit = gF2nONBField.getONBBit();
        this.mPol = new long[this.mLength];
        assign(bArr);
    }

    private GF2nONBElement(GF2nONBField gF2nONBField, long[] jArr) {
        this.mField = gF2nONBField;
        this.mDegree = gF2nONBField.getDegree();
        this.mLength = gF2nONBField.getONBLength();
        this.mBit = gF2nONBField.getONBBit();
        this.mPol = jArr;
    }

    public static GF2nONBElement ONE(GF2nONBField gF2nONBField) {
        int oNBLength = gF2nONBField.getONBLength();
        long[] jArr = new long[oNBLength];
        int i = 0;
        while (true) {
            int i2 = oNBLength - 1;
            if (i >= i2) {
                jArr[i2] = mMaxmask[gF2nONBField.getONBBit() - 1];
                return new GF2nONBElement(gF2nONBField, jArr);
            }
            jArr[i] = -1;
            i++;
        }
    }

    public static GF2nONBElement ZERO(GF2nONBField gF2nONBField) {
        return new GF2nONBElement(gF2nONBField, new long[gF2nONBField.getONBLength()]);
    }

    private void assign(BigInteger bigInteger) {
        assign(bigInteger.toByteArray());
    }

    private void assign(byte[] bArr) {
        this.mPol = new long[this.mLength];
        for (int i = 0; i < bArr.length; i++) {
            long[] jArr = this.mPol;
            int i2 = i >>> 3;
            jArr[i2] = jArr[i2] | ((bArr[(bArr.length - 1) - i] & 255) << ((i & 7) << 3));
        }
    }

    private void assign(long[] jArr) {
        System.arraycopy(jArr, 0, this.mPol, 0, this.mLength);
    }

    private long[] getElement() {
        long[] jArr = this.mPol;
        long[] jArr2 = new long[jArr.length];
        System.arraycopy(jArr, 0, jArr2, 0, jArr.length);
        return jArr2;
    }

    private long[] getElementReverseOrder() {
        long[] jArr = new long[this.mPol.length];
        int i = 0;
        while (true) {
            if (i >= this.mDegree) {
                return jArr;
            }
            if (testBit((r2 - i) - 1)) {
                int i2 = i >>> 6;
                jArr[i2] = jArr[i2] | mBitmask[i & 63];
            }
            i++;
        }
    }

    @Override // org.bouncycastle.pqc.math.linearalgebra.GFElement
    public GFElement add(GFElement gFElement) throws RuntimeException {
        GF2nONBElement gF2nONBElement = new GF2nONBElement(this);
        gF2nONBElement.addToThis(gFElement);
        return gF2nONBElement;
    }

    @Override // org.bouncycastle.pqc.math.linearalgebra.GFElement
    public void addToThis(GFElement gFElement) throws RuntimeException {
        if (!(gFElement instanceof GF2nONBElement)) {
            throw new RuntimeException();
        }
        GF2nONBElement gF2nONBElement = (GF2nONBElement) gFElement;
        if (!this.mField.equals(gF2nONBElement.mField)) {
            throw new RuntimeException();
        }
        for (int i = 0; i < this.mLength; i++) {
            long[] jArr = this.mPol;
            jArr[i] = jArr[i] ^ gF2nONBElement.mPol[i];
        }
    }

    @Override // org.bouncycastle.pqc.math.linearalgebra.GF2nElement
    public void assignOne() {
        int i = 0;
        while (true) {
            int i2 = this.mLength;
            if (i >= i2 - 1) {
                this.mPol[i2 - 1] = mMaxmask[this.mBit - 1];
                return;
            } else {
                this.mPol[i] = -1;
                i++;
            }
        }
    }

    @Override // org.bouncycastle.pqc.math.linearalgebra.GF2nElement
    public void assignZero() {
        this.mPol = new long[this.mLength];
    }

    @Override // org.bouncycastle.pqc.math.linearalgebra.GF2nElement, org.bouncycastle.pqc.math.linearalgebra.GFElement
    public Object clone() {
        return new GF2nONBElement(this);
    }

    @Override // org.bouncycastle.pqc.math.linearalgebra.GFElement
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof GF2nONBElement)) {
            return false;
        }
        GF2nONBElement gF2nONBElement = (GF2nONBElement) obj;
        for (int i = 0; i < this.mLength; i++) {
            if (this.mPol[i] != gF2nONBElement.mPol[i]) {
                return false;
            }
        }
        return true;
    }

    @Override // org.bouncycastle.pqc.math.linearalgebra.GFElement
    public int hashCode() {
        return this.mPol.hashCode();
    }

    @Override // org.bouncycastle.pqc.math.linearalgebra.GF2nElement
    public GF2nElement increase() throws RuntimeException {
        GF2nONBElement gF2nONBElement = new GF2nONBElement(this);
        gF2nONBElement.increaseThis();
        return gF2nONBElement;
    }

    @Override // org.bouncycastle.pqc.math.linearalgebra.GF2nElement
    public void increaseThis() throws RuntimeException {
        addToThis(ONE((GF2nONBField) this.mField));
    }

    @Override // org.bouncycastle.pqc.math.linearalgebra.GFElement
    public GFElement invert() throws RuntimeException {
        GF2nONBElement gF2nONBElement = new GF2nONBElement(this);
        gF2nONBElement.invertThis();
        return gF2nONBElement;
    }

    public void invertThis() throws RuntimeException {
        if (isZero()) {
            throw new ArithmeticException();
        }
        int i = 31;
        boolean z = false;
        while (!z && i >= 0) {
            if (((this.mDegree - 1) & mBitmask[i]) != 0) {
                z = true;
            }
            i--;
        }
        ZERO((GF2nONBField) this.mField);
        GF2nONBElement gF2nONBElement = new GF2nONBElement(this);
        int i2 = 1;
        for (int i3 = (i + 1) - 1; i3 >= 0; i3--) {
            GF2nElement gF2nElement = (GF2nElement) gF2nONBElement.clone();
            for (int i4 = 1; i4 <= i2; i4++) {
                gF2nElement.squareThis();
            }
            gF2nONBElement.multiplyThisBy(gF2nElement);
            i2 <<= 1;
            if (((this.mDegree - 1) & mBitmask[i3]) != 0) {
                gF2nONBElement.squareThis();
                gF2nONBElement.multiplyThisBy(this);
                i2++;
            }
        }
        gF2nONBElement.squareThis();
    }

    @Override // org.bouncycastle.pqc.math.linearalgebra.GFElement
    public boolean isOne() {
        int i;
        boolean z = false;
        int i2 = 0;
        boolean z2 = true;
        while (true) {
            i = this.mLength;
            if (i2 >= i - 1 || !z2) {
                break;
            }
            z2 = z2 && (this.mPol[i2] & (-1)) == -1;
            i2++;
        }
        if (!z2) {
            return z2;
        }
        if (z2) {
            long j = this.mPol[i - 1];
            long[] jArr = mMaxmask;
            int i3 = this.mBit;
            if ((j & jArr[i3 - 1]) == jArr[i3 - 1]) {
                z = true;
            }
        }
        return z;
    }

    @Override // org.bouncycastle.pqc.math.linearalgebra.GFElement
    public boolean isZero() {
        boolean z = true;
        for (int i = 0; i < this.mLength && z; i++) {
            z = z && (this.mPol[i] & (-1)) == 0;
        }
        return z;
    }

    @Override // org.bouncycastle.pqc.math.linearalgebra.GFElement
    public GFElement multiply(GFElement gFElement) throws RuntimeException {
        GF2nONBElement gF2nONBElement = new GF2nONBElement(this);
        gF2nONBElement.multiplyThisBy(gFElement);
        return gF2nONBElement;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0096 A[PHI: r15
  0x0096: PHI (r15v2 boolean) = (r15v1 boolean), (r15v4 boolean) binds: [B:16:0x0065, B:21:0x007a] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // org.bouncycastle.pqc.math.linearalgebra.GFElement
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void multiplyThisBy(org.bouncycastle.pqc.math.linearalgebra.GFElement r27) throws java.lang.RuntimeException {
        /*
            Method dump skipped, instructions count: 396
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.bouncycastle.pqc.math.linearalgebra.GF2nONBElement.multiplyThisBy(org.bouncycastle.pqc.math.linearalgebra.GFElement):void");
    }

    public void reverseOrder() {
        this.mPol = getElementReverseOrder();
    }

    @Override // org.bouncycastle.pqc.math.linearalgebra.GF2nElement
    public GF2nElement solveQuadraticEquation() throws RuntimeException {
        int i;
        if (trace() == 1) {
            throw new RuntimeException();
        }
        long j = mBitmask[63];
        long[] jArr = new long[this.mLength];
        int i2 = 0;
        long j2 = 0;
        while (true) {
            i = this.mLength;
            if (i2 >= i - 1) {
                break;
            }
            for (int i3 = 1; i3 < 64; i3++) {
                long[] jArr2 = mBitmask;
                long j3 = jArr2[i3];
                long[] jArr3 = this.mPol;
                if (((j3 & jArr3[i2]) == 0 || (jArr2[i3 - 1] & j2) == 0) && ((jArr3[i2] & jArr2[i3]) != 0 || (jArr2[i3 - 1] & j2) != 0)) {
                    j2 ^= jArr2[i3];
                }
            }
            jArr[i2] = j2;
            long j4 = j2 & j;
            j2 = ((j4 == 0 || (1 & this.mPol[i2 + 1]) != 1) && !(j4 == 0 && (this.mPol[i2 + 1] & 1) == 0)) ? 1L : 0L;
            i2++;
        }
        int i4 = this.mDegree & 63;
        long j5 = this.mPol[i - 1];
        for (int i5 = 1; i5 < i4; i5++) {
            long[] jArr4 = mBitmask;
            if (((jArr4[i5] & j5) == 0 || (jArr4[i5 - 1] & j2) == 0) && ((jArr4[i5] & j5) != 0 || (jArr4[i5 - 1] & j2) != 0)) {
                j2 ^= jArr4[i5];
            }
        }
        jArr[this.mLength - 1] = j2;
        return new GF2nONBElement((GF2nONBField) this.mField, jArr);
    }

    @Override // org.bouncycastle.pqc.math.linearalgebra.GF2nElement
    public GF2nElement square() {
        GF2nONBElement gF2nONBElement = new GF2nONBElement(this);
        gF2nONBElement.squareThis();
        return gF2nONBElement;
    }

    @Override // org.bouncycastle.pqc.math.linearalgebra.GF2nElement
    public GF2nElement squareRoot() {
        GF2nONBElement gF2nONBElement = new GF2nONBElement(this);
        gF2nONBElement.squareRootThis();
        return gF2nONBElement;
    }

    @Override // org.bouncycastle.pqc.math.linearalgebra.GF2nElement
    public void squareRootThis() {
        long[] element = getElement();
        int i = this.mLength - 1;
        int i2 = this.mBit - 1;
        long j = mBitmask[63];
        boolean z = (element[0] & 1) != 0;
        int i3 = i;
        while (i3 >= 0) {
            boolean z2 = (element[i3] & 1) != 0;
            element[i3] = element[i3] >>> 1;
            if (z) {
                if (i3 == i) {
                    element[i3] = element[i3] ^ mBitmask[i2];
                } else {
                    element[i3] = element[i3] ^ j;
                }
            }
            i3--;
            z = z2;
        }
        assign(element);
    }

    @Override // org.bouncycastle.pqc.math.linearalgebra.GF2nElement
    public void squareThis() {
        long[] element = getElement();
        int i = this.mLength - 1;
        int i2 = this.mBit - 1;
        long[] jArr = mBitmask;
        long j = jArr[63];
        boolean z = (element[i] & jArr[i2]) != 0;
        int i3 = 0;
        while (i3 < i) {
            boolean z2 = (element[i3] & j) != 0;
            element[i3] = element[i3] << 1;
            if (z) {
                element[i3] = 1 ^ element[i3];
            }
            i3++;
            z = z2;
        }
        long j2 = element[i];
        long[] jArr2 = mBitmask;
        boolean z3 = (j2 & jArr2[i2]) != 0;
        element[i] = element[i] << 1;
        if (z) {
            element[i] = element[i] ^ 1;
        }
        if (z3) {
            element[i] = jArr2[i2 + 1] ^ element[i];
        }
        assign(element);
    }

    @Override // org.bouncycastle.pqc.math.linearalgebra.GF2nElement
    public boolean testBit(int i) {
        return i >= 0 && i <= this.mDegree && (this.mPol[i >>> 6] & mBitmask[i & 63]) != 0;
    }

    @Override // org.bouncycastle.pqc.math.linearalgebra.GF2nElement
    public boolean testRightmostBit() {
        return (this.mPol[this.mLength - 1] & mBitmask[this.mBit - 1]) != 0;
    }

    @Override // org.bouncycastle.pqc.math.linearalgebra.GFElement
    public byte[] toByteArray() {
        int i = ((this.mDegree - 1) >> 3) + 1;
        byte[] bArr = new byte[i];
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = (i2 & 7) << 3;
            bArr[(i - i2) - 1] = (byte) ((this.mPol[i2 >>> 3] & (255 << i3)) >>> i3);
        }
        return bArr;
    }

    @Override // org.bouncycastle.pqc.math.linearalgebra.GFElement
    public BigInteger toFlexiBigInt() {
        return new BigInteger(1, toByteArray());
    }

    @Override // org.bouncycastle.pqc.math.linearalgebra.GFElement
    public String toString() {
        return toString(16);
    }

    @Override // org.bouncycastle.pqc.math.linearalgebra.GFElement
    public String toString(int i) {
        StringBuilder sb;
        long[] element = getElement();
        int i2 = this.mBit;
        String string = "";
        if (i == 2) {
            while (true) {
                i2--;
                if (i2 < 0) {
                    break;
                }
                string = (element[element.length - 1] & (1 << i2)) == 0 ? string + "0" : string + "1";
            }
            for (int length = element.length - 2; length >= 0; length--) {
                for (int i3 = 63; i3 >= 0; i3--) {
                    if ((element[length] & mBitmask[i3]) == 0) {
                        sb = new StringBuilder();
                        sb.append(string);
                        sb.append("0");
                    } else {
                        sb = new StringBuilder();
                        sb.append(string);
                        sb.append("1");
                    }
                    string = sb.toString();
                }
            }
        } else if (i == 16) {
            char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
            for (int length2 = element.length - 1; length2 >= 0; length2--) {
                string = ((((((((((((((((string + cArr[((int) (element[length2] >>> 60)) & 15]) + cArr[((int) (element[length2] >>> 56)) & 15]) + cArr[((int) (element[length2] >>> 52)) & 15]) + cArr[((int) (element[length2] >>> 48)) & 15]) + cArr[((int) (element[length2] >>> 44)) & 15]) + cArr[((int) (element[length2] >>> 40)) & 15]) + cArr[((int) (element[length2] >>> 36)) & 15]) + cArr[((int) (element[length2] >>> 32)) & 15]) + cArr[((int) (element[length2] >>> 28)) & 15]) + cArr[((int) (element[length2] >>> 24)) & 15]) + cArr[((int) (element[length2] >>> 20)) & 15]) + cArr[((int) (element[length2] >>> 16)) & 15]) + cArr[((int) (element[length2] >>> 12)) & 15]) + cArr[((int) (element[length2] >>> 8)) & 15]) + cArr[((int) (element[length2] >>> 4)) & 15]) + cArr[((int) element[length2]) & 15]) + " ";
            }
        }
        return string;
    }

    @Override // org.bouncycastle.pqc.math.linearalgebra.GF2nElement
    public int trace() {
        int i = this.mLength - 1;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            for (int i4 = 0; i4 < 64; i4++) {
                if ((this.mPol[i3] & mBitmask[i4]) != 0) {
                    i2 ^= 1;
                }
            }
        }
        int i5 = this.mBit;
        for (int i6 = 0; i6 < i5; i6++) {
            if ((this.mPol[i] & mBitmask[i6]) != 0) {
                i2 ^= 1;
            }
        }
        return i2;
    }
}
