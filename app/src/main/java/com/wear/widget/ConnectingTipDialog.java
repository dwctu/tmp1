package com.wear.widget;

import android.content.Context;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatDialog;
import com.lovense.wear.R;
import com.wear.util.MyApplication;
import dc.ah4;

/* loaded from: classes4.dex */
public class ConnectingTipDialog extends AppCompatDialog {
    public Context a;
    public View b;

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ConnectingTipDialog.this.cancel();
        }
    }

    public class b extends ClickableSpan {
        public b() {
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            MyApplication.y0(ConnectingTipDialog.this.a, ah4.e(R.string.toy_connection_tip_link));
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@NonNull TextPaint textPaint) {
            super.updateDrawState(textPaint);
            textPaint.setColor(ConnectingTipDialog.this.a.getResources().getColor(R.color.color_accent));
            textPaint.setUnderlineText(true);
            textPaint.clearShadowLayer();
        }
    }

    public class c implements Animation.AnimationListener {
        public c() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            ConnectingTipDialog.this.dismiss();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    public ConnectingTipDialog(Context context) {
        super(context, R.style.newBottomDialog);
        this.a = context;
    }

    public void a() {
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(new AlphaAnimation(1.0f, 0.0f));
        animationSet.addAnimation(new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, 1.0f));
        animationSet.setInterpolator(new AccelerateInterpolator());
        animationSet.setDuration(200L);
        animationSet.setFillAfter(true);
        animationSet.setAnimationListener(new c());
        this.b.setAnimation(animationSet);
        setContentView(this.b);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void cancel() {
        a();
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().getDecorView().setPadding(0, 0, 0, 0);
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.height = -2;
        attributes.width = -1;
        attributes.gravity = 81;
        getWindow().setAttributes(attributes);
        this.b = LayoutInflater.from(this.a).inflate(R.layout.dialog_connecting_tip, (ViewGroup) null);
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(new AlphaAnimation(0.0f, 1.0f));
        animationSet.addAnimation(new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f));
        animationSet.setInterpolator(new AccelerateInterpolator());
        animationSet.setDuration(200L);
        animationSet.setFillAfter(true);
        this.b.setAnimation(animationSet);
        ((ImageView) this.b.findViewById(R.id.close)).setOnClickListener(new a());
        TextView textView = (TextView) this.b.findViewById(R.id.description);
        String strE = ah4.e(R.string.clickable_here);
        String str = String.format(ah4.e(R.string.toy_connection_tip_des), "7", strE);
        SpannableString spannableString = new SpannableString(str);
        int iIndexOf = str.indexOf(strE);
        if (iIndexOf != -1) {
            spannableString.setSpan(new b(), iIndexOf, strE.length() + iIndexOf, 17);
        }
        textView.setText(spannableString);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setHighlightColor(0);
        setContentView(this.b);
    }
}
