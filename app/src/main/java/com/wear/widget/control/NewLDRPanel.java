package com.wear.widget.control;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.lovense.wear.R;
import com.wear.adapter.longdistance.LdrToyAdapter;
import com.wear.bean.Account;
import com.wear.bean.Toy;
import com.wear.bean.User;
import com.wear.bean.event.UserUpdateEvent;
import com.wear.main.longDistance.control.LDRControl;
import com.wear.util.WearUtils;
import com.wear.widget.control.NewLDRPanel;
import dc.cg3;
import dc.xc1;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsJvmKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smackx.address.packet.MultipleAddresses;

/* compiled from: NewLDRPanel.kt */
@Metadata(d1 = {"\u0000¬\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004B\u001b\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B#\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0006\u0010B\u001a\u00020CJ\b\u0010D\u001a\u0004\u0018\u00010\u0019J4\u0010E\u001a\u0012\u0012\u0004\u0012\u00020\u00120'j\b\u0012\u0004\u0012\u00020\u0012`(2\u001a\u0010F\u001a\u0016\u0012\u0004\u0012\u00020\u0012\u0018\u00010'j\n\u0012\u0004\u0012\u00020\u0012\u0018\u0001`(H\u0002J\u0010\u0010G\u001a\u0004\u0018\u00010\u00192\u0006\u0010H\u001a\u00020IJ\b\u0010J\u001a\u00020CH\u0002J\u0010\u0010K\u001a\u00020C2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016J\u0010\u0010L\u001a\u00020M2\u0006\u0010N\u001a\u00020\u0012H\u0002J\u0006\u0010O\u001a\u00020CJ\u0006\u0010P\u001a\u00020CJ\u0010\u0010Q\u001a\u00020C2\u0006\u0010R\u001a\u00020SH\u0007J\u0010\u0010Q\u001a\u00020C2\u0006\u0010R\u001a\u00020TH\u0007J\u0006\u0010U\u001a\u00020CJ\u0006\u0010V\u001a\u00020CJ\u0006\u0010W\u001a\u00020CJ\u0006\u0010X\u001a\u00020CJ\u000e\u0010Y\u001a\u00020C2\u0006\u0010Z\u001a\u00020\tJ\u0010\u0010[\u001a\u00020C2\b\u0010\\\u001a\u0004\u0018\u00010]J\u0017\u0010^\u001a\u00020C2\n\b\u0002\u0010_\u001a\u0004\u0018\u00010M¢\u0006\u0002\u0010`J\u0012\u0010a\u001a\u00020C2\n\b\u0002\u0010b\u001a\u0004\u0018\u00010IJ\u001e\u0010c\u001a\u00020C2\u0016\u0010d\u001a\u0012\u0012\u0004\u0012\u00020\u00120'j\b\u0012\u0004\u0012\u00020\u0012`(J\u0010\u0010e\u001a\u00020C2\b\u0010f\u001a\u0004\u0018\u00010gJ\u0017\u0010\u001c\u001a\u00020C2\n\b\u0002\u0010Z\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010hJ\u000e\u0010i\u001a\u00020C2\u0006\u0010Z\u001a\u00020\tJ\b\u0010j\u001a\u00020CH\u0002J\u000e\u0010k\u001a\u00020C2\u0006\u0010Z\u001a\u00020\tJ\u0017\u0010l\u001a\u00020C2\n\b\u0002\u0010_\u001a\u0004\u0018\u00010M¢\u0006\u0002\u0010`J\u001e\u0010m\u001a\u00020C2\u0016\u0010d\u001a\u0012\u0012\u0004\u0012\u00020\u00120'j\b\u0012\u0004\u0012\u00020\u0012`(J\u000e\u0010n\u001a\u00020C2\u0006\u0010o\u001a\u00020\tJ\u0018\u0010p\u001a\u00020C2\u000e\u0010q\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010rH\u0002J\u000e\u0010s\u001a\u00020C2\u0006\u0010o\u001a\u00020\tJ\u0018\u0010t\u001a\u00020C2\u0006\u0010u\u001a\u00020\u00192\u0006\u0010v\u001a\u00020\tH\u0002J\u0016\u0010t\u001a\u00020C2\u0006\u0010v\u001a\u00020\t2\u0006\u0010w\u001a\u00020MJ9\u0010t\u001a\u00020C2\b\u0010x\u001a\u0004\u0018\u00010I2\f\u0010y\u001a\b\u0012\u0004\u0012\u00020I0z2\f\u0010{\u001a\b\u0012\u0004\u0012\u00020I0z2\u0006\u0010w\u001a\u00020M¢\u0006\u0002\u0010|J\"\u0010t\u001a\u00020C2\b\u0010x\u001a\u0004\u0018\u00010I2\u0006\u0010v\u001a\u00020\t2\u0006\u0010w\u001a\u00020MH\u0002R\u001e\u0010\u000b\u001a\u00020\f8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0018\u001a\u00020\u00198\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001e\u0010\u001e\u001a\u00020\f8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u000e\"\u0004\b \u0010\u0010R\u001e\u0010!\u001a\u00020\u00018\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001e\u0010&\u001a\u0012\u0012\u0004\u0012\u00020\u00120'j\b\u0012\u0004\u0012\u00020\u0012`(X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010)\u001a\u0012\u0012\u0004\u0012\u00020\u00120'j\b\u0012\u0004\u0012\u00020\u0012`(X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010*\u001a\u00020\f8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u000e\"\u0004\b,\u0010\u0010R\u001e\u0010-\u001a\u00020.8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001e\u00103\u001a\u00020.8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00100\"\u0004\b5\u00102R\u0010\u00106\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00107\u001a\u0004\u0018\u000108X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u00109\u001a\u00020:8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u001e\u0010?\u001a\u00020:8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010<\"\u0004\bA\u0010>¨\u0006}"}, d2 = {"Lcom/wear/widget/control/NewLDRPanel;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "divider", "Landroid/view/View;", "getDivider", "()Landroid/view/View;", "setDivider", "(Landroid/view/View;)V", "fSelectToy", "Lcom/wear/bean/Toy;", "friendLdrToyAdapter", "Lcom/wear/adapter/longdistance/LdrToyAdapter;", "friendUser", "Lcom/wear/bean/User;", "iSelectToy", "ivLdrControlStates", "Landroid/widget/ImageView;", "getIvLdrControlStates", "()Landroid/widget/ImageView;", "setIvLdrControlStates", "(Landroid/widget/ImageView;)V", "leftView", "getLeftView", "setLeftView", "llPanel", "getLlPanel", "()Landroid/widget/LinearLayout;", "setLlPanel", "(Landroid/widget/LinearLayout;)V", "ownerToy", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "partnerToy", "rightView", "getRightView", "setRightView", "rvFriend", "Landroidx/recyclerview/widget/RecyclerView;", "getRvFriend", "()Landroidx/recyclerview/widget/RecyclerView;", "setRvFriend", "(Landroidx/recyclerview/widget/RecyclerView;)V", "rvSelf", "getRvSelf", "setRvSelf", "selfLdrToyAdapter", "selfUser", "Lcom/wear/bean/Account;", "tvFriendName", "Landroid/widget/TextView;", "getTvFriendName", "()Landroid/widget/TextView;", "setTvFriendName", "(Landroid/widget/TextView;)V", "tvMe", "getTvMe", "setTvMe", "endLdrControl", "", "getLdrControlStatesImageView", "getSortList", "list", "getToyBatteryImageView", "deviceId", "", "init", "initToys", "isSupportButtonFeedBack", "", "t", "notifyFriendDataSetChanged", "notifySelfDataSetChanged", "onMessageEvent", "event", "Lcom/lovense/btservice/work/EventBusToyConnectEvent;", "Lcom/wear/bean/event/UserUpdateEvent;", "resetLdrFriendToySelect", "resetLdrSelfToySelect", "resetLdrToySelect", "scrollToPosition", "setBackground", "resource", "setDividerBackground", "drawable", "Landroid/graphics/drawable/Drawable;", "setFriendAvailable", "available", "(Ljava/lang/Boolean;)V", "setFriendName", "name", "setFriendToys", "toys", "setItemClickListener", "itemClickListener", "Lcom/wear/adapter/longdistance/LdrToyAdapter$ItemClickListener;", "(Ljava/lang/Integer;)V", "setLeftViewBackground", "setMasterToys", "setRightViewBackground", "setSelfAvailable", "setSelfToys", "updateFriendSelectToy", "position", "updatePartnerLinkToys", "updateLinkedToys", "", "updateSelfSelectToy", "updateWaggleLevel", "ivLevel", FirebaseAnalytics.Param.LEVEL, "isMaster", MultipleAddresses.Address.ELEMENT, "funs", "", "groups", "(Ljava/lang/String;[Ljava/lang/String;[Ljava/lang/String;Z)V", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public final class NewLDRPanel extends LinearLayout {

    @NotNull
    public ArrayList<Toy> a;

    @NotNull
    public ArrayList<Toy> b;

    @Nullable
    public Toy c;

    @Nullable
    public Toy d;

    @BindView(R.id.divider)
    public View divider;

    @Nullable
    public LdrToyAdapter e;

    @Nullable
    public LdrToyAdapter f;

    @Nullable
    public User g;

    @Nullable
    public Account h;

    @BindView(R.id.iv_ldr_control_states)
    public ImageView ivLdrControlStates;

    @BindView(R.id.left_view)
    public View leftView;

    @BindView(R.id.ll_panel)
    public LinearLayout llPanel;

    @BindView(R.id.right_view)
    public View rightView;

    @BindView(R.id.rv_friend)
    public RecyclerView rvFriend;

    @BindView(R.id.rv_self)
    public RecyclerView rvSelf;

    @BindView(R.id.tv_friend_name)
    public TextView tvFriendName;

    @BindView(R.id.tv_me)
    public TextView tvMe;

    /* compiled from: Comparisons.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @SourceDebugExtension({"SMAP\nComparisons.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Comparisons.kt\nkotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2\n*L\n1#1,328:1\n*E\n"})
    public static final class a<T> implements Comparator {
        public a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            Toy toy = (Toy) t;
            boolean z = true;
            Boolean boolValueOf = Boolean.valueOf((toy.isSupportLdr() || (NewLDRPanel.this.f(toy) && LDRControl.p)) ? false : true);
            Toy toy2 = (Toy) t2;
            if (toy2.isSupportLdr() || (NewLDRPanel.this.f(toy2) && LDRControl.p)) {
                z = false;
            }
            return ComparisonsKt__ComparisonsKt.compareValues(boolValueOf, Boolean.valueOf(z));
        }
    }

    public NewLDRPanel(@Nullable Context context) {
        this(context, null);
    }

    public static final void o(NewLDRPanel this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        LdrToyAdapter ldrToyAdapter = this$0.e;
        if (ldrToyAdapter != null) {
            ldrToyAdapter.notifyDataSetChanged();
        }
        this$0.l();
    }

    public static /* synthetic */ void setFriendAvailable$default(NewLDRPanel newLDRPanel, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            bool = Boolean.FALSE;
        }
        newLDRPanel.setFriendAvailable(bool);
    }

    public static /* synthetic */ void setFriendName$default(NewLDRPanel newLDRPanel, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        newLDRPanel.setFriendName(str);
    }

    public static /* synthetic */ void setIvLdrControlStates$default(NewLDRPanel newLDRPanel, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            num = null;
        }
        newLDRPanel.setIvLdrControlStates(num);
    }

    public static /* synthetic */ void setSelfAvailable$default(NewLDRPanel newLDRPanel, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            bool = Boolean.FALSE;
        }
        newLDRPanel.setSelfAvailable(bool);
    }

    public static final void u(int i, ImageView ivLevel) {
        Intrinsics.checkNotNullParameter(ivLevel, "$ivLevel");
        if (i <= 0) {
            ivLevel.setImageResource(R.drawable.chat_ldr_feedback_level0);
            return;
        }
        if (i < 5) {
            ivLevel.setImageResource(R.drawable.chat_ldr_feedback_level1);
            return;
        }
        if (i < 10) {
            ivLevel.setImageResource(R.drawable.chat_ldr_feedback_level2);
        } else if (i < 15) {
            ivLevel.setImageResource(R.drawable.chat_ldr_feedback_level3);
        } else {
            ivLevel.setImageResource(R.drawable.chat_ldr_feedback_level4);
        }
    }

    public final void b() {
        this.d = null;
        EventBus.getDefault().unregister(this);
    }

    public final ArrayList<Toy> c(ArrayList<Toy> arrayList) {
        return new ArrayList<>(arrayList != null ? CollectionsKt___CollectionsKt.sortedWith(arrayList, new a()) : null);
    }

    public final void d() {
        View viewInflate = LayoutInflater.from(getContext()).inflate(R.layout.view_base_ldr_control, this);
        Intrinsics.checkNotNull(viewInflate, "null cannot be cast to non-null type android.view.ViewGroup");
        ButterKnife.bind(this, (ViewGroup) viewInflate);
        this.e = new LdrToyAdapter(this.b, R.layout.item_ldr_toy, false);
        this.f = new LdrToyAdapter(this.a, R.layout.item_ldr_toy, true);
        cg3.d(getRvFriend(), this.e);
        cg3.d(getRvSelf(), this.f);
        EventBus.getDefault().register(this);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x005b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void e(@org.jetbrains.annotations.Nullable com.wear.bean.User r3) {
        /*
            r2 = this;
            r2.g = r3
            dc.ch3 r0 = dc.ch3.n()
            com.wear.bean.Account r0 = r0.u()
            r2.h = r0
            java.util.ArrayList<com.wear.bean.Toy> r0 = r2.a
            r0.clear()
            com.wear.bean.Toy r0 = new com.wear.bean.Toy
            r0.<init>()
            java.lang.String r1 = "touch_icon_flag"
            r0.setName(r1)
            java.util.ArrayList<com.wear.bean.Toy> r1 = r2.a
            r1.add(r0)
            java.util.ArrayList<com.wear.bean.Toy> r0 = r2.b
            r0.clear()
            boolean r0 = r3 instanceof com.wear.bean.UserControlLink
            if (r0 == 0) goto L5b
            r0 = r3
            com.wear.bean.UserControlLink r0 = (com.wear.bean.UserControlLink) r0
            boolean r1 = r0.isControlLink()
            if (r1 == 0) goto L5b
            com.wear.bean.Account r3 = r2.h
            if (r3 == 0) goto L73
            boolean r1 = r3.isControlLinkJoiner()
            if (r1 != 0) goto L46
            java.util.ArrayList<com.wear.bean.Toy> r1 = r2.a
            java.util.ArrayList r3 = r3.getControlLinkToys()
            r1.addAll(r3)
            goto L51
        L46:
            java.util.ArrayList<com.wear.bean.Toy> r3 = r2.a
            dc.pc1 r1 = dc.pc1.a
            java.util.ArrayList r1 = r1.P()
            r3.addAll(r1)
        L51:
            java.util.ArrayList<com.wear.bean.Toy> r3 = r2.b
            java.util.ArrayList r0 = r0.getCLLinkedToys2()
            r3.addAll(r0)
            goto L73
        L5b:
            java.util.ArrayList<com.wear.bean.Toy> r0 = r2.a
            dc.pc1 r1 = dc.pc1.a
            java.util.ArrayList r1 = r1.P()
            r0.addAll(r1)
            if (r3 == 0) goto L73
            java.util.ArrayList r3 = r3.getLinkedToys2()
            if (r3 == 0) goto L73
            java.util.ArrayList<com.wear.bean.Toy> r0 = r2.b
            r0.addAll(r3)
        L73:
            r2.m()
            r2.k()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wear.widget.control.NewLDRPanel.e(com.wear.bean.User):void");
    }

    public final boolean f(Toy toy) {
        return toy.isH01Toy() || toy.isBAToy();
    }

    @NotNull
    public final View getDivider() {
        View view = this.divider;
        if (view != null) {
            return view;
        }
        Intrinsics.throwUninitializedPropertyAccessException("divider");
        return null;
    }

    @NotNull
    public final ImageView getIvLdrControlStates() {
        ImageView imageView = this.ivLdrControlStates;
        if (imageView != null) {
            return imageView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("ivLdrControlStates");
        return null;
    }

    @Nullable
    public final ImageView getLdrControlStatesImageView() {
        return getIvLdrControlStates();
    }

    @NotNull
    public final View getLeftView() {
        View view = this.leftView;
        if (view != null) {
            return view;
        }
        Intrinsics.throwUninitializedPropertyAccessException("leftView");
        return null;
    }

    @NotNull
    public final LinearLayout getLlPanel() {
        LinearLayout linearLayout = this.llPanel;
        if (linearLayout != null) {
            return linearLayout;
        }
        Intrinsics.throwUninitializedPropertyAccessException("llPanel");
        return null;
    }

    @NotNull
    public final View getRightView() {
        View view = this.rightView;
        if (view != null) {
            return view;
        }
        Intrinsics.throwUninitializedPropertyAccessException("rightView");
        return null;
    }

    @NotNull
    public final RecyclerView getRvFriend() {
        RecyclerView recyclerView = this.rvFriend;
        if (recyclerView != null) {
            return recyclerView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("rvFriend");
        return null;
    }

    @NotNull
    public final RecyclerView getRvSelf() {
        RecyclerView recyclerView = this.rvSelf;
        if (recyclerView != null) {
            return recyclerView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("rvSelf");
        return null;
    }

    @NotNull
    public final TextView getTvFriendName() {
        TextView textView = this.tvFriendName;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("tvFriendName");
        return null;
    }

    @NotNull
    public final TextView getTvMe() {
        TextView textView = this.tvMe;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("tvMe");
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0085  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void i() {
        /*
            r6 = this;
            com.wear.bean.Toy r0 = r6.d
            r1 = 0
            if (r0 == 0) goto L41
            java.util.ArrayList<com.wear.bean.Toy> r0 = r6.b
            kotlin.ranges.IntRange r0 = kotlin.collections.CollectionsKt__CollectionsKt.getIndices(r0)
            java.util.Iterator r0 = r0.iterator()
        Lf:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L3d
            java.lang.Object r2 = r0.next()
            r3 = r2
            java.lang.Number r3 = (java.lang.Number) r3
            int r3 = r3.intValue()
            java.util.ArrayList<com.wear.bean.Toy> r4 = r6.b
            java.lang.Object r3 = r4.get(r3)
            com.wear.bean.Toy r3 = (com.wear.bean.Toy) r3
            java.lang.String r3 = r3.getAndUpdateDeviceId()
            com.wear.bean.Toy r4 = r6.d
            if (r4 == 0) goto L35
            java.lang.String r4 = r4.getAndUpdateDeviceId()
            goto L36
        L35:
            r4 = r1
        L36:
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r3, r4)
            if (r3 == 0) goto Lf
            goto L3e
        L3d:
            r2 = r1
        L3e:
            java.lang.Integer r2 = (java.lang.Integer) r2
            goto L8c
        L41:
            java.util.ArrayList<com.wear.bean.Toy> r0 = r6.b
            kotlin.ranges.IntRange r0 = kotlin.collections.CollectionsKt__CollectionsKt.getIndices(r0)
            java.util.Iterator r0 = r0.iterator()
            r2 = r1
        L4c:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L8a
            java.lang.Object r3 = r0.next()
            r4 = r3
            java.lang.Number r4 = (java.lang.Number) r4
            int r4 = r4.intValue()
            java.util.ArrayList<com.wear.bean.Toy> r5 = r6.b
            java.lang.Object r5 = r5.get(r4)
            com.wear.bean.Toy r5 = (com.wear.bean.Toy) r5
            boolean r5 = r5.isSupportLdr()
            if (r5 != 0) goto L85
            java.util.ArrayList<com.wear.bean.Toy> r5 = r6.b
            java.lang.Object r4 = r5.get(r4)
            java.lang.String r5 = "partnerToy[i]"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)
            com.wear.bean.Toy r4 = (com.wear.bean.Toy) r4
            boolean r4 = r6.f(r4)
            if (r4 == 0) goto L83
            boolean r4 = com.wear.main.longDistance.control.LDRControl.p
            if (r4 == 0) goto L83
            goto L85
        L83:
            r4 = 0
            goto L86
        L85:
            r4 = 1
        L86:
            if (r4 == 0) goto L4c
            r2 = r3
            goto L4c
        L8a:
            java.lang.Integer r2 = (java.lang.Integer) r2
        L8c:
            com.wear.adapter.longdistance.LdrToyAdapter r0 = r6.e
            if (r0 != 0) goto L91
            goto La0
        L91:
            if (r2 != 0) goto L99
            r3 = -1
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            goto L9a
        L99:
            r3 = r2
        L9a:
            int r3 = r3.intValue()
            r0.j = r3
        La0:
            if (r2 == 0) goto Laf
            int r0 = r2.intValue()
            java.util.ArrayList<com.wear.bean.Toy> r1 = r6.b
            java.lang.Object r0 = r1.get(r0)
            r1 = r0
            com.wear.bean.Toy r1 = (com.wear.bean.Toy) r1
        Laf:
            r6.d = r1
            com.wear.adapter.longdistance.LdrToyAdapter r0 = r6.e
            if (r0 == 0) goto Lbc
            java.util.HashMap<com.wear.bean.Toy, android.widget.ImageView> r0 = r0.n
            if (r0 == 0) goto Lbc
            r0.clear()
        Lbc:
            com.wear.adapter.longdistance.LdrToyAdapter r0 = r6.e
            if (r0 == 0) goto Lc3
            r0.notifyDataSetChanged()
        Lc3:
            r6.l()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wear.widget.control.NewLDRPanel.i():void");
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x005e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void j() {
        /*
            r5 = this;
            com.wear.bean.Toy r0 = r5.c
            if (r0 == 0) goto L1e
            java.util.ArrayList<com.wear.bean.Toy> r1 = r5.a
            boolean r0 = kotlin.collections.CollectionsKt___CollectionsKt.contains(r1, r0)
            if (r0 == 0) goto L1e
            com.wear.adapter.longdistance.LdrToyAdapter r0 = r5.f
            if (r0 != 0) goto L12
            goto L8a
        L12:
            java.util.ArrayList<com.wear.bean.Toy> r1 = r5.a
            com.wear.bean.Toy r2 = r5.c
            int r1 = kotlin.collections.CollectionsKt___CollectionsKt.indexOf(r1, r2)
            r0.j = r1
            goto L8a
        L1e:
            java.util.ArrayList<com.wear.bean.Toy> r0 = r5.a
            kotlin.ranges.IntRange r0 = kotlin.collections.CollectionsKt__CollectionsKt.getIndices(r0)
            java.util.Iterator r0 = r0.iterator()
        L28:
            boolean r1 = r0.hasNext()
            r2 = 0
            if (r1 == 0) goto L62
            java.lang.Object r1 = r0.next()
            r3 = r1
            java.lang.Number r3 = (java.lang.Number) r3
            int r3 = r3.intValue()
            java.util.ArrayList<com.wear.bean.Toy> r4 = r5.a
            java.lang.Object r4 = r4.get(r3)
            com.wear.bean.Toy r4 = (com.wear.bean.Toy) r4
            boolean r4 = r4.isSupportLdr()
            if (r4 == 0) goto L5e
            java.util.ArrayList<com.wear.bean.Toy> r4 = r5.a
            java.lang.Object r3 = r4.get(r3)
            java.lang.String r4 = "ownerToy[i]"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            com.wear.bean.Toy r3 = (com.wear.bean.Toy) r3
            boolean r3 = r5.f(r3)
            if (r3 == 0) goto L5c
            goto L5e
        L5c:
            r3 = 0
            goto L5f
        L5e:
            r3 = 1
        L5f:
            if (r3 == 0) goto L28
            goto L63
        L62:
            r1 = r2
        L63:
            java.lang.Integer r1 = (java.lang.Integer) r1
            com.wear.adapter.longdistance.LdrToyAdapter r0 = r5.f
            if (r0 != 0) goto L6a
            goto L79
        L6a:
            if (r1 != 0) goto L72
            r3 = -1
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            goto L73
        L72:
            r3 = r1
        L73:
            int r3 = r3.intValue()
            r0.j = r3
        L79:
            if (r1 == 0) goto L88
            int r0 = r1.intValue()
            java.util.ArrayList<com.wear.bean.Toy> r1 = r5.a
            java.lang.Object r0 = r1.get(r0)
            r2 = r0
            com.wear.bean.Toy r2 = (com.wear.bean.Toy) r2
        L88:
            r5.c = r2
        L8a:
            com.wear.adapter.longdistance.LdrToyAdapter r0 = r5.f
            if (r0 == 0) goto L95
            java.util.HashMap<com.wear.bean.Toy, android.widget.ImageView> r0 = r0.n
            if (r0 == 0) goto L95
            r0.clear()
        L95:
            com.wear.adapter.longdistance.LdrToyAdapter r0 = r5.f
            if (r0 == 0) goto L9c
            r0.notifyDataSetChanged()
        L9c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wear.widget.control.NewLDRPanel.j():void");
    }

    public final void k() {
        j();
        i();
    }

    public final void l() {
        LdrToyAdapter ldrToyAdapter = this.e;
        Integer numValueOf = ldrToyAdapter != null ? Integer.valueOf(ldrToyAdapter.j) : null;
        if (numValueOf != null) {
            if (numValueOf.intValue() == -1) {
                getRvFriend().scrollToPosition(0);
            } else {
                getRvFriend().scrollToPosition(numValueOf.intValue());
            }
        }
    }

    public final void m() {
        ArrayList<Toy> arrayListC = c(this.b);
        this.b.clear();
        this.b.addAll(arrayListC);
        ArrayList<Toy> arrayListC2 = c(this.a);
        this.a.clear();
        this.a.addAll(arrayListC2);
        CollectionsKt___CollectionsJvmKt.reverse(this.b);
    }

    public final void n(int i) {
        if (this.b.size() > i) {
            LdrToyAdapter ldrToyAdapter = this.e;
            if (ldrToyAdapter != null) {
                ldrToyAdapter.j = i;
            }
            this.d = this.b.get(i);
            post(new Runnable() { // from class: dc.vo3
                @Override // java.lang.Runnable
                public final void run() {
                    NewLDRPanel.o(this.a);
                }
            });
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onMessageEvent(@NotNull xc1 event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (TextUtils.isEmpty(event.a())) {
            return;
        }
        if (this.a.isEmpty()) {
            q(0, false);
            return;
        }
        Iterator<Toy> it = this.a.iterator();
        while (it.hasNext()) {
            Toy next = it.next();
            if (Intrinsics.areEqual(event.a(), next.getAddress()) && !next.isConnected()) {
                s(next.getAddress(), 0, false);
            }
        }
    }

    public final void p(List<? extends Toy> list) {
        if (list != null) {
            if (list.isEmpty()) {
                q(0, false);
                return;
            }
            if (this.d == null) {
                return;
            }
            for (Toy toy : list) {
                Toy toy2 = this.d;
                if (Intrinsics.areEqual(toy2 != null ? toy2.getDeviceId() : null, toy.getDeviceId()) && toy.getStatus() != 1) {
                    q(0, false);
                    return;
                }
            }
        }
    }

    public final void q(int i, boolean z) {
        HashMap<Toy, ImageView> map;
        Set<Map.Entry<Toy, ImageView>> setEntrySet;
        HashMap<Toy, ImageView> map2;
        Set<Map.Entry<Toy, ImageView>> setEntrySet2;
        Iterator<Map.Entry<Toy, ImageView>> it = null;
        if (z) {
            LdrToyAdapter ldrToyAdapter = this.e;
            if (ldrToyAdapter != null && (map2 = ldrToyAdapter.n) != null && (setEntrySet2 = map2.entrySet()) != null) {
                it = setEntrySet2.iterator();
            }
        } else {
            LdrToyAdapter ldrToyAdapter2 = this.f;
            if (ldrToyAdapter2 != null && (map = ldrToyAdapter2.n) != null && (setEntrySet = map.entrySet()) != null) {
                it = setEntrySet.iterator();
            }
        }
        if (it != null) {
            while (it.hasNext()) {
                r(it.next().getValue(), i);
            }
        }
    }

    public final void r(final ImageView imageView, final int i) {
        post(new Runnable() { // from class: dc.wo3
            @Override // java.lang.Runnable
            public final void run() {
                NewLDRPanel.u(i, imageView);
            }
        });
    }

    public final void s(String str, int i, boolean z) {
        HashMap<Toy, ImageView> map;
        Set<Map.Entry<Toy, ImageView>> setEntrySet;
        HashMap<Toy, ImageView> map2;
        Set<Map.Entry<Toy, ImageView>> setEntrySet2;
        Iterator<Map.Entry<Toy, ImageView>> it = null;
        if (z) {
            LdrToyAdapter ldrToyAdapter = this.e;
            if (ldrToyAdapter != null && (map2 = ldrToyAdapter.n) != null && (setEntrySet2 = map2.entrySet()) != null) {
                it = setEntrySet2.iterator();
            }
        } else {
            LdrToyAdapter ldrToyAdapter2 = this.f;
            if (ldrToyAdapter2 != null && (map = ldrToyAdapter2.n) != null && (setEntrySet = map.entrySet()) != null) {
                it = setEntrySet.iterator();
            }
        }
        if (it != null) {
            while (it.hasNext()) {
                Map.Entry<Toy, ImageView> next = it.next();
                Toy key = next.getKey();
                if ((str == null || str.length() == 0) || Intrinsics.areEqual(key.getAndUpdateDeviceId(), str)) {
                    r(next.getValue(), i);
                }
            }
        }
    }

    public final void setBackground(int resource) {
        getLlPanel().setBackgroundResource(resource);
    }

    public final void setDivider(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "<set-?>");
        this.divider = view;
    }

    public final void setDividerBackground(@Nullable Drawable drawable) {
        getDivider().setBackground(drawable);
    }

    public final void setFriendAvailable(@Nullable Boolean available) {
        LdrToyAdapter ldrToyAdapter = this.e;
        if (ldrToyAdapter == null) {
            return;
        }
        ldrToyAdapter.k = available.booleanValue();
    }

    public final void setFriendName(@Nullable String name) {
        getTvFriendName().setText(name);
    }

    public final void setFriendToys(@NotNull ArrayList<Toy> toys) {
        Intrinsics.checkNotNullParameter(toys, "toys");
        this.b = toys;
    }

    public final void setItemClickListener(@Nullable LdrToyAdapter.b bVar) {
        LdrToyAdapter ldrToyAdapter = this.f;
        if (ldrToyAdapter != null) {
            ldrToyAdapter.C(bVar);
        }
    }

    public final void setIvLdrControlStates(@NotNull ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "<set-?>");
        this.ivLdrControlStates = imageView;
    }

    public final void setLeftView(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "<set-?>");
        this.leftView = view;
    }

    public final void setLeftViewBackground(int resource) {
        getLeftView().setBackgroundResource(resource);
    }

    public final void setLlPanel(@NotNull LinearLayout linearLayout) {
        Intrinsics.checkNotNullParameter(linearLayout, "<set-?>");
        this.llPanel = linearLayout;
    }

    public final void setRightView(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "<set-?>");
        this.rightView = view;
    }

    public final void setRightViewBackground(int resource) {
        getRightView().setBackgroundResource(resource);
    }

    public final void setRvFriend(@NotNull RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "<set-?>");
        this.rvFriend = recyclerView;
    }

    public final void setRvSelf(@NotNull RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "<set-?>");
        this.rvSelf = recyclerView;
    }

    public final void setSelfAvailable(@Nullable Boolean available) {
        LdrToyAdapter ldrToyAdapter = this.f;
        if (ldrToyAdapter == null) {
            return;
        }
        ldrToyAdapter.k = available.booleanValue();
    }

    public final void setSelfToys(@NotNull ArrayList<Toy> toys) {
        Intrinsics.checkNotNullParameter(toys, "toys");
        this.a = toys;
    }

    public final void setTvFriendName(@NotNull TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.tvFriendName = textView;
    }

    public final void setTvMe(@NotNull TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.tvMe = textView;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0033  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void t(@org.jetbrains.annotations.Nullable java.lang.String r12, @org.jetbrains.annotations.NotNull java.lang.String[] r13, @org.jetbrains.annotations.NotNull java.lang.String[] r14, boolean r15) throws java.lang.NumberFormatException {
        /*
            r11 = this;
            java.lang.String r0 = "funs"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            java.lang.String r0 = "groups"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            r0 = 0
            if (r15 == 0) goto L20
            com.wear.adapter.longdistance.LdrToyAdapter r15 = r11.e
            if (r15 == 0) goto L33
            java.util.HashMap<com.wear.bean.Toy, android.widget.ImageView> r15 = r15.n
            if (r15 == 0) goto L33
            java.util.Set r15 = r15.entrySet()
            if (r15 == 0) goto L33
            java.util.Iterator r15 = r15.iterator()
            goto L34
        L20:
            com.wear.adapter.longdistance.LdrToyAdapter r15 = r11.f
            if (r15 == 0) goto L33
            java.util.HashMap<com.wear.bean.Toy, android.widget.ImageView> r15 = r15.n
            if (r15 == 0) goto L33
            java.util.Set r15 = r15.entrySet()
            if (r15 == 0) goto L33
            java.util.Iterator r15 = r15.iterator()
            goto L34
        L33:
            r15 = r0
        L34:
            if (r15 == 0) goto Lbd
        L36:
            boolean r1 = r15.hasNext()
            if (r1 == 0) goto Lbd
            java.lang.Object r1 = r15.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            java.lang.Object r2 = r1.getKey()
            com.wear.bean.Toy r2 = (com.wear.bean.Toy) r2
            java.lang.String r3 = r2.getType()
            java.lang.String r3 = com.wear.bean.Toy.getToyFunction(r3)
            r4 = 0
            if (r12 == 0) goto L5c
            int r5 = r12.length()
            if (r5 != 0) goto L5a
            goto L5c
        L5a:
            r5 = 0
            goto L5d
        L5c:
            r5 = 1
        L5d:
            if (r5 != 0) goto L69
            java.lang.String r5 = r2.getAndUpdateDeviceId()
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual(r5, r12)
            if (r5 == 0) goto L36
        L69:
            int r5 = r13.length
            r6 = 0
            r7 = 0
        L6c:
            if (r6 >= r5) goto Lb2
            java.lang.String r8 = "function"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r8)
            r8 = r13[r6]
            r9 = 2
            boolean r8 = kotlin.text.StringsKt__StringsKt.contains$default(r3, r8, r4, r9, r0)
            if (r8 == 0) goto Laf
            r8 = r14[r6]
            int r8 = java.lang.Integer.parseInt(r8)
            boolean r9 = r2.isQ01Toy()
            if (r9 != 0) goto L8e
            boolean r9 = r2.isF01Toy()
            if (r9 == 0) goto L99
        L8e:
            r9 = r13[r6]
            java.lang.String r10 = "v"
            boolean r9 = kotlin.jvm.internal.Intrinsics.areEqual(r9, r10)
            if (r9 == 0) goto L99
            goto Laf
        L99:
            boolean r9 = r2.isMaxToy()
            if (r9 == 0) goto Lab
            r9 = r13[r6]
            java.lang.String r10 = "p"
            boolean r9 = kotlin.jvm.internal.Intrinsics.areEqual(r10, r9)
            if (r9 == 0) goto Lab
            int r8 = r8 * 5
        Lab:
            int r7 = java.lang.Math.max(r7, r8)
        Laf:
            int r6 = r6 + 1
            goto L6c
        Lb2:
            java.lang.Object r1 = r1.getValue()
            android.widget.ImageView r1 = (android.widget.ImageView) r1
            r11.r(r1, r7)
            goto L36
        Lbd:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wear.widget.control.NewLDRPanel.t(java.lang.String, java.lang.String[], java.lang.String[], boolean):void");
    }

    public NewLDRPanel(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final void setIvLdrControlStates(@Nullable Integer resource) {
        if (resource != null) {
            getIvLdrControlStates().setImageResource(resource.intValue());
        }
    }

    public NewLDRPanel(@Nullable Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = new ArrayList<>();
        this.b = new ArrayList<>();
        d();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onMessageEvent(@NotNull UserUpdateEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        String str = event.message;
        User user = this.g;
        if (user == null || WearUtils.e1(str) || !Intrinsics.areEqual(str, WearUtils.g0(user.getUserJid()))) {
            return;
        }
        p(user.getCLLinkedToys2());
    }
}
