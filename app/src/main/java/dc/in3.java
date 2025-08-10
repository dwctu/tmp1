package dc;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import com.lovense.wear.R;
import com.wear.bean.User;
import com.wear.protocol.MessageType;
import com.wear.util.WearUtils;
import dc.kn3;
import java.util.Timer;
import java.util.TimerTask;

/* compiled from: CallingDialog.java */
/* loaded from: classes4.dex */
public class in3 extends Dialog {
    public Context a;
    public kn3.d b;
    public ImageView c;
    public TextView d;
    public TextView e;
    public TextView f;
    public View g;
    public ImageView h;
    public View i;
    public ImageView j;
    public ImageView k;
    public boolean l;
    public MessageType m;
    public String n;
    public String o;
    public Handler p;
    public int q;
    public Timer r;

    /* compiled from: CallingDialog.java */
    public class a extends Handler {
        public a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            in3.this.i();
        }
    }

    /* compiled from: CallingDialog.java */
    public class b extends TimerTask {
        public b() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            if (in3.this.q < 15) {
                in3.d(in3.this);
            }
            if (in3.this.q == 15) {
                Timer timer = in3.this.r;
                if (timer != null) {
                    timer.cancel();
                    in3.this.r = null;
                }
                in3.this.p.sendEmptyMessage(0);
            }
        }
    }

    /* compiled from: CallingDialog.java */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (in3.this.b != null) {
                in3.this.b.doCancel();
            }
            in3.this.dismiss();
        }
    }

    /* compiled from: CallingDialog.java */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            in3.this.q = 20;
            if (in3.this.b != null) {
                in3.this.b.doConfirm();
            }
            in3.this.dismiss();
        }
    }

    public in3(Context context, boolean z, String str, MessageType messageType, kn3.d dVar) {
        super(context, R.style.Fulldialog);
        this.l = true;
        this.q = 0;
        this.a = context;
        this.l = z;
        this.n = str;
        this.b = dVar;
        this.m = messageType;
    }

    public static /* synthetic */ int d(in3 in3Var) {
        int i = in3Var.q;
        in3Var.q = i + 1;
        return i;
    }

    public final void f() {
        Timer timer = this.r;
        if (timer != null) {
            timer.cancel();
            this.r = null;
        }
        Timer timer2 = new Timer();
        this.r = timer2;
        timer2.schedule(new b(), 0L, 1000L);
    }

    public void g() {
        User userV;
        View viewInflate = LayoutInflater.from(this.a).inflate(R.layout.activity_calling, (ViewGroup) null);
        setContentView(viewInflate);
        this.c = (ImageView) viewInflate.findViewById(R.id.iv_friend_avatar);
        this.d = (TextView) viewInflate.findViewById(R.id.tv_friend_name);
        this.e = (TextView) viewInflate.findViewById(R.id.tv_calling_notice);
        this.f = (TextView) viewInflate.findViewById(R.id.tv_come_in_notice);
        this.g = viewInflate.findViewById(R.id.layout_calling_cancel);
        this.h = (ImageView) viewInflate.findViewById(R.id.iv_cancel);
        this.i = viewInflate.findViewById(R.id.layout_receive);
        this.j = (ImageView) viewInflate.findViewById(R.id.iv_reject);
        this.k = (ImageView) viewInflate.findViewById(R.id.iv_accept);
        c cVar = new c();
        d dVar = new d();
        this.o = "";
        if (!WearUtils.e1(this.n) && (userV = WearUtils.y.v(this.n)) != null) {
            WearUtils.t2(this.c, userV);
            this.o = userV.getShowNickName();
        }
        this.d.setText(this.o);
        this.j.setOnClickListener(cVar);
        this.h.setOnClickListener(dVar);
        this.k.setOnClickListener(dVar);
        this.e.setVisibility(8);
        this.f.setVisibility(8);
        this.g.setVisibility(8);
        this.i.setVisibility(8);
        if (this.l) {
            this.e.setVisibility(0);
            this.e.setText(ah4.e(R.string.chat_waitAcceptance_notice));
            this.g.setVisibility(0);
        } else {
            this.i.setVisibility(0);
            this.f.setVisibility(0);
        }
        if (this.m == MessageType.video) {
            this.f.setText(ah4.e(R.string.dialog_receiveRequest_video));
        } else {
            this.f.setText(ah4.e(R.string.dialog_receiveRequest_notice));
        }
        setCanceledOnTouchOutside(false);
        setCancelable(false);
        h();
    }

    public Dialog h() {
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        this.a.getResources().getDisplayMetrics();
        attributes.width = gg3.e(this.a);
        attributes.height = gg3.c(this.a);
        window.setAttributes(attributes);
        return this;
    }

    public final void i() {
        this.e.setText(ah4.e(R.string.dialog_receiveRequest_notice_longtime));
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        g();
        this.p = new a();
        f();
    }
}
