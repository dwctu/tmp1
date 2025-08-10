package com.wear.ui.longDistance.officialaccount;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.Observer;
import com.lovense.wear.R;
import com.wear.BaseActivity;
import com.wear.bean.official.OfficialAcount;
import com.wear.bean.official.OfficialMsg;
import com.wear.bean.official.OfficialSetInfo;
import com.wear.databinding.ActivityOfficialAccountInfoBinding;
import com.wear.main.longDistance.scan.PictureEnlargeActivity;
import com.wear.ui.longDistance.officialaccount.OfficialAccountInfoActivity;
import com.wear.util.WearUtils;
import dc.ah4;
import dc.kg3;
import dc.kn3;
import dc.th4;
import dc.uy3;
import dc.vl2;
import dc.wz3;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.codec.net.RFC1522Codec;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: OfficialAccountInfoActivity.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0006\u0010\f\u001a\u00020\rJ\b\u0010\u000e\u001a\u00020\rH\u0002J\u0006\u0010\u000f\u001a\u00020\rJ\u0012\u0010\u0010\u001a\u00020\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/wear/ui/longDistance/officialaccount/OfficialAccountInfoActivity;", "Lcom/wear/BaseActivity;", "Lcom/wear/network/presenter/base/PresenterLife;", "()V", "binding", "Lcom/wear/databinding/ActivityOfficialAccountInfoBinding;", "model", "Lcom/wear/ui/longDistance/officialaccount/OfficialaCountModel;", "getModel", "()Lcom/wear/ui/longDistance/officialaccount/OfficialaCountModel;", "vImageWatcher", "Lcom/wear/widget/iwatcher/ImageWatcher;", "clearMessage", "", "initData", "initView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public final class OfficialAccountInfoActivity extends BaseActivity<vl2> {
    public ActivityOfficialAccountInfoBinding a;

    @NotNull
    public final OfficialaCountModel b = OfficialaCountModel.g.a();

    /* compiled from: OfficialAccountInfoActivity.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.wear.ui.longDistance.officialaccount.OfficialAccountInfoActivity$clearMessage$1", f = "OfficialAccountInfoActivity.kt", i = {}, l = {107}, m = "invokeSuspend", n = {}, s = {})
    public static final class a extends SuspendLambda implements Function2<wz3, Continuation<? super Unit>, Object> {
        public int label;

        public a(Continuation<? super a> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return OfficialAccountInfoActivity.this.new a(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull wz3 wz3Var, @Nullable Continuation<? super Unit> continuation) {
            return ((a) create(wz3Var, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                OfficialaCountModel b = OfficialAccountInfoActivity.this.getB();
                this.label = 1;
                obj = b.j(this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            if (((Boolean) obj).booleanValue()) {
                OfficialAccountInfoActivity.this.getB().M();
                List<OfficialMsg> value = OfficialAccountInfoActivity.this.getB().q().getValue();
                if (value != null) {
                    value.clear();
                }
                OfficialAccountInfoActivity.this.getB().K(0L);
                OfficialAccountInfoActivity.this.getB().q().postValue(new ArrayList());
                OfficialAcount value2 = OfficialAccountInfoActivity.this.getB().o().getValue();
                if (value2 != null) {
                    value2.setMessage(null);
                }
                OfficialAccountInfoActivity.this.getB().o().postValue(OfficialAccountInfoActivity.this.getB().o().getValue());
            }
            return Unit.INSTANCE;
        }
    }

    /* compiled from: OfficialAccountInfoActivity.kt */
    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005"}, d2 = {"com/wear/ui/longDistance/officialaccount/OfficialAccountInfoActivity$initView$5$cd$1", "Lcom/wear/widget/CommonDialog$ClickListener;", "doCancel", "", "doConfirm", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class b implements kn3.d {
        public b() {
        }

        @Override // dc.kn3.d
        public void doCancel() {
        }

        @Override // dc.kn3.d
        public void doConfirm() {
            OfficialAccountInfoActivity.this.s4();
        }
    }

    public static final void A4(OfficialAccountInfoActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        kn3 kn3Var = new kn3((Context) this$0, ah4.e(R.string.clear_chat_message) + RFC1522Codec.SEP, ah4.e(R.string.common_yes), ah4.e(R.string.common_no), true, (kn3.d) this$0.new b());
        kn3Var.show();
        kn3Var.p();
        kn3Var.l();
    }

    public static final void w4(OfficialAccountInfoActivity this$0, OfficialSetInfo officialSetInfo) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (officialSetInfo != null) {
            ActivityOfficialAccountInfoBinding activityOfficialAccountInfoBinding = this$0.a;
            ActivityOfficialAccountInfoBinding activityOfficialAccountInfoBinding2 = null;
            if (activityOfficialAccountInfoBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityOfficialAccountInfoBinding = null;
            }
            activityOfficialAccountInfoBinding.f.setChecked(officialSetInfo.getStickyToTop());
            ActivityOfficialAccountInfoBinding activityOfficialAccountInfoBinding3 = this$0.a;
            if (activityOfficialAccountInfoBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                activityOfficialAccountInfoBinding2 = activityOfficialAccountInfoBinding3;
            }
            activityOfficialAccountInfoBinding2.e.setChecked(officialSetInfo.getOfficialMsgMuteNotification());
        }
    }

    public static final void x4(OfficialAccountInfoActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        OfficialSetInfo value = this$0.b.s().getValue();
        if (value != null) {
            ActivityOfficialAccountInfoBinding activityOfficialAccountInfoBinding = this$0.a;
            if (activityOfficialAccountInfoBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityOfficialAccountInfoBinding = null;
            }
            value.setStickyToTop(activityOfficialAccountInfoBinding.f.isChecked());
        }
        this$0.b.s().postValue(this$0.b.s().getValue());
        OfficialaCountModel.x(this$0.b, null, 1, null);
    }

    public static final void y4(OfficialAccountInfoActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        OfficialSetInfo value = this$0.b.s().getValue();
        if (value != null) {
            ActivityOfficialAccountInfoBinding activityOfficialAccountInfoBinding = this$0.a;
            if (activityOfficialAccountInfoBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityOfficialAccountInfoBinding = null;
            }
            value.setOfficialMsgMuteNotification(activityOfficialAccountInfoBinding.e.isChecked());
        }
        this$0.b.s().postValue(this$0.b.s().getValue());
        OfficialaCountModel.x(this$0.b, null, 1, null);
    }

    public static final void z4(OfficialAccountInfoActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intent intent = new Intent(this$0, (Class<?>) PictureEnlargeActivity.class);
        intent.putExtra("picture_resources", R.drawable.avatar_official);
        intent.putExtra("hide_upper_right", true);
        this$0.startActivity(intent);
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityOfficialAccountInfoBinding activityOfficialAccountInfoBindingC = ActivityOfficialAccountInfoBinding.c(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(activityOfficialAccountInfoBindingC, "inflate(layoutInflater)");
        this.a = activityOfficialAccountInfoBindingC;
        if (activityOfficialAccountInfoBindingC == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityOfficialAccountInfoBindingC = null;
        }
        setContentView(activityOfficialAccountInfoBindingC.getRoot());
        if (Build.VERSION.SDK_INT >= 23) {
            kg3.k(this, WearUtils.Y0());
        }
        v4();
        u4();
    }

    public final void s4() {
        uy3.d(LifecycleOwnerKt.getLifecycleScope(this), null, null, new a(null), 3, null);
    }

    @NotNull
    /* renamed from: t4, reason: from getter */
    public final OfficialaCountModel getB() {
        return this.b;
    }

    public final void u4() {
    }

    public final void v4() {
        ActivityOfficialAccountInfoBinding activityOfficialAccountInfoBinding = this.a;
        ActivityOfficialAccountInfoBinding activityOfficialAccountInfoBinding2 = null;
        if (activityOfficialAccountInfoBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityOfficialAccountInfoBinding = null;
        }
        activityOfficialAccountInfoBinding.b.setParentBackgroundColor(th4.b(this.application, R.color.lvs_ui_standard_systemBackground6));
        this.b.s().observe(this, new Observer() { // from class: dc.x93
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                OfficialAccountInfoActivity.w4(this.a, (OfficialSetInfo) obj);
            }
        });
        ActivityOfficialAccountInfoBinding activityOfficialAccountInfoBinding3 = this.a;
        if (activityOfficialAccountInfoBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityOfficialAccountInfoBinding3 = null;
        }
        activityOfficialAccountInfoBinding3.f.setOnClickListener(new View.OnClickListener() { // from class: dc.w93
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                OfficialAccountInfoActivity.x4(this.a, view);
            }
        });
        ActivityOfficialAccountInfoBinding activityOfficialAccountInfoBinding4 = this.a;
        if (activityOfficialAccountInfoBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityOfficialAccountInfoBinding4 = null;
        }
        activityOfficialAccountInfoBinding4.e.setOnClickListener(new View.OnClickListener() { // from class: dc.y93
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                OfficialAccountInfoActivity.y4(this.a, view);
            }
        });
        ActivityOfficialAccountInfoBinding activityOfficialAccountInfoBinding5 = this.a;
        if (activityOfficialAccountInfoBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityOfficialAccountInfoBinding5 = null;
        }
        activityOfficialAccountInfoBinding5.d.setOnClickListener(new View.OnClickListener() { // from class: dc.z93
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                OfficialAccountInfoActivity.z4(this.a, view);
            }
        });
        ActivityOfficialAccountInfoBinding activityOfficialAccountInfoBinding6 = this.a;
        if (activityOfficialAccountInfoBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityOfficialAccountInfoBinding2 = activityOfficialAccountInfoBinding6;
        }
        activityOfficialAccountInfoBinding2.c.setOnClickListener(new View.OnClickListener() { // from class: dc.v93
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                OfficialAccountInfoActivity.A4(this.a, view);
            }
        });
    }
}
