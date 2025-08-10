package dc;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.text.TextUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import org.jivesoftware.smackx.xhtmlim.packet.XHTMLExtension;

/* compiled from: FileImageUpload.java */
/* loaded from: classes4.dex */
public class le3 {
    public static final Map<String, String> a = new a();

    /* compiled from: FileImageUpload.java */
    public class a extends HashMap<String, String> {
        public a() {
            put("FFD8FF", "jpg");
            put("89504E47", "png");
            put("47494638", "gif");
            put("49492A00", "tif");
            put("424D", "bmp");
            put("41433130", "dwg");
            put("38425053", "psd");
            put("7B5C727466", "rtf");
            put("3C3F786D6C", "xml");
            put("68746D6C3E", XHTMLExtension.ELEMENT);
            put("44656C69766572792D646174653A", "eml");
            put("D0CF11E0", "doc");
            put("5374616E64617264204A", "mdb");
            put("252150532D41646F6265", "ps");
            put("255044462D312E", "pdf");
            put("504B0304", "zip");
            put("52617221", "rar");
            put("57415645", "wav");
            put("41564920", "avi");
            put("2E524D46", "rm");
            put("000001BA", "mpg");
            put("000001B3", "mpg");
            put("6D6F6F76", "mov");
            put("3026B2758E66CF11", "asf");
            put("4D546864", "mid");
            put("1F8B08", "gz");
        }
    }

    public static String a(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        for (byte b : bArr) {
            String upperCase = Integer.toHexString(b & 255).toUpperCase();
            if (upperCase.length() < 2) {
                sb.append(0);
            }
            sb.append(upperCase);
        }
        return sb.toString();
    }

    public static String b(String str) throws Throwable {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        strA = null;
        String strA = null;
        try {
            fileInputStream = new FileInputStream(str);
        } catch (Exception unused) {
            fileInputStream = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            byte[] bArr = new byte[3];
            fileInputStream.read(bArr, 0, 3);
            strA = a(bArr);
        } catch (Exception unused2) {
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            return strA;
        } catch (Throwable th2) {
            th = th2;
            fileInputStream2 = fileInputStream;
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                } catch (IOException unused3) {
                }
            }
            throw th;
        }
        try {
            fileInputStream.close();
        } catch (IOException unused4) {
        }
        return strA;
    }

    public static String c(File file) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(file.getPath(), options);
        return options.outMimeType;
    }

    public static String d(String str) {
        return a.get(b(str));
    }

    public static String e(Uri uri, Context context) throws Throwable {
        InputStream inputStreamOpenInputStream;
        String str;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        InputStream inputStream = null;
        try {
            try {
                try {
                    inputStreamOpenInputStream = context.getContentResolver().openInputStream(uri);
                    try {
                        BitmapFactory.decodeStream(inputStreamOpenInputStream, null, options);
                        str = options.outMimeType;
                    } catch (Exception e) {
                        e = e;
                        inputStream = inputStreamOpenInputStream;
                        e.printStackTrace();
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        return "jpeg";
                    } catch (Throwable th) {
                        th = th;
                        inputStream = inputStreamOpenInputStream;
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException unused) {
                            }
                        }
                        throw th;
                    }
                } catch (Exception e2) {
                    e = e2;
                }
                if (str == null) {
                    if (inputStreamOpenInputStream != null) {
                        inputStreamOpenInputStream.close();
                    }
                    return "jpeg";
                }
                String strReplace = str.replace("image/", "");
                if (inputStreamOpenInputStream != null) {
                    try {
                        inputStreamOpenInputStream.close();
                    } catch (IOException unused2) {
                    }
                }
                return strReplace;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException unused3) {
            return "jpeg";
        }
    }

    public static String f(File file) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(file.getPath(), options);
        String str = options.outMimeType;
        return str != null ? str.replace("image/", "") : "gif";
    }

    public static String g(String str) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        String str2 = options.outMimeType;
        return !TextUtils.isEmpty(str2) ? str2.substring(6, str2.length()) : str2;
    }
}
