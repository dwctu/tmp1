package dc;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.lovense.wear.R;
import com.wear.util.WearUtils;
import java.lang.reflect.InvocationTargetException;

/* compiled from: NewCommonDialog.java */
/* loaded from: classes4.dex */
public class is3<D> extends Dialog implements lf3 {
    public a a;
    public Context b;
    public D c;
    public Window d;
    public Handler e;

    /* compiled from: NewCommonDialog.java */
    public static class a {
        public Context a;
        public Object b;
        public CharSequence c;
        public CharSequence d;
        public CharSequence e;
        public CharSequence f;
        public d g;
        public c h;
        public DialogInterface.OnDismissListener i;
        public boolean j = false;
        public boolean k = false;
        public boolean l = false;
        public boolean m = false;
        public boolean n = false;
        public boolean o = true;
        public int p = R.layout.dialog_default;
        public int q = R.id.tv_confirm;
        public int r = R.id.tv_cancel;
        public int s = R.id.tv_text;
        public int t = R.id.tv_title;
        public int u = 0;
        public int v = 0;
        public int w = R.style.dialog;
        public int x = 17;
    }

    /* compiled from: NewCommonDialog.java */
    public static class b {
        public a a;

        public b(Context context) {
            a aVar = new a();
            this.a = aVar;
            aVar.a = context;
            aVar.d = ah4.e(R.string.common_cancel);
            this.a.e = ah4.e(R.string.common_ok);
        }

        public <T extends is3> T a(Class<T> cls) throws IllegalAccessException, InstantiationException, IllegalArgumentException, InvocationTargetException {
            T t = null;
            try {
                Class<?>[] clsArr = {Context.class, Integer.TYPE};
                a aVar = this.a;
                T tNewInstance = cls.getConstructor(clsArr).newInstance(aVar.a, Integer.valueOf(aVar.w));
                try {
                    tNewInstance.a = this.a;
                    return tNewInstance;
                } catch (Exception unused) {
                    t = tNewInstance;
                    try {
                        T tNewInstance2 = cls.getConstructor(Context.class).newInstance(this.a.a);
                        try {
                            tNewInstance2.a = this.a;
                            return tNewInstance2;
                        } catch (Exception unused2) {
                            return tNewInstance2;
                        }
                    } catch (Exception unused3) {
                        return t;
                    }
                }
            } catch (Exception unused4) {
            }
        }

        public b b(boolean z) {
            this.a.o = z;
            return this;
        }

        public b c(c cVar) {
            this.a.h = cVar;
            return this;
        }

        public b d(d dVar) {
            this.a.g = dVar;
            return this;
        }

        public b e(Object obj) {
            this.a.b = obj;
            return this;
        }

        public b f(DialogInterface.OnDismissListener onDismissListener) {
            this.a.i = onDismissListener;
            return this;
        }

        public b g(boolean z) {
            this.a.m = z;
            return this;
        }

        public b h(boolean z) {
            this.a.l = z;
            return this;
        }

        public b i(int i) {
            this.a.x = i;
            return this;
        }

        public b j(int i) {
            this.a.v = i;
            return this;
        }

        public b k(int i) {
            this.a.p = i;
            return this;
        }

        public b l(boolean z) {
            this.a.j = z;
            return this;
        }

        public b m(boolean z) {
            this.a.j = z;
            return this;
        }

        public b n(CharSequence charSequence) {
            this.a.d = charSequence;
            return this;
        }

        public b o(CharSequence charSequence) {
            this.a.e = charSequence;
            return this;
        }

        public b p(CharSequence charSequence) {
            this.a.c = charSequence;
            return this;
        }

        public b q(CharSequence charSequence) {
            this.a.f = charSequence;
            return this;
        }

        public b r(int i) {
            this.a.w = i;
            return this;
        }

        public b s(boolean z) {
            this.a.n = z;
            return this;
        }

        public b t(int i) {
            this.a.r = i;
            return this;
        }

        public b u(int i) {
            this.a.q = i;
            return this;
        }

        public b v(int i) {
            this.a.s = i;
            return this;
        }

        public b w(int i) {
            this.a.t = i;
            return this;
        }

        public b x(int i) {
            this.a.u = i;
            return this;
        }
    }

