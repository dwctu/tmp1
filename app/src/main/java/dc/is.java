package dc;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CheckedTextView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.ToggleButton;
import androidx.appcompat.widget.SwitchCompat;
import androidx.core.graphics.drawable.IconCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.component.dxbilog.lib.bean.BILogContentBean;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.android.material.tabs.TabLayout;
import com.google.android.vending.expansion.downloader.Constants;
import dc.is;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: BILogAutoManagerUtils.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/component/dxbilog/lib/manager/BILogAutoManagerUtils;", "", "()V", "Companion", "lib_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class is {

    @NotNull
    public static final a a = new a(null);

    @NotNull
    public static final HashMap<Integer, Long> b = new HashMap<>();

    /* compiled from: BILogAutoManagerUtils.kt */
    @Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fJ\u0012\u0010\r\u001a\u0004\u0018\u00010\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fJ\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001J\u0014\u0010\u0013\u001a\u0004\u0018\u00010\u00112\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0002J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u00112\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fJ\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u00112\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fJ\u0010\u0010\u0017\u001a\u00020\u00182\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001J\u0016\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001cJ\u0010\u0010\u001e\u001a\u00020\u001a2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fJ\u0016\u0010\u001f\u001a\u00020\u001a2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020!J\u0016\u0010\"\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020!2\u0006\u0010#\u001a\u00020\u0011J\u0018\u0010$\u001a\u00020\u001a2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010 \u001a\u00020!J\u0018\u0010%\u001a\u00020\u001a2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010 \u001a\u00020!J$\u0010&\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020!2\b\b\u0002\u0010'\u001a\u00020\u00182\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u0011J,\u0010&\u001a\u00020\u001a2\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010 \u001a\u00020!2\b\b\u0002\u0010'\u001a\u00020\u00182\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u0011J\u001c\u0010)\u001a\u00020\u00112\n\u0010*\u001a\u00060+j\u0002`,2\b\u0010-\u001a\u0004\u0018\u00010.R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lcom/component/dxbilog/lib/manager/BILogAutoManagerUtils$Companion;", "", "()V", "clickTimeHashMap", "Ljava/util/HashMap;", "", "", "mDateFormat", "Ljava/text/SimpleDateFormat;", "getActivityFromContext", "Landroid/app/Activity;", "context", "Landroid/content/Context;", "getActivityFromView", "view", "Landroid/view/View;", "getClassName", "", IconCompat.EXTRA_OBJ, "getElementViewContent", "getSupperClassName", "getViewContent", "getViewId", "isRepeatClick", "", "mergeJSONObject", "", "source", "Lorg/json/JSONObject;", "dest", "setAutoTrackClickTime", "setBeanAutoTrackClickTime", "contentBean", "Lcom/component/dxbilog/lib/bean/BILogContentBean;", "setTrackType", "type", "setViewContent", "setViewPosition", "trackPage", "isShow", "logNo", "traverseViewContent", "stringBuilder", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "root", "Landroid/view/ViewGroup;", "lib_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static final void q(Ref.ObjectRef logNo, BILogContentBean contentBean) {
            Intrinsics.checkNotNullParameter(logNo, "$logNo");
            Intrinsics.checkNotNullParameter(contentBean, "$contentBean");
            ks.a.b().a((String) logNo.element, contentBean);
        }

        @Nullable
        public final Activity a(@Nullable Context context) {
            Activity activity;
            Context context2;
            Activity activity2 = null;
            Object obj = context;
            if (context != null) {
                try {
                    if (context instanceof Activity) {
                        activity = (Activity) context;
                        context2 = context;
                    } else {
                        boolean z = context instanceof ContextWrapper;
                        obj = context;
                        Context baseContext = context;
                        if (z) {
                            while (!(baseContext instanceof Activity) && (baseContext instanceof ContextWrapper)) {
                                baseContext = ((ContextWrapper) baseContext).getBaseContext();
                            }
                            boolean z2 = baseContext instanceof Activity;
                            obj = baseContext;
                            if (z2) {
                                activity = (Activity) baseContext;
                                context2 = baseContext;
                            }
                        }
                    }
                    activity2 = activity;
                    obj = context2;
                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                }
            }
            return (activity2 == null && (obj instanceof Dialog)) ? ((Dialog) obj).getOwnerActivity() : activity2;
        }

        @Nullable
        public final Activity b(@Nullable View view) {
            if (view == null) {
                return null;
            }
            try {
                Context context = view.getContext();
                if (context == null) {
                    return null;
                }
                if (context instanceof Activity) {
                    return (Activity) context;
                }
                if (!(context instanceof ContextWrapper)) {
                    return null;
                }
                while (!(context instanceof Activity) && (context instanceof ContextWrapper)) {
                    context = ((ContextWrapper) context).getBaseContext();
                }
                Activity activity = context instanceof Activity ? (Activity) context : null;
                return activity == null ? b((View) view.getParent()) : activity;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        @Nullable
        public final String c(@Nullable Object obj) {
            Class<?> cls;
            if (obj == null || (cls = obj.getClass()) == null) {
                return null;
            }
            return cls.getSimpleName();
        }

        public final String d(View view) {
            CharSequence text;
            if (view == null) {
                return null;
            }
            if (view instanceof CheckBox) {
                text = ((CheckBox) view).getText();
            } else if (view instanceof SwitchCompat) {
                text = ((SwitchCompat) view).getTextOn();
            } else if (view instanceof RadioButton) {
                text = ((RadioButton) view).getText();
            } else if (view instanceof ToggleButton) {
                ToggleButton toggleButton = (ToggleButton) view;
                text = toggleButton.isChecked() ? toggleButton.getTextOn() : toggleButton.getTextOff();
            } else {
                text = view instanceof Button ? ((Button) view).getText() : view instanceof CheckedTextView ? ((CheckedTextView) view).getText() : view instanceof TextView ? ((TextView) view).getText() : view instanceof SeekBar ? String.valueOf(((SeekBar) view).getProgress()) : view instanceof RatingBar ? String.valueOf(((RatingBar) view).getRating()) : null;
            }
            if (text == null) {
                return null;
            }
            return text.toString();
        }

        @Nullable
        public final String e(@Nullable Object obj) {
            Class<?> cls;
            Class<? super Object> superclass;
            if (obj == null || (cls = obj.getClass()) == null || (superclass = cls.getSuperclass()) == null) {
                return null;
            }
            return superclass.getSimpleName();
        }

        @Nullable
        public final String f(@Nullable View view) {
            String strR = null;
            if (view == null) {
                return null;
            }
            if (view instanceof ViewGroup) {
                try {
                    strR = r(new StringBuilder(), (ViewGroup) view);
                    if (!TextUtils.isEmpty(strR)) {
                        String strSubstring = strR.substring(0, strR.length() - 1);
                        Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                        strR = strSubstring;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                strR = d(view);
            }
            if (strR == null || strR.length() <= 128) {
                return strR;
            }
            String strSubstring2 = strR.substring(0, 128);
            Intrinsics.checkNotNullExpressionValue(strSubstring2, "this as java.lang.String…ing(startIndex, endIndex)");
            return strSubstring2;
        }

        @Nullable
        public final String g(@Nullable View view) {
            Context context;
            Resources resources;
            boolean z = false;
            if (view != null) {
                try {
                    if (view.getId() == -1) {
                        z = true;
                    }
                } catch (Exception unused) {
                    return null;
                }
            }
            if (!z && view != null && (context = view.getContext()) != null && (resources = context.getResources()) != null) {
                return resources.getResourceEntryName((view == null ? null : Integer.valueOf(view.getId())).intValue());
            }
            return null;
        }

        public final boolean h(@Nullable Object obj) {
            if (obj == null) {
                return false;
            }
            Integer numValueOf = null;
            if (obj instanceof View) {
                numValueOf = Integer.valueOf(((View) obj).getId());
            } else if (obj instanceof String) {
                numValueOf = Integer.valueOf(((String) obj).hashCode());
            } else if (obj instanceof Integer) {
                numValueOf = (Integer) obj;
            } else if (obj instanceof Objects) {
                numValueOf = Integer.valueOf(((Objects) obj).hashCode());
            }
            if (numValueOf == null) {
                return false;
            }
            numValueOf.intValue();
            long jCurrentTimeMillis = System.currentTimeMillis();
            Long l = (Long) is.b.get(numValueOf);
            if (l == null) {
                l = 0L;
            }
            boolean z = jCurrentTimeMillis - l.longValue() < 300;
            if (!z) {
                is.b.put(numValueOf, Long.valueOf(jCurrentTimeMillis));
            }
            return z;
        }

        public final void j(@Nullable View view) {
            js.a.f(view, Integer.valueOf(qr.c), Long.valueOf(System.currentTimeMillis()));
        }

        public final void k(@NotNull View view, @NotNull BILogContentBean contentBean) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(contentBean, "contentBean");
            Object objB = js.a.b(view, Integer.valueOf(qr.c));
            Long l = objB instanceof Long ? (Long) objB : null;
            if (l == null) {
                return;
            }
            long jLongValue = l.longValue();
            BILogContentBean.Internals internals = contentBean.getInternals();
            if (internals == null) {
                return;
            }
            internals.setAuto_track_click_time(Long.valueOf(jLongValue));
        }

        public final void l(@NotNull BILogContentBean contentBean, @NotNull String type) {
            String track_type;
            Intrinsics.checkNotNullParameter(contentBean, "contentBean");
            Intrinsics.checkNotNullParameter(type, "type");
            if (contentBean.getProperties() == null) {
                contentBean.setProperties(new BILogContentBean.Properties(null, null, null, null, null, null, null, 127, null));
            }
            BILogContentBean.Properties properties = contentBean.getProperties();
            if (properties == null) {
                return;
            }
            BILogContentBean.Properties properties2 = contentBean.getProperties();
            if (properties2 != null && (track_type = properties2.getTrack_type()) != null) {
                type = track_type;
            }
            properties.setTrack_type(type);
        }

        public final void m(@Nullable View view, @NotNull BILogContentBean contentBean) {
            BILogContentBean.Properties properties;
            Intrinsics.checkNotNullParameter(contentBean, "contentBean");
            if (view == null) {
                return;
            }
            BILogContentBean.Properties properties2 = contentBean.getProperties();
            if ((properties2 == null ? null : properties2.getView_content()) == null) {
                String strF = f(view);
                if ((strF == null || strF.length() == 0) || (properties = contentBean.getProperties()) == null) {
                    return;
                }
                properties.setView_content(strF);
            }
        }

        public final void n(@Nullable View view, @NotNull BILogContentBean contentBean) {
            TabLayout.Tab tab;
            BILogContentBean.Properties properties;
            Intrinsics.checkNotNullParameter(contentBean, "contentBean");
            if (view == null) {
                return;
            }
            BILogContentBean.Properties properties2 = contentBean.getProperties();
            if ((properties2 == null ? null : properties2.getView_position()) == null) {
                ViewParent parent = view.getParent();
                int position = -1;
                if (parent instanceof RecyclerView) {
                    ViewParent parent2 = view.getParent();
                    RecyclerView recyclerView = parent2 instanceof RecyclerView ? (RecyclerView) parent2 : null;
                    if (recyclerView != null) {
                        position = recyclerView.getChildAdapterPosition(view);
                    }
                } else if (parent instanceof ListView) {
                    ViewParent parent3 = view.getParent();
                    ListView listView = parent3 instanceof ListView ? (ListView) parent3 : null;
                    if (listView != null) {
                        listView.getPositionForView(view);
                    }
                } else if (parent instanceof TabLayout.TabView) {
                    ViewParent parent4 = view.getParent();
                    TabLayout.TabView tabView = parent4 instanceof TabLayout.TabView ? (TabLayout.TabView) parent4 : null;
                    if (tabView != null && (tab = tabView.getTab()) != null) {
                        position = tab.getPosition();
                    }
                }
                if (position < 0 || (properties = contentBean.getProperties()) == null) {
                    return;
                }
                properties.setView_position(String.valueOf(position));
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void o(@NotNull final BILogContentBean contentBean, boolean z, @Nullable String str) {
            Intrinsics.checkNotNullParameter(contentBean, "contentBean");
            l(contentBean, TtmlNode.TEXT_EMPHASIS_AUTO);
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            String str2 = str;
            if (str == null) {
                str2 = z ? "S0007" : "S0008";
            }
            objectRef.element = str2;
            if (ks.a.i()) {
                de0.l("trackPage", Intrinsics.stringPlus("logNo = ", objectRef.element), wr.b(xd0.h().toJson(contentBean)));
            }
            se0.c().execute(new Runnable() { // from class: dc.fs
                @Override // java.lang.Runnable
                public final void run() {
                    is.a.q(objectRef, contentBean);
                }
            });
        }

        public final void p(@NotNull Object obj, @NotNull BILogContentBean contentBean, boolean z, @Nullable String str) {
            Intrinsics.checkNotNullParameter(obj, "obj");
            Intrinsics.checkNotNullParameter(contentBean, "contentBean");
            BILogContentBean.Properties properties = contentBean.getProperties();
            if (properties != null) {
                BILogContentBean.Properties properties2 = contentBean.getProperties();
                String view_class_name = properties2 == null ? null : properties2.getView_class_name();
                if (view_class_name == null) {
                    view_class_name = c(obj);
                }
                properties.setView_class_name(view_class_name);
            }
            BILogContentBean.Properties properties3 = contentBean.getProperties();
            if (properties3 != null) {
                BILogContentBean.Properties properties4 = contentBean.getProperties();
                String view_supper_name = properties4 != null ? properties4.getView_supper_name() : null;
                if (view_supper_name == null) {
                    view_supper_name = e(obj);
                }
                properties3.setView_supper_name(view_supper_name);
            }
            o(contentBean, z, str);
        }

        @NotNull
        public final String r(@NotNull StringBuilder stringBuilder, @Nullable ViewGroup viewGroup) {
            Intrinsics.checkNotNullParameter(stringBuilder, "stringBuilder");
            try {
                if (viewGroup == null) {
                    String string = stringBuilder.toString();
                    Intrinsics.checkNotNullExpressionValue(string, "stringBuilder.toString()");
                    return string;
                }
                int childCount = viewGroup.getChildCount();
                int i = 0;
                while (i < childCount) {
                    int i2 = i + 1;
                    View childAt = viewGroup.getChildAt(i);
                    if (childAt.getVisibility() == 0) {
                        if (childAt instanceof ViewGroup) {
                            r(stringBuilder, (ViewGroup) childAt);
                        } else {
                            CharSequence string2 = null;
                            if (childAt instanceof CheckBox) {
                                string2 = ((CheckBox) childAt).getText();
                            } else if (childAt instanceof RadioButton) {
                                string2 = ((RadioButton) childAt).getText();
                            } else if (childAt instanceof ToggleButton) {
                                string2 = ((ToggleButton) childAt).isChecked() ? ((ToggleButton) childAt).getTextOn() : ((ToggleButton) childAt).getTextOff();
                            } else if (childAt instanceof Button) {
                                string2 = ((Button) childAt).getText();
                            } else if (childAt instanceof CheckedTextView) {
                                string2 = ((CheckedTextView) childAt).getText();
                            } else if (childAt instanceof TextView) {
                                string2 = ((TextView) childAt).getText();
                            } else if ((childAt instanceof ImageView) && !TextUtils.isEmpty(((ImageView) childAt).getContentDescription())) {
                                string2 = ((ImageView) childAt).getContentDescription().toString();
                            }
                            if (!TextUtils.isEmpty(string2)) {
                                stringBuilder.append(String.valueOf(string2));
                                stringBuilder.append(Constants.FILENAME_SEQUENCE_SEPARATOR);
                            }
                        }
                    }
                    i = i2;
                }
                String string3 = stringBuilder.toString();
                Intrinsics.checkNotNullExpressionValue(string3, "{\n                if (ro….toString()\n            }");
                return string3;
            } catch (Exception e) {
                e.printStackTrace();
                String string4 = stringBuilder.toString();
                Intrinsics.checkNotNullExpressionValue(string4, "{\n                e.prin….toString()\n            }");
                return string4;
            }
        }
    }

    static {
        new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.CHINA);
    }
}
