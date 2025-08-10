package dc;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: ArrayUtils.java */
/* loaded from: classes.dex */
public class hd0 {
    @NonNull
    public static <T> List<T> a(@Nullable T... tArr) {
        ArrayList arrayList = new ArrayList();
        if (tArr != null && tArr.length != 0) {
            arrayList.addAll(Arrays.asList(tArr));
        }
        return arrayList;
    }
}
