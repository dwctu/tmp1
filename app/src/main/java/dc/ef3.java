package dc;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.lovense.wear.R;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import org.jivesoftware.smack.sm.packet.StreamManagement;

/* compiled from: MusicUtils.java */
/* loaded from: classes4.dex */
public class ef3 {
    public static final Uri a = Uri.parse("content://media/external/audio/albumart");
    public static final BitmapFactory.Options b = new BitmapFactory.Options();

    public static Bitmap a(Context context, long j, long j2, boolean z) throws Throwable {
        Bitmap bitmapB;
        InputStream inputStream = null;
        if (j2 < 0) {
            if (j >= 0 && (bitmapB = b(context, j, -1L)) != null) {
                return bitmapB;
            }
            if (z) {
                return c(context);
            }
            return null;
        }
        ContentResolver contentResolver = context.getContentResolver();
        Uri uriWithAppendedId = ContentUris.withAppendedId(a, j2);
        if (uriWithAppendedId == null) {
            return null;
        }
        try {
            try {
                InputStream inputStreamOpenInputStream = contentResolver.openInputStream(uriWithAppendedId);
                try {
                    Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(inputStreamOpenInputStream, null, b);
                    if (inputStreamOpenInputStream != null) {
                        try {
                            inputStreamOpenInputStream.close();
                        } catch (IOException unused) {
                        }
                    }
                    return bitmapDecodeStream;
                } catch (FileNotFoundException unused2) {
                    inputStream = inputStreamOpenInputStream;
                    Bitmap bitmapB2 = b(context, j, j2);
                    if (bitmapB2 != null) {
                        if (bitmapB2.getConfig() == null && (bitmapB2 = bitmapB2.copy(Bitmap.Config.RGB_565, false)) == null && z) {
                            Bitmap bitmapC = c(context);
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (IOException unused3) {
                                }
                            }
                            return bitmapC;
                        }
                    } else if (z) {
                        bitmapB2 = c(context);
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException unused4) {
                        }
                    }
                    return bitmapB2;
                } catch (Throwable th) {
                    th = th;
                    inputStream = inputStreamOpenInputStream;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException unused5) {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (FileNotFoundException unused6) {
        }
    }

    public static Bitmap b(Context context, long j, long j2) throws FileNotFoundException {
        if (j2 < 0 && j < 0) {
            throw new IllegalArgumentException("Must specify an album or a song id");
        }
        Bitmap bitmapDecodeFileDescriptor = null;
        try {
            if (j2 < 0) {
                ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = context.getContentResolver().openFileDescriptor(Uri.parse("content://media/external/audio/media/" + j + "/albumart"), StreamManagement.AckRequest.ELEMENT);
                if (parcelFileDescriptorOpenFileDescriptor != null) {
                    bitmapDecodeFileDescriptor = BitmapFactory.decodeFileDescriptor(parcelFileDescriptorOpenFileDescriptor.getFileDescriptor());
                }
            } else {
                ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor2 = context.getContentResolver().openFileDescriptor(ContentUris.withAppendedId(a, j2), StreamManagement.AckRequest.ELEMENT);
                if (parcelFileDescriptorOpenFileDescriptor2 != null) {
                    bitmapDecodeFileDescriptor = BitmapFactory.decodeFileDescriptor(parcelFileDescriptorOpenFileDescriptor2.getFileDescriptor());
                }
            }
        } catch (FileNotFoundException unused) {
        }
        return bitmapDecodeFileDescriptor;
    }

    public static Bitmap c(Context context) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        return BitmapFactory.decodeResource(context.getResources(), R.drawable.content_icon_music_cover, options);
    }
}
