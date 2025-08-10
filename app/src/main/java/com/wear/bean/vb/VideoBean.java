package com.wear.bean.vb;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.firebase.analytics.FirebaseAnalytics;
import dc.g;
import dc.tq;
import io.agora.rtc2.internal.AudioRoutingController;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.i18n.MessageBundle;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: VideoResponse.kt */
@Metadata(d1 = {"\u0000G\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0006\n\u0003\bï\u0001\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001Bé\u0005\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\r\u0012\u0006\u0010\"\u001a\u00020\u0003\u0012\u001c\b\u0002\u0010#\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010$j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`%\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010-\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u00107\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u00108\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u00109\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010;\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010<\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010?\u001a\u00020\u0003\u0012\n\b\u0002\u0010@\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010A\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010B\u001a\u00020\r\u0012\n\b\u0002\u0010C\u001a\u0004\u0018\u00010\r\u0012\u0006\u0010D\u001a\u00020\u0003\u0012\u0006\u0010E\u001a\u00020\n\u0012\u0006\u0010F\u001a\u00020\u0015¢\u0006\u0002\u0010GJ\f\u0010Û\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010Ü\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010Ý\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010Þ\u0001\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010bJ\f\u0010ß\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010à\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010á\u0001\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010bJ\u0011\u0010â\u0001\u001a\u0004\u0018\u00010\u0015HÆ\u0003¢\u0006\u0002\u0010sJ\u0011\u0010ã\u0001\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010bJ\u0011\u0010ä\u0001\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010[J\u0011\u0010å\u0001\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010[J\f\u0010æ\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010ç\u0001\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010[J\u0011\u0010è\u0001\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010[J\u0011\u0010é\u0001\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010bJ\f\u0010ê\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010ë\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010ì\u0001\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010bJ\f\u0010í\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010î\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010ï\u0001\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010bJ\n\u0010ð\u0001\u001a\u00020\u0003HÆ\u0003J\f\u0010ñ\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001e\u0010ò\u0001\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010$j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`%HÆ\u0003J\f\u0010ó\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010ô\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010õ\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010ö\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010÷\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010ø\u0001\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010bJ\u0012\u0010ù\u0001\u001a\u0004\u0018\u00010-HÆ\u0003¢\u0006\u0003\u0010©\u0001J\u0011\u0010ú\u0001\u001a\u0004\u0018\u00010\u0015HÆ\u0003¢\u0006\u0002\u0010sJ\f\u0010û\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010ü\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010ý\u0001\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010bJ\f\u0010þ\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010ÿ\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010\u0080\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010\u0081\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010\u0082\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010\u0083\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010\u0084\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0085\u0002\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010bJ\u0011\u0010\u0086\u0002\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010bJ\f\u0010\u0087\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0088\u0002\u001a\u0004\u0018\u00010\u0015HÆ\u0003¢\u0006\u0002\u0010sJ\f\u0010\u0089\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u008a\u0002\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010bJ\f\u0010\u008b\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010\u008c\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\n\u0010\u008d\u0002\u001a\u00020\u0003HÆ\u0003J\f\u0010\u008e\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010\u008f\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\n\u0010\u0090\u0002\u001a\u00020\rHÆ\u0003J\u0011\u0010\u0091\u0002\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010bJ\f\u0010\u0092\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\n\u0010\u0093\u0002\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0094\u0002\u001a\u00020\nHÆ\u0003J\n\u0010\u0095\u0002\u001a\u00020\u0015HÆ\u0003J\u0011\u0010\u0096\u0002\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010[J\u0011\u0010\u0097\u0002\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010[J\u0011\u0010\u0098\u0002\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010bJþ\u0005\u0010\u0099\u0002\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\"\u001a\u00020\u00032\u001c\b\u0002\u0010#\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010$j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`%2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010,\u001a\u0004\u0018\u00010-2\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u00100\u001a\u0004\u0018\u00010\r2\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u00107\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u00108\u001a\u0004\u0018\u00010\r2\n\b\u0002\u00109\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010;\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010<\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010?\u001a\u00020\u00032\n\b\u0002\u0010@\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010A\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010B\u001a\u00020\r2\n\b\u0002\u0010C\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010D\u001a\u00020\u00032\b\b\u0002\u0010E\u001a\u00020\n2\b\b\u0002\u0010F\u001a\u00020\u0015HÆ\u0001¢\u0006\u0003\u0010\u009a\u0002J\u0016\u0010\u009b\u0002\u001a\u00020\n2\n\u0010\u009c\u0002\u001a\u0005\u0018\u00010\u009d\u0002HÖ\u0003J\n\u0010\u009e\u0002\u001a\u00020\rHÖ\u0001J\n\u0010\u009f\u0002\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010I\"\u0004\bM\u0010KR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010I\"\u0004\bO\u0010KR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010I\"\u0004\bQ\u0010KR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bR\u0010I\"\u0004\bS\u0010KR\u001c\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bT\u0010I\"\u0004\bU\u0010KR\u001a\u0010B\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u0010W\"\u0004\bX\u0010YR\u001e\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u0010\n\u0002\u0010^\u001a\u0004\bZ\u0010[\"\u0004\b\\\u0010]R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u0010\n\u0002\u0010^\u001a\u0004\b_\u0010[\"\u0004\b`\u0010]R\u001e\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u0010\n\u0002\u0010e\u001a\u0004\ba\u0010b\"\u0004\bc\u0010dR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bf\u0010I\"\u0004\bg\u0010KR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bh\u0010I\"\u0004\bi\u0010KR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u0010\n\u0002\u0010e\u001a\u0004\bj\u0010b\"\u0004\bk\u0010dR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bl\u0010I\"\u0004\bm\u0010KR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bn\u0010I\"\u0004\bo\u0010KR\u001e\u0010\u0013\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u0010\n\u0002\u0010e\u001a\u0004\bp\u0010b\"\u0004\bq\u0010dR\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0086\u000e¢\u0006\u0010\n\u0002\u0010v\u001a\u0004\br\u0010s\"\u0004\bt\u0010uR\u001e\u0010\u0016\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u0010\n\u0002\u0010e\u001a\u0004\b\u0016\u0010b\"\u0004\bw\u0010dR\"\u0010\u0017\u001a\u0004\u0018\u00010\n8\u0007@\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010^\u001a\u0004\bx\u0010[\"\u0004\by\u0010]R\"\u0010\u0018\u001a\u0004\u0018\u00010\n8\u0007@\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010^\u001a\u0004\bz\u0010[\"\u0004\b{\u0010]R\"\u0010\u0019\u001a\u0004\u0018\u00010\n8\u0007@\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010^\u001a\u0004\b|\u0010[\"\u0004\b}\u0010]R\u0014\u0010~\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u007f\u0010WR \u0010\u001a\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u0012\n\u0002\u0010^\u001a\u0005\b\u0080\u0001\u0010[\"\u0005\b\u0081\u0001\u0010]R \u0010\u001b\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u0012\n\u0002\u0010e\u001a\u0005\b\u0082\u0001\u0010b\"\u0005\b\u0083\u0001\u0010dR\u001e\u0010\u001c\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0084\u0001\u0010I\"\u0005\b\u0085\u0001\u0010KR\u001e\u0010F\u001a\u00020\u0015X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0086\u0001\u0010\u0087\u0001\"\u0006\b\u0088\u0001\u0010\u0089\u0001R \u0010C\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u0012\n\u0002\u0010e\u001a\u0005\b\u008a\u0001\u0010b\"\u0005\b\u008b\u0001\u0010dR\u001e\u0010\u001d\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u008c\u0001\u0010I\"\u0005\b\u008d\u0001\u0010KR \u0010\u001e\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u0012\n\u0002\u0010e\u001a\u0005\b\u008e\u0001\u0010b\"\u0005\b\u008f\u0001\u0010dR\u001e\u0010\u001f\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0090\u0001\u0010I\"\u0005\b\u0091\u0001\u0010KR\u001e\u0010 \u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0092\u0001\u0010I\"\u0005\b\u0093\u0001\u0010KR \u0010!\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u0012\n\u0002\u0010e\u001a\u0005\b\u0094\u0001\u0010b\"\u0005\b\u0095\u0001\u0010dR\u001c\u0010\"\u001a\u00020\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0096\u0001\u0010I\"\u0005\b\u0097\u0001\u0010KR2\u0010#\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010$j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`%X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0098\u0001\u0010\u0099\u0001\"\u0006\b\u009a\u0001\u0010\u009b\u0001R\u001e\u0010&\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u009c\u0001\u0010I\"\u0005\b\u009d\u0001\u0010KR\u001e\u0010'\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u009e\u0001\u0010I\"\u0005\b\u009f\u0001\u0010KR\u001e\u0010(\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b \u0001\u0010I\"\u0005\b¡\u0001\u0010KR\u001e\u0010)\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¢\u0001\u0010I\"\u0005\b£\u0001\u0010KR\u001e\u0010*\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¤\u0001\u0010I\"\u0005\b¥\u0001\u0010KR \u0010+\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u0012\n\u0002\u0010e\u001a\u0005\b¦\u0001\u0010b\"\u0005\b§\u0001\u0010dR#\u0010,\u001a\u0004\u0018\u00010-X\u0086\u000e¢\u0006\u0015\n\u0003\u0010¬\u0001\u001a\u0006\b¨\u0001\u0010©\u0001\"\u0006\bª\u0001\u0010«\u0001R \u0010.\u001a\u0004\u0018\u00010\u0015X\u0086\u000e¢\u0006\u0012\n\u0002\u0010v\u001a\u0005\b\u00ad\u0001\u0010s\"\u0005\b®\u0001\u0010uR\u001e\u0010/\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¯\u0001\u0010I\"\u0005\b°\u0001\u0010KR\u001c\u0010D\u001a\u00020\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b±\u0001\u0010I\"\u0005\b²\u0001\u0010KR\u001e\u0010E\u001a\u00020\nX\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b³\u0001\u0010´\u0001\"\u0006\bµ\u0001\u0010¶\u0001R \u00100\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u0012\n\u0002\u0010e\u001a\u0005\b·\u0001\u0010b\"\u0005\b¸\u0001\u0010dR\u001e\u00101\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¹\u0001\u0010I\"\u0005\bº\u0001\u0010KR\u001e\u00102\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b»\u0001\u0010I\"\u0005\b¼\u0001\u0010KR\u001e\u00103\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b½\u0001\u0010I\"\u0005\b¾\u0001\u0010KR\u001e\u00104\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¿\u0001\u0010I\"\u0005\bÀ\u0001\u0010KR\u001e\u00105\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÁ\u0001\u0010I\"\u0005\bÂ\u0001\u0010KR\u001e\u00106\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÃ\u0001\u0010I\"\u0005\bÄ\u0001\u0010KR\u001e\u00107\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÅ\u0001\u0010I\"\u0005\bÆ\u0001\u0010KR \u00108\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u0012\n\u0002\u0010e\u001a\u0005\bÇ\u0001\u0010b\"\u0005\bÈ\u0001\u0010dR \u00109\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u0012\n\u0002\u0010e\u001a\u0005\bÉ\u0001\u0010b\"\u0005\bÊ\u0001\u0010dR \u0010:\u001a\u0004\u0018\u00010\u0015X\u0086\u000e¢\u0006\u0012\n\u0002\u0010v\u001a\u0005\bË\u0001\u0010s\"\u0005\bÌ\u0001\u0010uR\u001e\u0010;\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÍ\u0001\u0010I\"\u0005\bÎ\u0001\u0010KR \u0010<\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u0012\n\u0002\u0010e\u001a\u0005\bÏ\u0001\u0010b\"\u0005\bÐ\u0001\u0010dR\u001e\u0010=\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÑ\u0001\u0010I\"\u0005\bÒ\u0001\u0010KR\u001e\u0010>\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÓ\u0001\u0010I\"\u0005\bÔ\u0001\u0010KR\u001c\u0010?\u001a\u00020\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÕ\u0001\u0010I\"\u0005\bÖ\u0001\u0010KR\u001e\u0010@\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b×\u0001\u0010I\"\u0005\bØ\u0001\u0010KR\u001e\u0010A\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÙ\u0001\u0010I\"\u0005\bÚ\u0001\u0010K¨\u0006 \u0002"}, d2 = {"Lcom/wear/bean/vb/VideoBean;", "Lcom/chad/library/adapter/base/entity/MultiItemEntity;", "abbreviateMp4VideoUrl", "", "abbreviateVideoUrl", "accountId", "categories", "country", "coverPicture", "delete", "", "disLike", "dislikeCount", "", "domain", "downloadUrl", TypedValues.TransitionType.S_DURATION, "durationFormat", "email", "hasPattern", TtmlNode.ATTR_ID, "", "isAnonymous", "isDelete", "isDisLike", "isLike", "like", "likeCount", "likeCountShow", "manifestUrl", "mediaLength", "mediaLengthFormat", "mediaOrigin", "patternPer", "patternUrl", "patternUrls", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "pf", "pfChannelUnite", "pfLogo", "realWebUrl", "remark", "resourceType", FirebaseAnalytics.Param.SCORE, "", "sort", "statVersion", "status", "tag", MessageBundle.TITLE_ENTRY, "uploadDate", "uploader", "userName", "uuid", "uuidWebUrlMd5", "version", "videoDuration", "videoId", "videoTitle", "viewCount", "viewCountShow", "viewKey", "webUrl", "webUrlMd5", "website", "day", "localNewFlag", "staticVideoLikeNumber", "staticVideoUserIsLike", "likeTimestamp", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/util/ArrayList;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/Integer;Ljava/lang/String;ZJ)V", "getAbbreviateMp4VideoUrl", "()Ljava/lang/String;", "setAbbreviateMp4VideoUrl", "(Ljava/lang/String;)V", "getAbbreviateVideoUrl", "setAbbreviateVideoUrl", "getAccountId", "setAccountId", "getCategories", "setCategories", "getCountry", "setCountry", "getCoverPicture", "setCoverPicture", "getDay", "()I", "setDay", "(I)V", "getDelete", "()Ljava/lang/Boolean;", "setDelete", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getDisLike", "setDisLike", "getDislikeCount", "()Ljava/lang/Integer;", "setDislikeCount", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getDomain", "setDomain", "getDownloadUrl", "setDownloadUrl", "getDuration", "setDuration", "getDurationFormat", "setDurationFormat", "getEmail", "setEmail", "getHasPattern", "setHasPattern", "getId", "()Ljava/lang/Long;", "setId", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "setAnonymous", "getIsDelete", "setIsDelete", "getIsDisLike", "setIsDisLike", "getIsLike", "setIsLike", "itemType", "getItemType", "getLike", "setLike", "getLikeCount", "setLikeCount", "getLikeCountShow", "setLikeCountShow", "getLikeTimestamp", "()J", "setLikeTimestamp", "(J)V", "getLocalNewFlag", "setLocalNewFlag", "getManifestUrl", "setManifestUrl", "getMediaLength", "setMediaLength", "getMediaLengthFormat", "setMediaLengthFormat", "getMediaOrigin", "setMediaOrigin", "getPatternPer", "setPatternPer", "getPatternUrl", "setPatternUrl", "getPatternUrls", "()Ljava/util/ArrayList;", "setPatternUrls", "(Ljava/util/ArrayList;)V", "getPf", "setPf", "getPfChannelUnite", "setPfChannelUnite", "getPfLogo", "setPfLogo", "getRealWebUrl", "setRealWebUrl", "getRemark", "setRemark", "getResourceType", "setResourceType", "getScore", "()Ljava/lang/Double;", "setScore", "(Ljava/lang/Double;)V", "Ljava/lang/Double;", "getSort", "setSort", "getStatVersion", "setStatVersion", "getStaticVideoLikeNumber", "setStaticVideoLikeNumber", "getStaticVideoUserIsLike", "()Z", "setStaticVideoUserIsLike", "(Z)V", "getStatus", "setStatus", "getTag", "setTag", "getTitle", "setTitle", "getUploadDate", "setUploadDate", "getUploader", "setUploader", "getUserName", "setUserName", "getUuid", "setUuid", "getUuidWebUrlMd5", "setUuidWebUrlMd5", "getVersion", "setVersion", "getVideoDuration", "setVideoDuration", "getVideoId", "setVideoId", "getVideoTitle", "setVideoTitle", "getViewCount", "setViewCount", "getViewCountShow", "setViewCountShow", "getViewKey", "setViewKey", "getWebUrl", "setWebUrl", "getWebUrlMd5", "setWebUrlMd5", "getWebsite", "setWebsite", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component3", "component30", "component31", "component32", "component33", "component34", "component35", "component36", "component37", "component38", "component39", "component4", "component40", "component41", "component42", "component43", "component44", "component45", "component46", "component47", "component48", "component49", "component5", "component50", "component51", "component52", "component53", "component54", "component55", "component56", "component57", "component58", "component59", "component6", "component60", "component61", "component62", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/util/ArrayList;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/Integer;Ljava/lang/String;ZJ)Lcom/wear/bean/vb/VideoBean;", "equals", "other", "", "hashCode", "toString", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class VideoBean implements tq {

    @Nullable
    private String abbreviateMp4VideoUrl;

    @Nullable
    private String abbreviateVideoUrl;

    @Nullable
    private String accountId;

    @Nullable
    private String categories;

    @Nullable
    private String country;

    @Nullable
    private String coverPicture;
    private int day;

    @Nullable
    private Boolean delete;

    @Nullable
    private Boolean disLike;

    @Nullable
    private Integer dislikeCount;

    @Nullable
    private String domain;

    @Nullable
    private String downloadUrl;

    @Nullable
    private Integer duration;

    @Nullable
    private String durationFormat;

    @Nullable
    private String email;

    @Nullable
    private Integer hasPattern;

    @Nullable
    private Long id;

    @Nullable
    private Integer isAnonymous;

    @Nullable
    private Boolean isDelete;

    @Nullable
    private Boolean isDisLike;

    @Nullable
    private Boolean isLike;

    @Nullable
    private Boolean like;

    @Nullable
    private Integer likeCount;

    @Nullable
    private String likeCountShow;
    private long likeTimestamp;

    @Nullable
    private Integer localNewFlag;

    @Nullable
    private String manifestUrl;

    @Nullable
    private Integer mediaLength;

    @Nullable
    private String mediaLengthFormat;

    @Nullable
    private String mediaOrigin;

    @Nullable
    private Integer patternPer;

    @NotNull
    private String patternUrl;

    @Nullable
    private ArrayList<String> patternUrls;

    @Nullable
    private String pf;

    @Nullable
    private String pfChannelUnite;

    @Nullable
    private String pfLogo;

    @Nullable
    private String realWebUrl;

    @Nullable
    private String remark;

    @Nullable
    private Integer resourceType;

    @Nullable
    private Double score;

    @Nullable
    private Long sort;

    @Nullable
    private String statVersion;

    @NotNull
    private String staticVideoLikeNumber;
    private boolean staticVideoUserIsLike;

    @Nullable
    private Integer status;

    @Nullable
    private String tag;

    @Nullable
    private String title;

    @Nullable
    private String uploadDate;

    @Nullable
    private String uploader;

    @Nullable
    private String userName;

    @Nullable
    private String uuid;

    @Nullable
    private String uuidWebUrlMd5;

    @Nullable
    private Integer version;

    @Nullable
    private Integer videoDuration;

    @Nullable
    private Long videoId;

    @Nullable
    private String videoTitle;

    @Nullable
    private Integer viewCount;

    @Nullable
    private String viewCountShow;

    @Nullable
    private String viewKey;

    @NotNull
    private String webUrl;

    @Nullable
    private String webUrlMd5;

    @Nullable
    private String website;

    public VideoBean(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable Boolean bool, @Nullable Boolean bool2, @Nullable Integer num, @Nullable String str7, @Nullable String str8, @Nullable Integer num2, @Nullable String str9, @Nullable String str10, @Nullable Integer num3, @Nullable Long l, @Nullable Integer num4, @Nullable Boolean bool3, @Nullable Boolean bool4, @Nullable Boolean bool5, @Nullable Boolean bool6, @Nullable Integer num5, @Nullable String str11, @Nullable String str12, @Nullable Integer num6, @Nullable String str13, @Nullable String str14, @Nullable Integer num7, @NotNull String patternUrl, @Nullable ArrayList<String> arrayList, @Nullable String str15, @Nullable String str16, @Nullable String str17, @Nullable String str18, @Nullable String str19, @Nullable Integer num8, @Nullable Double d, @Nullable Long l2, @Nullable String str20, @Nullable Integer num9, @Nullable String str21, @Nullable String str22, @Nullable String str23, @Nullable String str24, @Nullable String str25, @Nullable String str26, @Nullable String str27, @Nullable Integer num10, @Nullable Integer num11, @Nullable Long l3, @Nullable String str28, @Nullable Integer num12, @Nullable String str29, @Nullable String str30, @NotNull String webUrl, @Nullable String str31, @Nullable String str32, int i, @Nullable Integer num13, @NotNull String staticVideoLikeNumber, boolean z, long j) {
        Intrinsics.checkNotNullParameter(patternUrl, "patternUrl");
        Intrinsics.checkNotNullParameter(webUrl, "webUrl");
        Intrinsics.checkNotNullParameter(staticVideoLikeNumber, "staticVideoLikeNumber");
        this.abbreviateMp4VideoUrl = str;
        this.abbreviateVideoUrl = str2;
        this.accountId = str3;
        this.categories = str4;
        this.country = str5;
        this.coverPicture = str6;
        this.delete = bool;
        this.disLike = bool2;
        this.dislikeCount = num;
        this.domain = str7;
        this.downloadUrl = str8;
        this.duration = num2;
        this.durationFormat = str9;
        this.email = str10;
        this.hasPattern = num3;
        this.id = l;
        this.isAnonymous = num4;
        this.isDelete = bool3;
        this.isDisLike = bool4;
        this.isLike = bool5;
        this.like = bool6;
        this.likeCount = num5;
        this.likeCountShow = str11;
        this.manifestUrl = str12;
        this.mediaLength = num6;
        this.mediaLengthFormat = str13;
        this.mediaOrigin = str14;
        this.patternPer = num7;
        this.patternUrl = patternUrl;
        this.patternUrls = arrayList;
        this.pf = str15;
        this.pfChannelUnite = str16;
        this.pfLogo = str17;
        this.realWebUrl = str18;
        this.remark = str19;
        this.resourceType = num8;
        this.score = d;
        this.sort = l2;
        this.statVersion = str20;
        this.status = num9;
        this.tag = str21;
        this.title = str22;
        this.uploadDate = str23;
        this.uploader = str24;
        this.userName = str25;
        this.uuid = str26;
        this.uuidWebUrlMd5 = str27;
        this.version = num10;
        this.videoDuration = num11;
        this.videoId = l3;
        this.videoTitle = str28;
        this.viewCount = num12;
        this.viewCountShow = str29;
        this.viewKey = str30;
        this.webUrl = webUrl;
        this.webUrlMd5 = str31;
        this.website = str32;
        this.day = i;
        this.localNewFlag = num13;
        this.staticVideoLikeNumber = staticVideoLikeNumber;
        this.staticVideoUserIsLike = z;
        this.likeTimestamp = j;
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getAbbreviateMp4VideoUrl() {
        return this.abbreviateMp4VideoUrl;
    }

    @Nullable
    /* renamed from: component10, reason: from getter */
    public final String getDomain() {
        return this.domain;
    }

    @Nullable
    /* renamed from: component11, reason: from getter */
    public final String getDownloadUrl() {
        return this.downloadUrl;
    }

    @Nullable
    /* renamed from: component12, reason: from getter */
    public final Integer getDuration() {
        return this.duration;
    }

    @Nullable
    /* renamed from: component13, reason: from getter */
    public final String getDurationFormat() {
        return this.durationFormat;
    }

    @Nullable
    /* renamed from: component14, reason: from getter */
    public final String getEmail() {
        return this.email;
    }

    @Nullable
    /* renamed from: component15, reason: from getter */
    public final Integer getHasPattern() {
        return this.hasPattern;
    }

    @Nullable
    /* renamed from: component16, reason: from getter */
    public final Long getId() {
        return this.id;
    }

    @Nullable
    /* renamed from: component17, reason: from getter */
    public final Integer getIsAnonymous() {
        return this.isAnonymous;
    }

    @Nullable
    /* renamed from: component18, reason: from getter */
    public final Boolean getIsDelete() {
        return this.isDelete;
    }

    @Nullable
    /* renamed from: component19, reason: from getter */
    public final Boolean getIsDisLike() {
        return this.isDisLike;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getAbbreviateVideoUrl() {
        return this.abbreviateVideoUrl;
    }

    @Nullable
    /* renamed from: component20, reason: from getter */
    public final Boolean getIsLike() {
        return this.isLike;
    }

    @Nullable
    /* renamed from: component21, reason: from getter */
    public final Boolean getLike() {
        return this.like;
    }

    @Nullable
    /* renamed from: component22, reason: from getter */
    public final Integer getLikeCount() {
        return this.likeCount;
    }

    @Nullable
    /* renamed from: component23, reason: from getter */
    public final String getLikeCountShow() {
        return this.likeCountShow;
    }

    @Nullable
    /* renamed from: component24, reason: from getter */
    public final String getManifestUrl() {
        return this.manifestUrl;
    }

    @Nullable
    /* renamed from: component25, reason: from getter */
    public final Integer getMediaLength() {
        return this.mediaLength;
    }

    @Nullable
    /* renamed from: component26, reason: from getter */
    public final String getMediaLengthFormat() {
        return this.mediaLengthFormat;
    }

    @Nullable
    /* renamed from: component27, reason: from getter */
    public final String getMediaOrigin() {
        return this.mediaOrigin;
    }

    @Nullable
    /* renamed from: component28, reason: from getter */
    public final Integer getPatternPer() {
        return this.patternPer;
    }

    @NotNull
    /* renamed from: component29, reason: from getter */
    public final String getPatternUrl() {
        return this.patternUrl;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final String getAccountId() {
        return this.accountId;
    }

    @Nullable
    public final ArrayList<String> component30() {
        return this.patternUrls;
    }

    @Nullable
    /* renamed from: component31, reason: from getter */
    public final String getPf() {
        return this.pf;
    }

    @Nullable
    /* renamed from: component32, reason: from getter */
    public final String getPfChannelUnite() {
        return this.pfChannelUnite;
    }

    @Nullable
    /* renamed from: component33, reason: from getter */
    public final String getPfLogo() {
        return this.pfLogo;
    }

    @Nullable
    /* renamed from: component34, reason: from getter */
    public final String getRealWebUrl() {
        return this.realWebUrl;
    }

    @Nullable
    /* renamed from: component35, reason: from getter */
    public final String getRemark() {
        return this.remark;
    }

    @Nullable
    /* renamed from: component36, reason: from getter */
    public final Integer getResourceType() {
        return this.resourceType;
    }

    @Nullable
    /* renamed from: component37, reason: from getter */
    public final Double getScore() {
        return this.score;
    }

    @Nullable
    /* renamed from: component38, reason: from getter */
    public final Long getSort() {
        return this.sort;
    }

    @Nullable
    /* renamed from: component39, reason: from getter */
    public final String getStatVersion() {
        return this.statVersion;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final String getCategories() {
        return this.categories;
    }

    @Nullable
    /* renamed from: component40, reason: from getter */
    public final Integer getStatus() {
        return this.status;
    }

    @Nullable
    /* renamed from: component41, reason: from getter */
    public final String getTag() {
        return this.tag;
    }

    @Nullable
    /* renamed from: component42, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    /* renamed from: component43, reason: from getter */
    public final String getUploadDate() {
        return this.uploadDate;
    }

    @Nullable
    /* renamed from: component44, reason: from getter */
    public final String getUploader() {
        return this.uploader;
    }

    @Nullable
    /* renamed from: component45, reason: from getter */
    public final String getUserName() {
        return this.userName;
    }

    @Nullable
    /* renamed from: component46, reason: from getter */
    public final String getUuid() {
        return this.uuid;
    }

    @Nullable
    /* renamed from: component47, reason: from getter */
    public final String getUuidWebUrlMd5() {
        return this.uuidWebUrlMd5;
    }

    @Nullable
    /* renamed from: component48, reason: from getter */
    public final Integer getVersion() {
        return this.version;
    }

    @Nullable
    /* renamed from: component49, reason: from getter */
    public final Integer getVideoDuration() {
        return this.videoDuration;
    }

    @Nullable
    /* renamed from: component5, reason: from getter */
    public final String getCountry() {
        return this.country;
    }

    @Nullable
    /* renamed from: component50, reason: from getter */
    public final Long getVideoId() {
        return this.videoId;
    }

    @Nullable
    /* renamed from: component51, reason: from getter */
    public final String getVideoTitle() {
        return this.videoTitle;
    }

    @Nullable
    /* renamed from: component52, reason: from getter */
    public final Integer getViewCount() {
        return this.viewCount;
    }

    @Nullable
    /* renamed from: component53, reason: from getter */
    public final String getViewCountShow() {
        return this.viewCountShow;
    }

    @Nullable
    /* renamed from: component54, reason: from getter */
    public final String getViewKey() {
        return this.viewKey;
    }

    @NotNull
    /* renamed from: component55, reason: from getter */
    public final String getWebUrl() {
        return this.webUrl;
    }

    @Nullable
    /* renamed from: component56, reason: from getter */
    public final String getWebUrlMd5() {
        return this.webUrlMd5;
    }

    @Nullable
    /* renamed from: component57, reason: from getter */
    public final String getWebsite() {
        return this.website;
    }

    /* renamed from: component58, reason: from getter */
    public final int getDay() {
        return this.day;
    }

    @Nullable
    /* renamed from: component59, reason: from getter */
    public final Integer getLocalNewFlag() {
        return this.localNewFlag;
    }

    @Nullable
    /* renamed from: component6, reason: from getter */
    public final String getCoverPicture() {
        return this.coverPicture;
    }

    @NotNull
    /* renamed from: component60, reason: from getter */
    public final String getStaticVideoLikeNumber() {
        return this.staticVideoLikeNumber;
    }

    /* renamed from: component61, reason: from getter */
    public final boolean getStaticVideoUserIsLike() {
        return this.staticVideoUserIsLike;
    }

    /* renamed from: component62, reason: from getter */
    public final long getLikeTimestamp() {
        return this.likeTimestamp;
    }

    @Nullable
    /* renamed from: component7, reason: from getter */
    public final Boolean getDelete() {
        return this.delete;
    }

    @Nullable
    /* renamed from: component8, reason: from getter */
    public final Boolean getDisLike() {
        return this.disLike;
    }

    @Nullable
    /* renamed from: component9, reason: from getter */
    public final Integer getDislikeCount() {
        return this.dislikeCount;
    }

    @NotNull
    public final VideoBean copy(@Nullable String abbreviateMp4VideoUrl, @Nullable String abbreviateVideoUrl, @Nullable String accountId, @Nullable String categories, @Nullable String country, @Nullable String coverPicture, @Nullable Boolean delete, @Nullable Boolean disLike, @Nullable Integer dislikeCount, @Nullable String domain, @Nullable String downloadUrl, @Nullable Integer duration, @Nullable String durationFormat, @Nullable String email, @Nullable Integer hasPattern, @Nullable Long id, @Nullable Integer isAnonymous, @Nullable Boolean isDelete, @Nullable Boolean isDisLike, @Nullable Boolean isLike, @Nullable Boolean like, @Nullable Integer likeCount, @Nullable String likeCountShow, @Nullable String manifestUrl, @Nullable Integer mediaLength, @Nullable String mediaLengthFormat, @Nullable String mediaOrigin, @Nullable Integer patternPer, @NotNull String patternUrl, @Nullable ArrayList<String> patternUrls, @Nullable String pf, @Nullable String pfChannelUnite, @Nullable String pfLogo, @Nullable String realWebUrl, @Nullable String remark, @Nullable Integer resourceType, @Nullable Double score, @Nullable Long sort, @Nullable String statVersion, @Nullable Integer status, @Nullable String tag, @Nullable String title, @Nullable String uploadDate, @Nullable String uploader, @Nullable String userName, @Nullable String uuid, @Nullable String uuidWebUrlMd5, @Nullable Integer version, @Nullable Integer videoDuration, @Nullable Long videoId, @Nullable String videoTitle, @Nullable Integer viewCount, @Nullable String viewCountShow, @Nullable String viewKey, @NotNull String webUrl, @Nullable String webUrlMd5, @Nullable String website, int day, @Nullable Integer localNewFlag, @NotNull String staticVideoLikeNumber, boolean staticVideoUserIsLike, long likeTimestamp) {
        Intrinsics.checkNotNullParameter(patternUrl, "patternUrl");
        Intrinsics.checkNotNullParameter(webUrl, "webUrl");
        Intrinsics.checkNotNullParameter(staticVideoLikeNumber, "staticVideoLikeNumber");
        return new VideoBean(abbreviateMp4VideoUrl, abbreviateVideoUrl, accountId, categories, country, coverPicture, delete, disLike, dislikeCount, domain, downloadUrl, duration, durationFormat, email, hasPattern, id, isAnonymous, isDelete, isDisLike, isLike, like, likeCount, likeCountShow, manifestUrl, mediaLength, mediaLengthFormat, mediaOrigin, patternPer, patternUrl, patternUrls, pf, pfChannelUnite, pfLogo, realWebUrl, remark, resourceType, score, sort, statVersion, status, tag, title, uploadDate, uploader, userName, uuid, uuidWebUrlMd5, version, videoDuration, videoId, videoTitle, viewCount, viewCountShow, viewKey, webUrl, webUrlMd5, website, day, localNewFlag, staticVideoLikeNumber, staticVideoUserIsLike, likeTimestamp);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VideoBean)) {
            return false;
        }
        VideoBean videoBean = (VideoBean) other;
        return Intrinsics.areEqual(this.abbreviateMp4VideoUrl, videoBean.abbreviateMp4VideoUrl) && Intrinsics.areEqual(this.abbreviateVideoUrl, videoBean.abbreviateVideoUrl) && Intrinsics.areEqual(this.accountId, videoBean.accountId) && Intrinsics.areEqual(this.categories, videoBean.categories) && Intrinsics.areEqual(this.country, videoBean.country) && Intrinsics.areEqual(this.coverPicture, videoBean.coverPicture) && Intrinsics.areEqual(this.delete, videoBean.delete) && Intrinsics.areEqual(this.disLike, videoBean.disLike) && Intrinsics.areEqual(this.dislikeCount, videoBean.dislikeCount) && Intrinsics.areEqual(this.domain, videoBean.domain) && Intrinsics.areEqual(this.downloadUrl, videoBean.downloadUrl) && Intrinsics.areEqual(this.duration, videoBean.duration) && Intrinsics.areEqual(this.durationFormat, videoBean.durationFormat) && Intrinsics.areEqual(this.email, videoBean.email) && Intrinsics.areEqual(this.hasPattern, videoBean.hasPattern) && Intrinsics.areEqual(this.id, videoBean.id) && Intrinsics.areEqual(this.isAnonymous, videoBean.isAnonymous) && Intrinsics.areEqual(this.isDelete, videoBean.isDelete) && Intrinsics.areEqual(this.isDisLike, videoBean.isDisLike) && Intrinsics.areEqual(this.isLike, videoBean.isLike) && Intrinsics.areEqual(this.like, videoBean.like) && Intrinsics.areEqual(this.likeCount, videoBean.likeCount) && Intrinsics.areEqual(this.likeCountShow, videoBean.likeCountShow) && Intrinsics.areEqual(this.manifestUrl, videoBean.manifestUrl) && Intrinsics.areEqual(this.mediaLength, videoBean.mediaLength) && Intrinsics.areEqual(this.mediaLengthFormat, videoBean.mediaLengthFormat) && Intrinsics.areEqual(this.mediaOrigin, videoBean.mediaOrigin) && Intrinsics.areEqual(this.patternPer, videoBean.patternPer) && Intrinsics.areEqual(this.patternUrl, videoBean.patternUrl) && Intrinsics.areEqual(this.patternUrls, videoBean.patternUrls) && Intrinsics.areEqual(this.pf, videoBean.pf) && Intrinsics.areEqual(this.pfChannelUnite, videoBean.pfChannelUnite) && Intrinsics.areEqual(this.pfLogo, videoBean.pfLogo) && Intrinsics.areEqual(this.realWebUrl, videoBean.realWebUrl) && Intrinsics.areEqual(this.remark, videoBean.remark) && Intrinsics.areEqual(this.resourceType, videoBean.resourceType) && Intrinsics.areEqual((Object) this.score, (Object) videoBean.score) && Intrinsics.areEqual(this.sort, videoBean.sort) && Intrinsics.areEqual(this.statVersion, videoBean.statVersion) && Intrinsics.areEqual(this.status, videoBean.status) && Intrinsics.areEqual(this.tag, videoBean.tag) && Intrinsics.areEqual(this.title, videoBean.title) && Intrinsics.areEqual(this.uploadDate, videoBean.uploadDate) && Intrinsics.areEqual(this.uploader, videoBean.uploader) && Intrinsics.areEqual(this.userName, videoBean.userName) && Intrinsics.areEqual(this.uuid, videoBean.uuid) && Intrinsics.areEqual(this.uuidWebUrlMd5, videoBean.uuidWebUrlMd5) && Intrinsics.areEqual(this.version, videoBean.version) && Intrinsics.areEqual(this.videoDuration, videoBean.videoDuration) && Intrinsics.areEqual(this.videoId, videoBean.videoId) && Intrinsics.areEqual(this.videoTitle, videoBean.videoTitle) && Intrinsics.areEqual(this.viewCount, videoBean.viewCount) && Intrinsics.areEqual(this.viewCountShow, videoBean.viewCountShow) && Intrinsics.areEqual(this.viewKey, videoBean.viewKey) && Intrinsics.areEqual(this.webUrl, videoBean.webUrl) && Intrinsics.areEqual(this.webUrlMd5, videoBean.webUrlMd5) && Intrinsics.areEqual(this.website, videoBean.website) && this.day == videoBean.day && Intrinsics.areEqual(this.localNewFlag, videoBean.localNewFlag) && Intrinsics.areEqual(this.staticVideoLikeNumber, videoBean.staticVideoLikeNumber) && this.staticVideoUserIsLike == videoBean.staticVideoUserIsLike && this.likeTimestamp == videoBean.likeTimestamp;
    }

    @Nullable
    public final String getAbbreviateMp4VideoUrl() {
        return this.abbreviateMp4VideoUrl;
    }

    @Nullable
    public final String getAbbreviateVideoUrl() {
        return this.abbreviateVideoUrl;
    }

    @Nullable
    public final String getAccountId() {
        return this.accountId;
    }

    @Nullable
    public final String getCategories() {
        return this.categories;
    }

    @Nullable
    public final String getCountry() {
        return this.country;
    }

    @Nullable
    public final String getCoverPicture() {
        return this.coverPicture;
    }

    public final int getDay() {
        return this.day;
    }

    @Nullable
    public final Boolean getDelete() {
        return this.delete;
    }

    @Nullable
    public final Boolean getDisLike() {
        return this.disLike;
    }

    @Nullable
    public final Integer getDislikeCount() {
        return this.dislikeCount;
    }

    @Nullable
    public final String getDomain() {
        return this.domain;
    }

    @Nullable
    public final String getDownloadUrl() {
        return this.downloadUrl;
    }

    @Nullable
    public final Integer getDuration() {
        return this.duration;
    }

    @Nullable
    public final String getDurationFormat() {
        return this.durationFormat;
    }

    @Nullable
    public final String getEmail() {
        return this.email;
    }

    @Nullable
    public final Integer getHasPattern() {
        return this.hasPattern;
    }

    @Nullable
    public final Long getId() {
        return this.id;
    }

    @JvmName(name = "getIsDelete")
    @Nullable
    public final Boolean getIsDelete() {
        return this.isDelete;
    }

    @JvmName(name = "getIsDisLike")
    @Nullable
    public final Boolean getIsDisLike() {
        return this.isDisLike;
    }

    @JvmName(name = "getIsLike")
    @Nullable
    public final Boolean getIsLike() {
        return this.isLike;
    }

    @Override // dc.tq
    public int getItemType() {
        return 1;
    }

    @Nullable
    public final Boolean getLike() {
        return this.like;
    }

    @Nullable
    public final Integer getLikeCount() {
        return this.likeCount;
    }

    @Nullable
    public final String getLikeCountShow() {
        return this.likeCountShow;
    }

    public final long getLikeTimestamp() {
        return this.likeTimestamp;
    }

    @Nullable
    public final Integer getLocalNewFlag() {
        return this.localNewFlag;
    }

    @Nullable
    public final String getManifestUrl() {
        return this.manifestUrl;
    }

    @Nullable
    public final Integer getMediaLength() {
        return this.mediaLength;
    }

    @Nullable
    public final String getMediaLengthFormat() {
        return this.mediaLengthFormat;
    }

    @Nullable
    public final String getMediaOrigin() {
        return this.mediaOrigin;
    }

    @Nullable
    public final Integer getPatternPer() {
        return this.patternPer;
    }

    @NotNull
    public final String getPatternUrl() {
        return this.patternUrl;
    }

    @Nullable
    public final ArrayList<String> getPatternUrls() {
        return this.patternUrls;
    }

    @Nullable
    public final String getPf() {
        return this.pf;
    }

    @Nullable
    public final String getPfChannelUnite() {
        return this.pfChannelUnite;
    }

    @Nullable
    public final String getPfLogo() {
        return this.pfLogo;
    }

    @Nullable
    public final String getRealWebUrl() {
        return this.realWebUrl;
    }

    @Nullable
    public final String getRemark() {
        return this.remark;
    }

    @Nullable
    public final Integer getResourceType() {
        return this.resourceType;
    }

    @Nullable
    public final Double getScore() {
        return this.score;
    }

    @Nullable
    public final Long getSort() {
        return this.sort;
    }

    @Nullable
    public final String getStatVersion() {
        return this.statVersion;
    }

    @NotNull
    public final String getStaticVideoLikeNumber() {
        return this.staticVideoLikeNumber;
    }

    public final boolean getStaticVideoUserIsLike() {
        return this.staticVideoUserIsLike;
    }

    @Nullable
    public final Integer getStatus() {
        return this.status;
    }

    @Nullable
    public final String getTag() {
        return this.tag;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    public final String getUploadDate() {
        return this.uploadDate;
    }

    @Nullable
    public final String getUploader() {
        return this.uploader;
    }

    @Nullable
    public final String getUserName() {
        return this.userName;
    }

    @Nullable
    public final String getUuid() {
        return this.uuid;
    }

    @Nullable
    public final String getUuidWebUrlMd5() {
        return this.uuidWebUrlMd5;
    }

    @Nullable
    public final Integer getVersion() {
        return this.version;
    }

    @Nullable
    public final Integer getVideoDuration() {
        return this.videoDuration;
    }

    @Nullable
    public final Long getVideoId() {
        return this.videoId;
    }

    @Nullable
    public final String getVideoTitle() {
        return this.videoTitle;
    }

    @Nullable
    public final Integer getViewCount() {
        return this.viewCount;
    }

    @Nullable
    public final String getViewCountShow() {
        return this.viewCountShow;
    }

    @Nullable
    public final String getViewKey() {
        return this.viewKey;
    }

    @NotNull
    public final String getWebUrl() {
        return this.webUrl;
    }

    @Nullable
    public final String getWebUrlMd5() {
        return this.webUrlMd5;
    }

    @Nullable
    public final String getWebsite() {
        return this.website;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        String str = this.abbreviateMp4VideoUrl;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.abbreviateVideoUrl;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.accountId;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.categories;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.country;
        int iHashCode5 = (iHashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.coverPicture;
        int iHashCode6 = (iHashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        Boolean bool = this.delete;
        int iHashCode7 = (iHashCode6 + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.disLike;
        int iHashCode8 = (iHashCode7 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        Integer num = this.dislikeCount;
        int iHashCode9 = (iHashCode8 + (num == null ? 0 : num.hashCode())) * 31;
        String str7 = this.domain;
        int iHashCode10 = (iHashCode9 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.downloadUrl;
        int iHashCode11 = (iHashCode10 + (str8 == null ? 0 : str8.hashCode())) * 31;
        Integer num2 = this.duration;
        int iHashCode12 = (iHashCode11 + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str9 = this.durationFormat;
        int iHashCode13 = (iHashCode12 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.email;
        int iHashCode14 = (iHashCode13 + (str10 == null ? 0 : str10.hashCode())) * 31;
        Integer num3 = this.hasPattern;
        int iHashCode15 = (iHashCode14 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Long l = this.id;
        int iHashCode16 = (iHashCode15 + (l == null ? 0 : l.hashCode())) * 31;
        Integer num4 = this.isAnonymous;
        int iHashCode17 = (iHashCode16 + (num4 == null ? 0 : num4.hashCode())) * 31;
        Boolean bool3 = this.isDelete;
        int iHashCode18 = (iHashCode17 + (bool3 == null ? 0 : bool3.hashCode())) * 31;
        Boolean bool4 = this.isDisLike;
        int iHashCode19 = (iHashCode18 + (bool4 == null ? 0 : bool4.hashCode())) * 31;
        Boolean bool5 = this.isLike;
        int iHashCode20 = (iHashCode19 + (bool5 == null ? 0 : bool5.hashCode())) * 31;
        Boolean bool6 = this.like;
        int iHashCode21 = (iHashCode20 + (bool6 == null ? 0 : bool6.hashCode())) * 31;
        Integer num5 = this.likeCount;
        int iHashCode22 = (iHashCode21 + (num5 == null ? 0 : num5.hashCode())) * 31;
        String str11 = this.likeCountShow;
        int iHashCode23 = (iHashCode22 + (str11 == null ? 0 : str11.hashCode())) * 31;
        String str12 = this.manifestUrl;
        int iHashCode24 = (iHashCode23 + (str12 == null ? 0 : str12.hashCode())) * 31;
        Integer num6 = this.mediaLength;
        int iHashCode25 = (iHashCode24 + (num6 == null ? 0 : num6.hashCode())) * 31;
        String str13 = this.mediaLengthFormat;
        int iHashCode26 = (iHashCode25 + (str13 == null ? 0 : str13.hashCode())) * 31;
        String str14 = this.mediaOrigin;
        int iHashCode27 = (iHashCode26 + (str14 == null ? 0 : str14.hashCode())) * 31;
        Integer num7 = this.patternPer;
        int iHashCode28 = (((iHashCode27 + (num7 == null ? 0 : num7.hashCode())) * 31) + this.patternUrl.hashCode()) * 31;
        ArrayList<String> arrayList = this.patternUrls;
        int iHashCode29 = (iHashCode28 + (arrayList == null ? 0 : arrayList.hashCode())) * 31;
        String str15 = this.pf;
        int iHashCode30 = (iHashCode29 + (str15 == null ? 0 : str15.hashCode())) * 31;
        String str16 = this.pfChannelUnite;
        int iHashCode31 = (iHashCode30 + (str16 == null ? 0 : str16.hashCode())) * 31;
        String str17 = this.pfLogo;
        int iHashCode32 = (iHashCode31 + (str17 == null ? 0 : str17.hashCode())) * 31;
        String str18 = this.realWebUrl;
        int iHashCode33 = (iHashCode32 + (str18 == null ? 0 : str18.hashCode())) * 31;
        String str19 = this.remark;
        int iHashCode34 = (iHashCode33 + (str19 == null ? 0 : str19.hashCode())) * 31;
        Integer num8 = this.resourceType;
        int iHashCode35 = (iHashCode34 + (num8 == null ? 0 : num8.hashCode())) * 31;
        Double d = this.score;
        int iHashCode36 = (iHashCode35 + (d == null ? 0 : d.hashCode())) * 31;
        Long l2 = this.sort;
        int iHashCode37 = (iHashCode36 + (l2 == null ? 0 : l2.hashCode())) * 31;
        String str20 = this.statVersion;
        int iHashCode38 = (iHashCode37 + (str20 == null ? 0 : str20.hashCode())) * 31;
        Integer num9 = this.status;
        int iHashCode39 = (iHashCode38 + (num9 == null ? 0 : num9.hashCode())) * 31;
        String str21 = this.tag;
        int iHashCode40 = (iHashCode39 + (str21 == null ? 0 : str21.hashCode())) * 31;
        String str22 = this.title;
        int iHashCode41 = (iHashCode40 + (str22 == null ? 0 : str22.hashCode())) * 31;
        String str23 = this.uploadDate;
        int iHashCode42 = (iHashCode41 + (str23 == null ? 0 : str23.hashCode())) * 31;
        String str24 = this.uploader;
        int iHashCode43 = (iHashCode42 + (str24 == null ? 0 : str24.hashCode())) * 31;
        String str25 = this.userName;
        int iHashCode44 = (iHashCode43 + (str25 == null ? 0 : str25.hashCode())) * 31;
        String str26 = this.uuid;
        int iHashCode45 = (iHashCode44 + (str26 == null ? 0 : str26.hashCode())) * 31;
        String str27 = this.uuidWebUrlMd5;
        int iHashCode46 = (iHashCode45 + (str27 == null ? 0 : str27.hashCode())) * 31;
        Integer num10 = this.version;
        int iHashCode47 = (iHashCode46 + (num10 == null ? 0 : num10.hashCode())) * 31;
        Integer num11 = this.videoDuration;
        int iHashCode48 = (iHashCode47 + (num11 == null ? 0 : num11.hashCode())) * 31;
        Long l3 = this.videoId;
        int iHashCode49 = (iHashCode48 + (l3 == null ? 0 : l3.hashCode())) * 31;
        String str28 = this.videoTitle;
        int iHashCode50 = (iHashCode49 + (str28 == null ? 0 : str28.hashCode())) * 31;
        Integer num12 = this.viewCount;
        int iHashCode51 = (iHashCode50 + (num12 == null ? 0 : num12.hashCode())) * 31;
        String str29 = this.viewCountShow;
        int iHashCode52 = (iHashCode51 + (str29 == null ? 0 : str29.hashCode())) * 31;
        String str30 = this.viewKey;
        int iHashCode53 = (((iHashCode52 + (str30 == null ? 0 : str30.hashCode())) * 31) + this.webUrl.hashCode()) * 31;
        String str31 = this.webUrlMd5;
        int iHashCode54 = (iHashCode53 + (str31 == null ? 0 : str31.hashCode())) * 31;
        String str32 = this.website;
        int iHashCode55 = (((iHashCode54 + (str32 == null ? 0 : str32.hashCode())) * 31) + this.day) * 31;
        Integer num13 = this.localNewFlag;
        int iHashCode56 = (((iHashCode55 + (num13 != null ? num13.hashCode() : 0)) * 31) + this.staticVideoLikeNumber.hashCode()) * 31;
        boolean z = this.staticVideoUserIsLike;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return ((iHashCode56 + i) * 31) + g.a(this.likeTimestamp);
    }

    @Nullable
    public final Integer isAnonymous() {
        return this.isAnonymous;
    }

    public final void setAbbreviateMp4VideoUrl(@Nullable String str) {
        this.abbreviateMp4VideoUrl = str;
    }

    public final void setAbbreviateVideoUrl(@Nullable String str) {
        this.abbreviateVideoUrl = str;
    }

    public final void setAccountId(@Nullable String str) {
        this.accountId = str;
    }

    public final void setAnonymous(@Nullable Integer num) {
        this.isAnonymous = num;
    }

    public final void setCategories(@Nullable String str) {
        this.categories = str;
    }

    public final void setCountry(@Nullable String str) {
        this.country = str;
    }

    public final void setCoverPicture(@Nullable String str) {
        this.coverPicture = str;
    }

    public final void setDay(int i) {
        this.day = i;
    }

    public final void setDelete(@Nullable Boolean bool) {
        this.delete = bool;
    }

    public final void setDisLike(@Nullable Boolean bool) {
        this.disLike = bool;
    }

    public final void setDislikeCount(@Nullable Integer num) {
        this.dislikeCount = num;
    }

    public final void setDomain(@Nullable String str) {
        this.domain = str;
    }

    public final void setDownloadUrl(@Nullable String str) {
        this.downloadUrl = str;
    }

    public final void setDuration(@Nullable Integer num) {
        this.duration = num;
    }

    public final void setDurationFormat(@Nullable String str) {
        this.durationFormat = str;
    }

    public final void setEmail(@Nullable String str) {
        this.email = str;
    }

    public final void setHasPattern(@Nullable Integer num) {
        this.hasPattern = num;
    }

    public final void setId(@Nullable Long l) {
        this.id = l;
    }

    @JvmName(name = "setIsDelete")
    public final void setIsDelete(@Nullable Boolean bool) {
        this.isDelete = bool;
    }

    @JvmName(name = "setIsDisLike")
    public final void setIsDisLike(@Nullable Boolean bool) {
        this.isDisLike = bool;
    }

    @JvmName(name = "setIsLike")
    public final void setIsLike(@Nullable Boolean bool) {
        this.isLike = bool;
    }

    public final void setLike(@Nullable Boolean bool) {
        this.like = bool;
    }

    public final void setLikeCount(@Nullable Integer num) {
        this.likeCount = num;
    }

    public final void setLikeCountShow(@Nullable String str) {
        this.likeCountShow = str;
    }

    public final void setLikeTimestamp(long j) {
        this.likeTimestamp = j;
    }

    public final void setLocalNewFlag(@Nullable Integer num) {
        this.localNewFlag = num;
    }

    public final void setManifestUrl(@Nullable String str) {
        this.manifestUrl = str;
    }

    public final void setMediaLength(@Nullable Integer num) {
        this.mediaLength = num;
    }

    public final void setMediaLengthFormat(@Nullable String str) {
        this.mediaLengthFormat = str;
    }

    public final void setMediaOrigin(@Nullable String str) {
        this.mediaOrigin = str;
    }

    public final void setPatternPer(@Nullable Integer num) {
        this.patternPer = num;
    }

    public final void setPatternUrl(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.patternUrl = str;
    }

    public final void setPatternUrls(@Nullable ArrayList<String> arrayList) {
        this.patternUrls = arrayList;
    }

    public final void setPf(@Nullable String str) {
        this.pf = str;
    }

    public final void setPfChannelUnite(@Nullable String str) {
        this.pfChannelUnite = str;
    }

    public final void setPfLogo(@Nullable String str) {
        this.pfLogo = str;
    }

    public final void setRealWebUrl(@Nullable String str) {
        this.realWebUrl = str;
    }

    public final void setRemark(@Nullable String str) {
        this.remark = str;
    }

    public final void setResourceType(@Nullable Integer num) {
        this.resourceType = num;
    }

    public final void setScore(@Nullable Double d) {
        this.score = d;
    }

    public final void setSort(@Nullable Long l) {
        this.sort = l;
    }

    public final void setStatVersion(@Nullable String str) {
        this.statVersion = str;
    }

    public final void setStaticVideoLikeNumber(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.staticVideoLikeNumber = str;
    }

    public final void setStaticVideoUserIsLike(boolean z) {
        this.staticVideoUserIsLike = z;
    }

    public final void setStatus(@Nullable Integer num) {
        this.status = num;
    }

    public final void setTag(@Nullable String str) {
        this.tag = str;
    }

    public final void setTitle(@Nullable String str) {
        this.title = str;
    }

    public final void setUploadDate(@Nullable String str) {
        this.uploadDate = str;
    }

    public final void setUploader(@Nullable String str) {
        this.uploader = str;
    }

    public final void setUserName(@Nullable String str) {
        this.userName = str;
    }

    public final void setUuid(@Nullable String str) {
        this.uuid = str;
    }

    public final void setUuidWebUrlMd5(@Nullable String str) {
        this.uuidWebUrlMd5 = str;
    }

    public final void setVersion(@Nullable Integer num) {
        this.version = num;
    }

    public final void setVideoDuration(@Nullable Integer num) {
        this.videoDuration = num;
    }

    public final void setVideoId(@Nullable Long l) {
        this.videoId = l;
    }

    public final void setVideoTitle(@Nullable String str) {
        this.videoTitle = str;
    }

    public final void setViewCount(@Nullable Integer num) {
        this.viewCount = num;
    }

    public final void setViewCountShow(@Nullable String str) {
        this.viewCountShow = str;
    }

    public final void setViewKey(@Nullable String str) {
        this.viewKey = str;
    }

    public final void setWebUrl(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.webUrl = str;
    }

    public final void setWebUrlMd5(@Nullable String str) {
        this.webUrlMd5 = str;
    }

    public final void setWebsite(@Nullable String str) {
        this.website = str;
    }

    @NotNull
    public String toString() {
        return "VideoBean(abbreviateMp4VideoUrl=" + this.abbreviateMp4VideoUrl + ", abbreviateVideoUrl=" + this.abbreviateVideoUrl + ", accountId=" + this.accountId + ", categories=" + this.categories + ", country=" + this.country + ", coverPicture=" + this.coverPicture + ", delete=" + this.delete + ", disLike=" + this.disLike + ", dislikeCount=" + this.dislikeCount + ", domain=" + this.domain + ", downloadUrl=" + this.downloadUrl + ", duration=" + this.duration + ", durationFormat=" + this.durationFormat + ", email=" + this.email + ", hasPattern=" + this.hasPattern + ", id=" + this.id + ", isAnonymous=" + this.isAnonymous + ", isDelete=" + this.isDelete + ", isDisLike=" + this.isDisLike + ", isLike=" + this.isLike + ", like=" + this.like + ", likeCount=" + this.likeCount + ", likeCountShow=" + this.likeCountShow + ", manifestUrl=" + this.manifestUrl + ", mediaLength=" + this.mediaLength + ", mediaLengthFormat=" + this.mediaLengthFormat + ", mediaOrigin=" + this.mediaOrigin + ", patternPer=" + this.patternPer + ", patternUrl=" + this.patternUrl + ", patternUrls=" + this.patternUrls + ", pf=" + this.pf + ", pfChannelUnite=" + this.pfChannelUnite + ", pfLogo=" + this.pfLogo + ", realWebUrl=" + this.realWebUrl + ", remark=" + this.remark + ", resourceType=" + this.resourceType + ", score=" + this.score + ", sort=" + this.sort + ", statVersion=" + this.statVersion + ", status=" + this.status + ", tag=" + this.tag + ", title=" + this.title + ", uploadDate=" + this.uploadDate + ", uploader=" + this.uploader + ", userName=" + this.userName + ", uuid=" + this.uuid + ", uuidWebUrlMd5=" + this.uuidWebUrlMd5 + ", version=" + this.version + ", videoDuration=" + this.videoDuration + ", videoId=" + this.videoId + ", videoTitle=" + this.videoTitle + ", viewCount=" + this.viewCount + ", viewCountShow=" + this.viewCountShow + ", viewKey=" + this.viewKey + ", webUrl=" + this.webUrl + ", webUrlMd5=" + this.webUrlMd5 + ", website=" + this.website + ", day=" + this.day + ", localNewFlag=" + this.localNewFlag + ", staticVideoLikeNumber=" + this.staticVideoLikeNumber + ", staticVideoUserIsLike=" + this.staticVideoUserIsLike + ", likeTimestamp=" + this.likeTimestamp + ')';
    }

    public /* synthetic */ VideoBean(String str, String str2, String str3, String str4, String str5, String str6, Boolean bool, Boolean bool2, Integer num, String str7, String str8, Integer num2, String str9, String str10, Integer num3, Long l, Integer num4, Boolean bool3, Boolean bool4, Boolean bool5, Boolean bool6, Integer num5, String str11, String str12, Integer num6, String str13, String str14, Integer num7, String str15, ArrayList arrayList, String str16, String str17, String str18, String str19, String str20, Integer num8, Double d, Long l2, String str21, Integer num9, String str22, String str23, String str24, String str25, String str26, String str27, String str28, Integer num10, Integer num11, Long l3, String str29, Integer num12, String str30, String str31, String str32, String str33, String str34, int i, Integer num13, String str35, boolean z, long j, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : str2, (i2 & 4) != 0 ? null : str3, (i2 & 8) != 0 ? null : str4, (i2 & 16) != 0 ? null : str5, (i2 & 32) != 0 ? null : str6, (i2 & 64) != 0 ? null : bool, (i2 & 128) != 0 ? null : bool2, (i2 & 256) != 0 ? null : num, (i2 & 512) != 0 ? null : str7, (i2 & 1024) != 0 ? null : str8, (i2 & 2048) != 0 ? null : num2, (i2 & 4096) != 0 ? null : str9, (i2 & 8192) != 0 ? null : str10, (i2 & 16384) != 0 ? null : num3, (i2 & 32768) != 0 ? null : l, (i2 & 65536) != 0 ? null : num4, (i2 & 131072) != 0 ? null : bool3, (i2 & 262144) != 0 ? null : bool4, (i2 & 524288) != 0 ? null : bool5, (i2 & 1048576) != 0 ? null : bool6, (i2 & 2097152) != 0 ? null : num5, (i2 & 4194304) != 0 ? null : str11, (i2 & 8388608) != 0 ? null : str12, (i2 & 16777216) != 0 ? null : num6, (i2 & 33554432) != 0 ? null : str13, (i2 & AudioRoutingController.DEVICE_OUT_USB_HEADSET) != 0 ? null : str14, (i2 & 134217728) != 0 ? null : num7, str15, (i2 & 536870912) != 0 ? null : arrayList, (i2 & 1073741824) != 0 ? null : str16, (i2 & Integer.MIN_VALUE) != 0 ? null : str17, (i3 & 1) != 0 ? null : str18, (i3 & 2) != 0 ? null : str19, (i3 & 4) != 0 ? null : str20, (i3 & 8) != 0 ? null : num8, (i3 & 16) != 0 ? null : d, (i3 & 32) != 0 ? null : l2, (i3 & 64) != 0 ? null : str21, (i3 & 128) != 0 ? null : num9, (i3 & 256) != 0 ? null : str22, (i3 & 512) != 0 ? null : str23, (i3 & 1024) != 0 ? null : str24, (i3 & 2048) != 0 ? null : str25, (i3 & 4096) != 0 ? null : str26, (i3 & 8192) != 0 ? null : str27, (i3 & 16384) != 0 ? null : str28, (32768 & i3) != 0 ? null : num10, (65536 & i3) != 0 ? null : num11, (i3 & 131072) != 0 ? null : l3, (i3 & 262144) != 0 ? null : str29, (i3 & 524288) != 0 ? null : num12, (i3 & 1048576) != 0 ? null : str30, (2097152 & i3) != 0 ? null : str31, str32, (8388608 & i3) != 0 ? null : str33, (16777216 & i3) != 0 ? null : str34, (33554432 & i3) != 0 ? 0 : i, (i3 & AudioRoutingController.DEVICE_OUT_USB_HEADSET) != 0 ? null : num13, str35, z, j);
    }
}
