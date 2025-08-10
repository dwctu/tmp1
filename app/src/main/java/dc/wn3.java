package dc;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.Html;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.lovense.wear.R;

/* compiled from: MyImageGetter.java */
/* loaded from: classes4.dex */
public class wn3 implements Html.ImageGetter {
    public Drawable a;
    public TextView b;
    public Context c;

    /* compiled from: MyImageGetter.java */
    public class a extends ap<Drawable> {
        public a() {
        }

        @Override // dc.cp
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public void f(@NonNull Drawable drawable, @Nullable hp<? super Drawable> hpVar) {
            wn3.this.a = drawable;
            wn3.this.a.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            wn3.this.b.postInvalidate();
            wn3.this.b.setText(wn3.this.b.getText());
        }
    }

    /* compiled from: MyImageGetter.java */
    public class b extends BitmapDrawable {
        public Bitmap a;

        public b(wn3 wn3Var) {
        }

        @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            super.draw(canvas);
            Bitmap bitmap = this.a;
            if (bitmap != null) {
                canvas.drawBitmap(bitmap, 0.0f, 0.0f, getPaint());
            }
        }
    }

    public wn3(Context context, TextView textView) {
        this.b = textView;
        this.c = context;
    }

    @Override // android.text.Html.ImageGetter
    public Drawable getDrawable(String str) {
        this.a = new b(this);
        kf.w(this.c).v(str).X(R.drawable.default_card_bg).x0(new a());
        return this.a;
    }
}
