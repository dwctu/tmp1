package com.wear.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.lovense.wear.R;
import com.wear.util.MyApplication;
import dc.ah4;
import dc.ye3;

/* loaded from: classes4.dex */
public class ControlLinkNewTipDialog extends BottomDialog {
    public static long e;
    public Context c;

    @BindView(R.id.cancel_btn)
    public TextView cancelBtn;
    public final String d;

    @BindView(R.id.iv_guide)
    public ImageView mIivGuide;

    @BindView(R.id.ll_tips_get_tophy)
    public LinearLayout mLlTipsGetTophy;

    @BindView(R.id.ll_tips_goto_discord)
    public LinearLayout mLlTipsGotoDiscord;

    @BindView(R.id.ok_btn)
    public TextView okBtn;

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (System.currentTimeMillis() - ControlLinkNewTipDialog.e < 500) {
                return;
            }
            long unused = ControlLinkNewTipDialog.e = System.currentTimeMillis();
            ControlLinkNewTipDialog.this.cancel();
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ControlLinkNewTipDialog.this.cancel();
            ControlLinkNewTipDialog controlLinkNewTipDialog = ControlLinkNewTipDialog.this;
            MyApplication.y0(controlLinkNewTipDialog.c, controlLinkNewTipDialog.d);
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ControlLinkNewTipDialog.this.cancel();
            MyApplication.y0(ControlLinkNewTipDialog.this.c, "https://play.google.com/store/apps/details?id=com.tophy.android");
            ye3.h(2);
        }
    }

    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ControlLinkNewTipDialog.this.cancel();
            MyApplication.y0(ControlLinkNewTipDialog.this.c, "https://discord.gg/lovense");
            ye3.h(3);
        }
    }

    public ControlLinkNewTipDialog(Context context) {
        super(context);
        this.d = ah4.e(R.string.control_link_tip_url);
        this.c = context;
    }

    @Override // com.wear.widget.BottomDialog
    public View b() {
        return LayoutInflater.from(this.c).inflate(R.layout.dialog_tip_control_link_new, (ViewGroup) null);
    }

    @Override // com.wear.widget.BottomDialog
    public void c(View view) {
        ButterKnife.bind(this, view);
        this.cancelBtn.setOnClickListener(new a());
        this.mIivGuide.setOnClickListener(new b());
        this.mLlTipsGetTophy.setOnClickListener(new c());
        this.mLlTipsGotoDiscord.setOnClickListener(new d());
    }
}
