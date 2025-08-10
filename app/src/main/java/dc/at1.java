package dc;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import androidx.core.app.NotificationCompat;
import com.component.dxbluetooth.lib.bean.BleResultBean;
import com.epicgames.unreal.psoservices.PSOProgramService;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.wear.bean.DfuBean;
import com.wear.bean.ToyConfigInfoBean;
import com.wear.util.TextOverlayImageView;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smack.sm.packet.StreamManagement;
import org.jivesoftware.smackx.address.packet.MultipleAddresses;

/* compiled from: ToyProxy.kt */
@Metadata(d1 = {"\u0000ª\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\\\n\u0002\u0018\u0002\n\u0002\br\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 É\u00022\u00020\u00012\u00020\u0002:\u0002É\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005H\u0016J\b\u0010\f\u001a\u00020\u0005H\u0016J\b\u0010\r\u001a\u00020\u0005H\u0016J\n\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\n\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\n\u0010\u0011\u001a\u0004\u0018\u00010\u000fH\u0016J\n\u0010\u0012\u001a\u0004\u0018\u00010\u000fH\u0016J\n\u0010\u0013\u001a\u0004\u0018\u00010\u000fH\u0016J\u0010\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015H\u0016J\b\u0010\u0017\u001a\u00020\u0016H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0016H\u0016J \u0010\u001b\u001a\u001a\u0012\u0014\u0012\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u001c\u0018\u00010\u0015H\u0016J\b\u0010\u001d\u001a\u00020\u0016H\u0016J\b\u0010\u001e\u001a\u00020\u0019H\u0016J\b\u0010\u001f\u001a\u00020\u0016H\u0016J\b\u0010 \u001a\u00020\u0016H\u0016J\b\u0010!\u001a\u00020\u0019H\u0016J\n\u0010\"\u001a\u0004\u0018\u00010\u000fH\u0016J\n\u0010#\u001a\u0004\u0018\u00010\u000fH\u0016J\n\u0010$\u001a\u0004\u0018\u00010\u000fH\u0016J\n\u0010%\u001a\u0004\u0018\u00010\u000fH\u0016J\n\u0010&\u001a\u0004\u0018\u00010\u000fH\u0016J\u0014\u0010'\u001a\u0004\u0018\u00010\u000f2\b\u0010(\u001a\u0004\u0018\u00010\u000fH\u0016J\u0010\u0010)\u001a\u00020\u00162\u0006\u0010*\u001a\u00020\u0005H\u0016J\b\u0010+\u001a\u00020\u0016H\u0016J\n\u0010,\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010-\u001a\u00020\u0019H\u0016J\n\u0010.\u001a\u0004\u0018\u00010\u000fH\u0016J\n\u0010/\u001a\u0004\u0018\u00010\u000fH\u0016J\u0006\u00100\u001a\u000201J\n\u00102\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u00103\u001a\u00020\u0019H\u0016J\b\u00104\u001a\u00020\u0019H\u0016J\n\u00105\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u00106\u001a\u00020\u0016H\u0016J\b\u00107\u001a\u00020\u0016H\u0016J\b\u00108\u001a\u00020\u0016H\u0016J\b\u00109\u001a\u00020\u0016H\u0016J\b\u0010:\u001a\u00020\u0016H\u0016J\b\u0010;\u001a\u00020\u0016H\u0016J\b\u0010<\u001a\u00020\u0016H\u0016J\b\u0010=\u001a\u00020\u0016H\u0016J\b\u0010>\u001a\u00020\u0016H\u0016J\n\u0010?\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010@\u001a\u00020\u000fH\u0016J\u0012\u0010A\u001a\u0004\u0018\u00010\u000f2\u0006\u0010B\u001a\u00020\u0016H\u0016J\u000e\u0010C\u001a\b\u0012\u0004\u0012\u00020D0\u0015H\u0016J\b\u0010E\u001a\u00020\u0016H\u0016J\n\u0010F\u001a\u0004\u0018\u00010GH\u0016J\u0014\u0010H\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u00150\u0015H\u0016J\n\u0010I\u001a\u0004\u0018\u00010\u000fH\u0016J\n\u0010J\u001a\u0004\u0018\u00010\u000fH\u0016J\u0014\u0010K\u001a\u0004\u0018\u00010\u000f2\b\u0010L\u001a\u0004\u0018\u00010MH\u0016J\b\u0010N\u001a\u0004\u0018\u00010OJ\n\u0010P\u001a\u0004\u0018\u00010\u000fH\u0016J\n\u0010Q\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010R\u001a\u0004\u0018\u00010SJ\n\u0010T\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010U\u001a\u00020\u0019H\u0016J\n\u0010V\u001a\u0004\u0018\u00010GH\u0016J\u001c\u0010W\u001a\u0016\u0012\u0004\u0012\u00020\u000f\u0018\u00010Xj\n\u0012\u0004\u0012\u00020\u000f\u0018\u0001`YH\u0016J\b\u0010Z\u001a\u00020\u0016H\u0016J\n\u0010[\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\\\u001a\u00020\u0005H\u0016J\b\u0010]\u001a\u00020\u0019H\u0016J\b\u0010^\u001a\u00020\u0016H\u0016J\b\u0010_\u001a\u00020\u0016H\u0016J\u0012\u0010`\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\u0015H\u0016J\b\u0010a\u001a\u00020\u0016H\u0016J\b\u0010b\u001a\u00020\u000fH\u0016J\n\u0010c\u001a\u0004\u0018\u00010\u000fH\u0016J\n\u0010d\u001a\u0004\u0018\u00010\u000fH\u0016J\n\u0010e\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010f\u001a\u00020\u0016H\u0016J\n\u0010g\u001a\u0004\u0018\u00010\u000fH\u0016J\n\u0010h\u001a\u0004\u0018\u00010iH\u0016J\b\u0010j\u001a\u00020\u0016H\u0016J\b\u0010k\u001a\u00020\u0016H\u0016J\u0010\u0010l\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0015H\u0016J\n\u0010m\u001a\u0004\u0018\u00010\u000fH\u0016J\u0012\u0010n\u001a\u0004\u0018\u00010\u000f2\u0006\u0010o\u001a\u00020\u0016H\u0016J\b\u0010p\u001a\u00020\u0016H\u0016J\n\u0010q\u001a\u0004\u0018\u00010\u000fH\u0016J\n\u0010r\u001a\u0004\u0018\u00010\u000fH\u0016J\n\u0010s\u001a\u0004\u0018\u00010tH\u0016J\b\u0010u\u001a\u00020\u0019H\u0016J\n\u0010v\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010w\u001a\u00020\u0016H\u0016J\n\u0010x\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010y\u001a\u00020\u0016H\u0016J\b\u0010z\u001a\u00020\u0005H\u0016J\b\u0010{\u001a\u00020\u0005H\u0016J\b\u0010|\u001a\u00020\u0005H\u0016J\b\u0010}\u001a\u00020\u0005H\u0016J\b\u0010~\u001a\u00020\u0005H\u0016J\b\u0010\u007f\u001a\u00020\u0005H\u0016J\t\u0010\u0080\u0001\u001a\u00020\u0005H\u0016J\t\u0010\u0081\u0001\u001a\u00020\u0005H\u0016J\t\u0010\u0082\u0001\u001a\u00020\u0005H\u0016J\u0012\u0010\u0082\u0001\u001a\u00020\u00052\u0007\u0010\u0083\u0001\u001a\u00020\u0016H\u0016J\t\u0010\u0084\u0001\u001a\u00020\u0005H\u0016J\t\u0010\u0085\u0001\u001a\u00020\u0005H\u0016J\t\u0010\u0086\u0001\u001a\u00020\u0005H\u0016J\t\u0010\u0087\u0001\u001a\u00020\u0005H\u0016J\t\u0010\u0088\u0001\u001a\u00020\u0005H\u0016J\t\u0010\u0089\u0001\u001a\u00020\u0005H\u0016J\t\u0010\u008a\u0001\u001a\u00020\u0005H\u0016J\t\u0010\u008b\u0001\u001a\u00020\u0016H\u0016J\t\u0010\u008c\u0001\u001a\u00020\u0005H\u0016J\u0012\u0010\u008c\u0001\u001a\u00020\u00052\u0007\u0010\u0083\u0001\u001a\u00020\u0016H\u0016J\t\u0010\u008d\u0001\u001a\u00020\u0005H\u0016J\t\u0010\u008e\u0001\u001a\u00020\u0005H\u0016J\t\u0010\u008f\u0001\u001a\u00020\u0005H\u0016J\t\u0010\u0090\u0001\u001a\u00020\u0005H\u0016J\t\u0010\u0091\u0001\u001a\u00020\u0005H\u0016J\t\u0010\u0092\u0001\u001a\u00020\u0005H\u0016J\t\u0010\u0093\u0001\u001a\u00020\u0005H\u0016J\t\u0010\u0094\u0001\u001a\u00020\u0005H\u0016J\t\u0010\u0095\u0001\u001a\u00020\u0005H\u0016J\t\u0010\u0096\u0001\u001a\u00020\u0005H\u0016J\t\u0010\u0097\u0001\u001a\u00020\u0005H\u0016J\t\u0010\u0098\u0001\u001a\u00020\u0005H\u0016J\t\u0010\u0099\u0001\u001a\u00020\u0005H\u0016J\t\u0010\u009a\u0001\u001a\u00020\u0005H\u0016J\t\u0010\u009b\u0001\u001a\u00020\u0005H\u0016J\t\u0010\u009c\u0001\u001a\u00020\u0005H\u0016J\t\u0010\u009d\u0001\u001a\u00020\u0005H\u0016J\t\u0010\u009e\u0001\u001a\u00020\u0005H\u0016J\t\u0010\u009f\u0001\u001a\u00020\u0005H\u0016J\t\u0010 \u0001\u001a\u00020\u0005H\u0016J\t\u0010¡\u0001\u001a\u00020\u0005H\u0016J\t\u0010¢\u0001\u001a\u00020\u0005H\u0016J\u0012\u0010£\u0001\u001a\u00020\u00052\u0007\u0010¤\u0001\u001a\u00020\u0005H\u0016J\t\u0010¥\u0001\u001a\u00020\u0005H\u0016J\t\u0010¦\u0001\u001a\u00020\u0005H\u0016J\t\u0010§\u0001\u001a\u00020\u0005H\u0016J\t\u0010¨\u0001\u001a\u00020\u0005H\u0016J\t\u0010©\u0001\u001a\u00020\u0005H\u0016J\t\u0010ª\u0001\u001a\u00020\u0005H\u0016J\t\u0010«\u0001\u001a\u00020\u0005H\u0016J\t\u0010¬\u0001\u001a\u00020\u0005H\u0016J\t\u0010\u00ad\u0001\u001a\u00020\u0005H\u0016J\t\u0010®\u0001\u001a\u00020\u0005H\u0016J\t\u0010¯\u0001\u001a\u00020\u0005H\u0016J\t\u0010°\u0001\u001a\u00020\u0005H\u0016J\t\u0010±\u0001\u001a\u00020\u0005H\u0016J\t\u0010²\u0001\u001a\u00020\u0005H\u0016J\u0012\u0010³\u0001\u001a\u00020\b2\u0007\u0010´\u0001\u001a\u00020\u0016H\u0016J\u0014\u0010µ\u0001\u001a\u00020\b2\t\u0010¶\u0001\u001a\u0004\u0018\u00010\u000fH\u0016J\u0012\u0010·\u0001\u001a\u00020\b2\u0007\u0010¸\u0001\u001a\u00020\u0016H\u0016J\t\u0010¹\u0001\u001a\u00020\bH\u0016J\u0010\u0010º\u0001\u001a\u00020\u00012\u0007\u0010»\u0001\u001a\u00020\u0005J\u0014\u0010¼\u0001\u001a\u00020\b2\t\u0010½\u0001\u001a\u0004\u0018\u00010\u000fH\u0016J\u0014\u0010¾\u0001\u001a\u00020\b2\t\u0010¿\u0001\u001a\u0004\u0018\u00010\u000fH\u0016J\u001d\u0010À\u0001\u001a\u00020\b2\t\u0010Á\u0001\u001a\u0004\u0018\u00010\u000f2\u0007\u0010Â\u0001\u001a\u00020\u0005H\u0016J\u0014\u0010Ã\u0001\u001a\u00020\b2\t\u0010Ä\u0001\u001a\u0004\u0018\u00010\u000fH\u0016J\u0012\u0010Å\u0001\u001a\u00020\b2\u0007\u0010Æ\u0001\u001a\u00020\u0016H\u0016J\u0012\u0010Ç\u0001\u001a\u00020\b2\u0007\u0010È\u0001\u001a\u00020\u0019H\u0016J\u0012\u0010É\u0001\u001a\u00020\b2\u0007\u0010Ê\u0001\u001a\u00020\u0016H\u0016J\u0012\u0010Ë\u0001\u001a\u00020\b2\u0007\u0010Ì\u0001\u001a\u00020\u0005H\u0016J\u0012\u0010Í\u0001\u001a\u00020\b2\u0007\u0010Î\u0001\u001a\u00020\u0016H\u0016J\u0013\u0010Ï\u0001\u001a\u00020\b2\b\u0010Ð\u0001\u001a\u00030Ñ\u0001H\u0016J\u0012\u0010Ò\u0001\u001a\u00020\b2\u0007\u0010Ó\u0001\u001a\u00020\u0019H\u0016J\u0012\u0010Ô\u0001\u001a\u00020\b2\u0007\u0010Õ\u0001\u001a\u00020\u0016H\u0016J\u0012\u0010Ö\u0001\u001a\u00020\b2\u0007\u0010×\u0001\u001a\u00020\u0016H\u0016J\u0012\u0010Ø\u0001\u001a\u00020\b2\u0007\u0010Ù\u0001\u001a\u00020\u0019H\u0016J\u0014\u0010Ú\u0001\u001a\u00020\b2\t\u0010Û\u0001\u001a\u0004\u0018\u00010\u000fH\u0016J\u0014\u0010Ü\u0001\u001a\u00020\b2\t\u0010Ý\u0001\u001a\u0004\u0018\u00010\u000fH\u0016J\u0014\u0010Þ\u0001\u001a\u00020\b2\t\u0010ß\u0001\u001a\u0004\u0018\u00010\u000fH\u0016J\u0013\u0010à\u0001\u001a\u00020\b2\b\u0010(\u001a\u0004\u0018\u00010\u000fH\u0016J\u0011\u0010á\u0001\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0012\u0010â\u0001\u001a\u00020\b2\u0007\u0010ã\u0001\u001a\u00020\u0016H\u0016J\u0014\u0010ä\u0001\u001a\u00020\b2\t\u0010å\u0001\u001a\u0004\u0018\u00010\u000fH\u0016J\u0012\u0010æ\u0001\u001a\u00020\b2\u0007\u0010ç\u0001\u001a\u00020\u0005H\u0016J\u0012\u0010è\u0001\u001a\u00020\b2\u0007\u0010é\u0001\u001a\u00020\u0005H\u0016J\u0012\u0010ê\u0001\u001a\u00020\b2\u0007\u0010ë\u0001\u001a\u00020\u0005H\u0016J\u0012\u0010ì\u0001\u001a\u00020\b2\u0007\u0010í\u0001\u001a\u00020\u0005H\u0016J\u0012\u0010î\u0001\u001a\u00020\b2\u0007\u0010ï\u0001\u001a\u00020\u0019H\u0016J\u0014\u0010ð\u0001\u001a\u00020\b2\t\u0010ñ\u0001\u001a\u0004\u0018\u00010\u000fH\u0016J\u0012\u0010ò\u0001\u001a\u00020\b2\u0007\u0010ó\u0001\u001a\u00020\u0019H\u0016J\u0012\u0010ô\u0001\u001a\u00020\b2\u0007\u0010õ\u0001\u001a\u00020\u0019H\u0016J\u0014\u0010ö\u0001\u001a\u00020\b2\t\u0010÷\u0001\u001a\u0004\u0018\u00010\u000fH\u0016J\u0012\u0010ø\u0001\u001a\u00020\b2\u0007\u0010ù\u0001\u001a\u00020\u0016H\u0016J\u0012\u0010ú\u0001\u001a\u00020\b2\u0007\u0010û\u0001\u001a\u00020\u0016H\u0016J\u0012\u0010ü\u0001\u001a\u00020\b2\u0007\u0010ý\u0001\u001a\u00020\u0016H\u0016J\u0012\u0010þ\u0001\u001a\u00020\b2\u0007\u0010ÿ\u0001\u001a\u00020\u0016H\u0016J\u0012\u0010\u0080\u0002\u001a\u00020\b2\u0007\u0010\u009a\u0001\u001a\u00020\u0016H\u0016J\u0012\u0010\u0081\u0002\u001a\u00020\b2\u0007\u0010\u0082\u0002\u001a\u00020\u0016H\u0016J\u0012\u0010\u0083\u0002\u001a\u00020\b2\u0007\u0010\u0090\u0001\u001a\u00020\u0005H\u0016J\u0012\u0010\u0084\u0002\u001a\u00020\b2\u0007\u0010\u0085\u0002\u001a\u00020\u0016H\u0016J\u0012\u0010\u0086\u0002\u001a\u00020\b2\u0007\u0010\u0087\u0002\u001a\u00020\u0016H\u0016J\u0014\u0010\u0088\u0002\u001a\u00020\b2\t\u0010\u0089\u0002\u001a\u0004\u0018\u00010\u000fH\u0016J\u0014\u0010\u008a\u0002\u001a\u00020\b2\t\u0010\u008b\u0002\u001a\u0004\u0018\u00010\u000fH\u0016J\u0012\u0010\u008c\u0002\u001a\u00020\b2\u0007\u0010\u008d\u0002\u001a\u00020\u0016H\u0016J\u0012\u0010\u008e\u0002\u001a\u00020\b2\u0007\u0010\u008f\u0002\u001a\u00020GH\u0016J\u0014\u0010\u0090\u0002\u001a\u00020\b2\t\u0010\u0091\u0002\u001a\u0004\u0018\u00010\u000fH\u0016J\u0010\u0010\u0092\u0002\u001a\u00020\b2\u0007\u0010\u0093\u0002\u001a\u00020OJ\u0010\u0010\u0094\u0002\u001a\u00020\b2\u0007\u0010\u0093\u0002\u001a\u00020SJ\u0014\u0010\u0095\u0002\u001a\u00020\b2\t\u0010\u0096\u0002\u001a\u0004\u0018\u00010\u000fH\u0016J\u0012\u0010\u0097\u0002\u001a\u00020\b2\u0007\u0010\u0098\u0002\u001a\u00020\u0019H\u0016J\u0012\u0010\u0099\u0002\u001a\u00020\b2\u0007\u0010\u009a\u0002\u001a\u00020\u0005H\u0016J\u0014\u0010\u009b\u0002\u001a\u00020\b2\t\u0010\u009c\u0002\u001a\u0004\u0018\u00010\u000fH\u0016J\t\u0010\u009d\u0002\u001a\u00020\bH\u0016J\u0012\u0010\u009e\u0002\u001a\u00020\b2\u0007\u0010\u009f\u0002\u001a\u00020\u0019H\u0016J\u0012\u0010 \u0002\u001a\u00020\b2\u0007\u0010¸\u0001\u001a\u00020\u0016H\u0016J\u0012\u0010¡\u0002\u001a\u00020\b2\u0007\u0010¢\u0002\u001a\u00020\u0016H\u0016J\u0012\u0010£\u0002\u001a\u00020\b2\u0007\u0010¤\u0002\u001a\u00020\u0016H\u0016J\u0012\u0010¥\u0002\u001a\u00020\b2\u0007\u0010¦\u0002\u001a\u00020\u0005H\u0016J\t\u0010§\u0002\u001a\u00020\bH\u0016J\u0014\u0010§\u0002\u001a\u00020\b2\t\u0010¨\u0002\u001a\u0004\u0018\u00010iH\u0016J\u0012\u0010©\u0002\u001a\u00020\b2\u0007\u0010ª\u0002\u001a\u00020\u0005H\u0016J\u0012\u0010«\u0002\u001a\u00020\b2\u0007\u0010¬\u0002\u001a\u00020\u0005H\u0016J\u0013\u0010\u00ad\u0002\u001a\u00020\b2\b\u0010o\u001a\u0004\u0018\u00010\u000fH\u0016J\u0014\u0010®\u0002\u001a\u00020\b2\t\u0010¯\u0002\u001a\u0004\u0018\u00010\u000fH\u0016J\u0014\u0010°\u0002\u001a\u00020\b2\t\u0010±\u0002\u001a\u0004\u0018\u00010tH\u0016J\u0012\u0010²\u0002\u001a\u00020\b2\u0007\u0010³\u0002\u001a\u00020\u0019H\u0016J\u0014\u0010´\u0002\u001a\u00020\b2\t\u0010µ\u0002\u001a\u0004\u0018\u00010\u000fH\u0016J\u0012\u0010¶\u0002\u001a\u00020\b2\u0007\u0010\u0083\u0001\u001a\u00020\u0016H\u0016J\u0014\u0010·\u0002\u001a\u00020\b2\t\u0010¸\u0002\u001a\u0004\u0018\u00010\u000fH\u0016J\u0012\u0010¹\u0002\u001a\u00020\b2\u0007\u0010º\u0002\u001a\u00020\u0016H\u0016J\t\u0010»\u0002\u001a\u00020\u0005H\u0016J\u0014\u0010¼\u0002\u001a\u00020\u00052\t\u0010½\u0002\u001a\u0004\u0018\u00010\u000fH\u0016J\t\u0010¾\u0002\u001a\u00020\bH\u0016J\t\u0010¿\u0002\u001a\u00020\u0005H\u0016J\t\u0010À\u0002\u001a\u00020\u0005H\u0016J\t\u0010Á\u0002\u001a\u00020\u0016H\u0016J\u001d\u0010Â\u0002\u001a\u00020\b2\b\u0010Ã\u0002\u001a\u00030Ä\u00022\b\u0010Å\u0002\u001a\u00030Æ\u0002H\u0016J\u0013\u0010Ç\u0002\u001a\u00020\b2\b\u0010Å\u0002\u001a\u00030È\u0002H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0001X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006Ê\u0002"}, d2 = {"Lcom/wear/component/dxtoy/toy/impl/ToyProxy;", "Lcom/wear/component/dxtoy/toy/interfaces/IToy;", "Lcom/wear/component/dxtoy/toy/impl/OldToyExt;", "()V", "direction", "", "toy", "addConnectTryNumb", "", "addLanApiUpdateCount", "canAddConnectingLog", "isAutoPlus", "canGetBattery", "canSetLed", "getAddress", "", "getAgString", "getAiString", "getAndUpdateDeviceId", "getBatchId", "getBattayList", "", "", "getBattery", "getBatteryRequestTime", "", "getBindType", "getCommandList", "", "getConnectApp", "getConnectScanTime", "getConnectTryNumb", "getConnectType", "getConnectedTime", "getDataBaseType", "getDefineRename", "getDeviceId", "getDeviceName", "getDeviceType", "getDeviceTypeMac", "deviceType", "getDfuIcon", "isFail", "getDisConnectType", "getEmail", "getFeedbackDownTime", "getFormApp", "getFullName", "getFunc", "Lcom/wear/bean/ToyConfigInfoBean$FuncBean;", "getGenerationVersion", "getGetCheckBindToyErrorTime", "getGetDfuErrorTime", "getId", "getIsCheckBindToy", "getIsDfuEnd", "getIsLongRange", "getIsPowerOff", "getIsSelect", "getLanApiUpdateCount", "getLdrIcon", "getLed", "getLedSetting", "getLogFormApp", "getLogToyType", "getLogToyTypeAndRssi", "stateCode", "getLvsMotorsFuncList", "Lcom/component/dxtoy/core/toy/constant/ToyCoreEum$MotorFunction;", "getMissionSolo", "getMissionTchLvl", "", "getMotors", "getMultiplayOrder", "getName", "getNewLogToyTypeAndRssi", "resultBean", "Lcom/component/dxbluetooth/lib/bean/BleResultBean;", "getNewToy", "Lcom/component/dxtoy/core/toy/ToyInfo;", "getOldEmail", "getOldId", "getOldToy", "Lcom/wear/component/dxtoy/toy/bean/OldToyBean;", "getPinStatus", "getPowerOffTime", "getProgramDefaultLevel", "getProgramDefaultProgram", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getProgramSpeed", "getRealType", "getReconnectOvertime", "getRquestConnectTime", "getRssi", "getRssiImg", "getRssiList", "getSearchToyIcon", "getShowName", "getSimpleFullName", "getSimpleName", "getSimpleType", "getStatus", "getSymbol", "getToyConfigDataBean", "Lcom/wear/bean/ToyConfigInfoBean;", "getToyIcon", "getToyRssiLevel", "getToySymbol", "getToyTypeKey", "getToyUINameSpecialForMiniXMachine", "type", "getToyVersion", "getType", "getUpCaseName", "getUpdateDfu", "Lcom/wear/bean/DfuBean;", "getUpdateTime", "getUuid", "getVersion", "getWorkMode", "getaColor", "hasProgramToy", "isAlarmEnable", "isBAToy", "isCanWearToy", "isCmdCompensation", "isConnected", "isDirection", "isEAToy", "isEI01Toy", "version", "isEL01Toy", "isEncrypt", "isF01IsNotice", "isF01IsReady", "isF01Off", "isF01Toy", "isFeedbackModeEnable", "isFeedbackModeEnableAndUpdateEnable", "isGeminiToy", "isGravity", "isH01Toy", "isJ01Toy", "isLanApiUpdateRequest", "isMax", "isMaxToy", "isMiniXMachine", "isMultiplyInstruct", "isNora", "isNoraToy", "isQ01Toy", "isQA01Toy", "isRealDeviceType", "isSelect", "isSelected", "isSetGradualSpeedUpEnable", "isSetThresholdEnable", "isSupportAir", "isSupportBt", "isSupportControlPanel", "isSupportDepthMode", "isSupportGame", "isSupportLEDColor", "isMotherboardLED", "isSupportLVS", "isSupportLdr", "isSupportR", "isSupportV1V2", "isSupportV1V2F", "isSuppportPinCode", "isSynControlAnimation", "isT01Toy", "isThridPartToy", "isToyListAdd", "isTransfer", "isV01Toy", "isVirtualToy", "isXMachine", "pushBattay", "battay", "pushCommand", "command", "pushRssi", "rssi", "reduceConnectTryNumb", "resetUseNew", "isUseNew", "setAddress", MultipleAddresses.Address.ELEMENT, "setAgString", "agString", "setAiString", "aiString", "isShowDialog", "setBatchId", "batchId", "setBattery", "battery", "setBatteryRequestTime", "batteryRequestTime", "setBindType", "bindType", "setCanRssi", "canRssi", "setConnectApp", "connectApp", "setConnectPriority", "connectPriority", "Lcom/component/dxtoy/core/toy/constant/ToyCoreEum$ConnectPriority;", "setConnectScanTime", "connectScanTime", "setConnectTryNumb", "connectTryNumb", "setConnectType", "connectType", "setConnectedTime", "connectedTime", "setDefineRename", "defineRename", "setDeviceId", "deviceId", "setDeviceName", "deviceName", "setDeviceType", "setDirection", "setDisConnectType", "disConnectType", "setEmail", "email", "setEncrypt", "encrypt", "setF01IsNotice", "f01IsNotice", "setF01IsOff", "f01IsOff", "setF01IsReady", "f01IsReady", "setFeedbackDownTime", "time", "setFormApp", "formApp", "setGetCheckBindToyErrorTime", "getCheckBindToyErrorTime", "setGetDfuErrorTime", "getDfuErrorTime", "setId", TtmlNode.ATTR_ID, "setIsCheckBindToy", "isCheckBindToy", "setIsDfuEnd", "isDfuEnd", "setIsLongRange", "isLongRange", "setIsPowerOff", "isPowerOff", "setIsSelect", "setLanApiUpdateCount", "lanApiUpdateCount", "setLanApiUpdateRequest", "setLed", "led", "setLedSetting", "ledSetting", "setLogFormApp", "logFormApp", "setLvsMotorConfig", "lvsMotorConfig", "setMissionSolo", "missionSolo", "setMissionTchLvl", "missionTchLvl", "setName", "name", "setNewToy", "toyBean", "setOldToy", "setPinStatus", "pinStatus", "setPowerOffTime", "powerOffTime", "setRealDeviceType", "realDeviceType", "setRealType", "realType", "setRenameDeviceName", "setRquestConnectTime", "requestConnectTime", "setRssi", "setSimpleToy", "simpleToy", "setStatus", "status", "setSynControlAnimation", "synControlAnimation", "setToyConfigDataBean", "toyConfigDataBean", "setToyListAdd", "toyListAdd", "setTransfer", "transfer", "setType", "setUpCaseName", "upCaseName", "setUpdateDfu", "updateDfu", "setUpdateTime", "updateTime", "setUuid", "uuid", "setVersion", "setWorkMode", "workMode", "setaColor", "aColor", "supportChangeName", "supportCommand", "message", "synNameToType", "toyIsSupport", "toyIsSupportLanApi", "typeInt", "updateMyToyBattery", "context", "Landroid/content/Context;", "imgView", "Lcom/wear/util/TextOverlayImageView;", "updateToyBattery", "Landroid/widget/ImageView;", "Companion", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class at1 extends zs1 implements bt1 {

    @NotNull
    public static final a b = new a(null);

    @NotNull
    public bt1 a = L3(mp1.a.b());

    /* compiled from: ToyProxy.kt */
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u0015\n\u0002\b\u0018\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0096\u0001J\u0013\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0006H\u0096\u0001J\u001f\u0010\t\u001a\u0004\u0018\u00010\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006H\u0096\u0001J\u001f\u0010\f\u001a\u0004\u0018\u00010\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u0006H\u0096\u0001J\u001f\u0010\u000f\u001a\u0004\u0018\u00010\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006H\u0096\u0001J\u001d\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0096\u0001J\u001d\u0010\u0015\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0096\u0001J\u001d\u0010\u0016\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0096\u0001J\u001d\u0010\u0017\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0096\u0001J\u001d\u0010\u0018\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0096\u0001J\u001d\u0010\u0019\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0096\u0001J\u001d\u0010\u001a\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0096\u0001J\u001d\u0010\u001b\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0096\u0001J\u001d\u0010\u001c\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0096\u0001J\u001d\u0010\u001d\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0096\u0001J\u0015\u0010\u001e\u001a\u0004\u0018\u00010\u00062\b\u0010\u001f\u001a\u0004\u0018\u00010\u0006H\u0096\u0001J\u0013\u0010 \u001a\u00020\u00112\b\u0010!\u001a\u0004\u0018\u00010\u0006H\u0096\u0001J\u0013\u0010\"\u001a\u00020\u00112\b\u0010!\u001a\u0004\u0018\u00010\u0006H\u0096\u0001J\u0015\u0010#\u001a\u0004\u0018\u00010\u00062\b\u0010$\u001a\u0004\u0018\u00010\u0006H\u0096\u0001J\u001f\u0010%\u001a\u0004\u0018\u00010\u00062\b\u0010&\u001a\u0004\u0018\u00010\u00062\b\u0010'\u001a\u0004\u0018\u00010\u0006H\u0096\u0001J\u0015\u0010(\u001a\u0004\u0018\u00010\u00062\b\u0010&\u001a\u0004\u0018\u00010\u0006H\u0096\u0001J\u0015\u0010)\u001a\u0004\u0018\u00010\u00062\b\u0010!\u001a\u0004\u0018\u00010\u0006H\u0096\u0001J\u0013\u0010*\u001a\u00020\u00112\b\u0010!\u001a\u0004\u0018\u00010\u0006H\u0096\u0001J\u0013\u0010+\u001a\u00020\u00112\b\u0010!\u001a\u0004\u0018\u00010\u0006H\u0096\u0001J-\u0010,\u001a\u0004\u0018\u00010-2\b\u0010&\u001a\u0004\u0018\u00010\u00062\u0006\u0010.\u001a\u00020\u00112\u0006\u0010/\u001a\u00020\u00112\u0006\u00100\u001a\u00020\u0004H\u0096\u0001J\u0015\u00101\u001a\u0004\u0018\u00010\u00062\b\u0010&\u001a\u0004\u0018\u00010\u0006H\u0096\u0001J#\u00102\u001a\u00020\u00112\b\u0010\u001f\u001a\u0004\u0018\u00010\u00062\u0006\u00103\u001a\u00020\u00112\u0006\u00104\u001a\u00020\u0004H\u0096\u0001J\u0015\u00105\u001a\u0004\u0018\u00010\u00062\b\u00106\u001a\u0004\u0018\u00010\u0006H\u0096\u0001J\u0013\u00107\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0096\u0001J\u0013\u00108\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0096\u0001J\u0013\u00109\u001a\u00020\u00042\b\u00106\u001a\u0004\u0018\u00010\u0006H\u0096\u0001J\u0013\u0010:\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0096\u0001J\u0013\u0010;\u001a\u00020\u00042\b\u0010<\u001a\u0004\u0018\u00010\u0006H\u0096\u0001J\u0013\u0010=\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0006H\u0096\u0001J\u0013\u0010>\u001a\u00020\u00042\b\u0010?\u001a\u0004\u0018\u00010\u0006H\u0096\u0001J\u001b\u0010@\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0096\u0001J!\u0010A\u001a\u00020\u00112\u0006\u0010B\u001a\u00020\u00042\u0006\u0010C\u001a\u00020\u00042\u0006\u0010D\u001a\u00020\u0011H\u0096\u0001J\u0011\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020\u0006H\u0096\u0001J\u001b\u0010H\u001a\u00020F2\b\u0010I\u001a\u0004\u0018\u00010J2\u0006\u0010D\u001a\u00020\u0011H\u0096\u0001J\u001b\u0010K\u001a\u00020F2\b\u0010I\u001a\u0004\u0018\u00010J2\u0006\u0010D\u001a\u00020\u0011H\u0096\u0001¨\u0006L"}, d2 = {"Lcom/wear/component/dxtoy/toy/impl/ToyProxy$Companion;", "Lcom/wear/component/dxtoy/toy/interfaces/IToyExt;", "()V", "canAddAddressToNeedConnect", "", "message", "", "canBind", "deviceType", "changeSinglefuncLineToTayValue", "tags", "groups", "changeSinglefuncLineToToyValue", "tag", "group", "changeToyValueToSinglefuncLine", "existDepthfund", "", "funcs", "view", "Landroid/view/View;", "existPumpVFunc", "existRotationVFunc", "existSecondVibratorVFunc", "existSpeedFuns", "existSuckFunc", "existThirdVibratorVFunc", "existVibratorFunV", "existfingerFunf", "existfingerFunt", "generateType", "type", "getCurveLineColor", "toyFunc", "getCurveLineTransColor", "getFullName", "symblo", "getLableTitle", "toyType", "lableTitle", "getLdrToyFunction", "getNameByFun", "getSeekbarProgress", "getSeekbarThumb", "getToyFuncIcon", "", "total", FirebaseAnalytics.Param.INDEX, "selected", "getToyFunction", "getToyIconLinkedId", "rows", StreamManagement.Enable.ELEMENT, "getToyTypeByFunc", "function", "isAgArrayMessage", "isAiTypeMessage", "isContainFunction", "isDeviceTypeMessage", "isOurToy", "name", "isOurType", "isPin", NotificationCompat.CATEGORY_MESSAGE, "isVelvoFunt", "setBatteryImage", "isToyList", "isTran", "battery", "setToyConfig", "", "data", "updateToyBattery", "toy_battery_img", "Landroid/widget/ImageView;", "updateToyBatteryTrans", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        public final /* synthetic */ at1 a;

        public a() {
            this.a = new at1();
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public int A(@Nullable String str, int i, boolean z) {
            return this.a.t3(str, i, z);
        }

        @Nullable
        public String B(@Nullable String str) {
            return this.a.u3(str);
        }

        public boolean C(@Nullable String str) {
            return this.a.v3(str);
        }

        public boolean D(@Nullable String str) {
            return this.a.w3(str);
        }

        public boolean E(@Nullable String str) {
            return this.a.x3(str);
        }

        public boolean F(@Nullable String str) {
            return this.a.y3(str);
        }

        public boolean G(@Nullable String str) {
            return this.a.z3(str);
        }

        public boolean H(@Nullable String str) {
            return this.a.A3(str);
        }

        public boolean I(@Nullable String str) {
            return this.a.B3(str);
        }

        public int J(@NotNull String funcs, @Nullable View view) {
            Intrinsics.checkNotNullParameter(funcs, "funcs");
            return this.a.C3(funcs, view);
        }

        public int K(boolean z, boolean z2, int i) {
            return this.a.D3(z, z2, i);
        }

        public void L(@NotNull String data) {
            Intrinsics.checkNotNullParameter(data, "data");
            this.a.E3(data);
        }

        public void M(@Nullable ImageView imageView, int i) {
            this.a.F3(imageView, i);
        }

        public void N(@Nullable ImageView imageView, int i) {
            this.a.G3(imageView, i);
        }

        public boolean a(@Nullable String str) {
            return this.a.T2(str);
        }

        public boolean b(@Nullable String str) {
            return this.a.U2(str);
        }

        @Nullable
        public String c(@Nullable String str, @Nullable String str2) {
            return this.a.V2(str, str2);
        }

        @Nullable
        public String d(@Nullable String str, @Nullable String str2) {
            return this.a.W2(str, str2);
        }

        @Nullable
        public String e(@Nullable String str, @Nullable String str2) {
            return this.a.X2(str, str2);
        }

        public int f(@Nullable String str, @Nullable View view) {
            return this.a.Y2(str, view);
        }

        public int g(@Nullable String str, @Nullable View view) {
            return this.a.Z2(str, view);
        }

        public int h(@Nullable String str, @Nullable View view) {
            return this.a.a3(str, view);
        }

        public int i(@Nullable String str, @Nullable View view) {
            return this.a.b3(str, view);
        }

        public int j(@Nullable String str, @Nullable View view) {
            return this.a.c3(str, view);
        }

        public int k(@Nullable String str, @Nullable View view) {
            return this.a.d3(str, view);
        }

        public int l(@Nullable String str, @Nullable View view) {
            return this.a.e3(str, view);
        }

        public int m(@Nullable String str, @Nullable View view) {
            return this.a.f3(str, view);
        }

        public int n(@Nullable String str, @Nullable View view) {
            return this.a.g3(str, view);
        }

        public int o(@Nullable String str, @Nullable View view) {
            return this.a.h3(str, view);
        }

        @Nullable
        public String p(@Nullable String str) {
            return this.a.i3(str);
        }

        public int q(@Nullable String str) {
            return this.a.j3(str);
        }

        public int r(@Nullable String str) {
            return this.a.k3(str);
        }

        @Nullable
        public String s(@Nullable String str) {
            return this.a.l3(str);
        }

        @Nullable
        public String t(@Nullable String str, @Nullable String str2) {
            return this.a.m3(str, str2);
        }

        @Nullable
        public String u(@Nullable String str) {
            return this.a.n3(str);
        }

        @Nullable
        public String v(@Nullable String str) {
            return this.a.o3(str);
        }

        public int w(@Nullable String str) {
            return this.a.p3(str);
        }

        public int x(@Nullable String str) {
            return this.a.q3(str);
        }

        @Nullable
        public int[] y(@Nullable String str, int i, int i2, boolean z) {
            return this.a.r3(str, i, i2, z);
        }

        @Nullable
        public String z(@Nullable String str) {
            return this.a.s3(str);
        }
    }

    @Override // dc.bt1
    public boolean A() {
        return this.a.A();
    }

    @Override // dc.bt1
    public boolean A0() {
        return this.a.A0();
    }

    @Override // dc.bt1
    @Nullable
    /* renamed from: A1 */
    public int[] getE() {
        return this.a.getE();
    }

    @Override // dc.bt1
    @Nullable
    /* renamed from: A2 */
    public DfuBean getN() {
        return this.a.getN();
    }

    @Override // dc.bt1
    public void B(boolean z) {
        this.a.B(z);
    }

    @Override // dc.bt1
    @Nullable
    public String B0() {
        return this.a.B0();
    }

    @Override // dc.bt1
    public void B1(long j) {
        this.a.B1(j);
    }

    @Override // dc.bt1
    public void B2(@Nullable String str) {
        this.a.B2(str);
    }

    @Override // dc.bt1
    @Nullable
    public String C() {
        return this.a.C();
    }

    @Override // dc.bt1
    public void C0(boolean z) {
        this.a.C0(z);
    }

    @Override // dc.bt1
    public boolean C1() {
        return this.a.C1();
    }

    @Override // dc.bt1
    public void C2(int i) {
        this.a.C2(i);
    }

    @Override // dc.bt1
    public boolean D() {
        return this.a.D();
    }

    @Override // dc.bt1
    public void D0(int i) {
        this.a.D0(i);
    }

    @Override // dc.bt1
    @Nullable
    public String D1() {
        return this.a.D1();
    }

    @Override // dc.bt1
    /* renamed from: D2 */
    public boolean getY() {
        return this.a.getY();
    }

    @Override // dc.bt1
    public boolean E() {
        return this.a.E();
    }

    @Override // dc.bt1
    public void E0(long j) {
        this.a.E0(j);
    }

    @Override // dc.bt1
    /* renamed from: E1 */
    public int getM() {
        return this.a.getM();
    }

    @Override // dc.bt1
    public void E2(@Nullable String str) {
        this.a.E2(str);
    }

    @Override // dc.bt1
    public void F(int i) {
        this.a.F(i);
    }

    @Override // dc.bt1
    @Nullable
    public ToyConfigInfoBean F0() {
        return this.a.F0();
    }

    @Override // dc.bt1
    public void F1(@Nullable String str) {
        this.a.F1(str);
    }

    @Override // dc.bt1
    public void F2() {
        this.a.F2();
    }

    @Override // dc.bt1
    @Nullable
    public String G() {
        return this.a.G();
    }

    @Override // dc.bt1
    public boolean G0() {
        return this.a.G0();
    }

    @Override // dc.bt1
    public void G1(@Nullable String str) {
        this.a.G1(str);
    }

    @Override // dc.bt1
    public void G2(boolean z) {
        this.a.G2(z);
    }

    @Override // dc.bt1
    public void H(@Nullable ToyConfigInfoBean toyConfigInfoBean) {
        this.a.H(toyConfigInfoBean);
    }

    @Override // dc.bt1
    @Nullable
    /* renamed from: H0 */
    public String getL() {
        return this.a.getL();
    }

    @Override // dc.bt1
    @Nullable
    /* renamed from: H1 */
    public String getW() {
        return this.a.getW();
    }

    @Override // dc.bt1
    @Nullable
    public List<String> H2() {
        return this.a.H2();
    }

    @NotNull
    public final ToyConfigInfoBean.FuncBean H3() {
        ToyConfigInfoBean toyConfigInfoBeanF0 = this.a.F0();
        ToyConfigInfoBean.FuncBean func = toyConfigInfoBeanF0 != null ? toyConfigInfoBeanF0.getFunc() : null;
        if (func != null) {
            return func;
        }
        ToyConfigInfoBean.FuncBean funcBean = new ToyConfigInfoBean.FuncBean();
        funcBean.setV(true);
        return funcBean;
    }

    @Override // dc.bt1
    public boolean I() {
        return this.a.I();
    }

    @Override // dc.bt1
    @Nullable
    public String I0(int i) {
        return this.a.I0(i);
    }

    @Override // dc.bt1
    public boolean I1() {
        return this.a.I1();
    }

    @Override // dc.bt1
    public void I2(int i) {
        this.a.I2(i);
    }

    @Nullable
    public final nb0 I3() {
        if (!mp1.a.b()) {
            return null;
        }
        bt1 bt1Var = this.a;
        xs1 xs1Var = bt1Var instanceof xs1 ? (xs1) bt1Var : null;
        if (xs1Var != null) {
            return xs1Var.getA();
        }
        return null;
    }

    @Override // dc.bt1
    @Nullable
    public List<String> J() {
        return this.a.J();
    }

    @Override // dc.bt1
    public boolean J0() {
        return this.a.J0();
    }

    @Override // dc.bt1
    /* renamed from: J1 */
    public long getG() {
        return this.a.getG();
    }

    @Override // dc.bt1
    @Nullable
    public String J2() {
        return this.a.J2();
    }

    @Nullable
    public final ws1 J3() {
        if (mp1.a.b()) {
            return null;
        }
        bt1 bt1Var = this.a;
        ys1 ys1Var = bt1Var instanceof ys1 ? (ys1) bt1Var : null;
        if (ys1Var != null) {
            return ys1Var.getA();
        }
        return null;
    }

    @Override // dc.bt1
    @Nullable
    public String K() {
        return this.a.K();
    }

    @Override // dc.bt1
    public void K0(@Nullable String str) {
        this.a.K0(str);
    }

    @Override // dc.bt1
    /* renamed from: K1 */
    public int getV() {
        return this.a.getV();
    }

    @Override // dc.bt1
    /* renamed from: K2 */
    public boolean getG() {
        return this.a.getG();
    }

    public boolean K3() {
        return this.a.j1();
    }

    @Override // dc.bt1
    @Nullable
    /* renamed from: L */
    public String getK() {
        return this.a.getK();
    }

    @Override // dc.bt1
    @Nullable
    public String L0() {
        return this.a.L0();
    }

    @Override // dc.bt1
    public boolean L1() {
        return this.a.L1();
    }

    @Override // dc.bt1
    /* renamed from: L2 */
    public long getP() {
        return this.a.getP();
    }

    @NotNull
    public final bt1 L3(boolean z) {
        bt1 xs1Var = z ? new xs1() : new ys1();
        this.a = xs1Var;
        return xs1Var;
    }

    @Override // dc.bt1
    public boolean M() {
        return this.a.M();
    }

    @Override // dc.bt1
    public int M0() {
        return this.a.M0();
    }

    @Override // dc.bt1
    public void M1(boolean z) {
        this.a.M1(z);
    }

    @Override // dc.bt1
    public boolean M2() {
        return this.a.M2();
    }

    public final void M3(@NotNull nb0 toyBean) {
        Intrinsics.checkNotNullParameter(toyBean, "toyBean");
        if (TextUtils.isEmpty(toyBean.getId())) {
            String str = "toyBean.id is null:" + toyBean.getMac();
        }
        if (mp1.a.b()) {
            bt1 bt1Var = this.a;
            xs1 xs1Var = bt1Var instanceof xs1 ? (xs1) bt1Var : null;
            if (xs1Var != null) {
                xs1Var.U2(toyBean);
            }
        }
    }

    @Override // dc.bt1
    public void N(@Nullable String str) {
        this.a.N(str);
    }

    @Override // dc.bt1
    public void N0(int i) {
        this.a.N0(i);
    }

    @Override // dc.bt1
    public void N1(@Nullable String str) {
        this.a.N1(str);
    }

    @Override // dc.bt1
    public void N2(@Nullable String str) {
        this.a.N2(str);
    }

    public final void N3(@NotNull ws1 toyBean) {
        Intrinsics.checkNotNullParameter(toyBean, "toyBean");
        if (mp1.a.b()) {
            return;
        }
        bt1 bt1Var = this.a;
        ys1 ys1Var = bt1Var instanceof ys1 ? (ys1) bt1Var : null;
        if (ys1Var != null) {
            ys1Var.U2(toyBean);
        }
    }

    @Override // dc.bt1
    public boolean O() {
        return this.a.O();
    }

    @Override // dc.bt1
    @Nullable
    public String O0() {
        return this.a.O0();
    }

    @Override // dc.bt1
    public boolean O1() {
        return this.a.O1();
    }

    @Override // dc.bt1
    public void O2(@Nullable String str) {
        this.a.O2(str);
    }

    @Override // dc.bt1
    @Nullable
    public String P() {
        return this.a.P();
    }

    @Override // dc.bt1
    @NotNull
    public String P0() {
        return this.a.P0();
    }

    @Override // dc.bt1
    @Nullable
    public String P1() {
        return this.a.P1();
    }

    @Override // dc.bt1
    /* renamed from: P2 */
    public int getD() {
        return this.a.getD();
    }

    @Override // dc.bt1
    /* renamed from: Q */
    public long getJ() {
        return this.a.getJ();
    }

    @Override // dc.bt1
    /* renamed from: Q0 */
    public boolean getJ() {
        return this.a.getJ();
    }

    @Override // dc.bt1
    public int Q1() {
        return this.a.Q1();
    }

    @Override // dc.bt1
    public void Q2(int i) {
        this.a.Q2(i);
    }

    @Override // dc.bt1
    public void R(int i) {
        this.a.R(i);
    }

    @Override // dc.bt1
    /* renamed from: R0 */
    public long getF() {
        return this.a.getF();
    }

    @Override // dc.bt1
    public void R1(@Nullable String str) {
        this.a.R1(str);
    }

    @Override // dc.bt1
    public boolean R2() {
        return this.a.R2();
    }

    @Override // dc.bt1
    public boolean S(boolean z) {
        return this.a.S(z);
    }

    @Override // dc.bt1
    @Nullable
    public String S0() {
        return this.a.S0();
    }

    @Override // dc.bt1
    @Nullable
    public String S1() {
        return this.a.S1();
    }

    @Override // dc.bt1
    public int S2() {
        return this.a.S2();
    }

    @Override // dc.bt1
    public void T(int i) {
        this.a.T(i);
    }

    @Override // dc.bt1
    @NotNull
    public List<qb0> T0() {
        return this.a.T0();
    }

    @Override // dc.bt1
    public boolean T1() {
        return this.a.T1();
    }

    @Override // dc.bt1
    /* renamed from: U */
    public boolean getI() {
        return this.a.getI();
    }

    @Override // dc.bt1
    @Nullable
    public String U0() {
        return this.a.U0();
    }

    @Override // dc.bt1
    /* renamed from: U1 */
    public long getA() {
        return this.a.getA();
    }

    @Override // dc.bt1
    public void V(@Nullable String str) {
        this.a.V(str);
    }

    @Override // dc.bt1
    public boolean V0(boolean z) {
        return this.a.V0(z);
    }

    @Override // dc.bt1
    public boolean V1() {
        return this.a.V1();
    }

    @Override // dc.bt1
    public int W() {
        return this.a.W();
    }

    @Override // dc.bt1
    public int W0() {
        return this.a.W0();
    }

    @Override // dc.bt1
    public void W1(@Nullable String str) {
        this.a.W1(str);
    }

    @Override // dc.bt1
    /* renamed from: X */
    public long getU() {
        return this.a.getU();
    }

    @Override // dc.bt1
    public void X0() {
        this.a.X0();
    }

    @Override // dc.bt1
    public long X1() {
        return this.a.X1();
    }

    @Override // dc.bt1
    @Nullable
    public ArrayList<String> Y() {
        return this.a.Y();
    }

    @Override // dc.bt1
    @Nullable
    /* renamed from: Y0 */
    public String getX() {
        return this.a.getX();
    }

    @Override // dc.bt1
    public void Y1(int i) {
        this.a.Y1(i);
    }

    @Override // dc.bt1
    public boolean Z() {
        return this.a.Z();
    }

    @Override // dc.bt1
    public void Z0(int i) {
        this.a.Z0(i);
    }

    @Override // dc.bt1
    public boolean Z1(int i) {
        return this.a.Z1(i);
    }

    @Override // dc.bt1
    public boolean a() {
        return this.a.a();
    }

    @Override // dc.bt1
    public int a0() {
        return this.a.a0();
    }

    @Override // dc.bt1
    @Nullable
    /* renamed from: a1 */
    public String getO() {
        return this.a.getO();
    }

    @Override // dc.bt1
    public void a2(boolean z) {
        this.a.a2(z);
    }

    @Override // dc.bt1
    public boolean b() {
        return this.a.b();
    }

    @Override // dc.bt1
    /* renamed from: b0 */
    public int getZ() {
        return this.a.getZ();
    }

    @Override // dc.bt1
    public void b1(long j) {
        this.a.b1(j);
    }

    @Override // dc.bt1
    public void b2(int i) {
        this.a.b2(i);
    }

    @Override // dc.bt1
    public void c(@Nullable DfuBean dfuBean) {
        this.a.c(dfuBean);
    }

    @Override // dc.bt1
    public void c0(int i) {
        this.a.c0(i);
    }

    @Override // dc.bt1
    public void c1(@Nullable String str, boolean z) {
        this.a.c1(str, z);
    }

    @Override // dc.bt1
    @Nullable
    public int[] c2() {
        return this.a.c2();
    }

    @Override // dc.bt1
    public boolean canSetLed() {
        return this.a.canSetLed();
    }

    @Override // dc.bt1
    public void d(int i) {
        this.a.d(i);
    }

    @Override // dc.bt1
    public void d0() {
        this.a.d0();
    }

    @Override // dc.bt1
    public void d1(long j) {
        this.a.d1(j);
    }

    @Override // dc.bt1
    public boolean d2() {
        return this.a.d2();
    }

    @Override // dc.bt1
    public void e(@Nullable String str) {
        this.a.e(str);
    }

    @Override // dc.bt1
    public void e0() {
        this.a.e0();
    }

    @Override // dc.bt1
    public boolean e1() {
        return this.a.e1();
    }

    @Override // dc.bt1
    public void e2(long j) {
        this.a.e2(j);
    }

    @Override // dc.bt1
    public void f(@Nullable String str) {
        this.a.f(str);
    }

    @Override // dc.bt1
    /* renamed from: f0 */
    public long getD() {
        return this.a.getD();
    }

    @Override // dc.bt1
    public int f1(boolean z) {
        return this.a.f1(z);
    }

    @Override // dc.bt1
    public boolean f2() {
        return this.a.f2();
    }

    @Override // dc.bt1
    public void g(long j) {
        this.a.g(j);
    }

    @Override // dc.bt1
    @Nullable
    public String g0() {
        return this.a.g0();
    }

    @Override // dc.bt1
    public void g1(int i) {
        this.a.g1(i);
    }

    @Override // dc.bt1
    public boolean g2() {
        return this.a.g2();
    }

    @Override // dc.bt1
    @Nullable
    public String getEmail() {
        return this.a.getEmail();
    }

    @Override // dc.bt1
    @Nullable
    public String getId() {
        return this.a.getId();
    }

    @Override // dc.bt1
    public int getLdrIcon() {
        return this.a.getLdrIcon();
    }

    @Override // dc.bt1
    @Nullable
    public String getName() {
        return this.a.getName();
    }

    @Override // dc.bt1
    @NotNull
    public String getShowName() {
        return this.a.getShowName();
    }

    @Override // dc.bt1
    @Nullable
    public String getSimpleName() {
        return this.a.getSimpleName();
    }

    @Override // dc.bt1
    public int getStatus() {
        return this.a.getStatus();
    }

    @Override // dc.bt1
    @Nullable
    public String getType() {
        return this.a.getType();
    }

    @Override // dc.bt1
    public int getVersion() {
        return this.a.getVersion();
    }

    @Override // dc.bt1
    @Nullable
    public String h() {
        return this.a.h();
    }

    @Override // dc.bt1
    public int h0() {
        return this.a.h0();
    }

    @Override // dc.bt1
    public void h1(int i) {
        this.a.h1(i);
    }

    @Override // dc.bt1
    public boolean h2() {
        return this.a.h2();
    }

    @Override // dc.bt1
    public boolean i() {
        return this.a.i();
    }

    @Override // dc.bt1
    /* renamed from: i0 */
    public boolean getH() {
        return this.a.getH();
    }

    @Override // dc.bt1
    /* renamed from: i1 */
    public int getS() {
        return this.a.getS();
    }

    @Override // dc.bt1
    public void i2(@Nullable String str) {
        this.a.i2(str);
    }

    @Override // dc.bt1
    public boolean isConnected() {
        return this.a.isConnected();
    }

    @Override // dc.bt1
    public boolean isMax() {
        return this.a.isMax();
    }

    @Override // dc.bt1
    public boolean isSupportBt() {
        return this.a.isSupportBt();
    }

    @Override // dc.bt1
    public boolean isSupportControlPanel() {
        return this.a.isSupportControlPanel();
    }

    @Override // dc.bt1
    public boolean isSupportDepthMode() {
        return this.a.isSupportDepthMode();
    }

    @Override // dc.bt1
    public boolean isSupportGame() {
        return this.a.isSupportGame();
    }

    @Override // dc.bt1
    public boolean isSupportLdr() {
        return this.a.isSupportLdr();
    }

    @Override // dc.bt1
    public boolean isThridPartToy() {
        return this.a.isThridPartToy();
    }

    @Override // dc.bt1
    public boolean isVirtualToy() {
        return this.a.isVirtualToy();
    }

    @Override // dc.bt1
    public void j(@NotNull ImageView imgView) {
        Intrinsics.checkNotNullParameter(imgView, "imgView");
        this.a.j(imgView);
    }

    @Override // dc.bt1
    public boolean j0() {
        return this.a.j0();
    }

    @Override // dc.bt1
    public boolean j1() {
        return this.a.j1();
    }

    @Override // dc.bt1
    public void j2(@Nullable String str) {
        this.a.j2(str);
    }

    @Override // dc.bt1
    public void k(long j) {
        this.a.k(j);
    }

    @Override // dc.bt1
    public void k0(boolean z) {
        this.a.k0(z);
    }

    @Override // dc.bt1
    public void k1(@Nullable String str) {
        this.a.k1(str);
    }

    @Override // dc.bt1
    public int k2() {
        return this.a.k2();
    }

    @Override // dc.bt1
    public boolean l() {
        return this.a.l();
    }

    @Override // dc.bt1
    public void l0(boolean z) {
        this.a.l0(z);
    }

    @Override // dc.bt1
    public void l1(@NotNull int[] missionTchLvl) {
        Intrinsics.checkNotNullParameter(missionTchLvl, "missionTchLvl");
        this.a.l1(missionTchLvl);
    }

    @Override // dc.bt1
    public int l2() {
        return this.a.l2();
    }

    @Override // dc.bt1
    /* renamed from: m */
    public long getQ() {
        return this.a.getQ();
    }

    @Override // dc.bt1
    public void m0(boolean z) {
        this.a.m0(z);
    }

    @Override // dc.bt1
    /* renamed from: m1 */
    public boolean getF() {
        return this.a.getF();
    }

    @Override // dc.bt1
    @Nullable
    public String m2() {
        return this.a.m2();
    }

    @Override // dc.bt1
    /* renamed from: n */
    public boolean getK() {
        return this.a.getK();
    }

    @Override // dc.bt1
    public boolean n0() {
        return this.a.n0();
    }

    @Override // dc.bt1
    @Nullable
    public List<Integer> n1() {
        return this.a.n1();
    }

    @Override // dc.bt1
    public int n2() {
        return this.a.n2();
    }

    @Override // dc.bt1
    @Nullable
    public List<Map<String, Long>> o() {
        return this.a.o();
    }

    @Override // dc.bt1
    public void o0() {
        this.a.o0();
    }

    @Override // dc.bt1
    public void o1(@Nullable String str) {
        this.a.o1(str);
    }

    @Override // dc.bt1
    /* renamed from: o2 */
    public int getH() {
        return this.a.getH();
    }

    @Override // dc.bt1
    public void p(int i) {
        this.a.p(i);
    }

    @Override // dc.bt1
    public boolean p0() {
        return this.a.p0();
    }

    @Override // dc.bt1
    public void p1() {
        this.a.p1();
    }

    @Override // dc.bt1
    public int p2() {
        return this.a.p2();
    }

    @Override // dc.bt1
    @Nullable
    public String q() {
        return this.a.q();
    }

    @Override // dc.bt1
    public int q0() {
        return this.a.q0();
    }

    @Override // dc.bt1
    @Nullable
    public String q1(@Nullable BleResultBean bleResultBean) {
        return this.a.q1(bleResultBean);
    }

    @Override // dc.bt1
    @Nullable
    public String q2(int i) {
        return this.a.q2(i);
    }

    @Override // dc.bt1
    public void r(@Nullable String str) {
        this.a.r(str);
    }

    @Override // dc.bt1
    /* renamed from: r0 */
    public boolean getE() {
        return this.a.getE();
    }

    @Override // dc.bt1
    public int r1() {
        return this.a.r1();
    }

    @Override // dc.bt1
    public boolean r2(int i) {
        return this.a.r2(i);
    }

    @Override // dc.bt1
    public void s(boolean z) {
        this.a.s(z);
    }

    @Override // dc.bt1
    public boolean s0() {
        return this.a.s0();
    }

    @Override // dc.bt1
    @Nullable
    public String s1() {
        return this.a.s1();
    }

    @Override // dc.bt1
    public void s2(int i) {
        this.a.s2(i);
    }

    @Override // dc.bt1
    public void setVersion(int version) {
        this.a.setVersion(version);
    }

    @Override // dc.bt1
    public boolean supportCommand(@Nullable String message) {
        return this.a.supportCommand(message);
    }

    @Override // dc.bt1
    public void t(boolean z) {
        this.a.t(z);
    }

    @Override // dc.bt1
    public void t0(boolean z) {
        this.a.t0(z);
    }

    @Override // dc.bt1
    public boolean t1() {
        return this.a.t1();
    }

    @Override // dc.bt1
    public boolean t2() {
        return this.a.t2();
    }

    @Override // dc.bt1
    public void u(long j) {
        this.a.u(j);
    }

    @Override // dc.bt1
    @Nullable
    /* renamed from: u0 */
    public String getB() {
        return this.a.getB();
    }

    @Override // dc.bt1
    public void u1(int i) {
        this.a.u1(i);
    }

    @Override // dc.bt1
    public void u2(@NotNull ob0 connectPriority) {
        Intrinsics.checkNotNullParameter(connectPriority, "connectPriority");
        this.a.u2(connectPriority);
    }

    @Override // dc.bt1
    public void v(@Nullable String str) {
        this.a.v(str);
    }

    @Override // dc.bt1
    public boolean v0() {
        return this.a.v0();
    }

    @Override // dc.bt1
    public boolean v1() {
        return this.a.v1();
    }

    @Override // dc.bt1
    public int v2() {
        return this.a.v2();
    }

    @Override // dc.bt1
    /* renamed from: w */
    public int getT() {
        return this.a.getT();
    }

    @Override // dc.bt1
    public boolean w0() {
        return this.a.w0();
    }

    @Override // dc.bt1
    @Nullable
    public String w1() {
        return this.a.w1();
    }

    @Override // dc.bt1
    /* renamed from: w2 */
    public int getC() {
        return this.a.getC();
    }

    @Override // dc.bt1
    public int x() {
        return this.a.x();
    }

    @Override // dc.bt1
    public boolean x0() {
        return this.a.x0();
    }

    @Override // dc.bt1
    @NotNull
    public List<List<String>> x1() {
        List<List<String>> listX1 = this.a.x1();
        return listX1.isEmpty() ? CollectionsKt__CollectionsKt.mutableListOf(CollectionsKt__CollectionsJVMKt.listOf(PSOProgramService.VS_Key)) : listX1;
    }

    @Override // dc.bt1
    public void x2(int i) {
        this.a.x2(i);
    }

    @Override // dc.bt1
    public void y(int i) {
        this.a.y(i);
    }

    @Override // dc.bt1
    public boolean y0() {
        return this.a.y0();
    }

    @Override // dc.bt1
    public int y1() {
        return this.a.y1();
    }

    @Override // dc.bt1
    /* renamed from: y2 */
    public int getI() {
        return this.a.getI();
    }

    @Override // dc.bt1
    public void z(@NotNull Context context, @NotNull TextOverlayImageView imgView) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(imgView, "imgView");
        this.a.z(context, imgView);
    }

    @Override // dc.bt1
    public void z0(long j) {
        this.a.z0(j);
    }

    @Override // dc.bt1
    public void z1(int i) {
        this.a.z1(i);
    }

    @Override // dc.bt1
    @Nullable
    public String z2(@Nullable String str) {
        return this.a.z2(str);
    }
}
