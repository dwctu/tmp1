package dc;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: SkinCompatDelegate.java */
/* loaded from: classes5.dex */
public class gh4 implements LayoutInflater.Factory2 {
    public final Context a;
    public hh4 b;
    public List<WeakReference<aj4>> c = new CopyOnWriteArrayList();

    public gh4(Context context) {
        this.a = context;
    }

    public static gh4 b(Context context) {
        return new gh4(context);
    }

    public void a() {
        List<WeakReference<aj4>> list = this.c;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (WeakReference<aj4> weakReference : this.c) {
            if (weakReference != null && weakReference.get() != null) {
                weakReference.get().P1();
            }
        }
    }

    public View c(View view, String str, Context context, AttributeSet attributeSet) {
        if (this.b == null) {
            this.b = new hh4();
        }
        Iterator<jh4> it = zg4.m().q().iterator();
        while (it.hasNext()) {
            Context contextA = it.next().a(this.a, view, attributeSet);
            if (contextA != null) {
                context = contextA;
            }
        }
        return this.b.c(view, str, context, attributeSet);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.LayoutInflater.Factory2
    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        View viewC = c(view, str, context, attributeSet);
        if (viewC == 0) {
            return null;
        }
        if (viewC instanceof aj4) {
            this.c.add(new WeakReference<>((aj4) viewC));
        }
        return viewC;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        View viewC = c(null, str, context, attributeSet);
        if (viewC == 0) {
            return null;
        }
        if (viewC instanceof aj4) {
            this.c.add(new WeakReference<>((aj4) viewC));
        }
        return viewC;
    }
}
