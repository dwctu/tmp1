package com.koushikdutta.async;

import android.os.Build;
import android.os.Handler;
import android.os.SystemClock;
import com.koushikdutta.async.AsyncServer;
import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.callback.ConnectCallback;
import com.koushikdutta.async.callback.ListenCallback;
import com.koushikdutta.async.callback.SocketCreateCallback;
import com.koushikdutta.async.callback.ValueFunction;
import com.koushikdutta.async.future.Cancellable;
import com.koushikdutta.async.future.Future;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.async.future.SimpleCancellable;
import com.koushikdutta.async.future.SimpleFuture;
import com.koushikdutta.async.future.ThenCallback;
import com.koushikdutta.async.util.StreamUtility;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.UnknownHostException;
import java.nio.channels.CancelledKeyException;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.ClosedSelectorException;
import java.nio.channels.DatagramChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.channels.spi.SelectorProvider;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes3.dex */
public class AsyncServer {
    public static final String LOGTAG = "NIO";
    private static final long QUEUE_EMPTY = Long.MAX_VALUE;
    private static final Comparator<InetAddress> ipSorter;
    public static AsyncServer mInstance;
    private static ExecutorService synchronousResolverWorkers;
    private static ExecutorService synchronousWorkers;
    private static final ThreadLocal<AsyncServer> threadServer;
    public boolean killed;
    public Thread mAffinity;
    public String mName;
    public PriorityQueue<Scheduled> mQueue;
    private SelectorWrapper mSelector;
    public int postCounter;

    public static class AsyncSelectorException extends IOException {
        public AsyncSelectorException(Exception exc) {
            super(exc);
        }
    }

    public class ConnectFuture extends SimpleFuture<AsyncNetworkSocket> {
        public ConnectCallback callback;
        public SocketChannel socket;

        private ConnectFuture() {
        }

        @Override // com.koushikdutta.async.future.SimpleCancellable
        public void cancelCleanup() {
            super.cancelCleanup();
            try {
                SocketChannel socketChannel = this.socket;
                if (socketChannel != null) {
                    socketChannel.close();
                }
            } catch (IOException unused) {
            }
        }
    }

    public static class NamedThreadFactory implements ThreadFactory {
        private final ThreadGroup group;
        private final String namePrefix;
        private final AtomicInteger threadNumber = new AtomicInteger(1);

        public NamedThreadFactory(String str) {
            SecurityManager securityManager = System.getSecurityManager();
            this.group = securityManager != null ? securityManager.getThreadGroup() : Thread.currentThread().getThreadGroup();
            this.namePrefix = str;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(this.group, runnable, this.namePrefix + this.threadNumber.getAndIncrement(), 0L);
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            if (thread.getPriority() != 5) {
                thread.setPriority(5);
            }
            return thread;
        }
    }

    public static class ObjectHolder<T> {
        public T held;

        private ObjectHolder() {
        }
    }

    public static class RunnableWrapper implements Runnable {
        public Handler handler;
        public boolean hasRun;
        public Runnable runnable;
        public ThreadQueue threadQueue;

        private RunnableWrapper() {
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (this) {
                if (this.hasRun) {
                    return;
                }
                this.hasRun = true;
                try {
                    this.runnable.run();
                } finally {
                    this.threadQueue.remove(this);
                    this.handler.removeCallbacks(this);
                    this.threadQueue = null;
                    this.handler = null;
                    this.runnable = null;
                }
            }
        }
    }

    public static class Scheduled implements Cancellable, Runnable {
        public boolean cancelled;
        public Runnable runnable;
        public AsyncServer server;
        public long time;

        public Scheduled(AsyncServer asyncServer, Runnable runnable, long j) {
            this.server = asyncServer;
            this.runnable = runnable;
            this.time = j;
        }

        @Override // com.koushikdutta.async.future.Cancellable
        public boolean cancel() {
            boolean zRemove;
            synchronized (this.server) {
                zRemove = this.server.mQueue.remove(this);
                this.cancelled = zRemove;
            }
            return zRemove;
        }

        @Override // com.koushikdutta.async.future.Cancellable
        public boolean isCancelled() {
            return this.cancelled;
        }

