package com.koushikdutta.async;

import com.koushikdutta.async.callback.DataCallback;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.LinkedList;

/* loaded from: classes3.dex */
public class PushParser implements DataCallback {
    public static Hashtable<Class, Method> mTable = new Hashtable<>();
    public DataEmitter mEmitter;
    private Waiter noopArgWaiter = new Waiter(0) { // from class: com.koushikdutta.async.PushParser.1
        @Override // com.koushikdutta.async.PushParser.Waiter
        public Waiter onDataAvailable(DataEmitter dataEmitter, ByteBufferList byteBufferList) {
            PushParser.this.args.add(null);
            return null;
        }
    };
    private Waiter byteArgWaiter = new Waiter(1) { // from class: com.koushikdutta.async.PushParser.2
        @Override // com.koushikdutta.async.PushParser.Waiter
        public Waiter onDataAvailable(DataEmitter dataEmitter, ByteBufferList byteBufferList) {
            PushParser.this.args.add(Byte.valueOf(byteBufferList.get()));
            return null;
        }
    };
    private Waiter shortArgWaiter = new Waiter(2) { // from class: com.koushikdutta.async.PushParser.3
        @Override // com.koushikdutta.async.PushParser.Waiter
        public Waiter onDataAvailable(DataEmitter dataEmitter, ByteBufferList byteBufferList) {
            PushParser.this.args.add(Short.valueOf(byteBufferList.getShort()));
            return null;
        }
    };
    private Waiter intArgWaiter = new Waiter(4) { // from class: com.koushikdutta.async.PushParser.4
        @Override // com.koushikdutta.async.PushParser.Waiter
        public Waiter onDataAvailable(DataEmitter dataEmitter, ByteBufferList byteBufferList) {
            PushParser.this.args.add(Integer.valueOf(byteBufferList.getInt()));
            return null;
        }
    };
    private Waiter longArgWaiter = new Waiter(8) { // from class: com.koushikdutta.async.PushParser.5
        @Override // com.koushikdutta.async.PushParser.Waiter
        public Waiter onDataAvailable(DataEmitter dataEmitter, ByteBufferList byteBufferList) {
            PushParser.this.args.add(Long.valueOf(byteBufferList.getLong()));
            return null;
        }
    };
    private ParseCallback<byte[]> byteArrayArgCallback = new ParseCallback<byte[]>() { // from class: com.koushikdutta.async.PushParser.6
        @Override // com.koushikdutta.async.PushParser.ParseCallback
        public void parsed(byte[] bArr) {
            PushParser.this.args.add(bArr);
        }
    };
    private ParseCallback<ByteBufferList> byteBufferListArgCallback = new ParseCallback<ByteBufferList>() { // from class: com.koushikdutta.async.PushParser.7
        @Override // com.koushikdutta.async.PushParser.ParseCallback
        public void parsed(ByteBufferList byteBufferList) {
            PushParser.this.args.add(byteBufferList);
        }
    };
    private ParseCallback<byte[]> stringArgCallback = new ParseCallback<byte[]>() { // from class: com.koushikdutta.async.PushParser.8
        @Override // com.koushikdutta.async.PushParser.ParseCallback
        public void parsed(byte[] bArr) {
            PushParser.this.args.add(new String(bArr));
        }
    };
    private LinkedList<Waiter> mWaiting = new LinkedList<>();
    private ArrayList<Object> args = new ArrayList<>();
    public ByteOrder order = ByteOrder.BIG_ENDIAN;
    public ByteBufferList pending = new ByteBufferList();

    public static class ByteArrayWaiter extends Waiter {
        public ParseCallback<byte[]> callback;

        public ByteArrayWaiter(int i, ParseCallback<byte[]> parseCallback) {
            super(i);
            if (i <= 0) {
                throw new IllegalArgumentException("length should be > 0");
            }
            this.callback = parseCallback;
        }

        @Override // com.koushikdutta.async.PushParser.Waiter
        public Waiter onDataAvailable(DataEmitter dataEmitter, ByteBufferList byteBufferList) {
            byte[] bArr = new byte[this.length];
            byteBufferList.get(bArr);
            this.callback.parsed(bArr);
            return null;
        }
    }

