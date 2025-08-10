package dc;

import android.app.KeyguardManager;
import android.content.Context;
import com.github.gzuliyujiang.oaid.OAIDException;
import java.lang.reflect.InvocationTargetException;
import java.util.Objects;

/* compiled from: CooseaImpl.java */
/* loaded from: classes.dex */
public class bi0 implements wh0 {
    public final Context a;
    public final KeyguardManager b;

    public bi0(Context context) {
        this.a = context;
        this.b = (KeyguardManager) context.getSystemService("keyguard");
    }

    @Override // dc.wh0
    public boolean a() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        KeyguardManager keyguardManager;
        if (this.a == null || (keyguardManager = this.b) == null) {
            return false;
        }
        try {
            Object objInvoke = keyguardManager.getClass().getDeclaredMethod("isSupported", new Class[0]).invoke(this.b, new Object[0]);
            Objects.requireNonNull(objInvoke);
            return ((Boolean) objInvoke).booleanValue();
        } catch (Exception e) {
            xh0.a(e);
            return false;
        }
    }

    @Override // dc.wh0
    public void b(vh0 vh0Var) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (this.a == null || vh0Var == null) {
            return;
        }
        KeyguardManager keyguardManager = this.b;
        if (keyguardManager == null) {
            vh0Var.b(new OAIDException("KeyguardManager not found"));
            return;
        }
        try {
            Object objInvoke = keyguardManager.getClass().getDeclaredMethod("obtainOaid", new Class[0]).invoke(this.b, new Object[0]);
            if (objInvoke == null) {
                throw new OAIDException("OAID obtain failed");
            }
            String string = objInvoke.toString();
            xh0.a("OAID obtain success: " + string);
            vh0Var.a(string);
        } catch (Exception e) {
            xh0.a(e);
        }
    }
}
