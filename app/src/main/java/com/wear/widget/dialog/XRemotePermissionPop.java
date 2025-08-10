package com.wear.widget.dialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.lovense.wear.R;
import com.wear.widget.dialog.CustomBottomSheetDialog;
import dc.kf;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: XRemotePermissionPop.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\bJ\u0010\u0010,\u001a\u00020\u001b2\u0006\u0010-\u001a\u00020'H\u0007J\b\u0010.\u001a\u00020\u001bH\u0002J&\u0010/\u001a\u00020\u001b2\u000e\u00100\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001a2\u000e\u00101\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001aR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\n8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0012\u001a\u00020\u00138\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u001d\u001a\u00020\n8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\f\"\u0004\b\u001f\u0010\u000eR\u001e\u0010 \u001a\u00020\n8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\f\"\u0004\b\"\u0010\u000eR\u001e\u0010#\u001a\u00020\n8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\f\"\u0004\b%\u0010\u000eR\u001e\u0010&\u001a\u00020'8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+¨\u00062"}, d2 = {"Lcom/wear/widget/dialog/XRemotePermissionPop;", "Lcom/wear/widget/dialog/CustomBottomSheetDialog;", "context", "Landroid/content/Context;", "applicationIcon", "", "applicationName", FirebaseAnalytics.Param.CONTENT, "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "btnAllow", "Landroid/widget/TextView;", "getBtnAllow", "()Landroid/widget/TextView;", "setBtnAllow", "(Landroid/widget/TextView;)V", "btnCancel", "getBtnCancel", "setBtnCancel", "ivAppIcon", "Landroid/widget/ImageView;", "getIvAppIcon", "()Landroid/widget/ImageView;", "setIvAppIcon", "(Landroid/widget/ImageView;)V", "mContext", "onCancelListener", "Lkotlin/Function0;", "", "onClickAllowListener", "tvAppName", "getTvAppName", "setTvAppName", "tvPrivacyContent", "getTvPrivacyContent", "setTvPrivacyContent", "tvPrivacyTitle", "getTvPrivacyTitle", "setTvPrivacyTitle", "vPlaceholder", "Landroid/view/View;", "getVPlaceholder", "()Landroid/view/View;", "setVPlaceholder", "(Landroid/view/View;)V", "doClick", "view", "initView", "setOnClickListener", "onClickAllow", "onCancel", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public final class XRemotePermissionPop extends CustomBottomSheetDialog {

    @Nullable
    public final String b;

    @BindView(R.id.btn_allow)
    public TextView btnAllow;

    @BindView(R.id.btn_cancel)
    public TextView btnCancel;

    @Nullable
    public final String c;

    @Nullable
    public final String d;

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

    @BindView(R.id.tv_privacy_title)
    public TextView tvPrivacyTitle;

    @BindView(R.id.v_placeholder)
    public View vPlaceholder;

    /* compiled from: XRemotePermissionPop.kt */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/wear/widget/dialog/XRemotePermissionPop$1", "Lcom/wear/widget/dialog/CustomBottomSheetDialog$OnOrientationChangeListener;", "onOrientationChange", "", "orientation", "", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a implements CustomBottomSheetDialog.a {
        public a() {
        }

        @Override // com.wear.widget.dialog.CustomBottomSheetDialog.a
        public void a(int i) {
            XRemotePermissionPop.this.i().setVisibility(i == 2 ? 0 : 8);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public XRemotePermissionPop(@NotNull Context context, @Nullable String str, @Nullable String str2, @Nullable String str3) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.g = context;
        j();
        d(new a());
    }

    @OnClick({R.id.btn_cancel, R.id.btn_allow})
    public final void doClick(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        int id = view.getId();
        if (id == R.id.btn_allow) {
            dismiss();
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
    public final ImageView e() {
        ImageView imageView = this.ivAppIcon;
        if (imageView != null) {
            return imageView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("ivAppIcon");
        return null;
    }

    @NotNull
    public final TextView f() {
        TextView textView = this.tvAppName;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("tvAppName");
        return null;
    }

    @NotNull
    public final TextView g() {
        TextView textView = this.tvPrivacyContent;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("tvPrivacyContent");
        return null;
    }

    @NotNull
    public final TextView h() {
        TextView textView = this.tvPrivacyTitle;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("tvPrivacyTitle");
        return null;
    }

    @NotNull
    public final View i() {
        View view = this.vPlaceholder;
        if (view != null) {
            return view;
        }
        Intrinsics.throwUninitializedPropertyAccessException("vPlaceholder");
        return null;
    }

    public final void j() {
        View viewInflate = LayoutInflater.from(this.g).inflate(R.layout.pop_xremote_policy, (ViewGroup) null);
        setContentView(viewInflate);
        setCanceledOnTouchOutside(false);
        ButterKnife.bind(this, viewInflate);
        f().setText(this.c);
        h().setText(this.d);
        g().setVisibility(8);
        kf.w(this.g).v(this.b).A0(e());
    }

    public final void k(@Nullable Function0<Unit> function0, @Nullable Function0<Unit> function02) {
        this.e = function0;
        this.f = function02;
    }
}
