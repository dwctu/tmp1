package retrofit2;

import dc.ac4;
import dc.ad4;
import dc.bc4;
import dc.bd4;
import dc.ge4;
import dc.nd4;
import dc.pd4;
import dc.sd4;
import dc.tc4;
import dc.wd4;
import dc.yc4;
import java.io.IOException;
import java.util.Objects;

/* loaded from: classes5.dex */
public final class OkHttpCall<T> implements Call<T> {
    private final Object[] args;
    private final ac4.a callFactory;
    private volatile boolean canceled;
    private Throwable creationFailure;
    private boolean executed;
    private ac4 rawCall;
    private final RequestFactory requestFactory;
    private final Converter<bd4, T> responseConverter;

    public static final class ExceptionCatchingResponseBody extends bd4 {
        private final bd4 delegate;
        private final pd4 delegateSource;
        public IOException thrownException;

        public ExceptionCatchingResponseBody(bd4 bd4Var) {
            this.delegate = bd4Var;
            this.delegateSource = wd4.d(new sd4(bd4Var.source()) { // from class: retrofit2.OkHttpCall.ExceptionCatchingResponseBody.1
                @Override // dc.sd4, dc.fe4
                public long read(nd4 nd4Var, long j) throws IOException {
                    try {
                        return super.read(nd4Var, j);
                    } catch (IOException e) {
                        ExceptionCatchingResponseBody.this.thrownException = e;
                        throw e;
                    }
                }
            });
        }

        @Override // dc.bd4, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.delegate.close();
        }

        @Override // dc.bd4
        public long contentLength() {
            return this.delegate.contentLength();
        }

        @Override // dc.bd4
        public tc4 contentType() {
            return this.delegate.contentType();
        }

        @Override // dc.bd4
        public pd4 source() {
            return this.delegateSource;
        }

