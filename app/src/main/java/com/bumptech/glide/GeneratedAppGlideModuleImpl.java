package com.bumptech.glide;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import com.wear.util.glide.GroupIconModule;
import dc.Cif;
import dc.cg;
import dc.kf;
import dc.lf;
import java.util.Collections;
import java.util.Set;

/* loaded from: classes.dex */
public final class GeneratedAppGlideModuleImpl extends GeneratedAppGlideModule {
    public final GroupIconModule a = new GroupIconModule();

    public GeneratedAppGlideModuleImpl(Context context) {
        Log.isLoggable("Glide", 3);
    }

    @Override // dc.xn, dc.yn
    public void a(@NonNull Context context, @NonNull lf lfVar) {
        this.a.a(context, lfVar);
    }

    @Override // dc.ao, dc.co
    public void b(@NonNull Context context, @NonNull kf kfVar, @NonNull Registry registry) {
        new cg().b(context, kfVar, registry);
        this.a.b(context, kfVar, registry);
    }

    @Override // dc.xn
    public boolean c() {
        return this.a.c();
    }

    @Override // com.bumptech.glide.GeneratedAppGlideModule
    @NonNull
    public Set<Class<?>> d() {
        return Collections.emptySet();
    }

    @Override // com.bumptech.glide.GeneratedAppGlideModule
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public Cif e() {
        return new Cif();
    }
}
