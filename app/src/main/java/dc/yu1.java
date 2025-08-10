package dc;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.Window;
import androidx.exifinterface.media.ExifInterface;
import com.lovense.wear.R;
import com.wear.ext.ActivityKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: View.kt */
@Metadata(d1 = {"\u0000H\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\u001a\"\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u0001H\u00120\u0011\"\u0004\b\u0000\u0010\u00122\u0006\u0010\u0013\u001a\u00020\u0001\u001a2\u0010\u0014\u001a\u00020\u0015*\u00020\t2\b\b\u0002\u0010\u0016\u001a\u00020\u00012\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00150\u001a\u001a\u0096\u0001\u0010\u001b\u001a\u00020\u0015*\u00020\t2!\u0010\u001c\u001a\u001d\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\u00150\u001a2!\u0010!\u001a\u001d\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\u00150\u001a2!\u0010\"\u001a\u001d\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\u00150\u001a2!\u0010#\u001a\u001d\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\u00150\u001a\u001a\u0012\u0010$\u001a\u00020\u0015*\u00020\t2\u0006\u0010%\u001a\u00020&\"\u001a\u0010\u0000\u001a\u00020\u0001X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u0004\b\u0004\u0010\u0005\"3\u0010\b\u001a\u0004\u0018\u00010\u0007*\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00078B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006'"}, d2 = {"debouncingClickIntervals", "", "getDebouncingClickIntervals", "()I", "setDebouncingClickIntervals", "(I)V", "<set-?>", "", "lastClickTime", "Landroid/view/View;", "getLastClickTime", "(Landroid/view/View;)Ljava/lang/Long;", "setLastClickTime", "(Landroid/view/View;Ljava/lang/Long;)V", "lastClickTime$delegate", "Lkotlin/properties/ReadWriteProperty;", "viewTags", "Lkotlin/properties/ReadWriteProperty;", ExifInterface.GPS_DIRECTION_TRUE, "key", "doOnDebouncingClick", "", "clickIntervals", "isSharingIntervals", "", "block", "Lkotlin/Function1;", "doOnTouch", "onDown", "Landroid/view/MotionEvent;", "Lkotlin/ParameterName;", "name", "event", "onMove", "onUp", "onCancel", "setBackgroundFile", "file", "Ljava/io/File;", "app_marketRelease"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class yu1 {
    public static final /* synthetic */ KProperty<Object>[] a = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(yu1.class, "lastClickTime", "getLastClickTime(Landroid/view/View;)Ljava/lang/Long;", 1))};

    @NotNull
    public static final ReadWriteProperty b = g(R.id.tag_last_click_time);
    public static int c = 500;

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: View.kt */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0001J$\u0010\u0003\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0004\u001a\u00020\u00022\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0006H\u0096\u0002¢\u0006\u0002\u0010\u0007J,\u0010\b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00022\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00062\b\u0010\n\u001a\u0004\u0018\u00018\u0000H\u0096\u0002¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"com/wear/ext/ViewKt$viewTags$1", "Lkotlin/properties/ReadWriteProperty;", "Landroid/view/View;", "getValue", "thisRef", "property", "Lkotlin/reflect/KProperty;", "(Landroid/view/View;Lkotlin/reflect/KProperty;)Ljava/lang/Object;", "setValue", "", "value", "(Landroid/view/View;Lkotlin/reflect/KProperty;Ljava/lang/Object;)V", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a<T> implements ReadWriteProperty<View, T> {
        public final /* synthetic */ int a;

        public a(int i) {
            this.a = i;
        }

        @Override // kotlin.properties.ReadWriteProperty, kotlin.properties.ReadOnlyProperty
        @Nullable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public T getValue(@NotNull View thisRef, @NotNull KProperty<?> property) {
            Intrinsics.checkNotNullParameter(thisRef, "thisRef");
            Intrinsics.checkNotNullParameter(property, "property");
            T t = (T) thisRef.getTag(this.a);
            if (t == null) {
                return null;
            }
            return t;
        }

        @Override // kotlin.properties.ReadWriteProperty
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void setValue(@NotNull View thisRef, @NotNull KProperty<?> property, @Nullable T t) {
            Intrinsics.checkNotNullParameter(thisRef, "thisRef");
            Intrinsics.checkNotNullParameter(property, "property");
            thisRef.setTag(this.a, t);
        }
    }

    public static final void a(@NotNull final View view, final int i, final boolean z, @NotNull final Function1<? super View, Unit> block) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        view.setOnClickListener(new View.OnClickListener() { // from class: dc.yt1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                yu1.c(z, view, i, block, view2);
            }
        });
    }

    public static /* synthetic */ void b(View view, int i, boolean z, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = c;
        }
        if ((i2 & 2) != 0) {
            z = false;
        }
        a(view, i, z, function1);
    }

    public static final void c(boolean z, View this_doOnDebouncingClick, int i, Function1 block, View it) {
        Window window;
        View decorView;
        Intrinsics.checkNotNullParameter(this_doOnDebouncingClick, "$this_doOnDebouncingClick");
        Intrinsics.checkNotNullParameter(block, "$block");
        if (z) {
            Context context = this_doOnDebouncingClick.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            Activity activityA = ActivityKt.a(context);
            if (activityA != null && (window = activityA.getWindow()) != null && (decorView = window.getDecorView()) != null) {
                this_doOnDebouncingClick = decorView;
            }
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        Long lD = d(this_doOnDebouncingClick);
        if (jCurrentTimeMillis - (lD != null ? lD.longValue() : 0L) > i) {
            f(this_doOnDebouncingClick, Long.valueOf(jCurrentTimeMillis));
            Intrinsics.checkNotNullExpressionValue(it, "it");
            block.invoke(it);
        }
    }

    public static final Long d(View view) {
        return (Long) b.getValue(view, a[0]);
    }

    public static final void f(View view, Long l) {
        b.setValue(view, a[0], l);
    }

    @NotNull
    public static final <T> ReadWriteProperty<View, T> g(int i) {
        return new a(i);
    }
}
