package com.google.firebase.database;

import androidx.annotation.NonNull;

/* loaded from: classes2.dex */
public interface ValueEventListener {
    void onCancelled(@NonNull DatabaseError databaseError);

    void onDataChange(@NonNull DataSnapshot dataSnapshot);
}