    /* compiled from: NewCommonDialog.java */
    public interface c {
        void doCancel();
    }

    /* compiled from: NewCommonDialog.java */
    public interface d {
        void doConfirm();
    }

    public is3(Context context, int i) {
        super(context, i);
        this.e = new Handler(Looper.getMainLooper());
        this.b = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void l(View view) {
        d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void n(View view) {
        e();
    }

    public void d() {
        if (!this.a.m) {
            dismiss();
        }
        c cVar = this.a.h;
        if (cVar != null) {
            cVar.doCancel();
        }
    }

    public void e() {
        if (!this.a.l) {
            dismiss();
        }
        d dVar = this.a.g;
        if (dVar != null) {
            dVar.doConfirm();
        }
    }

    public D f() {
        return this.c;
    }

    public int g() {
        return this.a.p;
    }

    @Override // dc.lf3
    public Context getKey() {
        return this.b;
    }

    public void h() {
        WearUtils.q2(this);
        this.d.setGravity(this.a.x);
        this.d.getDecorView().setPadding(0, 0, 0, 0);
        WindowManager.LayoutParams attributes = this.d.getAttributes();
        int i = this.a.u;
        if (i == 0) {
            attributes.width = ce3.a(getContext(), 311.0f);
        } else {
            attributes.width = i;
        }
        int i2 = this.a.v;
        if (i2 == 0) {
            attributes.height = -2;
        } else {
            attributes.height = i2;
        }
        this.d.setAttributes(attributes);
    }

    public void i() {
    }

    public final void j() {
        a aVar = this.a;
        if (aVar == null) {
            return;
        }
        TextView textView = (TextView) findViewById(aVar.s);
        if (textView != null) {
            textView.setText(this.a.c);
            textView.setHighlightColor(0);
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        }
        TextView textView2 = (TextView) findViewById(this.a.r);
        if (!TextUtils.isEmpty(this.a.d) && textView2 != null) {
            textView2.setText(this.a.d);
        }
        TextView textView3 = (TextView) findViewById(this.a.q);
        if (!TextUtils.isEmpty(this.a.e) && textView3 != null) {
            textView3.setText(this.a.e);
        }
        TextView textView4 = (TextView) findViewById(this.a.t);
        if (textView4 != null) {
            if (TextUtils.isEmpty(this.a.f)) {
                textView4.setVisibility(8);
            } else {
                textView4.setVisibility(0);
                textView4.setText(this.a.f);
            }
            textView4.setSingleLine(this.a.n);
        }
        if (textView2 != null) {
            textView2.setOnClickListener(new View.OnClickListener() { // from class: dc.pq3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.a.l(view);
                }
            });
            if (!this.a.o) {
                textView2.setVisibility(8);
                if (textView3 != null) {
                    ViewGroup.LayoutParams layoutParams = textView3.getLayoutParams();
                    layoutParams.width = ce3.a(this.b, 180.0f);
                    textView3.setLayoutParams(layoutParams);
                }
            }
        }
        if (textView3 != null) {
            textView3.setOnClickListener(new View.OnClickListener() { // from class: dc.oq3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.a.n(view);
                }
            });
        }
        setCanceledOnTouchOutside(this.a.k);
        setCancelable(this.a.j);
        a aVar2 = this.a;
        D d2 = (D) aVar2.b;
        if (d2 != null) {
            this.c = d2;
        }
        DialogInterface.OnDismissListener onDismissListener = aVar2.i;
        if (onDismissListener != null) {
            setOnDismissListener(onDismissListener);
        }
    }

    public void o(Runnable runnable) {
        if (Looper.myLooper() == this.e.getLooper()) {
            runnable.run();
        } else {
            this.e.post(runnable);
        }
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        pd3.j().n(this);
        setContentView(LayoutInflater.from(getContext()).inflate(g(), (ViewGroup) null));
        ButterKnife.bind(this);
        this.d = getWindow();
        h();
        j();
        i();
    }

    public void onDestroy() {
        dismiss();
    }

    @Override // android.app.Dialog
    public void show() {
        try {
            if (this.b != null) {
                super.show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public is3(Context context) {
        this(context, R.style.dialog);
    }
}
