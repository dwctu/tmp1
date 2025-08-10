package com.google.firebase.database;

import androidx.annotation.RestrictTo;

/* loaded from: classes2.dex */
public class DatabaseException extends RuntimeException {
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public DatabaseException(String str) {
        super(str);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public DatabaseException(String str, Throwable th) {
        super(str, th);
    }
}