        public void throwIfCaught() throws IOException {
            IOException iOException = this.thrownException;
            if (iOException != null) {
                throw iOException;
            }
        }
    }

    public static final class NoContentResponseBody extends bd4 {
        private final long contentLength;
        private final tc4 contentType;

        public NoContentResponseBody(tc4 tc4Var, long j) {
            this.contentType = tc4Var;
            this.contentLength = j;
        }

        @Override // dc.bd4
        public long contentLength() {
            return this.contentLength;
        }

        @Override // dc.bd4
        public tc4 contentType() {
            return this.contentType;
        }

        @Override // dc.bd4
        public pd4 source() {
            throw new IllegalStateException("Cannot read raw response body of a converted body.");
        }
    }

    public OkHttpCall(RequestFactory requestFactory, Object[] objArr, ac4.a aVar, Converter<bd4, T> converter) {
        this.requestFactory = requestFactory;
        this.args = objArr;
        this.callFactory = aVar;
        this.responseConverter = converter;
    }

    private ac4 createRawCall() throws IOException {
        ac4 ac4VarA = this.callFactory.a(this.requestFactory.create(this.args));
        Objects.requireNonNull(ac4VarA, "Call.Factory returned null.");
        return ac4VarA;
    }

    private ac4 getRawCall() throws IOException {
        ac4 ac4Var = this.rawCall;
        if (ac4Var != null) {
            return ac4Var;
        }
        Throwable th = this.creationFailure;
        if (th != null) {
            if (th instanceof IOException) {
                throw ((IOException) th);
            }
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            throw ((Error) th);
        }
        try {
            ac4 ac4VarCreateRawCall = createRawCall();
            this.rawCall = ac4VarCreateRawCall;
            return ac4VarCreateRawCall;
        } catch (IOException | Error | RuntimeException e) {
            Utils.throwIfFatal(e);
            this.creationFailure = e;
            throw e;
        }
    }

    @Override // retrofit2.Call
    public void cancel() {
        ac4 ac4Var;
        this.canceled = true;
        synchronized (this) {
            ac4Var = this.rawCall;
        }
        if (ac4Var != null) {
            ac4Var.cancel();
        }
    }

    @Override // retrofit2.Call
    public void enqueue(final Callback<T> callback) {
        ac4 ac4Var;
        Throwable th;
        Objects.requireNonNull(callback, "callback == null");
        synchronized (this) {
            if (this.executed) {
                throw new IllegalStateException("Already executed.");
            }
            this.executed = true;
            ac4Var = this.rawCall;
            th = this.creationFailure;
            if (ac4Var == null && th == null) {
                try {
                    ac4 ac4VarCreateRawCall = createRawCall();
                    this.rawCall = ac4VarCreateRawCall;
                    ac4Var = ac4VarCreateRawCall;
                } catch (Throwable th2) {
                    th = th2;
                    Utils.throwIfFatal(th);
                    this.creationFailure = th;
                }
            }
        }
        if (th != null) {
            callback.onFailure(this, th);
            return;
        }
        if (this.canceled) {
            ac4Var.cancel();
        }
        ac4Var.j(new bc4() { // from class: retrofit2.OkHttpCall.1
            private void callFailure(Throwable th3) {
                try {
                    callback.onFailure(OkHttpCall.this, th3);
                } catch (Throwable th4) {
                    Utils.throwIfFatal(th4);
                    th4.printStackTrace();
                }
            }

            @Override // dc.bc4
            public void onFailure(ac4 ac4Var2, IOException iOException) {
                callFailure(iOException);
            }

            @Override // dc.bc4
            public void onResponse(ac4 ac4Var2, ad4 ad4Var) {
                try {
                    try {
                        callback.onResponse(OkHttpCall.this, OkHttpCall.this.parseResponse(ad4Var));
                    } catch (Throwable th3) {
                        Utils.throwIfFatal(th3);
                        th3.printStackTrace();
                    }
                } catch (Throwable th4) {
                    Utils.throwIfFatal(th4);
                    callFailure(th4);
                }
            }
        });
    }

    @Override // retrofit2.Call
    public Response<T> execute() throws IOException {
        ac4 rawCall;
        synchronized (this) {
            if (this.executed) {
                throw new IllegalStateException("Already executed.");
            }
            this.executed = true;
            rawCall = getRawCall();
        }
        if (this.canceled) {
            rawCall.cancel();
        }
        return parseResponse(rawCall.execute());
    }

    @Override // retrofit2.Call
    public boolean isCanceled() {
        boolean z = true;
        if (this.canceled) {
            return true;
        }
        synchronized (this) {
            ac4 ac4Var = this.rawCall;
            if (ac4Var == null || !ac4Var.isCanceled()) {
                z = false;
            }
        }
        return z;
    }

    @Override // retrofit2.Call
    public synchronized boolean isExecuted() {
        return this.executed;
    }

    public Response<T> parseResponse(ad4 ad4Var) throws IOException {
        bd4 bd4VarB = ad4Var.b();
        ad4.a aVarA = ad4Var.A();
        aVarA.b(new NoContentResponseBody(bd4VarB.contentType(), bd4VarB.contentLength()));
        ad4 ad4VarC = aVarA.c();
        int iF = ad4VarC.f();
        if (iF < 200 || iF >= 300) {
            try {
                return Response.error(Utils.buffer(bd4VarB), ad4VarC);
            } finally {
                bd4VarB.close();
            }
        }
        if (iF == 204 || iF == 205) {
            bd4VarB.close();
            return Response.success((Object) null, ad4VarC);
        }
        ExceptionCatchingResponseBody exceptionCatchingResponseBody = new ExceptionCatchingResponseBody(bd4VarB);
        try {
            return Response.success(this.responseConverter.convert(exceptionCatchingResponseBody), ad4VarC);
        } catch (RuntimeException e) {
            exceptionCatchingResponseBody.throwIfCaught();
            throw e;
        }
    }

    @Override // retrofit2.Call
    public synchronized yc4 request() {
        try {
        } catch (IOException e) {
            throw new RuntimeException("Unable to create request.", e);
        }
        return getRawCall().request();
    }

    @Override // retrofit2.Call
    public synchronized ge4 timeout() {
        try {
        } catch (IOException e) {
            throw new RuntimeException("Unable to create call.", e);
        }
        return getRawCall().timeout();
    }

    @Override // retrofit2.Call
    public OkHttpCall<T> clone() {
        return new OkHttpCall<>(this.requestFactory, this.args, this.callFactory, this.responseConverter);
    }
}
