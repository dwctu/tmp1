package dc;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import androidx.annotation.NonNull;
import com.lovense.wear.R;
import com.wear.util.WearUtils;
import dc.ih;
import dc.yc4;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/* compiled from: GroupIconStreamFetcher.java */
/* loaded from: classes4.dex */
public class kj3 implements ih<InputStream> {
    public final List<String> a;
    public final Context b;

    public kj3(Context context, List<String> list) {
        this.b = context;
        this.a = list;
        new qo().h(R.drawable.chat_avatar_default).X(R.drawable.chat_avatar_default);
    }

    @Override // dc.ih
    public void a() {
        xe3.a("GroupIconStreamFetcher", "cleanup：" + this.a.toString());
    }

    public InputStream b(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        return new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
    }

    @Override // dc.ih
    @NonNull
    public sg c() {
        return sg.REMOTE;
    }

    @Override // dc.ih
    public void cancel() {
        xe3.a("GroupIconStreamFetcher", "cancel：" + this.a.toString());
    }

    @Override // dc.ih
    public void d(@NonNull of ofVar, @NonNull ih.a<? super InputStream> aVar) {
        int i;
        ArrayList arrayList = new ArrayList();
        for (String str : this.a) {
            try {
                if (WearUtils.e.equals(str)) {
                    arrayList.add(BitmapFactory.decodeResource(this.b.getResources(), R.drawable.chat_avatar_default));
                } else {
                    vc4 vc4Var = new vc4();
                    yc4.a aVar2 = new yc4.a();
                    aVar2.k(str);
                    ad4 ad4VarExecute = vc4Var.a(aVar2.b()).execute();
                    if (ad4VarExecute.isSuccessful()) {
                        Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(ad4VarExecute.b().byteStream());
                        int width = bitmapDecodeStream.getWidth();
                        int height = bitmapDecodeStream.getHeight();
                        int iMin = Math.min(width, height);
                        int i2 = 0;
                        if (iMin == width) {
                            i = (height / 2) - (iMin / 2);
                        } else {
                            i2 = (width / 2) - (iMin / 2);
                            i = 0;
                        }
                        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmapDecodeStream, i2, i, iMin, iMin);
                        if (bitmapCreateBitmap != null) {
                            arrayList.add(bitmapCreateBitmap);
                        } else {
                            arrayList.add(BitmapFactory.decodeResource(this.b.getResources(), R.drawable.chat_avatar_default));
                        }
                    } else {
                        arrayList.add(BitmapFactory.decodeResource(this.b.getResources(), R.drawable.chat_avatar_default));
                    }
                }
            } catch (Exception unused) {
                arrayList.add(BitmapFactory.decodeResource(this.b.getResources(), R.drawable.chat_avatar_default));
            }
        }
        aVar.e(b(sd3.g(arrayList)));
    }

    @Override // dc.ih
    @NonNull
    public Class<InputStream> getDataClass() {
        return InputStream.class;
    }
}
