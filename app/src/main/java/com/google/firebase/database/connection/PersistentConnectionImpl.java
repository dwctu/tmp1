package com.google.firebase.database.connection;

import androidx.core.app.NotificationCompat;
import com.broadcom.bt.util.io.FilenameUtils;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.database.connection.Connection;
import com.google.firebase.database.connection.ConnectionTokenProvider;
import com.google.firebase.database.connection.PersistentConnection;
import com.google.firebase.database.connection.util.RetryHelper;
import com.google.firebase.database.logging.LogWrapper;
import com.google.firebase.database.util.GAuthToken;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import kotlin.text.Typography;
import org.aspectj.runtime.reflect.SignatureImpl;
import org.jivesoftware.smackx.xhtmlim.XHTMLText;

/* loaded from: classes2.dex */
public class PersistentConnectionImpl implements Connection.Delegate, PersistentConnection {
    private static final String IDLE_INTERRUPT_REASON = "connection_idle";
    private static final long IDLE_TIMEOUT = 60000;
    private static final String INVALID_APP_CHECK_TOKEN = "Invalid appcheck token";
    private static final long INVALID_TOKEN_THRESHOLD = 3;
    private static final String REQUEST_ACTION = "a";
    private static final String REQUEST_ACTION_APPCHECK = "appcheck";
    private static final String REQUEST_ACTION_AUTH = "auth";
    private static final String REQUEST_ACTION_GAUTH = "gauth";
    private static final String REQUEST_ACTION_GET = "g";
    private static final String REQUEST_ACTION_MERGE = "m";
    private static final String REQUEST_ACTION_ONDISCONNECT_CANCEL = "oc";
    private static final String REQUEST_ACTION_ONDISCONNECT_MERGE = "om";
    private static final String REQUEST_ACTION_ONDISCONNECT_PUT = "o";
    private static final String REQUEST_ACTION_PUT = "p";
    private static final String REQUEST_ACTION_QUERY = "q";
    private static final String REQUEST_ACTION_QUERY_UNLISTEN = "n";
    private static final String REQUEST_ACTION_STATS = "s";
    private static final String REQUEST_ACTION_UNAPPCHECK = "unappcheck";
    private static final String REQUEST_ACTION_UNAUTH = "unauth";
    private static final String REQUEST_APPCHECK_TOKEN = "token";
    private static final String REQUEST_AUTHVAR = "authvar";
    private static final String REQUEST_COMPOUND_HASH = "ch";
    private static final String REQUEST_COMPOUND_HASH_HASHES = "hs";
    private static final String REQUEST_COMPOUND_HASH_PATHS = "ps";
    private static final String REQUEST_COUNTERS = "c";
    private static final String REQUEST_CREDENTIAL = "cred";
    private static final String REQUEST_DATA_HASH = "h";
    private static final String REQUEST_DATA_PAYLOAD = "d";
    private static final String REQUEST_ERROR = "error";
    private static final String REQUEST_NUMBER = "r";
    private static final String REQUEST_PATH = "p";
    private static final String REQUEST_PAYLOAD = "b";
    private static final String REQUEST_QUERIES = "q";
    private static final String REQUEST_STATUS = "s";
    private static final String REQUEST_TAG = "t";
    private static final String RESPONSE_FOR_REQUEST = "b";
    private static final String SERVER_ASYNC_ACTION = "a";
    private static final String SERVER_ASYNC_APP_CHECK_REVOKED = "apc";
    private static final String SERVER_ASYNC_AUTH_REVOKED = "ac";
    private static final String SERVER_ASYNC_DATA_MERGE = "m";
    private static final String SERVER_ASYNC_DATA_RANGE_MERGE = "rm";
    private static final String SERVER_ASYNC_DATA_UPDATE = "d";
    private static final String SERVER_ASYNC_LISTEN_CANCELLED = "c";
    private static final String SERVER_ASYNC_PAYLOAD = "b";
    private static final String SERVER_ASYNC_SECURITY_DEBUG = "sd";
    private static final String SERVER_DATA_END_PATH = "e";
    private static final String SERVER_DATA_RANGE_MERGE = "m";
    private static final String SERVER_DATA_START_PATH = "s";
    private static final String SERVER_DATA_TAG = "t";
    private static final String SERVER_DATA_UPDATE_BODY = "d";
    private static final String SERVER_DATA_UPDATE_PATH = "p";
    private static final String SERVER_DATA_WARNINGS = "w";
    private static final String SERVER_KILL_INTERRUPT_REASON = "server_kill";
    private static final String SERVER_RESPONSE_DATA = "d";
    private static final long SUCCESSFUL_CONNECTION_ESTABLISHED_DELAY = 30000;
    private static final String TOKEN_REFRESH_INTERRUPT_REASON = "token_refresh";
    private static long connectionIds;
    private String appCheckToken;
    private final ConnectionTokenProvider appCheckTokenProvider;
    private String authToken;
    private final ConnectionTokenProvider authTokenProvider;
    private String cachedHost;
    private final ConnectionContext context;
    private final PersistentConnection.Delegate delegate;
    private final ScheduledExecutorService executorService;
    private boolean forceAppCheckTokenRefresh;
    private boolean forceAuthTokenRefresh;
    private boolean hasOnDisconnects;
    private final HostInfo hostInfo;
    private long lastConnectionEstablishedTime;
    private String lastSessionId;
    private long lastWriteTimestamp;
    private Map<QuerySpec, OutstandingListen> listens;
    private final LogWrapper logger;
    private List<OutstandingDisconnect> onDisconnectRequestQueue;
    private Map<Long, OutstandingGet> outstandingGets;
    private Map<Long, OutstandingPut> outstandingPuts;
    private Connection realtime;
    private Map<Long, ConnectionRequestCallback> requestCBHash;
    private final RetryHelper retryHelper;
    private HashSet<String> interruptReasons = new HashSet<>();
    private boolean firstConnection = true;
    private ConnectionState connectionState = ConnectionState.Disconnected;
    private long writeCounter = 0;
    private long readCounter = 0;
    private long requestCounter = 0;
    private long currentGetTokenAttempt = 0;
    private int invalidAuthTokenCount = 0;
    private int invalidAppCheckTokenCount = 0;
    private ScheduledFuture<?> inactivityTimer = null;

    public interface ConnectionRequestCallback {
        void onResponse(Map<String, Object> map);
    }

    public enum ConnectionState {
        Disconnected,
        GettingToken,
        Connecting,
        Authenticating,
        Connected
    }

    public static class OutstandingDisconnect {
        private final String action;
        private final Object data;
        private final RequestResultCallback onComplete;
        private final List<String> path;

        public String getAction() {
            return this.action;
        }

        public Object getData() {
            return this.data;
        }

        public RequestResultCallback getOnComplete() {
            return this.onComplete;
        }

        public List<String> getPath() {
            return this.path;
        }