        @Override // com.koushikdutta.async.future.Cancellable
        public boolean isDone() {
            boolean z;
            synchronized (this.server) {
                z = (this.cancelled || this.server.mQueue.contains(this)) ? false : true;
            }
            return z;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.runnable.run();
        }
    }

    public static class Scheduler implements Comparator<Scheduled> {
        public static Scheduler INSTANCE = new Scheduler();

        private Scheduler() {
        }

        @Override // java.util.Comparator
        public int compare(Scheduled scheduled, Scheduled scheduled2) {
            long j = scheduled.time;
            long j2 = scheduled2.time;
            if (j == j2) {
                return 0;
            }
            return j > j2 ? 1 : -1;
        }
    }

    static {
        try {
            if (Build.VERSION.SDK_INT <= 8) {
                System.setProperty("java.net.preferIPv4Stack", "true");
                System.setProperty("java.net.preferIPv6Addresses", "false");
            }
        } catch (Throwable unused) {
        }
        mInstance = new AsyncServer();
        synchronousWorkers = newSynchronousWorkers("AsyncServer-worker-");
        ipSorter = new Comparator<InetAddress>() { // from class: com.koushikdutta.async.AsyncServer.5
            @Override // java.util.Comparator
            public int compare(InetAddress inetAddress, InetAddress inetAddress2) {
                boolean z = inetAddress instanceof Inet4Address;
                if (z && (inetAddress2 instanceof Inet4Address)) {
                    return 0;
                }
                if ((inetAddress instanceof Inet6Address) && (inetAddress2 instanceof Inet6Address)) {
                    return 0;
                }
                return (z && (inetAddress2 instanceof Inet6Address)) ? -1 : 1;
            }
        };
        synchronousResolverWorkers = newSynchronousWorkers("AsyncServer-resolver-");
        threadServer = new ThreadLocal<>();
    }

