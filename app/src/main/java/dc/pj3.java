package dc;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import androidx.annotation.NonNull;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.lovense.wear.R;
import com.wear.bean.ControlIdBean;
import com.wear.main.toy.newtoy.NewToyActivity;
import com.wear.ui.home.music.MusicListenActivity;
import com.wear.util.WearUtils;

/* compiled from: CommonUtils.java */
/* loaded from: classes4.dex */
public class pj3 {
    public static String a() {
        String strB = b();
        gu3.j.setControlId(strB);
        gu3.j.setAvailable(ControlIdBean.Status.request);
        gu3.j.setCreate(true);
        return strB;
    }

    public static String b() {
        char[] charArray = "qwertyuiopasdfghjklzxcvbnm".toCharArray();
        String str = "";
        int i = 0;
        while (i < 6) {
            char c = charArray[(int) (Math.random() * 26.0d)];
            if (str.contains(String.valueOf(c))) {
                i--;
            } else {
                str = str + c;
            }
            i++;
        }
        return str + System.currentTimeMillis();
    }

    public static int c(Activity activity) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    public static void d(Intent intent) {
    }

    public static boolean e(CharSequence charSequence) {
        return charSequence == null || "".equals(charSequence.toString().trim()) || "null".equals(charSequence);
    }

    public static void f(Context context, Class<?> cls) {
        String str = "Activity的名字" + cls.getSimpleName();
        if (context == null) {
            Intent intent = new Intent(WearUtils.x, cls);
            intent.setFlags(268435456);
            d(intent);
            WearUtils.x.startActivity(intent);
            return;
        }
        if (cls.getSimpleName().equals("ToyActivity")) {
            Intent intent2 = new Intent(context, (Class<?>) NewToyActivity.class);
            d(intent2);
            context.startActivity(intent2);
        } else if (!cls.getSimpleName().equals("SoundPlayActivity")) {
            Intent intent3 = new Intent(context, cls);
            d(intent3);
            context.startActivity(intent3);
        } else if (!eg3.d(context, "is_first_music", false)) {
            context.startActivity(new Intent(context, (Class<?>) MusicListenActivity.class));
            eg3.j(context, "is_first_music", true);
        } else {
            Intent intent4 = new Intent(context, cls);
            d(intent4);
            context.startActivity(intent4);
        }
    }

    public static void g(Context context, Class<?> cls, Bundle bundle) {
        try {
            if (context != null) {
                Intent intent = new Intent(context, cls);
                intent.putExtras(bundle);
                d(intent);
                context.startActivity(intent);
            } else {
                Intent intent2 = new Intent(WearUtils.x, cls);
                intent2.putExtras(bundle);
                intent2.setFlags(268435456);
                d(intent2);
                WearUtils.x.startActivity(intent2);
            }
        } catch (Exception e) {
            String str = "跳转失败==" + e.toString();
        }
    }

    public static void h(Context context, Class<?> cls, String str, int i) {
        Bundle bundle = new Bundle();
        bundle.putInt(str, i);
        g(context, cls, bundle);
    }

    public static void i(Context context, Class<?> cls, String str, Parcelable parcelable) {
        if (context != null) {
            Intent intent = new Intent(context, cls);
            intent.putExtra(str, parcelable);
            d(intent);
            context.startActivity(intent);
            return;
        }
        Intent intent2 = new Intent(WearUtils.x, cls);
        intent2.putExtra(str, parcelable);
        intent2.setFlags(268435456);
        d(intent2);
        WearUtils.x.startActivity(intent2);
    }

    public static void j(Context context, Class<?> cls, String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString(str, str2);
        g(context, cls, bundle);
    }

    public static void k(Context context, Class<?> cls, String str, boolean z) {
        Bundle bundle = new Bundle();
        bundle.putBoolean(str, z);
        g(context, cls, bundle);
    }

    public static void l(Context context, Class<?> cls) {
        if (context != null) {
            Intent intent = new Intent(context, cls);
            d(intent);
            context.startActivity(intent);
            ((Activity) context).overridePendingTransition(R.anim.from_bottom_to_top, R.anim.anim_silent);
            return;
        }
        Intent intent2 = new Intent(WearUtils.x, cls);
        intent2.addFlags(268435456);
        d(intent2);
        WearUtils.x.startActivity(intent2);
    }

