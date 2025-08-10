package dc;

import android.graphics.Canvas;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: DraggableModule.kt */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\b\u0016\u0018\u0000 [2\u00020\u0001:\u0001[B\u0015\u0012\u000e\u0010\u0002\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0003¢\u0006\u0002\u0010\u0004J\u000e\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020<J\u0010\u0010=\u001a\u0002042\u0006\u0010>\u001a\u00020?H\u0004J\b\u0010@\u001a\u00020\u0006H\u0016J\u0010\u0010A\u001a\u00020\u00062\u0006\u0010B\u001a\u000204H\u0002J\b\u0010C\u001a\u00020:H\u0002J\u0015\u0010D\u001a\u00020:2\u0006\u0010E\u001a\u00020FH\u0000¢\u0006\u0002\bGJ\u0010\u0010H\u001a\u00020:2\u0006\u0010>\u001a\u00020?H\u0016J\u0018\u0010I\u001a\u00020:2\u0006\u0010J\u001a\u00020?2\u0006\u0010K\u001a\u00020?H\u0016J\u0010\u0010L\u001a\u00020:2\u0006\u0010>\u001a\u00020?H\u0016J\u0010\u0010M\u001a\u00020:2\u0006\u0010>\u001a\u00020?H\u0016J\u0010\u0010N\u001a\u00020:2\u0006\u0010>\u001a\u00020?H\u0016J\u0010\u0010O\u001a\u00020:2\u0006\u0010>\u001a\u00020?H\u0016J4\u0010P\u001a\u00020:2\b\u0010Q\u001a\u0004\u0018\u00010R2\b\u0010>\u001a\u0004\u0018\u00010?2\u0006\u0010S\u001a\u00020T2\u0006\u0010U\u001a\u00020T2\u0006\u0010V\u001a\u00020\u0006H\u0016J\u0012\u0010W\u001a\u00020:2\b\u0010X\u001a\u0004\u0018\u00010\u001cH\u0016J\u0012\u0010Y\u001a\u00020:2\b\u0010Z\u001a\u0004\u0018\u00010\"H\u0016R\u0016\u0010\u0002\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0007\"\u0004\b\u000e\u0010\tR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001c\u0010!\u001a\u0004\u0018\u00010\"X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001c\u0010'\u001a\u0004\u0018\u00010(X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001c\u0010-\u001a\u0004\u0018\u00010.X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001a\u00103\u001a\u000204X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108¨\u0006\\"}, d2 = {"Lcom/chad/library/adapter/base/module/BaseDraggableModule;", "Lcom/chad/library/adapter/base/listener/DraggableListenerImp;", "baseQuickAdapter", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "(Lcom/chad/library/adapter/base/BaseQuickAdapter;)V", "isDragEnabled", "", "()Z", "setDragEnabled", "(Z)V", "value", "isDragOnLongPressEnabled", "setDragOnLongPressEnabled", "isSwipeEnabled", "setSwipeEnabled", "itemTouchHelper", "Landroidx/recyclerview/widget/ItemTouchHelper;", "getItemTouchHelper", "()Landroidx/recyclerview/widget/ItemTouchHelper;", "setItemTouchHelper", "(Landroidx/recyclerview/widget/ItemTouchHelper;)V", "itemTouchHelperCallback", "Lcom/chad/library/adapter/base/dragswipe/DragAndSwipeCallback;", "getItemTouchHelperCallback", "()Lcom/chad/library/adapter/base/dragswipe/DragAndSwipeCallback;", "setItemTouchHelperCallback", "(Lcom/chad/library/adapter/base/dragswipe/DragAndSwipeCallback;)V", "mOnItemDragListener", "Lcom/chad/library/adapter/base/listener/OnItemDragListener;", "getMOnItemDragListener", "()Lcom/chad/library/adapter/base/listener/OnItemDragListener;", "setMOnItemDragListener", "(Lcom/chad/library/adapter/base/listener/OnItemDragListener;)V", "mOnItemSwipeListener", "Lcom/chad/library/adapter/base/listener/OnItemSwipeListener;", "getMOnItemSwipeListener", "()Lcom/chad/library/adapter/base/listener/OnItemSwipeListener;", "setMOnItemSwipeListener", "(Lcom/chad/library/adapter/base/listener/OnItemSwipeListener;)V", "mOnToggleViewLongClickListener", "Landroid/view/View$OnLongClickListener;", "getMOnToggleViewLongClickListener", "()Landroid/view/View$OnLongClickListener;", "setMOnToggleViewLongClickListener", "(Landroid/view/View$OnLongClickListener;)V", "mOnToggleViewTouchListener", "Landroid/view/View$OnTouchListener;", "getMOnToggleViewTouchListener", "()Landroid/view/View$OnTouchListener;", "setMOnToggleViewTouchListener", "(Landroid/view/View$OnTouchListener;)V", "toggleViewId", "", "getToggleViewId", "()I", "setToggleViewId", "(I)V", "attachToRecyclerView", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getViewHolderPosition", "viewHolder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "hasToggleView", "inRange", "position", "initItemTouch", "initView", "holder", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "initView$com_github_CymChad_brvah", "onItemDragEnd", "onItemDragMoving", "source", TypedValues.AttributesType.S_TARGET, "onItemDragStart", "onItemSwipeClear", "onItemSwipeStart", "onItemSwiped", "onItemSwiping", "canvas", "Landroid/graphics/Canvas;", "dX", "", "dY", "isCurrentlyActive", "setOnItemDragListener", "onItemDragListener", "setOnItemSwipeListener", "onItemSwipeListener", "Companion", "com.github.CymChad.brvah"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public class fr {
    public final void a(@NotNull RecyclerView recyclerView) {
        throw null;
    }

    public boolean b() {
        throw null;
    }

    public final void c(@NotNull BaseViewHolder baseViewHolder) {
        throw null;
    }

    public final boolean d() {
        throw null;
    }

    public final boolean e() {
        throw null;
    }

    public void f(@NotNull RecyclerView.ViewHolder viewHolder) {
        throw null;
    }

    public void g(@NotNull RecyclerView.ViewHolder viewHolder, @NotNull RecyclerView.ViewHolder viewHolder2) {
        throw null;
    }

    public void h(@NotNull RecyclerView.ViewHolder viewHolder) {
        throw null;
    }

    public void i(@NotNull RecyclerView.ViewHolder viewHolder) {
        throw null;
    }

    public void j(@NotNull RecyclerView.ViewHolder viewHolder) {
        throw null;
    }

    public void k(@NotNull RecyclerView.ViewHolder viewHolder) {
        throw null;
    }

    public void l(@Nullable Canvas canvas, @Nullable RecyclerView.ViewHolder viewHolder, float f, float f2, boolean z) {
        throw null;
    }
}
