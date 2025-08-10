package com.wear.widget.dialog;

import android.content.Context;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.lovense.wear.R;
import com.wear.bean.CheckProtocolBean;
import com.wear.bean.CheckProtocolData;
import com.wear.widget.dialog.CustomBottomSheetDialog;
import dc.ah4;
import dc.kf;
import dc.lg3;
import dc.pj3;
import dc.wg3;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: XRemotePolicyPop.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0004\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u0010\u0010*\u001a\u00020\u001c2\u0006\u0010+\u001a\u00020%H\u0007J\b\u0010,\u001a\u00020\u001cH\u0002J\u0010\u0010-\u001a\u00020\u001c2\u0006\u0010.\u001a\u00020/H\u0002J&\u00100\u001a\u00020\u001c2\u000e\u00101\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001b2\u000e\u00102\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001bR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u00020\u000b8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0013\u001a\u00020\u00148\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u001e\u001a\u00020\u000b8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\r\"\u0004\b \u0010\u000fR\u001e\u0010!\u001a\u00020\u000b8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\r\"\u0004\b#\u0010\u000fR\u001e\u0010$\u001a\u00020%8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)¨\u00063"}, d2 = {"Lcom/wear/widget/dialog/XRemotePolicyPop;", "Lcom/wear/widget/dialog/CustomBottomSheetDialog;", "context", "Landroid/content/Context;", "applicationIcon", "", "applicationName", "checkProtocolData", "Lcom/wear/bean/CheckProtocolBean;", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Lcom/wear/bean/CheckProtocolBean;)V", "btnAllow", "Landroid/widget/TextView;", "getBtnAllow", "()Landroid/widget/TextView;", "setBtnAllow", "(Landroid/widget/TextView;)V", "btnCancel", "getBtnCancel", "setBtnCancel", "ivAppIcon", "Landroid/widget/ImageView;", "getIvAppIcon", "()Landroid/widget/ImageView;", "setIvAppIcon", "(Landroid/widget/ImageView;)V", "mContext", "onCancelListener", "Lkotlin/Function0;", "", "onClickAllowListener", "tvAppName", "getTvAppName", "setTvAppName", "tvPrivacyContent", "getTvPrivacyContent", "setTvPrivacyContent", "vPlaceholder", "Landroid/view/View;", "getVPlaceholder", "()Landroid/view/View;", "setVPlaceholder", "(Landroid/view/View;)V", "doClick", "view", "initView", "setBackgroundAlpha", "bgAlpha", "", "setOnClickListener", "onClickAllow", "onCancel", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public final class XRemotePolicyPop extends CustomBottomSheetDialog {

    @Nullable
    public final String b;

    @BindView(R.id.btn_allow)
    public TextView btnAllow;

    @BindView(R.id.btn_cancel)
    public TextView btnCancel;

    @Nullable
    public final String c;

    @Nullable
    public final CheckProtocolBean d;

    @Nullable
    public Function0<Unit> e;

    @Nullable
    public Function0<Unit> f;

    @NotNull
    public final Context g;

    @BindView(R.id.iv_app_icon)
    public ImageView ivAppIcon;

    @BindView(R.id.tv_app_name)
    public TextView tvAppName;

    @BindView(R.id.tv_privacy_content)
    public TextView tvPrivacyContent;

    @BindView(R.id.v_placeholder)
    public View vPlaceholder;

    /* compiled from: XRemotePolicyPop.kt */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/wear/widget/dialog/XRemotePolicyPop$1", "Lcom/wear/widget/dialog/CustomBottomSheetDialog$OnOrientationChangeListener;", "onOrientationChange", "", "orientation", "", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a implements CustomBottomSheetDialog.a {
        public a() {
        }

        @Override // com.wear.widget.dialog.CustomBottomSheetDialog.a
        public void a(int i) {
            XRemotePolicyPop.this.j().setVisibility(i == 2 ? 0 : 8);
        }
    }

    /* compiled from: XRemotePolicyPop.kt */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"com/wear/widget/dialog/XRemotePolicyPop$initView$provacyClickableSpan$1", "Landroid/text/style/ClickableSpan;", "onClick", "", "widget", "Landroid/view/View;", "updateDrawState", "ds", "Landroid/text/TextPaint;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class b extends ClickableSpan {
        public b() {
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NotNull View widget) {
            CheckProtocolData data;
            CheckProtocolData data2;
            Intrinsics.checkNotNullParameter(widget, "widget");
            CheckProtocolBean checkProtocolBean = XRemotePolicyPop.this.d;
            String protocolUrl = null;
            String protocolUrl2 = (checkProtocolBean == null || (data2 = checkProtocolBean.getData()) == null) ? null : data2.getProtocolUrl();
            if (protocolUrl2 == null || protocolUrl2.length() == 0) {
                return;
            }
            String strC = lg3.c(lg3.e(XRemotePolicyPop.this.g));
            StringBuilder sb = new StringBuilder();
            CheckProtocolBean checkProtocolBean2 = XRemotePolicyPop.this.d;
            if (checkProtocolBean2 != null && (data = checkProtocolBean2.getData()) != null) {
                protocolUrl = data.getProtocolUrl();
            }
            sb.append(protocolUrl);
            sb.append("?pf=");
            sb.append(wg3.a());
            sb.append("&lang=");
            sb.append(strC);
            String string = sb.toString();
            String str = "协议URL====" + string;
            pj3.w(XRemotePolicyPop.this.g, string);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@NotNull TextPaint ds) {
            Intrinsics.checkNotNullParameter(ds, "ds");
            super.updateDrawState(ds);
            ds.setColor(XRemotePolicyPop.this.g.getResources().getColor(R.color.color_accent));
            ds.setUnderlineText(false);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public XRemotePolicyPop(@NotNull Context context, @Nullable String str, @Nullable String str2, @Nullable CheckProtocolBean checkProtocolBean) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.b = str;
        this.c = str2;
        this.d = checkProtocolBean;
        this.g = context;
        k();
        d(new a());
    }

    @OnClick({R.id.btn_cancel, R.id.btn_allow})
    public final void doClick(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        int id = view.getId();
        if (id == R.id.btn_allow) {
            Function0<Unit> function0 = this.e;
            if (function0 != null) {
                function0.invoke();
                return;
            }
            return;
        }
        if (id != R.id.btn_cancel) {
            return;
        }
        dismiss();
        Function0<Unit> function02 = this.f;
        if (function02 != null) {
            function02.invoke();
        }
    }

    @NotNull
    public final ImageView g() {
        ImageView imageView = this.ivAppIcon;
        if (imageView != null) {
            return imageView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("ivAppIcon");
        return null;
    }

    @NotNull
    public final TextView h() {
        TextView textView = this.tvAppName;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("tvAppName");
        return null;
    }

    @NotNull
    public final TextView i() {
        TextView textView = this.tvPrivacyContent;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("tvPrivacyContent");
        return null;
    }

    @NotNull
    public final View j() {
        View view = this.vPlaceholder;
        if (view != null) {
            return view;
        }
        Intrinsics.throwUninitializedPropertyAccessException("vPlaceholder");
        return null;
    }

    public final void k() {
        View viewInflate = LayoutInflater.from(this.g).inflate(R.layout.pop_xremote_policy, (ViewGroup) null);
        setContentView(viewInflate);
        ButterKnife.bind(this, viewInflate);
        h().setText(this.c);
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String strE = ah4.e(R.string.gallery_developer_privacy_content2);
        Intrinsics.checkNotNullExpressionValue(strE, "getString(R.string.galle…veloper_privacy_content2)");
        String str = String.format(strE, Arrays.copyOf(new Object[]{this.c}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
        String str2 = "contentStr====" + str;
        String strE2 = ah4.e(R.string.gallery_developer_privacy_content1);
        Intrinsics.checkNotNullExpressionValue(strE2, "getString(R.string.galle…veloper_privacy_content1)");
        String str3 = String.format(strE2, Arrays.copyOf(new Object[]{str}, 1));
        Intrinsics.checkNotNullExpressionValue(str3, "format(format, *args)");
        SpannableString spannableString = new SpannableString(str3);
        int iIndexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) str3, str, 0, false, 6, (Object) null);
        if (iIndexOf$default != -1) {
            b bVar = new b();
            String str4 = "contentStrLength====" + (str.length() - 1);
            spannableString.setSpan(bVar, iIndexOf$default, str.length() + iIndexOf$default, 17);
        }
        i().setMovementMethod(LinkMovementMethod.getInstance());
        i().setText(spannableString);
        kf.w(this.g).v(this.b).A0(g());
    }

    public final void l(@Nullable Function0<Unit> function0, @Nullable Function0<Unit> function02) {
        this.e = function0;
        this.f = function02;
    }
}
