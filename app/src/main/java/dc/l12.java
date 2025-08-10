package dc;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Looper;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.ValueCallback;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.common.net.HttpHeaders;
import com.koushikdutta.async.http.cache.ResponseCacheMiddleware;
import com.lovense.wear.R;
import com.spotify.sdk.android.auth.AuthorizationRequest;
import com.spotify.sdk.android.auth.AuthorizationResponse;
import com.spotify.sdk.android.player.Config;
import com.spotify.sdk.android.player.ConnectionStateCallback;
import com.spotify.sdk.android.player.Connectivity;
import com.spotify.sdk.android.player.Error;
import com.spotify.sdk.android.player.PlayerOperationCallback;
import com.spotify.sdk.android.player.SpotifyPlayer;
import com.spotify.sdk.android.player.SpotifyTrack;
import com.wear.bean.HomeMusicBean;
import com.wear.bean.Music;
import com.wear.bean.MusicPlaylist;
import com.wear.bean.SpotifySwapTokenBean;
import com.wear.bean.SpotifyTokenBean;
import com.wear.dao.DaoUtils;
import com.wear.dao.TestValueDao;
import com.wear.main.MainActivity;
import com.wear.main.closeRange.music.MusicControl;
import com.wear.main.closeRange.spotifyMusic.StreamMusicLoginActivity;
import com.wear.network.protocol.exception.NetException;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import dc.yc4;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.greenrobot.eventbus.EventBus;
import org.jivesoftware.smackx.xhtmlim.XHTMLText;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: SpotifyMusicAuthUtils.java */
/* loaded from: classes3.dex */
public abstract class l12 extends j12 implements ConnectionStateCallback {
    public static boolean u;
    public String e;
    public String f;
    public String g;
    public SpotifyPlayer h;
    public ac4 n;
    public final PlayerOperationCallback d = new PlayerOperationCallback();
    public List<Music> i = new ArrayList();
    public List<MusicPlaylist> j = new ArrayList();
    public List<MusicPlaylist> k = new ArrayList();
    public List<MusicPlaylist> l = new ArrayList();
    public final vc4 m = new vc4();
    public SpotifyTokenBean o = null;
    public Boolean p = Boolean.FALSE;
    public int q = 0;
    public WeakReference<k> r = null;
    public Runnable s = new c();
    public Runnable t = new g();

    /* compiled from: SpotifyMusicAuthUtils.java */
    public class a extends HashMap<String, String> {
        public final /* synthetic */ boolean val$finalFlag;

        public a(boolean z) {
            this.val$finalFlag = z;
            put("isLogin", z ? "1" : "0");
        }
    }

    /* compiled from: SpotifyMusicAuthUtils.java */
    public class b implements zn2<String> {
        public final /* synthetic */ AuthorizationResponse a;

        public b(AuthorizationResponse authorizationResponse) {
            this.a = authorizationResponse;
        }

        @Override // dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(String str) throws JSONException {
            if (WearUtils.e1(str)) {
                l12.this.r(WearUtils.a2());
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.optInt(XHTMLText.CODE, 499) == 200) {
                    SpotifySwapTokenBean spotifySwapTokenBean = (SpotifySwapTokenBean) WearUtils.A.fromJson(str, SpotifySwapTokenBean.class);
                    if (spotifySwapTokenBean != null) {
                        l12.this.o = new SpotifyTokenBean(spotifySwapTokenBean.getAccess_token(), spotifySwapTokenBean.getRefresh_token(), spotifySwapTokenBean.getExpires_in());
                        l12.m(0, WearUtils.A.toJson(l12.this.o));
                        l12 l12Var = l12.this;
                        l12Var.v(l12Var.o);
                        l12.this.y(spotifySwapTokenBean.getAccess_token(), false, false);
                    } else {
                        l12.this.r(WearUtils.a2());
                    }
                } else {
                    String string = jSONObject.getString("errorMsg");
                    if (WearUtils.e1(string)) {
                        l12.this.r(WearUtils.a2());
                    } else {
                        l12.this.r(string);
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        @Override // dc.zn2
        public void onError(NetException netException) {
            l12.this.r(this.a.d());
        }
    }

    /* compiled from: SpotifyMusicAuthUtils.java */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            xe3.a("SpotifyRefresh", "刷新定时任务开始执行");
            l12.this.F(true);
        }
    }

    /* compiled from: SpotifyMusicAuthUtils.java */
    public class d implements zn2<String> {
        public final /* synthetic */ boolean a;

