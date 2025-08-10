package dc;

import com.wear.bean.event.ReadProfileRedDotEvent;
import com.wear.network.presenter.bean.BaseResponseBean;
import com.wear.network.presenter.bean.LoginUserBean;
import com.wear.network.protocol.exception.NetException;
import com.wear.util.WearUtils;
import java.util.HashMap;
import org.greenrobot.eventbus.EventBus;

/* compiled from: ProfilePresenterImpl.java */
/* loaded from: classes3.dex */
public class ql2 extends tl2<kp2, Object> implements wn2<Object> {
    public pl2 c;

    /* compiled from: ProfilePresenterImpl.java */
    public class a implements wn2<BaseResponseBean> {
        public a() {
        }

        @Override // dc.wn2
        public void b(String str, boolean z) {
            if (ql2.this.g()) {
                ((kp2) ql2.this.b.get()).showErrorMsg(str, false);
                ((kp2) ql2.this.b.get()).k2(false);
            }
        }

        @Override // dc.wn2
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(boolean z, BaseResponseBean baseResponseBean) {
            if (ql2.this.g()) {
                ((kp2) ql2.this.b.get()).k2(true);
            }
        }

        @Override // dc.wn2
        public void d(NetException netException, boolean z) {
            if (ql2.this.g()) {
                ((kp2) ql2.this.b.get()).showErrorMsg(netException.getMessage(), false);
                ((kp2) ql2.this.b.get()).k2(false);
            }
        }
    }

    /* compiled from: ProfilePresenterImpl.java */
    public class b implements wn2<LoginUserBean.Birth> {
        public b() {
        }

        @Override // dc.wn2
        public void b(String str, boolean z) {
            if (ql2.this.g()) {
                ((kp2) ql2.this.b.get()).showErrorMsg(str, false);
            }
        }

        @Override // dc.wn2
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(boolean z, LoginUserBean.Birth birth) {
            WearUtils.y.o().setBirth(birth);
            if (ql2.this.g()) {
                ((kp2) ql2.this.b.get()).d1();
            }
        }

        @Override // dc.wn2
        public void d(NetException netException, boolean z) {
        }
    }

    /* compiled from: ProfilePresenterImpl.java */
    public class c implements wn2<BaseResponseBean> {
        public final /* synthetic */ int a;
        public final /* synthetic */ int b;

        public c(int i, int i2) {
            this.a = i;
            this.b = i2;
        }

        @Override // dc.wn2
        public void b(String str, boolean z) {
            if (ql2.this.g()) {
                ((kp2) ql2.this.b.get()).showErrorMsg(str, false);
            }
        }

        @Override // dc.wn2
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(boolean z, BaseResponseBean baseResponseBean) {
            if (ql2.this.g()) {
                WearUtils.y.o().getBirth().setBirthdayDay(this.a);
                WearUtils.y.o().getBirth().setBirthdayMonth(this.b);
                ((kp2) ql2.this.b.get()).d1();
            }
        }

        @Override // dc.wn2
        public void d(NetException netException, boolean z) {
            if (netException.code.equals("50088")) {
                ql2.this.w();
            } else {
                if (ql2.this.b.get() == null) {
                    return;
                }
                ((kp2) ql2.this.b.get()).showErrorMsg(netException.getMessage(), false);
            }
        }
    }

    /* compiled from: ProfilePresenterImpl.java */
    public class d implements wn2<Object> {
        public d(ql2 ql2Var) {
        }

        @Override // dc.wn2
        public void a(boolean z, Object obj) {
            WearUtils.y.o().getBirth().setShowBirthdayTip(false);
            EventBus.getDefault().post(new ReadProfileRedDotEvent());
        }

        @Override // dc.wn2
        public void b(String str, boolean z) {
        }

        @Override // dc.wn2
        public void d(NetException netException, boolean z) {
        }
    }

    public ql2(pl2 pl2Var) {
        this.c = pl2Var;
    }

    @Override // dc.tl2, dc.wn2
    public void a(boolean z, Object obj) {
    }

    @Override // dc.tl2, dc.wn2
    public void b(String str, boolean z) {
    }

    @Override // dc.tl2, dc.wn2
    public void d(NetException netException, boolean z) {
    }

    public void t() {
        this.a = this.c.a(new d(this));
    }

    public void u(int i, int i2) {
        HashMap map = new HashMap();
        map.put("birthdayMonth", Integer.valueOf(i));
        map.put("birthdayDay", Integer.valueOf(i2));
        this.a = this.c.b(map, new c(i2, i));
    }

    public void v(int i) {
        HashMap map = new HashMap();
        map.put("subscribeStatus", Integer.valueOf(i));
        this.a = this.c.c(map, new a());
    }

    public final void w() {
        this.a = this.c.d(new b());
    }
}
