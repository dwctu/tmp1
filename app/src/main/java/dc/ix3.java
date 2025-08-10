package dc;

/* compiled from: Parser.java */
/* loaded from: classes4.dex */
public interface ix3 {
    public static final String[] a = {"CONNECT", "DISCONNECT", "EVENT", "ACK", "ERROR", "BINARY_EVENT", "BINARY_ACK"};

    /* compiled from: Parser.java */
    public interface a {

        /* compiled from: Parser.java */
        /* renamed from: dc.ix3$a$a, reason: collision with other inner class name */
        public interface InterfaceC0188a {
            void a(hx3 hx3Var);
        }

        void a(InterfaceC0188a interfaceC0188a);

        void add(String str);

        void add(byte[] bArr);

        void destroy();
    }

    /* compiled from: Parser.java */
    public interface b {

        /* compiled from: Parser.java */
        public interface a {
            void call(Object[] objArr);
        }

        void a(hx3 hx3Var, a aVar);
    }
}
