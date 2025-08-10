package dc;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.lovense.wear.R;
import com.wear.bean.Toy;
import com.wear.util.WearUtils;
import java.lang.reflect.InvocationTargetException;

/* compiled from: F01NoticePop.java */
/* loaded from: classes4.dex */
public class ds3 {
    public Context a;
    public PopupWindow b;
    public View c;
    public TextView d;
    public TextView e;
    public TextView f;
    public ImageView g;
    public LinearLayout h;
    public TextView i;
    public TextView j;
    public Toy k;

    /* compiled from: F01NoticePop.java */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ds3.this.b.dismiss();
        }
    }

    /* compiled from: F01NoticePop.java */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ds3.this.b.dismiss();
        }
    }

    /* compiled from: F01NoticePop.java */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            ds3.this.b.dismiss();
            eg3.k(WearUtils.x, eg3.a, 1);
        }
    }

    /* compiled from: F01NoticePop.java */
    public class d implements PopupWindow.OnDismissListener {
        public d() {
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            ds3.this.b(1.0f);
        }
    }

    public ds3(Context context, Toy toy) {
        this.a = context;
        this.k = toy;
        c();
    }

    public void b(float f) {
        try {
            WindowManager.LayoutParams attributes = ((Activity) this.a).getWindow().getAttributes();
            attributes.alpha = f;
            if (f == 1.0f) {
                ((Activity) this.a).getWindow().clearFlags(2);
            } else {
                ((Activity) this.a).getWindow().addFlags(2);
            }
            ((Activity) this.a).getWindow().setAttributes(attributes);
        } catch (Exception e) {
            e.printStackTrace();
            FirebaseCrashlytics.getInstance().recordException(e);
        }
    }

    public void c() {
        try {
            this.b = new PopupWindow(this.a);
            View viewInflate = LayoutInflater.from(this.a).inflate(R.layout.dialog_f01_gif, (ViewGroup) null);
            this.c = viewInflate;
            TextView textView = (TextView) viewInflate.findViewById(R.id.tv_title);
            this.d = textView;
            Toy toy = this.k;
            if (toy != null) {
                textView.setText(toy.getFullName());
            }
            this.g = (ImageView) this.c.findViewById(R.id.iv_gif);
            this.e = (TextView) this.c.findViewById(R.id.tv_notice);
            this.f = (TextView) this.c.findViewById(R.id.done);
            this.h = (LinearLayout) this.c.findViewById(R.id.ll_connect_again);
            this.i = (TextView) this.c.findViewById(R.id.tv_connect_again);
            this.j = (TextView) this.c.findViewById(R.id.tv_connect_done);
            this.f.setOnClickListener(new a());
            this.j.setOnClickListener(new b());
            this.i.setOnClickListener(new c());
            this.b.setContentView(this.c);
            this.b.setFocusable(true);
            this.b.setBackgroundDrawable(new ColorDrawable(0));
            this.b.setOutsideTouchable(true);
            this.b.setWidth(-2);
            this.b.setHeight(-2);
            this.b.setOnDismissListener(new d());
        } catch (Exception e) {
            e.printStackTrace();
            FirebaseCrashlytics.getInstance().recordException(e);
        }
    }

    public void d(String str, boolean z) {
        try {
            if (this.b != null) {
                Context context = this.a;
                if (!(context instanceof Activity) || ((Activity) context).isFinishing() || this.b.isShowing()) {
                    return;
                }
                b(0.7f);
                if (z) {
                    this.h.setVisibility(0);
                    this.f.setVisibility(8);
                } else {
                    this.h.setVisibility(8);
                    this.f.setVisibility(0);
                }
                this.e.setText(String.format(ah4.e(R.string.f01_notice), uu1.a(str, 1)));
                kf.w(this.a).q(th4.d(this.a, R.drawable.f01_notice)).a(qo.r0(ii.b)).A0(this.g);
                this.b.showAtLocation(this.c, 17, 0, 0);
                this.b.setAnimationStyle(-1);
            }
        } catch (Exception e) {
            e.printStackTrace();
            FirebaseCrashlytics.getInstance().recordException(e);
        }
    }
}
