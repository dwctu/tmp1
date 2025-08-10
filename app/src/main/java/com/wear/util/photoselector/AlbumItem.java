package com.wear.util.photoselector;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.lovense.wear.R;
import com.nostra13.universalimageloader.core.ImageLoader;
import dc.ah4;
import dc.nj3;

/* loaded from: classes4.dex */
public class AlbumItem extends LinearLayout {
    public ImageView a;
    public ImageView b;
    public TextView c;
    public TextView d;

    public AlbumItem(Context context) {
        this(context, null);
    }

    public void a(boolean z) {
        if (z) {
            this.b.setVisibility(0);
        } else {
            this.b.setVisibility(8);
        }
    }

    public void b(nj3 nj3Var) {
        setAlbumImage(nj3Var.c());
        setName(nj3Var.b());
        setCount(nj3Var.a());
        a(nj3Var.e());
    }

    public void setAlbumImage(String str) {
        ImageLoader.getInstance().displayImage("file://" + str, this.a);
    }

    public void setCount(int i) {
        this.d.setHint(i + ah4.e(R.string.album_pictures));
    }

    public void setName(CharSequence charSequence) {
        this.c.setText(charSequence);
    }

    public AlbumItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        LayoutInflater.from(context).inflate(R.layout.account_album, (ViewGroup) this, true);
        this.a = (ImageView) findViewById(R.id.iv_album_la);
        this.b = (ImageView) findViewById(R.id.iv_index_la);
        this.c = (TextView) findViewById(R.id.tv_name_la);
        this.d = (TextView) findViewById(R.id.tv_count_la);
    }

    public AlbumItem(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet);
    }
}
