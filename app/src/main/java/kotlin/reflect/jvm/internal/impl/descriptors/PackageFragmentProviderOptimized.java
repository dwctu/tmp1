package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.Collection;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import org.jetbrains.annotations.NotNull;

/* compiled from: PackageFragmentProvider.kt */
/* loaded from: classes4.dex */
public interface PackageFragmentProviderOptimized extends PackageFragmentProvider {
    void collectPackageFragments(@NotNull FqName fqName, @NotNull Collection<PackageFragmentDescriptor> collection);

    boolean isEmpty(@NotNull FqName fqName);
}
