package com.google.firebase.database;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: classes2.dex */
public interface ChildEventListener {
    void onCancelled(@NonNull DatabaseError databaseError);

    void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String str);

    void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String str);

    void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String str);

    void onChildRemoved(@NonNull DataSnapshot dataSnapshot);
}
