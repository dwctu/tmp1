package dc;

import com.broadcom.bt.util.io.IOUtils;
import com.google.common.base.Ascii;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* compiled from: ByteString.java */
/* loaded from: classes5.dex */
public class qd4 implements Serializable, Comparable<qd4> {
    public static final char[] c = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    public static final qd4 d = m(new byte[0]);
    private static final long serialVersionUID = 1;
    public transient int a;
    public transient String b;
    public final byte[] data;

    public qd4(byte[] bArr) {
        this.data = bArr;
    }

    public static int b(String str, int i) {
        int length = str.length();
        int iCharCount = 0;
        int i2 = 0;
        while (iCharCount < length) {
            if (i2 == i) {
                return iCharCount;
            }
            int iCodePointAt = str.codePointAt(iCharCount);
            if ((Character.isISOControl(iCodePointAt) && iCodePointAt != 10 && iCodePointAt != 13) || iCodePointAt == 65533) {
                return -1;
            }
            i2++;
            iCharCount += Character.charCount(iCodePointAt);
        }
        return str.length();
    }

    public static qd4 d(String str) {
        if (str == null) {
            throw new IllegalArgumentException("base64 == null");
        }
        byte[] bArrA = md4.a(str);
        if (bArrA != null) {
            return new qd4(bArrA);
        }
        return null;
    }

