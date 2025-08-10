package com.wear.ext;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.startup.Initializer;
import dc.bu1;
import dc.ju1;
import dc.ou1;
import dc.yf3;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: AppInitializer.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\fB\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\t\u001a\u0012\u0012\u000e\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00010\u000b0\nH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/wear/ext/AppInitializer;", "Landroidx/startup/Initializer;", "", "()V", "started", "", "create", "context", "Landroid/content/Context;", "dependencies", "", "Ljava/lang/Class;", "Companion", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class AppInitializer implements Initializer<Unit> {

    @NotNull
    public static final a b = new a(null);

    @Nullable
    public static ou1 c;
    public int a;

    /* compiled from: AppInitializer.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/wear/ext/AppInitializer$Companion;", "", "()V", "onAppStatusChangedListener", "Lcom/wear/ext/OnAppStatusChangedListener;", "getOnAppStatusChangedListener$app_marketRelease", "()Lcom/wear/ext/OnAppStatusChangedListener;", "setOnAppStatusChangedListener$app_marketRelease", "(Lcom/wear/ext/OnAppStatusChangedListener;)V", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Nullable
        public final ou1 a() {
            return AppInitializer.c;
        }

        public final void b(@Nullable ou1 ou1Var) {
            AppInitializer.c = ou1Var;
        }
    }

    /* compiled from: AppInitializer.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", ActivityChooserModel.ATTRIBUTE_ACTIVITY, "Landroid/app/Activity;", "<anonymous parameter 1>", "Landroid/os/Bundle;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class b extends Lambda implements Function2<Activity, Bundle, Unit> {
        public static final b a = new b();

        public b() {
            super(2);
        }

        public final void a(@NotNull Activity activity, @Nullable Bundle bundle) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            ActivityKt.d().add(activity);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Activity activity, Bundle bundle) {
            a(activity, bundle);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: AppInitializer.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", ActivityChooserModel.ATTRIBUTE_ACTIVITY, "Landroid/app/Activity;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class c extends Lambda implements Function1<Activity, Unit> {
        public c() {
            super(1);
        }

        public final void a(@NotNull Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            AppInitializer.this.a++;
            if (AppInitializer.this.a == 1) {
                bu1.c(false);
                ou1 ou1VarA = AppInitializer.b.a();
                if (ou1VarA != null) {
                    ou1VarA.a(activity);
                }
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Activity activity) {
            a(activity);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: AppInitializer.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", ActivityChooserModel.ATTRIBUTE_ACTIVITY, "Landroid/app/Activity;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class d extends Lambda implements Function1<Activity, Unit> {
        public d() {
            super(1);
        }

        public final void a(@NotNull Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            AppInitializer appInitializer = AppInitializer.this;
            appInitializer.a--;
            if (AppInitializer.this.a == 0) {
                bu1.c(true);
                ou1 ou1VarA = AppInitializer.b.a();
                if (ou1VarA != null) {
                    ou1VarA.b(activity);
                }
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Activity activity) {
            a(activity);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: AppInitializer.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", ActivityChooserModel.ATTRIBUTE_ACTIVITY, "Landroid/app/Activity;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class e extends Lambda implements Function1<Activity, Unit> {
        public static final e a = new e();

        public e() {
            super(1);
        }

        public final void a(@NotNull Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            ActivityKt.d().remove(activity);
            yf3.i.a().o(activity);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Activity activity) {
            a(activity);
            return Unit.INSTANCE;
        }
    }

    @Override // androidx.startup.Initializer
    public /* bridge */ /* synthetic */ Unit create(Context context) {
        e(context);
        return Unit.INSTANCE;
    }

    @Override // androidx.startup.Initializer
    @NotNull
    public List<Class<Initializer<?>>> dependencies() {
        return CollectionsKt__CollectionsKt.emptyList();
    }

    public void e(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        bu1.d((Application) context);
        ju1.b(bu1.a(), b.a, new c(), null, null, new d(), null, e.a, 44, null);
    }
}