        public d(boolean z) {
            this.a = z;
        }

        @Override // dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(String str) throws JSONException {
            if (WearUtils.e1(str)) {
                l12.this.r(WearUtils.a2());
                return;
            }
            xe3.a("SpotifyRefresh", "refreshToken 刷新成功");
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.optInt(XHTMLText.CODE, 499) == 200) {
                    SpotifySwapTokenBean spotifySwapTokenBean = (SpotifySwapTokenBean) WearUtils.A.fromJson(str, SpotifySwapTokenBean.class);
                    if (spotifySwapTokenBean != null) {
                        l12.this.o.refreshAccessToken(spotifySwapTokenBean.getAccess_token(), spotifySwapTokenBean.getExpires_in());
                        l12.m(0, WearUtils.A.toJson(l12.this.o));
                        l12 l12Var = l12.this;
                        l12Var.a.l.postDelayed(l12Var.s, (spotifySwapTokenBean.getExpires_in() - 300) * 1000);
                        if (l12.this.p.booleanValue()) {
                            l12.this.y(spotifySwapTokenBean.getAccess_token(), this.a, false);
                        }
                    } else {
                        l12.this.r(WearUtils.a2());
                    }
                } else {
                    String string = jSONObject.getString("errorMsg");
                    if (WearUtils.e1(string)) {
                        l12.this.r(WearUtils.a2());
                    } else {
                        l12.this.r(string);
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        @Override // dc.zn2
        public void onError(NetException netException) {
            l12.this.r(netException.getMessage());
        }
    }

    /* compiled from: SpotifyMusicAuthUtils.java */
    public class e implements SpotifyPlayer.InitializationObserver {
        public final /* synthetic */ boolean a;
        public final /* synthetic */ String b;
        public final /* synthetic */ boolean c;

        public e(boolean z, String str, boolean z2) {
            this.a = z;
            this.b = str;
            this.c = z2;
        }

        @Override // com.spotify.sdk.android.player.SpotifyPlayer.InitializationObserver
        public void onError(Throwable th) {
            String str = "Error in initialization: " + th.getMessage();
            xe3.a("SpotifyRefresh", "onAuthenticationComplete 登录失败！！ error = " + th.getMessage());
            l12.this.r(th.getMessage());
        }

        @Override // com.spotify.sdk.android.player.SpotifyPlayer.InitializationObserver
        public void onInitialized(SpotifyPlayer spotifyPlayer) {
            l12 l12Var = l12.this;
            if (l12Var.h == null) {
                l12Var.h = spotifyPlayer;
            }
            SpotifyPlayer spotifyPlayer2 = l12Var.h;
            if (spotifyPlayer2 == null) {
                WeakReference<k> weakReference = l12Var.r;
                if (weakReference == null || weakReference.get() == null) {
                    return;
                }
                l12.this.r.get().l(true);
                return;
            }
            PlayerOperationCallback playerOperationCallback = l12Var.d;
            playerOperationCallback.operation = "setConnectivityStatus";
            spotifyPlayer2.setConnectivityStatus(playerOperationCallback, l12Var.q(k12.m.b()));
            l12.this.h.addNotificationCallback(MusicControl.h0().e);
            l12.this.h.addConnectionStateCallback(MusicControl.h0().e);
            xe3.a("SpotifyRefresh", "onAuthenticationComplete 登录成功！！");
            if (this.a) {
                return;
            }
            l12.this.s(this.b, this.c);
        }
    }

    /* compiled from: SpotifyMusicAuthUtils.java */
    public class f implements bc4 {
        public final /* synthetic */ boolean a;

        /* compiled from: SpotifyMusicAuthUtils.java */
        public class a extends HashMap<String, String> {
            public a() {
                put("isPremium", "1");
            }
        }

        public f(boolean z) {
            this.a = z;
        }

        @Override // dc.bc4
        public void onFailure(ac4 ac4Var, IOException iOException) {
            String str = "onFailure: Failed to fetch data: " + iOException;
            WeakReference<k> weakReference = l12.this.r;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            l12.this.r.get().l(true);
        }

        @Override // dc.bc4
        public void onResponse(ac4 ac4Var, ad4 ad4Var) throws JSONException, IOException {
            try {
                JSONObject jSONObject = new JSONObject(ad4Var.b().string());
                System.out.println(jSONObject.toString(3));
                System.out.println("id>>>" + jSONObject.getString(TtmlNode.ATTR_ID));
                String string = jSONObject.getString(TtmlNode.ATTR_ID);
                String string2 = jSONObject.getString("product");
                MainActivity.d0 = true;
                EventBus.getDefault().post(new HomeMusicBean(5));
                if (!WearUtils.e1(string) && !WearUtils.e1(l12.this.f) && l12.this.f.equals(string) && !WearUtils.e1(string2) && !WearUtils.e1(l12.this.g) && l12.this.g.equals(string2) && this.a) {
                    xe3.a("SpotifyRefresh", "getUserId 获取用户信息成功 没有用户信息变化，不需要刷新列表 直接返回:");
                    return;
                }
                l12 l12Var = l12.this;
                l12Var.f = string;
                l12Var.g = string2;
                if (WearUtils.e1(string)) {
                    xe3.a("SpotifyRefresh", "getUserId 获取用户信息失败");
                    WeakReference<k> weakReference = l12.this.r;
                    if (weakReference != null && weakReference.get() != null) {
                        l12.this.r.get().l(true);
                    }
                } else {
                    xe3.a("SpotifyRefresh", "getUserId 获取用户信息成功:" + jSONObject);
                    WeakReference<k> weakReference2 = l12.this.r;
                    if (weakReference2 != null && weakReference2.get() != null) {
                        l12.this.r.get().i(true);
                    }
                }
                WearUtils.x.q("music_spotify_isPremium", new a());
            } catch (JSONException e) {
                String str = "onFailure: Failed to fetch data: " + e;
                xe3.a("SpotifyRefresh", "getUserId 获取用户信息失败(解析异常)" + e.getMessage());
                WeakReference<k> weakReference3 = l12.this.r;
                if (weakReference3 == null || weakReference3.get() == null) {
                    return;
                }
                l12.this.r.get().l(true);
            }
        }
    }

    /* compiled from: SpotifyMusicAuthUtils.java */
    public class g implements Runnable {
        public g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (MusicControl.h0().f == null || MusicControl.h0().f.getMusicType() != 1) {
                return;
            }
            l12.this.q = 0;
            l12.this.B(MusicControl.h0().f.getData());
        }
    }

