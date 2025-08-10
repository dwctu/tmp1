package dc;

import android.content.Context;
import android.content.SharedPreferences;

/* compiled from: SkinPreference.java */
/* loaded from: classes5.dex */
public class oi4 {
    public static oi4 d;
    public final Context a;
    public final SharedPreferences b;
    public final SharedPreferences.Editor c;

    public oi4(Context context) {
        this.a = context;
        SharedPreferences sharedPreferences = context.getSharedPreferences("meta-data", 0);
        this.b = sharedPreferences;
        this.c = sharedPreferences.edit();
    }

    public static oi4 b() {
        return d;
    }

    public static void d(Context context) {
        if (d == null) {
            synchronized (oi4.class) {
                if (d == null) {
                    d = new oi4(context.getApplicationContext());
                }
            }
        }
    }

    public void a() {
        this.c.apply();
    }

    public String c() {
        return this.b.getString("skin-user-theme-json", "");
    }

    public oi4 e(String str) {
        this.c.putString("skin-name", str);
        return this;
    }

    public oi4 f(int i) {
        this.c.putInt("skin-strategy", i);
        return this;
    }
}
