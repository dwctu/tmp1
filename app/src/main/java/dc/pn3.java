package dc;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import com.lovense.wear.R;
import com.wear.phonertc.RequestPermissionActivity;
import com.wear.util.MyApplication;
import com.wear.util.NormalResponse;
import com.wear.util.WearUtils;
import com.wear.widget.RingProgressBar;
import dc.is3;
import dc.kn3;
import dc.tn2;
import java.io.File;
import java.io.FileInputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* compiled from: EnquiresPics.java */
/* loaded from: classes4.dex */
public class pn3 {
    public Activity a;
    public h e;
    public i f;
    public File j;
    public Uri k;
    public int l;
    public String m;
    public ArrayList<String> n;
    public ac4 o;
    public ArrayList<g> b = new ArrayList<>();
    public ArrayList<File> c = new ArrayList<>();
    public HashMap<String, Bitmap> d = new HashMap<>();
    public int g = -1;
    public kn3 h = null;
    public RingProgressBar i = null;

    /* compiled from: EnquiresPics.java */
    public class a implements h {
        public a() {
        }

        @Override // dc.pn3.h
        public void a(int i) {
            pn3.this.t(i);
        }

        @Override // dc.pn3.h
        public void b(int i) {
            if (pn3.this.c.size() > 0 && i < pn3.this.c.size()) {
                File fileRemove = pn3.this.c.remove(i);
                Bitmap bitmapRemove = pn3.this.d.remove(fileRemove.getPath());
                if (bitmapRemove != null) {
                    bitmapRemove.recycle();
                }
                if (fileRemove != null && fileRemove.exists()) {
                    fileRemove.delete();
                }
            }
            Iterator<g> it = pn3.this.b.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                g next = it.next();
                Bitmap bitmapI2 = null;
                if (i2 < pn3.this.c.size()) {
                    File file = pn3.this.c.get(i2);
                    if (file.exists()) {
                        if (pn3.this.d.get(file.getPath()) != null) {
                            bitmapI2 = pn3.this.d.get(file.getPath());
                        } else {
                            try {
                                bitmapI2 = WearUtils.I2(BitmapFactory.decodeStream(new FileInputStream(file)));
                            } catch (Exception unused) {
                            }
                        }
                    }
                }
                i2++;
                next.e(bitmapI2);
            }
            if (pn3.this.c.size() <= 0 || pn3.this.c.size() >= pn3.this.b.size()) {
                pn3.this.b.get(0).a.setVisibility(0);
            } else {
                pn3 pn3Var = pn3.this;
                pn3Var.b.get(pn3Var.c.size()).a.setVisibility(0);
            }
            i iVar = pn3.this.f;
            if (iVar != null) {
                iVar.a(i);
            }
        }
    }

    /* compiled from: EnquiresPics.java */
    public class b implements Runnable {
        public final /* synthetic */ g a;
        public final /* synthetic */ Bitmap b;
        public final /* synthetic */ int c;

        public b(g gVar, Bitmap bitmap, int i) {
            this.a = gVar;
            this.b = bitmap;
            this.c = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.e(this.b);
            if (this.c < pn3.this.b.size() - 1) {
                pn3.this.b.get(this.c + 1).a.setVisibility(0);
            }
            i iVar = pn3.this.f;
            if (iVar != null) {
                iVar.a(this.c);
            }
        }
    }

    /* compiled from: EnquiresPics.java */
    public class c implements u51 {

        /* compiled from: EnquiresPics.java */
        public class a implements is3.d {
            public a() {
            }

            @Override // dc.is3.d
            public void doConfirm() {
                RequestPermissionActivity.s4(pn3.this.a);
            }
        }

        public c() {
        }

        @Override // dc.u51
        public void a(List<String> list, boolean z) {
            t51.a(this, list, z);
            if (z) {
                is3.b bVar = new is3.b(pn3.this.a);
                bVar.p(ah4.e(R.string.app_open_camera_permission));
                bVar.o(ah4.e(R.string.common_confirm));
                bVar.n(ah4.e(R.string.common_cancel));
                bVar.d(new a());
                cs3.h(bVar).show();
            }
        }

        @Override // dc.u51
        public void b(List<String> list, boolean z) {
            if (z) {
                pn3.this.m();
            }
        }
    }

    /* compiled from: EnquiresPics.java */
    public class d implements tn2.f {
        public final /* synthetic */ int a;
        public final /* synthetic */ boolean b;

        /* compiled from: EnquiresPics.java */
        public class a implements Runnable {
            public final /* synthetic */ String a;

            public a(String str) {
                this.a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (WearUtils.e1(this.a)) {
                    pn3.this.v();
                    return;
                }
                try {
                    NormalResponse normalResponse = (NormalResponse) WearUtils.A.fromJson(this.a, NormalResponse.class);
                    if (normalResponse != null && normalResponse.isResult()) {
                        String message = normalResponse.getMessage();
                        System.out.println("path!:" + message);
                        pn3.this.n.add(message);
                        d dVar = d.this;
                        pn3.this.b.get(dVar.a).d(true);
                        d dVar2 = d.this;
                        if (dVar2.a < pn3.this.c.size() - 1) {
                            d dVar3 = d.this;
                            pn3.this.x(dVar3.a + 1, dVar3.b);
                        } else {
                            pn3.this.g();
                            pn3 pn3Var = pn3.this;
                            i iVar = pn3Var.f;
                            if (iVar != null) {
                                iVar.b(pn3Var.m, WearUtils.G1(pn3.this.n, ","));
                            }
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    pn3.this.v();
                }
            }
        }

        public d(int i, boolean z) {
            this.a = i;
            this.b = z;
        }

        @Override // dc.tn2.f
        public void a(long j, float f, float f2) {
            PrintStream printStream = System.out;
            StringBuilder sb = new StringBuilder();
            sb.append("finalIndex:");
            sb.append(this.a);
            sb.append(" size:");
            sb.append(pn3.this.c.size());
            sb.append("numBytes:");
            sb.append(j);
            sb.append(" bytes percent:");
            float f3 = f * 100.0f;
            sb.append(f3);
            sb.append(" % speed:");
            sb.append(((f2 * 1000.0f) / 1024.0f) / 1024.0f);
            sb.append("  MB/秒");
            printStream.println(sb.toString());
            pn3.this.q(this.a, f3);
            kn3 kn3Var = pn3.this.h;
            if (kn3Var == null || !kn3Var.isShowing()) {
                return;
            }
            if (pn3.this.i != null) {
                pn3.this.i.setProgress((int) (((this.a * 100.0f) / r5.c.size()) + (f3 / pn3.this.c.size())));
            }
        }

        @Override // dc.tn2.f
        public void b(long j) {
        }

        @Override // dc.tn2.f
        public void onFinish() {
            System.out.println("finish!:");
        }

        @Override // dc.tn2.f
        public void onRequestComplete(String str) {
            pn3.this.a.runOnUiThread(new a(str));
        }
    }

    /* compiled from: EnquiresPics.java */
    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            i iVar = pn3.this.f;
            if (iVar != null) {
                iVar.c();
            }
        }
    }

    /* compiled from: EnquiresPics.java */
    public class f implements kn3.d {
        public f() {
        }

        @Override // dc.kn3.d
        public void doCancel() {
            pn3.this.h.dismiss();
            pn3.this.h = null;
        }

        @Override // dc.kn3.d
        public void doConfirm() {
            if (pn3.this.o != null) {
                pn3.this.o.cancel();
            }
            i iVar = pn3.this.f;
            if (iVar != null) {
                iVar.cancel();
            }
            pn3.this.h.dismiss();
            pn3.this.h = null;
        }
    }

    /* compiled from: EnquiresPics.java */
    public class g {
        public View a;
        public TextView b;
        public ImageView c;
        public ImageView d;
        public ProgressBar e;
        public SeekBar f;
        public boolean g = false;

        /* compiled from: EnquiresPics.java */
        public class a implements View.OnClickListener {
            public final /* synthetic */ h a;
            public final /* synthetic */ int b;

            public a(pn3 pn3Var, h hVar, int i) {
                this.a = hVar;
                this.b = i;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                boolean zJ = pn3.this.j();
                g gVar = g.this;
                if (gVar.g || zJ) {
                    return;
                }
                gVar.c.setVisibility(8);
                g.this.d.setVisibility(8);
                g.this.e.setVisibility(8);
                h hVar = this.a;
                if (hVar != null) {
                    hVar.b(this.b);
                }
            }
        }

        /* compiled from: EnquiresPics.java */
        public class b implements View.OnClickListener {
            public final /* synthetic */ h a;
            public final /* synthetic */ int b;

            public b(pn3 pn3Var, h hVar, int i) {
                this.a = hVar;
                this.b = i;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (this.a != null) {
                    g gVar = g.this;
                    if (gVar.g || gVar.d.getVisibility() != 8) {
                        return;
                    }
                    this.a.a(this.b);
                }
            }
        }

        public g(View view, int i, h hVar) throws Resources.NotFoundException {
            if (view != null) {
                this.a = view.findViewById(R.id.pic_action);
                this.b = (TextView) view.findViewById(R.id.txt_notice);
                this.c = (ImageView) view.findViewById(R.id.pic_content);
                this.d = (ImageView) view.findViewById(R.id.pic_delete);
                this.e = (ProgressBar) view.findViewById(R.id.loading_compress);
                this.f = (SeekBar) view.findViewById(R.id.upload_seek);
                this.d.setOnClickListener(new a(pn3.this, hVar, i));
                b bVar = new b(pn3.this, hVar, i);
                this.a.setOnClickListener(bVar);
                this.c.setOnClickListener(bVar);
                this.b.setText(i + "/4");
                if (i == 0) {
                    ah4.j(this.b, R.string.picture_add, new Object[0]);
                }
            }
        }

        public boolean a() {
            return this.g;
        }

        public void b(long j) {
        }

        public void c(float f) {
            this.f.setProgress((int) f);
        }

        public void d(boolean z) {
            this.g = z;
            if (z) {
                this.d.setBackgroundResource(R.drawable.pop_icon_success);
            } else {
                this.d.setBackgroundResource(R.drawable.icon_addpicture_delete);
            }
            this.f.setVisibility(8);
        }

        public void e(Bitmap bitmap) {
            if (bitmap != null) {
                this.c.setVisibility(0);
                this.d.setVisibility(0);
                this.e.setVisibility(8);
                this.c.setImageBitmap(bitmap);
                return;
            }
            this.c.setVisibility(8);
            this.d.setVisibility(8);
            this.a.setVisibility(8);
            this.e.setVisibility(8);
            this.f.setVisibility(8);
        }

        public void f(int i) {
            if (i == 0) {
                this.f.setProgress(0);
            }
            this.f.setVisibility(i);
        }
    }

    /* compiled from: EnquiresPics.java */
    public interface h {
        void a(int i);

        void b(int i);
    }

    /* compiled from: EnquiresPics.java */
    public interface i {
        void a(int i);

        void b(String str, String str2);

        void c();

        void cancel();
    }

    public pn3(Activity activity, View view, View view2, View view3, i iVar) {
        File fileE0 = WearUtils.e0("camera.jpg");
        this.j = fileE0;
        this.k = Uri.fromFile(fileE0);
        this.l = -1;
        this.m = "";
        this.n = new ArrayList<>();
        this.o = null;
        this.a = activity;
        this.f = iVar;
        File file = this.j;
        if (file != null && file.exists()) {
            this.j.delete();
        }
        WearUtils.Q1(WearUtils.b0().getName());
        this.e = new a();
        this.b.add(new g(view2.findViewById(R.id.enquires_1), 0, this.e));
        this.b.add(new g(view2.findViewById(R.id.enquires_2), 1, this.e));
        this.b.add(new g(view2.findViewById(R.id.enquires_3), 2, this.e));
        this.b.add(new g(view2.findViewById(R.id.enquires_4), 3, this.e));
        this.b.add(new g(view3.findViewById(R.id.enquires_5), 4, this.e));
        this.b.add(new g(view3.findViewById(R.id.enquires_6), 5, this.e));
        this.b.add(new g(view3.findViewById(R.id.enquires_7), 6, this.e));
        this.b.add(new g(view3.findViewById(R.id.enquires_8), 7, this.e));
        k();
    }

    public final void f(int i2) {
        this.g = i2;
        q61 q61VarM = q61.m(this.a);
        q61VarM.h("android.permission.CAMERA", "android.permission.READ_MEDIA_IMAGES", "android.permission.READ_MEDIA_VIDEO");
        q61VarM.j(new c());
    }

    public void g() {
        try {
            kn3 kn3Var = this.h;
            if (kn3Var != null) {
                if (kn3Var.isShowing()) {
                    Context baseContext = ((ContextWrapper) this.h.getContext()).getBaseContext();
                    if (!(baseContext instanceof Activity)) {
                        this.h.dismiss();
                    } else if (!((Activity) baseContext).isFinishing() && !((Activity) baseContext).isDestroyed()) {
                        this.h.dismiss();
                    }
                }
                this.h = null;
            }
        } catch (Exception unused) {
        }
    }

    public int h() {
        return this.l;
    }

    public int i() {
        return this.c.size();
    }

    public boolean j() {
        Iterator<g> it = this.b.iterator();
        while (it.hasNext()) {
            if (it.next().e.getVisibility() == 0) {
                return true;
            }
        }
        return false;
    }

    public void k() {
        if (this.b != null) {
            for (int i2 = 0; i2 < this.b.size(); i2++) {
                if (i2 > 0) {
                    this.b.get(i2).a.setVisibility(8);
                    this.b.get(i2).e.setVisibility(8);
                    this.b.get(i2).f.setVisibility(8);
                } else {
                    this.b.get(i2).a.setVisibility(0);
                }
            }
        }
    }

    public void l() {
        x(0, true);
    }

    public void m() {
        int i2 = this.g;
        if (i2 == R.id.from_camera) {
            Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
            intent.putExtra("output", this.k);
            intent.putExtra("return-data", false);
            this.a.startActivityForResult(intent, 16);
            return;
        }
        if (i2 == R.id.from_album) {
            Intent intent2 = new Intent("android.intent.action.PICK");
            intent2.setType("image/*");
            this.a.startActivityForResult(intent2, 17);
        } else if (i2 == 9097) {
            x83.b().g("标题").i(true).j(true).k(false).a(false).h(false).e((this.b.size() - this.c.size()) - 4).f(false).c(new w83()).l(this.a, 9097, 1);
        }
    }

    public void n() {
        this.c.clear();
        this.d.clear();
        k();
        this.e.b(0);
        Iterator<g> it = this.b.iterator();
        while (it.hasNext()) {
            it.next().d(false);
        }
    }

    public void o(int i2, Bitmap bitmap) {
        this.l = i2;
        p(bitmap);
    }

    public void p(Bitmap bitmap) {
        int i2;
        int i3 = this.l;
        if (i3 < 0 || i3 >= this.b.size() || bitmap == null || (i2 = this.l) >= this.b.size()) {
            return;
        }
        g gVar = this.b.get(i2);
        if (bitmap != null) {
            File file = new File(WearUtils.b0(), be3.I().getTime() + ".jpg");
            WearUtils.d2(bitmap, file.getPath());
            gVar.b(0L);
            if (i2 < this.c.size() && this.c.get(i2) != null) {
                this.c.remove(i2);
                Bitmap bitmapRemove = this.d.remove(file.getPath());
                if (bitmapRemove != null) {
                    bitmapRemove.recycle();
                }
            }
            Bitmap bitmapI2 = WearUtils.I2(bitmap);
            this.c.add(i2, file);
            this.d.put(file.getPath(), bitmapI2);
            this.a.runOnUiThread(new b(gVar, bitmapI2, i2));
        }
    }

    public void q(int i2, float f2) {
        ArrayList<g> arrayList = this.b;
        if (arrayList == null || i2 < 0 || i2 >= arrayList.size()) {
            return;
        }
        this.b.get(i2).c(f2);
    }

    public void r() {
        View viewInflate = LayoutInflater.from(this.a).inflate(R.layout.dialog_ring_progress_layout, (ViewGroup) null, false);
        RingProgressBar ringProgressBar = (RingProgressBar) viewInflate.findViewById(R.id.ringprogress);
        this.i = ringProgressBar;
        ringProgressBar.setProgress(0);
        kn3 kn3Var = this.h;
        if (kn3Var != null) {
            kn3Var.dismiss();
            this.h = null;
        }
        kn3 kn3Var2 = new kn3((Context) this.a, (String) null, ah4.e(R.string.common_cancel), false, false, 300, 220, (kn3.d) new f());
        this.h = kn3Var2;
        kn3Var2.show();
        this.h.h(viewInflate);
        this.h.m();
    }

    public void s(int i2, int i3) {
        ArrayList<g> arrayList = this.b;
        if (arrayList == null || i2 < 0 || i2 >= arrayList.size()) {
            return;
        }
        this.b.get(i2).f(i3);
    }

    public final void t(int i2) {
        this.l = i2;
        f(9097);
    }

    public void u(int i2) {
        ArrayList<g> arrayList = this.b;
        if (arrayList == null || i2 < 0 || i2 >= arrayList.size()) {
            return;
        }
        this.b.get(i2).e.setVisibility(0);
    }

    public final void v() {
        this.a.runOnUiThread(new e());
    }

    public void w(int i2, boolean z) {
        if (z) {
            Iterator<g> it = this.b.iterator();
            while (it.hasNext()) {
                if (it.next().a()) {
                    i2++;
                }
            }
            if (i2 >= this.c.size()) {
                this.f.b(this.m, WearUtils.G1(this.n, ","));
                return;
            }
        }
        if (this.c.get(i2) == null || !this.c.get(i2).exists()) {
            g();
            sg3.k(this.a, "上传的图片资源不存在!");
        } else {
            s(i2, 0);
            this.o = tn2.x(WearUtils.x).C(MyApplication.Z ? "/wear/feedback/offline/add" : "/wear/feedback/add", this.c.get(i2), new d(i2, z));
        }
    }

    public void x(int i2, boolean z) {
        w(i2, z);
    }

    public void y(String str, boolean z) {
        i iVar;
        this.m = str;
        this.n.clear();
        if (this.c.size() == 0 && (iVar = this.f) != null) {
            iVar.b(str, "");
        } else if (this.c.size() > 0) {
            if (!z) {
                r();
            }
            x(0, z);
        }
    }
}
