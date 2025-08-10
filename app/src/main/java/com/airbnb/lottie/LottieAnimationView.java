package com.airbnb.lottie;

import android.animation.Animator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.AttrRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.FloatRange;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RawRes;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.view.ViewCompat;
import com.google.common.collect.LinkedHashMultimap;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import dc.c7;
import dc.d7;
import dc.dd;
import dc.e7;
import dc.f7;
import dc.g7;
import dc.h7;
import dc.hd;
import dc.j7;
import dc.kd;
import dc.l7;
import dc.l9;
import dc.m7;
import dc.n7;
import dc.o7;
import dc.p7;
import dc.q7;
import dc.r7;
import dc.s7;
import dc.t7;
import dc.u7;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public class LottieAnimationView extends AppCompatImageView {
    public static final String t = LottieAnimationView.class.getSimpleName();
    public static final j7<Throwable> u = new a();
    public final j7<f7> a;
    public final j7<Throwable> b;

    @Nullable
    public j7<Throwable> c;

    @DrawableRes
    public int d;
    public final h7 e;
    public boolean f;
    public String g;

    @RawRes
    public int h;
    public boolean i;
    public boolean j;
    public boolean k;
    public boolean l;
    public boolean m;
    public boolean n;
    public s7 o;
    public final Set<l7> p;
    public int q;

    @Nullable
    public o7<f7> r;

    @Nullable
    public f7 s;

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        public String a;
        public int b;
        public float c;
        public boolean d;
        public String e;
        public int f;
        public int g;

        public class a implements Parcelable.Creator<SavedState> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        }

        public /* synthetic */ SavedState(Parcel parcel, a aVar) {
            this(parcel);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.a);
            parcel.writeFloat(this.c);
            parcel.writeInt(this.d ? 1 : 0);
            parcel.writeString(this.e);
            parcel.writeInt(this.f);
            parcel.writeInt(this.g);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            this.a = parcel.readString();
            this.c = parcel.readFloat();
            this.d = parcel.readInt() == 1;
            this.e = parcel.readString();
            this.f = parcel.readInt();
            this.g = parcel.readInt();
        }
    }

    public class a implements j7<Throwable> {
        @Override // dc.j7
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResult(Throwable th) {
            if (!hd.k(th)) {
                throw new IllegalStateException("Unable to parse composition", th);
            }
            dd.d("Unable to load composition.", th);
        }
    }

    public class b implements j7<f7> {
        public b() {
        }

        @Override // dc.j7
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResult(f7 f7Var) {
            LottieAnimationView.this.setComposition(f7Var);
        }
    }

    public class c implements j7<Throwable> {
        public c() {
        }

        @Override // dc.j7
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResult(Throwable th) {
            if (LottieAnimationView.this.d != 0) {
                LottieAnimationView lottieAnimationView = LottieAnimationView.this;
                lottieAnimationView.setImageResource(lottieAnimationView.d);
            }
            (LottieAnimationView.this.c == null ? LottieAnimationView.u : LottieAnimationView.this.c).onResult(th);
        }
    }

    public class d implements Callable<n7<f7>> {
        public final /* synthetic */ int a;

        public d(int i) {
            this.a = i;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public n7<f7> call() {
            return LottieAnimationView.this.n ? g7.o(LottieAnimationView.this.getContext(), this.a) : g7.p(LottieAnimationView.this.getContext(), this.a, null);
        }
    }

    public class e implements Callable<n7<f7>> {
        public final /* synthetic */ String a;

        public e(String str) {
            this.a = str;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public n7<f7> call() {
            return LottieAnimationView.this.n ? g7.f(LottieAnimationView.this.getContext(), this.a) : g7.g(LottieAnimationView.this.getContext(), this.a, null);
        }
    }

    public static /* synthetic */ class f {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[s7.values().length];
            a = iArr;
            try {
                iArr[s7.HARDWARE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[s7.SOFTWARE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[s7.AUTOMATIC.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public LottieAnimationView(Context context) {
        super(context);
        this.a = new b();
        this.b = new c();
        this.d = 0;
        this.e = new h7();
        this.i = false;
        this.j = false;
        this.k = false;
        this.l = false;
        this.m = false;
        this.n = true;
        this.o = s7.AUTOMATIC;
        this.p = new HashSet();
        this.q = 0;
        n(null, q7.lottieAnimationViewStyle);
    }

    private void setCompositionTask(o7<f7> o7Var) {
        i();
        h();
        o7Var.f(this.a);
        o7Var.e(this.b);
        this.r = o7Var;
    }

    @Override // android.view.View
    public void buildDrawingCache(boolean z) {
        e7.a("buildDrawingCache");
        this.q++;
        super.buildDrawingCache(z);
        if (this.q == 1 && getWidth() > 0 && getHeight() > 0 && getLayerType() == 1 && getDrawingCache(z) == null) {
            setRenderMode(s7.HARDWARE);
        }
        this.q--;
        e7.b("buildDrawingCache");
    }

    public void e(Animator.AnimatorListener animatorListener) {
        this.e.c(animatorListener);
    }

    public <T> void f(l9 l9Var, T t2, kd<T> kdVar) {
        this.e.d(l9Var, t2, kdVar);
    }

    @MainThread
    public void g() {
        this.k = false;
        this.j = false;
        this.i = false;
        this.e.i();
        k();
    }

    @Nullable
    public f7 getComposition() {
        return this.s;
    }

    public long getDuration() {
        f7 f7Var = this.s;
        if (f7Var != null) {
            return (long) f7Var.d();
        }
        return 0L;
    }

    public int getFrame() {
        return this.e.t();
    }

    @Nullable
    public String getImageAssetsFolder() {
        return this.e.w();
    }

    public float getMaxFrame() {
        return this.e.x();
    }

    public float getMinFrame() {
        return this.e.z();
    }

    @Nullable
    public p7 getPerformanceTracker() {
        return this.e.A();
    }

    @FloatRange(from = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, to = LinkedHashMultimap.VALUE_SET_LOAD_FACTOR)
    public float getProgress() {
        return this.e.B();
    }

    public int getRepeatCount() {
        return this.e.C();
    }

    public int getRepeatMode() {
        return this.e.D();
    }

    public float getScale() {
        return this.e.E();
    }

    public float getSpeed() {
        return this.e.F();
    }

    public final void h() {
        o7<f7> o7Var = this.r;
        if (o7Var != null) {
            o7Var.k(this.a);
            this.r.j(this.b);
        }
    }

    public final void i() {
        this.s = null;
        this.e.j();
    }

    @Override // android.widget.ImageView, android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(@NonNull Drawable drawable) {
        Drawable drawable2 = getDrawable();
        h7 h7Var = this.e;
        if (drawable2 == h7Var) {
            super.invalidateDrawable(h7Var);
        } else {
            super.invalidateDrawable(drawable);
        }
    }

    public void j(boolean z) {
        this.e.n(z);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void k() {
        /*
            r5 = this;
            int[] r0 = com.airbnb.lottie.LottieAnimationView.f.a
            dc.s7 r1 = r5.o
            int r1 = r1.ordinal()
            r0 = r0[r1]
            r1 = 2
            r2 = 1
            if (r0 == r2) goto L46
            if (r0 == r1) goto L13
            r3 = 3
            if (r0 == r3) goto L15
        L13:
            r1 = 1
            goto L46
        L15:
            dc.f7 r0 = r5.s
            r3 = 0
            if (r0 == 0) goto L27
            boolean r0 = r0.p()
            if (r0 == 0) goto L27
            int r0 = android.os.Build.VERSION.SDK_INT
            r4 = 28
            if (r0 >= r4) goto L27
            goto L44
        L27:
            dc.f7 r0 = r5.s
            if (r0 == 0) goto L33
            int r0 = r0.l()
            r4 = 4
            if (r0 <= r4) goto L33
            goto L44
        L33:
            int r0 = android.os.Build.VERSION.SDK_INT
            r4 = 21
            if (r0 >= r4) goto L3a
            goto L44
        L3a:
            r4 = 24
            if (r0 == r4) goto L44
            r4 = 25
            if (r0 != r4) goto L43
            goto L44
        L43:
            r3 = 1
        L44:
            if (r3 == 0) goto L13
        L46:
            int r0 = r5.getLayerType()
            if (r1 == r0) goto L50
            r0 = 0
            r5.setLayerType(r1, r0)
        L50:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.LottieAnimationView.k():void");
    }

    public final o7<f7> l(String str) {
        return isInEditMode() ? new o7<>(new e(str), true) : this.n ? g7.d(getContext(), str) : g7.e(getContext(), str, null);
    }

    public final o7<f7> m(@RawRes int i) {
        return isInEditMode() ? new o7<>(new d(i), true) : this.n ? g7.m(getContext(), i) : g7.n(getContext(), i, null);
    }

    public final void n(@Nullable AttributeSet attributeSet, @AttrRes int i) {
        String string;
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, r7.LottieAnimationView, i, 0);
        this.n = typedArrayObtainStyledAttributes.getBoolean(r7.LottieAnimationView_lottie_cacheComposition, true);
        int i2 = r7.LottieAnimationView_lottie_rawRes;
        boolean zHasValue = typedArrayObtainStyledAttributes.hasValue(i2);
        int i3 = r7.LottieAnimationView_lottie_fileName;
        boolean zHasValue2 = typedArrayObtainStyledAttributes.hasValue(i3);
        int i4 = r7.LottieAnimationView_lottie_url;
        boolean zHasValue3 = typedArrayObtainStyledAttributes.hasValue(i4);
        if (zHasValue && zHasValue2) {
            throw new IllegalArgumentException("lottie_rawRes and lottie_fileName cannot be used at the same time. Please use only one at once.");
        }
        if (zHasValue) {
            int resourceId = typedArrayObtainStyledAttributes.getResourceId(i2, 0);
            if (resourceId != 0) {
                setAnimation(resourceId);
            }
        } else if (zHasValue2) {
            String string2 = typedArrayObtainStyledAttributes.getString(i3);
            if (string2 != null) {
                setAnimation(string2);
            }
        } else if (zHasValue3 && (string = typedArrayObtainStyledAttributes.getString(i4)) != null) {
            setAnimationFromUrl(string);
        }
        setFallbackResource(typedArrayObtainStyledAttributes.getResourceId(r7.LottieAnimationView_lottie_fallbackRes, 0));
        if (typedArrayObtainStyledAttributes.getBoolean(r7.LottieAnimationView_lottie_autoPlay, false)) {
            this.k = true;
            this.m = true;
        }
        if (typedArrayObtainStyledAttributes.getBoolean(r7.LottieAnimationView_lottie_loop, false)) {
            this.e.i0(-1);
        }
        int i5 = r7.LottieAnimationView_lottie_repeatMode;
        if (typedArrayObtainStyledAttributes.hasValue(i5)) {
            setRepeatMode(typedArrayObtainStyledAttributes.getInt(i5, 1));
        }
        int i6 = r7.LottieAnimationView_lottie_repeatCount;
        if (typedArrayObtainStyledAttributes.hasValue(i6)) {
            setRepeatCount(typedArrayObtainStyledAttributes.getInt(i6, -1));
        }
        int i7 = r7.LottieAnimationView_lottie_speed;
        if (typedArrayObtainStyledAttributes.hasValue(i7)) {
            setSpeed(typedArrayObtainStyledAttributes.getFloat(i7, 1.0f));
        }
        setImageAssetsFolder(typedArrayObtainStyledAttributes.getString(r7.LottieAnimationView_lottie_imageAssetsFolder));
        setProgress(typedArrayObtainStyledAttributes.getFloat(r7.LottieAnimationView_lottie_progress, 0.0f));
        j(typedArrayObtainStyledAttributes.getBoolean(r7.LottieAnimationView_lottie_enableMergePathsForKitKatAndAbove, false));
        int i8 = r7.LottieAnimationView_lottie_colorFilter;
        if (typedArrayObtainStyledAttributes.hasValue(i8)) {
            f(new l9("**"), m7.E, new kd(new t7(AppCompatResources.getColorStateList(getContext(), typedArrayObtainStyledAttributes.getResourceId(i8, -1)).getDefaultColor())));
        }
        int i9 = r7.LottieAnimationView_lottie_scale;
        if (typedArrayObtainStyledAttributes.hasValue(i9)) {
            this.e.l0(typedArrayObtainStyledAttributes.getFloat(i9, 1.0f));
        }
        int i10 = r7.LottieAnimationView_lottie_renderMode;
        if (typedArrayObtainStyledAttributes.hasValue(i10)) {
            s7 s7Var = s7.AUTOMATIC;
            int iOrdinal = typedArrayObtainStyledAttributes.getInt(i10, s7Var.ordinal());
            if (iOrdinal >= s7.values().length) {
                iOrdinal = s7Var.ordinal();
            }
            setRenderMode(s7.values()[iOrdinal]);
        }
        setIgnoreDisabledSystemAnimations(typedArrayObtainStyledAttributes.getBoolean(r7.LottieAnimationView_lottie_ignoreDisabledSystemAnimations, false));
        typedArrayObtainStyledAttributes.recycle();
        this.e.n0(Boolean.valueOf(hd.f(getContext()) != 0.0f));
        k();
        this.f = true;
    }

    public boolean o() {
        return this.e.I();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!isInEditMode() && (this.m || this.k)) {
            r();
            this.m = false;
            this.k = false;
        }
        if (Build.VERSION.SDK_INT < 23) {
            onVisibilityChanged(this, getVisibility());
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        if (o()) {
            g();
            this.k = true;
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        String str = savedState.a;
        this.g = str;
        if (!TextUtils.isEmpty(str)) {
            setAnimation(this.g);
        }
        int i = savedState.b;
        this.h = i;
        if (i != 0) {
            setAnimation(i);
        }
        setProgress(savedState.c);
        if (savedState.d) {
            r();
        }
        this.e.U(savedState.e);
        setRepeatMode(savedState.f);
        setRepeatCount(savedState.g);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.a = this.g;
        savedState.b = this.h;
        savedState.c = this.e.B();
        savedState.d = this.e.I() || (!ViewCompat.isAttachedToWindow(this) && this.k);
        savedState.e = this.e.w();
        savedState.f = this.e.D();
        savedState.g = this.e.C();
        return savedState;
    }

    @Override // android.view.View
    public void onVisibilityChanged(@NonNull View view, int i) {
        if (this.f) {
            if (!isShown()) {
                if (o()) {
                    q();
                    this.j = true;
                    return;
                }
                return;
            }
            if (this.j) {
                s();
            } else if (this.i) {
                r();
            }
            this.j = false;
            this.i = false;
        }
    }

    @Deprecated
    public void p(boolean z) {
        this.e.i0(z ? -1 : 0);
    }

    @MainThread
    public void q() {
        this.m = false;
        this.k = false;
        this.j = false;
        this.i = false;
        this.e.K();
        k();
    }

    @MainThread
    public void r() {
        if (!isShown()) {
            this.i = true;
        } else {
            this.e.L();
            k();
        }
    }

    @MainThread
    public void s() {
        if (isShown()) {
            this.e.N();
            k();
        } else {
            this.i = false;
            this.j = true;
        }
    }

    public void setAnimation(@RawRes int i) {
        this.h = i;
        this.g = null;
        setCompositionTask(m(i));
    }

    @Deprecated
    public void setAnimationFromJson(String str) {
        setAnimationFromJson(str, null);
    }

    public void setAnimationFromUrl(String str) {
        setCompositionTask(this.n ? g7.q(getContext(), str) : g7.r(getContext(), str, null));
    }

    public void setApplyingOpacityToLayersEnabled(boolean z) {
        this.e.O(z);
    }

    public void setCacheComposition(boolean z) {
        this.n = z;
    }

    public void setComposition(@NonNull f7 f7Var) {
        if (e7.a) {
            String str = "Set Composition \n" + f7Var;
        }
        this.e.setCallback(this);
        this.s = f7Var;
        this.l = true;
        boolean zP = this.e.P(f7Var);
        this.l = false;
        k();
        if (getDrawable() != this.e || zP) {
            if (!zP) {
                t();
            }
            onVisibilityChanged(this, getVisibility());
            requestLayout();
            Iterator<l7> it = this.p.iterator();
            while (it.hasNext()) {
                it.next().a(f7Var);
            }
        }
    }

    public void setFailureListener(@Nullable j7<Throwable> j7Var) {
        this.c = j7Var;
    }

    public void setFallbackResource(@DrawableRes int i) {
        this.d = i;
    }

    public void setFontAssetDelegate(c7 c7Var) {
        this.e.Q(c7Var);
    }

    public void setFrame(int i) {
        this.e.R(i);
    }

    public void setIgnoreDisabledSystemAnimations(boolean z) {
        this.e.S(z);
    }

    public void setImageAssetDelegate(d7 d7Var) {
        this.e.T(d7Var);
    }

    public void setImageAssetsFolder(String str) {
        this.e.U(str);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        h();
        super.setImageBitmap(bitmap);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        h();
        super.setImageDrawable(drawable);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(int i) {
        h();
        super.setImageResource(i);
    }

    public void setMaxFrame(int i) {
        this.e.V(i);
    }

    public void setMaxProgress(@FloatRange(from = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, to = LinkedHashMultimap.VALUE_SET_LOAD_FACTOR) float f2) {
        this.e.X(f2);
    }

    public void setMinAndMaxFrame(String str) {
        this.e.Z(str);
    }

    public void setMinAndMaxProgress(@FloatRange(from = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, to = LinkedHashMultimap.VALUE_SET_LOAD_FACTOR) float f2, @FloatRange(from = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, to = LinkedHashMultimap.VALUE_SET_LOAD_FACTOR) float f3) {
        this.e.b0(f2, f3);
    }

    public void setMinFrame(int i) {
        this.e.c0(i);
    }

    public void setMinProgress(float f2) {
        this.e.e0(f2);
    }

    public void setOutlineMasksAndMattes(boolean z) {
        this.e.f0(z);
    }

    public void setPerformanceTrackingEnabled(boolean z) {
        this.e.g0(z);
    }

    public void setProgress(@FloatRange(from = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, to = LinkedHashMultimap.VALUE_SET_LOAD_FACTOR) float f2) {
        this.e.h0(f2);
    }

    public void setRenderMode(s7 s7Var) {
        this.o = s7Var;
        k();
    }

    public void setRepeatCount(int i) {
        this.e.i0(i);
    }

    public void setRepeatMode(int i) {
        this.e.j0(i);
    }

    public void setSafeMode(boolean z) {
        this.e.k0(z);
    }

    public void setScale(float f2) {
        this.e.l0(f2);
        if (getDrawable() == this.e) {
            t();
        }
    }

    public void setSpeed(float f2) {
        this.e.m0(f2);
    }

    public void setTextDelegate(u7 u7Var) {
        this.e.o0(u7Var);
    }

    public final void t() {
        boolean zO = o();
        setImageDrawable(null);
        setImageDrawable(this.e);
        if (zO) {
            this.e.N();
        }
    }

    @Override // android.view.View
    public void unscheduleDrawable(Drawable drawable) {
        h7 h7Var;
        if (!this.l && drawable == (h7Var = this.e) && h7Var.I()) {
            q();
        } else if (!this.l && (drawable instanceof h7)) {
            h7 h7Var2 = (h7) drawable;
            if (h7Var2.I()) {
                h7Var2.K();
            }
        }
        super.unscheduleDrawable(drawable);
    }

    public void setAnimationFromJson(String str, @Nullable String str2) {
        setAnimation(new ByteArrayInputStream(str.getBytes()), str2);
    }

    public void setMaxFrame(String str) {
        this.e.W(str);
    }

    public void setMinAndMaxFrame(String str, String str2, boolean z) {
        this.e.a0(str, str2, z);
    }

    public void setMinFrame(String str) {
        this.e.d0(str);
    }

    public void setMinAndMaxFrame(int i, int i2) {
        this.e.Y(i, i2);
    }

    public void setAnimation(String str) {
        this.g = str;
        this.h = 0;
        setCompositionTask(l(str));
    }

    public void setAnimationFromUrl(String str, @Nullable String str2) {
        setCompositionTask(g7.r(getContext(), str, str2));
    }

    public void setAnimation(InputStream inputStream, @Nullable String str) {
        setCompositionTask(g7.h(inputStream, str));
    }

    public LottieAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = new b();
        this.b = new c();
        this.d = 0;
        this.e = new h7();
        this.i = false;
        this.j = false;
        this.k = false;
        this.l = false;
        this.m = false;
        this.n = true;
        this.o = s7.AUTOMATIC;
        this.p = new HashSet();
        this.q = 0;
        n(attributeSet, q7.lottieAnimationViewStyle);
    }

    public LottieAnimationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = new b();
        this.b = new c();
        this.d = 0;
        this.e = new h7();
        this.i = false;
        this.j = false;
        this.k = false;
        this.l = false;
        this.m = false;
        this.n = true;
        this.o = s7.AUTOMATIC;
        this.p = new HashSet();
        this.q = 0;
        n(attributeSet, i);
    }
}
