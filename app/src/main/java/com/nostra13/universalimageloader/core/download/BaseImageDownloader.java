package com.nostra13.universalimageloader.core.download;

import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import com.google.common.net.HttpHeaders;
import com.nostra13.universalimageloader.core.assist.ContentLengthInputStream;
import com.nostra13.universalimageloader.core.download.ImageDownloader;
import com.nostra13.universalimageloader.utils.IoUtils;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/* loaded from: classes3.dex */
public class BaseImageDownloader implements ImageDownloader {
    public static final String ALLOWED_URI_CHARS = "@#&=*+-_.,:!?()/~'%";
    public static final int BUFFER_SIZE = 32768;
    public static final String CONTENT_CONTACTS_URI_PREFIX = "content://com.android.contacts/";
    public static final int DEFAULT_HTTP_CONNECT_TIMEOUT = 5000;
    public static final int DEFAULT_HTTP_READ_TIMEOUT = 20000;
    private static final String ERROR_UNSUPPORTED_SCHEME = "UIL doesn't support scheme(protocol) by default [%s]. You should implement this support yourself (BaseImageDownloader.getStreamFromOtherSource(...))";
    public static final int MAX_REDIRECT_COUNT = 5;
    public final int connectTimeout;
    public final Context context;
    public final int readTimeout;

    /* renamed from: com.nostra13.universalimageloader.core.download.BaseImageDownloader$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$nostra13$universalimageloader$core$download$ImageDownloader$Scheme;

        static {
            int[] iArr = new int[ImageDownloader.Scheme.values().length];
            $SwitchMap$com$nostra13$universalimageloader$core$download$ImageDownloader$Scheme = iArr;
            try {
                iArr[ImageDownloader.Scheme.HTTP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$nostra13$universalimageloader$core$download$ImageDownloader$Scheme[ImageDownloader.Scheme.HTTPS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$nostra13$universalimageloader$core$download$ImageDownloader$Scheme[ImageDownloader.Scheme.FILE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$nostra13$universalimageloader$core$download$ImageDownloader$Scheme[ImageDownloader.Scheme.CONTENT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$nostra13$universalimageloader$core$download$ImageDownloader$Scheme[ImageDownloader.Scheme.ASSETS.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$nostra13$universalimageloader$core$download$ImageDownloader$Scheme[ImageDownloader.Scheme.DRAWABLE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$nostra13$universalimageloader$core$download$ImageDownloader$Scheme[ImageDownloader.Scheme.UNKNOWN.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public BaseImageDownloader(Context context) {
        this.context = context.getApplicationContext();
        this.connectTimeout = 5000;
        this.readTimeout = 20000;
    }

    private boolean isVideoUri(Uri uri) {
        String type = this.context.getContentResolver().getType(uri);
        if (type == null) {
            return false;
        }
        return type.startsWith("video/");
    }

    public HttpURLConnection createConnection(String str, Object obj) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(Uri.encode(str, ALLOWED_URI_CHARS)).openConnection();
        httpURLConnection.setConnectTimeout(this.connectTimeout);
        httpURLConnection.setReadTimeout(this.readTimeout);
        return httpURLConnection;
    }

    @Override // com.nostra13.universalimageloader.core.download.ImageDownloader
    public InputStream getStream(String str, Object obj) throws IOException {
        switch (AnonymousClass1.$SwitchMap$com$nostra13$universalimageloader$core$download$ImageDownloader$Scheme[ImageDownloader.Scheme.ofUri(str).ordinal()]) {
            case 1:
            case 2:
                return getStreamFromNetwork(str, obj);
            case 3:
                return getStreamFromFile(str, obj);
            case 4:
                return getStreamFromContent(str, obj);
            case 5:
                return getStreamFromAssets(str, obj);
            case 6:
                return getStreamFromDrawable(str, obj);
            default:
                return getStreamFromOtherSource(str, obj);
        }
    }

    public InputStream getStreamFromAssets(String str, Object obj) throws IOException {
        return this.context.getAssets().open(ImageDownloader.Scheme.ASSETS.crop(str));
    }

    public InputStream getStreamFromContent(String str, Object obj) throws FileNotFoundException {
        ContentResolver contentResolver = this.context.getContentResolver();
        Uri uri = Uri.parse(str);
        if (isVideoUri(uri)) {
            Bitmap thumbnail = MediaStore.Video.Thumbnails.getThumbnail(contentResolver, Long.valueOf(uri.getLastPathSegment()).longValue(), 1, null);
            if (thumbnail != null) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                thumbnail.compress(Bitmap.CompressFormat.PNG, 0, byteArrayOutputStream);
                return new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
            }
        } else if (str.startsWith(CONTENT_CONTACTS_URI_PREFIX)) {
            return ContactsContract.Contacts.openContactPhotoInputStream(contentResolver, uri);
        }
        return contentResolver.openInputStream(uri);
    }

    public InputStream getStreamFromDrawable(String str, Object obj) throws NumberFormatException {
        return this.context.getResources().openRawResource(Integer.parseInt(ImageDownloader.Scheme.DRAWABLE.crop(str)));
    }

    public InputStream getStreamFromFile(String str, Object obj) throws IOException {
        String strCrop = ImageDownloader.Scheme.FILE.crop(str);
        return new ContentLengthInputStream(new BufferedInputStream(new FileInputStream(strCrop), 32768), (int) new File(strCrop).length());
    }

    public InputStream getStreamFromNetwork(String str, Object obj) throws IOException {
        HttpURLConnection httpURLConnectionCreateConnection = createConnection(str, obj);
        for (int i = 0; httpURLConnectionCreateConnection.getResponseCode() / 100 == 3 && i < 5; i++) {
            httpURLConnectionCreateConnection = createConnection(httpURLConnectionCreateConnection.getHeaderField(HttpHeaders.LOCATION), obj);
        }
        try {
            return new ContentLengthInputStream(new BufferedInputStream(httpURLConnectionCreateConnection.getInputStream(), 32768), httpURLConnectionCreateConnection.getContentLength());
        } catch (IOException e) {
            IoUtils.readAndCloseStream(httpURLConnectionCreateConnection.getErrorStream());
            throw e;
        }
    }

    public InputStream getStreamFromOtherSource(String str, Object obj) throws IOException {
        throw new UnsupportedOperationException(String.format(ERROR_UNSUPPORTED_SCHEME, str));
    }

    public BaseImageDownloader(Context context, int i, int i2) {
        this.context = context.getApplicationContext();
        this.connectTimeout = i;
        this.readTimeout = i2;
    }
}
