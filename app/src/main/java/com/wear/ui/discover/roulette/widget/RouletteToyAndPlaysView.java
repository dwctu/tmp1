package com.wear.ui.discover.roulette.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import com.wear.bean.FindMatchUserBean;
import com.wear.bean.UserToy;
import com.wear.databinding.ItemRouletteToyBinding;
import com.wear.databinding.ItemRouletteToyMoreBinding;
import com.wear.databinding.ViewRoulettePlayBinding;
import com.wear.databinding.ViewRouletteToyPlaysBinding;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import skin.support.widget.SkinCompatFrameLayout;

/* compiled from: RouletteToyAndPlaysView.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0002J$\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\f0\u0011H\u0002J\u0018\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\fH\u0002J$\u0010\u0016\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\f0\u0011H\u0002J\u000e\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u0019J\u0014\u0010\u001a\u001a\u00020\u000f*\u00020\u001b2\u0006\u0010\u0015\u001a\u00020\u0012H\u0002J\u0014\u0010\u001c\u001a\u00020\u000f*\u00020\u001b2\u0006\u0010\u0015\u001a\u00020\u0012H\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/wear/ui/discover/roulette/widget/RouletteToyAndPlaysView;", "Lskin/support/widget/SkinCompatFrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/wear/databinding/ViewRouletteToyPlaysBinding;", "getPlayString", "", "play", "initMoreContainer", "", "toys", "", "Lcom/wear/bean/UserToy;", "plays", "initSingleContainer", "toy", "setData", "setFindMatchUserBean", "findMatchUserBean", "Lcom/wear/bean/FindMatchUserBean;", "generateMoreLayout", "Lcom/wear/ui/discover/roulette/widget/CenterFlowLayout;", "generateToyLayout", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class RouletteToyAndPlaysView extends SkinCompatFrameLayout {

    @NotNull
    public final ViewRouletteToyPlaysBinding b;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public RouletteToyAndPlaysView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public RouletteToyAndPlaysView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ RouletteToyAndPlaysView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public final void a(CenterFlowLayout centerFlowLayout, UserToy userToy) {
        ItemRouletteToyMoreBinding itemRouletteToyMoreBindingC = ItemRouletteToyMoreBinding.c(LayoutInflater.from(centerFlowLayout.getContext()), centerFlowLayout, false);
        Intrinsics.checkNotNullExpressionValue(itemRouletteToyMoreBindingC, "inflate(LayoutInflater.from(context), this, false)");
        itemRouletteToyMoreBindingC.b.setText(userToy.getDeviceType());
        centerFlowLayout.addView(itemRouletteToyMoreBindingC.getRoot());
    }

    public final void b(CenterFlowLayout centerFlowLayout, UserToy userToy) {
        ItemRouletteToyBinding itemRouletteToyBindingD = ItemRouletteToyBinding.d(LayoutInflater.from(centerFlowLayout.getContext()), centerFlowLayout, false);
        Intrinsics.checkNotNullExpressionValue(itemRouletteToyBindingD, "inflate(LayoutInflater.from(context), this, false)");
        itemRouletteToyBindingD.f(userToy);
        itemRouletteToyBindingD.executePendingBindings();
        centerFlowLayout.addView(itemRouletteToyBindingD.getRoot());
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterative(DepthRegionTraversal.java:31)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visit(SwitchOverStringVisitor.java:60)
     */
    /* JADX WARN: Removed duplicated region for block: B:21:0x005c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String c(java.lang.String r2) {
        /*
            r1 = this;
            int r0 = r2.hashCode()
            switch(r0) {
                case -1909683783: goto L47;
                case 1262869753: goto L32;
                case 1989635156: goto L1d;
                case 2109779734: goto L8;
                default: goto L7;
            }
        L7:
            goto L5c
        L8:
            java.lang.String r0 = "no_chat"
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L11
            goto L5c
        L11:
            android.content.Context r2 = r1.getContext()
            r0 = 2131887196(0x7f12045c, float:1.9408992E38)
            java.lang.String r2 = r2.getString(r0)
            goto L5e
        L1d:
            java.lang.String r0 = "sexting"
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L26
            goto L5c
        L26:
            android.content.Context r2 = r1.getContext()
            r0 = 2131887198(0x7f12045e, float:1.9408996E38)
            java.lang.String r2 = r2.getString(r0)
            goto L5e
        L32:
            java.lang.String r0 = "dirty_talk"
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L3b
            goto L5c
        L3b:
            android.content.Context r2 = r1.getContext()
            r0 = 2131887194(0x7f12045a, float:1.9408988E38)
            java.lang.String r2 = r2.getString(r0)
            goto L5e
        L47:
            java.lang.String r0 = "voice_messages"
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L50
            goto L5c
        L50:
            android.content.Context r2 = r1.getContext()
            r0 = 2131887199(0x7f12045f, float:1.9408998E38)
            java.lang.String r2 = r2.getString(r0)
            goto L5e
        L5c:
            java.lang.String r2 = "unknown"
        L5e:
            java.lang.String r0 = "when (play) {\n        \"s…  else -> \"unknown\"\n    }"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r0)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wear.ui.discover.roulette.widget.RouletteToyAndPlaysView.c(java.lang.String):java.lang.String");
    }

    public final void d(List<UserToy> list, List<String> list2) {
        List<UserToy> mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) list);
        if (mutableList.size() > 5) {
            mutableList = mutableList.subList(0, 4);
            UserToy userToy = new UserToy((list.size() - 5) + " More", null, 2, null);
            userToy.setMore(true);
            mutableList.add(userToy);
        }
        CenterFlowLayout centerFlowLayout = this.b.c;
        centerFlowLayout.removeAllViews();
        for (UserToy userToy2 : mutableList) {
            if (userToy2.getIsMore()) {
                Intrinsics.checkNotNullExpressionValue(centerFlowLayout, "");
                a(centerFlowLayout, userToy2);
            } else {
                Intrinsics.checkNotNullExpressionValue(centerFlowLayout, "");
                b(centerFlowLayout, userToy2);
            }
        }
        CenterFlowLayout centerFlowLayout2 = this.b.b;
        centerFlowLayout2.removeAllViews();
        for (String str : list2) {
            ViewRoulettePlayBinding viewRoulettePlayBindingC = ViewRoulettePlayBinding.c(LayoutInflater.from(centerFlowLayout2.getContext()), centerFlowLayout2, false);
            Intrinsics.checkNotNullExpressionValue(viewRoulettePlayBindingC, "inflate(LayoutInflater.from(context), this, false)");
            viewRoulettePlayBindingC.getRoot().setText(str);
            centerFlowLayout2.addView(viewRoulettePlayBindingC.getRoot());
        }
    }

    public final void e(UserToy userToy, String str) {
        this.b.e.f(userToy);
        this.b.d.getRoot().setText(str);
    }

    public final void f(List<UserToy> list, List<String> list2) {
        boolean z = list.size() == 1 && list2.size() == 1;
        LinearLayout linearLayout = this.b.g;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.viewContainerRouletteSingle");
        linearLayout.setVisibility(z ^ true ? 8 : 0);
        LinearLayout linearLayout2 = this.b.f;
        Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.viewContainerRouletteMore");
        linearLayout2.setVisibility(z ? 8 : 0);
        if (z) {
            e((UserToy) CollectionsKt___CollectionsKt.first((List) list), (String) CollectionsKt___CollectionsKt.first((List) list2));
        } else {
            d(list, list2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setFindMatchUserBean(@NotNull FindMatchUserBean findMatchUserBean) {
        List listEmptyList;
        List listEmptyList2;
        Intrinsics.checkNotNullParameter(findMatchUserBean, "findMatchUserBean");
        List<String> plays = findMatchUserBean.getPlays();
        if (plays != null) {
            listEmptyList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(plays, 10));
            Iterator<T> it = plays.iterator();
            while (it.hasNext()) {
                listEmptyList.add(c((String) it.next()));
            }
        } else {
            listEmptyList = CollectionsKt__CollectionsKt.emptyList();
        }
        List<UserToy> toys = findMatchUserBean.getToys();
        if (toys != null) {
            listEmptyList2 = new ArrayList();
            for (Object obj : toys) {
                if (Intrinsics.areEqual(((UserToy) obj).getStatus(), Boolean.TRUE)) {
                    listEmptyList2.add(obj);
                }
            }
        } else {
            listEmptyList2 = CollectionsKt__CollectionsKt.emptyList();
        }
        f(listEmptyList2, listEmptyList);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public RouletteToyAndPlaysView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        ViewRouletteToyPlaysBinding viewRouletteToyPlaysBindingC = ViewRouletteToyPlaysBinding.c(LayoutInflater.from(context), this, true);
        Intrinsics.checkNotNullExpressionValue(viewRouletteToyPlaysBindingC, "inflate(LayoutInflater.from(context), this, true)");
        this.b = viewRouletteToyPlaysBindingC;
    }
}
