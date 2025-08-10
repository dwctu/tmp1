package com.wear.main.longDistance;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.lifecycle.LifecycleOwnerKt;
import com.lovense.wear.R;
import com.wear.BaseActivity;
import com.wear.bean.InviteLink;
import com.wear.databinding.ActivityInviteLinkBinding;
import com.wear.main.longDistance.InviteLinkActivity;
import com.wear.net.model.RemoteResponse;
import com.wear.net.model.RemoteResult;
import com.wear.util.WearUtils;
import dc.ah4;
import dc.al2;
import dc.cl2;
import dc.ku1;
import dc.sg3;
import dc.uy3;
import dc.vl2;
import dc.wz3;
import dc.xk2;
import dc.zk2;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: InviteLinkActivity.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0002J\u0006\u0010\b\u001a\u00020\u0007J\u0012\u0010\t\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/wear/main/longDistance/InviteLinkActivity;", "Lcom/wear/BaseActivity;", "Lcom/wear/network/presenter/base/PresenterLife;", "()V", "binding", "Lcom/wear/databinding/ActivityInviteLinkBinding;", "initData", "", "initView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class InviteLinkActivity extends BaseActivity<vl2> {
    public ActivityInviteLinkBinding a;

    /* compiled from: InviteLinkActivity.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.wear.main.longDistance.InviteLinkActivity$initData$1", f = "InviteLinkActivity.kt", i = {0}, l = {43}, m = "invokeSuspend", n = {"isShowToast$iv$iv"}, s = {"I$0"})
    public static final class a extends SuspendLambda implements Function2<wz3, Continuation<? super Unit>, Object> {
        public int I$0;
        public int label;

        public a(Continuation<? super a> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return InviteLinkActivity.this.new a(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull wz3 wz3Var, @Nullable Continuation<? super Unit> continuation) {
            return ((a) create(wz3Var, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            RemoteResponse remoteResponseA;
            RemoteResult remoteResult;
            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            int i2 = 1;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    InviteLinkActivity.this.showDialog();
                    cl2 cl2VarB = xk2.c.b();
                    this.I$0 = 1;
                    this.label = 1;
                    obj = cl2VarB.c(this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    i2 = this.I$0;
                    ResultKt.throwOnFailure(obj);
                }
                RemoteResult remoteResult2 = (RemoteResult) obj;
                if (remoteResult2.isSuccess()) {
                    remoteResponseA = new RemoteResponse.Success(remoteResult2);
                } else {
                    String message = remoteResult2.getMessage();
                    if (message == null) {
                        message = ah4.e(R.string.common_netError);
                    }
                    if (i2 != 0) {
                        sg3.l(message);
                    }
                    zk2.a.a(remoteResult2.getCode(), message);
                    remoteResponseA = new RemoteResponse.Error(Boxing.boxInt(remoteResult2.getCode()), message);
                }
            } catch (Exception e) {
                e.printStackTrace();
                remoteResponseA = al2.a.a(e);
            }
            ActivityInviteLinkBinding activityInviteLinkBinding = null;
            InviteLink inviteLink = (InviteLink) ((!(remoteResponseA instanceof RemoteResponse.Success) || (remoteResult = (RemoteResult) ((RemoteResponse.Success) remoteResponseA).getData()) == null) ? null : remoteResult.getData());
            InviteLinkActivity.this.dissDialog();
            if (inviteLink == null) {
                return Unit.INSTANCE;
            }
            ActivityInviteLinkBinding activityInviteLinkBinding2 = InviteLinkActivity.this.a;
            if (activityInviteLinkBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                activityInviteLinkBinding = activityInviteLinkBinding2;
            }
            activityInviteLinkBinding.d.setText(inviteLink.getInviteLinkUrl());
            return Unit.INSTANCE;
        }
    }

    public static final void v4(InviteLinkActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        Object[] objArr = new Object[2];
        objArr[0] = ah4.e(R.string.invite_paste_desc);
        ActivityInviteLinkBinding activityInviteLinkBinding = this$0.a;
        if (activityInviteLinkBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityInviteLinkBinding = null;
        }
        objArr[1] = activityInviteLinkBinding.d.getText().toString();
        String str = String.format("%s %s", Arrays.copyOf(objArr, 2));
        Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("text/plain");
        intent.putExtra("android.intent.extra.TEXT", str);
        this$0.startActivity(Intent.createChooser(intent, ah4.e(R.string.invite_link_page_title)));
        ku1.f("Invite Link", "share_add_people_invite_link_click", "share_add_people_invite_link", null, null, null);
    }

    public static final void w4(InviteLinkActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        Object[] objArr = new Object[2];
        objArr[0] = ah4.e(R.string.invite_paste_desc);
        ActivityInviteLinkBinding activityInviteLinkBinding = this$0.a;
        if (activityInviteLinkBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityInviteLinkBinding = null;
        }
        objArr[1] = activityInviteLinkBinding.d.getText().toString();
        String str = String.format("%s %s", Arrays.copyOf(objArr, 2));
        Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
        String str2 = "onClick: copy=" + str;
        WearUtils.p(str, this$0);
        sg3.n(R.string.copy_invite_link_title_copied);
        ku1.f("Invite Link", "copy_add_people_invite_link_click", "copy_add_people_invite_link", null, null, null);
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityInviteLinkBinding activityInviteLinkBindingC = ActivityInviteLinkBinding.c(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(activityInviteLinkBindingC, "inflate(layoutInflater)");
        this.a = activityInviteLinkBindingC;
        if (activityInviteLinkBindingC == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityInviteLinkBindingC = null;
        }
        setContentView(activityInviteLinkBindingC.getRoot());
        u4();
        t4();
    }

    public final void t4() {
        uy3.d(LifecycleOwnerKt.getLifecycleScope(this), null, null, new a(null), 3, null);
    }

    public final void u4() {
        ActivityInviteLinkBinding activityInviteLinkBinding = this.a;
        ActivityInviteLinkBinding activityInviteLinkBinding2 = null;
        if (activityInviteLinkBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityInviteLinkBinding = null;
        }
        activityInviteLinkBinding.c.setOnClickListener(new View.OnClickListener() { // from class: dc.m72
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                InviteLinkActivity.v4(this.a, view);
            }
        });
        ActivityInviteLinkBinding activityInviteLinkBinding3 = this.a;
        if (activityInviteLinkBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityInviteLinkBinding2 = activityInviteLinkBinding3;
        }
        activityInviteLinkBinding2.b.setOnClickListener(new View.OnClickListener() { // from class: dc.n72
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                InviteLinkActivity.w4(this.a, view);
            }
        });
    }
}
