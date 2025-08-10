package dc;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: LottieFetchResult.java */
/* loaded from: classes.dex */
public interface gb extends Closeable {
    @Nullable
    String error();

    boolean isSuccessful();

    @Nullable
    String r();

    @NonNull
    InputStream u() throws IOException;
}
