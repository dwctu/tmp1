package dc;

import android.content.Context;
import android.content.res.AssetManager;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: VibemateAssetsUtil.java */
/* loaded from: classes4.dex */
public class ok3 {

    /* compiled from: VibemateAssetsUtil.java */
    public interface a {
        void a(File file);
    }

    public static void a(Context context, String str, String str2, a aVar) throws IOException {
        AssetManager assets = context.getAssets();
        try {
            String[] list = assets.list(str);
            if (list.length != 0) {
                String str3 = str2 + File.separator + str;
                File file = new File(str3);
                if (!file.exists()) {
                    file.mkdirs();
                }
                for (String str4 : list) {
                    a(context, str + File.separator + str4, str3, aVar);
                }
                return;
            }
            InputStream inputStreamOpen = assets.open(str);
            byte[] bArr = new byte[1024];
            String str5 = File.separator;
            if (str.contains(str5)) {
                str = str.substring(str.lastIndexOf(str5));
            }
            File file2 = new File(str2 + str5 + str);
            if (file2.exists()) {
                if (aVar != null) {
                    aVar.a(file2);
                    return;
                }
                return;
            }
            file2.createNewFile();
            if (aVar != null) {
                aVar.a(file2);
            }
            String str6 = "putAssetsToSDCard: 文件=" + file2.getPath();
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            while (true) {
                int i = inputStreamOpen.read(bArr);
                if (i == -1) {
                    fileOutputStream.flush();
                    inputStreamOpen.close();
                    fileOutputStream.close();
                    return;
                }
                fileOutputStream.write(bArr, 0, i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
