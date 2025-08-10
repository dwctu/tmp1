package com.wear.ui.longDistance.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.lovense.wear.R;
import com.wear.BaseBindingBottomDialogFragment;
import com.wear.databinding.FragmentLongUserActionMenuConfirmBinding;
import com.wear.ui.longDistance.fragment.LongUserActionMenuConfirmFragmentBottom;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.i18n.MessageBundle;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: LongUserActionMenuConfirmFragmentBottom.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u000e\u000f\u0010B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0002J\u001a\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u000e\u0010\r\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0005R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/wear/ui/longDistance/fragment/LongUserActionMenuConfirmFragmentBottom;", "Lcom/wear/BaseBindingBottomDialogFragment;", "Lcom/wear/databinding/FragmentLongUserActionMenuConfirmBinding;", "()V", "onConfirmListener", "Lcom/wear/ui/longDistance/fragment/LongUserActionMenuConfirmFragmentBottom$OnConfirmListener;", "initListener", "", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "setOnConfirmListener", "Companion", "OnConfirmListener", "Type", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public final class LongUserActionMenuConfirmFragmentBottom extends BaseBindingBottomDialogFragment<FragmentLongUserActionMenuConfirmBinding> {

    @Nullable
    public b c;

    /* compiled from: LongUserActionMenuConfirmFragmentBottom.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class a extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, FragmentLongUserActionMenuConfirmBinding> {
        public static final a a = new a();

        public a() {
            super(3, FragmentLongUserActionMenuConfirmBinding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/wear/databinding/FragmentLongUserActionMenuConfirmBinding;", 0);
        }

        @NotNull
        public final FragmentLongUserActionMenuConfirmBinding a(@NotNull LayoutInflater p0, @Nullable ViewGroup viewGroup, boolean z) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return FragmentLongUserActionMenuConfirmBinding.b(p0, viewGroup, z);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ FragmentLongUserActionMenuConfirmBinding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
            return a(layoutInflater, viewGroup, bool.booleanValue());
        }
    }

    /* compiled from: LongUserActionMenuConfirmFragmentBottom.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/wear/ui/longDistance/fragment/LongUserActionMenuConfirmFragmentBottom$OnConfirmListener;", "", "onConfirm", "", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public interface b {
        void a();
    }

    /* compiled from: LongUserActionMenuConfirmFragmentBottom.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\r\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u001f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/wear/ui/longDistance/fragment/LongUserActionMenuConfirmFragmentBottom$Type;", "", MessageBundle.TITLE_ENTRY, "", FirebaseAnalytics.Param.CONTENT, "confirmText", "(Ljava/lang/String;IIII)V", "getConfirmText", "()I", "getContent", "getTitle", "CLEAR_CHAT_HISTORY", "DELETE_CONTACT", "LEAVE_GROUP", "BLOCK_CONTACT", "DELETE_GROUP", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public enum c {
        CLEAR_CHAT_HISTORY(R.string.clear_chat_message, R.string.tip_clear_chat_history, R.string.filter_clear_button),
        DELETE_CONTACT(R.string.chat_menu_delete_contact, R.string.user_manager_delete_friend, R.string.common_delete),
        LEAVE_GROUP(R.string.group_chat_setting_exit, R.string.group_chat_exit_group_content, R.string.group_chat_setting_exit),
        BLOCK_CONTACT(R.string.partner_profile_black_setting, R.string.tip_block_confirm, R.string.str_block),
        DELETE_GROUP(R.string.chat_menu_delete_contact, R.string.group_chat_delete_group_note, R.string.common_delete);

        private final int confirmText;
        private final int content;
        private final int title;

        c(int i, int i2, int i3) {
            this.title = i;
            this.content = i2;
            this.confirmText = i3;
        }

        public final int getConfirmText() {
            return this.confirmText;
        }

        public final int getContent() {
            return this.content;
        }

        public final int getTitle() {
            return this.title;
        }
    }

    public LongUserActionMenuConfirmFragmentBottom() {
        super(a.a);
    }

    public static final void v(LongUserActionMenuConfirmFragmentBottom this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
    }

    public static final void y(LongUserActionMenuConfirmFragmentBottom this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        b bVar = this$0.c;
        if (bVar != null) {
            bVar.a();
        }
        this$0.dismissAllowingStateLoss();
    }

    public final void C(@NotNull b onConfirmListener) {
        Intrinsics.checkNotNullParameter(onConfirmListener, "onConfirmListener");
        this.c = onConfirmListener;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        Bundle arguments = getArguments();
        t().e(c.values()[arguments != null ? arguments.getInt("argument_type") : 0]);
        Bundle arguments2 = getArguments();
        String string = arguments2 != null ? arguments2.getString("argument_name") : null;
        if (string == null) {
            string = "";
        }
        t().d(string);
        u();
    }

    public final void u() {
        t().a.setOnClickListener(new View.OnClickListener() { // from class: dc.i83
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LongUserActionMenuConfirmFragmentBottom.v(this.a, view);
            }
        });
        t().b.setOnClickListener(new View.OnClickListener() { // from class: dc.h83
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LongUserActionMenuConfirmFragmentBottom.y(this.a, view);
            }
        });
    }
}
