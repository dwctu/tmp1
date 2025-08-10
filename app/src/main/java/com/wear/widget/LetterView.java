package com.wear.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.lovense.wear.R;
import dc.ce3;

/* loaded from: classes4.dex */
public class LetterView extends LinearLayout {
    public Context a;
    public c b;
    public int c;

    public class a implements View.OnClickListener {
        public final /* synthetic */ String a;

        public a(String str) {
            this.a = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (LetterView.this.b != null) {
                LetterView.this.b.b(this.a);
            }
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (LetterView.this.b != null) {
                LetterView.this.b.a();
            }
        }
    }

    public interface c {
        void a();

        void b(String str);
    }

    public LetterView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = context;
        this.c = ce3.a(context, 2.0f);
        setOrientation(1);
        d();
    }

    public final ImageView b() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1, 1.0f);
        ImageView imageView = new ImageView(this.a);
        imageView.setLayoutParams(layoutParams);
        imageView.setOnClickListener(new b());
        return imageView;
    }

    public final TextView c(String str) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        TextView textView = new TextView(this.a);
        textView.setLayoutParams(layoutParams);
        textView.setGravity(17);
        int i = this.c;
        textView.setPadding(0, i, 0, i);
        textView.setClickable(true);
        textView.setTextColor(ContextCompat.getColor(this.a, R.color.text_color_45));
        textView.setText(str);
        textView.setTextSize(2, 11.0f);
        textView.setOnClickListener(new a(str));
        return textView;
    }

    public final void d() {
        addView(b());
        for (char c2 = 'A'; c2 <= 'Z'; c2 = (char) (c2 + 1)) {
            addView(c(c2 + ""));
        }
        addView(c("#"));
    }

    public void setCharacterListener(c cVar) {
        this.b = cVar;
    }
}
