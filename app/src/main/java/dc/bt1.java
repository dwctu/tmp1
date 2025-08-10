package dc;

import android.content.Context;
import android.widget.ImageView;
import com.component.dxbluetooth.lib.bean.BleResultBean;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.wear.bean.DfuBean;
import com.wear.bean.ToyConfigInfoBean;
import com.wear.util.TextOverlayImageView;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smackx.address.packet.MultipleAddresses;

/* compiled from: IToy.kt */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b%\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\bZ\n\u0002\u0018\u0002\n\u0002\bp\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H&J\b\u0010\b\u001a\u00020\u0006H&J\b\u0010\t\u001a\u00020\u0006H&J\n\u0010\n\u001a\u0004\u0018\u00010\u000bH&J\n\u0010\f\u001a\u0004\u0018\u00010\u000bH&J\n\u0010\r\u001a\u0004\u0018\u00010\u000bH&J\n\u0010\u000e\u001a\u0004\u0018\u00010\u000bH&J\n\u0010\u000f\u001a\u0004\u0018\u00010\u000bH&J\u0010\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011H&J\b\u0010\u0013\u001a\u00020\u0012H&J\b\u0010\u0014\u001a\u00020\u0015H&J\b\u0010\u0016\u001a\u00020\u0012H&J \u0010\u0017\u001a\u001a\u0012\u0014\u0012\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0018\u0018\u00010\u0011H&J\b\u0010\u0019\u001a\u00020\u0012H&J\b\u0010\u001a\u001a\u00020\u0015H&J\b\u0010\u001b\u001a\u00020\u0012H&J\b\u0010\u001c\u001a\u00020\u0012H&J\b\u0010\u001d\u001a\u00020\u0015H&J\n\u0010\u001e\u001a\u0004\u0018\u00010\u000bH&J\n\u0010\u001f\u001a\u0004\u0018\u00010\u000bH&J\n\u0010 \u001a\u0004\u0018\u00010\u000bH&J\n\u0010!\u001a\u0004\u0018\u00010\u000bH&J\n\u0010\"\u001a\u0004\u0018\u00010\u000bH&J\u0014\u0010#\u001a\u0004\u0018\u00010\u000b2\b\u0010$\u001a\u0004\u0018\u00010\u000bH&J\u0010\u0010%\u001a\u00020\u00122\u0006\u0010&\u001a\u00020\u0006H&J\b\u0010'\u001a\u00020\u0012H&J\n\u0010(\u001a\u0004\u0018\u00010\u000bH&J\b\u0010)\u001a\u00020\u0015H&J\n\u0010*\u001a\u0004\u0018\u00010\u000bH&J\n\u0010+\u001a\u0004\u0018\u00010\u000bH&J\n\u0010,\u001a\u0004\u0018\u00010\u000bH&J\b\u0010-\u001a\u00020\u0015H&J\b\u0010.\u001a\u00020\u0015H&J\n\u0010/\u001a\u0004\u0018\u00010\u000bH&J\b\u00100\u001a\u00020\u0012H&J\b\u00101\u001a\u00020\u0012H&J\b\u00102\u001a\u00020\u0012H&J\b\u00103\u001a\u00020\u0012H&J\b\u00104\u001a\u00020\u0012H&J\b\u00105\u001a\u00020\u0012H&J\b\u00106\u001a\u00020\u0012H&J\b\u00107\u001a\u00020\u0012H&J\b\u00108\u001a\u00020\u0012H&J\n\u00109\u001a\u0004\u0018\u00010\u000bH&J\b\u0010:\u001a\u00020\u000bH&J\u0012\u0010;\u001a\u0004\u0018\u00010\u000b2\u0006\u0010<\u001a\u00020\u0012H&J\u000e\u0010=\u001a\b\u0012\u0004\u0012\u00020>0\u0011H&J\b\u0010?\u001a\u00020\u0012H&J\n\u0010@\u001a\u0004\u0018\u00010AH&J\u0014\u0010B\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00110\u0011H&J\n\u0010C\u001a\u0004\u0018\u00010\u000bH&J\n\u0010D\u001a\u0004\u0018\u00010\u000bH&J\u0014\u0010E\u001a\u0004\u0018\u00010\u000b2\b\u0010F\u001a\u0004\u0018\u00010GH&J\n\u0010H\u001a\u0004\u0018\u00010\u000bH&J\n\u0010I\u001a\u0004\u0018\u00010\u000bH&J\n\u0010J\u001a\u0004\u0018\u00010\u000bH&J\b\u0010K\u001a\u00020\u0015H&J\n\u0010L\u001a\u0004\u0018\u00010AH&J\u001c\u0010M\u001a\u0016\u0012\u0004\u0012\u00020\u000b\u0018\u00010Nj\n\u0012\u0004\u0012\u00020\u000b\u0018\u0001`OH&J\b\u0010P\u001a\u00020\u0012H&J\n\u0010Q\u001a\u0004\u0018\u00010\u000bH&J\b\u0010R\u001a\u00020\u0006H&J\b\u0010S\u001a\u00020\u0015H&J\b\u0010T\u001a\u00020\u0012H&J\b\u0010U\u001a\u00020\u0012H&J\u0012\u0010V\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\u0011H&J\b\u0010W\u001a\u00020\u0012H&J\b\u0010X\u001a\u00020\u000bH&J\n\u0010Y\u001a\u0004\u0018\u00010\u000bH&J\n\u0010Z\u001a\u0004\u0018\u00010\u000bH&J\n\u0010[\u001a\u0004\u0018\u00010\u000bH&J\b\u0010\\\u001a\u00020\u0012H&J\n\u0010]\u001a\u0004\u0018\u00010\u000bH&J\n\u0010^\u001a\u0004\u0018\u00010_H&J\b\u0010`\u001a\u00020\u0012H&J\b\u0010a\u001a\u00020\u0012H&J\u0010\u0010b\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0011H&J\n\u0010c\u001a\u0004\u0018\u00010\u000bH&J\u0012\u0010d\u001a\u0004\u0018\u00010\u000b2\u0006\u0010e\u001a\u00020\u0012H&J\b\u0010f\u001a\u00020\u0012H&J\n\u0010g\u001a\u0004\u0018\u00010\u000bH&J\n\u0010h\u001a\u0004\u0018\u00010\u000bH&J\n\u0010i\u001a\u0004\u0018\u00010jH&J\b\u0010k\u001a\u00020\u0015H&J\n\u0010l\u001a\u0004\u0018\u00010\u000bH&J\b\u0010m\u001a\u00020\u0012H&J\n\u0010n\u001a\u0004\u0018\u00010\u000bH&J\b\u0010o\u001a\u00020\u0012H&J\b\u0010p\u001a\u00020\u0006H&J\b\u0010q\u001a\u00020\u0006H&J\b\u0010r\u001a\u00020\u0006H&J\b\u0010s\u001a\u00020\u0006H&J\b\u0010t\u001a\u00020\u0006H&J\b\u0010u\u001a\u00020\u0006H&J\b\u0010v\u001a\u00020\u0006H&J\b\u0010w\u001a\u00020\u0006H&J\b\u0010x\u001a\u00020\u0006H&J\u0010\u0010x\u001a\u00020\u00062\u0006\u0010y\u001a\u00020\u0012H&J\b\u0010z\u001a\u00020\u0006H&J\b\u0010{\u001a\u00020\u0006H&J\b\u0010|\u001a\u00020\u0006H&J\b\u0010}\u001a\u00020\u0006H&J\b\u0010~\u001a\u00020\u0006H&J\b\u0010\u007f\u001a\u00020\u0006H&J\t\u0010\u0080\u0001\u001a\u00020\u0006H&J\t\u0010\u0081\u0001\u001a\u00020\u0012H&J\t\u0010\u0082\u0001\u001a\u00020\u0006H&J\u0011\u0010\u0082\u0001\u001a\u00020\u00062\u0006\u0010y\u001a\u00020\u0012H&J\t\u0010\u0083\u0001\u001a\u00020\u0006H&J\t\u0010\u0084\u0001\u001a\u00020\u0006H&J\t\u0010\u0085\u0001\u001a\u00020\u0006H&J\t\u0010\u0086\u0001\u001a\u00020\u0006H&J\t\u0010\u0087\u0001\u001a\u00020\u0006H&J\t\u0010\u0088\u0001\u001a\u00020\u0006H&J\t\u0010\u0089\u0001\u001a\u00020\u0006H&J\t\u0010\u008a\u0001\u001a\u00020\u0006H&J\t\u0010\u008b\u0001\u001a\u00020\u0006H&J\t\u0010\u008c\u0001\u001a\u00020\u0006H&J\t\u0010\u008d\u0001\u001a\u00020\u0006H&J\t\u0010\u008e\u0001\u001a\u00020\u0006H&J\t\u0010\u008f\u0001\u001a\u00020\u0006H&J\t\u0010\u0090\u0001\u001a\u00020\u0006H&J\t\u0010\u0091\u0001\u001a\u00020\u0006H&J\t\u0010\u0092\u0001\u001a\u00020\u0006H&J\t\u0010\u0093\u0001\u001a\u00020\u0006H&J\t\u0010\u0094\u0001\u001a\u00020\u0006H&J\t\u0010\u0095\u0001\u001a\u00020\u0006H&J\t\u0010\u0096\u0001\u001a\u00020\u0006H&J\t\u0010\u0097\u0001\u001a\u00020\u0006H&J\t\u0010\u0098\u0001\u001a\u00020\u0006H&J\u0012\u0010\u0099\u0001\u001a\u00020\u00062\u0007\u0010\u009a\u0001\u001a\u00020\u0006H&J\t\u0010\u009b\u0001\u001a\u00020\u0006H&J\t\u0010\u009c\u0001\u001a\u00020\u0006H&J\t\u0010\u009d\u0001\u001a\u00020\u0006H&J\t\u0010\u009e\u0001\u001a\u00020\u0006H&J\t\u0010\u009f\u0001\u001a\u00020\u0006H&J\t\u0010 \u0001\u001a\u00020\u0006H&J\t\u0010¡\u0001\u001a\u00020\u0006H&J\t\u0010¢\u0001\u001a\u00020\u0006H&J\t\u0010£\u0001\u001a\u00020\u0006H&J\t\u0010¤\u0001\u001a\u00020\u0006H&J\t\u0010¥\u0001\u001a\u00020\u0006H&J\t\u0010¦\u0001\u001a\u00020\u0006H&J\t\u0010§\u0001\u001a\u00020\u0006H&J\t\u0010¨\u0001\u001a\u00020\u0006H&J\u0012\u0010©\u0001\u001a\u00020\u00032\u0007\u0010ª\u0001\u001a\u00020\u0012H&J\u0014\u0010«\u0001\u001a\u00020\u00032\t\u0010¬\u0001\u001a\u0004\u0018\u00010\u000bH&J\u0012\u0010\u00ad\u0001\u001a\u00020\u00032\u0007\u0010®\u0001\u001a\u00020\u0012H&J\t\u0010¯\u0001\u001a\u00020\u0003H&J\u0014\u0010°\u0001\u001a\u00020\u00032\t\u0010±\u0001\u001a\u0004\u0018\u00010\u000bH&J\u0014\u0010²\u0001\u001a\u00020\u00032\t\u0010³\u0001\u001a\u0004\u0018\u00010\u000bH&J\u001d\u0010´\u0001\u001a\u00020\u00032\t\u0010µ\u0001\u001a\u0004\u0018\u00010\u000b2\u0007\u0010¶\u0001\u001a\u00020\u0006H&J\u0014\u0010·\u0001\u001a\u00020\u00032\t\u0010¸\u0001\u001a\u0004\u0018\u00010\u000bH&J\u0012\u0010¹\u0001\u001a\u00020\u00032\u0007\u0010º\u0001\u001a\u00020\u0012H&J\u0012\u0010»\u0001\u001a\u00020\u00032\u0007\u0010¼\u0001\u001a\u00020\u0015H&J\u0012\u0010½\u0001\u001a\u00020\u00032\u0007\u0010¾\u0001\u001a\u00020\u0012H&J\u0012\u0010¿\u0001\u001a\u00020\u00032\u0007\u0010À\u0001\u001a\u00020\u0006H&J\u0012\u0010Á\u0001\u001a\u00020\u00032\u0007\u0010Â\u0001\u001a\u00020\u0012H&J\u0013\u0010Ã\u0001\u001a\u00020\u00032\b\u0010Ä\u0001\u001a\u00030Å\u0001H&J\u0012\u0010Æ\u0001\u001a\u00020\u00032\u0007\u0010Ç\u0001\u001a\u00020\u0015H&J\u0012\u0010È\u0001\u001a\u00020\u00032\u0007\u0010É\u0001\u001a\u00020\u0012H&J\u0012\u0010Ê\u0001\u001a\u00020\u00032\u0007\u0010Ë\u0001\u001a\u00020\u0012H&J\u0012\u0010Ì\u0001\u001a\u00020\u00032\u0007\u0010Í\u0001\u001a\u00020\u0015H&J\u0014\u0010Î\u0001\u001a\u00020\u00032\t\u0010Ï\u0001\u001a\u0004\u0018\u00010\u000bH&J\u0014\u0010Ð\u0001\u001a\u00020\u00032\t\u0010Ñ\u0001\u001a\u0004\u0018\u00010\u000bH&J\u0014\u0010Ò\u0001\u001a\u00020\u00032\t\u0010Ó\u0001\u001a\u0004\u0018\u00010\u000bH&J\u0013\u0010Ô\u0001\u001a\u00020\u00032\b\u0010$\u001a\u0004\u0018\u00010\u000bH&J\u0012\u0010Õ\u0001\u001a\u00020\u00032\u0007\u0010Ö\u0001\u001a\u00020\u0006H&J\u0012\u0010×\u0001\u001a\u00020\u00032\u0007\u0010Ø\u0001\u001a\u00020\u0012H&J\u0014\u0010Ù\u0001\u001a\u00020\u00032\t\u0010Ú\u0001\u001a\u0004\u0018\u00010\u000bH&J\u0012\u0010Û\u0001\u001a\u00020\u00032\u0007\u0010Ü\u0001\u001a\u00020\u0006H&J\u0012\u0010Ý\u0001\u001a\u00020\u00032\u0007\u0010Þ\u0001\u001a\u00020\u0006H&J\u0012\u0010ß\u0001\u001a\u00020\u00032\u0007\u0010à\u0001\u001a\u00020\u0006H&J\u0012\u0010á\u0001\u001a\u00020\u00032\u0007\u0010â\u0001\u001a\u00020\u0006H&J\u0012\u0010ã\u0001\u001a\u00020\u00032\u0007\u0010ä\u0001\u001a\u00020\u0015H&J\u0014\u0010å\u0001\u001a\u00020\u00032\t\u0010æ\u0001\u001a\u0004\u0018\u00010\u000bH&J\u0012\u0010ç\u0001\u001a\u00020\u00032\u0007\u0010è\u0001\u001a\u00020\u0015H&J\u0012\u0010é\u0001\u001a\u00020\u00032\u0007\u0010ê\u0001\u001a\u00020\u0015H&J\u0014\u0010ë\u0001\u001a\u00020\u00032\t\u0010ì\u0001\u001a\u0004\u0018\u00010\u000bH&J\u0012\u0010í\u0001\u001a\u00020\u00032\u0007\u0010î\u0001\u001a\u00020\u0012H&J\u0012\u0010ï\u0001\u001a\u00020\u00032\u0007\u0010ð\u0001\u001a\u00020\u0012H&J\u0012\u0010ñ\u0001\u001a\u00020\u00032\u0007\u0010ò\u0001\u001a\u00020\u0012H&J\u0012\u0010ó\u0001\u001a\u00020\u00032\u0007\u0010ô\u0001\u001a\u00020\u0012H&J\u0012\u0010õ\u0001\u001a\u00020\u00032\u0007\u0010\u0090\u0001\u001a\u00020\u0012H&J\u0012\u0010ö\u0001\u001a\u00020\u00032\u0007\u0010÷\u0001\u001a\u00020\u0012H&J\u0012\u0010ø\u0001\u001a\u00020\u00032\u0007\u0010\u0086\u0001\u001a\u00020\u0006H&J\u0012\u0010ù\u0001\u001a\u00020\u00032\u0007\u0010ú\u0001\u001a\u00020\u0012H&J\u0012\u0010û\u0001\u001a\u00020\u00032\u0007\u0010ü\u0001\u001a\u00020\u0012H&J\u0014\u0010ý\u0001\u001a\u00020\u00032\t\u0010þ\u0001\u001a\u0004\u0018\u00010\u000bH&J\u0014\u0010ÿ\u0001\u001a\u00020\u00032\t\u0010\u0080\u0002\u001a\u0004\u0018\u00010\u000bH&J\u0012\u0010\u0081\u0002\u001a\u00020\u00032\u0007\u0010\u0082\u0002\u001a\u00020\u0012H&J\u0012\u0010\u0083\u0002\u001a\u00020\u00032\u0007\u0010\u0084\u0002\u001a\u00020AH&J\u0014\u0010\u0085\u0002\u001a\u00020\u00032\t\u0010\u0086\u0002\u001a\u0004\u0018\u00010\u000bH&J\u0014\u0010\u0087\u0002\u001a\u00020\u00032\t\u0010\u0088\u0002\u001a\u0004\u0018\u00010\u000bH&J\u0012\u0010\u0089\u0002\u001a\u00020\u00032\u0007\u0010\u008a\u0002\u001a\u00020\u0015H&J\u0012\u0010\u008b\u0002\u001a\u00020\u00032\u0007\u0010\u008c\u0002\u001a\u00020\u0006H&J\u0014\u0010\u008d\u0002\u001a\u00020\u00032\t\u0010\u008e\u0002\u001a\u0004\u0018\u00010\u000bH&J\t\u0010\u008f\u0002\u001a\u00020\u0003H&J\u0012\u0010\u0090\u0002\u001a\u00020\u00032\u0007\u0010\u0091\u0002\u001a\u00020\u0015H&J\u0012\u0010\u0092\u0002\u001a\u00020\u00032\u0007\u0010®\u0001\u001a\u00020\u0012H&J\u0012\u0010\u0093\u0002\u001a\u00020\u00032\u0007\u0010\u0094\u0002\u001a\u00020\u0012H&J\u0012\u0010\u0095\u0002\u001a\u00020\u00032\u0007\u0010\u0096\u0002\u001a\u00020\u0012H&J\u0012\u0010\u0097\u0002\u001a\u00020\u00032\u0007\u0010\u0098\u0002\u001a\u00020\u0006H&J\t\u0010\u0099\u0002\u001a\u00020\u0003H&J\u0014\u0010\u0099\u0002\u001a\u00020\u00032\t\u0010\u009a\u0002\u001a\u0004\u0018\u00010_H&J\u0012\u0010\u009b\u0002\u001a\u00020\u00032\u0007\u0010\u009c\u0002\u001a\u00020\u0006H&J\u0012\u0010\u009d\u0002\u001a\u00020\u00032\u0007\u0010\u009e\u0002\u001a\u00020\u0006H&J\u0013\u0010\u009f\u0002\u001a\u00020\u00032\b\u0010e\u001a\u0004\u0018\u00010\u000bH&J\u0014\u0010 \u0002\u001a\u00020\u00032\t\u0010¡\u0002\u001a\u0004\u0018\u00010\u000bH&J\u0014\u0010¢\u0002\u001a\u00020\u00032\t\u0010£\u0002\u001a\u0004\u0018\u00010jH&J\u0012\u0010¤\u0002\u001a\u00020\u00032\u0007\u0010¥\u0002\u001a\u00020\u0015H&J\u0014\u0010¦\u0002\u001a\u00020\u00032\t\u0010§\u0002\u001a\u0004\u0018\u00010\u000bH&J\u0011\u0010¨\u0002\u001a\u00020\u00032\u0006\u0010y\u001a\u00020\u0012H&J\u0014\u0010©\u0002\u001a\u00020\u00032\t\u0010ª\u0002\u001a\u0004\u0018\u00010\u000bH&J\u0012\u0010«\u0002\u001a\u00020\u00032\u0007\u0010¬\u0002\u001a\u00020\u0012H&J\t\u0010\u00ad\u0002\u001a\u00020\u0006H&J\u0014\u0010®\u0002\u001a\u00020\u00062\t\u0010¯\u0002\u001a\u0004\u0018\u00010\u000bH&J\t\u0010°\u0002\u001a\u00020\u0003H&J\t\u0010±\u0002\u001a\u00020\u0006H&J\t\u0010²\u0002\u001a\u00020\u0006H&J\t\u0010³\u0002\u001a\u00020\u0012H&J\u001d\u0010´\u0002\u001a\u00020\u00032\b\u0010µ\u0002\u001a\u00030¶\u00022\b\u0010·\u0002\u001a\u00030¸\u0002H&J\u0013\u0010¹\u0002\u001a\u00020\u00032\b\u0010·\u0002\u001a\u00030º\u0002H&¨\u0006»\u0002"}, d2 = {"Lcom/wear/component/dxtoy/toy/interfaces/IToy;", "", "addConnectTryNumb", "", "addLanApiUpdateCount", "canAddConnectingLog", "", "isAutoPlus", "canGetBattery", "canSetLed", "getAddress", "", "getAgString", "getAiString", "getAndUpdateDeviceId", "getBatchId", "getBattayList", "", "", "getBattery", "getBatteryRequestTime", "", "getBindType", "getCommandList", "", "getConnectApp", "getConnectScanTime", "getConnectTryNumb", "getConnectType", "getConnectedTime", "getDataBaseType", "getDefineRename", "getDeviceId", "getDeviceName", "getDeviceType", "getDeviceTypeMac", "deviceType", "getDfuIcon", "isFail", "getDisConnectType", "getEmail", "getFeedbackDownTime", "getFormApp", "getFullName", "getGenerationVersion", "getGetCheckBindToyErrorTime", "getGetDfuErrorTime", "getId", "getIsCheckBindToy", "getIsDfuEnd", "getIsLongRange", "getIsPowerOff", "getIsSelect", "getLanApiUpdateCount", "getLdrIcon", "getLed", "getLedSetting", "getLogFormApp", "getLogToyType", "getLogToyTypeAndRssi", "stateCode", "getLvsMotorsFuncList", "Lcom/component/dxtoy/core/toy/constant/ToyCoreEum$MotorFunction;", "getMissionSolo", "getMissionTchLvl", "", "getMotors", "getMultiplayOrder", "getName", "getNewLogToyTypeAndRssi", "resultBean", "Lcom/component/dxbluetooth/lib/bean/BleResultBean;", "getOldEmail", "getOldId", "getPinStatus", "getPowerOffTime", "getProgramDefaultLevel", "getProgramDefaultProgram", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getProgramSpeed", "getRealType", "getReconnectOvertime", "getRquestConnectTime", "getRssi", "getRssiImg", "getRssiList", "getSearchToyIcon", "getShowName", "getSimpleFullName", "getSimpleName", "getSimpleType", "getStatus", "getSymbol", "getToyConfigDataBean", "Lcom/wear/bean/ToyConfigInfoBean;", "getToyIcon", "getToyRssiLevel", "getToySymbol", "getToyTypeKey", "getToyUINameSpecialForMiniXMachine", "type", "getToyVersion", "getType", "getUpCaseName", "getUpdateDfu", "Lcom/wear/bean/DfuBean;", "getUpdateTime", "getUuid", "getVersion", "getWorkMode", "getaColor", "hasProgramToy", "isAlarmEnable", "isBAToy", "isCanWearToy", "isCmdCompensation", "isConnected", "isDirection", "isEAToy", "isEI01Toy", "version", "isEL01Toy", "isEncrypt", "isF01IsNotice", "isF01IsReady", "isF01Off", "isF01Toy", "isFeedbackModeEnable", "isFeedbackModeEnableAndUpdateEnable", "isGeminiToy", "isGravity", "isH01Toy", "isJ01Toy", "isLanApiUpdateRequest", "isMax", "isMaxToy", "isMiniXMachine", "isMultiplyInstruct", "isNora", "isNoraToy", "isQ01Toy", "isQA01Toy", "isRealDeviceType", "isSelect", "isSelected", "isSetGradualSpeedUpEnable", "isSetThresholdEnable", "isSupportAir", "isSupportBt", "isSupportControlPanel", "isSupportDepthMode", "isSupportGame", "isSupportLEDColor", "isMotherboardLED", "isSupportLVS", "isSupportLdr", "isSupportR", "isSupportV1V2", "isSupportV1V2F", "isSuppportPinCode", "isSynControlAnimation", "isT01Toy", "isThridPartToy", "isToyListAdd", "isTransfer", "isV01Toy", "isVirtualToy", "isXMachine", "pushBattay", "battay", "pushCommand", "command", "pushRssi", "rssi", "reduceConnectTryNumb", "setAddress", MultipleAddresses.Address.ELEMENT, "setAgString", "agString", "setAiString", "aiString", "isShowDialog", "setBatchId", "batchId", "setBattery", "battery", "setBatteryRequestTime", "batteryRequestTime", "setBindType", "bindType", "setCanRssi", "canRssi", "setConnectApp", "connectApp", "setConnectPriority", "connectPriority", "Lcom/component/dxtoy/core/toy/constant/ToyCoreEum$ConnectPriority;", "setConnectScanTime", "connectScanTime", "setConnectTryNumb", "connectTryNumb", "setConnectType", "connectType", "setConnectedTime", "connectedTime", "setDefineRename", "defineRename", "setDeviceId", "deviceId", "setDeviceName", "deviceName", "setDeviceType", "setDirection", "direction", "setDisConnectType", "disConnectType", "setEmail", "email", "setEncrypt", "encrypt", "setF01IsNotice", "f01IsNotice", "setF01IsOff", "f01IsOff", "setF01IsReady", "f01IsReady", "setFeedbackDownTime", "time", "setFormApp", "formApp", "setGetCheckBindToyErrorTime", "getCheckBindToyErrorTime", "setGetDfuErrorTime", "getDfuErrorTime", "setId", TtmlNode.ATTR_ID, "setIsCheckBindToy", "isCheckBindToy", "setIsDfuEnd", "isDfuEnd", "setIsLongRange", "isLongRange", "setIsPowerOff", "isPowerOff", "setIsSelect", "setLanApiUpdateCount", "lanApiUpdateCount", "setLanApiUpdateRequest", "setLed", "led", "setLedSetting", "ledSetting", "setLogFormApp", "logFormApp", "setLvsMotorConfig", "lvsMotorConfig", "setMissionSolo", "missionSolo", "setMissionTchLvl", "missionTchLvl", "setName", "name", "setPinStatus", "pinStatus", "setPowerOffTime", "powerOffTime", "setRealDeviceType", "realDeviceType", "setRealType", "realType", "setRenameDeviceName", "setRquestConnectTime", "requestConnectTime", "setRssi", "setSimpleToy", "simpleToy", "setStatus", "status", "setSynControlAnimation", "synControlAnimation", "setToyConfigDataBean", "toyConfigDataBean", "setToyListAdd", "toyListAdd", "setTransfer", "transfer", "setType", "setUpCaseName", "upCaseName", "setUpdateDfu", "updateDfu", "setUpdateTime", "updateTime", "setUuid", "uuid", "setVersion", "setWorkMode", "workMode", "setaColor", "aColor", "supportChangeName", "supportCommand", "message", "synNameToType", "toyIsSupport", "toyIsSupportLanApi", "typeInt", "updateMyToyBattery", "context", "Landroid/content/Context;", "imgView", "Lcom/wear/util/TextOverlayImageView;", "updateToyBattery", "Landroid/widget/ImageView;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public interface bt1 {
    boolean A();

    boolean A0();

    @Nullable
    int[] A1();

    @Nullable
    DfuBean A2();

    void B(boolean z);

    @Nullable
    String B0();

    void B1(long j);

    void B2(@Nullable String str);

    @Nullable
    String C();

    void C0(boolean z);

    boolean C1();

    void C2(int i);

    boolean D();

    void D0(int i);

    @Nullable
    String D1();

    boolean D2();

    boolean E();

    void E0(long j);

    int E1();

    void E2(@Nullable String str);

    void F(int i);

    @Nullable
    ToyConfigInfoBean F0();

    void F1(@Nullable String str);

    void F2();

    @Nullable
    String G();

    boolean G0();

    void G1(@Nullable String str);

    void G2(boolean z);

    void H(@Nullable ToyConfigInfoBean toyConfigInfoBean);

    @Nullable
    String H0();

    @Nullable
    String H1();

    @Nullable
    List<String> H2();

    boolean I();

    @Nullable
    String I0(int i);

    boolean I1();

    void I2(int i);

    @Nullable
    List<String> J();

    boolean J0();

    long J1();

    @Nullable
    String J2();

    @Nullable
    String K();

    void K0(@Nullable String str);

    int K1();

    boolean K2();

    @Nullable
    String L();

    @Nullable
    String L0();

    boolean L1();

    long L2();

    boolean M();

    int M0();

    void M1(boolean z);

    boolean M2();

    void N(@Nullable String str);

    void N0(int i);

    void N1(@Nullable String str);

    void N2(@Nullable String str);

    boolean O();

    @Nullable
    String O0();

    boolean O1();

    void O2(@Nullable String str);

    @Nullable
    String P();

    @NotNull
    String P0();

    @Nullable
    String P1();

    int P2();

    long Q();

    boolean Q0();

    int Q1();

    void Q2(int i);

    void R(int i);

    long R0();

    void R1(@Nullable String str);

    boolean R2();

    boolean S(boolean z);

    @Nullable
    String S0();

    @Nullable
    String S1();

    int S2();

    void T(int i);

    @NotNull
    List<qb0> T0();

    boolean T1();

    boolean U();

    @Nullable
    String U0();

    long U1();

    void V(@Nullable String str);

    boolean V0(boolean z);

    boolean V1();

    int W();

    int W0();

    void W1(@Nullable String str);

    long X();

    void X0();

    long X1();

    @Nullable
    ArrayList<String> Y();

    @Nullable
    String Y0();

    void Y1(int i);

    boolean Z();

    void Z0(int i);

    boolean Z1(int i);

    boolean a();

    int a0();

    @Nullable
    String a1();

    void a2(boolean z);

    boolean b();

    int b0();

    void b1(long j);

    void b2(int i);

    void c(@Nullable DfuBean dfuBean);

    void c0(int i);

    void c1(@Nullable String str, boolean z);

    @Nullable
    int[] c2();

    boolean canSetLed();

    void d(int i);

    void d0();

    void d1(long j);

    boolean d2();

    void e(@Nullable String str);

    void e0();

    boolean e1();

    void e2(long j);

    void f(@Nullable String str);

    long f0();

    int f1(boolean z);

    boolean f2();

    void g(long j);

    @Nullable
    String g0();

    void g1(int i);

    boolean g2();

    @Nullable
    String getEmail();

    @Nullable
    String getId();

    int getLdrIcon();

    @Nullable
    String getName();

    @NotNull
    String getShowName();

    @Nullable
    String getSimpleName();

    int getStatus();

    @Nullable
    String getType();

    int getVersion();

    @Nullable
    String h();

    int h0();

    void h1(int i);

    boolean h2();

    boolean i();

    boolean i0();

    int i1();

    void i2(@Nullable String str);

    boolean isConnected();

    boolean isMax();

    boolean isSupportBt();

    boolean isSupportControlPanel();

    boolean isSupportDepthMode();

    boolean isSupportGame();

    boolean isSupportLdr();

    boolean isThridPartToy();

    boolean isVirtualToy();

    void j(@NotNull ImageView imageView);

    boolean j0();

    boolean j1();

    void j2(@Nullable String str);

    void k(long j);

    void k0(boolean z);

    void k1(@Nullable String str);

    int k2();

    boolean l();

    void l0(boolean z);

    void l1(@NotNull int[] iArr);

    int l2();

    long m();

    void m0(boolean z);

    boolean m1();

    @Nullable
    String m2();

    boolean n();

    boolean n0();

    @Nullable
    List<Integer> n1();

    int n2();

    @Nullable
    List<Map<String, Long>> o();

    void o0();

    void o1(@Nullable String str);

    int o2();

    void p(int i);

    boolean p0();

    void p1();

    int p2();

    @Nullable
    String q();

    int q0();

    @Nullable
    String q1(@Nullable BleResultBean bleResultBean);

    @Nullable
    String q2(int i);

    void r(@Nullable String str);

    boolean r0();

    int r1();

    boolean r2(int i);

    void s(boolean z);

    boolean s0();

    @Nullable
    String s1();

    void s2(int i);

    void setVersion(int version);

    boolean supportCommand(@Nullable String message);

    void t(boolean z);

    void t0(boolean z);

    boolean t1();

    boolean t2();

    void u(long j);

    @Nullable
    String u0();

    void u1(int i);

    void u2(@NotNull ob0 ob0Var);

    void v(@Nullable String str);

    boolean v0();

    boolean v1();

    int v2();

    int w();

    boolean w0();

    @Nullable
    String w1();

    int w2();

    int x();

    boolean x0();

    @NotNull
    List<List<String>> x1();

    void x2(int i);

    void y(int i);

    boolean y0();

    int y1();

    int y2();

    void z(@NotNull Context context, @NotNull TextOverlayImageView textOverlayImageView);

    void z0(long j);

    void z1(int i);

    @Nullable
    String z2(@Nullable String str);
}
