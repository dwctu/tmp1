package com.google.firebase.messaging;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.google.firebase.messaging.Constants;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.ExecutorService;

/* compiled from: com.google.firebase:firebase-messaging@@21.1.0 */
/* loaded from: classes2.dex */
public class FirebaseMessagingService extends EnhancedIntentService {
    public static final String ACTION_DIRECT_BOOT_REMOTE_INTENT = "com.google.firebase.messaging.RECEIVE_DIRECT_BOOT";
    private static final Queue<String> recentlyReceivedMessageIds = new ArrayDeque(10);

    private boolean alreadyReceivedMessage(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Queue<String> queue = recentlyReceivedMessageIds;
        if (!queue.contains(str)) {
            if (queue.size() >= 10) {
                queue.remove();
            }
            queue.add(str);
            return false;
        }
        if (!Log.isLoggable(Constants.TAG, 3)) {
            return true;
        }
        String strValueOf = String.valueOf(str);
        if (strValueOf.length() != 0) {
            "Received duplicate message: ".concat(strValueOf);
            return true;
        }
        new String("Received duplicate message: ");
        return true;
    }

    private void dispatchMessage(Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras == null) {
            extras = new Bundle();
        }
        extras.remove("androidx.content.wakelockid");
        if (NotificationParams.isNotification(extras)) {
            NotificationParams notificationParams = new NotificationParams(extras);
            ExecutorService executorServiceNewNetworkIOExecutor = FcmExecutors.newNetworkIOExecutor();
            try {
                if (new DisplayNotification(this, notificationParams, executorServiceNewNetworkIOExecutor).handleNotification()) {
                    return;
                }
                executorServiceNewNetworkIOExecutor.shutdown();
                if (MessagingAnalytics.shouldUploadScionMetrics(intent)) {
                    MessagingAnalytics.logNotificationForeground(intent);
                }
            } finally {
                executorServiceNewNetworkIOExecutor.shutdown();
            }
        }
        onMessageReceived(new RemoteMessage(extras));
    }

    private String getMessageId(Intent intent) {
        String stringExtra = intent.getStringExtra(Constants.MessagePayloadKeys.MSGID);
        return stringExtra == null ? intent.getStringExtra(Constants.MessagePayloadKeys.MSGID_SERVER) : stringExtra;
    }

    private void handleMessageIntent(Intent intent) {
        if (alreadyReceivedMessage(intent.getStringExtra(Constants.MessagePayloadKeys.MSGID))) {
            return;
        }
        passMessageIntentToSdk(intent);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:20:0x003c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void passMessageIntentToSdk(android.content.Intent r7) {
        /*
            r6 = this;
            java.lang.String r0 = "message_type"
            java.lang.String r0 = r7.getStringExtra(r0)
            java.lang.String r1 = "gcm"
            if (r0 != 0) goto Lb
            r0 = r1
        Lb:
            int r2 = r0.hashCode()
            r3 = 3
            r4 = 2
            r5 = 1
            switch(r2) {
                case -2062414158: goto L32;
                case 102161: goto L2a;
                case 814694033: goto L20;
                case 814800675: goto L16;
                default: goto L15;
            }
        L15:
            goto L3c
        L16:
            java.lang.String r1 = "send_event"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L3c
            r1 = 2
            goto L3d
        L20:
            java.lang.String r1 = "send_error"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L3c
            r1 = 3
            goto L3d
        L2a:
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L3c
            r1 = 0
            goto L3d
        L32:
            java.lang.String r1 = "deleted_messages"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L3c
            r1 = 1
            goto L3d
        L3c:
            r1 = -1
        L3d:
            if (r1 == 0) goto L78
            if (r1 == r5) goto L74
            if (r1 == r4) goto L6a
            if (r1 == r3) goto L57
            java.lang.String r7 = "Received message with unknown type: "
            int r1 = r0.length()
            if (r1 == 0) goto L51
            r7.concat(r0)
            goto L56
        L51:
            java.lang.String r0 = new java.lang.String
            r0.<init>(r7)
        L56:
            return
        L57:
            java.lang.String r0 = r6.getMessageId(r7)
            com.google.firebase.messaging.SendException r1 = new com.google.firebase.messaging.SendException
            java.lang.String r2 = "error"
            java.lang.String r7 = r7.getStringExtra(r2)
            r1.<init>(r7)
            r6.onSendError(r0, r1)
            return
        L6a:
            java.lang.String r0 = "google.message_id"
            java.lang.String r7 = r7.getStringExtra(r0)
            r6.onMessageSent(r7)
            return
        L74:
            r6.onDeletedMessages()
            return
        L78:
            com.google.firebase.messaging.MessagingAnalytics.logNotificationReceived(r7)
            r6.dispatchMessage(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.messaging.FirebaseMessagingService.passMessageIntentToSdk(android.content.Intent):void");
    }

    @Override // com.google.firebase.messaging.EnhancedIntentService
    public Intent getStartCommandIntent(Intent intent) {
        return ServiceStarter.getInstance().getMessagingEvent();
    }

    @Override // com.google.firebase.messaging.EnhancedIntentService
    public void handleIntent(Intent intent) {
        String action = intent.getAction();
        if ("com.google.android.c2dm.intent.RECEIVE".equals(action) || ACTION_DIRECT_BOOT_REMOTE_INTENT.equals(action)) {
            handleMessageIntent(intent);
            return;
        }
        if ("com.google.firebase.messaging.NEW_TOKEN".equals(action)) {
            onNewToken(intent.getStringExtra("token"));
            return;
        }
        String strValueOf = String.valueOf(intent.getAction());
        if (strValueOf.length() != 0) {
            "Unknown intent action: ".concat(strValueOf);
        } else {
            new String("Unknown intent action: ");
        }
    }

    @WorkerThread
    public void onDeletedMessages() {
    }

    @WorkerThread
    public void onMessageReceived(@NonNull RemoteMessage remoteMessage) {
    }

    @WorkerThread
    public void onMessageSent(@NonNull String str) {
    }

    @WorkerThread
    public void onNewToken(@NonNull String str) {
    }

    @WorkerThread
    public void onSendError(@NonNull String str, @NonNull Exception exc) {
    }
}
