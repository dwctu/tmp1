package dc;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import androidx.annotation.CheckResult;
import androidx.annotation.DrawableRes;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RawRes;
import com.google.common.collect.LinkedHashMultimap;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.io.File;

/* compiled from: GlideRequest.java */
/* loaded from: classes4.dex */
public class gj3<TranscodeType> extends qf<TranscodeType> implements Cloneable {
    public gj3(@NonNull kf kfVar, @NonNull rf rfVar, @NonNull Class<TranscodeType> cls, @NonNull Context context) {
        super(kfVar, rfVar, cls, context);
    }

    @Override // dc.qf
    @NonNull
    @CheckResult
    /* renamed from: O0, reason: merged with bridge method [inline-methods] */
    public gj3<TranscodeType> p0(@Nullable po<TranscodeType> poVar) {
        super.p0(poVar);
        return this;
    }

    @Override // dc.qf
    @NonNull
    @CheckResult
    /* renamed from: P0, reason: merged with bridge method [inline-methods] */
    public gj3<TranscodeType> a(@NonNull jo<?> joVar) {
        return (gj3) super.a(joVar);
    }

    @Override // dc.jo
    @NonNull
    @CheckResult
    /* renamed from: Q0, reason: merged with bridge method [inline-methods] */
    public gj3<TranscodeType> c() {
        return (gj3) super.c();
    }

    @Override // dc.qf
    @CheckResult
    /* renamed from: R0, reason: merged with bridge method [inline-methods] */
    public gj3<TranscodeType> clone() {
        return (gj3) super.clone();
    }

    @Override // dc.jo
    @NonNull
    @CheckResult
    /* renamed from: S0, reason: merged with bridge method [inline-methods] */
    public gj3<TranscodeType> e(@NonNull Class<?> cls) {
        return (gj3) super.e(cls);
    }

    @Override // dc.jo
    @NonNull
    @CheckResult
    /* renamed from: T0, reason: merged with bridge method [inline-methods] */
    public gj3<TranscodeType> f(@NonNull ii iiVar) {
        return (gj3) super.f(iiVar);
    }

    @Override // dc.jo
    @NonNull
    @CheckResult
    /* renamed from: U0, reason: merged with bridge method [inline-methods] */
    public gj3<TranscodeType> g(@NonNull ql qlVar) {
        return (gj3) super.g(qlVar);
    }

    @Override // dc.jo
    @NonNull
    @CheckResult
    /* renamed from: V0, reason: merged with bridge method [inline-methods] */
    public gj3<TranscodeType> h(@DrawableRes int i) {
        return (gj3) super.h(i);
    }

    @Override // dc.jo
    @NonNull
    @CheckResult
    /* renamed from: W0, reason: merged with bridge method [inline-methods] */
    public gj3<TranscodeType> i(@Nullable Drawable drawable) {
        return (gj3) super.i(drawable);
    }

    @Override // dc.jo
    @NonNull
    @CheckResult
    /* renamed from: X0, reason: merged with bridge method [inline-methods] */
    public gj3<TranscodeType> k(@DrawableRes int i) {
        return (gj3) super.k(i);
    }

    @Override // dc.jo
    @NonNull
    @CheckResult
    /* renamed from: Y0, reason: merged with bridge method [inline-methods] */
    public gj3<TranscodeType> l() {
        return (gj3) super.l();
    }

    @Override // dc.qf
    @NonNull
    @CheckResult
    /* renamed from: Z0, reason: merged with bridge method [inline-methods] */
    public gj3<TranscodeType> C0(@Nullable po<TranscodeType> poVar) {
        return (gj3) super.C0(poVar);
    }

    @Override // dc.qf
    @NonNull
    @CheckResult
    /* renamed from: a1, reason: merged with bridge method [inline-methods] */
    public gj3<TranscodeType> D0(@Nullable Bitmap bitmap) {
        return (gj3) super.D0(bitmap);
    }

    @Override // dc.qf
    @NonNull
    @CheckResult
    /* renamed from: b1, reason: merged with bridge method [inline-methods] */
    public gj3<TranscodeType> E0(@Nullable Drawable drawable) {
        return (gj3) super.E0(drawable);
    }

    @Override // dc.qf
    @NonNull
    @CheckResult
    /* renamed from: c1, reason: merged with bridge method [inline-methods] */
    public gj3<TranscodeType> F0(@Nullable Uri uri) {
        super.F0(uri);
        return this;
    }

    @Override // dc.qf
    @NonNull
    @CheckResult
    /* renamed from: d1, reason: merged with bridge method [inline-methods] */
    public gj3<TranscodeType> G0(@Nullable File file) {
        super.G0(file);
        return this;
    }

    @Override // dc.qf
    @NonNull
    @CheckResult
    /* renamed from: e1, reason: merged with bridge method [inline-methods] */
    public gj3<TranscodeType> H0(@Nullable @DrawableRes @RawRes Integer num) {
        return (gj3) super.H0(num);
    }

