package dc;

import java.util.ConcurrentModificationException;
import java.util.Map;
import org.slf4j.helpers.MessageFormatter;

/* compiled from: SimpleArrayMap.java */
/* loaded from: classes5.dex */
public class ph4<K, V> {
    public static Object[] d;
    public static int e;
    public static Object[] f;
    public static int g;
    public int[] a = nh4.a;
    public Object[] b = nh4.b;
    public int c = 0;

    public static int b(int[] iArr, int i, int i2) {
        try {
            return nh4.a(iArr, i, i2);
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    public static void d(int[] iArr, Object[] objArr, int i) {
        if (iArr.length == 8) {
            synchronized (mh4.class) {
                if (g < 10) {
                    objArr[0] = f;
                    objArr[1] = iArr;
                    for (int i2 = (i << 1) - 1; i2 >= 2; i2--) {
                        objArr[i2] = null;
                    }
                    f = objArr;
                    g++;
                }
            }
            return;
        }
        if (iArr.length == 4) {
            synchronized (mh4.class) {
                if (e < 10) {
                    objArr[0] = d;
                    objArr[1] = iArr;
                    for (int i3 = (i << 1) - 1; i3 >= 2; i3--) {
                        objArr[i3] = null;
                    }
                    d = objArr;
                    e++;
                }
            }
        }
    }

    public final void a(int i) {
        if (i == 8) {
            synchronized (mh4.class) {
                Object[] objArr = f;
                if (objArr != null) {
                    this.b = objArr;
                    f = (Object[]) objArr[0];
                    this.a = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    g--;
                    return;
                }
            }
        } else if (i == 4) {
            synchronized (mh4.class) {
                Object[] objArr2 = d;
                if (objArr2 != null) {
                    this.b = objArr2;
                    d = (Object[]) objArr2[0];
                    this.a = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    e--;
                    return;
                }
            }
        }
        this.a = new int[i];
        this.b = new Object[i << 1];
    }

    public void c(int i) {
        int i2 = this.c;
        int[] iArr = this.a;
        if (iArr.length < i) {
            Object[] objArr = this.b;
            a(i);
            if (this.c > 0) {
                System.arraycopy(iArr, 0, this.a, 0, i2);
                System.arraycopy(objArr, 0, this.b, 0, i2 << 1);
            }
            d(iArr, objArr, i2);
        }
        if (this.c != i2) {
            throw new ConcurrentModificationException();
        }
    }

    public void clear() {
        int i = this.c;
        if (i > 0) {
            int[] iArr = this.a;
            Object[] objArr = this.b;
            this.a = nh4.a;
            this.b = nh4.b;
            this.c = 0;
            d(iArr, objArr, i);
        }
        if (this.c > 0) {
            throw new ConcurrentModificationException();
        }
    }

    public boolean containsKey(Object obj) {
        return f(obj) >= 0;
    }

    public boolean containsValue(Object obj) {
        return h(obj) >= 0;
    }

    public int e(Object obj, int i) {
        int i2 = this.c;
        if (i2 == 0) {
            return -1;
        }
        int iB = b(this.a, i2, i);
        if (iB < 0 || obj.equals(this.b[iB << 1])) {
            return iB;
        }
        int i3 = iB + 1;
        while (i3 < i2 && this.a[i3] == i) {
            if (obj.equals(this.b[i3 << 1])) {
                return i3;
            }
            i3++;
        }
        for (int i4 = iB - 1; i4 >= 0 && this.a[i4] == i; i4--) {
            if (obj.equals(this.b[i4 << 1])) {
                return i4;
            }
        }
        return ~i3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ph4) {
            ph4 ph4Var = (ph4) obj;
            if (size() != ph4Var.size()) {
                return false;
            }
            for (int i = 0; i < this.c; i++) {
                try {
                    K kI = i(i);
                    V vL = l(i);
                    Object obj2 = ph4Var.get(kI);
                    if (vL == null) {
                        if (obj2 != null || !ph4Var.containsKey(kI)) {
                            return false;
                        }
                    } else if (!vL.equals(obj2)) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused) {
                    return false;
                }
            }
            return true;
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            if (size() != map.size()) {
                return false;
            }
            for (int i2 = 0; i2 < this.c; i2++) {
                try {
                    K kI2 = i(i2);
                    V vL2 = l(i2);
                    Object obj3 = map.get(kI2);
                    if (vL2 == null) {
                        if (obj3 != null || !map.containsKey(kI2)) {
                            return false;
                        }
                    } else if (!vL2.equals(obj3)) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused2) {
                }
            }
            return true;
        }
        return false;
    }

    public int f(Object obj) {
        return obj == null ? g() : e(obj, obj.hashCode());
    }

    public int g() {
        int i = this.c;
        if (i == 0) {
            return -1;
        }
        int iB = b(this.a, i, 0);
        if (iB < 0 || this.b[iB << 1] == null) {
            return iB;
        }
        int i2 = iB + 1;
        while (i2 < i && this.a[i2] == 0) {
            if (this.b[i2 << 1] == null) {
                return i2;
            }
            i2++;
        }
        for (int i3 = iB - 1; i3 >= 0 && this.a[i3] == 0; i3--) {
            if (this.b[i3 << 1] == null) {
                return i3;
            }
        }
        return ~i2;
    }

    public V get(Object obj) {
        int iF = f(obj);
        if (iF >= 0) {
            return (V) this.b[(iF << 1) + 1];
        }
        return null;
    }

    public int h(Object obj) {
        int i = this.c * 2;
        Object[] objArr = this.b;
        if (obj == null) {
            for (int i2 = 1; i2 < i; i2 += 2) {
                if (objArr[i2] == null) {
                    return i2 >> 1;
                }
            }
            return -1;
        }
        for (int i3 = 1; i3 < i; i3 += 2) {
            if (obj.equals(objArr[i3])) {
                return i3 >> 1;
            }
        }
        return -1;
    }

    public int hashCode() {
        int[] iArr = this.a;
        Object[] objArr = this.b;
        int i = this.c;
        int i2 = 1;
        int i3 = 0;
        int iHashCode = 0;
        while (i3 < i) {
            Object obj = objArr[i2];
            iHashCode += (obj == null ? 0 : obj.hashCode()) ^ iArr[i3];
            i3++;
            i2 += 2;
        }
        return iHashCode;
    }

    public K i(int i) {
        return (K) this.b[i << 1];
    }

    public boolean isEmpty() {
        return this.c <= 0;
    }

    public V j(int i) {
        Object[] objArr = this.b;
        int i2 = i << 1;
        V v = (V) objArr[i2 + 1];
        int i3 = this.c;
        int i4 = 0;
        if (i3 <= 1) {
            d(this.a, objArr, i3);
            this.a = nh4.a;
            this.b = nh4.b;
        } else {
            int i5 = i3 - 1;
            int[] iArr = this.a;
            if (iArr.length <= 8 || i3 >= iArr.length / 3) {
                if (i < i5) {
                    int i6 = i + 1;
                    int i7 = i5 - i;
                    System.arraycopy(iArr, i6, iArr, i, i7);
                    Object[] objArr2 = this.b;
                    System.arraycopy(objArr2, i6 << 1, objArr2, i2, i7 << 1);
                }
                Object[] objArr3 = this.b;
                int i8 = i5 << 1;
                objArr3[i8] = null;
                objArr3[i8 + 1] = null;
            } else {
                a(i3 > 8 ? i3 + (i3 >> 1) : 8);
                if (i3 != this.c) {
                    throw new ConcurrentModificationException();
                }
                if (i > 0) {
                    System.arraycopy(iArr, 0, this.a, 0, i);
                    System.arraycopy(objArr, 0, this.b, 0, i2);
                }
                if (i < i5) {
                    int i9 = i + 1;
                    int i10 = i5 - i;
                    System.arraycopy(iArr, i9, this.a, i, i10);
                    System.arraycopy(objArr, i9 << 1, this.b, i2, i10 << 1);
                }
            }
            i4 = i5;
        }
        if (i3 != this.c) {
            throw new ConcurrentModificationException();
        }
        this.c = i4;
        return v;
    }

    public V k(int i, V v) {
        int i2 = (i << 1) + 1;
        Object[] objArr = this.b;
        V v2 = (V) objArr[i2];
        objArr[i2] = v;
        return v2;
    }

    public V l(int i) {
        return (V) this.b[(i << 1) + 1];
    }

    public V put(K k, V v) {
        int i;
        int iE;
        int i2 = this.c;
        if (k == null) {
            iE = g();
            i = 0;
        } else {
            int iHashCode = k.hashCode();
            i = iHashCode;
            iE = e(k, iHashCode);
        }
        if (iE >= 0) {
            int i3 = (iE << 1) + 1;
            Object[] objArr = this.b;
            V v2 = (V) objArr[i3];
            objArr[i3] = v;
            return v2;
        }
        int i4 = ~iE;
        int[] iArr = this.a;
        if (i2 >= iArr.length) {
            int i5 = 4;
            if (i2 >= 8) {
                i5 = (i2 >> 1) + i2;
            } else if (i2 >= 4) {
                i5 = 8;
            }
            Object[] objArr2 = this.b;
            a(i5);
            if (i2 != this.c) {
                throw new ConcurrentModificationException();
            }
            int[] iArr2 = this.a;
            if (iArr2.length > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(objArr2, 0, this.b, 0, objArr2.length);
            }
            d(iArr, objArr2, i2);
        }
        if (i4 < i2) {
            int[] iArr3 = this.a;
            int i6 = i4 + 1;
            System.arraycopy(iArr3, i4, iArr3, i6, i2 - i4);
            Object[] objArr3 = this.b;
            System.arraycopy(objArr3, i4 << 1, objArr3, i6 << 1, (this.c - i4) << 1);
        }
        int i7 = this.c;
        if (i2 == i7) {
            int[] iArr4 = this.a;
            if (i4 < iArr4.length) {
                iArr4[i4] = i;
                Object[] objArr4 = this.b;
                int i8 = i4 << 1;
                objArr4[i8] = k;
                objArr4[i8 + 1] = v;
                this.c = i7 + 1;
                return null;
            }
        }
        throw new ConcurrentModificationException();
    }

    public V remove(Object obj) {
        int iF = f(obj);
        if (iF >= 0) {
            return j(iF);
        }
        return null;
    }

    public int size() {
        return this.c;
    }

    public String toString() {
        if (isEmpty()) {
            return MessageFormatter.DELIM_STR;
        }
        StringBuilder sb = new StringBuilder(this.c * 28);
        sb.append(MessageFormatter.DELIM_START);
        for (int i = 0; i < this.c; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            K kI = i(i);
            if (kI != this) {
                sb.append(kI);
            } else {
                sb.append("(this Map)");
            }
            sb.append('=');
            V vL = l(i);
            if (vL != this) {
                sb.append(vL);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append(MessageFormatter.DELIM_STOP);
        return sb.toString();
    }
}
