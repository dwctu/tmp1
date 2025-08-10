package dc;

import android.content.Context;
import android.widget.ImageView;
import androidx.core.os.EnvironmentCompat;
import com.component.dxbluetooth.lib.bean.BleResultBean;
import com.epicgames.unreal.psoservices.PSOProgramService;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.lovense.wear.R;
import com.wear.bean.DfuBean;
import com.wear.bean.Toy;
import com.wear.bean.ToyConfigInfoBean;
import com.wear.bean.ToyRename;
import com.wear.dao.DaoUtils;
import com.wear.util.MyApplication;
import com.wear.util.TextOverlayImageView;
import com.wear.util.WearUtils;
import com.xtremeprog.sdk.ble.BleService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.StringsKt___StringsKt;
import org.aspectj.runtime.reflect.SignatureImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smack.sm.packet.StreamManagement;
import org.jivesoftware.smackx.address.packet.MultipleAddresses;
import org.jivesoftware.smackx.xhtmlim.XHTMLText;

/* compiled from: NewToy.kt */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\b\u0017\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\b)\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\bj\n\u0002\u0018\u0002\n\u0002\bX\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u00104\u001a\u000205H\u0016J\b\u00106\u001a\u000205H\u0016J\u0010\u00107\u001a\u00020\f2\u0006\u00108\u001a\u00020\fH\u0016J\b\u00109\u001a\u00020\fH\u0016J\b\u0010:\u001a\u00020\fH\u0016J\b\u0010;\u001a\u00020\u0004H\u0016J\n\u0010<\u001a\u0004\u0018\u00010\u0004H\u0016J\n\u0010=\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010>\u001a\u00020\u0004H\u0016J\n\u0010?\u001a\u0004\u0018\u00010\u0004H\u0016J\u0010\u0010@\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010AH\u0016J\b\u0010B\u001a\u00020\nH\u0016J\b\u0010C\u001a\u00020\bH\u0016J\b\u0010D\u001a\u00020\nH\u0016J \u0010E\u001a\u001a\u0012\u0014\u0012\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\b\u0018\u00010\u000e\u0018\u00010AH\u0016J\b\u0010F\u001a\u00020\nH\u0016J\b\u0010G\u001a\u00020\bH\u0016J\b\u0010H\u001a\u00020\nH\u0016J\b\u0010I\u001a\u00020\nH\u0016J\b\u0010J\u001a\u00020\bH\u0016J\n\u0010K\u001a\u0004\u0018\u00010\u0004H\u0016J\n\u0010L\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010M\u001a\u00020\u0004H\u0016J\n\u0010N\u001a\u0004\u0018\u00010\u0004H\u0016J\n\u0010O\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010P\u001a\u00020\u00042\b\u0010Q\u001a\u0004\u0018\u00010\u0004H\u0016J\u0010\u0010R\u001a\u00020\n2\u0006\u0010S\u001a\u00020\fH\u0016J\b\u0010T\u001a\u00020\nH\u0016J\n\u0010U\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010V\u001a\u00020\bH\u0016J\n\u0010W\u001a\u0004\u0018\u00010\u0004H\u0016J\n\u0010X\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010Y\u001a\u00020\u0004H\u0016J\b\u0010Z\u001a\u00020\bH\u0016J\b\u0010[\u001a\u00020\bH\u0016J\n\u0010\\\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010]\u001a\u00020\nH\u0016J\b\u0010^\u001a\u00020\nH\u0016J\b\u0010_\u001a\u00020\nH\u0016J\b\u0010`\u001a\u00020\nH\u0016J\b\u0010a\u001a\u00020\nH\u0016J\b\u0010b\u001a\u00020\nH\u0016J\b\u0010c\u001a\u00020\nH\u0016J\b\u0010d\u001a\u00020\nH\u0016J\b\u0010e\u001a\u00020\nH\u0016J\n\u0010f\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010g\u001a\u00020\u0004H\u0016J\u0012\u0010h\u001a\u0004\u0018\u00010\u00042\u0006\u0010i\u001a\u00020\nH\u0016J\u000e\u0010j\u001a\b\u0012\u0004\u0012\u00020k0AH\u0016J\b\u0010l\u001a\u00020\nH\u0016J\b\u0010m\u001a\u00020&H\u0016J\u0014\u0010n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040A0AH\u0016J\n\u0010o\u001a\u0004\u0018\u00010\u0004H\u0016J\n\u0010p\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010q\u001a\u00020\u00042\b\u0010r\u001a\u0004\u0018\u00010sH\u0016J\n\u0010t\u001a\u0004\u0018\u00010\u0004H\u0016J\n\u0010u\u001a\u0004\u0018\u00010\u0004H\u0016J\n\u0010v\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010w\u001a\u00020\bH\u0016J\b\u0010x\u001a\u00020&H\u0016J\u0018\u0010y\u001a\u0012\u0012\u0004\u0012\u00020\u00040zj\b\u0012\u0004\u0012\u00020\u0004`{H\u0016J\b\u0010|\u001a\u00020\nH\u0016J\u0006\u0010}\u001a\u00020(J\b\u0010~\u001a\u00020\u0004H\u0016J\b\u0010\u007f\u001a\u00020\fH\u0016J\t\u0010\u0080\u0001\u001a\u00020\bH\u0016J\t\u0010\u0081\u0001\u001a\u00020\nH\u0016J\t\u0010\u0082\u0001\u001a\u00020\nH\u0016J\u0011\u0010\u0083\u0001\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010AH\u0016J\t\u0010\u0084\u0001\u001a\u00020\nH\u0016J\t\u0010\u0085\u0001\u001a\u00020\u0004H\u0016J\t\u0010\u0086\u0001\u001a\u00020\u0004H\u0016J\t\u0010\u0087\u0001\u001a\u00020\u0004H\u0016J\t\u0010\u0088\u0001\u001a\u00020\u0004H\u0016J\t\u0010\u0089\u0001\u001a\u00020\nH\u0016J\u000b\u0010\u008a\u0001\u001a\u0004\u0018\u00010\u0004H\u0016J\u000b\u0010\u008b\u0001\u001a\u0004\u0018\u000100H\u0016J\t\u0010\u008c\u0001\u001a\u00020\nH\u0016J\t\u0010\u008d\u0001\u001a\u00020\nH\u0016J\u0011\u0010\u008e\u0001\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010AH\u0016J\u000b\u0010\u008f\u0001\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010\u0090\u0001\u001a\u00020\u00042\u0007\u0010\u0091\u0001\u001a\u00020\nH\u0016J\t\u0010\u0092\u0001\u001a\u00020\nH\u0016J\t\u0010\u0093\u0001\u001a\u00020\u0004H\u0016J\t\u0010\u0094\u0001\u001a\u00020\u0004H\u0016J\u000b\u0010\u0095\u0001\u001a\u0004\u0018\u000102H\u0016J\t\u0010\u0096\u0001\u001a\u00020\bH\u0016J\u000b\u0010\u0097\u0001\u001a\u0004\u0018\u00010\u0004H\u0016J\t\u0010\u0098\u0001\u001a\u00020\nH\u0016J\u000b\u0010\u0099\u0001\u001a\u0004\u0018\u00010\u0004H\u0016J\t\u0010\u009a\u0001\u001a\u00020\nH\u0016J\t\u0010\u009b\u0001\u001a\u00020\fH\u0016J\t\u0010\u009c\u0001\u001a\u00020\fH\u0016J\t\u0010\u009d\u0001\u001a\u00020\fH\u0016J\t\u0010\u009e\u0001\u001a\u00020\fH\u0016J\t\u0010\u009f\u0001\u001a\u00020\fH\u0016J\t\u0010 \u0001\u001a\u00020\fH\u0016J\t\u0010¡\u0001\u001a\u00020\fH\u0016J\t\u0010¢\u0001\u001a\u00020\fH\u0016J\t\u0010£\u0001\u001a\u00020\fH\u0016J\u0012\u0010£\u0001\u001a\u00020\f2\u0007\u0010¤\u0001\u001a\u00020\nH\u0016J\t\u0010¥\u0001\u001a\u00020\fH\u0016J\t\u0010¦\u0001\u001a\u00020\fH\u0016J\t\u0010§\u0001\u001a\u00020\fH\u0016J\t\u0010¨\u0001\u001a\u00020\fH\u0016J\t\u0010©\u0001\u001a\u00020\fH\u0016J\t\u0010ª\u0001\u001a\u00020\fH\u0016J\t\u0010«\u0001\u001a\u00020\fH\u0016J\t\u0010¬\u0001\u001a\u00020\nH\u0016J\t\u0010\u00ad\u0001\u001a\u00020\fH\u0016J\u0012\u0010\u00ad\u0001\u001a\u00020\f2\u0007\u0010¤\u0001\u001a\u00020\nH\u0016J\t\u0010®\u0001\u001a\u00020\fH\u0016J\t\u0010¯\u0001\u001a\u00020\fH\u0016J\t\u0010°\u0001\u001a\u00020\fH\u0016J\b\u0010\u001c\u001a\u00020\fH\u0016J\t\u0010±\u0001\u001a\u00020\fH\u0016J\t\u0010²\u0001\u001a\u00020\fH\u0016J\t\u0010³\u0001\u001a\u00020\fH\u0016J\t\u0010´\u0001\u001a\u00020\fH\u0016J\t\u0010µ\u0001\u001a\u00020\fH\u0016J\t\u0010¶\u0001\u001a\u00020\fH\u0016J\t\u0010·\u0001\u001a\u00020\fH\u0016J\t\u0010¸\u0001\u001a\u00020\fH\u0016J\b\u0010\u001e\u001a\u00020\fH\u0016J\t\u0010¹\u0001\u001a\u00020\fH\u0016J\t\u0010º\u0001\u001a\u00020\fH\u0016J\t\u0010»\u0001\u001a\u00020\fH\u0016J\t\u0010¼\u0001\u001a\u00020\fH\u0016J\t\u0010½\u0001\u001a\u00020\fH\u0016J\t\u0010¾\u0001\u001a\u00020\fH\u0016J\t\u0010¿\u0001\u001a\u00020\fH\u0016J\t\u0010À\u0001\u001a\u00020\fH\u0016J\t\u0010Á\u0001\u001a\u00020\fH\u0016J\u0012\u0010Â\u0001\u001a\u00020\f2\u0007\u0010Ã\u0001\u001a\u00020\fH\u0016J\t\u0010Ä\u0001\u001a\u00020\fH\u0016J\t\u0010Å\u0001\u001a\u00020\fH\u0016J\t\u0010Æ\u0001\u001a\u00020\fH\u0016J\t\u0010Ç\u0001\u001a\u00020\fH\u0016J\t\u0010È\u0001\u001a\u00020\fH\u0016J\t\u0010É\u0001\u001a\u00020\fH\u0016J\t\u0010Ê\u0001\u001a\u00020\fH\u0016J\t\u0010Ë\u0001\u001a\u00020\fH\u0016J\t\u0010Ì\u0001\u001a\u00020\fH\u0016J\b\u0010\u001f\u001a\u00020\fH\u0016J\b\u0010 \u001a\u00020\fH\u0016J\t\u0010Í\u0001\u001a\u00020\fH\u0016J\t\u0010Î\u0001\u001a\u00020\fH\u0016J\t\u0010Ï\u0001\u001a\u00020\fH\u0016J\u0012\u0010Ð\u0001\u001a\u0002052\u0007\u0010Ñ\u0001\u001a\u00020\nH\u0016J\u0014\u0010Ò\u0001\u001a\u0002052\t\u0010Ó\u0001\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010Ô\u0001\u001a\u0002052\u0007\u0010Õ\u0001\u001a\u00020\nH\u0016J\t\u0010Ö\u0001\u001a\u000205H\u0016J\u0014\u0010×\u0001\u001a\u0002052\t\u0010Ø\u0001\u001a\u0004\u0018\u00010\u0004H\u0016J\u0013\u0010Ù\u0001\u001a\u0002052\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0016J\u001c\u0010Ú\u0001\u001a\u0002052\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0007\u0010Û\u0001\u001a\u00020\fH\u0016J\u0013\u0010Ü\u0001\u001a\u0002052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010Ý\u0001\u001a\u0002052\u0007\u0010Þ\u0001\u001a\u00020\nH\u0016J\u0011\u0010ß\u0001\u001a\u0002052\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0011\u0010à\u0001\u001a\u0002052\u0006\u0010\t\u001a\u00020\nH\u0016J\u0011\u0010á\u0001\u001a\u0002052\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0012\u0010â\u0001\u001a\u0002052\u0007\u0010ã\u0001\u001a\u00020\nH\u0016J\u0013\u0010ä\u0001\u001a\u0002052\b\u0010å\u0001\u001a\u00030æ\u0001H\u0016J\u0011\u0010ç\u0001\u001a\u0002052\u0006\u0010\u000f\u001a\u00020\bH\u0016J\u0012\u0010è\u0001\u001a\u0002052\u0007\u0010é\u0001\u001a\u00020\nH\u0016J\u0011\u0010ê\u0001\u001a\u0002052\u0006\u0010\u0010\u001a\u00020\nH\u0016J\u0011\u0010ë\u0001\u001a\u0002052\u0006\u0010\u0011\u001a\u00020\bH\u0016J\u0014\u0010ì\u0001\u001a\u0002052\t\u0010í\u0001\u001a\u0004\u0018\u00010\u0004H\u0016J\u0013\u0010î\u0001\u001a\u0002052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0004H\u0016J\u0014\u0010ï\u0001\u001a\u0002052\t\u0010ð\u0001\u001a\u0004\u0018\u00010\u0004H\u0016J\u0013\u0010ñ\u0001\u001a\u0002052\b\u0010Q\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010ò\u0001\u001a\u0002052\u0007\u0010ó\u0001\u001a\u00020\fH\u0016J\u0011\u0010ô\u0001\u001a\u0002052\u0006\u0010\u0013\u001a\u00020\nH\u0016J\u0014\u0010õ\u0001\u001a\u0002052\t\u0010ö\u0001\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010÷\u0001\u001a\u0002052\u0007\u0010ø\u0001\u001a\u00020\fH\u0016J\u0011\u0010ù\u0001\u001a\u0002052\u0006\u0010\u0014\u001a\u00020\fH\u0016J\u0011\u0010ú\u0001\u001a\u0002052\u0006\u0010\u0015\u001a\u00020\fH\u0016J\u0011\u0010û\u0001\u001a\u0002052\u0006\u0010\u0016\u001a\u00020\fH\u0016J\u0012\u0010ü\u0001\u001a\u0002052\u0007\u0010ý\u0001\u001a\u00020\bH\u0016J\u0014\u0010þ\u0001\u001a\u0002052\t\u0010ÿ\u0001\u001a\u0004\u0018\u00010\u0004H\u0016J\u0011\u0010\u0080\u0002\u001a\u0002052\u0006\u0010\u0018\u001a\u00020\bH\u0016J\u0011\u0010\u0081\u0002\u001a\u0002052\u0006\u0010\u0019\u001a\u00020\bH\u0016J\u0014\u0010\u0082\u0002\u001a\u0002052\t\u0010\u0083\u0002\u001a\u0004\u0018\u00010\u0004H\u0016J\u0011\u0010\u0084\u0002\u001a\u0002052\u0006\u0010\u001a\u001a\u00020\nH\u0016J\u0011\u0010\u0085\u0002\u001a\u0002052\u0006\u0010\u001b\u001a\u00020\nH\u0016J\u0012\u0010\u0086\u0002\u001a\u0002052\u0007\u0010\u0087\u0002\u001a\u00020\nH\u0016J\u0011\u0010\u0088\u0002\u001a\u0002052\u0006\u0010\u001d\u001a\u00020\nH\u0016J\u0012\u0010\u0089\u0002\u001a\u0002052\u0007\u0010¹\u0001\u001a\u00020\nH\u0016J\u0011\u0010\u008a\u0002\u001a\u0002052\u0006\u0010!\u001a\u00020\nH\u0016J\u0011\u0010\u008b\u0002\u001a\u0002052\u0006\u0010\u001c\u001a\u00020\fH\u0016J\u0011\u0010\u008c\u0002\u001a\u0002052\u0006\u0010\"\u001a\u00020\nH\u0016J\u0012\u0010\u008d\u0002\u001a\u0002052\u0007\u0010\u008e\u0002\u001a\u00020\nH\u0016J\u0013\u0010\u008f\u0002\u001a\u0002052\b\u0010#\u001a\u0004\u0018\u00010\u0004H\u0016J\u0014\u0010\u0090\u0002\u001a\u0002052\t\u0010\u0091\u0002\u001a\u0004\u0018\u00010\u0004H\u0016J\u0011\u0010\u0092\u0002\u001a\u0002052\u0006\u0010$\u001a\u00020\nH\u0016J\u0011\u0010\u0093\u0002\u001a\u0002052\u0006\u0010%\u001a\u00020&H\u0016J\u0014\u0010\u0094\u0002\u001a\u0002052\t\u0010\u0095\u0002\u001a\u0004\u0018\u00010\u0004H\u0016J\u0010\u0010\u0096\u0002\u001a\u0002052\u0007\u0010\u0097\u0002\u001a\u00020(J\u0013\u0010\u0098\u0002\u001a\u0002052\b\u0010)\u001a\u0004\u0018\u00010\u0004H\u0016J\u0011\u0010\u0099\u0002\u001a\u0002052\u0006\u0010*\u001a\u00020\bH\u0016J\u0012\u0010\u009a\u0002\u001a\u0002052\u0007\u0010\u009b\u0002\u001a\u00020\fH\u0016J\u0014\u0010\u009c\u0002\u001a\u0002052\t\u0010\u009d\u0002\u001a\u0004\u0018\u00010\u0004H\u0016J\t\u0010\u009e\u0002\u001a\u000205H\u0016J\u0011\u0010\u009f\u0002\u001a\u0002052\u0006\u0010+\u001a\u00020\bH\u0016J\u0012\u0010 \u0002\u001a\u0002052\u0007\u0010Õ\u0001\u001a\u00020\nH\u0016J\u0012\u0010¡\u0002\u001a\u0002052\u0007\u0010¢\u0002\u001a\u00020\nH\u0016J\u0011\u0010£\u0002\u001a\u0002052\u0006\u0010-\u001a\u00020\nH\u0016J\u0011\u0010¤\u0002\u001a\u0002052\u0006\u0010.\u001a\u00020\fH\u0016J\t\u0010¥\u0002\u001a\u000205H\u0016J\u0013\u0010¥\u0002\u001a\u0002052\b\u0010/\u001a\u0004\u0018\u000100H\u0016J\u0012\u0010¦\u0002\u001a\u0002052\u0007\u0010§\u0002\u001a\u00020\fH\u0016J\u0012\u0010¨\u0002\u001a\u0002052\u0007\u0010©\u0002\u001a\u00020\fH\u0016J\u0014\u0010ª\u0002\u001a\u0002052\t\u0010\u0091\u0001\u001a\u0004\u0018\u00010\u0004H\u0016J\u0014\u0010«\u0002\u001a\u0002052\t\u0010¬\u0002\u001a\u0004\u0018\u00010\u0004H\u0016J\u0013\u0010\u00ad\u0002\u001a\u0002052\b\u00101\u001a\u0004\u0018\u000102H\u0016J\u0012\u0010®\u0002\u001a\u0002052\u0007\u0010¯\u0002\u001a\u00020\bH\u0016J\u0014\u0010°\u0002\u001a\u0002052\t\u0010±\u0002\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010²\u0002\u001a\u0002052\u0007\u0010¤\u0001\u001a\u00020\nH\u0016J\u0013\u0010³\u0002\u001a\u0002052\b\u00103\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010´\u0002\u001a\u0002052\u0007\u0010µ\u0002\u001a\u00020\nH\u0016J\t\u0010¶\u0002\u001a\u00020\fH\u0016J\u0014\u0010·\u0002\u001a\u00020\f2\t\u0010¸\u0002\u001a\u0004\u0018\u00010\u0004H\u0016J\t\u0010¹\u0002\u001a\u000205H\u0016J\t\u0010º\u0002\u001a\u00020\fH\u0016J\t\u0010»\u0002\u001a\u00020\fH\u0016J\t\u0010¼\u0002\u001a\u00020\nH\u0016J\u001d\u0010½\u0002\u001a\u0002052\b\u0010¾\u0002\u001a\u00030¿\u00022\b\u0010À\u0002\u001a\u00030Á\u0002H\u0016J\u0013\u0010Â\u0002\u001a\u0002052\b\u0010À\u0002\u001a\u00030Ã\u0002H\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\n0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010/\u001a\u0004\u0018\u000100X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00101\u001a\u0004\u0018\u000102X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00103\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006Ä\u0002"}, d2 = {"Lcom/wear/component/dxtoy/toy/impl/NewToy;", "Lcom/wear/component/dxtoy/toy/interfaces/IToy;", "()V", "agString", "", "aiString", "batchId", "batteryRequestTime", "", "bindType", "", "canRssi", "", "commandMap", "", "connectScanTime", "connectType", "connectedTime", "deviceId", "disConnectType", "f01IsNotice", "f01IsOff", "f01IsReady", "feedbackDownTime", "getCheckBindToyErrorTime", "getDfuErrorTime", "isCheckBindToy", "isDfuEnd", "isLanApiUpdateRequest", "isPowerOff", "isRealDeviceType", "isToyListAdd", "isTransfer", "lanApiUpdateCount", "led", "logFormApp", "missionSolo", "missionTchLvl", "", "newToyBean", "Lcom/component/dxtoy/core/toy/ToyInfo;", "pinStatus", "powerOffTime", "requestConnectTime", "requestConnectingIndex", "status", "synControlAnimation", "toyConfigDataBean", "Lcom/wear/bean/ToyConfigInfoBean;", "updateDfu", "Lcom/wear/bean/DfuBean;", "workMode", "addConnectTryNumb", "", "addLanApiUpdateCount", "canAddConnectingLog", "isAutoPlus", "canGetBattery", "canSetLed", "getAddress", "getAgString", "getAiString", "getAndUpdateDeviceId", "getBatchId", "getBattayList", "", "getBattery", "getBatteryRequestTime", "getBindType", "getCommandList", "getConnectApp", "getConnectScanTime", "getConnectTryNumb", "getConnectType", "getConnectedTime", "getDataBaseType", "getDefineRename", "getDeviceId", "getDeviceName", "getDeviceType", "getDeviceTypeMac", "deviceType", "getDfuIcon", "isFail", "getDisConnectType", "getEmail", "getFeedbackDownTime", "getFormApp", "getFullName", "getGenerationVersion", "getGetCheckBindToyErrorTime", "getGetDfuErrorTime", "getId", "getIsCheckBindToy", "getIsDfuEnd", "getIsLongRange", "getIsPowerOff", "getIsSelect", "getLanApiUpdateCount", "getLdrIcon", "getLed", "getLedSetting", "getLogFormApp", "getLogToyType", "getLogToyTypeAndRssi", "stateCode", "getLvsMotorsFuncList", "Lcom/component/dxtoy/core/toy/constant/ToyCoreEum$MotorFunction;", "getMissionSolo", "getMissionTchLvl", "getMotors", "getMultiplayOrder", "getName", "getNewLogToyTypeAndRssi", "resultBean", "Lcom/component/dxbluetooth/lib/bean/BleResultBean;", "getOldEmail", "getOldId", "getPinStatus", "getPowerOffTime", "getProgramDefaultLevel", "getProgramDefaultProgram", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getProgramSpeed", "getRealToyBean", "getRealType", "getReconnectOvertime", "getRquestConnectTime", "getRssi", "getRssiImg", "getRssiList", "getSearchToyIcon", "getShowName", "getSimpleFullName", "getSimpleName", "getSimpleType", "getStatus", "getSymbol", "getToyConfigDataBean", "getToyIcon", "getToyRssiLevel", "getToySymbol", "getToyTypeKey", "getToyUINameSpecialForMiniXMachine", "type", "getToyVersion", "getType", "getUpCaseName", "getUpdateDfu", "getUpdateTime", "getUuid", "getVersion", "getWorkMode", "getaColor", "hasProgramToy", "isAlarmEnable", "isBAToy", "isCanWearToy", "isCmdCompensation", "isConnected", "isDirection", "isEAToy", "isEI01Toy", "version", "isEL01Toy", "isEncrypt", "isF01IsNotice", "isF01IsReady", "isF01Off", "isF01Toy", "isFeedbackModeEnable", "isFeedbackModeEnableAndUpdateEnable", "isGeminiToy", "isGravity", "isH01Toy", "isJ01Toy", "isMax", "isMaxToy", "isMiniXMachine", "isMultiplyInstruct", "isNora", "isNoraToy", "isQ01Toy", "isQA01Toy", "isSelect", "isSelected", "isSetGradualSpeedUpEnable", "isSetThresholdEnable", "isSupportAir", "isSupportBt", "isSupportControlPanel", "isSupportDepthMode", "isSupportGame", "isSupportLEDColor", "isMotherboardLED", "isSupportLVS", "isSupportLdr", "isSupportR", "isSupportV1V2", "isSupportV1V2F", "isSuppportPinCode", "isSynControlAnimation", "isT01Toy", "isThridPartToy", "isV01Toy", "isVirtualToy", "isXMachine", "pushBattay", "battay", "pushCommand", "command", "pushRssi", "rssi", "reduceConnectTryNumb", "setAddress", MultipleAddresses.Address.ELEMENT, "setAgString", "setAiString", "isShowDialog", "setBatchId", "setBattery", "battery", "setBatteryRequestTime", "setBindType", "setCanRssi", "setConnectApp", "connectState", "setConnectPriority", "connectPriority", "Lcom/component/dxtoy/core/toy/constant/ToyCoreEum$ConnectPriority;", "setConnectScanTime", "setConnectTryNumb", "connectTryNumb", "setConnectType", "setConnectedTime", "setDefineRename", "defineRename", "setDeviceId", "setDeviceName", "deviceName", "setDeviceType", "setDirection", "direction", "setDisConnectType", "setEmail", "email", "setEncrypt", "encrypt", "setF01IsNotice", "setF01IsOff", "setF01IsReady", "setFeedbackDownTime", "time", "setFormApp", "formApp", "setGetCheckBindToyErrorTime", "setGetDfuErrorTime", "setId", TtmlNode.ATTR_ID, "setIsCheckBindToy", "setIsDfuEnd", "setIsLongRange", "isLongRange", "setIsPowerOff", "setIsSelect", "setLanApiUpdateCount", "setLanApiUpdateRequest", "setLed", "setLedSetting", "ledSetting", "setLogFormApp", "setLvsMotorConfig", "lvsMotorConfig", "setMissionSolo", "setMissionTchLvl", "setName", "name", "setNewToyBean", "toyBean", "setPinStatus", "setPowerOffTime", "setRealDeviceType", "realDeviceType", "setRealType", "realType", "setRenameDeviceName", "setRquestConnectTime", "setRssi", "setSimpleToy", "simpleToy", "setStatus", "setSynControlAnimation", "setToyConfigDataBean", "setToyListAdd", "toyListAdd", "setTransfer", "transfer", "setType", "setUpCaseName", "upCaseName", "setUpdateDfu", "setUpdateTime", "updateTime", "setUuid", "uuid", "setVersion", "setWorkMode", "setaColor", "aColor", "supportChangeName", "supportCommand", "message", "synNameToType", "toyIsSupport", "toyIsSupportLanApi", "typeInt", "updateMyToyBattery", "context", "Landroid/content/Context;", "imgView", "Lcom/wear/util/TextOverlayImageView;", "updateToyBattery", "Landroid/widget/ImageView;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class xs1 implements bt1 {
    public long A;
    public int C;
    public long D;
    public boolean E;
    public boolean F;
    public boolean H;
    public int I;
    public long J;

    @Nullable
    public String L;

    @Nullable
    public ToyConfigInfoBean b;
    public long f;
    public long g;
    public int h;
    public boolean i;
    public boolean j;

    @Nullable
    public String k;

    @Nullable
    public DfuBean n;

    @Nullable
    public String o;
    public long p;
    public long q;
    public int r;
    public int t;
    public long u;
    public int v;

    @Nullable
    public String w;

    @Nullable
    public String x;
    public boolean y;

    @NotNull
    public nb0 a = new nb0();

    @NotNull
    public String c = "";
    public int d = 1;

    @NotNull
    public int[] e = {3, 8, 13, 18};
    public int l = -1;
    public int m = -1;
    public int s = 1;
    public int z = -1;

    @Nullable
    public String B = "-1";
    public boolean G = true;
    public boolean K = true;

    @NotNull
    public final Map<String, Integer> M = MapsKt__MapsKt.mapOf(TuplesKt.to("Vibrate:", 1), TuplesKt.to("vibrate:", 1), TuplesKt.to("Vibrate1:", 2), TuplesKt.to("vibrate1:", 2), TuplesKt.to("Vibrate2:", 2), TuplesKt.to("vibrate2:", 2), TuplesKt.to("Rotate:", 3), TuplesKt.to("rotate:", 3), TuplesKt.to("Air:Level:", 4), TuplesKt.to("air:level:", 4), TuplesKt.to("Suction:", 5), TuplesKt.to("suction:", 5), TuplesKt.to("Thrusting:", 6), TuplesKt.to("thrusting:", 6), TuplesKt.to("Fingering:", 7), TuplesKt.to("fingering:", 7), TuplesKt.to("vibrate3:", 7), TuplesKt.to("Depth:", 8), TuplesKt.to("depth:", 8));

    @Override // dc.bt1
    public boolean A() {
        return tb0.q(this.a);
    }

    @Override // dc.bt1
    public boolean A0() {
        String strF = this.a.f();
        if (strF != null) {
            return StringsKt__StringsJVMKt.equals(strF, PSOProgramService.VS_Key, true);
        }
        return false;
    }

    @Override // dc.bt1
    @NotNull
    /* renamed from: A1, reason: from getter */
    public int[] getE() {
        return this.e;
    }

    @Override // dc.bt1
    @Nullable
    /* renamed from: A2, reason: from getter */
    public DfuBean getN() {
        return this.n;
    }

    @Override // dc.bt1
    public void B(boolean z) {
        this.a.e0(z);
    }

    @Override // dc.bt1
    @Nullable
    public String B0() {
        return tb0.e(this.a);
    }

    @Override // dc.bt1
    public void B1(long j) {
        this.q = j;
    }

    @Override // dc.bt1
    public void B2(@Nullable String str) {
        this.a.w(str);
    }

    @Override // dc.bt1
    @NotNull
    public String C() {
        try {
            if (this.c.length() == 0) {
                String lowerCase = StringsKt__StringsJVMKt.replace$default(this.a.getMac(), SignatureImpl.INNER_SEP, "", false, 4, (Object) null).toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
                this.c = lowerCase;
            }
        } catch (Throwable th) {
            th.printStackTrace();
            de0.l(th.getMessage());
        }
        return this.c;
    }

    @Override // dc.bt1
    public void C0(boolean z) {
        this.j = z;
    }

    @Override // dc.bt1
    public boolean C1() {
        return j0() ? W0() >= 36 : w0() && W0() >= 3;
    }

    @Override // dc.bt1
    public void C2(int i) {
        this.C = i;
    }

    @Override // dc.bt1
    public boolean D() {
        return tb0.m(this.a);
    }

    @Override // dc.bt1
    public void D0(int i) {
        this.I = i;
    }

    @Override // dc.bt1
    @Nullable
    public String D1() {
        return this.a.getUuid();
    }

    @Override // dc.bt1
    /* renamed from: D2, reason: from getter */
    public boolean getY() {
        return this.y;
    }

    @Override // dc.bt1
    public boolean E() {
        if (this.J == 0) {
            return true;
        }
        long jCurrentTimeMillis = (System.currentTimeMillis() - getJ()) / 1000;
        if (W() <= 0 && jCurrentTimeMillis > 3) {
            return true;
        }
        if (W() < 30) {
            if (jCurrentTimeMillis >= 10) {
                return true;
            }
        } else if (jCurrentTimeMillis >= 30) {
            return true;
        }
        return false;
    }

    @Override // dc.bt1
    public void E0(long j) {
        this.u = j;
    }

    @Override // dc.bt1
    /* renamed from: E1, reason: from getter */
    public int getM() {
        return this.m;
    }

    @Override // dc.bt1
    public void E2(@Nullable String str) {
    }

    @Override // dc.bt1
    public void F(int i) {
        this.t = i;
    }

    @Override // dc.bt1
    @Nullable
    public ToyConfigInfoBean F0() {
        ToyConfigInfoBean toyConfigInfoBean = this.b;
        if (toyConfigInfoBean != null) {
            return toyConfigInfoBean;
        }
        try {
            com.component.dxtoy.core.toy.bean.ToyConfigInfoBean toyConfigInfoBeanG = this.a.g();
            if (toyConfigInfoBeanG == null) {
                return null;
            }
            ToyConfigInfoBean toyConfigInfoBean2 = (ToyConfigInfoBean) xd0.d(xd0.j(toyConfigInfoBeanG), ToyConfigInfoBean.class);
            this.b = toyConfigInfoBean2;
            return toyConfigInfoBean2;
        } catch (Throwable th) {
            de0.l(th.getMessage());
            return null;
        }
    }

    @Override // dc.bt1
    public void F1(@Nullable String str) {
        if (str == null || str.length() == 0) {
            return;
        }
        nb0 nb0Var = this.a;
        byte[] bArrG = qd0.g(str);
        Intrinsics.checkNotNullExpressionValue(bArrG, "hexString2Bytes(lvsMotorConfig)");
        nb0Var.Z(bArrG);
    }

    @Override // dc.bt1
    public void F2() {
        if (this.a.getG() < 30) {
            nb0 nb0Var = this.a;
            nb0Var.b0(nb0Var.getG() + 1);
        }
    }

    @Override // dc.bt1
    @Nullable
    public String G() {
        String strH = this.a.h();
        if (strH == null) {
            return null;
        }
        String lowerCase = strH.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        return lowerCase;
    }

    @Override // dc.bt1
    public boolean G0() {
        String strF = this.a.f();
        if (strF != null) {
            return StringsKt__StringsJVMKt.equals(strF, "ba", true);
        }
        return false;
    }

    @Override // dc.bt1
    public void G1(@Nullable String str) {
        this.a.o(str);
    }

    @Override // dc.bt1
    public void G2(boolean z) {
    }

    @Override // dc.bt1
    public void H(@Nullable ToyConfigInfoBean toyConfigInfoBean) {
        if (this.a.g() != null) {
            return;
        }
        if (toyConfigInfoBean != null) {
            this.a.u((com.component.dxtoy.core.toy.bean.ToyConfigInfoBean) xd0.d(xd0.j(toyConfigInfoBean), com.component.dxtoy.core.toy.bean.ToyConfigInfoBean.class));
        }
        com.component.dxtoy.core.toy.bean.ToyConfigInfoBean toyConfigInfoBeanG = this.a.g();
        if (toyConfigInfoBeanG != null) {
            this.a.v(toyConfigInfoBeanG.getType());
            this.a.s(toyConfigInfoBeanG.getShowName());
        }
    }

    @Override // dc.bt1
    @Nullable
    /* renamed from: H0, reason: from getter */
    public String getL() {
        return this.L;
    }

    @Override // dc.bt1
    @Nullable
    /* renamed from: H1, reason: from getter */
    public String getW() {
        return this.w;
    }

    @Override // dc.bt1
    @Nullable
    public List<String> H2() {
        return null;
    }

    @Override // dc.bt1
    public boolean I() {
        return ub0.m(this.a) || ub0.f(this.a);
    }

    @Override // dc.bt1
    @Nullable
    public String I0(int i) {
        return null;
    }

    @Override // dc.bt1
    public boolean I1() {
        return ub0.b(this.a);
    }

    @Override // dc.bt1
    public void I2(int i) {
        this.h = i;
    }

    @Override // dc.bt1
    @Nullable
    public List<String> J() {
        com.component.dxtoy.core.toy.bean.ToyConfigInfoBean toyConfigInfoBeanG = this.a.g();
        if (toyConfigInfoBeanG != null) {
            return toyConfigInfoBeanG.getSymbol();
        }
        return null;
    }

    @Override // dc.bt1
    public boolean J0() {
        if (!j0()) {
            return w0() && W0() < 4;
        }
        int iW0 = W0();
        if (30 <= iW0 && iW0 < 50) {
            return true;
        }
        int iW02 = W0();
        if (50 <= iW02 && iW02 < 52) {
            return true;
        }
        int iW03 = W0();
        return 80 <= iW03 && iW03 < 84;
    }

    @Override // dc.bt1
    /* renamed from: J1, reason: from getter */
    public long getG() {
        return this.g;
    }

    @Override // dc.bt1
    @NotNull
    public String J2() {
        Character chFirstOrNull;
        String strU0 = U0();
        if (strU0 != null && (chFirstOrNull = StringsKt___StringsKt.firstOrNull(strU0)) != null) {
            String strValueOf = String.valueOf(chFirstOrNull.charValue());
            Intrinsics.checkNotNull(strValueOf, "null cannot be cast to non-null type java.lang.String");
            String upperCase = strValueOf.toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
            if (upperCase != null) {
                return upperCase;
            }
        }
        return "U";
    }

    @Override // dc.bt1
    @Nullable
    public String K() {
        return this.a.getFormApp();
    }

    @Override // dc.bt1
    public void K0(@Nullable String str) {
        this.a.setId(nd3.p(str));
    }

    @Override // dc.bt1
    /* renamed from: K1, reason: from getter */
    public int getV() {
        return this.v;
    }

    @Override // dc.bt1
    /* renamed from: K2, reason: from getter */
    public boolean getG() {
        return this.G;
    }

    @Override // dc.bt1
    @Nullable
    /* renamed from: L, reason: from getter */
    public String getK() {
        return this.k;
    }

    @Override // dc.bt1
    @Nullable
    public String L0() {
        return this.a.getDeviceType();
    }

    @Override // dc.bt1
    public boolean L1() {
        return tb0.s(this.a);
    }

    @Override // dc.bt1
    /* renamed from: L2, reason: from getter */
    public long getP() {
        return this.p;
    }

    @Override // dc.bt1
    public boolean M() {
        nb0 nb0Var = this.a;
        return tb0.i(nb0Var) && tb0.j(nb0Var);
    }

    @Override // dc.bt1
    public int M0() {
        String strG0 = g0();
        return (!(strG0.length() > 0) || StringsKt__StringsKt.contains((CharSequence) strG0, (CharSequence) EnvironmentCompat.MEDIA_UNKNOWN, true)) ? R.drawable.toy_icon_unknow : R.drawable.toy_icon_nora;
    }

    @Override // dc.bt1
    public void M1(boolean z) {
        this.E = z;
    }

    @Override // dc.bt1
    public boolean M2() {
        return ub0.k(this.a);
    }

    @Override // dc.bt1
    public void N(@Nullable String str) {
        this.B = str;
    }

    @Override // dc.bt1
    public void N0(int i) {
        this.a.W(i);
    }

    @Override // dc.bt1
    public void N1(@Nullable String str) {
        this.a.U(str);
    }

    @Override // dc.bt1
    public void N2(@Nullable String str) {
        if (str == null || str.length() == 0) {
            return;
        }
        String deviceType = this.a.getDeviceType();
        if (deviceType == null || deviceType.length() == 0) {
            this.a.p(str);
        }
    }

    @Override // dc.bt1
    public boolean O() {
        return tb0.g(this.a);
    }

    @Override // dc.bt1
    @Nullable
    public String O0() {
        return this.a.getId();
    }

    @Override // dc.bt1
    public boolean O1() {
        String strF = this.a.f();
        if (strF != null) {
            return StringsKt__StringsJVMKt.equals(strF, XHTMLText.Q, true);
        }
        return false;
    }

    @Override // dc.bt1
    public void O2(@Nullable String str) {
        this.L = str;
    }

    @Override // dc.bt1
    @NotNull
    public String P() {
        try {
            return this.a.getMac();
        } catch (Throwable th) {
            th.printStackTrace();
            de0.l(th.getMessage());
            return "";
        }
    }

    @Override // dc.bt1
    @NotNull
    public String P0() {
        String strP1 = WearUtils.e1(L0()) ? P1() : getName();
        StringBuilder sb = new StringBuilder();
        sb.append(strP1);
        sb.append('#');
        String upperCase = P().toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
        sb.append(StringsKt__StringsJVMKt.replace$default(upperCase, SignatureImpl.INNER_SEP, "", false, 4, (Object) null));
        String string = sb.toString();
        if (xb1.b(D1(), P())) {
            return string + "#pin_0";
        }
        return string + "#pin_1";
    }

    @Override // dc.bt1
    @Nullable
    public String P1() {
        return this.a.getDeviceName();
    }

    @Override // dc.bt1
    /* renamed from: P2, reason: from getter */
    public int getD() {
        return this.d;
    }

    @Override // dc.bt1
    /* renamed from: Q, reason: from getter */
    public long getJ() {
        return this.J;
    }

    @Override // dc.bt1
    /* renamed from: Q0, reason: from getter */
    public boolean getJ() {
        return this.j;
    }

    @Override // dc.bt1
    public int Q1() {
        return this.a.getIsLedOpen() ? 1 : 0;
    }

    @Override // dc.bt1
    public void Q2(int i) {
        this.l = i;
        if (i != 1) {
            c1(null, false);
            R1(null);
            return;
        }
        xr1.a.a(P());
        B1(be3.I().getTime());
        this.r = 0;
        this.a.b0(0);
        this.A = 0L;
        u1(0);
    }

    @Override // dc.bt1
    public void R(int i) {
        this.a.z(i == 1);
    }

    @Override // dc.bt1
    /* renamed from: R0, reason: from getter */
    public long getF() {
        return this.f;
    }

    @Override // dc.bt1
    public void R1(@Nullable String str) {
        this.x = str;
    }

    @Override // dc.bt1
    public boolean R2() {
        return this.a.getD();
    }

    @Override // dc.bt1
    public boolean S(boolean z) {
        int i = this.r;
        if (i > 15) {
            return false;
        }
        if (!z) {
            return true;
        }
        this.r = i + 1;
        return true;
    }

    @Override // dc.bt1
    @Nullable
    public String S0() {
        String strF = this.a.f();
        if (strF == null) {
            return null;
        }
        String lowerCase = strF.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        return lowerCase;
    }

    @Override // dc.bt1
    @NotNull
    public String S1() {
        return t10.b(this.a);
    }

    @Override // dc.bt1
    public int S2() {
        return this.a.getIsSelect() ? 1 : 0;
    }

    @Override // dc.bt1
    public void T(int i) {
    }

    @Override // dc.bt1
    @NotNull
    public List<qb0> T0() {
        List<qb0> listC = tb0.c(this.a);
        return listC == null ? CollectionsKt__CollectionsKt.emptyList() : listC;
    }

    @Override // dc.bt1
    public boolean T1() {
        return true;
    }

    @NotNull
    /* renamed from: T2, reason: from getter */
    public final nb0 getA() {
        return this.a;
    }

    @Override // dc.bt1
    /* renamed from: U, reason: from getter */
    public boolean getI() {
        return this.i;
    }

    @Override // dc.bt1
    @Nullable
    public String U0() {
        return tb0.b(this.a);
    }

    @Override // dc.bt1
    /* renamed from: U1, reason: from getter */
    public long getA() {
        return this.A;
    }

    public final void U2(@NotNull nb0 toyBean) {
        Intrinsics.checkNotNullParameter(toyBean, "toyBean");
        this.a = toyBean;
    }

    @Override // dc.bt1
    public void V(@Nullable String str) {
        this.k = str;
    }

    @Override // dc.bt1
    public boolean V0(boolean z) {
        nb0 nb0Var = this.a;
        return z ? tb0.o(nb0Var) : tb0.k(nb0Var);
    }

    @Override // dc.bt1
    public boolean V1() {
        return tb0.w(this.a);
    }

    @Override // dc.bt1
    public int W() {
        if (this.a.getIsVirtualToy()) {
            return 50;
        }
        return this.a.getC();
    }

    @Override // dc.bt1
    public int W0() {
        return getVersion();
    }

    @Override // dc.bt1
    public void W1(@Nullable String str) {
        this.o = str;
    }

    @Override // dc.bt1
    /* renamed from: X, reason: from getter */
    public long getU() {
        return this.u;
    }

    @Override // dc.bt1
    public void X0() {
        this.a.b0(r0.getG() - 1);
    }

    @Override // dc.bt1
    public long X1() {
        return this.a.getUpdateTime();
    }

    @Override // dc.bt1
    @NotNull
    public ArrayList<String> Y() {
        return l20.b(this.a);
    }

    @Override // dc.bt1
    @Nullable
    /* renamed from: Y0, reason: from getter */
    public String getX() {
        return this.x;
    }

    @Override // dc.bt1
    public void Y1(int i) {
        this.a.b0(0);
    }

    @Override // dc.bt1
    public boolean Z() {
        return tb0.u(this.a);
    }

    @Override // dc.bt1
    public void Z0(int i) {
        this.a.X(i == 1);
    }

    @Override // dc.bt1
    public boolean Z1(int i) {
        return I1() && i >= 3;
    }

    @Override // dc.bt1
    public boolean a() {
        return tb0.v(this.a);
    }

    @Override // dc.bt1
    public int a0() {
        return this.a.getG();
    }

    @Override // dc.bt1
    @Nullable
    /* renamed from: a1, reason: from getter */
    public String getO() {
        return this.o;
    }

    @Override // dc.bt1
    public void a2(boolean z) {
        this.F = z;
    }

    @Override // dc.bt1
    public boolean b() {
        return t10.m(this.a);
    }

    @Override // dc.bt1
    /* renamed from: b0, reason: from getter */
    public int getZ() {
        return this.z;
    }

    @Override // dc.bt1
    public void b1(long j) {
        this.g = j;
    }

    @Override // dc.bt1
    public void b2(int i) {
    }

    @Override // dc.bt1
    public void c(@Nullable DfuBean dfuBean) {
        this.n = dfuBean;
    }

    @Override // dc.bt1
    public void c0(int i) {
        this.z = i;
    }

    @Override // dc.bt1
    public void c1(@Nullable String str, boolean z) {
        this.w = str;
        if (WearUtils.e1(str) || !z) {
            return;
        }
        xg3.i().k(this.a.getMac(), str);
    }

    @Override // dc.bt1
    @NotNull
    public int[] c2() {
        return l20.a(this.a);
    }

    @Override // dc.bt1
    public boolean canSetLed() {
        return t10.e(this.a);
    }

    @Override // dc.bt1
    public void d(int i) {
        this.a.R(i);
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x007b A[EDGE_INSN: B:47:0x007b->B:40:0x007b BREAK  A[LOOP:0: B:12:0x001f->B:51:?], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:51:? A[LOOP:0: B:12:0x001f->B:51:?, LOOP_END, SYNTHETIC] */
    @Override // dc.bt1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void d0() {
        /*
            r8 = this;
            dc.nb0 r0 = r8.a
            java.lang.String r0 = r0.e()
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L13
            int r0 = r0.length()
            if (r0 != 0) goto L11
            goto L13
        L11:
            r0 = 0
            goto L14
        L13:
            r0 = 1
        L14:
            if (r0 == 0) goto L17
            return
        L17:
            java.util.List r0 = dc.a00.e()
            java.util.Iterator r0 = r0.iterator()
        L1f:
            boolean r3 = r0.hasNext()
            r4 = 0
            if (r3 == 0) goto L7a
            java.lang.Object r3 = r0.next()
            r5 = r3
            com.component.dxtoy.core.toy.bean.ToyConfigInfoBean r5 = (com.component.dxtoy.core.toy.bean.ToyConfigInfoBean) r5
            java.lang.String r6 = r5.getShowName()
            if (r6 == 0) goto L3e
            dc.nb0 r7 = r8.a
            java.lang.String r7 = r7.e()
            boolean r6 = kotlin.text.StringsKt__StringsJVMKt.equals(r6, r7, r1)
            goto L3f
        L3e:
            r6 = 0
        L3f:
            if (r6 != 0) goto L76
            java.util.List r5 = r5.getSymbol()
            if (r5 == 0) goto L70
            boolean r6 = r5 instanceof java.util.Collection
            if (r6 == 0) goto L52
            boolean r6 = r5.isEmpty()
            if (r6 == 0) goto L52
            goto L70
        L52:
            java.util.Iterator r5 = r5.iterator()
        L56:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L70
            java.lang.Object r6 = r5.next()
            java.lang.String r6 = (java.lang.String) r6
            dc.nb0 r7 = r8.a
            java.lang.String r7 = r7.e()
            boolean r6 = kotlin.text.StringsKt__StringsJVMKt.equals(r6, r7, r1)
            if (r6 == 0) goto L56
            r5 = 1
            goto L71
        L70:
            r5 = 0
        L71:
            if (r5 == 0) goto L74
            goto L76
        L74:
            r5 = 0
            goto L77
        L76:
            r5 = 1
        L77:
            if (r5 == 0) goto L1f
            goto L7b
        L7a:
            r3 = r4
        L7b:
            com.component.dxtoy.core.toy.bean.ToyConfigInfoBean r3 = (com.component.dxtoy.core.toy.bean.ToyConfigInfoBean) r3
            if (r3 == 0) goto La8
            dc.nb0 r0 = r8.a
            r0.u(r3)
            dc.nb0 r0 = r8.a
            java.lang.String r1 = r3.getType()
            r0.v(r1)
            dc.nb0 r0 = r8.a
            java.lang.String r1 = r3.getShowName()
            r0.s(r1)
            dc.nb0 r0 = r8.a
            java.util.List r1 = r3.getSymbol()
            if (r1 == 0) goto La5
            java.lang.Object r1 = r1.get(r2)
            r4 = r1
            java.lang.String r4 = (java.lang.String) r4
        La5:
            r0.t(r4)
        La8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: dc.xs1.d0():void");
    }

    @Override // dc.bt1
    public void d1(long j) {
        this.D = j;
    }

    @Override // dc.bt1
    public boolean d2() {
        String strF = this.a.f();
        if (strF != null) {
            return StringsKt__StringsJVMKt.equals(strF, "qa", true);
        }
        return false;
    }

    @Override // dc.bt1
    public void e(@Nullable String str) {
    }

    @Override // dc.bt1
    public void e0() {
        String strP1 = P1();
        boolean z = true;
        if ((strP1 == null || StringsKt__StringsJVMKt.startsWith(strP1, "lvs", true)) ? false : true) {
            String strS1 = s1();
            if (strS1 != null && strS1.length() != 0) {
                z = false;
            }
            if (z || !Intrinsics.areEqual(P1(), s1())) {
                v(P1());
                ToyRename toyRenameFindToyName = DaoUtils.getToyRenameDao().findToyName(WearUtils.y.r(), P());
                if (toyRenameFindToyName != null) {
                    toyRenameFindToyName.setName(P1());
                    DaoUtils.getToyRenameDao().updateOrAdd(toyRenameFindToyName);
                    return;
                }
                ToyRename toyRename = new ToyRename();
                toyRename.setEmail(WearUtils.y.r());
                toyRename.setName(P1());
                toyRename.setAddress(P());
                DaoUtils.getToyRenameDao().updateOrAdd(toyRename);
            }
        }
    }

    @Override // dc.bt1
    public boolean e1() {
        return y1() == 0;
    }

    @Override // dc.bt1
    public void e2(long j) {
        this.A = j;
    }

    @Override // dc.bt1
    public void f(@Nullable String str) {
    }

    @Override // dc.bt1
    /* renamed from: f0, reason: from getter */
    public long getD() {
        return this.D;
    }

    @Override // dc.bt1
    public int f1(boolean z) {
        return z ? R.drawable.content_icon_gray : R.drawable.nav_unknown_1;
    }

    @Override // dc.bt1
    public boolean f2() {
        String strF = this.a.f();
        if (strF != null) {
            return StringsKt__StringsJVMKt.equals(strF, "ea", true);
        }
        return false;
    }

    @Override // dc.bt1
    public void g(long j) {
        this.a.h0(j);
    }

    @Override // dc.bt1
    @NotNull
    public String g0() {
        String strH = this.a.h();
        return strH == null ? "Unknown" : strH;
    }

    @Override // dc.bt1
    public void g1(int i) {
        this.a.f0(i);
    }

    @Override // dc.bt1
    public boolean g2() {
        return tb0.l(this.a);
    }

    @Override // dc.bt1
    @Nullable
    public String getEmail() {
        return null;
    }

    @Override // dc.bt1
    @Nullable
    public String getId() {
        String strF = nd3.f(this.a.getId());
        return strF == null || strF.length() == 0 ? this.a.getId() : strF;
    }

    @Override // dc.bt1
    public int getLdrIcon() {
        return R.drawable.ldr_toy_icon_nomal;
    }

    @Override // dc.bt1
    @Nullable
    public String getName() {
        return this.a.e();
    }

    @Override // dc.bt1
    @NotNull
    public String getShowName() {
        String strE = this.a.e();
        return strE == null ? "Unknown" : strE;
    }

    @Override // dc.bt1
    @NotNull
    public String getSimpleName() {
        return t10.c(this.a);
    }

    @Override // dc.bt1
    public int getStatus() {
        if (this.a.getIsVirtualToy()) {
            return 1;
        }
        return this.l;
    }

    @Override // dc.bt1
    @NotNull
    public String getType() {
        String strH = this.a.h();
        if (strH != null) {
            String lowerCase = strH.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
            if (lowerCase != null) {
                return lowerCase;
            }
        }
        return EnvironmentCompat.MEDIA_UNKNOWN;
    }

    @Override // dc.bt1
    public int getVersion() {
        if (WearUtils.c1(Integer.valueOf(this.a.getVersion()))) {
            return 0;
        }
        return this.a.getVersion();
    }

    @Override // dc.bt1
    @Nullable
    public String h() {
        return null;
    }

    @Override // dc.bt1
    public int h0() {
        return this.a.getB();
    }

    @Override // dc.bt1
    public void h1(int i) {
        this.a.r(i == 1);
    }

    @Override // dc.bt1
    public boolean h2() {
        String str = this.w;
        if (str != null) {
            return StringsKt__StringsJVMKt.startsWith(str, "ai:", true);
        }
        return false;
    }

    @Override // dc.bt1
    public boolean i() {
        String strF = this.a.f();
        if (strF != null) {
            return StringsKt__StringsJVMKt.equals(strF, "t", true);
        }
        return false;
    }

    @Override // dc.bt1
    /* renamed from: i0, reason: from getter */
    public boolean getH() {
        return this.H;
    }

    @Override // dc.bt1
    /* renamed from: i1, reason: from getter */
    public int getS() {
        return this.s;
    }

    @Override // dc.bt1
    public void i2(@Nullable String str) {
        String strH = this.a.h();
        if (strH == null || strH.length() == 0) {
            this.a.v(str);
        }
    }

    @Override // dc.bt1
    public boolean isConnected() {
        return pc1.a.a(P());
    }

    @Override // dc.bt1
    public boolean isMax() {
        return ub0.e(this.a);
    }

    @Override // dc.bt1
    public boolean isSupportBt() {
        return t10.g(this.a);
    }

    @Override // dc.bt1
    public boolean isSupportControlPanel() {
        return t10.h(this.a);
    }

    @Override // dc.bt1
    public boolean isSupportDepthMode() {
        return t10.i(this.a);
    }

    @Override // dc.bt1
    public boolean isSupportGame() {
        return t10.j(this.a);
    }

    @Override // dc.bt1
    public boolean isSupportLdr() {
        return t10.k(this.a);
    }

    @Override // dc.bt1
    public boolean isThridPartToy() {
        return t10.n(this.a);
    }

    @Override // dc.bt1
    public boolean isVirtualToy() {
        return this.a.getIsVirtualToy();
    }

    @Override // dc.bt1
    public void j(@NotNull ImageView imgView) {
        Intrinsics.checkNotNullParameter(imgView, "imgView");
        if (I()) {
            imgView.setVisibility(8);
            return;
        }
        int iW = W();
        imgView.setVisibility(iW >= 0 ? 0 : 8);
        imgView.setImageResource(ws1.m2(false, false, iW));
    }

    @Override // dc.bt1
    public boolean j0() {
        return ub0.m(this.a);
    }

    @Override // dc.bt1
    public boolean j1() {
        String strF = this.a.f();
        if (strF != null) {
            return StringsKt__StringsJVMKt.equals(strF, "ei", true);
        }
        return false;
    }

    @Override // dc.bt1
    public void j2(@Nullable String str) {
        if (str == null || str.length() == 0) {
            return;
        }
        String strE = this.a.e();
        if (strE == null || strE.length() == 0) {
            this.a.s(str);
        }
    }

    @Override // dc.bt1
    public void k(long j) {
        this.f = j;
    }

    @Override // dc.bt1
    public void k0(boolean z) {
        this.G = z;
    }

    @Override // dc.bt1
    public void k1(@Nullable String str) {
    }

    @Override // dc.bt1
    public int k2() {
        return this.a.getLedColor();
    }

    @Override // dc.bt1
    public boolean l() {
        String strF = this.a.f();
        if (strF != null) {
            return StringsKt__StringsJVMKt.equals(strF, XHTMLText.H, true);
        }
        return false;
    }

    @Override // dc.bt1
    public void l0(boolean z) {
        this.i = z;
    }

    @Override // dc.bt1
    public void l1(@NotNull int[] missionTchLvl) {
        Intrinsics.checkNotNullParameter(missionTchLvl, "missionTchLvl");
        this.e = missionTchLvl;
    }

    @Override // dc.bt1
    public int l2() {
        return l20.c(this.a);
    }

    @Override // dc.bt1
    /* renamed from: m, reason: from getter */
    public long getQ() {
        return this.q;
    }

    @Override // dc.bt1
    public void m0(boolean z) {
        this.K = z;
    }

    @Override // dc.bt1
    /* renamed from: m1, reason: from getter */
    public boolean getF() {
        return this.F;
    }

    @Override // dc.bt1
    @NotNull
    public String m2() {
        return C();
    }

    @Override // dc.bt1
    /* renamed from: n, reason: from getter */
    public boolean getK() {
        return this.K;
    }

    @Override // dc.bt1
    public boolean n0() {
        return this.a.getG() > 10;
    }

    @Override // dc.bt1
    @Nullable
    public List<Integer> n1() {
        return null;
    }

    @Override // dc.bt1
    public int n2() {
        String strG0 = g0();
        return (!(strG0.length() > 0) || StringsKt__StringsKt.contains((CharSequence) strG0, (CharSequence) EnvironmentCompat.MEDIA_UNKNOWN, true)) ? R.drawable.toy_icon_unknow : R.drawable.toy_icon_search;
    }

    @Override // dc.bt1
    @Nullable
    public List<Map<String, Long>> o() {
        return null;
    }

    @Override // dc.bt1
    public void o0() {
        this.I++;
    }

    @Override // dc.bt1
    public void o1(@Nullable String str) {
        if (str == null || str.length() == 0) {
            return;
        }
        this.a.q(str);
    }

    @Override // dc.bt1
    /* renamed from: o2, reason: from getter */
    public int getH() {
        return this.h;
    }

    @Override // dc.bt1
    public void p(int i) {
        pb0 pb0Var = (pb0) ArraysKt___ArraysKt.getOrNull(pb0.values(), i);
        if (pb0Var == null) {
            pb0Var = pb0.NOT_INIT;
        }
        this.a.Y(pb0Var);
    }

    @Override // dc.bt1
    public boolean p0() {
        String strF = this.a.f();
        if (strF != null) {
            return StringsKt__StringsJVMKt.equals(strF, "j", true);
        }
        return false;
    }

    @Override // dc.bt1
    public void p1() {
    }

    @Override // dc.bt1
    public int p2() {
        return this.a.getOtherAppConnectState();
    }

    @Override // dc.bt1
    @NotNull
    public String q() {
        return t10.d(this.a);
    }

    @Override // dc.bt1
    public int q0() {
        return tb0.f(this.a);
    }

    @Override // dc.bt1
    @NotNull
    public String q1(@Nullable BleResultBean bleResultBean) {
        String str;
        HashMap map = new HashMap();
        map.put("fversion", getVersion() + "");
        map.put(BleService.EXTRA_RSSI, g30.a.c(P()));
        if (bleResultBean != null) {
            if (bleResultBean.getCode() == mt.CONNECT_FAILED_BY_STATE_CHANGE.getCode()) {
                Integer status = bleResultBean.getStatus();
                map.put("message", ze3.f(status != null ? status.intValue() : -1));
                Integer status2 = bleResultBean.getStatus();
                map.put(XHTMLText.CODE, String.valueOf(status2 != null ? status2.intValue() : -1));
            } else {
                map.put("message", bleResultBean.getMsg());
                map.put(XHTMLText.CODE, String.valueOf(bleResultBean.getCode()));
            }
        }
        String str2 = "-1";
        if (W() <= 0) {
            str = "-1";
        } else {
            str = W() + "";
        }
        map.put("battery", str);
        StringBuilder sb = new StringBuilder();
        String strZ2 = z2(L0());
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "getDefault()");
        String upperCase = strZ2.toUpperCase(locale);
        Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(locale)");
        sb.append(upperCase);
        sb.append("");
        map.put("mac", sb.toString());
        String type = getType();
        Locale locale2 = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale2, "getDefault()");
        String lowerCase = type.toLowerCase(locale2);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        map.put("type", lowerCase);
        WearUtils.K();
        if (WearUtils.x.a > 0) {
            str2 = WearUtils.x.a + "";
        }
        map.put("s_battery", str2);
        map.put("is_lowpower", WearUtils.l1(WearUtils.x) ? "0" : "1");
        map.put("is_background", WearUtils.x.f0() ? "1" : "0");
        pc1 pc1VarG = WearUtils.x.G();
        MyApplication application = WearUtils.x;
        Intrinsics.checkNotNullExpressionValue(application, "application");
        map.put("is_bluetooth_on", pc1VarG.y(application, false) ? "1" : "0");
        map.put("isLongrange", Integer.valueOf(v2() == 1 ? 1 : 0));
        if (getC() != 1 || getD() - System.currentTimeMillis() >= 5000) {
            map.put("is_poweroff", "0");
        } else {
            map.put("is_poweroff", "1");
        }
        C2(0);
        String json = WearUtils.A.toJson(map);
        Intrinsics.checkNotNullExpressionValue(json, "gson.toJson(hashMap)");
        return json;
    }

    @Override // dc.bt1
    @NotNull
    public String q2(int i) {
        if (w0()) {
            if (i == 1) {
                return "Mini XMachine";
            }
            if (i == 2) {
                return Toy.TOY_XMACHINE;
            }
            if (i == 3) {
                return "Mini\nXMachine";
            }
        }
        return getShowName();
    }

    @Override // dc.bt1
    public void r(@Nullable String str) {
        if (str == null) {
            str = "";
        }
        this.c = str;
    }

    @Override // dc.bt1
    /* renamed from: r0, reason: from getter */
    public boolean getE() {
        return this.E;
    }

    @Override // dc.bt1
    public int r1() {
        int iH0 = h0();
        if (iH0 < 20 || iH0 >= 120) {
            return 0;
        }
        if (iH0 < 90) {
            return 3;
        }
        return iH0 < 105 ? 2 : 1;
    }

    @Override // dc.bt1
    public boolean r2(int i) {
        return j1() && i >= 3;
    }

    @Override // dc.bt1
    public void s(boolean z) {
        this.H = z;
    }

    @Override // dc.bt1
    public boolean s0() {
        return tb0.A(this.a);
    }

    @Override // dc.bt1
    @Nullable
    public String s1() {
        return this.a.getDefineRename();
    }

    @Override // dc.bt1
    public void s2(int i) {
        this.d = i;
    }

    @Override // dc.bt1
    public void setVersion(int version) {
        if (version <= 0 || this.a.getVersion() > 0) {
            return;
        }
        this.a.x(version);
    }

    @Override // dc.bt1
    public boolean supportCommand(@Nullable String message) {
        if (message == null || message.length() == 0) {
            return false;
        }
        String strZ = at1.b.z(getType());
        if (strZ == null || strZ.length() == 0) {
            return true;
        }
        Integer num = this.M.get(((String) StringsKt__StringsKt.split$default((CharSequence) message, new String[]{SignatureImpl.INNER_SEP}, false, 0, 6, (Object) null).get(0)) + ':');
        switch (num != null ? num.intValue() : 0) {
            case 0:
            case 1:
            default:
                return true;
            case 2:
                return StringsKt__StringsKt.contains$default((CharSequence) strZ, (CharSequence) "v1, v2", false, 2, (Object) null);
            case 3:
                return StringsKt__StringsKt.contains$default((CharSequence) strZ, (CharSequence) StreamManagement.AckRequest.ELEMENT, false, 2, (Object) null);
            case 4:
                return StringsKt__StringsKt.contains$default((CharSequence) strZ, (CharSequence) "p", false, 2, (Object) null);
            case 5:
                return StringsKt__StringsKt.contains$default((CharSequence) strZ, (CharSequence) "s", false, 2, (Object) null);
            case 6:
                return StringsKt__StringsKt.contains$default((CharSequence) strZ, (CharSequence) "t", false, 2, (Object) null);
            case 7:
                return StringsKt__StringsKt.contains$default((CharSequence) strZ, (CharSequence) "f", false, 2, (Object) null);
            case 8:
                return StringsKt__StringsKt.contains$default((CharSequence) strZ, (CharSequence) GoogleApiAvailabilityLight.TRACKING_SOURCE_DIALOG, false, 2, (Object) null);
        }
    }

    @Override // dc.bt1
    public void t(boolean z) {
        this.y = z;
    }

    @Override // dc.bt1
    public void t0(boolean z) {
    }

    @Override // dc.bt1
    public boolean t1() {
        return t10.l(this.a);
    }

    @Override // dc.bt1
    public boolean t2() {
        return ub0.g(this.a);
    }

    @Override // dc.bt1
    public void u(long j) {
        this.J = j;
    }

    @Override // dc.bt1
    @Nullable
    /* renamed from: u0, reason: from getter */
    public String getB() {
        return this.B;
    }

    @Override // dc.bt1
    public void u1(int i) {
        this.v = i;
    }

    @Override // dc.bt1
    public void u2(@NotNull ob0 connectPriority) {
        Intrinsics.checkNotNullParameter(connectPriority, "connectPriority");
        this.a.S(connectPriority);
    }

    @Override // dc.bt1
    public void v(@Nullable String str) {
        this.a.n(str);
    }

    @Override // dc.bt1
    public boolean v0() {
        return ub0.e(this.a);
    }

    @Override // dc.bt1
    public boolean v1() {
        return this.a.getIsSelect();
    }

    @Override // dc.bt1
    public int v2() {
        return this.a.getE().ordinal();
    }

    @Override // dc.bt1
    /* renamed from: w, reason: from getter */
    public int getT() {
        return this.t;
    }

    @Override // dc.bt1
    public boolean w0() {
        return ub0.f(this.a);
    }

    @Override // dc.bt1
    @NotNull
    public String w1() {
        int iQ0 = q0();
        return iQ0 > 1 ? String.valueOf(iQ0) : "";
    }

    @Override // dc.bt1
    /* renamed from: w2, reason: from getter */
    public int getC() {
        return this.C;
    }

    @Override // dc.bt1
    public int x() {
        int iH0 = h0();
        return iH0 >= -60 ? R.drawable.icon_signal_level4 : iH0 >= -70 ? R.drawable.icon_signal_level3 : iH0 >= -80 ? R.drawable.icon_signal_level2 : R.drawable.icon_signal_level1;
    }

    @Override // dc.bt1
    public boolean x0() {
        return ub0.c(this.a);
    }

    @Override // dc.bt1
    @NotNull
    public List<List<String>> x1() {
        List<List<String>> motors;
        com.component.dxtoy.core.toy.bean.ToyConfigInfoBean toyConfigInfoBeanG = this.a.g();
        return (toyConfigInfoBeanG == null || (motors = toyConfigInfoBeanG.getMotors()) == null) ? new ArrayList() : motors;
    }

    @Override // dc.bt1
    public void x2(int i) {
        this.a.a0(i);
    }

    @Override // dc.bt1
    public void y(int i) {
        this.s = i;
    }

    @Override // dc.bt1
    public boolean y0() {
        return ub0.g(this.a);
    }

    @Override // dc.bt1
    public int y1() {
        return t10.f(this.a);
    }

    @Override // dc.bt1
    /* renamed from: y2, reason: from getter */
    public int getI() {
        return this.I;
    }

    @Override // dc.bt1
    public void z(@NotNull Context context, @NotNull TextOverlayImageView imgView) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(imgView, "imgView");
        if (I()) {
            imgView.setVisibility(8);
            return;
        }
        int iW = W();
        imgView.setVisibility(iW >= 0 ? 0 : 8);
        imgView.setText(String.valueOf(iW));
        imgView.setTextSize(20);
        imgView.setTextColor(th4.b(context, R.color.text_color_85));
        imgView.setImageResource(ws1.m2(true, false, iW));
    }

    @Override // dc.bt1
    public void z0(long j) {
        this.p = j;
    }

    @Override // dc.bt1
    public void z1(int i) {
        this.m = i;
    }

    @Override // dc.bt1
    @NotNull
    public String z2(@Nullable String str) {
        String str2;
        if (str == null) {
            return "";
        }
        List listSplit$default = StringsKt__StringsKt.split$default((CharSequence) str, new String[]{SignatureImpl.INNER_SEP}, false, 0, 6, (Object) null);
        if (listSplit$default.size() == 3) {
            String lowerCase = ((String) listSplit$default.get(2)).toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
            str2 = (String) StringsKt__StringsKt.split$default((CharSequence) lowerCase, new String[]{";"}, false, 0, 6, (Object) null).get(0);
        } else {
            str2 = "";
        }
        return str2 == null ? "" : str2;
    }
}