    @Override // dc.qf
    @NonNull
    @CheckResult
    /* renamed from: f1, reason: merged with bridge method [inline-methods] */
    public gj3<TranscodeType> I0(@Nullable Object obj) {
        super.I0(obj);
        return this;
    }

    @Override // dc.qf
    @NonNull
    @CheckResult
    /* renamed from: g1, reason: merged with bridge method [inline-methods] */
    public gj3<TranscodeType> J0(@Nullable String str) {
        super.J0(str);
        return this;
    }

    @Override // dc.jo
    @NonNull
    @CheckResult
    /* renamed from: h1, reason: merged with bridge method [inline-methods] */
    public gj3<TranscodeType> Q() {
        return (gj3) super.Q();
    }

    @Override // dc.jo
    @NonNull
    @CheckResult
    /* renamed from: i1, reason: merged with bridge method [inline-methods] */
    public gj3<TranscodeType> R() {
        return (gj3) super.R();
    }

    @Override // dc.jo
    @NonNull
    @CheckResult
    /* renamed from: j1, reason: merged with bridge method [inline-methods] */
    public gj3<TranscodeType> S() {
        return (gj3) super.S();
    }

    @Override // dc.jo
    @NonNull
    @CheckResult
    /* renamed from: k1, reason: merged with bridge method [inline-methods] */
    public gj3<TranscodeType> W(int i, int i2) {
        return (gj3) super.W(i, i2);
    }

    @Override // dc.jo
    @NonNull
    @CheckResult
    /* renamed from: l1, reason: merged with bridge method [inline-methods] */
    public gj3<TranscodeType> X(@DrawableRes int i) {
        return (gj3) super.X(i);
    }

    @Override // dc.jo
    @NonNull
    @CheckResult
    /* renamed from: m1, reason: merged with bridge method [inline-methods] */
    public gj3<TranscodeType> Y(@Nullable Drawable drawable) {
        return (gj3) super.Y(drawable);
    }

    @Override // dc.jo
    @NonNull
    @CheckResult
    /* renamed from: n1, reason: merged with bridge method [inline-methods] */
    public gj3<TranscodeType> Z(@NonNull of ofVar) {
        return (gj3) super.Z(ofVar);
    }

    @Override // dc.jo
    @NonNull
    @CheckResult
    /* renamed from: o1, reason: merged with bridge method [inline-methods] */
    public <Y> gj3<TranscodeType> e0(@NonNull zg<Y> zgVar, @NonNull Y y) {
        return (gj3) super.e0(zgVar, y);
    }

    @Override // dc.jo
    @NonNull
    @CheckResult
    /* renamed from: p1, reason: merged with bridge method [inline-methods] */
    public gj3<TranscodeType> f0(@NonNull xg xgVar) {
        return (gj3) super.f0(xgVar);
    }

    @Override // dc.jo
    @NonNull
    @CheckResult
    /* renamed from: q1, reason: merged with bridge method [inline-methods] */
    public gj3<TranscodeType> g0(@FloatRange(from = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, to = LinkedHashMultimap.VALUE_SET_LOAD_FACTOR) float f) {
        return (gj3) super.g0(f);
    }

    @Override // dc.jo
    @NonNull
    @CheckResult
    /* renamed from: r1, reason: merged with bridge method [inline-methods] */
    public gj3<TranscodeType> h0(boolean z) {
        return (gj3) super.h0(z);
    }

    @Override // dc.jo
    @NonNull
    @CheckResult
    /* renamed from: s1, reason: merged with bridge method [inline-methods] */
    public gj3<TranscodeType> i0(@IntRange(from = 0) int i) {
        return (gj3) super.i0(i);
    }

    @Override // dc.jo
    @NonNull
    @CheckResult
    /* renamed from: t1, reason: merged with bridge method [inline-methods] */
    public gj3<TranscodeType> j0(@NonNull eh<Bitmap> ehVar) {
        return (gj3) super.j0(ehVar);
    }

    @Override // dc.jo
    @NonNull
    @CheckResult
    /* renamed from: u1, reason: merged with bridge method [inline-methods] */
    public gj3<TranscodeType> n0(@NonNull eh<Bitmap>... ehVarArr) {
        return (gj3) super.n0(ehVarArr);
    }

    @Override // dc.qf
    @NonNull
    @CheckResult
    /* renamed from: v1, reason: merged with bridge method [inline-methods] */
    public gj3<TranscodeType> N0(@NonNull sf<?, ? super TranscodeType> sfVar) {
        super.N0(sfVar);
        return this;
    }

    @Override // dc.jo
    @NonNull
    @CheckResult
    /* renamed from: w1, reason: merged with bridge method [inline-methods] */
    public gj3<TranscodeType> o0(boolean z) {
        return (gj3) super.o0(z);
    }
}
