package dc;

import android.content.res.AssetManager;
import androidx.annotation.NonNull;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: StreamAssetPathFetcher.java */
/* loaded from: classes.dex */
public class sh extends gh<InputStream> {
    public sh(AssetManager assetManager, String str) {
        super(assetManager, str);
    }

    @Override // dc.gh
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public void b(InputStream inputStream) throws IOException {
        inputStream.close();
    }

    @Override // dc.gh
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public InputStream e(AssetManager assetManager, String str) throws IOException {
        return assetManager.open(str);
    }

    @Override // dc.ih
    @NonNull
    public Class<InputStream> getDataClass() {
        return InputStream.class;
    }
}
