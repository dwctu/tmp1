package dc;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.wear.util.photoselector.PhotoSelectorActivity;
import java.util.List;

/* compiled from: PhotoSelectorDomain.java */
@SuppressLint({"HandlerLeak"})
/* loaded from: classes4.dex */
public class tj3 {
    public mj3 a;

    /* compiled from: PhotoSelectorDomain.java */
    public class a extends Handler {
        public final /* synthetic */ PhotoSelectorActivity.d a;

        public a(tj3 tj3Var, PhotoSelectorActivity.d dVar) {
            this.a = dVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            this.a.a((List) message.obj);
        }
    }

    /* compiled from: PhotoSelectorDomain.java */
    public class b implements Runnable {
        public final /* synthetic */ Handler a;

        public b(Handler handler) {
            this.a = handler;
        }

        @Override // java.lang.Runnable
        public void run() {
            List<rj3> listC = tj3.this.a.c();
            Message message = new Message();
            message.obj = listC;
            this.a.sendMessage(message);
        }
    }

    /* compiled from: PhotoSelectorDomain.java */
    public class c extends Handler {
        public final /* synthetic */ PhotoSelectorActivity.c a;

        public c(tj3 tj3Var, PhotoSelectorActivity.c cVar) {
            this.a = cVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            this.a.a((List) message.obj);
        }
    }

    /* compiled from: PhotoSelectorDomain.java */
    public class d implements Runnable {
        public final /* synthetic */ Handler a;

        public d(Handler handler) {
            this.a = handler;
        }

        @Override // java.lang.Runnable
        public void run() {
            List<nj3> listB = tj3.this.a.b();
            Message message = new Message();
            message.obj = listB;
            this.a.sendMessage(message);
        }
    }

    /* compiled from: PhotoSelectorDomain.java */
    public class e extends Handler {
        public final /* synthetic */ PhotoSelectorActivity.d a;

        public e(tj3 tj3Var, PhotoSelectorActivity.d dVar) {
            this.a = dVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            this.a.a((List) message.obj);
        }
    }

    /* compiled from: PhotoSelectorDomain.java */
    public class f implements Runnable {
        public final /* synthetic */ String a;
        public final /* synthetic */ Handler b;

        public f(String str, Handler handler) {
            this.a = str;
            this.b = handler;
        }

        @Override // java.lang.Runnable
        public void run() {
            List<rj3> listA = tj3.this.a.a(this.a);
            Message message = new Message();
            message.obj = listA;
            this.b.sendMessage(message);
        }
    }

    public tj3(Context context) {
        this.a = new mj3(context);
    }

    public void b(String str, PhotoSelectorActivity.d dVar) {
        vg3.b().a(new f(str, new e(this, dVar)));
    }

    public void c(PhotoSelectorActivity.d dVar) {
        vg3.b().a(new b(new a(this, dVar)));
    }

    public void d(PhotoSelectorActivity.c cVar) {
        vg3.b().a(new d(new c(this, cVar)));
    }
}
