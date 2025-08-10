package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.reflect.Modifier;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.descriptors.java.JavaVisibilities;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaModifierListOwner;
import org.jetbrains.annotations.NotNull;

/* compiled from: ReflectJavaModifierListOwner.kt */
/* loaded from: classes4.dex */
public interface ReflectJavaModifierListOwner extends JavaModifierListOwner {

    /* compiled from: ReflectJavaModifierListOwner.kt */
    public static final class DefaultImpls {
        @NotNull
        public static Visibility getVisibility(@NotNull ReflectJavaModifierListOwner reflectJavaModifierListOwner) {
            int modifiers = reflectJavaModifierListOwner.getModifiers();
            return Modifier.isPublic(modifiers) ? Visibilities.Public.INSTANCE : Modifier.isPrivate(modifiers) ? Visibilities.Private.INSTANCE : Modifier.isProtected(modifiers) ? Modifier.isStatic(modifiers) ? JavaVisibilities.ProtectedStaticVisibility.INSTANCE : JavaVisibilities.ProtectedAndPackage.INSTANCE : JavaVisibilities.PackageVisibility.INSTANCE;
        }

        public static boolean isAbstract(@NotNull ReflectJavaModifierListOwner reflectJavaModifierListOwner) {
            return Modifier.isAbstract(reflectJavaModifierListOwner.getModifiers());
        }

        public static boolean isFinal(@NotNull ReflectJavaModifierListOwner reflectJavaModifierListOwner) {
            return Modifier.isFinal(reflectJavaModifierListOwner.getModifiers());
        }

        public static boolean isStatic(@NotNull ReflectJavaModifierListOwner reflectJavaModifierListOwner) {
            return Modifier.isStatic(reflectJavaModifierListOwner.getModifiers());
        }
    }

    int getModifiers();
}
