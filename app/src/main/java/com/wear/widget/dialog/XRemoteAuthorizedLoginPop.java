package com.wear.widget.dialog;

import android.content.Context;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.lovense.wear.R;
import com.wear.bean.Account;
import com.wear.bean.XRemoteAppUserBean;
import com.wear.ui.discover.xremote.adapter.XRemoteUserAdapter;
import com.wear.widget.dialog.CustomBottomSheetDialog;
import dc.ah4;
import dc.ce3;
import dc.ch3;
import dc.eg3;
import dc.kf;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: XRemoteAuthorizedLoginPop.kt */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0010\u00107\u001a\u00020$2\u0006\u00108\u001a\u000209H\u0007J\b\u0010:\u001a\u00020$H\u0002J\u000e\u0010;\u001a\u00020$2\u0006\u0010<\u001a\u000200J\u0010\u0010=\u001a\u00020$2\u0006\u0010>\u001a\u00020?H\u0002J<\u0010@\u001a\u00020$2\u000e\u0010A\u001a\n\u0012\u0004\u0012\u00020$\u0018\u00010#2\u0014\u0010B\u001a\u0010\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020$\u0018\u00010&2\u000e\u0010C\u001a\n\u0012\u0004\u0012\u00020$\u0018\u00010#J\u0010\u0010D\u001a\u00020$2\u0006\u0010E\u001a\u000200H\u0002J\b\u0010F\u001a\u00020$H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\n8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001e\u0010\u0012\u001a\u00020\n8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0015\u001a\u00020\u00168\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001e\u0010\u001b\u001a\u00020\u001c8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u000e\u0010!\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\"\u001a\n\u0012\u0004\u0012\u00020$\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010%\u001a\u0010\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020$\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010(\u001a\n\u0012\u0004\u0012\u00020$\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010)\u001a\u00020*8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u000e\u0010/\u001a\u000200X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u00101\u001a\u00020\n8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\f\"\u0004\b3\u0010\u000eR\u001e\u00104\u001a\u00020\n8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\f\"\u0004\b6\u0010\u000e¨\u0006G"}, d2 = {"Lcom/wear/widget/dialog/XRemoteAuthorizedLoginPop;", "Lcom/wear/widget/dialog/CustomBottomSheetDialog;", "context", "Landroid/content/Context;", "appAccountId", "", "dataBean", "Lcom/wear/bean/XRemoteAppUserBean$DataBean;", "(Landroid/content/Context;Ljava/lang/String;Lcom/wear/bean/XRemoteAppUserBean$DataBean;)V", "btnAllow", "Landroid/widget/TextView;", "getBtnAllow", "()Landroid/widget/TextView;", "setBtnAllow", "(Landroid/widget/TextView;)V", "btnCancel", "getBtnCancel", "setBtnCancel", "btnUserCustomName", "getBtnUserCustomName", "setBtnUserCustomName", "ivAppIcon", "Landroid/widget/ImageView;", "getIvAppIcon", "()Landroid/widget/ImageView;", "setIvAppIcon", "(Landroid/widget/ImageView;)V", "llBottom", "Landroid/widget/LinearLayout;", "getLlBottom", "()Landroid/widget/LinearLayout;", "setLlBottom", "(Landroid/widget/LinearLayout;)V", "mContext", "onCancelListener", "Lkotlin/Function0;", "", "onClickAllowListener", "Lkotlin/Function1;", "Lcom/wear/bean/XRemoteAppUserBean$DataBean$ApplicationAccount;", "onClickUseCustomNameListener", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "setRecyclerView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "selectItemIndex", "", "tvAppName", "getTvAppName", "setTvAppName", "tvUserTip", "getTvUserTip", "setTvUserTip", "doClick", "view", "Landroid/view/View;", "initView", "notifyDataInserted", "pos", "setBackgroundAlpha", "bgAlpha", "", "setOnClickListener", "onClickUseCustomName", "onClickAllow", "onCancel", "updateLLBottomParams", "orientation", "updateUseCustomNameBtnVisible", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public final class XRemoteAuthorizedLoginPop extends CustomBottomSheetDialog {

    @Nullable
    public final String b;

    @BindView(R.id.btn_allow)
    public TextView btnAllow;

    @BindView(R.id.btn_cancel)
    public TextView btnCancel;

    @BindView(R.id.btn_user_custom_name)
    public TextView btnUserCustomName;

    @Nullable
    public final XRemoteAppUserBean.DataBean c;

    @Nullable
    public Function0<Unit> d;

    @Nullable
    public Function1<? super XRemoteAppUserBean.DataBean.ApplicationAccount, Unit> e;

    @Nullable
    public Function0<Unit> f;

    @NotNull
    public final Context g;
    public int h;

    @BindView(R.id.iv_app_icon)
    public ImageView ivAppIcon;

    @BindView(R.id.ll_bottom)
    public LinearLayout llBottom;

    @BindView(R.id.recycler_view)
    public RecyclerView recyclerView;

    @BindView(R.id.tv_app_name)
    public TextView tvAppName;

    @BindView(R.id.tv_user_tip)
    public TextView tvUserTip;

    /* compiled from: XRemoteAuthorizedLoginPop.kt */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/wear/widget/dialog/XRemoteAuthorizedLoginPop$1", "Lcom/wear/widget/dialog/CustomBottomSheetDialog$OnOrientationChangeListener;", "onOrientationChange", "", "orientation", "", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a implements CustomBottomSheetDialog.a {
        public a() {
        }

        @Override // com.wear.widget.dialog.CustomBottomSheetDialog.a
        public void a(int i) {
            if (XRemoteAuthorizedLoginPop.this.i().getAdapter() instanceof XRemoteUserAdapter) {
                RecyclerView.Adapter adapter = XRemoteAuthorizedLoginPop.this.i().getAdapter();
                Intrinsics.checkNotNull(adapter, "null cannot be cast to non-null type com.wear.ui.discover.xremote.adapter.XRemoteUserAdapter");
                ((XRemoteUserAdapter) adapter).C(i);
            }
            XRemoteAuthorizedLoginPop.this.o(i);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public XRemoteAuthorizedLoginPop(@NotNull Context context, @Nullable String str, @Nullable XRemoteAppUserBean.DataBean dataBean) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.b = str;
        this.c = dataBean;
        this.g = context;
        l();
        d(new a());
    }

    @OnClick({R.id.btn_user_custom_name, R.id.btn_cancel, R.id.btn_allow})
    public final void doClick(@NotNull View view) {
        List<XRemoteAppUserBean.DataBean.ApplicationAccount> applicationAccountList;
        Function0<Unit> function0;
        Intrinsics.checkNotNullParameter(view, "view");
        int id = view.getId();
        if (id != R.id.btn_allow) {
            if (id != R.id.btn_cancel) {
                if (id == R.id.btn_user_custom_name && (function0 = this.d) != null) {
                    function0.invoke();
                    return;
                }
                return;
            }
            dismiss();
            Function0<Unit> function02 = this.f;
            if (function02 != null) {
                function02.invoke();
                return;
            }
            return;
        }
        XRemoteAppUserBean.DataBean dataBean = this.c;
        if (dataBean != null && (applicationAccountList = dataBean.getApplicationAccountList()) != null) {
            RecyclerView.Adapter adapter = i().getAdapter();
            Intrinsics.checkNotNull(adapter, "null cannot be cast to non-null type com.wear.ui.discover.xremote.adapter.XRemoteUserAdapter");
            int j = ((XRemoteUserAdapter) adapter).getJ();
            if (applicationAccountList.size() > j) {
                XRemoteAppUserBean.DataBean.ApplicationAccount applicationAccount = applicationAccountList.get(j);
                Function1<? super XRemoteAppUserBean.DataBean.ApplicationAccount, Unit> function1 = this.e;
                if (function1 != null) {
                    function1.invoke(applicationAccount);
                }
                Context context = this.g;
                StringBuilder sb = new StringBuilder();
                XRemoteAppUserBean.DataBean.Application application = this.c.getApplication();
                sb.append(application != null ? application.getApplicationInfo() : null);
                sb.append('_');
                Account accountU = ch3.n().u();
                sb.append(accountU != null ? accountU.getId() : null);
                eg3.i(context, sb.toString(), applicationAccount.getApplicationAccountId() + '_' + System.currentTimeMillis());
            }
        }
        dismiss();
    }

    @NotNull
    public final TextView f() {
        TextView textView = this.btnUserCustomName;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("btnUserCustomName");
        return null;
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
    public final LinearLayout h() {
        LinearLayout linearLayout = this.llBottom;
        if (linearLayout != null) {
            return linearLayout;
        }
        Intrinsics.throwUninitializedPropertyAccessException("llBottom");
        return null;
    }

    @NotNull
    public final RecyclerView i() {
        RecyclerView recyclerView = this.recyclerView;
        if (recyclerView != null) {
            return recyclerView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        return null;
    }

    @NotNull
    public final TextView j() {
        TextView textView = this.tvAppName;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("tvAppName");
        return null;
    }

    @NotNull
    public final TextView k() {
        TextView textView = this.tvUserTip;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("tvUserTip");
        return null;
    }

    public final void l() {
        XRemoteAppUserBean.DataBean.Application application;
        XRemoteAppUserBean.DataBean dataBean;
        List<XRemoteAppUserBean.DataBean.ApplicationAccount> applicationAccountList;
        View viewInflate = LayoutInflater.from(this.g).inflate(R.layout.pop_xremote_authorized_login, (ViewGroup) null);
        setContentView(viewInflate);
        ButterKnife.bind(this, viewInflate);
        String str = this.b;
        if (!(str == null || str.length() == 0) && (dataBean = this.c) != null && (applicationAccountList = dataBean.getApplicationAccountList()) != null) {
            Iterator<XRemoteAppUserBean.DataBean.ApplicationAccount> it = applicationAccountList.iterator();
            int i = 0;
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                int i2 = i + 1;
                if (Intrinsics.areEqual(this.b, it.next().getApplicationAccountId())) {
                    this.h = i;
                    break;
                }
                i = i2;
            }
        }
        RecyclerView recyclerViewI = i();
        Integer numValueOf = Integer.valueOf(this.h);
        XRemoteAppUserBean.DataBean dataBean2 = this.c;
        recyclerViewI.setAdapter(new XRemoteUserAdapter(numValueOf, dataBean2 != null ? dataBean2.getApplicationAccountList() : null, R.layout.adapter_xremote_user));
        recyclerViewI.setLayoutManager(new LinearLayoutManager(recyclerViewI.getContext(), 1, false));
        recyclerViewI.addItemDecoration(new RecyclerView.ItemDecoration() { // from class: com.wear.widget.dialog.XRemoteAuthorizedLoginPop$initView$2$1
            @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
            public void getItemOffsets(@NotNull Rect outRect, @NotNull View view, @NotNull RecyclerView parent, @NotNull RecyclerView.State state) {
                Intrinsics.checkNotNullParameter(outRect, "outRect");
                Intrinsics.checkNotNullParameter(view, "view");
                Intrinsics.checkNotNullParameter(parent, "parent");
                Intrinsics.checkNotNullParameter(state, "state");
                outRect.top = ce3.a(parent.getContext(), parent.getChildAdapterPosition(view) == 0 ? 0.0f : 10.0f);
            }
        });
        XRemoteAppUserBean.DataBean dataBean3 = this.c;
        if (dataBean3 != null && (application = dataBean3.getApplication()) != null) {
            j().setText(application.getApplicationName());
            TextView textViewK = k();
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String strE = ah4.e(R.string.obtain_user_info_des2);
            Intrinsics.checkNotNullExpressionValue(strE, "getString(R.string.obtain_user_info_des2)");
            String str2 = String.format(strE, Arrays.copyOf(new Object[]{application.getApplicationName()}, 1));
            Intrinsics.checkNotNullExpressionValue(str2, "format(format, *args)");
            textViewK.setText(str2);
            kf.w(this.g).v(application.getApplicationIconUrl()).A0(g());
        }
        p();
    }

    public final void m(int i) {
        RecyclerView.Adapter adapter = i().getAdapter();
        if (adapter != null) {
            adapter.notifyItemInserted(i);
        }
        p();
    }

    public final void n(@Nullable Function0<Unit> function0, @Nullable Function1<? super XRemoteAppUserBean.DataBean.ApplicationAccount, Unit> function1, @Nullable Function0<Unit> function02) {
        this.d = function0;
        this.e = function1;
        this.f = function02;
    }

    public final void o(int i) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = i == 2 ? 0 : 64;
        layoutParams.bottomMargin = 28;
        h().setLayoutParams(layoutParams);
    }

    public final void p() {
        List<XRemoteAppUserBean.DataBean.ApplicationAccount> applicationAccountList;
        TextView textViewF = f();
        XRemoteAppUserBean.DataBean dataBean = this.c;
        Integer numValueOf = (dataBean == null || (applicationAccountList = dataBean.getApplicationAccountList()) == null) ? null : Integer.valueOf(applicationAccountList.size());
        Intrinsics.checkNotNull(numValueOf);
        textViewF.setVisibility(numValueOf.intValue() > 1 ? 8 : 0);
        o(getContext().getResources().getConfiguration().orientation);
    }
}
