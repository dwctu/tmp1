package com.wear.ui.chat.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.lovense.wear.R;
import com.wear.BaseBindingBottomDialogFragment;
import com.wear.bean.chat.ReportActionMenuBean;
import com.wear.bean.event.LanguageEvent;
import com.wear.databinding.DialogFragmentReportActionMenuBinding;
import com.wear.ui.chat.adapter.ReportActionMenuAdapter;
import com.wear.ui.chat.fragment.ReportActionMenuFragmentBottom;
import com.wear.ui.me.ControlRouletteNoticeActivity;
import dc.ah4;
import dc.br;
import dc.pj3;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.i18n.MessageBundle;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ReportActionMenuFragmentBottom.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001d2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u001d\u001e\u001fB\u0005¢\u0006\u0002\u0010\u0003J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002J\b\u0010\r\u001a\u00020\u000eH\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0002J\b\u0010\u0010\u001a\u00020\u000eH\u0016J\u0010\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0013H\u0007J\u001a\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u000e\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u0005J\u0016\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\tR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/wear/ui/chat/fragment/ReportActionMenuFragmentBottom;", "Lcom/wear/BaseBindingBottomDialogFragment;", "Lcom/wear/databinding/DialogFragmentReportActionMenuBinding;", "()V", "onReportActionMenuClickListener", "Lcom/wear/ui/chat/fragment/ReportActionMenuFragmentBottom$OnReportActionMenuClickListener;", "typeEnableMap", "", "", "", "assembleDataByGroup", "", "Lcom/wear/bean/chat/ReportActionMenuBean;", "initListener", "", "initRecyclerView", "onDestroy", "onLanguageChange", "event", "Lcom/wear/bean/event/LanguageEvent;", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "setOnReportActionMenuClickListener", "updateActionMenu", "type", "isEnable", "Companion", "OnReportActionMenuClickListener", "ReportActionMenuType", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class ReportActionMenuFragmentBottom extends BaseBindingBottomDialogFragment<DialogFragmentReportActionMenuBinding> {

    @NotNull
    public final Map<Integer, Boolean> c;

    @Nullable
    public b d;

    /* compiled from: ReportActionMenuFragmentBottom.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class a extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, DialogFragmentReportActionMenuBinding> {
        public static final a a = new a();

        public a() {
            super(3, DialogFragmentReportActionMenuBinding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/wear/databinding/DialogFragmentReportActionMenuBinding;", 0);
        }

        @NotNull
        public final DialogFragmentReportActionMenuBinding a(@NotNull LayoutInflater p0, @Nullable ViewGroup viewGroup, boolean z) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return DialogFragmentReportActionMenuBinding.b(p0, viewGroup, z);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ DialogFragmentReportActionMenuBinding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
            return a(layoutInflater, viewGroup, bool.booleanValue());
        }
    }

    /* compiled from: ReportActionMenuFragmentBottom.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/wear/ui/chat/fragment/ReportActionMenuFragmentBottom$OnReportActionMenuClickListener;", "", "onReportActionMenuClick", "", "type", "", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public interface b {
        void a(@NotNull String str);
    }

    public ReportActionMenuFragmentBottom() {
        super(a.a);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.c = linkedHashMap;
        Boolean bool = Boolean.TRUE;
        linkedHashMap.put(0, bool);
        linkedHashMap.put(1, bool);
        linkedHashMap.put(2, bool);
        linkedHashMap.put(3, bool);
        linkedHashMap.put(4, bool);
    }

    public static final void A(ReportActionMenuFragmentBottom this$0, BaseQuickAdapter adapter, View view, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 1>");
        Object item = adapter.getItem(i);
        Intrinsics.checkNotNull(item, "null cannot be cast to non-null type com.wear.bean.chat.ReportActionMenuBean");
        ReportActionMenuBean reportActionMenuBean = (ReportActionMenuBean) item;
        b bVar = this$0.d;
        if (bVar != null) {
            bVar.a(reportActionMenuBean.getReport_reason());
        }
    }

    public static final void B(ReportActionMenuFragmentBottom this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        pj3.f(this$0.t().b.getContext(), ControlRouletteNoticeActivity.class);
    }

    public final void E(@NotNull b onReportActionMenuClickListener) {
        Intrinsics.checkNotNullParameter(onReportActionMenuClickListener, "onReportActionMenuClickListener");
        this.d = onReportActionMenuClickListener;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onLanguageChange(@NotNull LanguageEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        RecyclerView.Adapter adapter = t().a.getAdapter();
        ReportActionMenuAdapter reportActionMenuAdapter = adapter instanceof ReportActionMenuAdapter ? (ReportActionMenuAdapter) adapter : null;
        if (reportActionMenuAdapter == null) {
            return;
        }
        reportActionMenuAdapter.y0(u());
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        t().b.getPaint().setFlags(8);
        t().b.getPaint().setAntiAlias(true);
        y();
        v();
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0061, code lost:
    
        r4.add(new com.wear.bean.chat.ReportActionMenuBean(r8.getTitle(), r5, r8.getReason()));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.List<com.wear.bean.chat.ReportActionMenuBean> u() {
        /*
            r10 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 0
            java.lang.Integer r2 = java.lang.Integer.valueOf(r1)
            r0.add(r2)
            r2 = 1
            java.lang.Integer r3 = java.lang.Integer.valueOf(r2)
            r0.add(r3)
            r3 = 2
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r0.add(r3)
            r3 = 3
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r0.add(r3)
            r3 = 4
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r0.add(r3)
            com.wear.ui.chat.fragment.ReportActionMenuFragmentBottom$c[] r3 = com.wear.ui.chat.fragment.ReportActionMenuFragmentBottom.c.values()
            java.util.ArrayList r4 = new java.util.ArrayList
            r5 = 10
            int r5 = kotlin.collections.CollectionsKt__IterablesKt.collectionSizeOrDefault(r0, r5)
            r4.<init>(r5)
            java.util.Iterator r0 = r0.iterator()
        L40:
            boolean r5 = r0.hasNext()
            if (r5 == 0) goto L7d
            java.lang.Object r5 = r0.next()
            java.lang.Number r5 = (java.lang.Number) r5
            int r5 = r5.intValue()
            int r6 = r3.length
            r7 = 0
        L52:
            if (r7 >= r6) goto L75
            r8 = r3[r7]
            int r9 = r8.getType()
            if (r9 != r5) goto L5e
            r9 = 1
            goto L5f
        L5e:
            r9 = 0
        L5f:
            if (r9 == 0) goto L72
            com.wear.bean.chat.ReportActionMenuBean r6 = new com.wear.bean.chat.ReportActionMenuBean
            java.lang.String r7 = r8.getTitle()
            java.lang.String r8 = r8.getReason()
            r6.<init>(r7, r5, r8)
            r4.add(r6)
            goto L40
        L72:
            int r7 = r7 + 1
            goto L52
        L75:
            java.util.NoSuchElementException r0 = new java.util.NoSuchElementException
            java.lang.String r1 = "Array contains no element matching the predicate."
            r0.<init>(r1)
            throw r0
        L7d:
            java.util.List r0 = kotlin.collections.CollectionsKt___CollectionsKt.toMutableList(r4)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wear.ui.chat.fragment.ReportActionMenuFragmentBottom.u():java.util.List");
    }

    public final void v() {
        EventBus.getDefault().register(this);
    }

    public final void y() {
        RecyclerView.ItemAnimator itemAnimator = t().a.getItemAnimator();
        Intrinsics.checkNotNull(itemAnimator, "null cannot be cast to non-null type androidx.recyclerview.widget.SimpleItemAnimator");
        ((SimpleItemAnimator) itemAnimator).setSupportsChangeAnimations(false);
        t().a.setLayoutManager(new LinearLayoutManager(requireContext()));
        ReportActionMenuAdapter reportActionMenuAdapter = new ReportActionMenuAdapter(u());
        reportActionMenuAdapter.E0(new br() { // from class: dc.dt2
            @Override // dc.br
            public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                ReportActionMenuFragmentBottom.A(this.a, baseQuickAdapter, view, i);
            }
        });
        t().a.setAdapter(reportActionMenuAdapter);
        t().b.setOnClickListener(new View.OnClickListener() { // from class: dc.et2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReportActionMenuFragmentBottom.B(this.a, view);
            }
        });
    }

    /* compiled from: ReportActionMenuFragmentBottom.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B!\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\tR\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0013"}, d2 = {"Lcom/wear/ui/chat/fragment/ReportActionMenuFragmentBottom$ReportActionMenuType;", "", "type", "", "titleId", "reason", "", "(Ljava/lang/String;IIILjava/lang/String;)V", "getReason", "()Ljava/lang/String;", MessageBundle.TITLE_ENTRY, "getTitle", "getType", "()I", "HARASSMENT", "TRANSACTIONS", "DISCRIMINATION", "USER", "OTHER", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public enum c {
        HARASSMENT(0, R.string.user_report_reason2, "harassment"),
        TRANSACTIONS(1, R.string.control_roulette_reportpage_type2, "moneyTransactions"),
        DISCRIMINATION(2, R.string.control_roulette_reportpage_type3, "racialDiscrimination"),
        USER(3, R.string.user_report_reason3, "childSafety"),
        OTHER(4, R.string.user_report_reason4, "other");


        @NotNull
        private final String reason;
        private final int titleId;
        private final int type;

        c(int i, int i2, String str) {
            this.type = i;
            this.titleId = i2;
            this.reason = str;
        }

        @NotNull
        public final String getReason() {
            return this.reason;
        }

        @NotNull
        public final String getTitle() {
            String strE = ah4.e(this.titleId);
            Intrinsics.checkNotNullExpressionValue(strE, "getString(titleId)");
            return strE;
        }

        public final int getType() {
            return this.type;
        }

        /* synthetic */ c(int i, int i2, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(i, i2, (i3 & 4) != 0 ? "" : str);
        }
    }
}
