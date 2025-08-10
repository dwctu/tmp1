package dc;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.DialogInterface;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import androidx.core.content.ContextCompat;
import com.lovense.wear.R;
import com.wear.bean.User;
import com.wear.protocol.MessageType;
import dc.is3;
import dc.kn3;

/* compiled from: LongRequestDialog.java */
/* loaded from: classes4.dex */
public class rn3 implements tz1 {
    public Context a;
    public d b;
    public String c;
    public String d;
    public Dialog e;
    public MessageType f;
    public User g;
    public String h;

    /* compiled from: LongRequestDialog.java */
    public class a implements is3.c {
        public a() {
        }

        @Override // dc.is3.c
        public void doCancel() {
            if (rn3.this.b != null) {
                rn3.this.b.doCancel();
            }
            rn3.this.e = null;
        }
    }

    /* compiled from: LongRequestDialog.java */
    public class b implements is3.d {
        public b() {
        }

        @Override // dc.is3.d
        public void doConfirm() {
            if (rn3.this.b != null) {
                rn3.this.b.doConfirm();
            }
            rn3.this.e = null;
        }
    }

    /* compiled from: LongRequestDialog.java */
    public class c implements kn3.d {
        public c() {
        }

        @Override // dc.kn3.d
        public void doCancel() {
            if (rn3.this.b != null) {
                rn3.this.b.doCancel();
            }
            rn3.this.e = null;
        }

        @Override // dc.kn3.d
        public void doConfirm() {
            if (rn3.this.b != null) {
                rn3.this.b.doConfirm();
            }
            rn3.this.e = null;
        }
    }

    /* compiled from: LongRequestDialog.java */
    public interface d {
        void doCancel();

        void doConfirm();
    }

    public rn3(Context context, String str, String str2, String str3, d dVar, MessageType messageType, String str4) {
        this.a = context;
        this.b = dVar;
        this.c = str;
        this.d = str2;
        this.f = messageType;
        this.h = str4;
        this.g = ch3.n().v(str4);
        if (messageType == MessageType.voice || messageType == MessageType.video) {
            g();
        } else {
            f();
        }
        sz1.d().n(this);
    }

    public void c() {
        Dialog dialog = this.e;
        if (dialog == null || !dialog.isShowing()) {
            return;
        }
        Context baseContext = ((ContextWrapper) this.e.getContext()).getBaseContext();
        if (baseContext instanceof Activity) {
            Activity activity = (Activity) baseContext;
            if (!activity.isFinishing() && !activity.isDestroyed()) {
                this.e.dismiss();
            }
        } else {
            this.e.dismiss();
        }
        this.e = null;
    }

    public boolean d() {
        Dialog dialog = this.e;
        if (dialog != null) {
            return dialog.isShowing();
        }
        return false;
    }

    public void e(DialogInterface.OnDismissListener onDismissListener) {
        Dialog dialog = this.e;
        if (dialog == null || onDismissListener == null) {
            return;
        }
        dialog.setOnDismissListener(onDismissListener);
    }

    public final void f() {
        Dialog dialog = this.e;
        if (dialog != null && dialog.isShowing()) {
            c();
            this.e = null;
        }
        String str = this.c + "\n " + this.d;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) str);
        int iIndexOf = str.indexOf(this.d);
        if (iIndexOf != -1 && this.d.length() + iIndexOf <= spannableStringBuilder.length()) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan(ContextCompat.getColor(this.a, R.color.color_accent)), iIndexOf, this.d.length() + iIndexOf, 34);
        }
        is3.b bVar = new is3.b(this.a);
        bVar.p(spannableStringBuilder);
        bVar.n(ah4.e(R.string.common_decline));
        bVar.o(ah4.e(R.string.common_accept));
        bVar.d(new b());
        bVar.c(new a());
        is3 is3VarH = cs3.h(bVar);
        this.e = is3VarH;
        is3VarH.show();
    }

    public final void g() {
        in3 in3Var = new in3(this.a, false, this.h, this.f, new c());
        this.e = in3Var;
        in3Var.show();
    }

    @Override // dc.tz1
    public int getPriority() {
        User user = this.g;
        return (user == null || !user.isDateIng()) ? 8 : 24;
    }

    @Override // dc.tz1
    public void pauseConnon(int i) {
    }

    @Override // dc.tz1
    public void recovery() {
    }

    @Override // dc.tz1
    public void stop(int i) {
        sz1.d().s(this);
        c();
        this.b.doCancel();
    }
}
