package com.wear.component.test;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.component.dxutilcode.lib.utils.ToastUtils;
import com.wear.component.test.TestDialog;
import com.wear.component.ui.dialog.BaseCenterDialog;
import com.wear.dao.DaoUtils;
import com.wear.databinding.DebugDialogBinding;
import dc.de0;
import dc.gd0;
import dc.jb0;
import dc.jp1;
import dc.mp1;
import dc.nb0;
import dc.se0;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: TestDialog.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0002J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u000eH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"Lcom/wear/component/test/TestDialog;", "Lcom/wear/component/ui/dialog/BaseCenterDialog;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "isUserFeatureConfig", "", "mBinding", "Lcom/wear/databinding/DebugDialogBinding;", "getMBinding", "()Lcom/wear/databinding/DebugDialogBinding;", "mBinding$delegate", "Lkotlin/Lazy;", "getView", "Landroid/view/View;", "initToySwitch", "", "initView", "view", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class TestDialog extends BaseCenterDialog {

    @NotNull
    public final Lazy d;
    public boolean e;

    /* compiled from: TestDialog.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/wear/databinding/DebugDialogBinding;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class a extends Lambda implements Function0<DebugDialogBinding> {
        public final /* synthetic */ Context $context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Context context) {
            super(0);
            this.$context = context;
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final DebugDialogBinding invoke() {
            DebugDialogBinding debugDialogBindingC = DebugDialogBinding.c(LayoutInflater.from(this.$context), null, false);
            Intrinsics.checkNotNullExpressionValue(debugDialogBindingC, "inflate(LayoutInflater.from(context), null, false)");
            return debugDialogBindingC;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TestDialog(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.d = LazyKt__LazyJVMKt.lazy(new a(context));
        this.e = jp1.a.a("sp_key_feature_config_switch");
    }

    public static final void h(TestDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismiss();
    }

    public static final void i(TestDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.e) {
            ToastUtils.z("热切换组件已打开，玩具开关由服务器控制", new Object[0]);
            return;
        }
        jp1.a.b("sp_key_toy_switch", !r4.a("sp_key_toy_switch"));
        this$0.g();
        StringBuilder sb = new StringBuilder();
        sb.append("size:");
        List<nb0> listC = jb0.e.c();
        sb.append(listC != null ? listC.size() : 0);
        sb.toString();
        se0.g(new Runnable() { // from class: dc.qt1
            @Override // java.lang.Runnable
            public final void run() {
                TestDialog.j();
            }
        }, 100L);
    }

    public static final void j() {
        gd0.m(true);
    }

    public static final void k(TestDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        boolean z = !this$0.e;
        this$0.e = z;
        jp1.a aVar = jp1.a;
        aVar.b("sp_key_feature_config_switch", z);
        if (this$0.e) {
            aVar.b("sp_key_toy_switch", false);
        }
        this$0.g();
        se0.g(new Runnable() { // from class: dc.ot1
            @Override // java.lang.Runnable
            public final void run() {
                TestDialog.l();
            }
        }, 200L);
    }

    public static final void l() {
        gd0.m(true);
    }

    public static final void m(View view) {
        DaoUtils.getToyDao().clearTable();
        DaoUtils.getToyTypeDao().clearTable();
        jb0.a aVar = jb0.e;
        aVar.b();
        Object[] objArr = new Object[1];
        StringBuilder sb = new StringBuilder();
        sb.append("ToyDaoBridge.findAll(): ");
        List<nb0> listC = aVar.c();
        sb.append(listC != null ? Integer.valueOf(listC.size()) : null);
        objArr[0] = sb.toString();
        de0.i(objArr);
        ToastUtils.z("清空玩具数据库", new Object[0]);
    }

    public static final void n(View view) {
        ToastUtils.z("YeTest1 click done", new Object[0]);
    }

    public static final void o(View view) {
        ToastUtils.z("YeTest2 click", new Object[0]);
    }

    @Override // com.wear.component.ui.dialog.BaseCenterDialog
    @NotNull
    public View b() {
        LinearLayout root = f().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "mBinding.root");
        return root;
    }

    @Override // com.wear.component.ui.dialog.BaseCenterDialog
    public void c(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        f().b.setOnClickListener(new View.OnClickListener() { // from class: dc.kt1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                TestDialog.h(this.a, view2);
            }
        });
        g();
        f().e.setOnClickListener(new View.OnClickListener() { // from class: dc.jt1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                TestDialog.i(this.a, view2);
            }
        });
        f().c.setOnClickListener(new View.OnClickListener() { // from class: dc.mt1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                TestDialog.k(this.a, view2);
            }
        });
        f().d.setOnClickListener(new View.OnClickListener() { // from class: dc.pt1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                TestDialog.m(view2);
            }
        });
        f().f.setOnClickListener(new View.OnClickListener() { // from class: dc.lt1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                TestDialog.n(view2);
            }
        });
        f().g.setOnClickListener(new View.OnClickListener() { // from class: dc.nt1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                TestDialog.o(view2);
            }
        });
    }

    public final DebugDialogBinding f() {
        return (DebugDialogBinding) this.d.getValue();
    }

    public final synchronized void g() {
        boolean zA = this.e ? mp1.a.a() : jp1.a.a("sp_key_toy_switch");
        TextView textView = f().e;
        StringBuilder sb = new StringBuilder();
        sb.append("玩具开关:");
        sb.append(zA ? "New" : "Old");
        textView.setText(sb.toString());
        f().c.setText(this.e ? "关闭热开关组件(当前开启状态)" : "启动热开关组件(当前关闭状态)");
    }
}
