package com.wear.main.toy.newtoy;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.motion.widget.Key;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.epicgames.unreal.psoservices.PSOProgramService;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.lovense.wear.R;
import com.wear.bean.MyToyConfigBean;
import com.wear.bean.StrengthBean;
import com.wear.bean.Toy;
import com.wear.bean.ToyStrength;
import com.wear.bean.event.ToyListItemChangeSettingEvent;
import com.wear.bean.event.UpdateToyStrengthEvent;
import com.wear.dao.DaoUtils;
import com.wear.dao.ToyStrengthDao;
import com.wear.databinding.ItemMytoyitemSpeedRangeBinding;
import com.wear.databinding.ItemMytoyitemStrokeRangeBinding;
import com.wear.main.toy.newtoy.seekbar.SignSeekBar;
import com.wear.widget.seekbar.RangeSeekBar;
import dc.ToyControlBuilder;
import dc.ah4;
import dc.ak2;
import dc.ek2;
import dc.fk2;
import dc.mp1;
import dc.pc1;
import dc.rq1;
import dc.th4;
import dc.vu1;
import dc.wi1;
import dc.xs3;
import dc.ye3;
import dc.z12;
import dc.zt3;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.EventBus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smack.sm.packet.StreamManagement;
import org.jivesoftware.smackx.address.packet.MultipleAddresses;

