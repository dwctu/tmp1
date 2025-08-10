package dc;

import com.wear.bean.chat.SignalingMessage;
import com.wear.bean.chat.SignalingMessageExtra;
import com.wear.bean.chat.SignalingRequest;
import com.wear.bean.chat.SignalingToyMessage;
import com.wear.util.WearUtils;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.random.Random;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smackx.delay.packet.DelayInformation;
import org.jivesoftware.smackx.receipts.DeliveryReceiptRequest;

/* compiled from: MessageSignalingAction.kt */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002KLB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\u0012J\u0016\u0010\"\u001a\u00020\u001e2\u0006\u0010#\u001a\u00020\t2\u0006\u0010$\u001a\u00020\u0015J\u0016\u0010%\u001a\u00020\u001e2\u0006\u0010#\u001a\u00020\t2\u0006\u0010$\u001a\u00020\u0018J\u0018\u0010&\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\u0012J\u0017\u0010'\u001a\u00020\u001e2\b\u0010#\u001a\u0004\u0018\u00010\u0012H\u0002¢\u0006\u0002\u0010(J\u001a\u0010)\u001a\u00020\u001e2\b\u0010#\u001a\u0004\u0018\u00010\t2\u0006\u0010*\u001a\u00020\u0004H\u0002J\u0012\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010\tH\u0002J\u0010\u0010.\u001a\u00020,2\u0006\u0010/\u001a\u00020\u0013H\u0002J\u0006\u00100\u001a\u00020\u001eJ \u00101\u001a\u00020\u001e2\u0006\u0010-\u001a\u00020\t2\u0006\u0010#\u001a\u00020\u00122\u0006\u0010!\u001a\u00020\u0012H\u0002J\b\u00102\u001a\u00020\u0012H\u0002J\u000e\u00103\u001a\u00020\u001e2\u0006\u0010/\u001a\u00020\u0013J\u000e\u00104\u001a\u00020\u001e2\u0006\u0010/\u001a\u00020\u0013J\u000e\u00105\u001a\u00020\u001e2\u0006\u0010/\u001a\u00020\u0013J\u000e\u00106\u001a\u00020\u001e2\u0006\u0010/\u001a\u00020\u0013J\u000e\u00107\u001a\u00020\u001e2\u0006\u0010/\u001a\u00020\u0013J\u000e\u00108\u001a\u00020\u001e2\u0006\u00109\u001a\u00020:J\u0018\u0010;\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\u0012J\u000e\u0010<\u001a\u00020\u001e2\u0006\u0010#\u001a\u00020\tJ\u0010\u0010=\u001a\u00020\u001e2\u0006\u0010/\u001a\u00020\u0013H\u0002J\u0011\u0010>\u001a\u00020\u001e2\u0006\u0010?\u001a\u00020\u0012H\u0082\u0010J\u000e\u0010@\u001a\u00020\u001e2\u0006\u0010#\u001a\u00020\tJ\u000e\u0010A\u001a\u00020\u001e2\u0006\u0010B\u001a\u00020 J&\u0010C\u001a\u00020\u001e2\u0006\u0010D\u001a\u00020\t2\u0006\u0010-\u001a\u00020\t2\u0006\u0010E\u001a\u00020\t2\u0006\u0010F\u001a\u00020\tJ\u000e\u0010G\u001a\u0004\u0018\u00010H*\u00020\u0013H\u0002J\u0010\u0010I\u001a\u0004\u0018\u00010\t*\u0004\u0018\u00010HH\u0002J\u0010\u0010J\u001a\u0004\u0018\u00010H*\u0004\u0018\u00010\tH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00150\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00180\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u001a0\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u001c0\u0017X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006M"}, d2 = {"Lcom/wear/ui/chat/manager/MessageSignalingAction;", "", "()V", "STATUS_CANCEL", "", "STATUS_IDLE", "STATUS_REFUSE", "STATUS_SENDING", "TAG", "", "manager", "Lcom/wear/ui/chat/manager/ChatMessageManagerImpl;", "getManager", "()Lcom/wear/ui/chat/manager/ChatMessageManagerImpl;", "manager$delegate", "Lkotlin/Lazy;", "messageQueue", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/wear/bean/chat/SignalingMessage;", "receiveMessageHandlers", "Lcom/wear/ui/chat/manager/MessageSignalingAction$ReceiveMessageHandler;", "receiveToyOrderHandler", "", "Lcom/wear/ui/chat/manager/MessageSignalingAction$ReceiveToyOrderHandler;", "sendStatus", "Ljava/util/concurrent/atomic/AtomicInteger;", "timers", "Ljava/util/Timer;", "acceptAction", "", DeliveryReceiptRequest.ELEMENT, "Lcom/wear/bean/chat/SignalingRequest;", DelayInformation.ELEMENT, "addListener", "key", "handler", "addToyOrderListener", "cancelAction", "cancelTimeTask", "(Ljava/lang/Long;)V", "changeStatus", "status", "checkStatus", "", "type", "checkValidation", "message", "clearListeners", "createTimeTask", "generateSynCode", "imSignalingAcceptTc", "imSignalingCancelTc", "imSignalingRejectTc", "imSignalingReqAckTc", "imSignalingReqTc", "imToyOrderTc", "toyMessage", "Lcom/wear/bean/chat/SignalingToyMessage;", "rejectAction", "removeListener", "removeMessageFromQueue", "removeMessageFromQueueParent", "ack", "removeToyOrderListener", "requestAction", "signalingRequest", "sendToyOrder", "userAccountCode", "data", "module", "adaptationSignalingMessageExtra", "Lcom/wear/bean/chat/SignalingMessageExtra;", "signalingMessageToString", "stringToSignalingMessage", "ReceiveMessageHandler", "ReceiveToyOrderHandler", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class ht2 {

    @NotNull
    public static final ht2 a = new ht2();

    @NotNull
    public static final Lazy b = LazyKt__LazyJVMKt.lazy(d.a);

    @NotNull
    public static final ConcurrentHashMap<Long, SignalingMessage> c = new ConcurrentHashMap<>();

    @NotNull
    public static final ConcurrentHashMap<String, a> d = new ConcurrentHashMap<>();

    @NotNull
    public static Map<String, b> e = new LinkedHashMap();

    @NotNull
    public static final Map<String, AtomicInteger> f = new LinkedHashMap();

    @NotNull
    public static final Map<Long, Timer> g = new LinkedHashMap();

    /* compiled from: MessageSignalingAction.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J)\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH&¢\u0006\u0002\u0010\nJ)\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH&¢\u0006\u0002\u0010\nJ)\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH&¢\u0006\u0002\u0010\nJ)\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH&¢\u0006\u0002\u0010\nJ1\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000f\u001a\u00020\u0010H&¢\u0006\u0002\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0013"}, d2 = {"Lcom/wear/ui/chat/manager/MessageSignalingAction$ReceiveMessageHandler;", "", "receiveActionCancel", "", "type", "", "syn", "", "extra", "Lcom/wear/bean/chat/SignalingMessageExtra;", "(Ljava/lang/String;Ljava/lang/Long;Lcom/wear/bean/chat/SignalingMessageExtra;)V", "receiveActionEnd", "receiveActionReject", "receiveActionRequest", "receiveActionStart", "receiveStart", "", "(Ljava/lang/String;Ljava/lang/Long;Lcom/wear/bean/chat/SignalingMessageExtra;Z)V", "receiveActionTimeout", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public interface a {
        void b(@NotNull String str);

        void d(@NotNull String str, @Nullable Long l, @Nullable SignalingMessageExtra signalingMessageExtra, boolean z);

        void e(@NotNull String str, @Nullable Long l, @Nullable SignalingMessageExtra signalingMessageExtra);

        void g(@NotNull String str, @Nullable Long l, @Nullable SignalingMessageExtra signalingMessageExtra);

        void i(@NotNull String str, @Nullable Long l, @Nullable SignalingMessageExtra signalingMessageExtra);
    }

    /* compiled from: MessageSignalingAction.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/wear/ui/chat/manager/MessageSignalingAction$ReceiveToyOrderHandler;", "", "receiveToyOrder", "", "toyMessage", "Lcom/wear/bean/chat/SignalingToyMessage;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public interface b {
        void receiveToyOrder(@NotNull SignalingToyMessage toyMessage);
    }

    /* compiled from: MessageSignalingAction.kt */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/wear/ui/chat/manager/MessageSignalingAction$createTimeTask$1$1", "Ljava/util/TimerTask;", "run", "", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class c extends TimerTask {
        public final /* synthetic */ long a;
        public final /* synthetic */ String b;

        public c(long j, String str) {
            this.a = j;
            this.b = str;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            ht2.c.remove(Long.valueOf(this.a));
            a aVar = (a) ht2.d.get(this.b);
            if (aVar != null) {
                aVar.b(this.b);
            }
            String str = "time out : 超时移除自己，messageQueue=" + ht2.c.keySet();
        }
    }

    /* compiled from: MessageSignalingAction.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/wear/ui/chat/manager/ChatMessageManagerImpl;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class d extends Lambda implements Function0<ft2> {
        public static final d a = new d();

        public d() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final ft2 invoke() {
            return ft2.a;
        }
    }

    public static /* synthetic */ void b(ht2 ht2Var, SignalingRequest signalingRequest, long j, int i, Object obj) {
        if ((i & 2) != 0) {
            j = 5000;
        }
        ht2Var.a(signalingRequest, j);
    }

    public final SignalingMessageExtra A(String str) {
        if (str == null) {
            return null;
        }
        return (SignalingMessageExtra) WearUtils.A.fromJson(str, SignalingMessageExtra.class);
    }

    public final void a(@NotNull SignalingRequest request, long j) {
        Intrinsics.checkNotNullParameter(request, "request");
        Long lValueOf = request.getSyn() != null ? Long.valueOf(request.getSyn().longValue() + 1) : null;
        String appAccountCode = ch3.n().o().getAppAccountCode();
        String userAccountCode = request.getUserAccountCode();
        String type = request.getType();
        long jN = n();
        String strZ = z(request.getExtra());
        SignalingMessageExtra extra = request.getExtra();
        List<String> features = extra != null ? extra.getFeatures() : null;
        Intrinsics.checkNotNullExpressionValue(appAccountCode, "appAccountCode");
        SignalingMessage signalingMessage = new SignalingMessage(userAccountCode, appAccountCode, type, Long.valueOf(jN), lValueOf, strZ, features);
        o().c(signalingMessage);
        if (signalingMessage.getSyn() != null) {
            if (j != 0) {
                String type2 = signalingMessage.getType();
                Long syn = signalingMessage.getSyn();
                Intrinsics.checkNotNull(syn);
                m(type2, syn.longValue(), j);
            }
            ConcurrentHashMap<Long, SignalingMessage> concurrentHashMap = c;
            Long syn2 = signalingMessage.getSyn();
            Intrinsics.checkNotNull(syn2);
            concurrentHashMap.put(syn2, signalingMessage);
        }
    }

    public final SignalingMessageExtra e(SignalingMessage signalingMessage) {
        SignalingMessageExtra signalingMessageExtraA = A(signalingMessage.getExtData());
        List<String> features = signalingMessage.getFeatures();
        if ((features == null || features.isEmpty()) || signalingMessageExtraA != null) {
            if (signalingMessageExtraA != null) {
                signalingMessageExtraA.setFeatures(signalingMessage.getFeatures());
            }
            return signalingMessageExtraA;
        }
        SignalingMessageExtra signalingMessageExtra = new SignalingMessageExtra();
        signalingMessageExtra.setFeatures(signalingMessage.getFeatures());
        return signalingMessageExtra;
    }

    public final void f(@NotNull String key, @NotNull a handler) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(handler, "handler");
        d.put(key, handler);
    }

    public final void g(@NotNull String key, @NotNull b handler) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(handler, "handler");
        e.put(key, handler);
    }

    public final void h(Long l) {
        if (l == null) {
            return;
        }
        Map<Long, Timer> map = g;
        Timer timer = map.get(Long.valueOf(l.longValue() - 1));
        if (timer != null) {
            timer.cancel();
        }
        map.remove(Long.valueOf(l.longValue() - 1));
    }

    public final void i(String str, int i) {
        if (str == null || str.length() == 0) {
            return;
        }
        Map<String, AtomicInteger> map = f;
        if (map.get(str) == null) {
            map.put(str, new AtomicInteger(0));
        }
        AtomicInteger atomicInteger = map.get(str);
        Intrinsics.checkNotNull(atomicInteger);
        atomicInteger.set(i);
        String str2 = "changeStatus: currentStatus is " + i;
    }

    public final boolean j(String str) {
        if (str == null || str.length() == 0) {
            return true;
        }
        Map<String, AtomicInteger> map = f;
        AtomicInteger atomicInteger = map.get(str);
        if (!(atomicInteger != null && atomicInteger.get() == 2)) {
            AtomicInteger atomicInteger2 = map.get(str);
            if (!(atomicInteger2 != null && atomicInteger2.get() == 2)) {
                return false;
            }
        }
        AtomicInteger atomicInteger3 = map.get(str);
        if (atomicInteger3 != null) {
            atomicInteger3.set(0);
        }
        return true;
    }

    public final boolean k(SignalingMessage signalingMessage) {
        if (signalingMessage.getAck() == null) {
            return true;
        }
        Long ack = signalingMessage.getAck();
        Intrinsics.checkNotNull(ack);
        long jLongValue = ack.longValue() - 1;
        ConcurrentHashMap<Long, SignalingMessage> concurrentHashMap = c;
        if (concurrentHashMap.get(Long.valueOf(jLongValue)) != null) {
            return false;
        }
        String str = "checkValidation: oldMessage is null,messageQueue=" + concurrentHashMap.keySet();
        return true;
    }

    public final void l() {
        d.clear();
        e.clear();
    }

    public final void m(String str, long j, long j2) {
        Map<Long, Timer> map = g;
        Timer timer = map.get(Long.valueOf(j));
        if (timer != null) {
            timer.cancel();
        }
        Long lValueOf = Long.valueOf(j);
        Timer timer2 = new Timer();
        timer2.schedule(new c(j, str), j2);
        map.put(lValueOf, timer2);
    }

    public final long n() {
        return Long.parseLong(System.currentTimeMillis() + String.valueOf(RangesKt___RangesKt.random(new IntRange(10000, 99999), Random.INSTANCE)));
    }

    public final ft2 o() {
        return (ft2) b.getValue();
    }

    public final void p(@NotNull SignalingMessage message) {
        Intrinsics.checkNotNullParameter(message, "message");
        if (k(message)) {
            return;
        }
        if (message.getSyn() != null) {
            String str = "imSignalingAcceptTc: 插入数据 :" + message;
            ConcurrentHashMap<Long, SignalingMessage> concurrentHashMap = c;
            Long syn = message.getSyn();
            Intrinsics.checkNotNull(syn);
            concurrentHashMap.put(syn, message);
        }
        h(message.getAck());
        if (j(message.getType())) {
            return;
        }
        SignalingMessageExtra signalingMessageExtraE = e(message);
        a aVar = d.get(message.getType());
        if (aVar != null) {
            aVar.d(message.getType(), message.getSyn(), signalingMessageExtraE, false);
        }
        SignalingMessage signalingMessageCopy$default = SignalingMessage.copy$default(message, null, null, null, null, null, null, null, 127, null);
        Long syn2 = signalingMessageCopy$default.getSyn();
        Intrinsics.checkNotNull(syn2);
        signalingMessageCopy$default.setAck(Long.valueOf(syn2.longValue() + 1));
        v(message);
        signalingMessageCopy$default.setSyn(null);
        o().x(signalingMessageCopy$default);
    }

    public final void q(@NotNull SignalingMessage message) {
        Intrinsics.checkNotNullParameter(message, "message");
        if (k(message)) {
            return;
        }
        h(message.getAck());
        i(message.getType(), 2);
        SignalingMessageExtra signalingMessageExtraE = e(message);
        a aVar = d.get(message.getType());
        if (aVar != null) {
            aVar.i(message.getType(), message.getSyn(), signalingMessageExtraE);
        }
        if (message.getSyn() != null) {
            ConcurrentHashMap<Long, SignalingMessage> concurrentHashMap = c;
            Long syn = message.getSyn();
            Intrinsics.checkNotNull(syn);
            concurrentHashMap.put(syn, message);
        }
        v(message);
    }

    public final void r(@NotNull SignalingMessage message) {
        Intrinsics.checkNotNullParameter(message, "message");
        if (k(message)) {
            return;
        }
        h(message.getAck());
        i(message.getType(), 2);
        SignalingMessageExtra signalingMessageExtraE = e(message);
        a aVar = d.get(message.getType());
        if (aVar != null) {
            aVar.g(message.getType(), message.getSyn(), signalingMessageExtraE);
        }
        if (message.getSyn() != null) {
            ConcurrentHashMap<Long, SignalingMessage> concurrentHashMap = c;
            Long syn = message.getSyn();
            Intrinsics.checkNotNull(syn);
            concurrentHashMap.put(syn, message);
        }
        v(message);
    }

    public final void s(@NotNull SignalingMessage message) {
        Intrinsics.checkNotNullParameter(message, "message");
        if (k(message)) {
            return;
        }
        h(message.getAck());
        if (j(message.getType())) {
            return;
        }
        i(message.getType(), 0);
        SignalingMessageExtra signalingMessageExtraE = e(message);
        a aVar = d.get(message.getType());
        if (aVar != null) {
            aVar.d(message.getType(), message.getSyn(), signalingMessageExtraE, true);
        }
        if (message.getSyn() != null) {
            ConcurrentHashMap<Long, SignalingMessage> concurrentHashMap = c;
            Long syn = message.getSyn();
            Intrinsics.checkNotNull(syn);
            concurrentHashMap.put(syn, message);
        }
        v(message);
    }

    public final void t(@NotNull SignalingMessage message) {
        Intrinsics.checkNotNullParameter(message, "message");
        h(message.getAck());
        if (j(message.getType())) {
            return;
        }
        SignalingMessageExtra signalingMessageExtraE = e(message);
        a aVar = d.get(message.getType());
        if (aVar != null) {
            aVar.e(message.getType(), message.getSyn(), signalingMessageExtraE);
        }
        if (message.getSyn() != null) {
            String str = "imSignalingAcceptTc: 插入数据 :" + message;
            ConcurrentHashMap<Long, SignalingMessage> concurrentHashMap = c;
            Long syn = message.getSyn();
            Intrinsics.checkNotNull(syn);
            concurrentHashMap.put(syn, message);
        }
    }

    public final void u(@NotNull SignalingToyMessage toyMessage) {
        Intrinsics.checkNotNullParameter(toyMessage, "toyMessage");
        b bVar = e.get(toyMessage.getType());
        if (bVar != null) {
            bVar.receiveToyOrder(toyMessage);
        }
    }

    public final void v(SignalingMessage signalingMessage) {
        if (signalingMessage.getSyn() != null) {
            TypeIntrinsics.asMutableMap(c).remove(signalingMessage.getSyn());
        }
        if (signalingMessage.getAck() != null) {
            Long ack = signalingMessage.getAck();
            Intrinsics.checkNotNull(ack);
            w(ack.longValue());
        }
        String str = "removeMessageFromQueue: 移除结果：" + c.keySet();
    }

    public final void w(long j) {
        while (true) {
            SignalingMessage signalingMessageRemove = c.remove(Long.valueOf(j - 1));
            if (signalingMessageRemove == null) {
                return;
            }
            String str = "removeMessageFromQueue: 从消息队列中移除：" + signalingMessageRemove;
            if (signalingMessageRemove.getAck() == null) {
                return;
            }
            Long ack = signalingMessageRemove.getAck();
            Intrinsics.checkNotNull(ack);
            j = ack.longValue() - 1;
        }
    }

    public final void x(@NotNull SignalingRequest signalingRequest) {
        Intrinsics.checkNotNullParameter(signalingRequest, "signalingRequest");
        String appAccountCode = ch3.n().o().getAppAccountCode();
        if (appAccountCode == null) {
            return;
        }
        String userAccountCode = signalingRequest.getUserAccountCode();
        String type = signalingRequest.getType();
        Long lValueOf = Long.valueOf(n());
        String strZ = z(signalingRequest.getExtra());
        SignalingMessageExtra extra = signalingRequest.getExtra();
        SignalingMessage signalingMessage = new SignalingMessage(appAccountCode, userAccountCode, type, lValueOf, null, strZ, extra != null ? extra.getFeatures() : null, 16, null);
        i(signalingMessage.getType(), 1);
        o().t(signalingMessage);
        if (signalingMessage.getSyn() != null) {
            Long timeout = signalingRequest.getTimeout();
            if (timeout == null || timeout.longValue() != 0) {
                String type2 = signalingMessage.getType();
                Long syn = signalingMessage.getSyn();
                Intrinsics.checkNotNull(syn);
                long jLongValue = syn.longValue();
                Long timeout2 = signalingRequest.getTimeout();
                Intrinsics.checkNotNull(timeout2);
                m(type2, jLongValue, timeout2.longValue());
            }
            ConcurrentHashMap<Long, SignalingMessage> concurrentHashMap = c;
            Long syn2 = signalingMessage.getSyn();
            Intrinsics.checkNotNull(syn2);
            concurrentHashMap.put(syn2, signalingMessage);
            String str = "imSignalingAcceptTc: 插入数据 :" + signalingMessage;
        }
    }

    public final void y(@NotNull String userAccountCode, @NotNull String type, @NotNull String data, @NotNull String module) {
        Intrinsics.checkNotNullParameter(userAccountCode, "userAccountCode");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(module, "module");
        o().w(new SignalingToyMessage(ch3.n().o().getAppAccountCode(), userAccountCode, data, null, type, module, null, 72, null));
    }

    public final String z(SignalingMessageExtra signalingMessageExtra) {
        if (signalingMessageExtra == null) {
            return null;
        }
        return WearUtils.A.toJson(signalingMessageExtra);
    }
}
