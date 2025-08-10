package no.nordicsemi.android.support.v18.scanner;

import android.util.SparseArray;
import androidx.annotation.Nullable;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.slf4j.helpers.MessageFormatter;

/* loaded from: classes5.dex */
public class BluetoothLeUtils {
    public static boolean equals(@Nullable SparseArray<byte[]> sparseArray, @Nullable SparseArray<byte[]> sparseArray2) {
        if (sparseArray == sparseArray2) {
            return true;
        }
        if (sparseArray == null || sparseArray2 == null || sparseArray.size() != sparseArray2.size()) {
            return false;
        }
        for (int i = 0; i < sparseArray.size(); i++) {
            if (sparseArray.keyAt(i) != sparseArray2.keyAt(i) || !Arrays.equals(sparseArray.valueAt(i), sparseArray2.valueAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static String toString(@Nullable SparseArray<byte[]> sparseArray) {
        if (sparseArray == null) {
            return "null";
        }
        if (sparseArray.size() == 0) {
            return MessageFormatter.DELIM_STR;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(MessageFormatter.DELIM_START);
        for (int i = 0; i < sparseArray.size(); i++) {
            sb.append(sparseArray.keyAt(i));
            sb.append("=");
            sb.append(Arrays.toString(sparseArray.valueAt(i)));
        }
        sb.append(MessageFormatter.DELIM_STOP);
        return sb.toString();
    }

    public static <T> boolean equals(@Nullable Map<T, byte[]> map, Map<T, byte[]> map2) {
        if (map == map2) {
            return true;
        }
        if (map == null || map2 == null || map.size() != map2.size()) {
            return false;
        }
        Set<T> setKeySet = map.keySet();
        if (!setKeySet.equals(map2.keySet())) {
            return false;
        }
        for (T t : setKeySet) {
            if (!Objects.deepEquals(map.get(t), map2.get(t))) {
                return false;
            }
        }
        return true;
    }

    public static <T> String toString(@Nullable Map<T, byte[]> map) {
        if (map == null) {
            return "null";
        }
        if (map.isEmpty()) {
            return MessageFormatter.DELIM_STR;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(MessageFormatter.DELIM_START);
        Iterator<Map.Entry<T, byte[]>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            T key = it.next().getKey();
            sb.append(key);
            sb.append("=");
            sb.append(Arrays.toString(map.get(key)));
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(MessageFormatter.DELIM_STOP);
        return sb.toString();
    }
}
