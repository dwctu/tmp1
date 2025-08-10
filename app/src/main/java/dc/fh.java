package dc;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import androidx.annotation.NonNull;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.jivesoftware.smack.sm.packet.StreamManagement;

/* compiled from: AssetFileDescriptorLocalUriFetcher.java */
/* loaded from: classes.dex */
public final class fh extends qh<AssetFileDescriptor> {
    public fh(ContentResolver contentResolver, Uri uri) {
        super(contentResolver, uri);
    }

    @Override // dc.qh
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public void b(AssetFileDescriptor assetFileDescriptor) throws IOException {
        assetFileDescriptor.close();
    }

    @Override // dc.qh
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public AssetFileDescriptor e(Uri uri, ContentResolver contentResolver) throws FileNotFoundException {
        AssetFileDescriptor assetFileDescriptorOpenAssetFileDescriptor = contentResolver.openAssetFileDescriptor(uri, StreamManagement.AckRequest.ELEMENT);
        if (assetFileDescriptorOpenAssetFileDescriptor != null) {
            return assetFileDescriptorOpenAssetFileDescriptor;
        }
        throw new FileNotFoundException("FileDescriptor is null for: " + uri);
    }

    @Override // dc.ih
    @NonNull
    public Class<AssetFileDescriptor> getDataClass() {
        return AssetFileDescriptor.class;
    }
}
