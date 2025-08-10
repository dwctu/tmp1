package dc;

import com.google.android.exoplayer2.extractor.ts.PsExtractor;
import com.samsung.android.sdk.bt.gatt.BluetoothGatt;
import io.socket.utf8.UTF8Exception;
import java.util.ArrayList;
import java.util.List;

/* compiled from: UTF8.java */
/* loaded from: classes4.dex */
public final class kx3 {
    public static int[] a;
    public static int b;
    public static int c;

    /* compiled from: UTF8.java */
    public static class a {
        public boolean a = true;
    }

    public static boolean a(int i, boolean z) throws UTF8Exception {
        if (i < 55296 || i > 57343) {
            return true;
        }
        if (!z) {
            return false;
        }
        throw new UTF8Exception("Lone surrogate U+" + Integer.toHexString(i).toUpperCase() + " is not a scalar value");
    }

    public static char[] b(int i, int i2) {
        return Character.toChars(((i >> i2) & 63) | 128);
    }

    public static String c(String str, a aVar) throws UTF8Exception {
        boolean z = aVar.a;
        int[] iArrI = i(str);
        a = iArrI;
        b = iArrI.length;
        c = 0;
        ArrayList arrayList = new ArrayList();
        while (true) {
            int iD = d(z);
            if (iD == -1) {
                return j(g(arrayList));
            }
            arrayList.add(Integer.valueOf(iD));
        }
    }

    public static int d(boolean z) throws UTF8Exception {
        int i = c;
        int i2 = b;
        if (i > i2) {
            throw new UTF8Exception("Invalid byte index");
        }
        if (i == i2) {
            return -1;
        }
        int i3 = a[i] & 255;
        c = i + 1;
        if ((i3 & 128) == 0) {
            return i3;
        }
        if ((i3 & 224) == 192) {
            int iH = h() | ((i3 & 31) << 6);
            if (iH >= 128) {
                return iH;
            }
            throw new UTF8Exception("Invalid continuation byte");
        }
        if ((i3 & PsExtractor.VIDEO_STREAM_MASK) == 224) {
            int iH2 = (h() << 6) | ((i3 & 15) << 12) | h();
            if (iH2 < 2048) {
                throw new UTF8Exception("Invalid continuation byte");
            }
            if (a(iH2, z)) {
                return iH2;
            }
            return 65533;
        }
        if ((i3 & 248) == 240) {
            int iH3 = h();
            int i4 = iH3 << 12;
            int iH4 = i4 | ((i3 & 15) << 18) | (h() << 6) | h();
            if (iH4 >= 65536 && iH4 <= 1114111) {
                return iH4;
            }
        }
        throw new UTF8Exception("Invalid continuation byte");
    }

    public static String e(String str, a aVar) throws UTF8Exception {
        boolean z = aVar.a;
        int[] iArrI = i(str);
        int length = iArrI.length;
        StringBuilder sb = new StringBuilder();
        int i = -1;
        while (true) {
            i++;
            if (i >= length) {
                return sb.toString();
            }
            sb.append(f(iArrI[i], z));
        }
    }

    public static String f(int i, boolean z) throws UTF8Exception {
        StringBuilder sb = new StringBuilder();
        if ((i & BluetoothGatt.GATT_NO_RESOURCES) == 0) {
            sb.append(Character.toChars(i));
            return sb.toString();
        }
        if ((i & (-2048)) == 0) {
            sb.append(Character.toChars(((i >> 6) & 31) | 192));
        } else if (((-65536) & i) == 0) {
            if (!a(i, z)) {
                i = 65533;
            }
            sb.append(Character.toChars(((i >> 12) & 15) | 224));
            sb.append(b(i, 6));
        } else if (((-2097152) & i) == 0) {
            sb.append(Character.toChars(((i >> 18) & 7) | PsExtractor.VIDEO_STREAM_MASK));
            sb.append(b(i, 12));
            sb.append(b(i, 6));
        }
        sb.append(Character.toChars((i & 63) | 128));
        return sb.toString();
    }

    public static int[] g(List<Integer> list) {
        int size = list.size();
        int[] iArr = new int[size];
        for (int i = 0; i < size; i++) {
            iArr[i] = list.get(i).intValue();
        }
        return iArr;
    }

    public static int h() throws UTF8Exception {
        int i = c;
        if (i >= b) {
            throw new UTF8Exception("Invalid byte index");
        }
        int i2 = a[i] & 255;
        c = i + 1;
        if ((i2 & 192) == 128) {
            return i2 & 63;
        }
        throw new UTF8Exception("Invalid continuation byte");
    }

    public static int[] i(String str) {
        int length = str.length();
        int iCharCount = 0;
        int[] iArr = new int[str.codePointCount(0, length)];
        int i = 0;
        while (iCharCount < length) {
            int iCodePointAt = str.codePointAt(iCharCount);
            iArr[i] = iCodePointAt;
            iCharCount += Character.charCount(iCodePointAt);
            i++;
        }
        return iArr;
    }

    public static String j(int[] iArr) {
        StringBuilder sb = new StringBuilder();
        for (int i : iArr) {
            sb.appendCodePoint(i);
        }
        return sb.toString();
    }
}
