package dc;

import android.graphics.Path;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.ImageView;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.lovense.wear.R;
import com.wear.bean.RedPackAnim;
import com.wear.widget.FallingView;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: FallingAdapter.kt */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001dB\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J \u0010\u0015\u001a\u00020\u00162\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0014\u0010\u001a\u001a\u00020\u000e2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00020\u001cR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u001e\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0002X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/wear/adapter/FallingAdapter;", "Lcom/wear/widget/FallingView$IFallingAdapter;", "", "()V", "animDuration", "", "animInterval", "Ljava/util/ArrayList;", "Lcom/wear/adapter/FallingAdapter$Interval;", "Lkotlin/collections/ArrayList;", "count", "random", "Ljava/util/Random;", "convert", "", "parent", "Landroid/view/ViewGroup;", "holder", "Lcom/wear/widget/FallingView$Holder;", "convertAnim", "Landroid/view/animation/Animation;", "createPath", "Landroid/graphics/Path;", "position", "view", "Landroid/view/View;", "setData", "data", "", "Interval", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class uj1 extends FallingView.c<Integer> {

    @NotNull
    public final Random c;
    public final long d;
    public final int e;

    @NotNull
    public final ArrayList<a> f;

    /* compiled from: FallingAdapter.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u0006\u0010\t\u001a\u00020\u0003R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/wear/adapter/FallingAdapter$Interval;", "", TtmlNode.START, "", TtmlNode.END, "(FF)V", "getEnd", "()F", "getStart", "getLength", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        public final float a;
        public final float b;

        public a(float f, float f2) {
            this.a = f;
            this.b = f2;
        }

        public final float a() {
            return this.b - this.a;
        }

        /* renamed from: b, reason: from getter */
        public final float getA() {
            return this.a;
        }
    }

    public uj1() {
        super(R.layout.item_redpack);
        this.c = new Random();
        this.d = 4000L;
        this.e = 15;
        this.f = new ArrayList<>();
    }

    public static final void f(View view) {
    }

    @Override // com.wear.widget.FallingView.c
    public void a(@NotNull ViewGroup parent, @NotNull FallingView.b holder) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (holder.getC() % 20 == 0) {
            View a2 = holder.getA();
            Intrinsics.checkNotNull(a2, "null cannot be cast to non-null type android.widget.ImageView");
            ((ImageView) a2).setImageResource(R.drawable.img_heart);
        } else {
            View a3 = holder.getA();
            Intrinsics.checkNotNull(a3, "null cannot be cast to non-null type android.widget.ImageView");
            ((ImageView) a3).setImageResource(R.drawable.img_heart);
        }
        holder.getB().f(holder.getC() * (this.d / this.e));
        holder.getA().setOnClickListener(new View.OnClickListener() { // from class: dc.qj1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                uj1.f(view);
            }
        });
    }

    @Override // com.wear.widget.FallingView.c
    @NotNull
    public Animation b(@NotNull ViewGroup parent, @NotNull FallingView.b holder) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(holder, "holder");
        Path pathG = g(parent, holder.getC(), holder.getA());
        holder.getB().e(pathG);
        RedPackAnim redPackAnim = new RedPackAnim(pathG, 0.0f, holder.getA());
        redPackAnim.setDuration(this.d);
        return redPackAnim;
    }

    public final Path g(ViewGroup viewGroup, int i, View view) {
        a aVar;
        Path path = new Path();
        view.measure(0, 0);
        int width = viewGroup.getWidth() - view.getMeasuredWidth();
        int height = viewGroup.getHeight();
        float f = width / 3.0f;
        if (this.f.isEmpty()) {
            this.f.add(new a(view.getMeasuredWidth() / 2.0f, f));
            float f2 = 2 * f;
            this.f.add(new a(f, f2));
            this.f.add(new a(f2, viewGroup.getWidth() - (view.getMeasuredWidth() / 2.0f)));
        }
        if (this.f.size() == 1) {
            a aVar2 = this.f.get(0);
            Intrinsics.checkNotNullExpressionValue(aVar2, "animInterval[0]");
            aVar = aVar2;
        } else {
            ArrayList<a> arrayList = this.f;
            a aVar3 = arrayList.get(this.c.nextInt(arrayList.size()));
            Intrinsics.checkNotNullExpressionValue(aVar3, "animInterval[random.nextInt(animInterval.size)]");
            aVar = aVar3;
        }
        this.f.remove(aVar);
        path.moveTo(this.c.nextInt(width), -view.getMeasuredHeight());
        path.cubicTo(this.c.nextInt((int) aVar.a()) + aVar.getA(), this.c.nextInt(r0), this.c.nextInt((int) aVar.a()) + aVar.getA(), this.c.nextInt(r0) + (height / 2), this.c.nextInt((int) aVar.a()) + aVar.getA(), height);
        return path;
    }

    public final void i(@NotNull List<Integer> data) {
        Intrinsics.checkNotNullParameter(data, "data");
        e(data);
    }
}
