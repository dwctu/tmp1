package com.wear.broadcast;

import androidx.annotation.NonNull;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.wear.util.WearUtils;
import dc.hu3;

/* loaded from: classes3.dex */
public class WearFirebaseInstanceIDService extends FirebaseMessagingService {
    public final void a(String str) {
        hu3.z(this).x0(WearUtils.H0(str));
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        System.out.println("FileIdService.onCreate()!");
    }

    @Override // com.google.firebase.messaging.EnhancedIntentService, android.app.Service
    public void onDestroy() {
        super.onDestroy();
        System.out.println("FileIdService.onDestroy()!");
    }

    @Override // com.google.firebase.messaging.FirebaseMessagingService
    public void onNewToken(@NonNull String str) {
        String token = FirebaseInstanceId.getInstance().getToken();
        String str2 = "Refreshed token: " + token;
        System.out.println("Refreshed token:" + token);
        a(token);
    }
}
