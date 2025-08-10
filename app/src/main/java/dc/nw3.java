package dc;

import dc.lw3;
import dc.mw3;
import dc.pw3;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jivesoftware.smackx.bytestreams.ibb.packet.Close;
import org.jivesoftware.smackx.ping.packet.Ping;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Socket.java */
/* loaded from: classes4.dex */
public class nw3 extends pw3 {
    public static final Logger l = Logger.getLogger(nw3.class.getName());
    public static Map<String, Integer> m = new a();
    public String b;
    public volatile boolean c;
    public int d;
    public String e;
    public lw3 f;
    public String g;
    public Queue<mw3.b> i;
    public Map<Integer, jw3> h = new HashMap();
    public final Queue<List<Object>> j = new LinkedList();
    public final Queue<hx3<JSONArray>> k = new LinkedList();

    /* compiled from: Socket.java */
    public class a extends HashMap<String, Integer> {
        public a() {
            put("connect", 1);
            put("connect_error", 1);
            put("connect_timeout", 1);
            put("connecting", 1);
            put("disconnect", 1);
            put("error", 1);
            put("reconnect", 1);
            put("reconnect_attempt", 1);
            put("reconnect_failed", 1);
            put("reconnect_error", 1);
            put("reconnecting", 1);
            put(Ping.ELEMENT, 1);
            put("pong", 1);
        }
    }

    /* compiled from: Socket.java */
    public class b extends LinkedList<mw3.b> {
        public final /* synthetic */ lw3 val$io;

        /* compiled from: Socket.java */
        public class a implements pw3.a {
            public a() {
            }

            @Override // dc.pw3.a
            public void call(Object... objArr) {
                nw3.this.K();
            }
        }

        /* compiled from: Socket.java */
        /* renamed from: dc.nw3$b$b, reason: collision with other inner class name */
        public class C0204b implements pw3.a {
            public C0204b() {
            }

            @Override // dc.pw3.a
            public void call(Object... objArr) {
                nw3.this.L((hx3) objArr[0]);
            }
        }

        /* compiled from: Socket.java */
        public class c implements pw3.a {
            public c() {
            }

            @Override // dc.pw3.a
            public void call(Object... objArr) {
                nw3.this.G(objArr.length > 0 ? (String) objArr[0] : null);
            }
        }

        public b(lw3 lw3Var) {
            this.val$io = lw3Var;
            add(mw3.a(lw3Var, "open", new a()));
            add(mw3.a(lw3Var, "packet", new C0204b()));
            add(mw3.a(lw3Var, Close.ELEMENT, new c()));
        }
    }

