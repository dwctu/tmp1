package com.component.dxbilog.lib.auto.click;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ExpandableListView;
import android.widget.ListView;
import androidx.annotation.Keep;
import androidx.core.graphics.drawable.IconCompat;
import com.google.android.material.tabs.TabLayout;
import dc.is;
import dc.js;
import dc.ks;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: BILogAutoClickHelperEnter.kt */
@Keep
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/component/dxbilog/lib/auto/click/BILogAutoClickHelperEnter;", "", "()V", "Companion", "lib_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class BILogAutoClickHelperEnter {

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
    public static final void trackViewOnClick(@Nullable Object obj, @NotNull MenuItem menuItem) {
        INSTANCE.trackViewOnClick(obj, menuItem);
    }

    /* compiled from: BILogAutoClickHelperEnter.kt */
    @Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0001H\u0002J*\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\u0005\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0007J\"\u0010\u000e\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\u0005\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u0012\u0010\u000f\u001a\u00020\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0007J\u0012\u0010\u0012\u001a\u00020\u00072\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0007J\u001a\u0010\u0015\u001a\u00020\u00072\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\fH\u0007J\"\u0010\u0015\u001a\u00020\u00072\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u0004H\u0007J\u0012\u0010\u0015\u001a\u00020\u00072\b\u0010\u0005\u001a\u0004\u0018\u00010\nH\u0007J&\u0010\u0015\u001a\u00020\u00072\n\u0010\u001a\u001a\u0006\u0012\u0002\b\u00030\u001b2\b\u0010\u0005\u001a\u0004\u0018\u00010\n2\u0006\u0010\u001c\u001a\u00020\fH\u0007J\u0018\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u001d2\u0006\u0010\u0019\u001a\u00020\u0004H\u0007J\u001a\u0010\u0015\u001a\u00020\u00072\b\u0010\u001e\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u001f\u001a\u00020 H\u0007¨\u0006!"}, d2 = {"Lcom/component/dxbilog/lib/auto/click/BILogAutoClickHelperEnter$Companion;", "", "()V", "isIntercept", "", "view", "trackExpandableListViewChildOnClick", "", "expandableListView", "Landroid/widget/ExpandableListView;", "Landroid/view/View;", "groupPosition", "", "childPosition", "trackExpandableListViewGroupOnClick", "trackTabHost", "tabName", "", "trackTabLayoutOnClick", "tab", "Lcom/google/android/material/tabs/TabLayout$Tab;", "trackViewOnClick", "dialogInterface", "Landroid/content/DialogInterface;", "whichButton", "isChecked", "adapterView", "Landroid/widget/AdapterView;", "position", "Landroid/widget/CompoundButton;", IconCompat.EXTRA_OBJ, "menuItem", "Landroid/view/MenuItem;", "lib_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean a(Object obj) {
            return obj == null || !ks.a.e() || is.a.h(obj) || js.a.e(obj);
        }

        @JvmStatic
        @Keep
        public final void trackExpandableListViewChildOnClick(@NotNull ExpandableListView expandableListView, @Nullable View view, int groupPosition, int childPosition) {
            Intrinsics.checkNotNullParameter(expandableListView, "expandableListView");
            try {
                if (a(view)) {
                    return;
                }
                is.a.j(view);
            } catch (Exception e) {
                e.printStackTrace();
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
            try {
                if (a(tabName)) {
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @JvmStatic
        @Keep
        public final void trackTabLayoutOnClick(@Nullable TabLayout.Tab tab) {
            if (tab == null) {
                return;
            }
            try {
                View customView = tab.getCustomView();
                if (customView == null) {
                    customView = tab.view;
                }
                Intrinsics.checkNotNullExpressionValue(customView, "tab.customView ?: tab.view");
                if (a(customView)) {
                    return;
                }
                is.a.j(customView);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @JvmStatic
        @Keep
        public final void trackViewOnClick(@Nullable DialogInterface dialogInterface, int whichButton) {
            if (dialogInterface == null) {
                return;
            }
            try {
                Button button = null;
                Dialog dialog = dialogInterface instanceof Dialog ? (Dialog) dialogInterface : null;
                if (dialog == null) {
                    return;
                }
                if (dialog instanceof AlertDialog) {
                    button = ((AlertDialog) dialog).getButton(whichButton);
                } else if (dialog instanceof androidx.appcompat.app.AlertDialog) {
                    button = ((androidx.appcompat.app.AlertDialog) dialog).getButton(whichButton);
                }
                if (a(button)) {
                    return;
                }
                is.a.j(button);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @JvmStatic
        @Keep
        public final void trackViewOnClick(@NotNull CompoundButton view, boolean isChecked) {
            Intrinsics.checkNotNullParameter(view, "view");
            try {
                if (view.getContext() == null || a(view)) {
                    return;
                }
                is.a.j(view);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @JvmStatic
        @Keep
        public final void trackViewOnClick(@Nullable DialogInterface dialogInterface, int whichButton, boolean isChecked) {
            Object item;
            if (dialogInterface == null) {
                return;
            }
            try {
                ListView listView = null;
                Dialog dialog = dialogInterface instanceof Dialog ? (Dialog) dialogInterface : null;
                if (dialog == null) {
                    return;
                }
                if (dialog instanceof AlertDialog) {
                    listView = ((AlertDialog) dialog).getListView();
                } else if (dialog instanceof androidx.appcompat.app.AlertDialog) {
                    listView = ((androidx.appcompat.app.AlertDialog) dialog).getListView();
                }
                if (listView == null || (item = listView.getAdapter().getItem(whichButton)) == null || !(item instanceof View) || BILogAutoClickHelperEnter.INSTANCE.a(item)) {
                    return;
                }
                is.a.j((View) item);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @JvmStatic
        @Keep
        public final void trackViewOnClick(@Nullable Object obj, @NotNull MenuItem menuItem) {
            Intrinsics.checkNotNullParameter(menuItem, "menuItem");
            try {
                if (a(obj)) {
                    return;
                }
                is.a.j(obj instanceof View ? (View) obj : null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @JvmStatic
        @Keep
        public final void trackViewOnClick(@NotNull AdapterView<?> adapterView, @Nullable View view, int position) {
            Intrinsics.checkNotNullParameter(adapterView, "adapterView");
            try {
                if (a(view)) {
                    return;
                }
                is.a.j(view);
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
                is.a.j(view);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
