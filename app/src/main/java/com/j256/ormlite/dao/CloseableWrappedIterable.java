package com.j256.ormlite.dao;

import java.sql.SQLException;

/* loaded from: classes3.dex */
public interface CloseableWrappedIterable<T> extends CloseableIterable<T> {
    void close() throws SQLException;
}
