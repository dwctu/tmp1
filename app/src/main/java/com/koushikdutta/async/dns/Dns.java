package com.koushikdutta.async.dns;

import com.koushikdutta.async.AsyncDatagramSocket;
import com.koushikdutta.async.AsyncServer;
import com.koushikdutta.async.ByteBufferList;
import com.koushikdutta.async.DataEmitter;
import com.koushikdutta.async.callback.DataCallback;
import com.koushikdutta.async.dns.Dns;
import com.koushikdutta.async.future.Cancellable;
import com.koushikdutta.async.future.Future;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.async.future.SimpleFuture;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Random;

/* loaded from: classes3.dex */
public class Dns {
    private static void addName(ByteBuffer byteBuffer, String str) {
        for (String str2 : str.split("\\.")) {
            byteBuffer.put((byte) str2.length());
            byteBuffer.put(str2.getBytes());
        }
        byteBuffer.put((byte) 0);
    }

    public static Future<DnsResponse> lookup(String str) {
        return lookup(AsyncServer.getDefault(), str, false, null);
    }

    public static Cancellable multicastLookup(AsyncServer asyncServer, String str, FutureCallback<DnsResponse> futureCallback) {
        return lookup(asyncServer, str, true, futureCallback);
    }

    private static int setFlag(int i, int i2, int i3) {
        return i | (i2 << i3);
    }

    private static int setQuery(int i) {
        return setFlag(i, 0, 0);
    }

    private static int setRecursion(int i) {
        return setFlag(i, 1, 8);
    }

    public static Future<DnsResponse> lookup(AsyncServer asyncServer, String str) {
        return lookup(asyncServer, str, false, null);
    }

    public static Cancellable multicastLookup(String str, FutureCallback<DnsResponse> futureCallback) {
        return multicastLookup(AsyncServer.getDefault(), str, futureCallback);
    }

    public static Future<DnsResponse> lookup(final AsyncServer asyncServer, final String str, final boolean z, final FutureCallback<DnsResponse> futureCallback) throws IllegalAccessException, SocketException, NoSuchFieldException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        final AsyncDatagramSocket asyncDatagramSocketOpenDatagram;
        if (!asyncServer.isAffinityThread()) {
            final SimpleFuture simpleFuture = new SimpleFuture();
            asyncServer.post(new Runnable() { // from class: dc.u81
                @Override // java.lang.Runnable
                public final void run() {
                    simpleFuture.setComplete((Future) Dns.lookup(asyncServer, str, z, futureCallback));
                }
            });
            return simpleFuture;
        }
        ByteBuffer byteBufferOrder = ByteBufferList.obtain(1024).order(ByteOrder.BIG_ENDIAN);
        short sNextInt = (short) new Random().nextInt();
        short query = (short) setQuery(0);
        if (!z) {
            query = (short) setRecursion(query);
        }
        byteBufferOrder.putShort(sNextInt);
        byteBufferOrder.putShort(query);
        byteBufferOrder.putShort(z ? (short) 1 : (short) 2);
        byteBufferOrder.putShort((short) 0);
        byteBufferOrder.putShort((short) 0);
        byteBufferOrder.putShort((short) 0);
        addName(byteBufferOrder, str);
        byteBufferOrder.putShort(z ? (short) 12 : (short) 1);
        byteBufferOrder.putShort((short) 1);
        if (!z) {
            addName(byteBufferOrder, str);
            byteBufferOrder.putShort((short) 28);
            byteBufferOrder.putShort((short) 1);
        }
        byteBufferOrder.flip();
        try {
            if (!z) {
                asyncDatagramSocketOpenDatagram = asyncServer.connectDatagram(new InetSocketAddress("8.8.8.8", 53));
            } else {
                asyncDatagramSocketOpenDatagram = AsyncServer.getDefault().openDatagram(null, 0, true);
                Field declaredField = DatagramSocket.class.getDeclaredField("impl");
                declaredField.setAccessible(true);
                Object obj = declaredField.get(asyncDatagramSocketOpenDatagram.getSocket());
                Method declaredMethod = obj.getClass().getDeclaredMethod("join", InetAddress.class);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(obj, InetAddress.getByName("224.0.0.251"));
                ((DatagramSocket) asyncDatagramSocketOpenDatagram.getSocket()).setBroadcast(true);
            }
            final SimpleFuture<DnsResponse> simpleFuture2 = new SimpleFuture<DnsResponse>() { // from class: com.koushikdutta.async.dns.Dns.1
                @Override // com.koushikdutta.async.future.SimpleCancellable
                public void cleanup() {
                    super.cleanup();
                    asyncDatagramSocketOpenDatagram.close();
                }
            };
            asyncDatagramSocketOpenDatagram.setDataCallback(new DataCallback() { // from class: com.koushikdutta.async.dns.Dns.2
                @Override // com.koushikdutta.async.callback.DataCallback
                public void onDataAvailable(DataEmitter dataEmitter, ByteBufferList byteBufferList) {
                    try {
                        DnsResponse dnsResponse = DnsResponse.parse(byteBufferList);
                        dnsResponse.source = asyncDatagramSocketOpenDatagram.getRemoteAddress();
                        if (z) {
                            futureCallback.onCompleted(null, dnsResponse);
                        } else {
                            asyncDatagramSocketOpenDatagram.close();
                            simpleFuture2.setComplete((SimpleFuture) dnsResponse);
                        }
                    } catch (Exception unused) {
                    }
                    byteBufferList.recycle();
                }
            });
            if (!z) {
                asyncDatagramSocketOpenDatagram.write(new ByteBufferList(byteBufferOrder));
            } else {
                asyncDatagramSocketOpenDatagram.send(new InetSocketAddress("224.0.0.251", 5353), byteBufferOrder);
            }
            return simpleFuture2;
        } catch (Exception e) {
            SimpleFuture simpleFuture3 = new SimpleFuture();
            simpleFuture3.setComplete(e);
            if (z) {
                futureCallback.onCompleted(e, null);
            }
            return simpleFuture3;
        }
    }
}
