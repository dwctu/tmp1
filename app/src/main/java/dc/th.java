package dc;

import android.content.ContentResolver;
import android.content.UriMatcher;
import android.net.Uri;
import android.provider.ContactsContract;
import androidx.annotation.NonNull;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: StreamLocalUriFetcher.java */
/* loaded from: classes.dex */
public class th extends qh<InputStream> {
    public static final UriMatcher d;

    static {
        UriMatcher uriMatcher = new UriMatcher(-1);
        d = uriMatcher;
        uriMatcher.addURI("com.android.contacts", "contacts/lookup/*/#", 1);
        uriMatcher.addURI("com.android.contacts", "contacts/lookup/*", 1);
        uriMatcher.addURI("com.android.contacts", "contacts/#/photo", 2);
        uriMatcher.addURI("com.android.contacts", "contacts/#", 3);
        uriMatcher.addURI("com.android.contacts", "contacts/#/display_photo", 4);
        uriMatcher.addURI("com.android.contacts", "phone_lookup/*", 5);
    }

    public th(ContentResolver contentResolver, Uri uri) {
        super(contentResolver, uri);
    }

    @Override // dc.qh
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public void b(InputStream inputStream) throws IOException {
        inputStream.close();
    }

    @Override // dc.qh
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public InputStream e(Uri uri, ContentResolver contentResolver) throws FileNotFoundException {
        InputStream inputStreamH = h(uri, contentResolver);
        if (inputStreamH != null) {
            return inputStreamH;
        }
        throw new FileNotFoundException("InputStream is null for " + uri);
    }

    @Override // dc.ih
    @NonNull
    public Class<InputStream> getDataClass() {
        return InputStream.class;
    }

    public final InputStream h(Uri uri, ContentResolver contentResolver) throws FileNotFoundException {
        int iMatch = d.match(uri);
        if (iMatch != 1) {
            if (iMatch == 3) {
                return i(contentResolver, uri);
            }
            if (iMatch != 5) {
                return contentResolver.openInputStream(uri);
            }
        }
        Uri uriLookupContact = ContactsContract.Contacts.lookupContact(contentResolver, uri);
        if (uriLookupContact != null) {
            return i(contentResolver, uriLookupContact);
        }
        throw new FileNotFoundException("Contact cannot be found");
    }

    public final InputStream i(ContentResolver contentResolver, Uri uri) {
        return ContactsContract.Contacts.openContactPhotoInputStream(contentResolver, uri, true);
    }
}
