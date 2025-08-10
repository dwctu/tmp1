package com.wear.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.lovense.wear.R;
import com.wear.widget.chatMic.DrawView;

/* loaded from: classes4.dex */
public class SoundView extends LinearLayout {
    public ImageView a;
    public MediumBoldTextView b;
    public CircleProgress c;
    public LayoutInflater d;
    public LinearLayout e;
    public int f;
    public b g;
    public DrawView h;
    public RelativeLayout i;

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b bVar = SoundView.this.g;
            if (bVar != null) {
                bVar.a();
            }
        }
    }

    public interface b {
        void a();
    }

    public SoundView(Context context) {
        super(context);
        this.f = 0;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    public void setIconVisibility(int i) {
        this.i.setVisibility(i);
    }

    public void setListener(b bVar) {
        this.g = bVar;
    }

    public void setPlayOrPause(boolean z) {
        this.a.setImageResource(z ? R.drawable.sound_play : R.drawable.sound_pause);
    }

    public void setSoundLevel(int i, int i2, int i3) {
        this.c.setValue(i3);
        int i4 = (i * i2) / 100;
        this.f = i4;
        float f = i4 / 40.0f;
        DrawView drawView = this.h;
        if (drawView != null) {
            drawView.setPause(false);
            DrawView drawView2 = this.h;
            drawView2.m = (drawView2.m + Math.max(f, 0.01f)) / 2.0f;
            DrawView drawView3 = this.h;
            drawView3.f += drawView3.e;
            drawView3.invalidate();
        }
        if ((i3 + "").equals(this.b.getText().toString())) {
            return;
        }
        this.b.setText(i3 + "");
    }

    public SoundView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f = 0;
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService("layout_inflater");
        this.d = layoutInflater;
        LinearLayout linearLayout = (LinearLayout) layoutInflater.inflate(R.layout.remote_sound_view, (ViewGroup) null);
        this.e = linearLayout;
        addView(linearLayout);
        this.i = (RelativeLayout) this.e.findViewById(R.id.rl_cir);
        this.c = (CircleProgress) this.e.findViewById(R.id.progress);
        this.b = (MediumBoldTextView) this.e.findViewById(R.id.tv_level);
        this.a = (ImageView) this.e.findViewById(R.id.iv_play_or_pause);
        LinearLayout linearLayout2 = (LinearLayout) this.e.findViewById(R.id.ll_sound_wave);
        DrawView drawView = new DrawView(context);
        this.h = drawView;
        linearLayout2.addView(drawView);
        setWillNotDraw(false);
        this.a.setOnClickListener(new a());
    }

    public SoundView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f = 0;
    }
}
