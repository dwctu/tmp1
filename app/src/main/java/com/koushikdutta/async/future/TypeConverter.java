package com.koushikdutta.async.future;

/* loaded from: classes3.dex */
public interface TypeConverter<T, F> {
    Future<T> convert(F f, String str) throws Exception;
}
