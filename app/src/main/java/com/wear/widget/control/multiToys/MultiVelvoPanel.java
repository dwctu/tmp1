package com.wear.widget.control.multiToys;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.lovense.wear.R;
import com.sun.jna.Callback;
import com.wear.bean.Toy;
import com.wear.bean.controlmutlitoys.BaseBallBean;
import com.wear.bean.event.UpdateToyStrengthEvent;
import com.wear.databinding.ViewMultiVelvoPanelBinding;
import com.wear.util.MyApplication;
import com.wear.widget.control.multiToys.MultiVelvoPanel;
import com.wear.widget.seekbar.RangeSeekBar;
import com.wear.widget.seekbar.VerticalRangeSeekBar;
import dc.ah4;
import dc.ek2;
import dc.fk2;
import dc.gg3;
import dc.pc1;
import dc.qu1;
import dc.uu1;
import dc.xs3;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import skin.support.constraint.SkinCompatConstraintLayout;

/* compiled from: MultiVelvoPanel.kt */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001:\u0003?@AB\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\rJ\u0006\u0010$\u001a\u00020\"J\u0016\u0010%\u001a\u00020&2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\r0(H\u0002J\u0010\u0010)\u001a\u00020&2\u0006\u0010*\u001a\u00020&H\u0002J\b\u0010+\u001a\u00020\nH\u0002J\b\u0010,\u001a\u00020\"H\u0002J\u0010\u0010-\u001a\u00020\"2\u0006\u0010*\u001a\u00020&H\u0002J\u001c\u0010-\u001a\u00020\"2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\r0(2\u0006\u0010\t\u001a\u00020\nJ\b\u0010.\u001a\u00020\"H\u0014J\u0006\u0010/\u001a\u00020\"J\u0010\u00100\u001a\u00020\"2\u0006\u00101\u001a\u000202H\u0002J\u000e\u00103\u001a\u00020\"2\u0006\u00104\u001a\u00020&J\u000e\u00103\u001a\u00020\"2\u0006\u0010\u001f\u001a\u00020 J\u0010\u00105\u001a\u00020\"2\u0006\u00106\u001a\u000207H\u0007J\u000e\u00108\u001a\u00020\"2\u0006\u0010#\u001a\u00020\rJ\b\u00109\u001a\u00020\"H\u0002J\u0016\u0010:\u001a\u00020\"2\f\u0010;\u001a\b\u0012\u0004\u0012\u00020\r0(H\u0002J\u0016\u0010<\u001a\u00020\"2\f\u0010=\u001a\b\u0012\u0004\u0012\u00020\r0(H\u0002J\u0010\u0010>\u001a\u00020\"2\u0006\u00101\u001a\u000202H\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u000e\u0010\u001f\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006B"}, d2 = {"Lcom/wear/widget/control/multiToys/MultiVelvoPanel;", "Lskin/support/constraint/SkinCompatConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "binding", "Lcom/wear/databinding/ViewMultiVelvoPanelBinding;", "controlPanelType", "", "listBalls", "", "Lcom/wear/bean/controlmutlitoys/BaseBallBean;", "multiPanelType", "getMultiPanelType", "()Ljava/lang/String;", "setMultiPanelType", "(Ljava/lang/String;)V", "onSolacePanelInterceptListener", "Lcom/wear/widget/control/multiToys/MultiVelvoPanel$OnSolacePanelInterceptListener;", "getOnSolacePanelInterceptListener", "()Lcom/wear/widget/control/multiToys/MultiVelvoPanel$OnSolacePanelInterceptListener;", "setOnSolacePanelInterceptListener", "(Lcom/wear/widget/control/multiToys/MultiVelvoPanel$OnSolacePanelInterceptListener;)V", "onSolaceProPanelListener", "Lcom/wear/widget/control/multiToys/MultiVelvoPanel$OnSolaceProPanelListener;", "getOnSolaceProPanelListener", "()Lcom/wear/widget/control/multiToys/MultiVelvoPanel$OnSolaceProPanelListener;", "setOnSolaceProPanelListener", "(Lcom/wear/widget/control/multiToys/MultiVelvoPanel$OnSolaceProPanelListener;)V", "panelType", "", "addVelvoItem", "", "baseBallBean", "autoShrink", "checkVisible", "", "lists", "", "filterVisibleByControlPanelType", "visible", "getDrawerModelText", "initRecyclerView", "initView", "onAttachedToWindow", "onDestroy", "onDrawerViewButtonClick", "view", "Landroid/view/View;", "onSwitchPanel", "isFysModel", "onVelvoStrokeChangeEvent", "event", "Lcom/wear/bean/event/UpdateToyStrengthEvent;", "removeVelvoItem", "smoothScrollAutoWidth", "updateModelUi", "baseBallList", "updateRecyclerViewUI", "velvoSpeedModelsToysAddress", "velvoChangeMode", "OnSolacePanelInterceptListener", "OnSolaceProPanelListener", "VelvoPositionRangeAdapter", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public final class MultiVelvoPanel extends SkinCompatConstraintLayout {

    @NotNull
    public final ViewMultiVelvoPanelBinding b;

    @Nullable
    public a c;

    @Nullable
    public b d;

    @Nullable
    public List<BaseBallBean> e;

    @Nullable
    public String f;

    @Nullable
    public String g;
    public int h;

    /* compiled from: MultiVelvoPanel.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0002H\u0014¨\u0006\t"}, d2 = {"Lcom/wear/widget/control/multiToys/MultiVelvoPanel$VelvoPositionRangeAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/wear/bean/controlmutlitoys/BaseBallBean;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "(Lcom/wear/widget/control/multiToys/MultiVelvoPanel;)V", "convert", "", "holder", "item", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public final class VelvoPositionRangeAdapter extends BaseQuickAdapter<BaseBallBean, BaseViewHolder> {

        /* compiled from: MultiVelvoPanel.kt */
        @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u0016J\u001a\u0010\u000b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\f\u001a\u00020\nH\u0016J\u001a\u0010\r\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\f\u001a\u00020\nH\u0016¨\u0006\u000e"}, d2 = {"com/wear/widget/control/multiToys/MultiVelvoPanel$VelvoPositionRangeAdapter$convert$1", "Lcom/wear/widget/seekbar/OnRangeChangedListener;", "onRangeChanged", "", "view", "Lcom/wear/widget/seekbar/RangeSeekBar;", "leftValue", "", "rightValue", "isTouchMoving", "", "onStartTrackingTouch", "isLeft", "onStopTrackingTouch", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class a implements xs3 {
            public final /* synthetic */ Toy a;
            public final /* synthetic */ ek2 b;
            public final /* synthetic */ MultiVelvoPanel c;

            public a(Toy toy, ek2 ek2Var, MultiVelvoPanel multiVelvoPanel) {
                this.a = toy;
                this.b = ek2Var;
                this.c = multiVelvoPanel;
            }

            @Override // dc.xs3
            public void a(@Nullable RangeSeekBar rangeSeekBar, float f, float f2, boolean z) {
                if (z) {
                    return;
                }
                int i = (int) f;
                int i2 = (int) f2;
                fk2.a.h(this.a, this.b, i, i2, true);
                b d = this.c.getD();
                if (d != null) {
                    Toy toy = this.a;
                    String address = toy != null ? toy.getAddress() : null;
                    if (address == null) {
                        address = "";
                    }
                    d.h(address, i, i2);
                }
            }

            @Override // dc.xs3
            public void b(@Nullable RangeSeekBar rangeSeekBar, boolean z) {
            }

            @Override // dc.xs3
            public void c(@Nullable RangeSeekBar rangeSeekBar, boolean z) {
            }
        }

        public VelvoPositionRangeAdapter() {
            super(R.layout.item_velvo_position_range, null, 2, null);
        }

        @Override // com.chad.library.adapter.base.BaseQuickAdapter
        /* renamed from: I0, reason: merged with bridge method [inline-methods] */
        public void C(@NotNull BaseViewHolder holder, @NotNull BaseBallBean item) {
            Intrinsics.checkNotNullParameter(holder, "holder");
            Intrinsics.checkNotNullParameter(item, "item");
            pc1 pc1Var = pc1.a;
            String toyAddress = item.getToyAddress();
            Intrinsics.checkNotNullExpressionValue(toyAddress, "item.toyAddress");
            Toy toyQ = pc1Var.Q(toyAddress);
            fk2 fk2Var = fk2.a;
            ek2 ek2VarC = fk2Var.c(item.getToyAddress());
            int iE = fk2Var.e(toyQ != null ? toyQ.getAndUpdateDeviceId() : null);
            int iD = fk2Var.d(toyQ != null ? toyQ.getAndUpdateDeviceId() : null);
            VerticalRangeSeekBar verticalRangeSeekBar = (VerticalRangeSeekBar) holder.getView(R.id.vertical_range_seek_bar);
            verticalRangeSeekBar.setProgress(iE, iD);
            verticalRangeSeekBar.setOnRangeChangedListener(new a(toyQ, ek2VarC, MultiVelvoPanel.this));
        }
    }

    /* compiled from: MultiVelvoPanel.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/wear/widget/control/multiToys/MultiVelvoPanel$OnSolacePanelInterceptListener;", "", "interceptVelvoModelChanged", "", Callback.METHOD_NAME, "Lkotlin/Function0;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public interface a {
        void g(@NotNull Function0<Unit> function0);
    }

    /* compiled from: MultiVelvoPanel.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0005H&J\"\u0010\f\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH&J\u001a\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&¨\u0006\u0012"}, d2 = {"Lcom/wear/widget/control/multiToys/MultiVelvoPanel$OnSolaceProPanelListener;", "", "onSolaceProModelChanged", "", "isAllChange", "", "toyAddress", "", "newMode", "Lcom/wear/main/toy/solacepro/SolaceProModel;", "onSolaceProPanelExpand", "isExpand", "onSolaceProPositionRangeChanged", "min", "", "max", "onSolaceProPreviewShowHidden", "isShow", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public interface b {
        void h(@Nullable String str, int i, int i2);

        void l(boolean z, @Nullable String str);

        void p(boolean z);

        void r(boolean z, @Nullable String str, @Nullable ek2 ek2Var);
    }

    /* compiled from: MultiVelvoPanel.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class c extends Lambda implements Function0<Unit> {
        public c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            fk2.a.j();
            b d = MultiVelvoPanel.this.getD();
            if (d != null) {
                d.r(true, null, null);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public MultiVelvoPanel(@NotNull Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ MultiVelvoPanel(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    public static final void a(View view) {
    }

    private final String getDrawerModelText() {
        String strE = ah4.e(R.string.function_switch);
        Intrinsics.checkNotNullExpressionValue(strE, "getString(R.string.function_switch)");
        return strE;
    }

    public static final void s(MultiVelvoPanel this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (Intrinsics.areEqual(this$0.b.b(), Boolean.TRUE)) {
            this$0.b.d.d();
        }
    }

    public final void b(@NotNull BaseBallBean baseBallBean) {
        BaseBallBean baseBallBean2;
        Object next;
        Intrinsics.checkNotNullParameter(baseBallBean, "baseBallBean");
        if (!Intrinsics.areEqual(this.f, "CREATE_PATTERN") && uu1.g(baseBallBean.getSymbol())) {
            List<BaseBallBean> list = this.e;
            Object obj = null;
            if (list != null) {
                Iterator<T> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                    BaseBallBean baseBallBean3 = (BaseBallBean) next;
                    if (Intrinsics.areEqual(baseBallBean3.getToyAddress(), baseBallBean.getToyAddress()) && Intrinsics.areEqual(baseBallBean3.getToyFun(), "pos")) {
                        break;
                    }
                }
                baseBallBean2 = (BaseBallBean) next;
            } else {
                baseBallBean2 = null;
            }
            List<BaseBallBean> list2 = this.e;
            if (list2 != null) {
                Iterator<T> it2 = list2.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    Object next2 = it2.next();
                    BaseBallBean baseBallBean4 = (BaseBallBean) next2;
                    if (Intrinsics.areEqual(baseBallBean4.getToyAddress(), baseBallBean.getToyAddress()) && Intrinsics.areEqual(baseBallBean4.getToyFun(), "t")) {
                        obj = next2;
                        break;
                    }
                }
                obj = (BaseBallBean) obj;
            }
            if (baseBallBean2 == null && obj == null) {
                List<BaseBallBean> list3 = this.e;
                if (list3 != null) {
                    list3.add(baseBallBean);
                }
            } else {
                if (((baseBallBean2 == null || baseBallBean2.isSelected()) ? false : true) && Intrinsics.areEqual(baseBallBean.getToyFun(), "pos")) {
                    baseBallBean2.setSelected(true);
                }
            }
            List<BaseBallBean> listEmptyList = this.e;
            if (listEmptyList == null) {
                listEmptyList = CollectionsKt__CollectionsKt.emptyList();
            }
            t(listEmptyList);
            List<BaseBallBean> listEmptyList2 = this.e;
            if (listEmptyList2 == null) {
                listEmptyList2 = CollectionsKt__CollectionsKt.emptyList();
            }
            setVisibility(e(d(listEmptyList2)) ? 0 : 8);
        }
    }

    public final void c() {
        if (getVisibility() == 0) {
            Boolean boolB = this.b.b();
            Boolean bool = Boolean.FALSE;
            if (Intrinsics.areEqual(boolB, bool)) {
                return;
            }
            this.b.e(bool);
            this.b.d.b();
        }
    }

    public final boolean d(List<? extends BaseBallBean> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                return !arrayList.isEmpty();
            }
            Object next = it.next();
            BaseBallBean baseBallBean = (BaseBallBean) next;
            if (uu1.g(baseBallBean.getSymbol()) && baseBallBean.isSelected()) {
                arrayList.add(next);
            }
        }
    }

    public final boolean e(boolean z) {
        if (z) {
            return Intrinsics.areEqual(this.f, "REMOTE_CONTROL") || Intrinsics.areEqual(this.f, "CREATE_PATTERN");
        }
        return false;
    }

    public final void f() {
        RecyclerView recyclerView = this.b.g;
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), 0, false));
        recyclerView.setAdapter(new VelvoPositionRangeAdapter());
    }

    public final void g(@NotNull List<? extends BaseBallBean> lists, @NotNull String controlPanelType) {
        Intrinsics.checkNotNullParameter(lists, "lists");
        Intrinsics.checkNotNullParameter(controlPanelType, "controlPanelType");
        this.f = controlPanelType;
        this.e = CollectionsKt___CollectionsKt.toMutableList((Collection) lists);
        h(d(lists));
    }

    @Nullable
    /* renamed from: getMultiPanelType, reason: from getter */
    public final String getG() {
        return this.g;
    }

    @Nullable
    /* renamed from: getOnSolacePanelInterceptListener, reason: from getter */
    public final a getC() {
        return this.c;
    }

    @Nullable
    /* renamed from: getOnSolaceProPanelListener, reason: from getter */
    public final b getD() {
        return this.d;
    }

    public final void h(boolean z) {
        List<BaseBallBean> listEmptyList = this.e;
        if (listEmptyList == null) {
            listEmptyList = CollectionsKt__CollectionsKt.emptyList();
        }
        t(listEmptyList);
        if ((getVisibility() == 0) == z) {
            return;
        }
        this.b.e(Boolean.FALSE);
        this.b.d.b();
        setVisibility(e(z) && this.h != 4 ? 0 : 8);
    }

    public final void m() {
        EventBus.getDefault().unregister(this);
    }

    public final void n(View view) {
        ViewMultiVelvoPanelBinding viewMultiVelvoPanelBinding = this.b;
        Boolean boolB = viewMultiVelvoPanelBinding.b();
        if (boolB == null) {
            boolB = Boolean.FALSE;
        }
        viewMultiVelvoPanelBinding.e(Boolean.valueOf(!boolB.booleanValue()));
        if (Intrinsics.areEqual(this.b.b(), Boolean.TRUE)) {
            this.b.d.c();
        } else {
            this.b.d.b();
        }
        b bVar = this.d;
        if (bVar != null) {
            Boolean boolB2 = this.b.b();
            if (boolB2 == null) {
                boolB2 = Boolean.FALSE;
            }
            bVar.p(boolB2.booleanValue());
        }
    }

    public final void o(int i) {
        this.h = i;
        List<BaseBallBean> listEmptyList = this.e;
        if (listEmptyList == null) {
            listEmptyList = CollectionsKt__CollectionsKt.emptyList();
        }
        setVisibility(e(d(listEmptyList) && (i == 0 || 3 == i)) ? 0 : 8);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (EventBus.getDefault().isRegistered(this)) {
            return;
        }
        EventBus.getDefault().register(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onVelvoStrokeChangeEvent(@NotNull UpdateToyStrengthEvent event) {
        Toy toy;
        Intrinsics.checkNotNullParameter(event, "event");
        if (Intrinsics.areEqual(MyApplication.K, getContext()) || (toy = event.getToy()) == null) {
            return;
        }
        RecyclerView.Adapter adapter = this.b.g.getAdapter();
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
        fk2 fk2Var = fk2.a;
        fk2Var.c(toy.getAddress());
        int iE = fk2Var.e(toy.getAndUpdateDeviceId());
        int iD = fk2Var.d(toy.getAndUpdateDeviceId());
        b bVar = this.d;
        if (bVar != null) {
            bVar.h(toy.getAddress(), iE, iD);
        }
    }

    public final void p(boolean z) {
        List<BaseBallBean> listEmptyList = this.e;
        if (listEmptyList == null) {
            listEmptyList = CollectionsKt__CollectionsKt.emptyList();
        }
        setVisibility(e(d(listEmptyList) && !z) ? 0 : 8);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void q(@NotNull BaseBallBean baseBallBean) {
        Intrinsics.checkNotNullParameter(baseBallBean, "baseBallBean");
        if (!Intrinsics.areEqual(this.f, "CREATE_PATTERN") && uu1.g(baseBallBean.getSymbol()) && Intrinsics.areEqual(baseBallBean.getToyFun(), "pos")) {
            List<BaseBallBean> list = this.e;
            BaseBallBean baseBallBean2 = null;
            if (list != null) {
                Iterator<T> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Object next = it.next();
                    BaseBallBean baseBallBean3 = (BaseBallBean) next;
                    if (Intrinsics.areEqual(baseBallBean3.getToyAddress(), baseBallBean.getToyAddress()) && Intrinsics.areEqual(baseBallBean3.getToyFun(), "pos")) {
                        baseBallBean2 = next;
                        break;
                    }
                }
                baseBallBean2 = baseBallBean2;
            }
            if (baseBallBean2 != null && baseBallBean2.isSelected()) {
                baseBallBean2.setSelected(false);
            }
            List<BaseBallBean> listEmptyList = this.e;
            if (listEmptyList == null) {
                listEmptyList = CollectionsKt__CollectionsKt.emptyList();
            }
            t(listEmptyList);
            List<BaseBallBean> listEmptyList2 = this.e;
            if (listEmptyList2 == null) {
                listEmptyList2 = CollectionsKt__CollectionsKt.emptyList();
            }
            setVisibility(e(d(listEmptyList2)) ? 0 : 8);
        }
    }

    public final void r() {
        this.b.d.post(new Runnable() { // from class: dc.fp3
            @Override // java.lang.Runnable
            public final void run() {
                MultiVelvoPanel.s(this.a);
            }
        });
    }

    public final void setMultiPanelType(@Nullable String str) {
        this.g = str;
    }

    public final void setOnSolacePanelInterceptListener(@Nullable a aVar) {
        this.c = aVar;
    }

    public final void setOnSolaceProPanelListener(@Nullable b bVar) {
        this.d = bVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void t(List<? extends BaseBallBean> list) {
        BaseBallBean baseBallBean;
        Object next;
        List<? extends BaseBallBean> arrayList = new ArrayList<>();
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next2 = it.next();
            BaseBallBean baseBallBean2 = (BaseBallBean) next2;
            if (baseBallBean2.isSelected() && uu1.g(baseBallBean2.getSymbol())) {
                arrayList.add(next2);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : list) {
            BaseBallBean baseBallBean3 = (BaseBallBean) obj;
            if (baseBallBean3.isSelected() && uu1.g(baseBallBean3.getSymbol()) && Intrinsics.areEqual(baseBallBean3.getToyFun(), "pos")) {
                arrayList2.add(obj);
            }
        }
        this.b.a.setText(getDrawerModelText());
        if (Intrinsics.areEqual(this.g, "CREATE_PATTERN")) {
            TextView textView = this.b.f;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.velvoDefault");
            textView.setVisibility(0);
        } else {
            RecyclerView recyclerView = this.b.g;
            Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.velvoRecyclerView");
            recyclerView.setVisibility(arrayList.isEmpty() ^ true ? 0 : 8);
            TextView textView2 = this.b.f;
            Intrinsics.checkNotNullExpressionValue(textView2, "binding.velvoDefault");
            textView2.setVisibility(arrayList.isEmpty() ? 0 : 8);
        }
        List<BaseBallBean> list2 = this.e;
        if (list2 != null) {
            Iterator<T> it2 = list2.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    next = null;
                    break;
                }
                next = it2.next();
                BaseBallBean baseBallBean4 = (BaseBallBean) next;
                if (baseBallBean4.isSelected() && uu1.g(baseBallBean4.getSymbol()) && Intrinsics.areEqual(baseBallBean4.getToyFun(), "pos")) {
                    break;
                }
            }
            baseBallBean = (BaseBallBean) next;
        } else {
            baseBallBean = null;
        }
        if (baseBallBean == null) {
            b bVar = this.d;
            if (bVar != null) {
                bVar.l(false, null);
            }
        } else {
            b bVar2 = this.d;
            if (bVar2 != null) {
                bVar2.l(true, baseBallBean.getToyAddress());
            }
        }
        if (Intrinsics.areEqual(this.g, "CREATE_PATTERN")) {
            arrayList = CollectionsKt__CollectionsKt.emptyList();
        }
        u(arrayList);
    }

    public final void u(List<? extends BaseBallBean> list) {
        RecyclerView.Adapter adapter = this.b.g.getAdapter();
        Intrinsics.checkNotNull(adapter, "null cannot be cast to non-null type com.wear.widget.control.multiToys.MultiVelvoPanel.VelvoPositionRangeAdapter");
        VelvoPositionRangeAdapter velvoPositionRangeAdapter = (VelvoPositionRangeAdapter) adapter;
        velvoPositionRangeAdapter.y0(CollectionsKt___CollectionsKt.toMutableList((Collection) list));
        if (getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
            if (!list.isEmpty()) {
                layoutParams.height = 0;
            } else {
                layoutParams.height = (int) qu1.a(120);
            }
            setLayoutParams(layoutParams);
            r();
        }
        RecyclerView recyclerView = this.b.g;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.velvoRecyclerView");
        ViewGroup.LayoutParams layoutParams2 = recyclerView.getLayoutParams();
        Objects.requireNonNull(layoutParams2, "null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        int iE = (gg3.e(getContext()) - (((int) qu1.a(20)) * 2)) - ((int) qu1.a(64));
        if (velvoPositionRangeAdapter.getItemCount() <= iE / ((int) qu1.a(64))) {
            iE = velvoPositionRangeAdapter.getItemCount() == 0 ? (int) qu1.a(64) : -2;
        }
        layoutParams2.width = iE;
        recyclerView.setLayoutParams(layoutParams2);
    }

    public final void v(View view) {
        a aVar = this.c;
        if (aVar != null) {
            aVar.g(new c());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public MultiVelvoPanel(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        ViewMultiVelvoPanelBinding viewMultiVelvoPanelBindingC = ViewMultiVelvoPanelBinding.c(LayoutInflater.from(context), this, true);
        Intrinsics.checkNotNullExpressionValue(viewMultiVelvoPanelBindingC, "inflate(LayoutInflater.from(context), this, true)");
        this.b = viewMultiVelvoPanelBindingC;
        viewMultiVelvoPanelBindingC.b.setOnClickListener(new View.OnClickListener() { // from class: dc.cp3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.n(view);
            }
        });
        viewMultiVelvoPanelBindingC.e.setOnClickListener(new View.OnClickListener() { // from class: dc.ep3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.v(view);
            }
        });
        viewMultiVelvoPanelBindingC.f.setOnClickListener(new View.OnClickListener() { // from class: dc.dp3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MultiVelvoPanel.a(view);
            }
        });
        f();
    }
}
