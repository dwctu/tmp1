package com.google.firebase.appcheck;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.FirebaseException;

/* loaded from: classes2.dex */
public abstract class AppCheckTokenResult {
    @Nullable
    public abstract FirebaseException getError();

    @NonNull
    public abstract String getToken();
}
