package dc;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.lovense.wear.R;

/* compiled from: F01ReadyNoticePop.java */
/* loaded from: classes4.dex */
public class es3 {
    public Context a;
    public PopupWindow b;
    public View c;
    public TextView d;
    public TextView e;

    /* compiled from: F01ReadyNoticePop.java */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            es3.this.b.dismiss();
        }
    }

    /* compiled from: F01ReadyNoticePop.java */
    public class b implements PopupWindow.OnDismissListener {
        public b() {
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            es3.this.b(1.0f);
        }
    }

    public es3(Context context) {
        this.a = context;
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
            View viewInflate = LayoutInflater.from(this.a).inflate(R.layout.dialog_f01_notice, (ViewGroup) null);
            this.c = viewInflate;
            this.d = (TextView) viewInflate.findViewById(R.id.tv_notice);
            TextView textView = (TextView) this.c.findViewById(R.id.done);
            this.e = textView;
            textView.setOnClickListener(new a());
            this.b.setContentView(this.c);
            this.b.setFocusable(true);
            this.b.setBackgroundDrawable(new ColorDrawable(0));
            this.b.setOutsideTouchable(true);
            this.b.setWidth(-2);
            this.b.setHeight(-2);
            this.b.setOnDismissListener(new b());
        } catch (Exception e) {
            e.printStackTrace();
            FirebaseCrashlytics.getInstance().recordException(e);
        }
    }

    public void d(String str) {
        try {
            if (this.b != null) {
                Context context = this.a;
                if (!(context instanceof Activity) || ((Activity) context).isFinishing() || this.b.isShowing()) {
                    return;
                }
                b(0.7f);
                this.d.setText(String.format(ah4.e(R.string.f01_ready_notice), str));
                this.b.showAtLocation(this.c, 17, 0, 0);
                this.b.setAnimationStyle(-1);
            }
        } catch (Exception e) {
            e.printStackTrace();
            FirebaseCrashlytics.getInstance().recordException(e);
        }
    }
}
