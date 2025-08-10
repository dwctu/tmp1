package com.google.firebase.messaging;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.firebase_messaging.zzg;
import com.google.android.gms.internal.firebase_messaging.zzh;
import com.google.android.gms.internal.firebase_messaging.zzo;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* compiled from: com.google.firebase:firebase-messaging@@21.1.0 */
/* loaded from: classes2.dex */
public class ImageDownload implements Closeable {

    @Nullable
    private volatile InputStream connectionInputStream;

    @Nullable
    private Task<Bitmap> task;
    private final URL url;

    private ImageDownload(URL url) {
        this.url = url;
    }

    private byte[] blockingDownloadBytes() throws IOException {
        URLConnection uRLConnectionOpenConnection = this.url.openConnection();
        if (uRLConnectionOpenConnection.getContentLength() > 1048576) {
            throw new IOException("Content-Length exceeds max size of 1048576");
        }
        InputStream inputStream = uRLConnectionOpenConnection.getInputStream();
        try {
            this.connectionInputStream = inputStream;
            byte[] bArrZza = zzg.zza(zzg.zzb(inputStream, 1048577L));
            if (inputStream != null) {
                inputStream.close();
            }
            if (Log.isLoggable(Constants.TAG, 2)) {
                String strValueOf = String.valueOf(this.url);
                StringBuilder sb = new StringBuilder(String.valueOf(strValueOf).length() + 34);
                sb.append("Downloaded ");
                sb.append(bArrZza.length);
                sb.append(" bytes from ");
                sb.append(strValueOf);
                sb.toString();
            }
            if (bArrZza.length <= 1048576) {
                return bArrZza;
            }
            throw new IOException("Image exceeds max size of 1048576");
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Throwable th2) {
                    zzo.zza(th, th2);
                }
            }
            throw th;
        }
    }

    @Nullable
    public static ImageDownload create(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new ImageDownload(new URL(str));
        } catch (MalformedURLException unused) {
            String strValueOf = String.valueOf(str);
            if (strValueOf.length() != 0) {
                "Not downloading image, bad URL: ".concat(strValueOf);
            } else {
                new String("Not downloading image, bad URL: ");
            }
            return null;
        }
    }

    public Bitmap blockingDownload() throws IOException {
        String strValueOf = String.valueOf(this.url);
        StringBuilder sb = new StringBuilder(String.valueOf(strValueOf).length() + 22);
        sb.append("Starting download of: ");
        sb.append(strValueOf);
        sb.toString();
        byte[] bArrBlockingDownloadBytes = blockingDownloadBytes();
        Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrBlockingDownloadBytes, 0, bArrBlockingDownloadBytes.length);
        if (bitmapDecodeByteArray == null) {
            String strValueOf2 = String.valueOf(this.url);
            StringBuilder sb2 = new StringBuilder(String.valueOf(strValueOf2).length() + 24);
            sb2.append("Failed to decode image: ");
            sb2.append(strValueOf2);
            throw new IOException(sb2.toString());
        }
        if (Log.isLoggable(Constants.TAG, 3)) {
            String strValueOf3 = String.valueOf(this.url);
            StringBuilder sb3 = new StringBuilder(String.valueOf(strValueOf3).length() + 31);
            sb3.append("Successfully downloaded image: ");
            sb3.append(strValueOf3);
            sb3.toString();
        }
        return bitmapDecodeByteArray;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        try {
            zzh.zza(this.connectionInputStream);
        } catch (NullPointerException unused) {
        }
    }

    public Task<Bitmap> getTask() {
        return (Task) Preconditions.checkNotNull(this.task);
    }

    public void start(Executor executor) {
        this.task = Tasks.call(executor, new Callable(this) { // from class: com.google.firebase.messaging.ImageDownload$$Lambda$0
            private final ImageDownload arg$1;

            {
                this.arg$1 = this;
            }

            @Override // java.util.concurrent.Callable
            public Object call() {
                return this.arg$1.blockingDownload();
            }
        });
    }
}
