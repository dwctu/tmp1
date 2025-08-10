package dc;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.lovense.wear.R;
import com.wear.util.WearUtils;

/* compiled from: CommonBottomDialog.java */
/* loaded from: classes4.dex */
public class wr3 extends Dialog {
    public String a;
    public String b;
    public String c;
    public String d;
    public a e;

    /* compiled from: CommonBottomDialog.java */
    public interface a {
        void a();

        void onCancel();
    }

    public wr3(@NonNull Context context, int i) {
        super(context, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void b(View view) {
        a aVar = this.e;
        if (aVar != null) {
            aVar.onCancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void d(View view) {
        a aVar = this.e;
        if (aVar != null) {
            aVar.a();
        }
    }

    public void e(a aVar) {
        this.e = aVar;
    }

    public void f(String str) {
        this.b = str;
    }

    public void g(String str) {
        this.c = str;
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        View viewInflate = LayoutInflater.from(getContext()).inflate(R.layout.dialog_common_bottom, (ViewGroup) null);
        setContentView(viewInflate);
        WearUtils.q2(this);
        getWindow().setGravity(80);
        getWindow().getDecorView().setPadding(0, 0, 0, 0);
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.width = -1;
        attributes.height = -1;
        getWindow().setAttributes(attributes);
        TextView textView = (TextView) viewInflate.findViewById(R.id.tv_title);
        TextView textView2 = (TextView) viewInflate.findViewById(R.id.tv_content);
        TextView textView3 = (TextView) viewInflate.findViewById(R.id.tv_ok);
        TextView textView4 = (TextView) viewInflate.findViewById(R.id.tv_cancel);
        if (TextUtils.isEmpty(this.a)) {
            textView.setVisibility(8);
        } else {
            textView.setText(this.a);
        }
        if (TextUtils.isEmpty(this.b)) {
            textView2.setVisibility(8);
        } else {
            textView2.setText(this.b);
        }
        if (!TextUtils.isEmpty(this.c)) {
            textView3.setText(this.c);
        }
        if (!TextUtils.isEmpty(this.d)) {
            textView4.setText(this.d);
        }
        viewInflate.findViewById(R.id.tv_cancel).setOnClickListener(new View.OnClickListener() { // from class: dc.vp3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.b(view);
            }
        });
        viewInflate.findViewById(R.id.tv_ok).setOnClickListener(new View.OnClickListener() { // from class: dc.up3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.d(view);
            }
        });
    }
}
