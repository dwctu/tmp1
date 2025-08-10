package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinder;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: KotlinClassFinder.kt */
/* loaded from: classes4.dex */
public final class KotlinClassFinderKt {
    @Nullable
    public static final KotlinJvmBinaryClass findKotlinClass(@NotNull KotlinClassFinder kotlinClassFinder, @NotNull ClassId classId) {
        Intrinsics.checkNotNullParameter(kotlinClassFinder, "<this>");
        Intrinsics.checkNotNullParameter(classId, "classId");
        KotlinClassFinder.Result resultFindKotlinClassOrContent = kotlinClassFinder.findKotlinClassOrContent(classId);
        if (resultFindKotlinClassOrContent != null) {
            return resultFindKotlinClassOrContent.toKotlinJvmBinaryClass();
        }
        return null;
    }

    @Nullable
    public static final KotlinJvmBinaryClass findKotlinClass(@NotNull KotlinClassFinder kotlinClassFinder, @NotNull JavaClass javaClass) {
        Intrinsics.checkNotNullParameter(kotlinClassFinder, "<this>");
        Intrinsics.checkNotNullParameter(javaClass, "javaClass");
        KotlinClassFinder.Result resultFindKotlinClassOrContent = kotlinClassFinder.findKotlinClassOrContent(javaClass);
        if (resultFindKotlinClassOrContent != null) {
            return resultFindKotlinClassOrContent.toKotlinJvmBinaryClass();
        }
        return null;
    }
}
