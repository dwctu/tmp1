package com.wear.ui.chat.action.im;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Commander.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B)\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0012\u0010\u0006\u001a\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b\u0018\u00010\u0007¢\u0006\u0002\u0010\tR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001f\u0010\u0006\u001a\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Lcom/wear/ui/chat/action/im/Commander;", "", "o", FirebaseAnalytics.Param.METHOD, "Ljava/lang/reflect/Method;", "(Ljava/lang/Object;Ljava/lang/reflect/Method;)V", "parameterTypes", "", "Ljava/lang/Class;", "(Ljava/lang/Object;Ljava/lang/reflect/Method;[Ljava/lang/Class;)V", "getMethod", "()Ljava/lang/reflect/Method;", "getO", "()Ljava/lang/Object;", "getParameterTypes", "()[Ljava/lang/Class;", "[Ljava/lang/Class;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class Commander {

    @NotNull
    private final Method method;

    @NotNull
    private final Object o;

    @Nullable
    private final Class<?>[] parameterTypes;

    public Commander(@NotNull Object o, @NotNull Method method, @Nullable Class<?>[] clsArr) {
        Intrinsics.checkNotNullParameter(o, "o");
        Intrinsics.checkNotNullParameter(method, "method");
        this.o = o;
        this.method = method;
        this.parameterTypes = clsArr;
    }

    @NotNull
    public final Method getMethod() {
        return this.method;
    }

    @NotNull
    public final Object getO() {
        return this.o;
    }

    @Nullable
    public final Class<?>[] getParameterTypes() {
        return this.parameterTypes;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Commander(@NotNull Object o, @NotNull Method method) {
        this(o, method, method.getParameterTypes());
        Intrinsics.checkNotNullParameter(o, "o");
        Intrinsics.checkNotNullParameter(method, "method");
    }
}
