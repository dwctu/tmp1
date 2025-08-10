package com.google.android.gms.cloudmessaging;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.messaging.Constants;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: com.google.android.gms:play-services-cloud-messaging@@16.0.0 */
/* loaded from: classes2.dex */
public abstract class CloudMessagingReceiver extends BroadcastReceiver {
    private final ExecutorService zza = com.google.android.gms.internal.cloudmessaging.zza.zza().zza(new NamedThreadFactory("firebase-iid-executor"), com.google.android.gms.internal.cloudmessaging.zzf.zza);

    /* compiled from: com.google.android.gms:play-services-cloud-messaging@@16.0.0 */
    public static final class IntentActionKeys {

        @NonNull
        public static final String NOTIFICATION_DISMISS = "com.google.firebase.messaging.NOTIFICATION_DISMISS";

        @NonNull
        public static final String NOTIFICATION_OPEN = "com.google.firebase.messaging.NOTIFICATION_OPEN";

        private IntentActionKeys() {
        }
    }

    /* compiled from: com.google.android.gms:play-services-cloud-messaging@@16.0.0 */
    public static final class IntentKeys {

        @NonNull
        public static final String PENDING_INTENT = "pending_intent";

        @NonNull
        public static final String WRAPPED_INTENT = "wrapped_intent";

        private IntentKeys() {
        }
    }

    @WorkerThread
    private final int zza(@NonNull Context context, @NonNull Intent intent) throws PendingIntent.CanceledException {
        PendingIntent pendingIntent = (PendingIntent) intent.getParcelableExtra(IntentKeys.PENDING_INTENT);
        if (pendingIntent != null) {
            try {
                pendingIntent.send();
            } catch (PendingIntent.CanceledException unused) {
            }
        }
        Bundle extras = intent.getExtras();
        if (extras != null) {
            extras.remove(IntentKeys.PENDING_INTENT);
        } else {
            extras = new Bundle();
        }
        if (IntentActionKeys.NOTIFICATION_OPEN.equals(intent.getAction())) {
            onNotificationOpen(context, extras);
            return -1;
        }
        if (!IntentActionKeys.NOTIFICATION_DISMISS.equals(intent.getAction())) {
            return 500;
        }
        onNotificationDismissed(context, extras);
        return -1;
    }

    @WorkerThread
    private final int zzb(@NonNull Context context, @NonNull Intent intent) {
        Task<Void> taskZza;
        if (intent.getExtras() == null) {
            return 500;
        }
        String stringExtra = intent.getStringExtra(Constants.MessagePayloadKeys.MSGID);
        if (TextUtils.isEmpty(stringExtra)) {
            taskZza = Tasks.forResult(null);
        } else {
            Bundle bundle = new Bundle();
            bundle.putString(Constants.MessagePayloadKeys.MSGID, stringExtra);
            taskZza = zze.zza(context).zza(2, bundle);
        }
        int iOnMessageReceive = onMessageReceive(context, new CloudMessage(intent));
        try {
            Tasks.await(taskZza, TimeUnit.SECONDS.toMillis(1L), TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            String strValueOf = String.valueOf(e);
            StringBuilder sb = new StringBuilder(String.valueOf(strValueOf).length() + 20);
            sb.append("Message ack failed: ");
            sb.append(strValueOf);
            sb.toString();
        }
        return iOnMessageReceive;
    }

    @NonNull
    public Executor getBroadcastExecutor() {
        return this.zza;
    }

    @WorkerThread
    public abstract int onMessageReceive(@NonNull Context context, @NonNull CloudMessage cloudMessage);

    @WorkerThread
    public void onNotificationDismissed(@NonNull Context context, @NonNull Bundle bundle) {
    }

    @WorkerThread
    public void onNotificationOpen(@NonNull Context context, @NonNull Bundle bundle) {
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(@NonNull final Context context, @NonNull final Intent intent) {
        if (intent == null) {
            return;
        }
        final boolean zIsOrderedBroadcast = isOrderedBroadcast();
        final BroadcastReceiver.PendingResult pendingResultGoAsync = goAsync();
        getBroadcastExecutor().execute(new Runnable(this, intent, context, zIsOrderedBroadcast, pendingResultGoAsync) { // from class: com.google.android.gms.cloudmessaging.zzd
            private final CloudMessagingReceiver zza;
            private final Intent zzb;
            private final Context zzc;
            private final boolean zzd;
            private final BroadcastReceiver.PendingResult zze;

            {
                this.zza = this;
                this.zzb = intent;
                this.zzc = context;
                this.zzd = zIsOrderedBroadcast;
                this.zze = pendingResultGoAsync;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zza(this.zzb, this.zzc, this.zzd, this.zze);
            }
        });
    }

    public final /* synthetic */ void zza(Intent intent, Context context, boolean z, BroadcastReceiver.PendingResult pendingResult) {
        int iZzb;
        try {
            Parcelable parcelableExtra = intent.getParcelableExtra(IntentKeys.WRAPPED_INTENT);
            Intent intent2 = parcelableExtra instanceof Intent ? (Intent) parcelableExtra : null;
            if (intent2 != null) {
                iZzb = zza(context, intent2);
            } else {
                iZzb = zzb(context, intent);
            }
            if (z) {
                pendingResult.setResultCode(iZzb);
            }
        } finally {
            pendingResult.finish();
        }
    }
}
