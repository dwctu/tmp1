package com.wear.ui.me.fragment;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.fragment.app.FragmentManager;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.lovense.wear.R;
import com.wear.BaseBindingDialogFragment;
import com.wear.bean.InviteRequestInfo;
import com.wear.databinding.FragmentInviteUserRequestBinding;
import com.wear.main.account.login.LoginActivity;
import com.wear.ui.me.fragment.InviteUserRequestFragment;
import com.wear.util.MyApplication;
import dc.gg3;
import dc.pj3;
import dc.qu1;
import dc.vz1;
import dc.wz1;
import dc.yy3;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: InviteUserRequestFragment.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0017B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\t\u001a\u00020\u0006H\u0016J\b\u0010\n\u001a\u00020\u0006H\u0002J\u0012\u0010\u000b\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u000e\u001a\u00020\u0006H\u0016J\u001a\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u000e\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\bJ\u000e\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0016R\u0016\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/wear/ui/me/fragment/InviteUserRequestFragment;", "Lcom/wear/BaseBindingDialogFragment;", "Lcom/wear/databinding/FragmentInviteUserRequestBinding;", "()V", "mCancellableContinuation", "Lkotlinx/coroutines/CancellableContinuation;", "", "mOnInviteUserRequestListener", "Lcom/wear/ui/me/fragment/InviteUserRequestFragment$OnInviteUserRequestListener;", "dismissAllowingStateLoss", "initListener", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "onViewCreated", "view", "Landroid/view/View;", "setOnInviteUserRequestListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "show", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "OnInviteUserRequestListener", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public final class InviteUserRequestFragment extends BaseBindingDialogFragment<FragmentInviteUserRequestBinding> {

    @Nullable
    public yy3<? super Unit> c;

    @Nullable
    public b d;

    /* compiled from: InviteUserRequestFragment.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class a extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, FragmentInviteUserRequestBinding> {
        public static final a a = new a();

        public a() {
            super(3, FragmentInviteUserRequestBinding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/wear/databinding/FragmentInviteUserRequestBinding;", 0);
        }

        @NotNull
        public final FragmentInviteUserRequestBinding a(@NotNull LayoutInflater p0, @Nullable ViewGroup viewGroup, boolean z) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return FragmentInviteUserRequestBinding.b(p0, viewGroup, z);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ FragmentInviteUserRequestBinding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
            return a(layoutInflater, viewGroup, bool.booleanValue());
        }
    }

    /* compiled from: InviteUserRequestFragment.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/wear/ui/me/fragment/InviteUserRequestFragment$OnInviteUserRequestListener;", "", "onInviteUserRequest", "", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public interface b {
        void a();
    }

    public InviteUserRequestFragment() {
        super(a.a);
    }

    public static final void D(DialogInterface dialogInterface) {
        vz1.b(wz1.b.INVITE);
    }

    public static final void v(InviteUserRequestFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
        MyApplication.v0(null);
    }

    public static final void y(InviteUserRequestFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!MyApplication.O) {
            pj3.f(view.getContext(), LoginActivity.class);
            return;
        }
        this$0.dismissAllowingStateLoss();
        b bVar = this$0.d;
        if (bVar != null) {
            bVar.a();
        }
    }

    public final void E(@NotNull b listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.d = listener;
    }

    public final void F(@NotNull FragmentManager fragmentManager) {
        Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
        show(fragmentManager, "InviteUserRequestFragment");
    }

    @Override // androidx.fragment.app.FixDialogFragment
    public void dismissAllowingStateLoss() {
        super.dismissAllowingStateLoss();
        yy3<? super Unit> yy3Var = this.c;
        if (yy3Var != null) {
            Result.Companion companion = Result.INSTANCE;
            yy3Var.resumeWith(Result.m86constructorimpl(Unit.INSTANCE));
        }
    }

    @Override // androidx.fragment.app.FixDialogFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(0, R.style.Dialog_Fragment_Fullscreen);
        setCancelable(false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        Window window;
        super.onResume();
        Dialog dialog = getDialog();
        if (dialog != null && (window = dialog.getWindow()) != null) {
            window.setLayout((int) (gg3.e(requireContext()) - qu1.a(64)), -2);
        }
        Dialog dialog2 = getDialog();
        if (dialog2 != null) {
            dialog2.setCanceledOnTouchOutside(false);
        }
        Dialog dialog3 = getDialog();
        if (dialog3 != null) {
            dialog3.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: dc.cc3
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    InviteUserRequestFragment.D(dialogInterface);
                }
            });
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        Bundle arguments = getArguments();
        InviteRequestInfo inviteRequestInfo = arguments != null ? (InviteRequestInfo) arguments.getParcelable("inviteRequestInfo") : null;
        t().d(inviteRequestInfo instanceof InviteRequestInfo ? inviteRequestInfo : null);
        u();
    }

    public final void u() {
        t().a.setOnClickListener(new View.OnClickListener() { // from class: dc.ec3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                InviteUserRequestFragment.v(this.a, view);
            }
        });
        t().b.setOnClickListener(new View.OnClickListener() { // from class: dc.dc3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                InviteUserRequestFragment.y(this.a, view);
            }
        });
    }
}
