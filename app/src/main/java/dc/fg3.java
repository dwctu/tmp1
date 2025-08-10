package dc;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.component.dxutilcode.lib.utils.ToastUtils;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.android.exoplayer2.util.MimeTypes;
import com.j256.ormlite.field.FieldType;
import com.lovense.wear.R;
import com.wear.bean.EmojiFavorite;
import com.wear.dao.DaoUtils;
import com.wear.protocol.CommunMessage;
import com.wear.protocol.DataEntityAbstract;
import com.wear.protocol.EntityPicture;
import com.wear.protocol.MessageType;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import dc.he3;
import dc.yc4;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.Map;
import org.bouncycastle.i18n.MessageBundle;

/* compiled from: SavePhotoUtils.java */
/* loaded from: classes4.dex */
public class fg3 {

    /* compiled from: SavePhotoUtils.java */
    public class a implements bc4 {
        @Override // dc.bc4
        public void onFailure(@NonNull ac4 ac4Var, @NonNull IOException iOException) {
            ToastUtils.y(iOException.getMessage());
        }

        @Override // dc.bc4
        public void onResponse(@NonNull ac4 ac4Var, @NonNull ad4 ad4Var) throws IOException {
            if (!ad4Var.isSuccessful() || ad4Var.b() == null) {
                ToastUtils.y(ad4Var.x());
                return;
            }
            MyApplication myApplication = WearUtils.x;
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            InputStream inputStreamByteStream = ad4Var.b().byteStream();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[2048];
            while (true) {
                int i = inputStreamByteStream.read(bArr);
                if (i <= -1) {
                    break;
                } else {
                    byteArrayOutputStream.write(bArr, 0, i);
                }
            }
            byteArrayOutputStream.flush();
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
            BitmapFactory.decodeStream(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()), null, options);
            String str = options.outMimeType;
            ContentResolver contentResolver = myApplication.getContentResolver();
            ContentValues contentValues = new ContentValues();
            contentValues.put("mime_type", str);
            contentValues.put("date_added", Long.valueOf(System.currentTimeMillis()));
            Uri uriInsert = contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
            OutputStream outputStreamOpenOutputStream = contentResolver.openOutputStream(uriInsert);
            byte[] bArr2 = new byte[2048];
            while (true) {
                int i2 = byteArrayInputStream.read(bArr2);
                if (i2 == -1) {
                    break;
                } else {
                    outputStreamOpenOutputStream.write(bArr2, 0, i2);
                }
            }
            outputStreamOpenOutputStream.close();
            Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
            intent.setData(uriInsert);
            myApplication.sendBroadcast(intent);
            Cursor cursorQuery = contentResolver.query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new String[]{FieldType.FOREIGN_ID_FIELD_SUFFIX, "_data"}, "_id=? ", new String[]{uriInsert.getLastPathSegment()}, null);
            if (cursorQuery != null) {
                cursorQuery.moveToNext();
                int columnIndex = cursorQuery.getColumnIndex("_data");
                if (columnIndex != -1) {
                    ToastUtils.y(String.format(ah4.e(R.string.chat_message_item_save_path), cursorQuery.getString(columnIndex)));
                }
                cursorQuery.close();
            }
        }
    }

    /* compiled from: SavePhotoUtils.java */
    public class b implements he3.f {
        public final /* synthetic */ File a;
        public final /* synthetic */ EntityPicture b;

        /* compiled from: SavePhotoUtils.java */
        public class a implements Runnable {
            public final /* synthetic */ Map a;

            /* compiled from: SavePhotoUtils.java */
            /* renamed from: dc.fg3$b$a$a, reason: collision with other inner class name */
            public class C0179a implements he3.f {
                public C0179a(a aVar) {
                }

                @Override // dc.he3.f
                public void a(Map map) {
                    ToastUtils.x(R.string.comman_saved_successfully);
                }
            }

            public a(Map map) {
                this.a = map;
            }

            @Override // java.lang.Runnable
            public void run() throws IOException {
                Map map = this.a;
                if (map == null || map.get(TtmlNode.ATTR_ID) == null || WearUtils.e1(this.a.get(TtmlNode.ATTR_ID).toString())) {
                    return;
                }
                WearUtils.q(b.this.a, new File(WearUtils.Y(), WearUtils.r0(this.a.get(TtmlNode.ATTR_ID).toString())));
                EmojiFavorite emojiFavorite = new EmojiFavorite(b.this.b.getFileMd5());
                emojiFavorite.setEmojiId(this.a.get(TtmlNode.ATTR_ID).toString());
                emojiFavorite.setPath(this.a.get("path").toString());
                emojiFavorite.setOwner(zt3.k);
                emojiFavorite.setCreated(new Date());
                DaoUtils.getEmojiFavoriteDao().addIfNotExist(emojiFavorite);
                he3.f(new C0179a(this));
            }
        }

        public b(File file, EntityPicture entityPicture) {
            this.a = file;
            this.b = entityPicture;
        }

        @Override // dc.he3.f
        public void a(Map map) {
            WearUtils.x.m.post(new a(map));
        }
    }

    public static void a(CommunMessage communMessage) {
        DataEntityAbstract dataBean = communMessage.getDataBean();
        final ie3 ie3Var = new ie3();
        if (communMessage.getType() == MessageType.picture) {
            final EntityPicture entityPicture = (EntityPicture) dataBean;
            if (WearUtils.e1(entityPicture.getType()) || !entityPicture.getType().equals("emoji")) {
                ToastUtils.x(R.string.chat_message_item_save_error);
                return;
            }
            if (TextUtils.isEmpty(entityPicture.getUrl())) {
                ToastUtils.x(R.string.chat_message_item_save_error);
                return;
            }
            final String str = WearUtils.e + entityPicture.getUrl().replace("thum_", "");
            vg3.b().a(new Runnable() { // from class: dc.ad3
                @Override // java.lang.Runnable
                public final void run() {
                    fg3.e(str, entityPicture, ie3Var);
                }
            });
        }
    }

    public static void b(String str, String str2) {
        vc4 vc4Var = new vc4();
        yc4.a aVar = new yc4.a();
        aVar.k(str);
        vc4Var.a(aVar.b()).j(new a());
    }

    public static File c(String str, String str2) throws IOException {
        File externalCacheDir = WearUtils.x.getExternalCacheDir();
        vc4 vc4Var = new vc4();
        yc4.a aVar = new yc4.a();
        aVar.k(str);
        try {
            ad4 ad4VarExecute = vc4Var.a(aVar.b()).execute();
            if (!ad4VarExecute.isSuccessful() || ad4VarExecute.b() == null) {
                return null;
            }
            InputStream inputStreamByteStream = ad4VarExecute.b().byteStream();
            File file = new File(externalCacheDir, System.currentTimeMillis() + ".gif");
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            byte[] bArr = new byte[2048];
            while (true) {
                int i = inputStreamByteStream.read(bArr);
                if (i == -1) {
                    fileOutputStream.close();
                    return file;
                }
                fileOutputStream.write(bArr, 0, i);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String d(String str) {
        return str.lastIndexOf(".") != -1 ? str.substring(str.lastIndexOf("."), str.length()) : ".jpg";
    }

    public static /* synthetic */ void e(String str, EntityPicture entityPicture, ie3 ie3Var) {
        try {
            File fileC = c(str, entityPicture.getLocalUrl());
            if (fileC == null || !fileC.exists()) {
                ToastUtils.x(R.string.chat_message_item_save_error);
            } else if (WearUtils.E.size() >= 81) {
                ToastUtils.x(R.string.add_favorite_faile_maxcount);
            } else {
                ie3Var.j.c(fileC, "", new b(fileC, entityPicture));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void f(String str, String str2) {
        Intent intent;
        Uri uri = Uri.parse(str);
        if (TextUtils.equals("https", uri.getScheme()) || TextUtils.equals("http", uri.getScheme())) {
            b(str, str2);
            return;
        }
        File file = new File(uri.getPath());
        MyApplication myApplication = WearUtils.x;
        if (file.exists() && le3.c(file).startsWith("image")) {
            try {
                try {
                    ToastUtils.y(String.format(ah4.e(R.string.chat_message_item_save_path), file.getAbsoluteFile()));
                    MediaStore.Images.Media.insertImage(myApplication.getContentResolver(), file.getAbsolutePath(), file.getName(), (String) null);
                    intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
                } catch (Exception e) {
                    e.printStackTrace();
                    intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
                }
                intent.setData(Uri.fromFile(file));
                myApplication.sendBroadcast(intent);
            } catch (Throwable th) {
                Intent intent2 = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
                intent2.setData(Uri.fromFile(file));
                myApplication.sendBroadcast(intent2);
                throw th;
            }
        }
    }

    public static void g(Context context, File file) {
        try {
            ContentResolver contentResolver = context.getContentResolver();
            ContentValues contentValues = new ContentValues();
            contentValues.put(MessageBundle.TITLE_ENTRY, file.getName());
            contentValues.put("_display_name", file.getName());
            contentValues.put("mime_type", MimeTypes.VIDEO_MP4);
            contentValues.put("date_added", Long.valueOf(System.currentTimeMillis()));
            Uri uriInsert = contentResolver.insert(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, contentValues);
            OutputStream outputStreamOpenOutputStream = contentResolver.openOutputStream(uriInsert);
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] bArr = new byte[2048];
            while (true) {
                int i = fileInputStream.read(bArr);
                if (i == -1) {
                    break;
                } else {
                    outputStreamOpenOutputStream.write(bArr, 0, i);
                }
            }
            outputStreamOpenOutputStream.close();
            Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
            intent.setData(uriInsert);
            context.sendBroadcast(intent);
            Cursor cursorQuery = contentResolver.query(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, new String[]{FieldType.FOREIGN_ID_FIELD_SUFFIX, "_data"}, "_id=? ", new String[]{uriInsert.getLastPathSegment()}, null);
            if (cursorQuery != null) {
                cursorQuery.moveToNext();
                int columnIndex = cursorQuery.getColumnIndex("_data");
                if (columnIndex != -1) {
                    ToastUtils.y(String.format(ah4.e(R.string.chat_message_item_save_path), cursorQuery.getString(columnIndex)));
                }
                cursorQuery.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
