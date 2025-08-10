package com.wear.ui.me;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.provider.MediaStore;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.viewpager2.widget.ViewPager2;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.epicgames.unreal.psoservices.PSOProgramService;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.lovense.wear.R;
import com.wear.BaseActivity;
import com.wear.bean.ReportChooseImageBean;
import com.wear.bean.ReportControlRouleteeBean;
import com.wear.bean.UserJoinChatBean;
import com.wear.bean.chat.MessageSelected;
import com.wear.databinding.ActivityControlRouletteReportBinding;
import com.wear.main.longDistance.report.BigPictureAdapter;
import com.wear.net.model.RemoteResponse;
import com.wear.ui.chat.NewChatSelectActivity;
import com.wear.ui.discover.roulette.viewmodel.RouletteReportViewModel;
import com.wear.ui.longDistance.imagepicker.data.MediaFile;
import com.wear.ui.me.ControlRouletteReportActivity;
import com.wear.ui.me.adapter.ReportChooseImgAdapter;
import com.wear.util.WearUtils;
import dc.ah4;
import dc.h04;
import dc.kg3;
import dc.se3;
import dc.sg3;
import dc.th4;
import dc.uy3;
import dc.vl2;
import dc.w83;
import dc.wz3;
import dc.x83;
import dc.yu1;
import dc.zq;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
import org.bouncycastle.crypto.tls.CipherSuite;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ControlRouletteReportActivity.kt */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 ;2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001;B\u0005¢\u0006\u0002\u0010\u0003J\u0006\u0010+\u001a\u00020,J\b\u0010-\u001a\u00020,H\u0002J\"\u0010.\u001a\u00020,2\u0006\u0010/\u001a\u00020\u00072\u0006\u00100\u001a\u00020\u00072\b\u00101\u001a\u0004\u0018\u000102H\u0015J\u0012\u00103\u001a\u00020,2\b\u00104\u001a\u0004\u0018\u000105H\u0014J\b\u00106\u001a\u00020,H\u0014J\u0010\u00107\u001a\u00020,2\u0006\u00108\u001a\u00020\u0007H\u0002J\u0010\u00109\u001a\u00020,2\u0006\u0010:\u001a\u00020\u0007H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001b\u0010\u0017\u001a\u00020\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0019\u0010\u001aR*\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00020\u001f0\u001ej\b\u0012\u0004\u0012\u00020\u001f` X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001c\u0010%\u001a\u0004\u0018\u00010&X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*¨\u0006<"}, d2 = {"Lcom/wear/ui/me/ControlRouletteReportActivity;", "Lcom/wear/BaseActivity;", "Lcom/wear/network/presenter/base/PresenterLife;", "()V", "binding", "Lcom/wear/databinding/ActivityControlRouletteReportBinding;", "currentIndex", "", "images", "", "Lcom/wear/bean/ReportChooseImageBean;", "repoortReason", "", "getRepoortReason", "()Ljava/lang/String;", "setRepoortReason", "(Ljava/lang/String;)V", "reportChooseImgAdapter", "Lcom/wear/ui/me/adapter/ReportChooseImgAdapter;", "getReportChooseImgAdapter", "()Lcom/wear/ui/me/adapter/ReportChooseImgAdapter;", "setReportChooseImgAdapter", "(Lcom/wear/ui/me/adapter/ReportChooseImgAdapter;)V", "rouletteReportViewModel", "Lcom/wear/ui/discover/roulette/viewmodel/RouletteReportViewModel;", "getRouletteReportViewModel", "()Lcom/wear/ui/discover/roulette/viewmodel/RouletteReportViewModel;", "rouletteReportViewModel$delegate", "Lkotlin/Lazy;", "selectedList", "Ljava/util/ArrayList;", "Lcom/wear/bean/chat/MessageSelected;", "Lkotlin/collections/ArrayList;", "getSelectedList", "()Ljava/util/ArrayList;", "setSelectedList", "(Ljava/util/ArrayList;)V", "userJoinChatBean", "Lcom/wear/bean/UserJoinChatBean;", "getUserJoinChatBean", "()Lcom/wear/bean/UserJoinChatBean;", "setUserJoinChatBean", "(Lcom/wear/bean/UserJoinChatBean;)V", "initRecycle", "", "observableViewModelData", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "showImagesDialog", "position", "updateSelectImageCount", "count", "Companion", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public final class ControlRouletteReportActivity extends BaseActivity<vl2> {

    @NotNull
    public static final a i = new a(null);
    public ActivityControlRouletteReportBinding a;
    public int b;

    @Nullable
    public ReportChooseImgAdapter d;

    @Nullable
    public UserJoinChatBean g;

    @NotNull
    public final List<ReportChooseImageBean> c = new ArrayList();

    @Nullable
    public String e = "";

    @NotNull
    public ArrayList<MessageSelected> f = new ArrayList<>();

    @NotNull
    public final Lazy h = new ViewModelLazy(Reflection.getOrCreateKotlinClass(RouletteReportViewModel.class), new g(this), new f(this), new h(null, this));

    /* compiled from: ControlRouletteReportActivity.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n¨\u0006\u000b"}, d2 = {"Lcom/wear/ui/me/ControlRouletteReportActivity$Companion;", "", "()V", "startAtc", "", "context", "Landroid/content/Context;", "reason", "", "userJoinChatBean", "Lcom/wear/bean/UserJoinChatBean;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull Context context, @NotNull String reason, @NotNull UserJoinChatBean userJoinChatBean) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(reason, "reason");
            Intrinsics.checkNotNullParameter(userJoinChatBean, "userJoinChatBean");
            Intent intent = new Intent(context, (Class<?>) ControlRouletteReportActivity.class);
            intent.putExtra("repoort_reason", reason);
            intent.putExtra("userJoinChatBean", userJoinChatBean);
            context.startActivity(intent);
        }
    }

    /* compiled from: ControlRouletteReportActivity.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class b extends Lambda implements Function1<View, Unit> {

        /* compiled from: ControlRouletteReportActivity.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
        @DebugMetadata(c = "com.wear.ui.me.ControlRouletteReportActivity$onCreate$2$1", f = "ControlRouletteReportActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class a extends SuspendLambda implements Function2<wz3, Continuation<? super Unit>, Object> {
            public int label;
            public final /* synthetic */ ControlRouletteReportActivity this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(ControlRouletteReportActivity controlRouletteReportActivity, Continuation<? super a> continuation) {
                super(2, continuation);
                this.this$0 = controlRouletteReportActivity;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                return new a(this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            @Nullable
            public final Object invoke(@NotNull wz3 wz3Var, @Nullable Continuation<? super Unit> continuation) {
                return ((a) create(wz3Var, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                if (this.this$0.c.size() == 1 && this.this$0.x4().size() == 0) {
                    sg3.l(ah4.e(R.string.control_roulette_reportdespage_unsuccess_toast));
                    return Unit.INSTANCE;
                }
                this.this$0.showDialog();
                ReportControlRouleteeBean reportControlRouleteeBean = new ReportControlRouleteeBean();
                reportControlRouleteeBean.setReportType(this.this$0.getE());
                UserJoinChatBean g = this.this$0.getG();
                ActivityControlRouletteReportBinding activityControlRouletteReportBinding = null;
                reportControlRouleteeBean.setReportUser(g != null ? g.getUserAccountCode() : null);
                ActivityControlRouletteReportBinding activityControlRouletteReportBinding2 = this.this$0.a;
                if (activityControlRouletteReportBinding2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                } else {
                    activityControlRouletteReportBinding = activityControlRouletteReportBinding2;
                }
                reportControlRouleteeBean.setDescription(String.valueOf(activityControlRouletteReportBinding.c.getText()));
                List list = this.this$0.c;
                ArrayList arrayList = new ArrayList();
                Iterator it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Object next = it.next();
                    String url = ((ReportChooseImageBean) next).getUrl();
                    if (!(url == null || url.length() == 0)) {
                        arrayList.add(next);
                    }
                }
                ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10));
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    arrayList2.add(((ReportChooseImageBean) it2.next()).getUrl());
                }
                reportControlRouleteeBean.setImages((String[]) arrayList2.toArray(new String[0]));
                if (this.this$0.x4().size() > 0) {
                    reportControlRouleteeBean.setChatHistory(this.this$0.x4());
                }
                if (this.this$0.c.size() > 1) {
                    this.this$0.w4().e(this.this$0.c, reportControlRouleteeBean);
                } else if (this.this$0.x4().size() > 0) {
                    this.this$0.w4().c(reportControlRouleteeBean);
                }
                return Unit.INSTANCE;
            }
        }

        public b() {
            super(1);
        }

        public final void a(@NotNull View it) {
            Intrinsics.checkNotNullParameter(it, "it");
            if (se3.c(ControlRouletteReportActivity.this)) {
                uy3.d(LifecycleOwnerKt.getLifecycleScope(ControlRouletteReportActivity.this), null, null, new a(ControlRouletteReportActivity.this, null), 3, null);
            } else {
                sg3.l(ah4.e(R.string.voice_control_net_connect_error_tip));
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            a(view);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: ControlRouletteReportActivity.kt */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J*\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016J*\u0010\f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0017¨\u0006\u000e"}, d2 = {"com/wear/ui/me/ControlRouletteReportActivity$onCreate$3", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", TtmlNode.START, "", "count", TtmlNode.ANNOTATION_POSITION_AFTER, "onTextChanged", TtmlNode.ANNOTATION_POSITION_BEFORE, "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class c implements TextWatcher {
        public c() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@Nullable Editable s) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(@Nullable CharSequence s, int start, int count, int after) {
        }

        @Override // android.text.TextWatcher
        @SuppressLint({"SetTextI18n"})
        public void onTextChanged(@Nullable CharSequence s, int start, int before, int count) {
            Integer numValueOf = s != null ? Integer.valueOf(s.length()) : null;
            Intrinsics.checkNotNull(numValueOf);
            if (numValueOf.intValue() <= 300) {
                ActivityControlRouletteReportBinding activityControlRouletteReportBinding = ControlRouletteReportActivity.this.a;
                if (activityControlRouletteReportBinding == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    activityControlRouletteReportBinding = null;
                }
                TextView textView = activityControlRouletteReportBinding.g;
                StringBuilder sb = new StringBuilder();
                sb.append(s != null ? Integer.valueOf(s.length()) : null);
                sb.append("/300");
                textView.setText(sb.toString());
            }
        }
    }

    /* compiled from: ControlRouletteReportActivity.kt */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/wear/ui/me/ControlRouletteReportActivity$onCreate$4", "Landroid/view/View$OnFocusChangeListener;", "onFocusChange", "", PSOProgramService.VS_Key, "Landroid/view/View;", "hasFocus", "", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class d implements View.OnFocusChangeListener {

        /* compiled from: ControlRouletteReportActivity.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
        @DebugMetadata(c = "com.wear.ui.me.ControlRouletteReportActivity$onCreate$4$onFocusChange$1", f = "ControlRouletteReportActivity.kt", i = {}, l = {CipherSuite.TLS_DH_anon_WITH_SEED_CBC_SHA}, m = "invokeSuspend", n = {}, s = {})
        public static final class a extends SuspendLambda implements Function2<wz3, Continuation<? super Unit>, Object> {
            public int label;
            public final /* synthetic */ ControlRouletteReportActivity this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(ControlRouletteReportActivity controlRouletteReportActivity, Continuation<? super a> continuation) {
                super(2, continuation);
                this.this$0 = controlRouletteReportActivity;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                return new a(this.this$0, continuation);
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
                    this.label = 1;
                    if (h04.a(100L, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                ActivityControlRouletteReportBinding activityControlRouletteReportBinding = this.this$0.a;
                if (activityControlRouletteReportBinding == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    activityControlRouletteReportBinding = null;
                }
                activityControlRouletteReportBinding.f.fullScroll(130);
                return Unit.INSTANCE;
            }
        }

        public d() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(@Nullable View v, boolean hasFocus) {
            if (hasFocus) {
                uy3.d(LifecycleOwnerKt.getLifecycleScope(ControlRouletteReportActivity.this), null, null, new a(ControlRouletteReportActivity.this, null), 3, null);
            }
        }
    }

    /* compiled from: ControlRouletteReportActivity.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.wear.ui.me.ControlRouletteReportActivity$onCreate$5$1", f = "ControlRouletteReportActivity.kt", i = {}, l = {CipherSuite.TLS_DH_DSS_WITH_AES_128_GCM_SHA256}, m = "invokeSuspend", n = {}, s = {})
    public static final class e extends SuspendLambda implements Function2<wz3, Continuation<? super Unit>, Object> {
        public int label;

        public e(Continuation<? super e> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return ControlRouletteReportActivity.this.new e(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull wz3 wz3Var, @Nullable Continuation<? super Unit> continuation) {
            return ((e) create(wz3Var, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (h04.a(100L, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            ActivityControlRouletteReportBinding activityControlRouletteReportBinding = ControlRouletteReportActivity.this.a;
            if (activityControlRouletteReportBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityControlRouletteReportBinding = null;
            }
            activityControlRouletteReportBinding.f.fullScroll(130);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: ActivityViewModelLazy.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, d2 = {"<anonymous>", "Landroidx/lifecycle/ViewModelProvider$Factory;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke", "androidx/activity/ActivityViewModelLazyKt$viewModels$factoryPromise$2"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class f extends Lambda implements Function0<ViewModelProvider.Factory> {
        public final /* synthetic */ ComponentActivity $this_viewModels;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(ComponentActivity componentActivity) {
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
    public static final class g extends Lambda implements Function0<ViewModelStore> {
        public final /* synthetic */ ComponentActivity $this_viewModels;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(ComponentActivity componentActivity) {
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
    public static final class h extends Lambda implements Function0<CreationExtras> {
        public final /* synthetic */ Function0 $extrasProducer;
        public final /* synthetic */ ComponentActivity $this_viewModels;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(Function0 function0, ComponentActivity componentActivity) {
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

    public static final void A4(ControlRouletteReportActivity this$0, BaseQuickAdapter adapter, View view, int i2) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "view");
        int id = view.getId();
        if (id == R.id.img_add) {
            x83.b().g("标题").i(false).j(true).k(false).a(false).h(false).e(4 - this$0.b).f(false).c(new w83()).l(this$0, 23, 1);
            return;
        }
        if (id != R.id.img_delete) {
            if (id != R.id.img_report) {
                return;
            }
            this$0.M4(i2);
        } else {
            this$0.b--;
            this$0.c.remove(i2);
            ReportChooseImgAdapter reportChooseImgAdapter = this$0.d;
            if (reportChooseImgAdapter != null) {
                reportChooseImgAdapter.notifyDataSetChanged();
            }
        }
    }

    public static final void I4(ControlRouletteReportActivity this$0, RemoteResponse result) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dissDialog();
        Intrinsics.checkNotNullExpressionValue(result, "result");
        if (result instanceof RemoteResponse.Success) {
            UserJoinChatBean userJoinChatBean = this$0.g;
            if (userJoinChatBean != null) {
                ControlRouletteReportSuccessActivity.c.a(this$0, userJoinChatBean);
            }
            this$0.finish();
            return;
        }
        Integer code = ((RemoteResponse.Error) result).getCode();
        if (code != null && code.intValue() == 610001) {
            sg3.l(ah4.e(R.string.control_roulette_report_frequently_toast));
        }
    }

    public static final void J4(ControlRouletteReportActivity this$0, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dissDialog();
        sg3.l(ah4.e(R.string.common_upload_large_error));
    }

    public static final void K4(ControlRouletteReportActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        UserJoinChatBean userJoinChatBean = this$0.g;
        if (userJoinChatBean != null) {
            NewChatSelectActivity.d.a(this$0, userJoinChatBean, this$0.f);
        }
    }

    public static final void L4(ControlRouletteReportActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        uy3.d(LifecycleOwnerKt.getLifecycleScope(this$0), null, null, this$0.new e(null), 3, null);
    }

    public static final void N4(AlertDialog alertDialog) {
        alertDialog.dismiss();
    }

    public final void H4() {
        w4().b().observe(this, new Observer() { // from class: dc.ya3
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ControlRouletteReportActivity.I4(this.a, (RemoteResponse) obj);
            }
        });
        w4().a().observe(this, new Observer() { // from class: dc.cb3
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ControlRouletteReportActivity.J4(this.a, (String) obj);
            }
        });
    }

    public final void M4(int i2) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View viewInflate = getLayoutInflater().inflate(R.layout.dialig_big_picture, (ViewGroup) null);
        builder.setView(viewInflate);
        final AlertDialog alertDialogCreate = builder.create();
        Window window = alertDialogCreate.getWindow();
        Intrinsics.checkNotNull(window);
        window.setBackgroundDrawableResource(R.color.transparent);
        ArrayList arrayList = new ArrayList();
        List<ReportChooseImageBean> list = this.c;
        ArrayList arrayList2 = new ArrayList();
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            String url = ((ReportChooseImageBean) next).getUrl();
            if (!(url == null || url.length() == 0)) {
                arrayList2.add(next);
            }
        }
        Iterator it2 = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList2).iterator();
        while (it2.hasNext()) {
            arrayList.add(((ReportChooseImageBean) it2.next()).getUrl());
        }
        String[] strArr = (String[]) arrayList.toArray(new String[0]);
        ViewPager2 viewPager2 = (ViewPager2) viewInflate.findViewById(R.id.image_list);
        BigPictureAdapter bigPictureAdapter = new BigPictureAdapter(strArr);
        viewPager2.setAdapter(bigPictureAdapter);
        bigPictureAdapter.o(new BigPictureAdapter.a() { // from class: dc.za3
            @Override // com.wear.main.longDistance.report.BigPictureAdapter.a
            public final void a() {
                ControlRouletteReportActivity.N4(alertDialogCreate);
            }
        });
        viewPager2.setCurrentItem(i2, false);
        builder.setCancelable(true);
        alertDialogCreate.show();
    }

    public final void O4(int i2) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String strE = ah4.e(R.string.report_message_selected);
        Intrinsics.checkNotNullExpressionValue(strE, "getString(R.string.report_message_selected)");
        String str = String.format(strE, Arrays.copyOf(new Object[]{String.valueOf(i2)}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
        ActivityControlRouletteReportBinding activityControlRouletteReportBinding = this.a;
        if (activityControlRouletteReportBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityControlRouletteReportBinding = null;
        }
        activityControlRouletteReportBinding.i.setText(str);
    }

    @Override // com.wear.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    @SuppressLint({"NotifyDataSetChanged"})
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode != 23 || resultCode != -1 || data == null) {
            if (requestCode == 100 && resultCode == -1 && data != null) {
                ArrayList<MessageSelected> parcelableArrayListExtra = data.getParcelableArrayListExtra("chatSelectedList");
                Intrinsics.checkNotNull(parcelableArrayListExtra);
                this.f = parcelableArrayListExtra;
                O4(parcelableArrayListExtra.size());
                return;
            }
            return;
        }
        ArrayList parcelableArrayListExtra2 = data.getParcelableArrayListExtra("selectMediaFile");
        if (parcelableArrayListExtra2 != null) {
            Iterator it = parcelableArrayListExtra2.iterator();
            while (it.hasNext()) {
                MediaFile mediaFile = (MediaFile) it.next();
                ReportChooseImageBean reportChooseImageBean = new ReportChooseImageBean(1);
                if (Build.VERSION.SDK_INT >= 29) {
                    Uri uriWithAppendedId = ContentUris.withAppendedId(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, mediaFile.e());
                    Intrinsics.checkNotNullExpressionValue(uriWithAppendedId, "withAppendedId(\n        …                        )");
                    String string = uriWithAppendedId.toString();
                    Intrinsics.checkNotNullExpressionValue(string, "uri.toString()");
                    reportChooseImageBean.setUrl(string);
                    this.c.add(0, reportChooseImageBean);
                } else {
                    String strF = mediaFile.f();
                    Intrinsics.checkNotNullExpressionValue(strF, "ibean.path");
                    reportChooseImageBean.setUrl(strF);
                    this.c.add(0, reportChooseImageBean);
                }
            }
            this.b += parcelableArrayListExtra2.size();
            ActivityControlRouletteReportBinding activityControlRouletteReportBinding = this.a;
            if (activityControlRouletteReportBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityControlRouletteReportBinding = null;
            }
            activityControlRouletteReportBinding.h.setText(String.valueOf(this.b));
            ReportChooseImgAdapter reportChooseImgAdapter = this.d;
            if (reportChooseImgAdapter != null) {
                reportChooseImgAdapter.notifyDataSetChanged();
            }
        }
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityControlRouletteReportBinding activityControlRouletteReportBindingC = ActivityControlRouletteReportBinding.c(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(activityControlRouletteReportBindingC, "inflate(layoutInflater)");
        this.a = activityControlRouletteReportBindingC;
        ActivityControlRouletteReportBinding activityControlRouletteReportBinding = null;
        if (activityControlRouletteReportBindingC == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityControlRouletteReportBindingC = null;
        }
        setContentView(activityControlRouletteReportBindingC.getRoot());
        this.e = getIntent().getStringExtra("repoort_reason");
        Parcelable parcelableExtra = getIntent().getParcelableExtra("userJoinChatBean");
        this.g = parcelableExtra instanceof UserJoinChatBean ? (UserJoinChatBean) parcelableExtra : null;
        ActivityControlRouletteReportBinding activityControlRouletteReportBinding2 = this.a;
        if (activityControlRouletteReportBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityControlRouletteReportBinding2 = null;
        }
        activityControlRouletteReportBinding2.d.setOnClickListener(new View.OnClickListener() { // from class: dc.ab3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ControlRouletteReportActivity.K4(this.a, view);
            }
        });
        ActivityControlRouletteReportBinding activityControlRouletteReportBinding3 = this.a;
        if (activityControlRouletteReportBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityControlRouletteReportBinding3 = null;
        }
        activityControlRouletteReportBinding3.b.setParentBackgroundColor(th4.b(this, R.color.lvs_ui_standard_systemBackground6));
        O4(0);
        z4();
        H4();
        ActivityControlRouletteReportBinding activityControlRouletteReportBinding4 = this.a;
        if (activityControlRouletteReportBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityControlRouletteReportBinding4 = null;
        }
        TextView textView = activityControlRouletteReportBinding4.j;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.tvSubmit");
        yu1.b(textView, 0, false, new b(), 3, null);
        ActivityControlRouletteReportBinding activityControlRouletteReportBinding5 = this.a;
        if (activityControlRouletteReportBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityControlRouletteReportBinding5 = null;
        }
        activityControlRouletteReportBinding5.c.addTextChangedListener(new c());
        ActivityControlRouletteReportBinding activityControlRouletteReportBinding6 = this.a;
        if (activityControlRouletteReportBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityControlRouletteReportBinding6 = null;
        }
        activityControlRouletteReportBinding6.c.setOnFocusChangeListener(new d());
        ActivityControlRouletteReportBinding activityControlRouletteReportBinding7 = this.a;
        if (activityControlRouletteReportBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityControlRouletteReportBinding = activityControlRouletteReportBinding7;
        }
        activityControlRouletteReportBinding.c.setOnClickListener(new View.OnClickListener() { // from class: dc.bb3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ControlRouletteReportActivity.L4(this.a, view);
            }
        });
    }

    @Override // com.wear.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (Build.VERSION.SDK_INT >= 23) {
            kg3.k(this, WearUtils.Y0());
        }
    }

    @Nullable
    /* renamed from: v4, reason: from getter */
    public final String getE() {
        return this.e;
    }

    public final RouletteReportViewModel w4() {
        return (RouletteReportViewModel) this.h.getValue();
    }

    @NotNull
    public final ArrayList<MessageSelected> x4() {
        return this.f;
    }

    @Nullable
    /* renamed from: y4, reason: from getter */
    public final UserJoinChatBean getG() {
        return this.g;
    }

    public final void z4() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this) { // from class: com.wear.ui.me.ControlRouletteReportActivity$initRecycle$gridLayoutManager$1
            {
                super(this, 4);
            }

            @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
            public boolean canScrollHorizontally() {
                return false;
            }
        };
        this.c.add(new ReportChooseImageBean(0));
        ActivityControlRouletteReportBinding activityControlRouletteReportBinding = this.a;
        ActivityControlRouletteReportBinding activityControlRouletteReportBinding2 = null;
        if (activityControlRouletteReportBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityControlRouletteReportBinding = null;
        }
        activityControlRouletteReportBinding.e.setLayoutManager(gridLayoutManager);
        this.d = new ReportChooseImgAdapter(this.c);
        ActivityControlRouletteReportBinding activityControlRouletteReportBinding3 = this.a;
        if (activityControlRouletteReportBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityControlRouletteReportBinding2 = activityControlRouletteReportBinding3;
        }
        activityControlRouletteReportBinding2.e.setAdapter(this.d);
        ReportChooseImgAdapter reportChooseImgAdapter = this.d;
        if (reportChooseImgAdapter != null) {
            reportChooseImgAdapter.n(R.id.img_add, R.id.img_delete, R.id.img_report);
        }
        ReportChooseImgAdapter reportChooseImgAdapter2 = this.d;
        if (reportChooseImgAdapter2 != null) {
            reportChooseImgAdapter2.A0(new zq() { // from class: dc.xa3
                @Override // dc.zq
                public final void O1(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
                    ControlRouletteReportActivity.A4(this.a, baseQuickAdapter, view, i2);
                }
            });
        }
    }
}
