package dc;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.TypedValue;
import android.util.Xml;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.R;
import androidx.collection.ArrayMap;
import androidx.collection.LongSparseArray;
import androidx.collection.LruCache;
import androidx.core.graphics.ColorUtils;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: SkinCompatDrawableManager.java */
/* loaded from: classes5.dex */
public final class rh4 {
    public static rh4 i;
    public WeakHashMap<Context, SparseArray<ColorStateList>> a;
    public ArrayMap<String, c> b;
    public SparseArray<String> c;
    public final Object d = new Object();
    public final WeakHashMap<Context, LongSparseArray<WeakReference<Drawable.ConstantState>>> e = new WeakHashMap<>(0);
    public TypedValue f;
    public boolean g;
    public static final PorterDuff.Mode h = PorterDuff.Mode.SRC_IN;
    public static final b j = new b(6);
    public static final int[] k = {R.drawable.abc_textfield_search_default_mtrl_alpha, R.drawable.abc_textfield_default_mtrl_alpha, R.drawable.abc_ab_share_pack_mtrl_alpha};
    public static final int[] l = {R.drawable.abc_ic_commit_search_api_mtrl_alpha, R.drawable.abc_seekbar_tick_mark_material, R.drawable.abc_ic_menu_share_mtrl_alpha, R.drawable.abc_ic_menu_copy_mtrl_am_alpha, R.drawable.abc_ic_menu_cut_mtrl_alpha, R.drawable.abc_ic_menu_selectall_mtrl_alpha, R.drawable.abc_ic_menu_paste_mtrl_am_alpha};
    public static final int[] m = {R.drawable.abc_textfield_activated_mtrl_alpha, R.drawable.abc_textfield_search_activated_mtrl_alpha, R.drawable.abc_cab_background_top_mtrl_alpha, R.drawable.abc_text_cursor_material, R.drawable.abc_text_select_handle_left_mtrl_dark, R.drawable.abc_text_select_handle_middle_mtrl_dark, R.drawable.abc_text_select_handle_right_mtrl_dark, R.drawable.abc_text_select_handle_left_mtrl_light, R.drawable.abc_text_select_handle_middle_mtrl_light, R.drawable.abc_text_select_handle_right_mtrl_light};
    public static final int[] n = {R.drawable.abc_popup_background_mtrl_mult, R.drawable.abc_cab_background_internal_bg, R.drawable.abc_menu_hardkey_panel_mtrl_mult};
    public static final int[] o = {R.drawable.abc_tab_indicator_material, R.drawable.abc_textfield_search_material};
    public static final int[] p = {R.drawable.abc_btn_check_material, R.drawable.abc_btn_radio_material};

    /* compiled from: SkinCompatDrawableManager.java */
    @RequiresApi(11)
    @TargetApi(11)
    public static class a implements c {
        @Override // dc.rh4.c
        @SuppressLint({"NewApi"})
        public Drawable createFromXmlInner(@NonNull Context context, @NonNull XmlPullParser xmlPullParser, @NonNull AttributeSet attributeSet, @Nullable Resources.Theme theme) {
            try {
                return AnimatedVectorDrawableCompat.createFromXmlInner(context, context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception unused) {
                return null;
            }
        }
    }

    /* compiled from: SkinCompatDrawableManager.java */
    public static class b extends LruCache<Integer, PorterDuffColorFilter> {
        public b(int i) {
            super(i);
        }

        public static int generateCacheKey(int i, PorterDuff.Mode mode) {
            return ((i + 31) * 31) + mode.hashCode();
        }

        public PorterDuffColorFilter get(int i, PorterDuff.Mode mode) {
            return get(Integer.valueOf(generateCacheKey(i, mode)));
        }

        public PorterDuffColorFilter put(int i, PorterDuff.Mode mode, PorterDuffColorFilter porterDuffColorFilter) {
            return put(Integer.valueOf(generateCacheKey(i, mode)), porterDuffColorFilter);
        }
    }

    /* compiled from: SkinCompatDrawableManager.java */
    public interface c {
        Drawable createFromXmlInner(@NonNull Context context, @NonNull XmlPullParser xmlPullParser, @NonNull AttributeSet attributeSet, @Nullable Resources.Theme theme);
    }

