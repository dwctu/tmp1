package com.alibaba.android.arouter.core;

import android.content.Context;
import com.alibaba.android.arouter.exception.HandlerException;
import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.facade.callback.InterceptorCallback;
import com.alibaba.android.arouter.facade.service.InterceptorService;
import com.alibaba.android.arouter.facade.template.IInterceptor;
import com.alibaba.android.arouter.facade.template.ILogger;
import dc.nd;
import dc.od;
import dc.pd;
import dc.rd;
import dc.wd;
import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Route(path = "/arouter/service/interceptor")
/* loaded from: classes.dex */
public class InterceptorServiceImpl implements InterceptorService {
    public static boolean a;
    public static final Object b = new Object();

    public class a implements Runnable {
        public final /* synthetic */ Postcard a;
        public final /* synthetic */ InterceptorCallback b;

        public a(InterceptorServiceImpl interceptorServiceImpl, Postcard postcard, InterceptorCallback interceptorCallback) {
            this.a = postcard;
            this.b = interceptorCallback;
        }

        @Override // java.lang.Runnable
        public void run() throws InterruptedException {
            rd rdVar = new rd(od.f.size());
            try {
                InterceptorServiceImpl.c(0, rdVar, this.a);
                rdVar.await(this.a.getTimeout(), TimeUnit.SECONDS);
                if (rdVar.getCount() > 0) {
                    this.b.onInterrupt(new HandlerException("The interceptor processing timed out."));
                } else if (this.a.getTag() != null) {
                    this.b.onInterrupt((Throwable) this.a.getTag());
                } else {
                    this.b.onContinue(this.a);
                }
            } catch (Exception e) {
                this.b.onInterrupt(e);
            }
        }
    }

    public static class b implements InterceptorCallback {
        public final /* synthetic */ rd a;
        public final /* synthetic */ int b;
        public final /* synthetic */ Postcard c;

        public b(rd rdVar, int i, Postcard postcard) {
            this.a = rdVar;
            this.b = i;
            this.c = postcard;
        }

        @Override // com.alibaba.android.arouter.facade.callback.InterceptorCallback
        public void onContinue(Postcard postcard) {
            this.a.countDown();
            InterceptorServiceImpl.c(this.b + 1, this.a, postcard);
        }

        @Override // com.alibaba.android.arouter.facade.callback.InterceptorCallback
        public void onInterrupt(Throwable th) {
            Postcard postcard = this.c;
            if (th == null) {
                th = new HandlerException("No message.");
            }
            postcard.setTag(th);
            this.a.a();
        }
    }

    public class c implements Runnable {
        public final /* synthetic */ Context a;

        public c(InterceptorServiceImpl interceptorServiceImpl, Context context) {
            this.a = context;
        }

        @Override // java.lang.Runnable
        public void run() throws IllegalAccessException, InstantiationException, IllegalArgumentException, InvocationTargetException {
            if (wd.b(od.e)) {
                Iterator<Map.Entry<Integer, Class<? extends IInterceptor>>> it = od.e.entrySet().iterator();
                while (it.hasNext()) {
                    Class<? extends IInterceptor> value = it.next().getValue();
                    try {
                        IInterceptor iInterceptorNewInstance = value.getConstructor(new Class[0]).newInstance(new Object[0]);
                        iInterceptorNewInstance.init(this.a);
                        od.f.add(iInterceptorNewInstance);
                    } catch (Exception e) {
                        throw new HandlerException("ARouter::ARouter init interceptor error! name = [" + value.getName() + "], reason = [" + e.getMessage() + "]");
                    }
                }
                boolean unused = InterceptorServiceImpl.a = true;
                pd.c.info(ILogger.defaultTag, "ARouter interceptors init over.");
                synchronized (InterceptorServiceImpl.b) {
                    InterceptorServiceImpl.b.notifyAll();
                }
            }
        }
    }

    public static void c(int i, rd rdVar, Postcard postcard) {
        if (i < od.f.size()) {
            od.f.get(i).process(postcard, new b(rdVar, i, postcard));
        }
    }

    public static void g() {
        synchronized (b) {
            while (!a) {
                try {
                    b.wait(10000L);
                } catch (InterruptedException e) {
                    throw new HandlerException("ARouter::Interceptor init cost too much time error! reason = [" + e.getMessage() + "]");
                }
            }
        }
    }

    @Override // com.alibaba.android.arouter.facade.service.InterceptorService
    public void doInterceptions(Postcard postcard, InterceptorCallback interceptorCallback) {
        if (!wd.b(od.e)) {
            interceptorCallback.onContinue(postcard);
            return;
        }
        g();
        if (a) {
            nd.b.execute(new a(this, postcard, interceptorCallback));
        } else {
            interceptorCallback.onInterrupt(new HandlerException("Interceptors initialization takes too much time."));
        }
    }

    @Override // com.alibaba.android.arouter.facade.template.IProvider
    public void init(Context context) {
        nd.b.execute(new c(this, context));
    }
}
