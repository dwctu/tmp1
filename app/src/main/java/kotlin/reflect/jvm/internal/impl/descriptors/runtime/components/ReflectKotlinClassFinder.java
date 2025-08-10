package kotlin.reflect.jvm.internal.impl.descriptors.runtime.components;

import java.io.InputStream;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinder;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins.BuiltInSerializerProtocol;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins.BuiltInsResourceLoader;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ReflectKotlinClassFinder.kt */
/* loaded from: classes4.dex */
public final class ReflectKotlinClassFinder implements KotlinClassFinder {

    @NotNull
    private final BuiltInsResourceLoader builtInsResourceLoader;

    @NotNull
    private final ClassLoader classLoader;

    public ReflectKotlinClassFinder(@NotNull ClassLoader classLoader) {
        Intrinsics.checkNotNullParameter(classLoader, "classLoader");
        this.classLoader = classLoader;
        this.builtInsResourceLoader = new BuiltInsResourceLoader();
    }

    private final KotlinClassFinder.Result findKotlinClass(String str) {
        ReflectKotlinClass reflectKotlinClassCreate;
        Class<?> clsTryLoadClass = ReflectJavaClassFinderKt.tryLoadClass(this.classLoader, str);
        if (clsTryLoadClass == null || (reflectKotlinClassCreate = ReflectKotlinClass.Factory.create(clsTryLoadClass)) == null) {
            return null;
        }
        return new KotlinClassFinder.Result.KotlinClass(reflectKotlinClassCreate, null, 2, null);
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.KotlinMetadataFinder
    @Nullable
    public InputStream findBuiltInsData(@NotNull FqName packageFqName) {
        Intrinsics.checkNotNullParameter(packageFqName, "packageFqName");
        if (packageFqName.startsWith(StandardNames.BUILT_INS_PACKAGE_NAME)) {
            return this.builtInsResourceLoader.loadResource(BuiltInSerializerProtocol.INSTANCE.getBuiltInsFilePath(packageFqName));
        }
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinder
    @Nullable
    public KotlinClassFinder.Result findKotlinClassOrContent(@NotNull ClassId classId) {
        Intrinsics.checkNotNullParameter(classId, "classId");
        return findKotlinClass(ReflectKotlinClassFinderKt.toRuntimeFqName(classId));
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinder
    @Nullable
    public KotlinClassFinder.Result findKotlinClassOrContent(@NotNull JavaClass javaClass) {
        String strAsString;
        Intrinsics.checkNotNullParameter(javaClass, "javaClass");
        FqName fqName = javaClass.getFqName();
        if (fqName == null || (strAsString = fqName.asString()) == null) {
            return null;
        }
        return findKotlinClass(strAsString);
    }
}
