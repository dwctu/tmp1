package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: Modality.kt */
/* loaded from: classes4.dex */
public enum Modality {
    FINAL,
    SEALED,
    OPEN,
    ABSTRACT;


    @NotNull
    public static final Companion Companion = new Companion(null);

    /* compiled from: Modality.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final Modality convertFromFlags(boolean z, boolean z2, boolean z3) {
            return z ? Modality.SEALED : z2 ? Modality.ABSTRACT : z3 ? Modality.OPEN : Modality.FINAL;
        }
    }
}
