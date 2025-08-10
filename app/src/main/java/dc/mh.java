package dc;

import android.content.res.AssetManager;
import android.os.ParcelFileDescriptor;
import androidx.annotation.NonNull;
import java.io.IOException;

/* compiled from: FileDescriptorAssetPathFetcher.java */
/* loaded from: classes.dex */
public class mh extends gh<ParcelFileDescriptor> {
    public mh(AssetManager assetManager, String str) {
        super(assetManager, str);
    }

    @Override // dc.gh
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public void b(ParcelFileDescriptor parcelFileDescriptor) throws IOException {
        parcelFileDescriptor.close();
    }

    @Override // dc.gh
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public ParcelFileDescriptor e(AssetManager assetManager, String str) throws IOException {
        return assetManager.openFd(str).getParcelFileDescriptor();
    }

    @Override // dc.ih
    @NonNull
    public Class<ParcelFileDescriptor> getDataClass() {
        return ParcelFileDescriptor.class;
    }
}
