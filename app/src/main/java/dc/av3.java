package dc;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.yydcdut.sdlv.BaseLayout;

/* compiled from: SDMenuItemView.java */
/* loaded from: classes4.dex */
public class av3 extends BaseLayout {
    public ImageView b;
    public TextView c;

    public av3(Context context, zu3 zu3Var) {
        super(context, zu3Var);
    }

    @Override // com.yydcdut.sdlv.BaseLayout
    public void a() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.a.a, -1);
        layoutParams.gravity = 17;
        setLayoutParams(layoutParams);
        addView(b());
        if (!TextUtils.isEmpty(this.a.b) && this.a.e != null) {
            this.b = d();
            this.c = e();
            LinearLayout linearLayout = new LinearLayout(getContext());
            linearLayout.setOrientation(1);
            linearLayout.addView(this.b);
            linearLayout.addView(this.c);
            linearLayout.setGravity(17);
            addView(linearLayout);
            return;
        }
        zu3 zu3Var = this.a;
        if (zu3Var.e != null) {
            ImageView imageViewD = d();
            this.b = imageViewD;
            addView(imageViewD);
        } else {
            if (TextUtils.isEmpty(zu3Var.b)) {
                addView(c());
                return;
            }
            TextView textViewE = e();
            this.c = textViewE;
            addView(textViewE);
        }
    }

    public final ImageView b() {
        ImageView imageView = new ImageView(getContext());
        imageView.setImageDrawable(this.a.f);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        return imageView;
    }

    public final View c() {
        return new View(getContext());
    }

    public ImageView d() {
        ImageView imageView = new ImageView(getContext());
        imageView.setImageDrawable(this.a.e);
        imageView.setScaleType(ImageView.ScaleType.CENTER);
        return imageView;
    }

    public final TextView e() {
        TextView textView = new TextView(getContext());
        textView.setText(this.a.b);
        textView.setTextSize(this.a.c);
        textView.setTextColor(this.a.d);
        textView.setGravity(17);
        return textView;
    }

    @Override // com.yydcdut.sdlv.BaseLayout
    public ImageView getImageView() {
        return this.b;
    }

    @Override // com.yydcdut.sdlv.BaseLayout
    public TextView getTextView() {
        return this.c;
    }
}
