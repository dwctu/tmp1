package dc;

import android.app.Application;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/* compiled from: SystemToast.java */
/* loaded from: classes2.dex */
public class a71 extends Toast implements i71 {
    public TextView a;

    public a71(Application application) {
        super(application);
    }

    @Override // dc.i71
    public /* synthetic */ TextView a(View view) {
        return h71.a(this, view);
    }

    @Override // android.widget.Toast, dc.i71
    public void setText(CharSequence charSequence) {
        super.setText(charSequence);
        TextView textView = this.a;
        if (textView == null) {
            return;
        }
        textView.setText(charSequence);
    }

    @Override // android.widget.Toast, dc.i71
    public void setView(View view) {
        super.setView(view);
        if (view == null) {
            this.a = null;
        } else {
            this.a = a(view);
        }
    }
}
