package dc;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import androidx.annotation.CheckResult;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RawRes;
import java.io.File;

/* compiled from: GlideRequests.java */
/* loaded from: classes4.dex */
public class hj3 extends rf {
    public hj3(@NonNull kf kfVar, @NonNull pn pnVar, @NonNull un unVar, @NonNull Context context) {
        super(kfVar, pnVar, unVar, context);
    }

    @Override // dc.rf
    public void A(@NonNull qo qoVar) {
        if (qoVar instanceof fj3) {
            super.A(qoVar);
        } else {
            super.A(new fj3().a(qoVar));
        }
    }

    @Override // dc.rf
    @NonNull
    /* renamed from: F, reason: merged with bridge method [inline-methods] */
    public synchronized hj3 c(@NonNull qo qoVar) {
        super.c(qoVar);
        return this;
    }

    @Override // dc.rf
    @NonNull
    @CheckResult
    /* renamed from: G, reason: merged with bridge method [inline-methods] */
    public <ResourceType> gj3<ResourceType> d(@NonNull Class<ResourceType> cls) {
        return new gj3<>(this.a, this, cls, this.b);
    }

    @Override // dc.rf
    @NonNull
    @CheckResult
    /* renamed from: H, reason: merged with bridge method [inline-methods] */
    public gj3<Bitmap> j() {
        return (gj3) super.j();
    }

    @Override // dc.rf
    @NonNull
    @CheckResult
    /* renamed from: I, reason: merged with bridge method [inline-methods] */
    public gj3<Drawable> k() {
        return (gj3) super.k();
    }

    @Override // dc.rf
    @NonNull
    @CheckResult
    /* renamed from: J, reason: merged with bridge method [inline-methods] */
    public gj3<Drawable> p(@Nullable Bitmap bitmap) {
        return (gj3) super.p(bitmap);
    }

    @Override // dc.rf
    @NonNull
    @CheckResult
    /* renamed from: K, reason: merged with bridge method [inline-methods] */
    public gj3<Drawable> q(@Nullable Drawable drawable) {
        return (gj3) super.q(drawable);
    }

    @Override // dc.rf
    @NonNull
    @CheckResult
    /* renamed from: L, reason: merged with bridge method [inline-methods] */
    public gj3<Drawable> r(@Nullable Uri uri) {
        return (gj3) super.r(uri);
    }

    @Override // dc.rf
    @NonNull
    @CheckResult
    /* renamed from: M, reason: merged with bridge method [inline-methods] */
    public gj3<Drawable> s(@Nullable File file) {
        return (gj3) super.s(file);
    }

    @Override // dc.rf
    @NonNull
    @CheckResult
    /* renamed from: N, reason: merged with bridge method [inline-methods] */
    public gj3<Drawable> t(@Nullable @DrawableRes @RawRes Integer num) {
        return (gj3) super.t(num);
    }

    @Override // dc.rf
    @NonNull
    @CheckResult
    /* renamed from: O, reason: merged with bridge method [inline-methods] */
    public gj3<Drawable> u(@Nullable Object obj) {
        return (gj3) super.u(obj);
    }

    @Override // dc.rf
    @NonNull
    @CheckResult
    /* renamed from: P, reason: merged with bridge method [inline-methods] */
    public gj3<Drawable> v(@Nullable String str) {
        return (gj3) super.v(str);
    }
}