    /* compiled from: Socket.java */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (nw3.this.c) {
                return;
            }
            nw3.this.O();
            nw3.this.f.X();
            if (lw3.p.OPEN == nw3.this.f.b) {
                nw3.this.K();
            }
            nw3.this.a("connecting", new Object[0]);
        }
    }

    /* compiled from: Socket.java */
    public class d implements Runnable {
        public final /* synthetic */ String a;
        public final /* synthetic */ Object[] b;

        public d(String str, Object[] objArr) {
            this.a = str;
            this.b = objArr;
        }

        @Override // java.lang.Runnable
        public void run() {
            jw3 jw3Var;
            if (nw3.m.containsKey(this.a)) {
                nw3.s(nw3.this, this.a, this.b);
                return;
            }
            Object[] objArr = this.b;
            int length = objArr.length - 1;
            if (objArr.length <= 0 || !(objArr[length] instanceof jw3)) {
                jw3Var = null;
            } else {
                objArr = new Object[length];
                for (int i = 0; i < length; i++) {
                    objArr[i] = this.b[i];
                }
                jw3Var = (jw3) this.b[length];
            }
            nw3.this.D(this.a, objArr, jw3Var);
        }
    }

    /* compiled from: Socket.java */
    public class e implements Runnable {
        public final /* synthetic */ String a;
        public final /* synthetic */ Object[] b;
        public final /* synthetic */ jw3 c;

        public e(String str, Object[] objArr, jw3 jw3Var) {
            this.a = str;
            this.b = objArr;
            this.c = jw3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(this.a);
            Object[] objArr = this.b;
            if (objArr != null) {
                for (Object obj : objArr) {
                    jSONArray.put(obj);
                }
            }
            hx3 hx3Var = new hx3(2, jSONArray);
            if (this.c != null) {
                nw3.l.fine(String.format("emitting packet with ack id %d", Integer.valueOf(nw3.this.d)));
                nw3.this.h.put(Integer.valueOf(nw3.this.d), this.c);
                hx3Var.b = nw3.u(nw3.this);
            }
            if (nw3.this.c) {
                nw3.this.N(hx3Var);
            } else {
                nw3.this.k.add(hx3Var);
            }
        }
    }

    /* compiled from: Socket.java */
    public class f implements jw3 {
        public final /* synthetic */ boolean[] a;
        public final /* synthetic */ int b;
        public final /* synthetic */ nw3 c;

        /* compiled from: Socket.java */
        public class a implements Runnable {
            public final /* synthetic */ Object[] a;

            public a(Object[] objArr) {
                this.a = objArr;
            }

            @Override // java.lang.Runnable
            public void run() {
                boolean[] zArr = f.this.a;
                if (zArr[0]) {
                    return;
                }
                zArr[0] = true;
                if (nw3.l.isLoggable(Level.FINE)) {
                    Logger logger = nw3.l;
                    Object[] objArr = this.a;
                    if (objArr.length == 0) {
                        objArr = null;
                    }
                    logger.fine(String.format("sending ack %s", objArr));
                }
                JSONArray jSONArray = new JSONArray();
                for (Object obj : this.a) {
                    jSONArray.put(obj);
                }
                hx3 hx3Var = new hx3(3, jSONArray);
                f fVar = f.this;
                hx3Var.b = fVar.b;
                fVar.c.N(hx3Var);
            }
        }

        public f(nw3 nw3Var, boolean[] zArr, int i, nw3 nw3Var2) {
            this.a = zArr;
            this.b = i;
            this.c = nw3Var2;
        }

        @Override // dc.jw3
        public void call(Object... objArr) {
            jx3.h(new a(objArr));
        }
    }

    /* compiled from: Socket.java */
    public class g implements Runnable {
        public g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (nw3.this.c) {
                if (nw3.l.isLoggable(Level.FINE)) {
                    nw3.l.fine(String.format("performing disconnect (%s)", nw3.this.e));
                }
                nw3.this.N(new hx3(1));
            }
            nw3.this.B();
            if (nw3.this.c) {
                nw3.this.G("io client disconnect");
            }
        }
    }

    public nw3(lw3 lw3Var, String str, lw3.o oVar) {
        this.f = lw3Var;
        this.e = str;
        if (oVar != null) {
            this.g = oVar.p;
        }
    }

    public static Object[] P(JSONArray jSONArray) throws JSONException {
        Object obj;
        int length = jSONArray.length();
        Object[] objArr = new Object[length];
        for (int i = 0; i < length; i++) {
            Object obj2 = null;
            try {
                obj = jSONArray.get(i);
            } catch (JSONException e2) {
                l.log(Level.WARNING, "An error occured while retrieving data from JSONArray", (Throwable) e2);
                obj = null;
            }
            if (!JSONObject.NULL.equals(obj)) {
                obj2 = obj;
            }
            objArr[i] = obj2;
        }
        return objArr;
    }

    public static /* synthetic */ pw3 s(nw3 nw3Var, String str, Object[] objArr) {
        super.a(str, objArr);
        return nw3Var;
    }

    public static /* synthetic */ int u(nw3 nw3Var) {
        int i = nw3Var.d;
        nw3Var.d = i + 1;
        return i;
    }

    public boolean A() {
        return this.c;
    }

    public final void B() {
        Queue<mw3.b> queue = this.i;
        if (queue != null) {
            Iterator<mw3.b> it = queue.iterator();
            while (it.hasNext()) {
                it.next().destroy();
            }
            this.i = null;
        }
        this.f.K(this);
    }

    public nw3 C() {
        y();
        return this;
    }

    public pw3 D(String str, Object[] objArr, jw3 jw3Var) {
        jx3.h(new e(str, objArr, jw3Var));
        return this;
    }

    public final void E() {
        while (true) {
            List<Object> listPoll = this.j.poll();
            if (listPoll == null) {
                break;
            } else {
                super.a((String) listPoll.get(0), listPoll.toArray());
            }
        }
        this.j.clear();
        while (true) {
            hx3<JSONArray> hx3VarPoll = this.k.poll();
            if (hx3VarPoll == null) {
                this.k.clear();
                return;
            }
            N(hx3VarPoll);
        }
    }

    public final void F(hx3<JSONArray> hx3Var) {
        jw3 jw3VarRemove = this.h.remove(Integer.valueOf(hx3Var.b));
        if (jw3VarRemove != null) {
            Logger logger = l;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(String.format("calling ack %s with %s", Integer.valueOf(hx3Var.b), hx3Var.d));
            }
            jw3VarRemove.call(P(hx3Var.d));
            return;
        }
        Logger logger2 = l;
        if (logger2.isLoggable(Level.FINE)) {
            logger2.fine(String.format("bad ack %s", Integer.valueOf(hx3Var.b)));
        }
    }

    public final void G(String str) {
        Logger logger = l;
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(String.format("close (%s)", str));
        }
        this.c = false;
        a("disconnect", str);
    }

    public final void H() {
        this.c = true;
        a("connect", new Object[0]);
        E();
    }

    public final void I() {
        Logger logger = l;
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(String.format("server disconnect (%s)", this.e));
        }
        B();
        G("io server disconnect");
    }

    public final void J(hx3<JSONArray> hx3Var) {
        ArrayList arrayList = new ArrayList(Arrays.asList(P(hx3Var.d)));
        Logger logger = l;
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(String.format("emitting event %s", arrayList));
        }
        if (hx3Var.b >= 0) {
            logger.fine("attaching ack callback to event");
            arrayList.add(x(hx3Var.b));
        }
        if (!this.c) {
            this.j.add(arrayList);
        } else {
            if (arrayList.isEmpty()) {
                return;
            }
            super.a(arrayList.remove(0).toString(), arrayList.toArray());
        }
    }

    public final void K() {
        l.fine("transport is open - connecting");
        if ("/".equals(this.e)) {
            return;
        }
        String str = this.g;
        if (str == null || str.isEmpty()) {
            N(new hx3(0));
            return;
        }
        hx3 hx3Var = new hx3(0);
        hx3Var.f = this.g;
        N(hx3Var);
    }

    public final void L(hx3<?> hx3Var) {
        if (this.e.equals(hx3Var.c)) {
            ej4.a("onpacket===>" + hx3Var.a);
            switch (hx3Var.a) {
                case 0:
                    H();
                    break;
                case 1:
                    I();
                    break;
                case 2:
                    J(hx3Var);
                    break;
                case 3:
                    F(hx3Var);
                    break;
                case 4:
                    a("error", hx3Var.d);
                    break;
                case 5:
                    J(hx3Var);
                    break;
                case 6:
                    F(hx3Var);
                    break;
            }
        }
    }

    public nw3 M() {
        jx3.h(new c());
        return this;
    }

    public final void N(hx3 hx3Var) {
        hx3Var.c = this.e;
        this.f.Z(hx3Var);
    }

    public final void O() {
        if (this.i != null) {
            return;
        }
        this.i = new b(this.f);
    }

    @Override // dc.pw3
    public pw3 a(String str, Object... objArr) {
        jx3.h(new d(str, objArr));
        return this;
    }

    public final jw3 x(int i) {
        return new f(this, new boolean[]{false}, i, this);
    }

    public nw3 y() {
        jx3.h(new g());
        return this;
    }

    public nw3 z() {
        M();
        return this;
    }
}
