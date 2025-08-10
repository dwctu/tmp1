package com.wear.ui.me;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import com.lovense.wear.R;
import com.wear.BaseActivity;
import com.wear.bean.UserJoinChatBean;
import com.wear.databinding.ActivityControlRouletteReportSuccessBinding;
import com.wear.ext.ActivityKt;
import com.wear.ui.discover.roulette.RouletteChatEndActivity;
import com.wear.ui.discover.roulette.ToyRouletteActivity;
import com.wear.ui.me.ControlRouletteReportSuccessActivity;
import com.wear.util.WearUtils;
import com.wear.widget.MyActionBar;
import dc.kg3;
import dc.th4;
import dc.vl2;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ControlRouletteReportSuccessActivity.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00182\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0018B\u0005¢\u0006\u0002\u0010\u0003J\u0006\u0010\f\u001a\u00020\rJ\u0012\u0010\u000e\u001a\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0014J\u001a\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\u0017\u001a\u00020\rH\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u001d\u0010\u0006\u001a\u0004\u0018\u00010\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t¨\u0006\u0019"}, d2 = {"Lcom/wear/ui/me/ControlRouletteReportSuccessActivity;", "Lcom/wear/BaseActivity;", "Lcom/wear/network/presenter/base/PresenterLife;", "()V", "binding", "Lcom/wear/databinding/ActivityControlRouletteReportSuccessBinding;", "userJoinChatBean", "Lcom/wear/bean/UserJoinChatBean;", "getUserJoinChatBean", "()Lcom/wear/bean/UserJoinChatBean;", "userJoinChatBean$delegate", "Lkotlin/Lazy;", "finshAc", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onKeyDown", "", "keyCode", "", "event", "Landroid/view/KeyEvent;", "onResume", "Companion", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public final class ControlRouletteReportSuccessActivity extends BaseActivity<vl2> {

    @NotNull
    public static final a c = new a(null);
    public ActivityControlRouletteReportSuccessBinding a;

    @NotNull
    public final Lazy b = LazyKt__LazyJVMKt.lazy(new b());

    /* compiled from: ControlRouletteReportSuccessActivity.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Lcom/wear/ui/me/ControlRouletteReportSuccessActivity$Companion;", "", "()V", "startAtc", "", "context", "Landroid/content/Context;", "userJoinChatBean", "Lcom/wear/bean/UserJoinChatBean;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull Context context, @NotNull UserJoinChatBean userJoinChatBean) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(userJoinChatBean, "userJoinChatBean");
            Intent intent = new Intent(context, (Class<?>) ControlRouletteReportSuccessActivity.class);
            intent.putExtra("userJoinChatBean", userJoinChatBean);
            context.startActivity(intent);
        }
    }

    /* compiled from: ControlRouletteReportSuccessActivity.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/wear/bean/UserJoinChatBean;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class b extends Lambda implements Function0<UserJoinChatBean> {
        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @Nullable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final UserJoinChatBean invoke() {
            return Build.VERSION.SDK_INT >= 33 ? (UserJoinChatBean) ControlRouletteReportSuccessActivity.this.getIntent().getParcelableExtra("userJoinChatBean", UserJoinChatBean.class) : (UserJoinChatBean) ControlRouletteReportSuccessActivity.this.getIntent().getParcelableExtra("userJoinChatBean");
        }
    }

    public static final void w4(ControlRouletteReportSuccessActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.s4();
    }

    public static final void x4(ControlRouletteReportSuccessActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.s4();
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityControlRouletteReportSuccessBinding activityControlRouletteReportSuccessBindingC = ActivityControlRouletteReportSuccessBinding.c(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(activityControlRouletteReportSuccessBindingC, "inflate(layoutInflater)");
        this.a = activityControlRouletteReportSuccessBindingC;
        ActivityControlRouletteReportSuccessBinding activityControlRouletteReportSuccessBinding = null;
        if (activityControlRouletteReportSuccessBindingC == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityControlRouletteReportSuccessBindingC = null;
        }
        setContentView(activityControlRouletteReportSuccessBindingC.getRoot());
        ActivityControlRouletteReportSuccessBinding activityControlRouletteReportSuccessBinding2 = this.a;
        if (activityControlRouletteReportSuccessBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityControlRouletteReportSuccessBinding2 = null;
        }
        activityControlRouletteReportSuccessBinding2.b.setParentBackgroundColor(th4.b(this, R.color.lvs_ui_standard_systemBackground));
        ActivityControlRouletteReportSuccessBinding activityControlRouletteReportSuccessBinding3 = this.a;
        if (activityControlRouletteReportSuccessBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityControlRouletteReportSuccessBinding3 = null;
        }
        activityControlRouletteReportSuccessBinding3.b.setBackAction(new MyActionBar.f() { // from class: dc.db3
            @Override // com.wear.widget.MyActionBar.f
            public final void performAction(View view) {
                ControlRouletteReportSuccessActivity.w4(this.a, view);
            }
        });
        ActivityControlRouletteReportSuccessBinding activityControlRouletteReportSuccessBinding4 = this.a;
        if (activityControlRouletteReportSuccessBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityControlRouletteReportSuccessBinding = activityControlRouletteReportSuccessBinding4;
        }
        activityControlRouletteReportSuccessBinding.c.setOnClickListener(new View.OnClickListener() { // from class: dc.eb3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ControlRouletteReportSuccessActivity.x4(this.a, view);
            }
        });
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int keyCode, @Nullable KeyEvent event) {
        if (keyCode != 4) {
            return super.onKeyDown(keyCode, event);
        }
        s4();
        return true;
    }

    @Override // com.wear.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (Build.VERSION.SDK_INT >= 23) {
            kg3.k(this, WearUtils.Y0());
        }
    }

    public final void s4() {
        Object next;
        Iterator<T> it = ActivityKt.d().iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            } else {
                next = it.next();
                if (((Activity) next) instanceof RouletteChatEndActivity) {
                    break;
                }
            }
        }
        Activity activity = (Activity) next;
        if (activity != null) {
            activity.finish();
        }
        UserJoinChatBean userJoinChatBeanT4 = t4();
        if (!(userJoinChatBeanT4 != null && userJoinChatBeanT4.getIsFromOuter())) {
            ToyRouletteActivity.b.a(this);
        }
        finish();
    }

    public final UserJoinChatBean t4() {
        return (UserJoinChatBean) this.b.getValue();
    }
}
