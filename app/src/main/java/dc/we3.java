package dc;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.lovense.wear.R;
import com.wear.activity.orgySetting.OrgySetting;
import com.wear.activity.orgySetting.OrgyWebViewActivity;
import com.wear.bean.EntryPoint;
import com.wear.bean.OpenAppBean;
import com.wear.bean.socketio.date.response.BeanFromHtml;
import com.wear.main.MainActivity;
import com.wear.main.account.WebViewActivity;
import com.wear.main.account.login.LoginActivity;
import com.wear.main.game.ui.NewGameModeActivity;
import com.wear.main.longDistance.control.ChatVideoControl;
import com.wear.ui.discover.gaming.GalleryListActivity;
import com.wear.ui.discover.gaming.NewGamingDetailsActivity;
import com.wear.ui.discover.pattern.PatternStoreActivity;
import com.wear.ui.discover.roulette.ToyRouletteActivity;
import com.wear.ui.discover.voicecontrol.VoiceControlActivity;
import com.wear.ui.discover.xremote.activity.XRemoteActivity;
import com.wear.ui.home.pattern.NewPatternActivity;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import dc.is3;
import dc.y12;
import org.bouncycastle.i18n.MessageBundle;

/* compiled from: LinkParser.java */
/* loaded from: classes4.dex */
public class we3 {
    public static void a(Uri uri) {
        String queryParameter = uri.getQueryParameter("version");
        String str = "广告版本：" + queryParameter;
        if (b(ye3.s(), queryParameter) < 0) {
            sg3.l(ah4.e(R.string.hint_update_ads_discover));
            return;
        }
        String str2 = "当前版本大于等于：" + queryParameter;
    }

    public static int b(String str, String str2) {
        String[] strArrSplit = str.split("\\.");
        String[] strArrSplit2 = str2.split("\\.");
        int iMax = Math.max(strArrSplit.length, strArrSplit2.length);
        int i = 0;
        while (i < iMax) {
            int i2 = i < strArrSplit.length ? Integer.parseInt(strArrSplit[i]) : -1;
            int i3 = i < strArrSplit2.length ? Integer.parseInt(strArrSplit2[i]) : -1;
            if (i2 < i3) {
                return -1;
            }
            if (i2 > i3) {
                return 1;
            }
            i++;
        }
        return 0;
    }

    public static void c(Activity activity, Uri uri) {
        Bundle bundle = new Bundle();
        String queryParameter = uri.getQueryParameter("applicationUrl");
        String str = "applicationUrl==" + queryParameter;
        String str2 = "applicationId==" + uri.getQueryParameter(RemoteConfigConstants.RequestFieldKey.APP_ID);
        String str3 = "applicationRealUrl==" + queryParameter + "?" + uri.getQueryParameter(RemoteConfigConstants.RequestFieldKey.APP_ID);
        bundle.putString(RemoteConfigConstants.RequestFieldKey.APP_ID, uri.getQueryParameter(RemoteConfigConstants.RequestFieldKey.APP_ID));
        if (MyApplication.Z) {
            bundle.putString(RemoteConfigConstants.RequestFieldKey.APP_VERSION, uri.getQueryParameter(RemoteConfigConstants.RequestFieldKey.APP_VERSION));
            pj3.g(activity, NewGamingDetailsActivity.class, bundle);
            return;
        }
        bundle.putString(ImagesContract.URL, queryParameter + "?appId=" + uri.getQueryParameter(RemoteConfigConstants.RequestFieldKey.APP_ID));
        bundle.putLong("startTime", System.currentTimeMillis());
        ye3.j("game", "game_open_click", "click", uri.getQueryParameter(RemoteConfigConstants.RequestFieldKey.APP_ID), "", ExifInterface.GPS_MEASUREMENT_3D, "", -1L);
        pj3.p(activity, XRemoteActivity.class, 12345, bundle);
    }

    public static void d(Context context, String str) {
        if (str.startsWith("remotelink://lovense.club/cordova")) {
            l(context, str.substring(str.indexOf("=") + 1));
        } else if (str.startsWith("remotelink://lovense.club/browser")) {
            j(context, str.substring(str.indexOf("=") + 1));
        }
    }

    public static void e(BeanFromHtml beanFromHtml, Activity activity) {
        f(beanFromHtml.getReceiver(), beanFromHtml.getSponsor(), beanFromHtml.getId(), beanFromHtml.getReceiverName(), beanFromHtml.getSponsorName(), beanFromHtml.isOwner(), 0, activity);
    }

