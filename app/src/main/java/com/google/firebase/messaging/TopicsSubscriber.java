package com.google.firebase.messaging;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import androidx.collection.ArrayMap;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.installations.FirebaseInstallationsApi;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: com.google.firebase:firebase-messaging@@21.1.0 */
/* loaded from: classes2.dex */
public class TopicsSubscriber {
    private static final long MAX_DELAY_SEC = TimeUnit.HOURS.toSeconds(8);
    private final Context context;
    private final FirebaseInstallationsApi firebaseInstallationsApi;
    private final FirebaseMessaging firebaseMessaging;
    private final Metadata metadata;
    private final GmsRpc rpc;
    private final TopicsStore store;
    private final ScheduledExecutorService syncExecutor;

    @GuardedBy("pendingOperations")
    private final Map<String, ArrayDeque<TaskCompletionSource<Void>>> pendingOperations = new ArrayMap();

    @GuardedBy("this")
    private boolean syncScheduledOrRunning = false;

    private TopicsSubscriber(FirebaseMessaging firebaseMessaging, FirebaseInstallationsApi firebaseInstallationsApi, Metadata metadata, TopicsStore topicsStore, GmsRpc gmsRpc, Context context, @NonNull ScheduledExecutorService scheduledExecutorService) {
        this.firebaseMessaging = firebaseMessaging;
        this.firebaseInstallationsApi = firebaseInstallationsApi;
        this.metadata = metadata;
        this.store = topicsStore;
        this.rpc = gmsRpc;
        this.context = context;
        this.syncExecutor = scheduledExecutorService;
    }

    private void addToPendingOperations(TopicOperation topicOperation, TaskCompletionSource<Void> taskCompletionSource) {
        ArrayDeque<TaskCompletionSource<Void>> arrayDeque;
        synchronized (this.pendingOperations) {
            String strSerialize = topicOperation.serialize();
            if (this.pendingOperations.containsKey(strSerialize)) {
                arrayDeque = this.pendingOperations.get(strSerialize);
            } else {
                ArrayDeque<TaskCompletionSource<Void>> arrayDeque2 = new ArrayDeque<>();
                this.pendingOperations.put(strSerialize, arrayDeque2);
                arrayDeque = arrayDeque2;
            }
            arrayDeque.add(taskCompletionSource);
        }
    }

