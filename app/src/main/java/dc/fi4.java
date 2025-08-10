package dc;

import android.content.Context;
import android.content.pm.PackageManager;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: SkinAssetsLoader.java */
/* loaded from: classes5.dex */
public class fi4 extends ji4 {
    @Override // dc.zg4.c
    public String c(Context context, String str, int i) {
        return null;
    }

    @Override // dc.ji4
    public String f(Context context, String str) {
        return g(context, str);
    }

    public final String g(Context context, String str) throws IOException {
        String absolutePath = new File(ni4.b(context), str).getAbsolutePath();
        try {
            InputStream inputStreamOpen = context.createPackageContext(context.getPackageName(), 0).getAssets().open("skins" + File.separator + str);
            FileOutputStream fileOutputStream = new FileOutputStream(absolutePath);
            byte[] bArr = new byte[1024];
            while (true) {
                int i = inputStreamOpen.read(bArr);
                if (i == -1) {
                    break;
                }
                fileOutputStream.write(bArr, 0, i);
            }
            fileOutputStream.close();
            inputStreamOpen.close();
        } catch (PackageManager.NameNotFoundException | IOException e) {
            e.printStackTrace();
        }
        return absolutePath;
    }

    @Override // dc.zg4.c
    public int getType() {
        return 0;
    }
}
