package dc;

import android.view.View;
import androidx.annotation.IdRes;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smack.sm.packet.StreamManagement;

/* compiled from: IContentContainer.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0001\u0010\b\u001a\u00020\u0005H&J\b\u0010\t\u001a\u00020\nH&J\b\u0010\u000b\u001a\u00020\fH&JX\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00052\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00172\b\b\u0002\u0010\u0019\u001a\u00020\u0017H&J&\u0010\u001a\u001a\u00020\u00032\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u001dH&¨\u0006\u001e"}, d2 = {"Lcom/wear/ui/chat/pancel/helper/view/content/IContentContainer;", "", "changeContainerHeight", "", "targetHeight", "", "findTriggerView", "Landroid/view/View;", TtmlNode.ATTR_ID, "getInputActionImpl", "Lcom/wear/ui/chat/pancel/helper/view/content/IInputAction;", "getResetActionImpl", "Lcom/wear/ui/chat/pancel/helper/view/content/IResetAction;", "layoutContainer", "l", "t", StreamManagement.AckRequest.ELEMENT, "b", "contentScrollMeasurer", "", "Lcom/wear/ui/chat/pancel/helper/interfaces/ContentScrollMeasurer;", "defaultScrollHeight", "canScrollOutsize", "", "reset", "changed", "translationContainer", "contentScrollMeasurers", "contentTranslationY", "", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public interface su2 {
    void a(@NotNull List<ot2> list, int i, float f);

    void b(int i, int i2, int i3, int i4, @NotNull List<ot2> list, int i5, boolean z, boolean z2, boolean z3);

    @Nullable
    View c(@IdRes int i);

    void d(int i);

    @NotNull
    tu2 getInputActionImpl();

    @NotNull
    uu2 getResetActionImpl();
}