    public static class ByteBufferListWaiter extends Waiter {
        public ParseCallback<ByteBufferList> callback;

        public ByteBufferListWaiter(int i, ParseCallback<ByteBufferList> parseCallback) {
            super(i);
            if (i <= 0) {
                throw new IllegalArgumentException("length should be > 0");
            }
            this.callback = parseCallback;
        }

        @Override // com.koushikdutta.async.PushParser.Waiter
        public Waiter onDataAvailable(DataEmitter dataEmitter, ByteBufferList byteBufferList) {
            this.callback.parsed(byteBufferList.get(this.length));
            return null;
        }
    }

    public static class IntWaiter extends Waiter {
        public ParseCallback<Integer> callback;

        public IntWaiter(ParseCallback<Integer> parseCallback) {
            super(4);
            this.callback = parseCallback;
        }

        @Override // com.koushikdutta.async.PushParser.Waiter
        public Waiter onDataAvailable(DataEmitter dataEmitter, ByteBufferList byteBufferList) {
            this.callback.parsed(Integer.valueOf(byteBufferList.getInt()));
            return null;
        }
    }

    public static class LenByteArrayWaiter extends Waiter {
        private final ParseCallback<byte[]> callback;

        public LenByteArrayWaiter(ParseCallback<byte[]> parseCallback) {
            super(4);
            this.callback = parseCallback;
        }

        @Override // com.koushikdutta.async.PushParser.Waiter
        public Waiter onDataAvailable(DataEmitter dataEmitter, ByteBufferList byteBufferList) {
            int i = byteBufferList.getInt();
            if (i != 0) {
                return new ByteArrayWaiter(i, this.callback);
            }
            this.callback.parsed(new byte[0]);
            return null;
        }
    }

    public static class LenByteBufferListWaiter extends Waiter {
        private final ParseCallback<ByteBufferList> callback;

        public LenByteBufferListWaiter(ParseCallback<ByteBufferList> parseCallback) {
            super(4);
            this.callback = parseCallback;
        }

        @Override // com.koushikdutta.async.PushParser.Waiter
        public Waiter onDataAvailable(DataEmitter dataEmitter, ByteBufferList byteBufferList) {
            return new ByteBufferListWaiter(byteBufferList.getInt(), this.callback);
        }
    }

    public interface ParseCallback<T> {
        void parsed(T t);
    }

    public class TapWaiter extends Waiter {
        private final TapCallback callback;

        public TapWaiter(TapCallback tapCallback) {
            super(0);
            this.callback = tapCallback;
        }

        @Override // com.koushikdutta.async.PushParser.Waiter
        public Waiter onDataAvailable(DataEmitter dataEmitter, ByteBufferList byteBufferList) throws IllegalAccessException, SecurityException, IllegalArgumentException, InvocationTargetException {
            Method tap = PushParser.getTap(this.callback);
            tap.setAccessible(true);
            try {
                tap.invoke(this.callback, PushParser.this.args.toArray());
            } catch (Exception unused) {
            }
            PushParser.this.args.clear();
            return null;
        }
    }

    public static class UntilWaiter extends Waiter {
        public DataCallback callback;
        public byte value;

        public UntilWaiter(byte b, DataCallback dataCallback) {
            super(1);
            this.value = b;
            this.callback = dataCallback;
        }

        @Override // com.koushikdutta.async.PushParser.Waiter
        public Waiter onDataAvailable(DataEmitter dataEmitter, ByteBufferList byteBufferList) {
            ByteBufferList byteBufferList2 = new ByteBufferList();
            boolean z = true;
            while (true) {
                if (byteBufferList.size() <= 0) {
                    break;
                }
                ByteBuffer byteBufferRemove = byteBufferList.remove();
                byteBufferRemove.mark();
                int i = 0;
                while (byteBufferRemove.remaining() > 0) {
                    z = byteBufferRemove.get() == this.value;
                    if (z) {
                        break;
                    }
                    i++;
                }
                byteBufferRemove.reset();
                if (z) {
                    byteBufferList.addFirst(byteBufferRemove);
                    byteBufferList.get(byteBufferList2, i);
                    byteBufferList.get();
                    break;
                }
                byteBufferList2.add(byteBufferRemove);
            }
            this.callback.onDataAvailable(dataEmitter, byteBufferList2);
            if (z) {
                return null;
            }
            return this;
        }
    }

