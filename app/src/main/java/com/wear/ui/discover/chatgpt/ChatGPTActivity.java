package com.wear.ui.discover.chatgpt;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.lovense.wear.R;
import com.wear.BaseActivity;
import com.wear.databinding.ActivityChatGptBinding;
import com.wear.main.toy.ToyActivity;
import com.wear.ui.discover.chatgpt.ChatGPTActivity;
import com.wear.widget.MyActionBar;
import dc.pc1;
import dc.pe3;
import dc.pj3;
import dc.th4;
import dc.vl2;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

/* compiled from: ChatGPTActivity.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0002J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0014J\b\u0010\u000b\u001a\u00020\u0007H\u0014J\b\u0010\f\u001a\u00020\u0007H\u0014J\b\u0010\r\u001a\u00020\u0007H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/wear/ui/discover/chatgpt/ChatGPTActivity;", "Lcom/wear/BaseActivity;", "Lcom/wear/network/presenter/base/PresenterLife;", "()V", "binding", "Lcom/wear/databinding/ActivityChatGptBinding;", "initAction", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onResume", "settingBarColor", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class ChatGPTActivity extends BaseActivity<vl2> {
    public ActivityChatGptBinding a;

    public static final void t4(ChatGPTActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.onBackPressed();
    }

    public static final void u4(ChatGPTActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        pj3.f(this$0, ToyActivity.class);
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityChatGptBinding activityChatGptBindingC = ActivityChatGptBinding.c(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(activityChatGptBindingC, "inflate(layoutInflater)");
        this.a = activityChatGptBindingC;
        if (activityChatGptBindingC == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityChatGptBindingC = null;
        }
        setContentView(activityChatGptBindingC.getRoot());
        s4();
        if (savedInstanceState == null) {
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
            FragmentTransaction fragmentTransactionBeginTransaction = supportFragmentManager.beginTransaction();
            Intrinsics.checkNotNullExpressionValue(fragmentTransactionBeginTransaction, "beginTransaction()");
            fragmentTransactionBeginTransaction.setReorderingAllowed(true).add(R.id.constraint, new PatternChatGPTFragment());
            fragmentTransactionBeginTransaction.commit();
        }
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        ActivityChatGptBinding activityChatGptBinding = this.a;
        if (activityChatGptBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityChatGptBinding = null;
        }
        activityChatGptBinding.b.s();
    }

    @Override // com.wear.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        ActivityChatGptBinding activityChatGptBinding = this.a;
        if (activityChatGptBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityChatGptBinding = null;
        }
        activityChatGptBinding.b.setToy(pc1.a.P());
    }

    public final void s4() {
        ActivityChatGptBinding activityChatGptBinding = this.a;
        if (activityChatGptBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityChatGptBinding = null;
        }
        MyActionBar myActionBar = activityChatGptBinding.b;
        myActionBar.setBackAction(new MyActionBar.f() { // from class: dc.mv2
            @Override // com.wear.widget.MyActionBar.f
            public final void performAction(View view) {
                ChatGPTActivity.t4(this.a, view);
            }
        });
        myActionBar.setTitle("Pattern");
        myActionBar.setToysAction(new MyActionBar.f() { // from class: dc.lv2
            @Override // com.wear.widget.MyActionBar.f
            public final void performAction(View view) {
                ChatGPTActivity.u4(this.a, view);
            }
        }, true, this);
        myActionBar.n();
        myActionBar.setParentBackgroundColor(th4.b(this, R.color.transparent));
    }

    @Override // com.wear.BaseActivity
    public void settingBarColor() {
        int iD = pe3.d("SKIN");
        View decorView = getWindow().getDecorView();
        Intrinsics.checkNotNullExpressionValue(decorView, "window.decorView");
        int i = Build.VERSION.SDK_INT;
        if (i >= 29) {
            getWindow().setNavigationBarContrastEnforced(false);
        }
        if ((iD == 0 && getResources().getConfiguration().uiMode == 33) || iD == 2 || i < 26) {
            decorView.setSystemUiVisibility(1792);
        } else {
            decorView.setSystemUiVisibility(10000);
        }
        getWindow().setNavigationBarColor(th4.b(this, R.color.chat_bottom_bg));
        getWindow().setStatusBarColor(0);
    }
}
