package dc;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import dc.lk;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

/* compiled from: GroupIconLoader.java */
/* loaded from: classes4.dex */
public class jj3 implements lk<List<String>, InputStream> {
    public final Context a;

    /* compiled from: GroupIconLoader.java */
    public static class a implements mk<List<String>, InputStream> {
        public Context a;

        public a(Context context) {
            this.a = context;
        }

        @Override // dc.mk
        @NonNull
        public lk<List<String>, InputStream> b(@NonNull pk pkVar) {
            return new jj3(this.a);
        }
    }

    public jj3(Context context) {
        this.a = context;
    }

    @Override // dc.lk
    @Nullable
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public lk.a<InputStream> b(@NonNull List<String> list, int i, int i2, @NonNull ah ahVar) {
        if (list.size() > 9) {
            list = list.subList(0, 9);
        }
        Iterator<String> it = list.iterator();
        String str = "";
        while (it.hasNext()) {
            str = str + it.next() + ",";
        }
        return new lk.a<>(new mp(str.substring(0, str.length() - 1)), new kj3(this.a, list));
    }

    @Override // dc.lk
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(@NonNull List<String> list) {
        return true;
    }
}
