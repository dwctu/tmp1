package com.chad.library.adapter.base;

import android.animation.Animator;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.IdRes;
import androidx.annotation.IntRange;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.epicgames.unreal.psoservices.PSOProgramService;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.analytics.FirebaseAnalytics;
import dc.ar;
import dc.br;
import dc.cr;
import dc.fr;
import dc.gr;
import dc.hr;
import dc.ir;
import dc.jr;
import dc.kr;
import dc.mr;
import dc.nq;
import dc.oq;
import dc.rq;
import dc.sq;
import dc.yq;
import dc.zq;
import java.lang.reflect.Constructor;
import java.lang.reflect.GenericSignatureFormatError;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.MalformedParameterizedTypeException;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smackx.disco.packet.DiscoverItems;
import org.jivesoftware.smackx.shim.packet.Header;

/* compiled from: BaseQuickAdapter.kt */
@Metadata(d1 = {"\u0000\u008e\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0006\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b$\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000 ï\u0001*\u0004\b\u0000\u0010\u0001*\b\b\u0001\u0010\u0002*\u00020\u00032\b\u0012\u0004\u0012\u0002H\u00020\u0004:\u0004î\u0001ï\u0001B#\b\u0007\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0006\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u0010\u0010n\u001a\u00020o2\u0006\u0010p\u001a\u00020qH\u0002J\u0014\u0010r\u001a\u00020o2\f\b\u0001\u0010s\u001a\u00020t\"\u00020\u0006J\u0014\u0010u\u001a\u00020o2\f\b\u0001\u0010s\u001a\u00020t\"\u00020\u0006J\u0017\u0010v\u001a\u00020o2\b\b\u0001\u0010\u0007\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010wJ\u001f\u0010v\u001a\u00020o2\b\b\u0001\u0010x\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010yJ \u0010v\u001a\u00020o2\b\b\u0001\u0010x\u001a\u00020\u00062\f\u0010z\u001a\b\u0012\u0004\u0012\u00028\u00000{H\u0016J\u0018\u0010v\u001a\u00020o2\u000e\b\u0001\u0010z\u001a\b\u0012\u0004\u0012\u00028\u00000{H\u0016J%\u0010|\u001a\u00020\u00062\u0006\u0010}\u001a\u00020~2\b\b\u0002\u0010\u007f\u001a\u00020\u00062\t\b\u0002\u0010\u0080\u0001\u001a\u00020\u0006H\u0007J&\u0010\u0081\u0001\u001a\u00020\u00062\u0006\u0010}\u001a\u00020~2\b\b\u0002\u0010\u007f\u001a\u00020\u00062\t\b\u0002\u0010\u0080\u0001\u001a\u00020\u0006H\u0007J!\u0010\u0082\u0001\u001a\u00020o2\u0007\u0010\u0083\u0001\u001a\u00028\u00012\u0007\u0010\u0084\u0001\u001a\u00020\u0006H\u0014¢\u0006\u0003\u0010\u0085\u0001J\t\u0010\u0086\u0001\u001a\u00020oH\u0002J\u0012\u0010\u0087\u0001\u001a\u00020o2\u0007\u0010\u0088\u0001\u001a\u00020\u0006H\u0004J \u0010\u0089\u0001\u001a\u00020o2\u0006\u0010p\u001a\u00028\u00012\u0007\u0010\u008a\u0001\u001a\u00028\u0000H$¢\u0006\u0003\u0010\u008b\u0001J1\u0010\u0089\u0001\u001a\u00020o2\u0006\u0010p\u001a\u00028\u00012\u0007\u0010\u008a\u0001\u001a\u00028\u00002\u000f\u0010\u008c\u0001\u001a\n\u0012\u0005\u0012\u00030\u008e\u00010\u008d\u0001H\u0014¢\u0006\u0003\u0010\u008f\u0001J'\u0010\u0090\u0001\u001a\u0004\u0018\u00018\u00012\f\u0010\u0091\u0001\u001a\u0007\u0012\u0002\b\u00030\u0092\u00012\u0006\u0010}\u001a\u00020~H\u0002¢\u0006\u0003\u0010\u0093\u0001J\u0017\u0010\u0094\u0001\u001a\u00028\u00012\u0006\u0010}\u001a\u00020~H\u0014¢\u0006\u0003\u0010\u0095\u0001J#\u0010\u0094\u0001\u001a\u00028\u00012\b\u0010\u0096\u0001\u001a\u00030\u0097\u00012\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u0014¢\u0006\u0003\u0010\u0098\u0001J\r\u0010\u0099\u0001\u001a\b\u0012\u0004\u0012\u00020\u00060\u0018J\r\u0010\u009a\u0001\u001a\b\u0012\u0004\u0012\u00020\u00060\u0018J\t\u0010\u009b\u0001\u001a\u00020\u0006H\u0014J\u0011\u0010\u009c\u0001\u001a\u00020\u00062\u0006\u0010x\u001a\u00020\u0006H\u0014J\u000f\u0010\u009d\u0001\u001a\b\u0012\u0004\u0012\u00028\u00000OH\u0007J\r\u0010\u009e\u0001\u001a\b\u0012\u0004\u0012\u00028\u00000OJ\u001e\u0010\u009f\u0001\u001a\t\u0012\u0002\b\u0003\u0018\u00010\u0092\u00012\f\u0010\u0091\u0001\u001a\u0007\u0012\u0002\b\u00030\u0092\u0001H\u0002J\u0019\u0010 \u0001\u001a\u00028\u00002\b\b\u0001\u0010x\u001a\u00020\u0006H\u0016¢\u0006\u0003\u0010¡\u0001J\t\u0010¢\u0001\u001a\u00020\u0006H\u0016J\u0012\u0010£\u0001\u001a\u00030¤\u00012\u0006\u0010x\u001a\u00020\u0006H\u0016J\u001b\u0010¥\u0001\u001a\u0004\u0018\u00018\u00002\b\b\u0001\u0010x\u001a\u00020\u0006H\u0016¢\u0006\u0003\u0010¡\u0001J\u001a\u0010¦\u0001\u001a\u00020\u00062\t\u0010\u008a\u0001\u001a\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0003\u0010§\u0001J\u0011\u0010¨\u0001\u001a\u00020\u00062\u0006\u0010x\u001a\u00020\u0006H\u0016J\t\u0010©\u0001\u001a\u0004\u0018\u00010ZJ\t\u0010ª\u0001\u001a\u0004\u0018\u00010\\J\t\u0010«\u0001\u001a\u0004\u0018\u00010^J\t\u0010¬\u0001\u001a\u0004\u0018\u00010`J\u001c\u0010\u00ad\u0001\u001a\u0004\u0018\u00010~2\u0006\u0010x\u001a\u00020\u00062\t\b\u0001\u0010®\u0001\u001a\u00020\u0006J\u0007\u0010¯\u0001\u001a\u00020\u0012J\u0007\u0010°\u0001\u001a\u00020\u0012J\u0007\u0010±\u0001\u001a\u00020\u0012J\u0012\u0010²\u0001\u001a\u00020\u00122\u0007\u0010³\u0001\u001a\u00020\u0006H\u0014J\u0011\u0010´\u0001\u001a\u00020o2\u0006\u0010e\u001a\u00020fH\u0016J\u001f\u0010µ\u0001\u001a\u00020o2\u0006\u0010p\u001a\u00028\u00012\u0006\u0010x\u001a\u00020\u0006H\u0016¢\u0006\u0003\u0010\u0085\u0001J/\u0010µ\u0001\u001a\u00020o2\u0006\u0010p\u001a\u00028\u00012\u0006\u0010x\u001a\u00020\u00062\u000e\u0010\u008c\u0001\u001a\t\u0012\u0005\u0012\u00030\u008e\u00010\bH\u0016¢\u0006\u0003\u0010¶\u0001J\"\u0010·\u0001\u001a\u00028\u00012\b\u0010\u0096\u0001\u001a\u00030\u0097\u00012\u0007\u0010\u0084\u0001\u001a\u00020\u0006H\u0014¢\u0006\u0003\u0010\u0098\u0001J\"\u0010¸\u0001\u001a\u00028\u00012\b\u0010\u0096\u0001\u001a\u00030\u0097\u00012\u0007\u0010\u0084\u0001\u001a\u00020\u0006H\u0016¢\u0006\u0003\u0010\u0098\u0001J\u0011\u0010¹\u0001\u001a\u00020o2\u0006\u0010e\u001a\u00020fH\u0016J!\u0010º\u0001\u001a\u00020o2\u0007\u0010\u0083\u0001\u001a\u00028\u00012\u0007\u0010\u0084\u0001\u001a\u00020\u0006H\u0014¢\u0006\u0003\u0010\u0085\u0001J\u0017\u0010»\u0001\u001a\u00020o2\u0006\u0010p\u001a\u00028\u0001H\u0016¢\u0006\u0003\u0010¼\u0001J\u0016\u0010½\u0001\u001a\u00020o2\u0006\u0010\u0007\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010wJ\u0013\u0010½\u0001\u001a\u00020o2\b\b\u0001\u0010x\u001a\u00020\u0006H\u0017J\u0007\u0010¾\u0001\u001a\u00020oJ\u0007\u0010¿\u0001\u001a\u00020oJ\u0013\u0010À\u0001\u001a\u00020o2\b\b\u0001\u0010x\u001a\u00020\u0006H\u0016J\u0007\u0010Á\u0001\u001a\u00020oJ\u0010\u0010Â\u0001\u001a\u00020o2\u0007\u0010Ã\u0001\u001a\u00020~J\u0010\u0010Ä\u0001\u001a\u00020o2\u0007\u0010Å\u0001\u001a\u00020~J\u0017\u0010Æ\u0001\u001a\u00020o2\f\u0010z\u001a\b\u0012\u0004\u0012\u00028\u00000{H\u0017J\u0011\u0010Ç\u0001\u001a\u00020o2\b\u0010È\u0001\u001a\u00030É\u0001J \u0010Ê\u0001\u001a\u00020o2\b\b\u0001\u0010\u007f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010yJ\u0017\u0010Ë\u0001\u001a\u00020o2\u000e\u0010Ì\u0001\u001a\t\u0012\u0004\u0012\u00028\u00000Í\u0001J\u0017\u0010Î\u0001\u001a\u00020o2\u000e\u0010Ï\u0001\u001a\t\u0012\u0004\u0012\u00028\u00000Ð\u0001J$\u0010Ñ\u0001\u001a\u00020o2\n\b\u0001\u0010Ò\u0001\u001a\u00030Ó\u00012\r\u0010Ô\u0001\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0016J(\u0010Ñ\u0001\u001a\u00020o2\u000f\u0010Ô\u0001\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\b2\f\b\u0002\u0010Õ\u0001\u001a\u0005\u0018\u00010Ö\u0001H\u0017J\u0010\u0010×\u0001\u001a\u00020o2\u0007\u0010Ø\u0001\u001a\u00020~J\u000f\u0010×\u0001\u001a\u00020o2\u0006\u0010\u0005\u001a\u00020\u0006J&\u0010Ù\u0001\u001a\u00020\u00062\u0006\u0010}\u001a\u00020~2\b\b\u0002\u0010\u007f\u001a\u00020\u00062\t\b\u0002\u0010\u0080\u0001\u001a\u00020\u0006H\u0007J\u0011\u0010Ú\u0001\u001a\u00020o2\u0006\u0010p\u001a\u00020qH\u0014J\u0012\u0010Û\u0001\u001a\u00020o2\t\u0010Ü\u0001\u001a\u0004\u0018\u00010bJ&\u0010Ý\u0001\u001a\u00020\u00062\u0006\u0010}\u001a\u00020~2\b\b\u0002\u0010\u007f\u001a\u00020\u00062\t\b\u0002\u0010\u0080\u0001\u001a\u00020\u0006H\u0007J\u001a\u0010Þ\u0001\u001a\u00020o2\u000f\u0010Ô\u0001\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010{H\u0016J\u0019\u0010ß\u0001\u001a\u00020o2\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\bH\u0017J\u001a\u0010à\u0001\u001a\u00020o2\u000f\u0010Ô\u0001\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\bH\u0016J\u001a\u0010á\u0001\u001a\u00020o2\u0007\u0010â\u0001\u001a\u00020~2\u0006\u0010x\u001a\u00020\u0006H\u0014J\u0012\u0010ã\u0001\u001a\u00020o2\t\u0010ä\u0001\u001a\u0004\u0018\u00010ZJ\u001a\u0010å\u0001\u001a\u00020\u00122\u0007\u0010â\u0001\u001a\u00020~2\u0006\u0010x\u001a\u00020\u0006H\u0014J\u0012\u0010æ\u0001\u001a\u00020o2\t\u0010ä\u0001\u001a\u0004\u0018\u00010\\J\u001a\u0010ç\u0001\u001a\u00020o2\u0007\u0010â\u0001\u001a\u00020~2\u0006\u0010x\u001a\u00020\u0006H\u0014J\u0012\u0010è\u0001\u001a\u00020o2\t\u0010ä\u0001\u001a\u0004\u0018\u00010^J\u001a\u0010é\u0001\u001a\u00020\u00122\u0007\u0010â\u0001\u001a\u00020~2\u0006\u0010x\u001a\u00020\u0006H\u0014J\u0012\u0010ê\u0001\u001a\u00020o2\t\u0010ä\u0001\u001a\u0004\u0018\u00010`J\u001b\u0010ë\u0001\u001a\u00020o2\b\u0010ì\u0001\u001a\u00030í\u00012\u0006\u0010\u007f\u001a\u00020\u0006H\u0014R(\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u000b@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00060\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00060\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u001a\u001a\u00020\u001b8F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR0\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\b2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\b@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u0011\u0010#\u001a\u00020$8F¢\u0006\u0006\u001a\u0004\b%\u0010&R\u0013\u0010'\u001a\u0004\u0018\u00010(8F¢\u0006\u0006\u001a\u0004\b)\u0010*R\u0013\u0010+\u001a\u0004\u0018\u00010,8F¢\u0006\u0006\u001a\u0004\b-\u0010.R\u0011\u0010/\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b0\u00101R\u001a\u00102\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u0014\"\u0004\b4\u0010\u0016R\u0011\u00105\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b6\u00101R\u001a\u00107\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u0014\"\u0004\b9\u0010\u0016R\u0013\u0010:\u001a\u0004\u0018\u00010,8F¢\u0006\u0006\u001a\u0004\b;\u0010.R\u0011\u0010<\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b=\u00101R\u001a\u0010>\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010\u0014\"\u0004\b@\u0010\u0016R\u0011\u0010A\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\bB\u00101R\u001a\u0010C\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010\u0014\"\u0004\bE\u0010\u0016R\u001a\u0010F\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010\u0014\"\u0004\bG\u0010\u0016R\u001a\u0010H\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010\u0014\"\u0004\bI\u0010\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010J\u001a\u00020K8F¢\u0006\u0006\u001a\u0004\bL\u0010MR\u0016\u0010N\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010OX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010P\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010Q\u001a\u00020(X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010R\u001a\u00020,X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010S\u001a\u00020,X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010T\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010U\u001a\u0004\u0018\u00010KX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u0010M\"\u0004\bW\u0010XR\u0010\u0010Y\u001a\u0004\u0018\u00010ZX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010[\u001a\u0004\u0018\u00010\\X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010]\u001a\u0004\u0018\u00010^X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010_\u001a\u0004\u0018\u00010`X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010a\u001a\u0004\u0018\u00010bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010c\u001a\u0004\u0018\u00010dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010e\u001a\u00020f8F¢\u0006\u0006\u001a\u0004\bg\u0010hR\"\u0010i\u001a\u0004\u0018\u00010f2\b\u0010\u001e\u001a\u0004\u0018\u00010f@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\bj\u0010hR\u0011\u0010k\u001a\u00020d8F¢\u0006\u0006\u001a\u0004\bl\u0010m¨\u0006ð\u0001"}, d2 = {"Lcom/chad/library/adapter/base/BaseQuickAdapter;", ExifInterface.GPS_DIRECTION_TRUE, "VH", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "layoutResId", "", "data", "", "(ILjava/util/List;)V", "value", "Lcom/chad/library/adapter/base/animation/BaseAnimation;", "adapterAnimation", "getAdapterAnimation", "()Lcom/chad/library/adapter/base/animation/BaseAnimation;", "setAdapterAnimation", "(Lcom/chad/library/adapter/base/animation/BaseAnimation;)V", "animationEnable", "", "getAnimationEnable", "()Z", "setAnimationEnable", "(Z)V", "childClickViewIds", "Ljava/util/LinkedHashSet;", "childLongClickViewIds", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "<set-?>", "getData", "()Ljava/util/List;", "setData$com_github_CymChad_brvah", "(Ljava/util/List;)V", "draggableModule", "Lcom/chad/library/adapter/base/module/BaseDraggableModule;", "getDraggableModule", "()Lcom/chad/library/adapter/base/module/BaseDraggableModule;", "emptyLayout", "Landroid/widget/FrameLayout;", "getEmptyLayout", "()Landroid/widget/FrameLayout;", "footerLayout", "Landroid/widget/LinearLayout;", "getFooterLayout", "()Landroid/widget/LinearLayout;", "footerLayoutCount", "getFooterLayoutCount", "()I", "footerViewAsFlow", "getFooterViewAsFlow", "setFooterViewAsFlow", "footerViewPosition", "getFooterViewPosition", "footerWithEmptyEnable", "getFooterWithEmptyEnable", "setFooterWithEmptyEnable", "headerLayout", "getHeaderLayout", "headerLayoutCount", "getHeaderLayoutCount", "headerViewAsFlow", "getHeaderViewAsFlow", "setHeaderViewAsFlow", "headerViewPosition", "getHeaderViewPosition", "headerWithEmptyEnable", "getHeaderWithEmptyEnable", "setHeaderWithEmptyEnable", "isAnimationFirstOnly", "setAnimationFirstOnly", "isUseEmpty", "setUseEmpty", "loadMoreModule", "Lcom/chad/library/adapter/base/module/BaseLoadMoreModule;", "getLoadMoreModule", "()Lcom/chad/library/adapter/base/module/BaseLoadMoreModule;", "mDiffHelper", "Lcom/chad/library/adapter/base/diff/BrvahAsyncDiffer;", "mDraggableModule", "mEmptyLayout", "mFooterLayout", "mHeaderLayout", "mLastPosition", "mLoadMoreModule", "getMLoadMoreModule$com_github_CymChad_brvah", "setMLoadMoreModule$com_github_CymChad_brvah", "(Lcom/chad/library/adapter/base/module/BaseLoadMoreModule;)V", "mOnItemChildClickListener", "Lcom/chad/library/adapter/base/listener/OnItemChildClickListener;", "mOnItemChildLongClickListener", "Lcom/chad/library/adapter/base/listener/OnItemChildLongClickListener;", "mOnItemClickListener", "Lcom/chad/library/adapter/base/listener/OnItemClickListener;", "mOnItemLongClickListener", "Lcom/chad/library/adapter/base/listener/OnItemLongClickListener;", "mSpanSizeLookup", "Lcom/chad/library/adapter/base/listener/GridSpanSizeLookup;", "mUpFetchModule", "Lcom/chad/library/adapter/base/module/BaseUpFetchModule;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "recyclerViewOrNull", "getRecyclerViewOrNull", "upFetchModule", "getUpFetchModule", "()Lcom/chad/library/adapter/base/module/BaseUpFetchModule;", "addAnimation", "", "holder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "addChildClickViewIds", "viewIds", "", "addChildLongClickViewIds", "addData", "(Ljava/lang/Object;)V", "position", "(ILjava/lang/Object;)V", "newData", "", "addFooterView", "view", "Landroid/view/View;", FirebaseAnalytics.Param.INDEX, "orientation", "addHeaderView", "bindViewClickListener", "viewHolder", "viewType", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;I)V", "checkModule", "compatibilityDataSizeChanged", "size", "convert", "item", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Ljava/lang/Object;)V", "payloads", "", "", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Ljava/lang/Object;Ljava/util/List;)V", "createBaseGenericKInstance", "z", "Ljava/lang/Class;", "(Ljava/lang/Class;Landroid/view/View;)Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "createBaseViewHolder", "(Landroid/view/View;)Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "parent", "Landroid/view/ViewGroup;", "(Landroid/view/ViewGroup;I)Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "getChildClickViewIds", "getChildLongClickViewIds", "getDefItemCount", "getDefItemViewType", "getDiffHelper", "getDiffer", "getInstancedGenericKClass", "getItem", "(I)Ljava/lang/Object;", "getItemCount", "getItemId", "", "getItemOrNull", "getItemPosition", "(Ljava/lang/Object;)I", "getItemViewType", "getOnItemChildClickListener", "getOnItemChildLongClickListener", "getOnItemClickListener", "getOnItemLongClickListener", "getViewByPosition", "viewId", "hasEmptyView", "hasFooterLayout", "hasHeaderLayout", "isFixedViewType", "type", "onAttachedToRecyclerView", "onBindViewHolder", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;ILjava/util/List;)V", "onCreateDefViewHolder", "onCreateViewHolder", "onDetachedFromRecyclerView", "onItemViewHolderCreated", "onViewAttachedToWindow", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;)V", DiscoverItems.Item.REMOVE_ACTION, "removeAllFooterView", "removeAllHeaderView", "removeAt", "removeEmptyView", "removeFooterView", "footer", "removeHeaderView", Header.ELEMENT, "replaceData", "setAnimationWithDefault", "animationType", "Lcom/chad/library/adapter/base/BaseQuickAdapter$AnimationType;", "setData", "setDiffCallback", "diffCallback", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "setDiffConfig", "config", "Lcom/chad/library/adapter/base/diff/BrvahAsyncDifferConfig;", "setDiffNewData", "diffResult", "Landroidx/recyclerview/widget/DiffUtil$DiffResult;", "list", "commitCallback", "Ljava/lang/Runnable;", "setEmptyView", "emptyView", "setFooterView", "setFullSpan", "setGridSpanSizeLookup", "spanSizeLookup", "setHeaderView", "setList", "setNewData", "setNewInstance", "setOnItemChildClick", PSOProgramService.VS_Key, "setOnItemChildClickListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnItemChildLongClick", "setOnItemChildLongClickListener", "setOnItemClick", "setOnItemClickListener", "setOnItemLongClick", "setOnItemLongClickListener", "startAnim", "anim", "Landroid/animation/Animator;", "AnimationType", "Companion", "com.github.CymChad.brvah"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class BaseQuickAdapter<T, VH extends BaseViewHolder> extends RecyclerView.Adapter<VH> {
    public final int a;

    @NotNull
    public List<T> b;
    public boolean c;
    public boolean d;
    public boolean e;
    public boolean f;
    public boolean g;
    public boolean h;
    public boolean i;

    @Nullable
    public oq j;
    public LinearLayout k;
    public LinearLayout l;
    public FrameLayout m;
    public int n;

    @Nullable
    public yq o;

    @Nullable
    public br p;

    @Nullable
    public cr q;

    @Nullable
    public zq r;

    @Nullable
    public ar s;

    @Nullable
    public hr t;

    @Nullable
    public fr u;

    @Nullable
    public gr v;

    @Nullable
    public RecyclerView w;

    @NotNull
    public final LinkedHashSet<Integer> x;

    @NotNull
    public final LinkedHashSet<Integer> y;

    public /* synthetic */ BaseQuickAdapter(int i, List list, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i2 & 2) != 0 ? null : list);
    }

    public static /* synthetic */ int u(BaseQuickAdapter baseQuickAdapter, View view, int i, int i2, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addFooterView");
        }
        if ((i3 & 2) != 0) {
            i = -1;
        }
        if ((i3 & 4) != 0) {
            i2 = 1;
        }
        return baseQuickAdapter.t(view, i, i2);
    }

    public static final void w(BaseViewHolder viewHolder, BaseQuickAdapter this$0, View v) {
        Intrinsics.checkNotNullParameter(viewHolder, "$viewHolder");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int bindingAdapterPosition = viewHolder.getBindingAdapterPosition();
        if (bindingAdapterPosition == -1) {
            return;
        }
        int iQ = bindingAdapterPosition - this$0.Q();
        Intrinsics.checkNotNullExpressionValue(v, "v");
        this$0.z0(v, iQ);
    }

    public static final boolean x(BaseViewHolder viewHolder, BaseQuickAdapter this$0, View v) {
        Intrinsics.checkNotNullParameter(viewHolder, "$viewHolder");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int bindingAdapterPosition = viewHolder.getBindingAdapterPosition();
        if (bindingAdapterPosition == -1) {
            return false;
        }
        int iQ = bindingAdapterPosition - this$0.Q();
        Intrinsics.checkNotNullExpressionValue(v, "v");
        return this$0.B0(v, iQ);
    }

    public static final void y(BaseViewHolder viewHolder, BaseQuickAdapter this$0, View v) {
        Intrinsics.checkNotNullParameter(viewHolder, "$viewHolder");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int bindingAdapterPosition = viewHolder.getBindingAdapterPosition();
        if (bindingAdapterPosition == -1) {
            return;
        }
        int iQ = bindingAdapterPosition - this$0.Q();
        Intrinsics.checkNotNullExpressionValue(v, "v");
        this$0.D0(v, iQ);
    }

    public static final boolean z(BaseViewHolder viewHolder, BaseQuickAdapter this$0, View v) {
        Intrinsics.checkNotNullParameter(viewHolder, "$viewHolder");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int bindingAdapterPosition = viewHolder.getBindingAdapterPosition();
        if (bindingAdapterPosition == -1) {
            return false;
        }
        int iQ = bindingAdapterPosition - this$0.Q();
        Intrinsics.checkNotNullExpressionValue(v, "v");
        return this$0.F0(v, iQ);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void A() {
        if (this instanceof jr) {
            this.v = ((jr) this).a(this);
        }
        if (this instanceof kr) {
            this.t = ((kr) this).a(this);
        }
        if (this instanceof ir) {
            this.u = ((ir) this).a(this);
        }
    }

    public final void A0(@Nullable zq zqVar) {
        this.r = zqVar;
    }

    public final void B(int i) {
        if (this.b.size() == i) {
            notifyDataSetChanged();
        }
    }

    public boolean B0(@NotNull View v, int i) {
        Intrinsics.checkNotNullParameter(v, "v");
        ar arVar = this.s;
        if (arVar != null) {
            return arVar.M1(this, v, i);
        }
        return false;
    }

    public abstract void C(@NotNull VH vh, T t);

    public final void C0(@Nullable ar arVar) {
        this.s = arVar;
    }

    public void D(@NotNull VH holder, T t, @NotNull List<? extends Object> payloads) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
    }

    public void D0(@NotNull View v, int i) {
        Intrinsics.checkNotNullParameter(v, "v");
        br brVar = this.p;
        if (brVar != null) {
            brVar.a(this, v, i);
        }
    }

    public final VH E(Class<?> cls, View view) throws IllegalAccessException, NoSuchMethodException, InstantiationException, SecurityException, IllegalArgumentException, InvocationTargetException {
        try {
            if (!cls.isMemberClass() || Modifier.isStatic(cls.getModifiers())) {
                Constructor<?> declaredConstructor = cls.getDeclaredConstructor(View.class);
                Intrinsics.checkNotNullExpressionValue(declaredConstructor, "z.getDeclaredConstructor(View::class.java)");
                declaredConstructor.setAccessible(true);
                Object objNewInstance = declaredConstructor.newInstance(view);
                if (objNewInstance != null) {
                    return (VH) objNewInstance;
                }
                throw new NullPointerException("null cannot be cast to non-null type VH of com.chad.library.adapter.base.BaseQuickAdapter");
            }
            Constructor<?> declaredConstructor2 = cls.getDeclaredConstructor(getClass(), View.class);
            Intrinsics.checkNotNullExpressionValue(declaredConstructor2, "z.getDeclaredConstructor…aClass, View::class.java)");
            declaredConstructor2.setAccessible(true);
            Object objNewInstance2 = declaredConstructor2.newInstance(this, view);
            if (objNewInstance2 != null) {
                return (VH) objNewInstance2;
            }
            throw new NullPointerException("null cannot be cast to non-null type VH of com.chad.library.adapter.base.BaseQuickAdapter");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return null;
        } catch (InstantiationException e2) {
            e2.printStackTrace();
            return null;
        } catch (NoSuchMethodException e3) {
            e3.printStackTrace();
            return null;
        } catch (InvocationTargetException e4) {
            e4.printStackTrace();
            return null;
        }
    }

    public final void E0(@Nullable br brVar) {
        this.p = brVar;
    }

    @NotNull
    public VH F(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        Class<?> clsS = null;
        for (Class<?> superclass = getClass(); clsS == null && superclass != null; superclass = superclass.getSuperclass()) {
            clsS = S(superclass);
        }
        VH vh = clsS == null ? (VH) new BaseViewHolder(view) : (VH) E(clsS, view);
        return vh == null ? (VH) new BaseViewHolder(view) : vh;
    }

    public boolean F0(@NotNull View v, int i) {
        Intrinsics.checkNotNullParameter(v, "v");
        cr crVar = this.q;
        if (crVar != null) {
            return crVar.J0(this, v, i);
        }
        return false;
    }

    @NotNull
    public VH G(@NotNull ViewGroup parent, @LayoutRes int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        return (VH) F(mr.a(parent, i));
    }

    public final void G0(@Nullable cr crVar) {
        this.q = crVar;
    }

    @NotNull
    public final LinkedHashSet<Integer> H() {
        return this.x;
    }

    public void H0(@NotNull Animator anim, int i) {
        Intrinsics.checkNotNullParameter(anim, "anim");
        anim.start();
    }

    @NotNull
    public final LinkedHashSet<Integer> I() {
        return this.y;
    }

    @NotNull
    public final Context J() {
        Context context = Y().getContext();
        Intrinsics.checkNotNullExpressionValue(context, "recyclerView.context");
        return context;
    }

    @NotNull
    public final List<T> K() {
        return this.b;
    }

    public int L() {
        return this.b.size();
    }

    public int M(int i) {
        return super.getItemViewType(i);
    }

    public final int N() {
        return b0() ? 1 : 0;
    }

    /* renamed from: O, reason: from getter */
    public final boolean getG() {
        return this.g;
    }

    public final int P() {
        if (!a0()) {
            return Q() + this.b.size();
        }
        int i = 1;
        if (this.c && c0()) {
            i = 2;
        }
        if (this.d) {
            return i;
        }
        return -1;
    }

    public final int Q() {
        return c0() ? 1 : 0;
    }

    /* renamed from: R, reason: from getter */
    public final boolean getF() {
        return this.f;
    }

    public final Class<?> S(Class<?> cls) {
        try {
            Type genericSuperclass = cls.getGenericSuperclass();
            if (!(genericSuperclass instanceof ParameterizedType)) {
                return null;
            }
            Type[] types = ((ParameterizedType) genericSuperclass).getActualTypeArguments();
            Intrinsics.checkNotNullExpressionValue(types, "types");
            for (Type type : types) {
                if (type instanceof Class) {
                    if (BaseViewHolder.class.isAssignableFrom((Class) type)) {
                        return (Class) type;
                    }
                } else if (type instanceof ParameterizedType) {
                    Type rawType = ((ParameterizedType) type).getRawType();
                    if ((rawType instanceof Class) && BaseViewHolder.class.isAssignableFrom((Class) rawType)) {
                        return (Class) rawType;
                    }
                } else {
                    continue;
                }
            }
            return null;
        } catch (TypeNotPresentException e) {
            e.printStackTrace();
            return null;
        } catch (GenericSignatureFormatError e2) {
            e2.printStackTrace();
            return null;
        } catch (MalformedParameterizedTypeException e3) {
            e3.printStackTrace();
            return null;
        }
    }

    @Nullable
    /* renamed from: T, reason: from getter */
    public final gr getV() {
        return this.v;
    }

    @Nullable
    /* renamed from: U, reason: from getter */
    public final zq getR() {
        return this.r;
    }

    @Nullable
    /* renamed from: V, reason: from getter */
    public final ar getS() {
        return this.s;
    }

    @Nullable
    /* renamed from: W, reason: from getter */
    public final br getP() {
        return this.p;
    }

    @Nullable
    /* renamed from: X, reason: from getter */
    public final cr getQ() {
        return this.q;
    }

    @NotNull
    public final RecyclerView Y() {
        RecyclerView recyclerView = this.w;
        if (recyclerView == null) {
            throw new IllegalStateException("Please get it after onAttachedToRecyclerView()".toString());
        }
        Intrinsics.checkNotNull(recyclerView);
        return recyclerView;
    }

    @Nullable
    public final View Z(int i, @IdRes int i2) {
        BaseViewHolder baseViewHolder;
        RecyclerView recyclerView = this.w;
        if (recyclerView == null || (baseViewHolder = (BaseViewHolder) recyclerView.findViewHolderForLayoutPosition(i)) == null) {
            return null;
        }
        return baseViewHolder.getViewOrNull(i2);
    }

    public final boolean a0() {
        FrameLayout frameLayout = this.m;
        if (frameLayout != null) {
            if (frameLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mEmptyLayout");
                frameLayout = null;
            }
            if (frameLayout.getChildCount() != 0 && this.e) {
                return this.b.isEmpty();
            }
            return false;
        }
        return false;
    }

    public final boolean b0() {
        LinearLayout linearLayout = this.l;
        if (linearLayout == null) {
            return false;
        }
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFooterLayout");
            linearLayout = null;
        }
        return linearLayout.getChildCount() > 0;
    }

    public final boolean c0() {
        LinearLayout linearLayout = this.k;
        if (linearLayout == null) {
            return false;
        }
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHeaderLayout");
            linearLayout = null;
        }
        return linearLayout.getChildCount() > 0;
    }

    public boolean d0(int i) {
        return i == 268436821 || i == 268435729 || i == 268436275 || i == 268436002;
    }

    public T getItem(@IntRange(from = 0) int position) {
        return this.b.get(position);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (!a0()) {
            gr grVar = this.v;
            return Q() + L() + N() + ((grVar == null || !grVar.e()) ? 0 : 1);
        }
        if (this.c && c0()) {
            i = 2;
        }
        return (this.d && b0()) ? i + 1 : i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int position) {
        return position;
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [boolean] */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        if (a0()) {
            boolean z = this.c && c0();
            if (position != 0) {
                return position != 1 ? 268436275 : 268436275;
            }
            if (z) {
                return 268435729;
            }
            return 268436821;
        }
        boolean zC0 = c0();
        if (zC0 && position == 0) {
            return 268435729;
        }
        if (zC0) {
            position--;
        }
        int size = this.b.size();
        return position < size ? M(position) : position - size < b0() ? 268436275 : 268436002;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: i0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull VH holder, int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        hr hrVar = this.t;
        if (hrVar != null) {
            hrVar.a(i);
        }
        gr grVar = this.v;
        if (grVar != null) {
            grVar.a(i);
        }
        switch (holder.getItemViewType()) {
            case 268435729:
            case 268436275:
            case 268436821:
                break;
            case 268436002:
                gr grVar2 = this.v;
                if (grVar2 != null) {
                    grVar2.d().a(holder, i, grVar2.c());
                    break;
                }
                break;
            default:
                C(holder, getItem(i - Q()));
                break;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: j0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull VH holder, int i, @NotNull List<Object> payloads) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        if (payloads.isEmpty()) {
            onBindViewHolder(holder, i);
        }
        hr hrVar = this.t;
        if (hrVar != null) {
            hrVar.a(i);
        }
        gr grVar = this.v;
        if (grVar != null) {
            grVar.a(i);
        }
        switch (holder.getItemViewType()) {
            case 268435729:
            case 268436275:
            case 268436821:
                break;
            case 268436002:
                gr grVar2 = this.v;
                if (grVar2 != null) {
                    grVar2.d().a(holder, i, grVar2.c());
                    break;
                }
                break;
            default:
                D(holder, getItem(i - Q()), payloads);
                break;
        }
    }

    @NotNull
    public VH k0(@NotNull ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        return (VH) G(parent, this.a);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: l0, reason: merged with bridge method [inline-methods] */
    public VH onCreateViewHolder(@NotNull ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View view = null;
        switch (i) {
            case 268435729:
                LinearLayout linearLayout = this.k;
                if (linearLayout == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mHeaderLayout");
                    linearLayout = null;
                }
                ViewParent parent2 = linearLayout.getParent();
                if (parent2 instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) parent2;
                    LinearLayout linearLayout2 = this.k;
                    if (linearLayout2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mHeaderLayout");
                        linearLayout2 = null;
                    }
                    viewGroup.removeView(linearLayout2);
                }
                LinearLayout linearLayout3 = this.k;
                if (linearLayout3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mHeaderLayout");
                } else {
                    view = linearLayout3;
                }
                return (VH) F(view);
            case 268436002:
                gr grVar = this.v;
                Intrinsics.checkNotNull(grVar);
                VH vh = (VH) F(grVar.d().b(parent));
                gr grVar2 = this.v;
                Intrinsics.checkNotNull(grVar2);
                grVar2.g(vh);
                return vh;
            case 268436275:
                LinearLayout linearLayout4 = this.l;
                if (linearLayout4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mFooterLayout");
                    linearLayout4 = null;
                }
                ViewParent parent3 = linearLayout4.getParent();
                if (parent3 instanceof ViewGroup) {
                    ViewGroup viewGroup2 = (ViewGroup) parent3;
                    LinearLayout linearLayout5 = this.l;
                    if (linearLayout5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mFooterLayout");
                        linearLayout5 = null;
                    }
                    viewGroup2.removeView(linearLayout5);
                }
                LinearLayout linearLayout6 = this.l;
                if (linearLayout6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mFooterLayout");
                } else {
                    view = linearLayout6;
                }
                return (VH) F(view);
            case 268436821:
                FrameLayout frameLayout = this.m;
                if (frameLayout == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mEmptyLayout");
                    frameLayout = null;
                }
                ViewParent parent4 = frameLayout.getParent();
                if (parent4 instanceof ViewGroup) {
                    ViewGroup viewGroup3 = (ViewGroup) parent4;
                    FrameLayout frameLayout2 = this.m;
                    if (frameLayout2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mEmptyLayout");
                        frameLayout2 = null;
                    }
                    viewGroup3.removeView(frameLayout2);
                }
                FrameLayout frameLayout3 = this.m;
                if (frameLayout3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mEmptyLayout");
                } else {
                    view = frameLayout3;
                }
                return (VH) F(view);
            default:
                VH vh2 = (VH) k0(parent, i);
                v(vh2, i);
                fr frVar = this.u;
                if (frVar != null) {
                    frVar.c(vh2);
                }
                m0(vh2, i);
                return vh2;
        }
    }

    public final void m(RecyclerView.ViewHolder viewHolder) {
        if (this.h) {
            if (!this.i || viewHolder.getLayoutPosition() > this.n) {
                oq nqVar = this.j;
                if (nqVar == null) {
                    nqVar = new nq(0.0f, 1, null);
                }
                View view = viewHolder.itemView;
                Intrinsics.checkNotNullExpressionValue(view, "holder.itemView");
                Animator[] animatorArrA = nqVar.a(view);
                for (Animator animator : animatorArrA) {
                    H0(animator, viewHolder.getLayoutPosition());
                }
                this.n = viewHolder.getLayoutPosition();
            }
        }
    }

    public void m0(@NotNull VH viewHolder, int i) {
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
    }

    public final void n(@IdRes @NotNull int... viewIds) {
        Intrinsics.checkNotNullParameter(viewIds, "viewIds");
        for (int i : viewIds) {
            this.x.add(Integer.valueOf(i));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: n0, reason: merged with bridge method [inline-methods] */
    public void onViewAttachedToWindow(@NotNull VH holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onViewAttachedToWindow(holder);
        if (d0(holder.getItemViewType())) {
            w0(holder);
        } else {
            m(holder);
        }
    }

    public final void o(@IdRes @NotNull int... viewIds) {
        Intrinsics.checkNotNullParameter(viewIds, "viewIds");
        for (int i : viewIds) {
            this.y.add(Integer.valueOf(i));
        }
    }

    public void o0(T t) {
        int iIndexOf = this.b.indexOf(t);
        if (iIndexOf == -1) {
            return;
        }
        q0(iIndexOf);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(@NotNull RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onAttachedToRecyclerView(recyclerView);
        this.w = recyclerView;
        fr frVar = this.u;
        if (frVar != null) {
            frVar.a(recyclerView);
        }
        final RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
            final GridLayoutManager.SpanSizeLookup spanSizeLookup = gridLayoutManager.getSpanSizeLookup();
            gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup(this) { // from class: com.chad.library.adapter.base.BaseQuickAdapter.onAttachedToRecyclerView.1
                public final /* synthetic */ BaseQuickAdapter<T, VH> a;

                {
                    this.a = this;
                }

                @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
                public int getSpanSize(int position) {
                    int itemViewType = this.a.getItemViewType(position);
                    if (itemViewType == 268435729 && this.a.getF()) {
                        return 1;
                    }
                    if (itemViewType == 268436275 && this.a.getG()) {
                        return 1;
                    }
                    if (this.a.o == null) {
                        return this.a.d0(itemViewType) ? ((GridLayoutManager) layoutManager).getSpanCount() : spanSizeLookup.getSpanSize(position);
                    }
                    if (this.a.d0(itemViewType)) {
                        return ((GridLayoutManager) layoutManager).getSpanCount();
                    }
                    yq yqVar = this.a.o;
                    Intrinsics.checkNotNull(yqVar);
                    return yqVar.a((GridLayoutManager) layoutManager, itemViewType, position - this.a.Q());
                }
            });
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(@NotNull RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onDetachedFromRecyclerView(recyclerView);
        this.w = null;
    }

    public void p(@IntRange(from = 0) int i, T t) {
        this.b.add(i, t);
        notifyItemInserted(i + Q());
        B(1);
    }

    public final void p0() {
        if (b0()) {
            LinearLayout linearLayout = this.l;
            if (linearLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mFooterLayout");
                linearLayout = null;
            }
            linearLayout.removeAllViews();
            int iP = P();
            if (iP != -1) {
                notifyItemRemoved(iP);
            }
        }
    }

    public void q(@IntRange(from = 0) int i, @NotNull Collection<? extends T> newData) {
        Intrinsics.checkNotNullParameter(newData, "newData");
        this.b.addAll(i, newData);
        notifyItemRangeInserted(i + Q(), newData.size());
        B(newData.size());
    }

    public void q0(@IntRange(from = 0) int i) {
        if (i >= this.b.size()) {
            return;
        }
        this.b.remove(i);
        int iQ = i + Q();
        notifyItemRemoved(iQ);
        B(0);
        notifyItemRangeChanged(iQ, this.b.size() - iQ);
    }

    public void r(@NonNull T t) {
        this.b.add(t);
        notifyItemInserted(this.b.size() + Q());
        B(1);
    }

    public final void r0(@NotNull List<T> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.b = list;
    }

    public void s(@NonNull @NotNull Collection<? extends T> newData) {
        Intrinsics.checkNotNullParameter(newData, "newData");
        this.b.addAll(newData);
        notifyItemRangeInserted((this.b.size() - newData.size()) + Q(), newData.size());
        B(newData.size());
    }

    public final void s0(@NotNull DiffUtil.ItemCallback<T> diffCallback) {
        Intrinsics.checkNotNullParameter(diffCallback, "diffCallback");
        t0(new sq.a(diffCallback).a());
    }

    @JvmOverloads
    public final int t(@NotNull View view, int i, int i2) {
        int iP;
        Intrinsics.checkNotNullParameter(view, "view");
        LinearLayout linearLayout = null;
        if (this.l == null) {
            LinearLayout linearLayout2 = new LinearLayout(view.getContext());
            this.l = linearLayout2;
            linearLayout2.setOrientation(i2);
            LinearLayout linearLayout3 = this.l;
            if (linearLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mFooterLayout");
                linearLayout3 = null;
            }
            linearLayout3.setLayoutParams(i2 == 1 ? new RecyclerView.LayoutParams(-1, -2) : new RecyclerView.LayoutParams(-2, -1));
        }
        LinearLayout linearLayout4 = this.l;
        if (linearLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFooterLayout");
            linearLayout4 = null;
        }
        int childCount = linearLayout4.getChildCount();
        if (i < 0 || i > childCount) {
            i = childCount;
        }
        LinearLayout linearLayout5 = this.l;
        if (linearLayout5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFooterLayout");
            linearLayout5 = null;
        }
        linearLayout5.addView(view, i);
        LinearLayout linearLayout6 = this.l;
        if (linearLayout6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFooterLayout");
        } else {
            linearLayout = linearLayout6;
        }
        if (linearLayout.getChildCount() == 1 && (iP = P()) != -1) {
            notifyItemInserted(iP);
        }
        return i;
    }

    public final void t0(@NotNull sq<T> config) {
        Intrinsics.checkNotNullParameter(config, "config");
        new rq(this, config);
    }

    public final void u0(int i) {
        RecyclerView recyclerView = this.w;
        if (recyclerView != null) {
            View view = LayoutInflater.from(recyclerView.getContext()).inflate(i, (ViewGroup) recyclerView, false);
            Intrinsics.checkNotNullExpressionValue(view, "view");
            v0(view);
        }
    }

    public void v(@NotNull final VH viewHolder, int i) {
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        if (this.p != null) {
            viewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: dc.lq
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BaseQuickAdapter.y(viewHolder, this, view);
                }
            });
        }
        if (this.q != null) {
            viewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() { // from class: dc.jq
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view) {
                    return BaseQuickAdapter.z(viewHolder, this, view);
                }
            });
        }
        if (this.r != null) {
            Iterator<Integer> it = H().iterator();
            while (it.hasNext()) {
                Integer id = it.next();
                View view = viewHolder.itemView;
                Intrinsics.checkNotNullExpressionValue(id, "id");
                View viewFindViewById = view.findViewById(id.intValue());
                if (viewFindViewById != null) {
                    Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById<View>(id)");
                    if (!viewFindViewById.isClickable()) {
                        viewFindViewById.setClickable(true);
                    }
                    viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: dc.mq
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view2) {
                            BaseQuickAdapter.w(viewHolder, this, view2);
                        }
                    });
                }
            }
        }
        if (this.s != null) {
            Iterator<Integer> it2 = I().iterator();
            while (it2.hasNext()) {
                Integer id2 = it2.next();
                View view2 = viewHolder.itemView;
                Intrinsics.checkNotNullExpressionValue(id2, "id");
                View viewFindViewById2 = view2.findViewById(id2.intValue());
                if (viewFindViewById2 != null) {
                    Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById<View>(id)");
                    if (!viewFindViewById2.isLongClickable()) {
                        viewFindViewById2.setLongClickable(true);
                    }
                    viewFindViewById2.setOnLongClickListener(new View.OnLongClickListener() { // from class: dc.kq
                        @Override // android.view.View.OnLongClickListener
                        public final boolean onLongClick(View view3) {
                            return BaseQuickAdapter.x(viewHolder, this, view3);
                        }
                    });
                }
            }
        }
    }

    public final void v0(@NotNull View emptyView) {
        boolean z;
        Intrinsics.checkNotNullParameter(emptyView, "emptyView");
        int itemCount = getItemCount();
        int i = 0;
        FrameLayout frameLayout = null;
        if (this.m == null) {
            FrameLayout frameLayout2 = new FrameLayout(emptyView.getContext());
            this.m = frameLayout2;
            if (frameLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mEmptyLayout");
                frameLayout2 = null;
            }
            ViewGroup.LayoutParams layoutParams = emptyView.getLayoutParams();
            frameLayout2.setLayoutParams(layoutParams != null ? new ViewGroup.LayoutParams(layoutParams.width, layoutParams.height) : new ViewGroup.LayoutParams(-1, -1));
            z = true;
        } else {
            ViewGroup.LayoutParams layoutParams2 = emptyView.getLayoutParams();
            if (layoutParams2 != null) {
                FrameLayout frameLayout3 = this.m;
                if (frameLayout3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mEmptyLayout");
                    frameLayout3 = null;
                }
                ViewGroup.LayoutParams layoutParams3 = frameLayout3.getLayoutParams();
                layoutParams3.width = layoutParams2.width;
                layoutParams3.height = layoutParams2.height;
                FrameLayout frameLayout4 = this.m;
                if (frameLayout4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mEmptyLayout");
                    frameLayout4 = null;
                }
                frameLayout4.setLayoutParams(layoutParams3);
            }
            z = false;
        }
        FrameLayout frameLayout5 = this.m;
        if (frameLayout5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEmptyLayout");
            frameLayout5 = null;
        }
        frameLayout5.removeAllViews();
        FrameLayout frameLayout6 = this.m;
        if (frameLayout6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEmptyLayout");
        } else {
            frameLayout = frameLayout6;
        }
        frameLayout.addView(emptyView);
        this.e = true;
        if (z && a0()) {
            if (this.c && c0()) {
                i = 1;
            }
            if (getItemCount() > itemCount) {
                notifyItemInserted(i);
            } else {
                notifyDataSetChanged();
            }
        }
    }

    public void w0(@NotNull RecyclerView.ViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        ViewGroup.LayoutParams layoutParams = holder.itemView.getLayoutParams();
        if (layoutParams instanceof StaggeredGridLayoutManager.LayoutParams) {
            ((StaggeredGridLayoutManager.LayoutParams) layoutParams).setFullSpan(true);
        }
    }

    public void x0(@Nullable Collection<? extends T> collection) {
        List<T> list = this.b;
        if (collection != list) {
            list.clear();
            if (!(collection == null || collection.isEmpty())) {
                this.b.addAll(collection);
            }
        } else {
            if (collection == null || collection.isEmpty()) {
                this.b.clear();
            } else {
                ArrayList arrayList = new ArrayList(collection);
                this.b.clear();
                this.b.addAll(arrayList);
            }
        }
        gr grVar = this.v;
        if (grVar != null) {
            grVar.f();
        }
        this.n = -1;
        notifyDataSetChanged();
        gr grVar2 = this.v;
        if (grVar2 != null) {
            grVar2.b();
        }
    }

    public void y0(@Nullable List<T> list) {
        if (list == this.b) {
            return;
        }
        if (list == null) {
            list = new ArrayList<>();
        }
        this.b = list;
        gr grVar = this.v;
        if (grVar != null) {
            grVar.f();
        }
        this.n = -1;
        notifyDataSetChanged();
        gr grVar2 = this.v;
        if (grVar2 != null) {
            grVar2.b();
        }
    }

    public void z0(@NotNull View v, int i) {
        Intrinsics.checkNotNullParameter(v, "v");
        zq zqVar = this.r;
        if (zqVar != null) {
            zqVar.O1(this, v, i);
        }
    }

    @JvmOverloads
    public BaseQuickAdapter(@LayoutRes int i, @Nullable List<T> list) {
        this.a = i;
        this.b = list == null ? new ArrayList<>() : list;
        this.e = true;
        this.i = true;
        this.n = -1;
        A();
        this.x = new LinkedHashSet<>();
        this.y = new LinkedHashSet<>();
    }
}
