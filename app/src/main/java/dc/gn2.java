package dc;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import com.wear.bean.response.BaseResponseBeanNew;
import com.wear.network.protocol.exception.NetException;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jivesoftware.smackx.xdata.packet.DataForm;

/* compiled from: ReportFriendPresenter.java */
/* loaded from: classes3.dex */
public class gn2 extends tl2<lp2, Object> implements wn2<Object> {
    public hn2 c;
    public fn2 d;

    /* compiled from: ReportFriendPresenter.java */
    public class a implements g {
        public a() {
        }

        @Override // dc.gn2.g
        public void a(String[] strArr) {
            gn2 gn2Var = gn2.this;
            gn2Var.d.b(strArr, gn2Var);
        }
    }

    /* compiled from: ReportFriendPresenter.java */
    public class b implements g {
        public b() {
        }

        @Override // dc.gn2.g
        public void a(String[] strArr) {
            gn2 gn2Var = gn2.this;
            gn2Var.c.c(strArr, gn2Var);
        }
    }

    /* compiled from: ReportFriendPresenter.java */
    public class c implements Consumer<String> {
        public final /* synthetic */ List a;
        public final /* synthetic */ int b;
        public final /* synthetic */ g c;

        public c(gn2 gn2Var, List list, int i, g gVar) {
            this.a = list;
            this.b = i;
            this.c = gVar;
        }

        @Override // io.reactivex.functions.Consumer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(String str) throws Exception {
            g gVar;
            if (!TextUtils.isEmpty(str)) {
                this.a.add(str);
            }
            if (this.a.size() != this.b || (gVar = this.c) == null) {
                return;
            }
            List list = this.a;
            gVar.a((String[]) list.toArray(new String[list.size()]));
        }
    }

    /* compiled from: ReportFriendPresenter.java */
    public class d implements Function<String, String> {
        public d(gn2 gn2Var) {
        }

        @Override // io.reactivex.functions.Function
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public String apply(@NotNull String str) throws Exception {
            try {
                File file = new File(str);
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

    /* compiled from: ReportFriendPresenter.java */
    public class e implements wn2<Boolean> {
        public e() {
        }

        @Override // dc.wn2
        public void b(String str, boolean z) {
            if (gn2.this.g()) {
                ((lp2) gn2.this.b.get()).showErrorMsg(str, z);
            }
        }

        @Override // dc.wn2
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(boolean z, Boolean bool) {
            if (gn2.this.g()) {
                ((lp2) gn2.this.b.get()).R3();
            }
        }

        @Override // dc.wn2
        public void d(NetException netException, boolean z) {
            if (gn2.this.g()) {
                ((lp2) gn2.this.b.get()).showErrorMsg(netException.getMessage(), z);
            }
        }
    }

    /* compiled from: ReportFriendPresenter.java */
    public class f implements wn2<Object> {
        public f() {
        }

        @Override // dc.wn2
        public void a(boolean z, Object obj) {
            if (gn2.this.g()) {
                ((lp2) gn2.this.b.get()).R3();
            }
        }

        @Override // dc.wn2
        public void b(String str, boolean z) {
            if (gn2.this.g()) {
                ((lp2) gn2.this.b.get()).showErrorMsg(str, false);
            }
        }

        @Override // dc.wn2
        public void d(NetException netException, boolean z) {
            if (gn2.this.g()) {
                ((lp2) gn2.this.b.get()).showErrorMsg(netException.message, false);
            }
        }
    }

    /* compiled from: ReportFriendPresenter.java */
    public interface g {
        void a(String[] strArr);
    }

    public gn2(fn2 fn2Var, hn2 hn2Var) {
        this.c = hn2Var;
        this.d = fn2Var;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // dc.tl2, dc.wn2
    public void a(boolean z, Object obj) {
        super.a(z, obj);
        if (obj instanceof BaseResponseBeanNew) {
            BaseResponseBeanNew baseResponseBeanNew = (BaseResponseBeanNew) obj;
            if (g()) {
                ((lp2) this.b.get()).B1((String) baseResponseBeanNew.data);
            }
        }
    }

    public final void n(String[] strArr, g gVar) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            if (!TextUtils.isEmpty(str)) {
                arrayList.add(str);
            }
        }
        String[] strArr2 = (String[]) arrayList.toArray(new String[arrayList.size()]);
        Observable.fromArray(strArr2).map(new d(this)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new c(this, new ArrayList(), strArr2.length, gVar));
    }

    public void o(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        HashMap map = new HashMap();
        map.put("appType", "remote");
        map.put("groupName", str);
        map.put("groupOwner", nd3.w(str2));
        map.put(DataForm.ReportedData.ELEMENT, str3);
        map.put("reportType", str4);
        map.put("othersReason", str5);
        map.put("imgs", str6);
        map.put("chats", str7);
        map.put("desc", str8);
        this.a = this.c.b(map, new e());
    }

    public void p(String str, String str2, String str3, String str4, String str5, String str6) {
        this.d.a(str, str2, str3, str4, str5, str6, new f());
    }

    public void q(String[] strArr) {
        n(strArr, new b());
    }

    public void r(String[] strArr) {
        n(strArr, new a());
    }
}