    @WorkerThread
    private static <T> T awaitTask(Task<T> task) throws IOException {
        try {
            return (T) Tasks.await(task, 30L, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e = e;
            throw new IOException(com.google.firebase.iid.GmsRpc.ERROR_SERVICE_NOT_AVAILABLE, e);
        } catch (ExecutionException e2) {
            Throwable cause = e2.getCause();
            if (cause instanceof IOException) {
                throw ((IOException) cause);
            }
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            throw new IOException(e2);
        } catch (TimeoutException e3) {
            e = e3;
            throw new IOException(com.google.firebase.iid.GmsRpc.ERROR_SERVICE_NOT_AVAILABLE, e);
        }
    }

    @WorkerThread
    private void blockingSubscribeToTopic(String str) throws IOException {
        awaitTask(this.rpc.subscribeToTopic((String) awaitTask(this.firebaseInstallationsApi.getId()), this.firebaseMessaging.blockingGetToken(), str));
    }

    @WorkerThread
    private void blockingUnsubscribeFromTopic(String str) throws IOException {
        awaitTask(this.rpc.unsubscribeFromTopic((String) awaitTask(this.firebaseInstallationsApi.getId()), this.firebaseMessaging.blockingGetToken(), str));
    }

    @VisibleForTesting
    public static Task<TopicsSubscriber> createInstance(final FirebaseMessaging firebaseMessaging, final FirebaseInstallationsApi firebaseInstallationsApi, final Metadata metadata, final GmsRpc gmsRpc, final Context context, @NonNull final ScheduledExecutorService scheduledExecutorService) {
        return Tasks.call(scheduledExecutorService, new Callable(context, scheduledExecutorService, firebaseMessaging, firebaseInstallationsApi, metadata, gmsRpc) { // from class: com.google.firebase.messaging.TopicsSubscriber$$Lambda$0
            private final Context arg$1;
            private final ScheduledExecutorService arg$2;
            private final FirebaseMessaging arg$3;
            private final FirebaseInstallationsApi arg$4;
            private final Metadata arg$5;
            private final GmsRpc arg$6;

            {
                this.arg$1 = context;
                this.arg$2 = scheduledExecutorService;
                this.arg$3 = firebaseMessaging;
                this.arg$4 = firebaseInstallationsApi;
                this.arg$5 = metadata;
                this.arg$6 = gmsRpc;
            }

            @Override // java.util.concurrent.Callable
            public Object call() {
                return TopicsSubscriber.lambda$createInstance$0$TopicsSubscriber(this.arg$1, this.arg$2, this.arg$3, this.arg$4, this.arg$5, this.arg$6);
            }
        });
    }

    public static boolean isDebugLogEnabled() {
        return Log.isLoggable(Constants.TAG, 3) || (Build.VERSION.SDK_INT == 23 && Log.isLoggable(Constants.TAG, 3));
    }

    public static final /* synthetic */ TopicsSubscriber lambda$createInstance$0$TopicsSubscriber(Context context, ScheduledExecutorService scheduledExecutorService, FirebaseMessaging firebaseMessaging, FirebaseInstallationsApi firebaseInstallationsApi, Metadata metadata, GmsRpc gmsRpc) throws Exception {
        return new TopicsSubscriber(firebaseMessaging, firebaseInstallationsApi, metadata, TopicsStore.getInstance(context, scheduledExecutorService), gmsRpc, context, scheduledExecutorService);
    }

    private void markCompletePendingOperation(TopicOperation topicOperation) {
        synchronized (this.pendingOperations) {
            String strSerialize = topicOperation.serialize();
            if (this.pendingOperations.containsKey(strSerialize)) {
                ArrayDeque<TaskCompletionSource<Void>> arrayDeque = this.pendingOperations.get(strSerialize);
                TaskCompletionSource<Void> taskCompletionSourcePoll = arrayDeque.poll();
                if (taskCompletionSourcePoll != null) {
                    taskCompletionSourcePoll.setResult(null);
                }
                if (arrayDeque.isEmpty()) {
                    this.pendingOperations.remove(strSerialize);
                }
            }
        }
    }

    private void startSync() {
        if (isSyncScheduledOrRunning()) {
            return;
        }
        syncWithDelaySecondsInternal(0L);
    }

    public boolean hasPendingOperation() {
        return this.store.getNextTopicOperation() != null;
    }

    public synchronized boolean isSyncScheduledOrRunning() {
        return this.syncScheduledOrRunning;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0027  */
    @androidx.annotation.WorkerThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean performTopicOperation(com.google.firebase.messaging.TopicOperation r6) throws java.io.IOException {
        /*
            r5 = this;
            r0 = 0
            java.lang.String r1 = r6.getOperation()     // Catch: java.io.IOException -> Lb6
            int r2 = r1.hashCode()     // Catch: java.io.IOException -> Lb6
            r3 = 83
            r4 = 1
            if (r2 == r3) goto L1d
            r3 = 85
            if (r2 == r3) goto L13
            goto L27
        L13:
            java.lang.String r2 = "U"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L27
            r1 = 1
            goto L28
        L1d:
            java.lang.String r2 = "S"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L27
            r1 = 0
            goto L28
        L27:
            r1 = -1
        L28:
            java.lang.String r2 = " succeeded."
            if (r1 == 0) goto L87
            if (r1 == r4) goto L58
            boolean r1 = isDebugLogEnabled()     // Catch: java.io.IOException -> Lb6
            if (r1 == 0) goto Lb5
            java.lang.String r6 = java.lang.String.valueOf(r6)     // Catch: java.io.IOException -> Lb6
            java.lang.String r1 = java.lang.String.valueOf(r6)     // Catch: java.io.IOException -> Lb6
            int r1 = r1.length()     // Catch: java.io.IOException -> Lb6
            int r1 = r1 + 24
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.io.IOException -> Lb6
            r2.<init>(r1)     // Catch: java.io.IOException -> Lb6
            java.lang.String r1 = "Unknown topic operation"
            r2.append(r1)     // Catch: java.io.IOException -> Lb6
            r2.append(r6)     // Catch: java.io.IOException -> Lb6
            java.lang.String r6 = "."
            r2.append(r6)     // Catch: java.io.IOException -> Lb6
            r2.toString()     // Catch: java.io.IOException -> Lb6
            goto Lb5
        L58:
            java.lang.String r1 = r6.getTopic()     // Catch: java.io.IOException -> Lb6
            r5.blockingUnsubscribeFromTopic(r1)     // Catch: java.io.IOException -> Lb6
            boolean r1 = isDebugLogEnabled()     // Catch: java.io.IOException -> Lb6
            if (r1 == 0) goto Lb5
            java.lang.String r6 = r6.getTopic()     // Catch: java.io.IOException -> Lb6
            java.lang.String r1 = java.lang.String.valueOf(r6)     // Catch: java.io.IOException -> Lb6
            int r1 = r1.length()     // Catch: java.io.IOException -> Lb6
            int r1 = r1 + 35
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.io.IOException -> Lb6
            r3.<init>(r1)     // Catch: java.io.IOException -> Lb6
            java.lang.String r1 = "Unsubscribe from topic: "
            r3.append(r1)     // Catch: java.io.IOException -> Lb6
            r3.append(r6)     // Catch: java.io.IOException -> Lb6
            r3.append(r2)     // Catch: java.io.IOException -> Lb6
            r3.toString()     // Catch: java.io.IOException -> Lb6
            goto Lb5
        L87:
            java.lang.String r1 = r6.getTopic()     // Catch: java.io.IOException -> Lb6
            r5.blockingSubscribeToTopic(r1)     // Catch: java.io.IOException -> Lb6
            boolean r1 = isDebugLogEnabled()     // Catch: java.io.IOException -> Lb6
            if (r1 == 0) goto Lb5
            java.lang.String r6 = r6.getTopic()     // Catch: java.io.IOException -> Lb6
            java.lang.String r1 = java.lang.String.valueOf(r6)     // Catch: java.io.IOException -> Lb6
            int r1 = r1.length()     // Catch: java.io.IOException -> Lb6
            int r1 = r1 + 31
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.io.IOException -> Lb6
            r3.<init>(r1)     // Catch: java.io.IOException -> Lb6
            java.lang.String r1 = "Subscribe to topic: "
            r3.append(r1)     // Catch: java.io.IOException -> Lb6
            r3.append(r6)     // Catch: java.io.IOException -> Lb6
            r3.append(r2)     // Catch: java.io.IOException -> Lb6
            r3.toString()     // Catch: java.io.IOException -> Lb6
        Lb5:
            return r4
        Lb6:
            r6 = move-exception
            java.lang.String r1 = r6.getMessage()
            java.lang.String r2 = "SERVICE_NOT_AVAILABLE"
            boolean r1 = r2.equals(r1)
            if (r1 != 0) goto Ld8
            java.lang.String r1 = r6.getMessage()
            java.lang.String r2 = "INTERNAL_SERVER_ERROR"
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto Ld0
            goto Ld8
        Ld0:
            java.lang.String r1 = r6.getMessage()
            if (r1 != 0) goto Ld7
            return r0
        Ld7:
            throw r6
        Ld8:
            java.lang.String r6 = r6.getMessage()
            java.lang.String r1 = java.lang.String.valueOf(r6)
            int r1 = r1.length()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            int r1 = r1 + 53
            r2.<init>(r1)
            java.lang.String r1 = "Topic operation failed: "
            r2.append(r1)
            r2.append(r6)
            java.lang.String r6 = ". Will retry Topic operation."
            r2.append(r6)
            r2.toString()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.messaging.TopicsSubscriber.performTopicOperation(com.google.firebase.messaging.TopicOperation):boolean");
    }

    public void scheduleSyncTaskWithDelaySeconds(Runnable runnable, long j) {
        this.syncExecutor.schedule(runnable, j, TimeUnit.SECONDS);
    }

    @VisibleForTesting
    public Task<Void> scheduleTopicOperation(TopicOperation topicOperation) {
        this.store.addTopicOperation(topicOperation);
        TaskCompletionSource<Void> taskCompletionSource = new TaskCompletionSource<>();
        addToPendingOperations(topicOperation, taskCompletionSource);
        return taskCompletionSource.getTask();
    }

    public synchronized void setSyncScheduledOrRunning(boolean z) {
        this.syncScheduledOrRunning = z;
    }

    public void startTopicsSyncIfNecessary() {
        if (hasPendingOperation()) {
            startSync();
        }
    }

    public Task<Void> subscribeToTopic(String str) {
        Task<Void> taskScheduleTopicOperation = scheduleTopicOperation(TopicOperation.subscribe(str));
        startTopicsSyncIfNecessary();
        return taskScheduleTopicOperation;
    }

    @WorkerThread
    public boolean syncTopics() throws IOException {
        while (true) {
            synchronized (this) {
                TopicOperation nextTopicOperation = this.store.getNextTopicOperation();
                if (nextTopicOperation == null) {
                    isDebugLogEnabled();
                    return true;
                }
                if (!performTopicOperation(nextTopicOperation)) {
                    return false;
                }
                this.store.removeTopicOperation(nextTopicOperation);
                markCompletePendingOperation(nextTopicOperation);
            }
        }
    }

    public void syncWithDelaySecondsInternal(long j) {
        scheduleSyncTaskWithDelaySeconds(new TopicsSyncTask(this, this.context, this.metadata, Math.min(Math.max(30L, j + j), MAX_DELAY_SEC)), j);
        setSyncScheduledOrRunning(true);
    }

    public Task<Void> unsubscribeFromTopic(String str) {
        Task<Void> taskScheduleTopicOperation = scheduleTopicOperation(TopicOperation.unsubscribe(str));
        startTopicsSyncIfNecessary();
        return taskScheduleTopicOperation;
    }
}