    public static void m(Context context, Class<?> cls, Bundle bundle) {
        if (context != null) {
            Intent intent = new Intent(context, cls);
            intent.putExtras(bundle);
            context.startActivity(intent);
            ((Activity) context).overridePendingTransition(R.anim.from_bottom_to_top, R.anim.anim_silent);
            return;
        }
        Intent intent2 = new Intent(WearUtils.x, cls);
        intent2.putExtras(bundle);
        intent2.addFlags(268435456);
        WearUtils.x.startActivity(intent2);
    }

    public static void n(Activity activity, Intent intent, int i) {
        activity.startActivityForResult(intent, i);
    }

    public static void o(Activity activity, Class<?> cls, int i) {
        Intent intent = new Intent(activity, cls);
        d(intent);
        activity.startActivityForResult(intent, i);
    }

    public static void p(Activity activity, Class<?> cls, int i, Bundle bundle) {
        Intent intent = new Intent(activity, cls);
        d(intent);
        intent.putExtras(bundle);
        activity.startActivityForResult(intent, i);
    }

    public static void q(Activity activity, Class<?> cls, int i, String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString(str, str2);
        p(activity, cls, i, bundle);
    }

    public static void r(Context context, Class<?> cls, Bundle bundle) {
        if (context != null) {
            Intent intent = new Intent(context, cls);
            intent.putExtras(bundle);
            d(intent);
            intent.addFlags(268468224);
            context.startActivity(intent);
            return;
        }
        Intent intent2 = new Intent(WearUtils.x, cls);
        intent2.putExtras(bundle);
        intent2.addFlags(268468224);
        d(intent2);
        WearUtils.x.startActivity(intent2);
    }

    public static void s(Context context, Class<?> cls) {
        if (context != null) {
            Intent intent = new Intent(context, cls);
            d(intent);
            intent.putExtra("intoType", 1);
            context.startActivity(intent);
            ((Activity) context).overridePendingTransition(R.anim.from_bottom_to_top, R.anim.anim_silent);
            return;
        }
        Intent intent2 = new Intent(WearUtils.x, cls);
        intent2.putExtra("intoType", 1);
        intent2.addFlags(268435456);
        d(intent2);
        WearUtils.x.startActivity(intent2);
    }

    public static void t(Context context, Class<?> cls, int i) {
        if (context != null) {
            Intent intent = new Intent(context, cls);
            d(intent);
            intent.putExtra("intoType", 1);
            intent.putExtra("fraIndex", i);
            context.startActivity(intent);
            ((Activity) context).overridePendingTransition(R.anim.from_bottom_to_top, R.anim.anim_silent);
            return;
        }
        Intent intent2 = new Intent(WearUtils.x, cls);
        intent2.putExtra("intoType", 1);
        intent2.putExtra("fraIndex", i);
        intent2.addFlags(268435456);
        d(intent2);
        WearUtils.x.startActivity(intent2);
    }

    public static void u(Context context, Intent intent) {
        if (context == null) {
            WearUtils.x.C0();
            d(intent);
            intent.addFlags(268468224);
            WearUtils.x.startActivity(intent);
            return;
        }
        WearUtils.x.C0();
        d(intent);
        intent.addFlags(268468224);
        context.startActivity(intent);
        ((Activity) context).overridePendingTransition(R.anim.from_bottom_to_top, R.anim.anim_silent);
    }

    public static void v(Context context, Class<?> cls) {
        WearUtils.x.C0();
        Intent intent = new Intent(context, cls);
        d(intent);
        intent.addFlags(268468224);
        context.startActivity(intent);
    }

    public static void w(@NonNull Context context, @NonNull String str) {
        if (context == null || WearUtils.e1(str)) {
            return;
        }
        try {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            Uri uriBuild = Uri.parse(str);
            if (TextUtils.isEmpty(uriBuild.getQueryParameter("utm_ap"))) {
                uriBuild = uriBuild.buildUpon().appendQueryParameter("utm_ap", "remote").build();
            }
            intent.setData(uriBuild);
            intent.resolveActivity(context.getPackageManager());
            context.startActivity(intent);
        } catch (Exception e) {
            FirebaseCrashlytics.getInstance().recordException(new Throwable("launchUrl 错误", e));
            sg3.f(context, ah4.e(R.string.no_browser_toast));
        }
    }

    public static String x(Context context, Uri uri) {
        Cursor cursorQuery = context.getContentResolver().query(uri, new String[]{"_data"}, null, null, null);
        if (cursorQuery == null) {
            return "";
        }
        try {
            cursorQuery.moveToNext();
            return cursorQuery.getString(cursorQuery.getColumnIndex("_data"));
        } finally {
            cursorQuery.close();
        }
    }
}
