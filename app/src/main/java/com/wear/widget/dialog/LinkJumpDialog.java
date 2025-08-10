package com.wear.widget.dialog;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import androidx.appcompat.app.AppCompatDialog;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.lovense.wear.R;
import com.wear.util.MyApplication;
import dc.sg3;
import java.util.Locale;

/* loaded from: classes4.dex */
public class LinkJumpDialog extends AppCompatDialog {
    public String a;
    public b b;
    public Activity c;

    @BindView(R.id.cancel_button)
    public AppCompatButton cancelButton;

    @BindView(R.id.confirm_button)
    public AppCompatButton confirmButton;

    @BindView(R.id.link)
    public AppCompatTextView link;

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            LinkJumpDialog.this.dismiss();
        }
    }

    public interface b {
        void a(String str);
    }

    public LinkJumpDialog(Activity activity) {
        super(activity, R.style.Fulldialog);
        a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void c(View view) {
        if (this.a.contains("ftp")) {
            sg3.l("This link is not supported");
            return;
        }
        String str = this.a;
        Locale locale = Locale.ENGLISH;
        if (!str.toLowerCase(locale).contains("http://") && !this.a.toLowerCase(locale).contains("https://")) {
            this.a = "https://" + this.a;
        }
        String lowerCase = this.a.toLowerCase(locale);
        this.a = lowerCase;
        b bVar = this.b;
        if (bVar != null) {
            bVar.a(lowerCase);
        } else {
            MyApplication.y0(this.c, lowerCase);
        }
        dismiss();
    }

    public final void a() {
        View viewInflate = LayoutInflater.from(getContext()).inflate(R.layout.dialog_link_jump, (ViewGroup) null);
        ButterKnife.bind(this, viewInflate);
        setContentView(viewInflate);
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.width = -1;
        attributes.height = -1;
        getWindow().setAttributes(attributes);
        setCancelable(false);
        setCanceledOnTouchOutside(false);
        this.confirmButton.setOnClickListener(new View.OnClickListener() { // from class: dc.lq3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.c(view);
            }
        });
        this.cancelButton.setOnClickListener(new a());
    }

    public void d(String str) {
        this.a = str;
        this.link.setText(str);
        super.show();
    }

    public LinkJumpDialog(Activity activity, b bVar) {
        this(activity);
        this.c = activity;
        this.b = bVar;
    }
}