    public static qd4 e(String str) {
        if (str == null) {
            throw new IllegalArgumentException("hex == null");
        }
        if (str.length() % 2 != 0) {
            throw new IllegalArgumentException("Unexpected hex string: " + str);
        }
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            bArr[i] = (byte) ((f(str.charAt(i2)) << 4) + f(str.charAt(i2 + 1)));
        }
        return m(bArr);
    }

    public static int f(char c2) {
        if (c2 >= '0' && c2 <= '9') {
            return c2 - '0';
        }
        char c3 = 'a';
        if (c2 < 'a' || c2 > 'f') {
            c3 = 'A';
            if (c2 < 'A' || c2 > 'F') {
                throw new IllegalArgumentException("Unexpected hex digit: " + c2);
            }
        }
        return (c2 - c3) + 10;
    }

    public static qd4 h(String str) {
        if (str == null) {
            throw new IllegalArgumentException("s == null");
        }
        qd4 qd4Var = new qd4(str.getBytes(he4.a));
        qd4Var.b = str;
        return qd4Var;
    }

    public static qd4 m(byte... bArr) {
        if (bArr != null) {
            return new qd4((byte[]) bArr.clone());
        }
        throw new IllegalArgumentException("data == null");
    }

    public static qd4 p(InputStream inputStream, int i) throws IOException {
        if (inputStream == null) {
            throw new IllegalArgumentException("in == null");
        }
        if (i < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + i);
        }
        byte[] bArr = new byte[i];
        int i2 = 0;
        while (i2 < i) {
            int i3 = inputStream.read(bArr, i2, i - i2);
            if (i3 == -1) {
                throw new EOFException();
            }
            i2 += i3;
        }
        return new qd4(bArr);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IllegalAccessException, NoSuchFieldException, IOException, IllegalArgumentException {
        qd4 qd4VarP = p(objectInputStream, objectInputStream.readInt());
        try {
            Field declaredField = qd4.class.getDeclaredField("data");
            declaredField.setAccessible(true);
            declaredField.set(this, qd4VarP.data);
        } catch (IllegalAccessException unused) {
            throw new AssertionError();
        } catch (NoSuchFieldException unused2) {
            throw new AssertionError();
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeInt(this.data.length);
        objectOutputStream.write(this.data);
    }

    public String a() {
        return md4.b(this.data);
    }

    @Override // java.lang.Comparable
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public int compareTo(qd4 qd4Var) {
        int iS = s();
        int iS2 = qd4Var.s();
        int iMin = Math.min(iS, iS2);
        for (int i = 0; i < iMin; i++) {
            int i2 = i(i) & 255;
            int i3 = qd4Var.i(i) & 255;
            if (i2 != i3) {
                return i2 < i3 ? -1 : 1;
            }
        }
        if (iS == iS2) {
            return 0;
        }
        return iS < iS2 ? -1 : 1;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof qd4) {
            qd4 qd4Var = (qd4) obj;
            int iS = qd4Var.s();
            byte[] bArr = this.data;
            if (iS == bArr.length && qd4Var.o(0, bArr, 0, bArr.length)) {
                return true;
            }
        }
        return false;
    }

    public final qd4 g(String str) {
        try {
            return m(MessageDigest.getInstance(str).digest(this.data));
        } catch (NoSuchAlgorithmException e) {
            throw new AssertionError(e);
        }
    }

    public int hashCode() {
        int i = this.a;
        if (i != 0) {
            return i;
        }
        int iHashCode = Arrays.hashCode(this.data);
        this.a = iHashCode;
        return iHashCode;
    }

    public byte i(int i) {
        return this.data[i];
    }

    public String j() {
        byte[] bArr = this.data;
        char[] cArr = new char[bArr.length * 2];
        int i = 0;
        for (byte b : bArr) {
            int i2 = i + 1;
            char[] cArr2 = c;
            cArr[i] = cArr2[(b >> 4) & 15];
            i = i2 + 1;
            cArr[i2] = cArr2[b & Ascii.SI];
        }
        return new String(cArr);
    }

    public byte[] k() {
        return this.data;
    }

    public qd4 l() {
        return g("MD5");
    }

    public boolean n(int i, qd4 qd4Var, int i2, int i3) {
        return qd4Var.o(i2, this.data, i, i3);
    }

    public boolean o(int i, byte[] bArr, int i2, int i3) {
        if (i >= 0) {
            byte[] bArr2 = this.data;
            if (i <= bArr2.length - i3 && i2 >= 0 && i2 <= bArr.length - i3 && he4.a(bArr2, i, bArr, i2, i3)) {
                return true;
            }
        }
        return false;
    }

    public qd4 q() {
        return g("SHA-1");
    }

    public qd4 r() {
        return g(MessageDigestAlgorithms.SHA_256);
    }

    public int s() {
        return this.data.length;
    }

    public final boolean t(qd4 qd4Var) {
        return n(0, qd4Var, 0, qd4Var.s());
    }

    public String toString() {
        if (this.data.length == 0) {
            return "[size=0]";
        }
        String strX = x();
        int iB = b(strX, 64);
        if (iB == -1) {
            if (this.data.length <= 64) {
                return "[hex=" + j() + "]";
            }
            return "[size=" + this.data.length + " hex=" + u(0, 64).j() + "…]";
        }
        String strReplace = strX.substring(0, iB).replace("\\", "\\\\").replace(IOUtils.LINE_SEPARATOR_UNIX, "\\n").replace("\r", "\\r");
        if (iB >= strX.length()) {
            return "[text=" + strReplace + "]";
        }
        return "[size=" + this.data.length + " text=" + strReplace + "…]";
    }

    public qd4 u(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException("beginIndex < 0");
        }
        byte[] bArr = this.data;
        if (i2 > bArr.length) {
            throw new IllegalArgumentException("endIndex > length(" + this.data.length + ")");
        }
        int i3 = i2 - i;
        if (i3 < 0) {
            throw new IllegalArgumentException("endIndex < beginIndex");
        }
        if (i == 0 && i2 == bArr.length) {
            return this;
        }
        byte[] bArr2 = new byte[i3];
        System.arraycopy(bArr, i, bArr2, 0, i3);
        return new qd4(bArr2);
    }

    public qd4 v() {
        int i = 0;
        while (true) {
            byte[] bArr = this.data;
            if (i >= bArr.length) {
                return this;
            }
            byte b = bArr[i];
            if (b >= 65 && b <= 90) {
                byte[] bArr2 = (byte[]) bArr.clone();
                bArr2[i] = (byte) (b + 32);
                for (int i2 = i + 1; i2 < bArr2.length; i2++) {
                    byte b2 = bArr2[i2];
                    if (b2 >= 65 && b2 <= 90) {
                        bArr2[i2] = (byte) (b2 + 32);
                    }
                }
                return new qd4(bArr2);
            }
            i++;
        }
    }

    public byte[] w() {
        return (byte[]) this.data.clone();
    }

    public String x() {
        String str = this.b;
        if (str != null) {
            return str;
        }
        String str2 = new String(this.data, he4.a);
        this.b = str2;
        return str2;
    }

    public void z(nd4 nd4Var) {
        byte[] bArr = this.data;
        nd4Var.l0(bArr, 0, bArr.length);
    }
}
