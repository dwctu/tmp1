package dc;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: ViewModelProvider.kt */
/* loaded from: classes.dex */
public final /* synthetic */ class c4 {
    @NotNull
    public static ViewModel $default$create(@NotNull ViewModelProvider.Factory _this, Class modelClass) {
        Intrinsics.checkNotNullParameter(modelClass, "modelClass");
        throw new UnsupportedOperationException("Factory.create(String) is unsupported.  This Factory requires `CreationExtras` to be passed into `create` method.");
    }

    @NotNull
    public static ViewModel $default$create(@NotNull ViewModelProvider.Factory _this, @NotNull Class modelClass, CreationExtras extras) {
        Intrinsics.checkNotNullParameter(modelClass, "modelClass");
        Intrinsics.checkNotNullParameter(extras, "extras");
        return _this.create(modelClass);
    }
}
