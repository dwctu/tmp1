package com.broadcom.bt.util;

/* loaded from: classes.dex */
public class SearchUtil {
    public static int binarySearch(int[] iArr, int i) {
        int length = iArr.length - 1;
        int i2 = 0;
        do {
            int i3 = (i2 + length) / 2;
            int i4 = iArr[i3];
            if (i4 == i) {
                return i3;
            }
            if (i4 < i) {
                i2 = i3 + 1;
            } else if (i4 > i) {
                length = i3 - 1;
            }
        } while (i2 <= length);
        return -1;
    }

    public static int indexOf(int[] iArr, int i) {
        for (int i2 = 0; i2 < iArr.length; i2++) {
            if (i == iArr[i2]) {
                return i2;
            }
        }
        return -1;
    }

    public static int search(String[] strArr, String str) {
        for (int i = 0; i < strArr.length; i++) {
            if (strArr[i].equals(str)) {
                return i;
            }
        }
        return -1;
    }
}
