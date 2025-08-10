package com.wear.util;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.media.RingtoneManager;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.opengl.GLES32;
import android.os.BatteryManager;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import androidx.multidex.MultiDexExtractor;
import com.epicgames.unreal.psoservices.PSOProgramService;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.vending.expansion.downloader.Constants;
import com.google.common.base.Ascii;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.google.firebase.crashlytics.internal.settings.SettingsJsonConstants;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.huawei.hms.framework.common.ContainerUtils;
import com.j256.ormlite.android.apptools.OrmLiteConfigUtil;
import com.j256.ormlite.stmt.query.SimpleComparison;
import com.koushikdutta.async.http.cache.ResponseCacheMiddleware;
import com.lovense.wear.R;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;
import com.wear.bean.Account;
import com.wear.bean.DomainBean;
import com.wear.bean.FavoriteEmojisBean;
import com.wear.bean.IpBean;
import com.wear.bean.PatternHead;
import com.wear.bean.Toy;
import com.wear.bean.User;
import com.wear.bean.XYBean;
import com.wear.bean.handlerbean.IPeopleInfo;
import com.wear.dao.DaoUtils;
import com.wear.dao.TestValueDao;
import com.wear.main.closeRange.PatternPlayActivity;
import com.wear.main.closeRange.RemoteControlActivity;
import com.wear.main.closeRange.RemoteMultiControlActivity;
import com.wear.main.closeRange.alarm.AlarmSoundPlayActivity;
import com.wear.main.patterns.CreatePatternActivity;
import com.wear.protocol.CommunMessage;
import com.wear.protocol.EntityAudio;
import com.wear.protocol.EntityBurnShortVideo;
import com.wear.protocol.EntityPicture;
import com.wear.protocol.EntityShortVideo;
import com.wear.protocol.MessageType;
import com.wear.ui.home.sound.SoundPlayActivity;
import com.wear.util.WearUtils;
import com.wear.widget.control.FingImageLayout;
import com.wear.widget.control.TouchControlView;
import dc.ae3;
import dc.ah4;
import dc.be3;
import dc.bg3;
import dc.bh3;
import dc.ch3;
import dc.eg3;
import dc.ff3;
import dc.lg3;
import dc.pe3;
import dc.pf3;
import dc.qe3;
import dc.sg3;
import dc.ue2;
import dc.vd0;
import dc.vg3;
import dc.vz;
import dc.ye3;
import dc.zb2;
import dc.zd3;
import io.agora.rtc2.internal.AudioRoutingController;
import io.agora.rtc2.internal.CommonUtility;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;
import java.util.UUID;
import java.util.regex.Pattern;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import org.aspectj.runtime.reflect.SignatureImpl;
import org.jivesoftware.smack.sm.packet.StreamManagement;
import org.jivesoftware.smackx.xhtmlim.XHTMLText;

/* loaded from: classes4.dex */
public class WearUtils {
    public static Gson A;
    public static String H;
    public static String I;
    public static String J;
    public static String K;
    public static qe3 N;
    public static XYBean P;
    public static String c;
    public static String d;
    public static String e;
    public static String f;
    public static String g;
    public static String h;
    public static String i;
    public static String j;
    public static String k;
    public static String l;
    public static int m;
    public static boolean n;
    public static String o;
    public static String p;
    public static String q;
    public static String r;
    public static String s;
    public static String t;
    public static MyApplication x;
    public static ch3 y;
    public static final String a = u("b2ZmbGluZUVtYWlsQGh5dHRvLmNvbQ==");
    public static final Object b = new Object();
    public static String u = null;
    public static boolean v = false;
    public static String w = OrmLiteConfigUtil.RESOURCE_DIR_NAME;
    public static String z = "!!!";
    public static boolean B = false;
    public static boolean C = false;
    public static boolean D = false;
    public static List<FavoriteEmojisBean> E = new ArrayList();
    public static List<Activity> F = new ArrayList();
    public static ScreenReceiver G = null;
    public static HashMap<String, CommunMessage> L = new HashMap<>();
    public static boolean M = true;
    public static bg3 O = null;