    public static void f(String str, String str2, String str3, String str4, String str5, boolean z, int i, Activity activity) {
        OpenAppBean openAppBean = new OpenAppBean();
        openAppBean.type = i;
        openAppBean.datingId = str3;
        if (z) {
            openAppBean.userId = str;
            openAppBean.selfId = str2;
            openAppBean.receiverName = str4;
            openAppBean.sponsorName = str5;
        } else {
            openAppBean.userId = str2;
            openAppBean.selfId = str;
            openAppBean.receiverName = str5;
            openAppBean.sponsorName = str4;
        }
        if (TextUtils.isEmpty(openAppBean.userId) || TextUtils.isEmpty(openAppBean.selfId)) {
            MyApplication.v0(null);
        } else {
            MyApplication.v0(openAppBean);
        }
        ti1.b().d(1);
        pj3.f(activity, MainActivity.class);
        activity.finish();
    }

    public static void h(Context context) {
        pj3.f(context, GalleryListActivity.class);
    }

    public static void i(Context context) {
        ToyRouletteActivity.b.a(context);
    }

    public static void j(Context context, String str) {
        context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
    }

    public static void k(Context context) {
        na2.m().w();
        ChatVideoControl.a1().X0(true, false, false);
        pj3.f(context, NewGameModeActivity.class);
    }

    public static void l(Context context, String str) {
        String str2;
        Bundle bundle = new Bundle();
        String language = lg3.e(WearUtils.x).getLanguage();
        if (str.contains("?")) {
            str2 = str + "&lang=" + language;
        } else {
            str2 = str + "?lang=" + language;
        }
        bundle.putString(ImagesContract.URL, str2);
        String str3 = "url==" + str2;
        Intent intent = new Intent(context, (Class<?>) WebViewActivity.class);
        intent.putExtras(bundle);
        intent.setFlags(268435456);
        context.startActivity(intent);
    }

    public static void m(Context context, String str, EntryPoint entryPoint) {
        String strSubstring = str.substring(str.indexOf("=") + 1);
        Bundle bundle = new Bundle();
        OrgySetting orgySetting = OrgySetting.getInstance();
        if (orgySetting.getOrgys() != null) {
            bundle.putString(MessageBundle.TITLE_ENTRY, orgySetting.getOrgys().getName());
        }
        bundle.putString(ImagesContract.URL, orgySetting.concatenateURL(strSubstring, orgySetting.getJoinId(), null, entryPoint));
        pj3.g(context, OrgyWebViewActivity.class, bundle);
    }

    public static void n(Context context) {
        pj3.f(context, NewPatternActivity.class);
    }

    public static void o(Context context) {
        pj3.f(context, PatternStoreActivity.class);
    }

    public static void p(Context context) {
        if (na2.m().i()) {
            na2.m().t();
        } else if (y12.c.a().s(y12.c.TYPE_VOICE_CONTROL)) {
            pj3.f(context, VoiceControlActivity.class);
        }
    }

    public static void q(Activity activity, String str, EntryPoint entryPoint) {
        Uri uri = Uri.parse(str);
        String host = uri.getHost();
        String path = uri.getPath();
        String str2 = "link==" + str;
        String str3 = "host==" + host;
        String str4 = "path==" + path;
        String str5 = "Scheme==" + uri.getScheme();
        if (host == null || !host.equals("lovense.club")) {
            d(activity, str);
            return;
        }
        if (path != null) {
            path.hashCode();
            switch (path) {
                case "/gamemode/home":
                    k(activity);
                    break;
                case "/controlroulette/home":
                    i(activity);
                    break;
                case "/patterns/mypattern":
                    n(activity);
                    break;
                case "/checkVersion":
                    a(uri);
                    break;
                case "/voicecontrol/home":
                    if (!MyApplication.Z) {
                        p(activity);
                        break;
                    } else {
                        s(activity, R.string.common_login_first);
                        break;
                    }
                case "/appgallery/home":
                    h(activity);
                    break;
                case "/browser":
                case "/cordova":
                    d(activity, str);
                    break;
                case "/patterns/home":
                    o(activity);
                    break;
                case "/mainorgy":
                    m(activity, str, entryPoint);
                    break;
                case "/appgallery/app":
                    c(activity, uri);
                    break;
                default:
                    sg3.k(activity, ah4.e(R.string.hint_update_ads_discover));
                    break;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:120:0x0331 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0242 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0101 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:135:0x02ff A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:137:0x028b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x017f A[Catch: UnsupportedEncodingException -> 0x0186, TRY_LEAVE, TryCatch #3 {UnsupportedEncodingException -> 0x0186, blocks: (B:33:0x0179, B:35:0x017f), top: B:126:0x0179 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0363  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean r(android.net.Uri r10, android.app.Activity r11) {
        /*
            Method dump skipped, instructions count: 1063
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: dc.we3.r(android.net.Uri, android.app.Activity):boolean");
    }

    public static void s(final Context context, int i) {
        cs3.c(context, ah4.e(i), ah4.e(R.string.login_title), ah4.e(R.string.common_cancel), new is3.d() { // from class: dc.qc3
            @Override // dc.is3.d
            public final void doConfirm() {
                pj3.t(context, LoginActivity.class, 2);
            }
        }).show();
    }
}
