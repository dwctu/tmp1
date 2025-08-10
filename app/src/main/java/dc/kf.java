package dc;

import android.app.Activity;
import android.content.ComponentCallbacks2;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.AssetFileDescriptor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import android.view.View;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bumptech.glide.GeneratedAppGlideModule;
import com.bumptech.glide.Registry;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import dc.al;
import dc.bk;
import dc.bl;
import dc.ck;
import dc.dk;
import dc.ik;
import dc.im;
import dc.ph;
import dc.qk;
import dc.rh;
import dc.sk;
import dc.tk;
import dc.uk;
import dc.vk;
import dc.wk;
import dc.xk;
import dc.yj;
import dc.yk;
import dc.zj;
import dc.zk;
import java.io.File;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: Glide.java */
/* loaded from: classes.dex */
public class kf implements ComponentCallbacks2 {
    public static volatile kf i;
    public static volatile boolean j;
    public final cj a;
    public final tj b;
    public final mf c;
    public final Registry d;
    public final zi e;
    public final tn f;
    public final ln g;
    public final List<rf> h = new ArrayList();

    /* compiled from: Glide.java */
    public interface a {
        @NonNull
        qo build();
    }

    public kf(@NonNull Context context, @NonNull ji jiVar, @NonNull tj tjVar, @NonNull cj cjVar, @NonNull zi ziVar, @NonNull tn tnVar, @NonNull ln lnVar, int i2, @NonNull a aVar, @NonNull Map<Class<?>, sf<?, ?>> map, @NonNull List<po<Object>> list, boolean z, boolean z2) {
        ch llVar;
        ch emVar;
        om omVar;
        nf nfVar = nf.NORMAL;
        this.a = cjVar;
        this.e = ziVar;
        this.b = tjVar;
        this.f = tnVar;
        this.g = lnVar;
        Resources resources = context.getResources();
        Registry registry = new Registry();
        this.d = registry;
        registry.r(new DefaultImageHeaderParser());
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 27) {
            registry.r(new ul());
        }
        List<ImageHeaderParser> listG = registry.g();
        sm smVar = new sm(context, listG, cjVar, ziVar);
        ch<ParcelFileDescriptor, Bitmap> chVarH = hm.h(cjVar);
        rl rlVar = new rl(registry.g(), resources.getDisplayMetrics(), cjVar, ziVar);
        if (!z2 || i3 < 28) {
            llVar = new ll(rlVar);
            emVar = new em(rlVar, ziVar);
        } else {
            emVar = new yl();
            llVar = new ml();
        }
        om omVar2 = new om(context);
        qk.c cVar = new qk.c(resources);
        qk.d dVar = new qk.d(resources);
        qk.b bVar = new qk.b(resources);
        qk.a aVar2 = new qk.a(resources);
        hl hlVar = new hl(ziVar);
        bn bnVar = new bn();
        en enVar = new en();
        ContentResolver contentResolver = context.getContentResolver();
        registry.a(ByteBuffer.class, new ak());
        registry.a(InputStream.class, new rk(ziVar));
        registry.e("Bitmap", ByteBuffer.class, Bitmap.class, llVar);
        registry.e("Bitmap", InputStream.class, Bitmap.class, emVar);
        if (rh.c()) {
            omVar = omVar2;
            registry.e("Bitmap", ParcelFileDescriptor.class, Bitmap.class, new am(rlVar));
        } else {
            omVar = omVar2;
        }
        registry.e("Bitmap", ParcelFileDescriptor.class, Bitmap.class, chVarH);
        registry.e("Bitmap", AssetFileDescriptor.class, Bitmap.class, hm.c(cjVar));
        registry.d(Bitmap.class, Bitmap.class, tk.a.a());
        registry.e("Bitmap", Bitmap.class, Bitmap.class, new gm());
        registry.b(Bitmap.class, hlVar);
        registry.e("BitmapDrawable", ByteBuffer.class, BitmapDrawable.class, new fl(resources, llVar));
        registry.e("BitmapDrawable", InputStream.class, BitmapDrawable.class, new fl(resources, emVar));
        registry.e("BitmapDrawable", ParcelFileDescriptor.class, BitmapDrawable.class, new fl(resources, chVarH));
        registry.b(BitmapDrawable.class, new gl(cjVar, hlVar));
        registry.e("Gif", InputStream.class, GifDrawable.class, new an(listG, smVar, ziVar));
        registry.e("Gif", ByteBuffer.class, GifDrawable.class, smVar);
        registry.b(GifDrawable.class, new um());
        registry.d(wf.class, wf.class, tk.a.a());
        registry.e("Bitmap", wf.class, Bitmap.class, new ym(cjVar));
        om omVar3 = omVar;
        registry.c(Uri.class, Drawable.class, omVar3);
        registry.c(Uri.class, Bitmap.class, new cm(omVar3, cjVar));
        registry.s(new im.a());
        registry.d(File.class, ByteBuffer.class, new bk.b());
        registry.d(File.class, InputStream.class, new dk.e());
        registry.c(File.class, File.class, new qm());
        registry.d(File.class, ParcelFileDescriptor.class, new dk.b());
        registry.d(File.class, File.class, tk.a.a());
        registry.s(new ph.a(ziVar));
        if (rh.c()) {
            registry.s(new rh.a());
        }
        Class cls = Integer.TYPE;
        registry.d(cls, InputStream.class, cVar);
        registry.d(cls, ParcelFileDescriptor.class, bVar);
        registry.d(Integer.class, InputStream.class, cVar);
        registry.d(Integer.class, ParcelFileDescriptor.class, bVar);
        registry.d(Integer.class, Uri.class, dVar);
        registry.d(cls, AssetFileDescriptor.class, aVar2);
        registry.d(Integer.class, AssetFileDescriptor.class, aVar2);
        registry.d(cls, Uri.class, dVar);
        registry.d(String.class, InputStream.class, new ck.c());
        registry.d(Uri.class, InputStream.class, new ck.c());
        registry.d(String.class, InputStream.class, new sk.c());
        registry.d(String.class, ParcelFileDescriptor.class, new sk.b());
        registry.d(String.class, AssetFileDescriptor.class, new sk.a());
        registry.d(Uri.class, InputStream.class, new xk.a());
        registry.d(Uri.class, InputStream.class, new yj.c(context.getAssets()));
        registry.d(Uri.class, ParcelFileDescriptor.class, new yj.b(context.getAssets()));
        registry.d(Uri.class, InputStream.class, new yk.a(context));
        registry.d(Uri.class, InputStream.class, new zk.a(context));
        if (i3 >= 29) {
            registry.d(Uri.class, InputStream.class, new al.c(context));
            registry.d(Uri.class, ParcelFileDescriptor.class, new al.b(context));
        }
        registry.d(Uri.class, InputStream.class, new uk.d(contentResolver));
        registry.d(Uri.class, ParcelFileDescriptor.class, new uk.b(contentResolver));
        registry.d(Uri.class, AssetFileDescriptor.class, new uk.a(contentResolver));
        registry.d(Uri.class, InputStream.class, new vk.a());
        registry.d(URL.class, InputStream.class, new bl.a());
        registry.d(Uri.class, File.class, new ik.a(context));
        registry.d(ek.class, InputStream.class, new wk.a());
        registry.d(byte[].class, ByteBuffer.class, new zj.a());
        registry.d(byte[].class, InputStream.class, new zj.d());
        registry.d(Uri.class, Uri.class, tk.a.a());
        registry.d(Drawable.class, Drawable.class, tk.a.a());
        registry.c(Drawable.class, Drawable.class, new pm());
        registry.t(Bitmap.class, BitmapDrawable.class, new cn(resources));
        registry.t(Bitmap.class, byte[].class, bnVar);
        registry.t(Drawable.class, byte[].class, new dn(cjVar, bnVar, enVar));
        registry.t(GifDrawable.class, byte[].class, enVar);
        if (i3 >= 23) {
            ch<ByteBuffer, Bitmap> chVarD = hm.d(cjVar);
            registry.c(ByteBuffer.class, Bitmap.class, chVarD);
            registry.c(ByteBuffer.class, BitmapDrawable.class, new fl(resources, chVarD));
        }
        this.c = new mf(context, ziVar, registry, new zo(), aVar, map, list, jiVar, z, i2);
    }

    @GuardedBy("Glide.class")
    public static void a(@NonNull Context context, @Nullable GeneratedAppGlideModule generatedAppGlideModule) throws PackageManager.NameNotFoundException {
        if (j) {
            throw new IllegalStateException("You cannot call Glide.get() in registerComponents(), use the provided Glide instance instead");
        }
        j = true;
        o(context, generatedAppGlideModule);
        j = false;
    }

    @NonNull
    public static kf c(@NonNull Context context) {
        if (i == null) {
            GeneratedAppGlideModule generatedAppGlideModuleD = d(context.getApplicationContext());
            synchronized (kf.class) {
                if (i == null) {
                    a(context, generatedAppGlideModuleD);
                }
            }
        }
        return i;
    }

    @Nullable
    public static GeneratedAppGlideModule d(Context context) {
        try {
            return (GeneratedAppGlideModule) Class.forName("com.bumptech.glide.GeneratedAppGlideModuleImpl").getDeclaredConstructor(Context.class).newInstance(context.getApplicationContext());
        } catch (ClassNotFoundException unused) {
            Log.isLoggable("Glide", 5);
            return null;
        } catch (IllegalAccessException e) {
            s(e);
            throw null;
        } catch (InstantiationException e2) {
            s(e2);
            throw null;
        } catch (NoSuchMethodException e3) {
            s(e3);
            throw null;
        } catch (InvocationTargetException e4) {
            s(e4);
            throw null;
        }
    }

    @Nullable
    public static File j(@NonNull Context context) {
        return k(context, "image_manager_disk_cache");
    }

    @Nullable
    public static File k(@NonNull Context context, @NonNull String str) {
        File cacheDir = context.getCacheDir();
        if (cacheDir == null) {
            Log.isLoggable("Glide", 6);
            return null;
        }
        File file = new File(cacheDir, str);
        if (file.mkdirs() || (file.exists() && file.isDirectory())) {
            return file;
        }
        return null;
    }

    @NonNull
    public static tn n(@Nullable Context context) {
        vp.e(context, "You cannot start a load on a not yet attached View or a Fragment where getActivity() returns null (which usually occurs when getActivity() is called before the Fragment is attached or after the Fragment is destroyed).");
        return c(context).m();
    }

    @GuardedBy("Glide.class")
    public static void o(@NonNull Context context, @Nullable GeneratedAppGlideModule generatedAppGlideModule) throws PackageManager.NameNotFoundException {
        p(context, new lf(), generatedAppGlideModule);
    }

    @GuardedBy("Glide.class")
    public static void p(@NonNull Context context, @NonNull lf lfVar, @Nullable GeneratedAppGlideModule generatedAppGlideModule) throws PackageManager.NameNotFoundException {
        Context applicationContext = context.getApplicationContext();
        List<zn> listEmptyList = Collections.emptyList();
        if (generatedAppGlideModule == null || generatedAppGlideModule.c()) {
            listEmptyList = new bo(applicationContext).a();
        }
        if (generatedAppGlideModule != null && !generatedAppGlideModule.d().isEmpty()) {
            Set<Class<?>> setD = generatedAppGlideModule.d();
            Iterator<zn> it = listEmptyList.iterator();
            while (it.hasNext()) {
                zn next = it.next();
                if (setD.contains(next.getClass())) {
                    if (Log.isLoggable("Glide", 3)) {
                        String str = "AppGlideModule excludes manifest GlideModule: " + next;
                    }
                    it.remove();
                }
            }
        }
        if (Log.isLoggable("Glide", 3)) {
            Iterator<zn> it2 = listEmptyList.iterator();
            while (it2.hasNext()) {
                String str2 = "Discovered GlideModule from manifest: " + it2.next().getClass();
            }
        }
        lfVar.b(generatedAppGlideModule != null ? generatedAppGlideModule.e() : null);
        Iterator<zn> it3 = listEmptyList.iterator();
        while (it3.hasNext()) {
            it3.next().a(applicationContext, lfVar);
        }
        if (generatedAppGlideModule != null) {
            generatedAppGlideModule.a(applicationContext, lfVar);
        }
        kf kfVarA = lfVar.a(applicationContext);
        for (zn znVar : listEmptyList) {
            try {
                znVar.b(applicationContext, kfVarA, kfVarA.d);
            } catch (AbstractMethodError e) {
                throw new IllegalStateException("Attempting to register a Glide v3 module. If you see this, you or one of your dependencies may be including Glide v3 even though you're using Glide v4. You'll need to find and remove (or update) the offending dependency. The v3 module name is: " + znVar.getClass().getName(), e);
            }
        }
        if (generatedAppGlideModule != null) {
            generatedAppGlideModule.b(applicationContext, kfVarA, kfVarA.d);
        }
        applicationContext.registerComponentCallbacks(kfVarA);
        i = kfVarA;
    }

    public static void s(Exception exc) {
        throw new IllegalStateException("GeneratedAppGlideModuleImpl is implemented incorrectly. If you've manually implemented this class, remove your implementation. The Annotation processor will generate a correct implementation.", exc);
    }

    @NonNull
    public static rf v(@NonNull Activity activity) {
        return n(activity).i(activity);
    }

    @NonNull
    public static rf w(@NonNull Context context) {
        return n(context).k(context);
    }

    @NonNull
    public static rf x(@NonNull View view) {
        return n(view.getContext()).l(view);
    }

    @NonNull
    public static rf y(@NonNull Fragment fragment) {
        return n(fragment.getContext()).m(fragment);
    }

    @NonNull
    public static rf z(@NonNull FragmentActivity fragmentActivity) {
        return n(fragmentActivity).n(fragmentActivity);
    }

    public void b() {
        wp.b();
        this.b.b();
        this.a.b();
        this.e.b();
    }

    @NonNull
    public zi e() {
        return this.e;
    }

    @NonNull
    public cj f() {
        return this.a;
    }

    public ln g() {
        return this.g;
    }

    @NonNull
    public Context h() {
        return this.c.getBaseContext();
    }

    @NonNull
    public mf i() {
        return this.c;
    }

    @NonNull
    public Registry l() {
        return this.d;
    }

    @NonNull
    public tn m() {
        return this.f;
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        b();
    }

    @Override // android.content.ComponentCallbacks2
    public void onTrimMemory(int i2) {
        t(i2);
    }

    public void q(rf rfVar) {
        synchronized (this.h) {
            if (this.h.contains(rfVar)) {
                throw new IllegalStateException("Cannot register already registered manager");
            }
            this.h.add(rfVar);
        }
    }

    public boolean r(@NonNull cp<?> cpVar) {
        synchronized (this.h) {
            Iterator<rf> it = this.h.iterator();
            while (it.hasNext()) {
                if (it.next().C(cpVar)) {
                    return true;
                }
            }
            return false;
        }
    }

    public void t(int i2) {
        wp.b();
        Iterator<rf> it = this.h.iterator();
        while (it.hasNext()) {
            it.next().onTrimMemory(i2);
        }
        this.b.a(i2);
        this.a.a(i2);
        this.e.a(i2);
    }

    public void u(rf rfVar) {
        synchronized (this.h) {
            if (!this.h.contains(rfVar)) {
                throw new IllegalStateException("Cannot unregister not yet registered manager");
            }
            this.h.remove(rfVar);
        }
    }
}