    public static class ScreenReceiver extends BroadcastReceiver {
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
        }
    }

    public class a extends SimpleImageLoadingListener {
        public final /* synthetic */ ff3 a;

        public a(ff3 ff3Var) {
            this.a = ff3Var;
        }

        @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
        public void onLoadingComplete(String str, View view, Bitmap bitmap) {
            System.out.println("imageUri:" + str);
            if (WearUtils.e1(str)) {
                return;
            }
            this.a.b(true, str);
        }

        @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
        public void onLoadingFailed(String str, View view, FailReason failReason) {
            System.out.println("error:imageUri:" + str);
        }
    }

    public class b extends ff3 {
        public final /* synthetic */ User a;

        public b(User user) {
            this.a = user;
        }

        @Override // dc.ff3
        public void b(boolean z, Object obj) {
            if (!z || obj == null) {
                return;
            }
            this.a.setAvatarBitmapUrl(String.valueOf(obj));
        }
    }

    public class c extends ff3 {
        public final /* synthetic */ Account a;

        public c(Account account) {
            this.a = account;
        }

        @Override // dc.ff3
        public void b(boolean z, Object obj) {
            if (!z || obj == null) {
                return;
            }
            this.a.setAvatarBitmapUrl(String.valueOf(obj));
        }
    }

    public class d extends SimpleImageLoadingListener {
        public final /* synthetic */ ImageView a;

        public d(ImageView imageView) {
            this.a = imageView;
        }

        @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
        public void onLoadingComplete(String str, View view, Bitmap bitmap) {
            this.a.setImageBitmap(bitmap);
        }

        @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
        public void onLoadingFailed(String str, View view, FailReason failReason) {
            this.a.setImageResource(R.drawable.icon_default_new);
        }

        @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
        public void onLoadingStarted(String str, View view) {
        }
    }

    public class e extends SimpleImageLoadingListener {
        public final /* synthetic */ ImageView a;
        public final /* synthetic */ LinearLayout b;

        public e(ImageView imageView, LinearLayout linearLayout) {
            this.a = imageView;
            this.b = linearLayout;
        }

        @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
        public void onLoadingComplete(String str, View view, Bitmap bitmap) {
            this.a.setImageBitmap(bitmap);
            this.b.setVisibility(8);
        }

        @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
        public void onLoadingFailed(String str, View view, FailReason failReason) {
            this.a.setImageResource(R.drawable.chat_avatar_default);
            this.b.setVisibility(0);
        }

        @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
        public void onLoadingStarted(String str, View view) {
        }
    }

    public static /* synthetic */ class f {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[MessageType.values().length];
            a = iArr;
            try {
                iArr[MessageType.audio.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[MessageType.picture.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[MessageType.burnpicture.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[MessageType.shortvideo.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[MessageType.burnvideo.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public static class g implements InputFilter {
        @Override // android.text.InputFilter
        public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
            while (i < i2) {
                int type = Character.getType(charSequence.charAt(i));
                if (type == 19 || type == 28) {
                    return "";
                }
                i++;
            }
            return null;
        }
    }

    static {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Date.class, new ae3());
        gsonBuilder.registerTypeAdapter(MessageType.class, new bh3());
        gsonBuilder.disableHtmlEscaping();
        A = gsonBuilder.create();
    }

    public static void A(String str) {
        File file;
        File file2;
        try {
            List<CommunMessage> listFindAllMessageWithMedia = TextUtils.isEmpty(str) ? DaoUtils.getCommunMessageDao().findAllMessageWithMedia() : DaoUtils.getCommunMessageDao().findAllMessageWithMedia(y.p(), str);
            for (int i2 = 0; i2 < listFindAllMessageWithMedia.size(); i2++) {
                CommunMessage communMessage = listFindAllMessageWithMedia.get(i2);
                communMessage.setDataBean(communMessage.syncDecryptBean());
                File file3 = null;
                if (communMessage.getDataBean() == null) {
                    file = null;
                } else {
                    int i3 = f.a[communMessage.getType().ordinal()];
                    if (i3 == 1) {
                        file2 = new File(new EntityAudio(communMessage.getData()).getLocalUrl());
                    } else if (i3 == 2 || i3 == 3) {
                        file2 = c0(new EntityPicture(communMessage.getData()).getLocalUrl());
                    } else if (i3 == 4) {
                        EntityShortVideo entityShortVideo = new EntityShortVideo(communMessage.getData());
                        file3 = new File(entityShortVideo.getVideoLocalUrl());
                        file = new File(entityShortVideo.getPicLocalUrl());
                    } else if (i3 != 5) {
                        file = null;
                    } else {
                        EntityBurnShortVideo entityBurnShortVideo = new EntityBurnShortVideo(communMessage.getData());
                        file3 = new File(entityBurnShortVideo.getVideoLocalUrl());
                        file = new File(entityBurnShortVideo.getPicLocalUrl());
                    }
                    file3 = file2;
                    file = null;
                }
                vd0.d(file3);
                vd0.d(file);
            }
        } catch (Exception e2) {
            FirebaseCrashlytics.getInstance().recordException(e2);
        }
    }

    public static String A0(String str) {
        return !e1(str) ? str.split("@")[0] : str;
    }

    public static /* synthetic */ void A1(String str, ff3 ff3Var) throws IOException {
        File fileG = g(str.replace("-api", ""));
        if (fileG == null) {
            ff3Var.b(false, null);
            return;
        }
        if (fileG.exists()) {
            ff3Var.b(true, fileG);
            return;
        }
        File fileG2 = g(str);
        if (fileG2 == null) {
            ff3Var.b(false, null);
            return;
        }
        if (fileG2.exists()) {
            ff3Var.b(true, fileG2);
            return;
        }
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setConnectTimeout(5000);
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setDoInput(true);
            if (httpURLConnection.getResponseCode() != 200) {
                ff3Var.b(false, null);
                ff3Var.c(false, Integer.valueOf(httpURLConnection.getResponseCode()), httpURLConnection.getResponseMessage());
                return;
            }
            InputStream inputStream = httpURLConnection.getInputStream();
            FileOutputStream fileOutputStream = new FileOutputStream(fileG2);
            byte[] bArr = new byte[1024];
            while (true) {
                int i2 = inputStream.read(bArr);
                if (i2 == -1) {
                    inputStream.close();
                    fileOutputStream.close();
                    ff3Var.b(true, fileG2);
                    return;
                }
                fileOutputStream.write(bArr, 0, i2);
            }
        } catch (Exception unused) {
            ff3Var.b(false, null);
        }
    }

    public static void A2() {
        w = "pre";
        d = x.getString(R.string.app_domain_api);
        c = x.getString(R.string.app_domain_host_api);
        m = Integer.parseInt(x.getString(R.string.app_port_api));
        n = y1(x.getString(R.string.app_ssl_api));
        e = x.getString(R.string.app_server_api);
        f = x.getString(R.string.app_date_server_api);
        g = x.getString(R.string.app_surfease_server_api);
        h = x.getString(R.string.log_server_api);
        x.getString(R.string.ws_domain_api);
        i = x.getString(R.string.orgy_domain_api);
        k = x.getString(R.string.office_website_domain);
        l = x.getString(R.string.control_link_domain);
        v = true;
        y1(x.getString(R.string.control_crashLogFile_sendSwitch));
        j = x.getString(R.string.vb_reported_domin);
        if (MyApplication.H() != null) {
            sg3.f(MyApplication.H(), "Switched to api2 Environment");
        }
    }

    public static String B(String str) {
        if (e1(str)) {
            str = "";
        }
        return new String(Base64.encode(str.getBytes(), 2));
    }

    public static File B0() {
        File file = new File(Environment.getExternalStorageState().equals("mounted") ? x.getExternalFilesDir(null) : x.getFilesDir(), "RemoteCrash");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static /* synthetic */ void B1(ue2.a aVar, File file) {
        if (aVar != null) {
            aVar.b(file);
        }
    }

    public static void B2() {
        w = "pre2";
        d = x.getString(R.string.app_domain_apps);
        c = x.getString(R.string.app_domain_host_apps);
        m = Integer.parseInt(x.getString(R.string.app_port_apps));
        n = y1(x.getString(R.string.app_ssl_apps));
        e = x.getString(R.string.app_server_apps);
        f = x.getString(R.string.app_date_server_apps);
        g = x.getString(R.string.app_surfease_server_apps);
        h = x.getString(R.string.log_server_apps);
        x.getString(R.string.ws_domain_apps);
        i = x.getString(R.string.orgy_domain_apps);
        k = x.getString(R.string.office_website_domain);
        l = x.getString(R.string.control_link_domain);
        v = false;
        y1(x.getString(R.string.control_crashLogFile_sendSwitch));
        j = x.getString(R.string.vb_reported_domin);
        if (MyApplication.H() != null) {
            sg3.f(MyApplication.H(), "Switched to apps Environment");
        }
    }

    public static void C(Activity activity) {
        Window window = activity.getWindow();
        window.getDecorView().setSystemUiVisibility(1280);
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(0);
    }

    public static int C0(String str) {
        if (e1(str)) {
            return 0;
        }
        if (str.indexOf(SignatureImpl.INNER_SEP) > 0 && str.length() == 5 && q1(str.substring(0, str.indexOf(SignatureImpl.INNER_SEP))) && q1(str.substring(str.indexOf(SignatureImpl.INNER_SEP) + 1))) {
            return (Integer.parseInt(str.substring(0, str.indexOf(SignatureImpl.INNER_SEP))) * 60) + Integer.parseInt(str.substring(str.indexOf(SignatureImpl.INNER_SEP) + 1));
        }
        return -1;
    }

    public static /* synthetic */ void C1(ue2.a aVar) {
        if (aVar != null) {
            aVar.a(-1, null);
        }
    }

    public static void C2() {
        w = OrmLiteConfigUtil.RESOURCE_DIR_NAME;
        d = x.getString(R.string.app_domain);
        c = x.getString(R.string.app_domain_host);
        m = Integer.parseInt(x.getString(R.string.app_port));
        n = y1(x.getString(R.string.app_ssl));
        e = x.getString(R.string.app_server);
        f = x.getString(R.string.app_date_server);
        g = x.getString(R.string.app_surfease_server);
        h = x.getString(R.string.log_server);
        x.getString(R.string.ws_domain);
        i = x.getString(R.string.orgy_domain);
        k = x.getString(R.string.office_website_domain);
        l = x.getString(R.string.control_link_domain);
        v = false;
        y1(x.getString(R.string.control_crashLogFile_sendSwitch));
        j = x.getString(R.string.vb_reported_domin);
        e();
    }

    public static String D(int i2) {
        String[] strArr = {"0", "1", "2", ExifInterface.GPS_MEASUREMENT_3D, "4", "5", "6", "7", "8", "9", "a", "b", "c", GoogleApiAvailabilityLight.TRACKING_SOURCE_DIALOG, "e", "f", "g", XHTMLText.H, "i", "j", "k", "l", "m", GoogleApiAvailabilityLight.TRACKING_SOURCE_NOTIFICATION, "o", "p", XHTMLText.Q, StreamManagement.AckRequest.ELEMENT, "s", "t", "u", PSOProgramService.VS_Key, "w", "x", FingImageLayout.ObjectAnimatorY, "z", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "C", "D", ExifInterface.LONGITUDE_EAST, "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", ExifInterface.LATITUDE_SOUTH, ExifInterface.GPS_DIRECTION_TRUE, "U", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, ExifInterface.LONGITUDE_WEST, "X", "Y", "Z"};
        if (i2 <= 0) {
            throw new IllegalArgumentException("Illegal Argument: num should not less than 0");
        }
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i3 = 0; i3 < i2; i3++) {
            sb.append(strArr[random.nextInt(62)]);
        }
        return sb.toString();
    }

    public static void D0(boolean z2, final String str, final ff3 ff3Var) {
        if (z2) {
            str = e + str;
        }
        vg3.b().a(new Runnable() { // from class: dc.gd3
            @Override // java.lang.Runnable
            public final void run() throws IOException {
                WearUtils.z1(str, ff3Var);
            }
        });
    }

    public static /* synthetic */ void D1(ue2.a aVar) {
        if (aVar != null) {
            aVar.a(-1, null);
        }
    }

    public static void D2() {
        w = "test";
        d = x.getString(R.string.app_domain_t);
        c = x.getString(R.string.app_domain_host_t);
        m = Integer.parseInt(x.getString(R.string.app_port_t));
        n = y1(x.getString(R.string.app_ssl_t));
        e = x.getString(R.string.app_server_t);
        f = x.getString(R.string.app_date_server_t);
        g = x.getString(R.string.app_surfease_server_t);
        h = x.getString(R.string.log_server_t);
        x.getString(R.string.ws_domain_t);
        i = x.getString(R.string.orgy_domain_t);
        k = x.getString(R.string.office_website_domain_t);
        l = x.getString(R.string.control_link_domain_t);
        v = true;
        y1(x.getString(R.string.control_crashLogFile_sendSwitch));
        j = x.getString(R.string.app_server_t);
        if (MyApplication.H() != null) {
            sg3.f(MyApplication.H(), "Switched to Test Environment");
        }
    }

    public static String E() {
        return UUID.randomUUID().toString().replaceAll(Constants.FILENAME_SEQUENCE_SEPARATOR, "");
    }

    public static void E0(boolean z2, final String str, final ff3 ff3Var) {
        if (e1(str)) {
            return;
        }
        if (z2) {
            if (str.charAt(0) == '/') {
                str = e + str;
            } else {
                str = e + "/" + str;
            }
        }
        vg3.b().a(new Runnable() { // from class: dc.ld3
            @Override // java.lang.Runnable
            public final void run() throws IOException {
                WearUtils.A1(str, ff3Var);
            }
        });
    }

    public static /* synthetic */ void E1(ue2.a aVar) {
        if (aVar != null) {
            aVar.a(-1, null);
        }
    }

    public static String E2(String str) {
        return str == null ? "" : str.trim();
    }

    public static String F(String str) {
        if (!e1(str)) {
            if (str.endsWith("#test14")) {
                return "#test14";
            }
            if (str.endsWith("#pre777")) {
                return "#pre777";
            }
            if (str.endsWith("#testapi2")) {
                return "#testapi2";
            }
            if (str.endsWith("#testapps")) {
                return "#testapps";
            }
            if (str.endsWith("#res777")) {
                return "#res777";
            }
            if (str.endsWith("#test")) {
                return "#test";
            }
        }
        return "";
    }

    @SuppressLint({"StringFormatInvalid"})
    public static String F0(Date date) {
        if (date == null) {
            return null;
        }
        long timeInMillis = (Calendar.getInstance().getTimeInMillis() - date.getTime()) / 1000;
        return timeInMillis < 3 ? ah4.e(R.string.data_distance_just) : timeInMillis < 60 ? String.format(ah4.e(R.string.data_distance_second), Long.valueOf(timeInMillis)) : timeInMillis < 120 ? String.format(ah4.e(R.string.data_distance_minute), 1) : timeInMillis < 3600 ? String.format(ah4.e(R.string.data_distance_minutes), Integer.valueOf((int) (timeInMillis / 60))) : a1(date, 0) ? x2(date) : a1(date, 1) ? ah4.e(R.string.yesterday) : DateFormat.getDateInstance(2, lg3.e(x)).format(date);
    }

    public static /* synthetic */ void F1(String str, String str2, Handler handler, final ue2.a aVar) throws Throwable {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setConnectTimeout(5000);
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setDoInput(true);
            if (httpURLConnection.getResponseCode() != 200) {
                handler.post(new Runnable() { // from class: dc.md3
                    @Override // java.lang.Runnable
                    public final void run() {
                        WearUtils.D1(aVar);
                    }
                });
                return;
            }
            InputStream inputStream = httpURLConnection.getInputStream();
            final File fileE0 = e0("pattern/" + str2);
            if (!fileE0.exists()) {
                try {
                    fileE0.createNewFile();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
            FileOutputStream fileOutputStream = new FileOutputStream(fileE0);
            byte[] bArr = new byte[1024];
            while (true) {
                int i2 = inputStream.read(bArr);
                if (i2 == -1) {
                    break;
                } else {
                    fileOutputStream.write(bArr, 0, i2);
                }
            }
            inputStream.close();
            fileOutputStream.close();
            String strN1 = N1(fileE0.getPath());
            if (!e1(strN1) && !strN1.contains("result")) {
                handler.post(new Runnable() { // from class: dc.kd3
                    @Override // java.lang.Runnable
                    public final void run() {
                        WearUtils.B1(aVar, fileE0);
                    }
                });
            } else {
                fileE0.delete();
                handler.post(new Runnable() { // from class: dc.jd3
                    @Override // java.lang.Runnable
                    public final void run() {
                        WearUtils.C1(aVar);
                    }
                });
            }
        } catch (Exception unused) {
            handler.post(new Runnable() { // from class: dc.hd3
                @Override // java.lang.Runnable
                public final void run() {
                    WearUtils.E1(aVar);
                }
            });
        }
    }

    public static String F2() {
        return x != null ? ah4.e(R.string.common_upload_large_error) : "Unable to connect to the server";
    }

    public static synchronized List<IpBean> G() {
        ArrayList arrayList;
        try {
            arrayList = new ArrayList();
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress inetAddressNextElement = inetAddresses.nextElement();
                    if (!inetAddressNextElement.isLoopbackAddress()) {
                        String str = "   getHostAddress=" + inetAddressNextElement.getHostAddress() + "   isLinkLocalAddress=" + inetAddressNextElement.isLinkLocalAddress() + "   isLoopbackAddress=" + inetAddressNextElement.isLoopbackAddress() + "   isSiteLocalAddress=" + inetAddressNextElement.isSiteLocalAddress() + "   isMulticastAddress=" + inetAddressNextElement.isMulticastAddress() + "   isMCGlobal=" + inetAddressNextElement.isMCGlobal() + "   isMCLinkLocal=" + inetAddressNextElement.isMCLinkLocal() + "   isMCNodeLocal=" + inetAddressNextElement.isMCNodeLocal() + "   isMCSiteLocal=" + inetAddressNextElement.isMCSiteLocal() + "   isAnyLocalAddress=" + inetAddressNextElement.isAnyLocalAddress();
                        arrayList.add(new IpBean(inetAddressNextElement.getHostAddress(), inetAddressNextElement instanceof Inet6Address, inetAddressNextElement.isLoopbackAddress(), inetAddressNextElement.isLinkLocalAddress()));
                    }
                }
            }
        } catch (Exception e2) {
            e2.toString();
            return null;
        }
        return arrayList;
    }

    public static String G0(List<IpBean> list) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            try {
                IpBean ipBean = list.get(i2);
                if (!ipBean.isLoopbackAddress() && ipBean.isIpv6()) {
                    if (ipBean.getIpAddress().startsWith("fd")) {
                        return ipBean.getIpAddress();
                    }
                    if (ipBean.getIpAddress().startsWith("fc")) {
                        return ipBean.getIpAddress();
                    }
                    if (ipBean.getIpAddress().startsWith("fec")) {
                        return ipBean.getIpAddress();
                    }
                    if (ipBean.getIpAddress().startsWith("fed")) {
                        return ipBean.getIpAddress();
                    }
                    if (ipBean.getIpAddress().startsWith("fee")) {
                        return ipBean.getIpAddress();
                    }
                    if (ipBean.getIpAddress().startsWith("fef")) {
                        return ipBean.getIpAddress();
                    }
                    if (ipBean.getIpAddress().endsWith("%wlan0")) {
                        return ipBean.getIpAddress();
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                return "";
            }
        }
        return "";
    }

    public static String G1(Collection collection, String str) {
        if (g1(collection)) {
            return "";
        }
        Iterator it = collection.iterator();
        if (!it.hasNext()) {
            return "";
        }
        Object next = it.next();
        if (!it.hasNext()) {
            return next == null ? "" : next.toString();
        }
        if (e1(str)) {
            str = ";";
        }
        StringBuilder sb = new StringBuilder();
        if (next != null) {
            sb.append(next);
        }
        while (it.hasNext()) {
            sb.append(str);
            Object next2 = it.next();
            if (next2 != null) {
                sb.append(next2);
            }
        }
        return sb.toString();
    }

    public static boolean G2(String str) {
        return Pattern.compile("^(\\w)+([\\-.\\w+])*@([\\w\\-#])+((\\.\\w+)+)$").matcher(str).matches();
    }

    public static String H(Toy toy) {
        return toy == null ? "" : toy.isH01Toy() ? "anim/solace_data.json" : toy.isT01Toy() ? "anim/calor_data.json" : toy.isF01Toy() ? "anim/xmachine_data.json" : (toy.isMaxToy() || toy.isNoraToy()) ? "anim/nora_max_data.json" : toy.isBAToy() ? "anim/solace_pro.json" : "";
    }

    public static String H0(String str) {
        return e1(str) ? "" : str;
    }

    public static String H1() {
        String strB = zd3.b(x, "xmpp_email_suffix");
        return e1(strB) ? "" : strB;
    }

    public static boolean H2(String str) {
        if (str == null) {
            return false;
        }
        return Pattern.compile("^(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|[1-9])\\.(00?\\d|1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\.(00?\\d|1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\.(00?\\d|1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)$").matcher(str).matches();
    }

    public static String I(Toy toy) {
        return toy.isH01Toy() ? ah4.e(R.string.lds_toy_use_tip4) : toy.isT01Toy() ? ah4.e(R.string.lds_toy_use_tip2) : toy.isXMachine() ? ah4.e(R.string.lds_toy_use_tip3) : toy.isMiniXMachine() ? ah4.e(R.string.lds_toy_use_tip) : toy.isBAToy() ? ah4.e(R.string.lds_toy_use_tip5) : String.format(ah4.e(R.string.lds_toy_use_tip1), toy.getToyUINameSpecialForMiniXMachine(1));
    }

    public static String I0(int i2) {
        Object objValueOf;
        Object objValueOf2;
        int i3 = i2 / 60;
        int i4 = i2 % 60;
        StringBuilder sb = new StringBuilder();
        if (i3 > 9) {
            objValueOf = Integer.valueOf(i3);
        } else {
            objValueOf = "0" + i3;
        }
        sb.append(objValueOf);
        sb.append(SignatureImpl.INNER_SEP);
        if (i4 > 9) {
            objValueOf2 = Integer.valueOf(i4);
        } else {
            objValueOf2 = "0" + i4;
        }
        sb.append(objValueOf2);
        return sb.toString();
    }

    public static boolean I1(Context context, String str) {
        if (pf3.d(context)) {
            return false;
        }
        return eg3.d(x, str, true);
    }

    public static Bitmap I2(Bitmap bitmap) {
        return J2(bitmap, 800);
    }

    public static long J(Context context) {
        if (context != null) {
            ActivityManager activityManager = (ActivityManager) context.getSystemService(ActivityChooserModel.ATTRIBUTE_ACTIVITY);
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            if (activityManager != null) {
                activityManager.getMemoryInfo(memoryInfo);
                return memoryInfo.availMem;
            }
        }
        return 0L;
    }

    public static String J0(long j2) {
        Object objValueOf;
        Object objValueOf2;
        long j3 = j2 / 60;
        long j4 = j2 % 60;
        StringBuilder sb = new StringBuilder();
        if (j3 > 9) {
            objValueOf = Long.valueOf(j3);
        } else {
            objValueOf = "0" + j3;
        }
        sb.append(objValueOf);
        sb.append(SignatureImpl.INNER_SEP);
        if (j4 > 9) {
            objValueOf2 = Long.valueOf(j4);
        } else {
            objValueOf2 = "0" + j4;
        }
        sb.append(objValueOf2);
        return sb.toString();
    }

    public static Bitmap J1(String str) throws IOException {
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new URL(str).openStream(), 1024);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(byteArrayOutputStream, 1024);
            o(bufferedInputStream, bufferedOutputStream);
            bufferedOutputStream.flush();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            return BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
        } catch (IOException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static Bitmap J2(Bitmap bitmap, int i2) {
        double dSqrt = Math.sqrt(i2 * 1024.0d);
        if (bitmap.getWidth() <= dSqrt && bitmap.getHeight() <= dSqrt) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        float fMax = (float) Math.max(dSqrt / bitmap.getWidth(), dSqrt / bitmap.getHeight());
        matrix.postScale(fMax, fMax);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    public static void K() {
        BatteryManager batteryManager = (BatteryManager) x.getSystemService("batterymanager");
        if (Build.VERSION.SDK_INT < 21 || batteryManager == null) {
            return;
        }
        x.a = batteryManager.getIntProperty(4);
    }

    public static long K0(String str) {
        long j2 = 0;
        try {
            if (!e1(str)) {
                int length = str.split(SignatureImpl.INNER_SEP).length;
                for (int i2 = 0; i2 < length; i2++) {
                    j2 = (long) (j2 + (Integer.parseInt(r12[i2]) * Math.pow(60.0d, (length - i2) - 1)));
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return j2;
    }

    public static void K1(boolean z2, bg3.c cVar) {
        z2();
        if (O == null) {
            O = new bg3();
        }
        O.g(z2);
        O.f(cVar);
    }

    public static File L() {
        File fileT = T(ResponseCacheMiddleware.CACHE);
        if (!fileT.exists()) {
            fileT.mkdirs();
        }
        return fileT;
    }

    public static String L0() {
        return "";
    }

    public static void L1(boolean z2, bg3.c cVar) {
        z2();
        if (O == null) {
            O = new bg3();
        }
        O.g(z2);
        O.e(cVar);
    }

    public static String M(Context context) {
        try {
            return context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.getString("CHANNEL");
        } catch (PackageManager.NameNotFoundException unused) {
            return "";
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0030 A[Catch: Exception -> 0x001e, TRY_ENTER, TRY_LEAVE, TryCatch #0 {Exception -> 0x001e, blocks: (B:15:0x001a, B:26:0x0030, B:5:0x0006, B:6:0x0008), top: B:28:0x0002, inners: #3 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static long M0(java.io.InputStream r6) throws java.io.IOException {
        /*
            r0 = 0
            if (r6 == 0) goto L2e
            r2 = 200(0xc8, float:2.8E-43)
            byte[] r3 = new byte[r2]     // Catch: java.lang.Throwable -> L12 java.lang.Exception -> L14
        L8:
            int r4 = r6.read(r3)     // Catch: java.lang.Throwable -> L12 java.lang.Exception -> L14
            r5 = -1
            if (r4 == r5) goto L2e
            long r4 = (long) r2
            long r0 = r0 + r4
            goto L8
        L12:
            r0 = move-exception
            goto L23
        L14:
            r2 = move-exception
            r2.printStackTrace()     // Catch: java.lang.Throwable -> L12
            if (r6 == 0) goto L33
            r6.close()     // Catch: java.lang.Exception -> L1e
            goto L33
        L1e:
            r6 = move-exception
            r6.printStackTrace()
            goto L33
        L23:
            if (r6 == 0) goto L2d
            r6.close()     // Catch: java.lang.Exception -> L29
            goto L2d
        L29:
            r6 = move-exception
            r6.printStackTrace()
        L2d:
            throw r0
        L2e:
            if (r6 == 0) goto L33
            r6.close()     // Catch: java.lang.Exception -> L1e
        L33:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wear.util.WearUtils.M0(java.io.InputStream):long");
    }

    public static String M1(InputStream inputStream) {
        StringBuilder sb = new StringBuilder();
        String property = System.getProperty("line.separator");
        try {
            Scanner scanner = new Scanner(inputStream, "UTF-8");
            while (scanner.hasNextLine()) {
                try {
                    sb.append(scanner.nextLine());
                    sb.append(scanner.hasNextLine() ? property : "");
                } finally {
                }
            }
            if (inputStream != null) {
                inputStream.close();
            }
            scanner.close();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return sb.toString();
    }

    public static File N(IPeopleInfo iPeopleInfo) {
        String strValueOf = String.valueOf(be3.I().getTime());
        if (iPeopleInfo != null) {
            strValueOf = iPeopleInfo.getUserJid();
        }
        if (e1(strValueOf)) {
            strValueOf = String.valueOf(be3.I().getTime());
        }
        return new File(T("cbgf"), r0(strValueOf));
    }

    public static String N0(long j2) {
        return DateFormat.getDateInstance(2, lg3.e(x)).format(new Date(j2));
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0064 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:63:? A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String N1(java.lang.String r6) throws java.lang.Throwable {
        /*
            java.lang.String r0 = ""
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "line.separator"
            java.lang.String r2 = java.lang.System.getProperty(r2)
            r3 = 0
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L46 java.lang.Exception -> L49
            r4.<init>(r6)     // Catch: java.lang.Throwable -> L46 java.lang.Exception -> L49
            java.util.Scanner r6 = new java.util.Scanner     // Catch: java.lang.Throwable -> L3f java.lang.Exception -> L43
            java.lang.String r5 = "UTF-8"
            r6.<init>(r4, r5)     // Catch: java.lang.Throwable -> L3f java.lang.Exception -> L43
        L1a:
            boolean r3 = r6.hasNextLine()     // Catch: java.lang.Throwable -> L3d java.lang.Exception -> L44
            if (r3 == 0) goto L34
            java.lang.String r3 = r6.nextLine()     // Catch: java.lang.Throwable -> L3d java.lang.Exception -> L44
            r1.append(r3)     // Catch: java.lang.Throwable -> L3d java.lang.Exception -> L44
            boolean r3 = r6.hasNextLine()     // Catch: java.lang.Throwable -> L3d java.lang.Exception -> L44
            if (r3 == 0) goto L2f
            r3 = r2
            goto L30
        L2f:
            r3 = r0
        L30:
            r1.append(r3)     // Catch: java.lang.Throwable -> L3d java.lang.Exception -> L44
            goto L1a
        L34:
            r4.close()     // Catch: java.io.IOException -> L38
            goto L59
        L38:
            r0 = move-exception
            r0.printStackTrace()
            goto L59
        L3d:
            r0 = move-exception
            goto L41
        L3f:
            r0 = move-exception
            r6 = r3
        L41:
            r3 = r4
            goto L62
        L43:
            r6 = r3
        L44:
            r3 = r4
            goto L4a
        L46:
            r0 = move-exception
            r6 = r3
            goto L62
        L49:
            r6 = r3
        L4a:
            r1.append(r0)     // Catch: java.lang.Throwable -> L61
            if (r3 == 0) goto L57
            r3.close()     // Catch: java.io.IOException -> L53
            goto L57
        L53:
            r0 = move-exception
            r0.printStackTrace()
        L57:
            if (r6 == 0) goto L5c
        L59:
            r6.close()
        L5c:
            java.lang.String r6 = r1.toString()
            return r6
        L61:
            r0 = move-exception
        L62:
            if (r3 == 0) goto L6c
            r3.close()     // Catch: java.io.IOException -> L68
            goto L6c
        L68:
            r1 = move-exception
            r1.printStackTrace()
        L6c:
            if (r6 == 0) goto L71
            r6.close()
        L71:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wear.util.WearUtils.N1(java.lang.String):java.lang.String");
    }

    public static File O() {
        return new File(T("cbgf"), r0("getChatBackgroundTempFile"));
    }

    public static int O0(String str) {
        if (!e1(str) && str.indexOf(".") > 0) {
            String strReplace = str.replace(".", "");
            if (e1(strReplace)) {
                strReplace = "0";
            }
            if (strReplace.length() > 3) {
                strReplace = strReplace.substring(0, 3);
            } else if (strReplace.length() < 3) {
                int length = strReplace.length();
                StringBuilder sb = new StringBuilder(strReplace);
                for (int i2 = 0; i2 < 3 - length; i2++) {
                    sb.append("0");
                }
                strReplace = sb.toString();
            }
            if (q1(strReplace)) {
                return Integer.parseInt(strReplace);
            }
        }
        return -1;
    }

    public static boolean O1(String str) {
        return Pattern.matches("[-a-zA-Z0-9_]+$", str);
    }

    public static File P() {
        File fileT = T("crash");
        if (!fileT.exists()) {
            fileT.mkdirs();
        }
        return fileT;
    }

    public static File P0(String str) {
        return e0("videoPattern/" + str);
    }

    public static void P1(File file, boolean z2) {
        String[] list;
        if (file == null || !file.exists()) {
            return;
        }
        if (file.isDirectory() && (list = file.list()) != null) {
            for (String str : list) {
                if (!e1(str)) {
                    new File(file, str).delete();
                }
            }
        }
        if (z2) {
            file.delete();
        }
    }

    public static String Q(long j2) {
        Object objValueOf;
        Object objValueOf2;
        if (d1(Long.valueOf(j2))) {
            return "";
        }
        int i2 = (int) j2;
        int i3 = i2 / 60;
        int i4 = i2 % 60;
        StringBuilder sb = new StringBuilder();
        if (i3 > 9) {
            objValueOf = Integer.valueOf(i3);
        } else {
            objValueOf = "0" + i3;
        }
        sb.append(objValueOf);
        sb.append(SignatureImpl.INNER_SEP);
        if (i4 > 9) {
            objValueOf2 = Integer.valueOf(i4);
        } else {
            objValueOf2 = "0" + i4;
        }
        sb.append(objValueOf2);
        return sb.toString();
    }

    public static XYBean Q0() {
        if (P == null) {
            synchronized (b) {
                if (P == null) {
                    XYBean xYBean = (XYBean) zd3.a("X_Y_Key");
                    P = xYBean;
                    if (xYBean == null) {
                        vz vzVar = vz.C;
                        P = new XYBean(vzVar.m(), vzVar.n());
                    } else {
                        H = xYBean.x;
                    }
                }
            }
        }
        return P;
    }

    public static void Q1(String str) {
        String[] list;
        File fileT = T(str);
        if (fileT.exists()) {
            if (fileT.isDirectory() && (list = fileT.list()) != null) {
                for (String str2 : list) {
                    if (!e1(str2)) {
                        new File(fileT, str2).delete();
                    }
                }
            }
            fileT.delete();
        }
    }

    public static File R() {
        File file = new File(Environment.getExternalStorageState().equals("mounted") ? Environment.getExternalStorageDirectory() : x.getFilesDir(), "DCIM/remote");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static boolean R0(String str) {
        if (!y2()) {
            return false;
        }
        if (str.contains("’")) {
            str = str.replace("’", "'");
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add("I love you");
        arrayList.add("I love u");
        arrayList.add("Be my Valentine");
        arrayList.add("You're my everything");
        arrayList.add("You re my everything");
        arrayList.add("Youre my everything");
        arrayList.add("You have my heart");
        arrayList.add("Forever and always");
        arrayList.add("You're my one and only");
        arrayList.add("You re my one and only");
        arrayList.add("Youre my one and only");
        arrayList.add("To the moon and back");
        arrayList.add("You're my soulmate");
        arrayList.add("You re my soulmate");
        arrayList.add("Youre my soulmate");
        arrayList.add("My heart belongs to you");
        arrayList.add("ILY");
        arrayList.add("U R MY [RedHeart]");
        arrayList.add("XOXO");
        arrayList.add("LYSM");
        arrayList.add("4EVA");
        arrayList.add("SWAK");
        arrayList.add("Je t'aime");
        arrayList.add("Je t aime");
        arrayList.add("Je taime");
        arrayList.add("Te amo");
        arrayList.add("Ti amo");
        arrayList.add("Te quiero");
        arrayList.add("Ich liebe dich");
        arrayList.add("愛してる");
        arrayList.add("好きです");
        arrayList.add("사랑해");
        arrayList.add("좋아해");
        arrayList.add("Eu te amo");
        arrayList.add("Eu gosto de você");
        arrayList.add("Kocham Cię");
        arrayList.add("Lubię Cię");
        arrayList.add("Я люблю тебя");
        arrayList.add("Мне нравишься");
        arrayList.add("我愛你");
        arrayList.add("我喜歡你");
        arrayList.add("youre my soulmate");
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            if (str.toLowerCase().contains(((String) arrayList.get(i2)).toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    public static void R1(File file) {
        if (file.exists()) {
            file.delete();
        }
    }

    public static Uri S() {
        Uri defaultUri;
        try {
            defaultUri = RingtoneManager.getDefaultUri(2);
        } catch (NoSuchFieldError e2) {
            e = e2;
            defaultUri = null;
        }
        try {
            M = true;
        } catch (NoSuchFieldError e3) {
            e = e3;
            M = false;
            FirebaseCrashlytics.getInstance().recordException(new Throwable("通知getDefaultUri异常", e));
            return defaultUri;
        }
        return defaultUri;
    }

    public static boolean S0(String str) {
        if (e1(str)) {
            return false;
        }
        return str.contains(SimpleComparison.LESS_THAN_OPERATION) || str.contains(SimpleComparison.GREATER_THAN_OPERATION);
    }

    public static void S1(String str) {
        R1(e0("pattern/" + str));
    }

    public static File T(String str) {
        File filesDir;
        if (!"mounted".equals(Environment.getExternalStorageState()) || (filesDir = x.getExternalFilesDir(null)) == null) {
            filesDir = x.getFilesDir();
        }
        File file = new File(filesDir, "wear" + File.separator + str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static void T0() {
        N = new qe3();
        new qe3.a();
        StringBuilder sb = new StringBuilder();
        sb.append(T("temp"));
        String str = File.separator;
        sb.append(str);
        sb.append("tempSoundPlay.3gp");
        J = sb.toString();
        K = T("temp") + str + "Vuc2UuY29tl1VbG9hZeZpb";
        y = ch3.n();
        s = eg3.h(x, "gen_token_Key", "");
        t = eg3.h(x, "r_token_Key", "");
    }

    public static void T1(String str) {
        new File(T("temp"), str + "temp").deleteOnExit();
    }

    public static List<String> U(String str, int i2) {
        ArrayList arrayList = new ArrayList();
        int length = str.length() % i2;
        int iFloor = (int) Math.floor(str.length() / i2);
        int i3 = 0;
        while (i3 < iFloor) {
            int i4 = i3 * i2;
            i3++;
            arrayList.add(str.substring(i4, i3 * i2));
        }
        if (length > 0) {
            arrayList.add(str.substring(iFloor * i2));
        }
        return arrayList;
    }

    public static void U0(List<Toy> list) {
        if (list == null) {
            return;
        }
        Iterator<Toy> it = list.iterator();
        while (it.hasNext()) {
            it.next().setSynControlAnimation(true);
        }
    }

    public static void U1(String str) {
        File file = new File(T("temp"), str + "temp");
        if (file.exists()) {
            file.delete();
        }
    }

    public static synchronized DomainBean V() {
        String str;
        WifiManager wifiManager = (WifiManager) x.getSystemService("wifi");
        if (!wifiManager.isWifiEnabled()) {
            return new DomainBean("127.0.0.1");
        }
        String strV0 = V0(wifiManager.getConnectionInfo().getIpAddress());
        if (H2(strV0)) {
            return new DomainBean(strV0);
        }
        List<IpBean> listG = G();
        if (!g1(listG)) {
            String strG0 = G0(listG);
            if (!e1(strG0)) {
                if (strG0.contains("%") && (str = strG0.split("%")[0]) != null && !e1(str)) {
                    strG0 = str;
                }
                return new DomainBean(strG0, true, listG);
            }
        }
        return null;
    }

    public static String V0(int i2) {
        return (i2 & 255) + "." + ((i2 >> 8) & 255) + "." + ((i2 >> 16) & 255) + "." + ((i2 >> 24) & 255);
    }

    public static void V1(File file, File file2, String str, String str2) throws IOException {
        try {
            if (file.exists()) {
                String property = System.getProperty("line.separator");
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file2));
                Scanner scanner = new Scanner(new FileInputStream(file), "UTF-8");
                while (scanner.hasNextLine()) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(scanner.nextLine());
                    sb.append(scanner.hasNextLine() ? property : "");
                    bufferedWriter.write(sb.toString().replace(str, str2));
                }
                scanner.close();
                bufferedWriter.flush();
                bufferedWriter.close();
            }
        } catch (Exception unused) {
        }
    }

    public static String W(String str, boolean z2) {
        if (e1(str)) {
            return "";
        }
        if (e1(p)) {
            p = "_w";
        }
        if (z2) {
            return str.endsWith(p) ? str.substring(0, str.length() - p.length()) : str;
        }
        if (str.endsWith(p)) {
            return str;
        }
        return str + p;
    }

    public static boolean W0(String str) {
        if (w1(str)) {
            return str.contains("_alexa_");
        }
        return false;
    }

    public static String W1(String str) throws NumberFormatException {
        String[] strArrSplit = str.split(",");
        StringBuilder sb = new StringBuilder();
        for (String str2 : strArrSplit) {
            if (!e1(str2)) {
                float f2 = Float.parseFloat(str2);
                if (f2 >= 100.0f) {
                    f2 = 99.0f;
                }
                sb.append((int) (f2 / 10.0f));
                sb.append(",");
            }
        }
        return sb.toString();
    }

    public static String X(String str) {
        return !e1(str) ? W(str.split("@")[0].replace(z, "@"), true) : str;
    }

    public static boolean X0(Context context) {
        try {
            return (context.getApplicationInfo().flags & 2) != 0;
        } catch (Exception unused) {
            return false;
        }
    }

    public static String X1(String str, int i2) {
        String[] strArrSplit = str.split(",");
        StringBuilder sb = new StringBuilder();
        int i3 = i2 / 100;
        for (int i4 = 0; i4 < strArrSplit.length; i4 += i3) {
            String str2 = strArrSplit[i4];
            if (!e1(str2)) {
                sb.append(str2);
                sb.append(",");
            }
        }
        return sb.toString();
    }

    public static File Y() {
        File fileT = T("emojis");
        if (!fileT.exists()) {
            fileT.mkdirs();
        }
        return fileT;
    }

    public static boolean Y0() {
        int i2 = MyApplication.m0;
        return i2 == 0 ? MyApplication.l0 : i2 != 1;
    }

    public static String Y1() {
        return x != null ? ah4.e(R.string.common_settingTip) : "Unable to connect to the server";
    }

    public static File Z(String str) {
        return new File(Y(), r0(str));
    }

    public static boolean Z0(String str) {
        return Pattern.compile("\\d{4}-\\d{2}-\\d{2}").matcher(str).matches();
    }

    public static String Z1(int i2) {
        MyApplication myApplication = x;
        return myApplication != null ? myApplication.getResources().getString(i2) : "Unable to connect to the server";
    }

    public static int a(String str, String str2) throws IOException {
        try {
            InputStream inputStreamOpenInputStream = str.startsWith(CommonUtility.PREFIX_URI) ? x.getContentResolver().openInputStream(Uri.parse(str)) : new FileInputStream(str);
            FileOutputStream fileOutputStream = new FileOutputStream(str2);
            byte[] bArr = new byte[1024];
            while (true) {
                int i2 = inputStreamOpenInputStream.read(bArr);
                if (i2 <= 0) {
                    inputStreamOpenInputStream.close();
                    fileOutputStream.close();
                    return 0;
                }
                fileOutputStream.write(bArr, 0, i2);
            }
        } catch (Exception unused) {
            return -1;
        }
    }

    public static File a0(String str) {
        return new File(Y(), str);
    }

    public static boolean a1(Date date, int i2) {
        Date date2;
        Date date3 = new Date(System.currentTimeMillis() - (((i2 * SettingsJsonConstants.SETTINGS_CACHE_DURATION_DEFAULT) * 24) * 1000));
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String strSubstring = simpleDateFormat.format(date3).substring(0, 10);
        String str = strSubstring + " 00:00:00";
        String str2 = strSubstring + " 23:59:59";
        Date date4 = null;
        try {
            date2 = simpleDateFormat.parse(str);
        } catch (ParseException e2) {
            e = e2;
            date2 = null;
        }
        try {
            date4 = simpleDateFormat.parse(str2);
        } catch (ParseException e3) {
            e = e3;
            e.printStackTrace();
            return !date.after(date2) ? false : false;
        }
        if (!date.after(date2) && date.before(date4)) {
            return true;
        }
    }

    public static String a2() {
        return x != null ? ah4.e(R.string.common_serverError) : "Unable to connect to the server";
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0043 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0044 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String b(android.content.Context r5, java.lang.String r6) throws java.io.IOException {
        /*
            java.lang.String r0 = ""
            android.content.res.AssetManager r1 = r5.getAssets()
            java.io.InputStream r1 = r1.open(r6)     // Catch: java.io.IOException -> L38
            java.io.File r2 = new java.io.File     // Catch: java.io.IOException -> L38
            java.io.File r5 = r5.getFilesDir()     // Catch: java.io.IOException -> L38
            r2.<init>(r5, r6)     // Catch: java.io.IOException -> L38
            java.io.FileOutputStream r5 = new java.io.FileOutputStream     // Catch: java.io.IOException -> L38
            r5.<init>(r2)     // Catch: java.io.IOException -> L38
            r6 = 1024(0x400, float:1.435E-42)
            byte[] r6 = new byte[r6]     // Catch: java.io.IOException -> L38
        L1c:
            int r3 = r1.read(r6)     // Catch: java.io.IOException -> L38
            r4 = -1
            if (r3 == r4) goto L28
            r4 = 0
            r5.write(r6, r4, r3)     // Catch: java.io.IOException -> L38
            goto L1c
        L28:
            java.lang.String r6 = r2.getPath()     // Catch: java.io.IOException -> L38
            r1.close()     // Catch: java.io.IOException -> L36
            r5.flush()     // Catch: java.io.IOException -> L36
            r5.close()     // Catch: java.io.IOException -> L36
            goto L3d
        L36:
            r5 = move-exception
            goto L3a
        L38:
            r5 = move-exception
            r6 = r0
        L3a:
            r5.printStackTrace()
        L3d:
            boolean r5 = android.text.TextUtils.isEmpty(r6)
            if (r5 != 0) goto L44
            return r6
        L44:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wear.util.WearUtils.b(android.content.Context, java.lang.String):java.lang.String");
    }

    public static File b0() {
        File fileT = T("enquires");
        if (!fileT.exists()) {
            fileT.mkdirs();
        }
        return fileT;
    }

    public static boolean b1() {
        return !e1(q) && !e1(r) && q.equals("999.999.999") && r.equals(TestValueDao.SAVE_KEY_US_TYPE);
    }

    public static String b2() {
        return x != null ? ah4.e(R.string.common_serverError) : "Unable to connect to the server";
    }

    public static int[] c(int[] iArr) {
        for (int i2 = 0; i2 < iArr.length - 1; i2++) {
            int i3 = 0;
            while (i3 < (iArr.length - 1) - i2) {
                int i4 = i3 + 1;
                if (iArr[i3] > iArr[i4]) {
                    int i5 = iArr[i3];
                    iArr[i3] = iArr[i4];
                    iArr[i4] = i5;
                }
                i3 = i4;
            }
        }
        return iArr;
    }

    public static File c0(String str) {
        return new File(x.getExternalFilesDir(Environment.DIRECTORY_PICTURES), str);
    }

    public static boolean c1(Integer num) {
        return num == null || num.intValue() == 0;
    }

    public static Bitmap c2(String str) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setDoInput(true);
            int contentLength = httpURLConnection.getContentLength();
            httpURLConnection.connect();
            BufferedInputStream bufferedInputStream = new BufferedInputStream(httpURLConnection.getInputStream(), contentLength);
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inSampleSize = 2;
            return BitmapFactory.decodeStream(bufferedInputStream, new Rect(0, 0, 0, 0), options);
        } catch (IOException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static String d(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return "";
        }
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (byte b2 : bArr) {
            sb.append(cArr[(b2 & 240) >> 4]);
            sb.append(cArr[b2 & Ascii.SI]);
        }
        return sb.toString();
    }

    public static String d0() {
        return r0(String.valueOf(be3.I().getTime()));
    }

    public static boolean d1(Long l2) {
        return l2 == null || l2.longValue() == 0;
    }

    public static void d2(Bitmap bitmap, String str) throws IOException {
        File file = new File(str);
        if (file.exists()) {
            file.delete();
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 60, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public static synchronized void e() {
        String str = e;
        String str2 = f;
        if (TextUtils.isEmpty(str)) {
            ye3.d("S0003", "server_https为空");
            return;
        }
        if (TextUtils.isEmpty(str2)) {
            ye3.d("S0003", "date_https为空");
            return;
        }
        if (MyApplication.n0) {
            if (str.contains("apps-dir.lovense.com")) {
                e = str.replace("apps-dir.lovense.com", "apps2.lovense.com");
                ye3.d("S0003", "切换到apps2.lovense.com");
            }
            if (str2.contains("date-dir.lovense.com")) {
                f = str2.replace("date-dir.lovense.com", "date.lovense.com");
            }
        } else {
            if (str.contains("apps2.lovense.com")) {
                e = str.replace("apps2.lovense.com", "apps-dir.lovense.com");
                ye3.d("S0003", "切换切换到apps-dir.lovense.com");
            }
            if (str2.contains("date.lovense.com")) {
                f = str2.replace("date.lovense.com", "date-dir.lovense.com");
            }
        }
    }

    public static File e0(String str) {
        File file = new File(T(""), str);
        File parentFile = file.getParentFile();
        Objects.requireNonNull(parentFile);
        if (!parentFile.exists()) {
            file.getParentFile().mkdirs();
        }
        return file;
    }

    public static boolean e1(String str) {
        return str == null || str.trim().equals("") || str.trim().equals("null");
    }

    public static void e2(Bitmap bitmap, String str) throws IOException {
        if (bitmap == null || e1(str)) {
            return;
        }
        try {
            File fileC0 = c0(str);
            if (!fileC0.exists()) {
                fileC0.getParentFile().mkdirs();
                fileC0.createNewFile();
            }
            FileOutputStream fileOutputStream = new FileOutputStream(fileC0);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public static String f(String str) {
        if (!e1(str)) {
            str = str.substring(0, str.length() - F(str).length());
        }
        return !e1(str) ? str.trim().toLowerCase() : str;
    }

    public static String f0() {
        WifiManager wifiManager = (WifiManager) x.getSystemService("wifi");
        if (!wifiManager.isWifiEnabled()) {
            return "";
        }
        String strV0 = V0(wifiManager.getConnectionInfo().getIpAddress());
        return H2(strV0) ? strV0 : "";
    }

    public static boolean f1(StringBuilder sb) {
        return sb == null || sb.length() == 0 || e1(sb.toString());
    }

    public static void f2(InputStream inputStream, String str) throws IOException {
        try {
            File fileA0 = a0(str);
            if (!fileA0.exists()) {
                fileA0.getParentFile().mkdirs();
                fileA0.createNewFile();
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[4096];
            while (true) {
                int i2 = inputStream.read(bArr);
                if (-1 == i2) {
                    FileOutputStream fileOutputStream = new FileOutputStream(fileA0);
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    fileOutputStream.write(byteArray, 0, byteArray.length);
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    return;
                }
                byteArrayOutputStream.write(bArr, 0, i2);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static File g(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(B(str));
        sb.append(str.lastIndexOf(".") > 0 ? str.substring(str.lastIndexOf(".")) : "");
        try {
            return new File(T(ResponseCacheMiddleware.CACHE), URLEncoder.encode(sb.toString(), "UTF-8"));
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static String g0(String str) {
        return TextUtils.isEmpty(str) ? str : str.contains("conference") ? A0(str) : X(str);
    }

    public static boolean g1(Collection<?> collection) {
        return collection == null || collection.size() == 0;
    }

    public static File g2(Bitmap bitmap, String str) throws IOException {
        String absolutePath = x.getFilesDir().getAbsolutePath();
        File file = new File(absolutePath);
        if (!file.exists()) {
            file.mkdir();
        }
        File file2 = new File(absolutePath + str);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file2));
        bitmap.compress(Bitmap.CompressFormat.JPEG, 80, bufferedOutputStream);
        bufferedOutputStream.flush();
        bufferedOutputStream.close();
        return file2;
    }

    public static boolean h(boolean z2, String str) {
        if (e1(str)) {
            return false;
        }
        if (z2) {
            if (str.charAt(0) == '/') {
                str = e + str;
            } else {
                str = e + "/" + str;
            }
        }
        File fileG = g(str.replace("-api", ""));
        if (fileG != null && fileG.exists()) {
            return true;
        }
        File fileG2 = g(str);
        return fileG2 != null && fileG2.exists();
    }

    public static void h0(String str, ff3 ff3Var) {
        if (!m1(str)) {
            ff3Var.b(false, ah4.e(R.string.common_not_pic));
            return;
        }
        ImageLoader.getInstance().loadImage(e + str, MyApplication.Y, new a(ff3Var));
    }

    public static boolean h1(Map map) {
        return map == null || map.size() == 0;
    }

    public static void h2(String str, String str2, boolean z2) throws IOException {
        File fileE0 = e0(str2);
        if (!fileE0.exists()) {
            try {
                fileE0.createNewFile();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
        if (fileE0.exists()) {
            try {
                FileWriter fileWriter = new FileWriter(fileE0, z2);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                bufferedWriter.write(str);
                bufferedWriter.flush();
                bufferedWriter.close();
                fileWriter.close();
            } catch (IOException e3) {
                e3.printStackTrace();
            }
        }
    }

    public static String i(String str) {
        if (!e1(str) && str.endsWith("#pre777")) {
            str = str.substring(0, str.length() - 7);
            A2();
        } else if (!e1(str) && str.endsWith("#testapi2")) {
            str = str.substring(0, str.length() - 9);
            A2();
        } else if (!e1(str) && str.endsWith("#testapps")) {
            str = str.substring(0, str.length() - 9);
            B2();
        } else if (!e1(str) && str.endsWith("#res777")) {
            str = str.substring(0, str.length() - 7);
            C2();
        } else if (!e1(str) && str.endsWith("#test")) {
            str = str.substring(0, str.length() - 5);
            D2();
        } else if (!e1(str) && str.endsWith("#test14")) {
            str = str.substring(0, str.length() - 7);
            D2();
        } else if (B) {
            D2();
        } else {
            C2();
        }
        return !e1(str) ? str.trim().toLowerCase() : str;
    }

    public static String i0(String str) {
        if (e1(str)) {
            return "";
        }
        return W(str, false).replace("@", z) + "@" + d;
    }

    public static boolean i1(byte[] bArr) {
        return bArr == null || bArr.length == 0;
    }

    public static void i2(boolean z2, String str, String str2, String str3, ue2.a aVar) throws Throwable {
        if (z2) {
            str2 = e + str2;
        }
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str2).openConnection();
            httpURLConnection.setConnectTimeout(5000);
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setDoInput(true);
            if (httpURLConnection.getResponseCode() != 200) {
                if (aVar != null) {
                    aVar.a(httpURLConnection.getResponseCode(), httpURLConnection.getResponseMessage());
                }
                String str4 = "saveFile fail1:" + httpURLConnection.getResponseMessage();
                return;
            }
            InputStream inputStream = httpURLConnection.getInputStream();
            File fileE0 = e0(str3 + "/" + str);
            if (!fileE0.exists()) {
                try {
                    fileE0.createNewFile();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
            FileOutputStream fileOutputStream = new FileOutputStream(fileE0);
            byte[] bArr = new byte[1024];
            while (true) {
                int i2 = inputStream.read(bArr);
                if (i2 == -1) {
                    break;
                } else {
                    fileOutputStream.write(bArr, 0, i2);
                }
            }
            inputStream.close();
            fileOutputStream.close();
            String strN1 = N1(fileE0.getPath());
            String str5 = "str==========" + strN1;
            if (!e1(strN1) && !strN1.contains("result")) {
                if (aVar != null) {
                    aVar.b(fileE0);
                }
            } else {
                fileE0.delete();
                if (aVar != null) {
                    aVar.a(-1, null);
                }
            }
        } catch (Exception e3) {
            if (aVar != null) {
                aVar.a(-1, e3.getMessage());
            }
            String str6 = "saveFile fail2:" + e3.getMessage();
        }
    }

    public static void j() {
        synchronized (b) {
            H = null;
            I = null;
            vz vzVar = vz.C;
            P = new XYBean(vzVar.m(), vzVar.n());
            pe3.a("X_Y_Key");
        }
    }

    public static String j0(String str) {
        return e1(str) ? "" : k1(str) ? i0(str) : k0(str);
    }

    public static boolean j1(Object[] objArr) {
        return objArr == null || objArr.length == 0;
    }

    public static void j2(final String str, String str2, final ue2.a aVar) {
        final String str3 = e + str2;
        final Handler handler = new Handler(Looper.getMainLooper());
        vg3.b().a(new Runnable() { // from class: dc.id3
            @Override // java.lang.Runnable
            public final void run() throws Throwable {
                WearUtils.F1(str3, str, handler, aVar);
            }
        });
    }

    public static int k(String str, String str2) {
        try {
            if (TextUtils.equals(str, str2)) {
                return 0;
            }
            String[] strArrSplit = str.split("\\.");
            String[] strArrSplit2 = str2.split("\\.");
            int iMin = Math.min(strArrSplit.length, strArrSplit2.length);
            int i2 = 0;
            int i3 = 0;
            while (i2 < iMin) {
                i3 = Integer.parseInt(strArrSplit[i2]) - Integer.parseInt(strArrSplit2[i2]);
                if (i3 != 0) {
                    break;
                }
                i2++;
            }
            if (i3 != 0) {
                return i3 > 0 ? 1 : -1;
            }
            for (int i4 = i2; i4 < strArrSplit.length; i4++) {
                if (Integer.parseInt(strArrSplit2[i4]) > 0) {
                    return 1;
                }
            }
            while (i2 < strArrSplit.length) {
                if (Integer.parseInt(strArrSplit2[i2]) > 0) {
                    return -1;
                }
                i2++;
            }
            return 0;
        } catch (Exception e2) {
            e2.printStackTrace();
            return -2;
        }
    }

    public static String k0(String str) {
        if (e1(str)) {
            return "";
        }
        return str + "@conference." + d;
    }

    public static boolean k1(String str) {
        if (e1(str)) {
            return true;
        }
        return str.contains("@");
    }

    public static void k2(String str) {
        String strF = F(str);
        if (e1(strF)) {
            eg3.m(x, "xmpp_email_suffix");
        } else {
            zd3.d(x, "xmpp_email_suffix", strF);
        }
    }

    public static Bitmap l(Context context, Bitmap bitmap, String str) {
        try {
            int iP = qe3.p(str);
            return iP != 0 ? qe3.q(iP, bitmap) : bitmap;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static String l0(Context context, String str) {
        int iM0 = m0(str);
        if (iM0 == 1) {
            return ah4.e(R.string.pattern_name_empty);
        }
        if (iM0 == 2) {
            return ah4.e(R.string.str_pattern_name_long_string);
        }
        if (iM0 == 3) {
            return ah4.e(R.string.str_pattern_name_error);
        }
        if (iM0 != 4) {
            return null;
        }
        return ah4.e(R.string.title_commit_rule);
    }

    public static boolean l1(Context context) {
        if (Build.VERSION.SDK_INT < 23) {
            return true;
        }
        return ((PowerManager) context.getSystemService("power")).isIgnoringBatteryOptimizations(context.getPackageName());
    }

    public static void l2(String str, String str2) throws IOException {
        if (e1(str2)) {
            q(new File(T("temp"), str + "temp"), new File(T("pattern"), str));
            return;
        }
        V1(new File(T("temp"), str + "temp"), new File(T("pattern"), str), PatternHead.P_M_DEF, str2.toLowerCase());
    }

    public static Bitmap m(MyApplication myApplication, Uri uri) {
        try {
            Bitmap bitmapB = qe3.b(myApplication, uri);
            int iP = qe3.p(N.d(myApplication, uri));
            return iP != 0 ? qe3.q(iP, bitmapB) : bitmapB;
        } catch (IOException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static int m0(String str) {
        boolean z2 = true;
        if (TextUtils.isEmpty(str)) {
            return 1;
        }
        String strTrim = str.trim();
        if (strTrim.length() > 30) {
            return 2;
        }
        if (!strTrim.contains(SimpleComparison.LESS_THAN_OPERATION) && !strTrim.contains(SimpleComparison.GREATER_THAN_OPERATION) && !strTrim.contains("*") && !strTrim.contains("'") && !strTrim.contains("\"")) {
            z2 = false;
        }
        if (z2) {
            return 3;
        }
        return (strTrim.contains(".com") || strTrim.contains(".cn") || strTrim.contains("@")) ? 4 : 0;
    }

    public static boolean m1(String str) {
        if (e1(str)) {
            return false;
        }
        return str.matches("(?i).+?\\.(jpg|gif|bmp|png)");
    }

    public static void m2(String str, String str2) throws IOException {
        h2(str, "pattern/" + str2, false);
    }

    public static String n(InputStream inputStream) throws IOException {
        StringWriter stringWriter = new StringWriter();
        char[] cArr = new char[2048];
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
            while (true) {
                int i2 = bufferedReader.read(cArr);
                if (i2 == -1) {
                    inputStream.close();
                    return stringWriter.toString();
                }
                stringWriter.write(cArr, 0, i2);
            }
        } catch (Throwable th) {
            inputStream.close();
            throw th;
        }
    }

    public static int n0(String str) throws Throwable {
        try {
            String strN1 = N1(str);
            com.wear.bean.Pattern pattern = new com.wear.bean.Pattern();
            pattern.setData(strN1);
            return pattern.getHead() == null ? pattern.getData().split(",").length : pattern.getData().split(TouchControlView.P).length;
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public static boolean n1(String str) throws NumberFormatException {
        try {
            Integer.parseInt(str);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static String n2(List list, String str, boolean z2) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append(G1(list, ";"));
        sb.append(z2 ? ";" : "");
        String string = sb.toString();
        h2(string, "temp/" + str + "temp", true);
        return string;
    }

    public static void o(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[1024];
        while (true) {
            int i2 = inputStream.read(bArr);
            if (i2 == -1) {
                return;
            } else {
                outputStream.write(bArr, 0, i2);
            }
        }
    }

    public static void o0(Context context) {
        vz.C.x(eg3.h(context, "LOCAL_abc", ""));
    }

    public static boolean o1(String str) {
        return m0(str) == 0;
    }

    public static void o2(Context context, String str) {
        eg3.i(context, str, Boolean.FALSE);
    }

    public static void p(String str, Context context) {
        ((ClipboardManager) context.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(null, str.trim()));
    }

    public static File p0() {
        File fileT = T("loginCrash");
        if (!fileT.exists()) {
            fileT.mkdirs();
        }
        return fileT;
    }

    public static boolean p1() {
        return Build.VERSION.SDK_INT < 23 || x.G().o().size() <= 0 || x.getPackageManager().checkPermission("android.permission.ACCESS_FINE_LOCATION", x.getPackageName()) == 0;
    }

    public static void p2(List<Toy> list, String str) {
        if (list == null) {
            return;
        }
        for (Toy toy : list) {
            if (TextUtils.equals(toy.getAddress(), str)) {
                toy.setSynControlAnimation(false);
            }
        }
    }

    public static void q(File file, File file2) throws IOException {
        try {
            if (!file.exists()) {
                return;
            }
            FileInputStream fileInputStream = new FileInputStream(file);
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            byte[] bArr = new byte[1444];
            while (true) {
                int i2 = fileInputStream.read(bArr);
                if (i2 == -1) {
                    fileInputStream.close();
                    return;
                }
                fileOutputStream.write(bArr, 0, i2);
            }
        } catch (Exception e2) {
            System.out.println("复制文件出错");
            e2.printStackTrace();
        }
    }

    public static String q0() {
        return ".lovense.club";
    }

    public static boolean q1(String str) {
        return Pattern.compile("-?\\d+(\\.\\d+)?").matcher(str).matches();
    }

    public static void q2(Dialog dialog) {
        dialog.getWindow().addFlags(AudioRoutingController.DEVICE_OUT_USB_HEADSET);
        ViewGroup viewGroup = (ViewGroup) ((ViewGroup) dialog.findViewById(android.R.id.content)).getChildAt(0);
        viewGroup.setFitsSystemWindows(true);
        viewGroup.setClipToPadding(true);
    }

    public static void r(InputStream inputStream, File file) throws IOException {
        if (file == null || inputStream == null) {
            return;
        }
        try {
            if (inputStream.available() <= 0) {
                return;
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            byte[] bArr = new byte[1444];
            while (true) {
                int i2 = inputStream.read(bArr);
                if (i2 == -1) {
                    inputStream.close();
                    return;
                }
                fileOutputStream.write(bArr, 0, i2);
            }
        } catch (Exception e2) {
            System.out.println("复制文件出错");
            e2.printStackTrace();
        }
    }

    public static String r0(String str) {
        return s0(str.getBytes());
    }

    public static boolean r1() {
        if (MyApplication.H() == null) {
            return false;
        }
        FragmentActivity fragmentActivityH = MyApplication.H();
        return (fragmentActivityH instanceof SoundPlayActivity) || (fragmentActivityH instanceof CreatePatternActivity) || (fragmentActivityH instanceof PatternPlayActivity) || (fragmentActivityH instanceof AlarmSoundPlayActivity) || (fragmentActivityH instanceof RemoteControlActivity) || (fragmentActivityH instanceof RemoteMultiControlActivity);
    }

    public static void r2(String str, Account account) {
        account.setAvatar(str);
        zb2.O().r0(account.getUserJid(), str);
        if (m1(str)) {
            h0(str, new c(account));
        }
    }

    public static void s(String str, Exception exc) {
        if (e1(exc.getMessage())) {
            exc.getClass().getSimpleName();
        } else {
            exc.getMessage();
        }
    }

    public static String s0(byte[] bArr) throws NoSuchAlgorithmException {
        if (bArr == null || bArr.length == 0) {
            return "";
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(bArr);
            return d(messageDigest.digest());
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }

    public static boolean s1() {
        if (eg3.d(x, "switchDefaultTheme", false)) {
            return false;
        }
        return y2();
    }

    public static void s2(String str, User user) {
        user.setAvatar(str);
        zb2.O().r0(user.getUserJid(), user.getAvatar());
        if (m1(str)) {
            h0(str, new b(user));
        }
    }

    public static Map<String, String> t(String str) {
        try {
            int iIndexOf = str.indexOf("#");
            if (iIndexOf != -1) {
                str = str.substring(iIndexOf);
            }
            int iIndexOf2 = str.indexOf("?");
            if (iIndexOf2 == -1) {
                return new HashMap();
            }
            String strSubstring = str.substring(iIndexOf2 + 1);
            HashMap map = new HashMap();
            for (String str2 : strSubstring.split(ContainerUtils.FIELD_DELIMITER)) {
                String[] strArrSplit = str2.split("=");
                if (strArrSplit.length == 2) {
                    map.put(URLDecoder.decode(strArrSplit[0], "UTF-8"), URLDecoder.decode(strArrSplit[1], "UTF-8"));
                }
            }
            return map;
        } catch (Exception e2) {
            e2.printStackTrace();
            return new HashMap();
        }
    }

    @SuppressLint({"StringFormatInvalid"})
    public static String t0(Date date) {
        if (date == null) {
            return null;
        }
        return a1(date, 0) ? x2(date) : a1(date, 1) ? ah4.e(R.string.yesterday) : DateFormat.getDateInstance(2, lg3.e(x)).format(date);
    }

    public static boolean t1(String str) {
        if (e1(str)) {
            return false;
        }
        if (Pattern.compile("^(?=.*\\d)(?=.*[~`!@#$%^&*()_\\-+={\\[}\\]|\\\\:;\"'<,>.?/])[A-Za-z\\d~`!@#$%^&*()_\\-+={\\[}\\]|\\\\:;\"'<,>.?/]{8,99}$").matcher(str).matches() || Pattern.compile("^(?=.*[A-Za-z])(?=.*[~`!@#$%^&*()_\\-+={\\[}\\]|\\\\:;\"'<,>.?/])[A-Za-z\\d~`!@#$%^&*()_\\-+={\\[}\\]|\\\\:;\"'<,>.?/]{8,99}$").matcher(str).matches()) {
            return true;
        }
        return Pattern.compile("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d~`!@#$%^&*()_\\-+={\\[}\\]|\\\\:;\"'<,>.?/]{8,99}$").matcher(str).matches();
    }

    public static void t2(ImageView imageView, IPeopleInfo iPeopleInfo) {
        if (iPeopleInfo == null) {
            return;
        }
        zb2.O().r0(iPeopleInfo.getUserJid(), iPeopleInfo.getAvatar());
        u2(imageView, iPeopleInfo.getAvatar());
    }

    public static String u(String str) {
        return e1(str) ? "" : v(str, "empty");
    }

    @SuppressLint({"StringFormatInvalid"})
    public static String u0(Date date) {
        if (date == null) {
            return null;
        }
        if (a1(date, 0)) {
            return x2(date);
        }
        if (!a1(date, 1)) {
            return DateFormat.getDateTimeInstance(2, 3, lg3.e(x)).format(date);
        }
        return ah4.e(R.string.yesterday) + " " + x2(date);
    }

    public static boolean u1() {
        StringBuilder sb = new StringBuilder();
        for (String str : Build.SUPPORTED_ABIS) {
            sb.append(str);
            sb.append(", ");
        }
        StringBuilder sb2 = new StringBuilder(sb.substring(0, sb.length() - 2));
        sb2.toString();
        return sb2.indexOf("arm64-v8a") != -1;
    }

    public static void u2(ImageView imageView, String str) {
        if (e1(str)) {
            imageView.setImageResource(R.drawable.icon_default_new);
            return;
        }
        if (String.valueOf(R.drawable.avatar_official).equals(str)) {
            imageView.setImageResource(R.drawable.avatar_official);
            return;
        }
        if (!str.startsWith("http")) {
            str = e + str;
        }
        ImageLoader.getInstance().displayImage(str, imageView, MyApplication.Y, new d(imageView));
    }

    public static String v(String str, String str2) {
        if (e1(str)) {
            str = "";
        }
        try {
            return new String(Base64.decode(str, 0));
        } catch (Exception unused) {
            return str2;
        }
    }

    public static String v0(long j2) {
        Object objValueOf;
        Object objValueOf2;
        Object objValueOf3;
        Object objValueOf4;
        if (d1(Long.valueOf(j2))) {
            return "";
        }
        int i2 = (int) j2;
        int i3 = i2 / 60;
        int i4 = i2 % 60;
        if (i3 < 60) {
            StringBuilder sb = new StringBuilder();
            if (i3 > 9) {
                objValueOf3 = Integer.valueOf(i3);
            } else {
                objValueOf3 = "0" + i3;
            }
            sb.append(objValueOf3);
            sb.append(SignatureImpl.INNER_SEP);
            if (i4 > 9) {
                objValueOf4 = Integer.valueOf(i4);
            } else {
                objValueOf4 = "0" + i4;
            }
            sb.append(objValueOf4);
            return sb.toString();
        }
        String str = (i3 / 60) + SignatureImpl.INNER_SEP;
        int i5 = i3 % 60;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        if (i5 > 9) {
            objValueOf = Integer.valueOf(i5);
        } else {
            objValueOf = "0" + i5;
        }
        sb2.append(objValueOf);
        sb2.append(SignatureImpl.INNER_SEP);
        if (i4 > 9) {
            objValueOf2 = Integer.valueOf(i4);
        } else {
            objValueOf2 = "0" + i4;
        }
        sb2.append(objValueOf2);
        return sb2.toString();
    }

    public static boolean v1() {
        try {
            EGLConfig[] eGLConfigArr = new EGLConfig[1];
            EGL10 egl10 = (EGL10) EGLContext.getEGL();
            EGLDisplay eGLDisplayEglGetDisplay = egl10.eglGetDisplay(0);
            egl10.eglInitialize(eGLDisplayEglGetDisplay, null);
            egl10.eglChooseConfig(eGLDisplayEglGetDisplay, new int[]{12352, 64, 12339, 1, 12322, 8, 12323, 8, 12324, 8, 12321, 8, 12344}, eGLConfigArr, 1, new int[1]);
            EGLContext eGLContextEglCreateContext = egl10.eglCreateContext(eGLDisplayEglGetDisplay, eGLConfigArr[0], EGL10.EGL_NO_CONTEXT, new int[]{12440, 3, 12344});
            EGLSurface eGLSurface = EGL10.EGL_NO_SURFACE;
            egl10.eglMakeCurrent(eGLDisplayEglGetDisplay, eGLSurface, eGLSurface, eGLContextEglCreateContext);
            boolean zContains = GLES32.glGetString(7938).contains("OpenGL ES 3.2");
            EGLSurface eGLSurface2 = EGL10.EGL_NO_SURFACE;
            egl10.eglMakeCurrent(eGLDisplayEglGetDisplay, eGLSurface2, eGLSurface2, EGL10.EGL_NO_CONTEXT);
            egl10.eglDestroyContext(eGLDisplayEglGetDisplay, eGLContextEglCreateContext);
            egl10.eglTerminate(eGLDisplayEglGetDisplay);
            return zContains;
        } catch (Exception | NoClassDefFoundError e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static void v2(ImageView imageView, String str, LinearLayout linearLayout) {
        if (e1(str)) {
            imageView.setImageResource(R.drawable.chat_avatar_default);
            return;
        }
        if (!str.startsWith("http")) {
            str = e + str;
        }
        ImageLoader.getInstance().displayImage(str, imageView, MyApplication.Y, new e(imageView, linearLayout));
    }

    public static <T> T w(T t2) throws IOException {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            new ObjectOutputStream(byteArrayOutputStream).writeObject(t2);
            return (T) new ObjectInputStream(new ByteArrayInputStream(byteArrayOutputStream.toByteArray())).readObject();
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static String w0(int i2) {
        String strE = ah4.e(R.string.ds_waiting_panel_order_numb_1);
        int i3 = i2 % 10;
        if (i3 == 0) {
            strE = ah4.e(R.string.ds_waiting_panel_order_numb_1);
        } else if (i3 == 1) {
            strE = ah4.e(R.string.ds_waiting_panel_order_numb_2);
        } else if (i3 == 2) {
            strE = ah4.e(R.string.ds_waiting_panel_order_numb_3);
        } else if (i3 == 3) {
            strE = ah4.e(R.string.ds_waiting_panel_order_numb_4);
        }
        return i2 + strE;
    }

    public static boolean w1(String str) {
        if (e1(str)) {
            str = "";
        }
        return str.matches("system+\\w+@lovense.com");
    }

    public static void w2(String str, String str2) {
        if (e1(str) || e1(str2)) {
            return;
        }
        synchronized (b) {
            H = str;
            I = str2;
            XYBean xYBean = new XYBean(str, str2);
            P = xYBean;
            zd3.e("X_Y_Key", xYBean);
        }
    }

    public static <E> List<E> x(List<E> list) throws IOException {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            new ObjectOutputStream(byteArrayOutputStream).writeObject(list);
            return (List) new ObjectInputStream(new ByteArrayInputStream(byteArrayOutputStream.toByteArray())).readObject();
        } catch (Exception e2) {
            e2.printStackTrace();
            return new ArrayList();
        }
    }

    public static File x0(String str) {
        return e0("pattern/" + str);
    }

    public static boolean x1(Boolean bool) {
        return bool != null && bool.booleanValue();
    }

    public static String x2(Date date) {
        if (be3.A(x)) {
            return be3.d.format(date);
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(date.getTime());
        if (calendar.get(9) == 0) {
            return be3.f.format(date) + " " + ah4.e(R.string.app_hourformat_12_am);
        }
        return be3.f.format(date) + " " + ah4.e(R.string.app_hourformat_12_pm);
    }

    public static void y() {
        R1(new File(Environment.getExternalStorageState().equals("mounted") ? x.getExternalFilesDir(null) : x.getFilesDir(), "lovense" + File.separator + "tempSoundPlay.3gp"));
        if (!e1(J)) {
            R1(new File(J));
        }
        if (e1(K)) {
            return;
        }
        R1(new File(K));
    }

    public static String y0() {
        return e0("pattern").getAbsolutePath();
    }

    public static boolean y1(String str) {
        return !e1(str) && str.equals("true");
    }

    public static boolean y2() {
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int i2 = calendar.get(2);
        int i3 = calendar.get(5);
        return i2 == 1 && i3 >= 5 && i3 <= 14;
    }

    public static void z(File file) {
        if (file.isFile()) {
            file.delete();
            return;
        }
        if (file.isDirectory()) {
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles == null || fileArrListFiles.length == 0) {
                file.delete();
                return;
            }
            for (File file2 : fileArrListFiles) {
                z(file2);
            }
            file.delete();
        }
    }

    public static File z0(String str) {
        File file = new File(x.getFilesDir(), str);
        File parentFile = file.getParentFile();
        Objects.requireNonNull(parentFile);
        if (!parentFile.exists()) {
            file.getParentFile().mkdirs();
        }
        return file;
    }

    public static /* synthetic */ void z1(String str, ff3 ff3Var) throws IOException {
        try {
            File file = new File(T(ResponseCacheMiddleware.CACHE), URLEncoder.encode(B(str) + MultiDexExtractor.EXTRACTED_SUFFIX, "UTF-8"));
            if (file.exists()) {
                ff3Var.b(true, file);
                return;
            }
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                httpURLConnection.setConnectTimeout(10000);
                httpURLConnection.setReadTimeout(10000);
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setDoInput(true);
                if (httpURLConnection.getResponseCode() != 200) {
                    ff3Var.b(false, null);
                    return;
                }
                InputStream inputStream = httpURLConnection.getInputStream();
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                byte[] bArr = new byte[1024];
                while (true) {
                    int i2 = inputStream.read(bArr);
                    if (i2 == -1) {
                        inputStream.close();
                        fileOutputStream.close();
                        ff3Var.b(true, file);
                        return;
                    }
                    fileOutputStream.write(bArr, 0, i2);
                }
            } catch (Exception e2) {
                ff3Var.b(false, e2.getMessage());
            }
        } catch (UnsupportedEncodingException e3) {
            ff3Var.b(false, e3.getMessage());
        }
    }

    public static void z2() {
        bg3 bg3Var = O;
        if (bg3Var != null) {
            bg3Var.h();
        }
        O = null;
    }
}
