package dc;

import android.app.Activity;
import android.app.Dialog;
import android.app.Fragment;
import android.view.View;
import android.view.Window;
import androidx.core.graphics.drawable.IconCompat;
import com.component.dxbilog.lib.bean.BILogContentBean;
import com.google.android.material.tabs.TabLayout;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: BILogAutoParamsManager.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/component/dxbilog/lib/manager/BILogAutoParamsManager;", "", "()V", "Companion", "lib_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class js {

    @NotNull
    public static final a a = new a(null);

    /* compiled from: BILogAutoParamsManager.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0001H\u0007J#\u0010\u0006\u001a\u0004\u0018\u00010\u00012\b\u0010\u0005\u001a\u0004\u0018\u00010\u00012\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0007¢\u0006\u0002\u0010\tJ\u0014\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0001H\u0002J\u001c\u0010\f\u001a\u00020\r2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004H\u0007J\u0012\u0010\u000f\u001a\u00020\u00102\b\u0010\u0005\u001a\u0004\u0018\u00010\u0001H\u0007J\u001a\u0010\u0011\u001a\u00020\r2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0012\u001a\u00020\u0010H\u0007J+\u0010\u0013\u001a\u00020\r2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00012\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0002\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/component/dxbilog/lib/manager/BILogAutoParamsManager$Companion;", "", "()V", "createContentBean", "Lcom/component/dxbilog/lib/bean/BILogContentBean;", IconCompat.EXTRA_OBJ, "getTag", "key", "", "(Ljava/lang/Object;Ljava/lang/Integer;)Ljava/lang/Object;", "getView", "Landroid/view/View;", "initAllTag", "", "contentBean", "isIgnore", "", "setIgnore", "ignore", "setTag", "value", "(Ljava/lang/Object;Ljava/lang/Integer;Ljava/lang/Object;)V", "lib_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final BILogContentBean a(@Nullable Object obj) {
            BILogContentBean bILogContentBean = new BILogContentBean(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 32767, null);
            bILogContentBean.setProperties(new BILogContentBean.Properties(null, null, null, null, null, null, null, 127, null));
            bILogContentBean.setInternals(new BILogContentBean.Internals(null, 1, null));
            d(obj, bILogContentBean);
            return bILogContentBean;
        }

        @JvmStatic
        @Nullable
        public final Object b(@Nullable Object obj, @Nullable Integer num) {
            View viewC = c(obj);
            if (viewC == null) {
                return null;
            }
            return viewC.getTag(num == null ? 0 : num.intValue());
        }

        public final View c(Object obj) {
            Window window;
            if (obj == null) {
                return null;
            }
            if (obj instanceof View) {
                return (View) obj;
            }
            if (obj instanceof Activity) {
                Window window2 = ((Activity) obj).getWindow();
                if (window2 == null) {
                    return null;
                }
                return window2.getDecorView();
            }
            if (obj instanceof Fragment) {
                return ((Fragment) obj).getView();
            }
            if (obj instanceof androidx.fragment.app.Fragment) {
                return ((androidx.fragment.app.Fragment) obj).getView();
            }
            if (obj instanceof TabLayout.Tab) {
                return ((TabLayout.Tab) obj).getCustomView();
            }
            if (!(obj instanceof Dialog) || (window = ((Dialog) obj).getWindow()) == null) {
                return null;
            }
            return window.getDecorView();
        }

        @JvmStatic
        public final void d(@Nullable Object obj, @Nullable BILogContentBean bILogContentBean) {
            BILogContentBean.Properties properties;
            BILogContentBean.Properties properties2;
            BILogContentBean.Properties properties3;
            BILogContentBean.Properties properties4;
            BILogContentBean.Properties properties5;
            BILogContentBean.Properties properties6;
            if (obj == null || e(obj) || bILogContentBean == null) {
                return;
            }
            Object objB = b(obj, Integer.valueOf(rr.b));
            String str = objB instanceof String ? (String) objB : null;
            Object objB2 = b(obj, Integer.valueOf(rr.c));
            String str2 = objB2 instanceof String ? (String) objB2 : null;
            Object objB3 = b(obj, Integer.valueOf(qr.a));
            String str3 = objB3 instanceof String ? (String) objB3 : null;
            Object objB4 = b(obj, Integer.valueOf(rr.d));
            String str4 = objB4 instanceof String ? (String) objB4 : null;
            Object objB5 = b(obj, Integer.valueOf(rr.e));
            String str5 = objB5 instanceof String ? (String) objB5 : null;
            Object objB6 = b(obj, Integer.valueOf(rr.f));
            Double d = objB6 instanceof Double ? (Double) objB6 : null;
            Object objB7 = b(obj, Integer.valueOf(rr.g));
            List<String> list = objB7 instanceof List ? (List) objB7 : null;
            Object objB8 = b(obj, Integer.valueOf(rr.h));
            String str6 = objB8 instanceof String ? (String) objB8 : null;
            Object objB9 = b(obj, Integer.valueOf(rr.i));
            String str7 = objB9 instanceof String ? (String) objB9 : null;
            Object objB10 = b(obj, Integer.valueOf(rr.j));
            String str8 = objB10 instanceof String ? (String) objB10 : null;
            Object objB11 = b(obj, Integer.valueOf(rr.k));
            String str9 = objB11 instanceof String ? (String) objB11 : null;
            Object objB12 = b(obj, Integer.valueOf(rr.l));
            String str10 = objB12 instanceof String ? (String) objB12 : null;
            Object objB13 = b(obj, Integer.valueOf(rr.m));
            String str11 = str10;
            String str12 = objB13 instanceof String ? (String) objB13 : null;
            Object objB14 = b(obj, Integer.valueOf(rr.n));
            Object objB15 = b(obj, Integer.valueOf(rr.o));
            String str13 = str12;
            String str14 = objB15 instanceof String ? (String) objB15 : null;
            Object objB16 = b(obj, Integer.valueOf(rr.s));
            String str15 = str14;
            String str16 = objB16 instanceof String ? (String) objB16 : null;
            Object objB17 = b(obj, Integer.valueOf(rr.t));
            String str17 = str16;
            String str18 = objB17 instanceof String ? (String) objB17 : null;
            Object objB18 = b(obj, Integer.valueOf(rr.p));
            String str19 = str18;
            String str20 = objB18 instanceof String ? (String) objB18 : null;
            Object objB19 = b(obj, Integer.valueOf(rr.q));
            String str21 = str20;
            Boolean bool = objB19 instanceof Boolean ? (Boolean) objB19 : null;
            Object objB20 = b(obj, Integer.valueOf(rr.r));
            Boolean bool2 = bool;
            String str22 = objB20 instanceof String ? (String) objB20 : null;
            Object objB21 = b(obj, Integer.valueOf(rr.u));
            String str23 = str22;
            String str24 = objB21 instanceof String ? (String) objB21 : null;
            Object objB22 = b(obj, Integer.valueOf(qr.c));
            Long l = objB22 instanceof Long ? (Long) objB22 : null;
            if (str != null) {
                bILogContentBean.setPage_name(str);
                vr.a.d(bILogContentBean, str3);
            }
            if (str2 != null) {
                bILogContentBean.setPage_type(str2);
            }
            if (str4 != null) {
                bILogContentBean.setReferrer(str4);
            }
            if (str5 != null) {
                bILogContentBean.setControl_type(str5);
            }
            if (d != null) {
                bILogContentBean.setDuration(Double.valueOf(d.doubleValue()));
            }
            if (list != null) {
                bILogContentBean.setToys(list);
            }
            if (str6 != null) {
                bILogContentBean.setEvent_id(str6);
            }
            if (str7 != null) {
                bILogContentBean.setEvent_type(str7);
            }
            if (str8 != null) {
                bILogContentBean.setElement_id(str8);
            }
            if (str9 != null) {
                bILogContentBean.setElement_type(str9);
            }
            if (str11 != null) {
                bILogContentBean.setElement_content(str11);
            }
            if (str13 != null) {
                bILogContentBean.setElement_name(str13);
            }
            if (objB14 != null) {
                bILogContentBean.setElement_data_json(objB14);
            }
            if (str15 != null && (properties6 = bILogContentBean.getProperties()) != null) {
                properties6.setView_type(str15);
            }
            if (str17 != null && (properties5 = bILogContentBean.getProperties()) != null) {
                properties5.setView_class_name(str17);
            }
            if (str19 != null && (properties4 = bILogContentBean.getProperties()) != null) {
                properties4.setView_supper_name(str19);
            }
            if (str21 != null && (properties3 = bILogContentBean.getProperties()) != null) {
                properties3.setView_content(str21);
            }
            if (bool2 != null) {
                boolean zBooleanValue = bool2.booleanValue();
                BILogContentBean.Properties properties7 = bILogContentBean.getProperties();
                if (properties7 != null) {
                    properties7.setView_check(Boolean.valueOf(zBooleanValue));
                }
            }
            if (str23 != null && (properties2 = bILogContentBean.getProperties()) != null) {
                properties2.setView_position(str23);
            }
            if (str24 != null && (properties = bILogContentBean.getProperties()) != null) {
                properties.setTrack_type(str24);
            }
            if (l == null) {
                return;
            }
            long jLongValue = l.longValue();
            BILogContentBean.Internals internals = bILogContentBean.getInternals();
            if (internals == null) {
                return;
            }
            internals.setAuto_track_click_time(Long.valueOf(jLongValue));
        }

        @JvmStatic
        public final boolean e(@Nullable Object obj) {
            Object objB = b(obj, Integer.valueOf(rr.a));
            Boolean bool = objB instanceof Boolean ? (Boolean) objB : null;
            if (bool == null) {
                return false;
            }
            return bool.booleanValue();
        }

        @JvmStatic
        public final void f(@Nullable Object obj, @Nullable Integer num, @Nullable Object obj2) {
            View viewC = c(obj);
            if (viewC == null) {
                return;
            }
            viewC.setTag(num == null ? 0 : num.intValue(), obj2);
        }
    }
}
