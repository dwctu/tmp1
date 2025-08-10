package com.wear.adapter.longdistance;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.epicgames.unreal.psoservices.PSOProgramService;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.lovense.wear.R;
import com.wear.adapter.BaseAdapter;
import com.wear.bean.Pattern;
import com.wear.util.WearUtils;
import dc.ah4;
import dc.qf3;
import dc.uu1;
import java.util.ArrayList;
import org.jivesoftware.smack.sm.packet.StreamManagement;
import pl.droidsonroids.gif.GifImageView;

/* loaded from: classes3.dex */
public class GroupControlPatternAdapter extends BaseAdapter<Pattern> {
    public b j;
    public int k;

    public class a implements View.OnClickListener {
        public final /* synthetic */ int a;
        public final /* synthetic */ Pattern b;

        public a(int i, Pattern pattern) {
            this.a = i;
            this.b = pattern;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int i = GroupControlPatternAdapter.this.k;
            int i2 = this.a;
            if (i == i2 && qf3.a) {
                if (GroupControlPatternAdapter.this.j != null) {
                    GroupControlPatternAdapter.this.j.onPause();
                }
                qf3.C();
                GroupControlPatternAdapter.this.notifyDataSetChanged();
                return;
            }
            GroupControlPatternAdapter.this.k = i2;
            if (GroupControlPatternAdapter.this.j != null) {
                GroupControlPatternAdapter.this.j.a(this.b);
            }
            GroupControlPatternAdapter.this.notifyDataSetChanged();
        }
    }

    public interface b {
        void a(Pattern pattern);

        void onPause();
    }

    public GroupControlPatternAdapter(ArrayList<Pattern> arrayList, int i) {
        super(arrayList, i);
        this.k = -1;
    }

    public void C() {
        int size = (this.k + 1) % this.b.size();
        this.k = size;
        b bVar = this.j;
        if (bVar != null) {
            bVar.a((Pattern) this.b.get(size));
        }
        notifyDataSetChanged();
    }

    public void D(b bVar) {
        this.j = bVar;
    }

    public final void E(BaseAdapter.ViewHolder viewHolder, Pattern pattern) {
        ImageView imageView = (ImageView) viewHolder.getView(R.id.toy_type_1);
        ImageView imageView2 = (ImageView) viewHolder.getView(R.id.toy_type_2);
        ImageView imageView3 = (ImageView) viewHolder.getView(R.id.toy_type_3);
        String[] strArrSplit = pattern.getToyFunc().split(",");
        int i = 0;
        imageView2.setVisibility(strArrSplit.length > 1 ? 0 : 8);
        imageView3.setVisibility(strArrSplit.length > 2 ? 0 : 8);
        while (i < strArrSplit.length) {
            ImageView imageView4 = i == 0 ? imageView : imageView2;
            if (i == 2) {
                imageView4 = imageView3;
            }
            boolean zEquals = TextUtils.equals(strArrSplit[i], PSOProgramService.VS_Key);
            int i2 = R.drawable.icon_label_toy_function_speed;
            if (zEquals || TextUtils.equals(strArrSplit[i], "v1")) {
                if (uu1.b(pattern.getToySymbol())) {
                    imageView4.setImageResource(R.drawable.icon_label_toy_function_speed);
                } else {
                    imageView4.setImageResource(R.drawable.icon_label_toy_function_vibration);
                }
            }
            if (TextUtils.equals(strArrSplit[i], "v2")) {
                imageView4.setImageResource(R.drawable.icon_label_toy_function_vibration_2);
            }
            if (TextUtils.equals(strArrSplit[i], "v3")) {
                imageView4.setImageResource(R.drawable.dark_home_wave);
            }
            if (TextUtils.equals(strArrSplit[i], "p")) {
                imageView4.setImageResource(R.drawable.icon_label_toy_function_contraction);
            }
            if (TextUtils.equals(strArrSplit[i], StreamManagement.AckRequest.ELEMENT)) {
                imageView4.setImageResource(R.drawable.icon_label_toy_function_rotation);
            }
            if (TextUtils.equals(strArrSplit[i], "t")) {
                if (i == 0) {
                    i2 = R.drawable.icon_label_toy_function_thrusting;
                }
                imageView4.setImageResource(i2);
            }
            if (TextUtils.equals(strArrSplit[i], "s")) {
                imageView4.setImageResource(R.drawable.icon_white_function_suction);
            }
            if (TextUtils.equals(strArrSplit[i], "f")) {
                imageView4.setImageResource(R.drawable.icon_label_toy_function_fingering);
            }
            if (TextUtils.equals(strArrSplit[i], GoogleApiAvailabilityLight.TRACKING_SOURCE_DIALOG)) {
                imageView4.setImageResource(R.drawable.icon_label_toy_function_depth);
            }
            if (TextUtils.equals(strArrSplit[i], "pos")) {
                imageView4.setImageResource(R.drawable.icon_velvo_position);
            }
            i++;
        }
    }

    @Override // com.wear.adapter.BaseAdapter
    /* renamed from: F, reason: merged with bridge method [inline-methods] */
    public void y(BaseAdapter.ViewHolder viewHolder, Pattern pattern, int i) {
        TextView textView = (TextView) viewHolder.getView(R.id.tv_pattern_name);
        TextView textView2 = (TextView) viewHolder.getView(R.id.pattern_author);
        TextView textView3 = (TextView) viewHolder.getView(R.id.pattern_timer);
        textView2.setText(WearUtils.e1(pattern.getAuthor()) ? ah4.e(R.string.common_anonymous) : pattern.getAuthor());
        if (pattern.isAnony()) {
            textView2.setText(ah4.e(R.string.common_anonymous));
        }
        textView3.setText(pattern.getTimer());
        textView.setText(pattern.getName());
        E(viewHolder, pattern);
        GifImageView gifImageView = (GifImageView) viewHolder.getView(R.id.iv_pattern_playing);
        if (i == this.k) {
            viewHolder.getView(R.id.iv_pattern_playing).setVisibility(0);
            if (qf3.a) {
                gifImageView.setImageResource(R.drawable.content_icon_musicewave_playing);
            } else {
                gifImageView.setImageResource(R.drawable.content_icon_musicewave_pause);
            }
        } else {
            gifImageView.setVisibility(8);
        }
        viewHolder.itemView.setOnClickListener(new a(i, pattern));
    }
}
