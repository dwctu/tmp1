package com.component.dxbilog.lib.auto.click;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.Spinner;
import androidx.annotation.Keep;
import androidx.core.graphics.drawable.IconCompat;
import com.component.dxbilog.lib.auto.click.BILogAutoClickHelperExit;
import com.component.dxbilog.lib.bean.BILogContentBean;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.android.material.tabs.TabLayout;
import dc.de0;
import dc.is;
import dc.js;
import dc.ks;
import dc.se0;
import dc.ue0;
import dc.vr;
import dc.wr;
import dc.xd0;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: BILogAutoClickHelperExit.kt */
@Keep
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/component/dxbilog/lib/auto/click/BILogAutoClickHelperExit;", "", "()V", "Companion", "lib_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class BILogAutoClickHelperExit {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @JvmStatic
    @Keep
    public static final void trackExpandableListViewChildOnClick(@NotNull ExpandableListView expandableListView, @Nullable View view, int i, int i2) {
        INSTANCE.trackExpandableListViewChildOnClick(expandableListView, view, i, i2);
    }

    @JvmStatic
    @Keep
    public static final void trackExpandableListViewGroupOnClick(@NotNull ExpandableListView expandableListView, @Nullable View view, int i) {
        INSTANCE.trackExpandableListViewGroupOnClick(expandableListView, view, i);
    }

    @JvmStatic
    @Keep
    public static final void trackTabHost(@Nullable String str) {
        INSTANCE.trackTabHost(str);
    }

    @JvmStatic
    @Keep
    public static final void trackTabLayoutOnClick(@Nullable TabLayout.Tab tab) {
        INSTANCE.trackTabLayoutOnClick(tab);
    }

    @JvmStatic
    @Keep
    public static final void trackViewOnClick(@Nullable DialogInterface dialogInterface, int i) {
        INSTANCE.trackViewOnClick(dialogInterface, i);
    }

    @JvmStatic
    @Keep
    public static final void trackViewOnClick(@Nullable DialogInterface dialogInterface, int i, boolean z) {
        INSTANCE.trackViewOnClick(dialogInterface, i, z);
    }

    @JvmStatic
    @Keep
    public static final void trackViewOnClick(@Nullable View view) {
        INSTANCE.trackViewOnClick(view);
    }

    @JvmStatic
    @Keep
    public static final void trackViewOnClick(@NotNull AdapterView<?> adapterView, @Nullable View view, int i) {
        INSTANCE.trackViewOnClick(adapterView, view, i);
    }

    @JvmStatic
    @Keep
    public static final void trackViewOnClick(@NotNull CompoundButton compoundButton, boolean z) {
        INSTANCE.trackViewOnClick(compoundButton, z);
    }

    @JvmStatic
    @Keep
    public static final void trackViewOnClick(@Nullable Object obj, @NotNull MenuItem menuItem) throws Resources.NotFoundException {
        INSTANCE.trackViewOnClick(obj, menuItem);
    }

    /* compiled from: BILogAutoClickHelperExit.kt */
    @Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0001H\u0002J\"\u0010\u0006\u001a\u00020\u00072\b\u0010\u0005\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u0004J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u0004J*\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u0005\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0007J\"\u0010\u0012\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u0005\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J\u0012\u0010\u0013\u001a\u00020\u00072\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0007J\u0012\u0010\u0016\u001a\u00020\u00072\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0007J\u001a\u0010\u0019\u001a\u00020\u00072\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u0010H\u0007J\"\u0010\u0019\u001a\u00020\u00072\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u0004H\u0007J\u0012\u0010\u0019\u001a\u00020\u00072\b\u0010\u0005\u001a\u0004\u0018\u00010\bH\u0007J&\u0010\u0019\u001a\u00020\u00072\n\u0010\u001e\u001a\u0006\u0012\u0002\b\u00030\u001f2\b\u0010\u0005\u001a\u0004\u0018\u00010\b2\u0006\u0010 \u001a\u00020\u0010H\u0007J\u0018\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020!2\u0006\u0010\u001d\u001a\u00020\u0004H\u0007J\u001a\u0010\u0019\u001a\u00020\u00072\b\u0010\"\u001a\u0004\u0018\u00010\u00012\u0006\u0010#\u001a\u00020$H\u0007¨\u0006%"}, d2 = {"Lcom/component/dxbilog/lib/auto/click/BILogAutoClickHelperExit$Companion;", "", "()V", "isIntercept", "", "view", "trackClick", "", "Landroid/view/View;", "contentBean", "Lcom/component/dxbilog/lib/bean/BILogContentBean;", "isIgnoreEventType", "trackExpandableListViewChildOnClick", "expandableListView", "Landroid/widget/ExpandableListView;", "groupPosition", "", "childPosition", "trackExpandableListViewGroupOnClick", "trackTabHost", "tabName", "", "trackTabLayoutOnClick", "tab", "Lcom/google/android/material/tabs/TabLayout$Tab;", "trackViewOnClick", "dialogInterface", "Landroid/content/DialogInterface;", "whichButton", "isChecked", "adapterView", "Landroid/widget/AdapterView;", "position", "Landroid/widget/CompoundButton;", IconCompat.EXTRA_OBJ, "menuItem", "Landroid/view/MenuItem;", "lib_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void e(Companion companion, View view, BILogContentBean bILogContentBean, boolean z, int i, Object obj) {
            if ((i & 4) != 0) {
                z = false;
            }
            companion.c(view, bILogContentBean, z);
        }

        public static /* synthetic */ void f(Companion companion, BILogContentBean bILogContentBean, boolean z, int i, Object obj) {
            if ((i & 2) != 0) {
                z = false;
            }
            companion.d(bILogContentBean, z);
        }

        public static final void g(String logNo, BILogContentBean contentBean) {
            Intrinsics.checkNotNullParameter(logNo, "$logNo");
            Intrinsics.checkNotNullParameter(contentBean, "$contentBean");
            ks.a.b().a(logNo, contentBean);
        }

        public final boolean a(Object obj) {
            return obj == null || !ks.a.e() || js.a.e(obj);
        }

        public final void c(@Nullable View view, @NotNull BILogContentBean contentBean, boolean z) {
            Class<?> cls;
            Intrinsics.checkNotNullParameter(contentBean, "contentBean");
            if (view == null) {
                return;
            }
            String event_id = contentBean.getEvent_id();
            if (event_id == null) {
                event_id = is.a.g(view);
            }
            contentBean.setEvent_id(event_id);
            String page_name = contentBean.getPage_name();
            if (page_name == null) {
                Activity activityB = is.a.b(view);
                page_name = (activityB == null || (cls = activityB.getClass()) == null) ? null : cls.getCanonicalName();
            }
            contentBean.setPage_name(page_name);
            vr vrVar = vr.a;
            vrVar.d(contentBean, vrVar.a(view));
            is.a aVar = is.a;
            aVar.n(view, contentBean);
            aVar.m(view, contentBean);
            aVar.k(view, contentBean);
            BILogContentBean.Properties properties = contentBean.getProperties();
            if (properties != null) {
                BILogContentBean.Properties properties2 = contentBean.getProperties();
                String view_class_name = properties2 == null ? null : properties2.getView_class_name();
                if (view_class_name == null) {
                    view_class_name = aVar.c(view);
                }
                properties.setView_class_name(view_class_name);
            }
            BILogContentBean.Properties properties3 = contentBean.getProperties();
            if (properties3 != null) {
                BILogContentBean.Properties properties4 = contentBean.getProperties();
                String view_supper_name = properties4 != null ? properties4.getView_supper_name() : null;
                if (view_supper_name == null) {
                    view_supper_name = aVar.e(view);
                }
                properties3.setView_supper_name(view_supper_name);
            }
            d(contentBean, z);
        }

        public final void d(@NotNull final BILogContentBean contentBean, boolean z) {
            Long auto_track_click_time;
            Intrinsics.checkNotNullParameter(contentBean, "contentBean");
            if (!z) {
                String event_type = contentBean.getEvent_type();
                if (event_type == null) {
                    event_type = "click";
                }
                contentBean.setEvent_type(event_type);
            }
            is.a.l(contentBean, TtmlNode.TEXT_EMPHASIS_AUTO);
            final String str = "S0009";
            if (ks.a.i()) {
                Object[] objArr = new Object[5];
                objArr[0] = "trackClick";
                objArr[1] = Intrinsics.stringPlus("logNo = ", "S0009");
                objArr[2] = wr.b(xd0.h().toJson(contentBean));
                BILogContentBean.Internals internals = contentBean.getInternals();
                String strN = null;
                if (internals != null && (auto_track_click_time = internals.getAuto_track_click_time()) != null) {
                    strN = ue0.n(auto_track_click_time.longValue(), ue0.d);
                }
                objArr[3] = Intrinsics.stringPlus("trackTime: ", strN);
                objArr[4] = Intrinsics.stringPlus("currentTime: ", ue0.n(System.currentTimeMillis(), ue0.d));
                de0.l(objArr);
            }
            se0.c().execute(new Runnable() { // from class: dc.pr
                @Override // java.lang.Runnable
                public final void run() {
                    BILogAutoClickHelperExit.Companion.g(str, contentBean);
                }
            });
        }

        @JvmStatic
        @Keep
        public final void trackExpandableListViewChildOnClick(@NotNull ExpandableListView expandableListView, @Nullable View view, int groupPosition, int childPosition) {
            Context context;
            String strValueOf;
            String view_position;
            String view_type;
            String view_position2;
            Class<?> cls;
            Intrinsics.checkNotNullParameter(expandableListView, "expandableListView");
            try {
                if (a(view) || (context = expandableListView.getContext()) == null) {
                    return;
                }
                BILogContentBean bILogContentBeanA = js.a.a(view);
                String page_name = bILogContentBeanA.getPage_name();
                String strR = null;
                if (page_name == null) {
                    Activity activityA = is.a.a(context);
                    page_name = (activityA == null || (cls = activityA.getClass()) == null) ? null : cls.getCanonicalName();
                }
                bILogContentBeanA.setPage_name(page_name);
                if (childPosition != -1) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(groupPosition);
                    sb.append(':');
                    sb.append(childPosition);
                    strValueOf = sb.toString();
                } else {
                    strValueOf = String.valueOf(groupPosition);
                }
                BILogContentBean.Properties properties = bILogContentBeanA.getProperties();
                if (properties != null) {
                    BILogContentBean.Properties properties2 = bILogContentBeanA.getProperties();
                    if (properties2 != null && (view_position = properties2.getView_position()) != null) {
                        strValueOf = view_position;
                    }
                    properties.setView_position(strValueOf);
                }
                String event_id = bILogContentBeanA.getEvent_id();
                if (event_id == null) {
                    event_id = is.a.g(expandableListView);
                }
                bILogContentBeanA.setEvent_id(event_id);
                BILogContentBean.Properties properties3 = bILogContentBeanA.getProperties();
                if (properties3 != null) {
                    BILogContentBean.Properties properties4 = bILogContentBeanA.getProperties();
                    String str = "ExpandableListView";
                    if (properties4 != null && (view_type = properties4.getView_type()) != null) {
                        str = view_type;
                    }
                    properties3.setView_type(str);
                }
                if (view instanceof ViewGroup) {
                    try {
                        strR = is.a.r(new StringBuilder(), (ViewGroup) view);
                        if (!TextUtils.isEmpty(strR)) {
                            String strSubstring = strR.substring(0, strR.length() - 1);
                            Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                            strR = strSubstring;
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                BILogContentBean.Properties properties5 = bILogContentBeanA.getProperties();
                if (properties5 != null) {
                    BILogContentBean.Properties properties6 = bILogContentBeanA.getProperties();
                    if (properties6 != null && (view_position2 = properties6.getView_position()) != null) {
                        strR = view_position2;
                    }
                    properties5.setView_position(strR);
                }
                e(this, view, bILogContentBeanA, false, 4, null);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        @JvmStatic
        @Keep
        public final void trackExpandableListViewGroupOnClick(@NotNull ExpandableListView expandableListView, @Nullable View view, int groupPosition) {
            Intrinsics.checkNotNullParameter(expandableListView, "expandableListView");
            trackExpandableListViewChildOnClick(expandableListView, view, groupPosition, -1);
        }

        @JvmStatic
        @Keep
        public final void trackTabHost(@Nullable String tabName) {
            String view_type;
            String view_content;
            try {
                if (a(tabName)) {
                    return;
                }
                BILogContentBean bILogContentBeanA = js.a.a(tabName);
                BILogContentBean.Properties properties = bILogContentBeanA.getProperties();
                if (properties != null) {
                    BILogContentBean.Properties properties2 = bILogContentBeanA.getProperties();
                    String str = "TabHost";
                    if (properties2 != null && (view_type = properties2.getView_type()) != null) {
                        str = view_type;
                    }
                    properties.setView_type(str);
                }
                BILogContentBean.Properties properties3 = bILogContentBeanA.getProperties();
                if (properties3 != null) {
                    BILogContentBean.Properties properties4 = bILogContentBeanA.getProperties();
                    if (properties4 != null && (view_content = properties4.getView_content()) != null) {
                        tabName = view_content;
                    }
                    properties3.setView_content(tabName);
                }
                f(this, bILogContentBeanA, false, 2, null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @JvmStatic
        @Keep
        public final void trackTabLayoutOnClick(@Nullable TabLayout.Tab tab) {
            String view_type;
            if (tab == null) {
                return;
            }
            try {
                View customView = tab.getCustomView();
                if (customView == null) {
                    customView = tab.view;
                }
                View view = customView;
                Intrinsics.checkNotNullExpressionValue(view, "tab.customView ?: tab.view");
                if (a(view)) {
                    return;
                }
                BILogContentBean bILogContentBeanA = js.a.a(view);
                BILogContentBean.Properties properties = bILogContentBeanA.getProperties();
                if (properties != null) {
                    BILogContentBean.Properties properties2 = bILogContentBeanA.getProperties();
                    String str = "TabLayout";
                    if (properties2 != null && (view_type = properties2.getView_type()) != null) {
                        str = view_type;
                    }
                    properties.setView_type(str);
                }
                e(this, view, bILogContentBeanA, false, 4, null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @JvmStatic
        @Keep
        public final void trackViewOnClick(@Nullable DialogInterface dialogInterface, int whichButton) {
            String view_type;
            if (dialogInterface == null) {
                return;
            }
            try {
                String view_position = null;
                Dialog dialog = dialogInterface instanceof Dialog ? (Dialog) dialogInterface : null;
                if (dialog == null) {
                    return;
                }
                Button button = dialog instanceof AlertDialog ? ((AlertDialog) dialog).getButton(whichButton) : dialog instanceof androidx.appcompat.app.AlertDialog ? ((androidx.appcompat.app.AlertDialog) dialog).getButton(whichButton) : null;
                if (a(button)) {
                    return;
                }
                BILogContentBean bILogContentBeanA = js.a.a(button);
                BILogContentBean.Properties properties = bILogContentBeanA.getProperties();
                if (properties != null) {
                    BILogContentBean.Properties properties2 = bILogContentBeanA.getProperties();
                    String str = "Dialog";
                    if (properties2 != null && (view_type = properties2.getView_type()) != null) {
                        str = view_type;
                    }
                    properties.setView_type(str);
                }
                BILogContentBean.Properties properties3 = bILogContentBeanA.getProperties();
                if (properties3 != null) {
                    BILogContentBean.Properties properties4 = bILogContentBeanA.getProperties();
                    if (properties4 != null) {
                        view_position = properties4.getView_position();
                    }
                    if (view_position == null) {
                        view_position = String.valueOf(whichButton);
                    }
                    properties3.setView_position(view_position);
                }
                e(this, button, bILogContentBeanA, false, 4, null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @JvmStatic
        @Keep
        public final void trackViewOnClick(@NotNull CompoundButton view, boolean isChecked) {
            String view_type;
            Boolean view_check;
            Intrinsics.checkNotNullParameter(view, "view");
            try {
                if (view.getContext() == null || a(view)) {
                    return;
                }
                BILogContentBean bILogContentBeanA = js.a.a(view);
                BILogContentBean.Properties properties = bILogContentBeanA.getProperties();
                if (properties != null) {
                    BILogContentBean.Properties properties2 = bILogContentBeanA.getProperties();
                    String str = "Button";
                    if (properties2 != null && (view_type = properties2.getView_type()) != null) {
                        str = view_type;
                    }
                    properties.setView_type(str);
                }
                BILogContentBean.Properties properties3 = bILogContentBeanA.getProperties();
                if (properties3 != null) {
                    BILogContentBean.Properties properties4 = bILogContentBeanA.getProperties();
                    properties3.setView_check((properties4 == null || (view_check = properties4.getView_check()) == null) ? Boolean.valueOf(isChecked) : view_check);
                }
                e(this, view, bILogContentBeanA, false, 4, null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @JvmStatic
        @Keep
        public final void trackViewOnClick(@Nullable DialogInterface dialogInterface, int whichButton, boolean isChecked) {
            ListView listView;
            Object item;
            String view_type;
            Boolean view_check;
            if (dialogInterface == null) {
                return;
            }
            try {
                String view_position = null;
                Dialog dialog = dialogInterface instanceof Dialog ? (Dialog) dialogInterface : null;
                if (dialog == null) {
                    return;
                }
                if (dialog instanceof AlertDialog) {
                    listView = ((AlertDialog) dialog).getListView();
                } else {
                    listView = dialog instanceof androidx.appcompat.app.AlertDialog ? ((androidx.appcompat.app.AlertDialog) dialog).getListView() : null;
                }
                if (listView == null || (item = listView.getAdapter().getItem(whichButton)) == null || !(item instanceof View)) {
                    return;
                }
                Companion companion = BILogAutoClickHelperExit.INSTANCE;
                if (companion.a(item)) {
                    return;
                }
                BILogContentBean bILogContentBeanA = js.a.a(item);
                BILogContentBean.Properties properties = bILogContentBeanA.getProperties();
                if (properties != null) {
                    BILogContentBean.Properties properties2 = bILogContentBeanA.getProperties();
                    String str = "Dialog";
                    if (properties2 != null && (view_type = properties2.getView_type()) != null) {
                        str = view_type;
                    }
                    properties.setView_type(str);
                }
                BILogContentBean.Properties properties3 = bILogContentBeanA.getProperties();
                if (properties3 != null) {
                    BILogContentBean.Properties properties4 = bILogContentBeanA.getProperties();
                    properties3.setView_check((properties4 == null || (view_check = properties4.getView_check()) == null) ? Boolean.valueOf(isChecked) : view_check);
                }
                BILogContentBean.Properties properties5 = bILogContentBeanA.getProperties();
                if (properties5 != null) {
                    BILogContentBean.Properties properties6 = bILogContentBeanA.getProperties();
                    if (properties6 != null) {
                        view_position = properties6.getView_position();
                    }
                    if (view_position == null) {
                        view_position = String.valueOf(whichButton);
                    }
                    properties5.setView_position(view_position);
                }
                e(companion, (View) item, bILogContentBeanA, false, 4, null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @JvmStatic
        @Keep
        public final void trackViewOnClick(@Nullable Object obj, @NotNull MenuItem menuItem) throws Resources.NotFoundException {
            String view_type;
            Class<?> cls;
            Intrinsics.checkNotNullParameter(menuItem, "menuItem");
            try {
                if (a(obj)) {
                    return;
                }
                BILogContentBean bILogContentBeanA = js.a.a(obj);
                BILogContentBean.Properties properties = bILogContentBeanA.getProperties();
                if (properties != null) {
                    BILogContentBean.Properties properties2 = bILogContentBeanA.getProperties();
                    String str = "MenuItem";
                    if (properties2 != null && (view_type = properties2.getView_type()) != null) {
                        str = view_type;
                    }
                    properties.setView_type(str);
                }
                BILogContentBean.Properties properties3 = bILogContentBeanA.getProperties();
                if (properties3 != null) {
                    BILogContentBean.Properties properties4 = bILogContentBeanA.getProperties();
                    String view_content = properties4 == null ? null : properties4.getView_content();
                    if (view_content == null) {
                        CharSequence title = menuItem.getTitle();
                        view_content = title == null ? null : title.toString();
                    }
                    properties3.setView_content(view_content);
                }
                Context context = obj instanceof Context ? (Context) obj : null;
                if (context != null) {
                    String event_id = bILogContentBeanA.getEvent_id();
                    if (event_id == null) {
                        event_id = context.getResources().getResourceEntryName(menuItem.getItemId());
                    }
                    bILogContentBeanA.setEvent_id(event_id);
                    String page_name = bILogContentBeanA.getPage_name();
                    if (page_name == null) {
                        Activity activityA = is.a.a(context);
                        page_name = (activityA == null || (cls = activityA.getClass()) == null) ? null : cls.getCanonicalName();
                    }
                    bILogContentBeanA.setPage_name(page_name);
                }
                f(this, bILogContentBeanA, false, 2, null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @JvmStatic
        @Keep
        public final void trackViewOnClick(@NotNull AdapterView<?> adapterView, @Nullable View view, int position) {
            Context context;
            String view_content;
            Class<?> cls;
            Intrinsics.checkNotNullParameter(adapterView, "adapterView");
            try {
                if (a(view) || (context = adapterView.getContext()) == null) {
                    return;
                }
                BILogContentBean bILogContentBeanA = js.a.a(view);
                String event_id = bILogContentBeanA.getEvent_id();
                if (event_id == null) {
                    event_id = is.a.g(adapterView);
                }
                bILogContentBeanA.setEvent_id(event_id);
                String page_name = bILogContentBeanA.getPage_name();
                String strF = null;
                if (page_name == null) {
                    Activity activityA = is.a.a(context);
                    page_name = (activityA == null || (cls = activityA.getClass()) == null) ? null : cls.getCanonicalName();
                }
                bILogContentBeanA.setPage_name(page_name);
                BILogContentBean.Properties properties = bILogContentBeanA.getProperties();
                if (properties != null) {
                    BILogContentBean.Properties properties2 = bILogContentBeanA.getProperties();
                    String view_position = properties2 == null ? null : properties2.getView_position();
                    if (view_position == null) {
                        view_position = String.valueOf(position);
                    }
                    properties.setView_position(view_position);
                }
                BILogContentBean.Properties properties3 = bILogContentBeanA.getProperties();
                if (properties3 != null) {
                    BILogContentBean.Properties properties4 = bILogContentBeanA.getProperties();
                    String view_type = properties4 == null ? null : properties4.getView_type();
                    if (view_type == null) {
                        view_type = adapterView.getClass().getSimpleName();
                    }
                    properties3.setView_type(view_type);
                }
                if (adapterView instanceof Spinner) {
                    Object itemAtPosition = adapterView.getItemAtPosition(position);
                    if (itemAtPosition instanceof String) {
                        strF = (String) itemAtPosition;
                    }
                } else {
                    strF = is.a.f(view);
                }
                BILogContentBean.Properties properties5 = bILogContentBeanA.getProperties();
                if (properties5 != null) {
                    BILogContentBean.Properties properties6 = bILogContentBeanA.getProperties();
                    if (properties6 != null && (view_content = properties6.getView_content()) != null) {
                        strF = view_content;
                    }
                    properties5.setView_content(strF);
                }
                e(this, view, bILogContentBeanA, false, 4, null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @JvmStatic
        @Keep
        public final void trackViewOnClick(@Nullable View view) {
            if (view == null) {
                return;
            }
            try {
                if (a(view)) {
                    return;
                }
                e(this, view, js.a.a(view), false, 4, null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
