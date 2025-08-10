package dc;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.widget.ImageView;
import androidx.core.content.FileProvider;
import com.lovense.wear.R;
import com.wear.bean.Group;
import com.wear.ui.longDistance.CameraNewActivity;
import com.wear.util.WearUtils;
import io.agora.rtc2.Constants;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.jivesoftware.smack.util.stringencoder.Base64;

/* compiled from: TakePhotoUtil.java */
/* loaded from: classes4.dex */
public class tg3 {

    /* compiled from: TakePhotoUtil.java */
    public interface a {
        void a(Bitmap bitmap, String str);
    }

    public static int a(BitmapFactory.Options options, int i, int i2) {
        int i3 = options.outHeight;
        int i4 = options.outWidth;
        if (i3 <= i2 && i4 <= i) {
            return 1;
        }
        int iRound = Math.round(i3 / i2);
        int iRound2 = Math.round(i4 / i);
        if (iRound < iRound2) {
            iRound = iRound2;
        }
        return 1 + iRound;
    }

    public static String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String str2 = "";
        for (String str3 : str.split(",")) {
            if (!TextUtils.isEmpty(str3) && !str3.contains("UploadFiles/wear/avatar")) {
                try {
                    String str4 = new String(Base64.decode(str3), "ISO-8859-1");
                    str3 = (TextUtils.isEmpty(str4) || str4.length() > 512) ? "" : str4;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            str2 = str2 + str3 + ",";
        }
        return !TextUtils.isEmpty(str2) ? str2.substring(0, str2.length() - 1) : "";
    }

    public static String c(String str) {
        return WearUtils.v(str, "");
    }

    public static Bitmap d(String str, int i, int i2) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        options.inSampleSize = a(options, i, i2);
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
        options.inJustDecodeBounds = false;
        xe3.a("TakePhotoUtil", "压缩比例：" + options.inSampleSize);
        Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(str, options);
        if (bitmapDecodeFile == null) {
            return null;
        }
        Bitmap bitmapG = g(bitmapDecodeFile, f(str));
        h(bitmapG, str);
        return bitmapG;
    }

    public static void e(File file, Context context, Uri uri, a aVar) {
        try {
            Bitmap bitmapD = d(file.getAbsolutePath(), 1080, 1920);
            String strD0 = WearUtils.d0();
            WearUtils.e2(bitmapD, strD0);
            String str = "handlerTakePhotoByUri filePath: " + strD0;
            aVar.a(bitmapD, strD0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int f(String str) {
        try {
            int attributeInt = new ExifInterface(str).getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, 1);
            if (attributeInt == 3) {
                return 180;
            }
            if (attributeInt == 6) {
                return 90;
            }
            if (attributeInt != 8) {
                return 0;
            }
            return Constants.VIDEO_ORIENTATION_270;
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static Bitmap g(Bitmap bitmap, int i) {
        if (bitmap == null) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.postRotate(i);
        return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
    }

    public static Bitmap h(Bitmap bitmap, String str) {
        try {
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, new FileOutputStream(str));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return bitmap;
    }

    public static void i(ImageView imageView, Group group) {
        if (imageView == null || group == null) {
            return;
        }
        if (group.isExit()) {
            j(imageView, group.getMcs());
        } else {
            j(imageView, group.getUrl());
        }
    }

    public static void j(ImageView imageView, String str) {
        if (TextUtils.isEmpty(str)) {
            imageView.setImageDrawable(th4.d(imageView.getContext(), R.drawable.icon_avatar_group_default));
            return;
        }
        qo qoVarF = new qo().h(R.drawable.icon_avatar_group_default).X(R.drawable.icon_avatar_group_default).f(ii.a);
        if (!str.startsWith("http")) {
            str = WearUtils.e + str;
        }
        kf.w(imageView.getContext()).v(str).a(qoVarF).A0(imageView);
    }

    public static void k(Activity activity, int i) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.PICK");
        intent.setType("image/*");
        intent.putExtra("return-data", false);
        if (intent.resolveActivity(activity.getPackageManager()) == null) {
            intent.setAction("android.intent.action.GET_CONTENT");
        }
        activity.startActivityForResult(intent, i);
    }

    public static Uri l(Activity activity, File file, int i) throws IOException {
        try {
            if (file.exists()) {
                file.delete();
            }
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Uri uriForFile = Build.VERSION.SDK_INT >= 24 ? FileProvider.getUriForFile(activity, "com.lovense.wear.fileprovider", file) : Uri.fromFile(file);
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        intent.putExtra("output", uriForFile);
        activity.startActivityForResult(intent, i);
        return uriForFile;
    }

    public static Uri m(Activity activity, File file, int i, int i2) throws IOException {
        try {
            if (file.exists()) {
                file.delete();
            }
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Uri uriForFile = Build.VERSION.SDK_INT >= 24 ? FileProvider.getUriForFile(activity, "com.lovense.wear.fileprovider", file) : Uri.fromFile(file);
        Intent intent = new Intent(activity, (Class<?>) CameraNewActivity.class);
        intent.putExtra("filePath", file.getAbsolutePath());
        intent.putExtra("chatType", i2);
        activity.startActivityForResult(intent, i);
        return uriForFile;
    }
}
