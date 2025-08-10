package dc;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.webkit.MimeTypeMap;
import androidx.core.content.FileProvider;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

/* compiled from: FileUtils.java */
/* loaded from: classes4.dex */
public class ti3 {
    public static void a(File file) {
        try {
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write("");
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void b(File file) {
        if (file == null || !file.exists()) {
            return;
        }
        if (!file.isDirectory()) {
            file.delete();
            return;
        }
        for (File file2 : file.listFiles()) {
            if (!file2.isDirectory()) {
                file2.delete();
            }
        }
    }

    public static String c(String str) {
        int iLastIndexOf = str.lastIndexOf(46);
        if (iLastIndexOf < 0) {
            return null;
        }
        return str.substring(iLastIndexOf + 1);
    }

    public static String d(File file) {
        String strC = c(file.getName());
        if (strC != null) {
            return MimeTypeMap.getSingleton().getMimeTypeFromExtension(strC);
        }
        return null;
    }

    public static boolean e(Context context, String str) {
        try {
            File file = new File(str);
            if (!file.exists()) {
                return false;
            }
            Intent intent = new Intent("android.intent.action.VIEW");
            Uri uriForFile = Build.VERSION.SDK_INT >= 24 ? FileProvider.getUriForFile(context, "com.lovense.wear.fileprovider", file) : Uri.fromFile(file);
            intent.addFlags(1);
            intent.setDataAndType(uriForFile, d(file));
            context.startActivity(intent);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static String f(Context context, String str) throws IOException {
        try {
            FileInputStream fileInputStreamOpenFileInput = context.openFileInput(str);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStreamOpenFileInput);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuilder sb = new StringBuilder();
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    bufferedReader.close();
                    inputStreamReader.close();
                    fileInputStreamOpenFileInput.close();
                    return sb.toString();
                }
                sb.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static void g(Context context, String str, String str2) throws IOException {
        try {
            FileOutputStream fileOutputStreamOpenFileOutput = context.openFileOutput(str2, 0);
            fileOutputStreamOpenFileOutput.write(str.getBytes());
            fileOutputStreamOpenFileOutput.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
