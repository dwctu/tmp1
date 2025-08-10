package dc;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* compiled from: CompressImageUtil.java */
/* loaded from: classes4.dex */
public class wd3 {
    public static wd3 a;

    /* compiled from: CompressImageUtil.java */
    public class a implements Consumer<String> {
        public final /* synthetic */ List a;
        public final /* synthetic */ int b;
        public final /* synthetic */ c c;

        public a(wd3 wd3Var, List list, int i, c cVar) {
            this.a = list;
            this.b = i;
            this.c = cVar;
        }

        @Override // io.reactivex.functions.Consumer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(String str) throws Exception {
            c cVar;
            if (!TextUtils.isEmpty(str)) {
                this.a.add(str);
            }
            if (this.a.size() != this.b || (cVar = this.c) == null) {
                return;
            }
            List list = this.a;
            cVar.a((String[]) list.toArray(new String[list.size()]));
        }
    }

    /* compiled from: CompressImageUtil.java */
    public class b implements Function<String, String> {
        public b(wd3 wd3Var) {
        }

        @Override // io.reactivex.functions.Function
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public String apply(@NotNull String str) throws Exception {
            try {
                File file = new File(qe3.f(MyApplication.N(), Uri.parse(str)));
                if (file.length() > PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE) {
                    Uri uriFromFile = Uri.fromFile(file);
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inPreferredConfig = Bitmap.Config.RGB_565;
                    options.inSampleSize = 2;
                    options.inJustDecodeBounds = false;
                    Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(MyApplication.N().getContentResolver().openInputStream(uriFromFile), null, options);
                    Bitmap bitmapL = WearUtils.l(MyApplication.N(), bitmapDecodeStream, qe3.g(MyApplication.N(), uriFromFile, bitmapDecodeStream));
                    if (bitmapL != null) {
                        Bitmap bitmapJ2 = WearUtils.J2(bitmapL, 2048);
                        String strD0 = WearUtils.d0();
                        WearUtils.e2(bitmapJ2, strD0);
                        return WearUtils.c0(strD0).getPath();
                    }
                } else if (Build.VERSION.SDK_INT >= 29) {
                    BitmapFactory.Options options2 = new BitmapFactory.Options();
                    options2.inJustDecodeBounds = false;
                    Bitmap bitmapDecodeStream2 = BitmapFactory.decodeStream(MyApplication.N().getContentResolver().openInputStream(Uri.parse(str)), null, options2);
                    if (bitmapDecodeStream2 != null) {
                        String strD02 = WearUtils.d0();
                        WearUtils.e2(bitmapDecodeStream2, strD02);
                        return WearUtils.c0(strD02).getPath();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    /* compiled from: CompressImageUtil.java */
    public interface c {
        void a(String[] strArr);
    }

    public static wd3 b() {
        if (a == null) {
            synchronized (wd3.class) {
                if (a == null) {
                    a = new wd3();
                }
            }
        }
        return a;
    }

    public void a(String[] strArr, c cVar) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            if (!TextUtils.isEmpty(str)) {
                arrayList.add(str);
            }
        }
        String[] strArr2 = (String[]) arrayList.toArray(new String[arrayList.size()]);
        Observable.fromArray(strArr2).map(new b(this)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new a(this, new ArrayList(), strArr2.length, cVar));
    }
}
