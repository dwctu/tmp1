package com.wear.main.account.rate;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.broadcom.bt.util.io.IOUtils;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.lovense.wear.R;
import com.wear.BaseActivity;
import com.wear.bean.event.LoginOrOfflineEvent;
import com.wear.databinding.ActivityRateFeedbackBinding;
import com.wear.main.account.rate.RateFeedbackActivity;
import com.wear.network.presenter.bean.BaseResponseBean;
import com.wear.widget.roundwidget.SkinRoundTextView;
import dc.ah4;
import dc.cu2;
import dc.ku1;
import dc.sg3;
import dc.vl2;
import java.util.Arrays;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: RateFeedbackActivity.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J(\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0012H\u0002J\b\u0010\u0016\u001a\u00020\u0010H\u0016J\b\u0010\u0017\u001a\u00020\u0010H\u0002J\b\u0010\u0018\u001a\u00020\u0010H\u0002J\b\u0010\u0019\u001a\u00020\u0010H\u0016J\u0012\u0010\u001a\u001a\u00020\u00102\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0014J\b\u0010\u001d\u001a\u00020\u0010H\u0014J\u0010\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020 H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\f¨\u0006!"}, d2 = {"Lcom/wear/main/account/rate/RateFeedbackActivity;", "Lcom/wear/BaseActivity;", "Lcom/wear/network/presenter/base/PresenterLife;", "()V", "binding", "Lcom/wear/databinding/ActivityRateFeedbackBinding;", "maxCount", "", "minCount", "viewModel", "Lcom/wear/main/account/rate/RateFeedbackModel;", "getViewModel", "()Lcom/wear/main/account/rate/RateFeedbackModel;", "viewModel$delegate", "Lkotlin/Lazy;", "addLog", "", "eventId", "", "eventType", "elementId", "elementType", "finish", "initView", "observableViewModelData", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onMessage", "event", "Lcom/wear/bean/event/LoginOrOfflineEvent;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class RateFeedbackActivity extends BaseActivity<vl2> {
    public ActivityRateFeedbackBinding a;
    public final int b = 500;
    public final int c = 15;

    @NotNull
    public final Lazy d = new ViewModelLazy(Reflection.getOrCreateKotlinClass(RateFeedbackModel.class), new c(this), new b(this), new d(null, this));

    /* compiled from: TextView.kt */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J*\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0016J*\u0010\r\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016¨\u0006\u000f¸\u0006\u0010"}, d2 = {"androidx/core/widget/TextViewKt$addTextChangedListener$textWatcher$1", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "text", "", TtmlNode.START, "", "count", TtmlNode.ANNOTATION_POSITION_AFTER, "onTextChanged", TtmlNode.ANNOTATION_POSITION_BEFORE, "core-ktx_release", "androidx/core/widget/TextViewKt$doAfterTextChanged$$inlined$addTextChangedListener$default$1"}, k = 1, mv = {1, 7, 1}, xi = 48)
    @SourceDebugExtension({"SMAP\nTextView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TextView.kt\nandroidx/core/widget/TextViewKt$addTextChangedListener$textWatcher$1\n+ 2 TextView.kt\nandroidx/core/widget/TextViewKt$addTextChangedListener$1\n+ 3 TextView.kt\nandroidx/core/widget/TextViewKt$addTextChangedListener$2\n*L\n1#1,97:1\n71#2:98\n77#3:99\n*E\n"})
    public static final class a implements TextWatcher {
        public a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@Nullable Editable s) {
            ActivityRateFeedbackBinding activityRateFeedbackBinding = RateFeedbackActivity.this.a;
            if (activityRateFeedbackBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityRateFeedbackBinding = null;
            }
            TextView textView = activityRateFeedbackBinding.f;
            StringBuilder sb = new StringBuilder();
            sb.append(s != null ? Integer.valueOf(s.length()) : null);
            sb.append(IOUtils.DIR_SEPARATOR_UNIX);
            sb.append(RateFeedbackActivity.this.b);
            textView.setText(sb.toString());
            ActivityRateFeedbackBinding activityRateFeedbackBinding2 = RateFeedbackActivity.this.a;
            if (activityRateFeedbackBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityRateFeedbackBinding2 = null;
            }
            activityRateFeedbackBinding2.e.setVisibility(8);
            ActivityRateFeedbackBinding activityRateFeedbackBinding3 = RateFeedbackActivity.this.a;
            if (activityRateFeedbackBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityRateFeedbackBinding3 = null;
            }
            SkinRoundTextView skinRoundTextView = activityRateFeedbackBinding3.b;
            Integer numValueOf = s != null ? Integer.valueOf(s.length()) : null;
            Intrinsics.checkNotNull(numValueOf);
            skinRoundTextView.setEnabled(numValueOf.intValue() > 0);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(@Nullable CharSequence text, int start, int count, int after) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(@Nullable CharSequence text, int start, int before, int count) {
        }
    }

    /* compiled from: ActivityViewModelLazy.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, d2 = {"<anonymous>", "Landroidx/lifecycle/ViewModelProvider$Factory;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke", "androidx/activity/ActivityViewModelLazyKt$viewModels$factoryPromise$2"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class b extends Lambda implements Function0<ViewModelProvider.Factory> {
        public final /* synthetic */ ComponentActivity $this_viewModels;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(ComponentActivity componentActivity) {
            super(0);
            this.$this_viewModels = componentActivity;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final ViewModelProvider.Factory invoke() {
            ViewModelProvider.Factory defaultViewModelProviderFactory = this.$this_viewModels.getDefaultViewModelProviderFactory();
            Intrinsics.checkNotNullExpressionValue(defaultViewModelProviderFactory, "defaultViewModelProviderFactory");
            return defaultViewModelProviderFactory;
        }
    }

    /* compiled from: ActivityViewModelLazy.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, d2 = {"<anonymous>", "Landroidx/lifecycle/ViewModelStore;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke", "androidx/activity/ActivityViewModelLazyKt$viewModels$3"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class c extends Lambda implements Function0<ViewModelStore> {
        public final /* synthetic */ ComponentActivity $this_viewModels;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(ComponentActivity componentActivity) {
            super(0);
            this.$this_viewModels = componentActivity;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final ViewModelStore invoke() {
            ViewModelStore viewModelStore = this.$this_viewModels.getViewModelStore();
            Intrinsics.checkNotNullExpressionValue(viewModelStore, "viewModelStore");
            return viewModelStore;
        }
    }

    /* compiled from: ActivityViewModelLazy.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, d2 = {"<anonymous>", "Landroidx/lifecycle/viewmodel/CreationExtras;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke", "androidx/activity/ActivityViewModelLazyKt$viewModels$4"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class d extends Lambda implements Function0<CreationExtras> {
        public final /* synthetic */ Function0 $extrasProducer;
        public final /* synthetic */ ComponentActivity $this_viewModels;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(Function0 function0, ComponentActivity componentActivity) {
            super(0);
            this.$extrasProducer = function0;
            this.$this_viewModels = componentActivity;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final CreationExtras invoke() {
            CreationExtras creationExtras;
            Function0 function0 = this.$extrasProducer;
            if (function0 != null && (creationExtras = (CreationExtras) function0.invoke()) != null) {
                return creationExtras;
            }
            CreationExtras defaultViewModelCreationExtras = this.$this_viewModels.getDefaultViewModelCreationExtras();
            Intrinsics.checkNotNullExpressionValue(defaultViewModelCreationExtras, "this.defaultViewModelCreationExtras");
            return defaultViewModelCreationExtras;
        }
    }

    public static final void E4(RateFeedbackActivity this$0, BaseResponseBean baseResponseBean) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dissDialog();
        if (baseResponseBean == null) {
            sg3.l(ah4.e(R.string.common_submit_failed));
        } else {
            if (!baseResponseBean.isResult()) {
                sg3.l(ah4.e(R.string.common_submit_failed));
                return;
            }
            this$0.u4("bad_comment_popup_send_click", "click", "bad_comment_popup_send", "button");
            sg3.l(ah4.e(R.string.common_submitted_successfully));
            this$0.finish();
        }
    }

    public static final void F4(RateFeedbackActivity this$0, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dissDialog();
        sg3.l(ah4.e(R.string.common_submit_failed));
    }

    public static final void x4(RateFeedbackActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.u4("bad_comment_popup_close_click", "click", "bad_comment_popup_close", "button");
        this$0.finish();
    }

    public static final void y4(RateFeedbackActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ActivityRateFeedbackBinding activityRateFeedbackBinding = this$0.a;
        ActivityRateFeedbackBinding activityRateFeedbackBinding2 = null;
        if (activityRateFeedbackBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityRateFeedbackBinding = null;
        }
        if (activityRateFeedbackBinding.c.getText().length() >= this$0.c) {
            this$0.showDialog();
            RateFeedbackModel rateFeedbackModelV4 = this$0.v4();
            ActivityRateFeedbackBinding activityRateFeedbackBinding3 = this$0.a;
            if (activityRateFeedbackBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                activityRateFeedbackBinding2 = activityRateFeedbackBinding3;
            }
            rateFeedbackModelV4.c(activityRateFeedbackBinding2.c.getText().toString());
            return;
        }
        ActivityRateFeedbackBinding activityRateFeedbackBinding4 = this$0.a;
        if (activityRateFeedbackBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityRateFeedbackBinding4 = null;
        }
        TextView textView = activityRateFeedbackBinding4.e;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String strE = ah4.e(R.string.common_content_limit);
        Intrinsics.checkNotNullExpressionValue(strE, "getString(R.string.common_content_limit)");
        String str = String.format(strE, Arrays.copyOf(new Object[]{Integer.valueOf(this$0.c), Integer.valueOf(this$0.b)}, 2));
        Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
        textView.setText(str);
        ActivityRateFeedbackBinding activityRateFeedbackBinding5 = this$0.a;
        if (activityRateFeedbackBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityRateFeedbackBinding2 = activityRateFeedbackBinding5;
        }
        activityRateFeedbackBinding2.e.setVisibility(0);
    }

    public final void D4() {
        v4().b().observe(this, new Observer() { // from class: dc.kz1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                RateFeedbackActivity.E4(this.a, (BaseResponseBean) obj);
            }
        });
        v4().a().observe(this, new Observer() { // from class: dc.jz1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                RateFeedbackActivity.F4(this.a, (String) obj);
            }
        });
    }

    @Override // android.app.Activity
    public void finish() {
        cu2.a(this);
        super.finish();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        u4("bad_comment_popup_close_click", "click", "bad_comment_popup_close", "button");
        super.onBackPressed();
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityRateFeedbackBinding activityRateFeedbackBindingC = ActivityRateFeedbackBinding.c(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(activityRateFeedbackBindingC, "inflate(layoutInflater)");
        this.a = activityRateFeedbackBindingC;
        if (activityRateFeedbackBindingC == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityRateFeedbackBindingC = null;
        }
        setContentView(activityRateFeedbackBindingC.getRoot());
        w4();
        D4();
        u4("bad_comment_popup_exposure", "exposure", "bad_comment_popup", "popup");
        EventBus.getDefault().register(this);
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        EventBus.getDefault().unregister(this);
        super.onDestroy();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onMessage(@NotNull LoginOrOfflineEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event.isLogin()) {
            return;
        }
        finish();
    }

    public final void u4(String str, String str2, String str3, String str4) {
        ku1.c("evaluation guide", str, str2, str3, str4, null, null, null, 128, null);
    }

    public final RateFeedbackModel v4() {
        return (RateFeedbackModel) this.d.getValue();
    }

    public final void w4() {
        ActivityRateFeedbackBinding activityRateFeedbackBinding = this.a;
        ActivityRateFeedbackBinding activityRateFeedbackBinding2 = null;
        if (activityRateFeedbackBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityRateFeedbackBinding = null;
        }
        activityRateFeedbackBinding.c.setFocusable(true);
        ActivityRateFeedbackBinding activityRateFeedbackBinding3 = this.a;
        if (activityRateFeedbackBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityRateFeedbackBinding3 = null;
        }
        activityRateFeedbackBinding3.c.setFocusableInTouchMode(true);
        ActivityRateFeedbackBinding activityRateFeedbackBinding4 = this.a;
        if (activityRateFeedbackBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityRateFeedbackBinding4 = null;
        }
        activityRateFeedbackBinding4.c.requestFocus();
        ActivityRateFeedbackBinding activityRateFeedbackBinding5 = this.a;
        if (activityRateFeedbackBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityRateFeedbackBinding5 = null;
        }
        activityRateFeedbackBinding5.d.setOnClickListener(new View.OnClickListener() { // from class: dc.iz1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RateFeedbackActivity.x4(this.a, view);
            }
        });
        ActivityRateFeedbackBinding activityRateFeedbackBinding6 = this.a;
        if (activityRateFeedbackBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityRateFeedbackBinding6 = null;
        }
        EditText editText = activityRateFeedbackBinding6.c;
        Intrinsics.checkNotNullExpressionValue(editText, "binding.etFeedback");
        editText.addTextChangedListener(new a());
        ActivityRateFeedbackBinding activityRateFeedbackBinding7 = this.a;
        if (activityRateFeedbackBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityRateFeedbackBinding2 = activityRateFeedbackBinding7;
        }
        activityRateFeedbackBinding2.b.setOnClickListener(new View.OnClickListener() { // from class: dc.lz1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RateFeedbackActivity.y4(this.a, view);
            }
        });
    }
}