        private OutstandingDisconnect(String str, List<String> list, Object obj, RequestResultCallback requestResultCallback) {
            this.action = str;
            this.path = list;
            this.data = obj;
            this.onComplete = requestResultCallback;
        }
    }

    public static class OutstandingGet {
        private final ConnectionRequestCallback onComplete;
        private final Map<String, Object> request;
        private boolean sent;

        /* JADX INFO: Access modifiers changed from: private */
        public ConnectionRequestCallback getOnComplete() {
            return this.onComplete;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Map<String, Object> getRequest() {
            return this.request;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean markSent() {
            if (this.sent) {
                return false;
            }
            this.sent = true;
            return true;
        }

        private OutstandingGet(String str, Map<String, Object> map, ConnectionRequestCallback connectionRequestCallback) {
            this.request = map;
            this.onComplete = connectionRequestCallback;
            this.sent = false;
        }
    }

    public static class OutstandingListen {
        private final ListenHashProvider hashFunction;
        private final QuerySpec query;
        private final RequestResultCallback resultCallback;
        private final Long tag;

        public ListenHashProvider getHashFunction() {
            return this.hashFunction;
        }

        public QuerySpec getQuery() {
            return this.query;
        }

        public Long getTag() {
            return this.tag;
        }

        public String toString() {
            return this.query.toString() + " (Tag: " + this.tag + ")";
        }

        private OutstandingListen(RequestResultCallback requestResultCallback, QuerySpec querySpec, Long l, ListenHashProvider listenHashProvider) {
            this.resultCallback = requestResultCallback;
            this.query = querySpec;
            this.hashFunction = listenHashProvider;
            this.tag = l;
        }
    }

    public static class OutstandingPut {
        private String action;
        private RequestResultCallback onComplete;
        private Map<String, Object> request;
        private boolean sent;

        public String getAction() {
            return this.action;
        }

        public RequestResultCallback getOnComplete() {
            return this.onComplete;
        }

        public Map<String, Object> getRequest() {
            return this.request;
        }

        public void markSent() {
            this.sent = true;
        }

        public boolean wasSent() {
            return this.sent;
        }

        private OutstandingPut(String str, Map<String, Object> map, RequestResultCallback requestResultCallback) {
            this.action = str;
            this.request = map;
            this.onComplete = requestResultCallback;
        }
    }

    public static class QuerySpec {
        private final List<String> path;
        private final Map<String, Object> queryParams;

        public QuerySpec(List<String> list, Map<String, Object> map) {
            this.path = list;
            this.queryParams = map;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof QuerySpec)) {
                return false;
            }
            QuerySpec querySpec = (QuerySpec) obj;
            if (this.path.equals(querySpec.path)) {
                return this.queryParams.equals(querySpec.queryParams);
            }
            return false;
        }

        public int hashCode() {
            return (this.path.hashCode() * 31) + this.queryParams.hashCode();
        }

        public String toString() {
            return ConnectionUtils.pathToString(this.path) + " (params: " + this.queryParams + ")";
        }
    }

