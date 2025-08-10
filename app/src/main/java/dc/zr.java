package dc;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;
import java.util.LinkedList;

/* compiled from: SAViewUtils.java */
/* loaded from: classes.dex */
public class zr {

    /* compiled from: SAViewUtils.java */
    public class a extends LinkedList<String> {
        public a() {
            add("android##widget");
            add("android##support##v7##widget");
            add("android##support##design##widget");
            add("android##support##text##emoji##widget");
            add("androidx##appcompat##widget");
            add("androidx##emoji##widget");
            add("androidx##cardview##widget");
            add("com##google##android##material");
        }
    }

    static {
        new a();
    }

    public static Activity a(Context context, View view) {
        Activity activity;
        if (context == null) {
            return null;
        }
        try {
            if (context instanceof Activity) {
                activity = (Activity) context;
            } else {
                if (!(context instanceof ContextWrapper)) {
                    return null;
                }
                while (!(context instanceof Activity) && (context instanceof ContextWrapper)) {
                    context = ((ContextWrapper) context).getBaseContext();
                }
                if (!(context instanceof Activity)) {
                    return null;
                }
                activity = (Activity) context;
            }
            return activity;
        } catch (Exception unused) {
            return null;
        }
    }
}
