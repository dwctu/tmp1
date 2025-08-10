package dc;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.Fragment;
import com.lovense.wear.R;
import com.wear.bean.MusicAPPBean;
import com.wear.bean.SongInformation;
import com.wear.util.MyApplication;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: AudioFunctionUtils.java */
/* loaded from: classes4.dex */
public class rd3 {
    public static rd3 k = null;
    public static String l = "com.wear.backgroundservice.service.MusicCaptureService";
    public static String m = "com.wear.backgroundservice.service.MediaControllerService";
    public static String n = "music_player_name";
    public j43 b;
    public h43 c;
    public i43 d;
    public k43 e;
    public SongInformation j;
    public boolean a = false;
    public boolean f = false;
    public boolean g = false;
    public long h = 0;
    public long i = 0;

    public static rd3 f() {
        if (k == null) {
            synchronized (sc1.class) {
                if (k == null) {
                    k = new rd3();
                }
            }
        }
        return k;
    }

    public static boolean m(Context context) {
        return NotificationManagerCompat.getEnabledListenerPackages(context).contains(context.getPackageName());
    }

    public static void s(Context context) {
        try {
            if (Build.VERSION.SDK_INT >= 22) {
                context.startActivity(new Intent("android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void A(j43 j43Var) {
        this.b = j43Var;
    }

    public void B(boolean z) {
        z(z);
        this.a = z;
    }

    public void C(k43 k43Var) {
        this.e = k43Var;
    }

    public void D(int i) {
    }

    public void E(long j) {
        this.h = j;
    }

    public void F(l43 l43Var) {
    }

    public void G(m43 m43Var) {
    }

    public List<MusicAPPBean> a() {
        ArrayList arrayList = new ArrayList();
        MusicAPPBean musicAPPBean = new MusicAPPBean();
        Boolean bool = Boolean.FALSE;
        musicAPPBean.setCheck(bool);
        musicAPPBean.setPackageName("com.google.android.apps.youtube.music");
        musicAPPBean.setLabel("YouTube Music");
        Boolean bool2 = Boolean.TRUE;
        musicAPPBean.setSupport(bool2);
        musicAPPBean.setIconLogo(Integer.valueOf(R.drawable.music_youtube_logo));
        musicAPPBean.setInstalled(Boolean.valueOf(c(musicAPPBean.getPackageName())));
        arrayList.add(musicAPPBean);
        MusicAPPBean musicAPPBean2 = new MusicAPPBean();
        musicAPPBean2.setCheck(bool);
        musicAPPBean2.setPackageName("com.apple.android.music");
        musicAPPBean2.setLabel("Apple Music");
        musicAPPBean2.setSupport(bool2);
        musicAPPBean2.setIconLogo(Integer.valueOf(R.drawable.music_apple_logo));
        musicAPPBean2.setInstalled(Boolean.valueOf(c(musicAPPBean2.getPackageName())));
        arrayList.add(musicAPPBean2);
        MusicAPPBean musicAPPBean3 = new MusicAPPBean();
        musicAPPBean3.setCheck(bool);
        musicAPPBean3.setPackageName("com.amazon.mp3");
        musicAPPBean3.setLabel("Amazon Music");
        musicAPPBean3.setIconLogo(Integer.valueOf(R.drawable.music_amazon_logo));
        musicAPPBean3.setSupport(bool2);
        musicAPPBean3.setInstalled(Boolean.valueOf(c(musicAPPBean3.getPackageName())));
        arrayList.add(musicAPPBean3);
        MusicAPPBean musicAPPBean4 = new MusicAPPBean();
        musicAPPBean4.setCheck(bool);
        musicAPPBean4.setPackageName("com.dywx.larkplayer");
        musicAPPBean4.setLabel("Lark Player");
        musicAPPBean4.setIconLogo(Integer.valueOf(R.drawable.music_larkplayer_logo));
        musicAPPBean4.setSupport(bool2);
        musicAPPBean4.setInstalled(Boolean.valueOf(c(musicAPPBean4.getPackageName())));
        arrayList.add(musicAPPBean4);
        MusicAPPBean musicAPPBean5 = new MusicAPPBean();
        musicAPPBean5.setCheck(bool);
        musicAPPBean5.setPackageName("com.spotify.music");
        musicAPPBean5.setLabel("Spotify");
        musicAPPBean5.setIconLogo(Integer.valueOf(R.drawable.music_label_spotify));
        musicAPPBean5.setSupport(bool);
        musicAPPBean5.setInstalled(Boolean.valueOf(c(musicAPPBean5.getPackageName())));
        arrayList.add(musicAPPBean5);
        if (c("com.tencent.qqmusic") || l()) {
            MusicAPPBean musicAPPBean6 = new MusicAPPBean();
            musicAPPBean6.setCheck(bool);
            musicAPPBean6.setPackageName("com.tencent.qqmusic");
            musicAPPBean6.setLabel("QQ音乐");
            musicAPPBean6.setSupport(bool2);
            musicAPPBean6.setIconLogo(Integer.valueOf(R.drawable.music_qq_logo));
            musicAPPBean6.setInstalled(Boolean.valueOf(c(musicAPPBean6.getPackageName())));
            arrayList.add(musicAPPBean6);
        }
        if (c("com.netease.cloudmusic") || l()) {
            MusicAPPBean musicAPPBean7 = new MusicAPPBean();
            musicAPPBean7.setCheck(bool);
            musicAPPBean7.setPackageName("com.netease.cloudmusic");
            musicAPPBean7.setLabel("网易云音乐");
            musicAPPBean7.setSupport(bool2);
            musicAPPBean7.setIconLogo(Integer.valueOf(R.drawable.music_netease_logo));
            musicAPPBean7.setInstalled(Boolean.valueOf(c(musicAPPBean7.getPackageName())));
            arrayList.add(musicAPPBean7);
        }
        if (c("com.kugou.android") || l()) {
            MusicAPPBean musicAPPBean8 = new MusicAPPBean();
            musicAPPBean8.setCheck(bool);
            musicAPPBean8.setPackageName("com.kugou.android");
            musicAPPBean8.setLabel("酷狗音乐");
            musicAPPBean8.setSupport(bool);
            musicAPPBean8.setInstalled(Boolean.valueOf(c(musicAPPBean8.getPackageName())));
            arrayList.add(musicAPPBean8);
        }
        if (c("cmccwm.mobilemusic") || l()) {
            MusicAPPBean musicAPPBean9 = new MusicAPPBean();
            musicAPPBean9.setCheck(bool);
            musicAPPBean9.setPackageName("cmccwm.mobilemusic");
            musicAPPBean9.setLabel("咪咕音乐");
            musicAPPBean9.setSupport(bool);
            musicAPPBean9.setInstalled(Boolean.valueOf(c(musicAPPBean9.getPackageName())));
            arrayList.add(musicAPPBean9);
        }
        return arrayList;
    }

    public void b(Context context) {
        try {
            ((NotificationManager) context.getSystemService("notification")).cancel(1009);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean c(String str) throws PackageManager.NameNotFoundException {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            MyApplication.H().getPackageManager().getPackageInfo(str, 0);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public long d() {
        return this.i;
    }

    public boolean e() {
        return this.g;
    }

    public List<MusicAPPBean> g() {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setDataAndType(Uri.parse("file://"), "audio/mp3");
        PackageManager packageManager = MyApplication.N().getPackageManager();
        List<ResolveInfo> listQueryIntentActivities = packageManager.queryIntentActivities(intent, 0);
        ArrayList arrayList = new ArrayList();
        for (ResolveInfo resolveInfo : listQueryIntentActivities) {
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            String str = activityInfo.packageName;
            String str2 = activityInfo.name;
            String string = resolveInfo.loadLabel(packageManager).toString();
            Drawable drawableLoadIcon = resolveInfo.loadIcon(packageManager);
            MusicAPPBean musicAPPBean = new MusicAPPBean();
            musicAPPBean.setClassName(str2);
            musicAPPBean.setLabel(string);
            musicAPPBean.setPackageName(str);
            musicAPPBean.setImageLogo(drawableLoadIcon);
            arrayList.add(musicAPPBean);
        }
        return arrayList;
    }

    public MusicAPPBean h() {
        MusicAPPBean musicAPPBean = new MusicAPPBean();
        List<MusicAPPBean> listA = a();
        ArrayList arrayList = new ArrayList(g());
        for (MusicAPPBean musicAPPBean2 : listA) {
            for (int i = 0; i < arrayList.size(); i++) {
                if (TextUtils.equals(musicAPPBean2.getPackageName(), ((MusicAPPBean) arrayList.get(i)).getPackageName()) && musicAPPBean2.getIsSupport().booleanValue()) {
                    musicAPPBean = musicAPPBean2;
                }
            }
        }
        return musicAPPBean;
    }

    public SongInformation i() {
        return this.j;
    }

    public long j() {
        return this.h;
    }

    public void k(boolean z) {
        this.g = z;
        h43 h43Var = this.c;
        if (h43Var != null) {
            h43Var.p(z);
        }
    }

    public boolean l() {
        return lg3.b(MyApplication.H()).equals("zh") || lg3.b(MyApplication.H()).equals("zh-tw");
    }

    public boolean n() {
        return this.a;
    }

    public boolean o() {
        return this.f;
    }

    public boolean p(Activity activity) {
        return activity != null && v(l, activity) && v(m, activity);
    }

    public void q(boolean z) {
        String str = "onReceiveIsPaly:" + z;
        i43 i43Var = this.d;
        if (i43Var != null) {
            i43Var.m0(z);
        }
    }

    public void r(SongInformation songInformation) {
        this.j = songInformation;
        Object obj = this.b;
        if (obj == null || !(obj instanceof Fragment) || ((Fragment) obj).isDetached()) {
            return;
        }
        this.b.b(songInformation);
    }

    public void t(String str) {
        if (MyApplication.H().getPackageManager().getLaunchIntentForPackage(str) != null) {
            ed0.j(MyApplication.H().getPackageManager().getLaunchIntentForPackage(str));
        } else {
            sg3.l("应用程序未安装");
        }
    }

    public void u(int i) {
        k43 k43Var = this.e;
        if (k43Var != null) {
            k43Var.Y2(i);
        }
    }

    public boolean v(String str, Activity activity) throws SecurityException {
        List<ActivityManager.RunningServiceInfo> runningServices = ((ActivityManager) activity.getSystemService(ActivityChooserModel.ATTRIBUTE_ACTIVITY)).getRunningServices(Integer.MAX_VALUE);
        if (runningServices.size() <= 0) {
            return false;
        }
        Iterator<ActivityManager.RunningServiceInfo> it = runningServices.iterator();
        while (it.hasNext()) {
            if (str.equals(it.next().service.getClassName())) {
                return true;
            }
        }
        return false;
    }

    public void w(long j) {
        this.i = j;
    }

    public void x(h43 h43Var) {
        this.c = h43Var;
    }

    public void y(i43 i43Var) {
        this.d = i43Var;
    }

    public void z(boolean z) {
        this.f = z;
    }
}
