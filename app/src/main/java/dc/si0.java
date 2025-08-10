package dc;

import android.annotation.SuppressLint;
import android.content.Context;
import com.github.gzuliyujiang.oaid.OAIDException;
import java.lang.reflect.InvocationTargetException;

/* compiled from: XiaomiImpl.java */
/* loaded from: classes.dex */
public class si0 implements wh0 {
    public final Context a;
    public Class<?> b;
    public Object c;

    @SuppressLint({"PrivateApi"})
    public si0(Context context) throws ClassNotFoundException {
        this.a = context;
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            this.b = cls;
            this.c = cls.newInstance();
        } catch (Exception e) {
            xh0.a(e);
        }
    }

    @Override // dc.wh0
    public boolean a() {
        return this.c != null;
    }

    @Override // dc.wh0
    public void b(vh0 vh0Var) {
        if (this.a == null || vh0Var == null) {
            return;
        }
        if (this.b == null || this.c == null) {
            vh0Var.b(new OAIDException("Xiaomi IdProvider not exists"));
            return;
        }
        try {
            String strC = c();
            if (strC == null || strC.length() == 0) {
                throw new OAIDException("OAID query failed");
            }
            xh0.a("OAID query success: " + strC);
            vh0Var.a(strC);
        } catch (Exception e) {
            xh0.a(e);
            vh0Var.b(e);
        }
    }

    public final String c() throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        return (String) this.b.getMethod("getOAID", Context.class).invoke(this.c, this.a);
    }
}
