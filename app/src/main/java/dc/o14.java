package dc;

import androidx.exifinterface.media.ExifInterface;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import dc.g64;
import dc.h14;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ExceptionsKt__ExceptionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletionHandlerException;
import kotlinx.coroutines.JobCancellationException;
import kotlinx.coroutines.TimeoutCancellationException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smackx.disco.packet.DiscoverItems;
import org.slf4j.helpers.MessageFormatter;

/* compiled from: JobSupport.kt */
@Deprecated(level = DeprecationLevel.ERROR, message = "This is internal API and may be removed in the future releases")
@Metadata(d1 = {"\u0000è\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0001\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0017\u0018\u00002\u00020X2\u00020\u00172\u00020\u007f2\u00030Ã\u0001:\u0006Ò\u0001Ó\u0001Ô\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004J'\u0010\u000b\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ%\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\r2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\u000fH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0015\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005H\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u001a\u0010\u001bJ\u0015\u0010\u001e\u001a\u0004\u0018\u00010\u0005H\u0080@ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ\u0015\u0010\u001f\u001a\u0004\u0018\u00010\u0005H\u0082@ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010\u001dJ\u0019\u0010!\u001a\u00020\u00012\b\u0010 \u001a\u0004\u0018\u00010\rH\u0017¢\u0006\u0004\b!\u0010\"J\u001f\u0010!\u001a\u00020\u00112\u000e\u0010 \u001a\n\u0018\u00010#j\u0004\u0018\u0001`$H\u0016¢\u0006\u0004\b!\u0010%J\u0017\u0010&\u001a\u00020\u00012\b\u0010 \u001a\u0004\u0018\u00010\r¢\u0006\u0004\b&\u0010\"J\u0019\u0010)\u001a\u00020\u00012\b\u0010 \u001a\u0004\u0018\u00010\u0005H\u0000¢\u0006\u0004\b'\u0010(J\u0017\u0010*\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\rH\u0016¢\u0006\u0004\b*\u0010+J\u001b\u0010,\u001a\u0004\u0018\u00010\u00052\b\u0010 \u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\b,\u0010-J\u0017\u0010.\u001a\u00020\u00012\u0006\u0010 \u001a\u00020\rH\u0002¢\u0006\u0004\b.\u0010\"J\u000f\u00100\u001a\u00020/H\u0014¢\u0006\u0004\b0\u00101J\u0017\u00102\u001a\u00020\u00012\u0006\u0010 \u001a\u00020\rH\u0016¢\u0006\u0004\b2\u0010\"J!\u00105\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u0002032\b\u00104\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\b5\u00106J)\u0010;\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u0002072\u0006\u00109\u001a\u0002082\b\u0010:\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\b;\u0010<J\u0019\u0010=\u001a\u00020\r2\b\u0010 \u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\b=\u0010>J(\u0010C\u001a\u00020@2\n\b\u0002\u0010?\u001a\u0004\u0018\u00010/2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\rH\u0080\b¢\u0006\u0004\bA\u0010BJ#\u0010D\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0014\u001a\u0002072\b\u0010:\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\bD\u0010EJ\u0019\u0010F\u001a\u0004\u0018\u0001082\u0006\u0010\u0014\u001a\u000203H\u0002¢\u0006\u0004\bF\u0010GJ\u0011\u0010H\u001a\u00060#j\u0002`$¢\u0006\u0004\bH\u0010IJ\u0013\u0010J\u001a\u00060#j\u0002`$H\u0016¢\u0006\u0004\bJ\u0010IJ\u0011\u0010M\u001a\u0004\u0018\u00010\u0005H\u0000¢\u0006\u0004\bK\u0010LJ\u000f\u0010N\u001a\u0004\u0018\u00010\r¢\u0006\u0004\bN\u0010OJ'\u0010P\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0014\u001a\u0002072\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\u000fH\u0002¢\u0006\u0004\bP\u0010QJ\u0019\u0010R\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0014\u001a\u000203H\u0002¢\u0006\u0004\bR\u0010SJ\u0017\u0010U\u001a\u00020\u00012\u0006\u0010T\u001a\u00020\rH\u0014¢\u0006\u0004\bU\u0010\"J\u0017\u0010W\u001a\u00020\u00112\u0006\u0010T\u001a\u00020\rH\u0010¢\u0006\u0004\bV\u0010+J\u0019\u0010Z\u001a\u00020\u00112\b\u0010Y\u001a\u0004\u0018\u00010XH\u0004¢\u0006\u0004\bZ\u0010[JF\u0010d\u001a\u00020c2\u0006\u0010\\\u001a\u00020\u00012\u0006\u0010]\u001a\u00020\u00012'\u0010b\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\r¢\u0006\f\b_\u0012\b\b`\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\u00110^j\u0002`a¢\u0006\u0004\bd\u0010eJ6\u0010d\u001a\u00020c2'\u0010b\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\r¢\u0006\f\b_\u0012\b\b`\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\u00110^j\u0002`a¢\u0006\u0004\bd\u0010fJ\u0013\u0010g\u001a\u00020\u0011H\u0086@ø\u0001\u0000¢\u0006\u0004\bg\u0010\u001dJ\u000f\u0010h\u001a\u00020\u0001H\u0002¢\u0006\u0004\bh\u0010iJ\u0013\u0010j\u001a\u00020\u0011H\u0082@ø\u0001\u0000¢\u0006\u0004\bj\u0010\u001dJ&\u0010m\u001a\u00020l2\u0014\u0010k\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\u00110^H\u0082\b¢\u0006\u0004\bm\u0010nJ\u001b\u0010o\u001a\u0004\u0018\u00010\u00052\b\u0010 \u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\bo\u0010-J\u0019\u0010q\u001a\u00020\u00012\b\u0010:\u001a\u0004\u0018\u00010\u0005H\u0000¢\u0006\u0004\bp\u0010(J\u001b\u0010s\u001a\u0004\u0018\u00010\u00052\b\u0010:\u001a\u0004\u0018\u00010\u0005H\u0000¢\u0006\u0004\br\u0010-J@\u0010t\u001a\u00020\t2'\u0010b\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\r¢\u0006\f\b_\u0012\b\b`\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\u00110^j\u0002`a2\u0006\u0010\\\u001a\u00020\u0001H\u0002¢\u0006\u0004\bt\u0010uJ\u000f\u0010w\u001a\u00020/H\u0010¢\u0006\u0004\bv\u00101J\u001f\u0010x\u001a\u00020\u00112\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\rH\u0002¢\u0006\u0004\bx\u0010yJ.\u0010{\u001a\u00020\u0011\"\n\b\u0000\u0010z\u0018\u0001*\u00020\t2\u0006\u0010\b\u001a\u00020\u00072\b\u0010 \u001a\u0004\u0018\u00010\rH\u0082\b¢\u0006\u0004\b{\u0010yJ\u0019\u0010\\\u001a\u00020\u00112\b\u0010 \u001a\u0004\u0018\u00010\rH\u0014¢\u0006\u0004\b\\\u0010+J\u0019\u0010|\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005H\u0014¢\u0006\u0004\b|\u0010\u0016J\u000f\u0010}\u001a\u00020\u0011H\u0014¢\u0006\u0004\b}\u0010~J\u0019\u0010\u0081\u0001\u001a\u00020\u00112\u0007\u0010\u0080\u0001\u001a\u00020\u007f¢\u0006\u0006\b\u0081\u0001\u0010\u0082\u0001J\u001b\u0010\u0084\u0001\u001a\u00020\u00112\u0007\u0010\u0014\u001a\u00030\u0083\u0001H\u0002¢\u0006\u0006\b\u0084\u0001\u0010\u0085\u0001J\u001a\u0010\u0086\u0001\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\tH\u0002¢\u0006\u0006\b\u0086\u0001\u0010\u0087\u0001JI\u0010\u008c\u0001\u001a\u00020\u0011\"\u0005\b\u0000\u0010\u0088\u00012\u000e\u0010\u008a\u0001\u001a\t\u0012\u0004\u0012\u00028\u00000\u0089\u00012\u001d\u0010k\u001a\u0019\b\u0001\u0012\u000b\u0012\t\u0012\u0004\u0012\u00028\u00000\u008b\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00050^ø\u0001\u0000¢\u0006\u0006\b\u008c\u0001\u0010\u008d\u0001JX\u0010\u0091\u0001\u001a\u00020\u0011\"\u0004\b\u0000\u0010z\"\u0005\b\u0001\u0010\u0088\u00012\u000e\u0010\u008a\u0001\u001a\t\u0012\u0004\u0012\u00028\u00010\u0089\u00012$\u0010k\u001a \b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\u000b\u0012\t\u0012\u0004\u0012\u00028\u00010\u008b\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u008e\u0001H\u0000ø\u0001\u0000¢\u0006\u0006\b\u008f\u0001\u0010\u0090\u0001J\u001a\u0010\u0093\u0001\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\tH\u0000¢\u0006\u0006\b\u0092\u0001\u0010\u0087\u0001JX\u0010\u0095\u0001\u001a\u00020\u0011\"\u0004\b\u0000\u0010z\"\u0005\b\u0001\u0010\u0088\u00012\u000e\u0010\u008a\u0001\u001a\t\u0012\u0004\u0012\u00028\u00010\u0089\u00012$\u0010k\u001a \b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\u000b\u0012\t\u0012\u0004\u0012\u00028\u00010\u008b\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u008e\u0001H\u0000ø\u0001\u0000¢\u0006\u0006\b\u0094\u0001\u0010\u0090\u0001J\u000f\u0010\u0096\u0001\u001a\u00020\u0001¢\u0006\u0005\b\u0096\u0001\u0010iJ\u001d\u0010\u0098\u0001\u001a\u00030\u0097\u00012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0006\b\u0098\u0001\u0010\u0099\u0001J\u001c\u0010\u009a\u0001\u001a\u00020/2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0006\b\u009a\u0001\u0010\u009b\u0001J\u0011\u0010\u009c\u0001\u001a\u00020/H\u0007¢\u0006\u0005\b\u009c\u0001\u00101J\u0011\u0010\u009d\u0001\u001a\u00020/H\u0016¢\u0006\u0005\b\u009d\u0001\u00101J$\u0010\u009e\u0001\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u0002032\b\u00104\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0006\b\u009e\u0001\u0010\u009f\u0001J\"\u0010 \u0001\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u0002032\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0006\b \u0001\u0010¡\u0001J(\u0010¢\u0001\u001a\u0004\u0018\u00010\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u00052\b\u0010:\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0006\b¢\u0001\u0010£\u0001J&\u0010¤\u0001\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0014\u001a\u0002032\b\u0010:\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0006\b¤\u0001\u0010¥\u0001J-\u0010¦\u0001\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u0002072\u0006\u0010\u0018\u001a\u0002082\b\u0010:\u001a\u0004\u0018\u00010\u0005H\u0082\u0010¢\u0006\u0006\b¦\u0001\u0010§\u0001J\u0019\u0010©\u0001\u001a\u0004\u0018\u000108*\u00030¨\u0001H\u0002¢\u0006\u0006\b©\u0001\u0010ª\u0001J\u001f\u0010«\u0001\u001a\u00020\u0011*\u00020\u00072\b\u0010 \u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0005\b«\u0001\u0010yJ&\u0010¬\u0001\u001a\u00060#j\u0002`$*\u00020\r2\n\b\u0002\u0010?\u001a\u0004\u0018\u00010/H\u0004¢\u0006\u0006\b¬\u0001\u0010\u00ad\u0001R\u001b\u0010±\u0001\u001a\t\u0012\u0004\u0012\u00020X0®\u00018F¢\u0006\b\u001a\u0006\b¯\u0001\u0010°\u0001R\u0018\u0010³\u0001\u001a\u0004\u0018\u00010\r8DX\u0084\u0004¢\u0006\u0007\u001a\u0005\b²\u0001\u0010OR\u0016\u0010µ\u0001\u001a\u00020\u00018DX\u0084\u0004¢\u0006\u0007\u001a\u0005\b´\u0001\u0010iR\u0016\u0010·\u0001\u001a\u00020\u00018PX\u0090\u0004¢\u0006\u0007\u001a\u0005\b¶\u0001\u0010iR\u0016\u0010¸\u0001\u001a\u00020\u00018VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b¸\u0001\u0010iR\u0013\u0010¹\u0001\u001a\u00020\u00018F¢\u0006\u0007\u001a\u0005\b¹\u0001\u0010iR\u0013\u0010º\u0001\u001a\u00020\u00018F¢\u0006\u0007\u001a\u0005\bº\u0001\u0010iR\u0013\u0010»\u0001\u001a\u00020\u00018F¢\u0006\u0007\u001a\u0005\b»\u0001\u0010iR\u0016\u0010¼\u0001\u001a\u00020\u00018TX\u0094\u0004¢\u0006\u0007\u001a\u0005\b¼\u0001\u0010iR\u0019\u0010À\u0001\u001a\u0007\u0012\u0002\b\u00030½\u00018F¢\u0006\b\u001a\u0006\b¾\u0001\u0010¿\u0001R\u0016\u0010Â\u0001\u001a\u00020\u00018PX\u0090\u0004¢\u0006\u0007\u001a\u0005\bÁ\u0001\u0010iR\u0015\u0010Æ\u0001\u001a\u00030Ã\u00018F¢\u0006\b\u001a\u0006\bÄ\u0001\u0010Å\u0001R.\u0010Ì\u0001\u001a\u0004\u0018\u00010\u00192\t\u0010Ç\u0001\u001a\u0004\u0018\u00010\u00198@@@X\u0080\u000e¢\u0006\u0010\u001a\u0006\bÈ\u0001\u0010É\u0001\"\u0006\bÊ\u0001\u0010Ë\u0001R\u0017\u0010\u0014\u001a\u0004\u0018\u00010\u00058@X\u0080\u0004¢\u0006\u0007\u001a\u0005\bÍ\u0001\u0010LR\u001e\u0010Ï\u0001\u001a\u0004\u0018\u00010\r*\u0004\u0018\u00010\u00058BX\u0082\u0004¢\u0006\u0007\u001a\u0005\bÎ\u0001\u0010>R\u001b\u0010Ð\u0001\u001a\u00020\u0001*\u0002038BX\u0082\u0004¢\u0006\b\u001a\u0006\bÐ\u0001\u0010Ñ\u0001\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006Õ\u0001"}, d2 = {"Lkotlinx/coroutines/JobSupport;", "", AppMeasurementSdk.ConditionalUserProperty.ACTIVE, "<init>", "(Z)V", "", "expect", "Lkotlinx/coroutines/NodeList;", "list", "Lkotlinx/coroutines/JobNode;", "node", "addLastAtomic", "(Ljava/lang/Object;Lkotlinx/coroutines/NodeList;Lkotlinx/coroutines/JobNode;)Z", "", "rootCause", "", "exceptions", "", "addSuppressedExceptions", "(Ljava/lang/Throwable;Ljava/util/List;)V", "state", "afterCompletion", "(Ljava/lang/Object;)V", "Lkotlinx/coroutines/ChildJob;", "child", "Lkotlinx/coroutines/ChildHandle;", "attachChild", "(Lkotlinx/coroutines/ChildJob;)Lkotlinx/coroutines/ChildHandle;", "awaitInternal$kotlinx_coroutines_core", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitInternal", "awaitSuspend", "cause", "cancel", "(Ljava/lang/Throwable;)Z", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "(Ljava/util/concurrent/CancellationException;)V", "cancelCoroutine", "cancelImpl$kotlinx_coroutines_core", "(Ljava/lang/Object;)Z", "cancelImpl", "cancelInternal", "(Ljava/lang/Throwable;)V", "cancelMakeCompleting", "(Ljava/lang/Object;)Ljava/lang/Object;", "cancelParent", "", "cancellationExceptionMessage", "()Ljava/lang/String;", "childCancelled", "Lkotlinx/coroutines/Incomplete;", DiscoverItems.Item.UPDATE_ACTION, "completeStateFinalization", "(Lkotlinx/coroutines/Incomplete;Ljava/lang/Object;)V", "Lkotlinx/coroutines/JobSupport$Finishing;", "Lkotlinx/coroutines/ChildHandleNode;", "lastChild", "proposedUpdate", "continueCompleting", "(Lkotlinx/coroutines/JobSupport$Finishing;Lkotlinx/coroutines/ChildHandleNode;Ljava/lang/Object;)V", "createCauseException", "(Ljava/lang/Object;)Ljava/lang/Throwable;", "message", "Lkotlinx/coroutines/JobCancellationException;", "defaultCancellationException$kotlinx_coroutines_core", "(Ljava/lang/String;Ljava/lang/Throwable;)Lkotlinx/coroutines/JobCancellationException;", "defaultCancellationException", "finalizeFinishingState", "(Lkotlinx/coroutines/JobSupport$Finishing;Ljava/lang/Object;)Ljava/lang/Object;", "firstChild", "(Lkotlinx/coroutines/Incomplete;)Lkotlinx/coroutines/ChildHandleNode;", "getCancellationException", "()Ljava/util/concurrent/CancellationException;", "getChildJobCancellationCause", "getCompletedInternal$kotlinx_coroutines_core", "()Ljava/lang/Object;", "getCompletedInternal", "getCompletionExceptionOrNull", "()Ljava/lang/Throwable;", "getFinalRootCause", "(Lkotlinx/coroutines/JobSupport$Finishing;Ljava/util/List;)Ljava/lang/Throwable;", "getOrPromoteCancellingList", "(Lkotlinx/coroutines/Incomplete;)Lkotlinx/coroutines/NodeList;", "exception", "handleJobException", "handleOnCompletionException$kotlinx_coroutines_core", "handleOnCompletionException", "Lkotlinx/coroutines/Job;", "parent", "initParentJob", "(Lkotlinx/coroutines/Job;)V", "onCancelling", "invokeImmediately", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "Lkotlinx/coroutines/CompletionHandler;", "handler", "Lkotlinx/coroutines/DisposableHandle;", "invokeOnCompletion", "(ZZLkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/DisposableHandle;", "(Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/DisposableHandle;", "join", "joinInternal", "()Z", "joinSuspend", "block", "", "loopOnState", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Void;", "makeCancelling", "makeCompleting$kotlinx_coroutines_core", "makeCompleting", "makeCompletingOnce$kotlinx_coroutines_core", "makeCompletingOnce", "makeNode", "(Lkotlin/jvm/functions/Function1;Z)Lkotlinx/coroutines/JobNode;", "nameString$kotlinx_coroutines_core", "nameString", "notifyCancelling", "(Lkotlinx/coroutines/NodeList;Ljava/lang/Throwable;)V", ExifInterface.GPS_DIRECTION_TRUE, "notifyHandlers", "onCompletionInternal", "onStart", "()V", "Lkotlinx/coroutines/ParentJob;", "parentJob", "parentCancelled", "(Lkotlinx/coroutines/ParentJob;)V", "Lkotlinx/coroutines/Empty;", "promoteEmptyToNodeList", "(Lkotlinx/coroutines/Empty;)V", "promoteSingleToNodeList", "(Lkotlinx/coroutines/JobNode;)V", "R", "Lkotlinx/coroutines/selects/SelectInstance;", "select", "Lkotlin/coroutines/Continuation;", "registerSelectClause0", "(Lkotlinx/coroutines/selects/SelectInstance;Lkotlin/jvm/functions/Function1;)V", "Lkotlin/Function2;", "registerSelectClause1Internal$kotlinx_coroutines_core", "(Lkotlinx/coroutines/selects/SelectInstance;Lkotlin/jvm/functions/Function2;)V", "registerSelectClause1Internal", "removeNode$kotlinx_coroutines_core", "removeNode", "selectAwaitCompletion$kotlinx_coroutines_core", "selectAwaitCompletion", TtmlNode.START, "", "startInternal", "(Ljava/lang/Object;)I", "stateString", "(Ljava/lang/Object;)Ljava/lang/String;", "toDebugString", "toString", "tryFinalizeSimpleState", "(Lkotlinx/coroutines/Incomplete;Ljava/lang/Object;)Z", "tryMakeCancelling", "(Lkotlinx/coroutines/Incomplete;Ljava/lang/Throwable;)Z", "tryMakeCompleting", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "tryMakeCompletingSlowPath", "(Lkotlinx/coroutines/Incomplete;Ljava/lang/Object;)Ljava/lang/Object;", "tryWaitForChild", "(Lkotlinx/coroutines/JobSupport$Finishing;Lkotlinx/coroutines/ChildHandleNode;Ljava/lang/Object;)Z", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "nextChild", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)Lkotlinx/coroutines/ChildHandleNode;", "notifyCompletion", "toCancellationException", "(Ljava/lang/Throwable;Ljava/lang/String;)Ljava/util/concurrent/CancellationException;", "Lkotlin/sequences/Sequence;", "getChildren", "()Lkotlin/sequences/Sequence;", "children", "getCompletionCause", "completionCause", "getCompletionCauseHandled", "completionCauseHandled", "getHandlesException$kotlinx_coroutines_core", "handlesException", "isActive", "isCancelled", "isCompleted", "isCompletedExceptionally", "isScopedCoroutine", "Lkotlin/coroutines/CoroutineContext$Key;", "getKey", "()Lkotlin/coroutines/CoroutineContext$Key;", "key", "getOnCancelComplete$kotlinx_coroutines_core", "onCancelComplete", "Lkotlinx/coroutines/selects/SelectClause0;", "getOnJoin", "()Lkotlinx/coroutines/selects/SelectClause0;", "onJoin", "value", "getParentHandle$kotlinx_coroutines_core", "()Lkotlinx/coroutines/ChildHandle;", "setParentHandle$kotlinx_coroutines_core", "(Lkotlinx/coroutines/ChildHandle;)V", "parentHandle", "getState$kotlinx_coroutines_core", "getExceptionOrNull", "exceptionOrNull", "isCancelling", "(Lkotlinx/coroutines/Incomplete;)Z", "AwaitContinuation", "ChildCompletion", "Finishing", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public class o14 implements h14, gz3, w14 {
    public static final /* synthetic */ AtomicReferenceFieldUpdater a = AtomicReferenceFieldUpdater.newUpdater(o14.class, Object.class, "_state");

    @NotNull
    private volatile /* synthetic */ Object _parentHandle;

    @NotNull
    private volatile /* synthetic */ Object _state;

    /* compiled from: JobSupport.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001b\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\rH\u0014R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lkotlinx/coroutines/JobSupport$AwaitContinuation;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/CancellableContinuationImpl;", "delegate", "Lkotlin/coroutines/Continuation;", "job", "Lkotlinx/coroutines/JobSupport;", "(Lkotlin/coroutines/Continuation;Lkotlinx/coroutines/JobSupport;)V", "getContinuationCancellationCause", "", "parent", "Lkotlinx/coroutines/Job;", "nameString", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a<T> extends zy3<T> {

        @NotNull
        public final o14 i;

        public a(@NotNull Continuation<? super T> continuation, @NotNull o14 o14Var) {
            super(continuation, 1);
            this.i = o14Var;
        }

        @Override // dc.zy3
        @NotNull
        public String G() {
            return "AwaitContinuation";
        }

        @Override // dc.zy3
        @NotNull
        public Throwable w(@NotNull h14 h14Var) {
            Throwable thE;
            Object objZ = this.i.Z();
            return (!(objZ instanceof c) || (thE = ((c) objZ).e()) == null) ? objZ instanceof jz3 ? ((jz3) objZ).a : h14Var.m() : thE;
        }
    }

    /* compiled from: JobSupport.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\b\u0002\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0096\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lkotlinx/coroutines/JobSupport$ChildCompletion;", "Lkotlinx/coroutines/JobNode;", "parent", "Lkotlinx/coroutines/JobSupport;", "state", "Lkotlinx/coroutines/JobSupport$Finishing;", "child", "Lkotlinx/coroutines/ChildHandleNode;", "proposedUpdate", "", "(Lkotlinx/coroutines/JobSupport;Lkotlinx/coroutines/JobSupport$Finishing;Lkotlinx/coroutines/ChildHandleNode;Ljava/lang/Object;)V", "invoke", "", "cause", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class b extends n14 {

        @NotNull
        public final o14 e;

        @NotNull
        public final c f;

        @NotNull
        public final fz3 g;

        @Nullable
        public final Object h;

        public b(@NotNull o14 o14Var, @NotNull c cVar, @NotNull fz3 fz3Var, @Nullable Object obj) {
            this.e = o14Var;
            this.f = cVar;
            this.g = fz3Var;
            this.h = obj;
        }

        @Override // dc.lz3
        public void K(@Nullable Throwable th) {
            this.e.O(this.f, this.g, this.h);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
            K(th);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: JobSupport.kt */
    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\u0018\u0002\b\u0002\u0018\u00002\u00060\u0018j\u0002`,2\u00020-B!\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00050\rj\b\u0012\u0004\u0012\u00020\u0005`\u000eH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017R(\u0010\u001e\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u00188B@BX\u0082\u000e¢\u0006\f\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001f\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0011\u0010!\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b!\u0010 R$\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u00038F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010 \"\u0004\b\"\u0010#R\u0011\u0010$\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b$\u0010 R\u001a\u0010\u0002\u001a\u00020\u00018\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0002\u0010%\u001a\u0004\b&\u0010'R(\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u00058F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b(\u0010)\"\u0004\b*\u0010\f¨\u0006+"}, d2 = {"Lkotlinx/coroutines/JobSupport$Finishing;", "Lkotlinx/coroutines/NodeList;", "list", "", "isCompleting", "", "rootCause", "<init>", "(Lkotlinx/coroutines/NodeList;ZLjava/lang/Throwable;)V", "exception", "", "addExceptionLocked", "(Ljava/lang/Throwable;)V", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "allocateList", "()Ljava/util/ArrayList;", "proposedException", "", "sealLocked", "(Ljava/lang/Throwable;)Ljava/util/List;", "", "toString", "()Ljava/lang/String;", "", "value", "getExceptionsHolder", "()Ljava/lang/Object;", "setExceptionsHolder", "(Ljava/lang/Object;)V", "exceptionsHolder", "isActive", "()Z", "isCancelling", "setCompleting", "(Z)V", "isSealed", "Lkotlinx/coroutines/NodeList;", "getList", "()Lkotlinx/coroutines/NodeList;", "getRootCause", "()Ljava/lang/Throwable;", "setRootCause", "kotlinx-coroutines-core", "Lkotlinx/coroutines/internal/SynchronizedObject;", "Lkotlinx/coroutines/Incomplete;"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class c implements c14 {

        @NotNull
        private volatile /* synthetic */ Object _exceptionsHolder = null;

        @NotNull
        private volatile /* synthetic */ int _isCompleting;

        @NotNull
        private volatile /* synthetic */ Object _rootCause;

        @NotNull
        public final t14 a;

        public c(@NotNull t14 t14Var, boolean z, @Nullable Throwable th) {
            this.a = t14Var;
            this._isCompleting = z ? 1 : 0;
            this._rootCause = th;
        }

        public final void a(@NotNull Throwable th) {
            Throwable thE = e();
            if (thE == null) {
                l(th);
                return;
            }
            if (th == thE) {
                return;
            }
            Object obj = get_exceptionsHolder();
            if (obj == null) {
                k(th);
                return;
            }
            if (!(obj instanceof Throwable)) {
                if (!(obj instanceof ArrayList)) {
                    throw new IllegalStateException(Intrinsics.stringPlus("State is ", obj).toString());
                }
                ((ArrayList) obj).add(th);
            } else {
                if (th == obj) {
                    return;
                }
                ArrayList<Throwable> arrayListB = b();
                arrayListB.add(obj);
                arrayListB.add(th);
                k(arrayListB);
            }
        }

        public final ArrayList<Throwable> b() {
            return new ArrayList<>(4);
        }

        /* renamed from: c, reason: from getter */
        public final Object get_exceptionsHolder() {
            return this._exceptionsHolder;
        }

        @Override // dc.c14
        @NotNull
        /* renamed from: d, reason: from getter */
        public t14 getA() {
            return this.a;
        }

        @Nullable
        public final Throwable e() {
            return (Throwable) this._rootCause;
        }

        public final boolean f() {
            return e() != null;
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [boolean, int] */
        public final boolean g() {
            return this._isCompleting;
        }

        public final boolean h() {
            return get_exceptionsHolder() == p14.e;
        }

        @NotNull
        public final List<Throwable> i(@Nullable Throwable th) {
            ArrayList<Throwable> arrayListB;
            Object obj = get_exceptionsHolder();
            if (obj == null) {
                arrayListB = b();
            } else if (obj instanceof Throwable) {
                ArrayList<Throwable> arrayListB2 = b();
                arrayListB2.add(obj);
                arrayListB = arrayListB2;
            } else {
                if (!(obj instanceof ArrayList)) {
                    throw new IllegalStateException(Intrinsics.stringPlus("State is ", obj).toString());
                }
                arrayListB = (ArrayList) obj;
            }
            Throwable thE = e();
            if (thE != null) {
                arrayListB.add(0, thE);
            }
            if (th != null && !Intrinsics.areEqual(th, thE)) {
                arrayListB.add(th);
            }
            k(p14.e);
            return arrayListB;
        }

        @Override // dc.c14
        /* renamed from: isActive */
        public boolean getA() {
            return e() == null;
        }

        public final void j(boolean z) {
            this._isCompleting = z ? 1 : 0;
        }

        public final void k(Object obj) {
            this._exceptionsHolder = obj;
        }

        public final void l(@Nullable Throwable th) {
            this._rootCause = th;
        }

        @NotNull
        public String toString() {
            return "Finishing[cancelling=" + f() + ", completing=" + g() + ", rootCause=" + e() + ", exceptions=" + get_exceptionsHolder() + ", list=" + getA() + ']';
        }
    }

    /* compiled from: LockFreeLinkedList.kt */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006H\u0016¨\u0006\u0007¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/internal/LockFreeLinkedListNode$makeCondAddOp$1", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$CondAddOp;", "prepare", "", "affected", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/internal/Node;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class d extends g64.b {
        public final /* synthetic */ o14 d;
        public final /* synthetic */ Object e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(g64 g64Var, o14 o14Var, Object obj) {
            super(g64Var);
            this.d = o14Var;
            this.e = obj;
        }

        @Override // dc.r54
        @Nullable
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public Object g(@NotNull g64 g64Var) {
            if (this.d.Z() == this.e) {
                return null;
            }
            return f64.a();
        }
    }

    public o14(boolean z) {
        this._state = z ? p14.g : p14.f;
        this._parentHandle = null;
    }

    public static /* synthetic */ CancellationException D0(o14 o14Var, Throwable th, String str, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: toCancellationException");
        }
        if ((i & 1) != 0) {
            str = null;
        }
        return o14Var.C0(th, str);
    }

    public final int A0(Object obj) {
        if (obj instanceof q04) {
            if (((q04) obj).getA()) {
                return 0;
            }
            if (!a.compareAndSet(this, obj, p14.g)) {
                return -1;
            }
            t0();
            return 1;
        }
        if (!(obj instanceof b14)) {
            return 0;
        }
        if (!a.compareAndSet(this, obj, ((b14) obj).getA())) {
            return -1;
        }
        t0();
        return 1;
    }

    @Nullable
    public final Object B(@NotNull Continuation<Object> continuation) throws Throwable {
        Object objZ;
        do {
            objZ = Z();
            if (!(objZ instanceof c14)) {
                if (!(objZ instanceof jz3)) {
                    return p14.h(objZ);
                }
                Throwable th = ((jz3) objZ).a;
                if (a04.d() && (continuation instanceof CoroutineStackFrame)) {
                    throw s64.j(th, (CoroutineStackFrame) continuation);
                }
                throw th;
            }
        } while (A0(objZ) < 0);
        return D(continuation);
    }

    public final String B0(Object obj) {
        if (!(obj instanceof c)) {
            return obj instanceof c14 ? ((c14) obj).getA() ? "Active" : "New" : obj instanceof jz3 ? "Cancelled" : "Completed";
        }
        c cVar = (c) obj;
        return cVar.f() ? "Cancelling" : cVar.g() ? "Completing" : "Active";
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v11, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.lang.Throwable] */
    @Override // dc.w14
    @NotNull
    public CancellationException C() {
        CancellationException cancellationExceptionE;
        Object objZ = Z();
        if (objZ instanceof c) {
            cancellationExceptionE = ((c) objZ).e();
        } else if (objZ instanceof jz3) {
            cancellationExceptionE = ((jz3) objZ).a;
        } else {
            if (objZ instanceof c14) {
                throw new IllegalStateException(Intrinsics.stringPlus("Cannot be cancelling child in this state: ", objZ).toString());
            }
            cancellationExceptionE = null;
        }
        CancellationException cancellationException = cancellationExceptionE instanceof CancellationException ? cancellationExceptionE : null;
        return cancellationException == null ? new JobCancellationException(Intrinsics.stringPlus("Parent job is ", B0(objZ)), cancellationExceptionE, this) : cancellationException;
    }

    @NotNull
    public final CancellationException C0(@NotNull Throwable th, @Nullable String str) {
        CancellationException jobCancellationException = th instanceof CancellationException ? (CancellationException) th : null;
        if (jobCancellationException == null) {
            if (str == null) {
                str = J();
            }
            jobCancellationException = new JobCancellationException(str, th, this);
        }
        return jobCancellationException;
    }

    public final Object D(Continuation<Object> continuation) {
        a aVar = new a(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation), this);
        aVar.A();
        bz3.a(aVar, e0(new y14(aVar)));
        Object objX = aVar.x();
        if (objX == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return objX;
    }

    public final boolean E(@Nullable Throwable th) {
        return F(th);
    }

    @NotNull
    public final String E0() {
        return n0() + MessageFormatter.DELIM_START + B0(Z()) + MessageFormatter.DELIM_STOP;
    }

    public final boolean F(@Nullable Object obj) throws Throwable {
        Object objK0 = p14.a;
        if (V() && (objK0 = H(obj)) == p14.b) {
            return true;
        }
        if (objK0 == p14.a) {
            objK0 = k0(obj);
        }
        if (objK0 == p14.a || objK0 == p14.b) {
            return true;
        }
        if (objK0 == p14.d) {
            return false;
        }
        z(objK0);
        return true;
    }

    public final boolean F0(c14 c14Var, Object obj) throws Throwable {
        if (a04.a()) {
            if (!((c14Var instanceof q04) || (c14Var instanceof n14))) {
                throw new AssertionError();
            }
        }
        if (a04.a() && !(!(obj instanceof jz3))) {
            throw new AssertionError();
        }
        if (!a.compareAndSet(this, c14Var, p14.g(obj))) {
            return false;
        }
        r0(null);
        s0(obj);
        N(c14Var, obj);
        return true;
    }

    public void G(@NotNull Throwable th) throws Throwable {
        F(th);
    }

    public final boolean G0(c14 c14Var, Throwable th) throws Throwable {
        if (a04.a() && !(!(c14Var instanceof c))) {
            throw new AssertionError();
        }
        if (a04.a() && !c14Var.getA()) {
            throw new AssertionError();
        }
        t14 t14VarW = W(c14Var);
        if (t14VarW == null) {
            return false;
        }
        if (!a.compareAndSet(this, c14Var, new c(t14VarW, false, th))) {
            return false;
        }
        p0(t14VarW, th);
        return true;
    }

    public final Object H(Object obj) {
        Object objH0;
        do {
            Object objZ = Z();
            if (!(objZ instanceof c14) || ((objZ instanceof c) && ((c) objZ).g())) {
                return p14.a;
            }
            objH0 = H0(objZ, new jz3(P(obj), false, 2, null));
        } while (objH0 == p14.c);
        return objH0;
    }

    public final Object H0(Object obj, Object obj2) {
        return !(obj instanceof c14) ? p14.a : ((!(obj instanceof q04) && !(obj instanceof n14)) || (obj instanceof fz3) || (obj2 instanceof jz3)) ? I0((c14) obj, obj2) : F0((c14) obj, obj2) ? obj2 : p14.c;
    }

    public final boolean I(Throwable th) {
        if (h0()) {
            return true;
        }
        boolean z = th instanceof CancellationException;
        ez3 ez3VarY = Y();
        return (ez3VarY == null || ez3VarY == u14.a) ? z : ez3VarY.c(th) || z;
    }

    public final Object I0(c14 c14Var, Object obj) throws Throwable {
        t14 t14VarW = W(c14Var);
        if (t14VarW == null) {
            return p14.c;
        }
        c cVar = c14Var instanceof c ? (c) c14Var : null;
        if (cVar == null) {
            cVar = new c(t14VarW, false, null);
        }
        synchronized (cVar) {
            if (cVar.g()) {
                return p14.a;
            }
            cVar.j(true);
            if (cVar != c14Var && !a.compareAndSet(this, c14Var, cVar)) {
                return p14.c;
            }
            if (a04.a() && !(!cVar.h())) {
                throw new AssertionError();
            }
            boolean zF = cVar.f();
            jz3 jz3Var = obj instanceof jz3 ? (jz3) obj : null;
            if (jz3Var != null) {
                cVar.a(jz3Var.a);
            }
            Throwable thE = true ^ zF ? cVar.e() : null;
            Unit unit = Unit.INSTANCE;
            if (thE != null) {
                p0(t14VarW, thE);
            }
            fz3 fz3VarR = R(c14Var);
            return (fz3VarR == null || !J0(cVar, fz3VarR, obj)) ? Q(cVar, obj) : p14.b;
        }
    }

    @NotNull
    public String J() {
        return "Job was cancelled";
    }

    public final boolean J0(c cVar, fz3 fz3Var, Object obj) {
        while (h14.a.d(fz3Var.e, false, false, new b(this, cVar, fz3Var, obj), 1, null) == u14.a) {
            fz3Var = o0(fz3Var);
            if (fz3Var == null) {
                return false;
            }
        }
        return true;
    }

    @Override // dc.h14
    @Nullable
    public final Object L(@NotNull Continuation<? super Unit> continuation) {
        if (i0()) {
            Object objJ0 = j0(continuation);
            return objJ0 == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objJ0 : Unit.INSTANCE;
        }
        k14.f(continuation.get$context());
        return Unit.INSTANCE;
    }

    public boolean M(@NotNull Throwable th) {
        if (th instanceof CancellationException) {
            return true;
        }
        return F(th) && getB();
    }

    public final void N(c14 c14Var, Object obj) throws Throwable {
        ez3 ez3VarY = Y();
        if (ez3VarY != null) {
            ez3VarY.dispose();
            z0(u14.a);
        }
        jz3 jz3Var = obj instanceof jz3 ? (jz3) obj : null;
        Throwable th = jz3Var != null ? jz3Var.a : null;
        if (!(c14Var instanceof n14)) {
            t14 a2 = c14Var.getA();
            if (a2 == null) {
                return;
            }
            q0(a2, th);
            return;
        }
        try {
            ((n14) c14Var).K(th);
        } catch (Throwable th2) {
            c0(new CompletionHandlerException("Exception in completion handler " + c14Var + " for " + this, th2));
        }
    }

    public final void O(c cVar, fz3 fz3Var, Object obj) {
        if (a04.a()) {
            if (!(Z() == cVar)) {
                throw new AssertionError();
            }
        }
        fz3 fz3VarO0 = o0(fz3Var);
        if (fz3VarO0 == null || !J0(cVar, fz3VarO0, obj)) {
            z(Q(cVar, obj));
        }
    }

    public final Throwable P(Object obj) {
        if (obj == null ? true : obj instanceof Throwable) {
            Throwable th = (Throwable) obj;
            return th == null ? new JobCancellationException(J(), null, this) : th;
        }
        Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.ParentJob");
        return ((w14) obj).C();
    }

    public final Object Q(c cVar, Object obj) throws Throwable {
        boolean zF;
        Throwable thT;
        boolean z = true;
        if (a04.a()) {
            if (!(Z() == cVar)) {
                throw new AssertionError();
            }
        }
        if (a04.a() && !(!cVar.h())) {
            throw new AssertionError();
        }
        if (a04.a() && !cVar.g()) {
            throw new AssertionError();
        }
        jz3 jz3Var = obj instanceof jz3 ? (jz3) obj : null;
        Throwable th = jz3Var == null ? null : jz3Var.a;
        synchronized (cVar) {
            zF = cVar.f();
            List<Throwable> listI = cVar.i(th);
            thT = T(cVar, listI);
            if (thT != null) {
                y(thT, listI);
            }
        }
        if (thT != null && thT != th) {
            obj = new jz3(thT, false, 2, null);
        }
        if (thT != null) {
            if (!I(thT) && !a0(thT)) {
                z = false;
            }
            if (z) {
                Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.CompletedExceptionally");
                ((jz3) obj).b();
            }
        }
        if (!zF) {
            r0(thT);
        }
        s0(obj);
        boolean zCompareAndSet = a.compareAndSet(this, cVar, p14.g(obj));
        if (a04.a() && !zCompareAndSet) {
            throw new AssertionError();
        }
        N(cVar, obj);
        return obj;
    }

    public final fz3 R(c14 c14Var) {
        fz3 fz3Var = c14Var instanceof fz3 ? (fz3) c14Var : null;
        if (fz3Var != null) {
            return fz3Var;
        }
        t14 a2 = c14Var.getA();
        if (a2 == null) {
            return null;
        }
        return o0(a2);
    }

    public final Throwable S(Object obj) {
        jz3 jz3Var = obj instanceof jz3 ? (jz3) obj : null;
        if (jz3Var == null) {
            return null;
        }
        return jz3Var.a;
    }

    public final Throwable T(c cVar, List<? extends Throwable> list) {
        Object next;
        Object obj = null;
        if (list.isEmpty()) {
            if (cVar.f()) {
                return new JobCancellationException(J(), null, this);
            }
            return null;
        }
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (!(((Throwable) next) instanceof CancellationException)) {
                break;
            }
        }
        Throwable th = (Throwable) next;
        if (th != null) {
            return th;
        }
        Throwable th2 = list.get(0);
        if (th2 instanceof TimeoutCancellationException) {
            Iterator<T> it2 = list.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Object next2 = it2.next();
                Throwable th3 = (Throwable) next2;
                if (th3 != th2 && (th3 instanceof TimeoutCancellationException)) {
                    obj = next2;
                    break;
                }
            }
            Throwable th4 = (Throwable) obj;
            if (th4 != null) {
                return th4;
            }
        }
        return th2;
    }

    /* renamed from: U */
    public boolean getB() {
        return true;
    }

    public boolean V() {
        return false;
    }

    public final t14 W(c14 c14Var) {
        t14 a2 = c14Var.getA();
        if (a2 != null) {
            return a2;
        }
        if (c14Var instanceof q04) {
            return new t14();
        }
        if (!(c14Var instanceof n14)) {
            throw new IllegalStateException(Intrinsics.stringPlus("State should have list: ", c14Var).toString());
        }
        v0((n14) c14Var);
        return null;
    }

    @Nullable
    public final ez3 Y() {
        return (ez3) this._parentHandle;
    }

    @Nullable
    public final Object Z() {
        while (true) {
            Object obj = this._state;
            if (!(obj instanceof o64)) {
                return obj;
            }
            ((o64) obj).c(this);
        }
    }

    public boolean a0(@NotNull Throwable th) {
        return false;
    }

    @Override // dc.h14
    public void b(@Nullable CancellationException cancellationException) throws Throwable {
        if (cancellationException == null) {
            cancellationException = new JobCancellationException(J(), null, this);
        }
        G(cancellationException);
    }

    @Override // dc.h14
    @NotNull
    public final ez3 b0(@NotNull gz3 gz3Var) {
        return (ez3) h14.a.d(this, true, false, new fz3(gz3Var), 2, null);
    }

    public void c0(@NotNull Throwable th) throws Throwable {
        throw th;
    }

    public final void d0(@Nullable h14 h14Var) {
        if (a04.a()) {
            if (!(Y() == null)) {
                throw new AssertionError();
            }
        }
        if (h14Var == null) {
            z0(u14.a);
            return;
        }
        h14Var.start();
        ez3 ez3VarB0 = h14Var.b0(this);
        z0(ez3VarB0);
        if (g0()) {
            ez3VarB0.dispose();
            z0(u14.a);
        }
    }

    @NotNull
    public final o04 e0(@NotNull Function1<? super Throwable, Unit> function1) {
        return j(false, true, function1);
    }

    public final boolean f0() {
        Object objZ = Z();
        return (objZ instanceof jz3) || ((objZ instanceof c) && ((c) objZ).f());
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public <R> R fold(R r, @NotNull Function2<? super R, ? super CoroutineContext.Element, ? extends R> function2) {
        return (R) h14.a.b(this, r, function2);
    }

    public final boolean g0() {
        return !(Z() instanceof c14);
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    @Nullable
    public <E extends CoroutineContext.Element> E get(@NotNull CoroutineContext.Key<E> key) {
        return (E) h14.a.c(this, key);
    }

    @Override // kotlin.coroutines.CoroutineContext.Element
    @NotNull
    public final CoroutineContext.Key<?> getKey() {
        return h14.I;
    }

    public boolean h0() {
        return false;
    }

    public final boolean i0() {
        Object objZ;
        do {
            objZ = Z();
            if (!(objZ instanceof c14)) {
                return false;
            }
        } while (A0(objZ) < 0);
        return true;
    }

    @Override // dc.h14
    public boolean isActive() {
        Object objZ = Z();
        return (objZ instanceof c14) && ((c14) objZ).getA();
    }

    @Override // dc.h14
    @NotNull
    public final o04 j(boolean z, boolean z2, @NotNull Function1<? super Throwable, Unit> function1) {
        n14 n14VarM0 = m0(function1, z);
        while (true) {
            Object objZ = Z();
            if (objZ instanceof q04) {
                q04 q04Var = (q04) objZ;
                if (!q04Var.getA()) {
                    u0(q04Var);
                } else if (a.compareAndSet(this, objZ, n14VarM0)) {
                    return n14VarM0;
                }
            } else {
                if (!(objZ instanceof c14)) {
                    if (z2) {
                        jz3 jz3Var = objZ instanceof jz3 ? (jz3) objZ : null;
                        function1.invoke(jz3Var != null ? jz3Var.a : null);
                    }
                    return u14.a;
                }
                t14 a2 = ((c14) objZ).getA();
                if (a2 == null) {
                    Objects.requireNonNull(objZ, "null cannot be cast to non-null type kotlinx.coroutines.JobNode");
                    v0((n14) objZ);
                } else {
                    o04 o04Var = u14.a;
                    if (z && (objZ instanceof c)) {
                        synchronized (objZ) {
                            thE = ((c) objZ).e();
                            if (thE == null || ((function1 instanceof fz3) && !((c) objZ).g())) {
                                if (w(objZ, a2, n14VarM0)) {
                                    if (thE == null) {
                                        return n14VarM0;
                                    }
                                    o04Var = n14VarM0;
                                }
                            }
                            Unit unit = Unit.INSTANCE;
                        }
                    }
                    if (thE != null) {
                        if (z2) {
                            function1.invoke(thE);
                        }
                        return o04Var;
                    }
                    if (w(objZ, a2, n14VarM0)) {
                        return n14VarM0;
                    }
                }
            }
        }
    }

    public final Object j0(Continuation<? super Unit> continuation) {
        zy3 zy3Var = new zy3(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation), 1);
        zy3Var.A();
        bz3.a(zy3Var, e0(new z14(zy3Var)));
        Object objX = zy3Var.x();
        if (objX == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return objX == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objX : Unit.INSTANCE;
    }

    public final Object k0(Object obj) throws Throwable {
        Throwable thP = null;
        while (true) {
            Object objZ = Z();
            if (objZ instanceof c) {
                synchronized (objZ) {
                    if (((c) objZ).h()) {
                        return p14.d;
                    }
                    boolean zF = ((c) objZ).f();
                    if (obj != null || !zF) {
                        if (thP == null) {
                            thP = P(obj);
                        }
                        ((c) objZ).a(thP);
                    }
                    Throwable thE = zF ^ true ? ((c) objZ).e() : null;
                    if (thE != null) {
                        p0(((c) objZ).getA(), thE);
                    }
                    return p14.a;
                }
            }
            if (!(objZ instanceof c14)) {
                return p14.d;
            }
            if (thP == null) {
                thP = P(obj);
            }
            c14 c14Var = (c14) objZ;
            if (!c14Var.getA()) {
                Object objH0 = H0(objZ, new jz3(thP, false, 2, null));
                if (objH0 == p14.a) {
                    throw new IllegalStateException(Intrinsics.stringPlus("Cannot happen in ", objZ).toString());
                }
                if (objH0 != p14.c) {
                    return objH0;
                }
            } else if (G0(c14Var, thP)) {
                return p14.a;
            }
        }
    }

    @Nullable
    public final Object l0(@Nullable Object obj) {
        Object objH0;
        do {
            objH0 = H0(Z(), obj);
            if (objH0 == p14.a) {
                throw new IllegalStateException("Job " + this + " is already complete or completing, but is being completed with " + obj, S(obj));
            }
        } while (objH0 == p14.c);
        return objH0;
    }

    @Override // dc.h14
    @NotNull
    public final CancellationException m() {
        Object objZ = Z();
        if (!(objZ instanceof c)) {
            if (objZ instanceof c14) {
                throw new IllegalStateException(Intrinsics.stringPlus("Job is still new or active: ", this).toString());
            }
            return objZ instanceof jz3 ? D0(this, ((jz3) objZ).a, null, 1, null) : new JobCancellationException(Intrinsics.stringPlus(b04.a(this), " has completed normally"), null, this);
        }
        Throwable thE = ((c) objZ).e();
        CancellationException cancellationExceptionC0 = thE != null ? C0(thE, Intrinsics.stringPlus(b04.a(this), " is cancelling")) : null;
        if (cancellationExceptionC0 != null) {
            return cancellationExceptionC0;
        }
        throw new IllegalStateException(Intrinsics.stringPlus("Job is still new or active: ", this).toString());
    }

    public final n14 m0(Function1<? super Throwable, Unit> function1, boolean z) {
        if (z) {
            g14Var = function1 instanceof i14 ? (i14) function1 : null;
            if (g14Var == null) {
                g14Var = new f14(function1);
            }
        } else {
            n14 n14Var = function1 instanceof n14 ? (n14) function1 : null;
            if (n14Var != null) {
                if (a04.a() && !(!(n14Var instanceof i14))) {
                    throw new AssertionError();
                }
                g14Var = n14Var;
            }
            if (g14Var == null) {
                g14Var = new g14(function1);
            }
        }
        g14Var.M(this);
        return g14Var;
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    @NotNull
    public CoroutineContext minusKey(@NotNull CoroutineContext.Key<?> key) {
        return h14.a.e(this, key);
    }

    @NotNull
    public String n0() {
        return b04.a(this);
    }

    public final fz3 o0(g64 g64Var) {
        while (g64Var.E()) {
            g64Var = g64Var.B();
        }
        while (true) {
            g64Var = g64Var.A();
            if (!g64Var.E()) {
                if (g64Var instanceof fz3) {
                    return (fz3) g64Var;
                }
                if (g64Var instanceof t14) {
                    return null;
                }
            }
        }
    }

    public final void p0(t14 t14Var, Throwable th) throws Throwable {
        CompletionHandlerException completionHandlerException;
        r0(th);
        CompletionHandlerException completionHandlerException2 = null;
        for (g64 g64VarA = (g64) t14Var.z(); !Intrinsics.areEqual(g64VarA, t14Var); g64VarA = g64VarA.A()) {
            if (g64VarA instanceof i14) {
                n14 n14Var = (n14) g64VarA;
                try {
                    n14Var.K(th);
                } catch (Throwable th2) {
                    if (completionHandlerException2 == null) {
                        completionHandlerException = null;
                    } else {
                        ExceptionsKt__ExceptionsKt.addSuppressed(completionHandlerException2, th2);
                        completionHandlerException = completionHandlerException2;
                    }
                    if (completionHandlerException == null) {
                        completionHandlerException2 = new CompletionHandlerException("Exception in completion handler " + n14Var + " for " + this, th2);
                    }
                }
            }
        }
        if (completionHandlerException2 != null) {
            c0(completionHandlerException2);
        }
        I(th);
    }

    @Override // kotlin.coroutines.CoroutineContext
    @NotNull
    public CoroutineContext plus(@NotNull CoroutineContext coroutineContext) {
        return h14.a.f(this, coroutineContext);
    }

    @Override // dc.gz3
    public final void q(@NotNull w14 w14Var) throws Throwable {
        F(w14Var);
    }

    public final void q0(t14 t14Var, Throwable th) throws Throwable {
        CompletionHandlerException completionHandlerException;
        CompletionHandlerException completionHandlerException2 = null;
        for (g64 g64VarA = (g64) t14Var.z(); !Intrinsics.areEqual(g64VarA, t14Var); g64VarA = g64VarA.A()) {
            if (g64VarA instanceof n14) {
                n14 n14Var = (n14) g64VarA;
                try {
                    n14Var.K(th);
                } catch (Throwable th2) {
                    if (completionHandlerException2 == null) {
                        completionHandlerException = null;
                    } else {
                        ExceptionsKt__ExceptionsKt.addSuppressed(completionHandlerException2, th2);
                        completionHandlerException = completionHandlerException2;
                    }
                    if (completionHandlerException == null) {
                        completionHandlerException2 = new CompletionHandlerException("Exception in completion handler " + n14Var + " for " + this, th2);
                    }
                }
            }
        }
        if (completionHandlerException2 == null) {
            return;
        }
        c0(completionHandlerException2);
    }

    public void r0(@Nullable Throwable th) {
    }

    public void s0(@Nullable Object obj) {
    }

    @Override // dc.h14
    public final boolean start() {
        int iA0;
        do {
            iA0 = A0(Z());
            if (iA0 == 0) {
                return false;
            }
        } while (iA0 != 1);
        return true;
    }

    public void t0() {
    }

    @NotNull
    public String toString() {
        return E0() + '@' + b04.b(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [dc.b14] */
    public final void u0(q04 q04Var) {
        t14 t14Var = new t14();
        if (!q04Var.getA()) {
            t14Var = new b14(t14Var);
        }
        a.compareAndSet(this, q04Var, t14Var);
    }

    public final void v0(n14 n14Var) {
        n14Var.v(new t14());
        a.compareAndSet(this, n14Var, n14Var.A());
    }

    public final boolean w(Object obj, t14 t14Var, n14 n14Var) {
        int iJ;
        d dVar = new d(n14Var, this, obj);
        do {
            iJ = t14Var.B().J(n14Var, t14Var, dVar);
            if (iJ == 1) {
                return true;
            }
        } while (iJ != 2);
        return false;
    }

    public final <T, R> void w0(@NotNull v74<? super R> v74Var, @NotNull Function2<? super T, ? super Continuation<? super R>, ? extends Object> function2) {
        Object objZ;
        do {
            objZ = Z();
            if (v74Var.e()) {
                return;
            }
            if (!(objZ instanceof c14)) {
                if (v74Var.k()) {
                    if (objZ instanceof jz3) {
                        v74Var.o(((jz3) objZ).a);
                        return;
                    } else {
                        d74.c(function2, p14.h(objZ), v74Var.m());
                        return;
                    }
                }
                return;
            }
        } while (A0(objZ) != 0);
        v74Var.j(e0(new b24(v74Var, function2)));
    }

    public final void x0(@NotNull n14 n14Var) {
        Object objZ;
        do {
            objZ = Z();
            if (!(objZ instanceof n14)) {
                if (!(objZ instanceof c14) || ((c14) objZ).getA() == null) {
                    return;
                }
                n14Var.F();
                return;
            }
            if (objZ != n14Var) {
                return;
            }
        } while (!a.compareAndSet(this, objZ, p14.g));
    }

    public final void y(Throwable th, List<? extends Throwable> list) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (list.size() <= 1) {
            return;
        }
        Set setNewSetFromMap = Collections.newSetFromMap(new IdentityHashMap(list.size()));
        Throwable thN = !a04.d() ? th : s64.n(th);
        for (Throwable thN2 : list) {
            if (a04.d()) {
                thN2 = s64.n(thN2);
            }
            if (thN2 != th && thN2 != thN && !(thN2 instanceof CancellationException) && setNewSetFromMap.add(thN2)) {
                ExceptionsKt__ExceptionsKt.addSuppressed(th, thN2);
            }
        }
    }

    public final <T, R> void y0(@NotNull v74<? super R> v74Var, @NotNull Function2<? super T, ? super Continuation<? super R>, ? extends Object> function2) throws Throwable {
        Object objZ = Z();
        if (objZ instanceof jz3) {
            v74Var.o(((jz3) objZ).a);
        } else {
            c74.e(function2, p14.h(objZ), v74Var.m(), null, 4, null);
        }
    }

    public void z(@Nullable Object obj) {
    }

    public final void z0(@Nullable ez3 ez3Var) {
        this._parentHandle = ez3Var;
    }
}
