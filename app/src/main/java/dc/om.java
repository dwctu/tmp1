package dc;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.crashlytics.internal.settings.DefaultSettingsSpiCall;
import java.util.List;

/* compiled from: ResourceDrawableDecoder.java */
/* loaded from: classes.dex */
public class om implements ch<Uri, Drawable> {
    public final Context a;

    public om(Context context) {
        this.a = context.getApplicationContext();
    }

    @Override // dc.ch
    @Nullable
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public ti<Drawable> b(@NonNull Uri uri, int i, int i2, @NonNull ah ahVar) {
        Context contextD = d(uri, uri.getAuthority());
        return nm.d(km.b(this.a, contextD, g(contextD, uri)));
    }

    @NonNull
    public final Context d(Uri uri, String str) {
        if (str.equals(this.a.getPackageName())) {
            return this.a;
        }
        try {
            return this.a.createPackageContext(str, 0);
        } catch (PackageManager.NameNotFoundException e) {
            if (str.contains(this.a.getPackageName())) {
                return this.a;
            }
            throw new IllegalArgumentException("Failed to obtain context or unrecognized Uri format for: " + uri, e);
        }
    }

    @DrawableRes
    public final int e(Uri uri) {
        try {
            return Integer.parseInt(uri.getPathSegments().get(0));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Unrecognized Uri format: " + uri, e);
        }
    }

    @DrawableRes
    public final int f(Context context, Uri uri) {
        List<String> pathSegments = uri.getPathSegments();
        String authority = uri.getAuthority();
        String str = pathSegments.get(0);
        String str2 = pathSegments.get(1);
        int identifier = context.getResources().getIdentifier(str2, str, authority);
        if (identifier == 0) {
            identifier = Resources.getSystem().getIdentifier(str2, str, DefaultSettingsSpiCall.ANDROID_CLIENT_TYPE);
        }
        if (identifier != 0) {
            return identifier;
        }
        throw new IllegalArgumentException("Failed to find resource id for: " + uri);
    }

    @DrawableRes
    public final int g(Context context, Uri uri) {
        List<String> pathSegments = uri.getPathSegments();
        if (pathSegments.size() == 2) {
            return f(context, uri);
        }
        if (pathSegments.size() == 1) {
            return e(uri);
        }
        throw new IllegalArgumentException("Unrecognized Uri format: " + uri);
    }

    @Override // dc.ch
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public boolean a(@NonNull Uri uri, @NonNull ah ahVar) {
        return uri.getScheme().equals("android.resource");
    }
}