    /* compiled from: SpotifyMusicAuthUtils.java */
    public class h extends HashMap<String, String> {
        public h() {
            put("isPremium", "0");
        }
    }

    /* compiled from: SpotifyMusicAuthUtils.java */
    public static /* synthetic */ class i {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[AuthorizationResponse.c.values().length];
            a = iArr;
            try {
                iArr[AuthorizationResponse.c.CODE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[AuthorizationResponse.c.TOKEN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[AuthorizationResponse.c.ERROR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* compiled from: SpotifyMusicAuthUtils.java */
    public class j extends Thread {
        public Context a;
        public final ValueCallback<Boolean> b;

        public j(l12 l12Var, Context context, ValueCallback<Boolean> valueCallback) {
            this.a = context;
            this.b = valueCallback;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Looper.prepare();
            if (Build.VERSION.SDK_INT >= 21) {
                CookieManager.getInstance().removeAllCookies(this.b);
            } else {
                CookieSyncManager cookieSyncManagerCreateInstance = CookieSyncManager.createInstance(this.a);
                cookieSyncManagerCreateInstance.startSync();
                CookieManager.getInstance().removeAllCookie();
                cookieSyncManagerCreateInstance.stopSync();
                ValueCallback<Boolean> valueCallback = this.b;
                if (valueCallback != null) {
                    valueCallback.onReceiveValue(Boolean.TRUE);
                }
            }
            Looper.loop();
        }
    }

    /* compiled from: SpotifyMusicAuthUtils.java */
    public interface k {
        void i(boolean z);

        void l(boolean z);
    }

    public static String m(int i2, String str) {
        if (i2 != 0) {
            if (i2 == 1) {
                DaoUtils.getTestValueDao().delete("spotifyTokenStatus", TestValueDao.SPOTIFY_TOKEN_DATA_TYPE);
                DaoUtils.getMusicSpotifyDao().deleteAll();
                EventBus.getDefault().post(new HomeMusicBean(9));
            } else if (i2 == 2) {
                return DaoUtils.getTestValueDao().getValue("spotifyTokenStatus", TestValueDao.SPOTIFY_TOKEN_DATA_TYPE);
            }
        } else if (!WearUtils.e1(str)) {
            DaoUtils.getTestValueDao().save("spotifyTokenStatus", str, TestValueDao.SPOTIFY_TOKEN_DATA_TYPE);
        }
        return "";
    }

    public static String p() {
        return nd3.a("mD2+fNi8MpMxv3xuovCbQm9GyvSu6bULAUCpAhHAlaH3nOXa9cY6Y7k+c7C9rEpW");
    }

    public void A() {
        xe3.a("SpotifyRefresh", "openLoginWindow 点击登录");
        this.p = Boolean.TRUE;
        String strM = m(2, "");
        if (!WearUtils.e1(strM)) {
            xe3.a("SpotifyRefresh", "openLoginWindow 数据库有账号信息前去判断时间，刷新或者直接登录");
            H(strM);
            return;
        }
        xe3.a("SpotifyRefresh", "openLoginWindow 数据库没有账号信息，跳转获取code");
        AuthorizationRequest.b bVar = new AuthorizationRequest.b(p(), AuthorizationResponse.c.CODE, "testschema://callback");
        bVar.b(new String[]{"streaming", "playlist-read-private", "playlist-read-collaborative", "user-follow-modify", "user-follow-read", "user-library-read", "user-top-read", "playlist-modify-public", "playlist-modify-private", "user-read-private"});
        AuthorizationRequest authorizationRequestA = bVar.a();
        if (MyApplication.H() == null || !(MyApplication.H() instanceof StreamMusicLoginActivity)) {
            return;
        }
        ze1.h(MyApplication.H(), 1337, authorizationRequestA);
    }

    public abstract void B(String str);

    public void C(k kVar) {
        this.r = new WeakReference<>(kVar);
        if (t()) {
            kVar.i(true);
        } else {
            A();
        }
    }

    public void D(k kVar) {
        this.r = new WeakReference<>(kVar);
        SpotifyPlayer spotifyPlayer = this.h;
        if (spotifyPlayer != null) {
            spotifyPlayer.logout();
        }
        this.f = "";
        this.g = "";
        this.a.l.removeCallbacks(this.s);
        m(1, "");
        if (!t()) {
            if (this.r != null) {
                kVar.i(false);
                return;
            }
            return;
        }
        SpotifyPlayer spotifyPlayer2 = this.h;
        if (spotifyPlayer2 != null) {
            spotifyPlayer2.logout();
        }
        if (this.r != null) {
            kVar.i(false);
        } else {
            kVar.l(false);
        }
        z();
    }

    public void E() {
        int i2;
        String strM = m(2, "");
        if (WearUtils.e1(strM) || (i2 = this.q) >= 2) {
            return;
        }
        this.q = i2 + 1;
        y(((SpotifyTokenBean) WearUtils.A.fromJson(strM, SpotifyTokenBean.class)).getAccess_token(), false, true);
        MusicControl.h0().b.removeCallbacks(this.t);
        MusicControl.h0().b.postDelayed(this.t, 1000L);
    }

    public final synchronized void F(boolean z) {
        if (this.o == null) {
            r(WearUtils.a2());
            return;
        }
        xe3.a("SpotifyRefresh", "refreshToken 刷新开始");
        HashMap map = new HashMap();
        map.put("refresh_token", this.o.getRefresh_token());
        tn2.x(WearUtils.x).t("/app/tokenRefresh", map, new d(z));
    }

    public void G() {
        SpotifyPlayer spotifyPlayer = this.h;
        if (spotifyPlayer != null) {
            spotifyPlayer.logout();
        }
        this.f = "";
        this.g = "";
        w();
    }

    public void H(String str) {
        this.o = (SpotifyTokenBean) WearUtils.A.fromJson(str, SpotifyTokenBean.class);
        long time = be3.I().getTime();
        this.a.l.removeCallbacks(this.s);
        if (time > this.o.getOverdueTime()) {
            xe3.a("SpotifyRefresh", "setRefreshToken 当前时间已经超过token有效时间,马上刷新");
            F(false);
            return;
        }
        long overdueTime = this.o.getOverdueTime() - time;
        xe3.a("SpotifyRefresh", "setRefreshToken remainingTime=" + (overdueTime / 1000));
        if (overdueTime <= 300000) {
            xe3.a("SpotifyRefresh", "setRefreshToken 不到五分钟就要过期，马上刷新");
            F(false);
            return;
        }
        long j2 = overdueTime - 300000;
        this.a.l.postDelayed(this.s, j2);
        xe3.a("SpotifyRefresh", "setRefreshToken 设置定时器执行刷新  " + (j2 / 1000) + "秒后执行");
        if (this.p.booleanValue()) {
            xe3.a("SpotifyRefresh", "setRefreshToken 设置定时器执行刷新  并且是登录，直接登录");
            y(this.o.getAccess_token(), false, false);
        }
    }

    public void l() {
    }

    public void n(Context context) {
        File[] fileArrListFiles;
        File[] fileArrListFiles2;
        try {
            context.getDatabasePath("webview.db").deleteOnExit();
            context.getDatabasePath("webviewCache.db").deleteOnExit();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        File file = new File(context.getFilesDir().getAbsolutePath() + "/webcache");
        String str = "appCacheDir path=" + file.getAbsolutePath();
        File file2 = new File(context.getCacheDir().getAbsolutePath() + "/webviewCache");
        String str2 = "webviewCacheDir path=" + file2.getAbsolutePath();
        if (file2.exists()) {
            o(file2);
        }
        if (file.exists()) {
            o(file);
        }
        try {
            String absolutePath = context.getFilesDir().getAbsolutePath();
            File file3 = new File(absolutePath.substring(0, absolutePath.lastIndexOf("/")));
            if (file3.isDirectory() && (fileArrListFiles = file3.listFiles()) != null) {
                for (File file4 : fileArrListFiles) {
                    if (!WearUtils.e1(file4.getName()) && file4.getName().toLowerCase().indexOf("webview") != -1) {
                        o(file4);
                    } else if (!WearUtils.e1(file4.getName()) && file4.getName().toLowerCase().indexOf(ResponseCacheMiddleware.CACHE) != -1 && (fileArrListFiles2 = file4.listFiles()) != null) {
                        for (File file5 : fileArrListFiles2) {
                            if (!WearUtils.e1(file5.getName()) && file5.getName().toLowerCase().indexOf("webview") != -1) {
                                o(file5);
                            } else if (!WearUtils.e1(file5.getName()) && file5.getName().toLowerCase().indexOf("chromium") != -1) {
                                o(file5);
                            }
                        }
                    }
                }
            }
        } catch (Exception unused) {
        }
        new j(this, context, null).start();
    }

    public void o(File file) {
        String str = "delete file path=" + file.getAbsolutePath();
        if (!file.exists()) {
            String str2 = "delete file no exists " + file.getAbsolutePath();
            return;
        }
        if (file.isFile()) {
            file.delete();
        } else if (file.isDirectory()) {
            for (File file2 : file.listFiles()) {
                o(file2);
            }
        }
        file.delete();
    }

    @Override // com.spotify.sdk.android.player.ConnectionStateCallback
    public void onConnectionMessage(String str) {
        String str2 = "Incoming connection message: " + str;
    }

    @Override // com.spotify.sdk.android.player.ConnectionStateCallback
    public void onLoggedIn() {
    }

    @Override // com.spotify.sdk.android.player.ConnectionStateCallback
    public void onLoggedOut() {
    }

    @Override // com.spotify.sdk.android.player.ConnectionStateCallback
    public void onLoginFailed(Error error) {
        String str = "Login error " + error;
        if (k12.m != null) {
            WeakReference<k> weakReference = this.r;
            if (weakReference != null && weakReference.get() != null) {
                this.r.get().l(true);
            }
            if (error == null || error != Error.kSpErrorNeedsPremium) {
                sg3.k(k12.m.b(), error.toString());
            } else {
                sg3.i(k12.m.b(), R.string.spotify_premium_supported);
                WearUtils.x.q("music_spotify_isPremium", new h());
            }
        }
    }

    @Override // com.spotify.sdk.android.player.ConnectionStateCallback
    public void onTemporaryError() {
    }

    public Connectivity q(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) ? Connectivity.OFFLINE : Connectivity.fromNetworkType(activeNetworkInfo.getType());
    }

    public final void r(String str) {
        if (this.p.booleanValue()) {
            WeakReference<k> weakReference = this.r;
            if (weakReference == null || weakReference.get() == null) {
                g12 g12Var = k12.m;
                if (g12Var != null) {
                    sg3.f(g12Var.b(), str);
                }
            } else {
                this.r.get().l(true);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("登录失败！！！");
        sb.append(this.p.booleanValue() ? "已登录过" : "没有登录过");
        xe3.a("SpotifyRefresh", sb.toString());
        this.a.l.removeCallbacks(this.s);
        m(1, "");
    }

    public final void s(String str, boolean z) {
        xe3.a("SpotifyRefresh", "getUserId 获取用户信息");
        this.e = str;
        yc4.a aVar = new yc4.a();
        aVar.k("https://api.spotify.com/v1/me");
        aVar.a(HttpHeaders.AUTHORIZATION, "Bearer " + this.e);
        yc4 yc4VarB = aVar.b();
        l();
        ac4 ac4VarA = this.m.a(yc4VarB);
        this.n = ac4VarA;
        ac4VarA.j(new f(z));
    }

    public boolean t() {
        boolean z;
        SpotifyPlayer spotifyPlayer = this.h;
        boolean z2 = false;
        if (spotifyPlayer == null || spotifyPlayer.getPlaybackState() == null || !this.h.getPlaybackState().isActiveDevice) {
            z = false;
        } else {
            System.out.println("mPlayer.getPlaybackState().isActiveDevice=" + this.h.getPlaybackState().isActiveDevice);
            z = true;
        }
        if (!z) {
            SpotifyPlayer spotifyPlayer2 = this.h;
            if (spotifyPlayer2 != null && spotifyPlayer2.isLoggedIn()) {
                z2 = true;
            }
            z = z2;
        }
        WearUtils.x.q("music_spotify_isLogin", new a(z));
        return z;
    }

    public boolean u() {
        return (WearUtils.e1(this.f) || WearUtils.e1(this.g) || !this.g.equals("premium")) ? false : true;
    }

    public void v(SpotifyTokenBean spotifyTokenBean) {
        this.o = spotifyTokenBean;
        long time = be3.I().getTime();
        this.a.l.removeCallbacks(this.s);
        if (time > this.o.getOverdueTime()) {
            xe3.a("SpotifyRefresh", "loginSuccessSetRefreshToken 当前时间已经超过token有效时间,马上刷新");
            F(false);
            return;
        }
        long overdueTime = this.o.getOverdueTime() - time;
        xe3.a("SpotifyRefresh", "loginSuccessSetRefreshToken remainingTime=" + (overdueTime / 1000));
        if (overdueTime <= 300000) {
            xe3.a("SpotifyRefresh", "loginSuccessSetRefreshToken 不到五分钟就要过期，马上刷新");
            F(false);
            return;
        }
        long j2 = overdueTime - 300000;
        this.a.l.postDelayed(this.s, j2);
        xe3.a("SpotifyRefresh", "loginSuccessSetRefreshToken 设置定时器执行刷新  " + (j2 / 1000) + "秒后执行");
    }

    public void w() {
        this.i.clear();
        this.j.clear();
        this.k.clear();
        this.l.clear();
    }

    public void x(int i2, int i3, Intent intent) {
        if (i2 == 1337) {
            AuthorizationResponse authorizationResponseG = ze1.g(i3, intent);
            if (authorizationResponseG == null) {
                sg3.i(k12.m.b(), R.string.common_serverError);
                return;
            }
            int i4 = i.a[authorizationResponseG.e().ordinal()];
            if (i4 == 1) {
                HashMap map = new HashMap();
                map.put(XHTMLText.CODE, authorizationResponseG.c());
                tn2.x(WearUtils.x).t("/app/tokenSwap", map, new b(authorizationResponseG));
                return;
            }
            if (i4 == 2) {
                y(authorizationResponseG.b(), false, false);
                return;
            }
            if (i4 != 3) {
                String str = "Auth result: " + authorizationResponseG.e();
                return;
            }
            String str2 = "Auth error: " + authorizationResponseG.d();
            WeakReference<k> weakReference = this.r;
            if (weakReference != null && weakReference.get() != null) {
                this.r.get().l(true);
                return;
            }
            g12 g12Var = k12.m;
            if (g12Var != null) {
                sg3.f(g12Var.b(), authorizationResponseG.d());
            }
        }
    }

    public final void y(String str, boolean z, boolean z2) {
        xe3.a("SpotifyRefresh", "onAuthenticationComplete 开始登录");
        SpotifyPlayer spotifyPlayer = this.h;
        if (spotifyPlayer == null) {
            xe3.a("SpotifyRefresh", "onAuthenticationComplete 登录 mPlayer为空,登录生成新的");
            this.h = SpotifyTrack.getPlayer(new Config(this.a, str, p()), this, new e(z2, str, z));
            return;
        }
        if (spotifyPlayer != null) {
            spotifyPlayer.login(str);
        }
        xe3.a("SpotifyRefresh", "onAuthenticationComplete 登录 mPlayer不为空，直接使用token getUserId");
        if (z2) {
            return;
        }
        s(str, z);
    }

    public abstract void z();
}
