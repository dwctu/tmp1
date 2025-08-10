package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Visibility.kt */
/* loaded from: classes4.dex */
public abstract class Visibility {
    private final boolean isPublicAPI;

    @NotNull
    private final String name;

    public Visibility(@NotNull String name, boolean z) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.name = name;
        this.isPublicAPI = z;
    }

    @Nullable
    public Integer compareTo(@NotNull Visibility visibility) {
        Intrinsics.checkNotNullParameter(visibility, "visibility");
        return Visibilities.INSTANCE.compareLocal$compiler_common(this, visibility);
    }

    @NotNull
    public String getInternalDisplayName() {
        return this.name;
    }

    public final boolean isPublicAPI() {
        return this.isPublicAPI;
    }

    @NotNull
    public Visibility normalize() {
        return this;
    }

    @NotNull
    public final String toString() {
        return getInternalDisplayName();
    }
}
