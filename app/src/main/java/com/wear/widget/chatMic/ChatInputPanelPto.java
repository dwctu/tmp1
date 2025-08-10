package com.wear.widget.chatMic;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.wear.bean.event.InputResizeEvent;
import com.wear.dao.DaoUtils;
import com.wear.dao.TestValueDao;
import com.wear.util.WearUtils;
import dc.bh0;
import dc.dh0;
import dc.eh0;
import dc.fh0;
import dc.gh0;
import dc.yg0;
import org.greenrobot.eventbus.EventBus;

/* loaded from: classes4.dex */
public abstract class ChatInputPanelPto extends RelativeLayout implements yg0 {
    public static boolean l;
    public fh0 a;
    public fh0 b;
    public eh0 c;
    public dh0 d;
    public int e;
    public int f;
    public Handler g;
    public Runnable h;
    public long i;
    public int j;
    public c k;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            StringBuilder sb = new StringBuilder();
            sb.append("onSoftKeyboardOpenedResize resizeHeight:");
            sb.append(ChatInputPanelPto.this.e);
            sb.append(",getKeyboardHeight:");
            bh0.a aVar = bh0.h;
            sb.append(aVar.a());
            sb.toString();
            if (ChatInputPanelPto.this.e != aVar.a()) {
                EventBus.getDefault().post(new InputResizeEvent(1, ChatInputPanelPto.this.e));
            }
        }
    }

    public static /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[fh0.values().length];
            a = iArr;
            try {
                iArr[fh0.INPUT_MOTHOD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[fh0.EXPRESSION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[fh0.MORE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[fh0.NONE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[fh0.LAYER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[fh0.VOICE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public interface c {
        void a();

        void b();
    }

    public ChatInputPanelPto(Context context) {
        super(context);
        fh0 fh0Var = fh0.NONE;
        this.a = fh0Var;
        this.b = fh0Var;
        this.g = new Handler();
    }

    @Override // dc.yg0
    public void a() {
        if (this.b == fh0.INPUT_MOTHOD) {
            c cVar = this.k;
            if (cVar != null) {
                cVar.a();
            }
            if (System.currentTimeMillis() - this.i < 50) {
                return;
            }
            h(fh0.NONE, false, false);
        }
    }

    @Override // dc.yg0
    public void b(int i) {
        k(i);
    }

    @Override // dc.yg0
    public void c(int i) {
        String str = "onSoftKeyboardOpened keyBoardHeight:" + i;
        if (bh0.h.a() != i) {
            if (i > (gh0.a.b(WearUtils.x) / 3) * 2) {
                return;
            } else {
                k(i);
            }
        }
        c cVar = this.k;
        if (cVar != null) {
            cVar.b();
        }
    }

    public void e() {
        this.i = System.currentTimeMillis();
        h(fh0.INPUT_MOTHOD, false, false);
    }

    public void f() {
        fh0 fh0Var = this.b;
        fh0 fh0Var2 = fh0.EXPRESSION;
        if (fh0Var == fh0Var2 || fh0Var == fh0.VOICE) {
            h(fh0.INPUT_MOTHOD, false, false);
        } else {
            h(fh0Var2, false, false);
            this.d.b();
        }
    }

    public void g(boolean z) {
        if (!z) {
            h(fh0.NONE, false, false);
        } else {
            h(fh0.MORE, false, false);
            this.d.a();
        }
    }

    public fh0 getLastPanelType() {
        return this.b;
    }

    public int getLayerHeight() {
        return this.f;
    }

    public int getPanelHeight() {
        return bh0.h.a();
    }

    public int getPanelTypeHeight() {
        fh0 fh0Var = this.b;
        return fh0Var == fh0.INPUT_MOTHOD ? bh0.h.a() : fh0Var == fh0.LAYER ? this.f : bh0.h.b();
    }

    public void h(fh0 fh0Var, boolean z, boolean z2) {
        i(fh0Var, z, z2, -1);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00d7, code lost:
    
        if (r13 != 6) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0118, code lost:
    
        if (r13 != 6) goto L53;
     */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x019f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void i(dc.fh0 r10, boolean r11, boolean r12, int r13) {
        /*
            Method dump skipped, instructions count: 514
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wear.widget.chatMic.ChatInputPanelPto.i(dc.fh0, boolean, boolean, int):void");
    }

    public void j(int i) {
        fh0 fh0Var = this.b;
        fh0 fh0Var2 = fh0.INPUT_MOTHOD;
        if (fh0Var == fh0Var2) {
            i(fh0Var2, false, true, i);
        }
    }

    public final void k(int i) {
        if (this.g == null) {
            this.g = new Handler();
        }
        if (this.h == null) {
            this.h = new a();
        }
        this.g.removeCallbacks(this.h);
        this.e = i;
        this.g.postDelayed(this.h, 50L);
        String str = "onSoftKeyboardOpenedResize keyBoardHeight:" + i;
    }

    public final void l(int i) {
        bh0.a aVar = bh0.h;
        aVar.c(i);
        DaoUtils.getTestValueDao().save(TestValueDao.CHAT_KEYBOARD_HEIGHT_KEY, i + "", TestValueDao.CHAT_KEYBOARD_HEIGHT_TYPE);
        int iB = gh0.a.b(WearUtils.x);
        if (i < iB / 3) {
            i = (iB * 2) / 5;
        }
        aVar.d(i);
        EventBus.getDefault().post(new InputResizeEvent(2, i));
    }

    public void m(boolean z, int i) {
        if (!z) {
            h(fh0.NONE, false, false);
        } else {
            this.f = i;
            h(fh0.LAYER, true, false);
        }
    }

    public void n() {
        h(fh0.INPUT_MOTHOD, false, false);
    }

    public void o() {
        h(fh0.INPUT_MOTHOD, false, false);
    }

    @Override // dc.zg0
    public void reset() {
    }

    public void setLayerHeight(int i) {
        this.f = i;
    }

    @Override // dc.yg0
    public void setOnInputStateChangedListener(dh0 dh0Var) {
        this.d = dh0Var;
    }

    @Override // dc.yg0
    public void setOnLayoutAnimatorHandleListener(eh0 eh0Var) {
        this.c = eh0Var;
    }

    public void setiSoftListener(c cVar) {
        this.k = cVar;
    }

    public ChatInputPanelPto(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        fh0 fh0Var = fh0.NONE;
        this.a = fh0Var;
        this.b = fh0Var;
        this.g = new Handler();
    }

    public ChatInputPanelPto(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        fh0 fh0Var = fh0.NONE;
        this.a = fh0Var;
        this.b = fh0Var;
        this.g = new Handler();
    }
}
