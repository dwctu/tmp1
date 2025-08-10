package dc;

import android.content.Context;
import android.widget.ImageView;
import com.component.dxbluetooth.lib.bean.BleResultBean;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.wear.bean.DfuBean;
import com.wear.bean.ToyConfigInfoBean;
import com.wear.util.TextOverlayImageView;
import com.wear.util.WearUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smackx.address.packet.MultipleAddresses;

/* compiled from: OldToy.kt */
@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b%\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\bZ\n\u0002\u0018\u0002\n\u0002\br\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\tH\u0016J\n\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\n\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\n\u0010\u0010\u001a\u0004\u0018\u00010\u000eH\u0016J\n\u0010\u0011\u001a\u0004\u0018\u00010\u000eH\u0016J\n\u0010\u0012\u001a\u0004\u0018\u00010\u000eH\u0016J\u0010\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014H\u0016J\b\u0010\u0016\u001a\u00020\u0015H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0015H\u0016J \u0010\u001a\u001a\u001a\u0012\u0014\u0012\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u001b\u0018\u00010\u0014H\u0016J\b\u0010\u001c\u001a\u00020\u0015H\u0016J\b\u0010\u001d\u001a\u00020\u0018H\u0016J\b\u0010\u001e\u001a\u00020\u0015H\u0016J\b\u0010\u001f\u001a\u00020\u0015H\u0016J\b\u0010 \u001a\u00020\u0018H\u0016J\n\u0010!\u001a\u0004\u0018\u00010\u000eH\u0016J\n\u0010\"\u001a\u0004\u0018\u00010\u000eH\u0016J\n\u0010#\u001a\u0004\u0018\u00010\u000eH\u0016J\n\u0010$\u001a\u0004\u0018\u00010\u000eH\u0016J\n\u0010%\u001a\u0004\u0018\u00010\u000eH\u0016J\u0014\u0010&\u001a\u0004\u0018\u00010\u000e2\b\u0010'\u001a\u0004\u0018\u00010\u000eH\u0016J\u0010\u0010(\u001a\u00020\u00152\u0006\u0010)\u001a\u00020\tH\u0016J\b\u0010*\u001a\u00020\u0015H\u0016J\n\u0010+\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010,\u001a\u00020\u0018H\u0016J\n\u0010-\u001a\u0004\u0018\u00010\u000eH\u0016J\n\u0010.\u001a\u0004\u0018\u00010\u000eH\u0016J\n\u0010/\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u00100\u001a\u00020\u0018H\u0016J\b\u00101\u001a\u00020\u0018H\u0016J\n\u00102\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u00103\u001a\u00020\u0015H\u0016J\b\u00104\u001a\u00020\u0015H\u0016J\b\u00105\u001a\u00020\u0015H\u0016J\b\u00106\u001a\u00020\u0015H\u0016J\b\u00107\u001a\u00020\u0015H\u0016J\b\u00108\u001a\u00020\u0015H\u0016J\b\u00109\u001a\u00020\u0015H\u0016J\b\u0010:\u001a\u00020\u0015H\u0016J\b\u0010;\u001a\u00020\u0015H\u0016J\n\u0010<\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010=\u001a\u00020\u000eH\u0016J\u0012\u0010>\u001a\u0004\u0018\u00010\u000e2\u0006\u0010?\u001a\u00020\u0015H\u0016J\u000e\u0010@\u001a\b\u0012\u0004\u0012\u00020A0\u0014H\u0016J\b\u0010B\u001a\u00020\u0015H\u0016J\n\u0010C\u001a\u0004\u0018\u00010DH\u0016J\u0014\u0010E\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u00140\u0014H\u0016J\n\u0010F\u001a\u0004\u0018\u00010\u000eH\u0016J\n\u0010G\u001a\u0004\u0018\u00010\u000eH\u0016J\u0014\u0010H\u001a\u0004\u0018\u00010\u000e2\b\u0010I\u001a\u0004\u0018\u00010JH\u0016J\n\u0010K\u001a\u0004\u0018\u00010\u000eH\u0016J\n\u0010L\u001a\u0004\u0018\u00010\u000eH\u0016J\n\u0010M\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010N\u001a\u00020\u0018H\u0016J\n\u0010O\u001a\u0004\u0018\u00010DH\u0016J\u001c\u0010P\u001a\u0016\u0012\u0004\u0012\u00020\u000e\u0018\u00010Qj\n\u0012\u0004\u0012\u00020\u000e\u0018\u0001`RH\u0016J\b\u0010S\u001a\u00020\u0015H\u0016J\u0006\u0010T\u001a\u00020\u0004J\n\u0010U\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010V\u001a\u00020\tH\u0016J\b\u0010W\u001a\u00020\u0018H\u0016J\b\u0010X\u001a\u00020\u0015H\u0016J\b\u0010Y\u001a\u00020\u0015H\u0016J\u0012\u0010Z\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u00010\u0014H\u0016J\b\u0010[\u001a\u00020\u0015H\u0016J\b\u0010\\\u001a\u00020\u000eH\u0016J\n\u0010]\u001a\u0004\u0018\u00010\u000eH\u0016J\n\u0010^\u001a\u0004\u0018\u00010\u000eH\u0016J\n\u0010_\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010`\u001a\u00020\u0015H\u0016J\n\u0010a\u001a\u0004\u0018\u00010\u000eH\u0016J\n\u0010b\u001a\u0004\u0018\u00010cH\u0016J\b\u0010d\u001a\u00020\u0015H\u0016J\b\u0010e\u001a\u00020\u0015H\u0016J\u0010\u0010f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0014H\u0016J\n\u0010g\u001a\u0004\u0018\u00010\u000eH\u0016J\u0012\u0010h\u001a\u0004\u0018\u00010\u000e2\u0006\u0010i\u001a\u00020\u0015H\u0016J\b\u0010j\u001a\u00020\u0015H\u0016J\n\u0010k\u001a\u0004\u0018\u00010\u000eH\u0016J\n\u0010l\u001a\u0004\u0018\u00010\u000eH\u0016J\n\u0010m\u001a\u0004\u0018\u00010nH\u0016J\b\u0010o\u001a\u00020\u0018H\u0016J\n\u0010p\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010q\u001a\u00020\u0015H\u0016J\n\u0010r\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010s\u001a\u00020\u0015H\u0016J\b\u0010t\u001a\u00020\tH\u0016J\b\u0010u\u001a\u00020\tH\u0016J\b\u0010v\u001a\u00020\tH\u0016J\b\u0010w\u001a\u00020\tH\u0016J\b\u0010x\u001a\u00020\tH\u0016J\b\u0010y\u001a\u00020\tH\u0016J\b\u0010z\u001a\u00020\tH\u0016J\b\u0010{\u001a\u00020\tH\u0016J\b\u0010|\u001a\u00020\tH\u0016J\u0010\u0010|\u001a\u00020\t2\u0006\u0010}\u001a\u00020\u0015H\u0016J\b\u0010~\u001a\u00020\tH\u0016J\b\u0010\u007f\u001a\u00020\tH\u0016J\t\u0010\u0080\u0001\u001a\u00020\tH\u0016J\t\u0010\u0081\u0001\u001a\u00020\tH\u0016J\t\u0010\u0082\u0001\u001a\u00020\tH\u0016J\t\u0010\u0083\u0001\u001a\u00020\tH\u0016J\t\u0010\u0084\u0001\u001a\u00020\tH\u0016J\t\u0010\u0085\u0001\u001a\u00020\u0015H\u0016J\t\u0010\u0086\u0001\u001a\u00020\tH\u0016J\u0011\u0010\u0086\u0001\u001a\u00020\t2\u0006\u0010}\u001a\u00020\u0015H\u0016J\t\u0010\u0087\u0001\u001a\u00020\tH\u0016J\t\u0010\u0088\u0001\u001a\u00020\tH\u0016J\t\u0010\u0089\u0001\u001a\u00020\tH\u0016J\t\u0010\u008a\u0001\u001a\u00020\tH\u0016J\t\u0010\u008b\u0001\u001a\u00020\tH\u0016J\t\u0010\u008c\u0001\u001a\u00020\tH\u0016J\t\u0010\u008d\u0001\u001a\u00020\tH\u0016J\t\u0010\u008e\u0001\u001a\u00020\tH\u0016J\t\u0010\u008f\u0001\u001a\u00020\tH\u0016J\t\u0010\u0090\u0001\u001a\u00020\tH\u0016J\t\u0010\u0091\u0001\u001a\u00020\tH\u0016J\t\u0010\u0092\u0001\u001a\u00020\tH\u0016J\t\u0010\u0093\u0001\u001a\u00020\tH\u0016J\t\u0010\u0094\u0001\u001a\u00020\tH\u0016J\t\u0010\u0095\u0001\u001a\u00020\tH\u0016J\t\u0010\u0096\u0001\u001a\u00020\tH\u0016J\t\u0010\u0097\u0001\u001a\u00020\tH\u0016J\t\u0010\u0098\u0001\u001a\u00020\tH\u0016J\t\u0010\u0099\u0001\u001a\u00020\tH\u0016J\t\u0010\u009a\u0001\u001a\u00020\tH\u0016J\t\u0010\u009b\u0001\u001a\u00020\tH\u0016J\t\u0010\u009c\u0001\u001a\u00020\tH\u0016J\u0012\u0010\u009d\u0001\u001a\u00020\t2\u0007\u0010\u009e\u0001\u001a\u00020\tH\u0016J\t\u0010\u009f\u0001\u001a\u00020\tH\u0016J\t\u0010 \u0001\u001a\u00020\tH\u0016J\t\u0010¡\u0001\u001a\u00020\tH\u0016J\t\u0010¢\u0001\u001a\u00020\tH\u0016J\t\u0010£\u0001\u001a\u00020\tH\u0016J\t\u0010¤\u0001\u001a\u00020\tH\u0016J\t\u0010¥\u0001\u001a\u00020\tH\u0016J\t\u0010¦\u0001\u001a\u00020\tH\u0016J\t\u0010§\u0001\u001a\u00020\tH\u0016J\t\u0010¨\u0001\u001a\u00020\tH\u0016J\t\u0010©\u0001\u001a\u00020\tH\u0016J\t\u0010ª\u0001\u001a\u00020\tH\u0016J\t\u0010«\u0001\u001a\u00020\tH\u0016J\t\u0010¬\u0001\u001a\u00020\tH\u0016J\u0012\u0010\u00ad\u0001\u001a\u00020\u00062\u0007\u0010®\u0001\u001a\u00020\u0015H\u0016J\u0014\u0010¯\u0001\u001a\u00020\u00062\t\u0010°\u0001\u001a\u0004\u0018\u00010\u000eH\u0016J\u0012\u0010±\u0001\u001a\u00020\u00062\u0007\u0010²\u0001\u001a\u00020\u0015H\u0016J\t\u0010³\u0001\u001a\u00020\u0006H\u0016J\u0014\u0010´\u0001\u001a\u00020\u00062\t\u0010µ\u0001\u001a\u0004\u0018\u00010\u000eH\u0016J\u0014\u0010¶\u0001\u001a\u00020\u00062\t\u0010·\u0001\u001a\u0004\u0018\u00010\u000eH\u0016J\u001d\u0010¸\u0001\u001a\u00020\u00062\t\u0010¹\u0001\u001a\u0004\u0018\u00010\u000e2\u0007\u0010º\u0001\u001a\u00020\tH\u0016J\u0014\u0010»\u0001\u001a\u00020\u00062\t\u0010¼\u0001\u001a\u0004\u0018\u00010\u000eH\u0016J\u0012\u0010½\u0001\u001a\u00020\u00062\u0007\u0010¾\u0001\u001a\u00020\u0015H\u0016J\u0012\u0010¿\u0001\u001a\u00020\u00062\u0007\u0010À\u0001\u001a\u00020\u0018H\u0016J\u0012\u0010Á\u0001\u001a\u00020\u00062\u0007\u0010Â\u0001\u001a\u00020\u0015H\u0016J\u0012\u0010Ã\u0001\u001a\u00020\u00062\u0007\u0010Ä\u0001\u001a\u00020\tH\u0016J\u0012\u0010Å\u0001\u001a\u00020\u00062\u0007\u0010Æ\u0001\u001a\u00020\u0015H\u0016J\u0013\u0010Ç\u0001\u001a\u00020\u00062\b\u0010È\u0001\u001a\u00030É\u0001H\u0016J\u0012\u0010Ê\u0001\u001a\u00020\u00062\u0007\u0010Ë\u0001\u001a\u00020\u0018H\u0016J\u0012\u0010Ì\u0001\u001a\u00020\u00062\u0007\u0010Í\u0001\u001a\u00020\u0015H\u0016J\u0012\u0010Î\u0001\u001a\u00020\u00062\u0007\u0010Ï\u0001\u001a\u00020\u0015H\u0016J\u0012\u0010Ð\u0001\u001a\u00020\u00062\u0007\u0010Ñ\u0001\u001a\u00020\u0018H\u0016J\u0014\u0010Ò\u0001\u001a\u00020\u00062\t\u0010Ó\u0001\u001a\u0004\u0018\u00010\u000eH\u0016J\u0014\u0010Ô\u0001\u001a\u00020\u00062\t\u0010Õ\u0001\u001a\u0004\u0018\u00010\u000eH\u0016J\u0014\u0010Ö\u0001\u001a\u00020\u00062\t\u0010×\u0001\u001a\u0004\u0018\u00010\u000eH\u0016J\u0013\u0010Ø\u0001\u001a\u00020\u00062\b\u0010'\u001a\u0004\u0018\u00010\u000eH\u0016J\u0012\u0010Ù\u0001\u001a\u00020\u00062\u0007\u0010Ú\u0001\u001a\u00020\tH\u0016J\u0012\u0010Û\u0001\u001a\u00020\u00062\u0007\u0010Ü\u0001\u001a\u00020\u0015H\u0016J\u0014\u0010Ý\u0001\u001a\u00020\u00062\t\u0010Þ\u0001\u001a\u0004\u0018\u00010\u000eH\u0016J\u0012\u0010ß\u0001\u001a\u00020\u00062\u0007\u0010à\u0001\u001a\u00020\tH\u0016J\u0012\u0010á\u0001\u001a\u00020\u00062\u0007\u0010â\u0001\u001a\u00020\tH\u0016J\u0012\u0010ã\u0001\u001a\u00020\u00062\u0007\u0010ä\u0001\u001a\u00020\tH\u0016J\u0012\u0010å\u0001\u001a\u00020\u00062\u0007\u0010æ\u0001\u001a\u00020\tH\u0016J\u0012\u0010ç\u0001\u001a\u00020\u00062\u0007\u0010è\u0001\u001a\u00020\u0018H\u0016J\u0014\u0010é\u0001\u001a\u00020\u00062\t\u0010ê\u0001\u001a\u0004\u0018\u00010\u000eH\u0016J\u0012\u0010ë\u0001\u001a\u00020\u00062\u0007\u0010ì\u0001\u001a\u00020\u0018H\u0016J\u0012\u0010í\u0001\u001a\u00020\u00062\u0007\u0010î\u0001\u001a\u00020\u0018H\u0016J\u0014\u0010ï\u0001\u001a\u00020\u00062\t\u0010ð\u0001\u001a\u0004\u0018\u00010\u000eH\u0016J\u0012\u0010ñ\u0001\u001a\u00020\u00062\u0007\u0010ò\u0001\u001a\u00020\u0015H\u0016J\u0012\u0010ó\u0001\u001a\u00020\u00062\u0007\u0010ô\u0001\u001a\u00020\u0015H\u0016J\u0012\u0010õ\u0001\u001a\u00020\u00062\u0007\u0010ö\u0001\u001a\u00020\u0015H\u0016J\u0012\u0010÷\u0001\u001a\u00020\u00062\u0007\u0010ø\u0001\u001a\u00020\u0015H\u0016J\u0012\u0010ù\u0001\u001a\u00020\u00062\u0007\u0010\u0094\u0001\u001a\u00020\u0015H\u0016J\u0012\u0010ú\u0001\u001a\u00020\u00062\u0007\u0010û\u0001\u001a\u00020\u0015H\u0016J\u0012\u0010ü\u0001\u001a\u00020\u00062\u0007\u0010\u008a\u0001\u001a\u00020\tH\u0016J\u0012\u0010ý\u0001\u001a\u00020\u00062\u0007\u0010þ\u0001\u001a\u00020\u0015H\u0016J\u0012\u0010ÿ\u0001\u001a\u00020\u00062\u0007\u0010\u0080\u0002\u001a\u00020\u0015H\u0016J\u0014\u0010\u0081\u0002\u001a\u00020\u00062\t\u0010\u0082\u0002\u001a\u0004\u0018\u00010\u000eH\u0016J\u0014\u0010\u0083\u0002\u001a\u00020\u00062\t\u0010\u0084\u0002\u001a\u0004\u0018\u00010\u000eH\u0016J\u0012\u0010\u0085\u0002\u001a\u00020\u00062\u0007\u0010\u0086\u0002\u001a\u00020\u0015H\u0016J\u0012\u0010\u0087\u0002\u001a\u00020\u00062\u0007\u0010\u0088\u0002\u001a\u00020DH\u0016J\u0014\u0010\u0089\u0002\u001a\u00020\u00062\t\u0010\u008a\u0002\u001a\u0004\u0018\u00010\u000eH\u0016J\u0010\u0010\u008b\u0002\u001a\u00020\u00062\u0007\u0010\u008c\u0002\u001a\u00020\u0004J\u0014\u0010\u008d\u0002\u001a\u00020\u00062\t\u0010\u008e\u0002\u001a\u0004\u0018\u00010\u000eH\u0016J\u0012\u0010\u008f\u0002\u001a\u00020\u00062\u0007\u0010\u0090\u0002\u001a\u00020\u0018H\u0016J\u0012\u0010\u0091\u0002\u001a\u00020\u00062\u0007\u0010\u0092\u0002\u001a\u00020\tH\u0016J\u0014\u0010\u0093\u0002\u001a\u00020\u00062\t\u0010\u0094\u0002\u001a\u0004\u0018\u00010\u000eH\u0016J\t\u0010\u0095\u0002\u001a\u00020\u0006H\u0016J\u0012\u0010\u0096\u0002\u001a\u00020\u00062\u0007\u0010\u0097\u0002\u001a\u00020\u0018H\u0016J\u0012\u0010\u0098\u0002\u001a\u00020\u00062\u0007\u0010²\u0001\u001a\u00020\u0015H\u0016J\u0012\u0010\u0099\u0002\u001a\u00020\u00062\u0007\u0010\u009a\u0002\u001a\u00020\u0015H\u0016J\u0012\u0010\u009b\u0002\u001a\u00020\u00062\u0007\u0010\u009c\u0002\u001a\u00020\u0015H\u0016J\u0012\u0010\u009d\u0002\u001a\u00020\u00062\u0007\u0010\u009e\u0002\u001a\u00020\tH\u0016J\t\u0010\u009f\u0002\u001a\u00020\u0006H\u0016J\u0014\u0010\u009f\u0002\u001a\u00020\u00062\t\u0010 \u0002\u001a\u0004\u0018\u00010cH\u0016J\u0012\u0010¡\u0002\u001a\u00020\u00062\u0007\u0010¢\u0002\u001a\u00020\tH\u0016J\u0012\u0010£\u0002\u001a\u00020\u00062\u0007\u0010¤\u0002\u001a\u00020\tH\u0016J\u0013\u0010¥\u0002\u001a\u00020\u00062\b\u0010i\u001a\u0004\u0018\u00010\u000eH\u0016J\u0014\u0010¦\u0002\u001a\u00020\u00062\t\u0010§\u0002\u001a\u0004\u0018\u00010\u000eH\u0016J\u0014\u0010¨\u0002\u001a\u00020\u00062\t\u0010©\u0002\u001a\u0004\u0018\u00010nH\u0016J\u0012\u0010ª\u0002\u001a\u00020\u00062\u0007\u0010«\u0002\u001a\u00020\u0018H\u0016J\u0014\u0010¬\u0002\u001a\u00020\u00062\t\u0010\u00ad\u0002\u001a\u0004\u0018\u00010\u000eH\u0016J\u0011\u0010®\u0002\u001a\u00020\u00062\u0006\u0010}\u001a\u00020\u0015H\u0016J\u0014\u0010¯\u0002\u001a\u00020\u00062\t\u0010°\u0002\u001a\u0004\u0018\u00010\u000eH\u0016J\u0012\u0010±\u0002\u001a\u00020\u00062\u0007\u0010²\u0002\u001a\u00020\u0015H\u0016J\t\u0010³\u0002\u001a\u00020\tH\u0016J\u0014\u0010´\u0002\u001a\u00020\t2\t\u0010µ\u0002\u001a\u0004\u0018\u00010\u000eH\u0016J\t\u0010¶\u0002\u001a\u00020\u0006H\u0016J\t\u0010·\u0002\u001a\u00020\tH\u0016J\t\u0010¸\u0002\u001a\u00020\tH\u0016J\t\u0010¹\u0002\u001a\u00020\u0015H\u0016J\u001d\u0010º\u0002\u001a\u00020\u00062\b\u0010»\u0002\u001a\u00030¼\u00022\b\u0010½\u0002\u001a\u00030¾\u0002H\u0016J\u0013\u0010¿\u0002\u001a\u00020\u00062\b\u0010½\u0002\u001a\u00030À\u0002H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006Á\u0002"}, d2 = {"Lcom/wear/component/dxtoy/toy/impl/OldToy;", "Lcom/wear/component/dxtoy/toy/interfaces/IToy;", "()V", "oldToyBean", "Lcom/wear/component/dxtoy/toy/bean/OldToyBean;", "addConnectTryNumb", "", "addLanApiUpdateCount", "canAddConnectingLog", "", "isAutoPlus", "canGetBattery", "canSetLed", "getAddress", "", "getAgString", "getAiString", "getAndUpdateDeviceId", "getBatchId", "getBattayList", "", "", "getBattery", "getBatteryRequestTime", "", "getBindType", "getCommandList", "", "getConnectApp", "getConnectScanTime", "getConnectTryNumb", "getConnectType", "getConnectedTime", "getDataBaseType", "getDefineRename", "getDeviceId", "getDeviceName", "getDeviceType", "getDeviceTypeMac", "deviceType", "getDfuIcon", "isFail", "getDisConnectType", "getEmail", "getFeedbackDownTime", "getFormApp", "getFullName", "getGenerationVersion", "getGetCheckBindToyErrorTime", "getGetDfuErrorTime", "getId", "getIsCheckBindToy", "getIsDfuEnd", "getIsLongRange", "getIsPowerOff", "getIsSelect", "getLanApiUpdateCount", "getLdrIcon", "getLed", "getLedSetting", "getLogFormApp", "getLogToyType", "getLogToyTypeAndRssi", "stateCode", "getLvsMotorsFuncList", "Lcom/component/dxtoy/core/toy/constant/ToyCoreEum$MotorFunction;", "getMissionSolo", "getMissionTchLvl", "", "getMotors", "getMultiplayOrder", "getName", "getNewLogToyTypeAndRssi", "resultBean", "Lcom/component/dxbluetooth/lib/bean/BleResultBean;", "getOldEmail", "getOldId", "getPinStatus", "getPowerOffTime", "getProgramDefaultLevel", "getProgramDefaultProgram", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getProgramSpeed", "getRealToyBean", "getRealType", "getReconnectOvertime", "getRquestConnectTime", "getRssi", "getRssiImg", "getRssiList", "getSearchToyIcon", "getShowName", "getSimpleFullName", "getSimpleName", "getSimpleType", "getStatus", "getSymbol", "getToyConfigDataBean", "Lcom/wear/bean/ToyConfigInfoBean;", "getToyIcon", "getToyRssiLevel", "getToySymbol", "getToyTypeKey", "getToyUINameSpecialForMiniXMachine", "type", "getToyVersion", "getType", "getUpCaseName", "getUpdateDfu", "Lcom/wear/bean/DfuBean;", "getUpdateTime", "getUuid", "getVersion", "getWorkMode", "getaColor", "hasProgramToy", "isAlarmEnable", "isBAToy", "isCanWearToy", "isCmdCompensation", "isConnected", "isDirection", "isEAToy", "isEI01Toy", "version", "isEL01Toy", "isEncrypt", "isF01IsNotice", "isF01IsReady", "isF01Off", "isF01Toy", "isFeedbackModeEnable", "isFeedbackModeEnableAndUpdateEnable", "isGeminiToy", "isGravity", "isH01Toy", "isJ01Toy", "isLanApiUpdateRequest", "isMax", "isMaxToy", "isMiniXMachine", "isMultiplyInstruct", "isNora", "isNoraToy", "isQ01Toy", "isQA01Toy", "isRealDeviceType", "isSelect", "isSelected", "isSetGradualSpeedUpEnable", "isSetThresholdEnable", "isSupportAir", "isSupportBt", "isSupportControlPanel", "isSupportDepthMode", "isSupportGame", "isSupportLEDColor", "isMotherboardLED", "isSupportLVS", "isSupportLdr", "isSupportR", "isSupportV1V2", "isSupportV1V2F", "isSuppportPinCode", "isSynControlAnimation", "isT01Toy", "isThridPartToy", "isToyListAdd", "isTransfer", "isV01Toy", "isVirtualToy", "isXMachine", "pushBattay", "battay", "pushCommand", "command", "pushRssi", "rssi", "reduceConnectTryNumb", "setAddress", MultipleAddresses.Address.ELEMENT, "setAgString", "agString", "setAiString", "aiString", "isShowDialog", "setBatchId", "batchId", "setBattery", "battery", "setBatteryRequestTime", "batteryRequestTime", "setBindType", "bindType", "setCanRssi", "canRssi", "setConnectApp", "connectApp", "setConnectPriority", "connectPriority", "Lcom/component/dxtoy/core/toy/constant/ToyCoreEum$ConnectPriority;", "setConnectScanTime", "connectScanTime", "setConnectTryNumb", "connectTryNumb", "setConnectType", "connectType", "setConnectedTime", "connectedTime", "setDefineRename", "defineRename", "setDeviceId", "deviceId", "setDeviceName", "deviceName", "setDeviceType", "setDirection", "direction", "setDisConnectType", "disConnectType", "setEmail", "email", "setEncrypt", "encrypt", "setF01IsNotice", "f01IsNotice", "setF01IsOff", "f01IsOff", "setF01IsReady", "f01IsReady", "setFeedbackDownTime", "time", "setFormApp", "formApp", "setGetCheckBindToyErrorTime", "getCheckBindToyErrorTime", "setGetDfuErrorTime", "getDfuErrorTime", "setId", TtmlNode.ATTR_ID, "setIsCheckBindToy", "isCheckBindToy", "setIsDfuEnd", "isDfuEnd", "setIsLongRange", "isLongRange", "setIsPowerOff", "isPowerOff", "setIsSelect", "setLanApiUpdateCount", "lanApiUpdateCount", "setLanApiUpdateRequest", "setLed", "led", "setLedSetting", "ledSetting", "setLogFormApp", "logFormApp", "setLvsMotorConfig", "lvsMotorConfig", "setMissionSolo", "missionSolo", "setMissionTchLvl", "missionTchLvl", "setName", "name", "setOldToyBean", "toyBean", "setPinStatus", "pinStatus", "setPowerOffTime", "powerOffTime", "setRealDeviceType", "realDeviceType", "setRealType", "realType", "setRenameDeviceName", "setRquestConnectTime", "requestConnectTime", "setRssi", "setSimpleToy", "simpleToy", "setStatus", "status", "setSynControlAnimation", "synControlAnimation", "setToyConfigDataBean", "toyConfigDataBean", "setToyListAdd", "toyListAdd", "setTransfer", "transfer", "setType", "setUpCaseName", "upCaseName", "setUpdateDfu", "updateDfu", "setUpdateTime", "updateTime", "setUuid", "uuid", "setVersion", "setWorkMode", "workMode", "setaColor", "aColor", "supportChangeName", "supportCommand", "message", "synNameToType", "toyIsSupport", "toyIsSupportLanApi", "typeInt", "updateMyToyBattery", "context", "Landroid/content/Context;", "imgView", "Lcom/wear/util/TextOverlayImageView;", "updateToyBattery", "Landroid/widget/ImageView;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class ys1 implements bt1 {

    @NotNull
    public ws1 a = new ws1();

    @Override // dc.bt1
    public boolean A() {
        return this.a.G1();
    }

    @Override // dc.bt1
    public boolean A0() {
        return this.a.b2();
    }

    @Override // dc.bt1
    @Nullable
    public int[] A1() {
        return this.a.t0();
    }

    @Override // dc.bt1
    @Nullable
    public DfuBean A2() {
        return this.a.c1();
    }

    @Override // dc.bt1
    public void B(boolean z) {
        this.a.y2(z);
    }

    @Override // dc.bt1
    @Nullable
    public String B0() {
        return this.a.v0();
    }

    @Override // dc.bt1
    public void B1(long j) {
        this.a.connectedTime = Long.valueOf(j);
    }

    @Override // dc.bt1
    public void B2(@Nullable String str) {
        this.a.g3(str);
    }

    @Override // dc.bt1
    @Nullable
    public String C() {
        return this.a.R();
    }

    @Override // dc.bt1
    public void C0(boolean z) {
        this.a.S2(z);
    }

    @Override // dc.bt1
    public boolean C1() {
        return j0() ? W0() >= 36 : w0() && W0() >= 3;
    }

    @Override // dc.bt1
    public void C2(int i) {
        this.a.G2(i);
    }

    @Override // dc.bt1
    public boolean D() {
        return this.a.m3();
    }

    @Override // dc.bt1
    public void D0(int i) {
        this.a.I2(i);
    }

    @Override // dc.bt1
    @Nullable
    public String D1() {
        return this.a.d1();
    }

    @Override // dc.bt1
    public boolean D2() {
        return this.a.a2();
    }

    @Override // dc.bt1
    public boolean E() {
        return this.a.f();
    }

    @Override // dc.bt1
    public void E0(long j) {
        this.a.C2(j);
    }

    @Override // dc.bt1
    public int E1() {
        return this.a.m0();
    }

    @Override // dc.bt1
    public void E2(@Nullable String str) {
        this.a.f2(str);
    }

    @Override // dc.bt1
    public void F(int i) {
        this.a.E2(i);
    }

    @Override // dc.bt1
    @Nullable
    public ToyConfigInfoBean F0() {
        return this.a.P0();
    }

    @Override // dc.bt1
    public void F1(@Nullable String str) {
        this.a.N2(str);
    }

    @Override // dc.bt1
    public void F2() {
        this.a.a();
    }

    @Override // dc.bt1
    @Nullable
    public String G() {
        return this.a.P();
    }

    @Override // dc.bt1
    public boolean G0() {
        return this.a.k1();
    }

    @Override // dc.bt1
    public void G1(@Nullable String str) {
        this.a.x2(str);
    }

    @Override // dc.bt1
    public void G2(boolean z) {
        this.a.p2(z);
    }

    @Override // dc.bt1
    public void H(@Nullable ToyConfigInfoBean toyConfigInfoBean) {
        this.a.b3(toyConfigInfoBean);
    }

    @Override // dc.bt1
    @Nullable
    public String H0() {
        return this.a.f1();
    }

    @Override // dc.bt1
    @Nullable
    public String H1() {
        return this.a.z();
    }

    @Override // dc.bt1
    @Nullable
    public List<String> H2() {
        return this.a.I0();
    }

    @Override // dc.bt1
    public boolean I() {
        return this.a.u1();
    }

    @Override // dc.bt1
    @Nullable
    public String I0(int i) {
        return this.a.q0(i);
    }

    @Override // dc.bt1
    public boolean I1() {
        return this.a.y1();
    }

    @Override // dc.bt1
    public void I2(int i) {
        this.a.F2(i);
    }

    @Override // dc.bt1
    @Nullable
    public List<String> J() {
        return this.a.W0();
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
    public long J1() {
        return this.a.d0();
    }

    @Override // dc.bt1
    @Nullable
    public String J2() {
        return this.a.b1();
    }

    @Override // dc.bt1
    @Nullable
    public String K() {
        return this.a.getFormApp();
    }

    @Override // dc.bt1
    public void K0(@Nullable String str) {
        this.a.setId(str);
    }

    @Override // dc.bt1
    public int K1() {
        return this.a.W();
    }

    @Override // dc.bt1
    public boolean K2() {
        return this.a.t1();
    }

    @Override // dc.bt1
    @Nullable
    public String L() {
        return this.a.o0();
    }

    @Override // dc.bt1
    @Nullable
    public String L0() {
        return this.a.getDeviceType();
    }

    @Override // dc.bt1
    public boolean L1() {
        return this.a.W1();
    }

    @Override // dc.bt1
    public long L2() {
        Long lF0 = this.a.F0();
        Intrinsics.checkNotNullExpressionValue(lF0, "oldToyBean.getRquestConnectTime()");
        return lF0.longValue();
    }

    @Override // dc.bt1
    public boolean M() {
        return this.a.V1();
    }

    @Override // dc.bt1
    public int M0() {
        return this.a.T0();
    }

    @Override // dc.bt1
    public void M1(boolean z) {
        this.a.f01IsNotice = z;
    }

    @Override // dc.bt1
    public boolean M2() {
        return false;
    }

    @Override // dc.bt1
    public void N(@Nullable String str) {
        this.a.Q2(str);
    }

    @Override // dc.bt1
    public void N0(int i) {
        this.a.setaColor(i);
    }

    @Override // dc.bt1
    public void N1(@Nullable String str) {
        this.a.setFormApp(str);
    }

    @Override // dc.bt1
    public void N2(@Nullable String str) {
        this.a.setDeviceType(str);
    }

    @Override // dc.bt1
    public boolean O() {
        return this.a.j3();
    }

    @Override // dc.bt1
    @Nullable
    public String O0() {
        return this.a.getOldId();
    }

    @Override // dc.bt1
    public boolean O1() {
        return this.a.M1();
    }

    @Override // dc.bt1
    public void O2(@Nullable String str) {
        this.a.i3(str);
    }

    @Override // dc.bt1
    @Nullable
    public String P() {
        return this.a.getAddress();
    }

    @Override // dc.bt1
    @NotNull
    public String P0() {
        String strP0 = this.a.p0();
        Intrinsics.checkNotNullExpressionValue(strP0, "oldToyBean.logToyType");
        return strP0;
    }

    @Override // dc.bt1
    @Nullable
    public String P1() {
        return this.a.S();
    }

    @Override // dc.bt1
    public int P2() {
        return this.a.s0();
    }

    @Override // dc.bt1
    public long Q() {
        return this.a.E();
    }

    @Override // dc.bt1
    public boolean Q0() {
        return this.a.O1();
    }

    @Override // dc.bt1
    public int Q1() {
        Integer numN0 = this.a.n0();
        Intrinsics.checkNotNullExpressionValue(numN0, "oldToyBean.ledSetting");
        return numN0.intValue();
    }

    @Override // dc.bt1
    public void Q2(int i) {
        this.a.setStatus(i);
    }

    @Override // dc.bt1
    public void R(int i) {
        this.a.X2(Integer.valueOf(i));
    }

    @Override // dc.bt1
    public long R0() {
        return this.a.X();
    }

    @Override // dc.bt1
    public void R1(@Nullable String str) {
        this.a.i2(str);
    }

    @Override // dc.bt1
    public boolean R2() {
        return this.a.p1();
    }

    @Override // dc.bt1
    public boolean S(boolean z) {
        return this.a.d(z);
    }

    @Override // dc.bt1
    @Nullable
    public String S0() {
        return this.a.Y0();
    }

    @Override // dc.bt1
    @Nullable
    public String S1() {
        return this.a.M0();
    }

    @Override // dc.bt1
    public int S2() {
        Integer numI0 = this.a.i0();
        Intrinsics.checkNotNullExpressionValue(numI0, "oldToyBean.getIsSelect()");
        return numI0.intValue();
    }

    @Override // dc.bt1
    public void T(int i) {
        this.a.g2(i);
    }

    @Override // dc.bt1
    @NotNull
    public List<qb0> T0() {
        return CollectionsKt__CollectionsKt.emptyList();
    }

    @Override // dc.bt1
    public boolean T1() {
        return this.a.isEncrypt();
    }

    @NotNull
    /* renamed from: T2, reason: from getter */
    public final ws1 getA() {
        return this.a;
    }

    @Override // dc.bt1
    public boolean U() {
        return this.a.Z1();
    }

    @Override // dc.bt1
    @Nullable
    public String U0() {
        return this.a.Y();
    }

    @Override // dc.bt1
    public long U1() {
        return this.a.J();
    }

    public final void U2(@NotNull ws1 toyBean) {
        Intrinsics.checkNotNullParameter(toyBean, "toyBean");
        this.a = toyBean;
    }

    @Override // dc.bt1
    public void V(@Nullable String str) {
        this.a.M2(str);
    }

    @Override // dc.bt1
    public boolean V0(boolean z) {
        return this.a.R1(z);
    }

    @Override // dc.bt1
    public boolean V1() {
        return this.a.T1();
    }

    @Override // dc.bt1
    public int W() {
        return this.a.D();
    }

    @Override // dc.bt1
    public int W0() {
        return this.a.a1();
    }

    @Override // dc.bt1
    public void W1(@Nullable String str) {
        this.a.k2(str);
    }

    @Override // dc.bt1
    public long X() {
        return this.a.c0();
    }

    @Override // dc.bt1
    public void X0() {
        this.a.h2();
    }

    @Override // dc.bt1
    public long X1() {
        return this.a.getUpdateTime();
    }

    @Override // dc.bt1
    @Nullable
    public ArrayList<String> Y() {
        return this.a.B0();
    }

    @Override // dc.bt1
    @Nullable
    public String Y0() {
        return this.a.x();
    }

    @Override // dc.bt1
    public void Y1(int i) {
        this.a.s2(i);
    }

    @Override // dc.bt1
    public boolean Z() {
        return this.a.g1();
    }

    @Override // dc.bt1
    public void Z0(int i) {
        this.a.L2(Integer.valueOf(i));
    }

    @Override // dc.bt1
    public boolean Z1(int i) {
        return this.a.z1(i);
    }

    @Override // dc.bt1
    public boolean a() {
        return this.a.Q1();
    }

    @Override // dc.bt1
    public int a0() {
        return this.a.K();
    }

    @Override // dc.bt1
    @Nullable
    public String a1() {
        return this.a.B();
    }

    @Override // dc.bt1
    public void a2(boolean z) {
        this.a.f01IsReady = z;
    }

    @Override // dc.bt1
    public boolean b() {
        return this.a.l1();
    }

    @Override // dc.bt1
    public int b0() {
        return this.a.L();
    }

    @Override // dc.bt1
    public void b1(long j) {
        this.a.D2(j);
    }

    @Override // dc.bt1
    public void b2(int i) {
        this.a.e2(i);
    }

    @Override // dc.bt1
    public void c(@Nullable DfuBean dfuBean) {
        this.a.f3(dfuBean);
    }

    @Override // dc.bt1
    public void c0(int i) {
        this.a.t2(i);
    }

    @Override // dc.bt1
    public void c1(@Nullable String str, boolean z) {
        this.a.j2(str, z);
    }

    @Override // dc.bt1
    @Nullable
    public int[] c2() {
        return this.a.A0();
    }

    @Override // dc.bt1
    public boolean canSetLed() {
        return this.a.canSetLed();
    }

    @Override // dc.bt1
    public void d(int i) {
        this.a.l2(i);
    }

    @Override // dc.bt1
    public void d0() {
        this.a.k3();
    }

    @Override // dc.bt1
    public void d1(long j) {
        this.a.R2(j);
    }

    @Override // dc.bt1
    public boolean d2() {
        return this.a.N1();
    }

    @Override // dc.bt1
    public void e(@Nullable String str) {
        this.a.T2(str);
    }

    @Override // dc.bt1
    public void e0() {
        this.a.U2();
    }

    @Override // dc.bt1
    public boolean e1() {
        return this.a.v1();
    }

    @Override // dc.bt1
    public void e2(long j) {
        this.a.r2(j);
    }

    @Override // dc.bt1
    public void f(@Nullable String str) {
        this.a.e3(str);
    }

    @Override // dc.bt1
    public long f0() {
        return this.a.z0();
    }

    @Override // dc.bt1
    public int f1(boolean z) {
        return this.a.U(z);
    }

    @Override // dc.bt1
    public boolean f2() {
        return this.a.q1();
    }

    @Override // dc.bt1
    public void g(long j) {
        this.a.setUpdateTime(j);
    }

    @Override // dc.bt1
    @Nullable
    public String g0() {
        return this.a.D0();
    }

    @Override // dc.bt1
    public void g1(int i) {
        this.a.W2(i);
    }

    @Override // dc.bt1
    public boolean g2() {
        return this.a.S1();
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
        String showName = this.a.getShowName();
        Intrinsics.checkNotNullExpressionValue(showName, "oldToyBean.showName");
        return showName;
    }

    @Override // dc.bt1
    @Nullable
    public String getSimpleName() {
        return this.a.N0();
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
        if (WearUtils.c1(this.a.e1())) {
            return 0;
        }
        Integer numE1 = this.a.e1();
        Intrinsics.checkNotNullExpressionValue(numE1, "oldToyBean.version");
        return numE1.intValue();
    }

    @Override // dc.bt1
    @Nullable
    public String h() {
        return this.a.getOldEmail();
    }

    @Override // dc.bt1
    public int h0() {
        return this.a.G0();
    }

    @Override // dc.bt1
    public void h1(int i) {
        this.a.H2(Integer.valueOf(i));
    }

    @Override // dc.bt1
    public boolean h2() {
        return this.a.j1();
    }

    @Override // dc.bt1
    public boolean i() {
        return this.a.Y1();
    }

    @Override // dc.bt1
    public boolean i0() {
        return this.a.D1();
    }

    @Override // dc.bt1
    public int i1() {
        return this.a.F();
    }

    @Override // dc.bt1
    public void i2(@Nullable String str) {
        this.a.setType(str);
    }

    @Override // dc.bt1
    public boolean isConnected() {
        return this.a.m1();
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
        this.a.p3(imgView);
    }

    @Override // dc.bt1
    public boolean j0() {
        return this.a.d2();
    }

    @Override // dc.bt1
    public boolean j1() {
        return this.a.r1();
    }

    @Override // dc.bt1
    public void j2(@Nullable String str) {
        this.a.setName(str);
    }

    @Override // dc.bt1
    public void k(long j) {
        this.a.B2(j);
    }

    @Override // dc.bt1
    public void k0(boolean z) {
        this.a.A2(z);
    }

    @Override // dc.bt1
    public void k1(@Nullable String str) {
        this.a.setEmail(str);
    }

    @Override // dc.bt1
    public int k2() {
        return this.a.getaColor();
    }

    @Override // dc.bt1
    public boolean l() {
        return this.a.B1();
    }

    @Override // dc.bt1
    public void l0(boolean z) {
        this.a.c3(z);
    }

    @Override // dc.bt1
    public void l1(@NotNull int[] missionTchLvl) {
        Intrinsics.checkNotNullParameter(missionTchLvl, "missionTchLvl");
        this.a.P2(missionTchLvl);
    }

    @Override // dc.bt1
    public int l2() {
        return this.a.C0();
    }

    @Override // dc.bt1
    public long m() {
        Long l = this.a.connectedTime;
        Intrinsics.checkNotNullExpressionValue(l, "oldToyBean.connectedTime");
        return l.longValue();
    }

    @Override // dc.bt1
    public void m0(boolean z) {
        this.a.Y2(z);
    }

    @Override // dc.bt1
    public boolean m1() {
        return this.a.f01IsReady;
    }

    @Override // dc.bt1
    @Nullable
    public String m2() {
        return this.a.A();
    }

    @Override // dc.bt1
    public boolean n() {
        return this.a.X1();
    }

    @Override // dc.bt1
    public boolean n0() {
        return this.a.E0();
    }

    @Override // dc.bt1
    @Nullable
    public List<Integer> n1() {
        return this.a.C();
    }

    @Override // dc.bt1
    public int n2() {
        return this.a.J0();
    }

    @Override // dc.bt1
    @Nullable
    public List<Map<String, Long>> o() {
        return this.a.G();
    }

    @Override // dc.bt1
    public void o0() {
        this.a.b();
    }

    @Override // dc.bt1
    public void o1(@Nullable String str) {
        this.a.setAddress(str);
    }

    @Override // dc.bt1
    public int o2() {
        return this.a.f0();
    }

    @Override // dc.bt1
    public void p(int i) {
        this.a.isLongRange = i;
    }

    @Override // dc.bt1
    public boolean p0() {
        return this.a.C1();
    }

    @Override // dc.bt1
    public void p1() {
        this.a.a3();
    }

    @Override // dc.bt1
    public int p2() {
        return this.a.H();
    }

    @Override // dc.bt1
    @Nullable
    public String q() {
        return this.a.O0();
    }

    @Override // dc.bt1
    public int q0() {
        return this.a.n3();
    }

    @Override // dc.bt1
    @Nullable
    public String q1(@Nullable BleResultBean bleResultBean) {
        return this.a.x0(bleResultBean);
    }

    @Override // dc.bt1
    @Nullable
    public String q2(int i) {
        return this.a.Z0(i);
    }

    @Override // dc.bt1
    public void r(@Nullable String str) {
        this.a.w2(str);
    }

    @Override // dc.bt1
    public boolean r0() {
        return this.a.f01IsNotice;
    }

    @Override // dc.bt1
    public int r1() {
        return this.a.V0();
    }

    @Override // dc.bt1
    public boolean r2(int i) {
        return this.a.s1(i);
    }

    @Override // dc.bt1
    public void s(boolean z) {
        this.a.J2(z);
    }

    @Override // dc.bt1
    public boolean s0() {
        return this.a.l3();
    }

    @Override // dc.bt1
    @Nullable
    public String s1() {
        return this.a.Q();
    }

    @Override // dc.bt1
    public void s2(int i) {
        this.a.O2(i);
    }

    @Override // dc.bt1
    public void setVersion(int version) {
        this.a.h3(Integer.valueOf(version));
    }

    @Override // dc.bt1
    public boolean supportCommand(@Nullable String message) {
        return this.a.supportCommand(message);
    }

    @Override // dc.bt1
    public void t(boolean z) {
        this.a.d3(z);
    }

    @Override // dc.bt1
    public void t0(boolean z) {
        this.a.setEncrypt(z);
    }

    @Override // dc.bt1
    public boolean t1() {
        return this.a.U1();
    }

    @Override // dc.bt1
    public boolean t2() {
        return this.a.I1();
    }

    @Override // dc.bt1
    public void u(long j) {
        this.a.n2(j);
    }

    @Override // dc.bt1
    @Nullable
    public String u0() {
        return this.a.y0();
    }

    @Override // dc.bt1
    public void u1(int i) {
        this.a.z2(i);
    }

    @Override // dc.bt1
    public void u2(@NotNull ob0 connectPriority) {
        Intrinsics.checkNotNullParameter(connectPriority, "connectPriority");
    }

    @Override // dc.bt1
    public void v(@Nullable String str) {
        this.a.v2(str);
    }

    @Override // dc.bt1
    public boolean v0() {
        return this.a.E1();
    }

    @Override // dc.bt1
    public boolean v1() {
        return this.a.P1();
    }

    @Override // dc.bt1
    public int v2() {
        return this.a.isLongRange;
    }

    @Override // dc.bt1
    public int w() {
        return this.a.e0();
    }

    @Override // dc.bt1
    public boolean w0() {
        return this.a.F1();
    }

    @Override // dc.bt1
    @Nullable
    public String w1() {
        return this.a.b0();
    }

    @Override // dc.bt1
    public int w2() {
        return this.a.h0();
    }

    @Override // dc.bt1
    public int x() {
        return this.a.H0();
    }

    @Override // dc.bt1
    public boolean x0() {
        return this.a.A1();
    }

    @Override // dc.bt1
    @NotNull
    public List<List<String>> x1() {
        List<List<String>> listU0 = this.a.u0();
        return listU0 == null ? new ArrayList() : listU0;
    }

    @Override // dc.bt1
    public void x2(int i) {
        this.a.q2(i);
    }

    @Override // dc.bt1
    public void y(int i) {
        this.a.o2(i);
    }

    @Override // dc.bt1
    public boolean y0() {
        return this.a.H1();
    }

    @Override // dc.bt1
    public int y1() {
        return this.a.w1();
    }

    @Override // dc.bt1
    public int y2() {
        return this.a.k0();
    }

    @Override // dc.bt1
    public void z(@NotNull Context context, @NotNull TextOverlayImageView imgView) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(imgView, "imgView");
        this.a.o3(context, imgView);
    }

    @Override // dc.bt1
    public void z0(long j) {
        this.a.V2(Long.valueOf(j));
    }

    @Override // dc.bt1
    public void z1(int i) {
        this.a.K2(i);
    }

    @Override // dc.bt1
    @Nullable
    public String z2(@Nullable String str) {
        return this.a.T(str);
    }
}
