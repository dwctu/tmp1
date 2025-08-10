package org.vosk.android;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.vosk.Model;
import org.vosk.android.StorageService;

/* loaded from: classes5.dex */
public class StorageService {
    public static final String TAG = "StorageService";

    public interface Callback<R> {
        void onComplete(R r);
    }

    public static /* synthetic */ void c(Context context, String str, String str2, Handler handler, final Callback callback, final Callback callback2) {
        try {
            final Model model = new Model(sync(context, str, str2));
            handler.post(new Runnable() { // from class: dc.af4
                @Override // java.lang.Runnable
                public final void run() {
                    callback.onComplete(model);
                }
            });
        } catch (IOException e) {
            handler.post(new Runnable() { // from class: dc.ye4
                @Override // java.lang.Runnable
                public final void run() {
                    callback2.onComplete(e);
                }
            });
        }
    }

    private static void copyAssets(AssetManager assetManager, String str, File file) throws IOException {
        String[] list = assetManager.list(str);
        if (list == null) {
            return;
        }
        if (list.length == 0) {
            if (str.endsWith("uuid")) {
                return;
            }
            copyFile(assetManager, str, file);
            return;
        }
        File file2 = new File(file, str);
        if (!file2.exists()) {
            String str2 = "Making directory " + file2.getAbsolutePath();
            if (!file2.mkdirs()) {
                String str3 = "Failed to create directory " + file2.getAbsolutePath();
            }
        }
        for (String str4 : list) {
            copyAssets(assetManager, str + "/" + str4, file);
        }
    }

    private static void copyFile(AssetManager assetManager, String str, File file) throws IOException {
        String str2 = "Copy " + str + " to " + file;
        InputStream inputStreamOpen = assetManager.open(str);
        FileOutputStream fileOutputStream = new FileOutputStream(file + "/" + str);
        byte[] bArr = new byte[4000];
        while (true) {
            int i = inputStreamOpen.read(bArr);
            if (i == -1) {
                inputStreamOpen.close();
                fileOutputStream.close();
                return;
            }
            fileOutputStream.write(bArr, 0, i);
        }
    }

    private static boolean deleteContents(File file) {
        File[] fileArrListFiles = file.listFiles();
        boolean zDeleteContents = true;
        if (fileArrListFiles != null) {
            for (File file2 : fileArrListFiles) {
                if (file2.isDirectory()) {
                    zDeleteContents &= deleteContents(file2);
                }
                if (!file2.delete()) {
                    zDeleteContents = false;
                }
            }
        }
        return zDeleteContents;
    }

    private static String readLine(InputStream inputStream) throws IOException {
        return new BufferedReader(new InputStreamReader(inputStream)).readLine();
    }

    public static String sync(Context context, String str, String str2) throws IOException {
        AssetManager assets = context.getAssets();
        File externalFilesDir = context.getExternalFilesDir(null);
        if (externalFilesDir == null) {
            throw new IOException("cannot get external files dir, external storage state is " + Environment.getExternalStorageState());
        }
        File file = new File(externalFilesDir, str2);
        String absolutePath = new File(file, str).getAbsolutePath();
        try {
            if (readLine(new FileInputStream(new File(file, str + "/uuid"))).equals(readLine(assets.open(str + "/uuid")))) {
                return absolutePath;
            }
        } catch (FileNotFoundException unused) {
        }
        deleteContents(file);
        copyAssets(assets, str, file);
        copyFile(assets, str + "/uuid", file);
        return absolutePath;
    }

    public static void unpack(final Context context, final String str, final String str2, final Callback<Model> callback, final Callback<IOException> callback2) {
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor();
        final Handler handler = new Handler(Looper.getMainLooper());
        executorServiceNewSingleThreadExecutor.execute(new Runnable() { // from class: dc.ze4
            @Override // java.lang.Runnable
            public final void run() {
                StorageService.c(context, str, str2, handler, callback, callback2);
            }
        });
    }
}
