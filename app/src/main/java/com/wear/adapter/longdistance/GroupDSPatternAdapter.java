package com.wear.adapter.longdistance;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.lovense.wear.R;
import com.wear.adapter.BaseAdapter;
import com.wear.bean.Pattern;
import dc.qf3;
import java.util.ArrayList;
import pl.droidsonroids.gif.GifImageView;

/* loaded from: classes3.dex */
public class GroupDSPatternAdapter extends BaseAdapter<Pattern> {
    public TextView j;
    public b k;
    public int l;

    public class a implements View.OnClickListener {
        public final /* synthetic */ int a;
        public final /* synthetic */ Pattern b;

        public a(int i, Pattern pattern) {
            this.a = i;
            this.b = pattern;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int i = GroupDSPatternAdapter.this.l;
            int i2 = this.a;
            if (i == i2 && qf3.a) {
                if (GroupDSPatternAdapter.this.k != null) {
                    GroupDSPatternAdapter.this.k.onPause();
                }
                qf3.C();
                GroupDSPatternAdapter.this.notifyDataSetChanged();
                return;
            }
            GroupDSPatternAdapter.this.l = i2;
            if (GroupDSPatternAdapter.this.k != null) {
                GroupDSPatternAdapter.this.k.a(this.b);
            }
            GroupDSPatternAdapter.this.notifyDataSetChanged();
        }
    }

    public interface b {
        void a(Pattern pattern);

        void onPause();
    }

    public GroupDSPatternAdapter(ArrayList<Pattern> arrayList, int i) {
        super(arrayList, i);
        this.l = -1;
    }

    public void C() {
        if (this.b.isEmpty()) {
            return;
        }
        int size = (this.l + 1) % this.b.size();
        this.l = size;
        b bVar = this.k;
        if (bVar != null) {
            bVar.a((Pattern) this.b.get(size));
        }
        notifyDataSetChanged();
    }

    public void D(b bVar) {
        this.k = bVar;
    }

    @Override // com.wear.adapter.BaseAdapter
    /* renamed from: E, reason: merged with bridge method [inline-methods] */
    public void y(BaseAdapter.ViewHolder viewHolder, Pattern pattern, int i) {
        TextView textView = (TextView) viewHolder.getView(R.id.tv_pattern_name);
        TextView textView2 = (TextView) viewHolder.getView(R.id.pattern_timer);
        textView.setText(pattern.getName());
        GifImageView gifImageView = (GifImageView) viewHolder.getView(R.id.iv_pattern_playing);
        ImageView imageView = (ImageView) viewHolder.getView(R.id.iv_pause);
        if (i == this.l) {
            viewHolder.getView(R.id.iv_pattern_playing).setVisibility(0);
            imageView.setVisibility(0);
            if (qf3.a) {
                gifImageView.setImageResource(R.drawable.content_icon_musicewave_playing);
                imageView.setImageResource(R.drawable.chat_toolbar_pattern_pause);
                textView2.setText(pattern.getTimer());
                this.j = textView2;
            } else {
                gifImageView.setImageResource(R.drawable.content_icon_musicewave_pause);
                imageView.setImageResource(R.drawable.chat_toolbar_pattern_play);
                textView2.setText(pattern.getTimer());
            }
            textView.setTextColor(this.c.getResources().getColor(R.color.select_text_color));
            textView2.setTextColor(this.c.getResources().getColor(R.color.select_text_color));
        } else {
            gifImageView.setVisibility(8);
            imageView.setVisibility(8);
            textView.setTextColor(this.c.getResources().getColor(R.color.text_color_45));
            textView2.setTextColor(this.c.getResources().getColor(R.color.text_color_45));
            textView2.setText(pattern.getTimer());
        }
        viewHolder.itemView.setOnClickListener(new a(i, pattern));
    }
}