    public AsyncServer() {
        this(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void b(AsyncDatagramSocket asyncDatagramSocket, DatagramChannel datagramChannel, SocketAddress socketAddress) throws IOException {
        try {
            handleSocket(asyncDatagramSocket);
            datagramChannel.connect(socketAddress);
        } catch (IOException unused) {
            StreamUtility.closeQuietly(datagramChannel);
        }
    }

    public static /* synthetic */ InetAddress d(InetAddress inetAddress) throws Exception {
        return inetAddress;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void f(ValueFunction valueFunction, int i, boolean z, SimpleFuture simpleFuture) throws IOException {
        DatagramChannel datagramChannelOpen;
        try {
            datagramChannelOpen = DatagramChannel.open();
            try {
                AsyncDatagramSocket asyncDatagramSocket = new AsyncDatagramSocket();
                asyncDatagramSocket.attach(datagramChannelOpen);
                InetSocketAddress inetSocketAddress = valueFunction == null ? new InetSocketAddress(i) : new InetSocketAddress((InetAddress) valueFunction.getValue(), i);
                if (z) {
                    datagramChannelOpen.socket().setReuseAddress(z);
                }
                datagramChannelOpen.socket().bind(inetSocketAddress);
                handleSocket(asyncDatagramSocket);
                if (simpleFuture.setComplete((SimpleFuture) asyncDatagramSocket)) {
                    return;
                }
                datagramChannelOpen.close();
            } catch (Exception e) {
                e = e;
                StreamUtility.closeQuietly(datagramChannelOpen);
                simpleFuture.setComplete(e);
            }
        } catch (Exception e2) {
            e = e2;
            datagramChannelOpen = null;
        }
    }

    public static /* synthetic */ InetAddress g(InetAddress[] inetAddressArr) throws Exception {
        return inetAddressArr[0];
    }

    public static AsyncServer getCurrentThreadServer() {
        return threadServer.get();
    }

    public static AsyncServer getDefault() {
        return mInstance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void i(AsyncDatagramSocket asyncDatagramSocket, InetAddress inetAddress, int i, boolean z) throws IOException {
        try {
            DatagramChannel datagramChannelOpen = DatagramChannel.open();
            try {
                asyncDatagramSocket.attach(datagramChannelOpen);
                InetSocketAddress inetSocketAddress = inetAddress == null ? new InetSocketAddress(i) : new InetSocketAddress(inetAddress, i);
                if (z) {
                    datagramChannelOpen.socket().setReuseAddress(z);
                }
                datagramChannelOpen.socket().bind(inetSocketAddress);
                handleSocket(asyncDatagramSocket);
            } catch (IOException unused) {
                StreamUtility.closeQuietly(datagramChannelOpen);
            }
        } catch (Exception unused2) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleSocket(AsyncNetworkSocket asyncNetworkSocket) throws ClosedChannelException {
        SelectionKey selectionKeyRegister = asyncNetworkSocket.getChannel().register(this.mSelector.getSelector());
        selectionKeyRegister.attach(asyncNetworkSocket);
        asyncNetworkSocket.setup(this, selectionKeyRegister);
    }

    public static /* synthetic */ void k(Runnable runnable, Semaphore semaphore) {
        runnable.run();
        semaphore.release();
    }

    private static long lockAndRunQueue(AsyncServer asyncServer, PriorityQueue<Scheduled> priorityQueue) {
        long j = Long.MAX_VALUE;
        while (true) {
            Scheduled scheduled = null;
            synchronized (asyncServer) {
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                if (priorityQueue.size() > 0) {
                    Scheduled scheduledRemove = priorityQueue.remove();
                    long j2 = scheduledRemove.time;
                    if (j2 <= jElapsedRealtime) {
                        scheduled = scheduledRemove;
                    } else {
                        priorityQueue.add(scheduledRemove);
                        j = j2 - jElapsedRealtime;
                    }
                }
            }
            if (scheduled == null) {
                asyncServer.postCounter = 0;
                return j;
            }
            scheduled.run();
        }
    }

    private static ExecutorService newSynchronousWorkers(String str) {
        return new ThreadPoolExecutor(0, 4, 10L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new NamedThreadFactory(str));
    }

    public static void post(Handler handler, Runnable runnable) {
        RunnableWrapper runnableWrapper = new RunnableWrapper();
        ThreadQueue orCreateThreadQueue = ThreadQueue.getOrCreateThreadQueue(handler.getLooper().getThread());
        runnableWrapper.threadQueue = orCreateThreadQueue;
        runnableWrapper.handler = handler;
        runnableWrapper.runnable = runnable;
        orCreateThreadQueue.add((Runnable) runnableWrapper);
        handler.post(runnableWrapper);
        orCreateThreadQueue.queueSemaphore.release();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v18, types: [com.koushikdutta.async.callback.ConnectCallback] */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.nio.channels.SelectionKey] */
    /* JADX WARN: Type inference failed for: r1v7, types: [com.koushikdutta.async.callback.ListenCallback] */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v4, types: [java.nio.channels.SelectionKey] */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r6v1, types: [com.koushikdutta.async.AsyncNetworkSocket, com.koushikdutta.async.AsyncSocket, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v4, types: [com.koushikdutta.async.AsyncNetworkSocket, com.koushikdutta.async.AsyncSocket, java.lang.Object] */
    private static void runLoop(AsyncServer asyncServer, SelectorWrapper selectorWrapper, PriorityQueue<Scheduled> priorityQueue) throws IOException {
        boolean z;
        SocketChannel socketChannel;
        SelectionKey selectionKey;
        ?? Register;
        long jLockAndRunQueue = lockAndRunQueue(asyncServer, priorityQueue);
        try {
            synchronized (asyncServer) {
                if (selectorWrapper.selectNow() != 0) {
                    z = false;
                } else if (selectorWrapper.keys().size() == 0 && jLockAndRunQueue == Long.MAX_VALUE) {
                    return;
                } else {
                    z = true;
                }
                if (z) {
                    if (jLockAndRunQueue == Long.MAX_VALUE) {
                        selectorWrapper.select();
                    } else {
                        selectorWrapper.select(jLockAndRunQueue);
                    }
                }
                Set<SelectionKey> setSelectedKeys = selectorWrapper.selectedKeys();
                for (SelectionKey selectionKey2 : setSelectedKeys) {
                    try {
                        socketChannel = null;
                        Register = 0;
                    } catch (CancelledKeyException unused) {
                    }
                    if (selectionKey2.isAcceptable()) {
                        try {
                            SocketChannel socketChannelAccept = ((ServerSocketChannel) selectionKey2.channel()).accept();
                            if (socketChannelAccept != null) {
                                try {
                                    socketChannelAccept.configureBlocking(false);
                                    Register = socketChannelAccept.register(selectorWrapper.getSelector(), 1);
                                    ?? r1 = (ListenCallback) selectionKey2.attachment();
                                    ?? asyncNetworkSocket = new AsyncNetworkSocket();
                                    asyncNetworkSocket.attach(socketChannelAccept, (InetSocketAddress) socketChannelAccept.socket().getRemoteSocketAddress());
                                    asyncNetworkSocket.setup(asyncServer, Register);
                                    Register.attach(asyncNetworkSocket);
                                    r1.onAccepted(asyncNetworkSocket);
                                } catch (IOException unused2) {
                                    selectionKey = Register;
                                    socketChannel = socketChannelAccept;
                                    StreamUtility.closeQuietly(socketChannel);
                                    if (selectionKey != null) {
                                        selectionKey.cancel();
                                    }
                                }
                            }
                        } catch (IOException unused3) {
                            selectionKey = null;
                        }
                    } else if (selectionKey2.isReadable()) {
                        asyncServer.onDataReceived(((AsyncNetworkSocket) selectionKey2.attachment()).onReadable());
                    } else if (selectionKey2.isWritable()) {
                        ((AsyncNetworkSocket) selectionKey2.attachment()).onDataWritable();
                    } else {
                        if (!selectionKey2.isConnectable()) {
                            throw new RuntimeException("Unknown key state.");
                        }
                        ConnectFuture connectFuture = (ConnectFuture) selectionKey2.attachment();
                        SocketChannel socketChannel2 = (SocketChannel) selectionKey2.channel();
                        selectionKey2.interestOps(1);
                        try {
                            socketChannel2.finishConnect();
                            ?? asyncNetworkSocket2 = new AsyncNetworkSocket();
                            asyncNetworkSocket2.setup(asyncServer, selectionKey2);
                            asyncNetworkSocket2.attach(socketChannel2, (InetSocketAddress) socketChannel2.socket().getRemoteSocketAddress());
                            selectionKey2.attach(asyncNetworkSocket2);
                            if (connectFuture.setComplete((ConnectFuture) asyncNetworkSocket2)) {
                                connectFuture.callback.onConnectCompleted(null, asyncNetworkSocket2);
                            }
                        } catch (IOException e) {
                            selectionKey2.cancel();
                            StreamUtility.closeQuietly(socketChannel2);
                            if (connectFuture.setComplete((Exception) e)) {
                                connectFuture.callback.onConnectCompleted(e, null);
                            }
                        }
                    }
                }
                setSelectedKeys.clear();
            }
        } catch (Exception e2) {
            throw new AsyncSelectorException(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void shutdownEverything(SelectorWrapper selectorWrapper) throws IOException {
        shutdownKeys(selectorWrapper);
        StreamUtility.closeQuietly(selectorWrapper);
    }

    private static void shutdownKeys(SelectorWrapper selectorWrapper) {
        try {
            for (SelectionKey selectionKey : selectorWrapper.keys()) {
                StreamUtility.closeQuietly(selectionKey.channel());
                try {
                    selectionKey.cancel();
                } catch (Exception unused) {
                }
            }
        } catch (Exception unused2) {
        }
    }

    private static void wakeup(final SelectorWrapper selectorWrapper) {
        synchronousWorkers.execute(new Runnable() { // from class: dc.j81
            @Override // java.lang.Runnable
            public final void run() {
                selectorWrapper.wakeupOnce();
            }
        });
    }

    public AsyncDatagramSocket connectDatagram(final String str, final int i) throws InterruptedException, IOException {
        final DatagramChannel datagramChannelOpen = DatagramChannel.open();
        final AsyncDatagramSocket asyncDatagramSocket = new AsyncDatagramSocket();
        asyncDatagramSocket.attach(datagramChannelOpen);
        run(new Runnable() { // from class: com.koushikdutta.async.AsyncServer.7
            @Override // java.lang.Runnable
            public void run() throws IOException {
                try {
                    InetSocketAddress inetSocketAddress = new InetSocketAddress(str, i);
                    AsyncServer.this.handleSocket(asyncDatagramSocket);
                    datagramChannelOpen.connect(inetSocketAddress);
                } catch (IOException unused) {
                    StreamUtility.closeQuietly(datagramChannelOpen);
                }
            }
        });
        return asyncDatagramSocket;
    }

    public Cancellable connectResolvedInetSocketAddress(InetSocketAddress inetSocketAddress, ConnectCallback connectCallback) {
        return connectResolvedInetSocketAddress(inetSocketAddress, connectCallback, null);
    }

    public Cancellable connectSocket(final InetSocketAddress inetSocketAddress, final ConnectCallback connectCallback) {
        if (!inetSocketAddress.isUnresolved()) {
            return connectResolvedInetSocketAddress(inetSocketAddress, connectCallback);
        }
        final SimpleFuture simpleFuture = new SimpleFuture();
        Future<InetAddress> byName = getByName(inetSocketAddress.getHostName());
        simpleFuture.setParent(byName);
        byName.setCallback(new FutureCallback<InetAddress>() { // from class: com.koushikdutta.async.AsyncServer.4
            @Override // com.koushikdutta.async.future.FutureCallback
            public void onCompleted(Exception exc, InetAddress inetAddress) {
                if (exc == null) {
                    simpleFuture.setComplete((Future) AsyncServer.this.connectResolvedInetSocketAddress(new InetSocketAddress(inetAddress, inetSocketAddress.getPort()), connectCallback));
                } else {
                    connectCallback.onConnectCompleted(exc, null);
                    simpleFuture.setComplete(exc);
                }
            }
        });
        return simpleFuture;
    }

    public Cancellable createDatagram(final String str, int i, boolean z, FutureCallback<AsyncDatagramSocket> futureCallback) {
        return createDatagram(new ValueFunction() { // from class: dc.i81
            @Override // com.koushikdutta.async.callback.ValueFunction
            public final Object getValue() {
                return InetAddress.getByName(str);
            }
        }, i, z, futureCallback);
    }

    public void dump() {
        post(new Runnable() { // from class: com.koushikdutta.async.AsyncServer.9
            @Override // java.lang.Runnable
            public void run() {
                if (AsyncServer.this.mSelector == null) {
                    return;
                }
                String str = "Key Count: " + AsyncServer.this.mSelector.keys().size();
                Iterator<SelectionKey> it = AsyncServer.this.mSelector.keys().iterator();
                while (it.hasNext()) {
                    String str2 = "Key: " + it.next();
                }
            }
        });
    }

    public Thread getAffinity() {
        return this.mAffinity;
    }

    public Future<InetAddress[]> getAllByName(final String str) {
        final SimpleFuture simpleFuture = new SimpleFuture();
        synchronousResolverWorkers.execute(new Runnable() { // from class: com.koushikdutta.async.AsyncServer.6
            @Override // java.lang.Runnable
            public void run() throws UnknownHostException, HostnameResolutionException {
                try {
                    final InetAddress[] allByName = InetAddress.getAllByName(str);
                    Arrays.sort(allByName, AsyncServer.ipSorter);
                    if (allByName == null || allByName.length == 0) {
                        throw new HostnameResolutionException("no addresses for host");
                    }
                    AsyncServer.this.post(new Runnable() { // from class: com.koushikdutta.async.AsyncServer.6.1
                        @Override // java.lang.Runnable
                        public void run() {
                            simpleFuture.setComplete((Exception) null, (Exception) allByName);
                        }
                    });
                } catch (Exception e) {
                    AsyncServer.this.post(new Runnable() { // from class: com.koushikdutta.async.AsyncServer.6.2
                        @Override // java.lang.Runnable
                        public void run() {
                            simpleFuture.setComplete(e, (Exception) null);
                        }
                    });
                }
            }
        });
        return simpleFuture;
    }

    public Future<InetAddress> getByName(String str) {
        return getAllByName(str).thenConvert(new ThenCallback() { // from class: dc.q81
            @Override // com.koushikdutta.async.future.ThenCallback
            public final Object then(Object obj) {
                return AsyncServer.g((InetAddress[]) obj);
            }
        });
    }

    public boolean isAffinityThread() {
        return this.mAffinity == Thread.currentThread();
    }

    public boolean isAffinityThreadOrStopped() {
        Thread thread = this.mAffinity;
        return thread == null || thread == Thread.currentThread();
    }

    public boolean isRunning() {
        return this.mSelector != null;
    }

    public void kill() throws InterruptedException {
        synchronized (this) {
            this.killed = true;
        }
        stop(false);
    }

    public AsyncServerSocket listen(final InetAddress inetAddress, final int i, final ListenCallback listenCallback) throws InterruptedException {
        final ObjectHolder objectHolder = new ObjectHolder();
        run(new Runnable() { // from class: com.koushikdutta.async.AsyncServer.2
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r5v0, types: [T, com.koushikdutta.async.AsyncServer$2$1, com.koushikdutta.async.AsyncServerSocket] */
            @Override // java.lang.Runnable
            public void run() throws IOException {
                final ServerSocketChannelWrapper serverSocketChannelWrapper;
                IOException e;
                final ServerSocketChannel serverSocketChannelOpen;
                try {
                    serverSocketChannelOpen = ServerSocketChannel.open();
                    try {
                        serverSocketChannelWrapper = new ServerSocketChannelWrapper(serverSocketChannelOpen);
                        try {
                            serverSocketChannelOpen.socket().bind(inetAddress == null ? new InetSocketAddress(i) : new InetSocketAddress(inetAddress, i));
                            final SelectionKey selectionKeyRegister = serverSocketChannelWrapper.register(AsyncServer.this.mSelector.getSelector());
                            selectionKeyRegister.attach(listenCallback);
                            ListenCallback listenCallback2 = listenCallback;
                            ObjectHolder objectHolder2 = objectHolder;
                            ?? r5 = new AsyncServerSocket() { // from class: com.koushikdutta.async.AsyncServer.2.1
                                @Override // com.koushikdutta.async.AsyncServerSocket
                                public int getLocalPort() {
                                    return serverSocketChannelOpen.socket().getLocalPort();
                                }

                                @Override // com.koushikdutta.async.AsyncServerSocket
                                public void stop() throws IOException {
                                    StreamUtility.closeQuietly(serverSocketChannelWrapper);
                                    try {
                                        selectionKeyRegister.cancel();
                                    } catch (Exception unused) {
                                    }
                                }
                            };
                            objectHolder2.held = r5;
                            listenCallback2.onListening(r5);
                        } catch (IOException e2) {
                            e = e2;
                            StreamUtility.closeQuietly(serverSocketChannelWrapper, serverSocketChannelOpen);
                            listenCallback.onCompleted(e);
                        }
                    } catch (IOException e3) {
                        serverSocketChannelWrapper = null;
                        e = e3;
                    }
                } catch (IOException e4) {
                    serverSocketChannelWrapper = null;
                    e = e4;
                    serverSocketChannelOpen = null;
                }
            }
        });
        return (AsyncServerSocket) objectHolder.held;
    }

    public void onDataReceived(int i) {
    }

    public void onDataSent(int i) {
    }

    public AsyncDatagramSocket openDatagram() {
        return openDatagram(null, 0, false);
    }

    public Cancellable postDelayed(Runnable runnable, long j) {
        synchronized (this) {
            if (this.killed) {
                return SimpleCancellable.CANCELLED;
            }
            long jMin = 0;
            if (j > 0) {
                jMin = SystemClock.elapsedRealtime() + j;
            } else if (j == 0) {
                int i = this.postCounter;
                this.postCounter = i + 1;
                jMin = i;
            } else if (this.mQueue.size() > 0) {
                jMin = Math.min(0L, this.mQueue.peek().time - 1);
            }
            PriorityQueue<Scheduled> priorityQueue = this.mQueue;
            Scheduled scheduled = new Scheduled(this, runnable, jMin);
            priorityQueue.add(scheduled);
            if (this.mSelector == null) {
                run();
            }
            if (!isAffinityThread()) {
                wakeup(this.mSelector);
            }
            return scheduled;
        }
    }

    public Cancellable postImmediate(Runnable runnable) {
        if (Thread.currentThread() != getAffinity()) {
            return postDelayed(runnable, -1L);
        }
        runnable.run();
        return null;
    }

    public void run(final Runnable runnable) throws InterruptedException {
        if (Thread.currentThread() == this.mAffinity) {
            post(runnable);
            lockAndRunQueue(this, this.mQueue);
            return;
        }
        synchronized (this) {
            if (this.killed) {
                return;
            }
            final Semaphore semaphore = new Semaphore(0);
            post(new Runnable() { // from class: dc.k81
                @Override // java.lang.Runnable
                public final void run() {
                    AsyncServer.k(runnable, semaphore);
                }
            });
            try {
                semaphore.acquire();
            } catch (InterruptedException unused) {
            }
        }
    }

    public void stop() throws InterruptedException {
        stop(false);
    }

    public AsyncServer(String str) {
        this.postCounter = 0;
        this.mQueue = new PriorityQueue<>(1, Scheduler.INSTANCE);
        this.mName = str == null ? "AsyncServer" : str;
    }

    public ConnectFuture connectResolvedInetSocketAddress(final InetSocketAddress inetSocketAddress, final ConnectCallback connectCallback, final SocketCreateCallback socketCreateCallback) {
        final ConnectFuture connectFuture = new ConnectFuture();
        post(new Runnable() { // from class: com.koushikdutta.async.AsyncServer.3
            @Override // java.lang.Runnable
            public void run() throws IOException {
                SocketChannel socketChannelOpen;
                if (connectFuture.isCancelled()) {
                    return;
                }
                ConnectFuture connectFuture2 = connectFuture;
                connectFuture2.callback = connectCallback;
                SelectionKey selectionKeyRegister = null;
                try {
                    socketChannelOpen = SocketChannel.open();
                    connectFuture2.socket = socketChannelOpen;
                } catch (Throwable th) {
                    th = th;
                    socketChannelOpen = null;
                }
                try {
                    socketChannelOpen.configureBlocking(false);
                    selectionKeyRegister = socketChannelOpen.register(AsyncServer.this.mSelector.getSelector(), 8);
                    selectionKeyRegister.attach(connectFuture);
                    SocketCreateCallback socketCreateCallback2 = socketCreateCallback;
                    if (socketCreateCallback2 != null) {
                        socketCreateCallback2.onSocketCreated(socketChannelOpen.socket().getLocalPort());
                    }
                    socketChannelOpen.connect(inetSocketAddress);
                } catch (Throwable th2) {
                    th = th2;
                    if (selectionKeyRegister != null) {
                        selectionKeyRegister.cancel();
                    }
                    StreamUtility.closeQuietly(socketChannelOpen);
                    connectFuture.setComplete((Exception) new RuntimeException(th));
                }
            }
        });
        return connectFuture;
    }

    public Cancellable createDatagram(final InetAddress inetAddress, int i, boolean z, FutureCallback<AsyncDatagramSocket> futureCallback) {
        return createDatagram(new ValueFunction() { // from class: dc.h81
            @Override // com.koushikdutta.async.callback.ValueFunction
            public final Object getValue() throws Exception {
                InetAddress inetAddress2 = inetAddress;
                AsyncServer.d(inetAddress2);
                return inetAddress2;
            }
        }, i, z, futureCallback);
    }

    public AsyncDatagramSocket openDatagram(final InetAddress inetAddress, final int i, final boolean z) throws InterruptedException {
        final AsyncDatagramSocket asyncDatagramSocket = new AsyncDatagramSocket();
        Runnable runnable = new Runnable() { // from class: dc.o81
            @Override // java.lang.Runnable
            public final void run() throws IOException {
                this.a.i(asyncDatagramSocket, inetAddress, i, z);
            }
        };
        if (getAffinity() != Thread.currentThread()) {
            run(runnable);
            return asyncDatagramSocket;
        }
        runnable.run();
        return asyncDatagramSocket;
    }

    public void stop(boolean z) throws InterruptedException {
        synchronized (this) {
            boolean zIsAffinityThread = isAffinityThread();
            final SelectorWrapper selectorWrapper = this.mSelector;
            if (selectorWrapper == null) {
                return;
            }
            final Semaphore semaphore = new Semaphore(0);
            this.mQueue.add(new Scheduled(this, new Runnable() { // from class: com.koushikdutta.async.AsyncServer.1
                @Override // java.lang.Runnable
                public void run() throws IOException {
                    AsyncServer.shutdownEverything(selectorWrapper);
                    semaphore.release();
                }
            }, 0L));
            synchronousWorkers.execute(new Runnable() { // from class: dc.l81
                @Override // java.lang.Runnable
                public final void run() {
                    selectorWrapper.wakeupOnce();
                }
            });
            shutdownKeys(selectorWrapper);
            this.mQueue = new PriorityQueue<>(1, Scheduler.INSTANCE);
            this.mSelector = null;
            this.mAffinity = null;
            if (zIsAffinityThread || !z) {
                return;
            }
            try {
                semaphore.acquire();
            } catch (Exception unused) {
            }
        }
    }

    private Cancellable createDatagram(final ValueFunction<InetAddress> valueFunction, final int i, final boolean z, FutureCallback<AsyncDatagramSocket> futureCallback) {
        final SimpleFuture simpleFuture = new SimpleFuture();
        simpleFuture.setCallback(futureCallback);
        post(new Runnable() { // from class: dc.p81
            @Override // java.lang.Runnable
            public final void run() throws IOException {
                this.a.f(valueFunction, i, z, simpleFuture);
            }
        });
        return simpleFuture;
    }

    public AsyncDatagramSocket connectDatagram(final SocketAddress socketAddress) throws InterruptedException, IOException {
        final AsyncDatagramSocket asyncDatagramSocket = new AsyncDatagramSocket();
        final DatagramChannel datagramChannelOpen = DatagramChannel.open();
        asyncDatagramSocket.attach(datagramChannelOpen);
        Runnable runnable = new Runnable() { // from class: dc.m81
            @Override // java.lang.Runnable
            public final void run() throws IOException {
                this.a.b(asyncDatagramSocket, datagramChannelOpen, socketAddress);
            }
        };
        if (getAffinity() != Thread.currentThread()) {
            run(runnable);
            return asyncDatagramSocket;
        }
        runnable.run();
        return asyncDatagramSocket;
    }

    public Cancellable connectSocket(String str, int i, ConnectCallback connectCallback) {
        return connectSocket(InetSocketAddress.createUnresolved(str, i), connectCallback);
    }

    public Cancellable post(Runnable runnable) {
        return postDelayed(runnable, 0L);
    }

    public Cancellable post(final CompletedCallback completedCallback, final Exception exc) {
        return post(new Runnable() { // from class: dc.n81
            @Override // java.lang.Runnable
            public final void run() {
                completedCallback.onCompleted(exc);
            }
        });
    }

    private void run() throws IOException {
        synchronized (this) {
            SelectorWrapper selectorWrapper = this.mSelector;
            if (selectorWrapper == null) {
                try {
                    final SelectorWrapper selectorWrapper2 = new SelectorWrapper(SelectorProvider.provider().openSelector());
                    this.mSelector = selectorWrapper2;
                    final PriorityQueue<Scheduled> priorityQueue = this.mQueue;
                    Thread thread = new Thread(this.mName) { // from class: com.koushikdutta.async.AsyncServer.8
                        @Override // java.lang.Thread, java.lang.Runnable
                        public void run() {
                            try {
                                AsyncServer.threadServer.set(AsyncServer.this);
                                AsyncServer.run(AsyncServer.this, selectorWrapper2, priorityQueue);
                            } finally {
                                AsyncServer.threadServer.remove();
                            }
                        }
                    };
                    this.mAffinity = thread;
                    thread.start();
                    return;
                } catch (IOException e) {
                    throw new RuntimeException("unable to create selector?", e);
                }
            }
            PriorityQueue<Scheduled> priorityQueue2 = this.mQueue;
            try {
                try {
                    runLoop(this, selectorWrapper, priorityQueue2);
                } catch (AsyncSelectorException unused) {
                    selectorWrapper.getSelector().close();
                }
            } catch (Exception unused2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void run(AsyncServer asyncServer, SelectorWrapper selectorWrapper, PriorityQueue<Scheduled> priorityQueue) throws IOException {
        while (true) {
            try {
                runLoop(asyncServer, selectorWrapper, priorityQueue);
            } catch (AsyncSelectorException e) {
                boolean z = e.getCause() instanceof ClosedSelectorException;
                StreamUtility.closeQuietly(selectorWrapper);
            }
            synchronized (asyncServer) {
                if (!selectorWrapper.isOpen() || (selectorWrapper.keys().size() <= 0 && priorityQueue.size() <= 0)) {
                    break;
                }
            }
        }
        shutdownEverything(selectorWrapper);
        if (asyncServer.mSelector == selectorWrapper) {
            asyncServer.mQueue = new PriorityQueue<>(1, Scheduler.INSTANCE);
            asyncServer.mSelector = null;
            asyncServer.mAffinity = null;
        }
    }
}
