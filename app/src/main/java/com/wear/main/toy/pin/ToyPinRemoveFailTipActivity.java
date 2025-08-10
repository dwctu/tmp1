package com.wear.main.toy.pin;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.lovense.wear.R;
import com.wear.BaseActivity;
import com.wear.bean.Toy;
import com.wear.util.WearUtils;
import dc.pc1;

/* loaded from: classes3.dex */
public class ToyPinRemoveFailTipActivity extends BaseActivity {
    public String a;
    public Toy b;
    public pc1 c;

    @BindView(R.id.iv_close)
    public ImageView ivClose;

    @BindView(R.id.tip_1_ok)
    public TextView tip1Ok;

    @BindView(R.id.toy_icon)
    public ImageView toyIcon;

    @BindView(R.id.toy_name)
    public TextView toyName;

    @BindView(R.id.toy_pin_tip_1)
    public LinearLayout toyPinTip1;

    @BindView(R.id.toy_pin_tip_text_1)
    public TextView toyPinTipText1;

    @BindView(R.id.toy_pin_tip_view)
    public View toyPinTipView;

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ToyPinRemoveFailTipActivity.this.finish();
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ToyPinRemoveFailTipActivity.this.finish();
        }
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_toy_pin_remove_fail_tip);
        ButterKnife.bind(this);
        this.a = getIntent().getStringExtra("toyId");
        pc1 pc1VarG = WearUtils.x.G();
        this.c = pc1VarG;
        Toy toyQ = pc1VarG.Q(this.a);
        this.b = toyQ;
        if (toyQ == null) {
            finish();
            return;
        }
        this.toyIcon.setImageResource(Toy.getToyIconLinkedId(toyQ.getType(), 0, false));
        if (WearUtils.e1(this.b.getDefineRename())) {
            this.toyName.setText(this.b.getSimpleName());
        } else {
            this.toyName.setText(this.b.getSimpleName() + " · " + this.b.getDefineRename());
        }
        this.ivClose.setOnClickListener(new a());
        this.toyPinTip1.setVisibility(0);
        this.tip1Ok.setOnClickListener(new b());
    }
}
