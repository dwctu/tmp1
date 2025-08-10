package dc;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.net.Uri;
import com.google.android.vending.expansion.downloader.Constants;
import com.lovense.wear.R;
import com.wear.bean.Music;
import com.wear.bean.MusicPlaylist;
import com.wear.util.WearUtils;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/* compiled from: MediaUtil.java */
/* loaded from: classes4.dex */
public class cf3 {
    public static final Uri a = Uri.parse("content://media/external/audio/albumart");

    /* compiled from: MediaUtil.java */
    public static class a {
        public Bitmap a;
        public Music b;
        public int c;
    }

    public static Bitmap a(Bitmap bitmap, Bitmap bitmap2) {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap.getWidth() + bitmap2.getWidth(), Math.max(bitmap.getHeight(), bitmap2.getHeight()), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        canvas.drawBitmap(bitmap2, bitmap.getWidth(), 0.0f, (Paint) null);
        return bitmapCreateBitmap;
    }

    public static Bitmap b(Bitmap bitmap, Bitmap bitmap2) {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(Math.max(bitmap.getWidth(), bitmap2.getWidth()), bitmap.getHeight() + bitmap2.getHeight(), Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        canvas.drawBitmap(bitmap2, 0.0f, bitmap.getHeight(), (Paint) null);
        return bitmapCreateBitmap;
    }

    public static int c(BitmapFactory.Options options, int i) {
        int i2 = options.outWidth;
        int i3 = options.outHeight;
        int iMax = Math.max(i2 / i, i3 / i);
        if (iMax == 0) {
            return 1;
        }
        if (iMax > 1 && i2 > i && i2 / iMax < i) {
            iMax--;
        }
        return (iMax <= 1 || i3 <= i || i3 / iMax >= i) ? iMax : iMax - 1;
    }

    public static Bitmap d(Context context, long j, long j2, boolean z, boolean z2) throws Throwable {
        Bitmap bitmapE;
        InputStream inputStream = null;
        if (j2 < 0) {
            if (j < 0 && (bitmapE = e(context, j, -1L)) != null) {
                return bitmapE;
            }
            if (z) {
                return f(context, z2);
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
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inSampleSize = 1;
                    options.inJustDecodeBounds = true;
                    BitmapFactory.decodeStream(inputStreamOpenInputStream, null, options);
                    if (z2) {
                        options.inSampleSize = c(options, 40);
                    } else {
                        options.inSampleSize = c(options, 600);
                    }
                    options.inJustDecodeBounds = false;
                    options.inDither = false;
                    options.inPreferredConfig = Bitmap.Config.ARGB_8888;
                    InputStream inputStreamOpenInputStream2 = contentResolver.openInputStream(uriWithAppendedId);
                    try {
                        Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(inputStreamOpenInputStream2, null, options);
                        if (inputStreamOpenInputStream2 != null) {
                            try {
                                inputStreamOpenInputStream2.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                        return bitmapDecodeStream;
                    } catch (FileNotFoundException unused) {
                        inputStream = inputStreamOpenInputStream2;
                        Bitmap bitmapE2 = e(context, j, j2);
                        if (bitmapE2 != null) {
                            if (bitmapE2.getConfig() == null && (bitmapE2 = bitmapE2.copy(Bitmap.Config.RGB_565, false)) == null && z) {
                                Bitmap bitmapF = f(context, z2);
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (IOException e2) {
                                        e2.printStackTrace();
                                    }
                                }
                                return bitmapF;
                            }
                        } else if (z) {
                            bitmapE2 = f(context, z2);
                        }
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e3) {
                                e3.printStackTrace();
                            }
                        }
                        return bitmapE2;
                    } catch (Throwable th) {
                        th = th;
                        inputStream = inputStreamOpenInputStream2;
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e4) {
                                e4.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (FileNotFoundException unused2) {
                    inputStream = inputStreamOpenInputStream;
                } catch (Throwable th2) {
                    th = th2;
                    inputStream = inputStreamOpenInputStream;
                }
            } catch (FileNotFoundException unused3) {
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x005b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.graphics.Bitmap e(android.content.Context r4, long r5, long r7) throws java.io.FileNotFoundException {
        /*
            r0 = 0
            int r2 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
            if (r2 >= 0) goto L13
            int r3 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
            if (r3 < 0) goto Lb
            goto L13
        Lb:
            java.lang.IllegalArgumentException r4 = new java.lang.IllegalArgumentException
            java.lang.String r5 = "Must specify an album or a song id"
            r4.<init>(r5)
            throw r4
        L13:
            r0 = 0
            android.graphics.BitmapFactory$Options r1 = new android.graphics.BitmapFactory$Options     // Catch: java.io.FileNotFoundException -> L76
            r1.<init>()     // Catch: java.io.FileNotFoundException -> L76
            java.lang.String r3 = "r"
            if (r2 >= 0) goto L46
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.io.FileNotFoundException -> L76
            r7.<init>()     // Catch: java.io.FileNotFoundException -> L76
            java.lang.String r8 = "content://media/external/audio/media/"
            r7.append(r8)     // Catch: java.io.FileNotFoundException -> L76
            r7.append(r5)     // Catch: java.io.FileNotFoundException -> L76
            java.lang.String r5 = "/albumart"
            r7.append(r5)     // Catch: java.io.FileNotFoundException -> L76
            java.lang.String r5 = r7.toString()     // Catch: java.io.FileNotFoundException -> L76
            android.net.Uri r5 = android.net.Uri.parse(r5)     // Catch: java.io.FileNotFoundException -> L76
            android.content.ContentResolver r4 = r4.getContentResolver()     // Catch: java.io.FileNotFoundException -> L76
            android.os.ParcelFileDescriptor r4 = r4.openFileDescriptor(r5, r3)     // Catch: java.io.FileNotFoundException -> L76
            if (r4 == 0) goto L5b
            java.io.FileDescriptor r4 = r4.getFileDescriptor()     // Catch: java.io.FileNotFoundException -> L76
            goto L5c
        L46:
            android.net.Uri r5 = dc.cf3.a     // Catch: java.io.FileNotFoundException -> L76
            android.net.Uri r5 = android.content.ContentUris.withAppendedId(r5, r7)     // Catch: java.io.FileNotFoundException -> L76
            android.content.ContentResolver r4 = r4.getContentResolver()     // Catch: java.io.FileNotFoundException -> L76
            android.os.ParcelFileDescriptor r4 = r4.openFileDescriptor(r5, r3)     // Catch: java.io.FileNotFoundException -> L76
            if (r4 == 0) goto L5b
            java.io.FileDescriptor r4 = r4.getFileDescriptor()     // Catch: java.io.FileNotFoundException -> L76
            goto L5c
        L5b:
            r4 = r0
        L5c:
            r5 = 1
            r1.inSampleSize = r5     // Catch: java.io.FileNotFoundException -> L76
            r1.inJustDecodeBounds = r5     // Catch: java.io.FileNotFoundException -> L76
            android.graphics.BitmapFactory.decodeFileDescriptor(r4, r0, r1)     // Catch: java.io.FileNotFoundException -> L76
            r5 = 100
            r1.inSampleSize = r5     // Catch: java.io.FileNotFoundException -> L76
            r5 = 0
            r1.inJustDecodeBounds = r5     // Catch: java.io.FileNotFoundException -> L76
            r1.inDither = r5     // Catch: java.io.FileNotFoundException -> L76
            android.graphics.Bitmap$Config r5 = android.graphics.Bitmap.Config.ARGB_8888     // Catch: java.io.FileNotFoundException -> L76
            r1.inPreferredConfig = r5     // Catch: java.io.FileNotFoundException -> L76
            android.graphics.Bitmap r0 = android.graphics.BitmapFactory.decodeFileDescriptor(r4, r0, r1)     // Catch: java.io.FileNotFoundException -> L76
            goto L7a
        L76:
            r4 = move-exception
            r4.printStackTrace()
        L7a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: dc.cf3.e(android.content.Context, long, long):android.graphics.Bitmap");
    }

    @SuppressLint({"ResourceType"})
    public static Bitmap f(Context context, boolean z) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        return z ? BitmapFactory.decodeStream(context.getResources().openRawResource(R.drawable.content_icon_music_cover), null, options) : BitmapFactory.decodeStream(context.getResources().openRawResource(R.drawable.content_icon_music_cover), null, options);
    }

    public static File g(String str) {
        return new File(WearUtils.T("cbgf"), WearUtils.r0(str));
    }

    public static Bitmap h(Bitmap bitmap, int i, int i2) {
        return j(bitmap, i, i2);
    }

    public static String i(Context context, MusicPlaylist musicPlaylist) throws Throwable {
        if (musicPlaylist.getCreateFromLocalDB() != 1) {
            return musicPlaylist.getCover();
        }
        if (musicPlaylist.getItemsList() == null || musicPlaylist.getItemsList().size() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i = 0;
        for (int i2 = 0; i2 < musicPlaylist.getItemsList().size(); i2++) {
            Music music = musicPlaylist.getItemsList().get(i2).getMusic();
            if (music.getMusicType() == 0) {
                if (arrayList.size() == 4) {
                    break;
                }
                Bitmap bitmapD = d(context, music.getSongId(), music.getAlbumId(), false, true);
                if (bitmapD != null && arrayList.size() < 4) {
                    a aVar = new a();
                    aVar.b = music;
                    aVar.c = i2;
                    aVar.a = h(bitmapD, 100, 100);
                    arrayList.add(aVar);
                }
            }
        }
        if (arrayList.size() < 4 && arrayList.size() > 0) {
            int i3 = 0;
            while (true) {
                if (i3 >= musicPlaylist.getItemsList().size()) {
                    i3 = -1;
                    break;
                }
                if (musicPlaylist.getItemsList().get(i3).getMusic().getMusicType() != 0) {
                    break;
                }
                i3++;
            }
            if (i3 <= ((a) arrayList.get(0)).c && i3 != -1) {
                return musicPlaylist.getItemsList().get(i3).getMusic().getImageUrl();
            }
            return "content://media/external/audio/albumart/" + ((a) arrayList.get(0)).b.getAlbumId();
        }
        String str = "";
        if (arrayList.size() != 4) {
            while (true) {
                if (i >= musicPlaylist.getItemsList().size()) {
                    i = -1;
                    break;
                }
                if (musicPlaylist.getItemsList().get(i).getMusic().getMusicType() != 0) {
                    break;
                }
                i++;
            }
            return i > -1 ? musicPlaylist.getItemsList().get(i).getMusic().getImageUrl() : "";
        }
        for (int i4 = 0; i4 < arrayList.size(); i4++) {
            str = i4 == arrayList.size() - 1 ? str + ((a) arrayList.get(i4)).b.getSongId() : str + ((a) arrayList.get(i4)).b.getSongId() + Constants.FILENAME_SEQUENCE_SEPARATOR;
        }
        File fileG = g(str);
        if (!fileG.exists()) {
            fileG = new File(k(b(a(((a) arrayList.get(0)).a, ((a) arrayList.get(1)).a), a(((a) arrayList.get(2)).a, ((a) arrayList.get(3)).a)), str));
        }
        return Uri.fromFile(fileG).toString();
    }

    public static Bitmap j(Bitmap bitmap, int i, int i2) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.postScale(i / width, i2 / height);
        return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
    }

    public static String k(Bitmap bitmap, String str) throws IOException {
        File fileG = g(str);
        if (fileG.exists()) {
            fileG.delete();
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(fileG);
            bitmap.compress(Bitmap.CompressFormat.PNG, 90, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        return fileG.getAbsolutePath();
    }
}
