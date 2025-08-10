package com.koushikdutta.async.future;

import android.text.TextUtils;
import com.koushikdutta.async.ByteBufferList;
import com.koushikdutta.async.future.Converter;
import com.koushikdutta.async.future.Future;
import com.koushikdutta.async.future.SimpleFuture;
import com.koushikdutta.async.future.ThenCallback;
import dc.a91;
import dc.b91;
import dc.c91;
import dc.f91;
import dc.g91;
import dc.h91;
import dc.i91;
import dc.x81;
import dc.y81;
import dc.z81;
import java.io.InvalidObjectException;
import java.nio.ByteBuffer;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class Converter<R> {
    public static final ConverterEntries Converters;
    private static final String MIME_ALL = "*/*";
    public MultiFuture<R> future = new MultiFuture<>();
    public String futureMime;
    public Converters<Object, Object> outputs;

    public static class ConverterEntry<F, T> {
        public int distance;
        public MimedType<F> from;
        public MimedType<T> to;
        public TypeConverter<T, F> typeConverter;

        public ConverterEntry(Class<F> cls, String str, Class<T> cls2, String str2, int i, TypeConverter<T, F> typeConverter) {
            this.from = new MimedType<>(cls, str);
            this.to = new MimedType<>(cls2, str2);
            this.distance = i;
            this.typeConverter = typeConverter;
        }

        public boolean equals(Object obj) {
            ConverterEntry converterEntry = (ConverterEntry) obj;
            return this.from.equals(converterEntry.from) && this.to.equals(converterEntry.to);
        }

        public int hashCode() {
            return this.from.hashCode() ^ this.to.hashCode();
        }
    }

    public static class ConverterTransformers<F, T> extends LinkedHashMap<MimedType<T>, MultiTransformer<T, F>> {
    }

    public static class Converters<F, T> extends EnsureHashMap<MimedType<F>, ConverterTransformers<F, T>> {
        private static <F, T> void add(ConverterTransformers<F, T> converterTransformers, ConverterTransformers<F, T> converterTransformers2) {
            if (converterTransformers2 == null) {
                return;
            }
            converterTransformers.putAll(converterTransformers2);
        }

        public ConverterTransformers<F, T> getAll(MimedType<T> mimedType) {
            ConverterTransformers<F, T> converterTransformers = new ConverterTransformers<>();
            for (MimedType<F> mimedType2 : keySet()) {
                if (mimedType2.isTypeOf(mimedType)) {
                    add(converterTransformers, get(mimedType2));
                }
            }
            return converterTransformers;
        }

        @Override // com.koushikdutta.async.future.Converter.EnsureHashMap
        public ConverterTransformers makeDefault() {
            return new ConverterTransformers();
        }
    }

    public static abstract class EnsureHashMap<K, V> extends LinkedHashMap<K, V> {
        public synchronized V ensure(K k) {
            if (!containsKey(k)) {
                put(k, makeDefault());
            }
            return get(k);
        }

        public abstract V makeDefault();
    }

    public static class MimedData<T> {
        public T data;
        public String mime;

        public MimedData(T t, String str) {
            this.data = t;
            this.mime = str;
        }
    }

    public static class MultiTransformer<T, F> extends MultiTransformFuture<MimedData<Future<T>>, MimedData<Future<F>>> {
        public TypeConverter<T, F> converter;
        public String converterMime;
        public int distance;

        public MultiTransformer(TypeConverter<T, F> typeConverter, String str, int i) {
            this.converter = typeConverter;
            this.converterMime = str;
            this.distance = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: o, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ Future p(String str, Object obj) throws Exception {
            return this.converter.convert(obj, str);
        }

        public static /* synthetic */ void q(MultiFuture multiFuture, Exception exc, Future future) {
            if (exc != null) {
                multiFuture.setComplete(exc);
            } else {
                multiFuture.setComplete(future);
            }
        }

        @Override // com.koushikdutta.async.future.MultiTransformFuture
        public void transform(MimedData<Future<F>> mimedData) {
            final String str = mimedData.mime;
            final MultiFuture multiFuture = new MultiFuture();
            setComplete((MultiTransformer<T, F>) new MimedData(multiFuture, Converter.mimeReplace(str, this.converterMime)));
            mimedData.data.thenConvert(new ThenCallback() { // from class: dc.e91
                @Override // com.koushikdutta.async.future.ThenCallback
                public final Object then(Object obj) {
                    return this.a.p(str, obj);
                }
            }).setCallback(new FutureCallback() { // from class: dc.d91
                @Override // com.koushikdutta.async.future.FutureCallback
                public final void onCompleted(Exception exc, Object obj) {
                    Converter.MultiTransformer.q(multiFuture, exc, (Future) obj);
                }
            });
        }
    }

    public static class PathInfo {
        public MimedType candidate;
        public String mime;
        public MultiTransformer<Object, Object> transformer;

        public static int distance(ArrayDeque<PathInfo> arrayDeque) {
            Iterator<PathInfo> it = arrayDeque.iterator();
            int i = 0;
            while (it.hasNext()) {
                i += it.next().transformer.distance;
            }
            return i;
        }
    }

    static {
        ConverterEntries converterEntries = new ConverterEntries();
        Converters = converterEntries;
        h91 h91Var = new TypeConverter() { // from class: dc.h91
            @Override // com.koushikdutta.async.future.TypeConverter
            public final Future convert(Object obj, String str) {
                return Converter.c((byte[]) obj, str);
            }
        };
        z81 z81Var = new TypeConverter() { // from class: dc.z81
            @Override // com.koushikdutta.async.future.TypeConverter
            public final Future convert(Object obj, String str) {
                return Converter.d((ByteBufferList) obj, str);
            }
        };
        x81 x81Var = new TypeConverter() { // from class: dc.x81
            @Override // com.koushikdutta.async.future.TypeConverter
            public final Future convert(Object obj, String str) {
                return Converter.e((ByteBufferList) obj, str);
            }
        };
        b91 b91Var = new TypeConverter() { // from class: dc.b91
            @Override // com.koushikdutta.async.future.TypeConverter
            public final Future convert(Object obj, String str) {
                return Converter.f((ByteBufferList) obj, str);
            }
        };
        i91 i91Var = new TypeConverter() { // from class: dc.i91
            @Override // com.koushikdutta.async.future.TypeConverter
            public final Future convert(Object obj, String str) {
                return Converter.g((byte[]) obj, str);
            }
        };
        g91 g91Var = new TypeConverter() { // from class: dc.g91
            @Override // com.koushikdutta.async.future.TypeConverter
            public final Future convert(Object obj, String str) {
                return Converter.h((ByteBuffer) obj, str);
            }
        };
        f91 f91Var = new TypeConverter() { // from class: dc.f91
            @Override // com.koushikdutta.async.future.TypeConverter
            public final Future convert(Object obj, String str) {
                return Converter.i((String) obj, str);
            }
        };
        y81 y81Var = new TypeConverter() { // from class: dc.y81
            @Override // com.koushikdutta.async.future.TypeConverter
            public final Future convert(Object obj, String str) {
                return new SimpleFuture((String) obj).thenConvert(new ThenCallback() { // from class: dc.y91
                    @Override // com.koushikdutta.async.future.ThenCallback
                    public final Object then(Object obj2) {
                        return new JSONObject((String) obj2);
                    }
                });
            }
        };
        c91 c91Var = new TypeConverter() { // from class: dc.c91
            @Override // com.koushikdutta.async.future.TypeConverter
            public final Future convert(Object obj, String str) {
                return new SimpleFuture((JSONObject) obj).thenConvert(new ThenCallback() { // from class: dc.x91
                    @Override // com.koushikdutta.async.future.ThenCallback
                    public final Object then(Object obj2) {
                        return ((JSONObject) obj2).toString();
                    }
                });
            }
        };
        a91 a91Var = new TypeConverter() { // from class: dc.a91
            @Override // com.koushikdutta.async.future.TypeConverter
            public final Future convert(Object obj, String str) {
                return Converter.b((byte[]) obj, str);
            }
        };
        converterEntries.addConverter(ByteBuffer.class, null, ByteBufferList.class, null, g91Var);
        converterEntries.addConverter(String.class, null, byte[].class, "text/plain", f91Var);
        converterEntries.addConverter(byte[].class, null, ByteBufferList.class, null, h91Var);
        converterEntries.addConverter(ByteBufferList.class, null, byte[].class, null, z81Var);
        converterEntries.addConverter(ByteBufferList.class, null, ByteBuffer.class, null, x81Var);
        converterEntries.addConverter(ByteBufferList.class, "text/plain", String.class, null, b91Var);
        converterEntries.addConverter(byte[].class, null, ByteBuffer.class, null, i91Var);
        converterEntries.addConverter(String.class, "application/json", JSONObject.class, null, y81Var);
        converterEntries.addConverter(JSONObject.class, null, String.class, "application/json", c91Var);
        converterEntries.addConverter(byte[].class, "text/plain", String.class, null, a91Var);
    }

    public Converter(Future future, String str) {
        this.futureMime = TextUtils.isEmpty(str) ? "*/*" : str;
        this.future.setComplete((Future<R>) future);
    }

    public static /* synthetic */ Future b(byte[] bArr, String str) throws Exception {
        return new SimpleFuture(new String(bArr));
    }

    public static /* synthetic */ Future c(byte[] bArr, String str) throws Exception {
        return new SimpleFuture(new ByteBufferList(ByteBufferList.deepCopy(ByteBuffer.wrap(bArr))));
    }

    public static <T> Converter<T> convert(Future<T> future, String str) {
        return new Converter<>(future, str);
    }

    public static /* synthetic */ Future d(ByteBufferList byteBufferList, String str) throws Exception {
        return new SimpleFuture(byteBufferList.getAllByteArray());
    }

    public static /* synthetic */ Future e(ByteBufferList byteBufferList, String str) throws Exception {
        return new SimpleFuture(byteBufferList.getAll());
    }

    public static /* synthetic */ Future f(ByteBufferList byteBufferList, String str) throws Exception {
        return new SimpleFuture(byteBufferList.peekString());
    }

    public static /* synthetic */ Future g(byte[] bArr, String str) throws Exception {
        return new SimpleFuture(ByteBufferList.deepCopy(ByteBuffer.wrap(bArr)));
    }

    public static /* synthetic */ Future h(ByteBuffer byteBuffer, String str) throws Exception {
        return new SimpleFuture(new ByteBufferList(ByteBufferList.deepCopy(byteBuffer)));
    }

    public static /* synthetic */ Future i(String str, String str2) throws Exception {
        return new SimpleFuture(str.getBytes());
    }

    public static /* synthetic */ Future k(MimedData mimedData) throws Exception {
        return (Future) mimedData.data;
    }

    public static String mimeReplace(String str, String str2) {
        String[] strArrSplit = str2.split("/");
        String[] strArrSplit2 = str.split("/");
        return (!"*".equals(strArrSplit[0]) ? strArrSplit[0] : strArrSplit2[0]) + "/" + (!"*".equals(strArrSplit[1]) ? strArrSplit[1] : strArrSplit2[1]);
    }

    private <T> boolean search(MimedType<T> mimedType, ArrayDeque<PathInfo> arrayDeque, ArrayDeque<PathInfo> arrayDeque2, MimedType mimedType2, HashSet<MimedType> hashSet) {
        if (mimedType.isTypeOf(mimedType2)) {
            arrayDeque.clear();
            arrayDeque.addAll(arrayDeque2);
            return true;
        }
        boolean zSearch = false;
        if ((!arrayDeque.isEmpty() && PathInfo.distance(arrayDeque2) >= PathInfo.distance(arrayDeque)) || hashSet.contains(mimedType2)) {
            return false;
        }
        hashSet.add(mimedType2);
        ConverterTransformers<Object, Object> all = this.outputs.getAll(mimedType2);
        for (MimedType<T> mimedType3 : all.keySet()) {
            MimedType mimedType4 = new MimedType(mimedType3.type, mimeReplace(mimedType2.mime, mimedType3.mime));
            PathInfo pathInfo = new PathInfo();
            pathInfo.transformer = all.get(mimedType3);
            pathInfo.mime = mimedType4.mime;
            pathInfo.candidate = mimedType3;
            arrayDeque2.addLast(pathInfo);
            try {
                zSearch |= search(mimedType, arrayDeque, arrayDeque2, mimedType4, hashSet);
            } finally {
                arrayDeque2.removeLast();
            }
        }
        if (zSearch) {
            hashSet.remove(mimedType2);
        }
        return zSearch;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: to, reason: merged with bridge method [inline-methods] */
    public final synchronized <T> Future<T> m(Object obj, Class<T> cls, String str) {
        if (cls.isInstance(obj)) {
            return new SimpleFuture(obj);
        }
        return to((Class) obj.getClass(), (Class) cls, str);
    }

    public ConverterEntries getConverters() {
        return new ConverterEntries(Converters);
    }

    public static class ConverterEntries {
        public ArrayList<ConverterEntry> list;

        public ConverterEntries() {
            this.list = new ArrayList<>();
        }

        public synchronized <F, T> void addConverter(Class<F> cls, String str, Class<T> cls2, String str2, TypeConverter<T, F> typeConverter) {
            addConverter(cls, str, cls2, str2, 1, typeConverter);
        }

        public synchronized boolean removeConverter(TypeConverter typeConverter) {
            Iterator<ConverterEntry> it = this.list.iterator();
            while (it.hasNext()) {
                ConverterEntry next = it.next();
                if (next.typeConverter == typeConverter) {
                    return this.list.remove(next);
                }
            }
            return false;
        }

        public ConverterEntries(ConverterEntries converterEntries) {
            ArrayList<ConverterEntry> arrayList = new ArrayList<>();
            this.list = arrayList;
            arrayList.addAll(converterEntries.list);
        }

        public synchronized <F, T> void addConverter(Class<F> cls, String str, Class<T> cls2, String str2, int i, TypeConverter<T, F> typeConverter) {
            if (TextUtils.isEmpty(str)) {
                str = "*/*";
            }
            String str3 = str;
            if (TextUtils.isEmpty(str2)) {
                str2 = "*/*";
            }
            this.list.add(new ConverterEntry(cls, str3, cls2, str2, i, typeConverter));
        }
    }

    public static class MimedType<T> {
        public String mime;
        public Class<T> type;

        public MimedType(Class<T> cls, String str) {
            this.type = cls;
            this.mime = str;
        }

        public boolean equals(Object obj) {
            MimedType mimedType = (MimedType) obj;
            return this.type.equals(mimedType.type) && this.mime.equals(mimedType.mime);
        }

        public int hashCode() {
            return this.type.hashCode() ^ this.mime.hashCode();
        }

        public boolean isTypeOf(MimedType mimedType) {
            if (this.type.isAssignableFrom(mimedType.type)) {
                return isTypeOf(mimedType.mime);
            }
            return false;
        }

        public String primary() {
            return this.mime.split("/")[0];
        }

        public String secondary() {
            return this.mime.split("/")[1];
        }

        public String toString() {
            return this.type.getSimpleName() + " " + this.mime;
        }

        public boolean isTypeOf(String str) {
            String[] strArrSplit = str.split("/");
            String[] strArrSplit2 = this.mime.split("/");
            if ("*".equals(strArrSplit2[0]) || strArrSplit[0].equals(strArrSplit2[0])) {
                return "*".equals(strArrSplit2[1]) || strArrSplit[1].equals(strArrSplit2[1]);
            }
            return false;
        }
    }

    public static <T> Converter<T> convert(Future<T> future) {
        return convert(future, null);
    }

    private final synchronized <T> Future<T> to(Class cls, Class<T> cls2, String str) {
        if (TextUtils.isEmpty(str)) {
            str = "*/*";
        }
        if (this.outputs == null) {
            this.outputs = new Converters<>();
            Iterator<ConverterEntry> it = getConverters().list.iterator();
            while (it.hasNext()) {
                ConverterEntry next = it.next();
                this.outputs.ensure(next.from).put(next.to, new MultiTransformer(next.typeConverter, next.to.mime, next.distance));
            }
        }
        MimedType<T> mimedType = new MimedType<>(cls2, str);
        ArrayDeque<PathInfo> arrayDeque = new ArrayDeque<>();
        if (search(mimedType, arrayDeque, new ArrayDeque<>(), new MimedType(cls, this.futureMime), new HashSet<>())) {
            PathInfo pathInfoRemoveFirst = arrayDeque.removeFirst();
            new SimpleFuture(new MimedData(this.future, this.futureMime)).setCallback(pathInfoRemoveFirst.transformer);
            while (!arrayDeque.isEmpty()) {
                PathInfo pathInfoRemoveFirst2 = arrayDeque.removeFirst();
                pathInfoRemoveFirst.transformer.setCallback(pathInfoRemoveFirst2.transformer);
                pathInfoRemoveFirst = pathInfoRemoveFirst2;
            }
            return pathInfoRemoveFirst.transformer.then(new ThenFutureCallback() { // from class: dc.v81
                @Override // com.koushikdutta.async.future.ThenFutureCallback
                public final Future then(Object obj) {
                    return Converter.k((Converter.MimedData) obj);
                }
            });
        }
        return new SimpleFuture((Exception) new InvalidObjectException("unable to find converter"));
    }

    public final <T> Future<T> to(Class<T> cls) {
        return to(cls, null);
    }

    public <T> Future<T> to(final Class<T> cls, final String str) {
        return this.future.then(new ThenFutureCallback() { // from class: dc.w81
            @Override // com.koushikdutta.async.future.ThenFutureCallback
            public final Future then(Object obj) {
                return this.a.m(cls, str, obj);
            }
        });
    }
}
