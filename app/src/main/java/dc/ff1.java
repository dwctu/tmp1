package dc;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import com.spotify.sdk.android.auth.AuthorizationRequest;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* compiled from: SpotifyNativeAuthUtil.java */
/* loaded from: classes3.dex */
public class ff1 {
    public static final String[] c = {".debug", ".canary", ".partners", ""};
    public static final String[] d = {"25a9b2d2745c098361edaa3b87936dc29a28e7f1", "80abdd17dcc4cb3a33815d354355bf87c9378624", "88df4d670ed5e01fc7b3eff13b63258628ff5a00", "d834ae340d1e854c5f4092722f9788216d9221e5", "1cbedd9e7345f64649bad2b493a20d9eea955352", "4b3d76a2de89033ea830f476a1f815692938e33b"};
    public static final char[] e = "0123456789abcdef".toCharArray();
    public final Activity a;
    public final AuthorizationRequest b;

    public ff1(Activity activity, AuthorizationRequest authorizationRequest) {
        this.a = activity;
        this.b = authorizationRequest;
    }

    public static String a(byte[] bArr) {
        char[] cArr = new char[bArr.length * 2];
        for (int i = 0; i < bArr.length; i++) {
            int i2 = bArr[i] & 255;
            int i3 = i * 2;
            char[] cArr2 = e;
            cArr[i3] = cArr2[i2 >>> 4];
            cArr[i3 + 1] = cArr2[i2 & 15];
        }
        return new String(cArr);
    }

    public static String c(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
            byte[] bytes = str.getBytes("UTF-8");
            messageDigest.update(bytes, 0, bytes.length);
            return a(messageDigest.digest());
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException unused) {
            return null;
        }
    }

    public final Intent b() {
        Intent intentF = null;
        for (String str : c) {
            intentF = f("com.spotify.music" + str);
            if (intentF != null) {
                break;
            }
        }
        return intentF;
    }

    public boolean d() {
        Intent intentB = b();
        if (intentB == null) {
            return false;
        }
        intentB.putExtra("VERSION", 1);
        intentB.putExtra("CLIENT_ID", this.b.b());
        intentB.putExtra("REDIRECT_URI", this.b.c());
        intentB.putExtra("RESPONSE_TYPE", this.b.d());
        intentB.putExtra("SCOPES", this.b.e());
        intentB.putExtra("STATE", this.b.f());
        try {
            this.a.startActivityForResult(intentB, 1138);
            return true;
        } catch (ActivityNotFoundException unused) {
            return false;
        }
    }

    public void e() {
        this.a.finishActivity(1138);
    }

    public final Intent f(String str) {
        Intent intent = new Intent("com.spotify.sso.action.START_AUTH_FLOW");
        intent.setPackage(str);
        ComponentName componentNameResolveActivity = intent.resolveActivity(this.a.getPackageManager());
        if (componentNameResolveActivity != null && g(componentNameResolveActivity.getPackageName())) {
            return intent;
        }
        return null;
    }

    @SuppressLint({"PackageManagerGetSignatures"})
    public final boolean g(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        Signature[] signatureArr;
        try {
            signatureArr = this.a.getPackageManager().getPackageInfo(str, 64).signatures;
        } catch (PackageManager.NameNotFoundException unused) {
        }
        if (signatureArr == null) {
            return false;
        }
        for (Signature signature : signatureArr) {
            String strC = c(signature.toCharsString());
            for (String str2 : d) {
                if (str2.equals(strC)) {
                    return true;
                }
            }
        }
        return false;
    }
}
