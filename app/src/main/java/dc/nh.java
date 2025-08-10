package dc;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import androidx.annotation.NonNull;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.jivesoftware.smack.sm.packet.StreamManagement;

/* compiled from: FileDescriptorLocalUriFetcher.java */
/* loaded from: classes.dex */
public class nh extends qh<ParcelFileDescriptor> {
    public nh(ContentResolver contentResolver, Uri uri) {
        super(contentResolver, uri);
    }

    @Override // dc.qh
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public void b(ParcelFileDescriptor parcelFileDescriptor) throws IOException {
        parcelFileDescriptor.close();
    }

    @Override // dc.qh
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public ParcelFileDescriptor e(Uri uri, ContentResolver contentResolver) throws FileNotFoundException {
        AssetFileDescriptor assetFileDescriptorOpenAssetFileDescriptor = contentResolver.openAssetFileDescriptor(uri, StreamManagement.AckRequest.ELEMENT);
        if (assetFileDescriptorOpenAssetFileDescriptor != null) {
            return assetFileDescriptorOpenAssetFileDescriptor.getParcelFileDescriptor();
        }
        throw new FileNotFoundException("FileDescriptor is null for: " + uri);
    }

    @Override // dc.ih
    @NonNull
    public Class<ParcelFileDescriptor> getDataClass() {
        return ParcelFileDescriptor.class;
    }
}