    public PersistentConnectionImpl(ConnectionContext connectionContext, HostInfo hostInfo, PersistentConnection.Delegate delegate) {
        this.delegate = delegate;
        this.context = connectionContext;
        ScheduledExecutorService executorService = connectionContext.getExecutorService();
        this.executorService = executorService;
        this.authTokenProvider = connectionContext.getAuthTokenProvider();
        this.appCheckTokenProvider = connectionContext.getAppCheckTokenProvider();
        this.hostInfo = hostInfo;
        this.listens = new HashMap();
        this.requestCBHash = new HashMap();
        this.outstandingPuts = new HashMap();
        this.outstandingGets = new ConcurrentHashMap();
        this.onDisconnectRequestQueue = new ArrayList();
        this.retryHelper = new RetryHelper.Builder(executorService, connectionContext.getLogger(), "ConnectionRetryHelper").withMinDelayAfterFailure(1000L).withRetryExponent(1.3d).withMaxDelay(SUCCESSFUL_CONNECTION_ESTABLISHED_DELAY).withJitterFactor(0.7d).build();
        long j = connectionIds;
        connectionIds = 1 + j;
        this.logger = new LogWrapper(connectionContext.getLogger(), "PersistentConnection", "pc_" + j);
        this.lastSessionId = null;
        doIdleCheck();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void b(QuerySpec querySpec, TaskCompletionSource taskCompletionSource, Map map) {
        if (!((String) map.get("s")).equals("ok")) {
            taskCompletionSource.setException(new Exception((String) map.get(GoogleApiAvailabilityLight.TRACKING_SOURCE_DIALOG)));
            return;
        }
        Object obj = map.get(GoogleApiAvailabilityLight.TRACKING_SOURCE_DIALOG);
        this.delegate.onDataUpdate(querySpec.path, obj, false, null);
        taskCompletionSource.setResult(obj);
    }

    public static /* synthetic */ int access$1008(PersistentConnectionImpl persistentConnectionImpl) {
        int i = persistentConnectionImpl.invalidAuthTokenCount;
        persistentConnectionImpl.invalidAuthTokenCount = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void d(boolean z, Map map) {
        String str = (String) map.get("s");
        if (str.equals("ok")) {
            this.invalidAppCheckTokenCount = 0;
        } else {
            this.appCheckToken = null;
            this.forceAppCheckTokenRefresh = true;
            String str2 = (String) map.get(GoogleApiAvailabilityLight.TRACKING_SOURCE_DIALOG);
            this.logger.debug("App check failed: " + str + " (" + str2 + ")", new Object[0]);
        }
        if (z) {
            restoreState();
        }
    }

    private boolean canSendReads() {
        return this.connectionState == ConnectionState.Connected;
    }

    private boolean canSendWrites() {
        return this.connectionState == ConnectionState.Connected;
    }

    private void cancelSentTransactions() {
        ArrayList arrayList = new ArrayList();
        Iterator<Map.Entry<Long, OutstandingPut>> it = this.outstandingPuts.entrySet().iterator();
        while (it.hasNext()) {
            OutstandingPut value = it.next().getValue();
            if (value.getRequest().containsKey("h") && value.wasSent()) {
                arrayList.add(value);
                it.remove();
            }
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            ((OutstandingPut) it2.next()).getOnComplete().onRequestResult("disconnected", null);
        }
    }

    private boolean connected() {
        ConnectionState connectionState = this.connectionState;
        return connectionState == ConnectionState.Authenticating || connectionState == ConnectionState.Connected;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doIdleCheck() {
        if (isIdle()) {
            ScheduledFuture<?> scheduledFuture = this.inactivityTimer;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(false);
            }
            this.inactivityTimer = this.executorService.schedule(new Runnable() { // from class: com.google.firebase.database.connection.PersistentConnectionImpl.9
                @Override // java.lang.Runnable
                public void run() {
                    PersistentConnectionImpl.this.inactivityTimer = null;
                    if (PersistentConnectionImpl.this.idleHasTimedOut()) {
                        PersistentConnectionImpl.this.interrupt(PersistentConnectionImpl.IDLE_INTERRUPT_REASON);
                    } else {
                        PersistentConnectionImpl.this.doIdleCheck();
                    }
                }
            }, 60000L, TimeUnit.MILLISECONDS);
            return;
        }
        if (isInterrupted(IDLE_INTERRUPT_REASON)) {
            ConnectionUtils.hardAssert(!isIdle());
            resume(IDLE_INTERRUPT_REASON);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void f(long j, Task task, Task task2, Void r8) {
        if (j != this.currentGetTokenAttempt) {
            this.logger.debug("Ignoring getToken result, because this was not the latest attempt.", new Object[0]);
            return;
        }
        ConnectionState connectionState = this.connectionState;
        if (connectionState == ConnectionState.GettingToken) {
            this.logger.debug("Successfully fetched token, opening connection", new Object[0]);
            openNetworkConnection((String) task.getResult(), (String) task2.getResult());
        } else if (connectionState == ConnectionState.Disconnected) {
            this.logger.debug("Not opening connection after token refresh, because connection was set to disconnected", new Object[0]);
        }
    }

    private Task<String> fetchAppCheckToken(boolean z) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.logger.debug("Trying to fetch app check token", new Object[0]);
        this.appCheckTokenProvider.getToken(z, new ConnectionTokenProvider.GetTokenCallback() { // from class: com.google.firebase.database.connection.PersistentConnectionImpl.2
            @Override // com.google.firebase.database.connection.ConnectionTokenProvider.GetTokenCallback
            public void onError(String str) {
                taskCompletionSource.setException(new Exception(str));
            }

            @Override // com.google.firebase.database.connection.ConnectionTokenProvider.GetTokenCallback
            public void onSuccess(String str) {
                taskCompletionSource.setResult(str);
            }
        });
        return taskCompletionSource.getTask();
    }

    private Task<String> fetchAuthToken(boolean z) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.logger.debug("Trying to fetch auth token", new Object[0]);
        this.authTokenProvider.getToken(z, new ConnectionTokenProvider.GetTokenCallback() { // from class: com.google.firebase.database.connection.PersistentConnectionImpl.1
            @Override // com.google.firebase.database.connection.ConnectionTokenProvider.GetTokenCallback
            public void onError(String str) {
                taskCompletionSource.setException(new Exception(str));
            }

            @Override // com.google.firebase.database.connection.ConnectionTokenProvider.GetTokenCallback
            public void onSuccess(String str) {
                taskCompletionSource.setResult(str);
            }
        });
        return taskCompletionSource.getTask();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void h(long j, Exception exc) {
        if (j != this.currentGetTokenAttempt) {
            this.logger.debug("Ignoring getToken error, because this was not the latest attempt.", new Object[0]);
            return;
        }
        this.connectionState = ConnectionState.Disconnected;
        this.logger.debug("Error fetching token: " + exc, new Object[0]);
        tryScheduleReconnect();
    }

    private Map<String, Object> getPutObject(List<String> list, Object obj, String str) {
        HashMap map = new HashMap();
        map.put("p", ConnectionUtils.pathToString(list));
        map.put(GoogleApiAvailabilityLight.TRACKING_SOURCE_DIALOG, obj);
        if (str != null) {
            map.put("h", str);
        }
        return map;
    }

    private void handleTimestamp(long j) {
        if (this.logger.logsDebug()) {
            this.logger.debug("handling timestamp", new Object[0]);
        }
        long jCurrentTimeMillis = j - System.currentTimeMillis();
        HashMap map = new HashMap();
        map.put(Constants.DOT_INFO_SERVERTIME_OFFSET, Long.valueOf(jCurrentTimeMillis));
        this.delegate.onServerInfoUpdate(map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void j(boolean z, boolean z2) {
        ConnectionState connectionState = this.connectionState;
        ConnectionUtils.hardAssert(connectionState == ConnectionState.Disconnected, "Not in disconnected state: %s", connectionState);
        this.connectionState = ConnectionState.GettingToken;
        final long j = this.currentGetTokenAttempt + 1;
        this.currentGetTokenAttempt = j;
        final Task<String> taskFetchAuthToken = fetchAuthToken(z);
        final Task<String> taskFetchAppCheckToken = fetchAppCheckToken(z2);
        Tasks.whenAll((Task<?>[]) new Task[]{taskFetchAuthToken, taskFetchAppCheckToken}).addOnSuccessListener(this.executorService, new OnSuccessListener() { // from class: dc.i21
            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final void onSuccess(Object obj) {
                this.a.f(j, taskFetchAuthToken, taskFetchAppCheckToken, (Void) obj);
            }
        }).addOnFailureListener(this.executorService, new OnFailureListener() { // from class: dc.g21
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception exc) {
                this.a.h(j, exc);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean idleHasTimedOut() {
        return isIdle() && System.currentTimeMillis() > this.lastWriteTimestamp + 60000;
    }

    private boolean isIdle() {
        return this.listens.isEmpty() && this.outstandingGets.isEmpty() && this.requestCBHash.isEmpty() && !this.hasOnDisconnects && this.outstandingPuts.isEmpty();
    }

    private long nextRequestNumber() {
        long j = this.requestCounter;
        this.requestCounter = 1 + j;
        return j;
    }

    private void onAppCheckRevoked(String str, String str2) {
        this.logger.debug("App check token revoked: " + str + " (" + str2 + ")", new Object[0]);
        this.appCheckToken = null;
        this.forceAppCheckTokenRefresh = true;
    }

    private void onAuthRevoked(String str, String str2) {
        this.logger.debug("Auth token revoked: " + str + " (" + str2 + ")", new Object[0]);
        this.authToken = null;
        this.forceAuthTokenRefresh = true;
        this.delegate.onConnectionStatus(false);
        this.realtime.close();
    }

    private void onDataPush(String str, Map<String, Object> map) {
        if (this.logger.logsDebug()) {
            this.logger.debug("handleServerMessage: " + str + " " + map, new Object[0]);
        }
        if (str.equals(GoogleApiAvailabilityLight.TRACKING_SOURCE_DIALOG) || str.equals("m")) {
            boolean zEquals = str.equals("m");
            String str2 = (String) map.get("p");
            Object obj = map.get(GoogleApiAvailabilityLight.TRACKING_SOURCE_DIALOG);
            Long lLongFromObject = ConnectionUtils.longFromObject(map.get("t"));
            if (!zEquals || !(obj instanceof Map) || ((Map) obj).size() != 0) {
                this.delegate.onDataUpdate(ConnectionUtils.stringToPath(str2), obj, zEquals, lLongFromObject);
                return;
            }
            if (this.logger.logsDebug()) {
                this.logger.debug("ignoring empty merge for path " + str2, new Object[0]);
                return;
            }
            return;
        }
        if (!str.equals(SERVER_ASYNC_DATA_RANGE_MERGE)) {
            if (str.equals("c")) {
                onListenRevoked(ConnectionUtils.stringToPath((String) map.get("p")));
                return;
            }
            if (str.equals(SERVER_ASYNC_AUTH_REVOKED)) {
                onAuthRevoked((String) map.get("s"), (String) map.get(GoogleApiAvailabilityLight.TRACKING_SOURCE_DIALOG));
                return;
            }
            if (str.equals(SERVER_ASYNC_APP_CHECK_REVOKED)) {
                onAppCheckRevoked((String) map.get("s"), (String) map.get(GoogleApiAvailabilityLight.TRACKING_SOURCE_DIALOG));
                return;
            }
            if (str.equals(SERVER_ASYNC_SECURITY_DEBUG)) {
                onSecurityDebugPacket(map);
                return;
            }
            if (this.logger.logsDebug()) {
                this.logger.debug("Unrecognized action from server: " + str, new Object[0]);
                return;
            }
            return;
        }
        String str3 = (String) map.get("p");
        List<String> listStringToPath = ConnectionUtils.stringToPath(str3);
        Object obj2 = map.get(GoogleApiAvailabilityLight.TRACKING_SOURCE_DIALOG);
        Long lLongFromObject2 = ConnectionUtils.longFromObject(map.get("t"));
        ArrayList arrayList = new ArrayList();
        for (Map map2 : (List) obj2) {
            String str4 = (String) map2.get("s");
            String str5 = (String) map2.get(SERVER_DATA_END_PATH);
            List<String> listStringToPath2 = null;
            List<String> listStringToPath3 = str4 != null ? ConnectionUtils.stringToPath(str4) : null;
            if (str5 != null) {
                listStringToPath2 = ConnectionUtils.stringToPath(str5);
            }
            arrayList.add(new RangeMerge(listStringToPath3, listStringToPath2, map2.get("m")));
        }
        if (!arrayList.isEmpty()) {
            this.delegate.onRangeMergeUpdate(listStringToPath, arrayList, lLongFromObject2);
            return;
        }
        if (this.logger.logsDebug()) {
            this.logger.debug("Ignoring empty range merge for path " + str3, new Object[0]);
        }
    }

    private void onListenRevoked(List<String> list) {
        Collection<OutstandingListen> collectionRemoveListens = removeListens(list);
        if (collectionRemoveListens != null) {
            Iterator<OutstandingListen> it = collectionRemoveListens.iterator();
            while (it.hasNext()) {
                it.next().resultCallback.onRequestResult("permission_denied", null);
            }
        }
    }

    private void onSecurityDebugPacket(Map<String, Object> map) {
        this.logger.info((String) map.get(NotificationCompat.CATEGORY_MESSAGE));
    }

    private void putInternal(String str, List<String> list, Object obj, String str2, RequestResultCallback requestResultCallback) {
        Map<String, Object> putObject = getPutObject(list, obj, str2);
        long j = this.writeCounter;
        this.writeCounter = 1 + j;
        this.outstandingPuts.put(Long.valueOf(j), new OutstandingPut(str, putObject, requestResultCallback));
        if (canSendWrites()) {
            sendPut(j);
        }
        this.lastWriteTimestamp = System.currentTimeMillis();
        doIdleCheck();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public OutstandingListen removeListen(QuerySpec querySpec) {
        if (this.logger.logsDebug()) {
            this.logger.debug("removing query " + querySpec, new Object[0]);
        }
        if (this.listens.containsKey(querySpec)) {
            OutstandingListen outstandingListen = this.listens.get(querySpec);
            this.listens.remove(querySpec);
            doIdleCheck();
            return outstandingListen;
        }
        if (!this.logger.logsDebug()) {
            return null;
        }
        this.logger.debug("Trying to remove listener for QuerySpec " + querySpec + " but no listener exists.", new Object[0]);
        return null;
    }

    private Collection<OutstandingListen> removeListens(List<String> list) {
        if (this.logger.logsDebug()) {
            this.logger.debug("removing all listens at path " + list, new Object[0]);
        }
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<QuerySpec, OutstandingListen> entry : this.listens.entrySet()) {
            QuerySpec key = entry.getKey();
            OutstandingListen value = entry.getValue();
            if (key.path.equals(list)) {
                arrayList.add(value);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            this.listens.remove(((OutstandingListen) it.next()).getQuery());
        }
        doIdleCheck();
        return arrayList;
    }

    private void restoreState() {
        ConnectionState connectionState = this.connectionState;
        ConnectionUtils.hardAssert(connectionState == ConnectionState.Connected, "Should be connected if we're restoring state, but we are: %s", connectionState);
        if (this.logger.logsDebug()) {
            this.logger.debug("Restoring outstanding listens", new Object[0]);
        }
        for (OutstandingListen outstandingListen : this.listens.values()) {
            if (this.logger.logsDebug()) {
                this.logger.debug("Restoring listen " + outstandingListen.getQuery(), new Object[0]);
            }
            sendListen(outstandingListen);
        }
        if (this.logger.logsDebug()) {
            this.logger.debug("Restoring writes.", new Object[0]);
        }
        ArrayList arrayList = new ArrayList(this.outstandingPuts.keySet());
        Collections.sort(arrayList);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            sendPut(((Long) it.next()).longValue());
        }
        for (OutstandingDisconnect outstandingDisconnect : this.onDisconnectRequestQueue) {
            sendOnDisconnect(outstandingDisconnect.getAction(), outstandingDisconnect.getPath(), outstandingDisconnect.getData(), outstandingDisconnect.getOnComplete());
        }
        this.onDisconnectRequestQueue.clear();
        if (this.logger.logsDebug()) {
            this.logger.debug("Restoring reads.", new Object[0]);
        }
        ArrayList arrayList2 = new ArrayList(this.outstandingGets.keySet());
        Collections.sort(arrayList2);
        Iterator it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            sendGet((Long) it2.next());
        }
    }

    private void restoreTokens() {
        if (this.logger.logsDebug()) {
            this.logger.debug("calling restore tokens", new Object[0]);
        }
        ConnectionState connectionState = this.connectionState;
        ConnectionUtils.hardAssert(connectionState == ConnectionState.Connecting, "Wanted to restore tokens, but was in wrong state: %s", connectionState);
        if (this.authToken != null) {
            if (this.logger.logsDebug()) {
                this.logger.debug("Restoring auth.", new Object[0]);
            }
            this.connectionState = ConnectionState.Authenticating;
            sendAuthAndRestoreState();
            return;
        }
        if (this.logger.logsDebug()) {
            this.logger.debug("Not restoring auth because auth token is null.", new Object[0]);
        }
        this.connectionState = ConnectionState.Connected;
        sendAppCheckTokenHelper(true);
    }

    private void sendAction(String str, Map<String, Object> map, ConnectionRequestCallback connectionRequestCallback) {
        sendSensitive(str, false, map, connectionRequestCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendAppCheckTokenHelper(final boolean z) {
        if (this.appCheckToken == null) {
            restoreState();
            return;
        }
        ConnectionUtils.hardAssert(connected(), "Must be connected to send auth, but was: %s", this.connectionState);
        if (this.logger.logsDebug()) {
            this.logger.debug("Sending app check.", new Object[0]);
        }
        ConnectionRequestCallback connectionRequestCallback = new ConnectionRequestCallback() { // from class: dc.h21
            @Override // com.google.firebase.database.connection.PersistentConnectionImpl.ConnectionRequestCallback
            public final void onResponse(Map map) {
                this.a.d(z, map);
            }
        };
        HashMap map = new HashMap();
        ConnectionUtils.hardAssert(this.appCheckToken != null, "App check token must be set!", new Object[0]);
        map.put(REQUEST_APPCHECK_TOKEN, this.appCheckToken);
        sendSensitive(REQUEST_ACTION_APPCHECK, true, map, connectionRequestCallback);
    }

    private void sendAuthAndRestoreState() {
        sendAuthHelper(true);
    }

    private void sendAuthHelper(final boolean z) {
        ConnectionUtils.hardAssert(connected(), "Must be connected to send auth, but was: %s", this.connectionState);
        if (this.logger.logsDebug()) {
            this.logger.debug("Sending auth.", new Object[0]);
        }
        ConnectionRequestCallback connectionRequestCallback = new ConnectionRequestCallback() { // from class: com.google.firebase.database.connection.PersistentConnectionImpl.4
            @Override // com.google.firebase.database.connection.PersistentConnectionImpl.ConnectionRequestCallback
            public void onResponse(Map<String, Object> map) {
                String str = (String) map.get("s");
                if (str.equals("ok")) {
                    PersistentConnectionImpl.this.connectionState = ConnectionState.Connected;
                    PersistentConnectionImpl.this.invalidAuthTokenCount = 0;
                    PersistentConnectionImpl.this.sendAppCheckTokenHelper(z);
                    return;
                }
                PersistentConnectionImpl.this.authToken = null;
                PersistentConnectionImpl.this.forceAuthTokenRefresh = true;
                PersistentConnectionImpl.this.delegate.onConnectionStatus(false);
                String str2 = (String) map.get(GoogleApiAvailabilityLight.TRACKING_SOURCE_DIALOG);
                PersistentConnectionImpl.this.logger.debug("Authentication failed: " + str + " (" + str2 + ")", new Object[0]);
                PersistentConnectionImpl.this.realtime.close();
                if (str.equals("invalid_token")) {
                    PersistentConnectionImpl.access$1008(PersistentConnectionImpl.this);
                    if (PersistentConnectionImpl.this.invalidAuthTokenCount >= 3) {
                        PersistentConnectionImpl.this.retryHelper.setMaxDelay();
                        PersistentConnectionImpl.this.logger.warn("Provided authentication credentials are invalid. This usually indicates your FirebaseApp instance was not initialized correctly. Make sure your google-services.json file has the correct firebase_url and api_key. You can re-download google-services.json from https://console.firebase.google.com/.");
                    }
                }
            }
        };
        HashMap map = new HashMap();
        GAuthToken gAuthTokenTryParseFromString = GAuthToken.tryParseFromString(this.authToken);
        if (gAuthTokenTryParseFromString == null) {
            map.put(REQUEST_CREDENTIAL, this.authToken);
            sendSensitive("auth", true, map, connectionRequestCallback);
        } else {
            map.put(REQUEST_CREDENTIAL, gAuthTokenTryParseFromString.getToken());
            if (gAuthTokenTryParseFromString.getAuth() != null) {
                map.put(REQUEST_AUTHVAR, gAuthTokenTryParseFromString.getAuth());
            }
            sendSensitive(REQUEST_ACTION_GAUTH, true, map, connectionRequestCallback);
        }
    }

    private void sendConnectStats() {
        HashMap map = new HashMap();
        if (this.context.isPersistenceEnabled()) {
            map.put("persistence.android.enabled", 1);
        }
        map.put("sdk.android." + this.context.getClientSdkVersion().replace(FilenameUtils.EXTENSION_SEPARATOR, SignatureImpl.SEP), 1);
        if (this.logger.logsDebug()) {
            this.logger.debug("Sending first connection stats", new Object[0]);
        }
        sendStats(map);
    }

    private void sendGet(final Long l) {
        ConnectionUtils.hardAssert(canSendReads(), "sendGet called when we can't send gets", new Object[0]);
        final OutstandingGet outstandingGet = this.outstandingGets.get(l);
        if (outstandingGet.markSent() || !this.logger.logsDebug()) {
            sendAction(REQUEST_ACTION_GET, outstandingGet.getRequest(), new ConnectionRequestCallback() { // from class: com.google.firebase.database.connection.PersistentConnectionImpl.6
                @Override // com.google.firebase.database.connection.PersistentConnectionImpl.ConnectionRequestCallback
                public void onResponse(Map<String, Object> map) {
                    if (((OutstandingGet) PersistentConnectionImpl.this.outstandingGets.get(l)) == outstandingGet) {
                        PersistentConnectionImpl.this.outstandingGets.remove(l);
                        outstandingGet.getOnComplete().onResponse(map);
                    } else if (PersistentConnectionImpl.this.logger.logsDebug()) {
                        PersistentConnectionImpl.this.logger.debug("Ignoring on complete for get " + l + " because it was removed already.", new Object[0]);
                    }
                }
            });
            return;
        }
        this.logger.debug("get" + l + " cancelled, ignoring.", new Object[0]);
    }

    private void sendListen(final OutstandingListen outstandingListen) {
        Map<String, Object> map = new HashMap<>();
        map.put("p", ConnectionUtils.pathToString(outstandingListen.getQuery().path));
        Object tag = outstandingListen.getTag();
        if (tag != null) {
            map.put(XHTMLText.Q, outstandingListen.query.queryParams);
            map.put("t", tag);
        }
        ListenHashProvider hashFunction = outstandingListen.getHashFunction();
        map.put("h", hashFunction.getSimpleHash());
        if (hashFunction.shouldIncludeCompoundHash()) {
            CompoundHash compoundHash = hashFunction.getCompoundHash();
            ArrayList arrayList = new ArrayList();
            Iterator<List<String>> it = compoundHash.getPosts().iterator();
            while (it.hasNext()) {
                arrayList.add(ConnectionUtils.pathToString(it.next()));
            }
            HashMap map2 = new HashMap();
            map2.put(REQUEST_COMPOUND_HASH_HASHES, compoundHash.getHashes());
            map2.put(REQUEST_COMPOUND_HASH_PATHS, arrayList);
            map.put(REQUEST_COMPOUND_HASH, map2);
        }
        sendAction(XHTMLText.Q, map, new ConnectionRequestCallback() { // from class: com.google.firebase.database.connection.PersistentConnectionImpl.7
            @Override // com.google.firebase.database.connection.PersistentConnectionImpl.ConnectionRequestCallback
            public void onResponse(Map<String, Object> map3) {
                String str = (String) map3.get("s");
                if (str.equals("ok")) {
                    Map map4 = (Map) map3.get(GoogleApiAvailabilityLight.TRACKING_SOURCE_DIALOG);
                    if (map4.containsKey(PersistentConnectionImpl.SERVER_DATA_WARNINGS)) {
                        PersistentConnectionImpl.this.warnOnListenerWarnings((List) map4.get(PersistentConnectionImpl.SERVER_DATA_WARNINGS), outstandingListen.query);
                    }
                }
                if (((OutstandingListen) PersistentConnectionImpl.this.listens.get(outstandingListen.getQuery())) == outstandingListen) {
                    if (str.equals("ok")) {
                        outstandingListen.resultCallback.onRequestResult(null, null);
                        return;
                    }
                    PersistentConnectionImpl.this.removeListen(outstandingListen.getQuery());
                    outstandingListen.resultCallback.onRequestResult(str, (String) map3.get(GoogleApiAvailabilityLight.TRACKING_SOURCE_DIALOG));
                }
            }
        });
    }

    private void sendOnDisconnect(String str, List<String> list, Object obj, final RequestResultCallback requestResultCallback) {
        HashMap map = new HashMap();
        map.put("p", ConnectionUtils.pathToString(list));
        map.put(GoogleApiAvailabilityLight.TRACKING_SOURCE_DIALOG, obj);
        sendAction(str, map, new ConnectionRequestCallback() { // from class: com.google.firebase.database.connection.PersistentConnectionImpl.3
            @Override // com.google.firebase.database.connection.PersistentConnectionImpl.ConnectionRequestCallback
            public void onResponse(Map<String, Object> map2) {
                String str2 = (String) map2.get("s");
                String str3 = null;
                if (str2.equals("ok")) {
                    str2 = null;
                } else {
                    str3 = (String) map2.get(GoogleApiAvailabilityLight.TRACKING_SOURCE_DIALOG);
                }
                RequestResultCallback requestResultCallback2 = requestResultCallback;
                if (requestResultCallback2 != null) {
                    requestResultCallback2.onRequestResult(str2, str3);
                }
            }
        });
    }

    private void sendPut(final long j) {
        ConnectionUtils.hardAssert(canSendWrites(), "sendPut called when we can't send writes (we're disconnected or writes are paused).", new Object[0]);
        final OutstandingPut outstandingPut = this.outstandingPuts.get(Long.valueOf(j));
        final RequestResultCallback onComplete = outstandingPut.getOnComplete();
        final String action = outstandingPut.getAction();
        outstandingPut.markSent();
        sendAction(action, outstandingPut.getRequest(), new ConnectionRequestCallback() { // from class: com.google.firebase.database.connection.PersistentConnectionImpl.5
            @Override // com.google.firebase.database.connection.PersistentConnectionImpl.ConnectionRequestCallback
            public void onResponse(Map<String, Object> map) {
                if (PersistentConnectionImpl.this.logger.logsDebug()) {
                    PersistentConnectionImpl.this.logger.debug(action + " response: " + map, new Object[0]);
                }
                if (((OutstandingPut) PersistentConnectionImpl.this.outstandingPuts.get(Long.valueOf(j))) == outstandingPut) {
                    PersistentConnectionImpl.this.outstandingPuts.remove(Long.valueOf(j));
                    if (onComplete != null) {
                        String str = (String) map.get("s");
                        if (str.equals("ok")) {
                            onComplete.onRequestResult(null, null);
                        } else {
                            onComplete.onRequestResult(str, (String) map.get(GoogleApiAvailabilityLight.TRACKING_SOURCE_DIALOG));
                        }
                    }
                } else if (PersistentConnectionImpl.this.logger.logsDebug()) {
                    PersistentConnectionImpl.this.logger.debug("Ignoring on complete for put " + j + " because it was removed already.", new Object[0]);
                }
                PersistentConnectionImpl.this.doIdleCheck();
            }
        });
    }

    private void sendSensitive(String str, boolean z, Map<String, Object> map, ConnectionRequestCallback connectionRequestCallback) {
        long jNextRequestNumber = nextRequestNumber();
        HashMap map2 = new HashMap();
        map2.put("r", Long.valueOf(jNextRequestNumber));
        map2.put("a", str);
        map2.put("b", map);
        this.realtime.sendRequest(map2, z);
        this.requestCBHash.put(Long.valueOf(jNextRequestNumber), connectionRequestCallback);
    }

    private void sendStats(Map<String, Integer> map) {
        if (map.isEmpty()) {
            if (this.logger.logsDebug()) {
                this.logger.debug("Not sending stats because stats are empty", new Object[0]);
            }
        } else {
            HashMap map2 = new HashMap();
            map2.put("c", map);
            sendAction("s", map2, new ConnectionRequestCallback() { // from class: com.google.firebase.database.connection.PersistentConnectionImpl.8
                @Override // com.google.firebase.database.connection.PersistentConnectionImpl.ConnectionRequestCallback
                public void onResponse(Map<String, Object> map3) {
                    String str = (String) map3.get("s");
                    if (str.equals("ok")) {
                        return;
                    }
                    String str2 = (String) map3.get(GoogleApiAvailabilityLight.TRACKING_SOURCE_DIALOG);
                    if (PersistentConnectionImpl.this.logger.logsDebug()) {
                        PersistentConnectionImpl.this.logger.debug("Failed to send stats: " + str + " (message: " + str2 + ")", new Object[0]);
                    }
                }
            });
        }
    }

    private void sendUnAppCheck() {
        ConnectionUtils.hardAssert(connected(), "Must be connected to send unauth.", new Object[0]);
        ConnectionUtils.hardAssert(this.appCheckToken == null, "App check token must not be set.", new Object[0]);
        sendAction(REQUEST_ACTION_UNAPPCHECK, Collections.emptyMap(), null);
    }

    private void sendUnauth() {
        ConnectionUtils.hardAssert(connected(), "Must be connected to send unauth.", new Object[0]);
        ConnectionUtils.hardAssert(this.authToken == null, "Auth token must not be set.", new Object[0]);
        sendAction(REQUEST_ACTION_UNAUTH, Collections.emptyMap(), null);
    }

    private void sendUnlisten(OutstandingListen outstandingListen) {
        HashMap map = new HashMap();
        map.put("p", ConnectionUtils.pathToString(outstandingListen.query.path));
        Long tag = outstandingListen.getTag();
        if (tag != null) {
            map.put(XHTMLText.Q, outstandingListen.getQuery().queryParams);
            map.put("t", tag);
        }
        sendAction("n", map, null);
    }

    private void tryScheduleReconnect() {
        if (shouldReconnect()) {
            ConnectionState connectionState = this.connectionState;
            ConnectionUtils.hardAssert(connectionState == ConnectionState.Disconnected, "Not in disconnected state: %s", connectionState);
            final boolean z = this.forceAuthTokenRefresh;
            final boolean z2 = this.forceAppCheckTokenRefresh;
            this.logger.debug("Scheduling connection attempt", new Object[0]);
            this.forceAuthTokenRefresh = false;
            this.forceAppCheckTokenRefresh = false;
            this.retryHelper.retry(new Runnable() { // from class: dc.e21
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.j(z, z2);
                }
            });
        }
    }

    private void upgradeAppCheck() {
        sendAppCheckTokenHelper(false);
    }

    private void upgradeAuth() {
        sendAuthHelper(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void warnOnListenerWarnings(List<String> list, QuerySpec querySpec) {
        if (list.contains("no_index")) {
            String str = "\".indexOn\": \"" + querySpec.queryParams.get("i") + Typography.quote;
            this.logger.warn("Using an unspecified index. Your data will be downloaded and filtered on the client. Consider adding '" + str + "' at " + ConnectionUtils.pathToString(querySpec.path) + " to your security and Firebase Database rules for better performance");
        }
    }

    @Override // com.google.firebase.database.connection.PersistentConnection
    public void compareAndPut(List<String> list, Object obj, String str, RequestResultCallback requestResultCallback) {
        putInternal("p", list, obj, str, requestResultCallback);
    }

    @Override // com.google.firebase.database.connection.PersistentConnection
    public Task<Object> get(List<String> list, Map<String, Object> map) {
        final QuerySpec querySpec = new QuerySpec(list, map);
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        long j = this.readCounter;
        this.readCounter = 1 + j;
        HashMap map2 = new HashMap();
        map2.put("p", ConnectionUtils.pathToString(querySpec.path));
        map2.put(XHTMLText.Q, querySpec.queryParams);
        this.outstandingGets.put(Long.valueOf(j), new OutstandingGet(REQUEST_ACTION_GET, map2, new ConnectionRequestCallback() { // from class: dc.f21
            @Override // com.google.firebase.database.connection.PersistentConnectionImpl.ConnectionRequestCallback
            public final void onResponse(Map map3) {
                this.a.b(querySpec, taskCompletionSource, map3);
            }
        }));
        if (canSendReads()) {
            sendGet(Long.valueOf(j));
        }
        doIdleCheck();
        return taskCompletionSource.getTask();
    }

    @Override // com.google.firebase.database.connection.PersistentConnection
    public void initialize() {
        tryScheduleReconnect();
    }

    public void injectConnectionFailure() {
        Connection connection = this.realtime;
        if (connection != null) {
            connection.injectConnectionFailure();
        }
    }

    @Override // com.google.firebase.database.connection.PersistentConnection
    public void interrupt(String str) {
        if (this.logger.logsDebug()) {
            this.logger.debug("Connection interrupted for: " + str, new Object[0]);
        }
        this.interruptReasons.add(str);
        Connection connection = this.realtime;
        if (connection != null) {
            connection.close();
            this.realtime = null;
        } else {
            this.retryHelper.cancel();
            this.connectionState = ConnectionState.Disconnected;
        }
        this.retryHelper.signalSuccess();
    }

    @Override // com.google.firebase.database.connection.PersistentConnection
    public boolean isInterrupted(String str) {
        return this.interruptReasons.contains(str);
    }

    @Override // com.google.firebase.database.connection.PersistentConnection
    public void listen(List<String> list, Map<String, Object> map, ListenHashProvider listenHashProvider, Long l, RequestResultCallback requestResultCallback) {
        QuerySpec querySpec = new QuerySpec(list, map);
        if (this.logger.logsDebug()) {
            this.logger.debug("Listening on " + querySpec, new Object[0]);
        }
        ConnectionUtils.hardAssert(!this.listens.containsKey(querySpec), "listen() called twice for same QuerySpec.", new Object[0]);
        if (this.logger.logsDebug()) {
            this.logger.debug("Adding listen query: " + querySpec, new Object[0]);
        }
        OutstandingListen outstandingListen = new OutstandingListen(requestResultCallback, querySpec, l, listenHashProvider);
        this.listens.put(querySpec, outstandingListen);
        if (connected()) {
            sendListen(outstandingListen);
        }
        doIdleCheck();
    }

    @Override // com.google.firebase.database.connection.PersistentConnection
    public void merge(List<String> list, Map<String, Object> map, RequestResultCallback requestResultCallback) {
        putInternal("m", list, map, null, requestResultCallback);
    }

    @Override // com.google.firebase.database.connection.Connection.Delegate
    public void onCacheHost(String str) {
        this.cachedHost = str;
    }

    @Override // com.google.firebase.database.connection.Connection.Delegate
    public void onDataMessage(Map<String, Object> map) {
        if (map.containsKey("r")) {
            ConnectionRequestCallback connectionRequestCallbackRemove = this.requestCBHash.remove(Long.valueOf(((Integer) map.get("r")).intValue()));
            if (connectionRequestCallbackRemove != null) {
                connectionRequestCallbackRemove.onResponse((Map) map.get("b"));
                return;
            }
            return;
        }
        if (map.containsKey("error")) {
            return;
        }
        if (map.containsKey("a")) {
            onDataPush((String) map.get("a"), (Map) map.get("b"));
            return;
        }
        if (this.logger.logsDebug()) {
            this.logger.debug("Ignoring unknown message: " + map, new Object[0]);
        }
    }

    @Override // com.google.firebase.database.connection.Connection.Delegate
    public void onDisconnect(Connection.DisconnectReason disconnectReason) {
        boolean z = false;
        if (this.logger.logsDebug()) {
            this.logger.debug("Got on disconnect due to " + disconnectReason.name(), new Object[0]);
        }
        this.connectionState = ConnectionState.Disconnected;
        this.realtime = null;
        this.hasOnDisconnects = false;
        this.requestCBHash.clear();
        cancelSentTransactions();
        if (shouldReconnect()) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            long j = this.lastConnectionEstablishedTime;
            long j2 = jCurrentTimeMillis - j;
            if (j > 0 && j2 > SUCCESSFUL_CONNECTION_ESTABLISHED_DELAY) {
                z = true;
            }
            if (disconnectReason == Connection.DisconnectReason.SERVER_RESET || z) {
                this.retryHelper.signalSuccess();
            }
            tryScheduleReconnect();
        }
        this.lastConnectionEstablishedTime = 0L;
        this.delegate.onDisconnect();
    }

    @Override // com.google.firebase.database.connection.PersistentConnection
    public void onDisconnectCancel(List<String> list, RequestResultCallback requestResultCallback) {
        if (canSendWrites()) {
            sendOnDisconnect(REQUEST_ACTION_ONDISCONNECT_CANCEL, list, null, requestResultCallback);
        } else {
            this.onDisconnectRequestQueue.add(new OutstandingDisconnect(REQUEST_ACTION_ONDISCONNECT_CANCEL, list, null, requestResultCallback));
        }
        doIdleCheck();
    }

    @Override // com.google.firebase.database.connection.PersistentConnection
    public void onDisconnectMerge(List<String> list, Map<String, Object> map, RequestResultCallback requestResultCallback) {
        this.hasOnDisconnects = true;
        if (canSendWrites()) {
            sendOnDisconnect(REQUEST_ACTION_ONDISCONNECT_MERGE, list, map, requestResultCallback);
        } else {
            this.onDisconnectRequestQueue.add(new OutstandingDisconnect(REQUEST_ACTION_ONDISCONNECT_MERGE, list, map, requestResultCallback));
        }
        doIdleCheck();
    }

    @Override // com.google.firebase.database.connection.PersistentConnection
    public void onDisconnectPut(List<String> list, Object obj, RequestResultCallback requestResultCallback) {
        this.hasOnDisconnects = true;
        if (canSendWrites()) {
            sendOnDisconnect(REQUEST_ACTION_ONDISCONNECT_PUT, list, obj, requestResultCallback);
        } else {
            this.onDisconnectRequestQueue.add(new OutstandingDisconnect(REQUEST_ACTION_ONDISCONNECT_PUT, list, obj, requestResultCallback));
        }
        doIdleCheck();
    }

    @Override // com.google.firebase.database.connection.Connection.Delegate
    public void onKill(String str) {
        if (str.equals(INVALID_APP_CHECK_TOKEN)) {
            int i = this.invalidAppCheckTokenCount;
            if (i < 3) {
                this.invalidAppCheckTokenCount = i + 1;
                this.logger.warn("Detected invalid AppCheck token. Reconnecting (" + (3 - this.invalidAppCheckTokenCount) + " attempts remaining)");
                return;
            }
        }
        this.logger.warn("Firebase Database connection was forcefully killed by the server. Will not attempt reconnect. Reason: " + str);
        interrupt(SERVER_KILL_INTERRUPT_REASON);
    }

    @Override // com.google.firebase.database.connection.Connection.Delegate
    public void onReady(long j, String str) {
        if (this.logger.logsDebug()) {
            this.logger.debug("onReady", new Object[0]);
        }
        this.lastConnectionEstablishedTime = System.currentTimeMillis();
        handleTimestamp(j);
        if (this.firstConnection) {
            sendConnectStats();
        }
        restoreTokens();
        this.firstConnection = false;
        this.lastSessionId = str;
        this.delegate.onConnect();
    }

    public void openNetworkConnection(String str, String str2) {
        ConnectionState connectionState = this.connectionState;
        ConnectionUtils.hardAssert(connectionState == ConnectionState.GettingToken, "Trying to open network connection while in the wrong state: %s", connectionState);
        if (str == null) {
            this.delegate.onConnectionStatus(false);
        }
        this.authToken = str;
        this.appCheckToken = str2;
        this.connectionState = ConnectionState.Connecting;
        Connection connection = new Connection(this.context, this.hostInfo, this.cachedHost, this, this.lastSessionId, str2);
        this.realtime = connection;
        connection.open();
    }

    @Override // com.google.firebase.database.connection.PersistentConnection
    public void purgeOutstandingWrites() {
        for (OutstandingPut outstandingPut : this.outstandingPuts.values()) {
            if (outstandingPut.onComplete != null) {
                outstandingPut.onComplete.onRequestResult("write_canceled", null);
            }
        }
        for (OutstandingDisconnect outstandingDisconnect : this.onDisconnectRequestQueue) {
            if (outstandingDisconnect.onComplete != null) {
                outstandingDisconnect.onComplete.onRequestResult("write_canceled", null);
            }
        }
        this.outstandingPuts.clear();
        this.onDisconnectRequestQueue.clear();
        if (!connected()) {
            this.hasOnDisconnects = false;
        }
        doIdleCheck();
    }

    @Override // com.google.firebase.database.connection.PersistentConnection
    public void put(List<String> list, Object obj, RequestResultCallback requestResultCallback) {
        putInternal("p", list, obj, null, requestResultCallback);
    }

    @Override // com.google.firebase.database.connection.PersistentConnection
    public void refreshAppCheckToken() {
        this.logger.debug("App check token refresh requested", new Object[0]);
        interrupt(TOKEN_REFRESH_INTERRUPT_REASON);
        resume(TOKEN_REFRESH_INTERRUPT_REASON);
    }

    @Override // com.google.firebase.database.connection.PersistentConnection
    public void refreshAuthToken() {
        this.logger.debug("Auth token refresh requested", new Object[0]);
        interrupt(TOKEN_REFRESH_INTERRUPT_REASON);
        resume(TOKEN_REFRESH_INTERRUPT_REASON);
    }

    @Override // com.google.firebase.database.connection.PersistentConnection
    public void resume(String str) {
        if (this.logger.logsDebug()) {
            this.logger.debug("Connection no longer interrupted for: " + str, new Object[0]);
        }
        this.interruptReasons.remove(str);
        if (shouldReconnect() && this.connectionState == ConnectionState.Disconnected) {
            tryScheduleReconnect();
        }
    }

    public boolean shouldReconnect() {
        return this.interruptReasons.size() == 0;
    }

    @Override // com.google.firebase.database.connection.PersistentConnection
    public void shutdown() {
        interrupt("shutdown");
    }

    @Override // com.google.firebase.database.connection.PersistentConnection
    public void unlisten(List<String> list, Map<String, Object> map) {
        QuerySpec querySpec = new QuerySpec(list, map);
        if (this.logger.logsDebug()) {
            this.logger.debug("unlistening on " + querySpec, new Object[0]);
        }
        OutstandingListen outstandingListenRemoveListen = removeListen(querySpec);
        if (outstandingListenRemoveListen != null && connected()) {
            sendUnlisten(outstandingListenRemoveListen);
        }
        doIdleCheck();
    }

    @Override // com.google.firebase.database.connection.PersistentConnection
    public void refreshAppCheckToken(String str) {
        this.logger.debug("App check token refreshed.", new Object[0]);
        this.appCheckToken = str;
        if (connected()) {
            if (str != null) {
                upgradeAppCheck();
            } else {
                sendUnAppCheck();
            }
        }
    }

    @Override // com.google.firebase.database.connection.PersistentConnection
    public void refreshAuthToken(String str) {
        this.logger.debug("Auth token refreshed.", new Object[0]);
        this.authToken = str;
        if (connected()) {
            if (str != null) {
                upgradeAuth();
            } else {
                sendUnauth();
            }
        }
    }
}
