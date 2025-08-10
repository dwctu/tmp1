package dc;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;
import com.google.android.play.core.review.ReviewInfo;
import com.google.android.play.core.review.ReviewManager;
import com.google.android.play.core.review.ReviewManagerFactory;
import com.google.android.play.core.tasks.OnCompleteListener;
import com.google.android.play.core.tasks.Task;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.lovense.wear.R;
import com.wear.bean.RateFeature;
import com.wear.bean.RateInfoBean;
import com.wear.databinding.PopupRateBinding;
import com.wear.main.account.rate.RateFeedbackActivity;
import dc.yf3;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: RatePopupWindow.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J0\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u0010H\u0002J\u0010\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\b\u0010 \u001a\u00020\u0016H\u0002J\b\u0010!\u001a\u00020\u0016H\u0002J\u0010\u0010\"\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0006\u0010#\u001a\u00020\u0016R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/wear/widget/dialog/RatePopupWindow;", "Landroid/widget/PopupWindow;", "context", "Landroid/content/Context;", "rateFeature", "Lcom/wear/bean/RateFeature;", "(Landroid/content/Context;Lcom/wear/bean/RateFeature;)V", "binding", "Lcom/wear/databinding/PopupRateBinding;", "getBinding", "()Lcom/wear/databinding/PopupRateBinding;", "binding$delegate", "Lkotlin/Lazy;", "getContext", "()Landroid/content/Context;", "dismissLogFlag", "", "localRateInfo", "Lcom/wear/bean/RateInfoBean;", "type", "", "addLog", "", "eventId", "", "eventType", "elementId", "elementType", "isSendElementNameAndContent", "backgroundAlpha", "bgAlpha", "", "googleReview", "openGooglePlay", "selectType", "show", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public final class ks3 extends PopupWindow {

    @NotNull
    public final Context a;

    @NotNull
    public final RateFeature b;

    @NotNull
    public final Lazy c;
    public int d;
    public RateInfoBean e;
    public boolean f;

    /* compiled from: RatePopupWindow.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[RateFeature.values().length];
            iArr[RateFeature.Live.ordinal()] = 1;
            iArr[RateFeature.Sync.ordinal()] = 2;
            iArr[RateFeature.Video.ordinal()] = 3;
            iArr[RateFeature.Voice.ordinal()] = 4;
            iArr[RateFeature.GroupSync.ordinal()] = 5;
            iArr[RateFeature.GroupDS.ordinal()] = 6;
            iArr[RateFeature.ControlRoulette.ordinal()] = 7;
            iArr[RateFeature.ControlLink.ordinal()] = 8;
            iArr[RateFeature.RemoteControl.ordinal()] = 9;
            a = iArr;
        }
    }

    /* compiled from: RatePopupWindow.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/wear/databinding/PopupRateBinding;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class b extends Lambda implements Function0<PopupRateBinding> {
        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final PopupRateBinding invoke() {
            PopupRateBinding popupRateBindingC = PopupRateBinding.c(LayoutInflater.from(ks3.this.getA()));
            Intrinsics.checkNotNullExpressionValue(popupRateBindingC, "inflate(LayoutInflater.from(context))");
            return popupRateBindingC;
        }
    }

    public ks3(@NotNull Context context, @NotNull RateFeature rateFeature) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(rateFeature, "rateFeature");
        this.a = context;
        this.b = rateFeature;
        this.c = LazyKt__LazyJVMKt.lazy(new b());
        this.d = -1;
        this.f = true;
        setContentView(h().getRoot());
        setWidth(-1);
        setHeight(-2);
        setOutsideTouchable(true);
        setAnimationStyle(R.style.MaterialDialogSheetAnimation);
        setFocusable(true);
        setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: dc.vq3
            @Override // android.widget.PopupWindow.OnDismissListener
            public final void onDismiss() {
                ks3.a(this.a);
            }
        });
        h().d.setOnClickListener(new View.OnClickListener() { // from class: dc.sq3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ks3.b(this.a, view);
            }
        });
        h().e.setOnClickListener(new View.OnClickListener() { // from class: dc.tq3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ks3.c(this.a, view);
            }
        });
        h().b.setOnClickListener(new View.OnClickListener() { // from class: dc.xq3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ks3.d(this.a, view);
            }
        });
        h().c.setOnClickListener(new View.OnClickListener() { // from class: dc.uq3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ks3.e(this.a, view);
            }
        });
        this.e = new RateInfoBean(System.currentTimeMillis(), rateFeature.getFeature(), false);
        yf3 yf3VarA = yf3.i.a();
        RateInfoBean rateInfoBean = this.e;
        if (rateInfoBean == null) {
            Intrinsics.throwUninitializedPropertyAccessException("localRateInfo");
            rateInfoBean = null;
        }
        yf3VarA.p(rateInfoBean);
        f("evaluation_popup_exposure", "exposure", "evaluation_popup", "popup", true);
    }

    public static final void a(ks3 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.g(1.0f);
        this$0.h().f.clearAnimation();
        this$0.h().g.clearAnimation();
        RateInfoBean rateInfoBean = this$0.e;
        RateInfoBean rateInfoBean2 = null;
        if (rateInfoBean == null) {
            Intrinsics.throwUninitializedPropertyAccessException("localRateInfo");
            rateInfoBean = null;
        }
        rateInfoBean.setOperationTime(System.currentTimeMillis());
        yf3.b bVar = yf3.i;
        yf3 yf3VarA = bVar.a();
        RateInfoBean rateInfoBean3 = this$0.e;
        if (rateInfoBean3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("localRateInfo");
            rateInfoBean3 = null;
        }
        yf3VarA.p(rateInfoBean3);
        yf3 yf3VarA2 = bVar.a();
        RateInfoBean rateInfoBean4 = this$0.e;
        if (rateInfoBean4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("localRateInfo");
        } else {
            rateInfoBean2 = rateInfoBean4;
        }
        yf3VarA2.q(rateInfoBean2);
        if (this$0.f) {
            this$0.f("evaluation_popup_close_click", "click", "evaluation_popup_close", "button", false);
        }
    }

    public static final void b(ks3 this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.u(0);
    }

    public static final void c(ks3 this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.u(1);
    }

    public static final void d(ks3 this$0, View view) {
        String str;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        RateInfoBean rateInfoBean = this$0.e;
        if (rateInfoBean == null) {
            Intrinsics.throwUninitializedPropertyAccessException("localRateInfo");
            rateInfoBean = null;
        }
        rateInfoBean.setRateApp(true);
        int i = this$0.d;
        if (i == 0) {
            pj3.f(this$0.a, RateFeedbackActivity.class);
            str = "bad";
        } else if (i != 1) {
            str = "";
        } else {
            this$0.j();
            str = "excellent";
        }
        this$0.f("evaluation_popup_score_click", "click", "evaluation_popup_score", str, true);
        this$0.f = false;
        this$0.dismiss();
    }

    public static final void e(ks3 this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismiss();
    }

    public static final void k(ReviewManager this_apply, ks3 this$0, Task task) {
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(task, "task");
        if (!task.isSuccessful()) {
            this$0.t();
            String str = "Review flow failed: " + task.getException();
            return;
        }
        Object result = task.getResult();
        Intrinsics.checkNotNullExpressionValue(result, "task.result");
        Context context = this$0.a;
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
        Task<Void> taskLaunchReviewFlow = this_apply.launchReviewFlow((Activity) context, (ReviewInfo) result);
        Intrinsics.checkNotNullExpressionValue(taskLaunchReviewFlow, "this.launchReviewFlow(co… as Activity, reviewInfo)");
        taskLaunchReviewFlow.addOnCompleteListener(new OnCompleteListener() { // from class: dc.yq3
            @Override // com.google.android.play.core.tasks.OnCompleteListener
            public final void onComplete(Task task2) {
                ks3.l(task2);
            }
        });
    }

    public static final void l(Task it) {
        Intrinsics.checkNotNullParameter(it, "it");
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void f(java.lang.String r19, java.lang.String r20, java.lang.String r21, java.lang.String r22, boolean r23) {
        /*
            r18 = this;
            java.lang.String r0 = "5"
            java.lang.String r1 = "4"
            java.lang.String r2 = "3"
            java.lang.String r3 = ""
            java.lang.String r4 = "0"
            java.lang.String r5 = "2"
            java.lang.String r6 = "1"
            r7 = r18
            if (r23 == 0) goto L35
            com.wear.bean.RateFeature r8 = r7.b
            int[] r9 = dc.ks3.a.a
            int r8 = r8.ordinal()
            r8 = r9[r8]
            switch(r8) {
                case 1: goto L33;
                case 2: goto L30;
                case 3: goto L2e;
                case 4: goto L2c;
                case 5: goto L29;
                case 6: goto L27;
                case 7: goto L24;
                case 8: goto L22;
                case 9: goto L20;
                default: goto L1f;
            }
        L1f:
            goto L35
        L20:
            r13 = r0
            goto L25
        L22:
            r13 = r1
            goto L25
        L24:
            r13 = r2
        L25:
            r14 = r4
            goto L37
        L27:
            java.lang.String r0 = "6"
        L29:
            r14 = r0
            r13 = r5
            goto L37
        L2c:
            r14 = r1
            goto L31
        L2e:
            r14 = r2
            goto L31
        L30:
            r14 = r5
        L31:
            r13 = r6
            goto L37
        L33:
            r13 = r6
            goto L36
        L35:
            r13 = r3
        L36:
            r14 = r13
        L37:
            r15 = 0
            r16 = 128(0x80, float:1.8E-43)
            r17 = 0
            java.lang.String r8 = "evaluation guide"
            r9 = r19
            r10 = r20
            r11 = r21
            r12 = r22
            dc.ku1.c(r8, r9, r10, r11, r12, r13, r14, r15, r16, r17)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: dc.ks3.f(java.lang.String, java.lang.String, java.lang.String, java.lang.String, boolean):void");
    }

    public final void g(float f) {
        try {
            Context context = this.a;
            Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
            WindowManager.LayoutParams attributes = ((Activity) context).getWindow().getAttributes();
            attributes.alpha = f;
            if (f == 1.0f) {
                ((Activity) this.a).getWindow().clearFlags(2);
            } else {
                ((Activity) this.a).getWindow().addFlags(2);
            }
            ((Activity) this.a).getWindow().setAttributes(attributes);
        } catch (Exception e) {
            e.printStackTrace();
            FirebaseCrashlytics.getInstance().recordException(e);
        }
    }

    public final PopupRateBinding h() {
        return (PopupRateBinding) this.c.getValue();
    }

    @NotNull
    /* renamed from: i, reason: from getter */
    public final Context getA() {
        return this.a;
    }

    public final void j() {
        final ReviewManager reviewManagerCreate = ReviewManagerFactory.create(this.a);
        Task<ReviewInfo> taskRequestReviewFlow = reviewManagerCreate.requestReviewFlow();
        Intrinsics.checkNotNullExpressionValue(taskRequestReviewFlow, "this.requestReviewFlow()");
        taskRequestReviewFlow.addOnCompleteListener(new OnCompleteListener() { // from class: dc.wq3
            @Override // com.google.android.play.core.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                ks3.k(reviewManagerCreate, this, task);
            }
        });
    }

    public final void t() {
        try {
            if (this.a.getPackageName() != null) {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + this.a.getPackageName()));
                intent.addFlags(268435456);
                intent.setPackage("com.android.vending");
                this.a.startActivity(intent);
            }
        } catch (Exception e) {
            e.printStackTrace();
            Intent intent2 = new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=" + this.a.getPackageName()));
            intent2.addFlags(268435456);
            this.a.startActivity(intent2);
        }
    }

    public final void u(int i) {
        if (this.d == i) {
            return;
        }
        this.d = i;
        h().b.setEnabled(true);
        if (i == 0) {
            h().d.setStrokeWidth(1.0f);
            h().e.setStrokeWidth(0.0f);
            h().f.r();
            h().g.q();
            h().g.setProgress(0.0f);
            return;
        }
        if (i != 1) {
            return;
        }
        h().e.setStrokeWidth(1.0f);
        h().d.setStrokeWidth(0.0f);
        h().g.r();
        h().f.q();
        h().f.setProgress(0.0f);
    }

    public final void v() {
        showAtLocation(h().getRoot(), 80, 0, 0);
        g(0.6f);
    }
}