    public static abstract class Waiter {
        public int length;

        public Waiter(int i) {
            this.length = i;
        }

        public abstract Waiter onDataAvailable(DataEmitter dataEmitter, ByteBufferList byteBufferList);
    }

    public PushParser(DataEmitter dataEmitter) {
        this.mEmitter = dataEmitter;
        dataEmitter.setDataCallback(this);
    }

    public static Method getTap(TapCallback tapCallback) throws SecurityException {
        Method method = mTable.get(tapCallback.getClass());
        if (method != null) {
            return method;
        }
        for (Method method2 : tapCallback.getClass().getMethods()) {
            if ("tap".equals(method2.getName())) {
                mTable.put(tapCallback.getClass(), method2);
                return method2;
            }
        }
        Method[] declaredMethods = tapCallback.getClass().getDeclaredMethods();
        if (declaredMethods.length == 1) {
            return declaredMethods[0];
        }
        throw new AssertionError("-keep class * extends com.koushikdutta.async.TapCallback {\n    *;\n}\n");
    }

    public PushParser noop() {
        this.mWaiting.add(this.noopArgWaiter);
        return this;
    }

    @Override // com.koushikdutta.async.callback.DataCallback
    public void onDataAvailable(DataEmitter dataEmitter, ByteBufferList byteBufferList) {
        byteBufferList.get(this.pending);
        while (this.mWaiting.size() > 0 && this.pending.remaining() >= this.mWaiting.peek().length) {
            this.pending.order(this.order);
            Waiter waiterOnDataAvailable = this.mWaiting.poll().onDataAvailable(dataEmitter, this.pending);
            if (waiterOnDataAvailable != null) {
                this.mWaiting.addFirst(waiterOnDataAvailable);
            }
        }
        if (this.mWaiting.size() == 0) {
            this.pending.get(byteBufferList);
        }
    }

    public PushParser readByte() {
        this.mWaiting.add(this.byteArgWaiter);
        return this;
    }

    public PushParser readByteArray(int i, ParseCallback<byte[]> parseCallback) {
        this.mWaiting.add(new ByteArrayWaiter(i, parseCallback));
        return this;
    }

    public PushParser readByteBufferList(int i, ParseCallback<ByteBufferList> parseCallback) {
        this.mWaiting.add(new ByteBufferListWaiter(i, parseCallback));
        return this;
    }

    public PushParser readInt(ParseCallback<Integer> parseCallback) {
        this.mWaiting.add(new IntWaiter(parseCallback));
        return this;
    }

    public PushParser readLenByteArray() {
        this.mWaiting.add(new LenByteArrayWaiter(this.byteArrayArgCallback));
        return this;
    }

    public PushParser readLenByteBufferList() {
        return readLenByteBufferList(this.byteBufferListArgCallback);
    }

    public PushParser readLong() {
        this.mWaiting.add(this.longArgWaiter);
        return this;
    }

    public PushParser readShort() {
        this.mWaiting.add(this.shortArgWaiter);
        return this;
    }

    public PushParser readString() {
        this.mWaiting.add(new LenByteArrayWaiter(this.stringArgCallback));
        return this;
    }

    public PushParser setOrder(ByteOrder byteOrder) {
        this.order = byteOrder;
        return this;
    }

    public void tap(TapCallback tapCallback) {
        this.mWaiting.add(new TapWaiter(tapCallback));
    }

    public PushParser until(byte b, DataCallback dataCallback) {
        this.mWaiting.add(new UntilWaiter(b, dataCallback));
        return this;
    }

    public PushParser readByteArray(int i) {
        return i == -1 ? readLenByteArray() : readByteArray(i, this.byteArrayArgCallback);
    }

    public PushParser readByteBufferList(int i) {
        return i == -1 ? readLenByteBufferList() : readByteBufferList(i, this.byteBufferListArgCallback);
    }

    public PushParser readInt() {
        this.mWaiting.add(this.intArgWaiter);
        return this;
    }

    public PushParser readLenByteBufferList(ParseCallback<ByteBufferList> parseCallback) {
        this.mWaiting.add(new LenByteBufferListWaiter(parseCallback));
        return this;
    }
}
