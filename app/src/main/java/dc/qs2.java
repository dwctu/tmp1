package dc;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.EditText;
import com.lovense.wear.R;
import com.wear.databinding.PanelEmojisBinding;
import com.wear.ext.ActivityKt;
import com.wear.ui.chat.NewChatViewModel;
import com.wear.widget.EmojisToastView;
import dc.ie3;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: EmojisFunctionPanelAdapter.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0002H\u0016J\u0012\u0010\u000e\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J0\u0010\u0011\u001a\u00020\f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00102\b\u0010\u0015\u001a\u0004\u0018\u00010\u00102\b\u0010\u0016\u001a\u0004\u0018\u00010\u0010H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/wear/ui/chat/controller/EmojisFunctionPanelAdapter;", "Lcom/wear/ui/chat/controller/FunctionPanelAdapter;", "Lcom/wear/databinding/PanelEmojisBinding;", "Lcom/wear/util/EmojisUtils$IEmojisEventListener;", "viewModel", "Lcom/wear/ui/chat/NewChatViewModel;", "emojisUtils", "Lcom/wear/util/EmojisUtils;", "(Lcom/wear/ui/chat/NewChatViewModel;Lcom/wear/util/EmojisUtils;)V", "getTriggerViewId", "", "onBinding", "", "binding", "sendEmojisMessage", "message", "", "sendPicFileAction", "file", "Ljava/io/File;", "photoType", "fileMd5", "key", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class qs2 extends rs2<PanelEmojisBinding> implements ie3.m {

    @NotNull
    public final ie3 b;

    /* compiled from: EmojisFunctionPanelAdapter.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class a extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, PanelEmojisBinding> {
        public static final a a = new a();

        public a() {
            super(3, PanelEmojisBinding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/wear/databinding/PanelEmojisBinding;", 0);
        }

        @NotNull
        public final PanelEmojisBinding a(@NotNull LayoutInflater p0, @Nullable ViewGroup viewGroup, boolean z) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return PanelEmojisBinding.c(p0, viewGroup, z);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ PanelEmojisBinding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
            return a(layoutInflater, viewGroup, bool.booleanValue());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public qs2(@NotNull NewChatViewModel viewModel, @NotNull ie3 emojisUtils) {
        super(a.a);
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(emojisUtils, "emojisUtils");
        this.b = emojisUtils;
    }

    @Override // dc.rs2
    public int k() {
        return R.id.chat_emojis;
    }

    @Override // dc.rs2
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public void n(@NotNull PanelEmojisBinding binding) {
        Intrinsics.checkNotNullParameter(binding, "binding");
        Activity activityE = ActivityKt.e();
        if (activityE != null) {
            this.b.w(binding.getRoot().getContext(), this, binding.getRoot(), (EditText) activityE.findViewById(R.id.chat_message), (EmojisToastView) activityE.findViewById(R.id.chat_emojis_toast_layer));
        }
        binding.getRoot().setFavoriteLayoutVisible(false);
    }

    @Override // dc.ie3.m
    public void o2(@Nullable File file, @Nullable String str, @Nullable String str2, @Nullable String str3) {
    }
}