    /* compiled from: SkinCompatDrawableManager.java */
    public static class d implements c {
        @Override // dc.rh4.c
        @SuppressLint({"NewApi"})
        public Drawable createFromXmlInner(@NonNull Context context, @NonNull XmlPullParser xmlPullParser, @NonNull AttributeSet attributeSet, @Nullable Resources.Theme theme) {
            try {
                return VectorDrawableCompat.createFromXmlInner(context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception unused) {
                return null;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x005f A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean A(@androidx.annotation.NonNull android.content.Context r6, @androidx.annotation.DrawableRes int r7, @androidx.annotation.NonNull android.graphics.drawable.Drawable r8) {
        /*
            android.graphics.PorterDuff$Mode r0 = dc.rh4.h
            int[] r1 = dc.rh4.k
            boolean r1 = d(r1, r7)
            r2 = 16842801(0x1010031, float:2.3693695E-38)
            r3 = -1
            r4 = 0
            r5 = 1
            if (r1 == 0) goto L15
            int r2 = androidx.appcompat.R.attr.colorControlNormal
        L12:
            r7 = -1
        L13:
            r1 = 1
            goto L42
        L15:
            int[] r1 = dc.rh4.m
            boolean r1 = d(r1, r7)
            if (r1 == 0) goto L20
            int r2 = androidx.appcompat.R.attr.colorControlActivated
            goto L12
        L20:
            int[] r1 = dc.rh4.n
            boolean r1 = d(r1, r7)
            if (r1 == 0) goto L2b
            android.graphics.PorterDuff$Mode r0 = android.graphics.PorterDuff.Mode.MULTIPLY
            goto L12
        L2b:
            int r1 = androidx.appcompat.R.drawable.abc_list_divider_mtrl_alpha
            if (r7 != r1) goto L3a
            r2 = 16842800(0x1010030, float:2.3693693E-38)
            r7 = 1109603123(0x42233333, float:40.8)
            int r7 = java.lang.Math.round(r7)
            goto L13
        L3a:
            int r1 = androidx.appcompat.R.drawable.abc_dialog_material_background
            if (r7 != r1) goto L3f
            goto L12
        L3f:
            r7 = -1
            r1 = 0
            r2 = 0
        L42:
            if (r1 == 0) goto L5f
            boolean r1 = dc.sh4.a(r8)
            if (r1 == 0) goto L4e
            android.graphics.drawable.Drawable r8 = r8.mutate()
        L4e:
            int r6 = dc.uh4.d(r6, r2)
            android.graphics.PorterDuffColorFilter r6 = r(r6, r0)
            r8.setColorFilter(r6)
            if (r7 == r3) goto L5e
            r8.setAlpha(r7)
        L5e:
            return r5
        L5f:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: dc.rh4.A(android.content.Context, int, android.graphics.drawable.Drawable):boolean");
    }

    public static boolean d(int[] iArr, int i2) {
        for (int i3 : iArr) {
            if (i3 == i2) {
                return true;
            }
        }
        return false;
    }

    public static long i(TypedValue typedValue) {
        return (typedValue.assetCookie << 32) | typedValue.data;
    }

    public static rh4 n() {
        if (i == null) {
            rh4 rh4Var = new rh4();
            i = rh4Var;
            v(rh4Var);
        }
        return i;
    }

    public static PorterDuffColorFilter r(int i2, PorterDuff.Mode mode) {
        b bVar = j;
        PorterDuffColorFilter porterDuffColorFilter = bVar.get(i2, mode);
        if (porterDuffColorFilter != null) {
            return porterDuffColorFilter;
        }
        PorterDuffColorFilter porterDuffColorFilter2 = new PorterDuffColorFilter(i2, mode);
        bVar.put(i2, mode, porterDuffColorFilter2);
        return porterDuffColorFilter2;
    }

    public static PorterDuff.Mode u(int i2) {
        if (i2 == R.drawable.abc_switch_thumb_material) {
            return PorterDuff.Mode.MULTIPLY;
        }
        return null;
    }

    public static void v(@NonNull rh4 rh4Var) {
        if (Build.VERSION.SDK_INT < 24) {
            rh4Var.a("vector", new d());
            rh4Var.a("animated-vector", new a());
        }
    }

    public static boolean w(@NonNull Drawable drawable) {
        return (drawable instanceof VectorDrawableCompat) || "android.graphics.drawable.VectorDrawable".equals(drawable.getClass().getName());
    }

    public static void y(Drawable drawable, int i2, PorterDuff.Mode mode) {
        if (sh4.a(drawable)) {
            drawable = drawable.mutate();
        }
        if (mode == null) {
            mode = h;
        }
        drawable.setColorFilter(r(i2, mode));
    }

    public final void a(@NonNull String str, @NonNull c cVar) {
        if (this.b == null) {
            this.b = new ArrayMap<>();
        }
        this.b.put(str, cVar);
    }

    public final boolean b(@NonNull Context context, long j2, @NonNull Drawable drawable) {
        Drawable.ConstantState constantState = drawable.getConstantState();
        if (constantState == null) {
            return false;
        }
        synchronized (this.d) {
            LongSparseArray<WeakReference<Drawable.ConstantState>> longSparseArray = this.e.get(context);
            if (longSparseArray == null) {
                longSparseArray = new LongSparseArray<>();
                this.e.put(context, longSparseArray);
            }
            longSparseArray.put(j2, new WeakReference<>(constantState));
        }
        return true;
    }

    public final void c(@NonNull Context context, @DrawableRes int i2, @NonNull ColorStateList colorStateList) {
        if (this.a == null) {
            this.a = new WeakHashMap<>();
        }
        SparseArray<ColorStateList> sparseArray = this.a.get(context);
        if (sparseArray == null) {
            sparseArray = new SparseArray<>();
            this.a.put(context, sparseArray);
        }
        sparseArray.append(i2, colorStateList);
    }

    public final void e(@NonNull Context context) {
        if (this.g) {
            return;
        }
        this.g = true;
        Drawable drawableP = p(context, R.drawable.abc_vector_test);
        if (drawableP == null || !w(drawableP)) {
            this.g = false;
            throw new IllegalStateException("This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.");
        }
    }

    public void f() {
        this.e.clear();
        SparseArray<String> sparseArray = this.c;
        if (sparseArray != null) {
            sparseArray.clear();
        }
        WeakHashMap<Context, SparseArray<ColorStateList>> weakHashMap = this.a;
        if (weakHashMap != null) {
            weakHashMap.clear();
        }
        j.evictAll();
    }

    public final ColorStateList g(@NonNull Context context) {
        return h(context, 0);
    }

    public final ColorStateList h(@NonNull Context context, @ColorInt int i2) {
        int iD = uh4.d(context, R.attr.colorControlHighlight);
        return new ColorStateList(new int[][]{uh4.b, uh4.k, uh4.e, uh4.n}, new int[]{uh4.a(context, R.attr.colorButtonNormal), ColorUtils.compositeColors(iD, i2), ColorUtils.compositeColors(iD, i2), i2});
    }

    public final ColorStateList j(@NonNull Context context) {
        return h(context, uh4.d(context, R.attr.colorAccent));
    }

    public final ColorStateList k(@NonNull Context context) {
        return h(context, uh4.d(context, R.attr.colorButtonNormal));
    }

    public final Drawable l(@NonNull Context context, @DrawableRes int i2) throws Resources.NotFoundException {
        if (this.f == null) {
            this.f = new TypedValue();
        }
        TypedValue typedValue = this.f;
        th4.n(context, i2, typedValue, true);
        long jI = i(typedValue);
        Drawable drawableO = o(context, jI);
        if (drawableO != null) {
            return drawableO;
        }
        if (i2 == R.drawable.abc_cab_background_top_material) {
            drawableO = new LayerDrawable(new Drawable[]{p(context, R.drawable.abc_cab_background_internal_bg), p(context, R.drawable.abc_cab_background_top_mtrl_alpha)});
        }
        if (drawableO != null) {
            drawableO.setChangingConfigurations(typedValue.changingConfigurations);
            b(context, jI, drawableO);
        }
        return drawableO;
    }

    public final ColorStateList m(Context context) {
        int[][] iArr = new int[3][];
        int[] iArr2 = new int[3];
        int i2 = R.attr.colorSwitchThumbNormal;
        ColorStateList colorStateListF = uh4.f(context, i2);
        if (colorStateListF == null || !colorStateListF.isStateful()) {
            iArr[0] = uh4.b;
            iArr2[0] = uh4.a(context, i2);
            iArr[1] = uh4.l;
            iArr2[1] = uh4.d(context, R.attr.colorControlActivated);
            iArr[2] = uh4.n;
            iArr2[2] = uh4.d(context, i2);
        } else {
            iArr[0] = uh4.b;
            iArr2[0] = colorStateListF.getColorForState(iArr[0], 0);
            iArr[1] = uh4.l;
            iArr2[1] = uh4.d(context, R.attr.colorControlActivated);
            iArr[2] = uh4.n;
            iArr2[2] = colorStateListF.getDefaultColor();
        }
        return new ColorStateList(iArr, iArr2);
    }

    public final Drawable o(@NonNull Context context, long j2) {
        synchronized (this.d) {
            LongSparseArray<WeakReference<Drawable.ConstantState>> longSparseArray = this.e.get(context);
            if (longSparseArray == null) {
                return null;
            }
            WeakReference<Drawable.ConstantState> weakReference = longSparseArray.get(j2);
            if (weakReference != null) {
                Drawable.ConstantState constantState = weakReference.get();
                if (constantState != null) {
                    return constantState.newDrawable(context.getResources());
                }
                longSparseArray.delete(j2);
            }
            return null;
        }
    }

    public Drawable p(@NonNull Context context, @DrawableRes int i2) {
        return q(context, i2, false);
    }

    public Drawable q(@NonNull Context context, @DrawableRes int i2, boolean z) throws XmlPullParserException, Resources.NotFoundException, IOException {
        e(context);
        Drawable drawableX = x(context, i2);
        if (drawableX == null) {
            drawableX = l(context, i2);
        }
        if (drawableX == null) {
            drawableX = th4.d(context, i2);
        }
        if (drawableX != null) {
            drawableX = z(context, i2, z, drawableX);
        }
        if (drawableX != null) {
            sh4.b(drawableX);
        }
        return drawableX;
    }

    public ColorStateList s(@NonNull Context context, @DrawableRes int i2) {
        ColorStateList colorStateListT = t(context, i2);
        if (colorStateListT == null) {
            if (i2 == R.drawable.abc_edit_text_material) {
                colorStateListT = th4.c(context, R.color.abc_tint_edittext);
            } else if (i2 == R.drawable.abc_switch_track_mtrl_alpha) {
                colorStateListT = th4.c(context, R.color.abc_tint_switch_track);
            } else if (i2 == R.drawable.abc_switch_thumb_material) {
                colorStateListT = m(context);
            } else if (i2 == R.drawable.abc_btn_default_mtrl_shape) {
                colorStateListT = k(context);
            } else if (i2 == R.drawable.abc_btn_borderless_material) {
                colorStateListT = g(context);
            } else if (i2 == R.drawable.abc_btn_colored_material) {
                colorStateListT = j(context);
            } else if (i2 == R.drawable.abc_spinner_mtrl_am_alpha || i2 == R.drawable.abc_spinner_textfield_background_material) {
                colorStateListT = th4.c(context, R.color.abc_tint_spinner);
            } else if (d(l, i2)) {
                colorStateListT = uh4.f(context, R.attr.colorControlNormal);
            } else if (d(o, i2)) {
                colorStateListT = th4.c(context, R.color.abc_tint_default);
            } else if (d(p, i2)) {
                colorStateListT = th4.c(context, R.color.abc_tint_btn_checkable);
            } else if (i2 == R.drawable.abc_seekbar_thumb_material) {
                colorStateListT = th4.c(context, R.color.abc_tint_seek_thumb);
            }
            if (colorStateListT != null) {
                c(context, i2, colorStateListT);
            }
        }
        return colorStateListT;
    }

    public final ColorStateList t(@NonNull Context context, @DrawableRes int i2) {
        SparseArray<ColorStateList> sparseArray;
        WeakHashMap<Context, SparseArray<ColorStateList>> weakHashMap = this.a;
        if (weakHashMap == null || (sparseArray = weakHashMap.get(context)) == null) {
            return null;
        }
        return sparseArray.get(i2);
    }

    public final Drawable x(@NonNull Context context, @DrawableRes int i2) throws XmlPullParserException, Resources.NotFoundException, IOException {
        int next;
        ArrayMap<String, c> arrayMap = this.b;
        if (arrayMap == null || arrayMap.isEmpty()) {
            return null;
        }
        SparseArray<String> sparseArray = this.c;
        if (sparseArray != null) {
            String str = sparseArray.get(i2);
            if ("appcompat_skip_skip".equals(str) || (str != null && this.b.get(str) == null)) {
                return null;
            }
        } else {
            this.c = new SparseArray<>();
        }
        if (this.f == null) {
            this.f = new TypedValue();
        }
        TypedValue typedValue = this.f;
        th4.n(context, i2, typedValue, true);
        long jI = i(typedValue);
        Drawable drawableO = o(context, jI);
        if (drawableO != null) {
            return drawableO;
        }
        CharSequence charSequence = typedValue.string;
        if (charSequence != null && charSequence.toString().endsWith(".xml")) {
            try {
                XmlResourceParser xmlResourceParserO = th4.o(context, i2);
                AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(xmlResourceParserO);
                do {
                    next = xmlResourceParserO.next();
                    if (next == 2) {
                        break;
                    }
                } while (next != 1);
                if (next != 2) {
                    throw new XmlPullParserException("No start tag found");
                }
                String name = xmlResourceParserO.getName();
                this.c.append(i2, name);
                c cVar = this.b.get(name);
                if (cVar != null) {
                    drawableO = cVar.createFromXmlInner(context, xmlResourceParserO, attributeSetAsAttributeSet, null);
                }
                if (drawableO != null) {
                    drawableO.setChangingConfigurations(typedValue.changingConfigurations);
                    b(context, jI, drawableO);
                }
            } catch (Exception unused) {
            }
        }
        if (drawableO == null) {
            this.c.append(i2, "appcompat_skip_skip");
        }
        return drawableO;
    }

    public final Drawable z(@NonNull Context context, @DrawableRes int i2, boolean z, @NonNull Drawable drawable) {
        ColorStateList colorStateListS = s(context, i2);
        if (colorStateListS != null) {
            if (sh4.a(drawable)) {
                drawable = drawable.mutate();
            }
            Drawable drawableWrap = DrawableCompat.wrap(drawable);
            DrawableCompat.setTintList(drawableWrap, colorStateListS);
            PorterDuff.Mode modeU = u(i2);
            if (modeU == null) {
                return drawableWrap;
            }
            DrawableCompat.setTintMode(drawableWrap, modeU);
            return drawableWrap;
        }
        if (i2 == R.drawable.abc_seekbar_track_material) {
            LayerDrawable layerDrawable = (LayerDrawable) drawable;
            Drawable drawableFindDrawableByLayerId = layerDrawable.findDrawableByLayerId(android.R.id.background);
            int i3 = R.attr.colorControlNormal;
            int iD = uh4.d(context, i3);
            PorterDuff.Mode mode = h;
            y(drawableFindDrawableByLayerId, iD, mode);
            y(layerDrawable.findDrawableByLayerId(android.R.id.secondaryProgress), uh4.d(context, i3), mode);
            y(layerDrawable.findDrawableByLayerId(android.R.id.progress), uh4.d(context, R.attr.colorControlActivated), mode);
            return drawable;
        }
        if (i2 != R.drawable.abc_ratingbar_material && i2 != R.drawable.abc_ratingbar_indicator_material && i2 != R.drawable.abc_ratingbar_small_material) {
            if (A(context, i2, drawable) || !z) {
                return drawable;
            }
            return null;
        }
        LayerDrawable layerDrawable2 = (LayerDrawable) drawable;
        Drawable drawableFindDrawableByLayerId2 = layerDrawable2.findDrawableByLayerId(android.R.id.background);
        int iA = uh4.a(context, R.attr.colorControlNormal);
        PorterDuff.Mode mode2 = h;
        y(drawableFindDrawableByLayerId2, iA, mode2);
        Drawable drawableFindDrawableByLayerId3 = layerDrawable2.findDrawableByLayerId(android.R.id.secondaryProgress);
        int i4 = R.attr.colorControlActivated;
        y(drawableFindDrawableByLayerId3, uh4.d(context, i4), mode2);
        y(layerDrawable2.findDrawableByLayerId(android.R.id.progress), uh4.d(context, i4), mode2);
        return drawable;
    }
}
