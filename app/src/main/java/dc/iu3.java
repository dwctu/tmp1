package dc;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.google.android.exoplayer2.ExoPlayer;
import com.lovense.wear.R;
import com.wear.bean.event.LoginStatusActionEvent;
import com.wear.bean.event.XmppReconctionSuccessEvent;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import java.text.ParseException;
import org.greenrobot.eventbus.EventBus;
import org.jivesoftware.smack.ConnectionListener;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.packet.DefaultExtensionElement;

/* compiled from: SmackConnectionListener.java */
/* loaded from: classes4.dex */
public class iu3 implements ConnectionListener {
    public hu3 a;
    public Handler c = new Handler(Looper.getMainLooper());
    public Handler d = new Handler(Looper.getMainLooper());
    public boolean e = true;
    public MyApplication b = WearUtils.x;

    /* compiled from: SmackConnectionListener.java */
    public class a implements Runnable {

        /* compiled from: SmackConnectionListener.java */
        /* renamed from: dc.iu3$a$a, reason: collision with other inner class name */
        public class RunnableC0187a implements Runnable {
            public RunnableC0187a(a aVar) {
            }

            @Override // java.lang.Runnable
            public void run() {
                hu3.B();
            }
        }

        public a(iu3 iu3Var) {
        }

        @Override // java.lang.Runnable
        public void run() {
            vg3.b().a(new RunnableC0187a(this));
        }
    }

    /* compiled from: SmackConnectionListener.java */
    public class b implements Runnable {
        public final /* synthetic */ Exception a;

        public b(Exception exc) {
            this.a = exc;
        }

        @Override // java.lang.Runnable
        public void run() {
            DefaultExtensionElement defaultExtensionElement = (DefaultExtensionElement) ((XMPPException.StreamErrorException) this.a).getStreamError().getExtension("bodyconflict", "jabber:client");
            if (defaultExtensionElement == null || !TextUtils.equals(nd3.d(defaultExtensionElement.getValue("bodyconflict")), nd3.i(eg3.h(WearUtils.x, "gen_token_Key", "")))) {
                ye3.d("A0001", "");
                ye3.I("xmppConflict", this.a.getMessage());
                sg3.i(iu3.this.b, R.string.system_account_single);
                ep1.b().h(1);
            }
        }
    }

    /* compiled from: SmackConnectionListener.java */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            iu3.this.e = true;
        }
    }

    public iu3(hu3 hu3Var) {
        this.a = hu3Var;
    }

    @Override // org.jivesoftware.smack.ConnectionListener
    public void authenticated(XMPPConnection xMPPConnection, boolean z) throws ParseException {
        ep1.b().e("--->authenticated:" + z);
        zt3.o();
        MyApplication.P = true;
        EventBus.getDefault().post(new LoginStatusActionEvent());
        fp1.c();
        if (MyApplication.Q == 3) {
            this.a.Q("");
            this.a.p(true);
        }
        this.c.removeCallbacksAndMessages(null);
        this.c.postDelayed(new a(this), ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
    }

    public final void b(Exception exc) {
        try {
            ye3.d("A0014", je3.a(exc));
            this.d.postDelayed(new c(), 60000L);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // org.jivesoftware.smack.ConnectionListener
    public void connected(XMPPConnection xMPPConnection) {
        ep1.b().e("--->connected:");
    }

    @Override // org.jivesoftware.smack.ConnectionListener
    public void connectionClosed() {
        ep1.b().e("--->connectionClosed:");
        MyApplication.P = false;
        EventBus.getDefault().post(new LoginStatusActionEvent());
    }

    @Override // org.jivesoftware.smack.ConnectionListener
    public void connectionClosedOnError(Exception exc) throws InterruptedException {
        ep1.b().e("--->connectionClosedOnError:" + exc.getMessage());
        MyApplication.P = false;
        EventBus.getDefault().post(new LoginStatusActionEvent());
        try {
            Thread.sleep(1000L);
            if (!hf3.d(this.b)) {
                hf3.f(MyApplication.H());
            } else if (!WearUtils.e1(exc.getMessage()) && exc.getMessage().toLowerCase().contains("conflict")) {
                WearUtils.x.l.postDelayed(new b(exc), 300L);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (this.e) {
            this.e = false;
            b(exc);
        }
    }

    @Override // org.jivesoftware.smack.ConnectionListener
    public void reconnectingIn(int i) {
    }

    @Override // org.jivesoftware.smack.ConnectionListener
    public void reconnectionFailed(Exception exc) {
        ep1.b().e("--->reconnectionFailed:");
    }

    @Override // org.jivesoftware.smack.ConnectionListener
    public void reconnectionSuccessful() {
        ep1.b().e("--->reconnectionSuccessful:");
        EventBus.getDefault().post(new XmppReconctionSuccessEvent());
        hu3.T();
    }
}