/* compiled from: MyToyStrengthAdapter.kt */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003IJKB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J,\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010\u00102\u0006\u0010(\u001a\u00020\"2\u0006\u0010)\u001a\u00020\"2\b\u0010*\u001a\u0004\u0018\u00010+H\u0002J\u0016\u0010,\u001a\u00020&2\u0006\u0010-\u001a\u00020\u00022\u0006\u0010.\u001a\u00020\nJ\b\u0010/\u001a\u00020\"H\u0016J\u0010\u00100\u001a\u00020\"2\u0006\u00101\u001a\u00020\"H\u0016J\u0018\u00102\u001a\u00020&2\u0006\u0010-\u001a\u00020\u00022\u0006\u00101\u001a\u00020\"H\u0016J\u0018\u00103\u001a\u00020\u00022\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u00020\"H\u0016J(\u00107\u001a\u00020&2\u0006\u0010.\u001a\u00020\n2\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020;H\u0002J\"\u0010=\u001a\u00020&2\b\u0010*\u001a\u0004\u0018\u00010+2\u0006\u0010>\u001a\u00020\u00102\u0006\u0010?\u001a\u00020\"H\u0002J\u0014\u0010@\u001a\u00020&2\f\u0010A\u001a\b\u0012\u0004\u0012\u00020\n0BJ \u0010C\u001a\u00020&2\u0006\u0010.\u001a\u00020\n2\u0006\u0010D\u001a\u00020\"2\u0006\u0010E\u001a\u00020\"H\u0002J\u0018\u0010F\u001a\u00020&2\u0006\u0010-\u001a\u00020\u00022\u0006\u0010G\u001a\u00020HH\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R \u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u000e\u0010 \u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006L"}, d2 = {"Lcom/wear/main/toy/newtoy/MyToyStrengthAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "data", "", "Lcom/wear/bean/MyToyConfigBean;", "getData", "()Ljava/util/List;", "setData", "(Ljava/util/List;)V", "elementId", "", "getElementId", "()Ljava/lang/String;", "setElementId", "(Ljava/lang/String;)V", "funNameMap", "", "handler", "Landroid/os/Handler;", "logFlag", "onStrengthChangeListener", "Lcom/wear/main/toy/newtoy/MyToyStrengthAdapter$OnStrengthChangeListener;", "getOnStrengthChangeListener", "()Lcom/wear/main/toy/newtoy/MyToyStrengthAdapter$OnStrengthChangeListener;", "setOnStrengthChangeListener", "(Lcom/wear/main/toy/newtoy/MyToyStrengthAdapter$OnStrengthChangeListener;)V", "tempFun", "tempProgress", "", "tempTime", "", "addStrengthLog", "", "name", "startStrength", "endStrength", "toy", "Lcom/wear/bean/Toy;", "convert", "holder", "item", "getItemCount", "getItemViewType", "position", "onBindViewHolder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "saveStroke", "strokeForModel", "Lcom/wear/main/toy/solacepro/SolaceProModel;", "leftProgress", "", "rightProgress", "sendToyCommand", "function", "progress", "setNewInstance", "list", "", "setSettingProgress", "startProgress", "endProgress", "setViewEnable", StreamManagement.Enable.ELEMENT, "", "OnStrengthChangeListener", "Solace2SettingSpeedHolder", "Solace2SettingStrokeHolder", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class MyToyStrengthAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    @NotNull
    public final Context a;

    @NotNull
    public final Map<String, String> b;

    @Nullable
    public String c;

    @NotNull
    public String d;

    @Nullable
    public a e;

    @NotNull
    public List<MyToyConfigBean> f;

    @NotNull
    public String g;
    public int h;
    public long i;

    @NotNull
    public Handler j;

    /* compiled from: MyToyStrengthAdapter.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\r"}, d2 = {"Lcom/wear/main/toy/newtoy/MyToyStrengthAdapter$Solace2SettingSpeedHolder;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "view", "Landroid/view/View;", "(Lcom/wear/main/toy/newtoy/MyToyStrengthAdapter;Landroid/view/View;)V", "binding", "Lcom/wear/databinding/ItemMytoyitemSpeedRangeBinding;", "getBinding", "()Lcom/wear/databinding/ItemMytoyitemSpeedRangeBinding;", "convert", "", "item", "Lcom/wear/bean/MyToyConfigBean;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public final class Solace2SettingSpeedHolder extends BaseViewHolder {

        @NotNull
        public final ItemMytoyitemSpeedRangeBinding a;
        public final /* synthetic */ MyToyStrengthAdapter b;

        /* compiled from: MyToyStrengthAdapter.kt */
        @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u0016J\u001a\u0010\u000b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\f\u001a\u00020\nH\u0016J\u001a\u0010\r\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\f\u001a\u00020\nH\u0016¨\u0006\u000e"}, d2 = {"com/wear/main/toy/newtoy/MyToyStrengthAdapter$Solace2SettingSpeedHolder$convert$1", "Lcom/wear/widget/seekbar/OnRangeChangedListener;", "onRangeChanged", "", "view", "Lcom/wear/widget/seekbar/RangeSeekBar;", "leftValue", "", "rightValue", "isTouchMoving", "", "onStartTrackingTouch", "isLeft", "onStopTrackingTouch", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class a implements xs3 {
            public final /* synthetic */ MyToyConfigBean a;
            public final /* synthetic */ Solace2SettingSpeedHolder b;
            public final /* synthetic */ MyToyStrengthAdapter c;

            public a(MyToyConfigBean myToyConfigBean, Solace2SettingSpeedHolder solace2SettingSpeedHolder, MyToyStrengthAdapter myToyStrengthAdapter) {
                this.a = myToyConfigBean;
                this.b = solace2SettingSpeedHolder;
                this.c = myToyStrengthAdapter;
            }

            @Override // dc.xs3
            public void a(@Nullable RangeSeekBar rangeSeekBar, float f, float f2, boolean z) throws IllegalAccessException, NoSuchFieldException, IllegalArgumentException {
                EventBus.getDefault().post(new ToyListItemChangeSettingEvent(z, this.a.getToy()));
                TextView textView = this.b.getA().b;
                Intrinsics.checkNotNullExpressionValue(textView, "binding.mytoyItem1Funcationname");
                wi1.a(textView, true ^ (f == 0.0f));
                if (z) {
                    this.c.v(this.a.getToy(), "t", (int) f);
                    return;
                }
                this.c.v(this.a.getToy(), "t", 0);
                if (Intrinsics.areEqual(rangeSeekBar, this.b.getA().c)) {
                    System.out.println("leftValue:" + f);
                    this.c.z(this.a, 0, (int) f);
                }
            }

            @Override // dc.xs3
            public void b(@Nullable RangeSeekBar rangeSeekBar, boolean z) {
            }

            @Override // dc.xs3
            public void c(@Nullable RangeSeekBar rangeSeekBar, boolean z) {
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Solace2SettingSpeedHolder(@NotNull MyToyStrengthAdapter myToyStrengthAdapter, View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            this.b = myToyStrengthAdapter;
            ItemMytoyitemSpeedRangeBinding itemMytoyitemSpeedRangeBindingA = ItemMytoyitemSpeedRangeBinding.a(view);
            Intrinsics.checkNotNullExpressionValue(itemMytoyitemSpeedRangeBindingA, "bind(view)");
            this.a = itemMytoyitemSpeedRangeBindingA;
            itemMytoyitemSpeedRangeBindingA.c.getLeftSeekBar().K(th4.b(view.getContext(), R.color.item_pattern_toy_name_2));
            itemMytoyitemSpeedRangeBindingA.c.getRightSeekBar().K(th4.b(view.getContext(), R.color.item_pattern_toy_name_2));
            itemMytoyitemSpeedRangeBindingA.c.setProgressDefaultColor(th4.b(view.getContext(), R.color.report_edittext_box_stroke_color));
        }

        public final void a(@NotNull MyToyConfigBean item) {
            String thrustingStrength;
            Intrinsics.checkNotNullParameter(item, "item");
            this.a.b.setText(item.getFunName());
            ToyStrength config = item.getConfig();
            this.a.c.setProgress((config == null || (thrustingStrength = config.getThrustingStrength()) == null) ? 100.0f : Float.parseFloat(thrustingStrength));
            this.a.c.setIndicatorTextDecimalFormat("0");
            this.a.c.setIndicatorTextStringFormat("%s%%");
            this.a.c.setOnRangeChangedListener(new a(item, this, this.b));
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final ItemMytoyitemSpeedRangeBinding getA() {
            return this.a;
        }
    }

    /* compiled from: MyToyStrengthAdapter.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\r"}, d2 = {"Lcom/wear/main/toy/newtoy/MyToyStrengthAdapter$Solace2SettingStrokeHolder;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "view", "Landroid/view/View;", "(Lcom/wear/main/toy/newtoy/MyToyStrengthAdapter;Landroid/view/View;)V", "binding", "Lcom/wear/databinding/ItemMytoyitemStrokeRangeBinding;", "getBinding", "()Lcom/wear/databinding/ItemMytoyitemStrokeRangeBinding;", "convert", "", "item", "Lcom/wear/bean/MyToyConfigBean;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public final class Solace2SettingStrokeHolder extends BaseViewHolder {

        @NotNull
        public final ItemMytoyitemStrokeRangeBinding a;
        public final /* synthetic */ MyToyStrengthAdapter b;

        /* compiled from: MyToyStrengthAdapter.kt */
        @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u0016J\u001a\u0010\u000b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\f\u001a\u00020\nH\u0016J\u001a\u0010\r\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\f\u001a\u00020\nH\u0016¨\u0006\u000e"}, d2 = {"com/wear/main/toy/newtoy/MyToyStrengthAdapter$Solace2SettingStrokeHolder$convert$1", "Lcom/wear/widget/seekbar/OnRangeChangedListener;", "onRangeChanged", "", "view", "Lcom/wear/widget/seekbar/RangeSeekBar;", "leftValue", "", "rightValue", "isTouchMoving", "", "onStartTrackingTouch", "isLeft", "onStopTrackingTouch", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class a implements xs3 {
            public final /* synthetic */ MyToyConfigBean a;
            public final /* synthetic */ Solace2SettingStrokeHolder b;
            public final /* synthetic */ MyToyStrengthAdapter c;
            public final /* synthetic */ ek2 d;

            public a(MyToyConfigBean myToyConfigBean, Solace2SettingStrokeHolder solace2SettingStrokeHolder, MyToyStrengthAdapter myToyStrengthAdapter, ek2 ek2Var) {
                this.a = myToyConfigBean;
                this.b = solace2SettingStrokeHolder;
                this.c = myToyStrengthAdapter;
                this.d = ek2Var;
            }

            @Override // dc.xs3
            public void a(@Nullable RangeSeekBar rangeSeekBar, float f, float f2, boolean z) {
                EventBus.getDefault().post(new ToyListItemChangeSettingEvent(z, this.a.getToy()));
                if (!z && Intrinsics.areEqual(rangeSeekBar, this.b.getA().c)) {
                    System.out.println("leftValue:" + f);
                    this.c.u(this.a, this.d, f, f2);
                }
            }

            @Override // dc.xs3
            public void b(@Nullable RangeSeekBar rangeSeekBar, boolean z) {
            }

            @Override // dc.xs3
            public void c(@Nullable RangeSeekBar rangeSeekBar, boolean z) {
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Solace2SettingStrokeHolder(@NotNull MyToyStrengthAdapter myToyStrengthAdapter, View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            this.b = myToyStrengthAdapter;
            ItemMytoyitemStrokeRangeBinding itemMytoyitemStrokeRangeBindingA = ItemMytoyitemStrokeRangeBinding.a(view);
            Intrinsics.checkNotNullExpressionValue(itemMytoyitemStrokeRangeBindingA, "bind(view)");
            this.a = itemMytoyitemStrokeRangeBindingA;
            itemMytoyitemStrokeRangeBindingA.c.getLeftSeekBar().K(th4.b(view.getContext(), R.color.item_pattern_toy_name_2));
            itemMytoyitemStrokeRangeBindingA.c.getRightSeekBar().K(th4.b(view.getContext(), R.color.item_pattern_toy_name_2));
            itemMytoyitemStrokeRangeBindingA.c.setProgressDefaultColor(th4.b(view.getContext(), R.color.report_edittext_box_stroke_color));
        }

        public final void a(@NotNull MyToyConfigBean item) {
            Intrinsics.checkNotNullParameter(item, "item");
            this.a.b.setText(item.getFunName());
            fk2 fk2Var = fk2.a;
            Toy toy = item.getToy();
            ek2 ek2VarC = fk2Var.c(toy != null ? toy.getAddress() : null);
            Toy toy2 = item.getToy();
            int iE = fk2Var.e(toy2 != null ? toy2.getAndUpdateDeviceId() : null);
            Toy toy3 = item.getToy();
            int iD = fk2Var.d(toy3 != null ? toy3.getAndUpdateDeviceId() : null);
            this.a.c.setOnRangeChangedListener(null);
            this.a.c.setProgress(iE, iD);
            this.a.c.setIndicatorTextDecimalFormat("0");
            this.a.c.setOnRangeChangedListener(new a(item, this, this.b, ek2VarC));
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final ItemMytoyitemStrokeRangeBinding getA() {
            return this.a;
        }
    }

    /* compiled from: MyToyStrengthAdapter.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/wear/main/toy/newtoy/MyToyStrengthAdapter$OnStrengthChangeListener;", "", "onStrengthChange", "", "bean", "Lcom/wear/bean/StrengthBean;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public interface a {
        void a(@Nullable StrengthBean strengthBean);
    }

    /* compiled from: MyToyStrengthAdapter.kt */
    @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J*\u0010\n\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0016J*\u0010\r\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\u000e"}, d2 = {"com/wear/main/toy/newtoy/MyToyStrengthAdapter$convert$1", "Lcom/wear/main/toy/newtoy/seekbar/SignSeekBar$OnProgressChangedListener;", "getProgressOnActionUp", "", "signSeekBar", "Lcom/wear/main/toy/newtoy/seekbar/SignSeekBar;", "progress", "", "progressFloat", "", "getProgressOnFinally", "fromUser", "", "onProgressChanged", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class b implements SignSeekBar.f {
        public final /* synthetic */ MyToyConfigBean a;
        public final /* synthetic */ MyToyStrengthAdapter b;
        public final /* synthetic */ BaseViewHolder c;

        public b(MyToyConfigBean myToyConfigBean, MyToyStrengthAdapter myToyStrengthAdapter, BaseViewHolder baseViewHolder) {
            this.a = myToyConfigBean;
            this.b = myToyStrengthAdapter;
            this.c = baseViewHolder;
        }

        @Override // com.wear.main.toy.newtoy.seekbar.SignSeekBar.f
        public void a(@Nullable SignSeekBar signSeekBar, int i, float f, boolean z) throws IllegalAccessException, NoSuchFieldException, IllegalArgumentException {
            EventBus.getDefault().post(new ToyListItemChangeSettingEvent(false, this.a.getToy()));
            this.b.z(this.a, 0, i);
        }

        @Override // com.wear.main.toy.newtoy.seekbar.SignSeekBar.f
        public void b(@Nullable SignSeekBar signSeekBar, int i, float f) {
        }

        @Override // com.wear.main.toy.newtoy.seekbar.SignSeekBar.f
        public void c(@Nullable SignSeekBar signSeekBar, int i, float f, boolean z) {
            EventBus.getDefault().post(new ToyListItemChangeSettingEvent(true, this.a.getToy()));
            String str = "item.funName===" + this.a.getFunName();
            MyToyStrengthAdapter myToyStrengthAdapter = this.b;
            Toy toy = this.a.getToy();
            String funName = this.a.getFunName();
            if (funName == null) {
                funName = "";
            }
            myToyStrengthAdapter.v(toy, funName, i);
            this.b.A(this.c, i != 0);
        }
    }

    /* compiled from: MyToyStrengthAdapter.kt */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/wear/main/toy/newtoy/MyToyStrengthAdapter$handler$1", "Landroid/os/Handler;", "handleMessage", "", NotificationCompat.CATEGORY_MESSAGE, "Landroid/os/Message;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class c extends Handler {
        public c(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(@NotNull Message msg) {
            Bundle data;
            String lowerCase;
            Intrinsics.checkNotNullParameter(msg, "msg");
            super.handleMessage(msg);
            if (msg.what != 1 || (data = msg.getData()) == null) {
                return;
            }
            MyToyStrengthAdapter myToyStrengthAdapter = MyToyStrengthAdapter.this;
            int i = data.getInt("startStrength");
            int i2 = data.getInt("endStrength");
            String string = data.getString("name");
            String string2 = data.getString(MultipleAddresses.Address.ELEMENT);
            String string3 = data.getString("deviceType");
            if (string2 != null) {
                String str = "addStrengthLog: " + string3;
                String c = myToyStrengthAdapter.getC();
                if (string != null) {
                    lowerCase = string.toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
                } else {
                    lowerCase = null;
                }
                String str2 = lowerCase;
                StringBuilder sb = new StringBuilder();
                sb.append(i);
                sb.append('_');
                sb.append(i2);
                ye3.k("toys", "edit_toys_strength", "edit", c, str2, sb.toString(), "", -1L, string2);
            }
        }
    }

    public MyToyStrengthAdapter(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.a = context;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(PSOProgramService.VS_Key, "vibrate");
        linkedHashMap.put("v1", "vibrate1");
        linkedHashMap.put("v2", "vibrate2");
        linkedHashMap.put("v3", "vibrate3");
        linkedHashMap.put(StreamManagement.AckRequest.ELEMENT, Key.ROTATION);
        linkedHashMap.put("p", "contract");
        linkedHashMap.put("s", Toy.TOY_FEATURE_TENERA);
        linkedHashMap.put("t", "thrusting");
        linkedHashMap.put("f", "fingering");
        linkedHashMap.put(GoogleApiAvailabilityLight.TRACKING_SOURCE_DIALOG, "depth");
        linkedHashMap.put("pos", "position");
        this.b = linkedHashMap;
        this.d = "";
        this.f = new ArrayList();
        this.g = "";
        this.j = new c(Looper.getMainLooper());
    }

    public final void A(BaseViewHolder baseViewHolder, boolean z) {
        wi1.a(baseViewHolder.getView(R.id.mytoy_item1_funcationname), z);
        wi1.a(baseViewHolder.getView(R.id.mytoy_item1_funcationbg), z);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return this.f.get(position).getConfigType();
    }

    public final void p(String str, int i, int i2, Toy toy) {
        String lowerCase;
        if (toy == null) {
            return;
        }
        if (str == null || str.length() == 0) {
            return;
        }
        String str2 = str + '_' + toy.getAddress();
        if (Intrinsics.areEqual(this.d, str2)) {
            this.j.removeMessages(1);
        }
        this.d = str2;
        String str3 = "";
        if (!toy.isBAToy()) {
            String str4 = this.b.get(str);
            if (str4 != null) {
                lowerCase = str4.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
                if (lowerCase != null) {
                    str3 = lowerCase;
                }
            }
        } else if (TextUtils.equals(str, "Stroke Range")) {
            lowerCase = fk2.a.c(toy.getAddress()) == ek2.POSITION ? "pos_range" : "stroke_range";
            str3 = lowerCase;
        } else if (TextUtils.equals(str, "Thrusting Speed")) {
            str3 = "thrusting";
        }
        Message messageObtainMessage = this.j.obtainMessage();
        Intrinsics.checkNotNullExpressionValue(messageObtainMessage, "handler.obtainMessage()");
        messageObtainMessage.what = 1;
        messageObtainMessage.obj = str3;
        Bundle bundle = new Bundle();
        bundle.putInt("startStrength", i);
        bundle.putInt("endStrength", i2);
        bundle.putString("name", str3);
        bundle.putString(MultipleAddresses.Address.ELEMENT, toy.getAddress());
        bundle.putString("deviceType", toy.getDeviceType());
        messageObtainMessage.setData(bundle);
        this.j.sendMessageDelayed(messageObtainMessage, 5000L);
    }

    public final void q(@NotNull BaseViewHolder holder, @NotNull MyToyConfigBean item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        if (item.getTfunIcon() > 0) {
            holder.setImageDrawable(R.id.mytoy_item1_funcationbg, th4.d(this.a, item.getTfunIcon()));
        }
        Map<String, String> TOY_STRENGTH = Toy.TOY_STRENGTH;
        Intrinsics.checkNotNullExpressionValue(TOY_STRENGTH, "TOY_STRENGTH");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, String> entry : TOY_STRENGTH.entrySet()) {
            if (Intrinsics.areEqual(entry.getValue(), item.getFunName())) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        Integer num = Toy.TOY_LANGUAGE.get((String) CollectionsKt___CollectionsKt.first(linkedHashMap.keySet()));
        holder.setText(R.id.mytoy_item1_funcationname, ah4.e(num != null ? num.intValue() : R.string.toy_control_type1));
        A(holder, !Intrinsics.areEqual(item.getToyStrength(), 0.0f));
        SignSeekBar signSeekBar = (SignSeekBar) holder.getView(R.id.mytoy_item1_seekbar);
        signSeekBar.setOnProgressChangedListener(null);
        Float toyStrength = item.getToyStrength();
        signSeekBar.setProgress(toyStrength != null ? toyStrength.floatValue() : 0.0f);
        ak2 configBuilder = signSeekBar.getConfigBuilder();
        configBuilder.f(ContextCompat.getColor(this.a, R.color.gray_cbcbcb));
        Context context = this.a;
        Map<String, Integer> map = Toy.ICON_TOY_STRENGTH_COLOR;
        Integer num2 = map.get(item.getFunName());
        int iIntValue = R.color.func_v_trans;
        configBuilder.b(ContextCompat.getColor(context, num2 != null ? num2.intValue() : R.color.func_v_trans));
        Context context2 = this.a;
        Integer num3 = map.get(item.getFunName());
        if (num3 != null) {
            iIntValue = num3.intValue();
        }
        configBuilder.d(ContextCompat.getColor(context2, iIntValue));
        configBuilder.c(th4.b(this.a, R.color.item_pattern_toy_name_2));
        configBuilder.e(ContextCompat.getColor(this.a, R.color.white));
        configBuilder.f(th4.b(this.a, R.color.seekbar_default_bg));
        configBuilder.a();
        signSeekBar.setOnProgressChangedListener(new b(item, this, holder));
    }

    @Nullable
    /* renamed from: r, reason: from getter */
    public final String getC() {
        return this.c;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull BaseViewHolder holder, int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        MyToyConfigBean myToyConfigBean = this.f.get(i);
        if (holder instanceof Solace2SettingSpeedHolder) {
            ((Solace2SettingSpeedHolder) holder).a(myToyConfigBean);
        } else if (holder instanceof Solace2SettingStrokeHolder) {
            ((Solace2SettingStrokeHolder) holder).a(myToyConfigBean);
        } else {
            q(holder, myToyConfigBean);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public BaseViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        MyToyConfigBean.ToyConfigType toyConfigType = MyToyConfigBean.ToyConfigType.INSTANCE;
        if (i == toyConfigType.getSTROKE()) {
            View view = LayoutInflater.from(this.a).inflate(R.layout.item_mytoyitem_stroke_range, parent, false);
            Intrinsics.checkNotNullExpressionValue(view, "view");
            return new Solace2SettingStrokeHolder(this, view);
        }
        if (i == toyConfigType.getSPEED()) {
            View view2 = LayoutInflater.from(this.a).inflate(R.layout.item_mytoyitem_speed_range, parent, false);
            Intrinsics.checkNotNullExpressionValue(view2, "view");
            return new Solace2SettingSpeedHolder(this, view2);
        }
        View view3 = LayoutInflater.from(this.a).inflate(R.layout.toy_mytoyitem1_itemlayout, parent, false);
        Intrinsics.checkNotNullExpressionValue(view3, "view");
        return new BaseViewHolder(view3);
    }

    public final void u(MyToyConfigBean myToyConfigBean, ek2 ek2Var, float f, float f2) {
        int i = (int) f;
        int i2 = (int) f2;
        fk2.a.h(myToyConfigBean.getToy(), ek2Var, i, i2, false);
        vu1.a aVar = vu1.a;
        Toy toy = myToyConfigBean.getToy();
        StrengthBean strengthBeanC = aVar.c(toy != null ? toy.getAndUpdateDeviceId() : null);
        a aVar2 = this.e;
        if (aVar2 != null) {
            aVar2.a(strengthBeanC);
        }
        p(myToyConfigBean.getFunName(), i, i2, myToyConfigBean.getToy());
    }

    public final void v(Toy toy, String str, int i) {
        if (z12.a()) {
            return;
        }
        if (Intrinsics.areEqual(this.g, str) && this.h == i) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.i >= 100 || i == 0) {
            this.i = jCurrentTimeMillis;
            this.g = str;
            this.h = i;
            if (!mp1.a.b()) {
                pc1.a.n0(toy, new String[]{str}, new String[]{String.valueOf(i)}, true, false, false);
            } else if (toy != null) {
                rq1 rq1Var = rq1.d;
                String address = toy.getAddress();
                Intrinsics.checkNotNullExpressionValue(address, "toy.address");
                rq1Var.n(address, str, String.valueOf(i), new ToyControlBuilder(true, false, false, ToyControlBuilder.a.SPEED));
            }
        }
    }

    public final void w(@Nullable String str) {
        this.c = str;
    }

    public final void x(@NotNull List<MyToyConfigBean> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.f.clear();
        this.f.addAll(list);
        notifyDataSetChanged();
    }

    public final void y(@Nullable a aVar) {
        this.e = aVar;
    }

    public final void z(MyToyConfigBean myToyConfigBean, int i, int i2) throws IllegalAccessException, NoSuchFieldException, IllegalArgumentException {
        Field declaredField;
        vu1.a aVar = vu1.a;
        Toy toy = myToyConfigBean.getToy();
        StrengthBean strengthBeanC = aVar.c(toy != null ? toy.getAndUpdateDeviceId() : null);
        if (strengthBeanC == null) {
            Toy toy2 = myToyConfigBean.getToy();
            strengthBeanC = new StrengthBean(toy2 != null ? toy2.getAndUpdateDeviceId() : null);
            Toy toy3 = myToyConfigBean.getToy();
            aVar.e(toy3 != null ? toy3.getAndUpdateDeviceId() : null, strengthBeanC);
        }
        StrengthBean.Data data = strengthBeanC.getData();
        if (data == null) {
            data = new StrengthBean.Data();
            strengthBeanC.setData(data);
        }
        StrengthBean.Data data2 = data;
        try {
            String funName = myToyConfigBean.getFunName();
            if (funName == null) {
                funName = "";
            }
            declaredField = StrengthBean.Data.class.getDeclaredField(funName);
        } catch (Exception e) {
            e.printStackTrace();
            declaredField = null;
        }
        if (declaredField != null) {
            declaredField.setAccessible(true);
            Toy toy4 = myToyConfigBean.getToy();
            if (toy4 != null && toy4.isQ01Toy()) {
                data2.setV(Integer.valueOf(i2));
            } else {
                Toy toy5 = myToyConfigBean.getToy();
                if (toy5 != null && toy5.isF01Toy()) {
                    data2.setV(Integer.valueOf(i2));
                }
            }
            Integer numValueOf = Integer.valueOf(i2);
            declaredField.set(data2, Integer.valueOf(numValueOf != null ? numValueOf.intValue() : 100));
        }
        Toy toy6 = myToyConfigBean.getToy();
        if (toy6 != null && toy6.isBAToy()) {
            data2.setT(Integer.valueOf(i2));
        }
        String str = "strengthData" + data2;
        ToyStrengthDao toyStrengthDao = DaoUtils.getToyStrengthDao();
        String str2 = zt3.k;
        Toy toy7 = myToyConfigBean.getToy();
        ToyStrength toyStrengthFindToyStrength = toyStrengthDao.findToyStrength(str2, toy7 != null ? toy7.getAndUpdateDeviceId() : null);
        if (toyStrengthFindToyStrength == null) {
            String str3 = zt3.k;
            Toy toy8 = myToyConfigBean.getToy();
            toyStrengthFindToyStrength = new ToyStrength(str3, toy8 != null ? toy8.getAndUpdateDeviceId() : null);
        }
        toyStrengthFindToyStrength.setStrength(data2.getV(), data2.getV1(), data2.getV2(), data2.getV3(), data2.getR(), data2.getP(), data2.getS(), data2.getT(), data2.getF(), data2.getD(), data2.getStrokeMin(), data2.getStrokeMax());
        DaoUtils.getToyStrengthDao().updateOrAdd(toyStrengthFindToyStrength);
        p(myToyConfigBean.getFunName(), i, i2, myToyConfigBean.getToy());
        a aVar2 = this.e;
        if (aVar2 != null) {
            aVar2.a(strengthBeanC);
        }
        EventBus.getDefault().post(new UpdateToyStrengthEvent(myToyConfigBean.getToy()));
        Toy toy9 = myToyConfigBean.getToy();
        String funName2 = myToyConfigBean.getFunName();
        v(toy9, funName2 != null ? funName2 : "", 0);
    }
}
