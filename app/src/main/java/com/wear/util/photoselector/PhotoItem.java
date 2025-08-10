package com.wear.util.photoselector;

import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.lovense.wear.R;
import com.nostra13.universalimageloader.core.ImageLoader;
import dc.rj3;
import java.util.Random;

/* loaded from: classes4.dex */
public class PhotoItem extends LinearLayout implements View.OnClickListener {
    public ImageView a;
    public rj3 b;
    public b c;

    public class a implements Runnable {
        public final /* synthetic */ rj3 a;

        public a(rj3 rj3Var) {
            this.a = rj3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            ImageLoader.getInstance().displayImage("file://" + this.a.a(), PhotoItem.this.a);
        }
    }

    public interface b {
        void a(String str);
    }

    public PhotoItem(Context context) {
        super(context);
        LayoutInflater.from(context).inflate(R.layout.account_photoitem, (ViewGroup) this, true);
        setOnClickListener(this);
        this.a = (ImageView) findViewById(R.id.iv_photo_lpsi);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        b bVar = this.c;
        if (bVar != null) {
            bVar.a(this.b.a());
        }
    }

    public void setImageDrawable(rj3 rj3Var) {
        this.b = rj3Var;
        new Handler().postDelayed(new a(rj3Var), new Random().nextInt(10));
    }

    public void setOnClickListener(b bVar, int i) {
        this.c = bVar;
    }
}
