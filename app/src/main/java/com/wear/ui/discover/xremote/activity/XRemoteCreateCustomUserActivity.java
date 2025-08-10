package com.wear.ui.discover.xremote.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import androidx.activity.ComponentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.lovense.wear.R;
import com.wear.BaseActivity;
import com.wear.bean.XRemoteAppUserBean;
import com.wear.databinding.ActivityXremoteCreateCustomUserBinding;
import com.wear.ui.discover.xremote.activity.XRemoteCreateCustomUserActivity;
import com.wear.ui.discover.xremote.model.XRemoteCreateCustomUserModel;
import com.wear.widget.MyActionBar;
import dc.th4;
import dc.vl2;
import dc.ye3;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Regex;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import rx.Subscription;

/* compiled from: XRemoteCreateCustomUserActivity.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u000e\u001a\u00020\u000fH\u0002J\b\u0010\u0010\u001a\u00020\u000fH\u0002J\u0012\u0010\u0011\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0014J\b\u0010\u0014\u001a\u00020\u000fH\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/wear/ui/discover/xremote/activity/XRemoteCreateCustomUserActivity;", "Lcom/wear/BaseActivity;", "Lcom/wear/network/presenter/base/PresenterLife;", "()V", "binding", "Lcom/wear/databinding/ActivityXremoteCreateCustomUserBinding;", "subscription", "Lrx/Subscription;", "viewModel", "Lcom/wear/ui/discover/xremote/model/XRemoteCreateCustomUserModel;", "getViewModel", "()Lcom/wear/ui/discover/xremote/model/XRemoteCreateCustomUserModel;", "viewModel$delegate", "Lkotlin/Lazy;", "initView", "", "observableViewModelData", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class XRemoteCreateCustomUserActivity extends BaseActivity<vl2> {
    public ActivityXremoteCreateCustomUserBinding a;

    @NotNull
    public final Lazy b = new ViewModelLazy(Reflection.getOrCreateKotlinClass(XRemoteCreateCustomUserModel.class), new c(this), new b(this), new d(null, this));

    @Nullable
    public Subscription c;

    /* compiled from: TextView.kt */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J*\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0016J*\u0010\r\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016¨\u0006\u000f¸\u0006\u0000"}, d2 = {"androidx/core/widget/TextViewKt$addTextChangedListener$textWatcher$1", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "text", "", TtmlNode.START, "", "count", TtmlNode.ANNOTATION_POSITION_AFTER, "onTextChanged", TtmlNode.ANNOTATION_POSITION_BEFORE, "core-ktx_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    @SourceDebugExtension({"SMAP\nTextView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TextView.kt\nandroidx/core/widget/TextViewKt$addTextChangedListener$textWatcher$1\n*L\n1#1,97:1\n*E\n"})
    public static final class a implements TextWatcher {
        public final /* synthetic */ EditText b;

        public a(EditText editText) {
            this.b = editText;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@Nullable Editable s) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(@Nullable CharSequence text, int start, int count, int after) {
        }

        /* JADX WARN: Removed duplicated region for block: B:23:0x0073  */
        /* JADX WARN: Removed duplicated region for block: B:36:0x0094  */
        @Override // android.text.TextWatcher
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void onTextChanged(@org.jetbrains.annotations.Nullable java.lang.CharSequence r4, int r5, int r6, int r7) {
            /*
                r3 = this;
                com.wear.ui.discover.xremote.activity.XRemoteCreateCustomUserActivity r5 = com.wear.ui.discover.xremote.activity.XRemoteCreateCustomUserActivity.this
                com.wear.databinding.ActivityXremoteCreateCustomUserBinding r5 = com.wear.ui.discover.xremote.activity.XRemoteCreateCustomUserActivity.s4(r5)
                java.lang.String r6 = "binding"
                r7 = 0
                if (r5 != 0) goto Lf
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r6)
                r5 = r7
            Lf:
                android.widget.TextView r5 = r5.e
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                if (r4 == 0) goto L21
                int r1 = r4.length()
                java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
                goto L22
            L21:
                r1 = r7
            L22:
                r0.append(r1)
                java.lang.String r1 = "/20"
                r0.append(r1)
                java.lang.String r0 = r0.toString()
                r5.setText(r0)
                com.wear.ui.discover.xremote.activity.XRemoteCreateCustomUserActivity r5 = com.wear.ui.discover.xremote.activity.XRemoteCreateCustomUserActivity.this
                com.wear.databinding.ActivityXremoteCreateCustomUserBinding r5 = com.wear.ui.discover.xremote.activity.XRemoteCreateCustomUserActivity.s4(r5)
                if (r5 != 0) goto L3d
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r6)
                r5 = r7
            L3d:
                android.widget.TextView r5 = r5.f
                r0 = 8
                r5.setVisibility(r0)
                android.widget.EditText r5 = r3.b
                android.content.Context r0 = r5.getContext()
                r1 = 2131233124(0x7f080964, float:1.8082377E38)
                android.graphics.drawable.Drawable r0 = dc.th4.d(r0, r1)
                r5.setBackground(r0)
                com.wear.ui.discover.xremote.activity.XRemoteCreateCustomUserActivity r5 = com.wear.ui.discover.xremote.activity.XRemoteCreateCustomUserActivity.this
                com.wear.databinding.ActivityXremoteCreateCustomUserBinding r5 = com.wear.ui.discover.xremote.activity.XRemoteCreateCustomUserActivity.s4(r5)
                if (r5 != 0) goto L60
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r6)
                r5 = r7
            L60:
                android.widget.TextView r5 = r5.c
                r0 = 1
                r1 = 0
                if (r4 == 0) goto L73
                int r2 = r4.length()
                if (r2 != 0) goto L6e
                r2 = 1
                goto L6f
            L6e:
                r2 = 0
            L6f:
                if (r2 != 0) goto L73
                r2 = 1
                goto L74
            L73:
                r2 = 0
            L74:
                r5.setEnabled(r2)
                com.wear.ui.discover.xremote.activity.XRemoteCreateCustomUserActivity r5 = com.wear.ui.discover.xremote.activity.XRemoteCreateCustomUserActivity.this
                com.wear.databinding.ActivityXremoteCreateCustomUserBinding r5 = com.wear.ui.discover.xremote.activity.XRemoteCreateCustomUserActivity.s4(r5)
                if (r5 != 0) goto L83
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r6)
                goto L84
            L83:
                r7 = r5
            L84:
                android.widget.TextView r5 = r7.c
                if (r4 == 0) goto L94
                int r4 = r4.length()
                if (r4 != 0) goto L90
                r4 = 1
                goto L91
            L90:
                r4 = 0
            L91:
                if (r4 != 0) goto L94
                goto L95
            L94:
                r0 = 0
            L95:
                if (r0 == 0) goto La1
                com.wear.ui.discover.xremote.activity.XRemoteCreateCustomUserActivity r4 = com.wear.ui.discover.xremote.activity.XRemoteCreateCustomUserActivity.this
                r6 = 2131099981(0x7f06014d, float:1.781233E38)
                int r4 = r4.getColor(r6)
                goto Laa
            La1:
                com.wear.ui.discover.xremote.activity.XRemoteCreateCustomUserActivity r4 = com.wear.ui.discover.xremote.activity.XRemoteCreateCustomUserActivity.this
                r6 = 2131100694(0x7f060416, float:1.7813777E38)
                int r4 = r4.getColor(r6)
            Laa:
                r5.setTextColor(r4)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.wear.ui.discover.xremote.activity.XRemoteCreateCustomUserActivity.a.onTextChanged(java.lang.CharSequence, int, int, int):void");
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

    public static final void D4(XRemoteCreateCustomUserActivity this$0, XRemoteAppUserBean.DataBean.ApplicationAccount applicationAccount) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dissDialog();
        if (applicationAccount != null) {
            Intent intent = new Intent();
            intent.putExtra("account", applicationAccount);
            this$0.setResult(-1, intent);
            this$0.finish();
        }
    }

    public static final void v4(XRemoteCreateCustomUserActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.onBackPressed();
    }

    public static final CharSequence w4(String regex, CharSequence source, int i, int i2, Spanned spanned, int i3, int i4) {
        Intrinsics.checkNotNullParameter(regex, "$regex");
        Intrinsics.checkNotNullExpressionValue(source, "source");
        return new Regex(regex).matches(source) ? source : "";
    }

    public static final void x4(XRemoteCreateCustomUserActivity this$0, View view) {
        String str;
        String string;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ActivityXremoteCreateCustomUserBinding activityXremoteCreateCustomUserBinding = this$0.a;
        ActivityXremoteCreateCustomUserBinding activityXremoteCreateCustomUserBinding2 = null;
        if (activityXremoteCreateCustomUserBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityXremoteCreateCustomUserBinding = null;
        }
        if (activityXremoteCreateCustomUserBinding.d.getText().toString().length() < 6) {
            ActivityXremoteCreateCustomUserBinding activityXremoteCreateCustomUserBinding3 = this$0.a;
            if (activityXremoteCreateCustomUserBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityXremoteCreateCustomUserBinding3 = null;
            }
            activityXremoteCreateCustomUserBinding3.f.setVisibility(0);
            ActivityXremoteCreateCustomUserBinding activityXremoteCreateCustomUserBinding4 = this$0.a;
            if (activityXremoteCreateCustomUserBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                activityXremoteCreateCustomUserBinding2 = activityXremoteCreateCustomUserBinding4;
            }
            activityXremoteCreateCustomUserBinding2.d.setBackground(th4.d(this$0, R.drawable.shape_xremote_edittext_custom_name_warn));
            return;
        }
        Bundle extras = this$0.getIntent().getExtras();
        String string2 = extras != null ? extras.getString("applicationId") : null;
        Bundle extras2 = this$0.getIntent().getExtras();
        if (extras2 == null || (string = extras2.getString("applicationName")) == null) {
            str = null;
        } else {
            String lowerCase = string.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
            str = lowerCase;
        }
        ye3.j("game", "game_success_activation", "click", string2, "button", "2", str, -1L);
        this$0.showDialog();
        XRemoteCreateCustomUserModel xRemoteCreateCustomUserModelT4 = this$0.t4();
        ActivityXremoteCreateCustomUserBinding activityXremoteCreateCustomUserBinding5 = this$0.a;
        if (activityXremoteCreateCustomUserBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityXremoteCreateCustomUserBinding2 = activityXremoteCreateCustomUserBinding5;
        }
        this$0.c = xRemoteCreateCustomUserModelT4.a(activityXremoteCreateCustomUserBinding2.d.getText().toString(), this$0);
    }

    public final void C4() {
        t4().b().observe(this, new Observer() { // from class: dc.h23
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                XRemoteCreateCustomUserActivity.D4(this.a, (XRemoteAppUserBean.DataBean.ApplicationAccount) obj);
            }
        });
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityXremoteCreateCustomUserBinding activityXremoteCreateCustomUserBindingC = ActivityXremoteCreateCustomUserBinding.c(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(activityXremoteCreateCustomUserBindingC, "inflate(layoutInflater)");
        this.a = activityXremoteCreateCustomUserBindingC;
        if (activityXremoteCreateCustomUserBindingC == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityXremoteCreateCustomUserBindingC = null;
        }
        setContentView(activityXremoteCreateCustomUserBindingC.getRoot());
        u4();
        C4();
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        dissDialog();
        Subscription subscription = this.c;
        if (subscription != null) {
            subscription.unsubscribe();
        }
    }

    public final XRemoteCreateCustomUserModel t4() {
        return (XRemoteCreateCustomUserModel) this.b.getValue();
    }

    public final void u4() {
        ActivityXremoteCreateCustomUserBinding activityXremoteCreateCustomUserBinding = this.a;
        ActivityXremoteCreateCustomUserBinding activityXremoteCreateCustomUserBinding2 = null;
        if (activityXremoteCreateCustomUserBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityXremoteCreateCustomUserBinding = null;
        }
        activityXremoteCreateCustomUserBinding.b.setBackAction(new MyActionBar.f() { // from class: dc.g23
            @Override // com.wear.widget.MyActionBar.f
            public final void performAction(View view) {
                XRemoteCreateCustomUserActivity.v4(this.a, view);
            }
        });
        ActivityXremoteCreateCustomUserBinding activityXremoteCreateCustomUserBinding3 = this.a;
        if (activityXremoteCreateCustomUserBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityXremoteCreateCustomUserBinding3 = null;
        }
        EditText editText = activityXremoteCreateCustomUserBinding3.d;
        editText.requestFocus();
        Intrinsics.checkNotNullExpressionValue(editText, "");
        editText.addTextChangedListener(new a(editText));
        final String str = "^[a-z0-9A-Z]+$";
        editText.setFilters(new InputFilter[]{new InputFilter() { // from class: dc.i23
            @Override // android.text.InputFilter
            public final CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
                return XRemoteCreateCustomUserActivity.w4(str, charSequence, i, i2, spanned, i3, i4);
            }
        }, new InputFilter.LengthFilter(20)});
        ActivityXremoteCreateCustomUserBinding activityXremoteCreateCustomUserBinding4 = this.a;
        if (activityXremoteCreateCustomUserBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityXremoteCreateCustomUserBinding4 = null;
        }
        activityXremoteCreateCustomUserBinding4.c.setEnabled(false);
        ActivityXremoteCreateCustomUserBinding activityXremoteCreateCustomUserBinding5 = this.a;
        if (activityXremoteCreateCustomUserBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityXremoteCreateCustomUserBinding5 = null;
        }
        activityXremoteCreateCustomUserBinding5.c.setTextColor(getColor(R.color.text_color_45));
        ActivityXremoteCreateCustomUserBinding activityXremoteCreateCustomUserBinding6 = this.a;
        if (activityXremoteCreateCustomUserBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityXremoteCreateCustomUserBinding2 = activityXremoteCreateCustomUserBinding6;
        }
        activityXremoteCreateCustomUserBinding2.c.setOnClickListener(new View.OnClickListener() { // from class: dc.j23
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                XRemoteCreateCustomUserActivity.x4(this.a, view);
            }
        });
    }
}
