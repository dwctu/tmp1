package com.wear.ext;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import androidx.activity.ComponentActivity;
import androidx.activity.OnBackPressedCallback;
import androidx.lifecycle.LifecycleOwner;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Activity.kt */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\b\u001a\u0004\u0018\u00010\u0002*\u00020\t\u001a\"\u0010\n\u001a\u00020\u000b*\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0010\"\u001a\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004\"\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u00028F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"activityCache", "Ljava/util/LinkedList;", "Landroid/app/Activity;", "getActivityCache", "()Ljava/util/LinkedList;", "topActivity", "getTopActivity", "()Landroid/app/Activity;", "asActivity", "Landroid/content/Context;", "doOnBackPressed", "", "Landroidx/activity/ComponentActivity;", "owner", "Landroidx/lifecycle/LifecycleOwner;", "onBackPressed", "Lkotlin/Function0;", "app_marketRelease"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class ActivityKt {

    @NotNull
    public static final LinkedList<Activity> a = new LinkedList<>();

    @Nullable
    public static final Activity a(@NotNull Context context) {
        Context baseContext;
        Intrinsics.checkNotNullParameter(context, "<this>");
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity != null) {
            return activity;
        }
        ContextWrapper contextWrapper = context instanceof ContextWrapper ? (ContextWrapper) context : null;
        if (contextWrapper == null || (baseContext = contextWrapper.getBaseContext()) == null) {
            return null;
        }
        return a(baseContext);
    }

    public static final void b(@NotNull ComponentActivity componentActivity, @NotNull LifecycleOwner owner, @NotNull final Function0<Unit> onBackPressed) {
        Intrinsics.checkNotNullParameter(componentActivity, "<this>");
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(onBackPressed, "onBackPressed");
        componentActivity.getOnBackPressedDispatcher().addCallback(owner, new OnBackPressedCallback() { // from class: com.wear.ext.ActivityKt$doOnBackPressed$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(true);
            }

            @Override // androidx.activity.OnBackPressedCallback
            public void handleOnBackPressed() {
                onBackPressed.invoke();
            }
        });
    }

    public static /* synthetic */ void c(ComponentActivity componentActivity, LifecycleOwner lifecycleOwner, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            lifecycleOwner = componentActivity;
        }
        b(componentActivity, lifecycleOwner, function0);
    }

    @NotNull
    public static final LinkedList<Activity> d() {
        return a;
    }

    @Nullable
    public static final Activity e() {
        return (Activity) CollectionsKt___CollectionsKt.lastOrNull((List) a);
    }
}
