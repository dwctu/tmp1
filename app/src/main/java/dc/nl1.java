package dc;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.epicgames.unreal.psoservices.PSOProgramService;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.lovense.wear.R;
import com.wear.bean.Pattern;
import com.wear.util.WearUtils;
import java.util.List;
import org.jivesoftware.smack.sm.packet.StreamManagement;
import pl.droidsonroids.gif.GifImageView;

/* compiled from: ChatLivePatternAdapter.java */
/* loaded from: classes3.dex */
public class nl1 extends vj1<Pattern> {
    public b d;
    public int e;

    /* compiled from: ChatLivePatternAdapter.java */
    public class a implements View.OnClickListener {
        public final /* synthetic */ int a;
        public final /* synthetic */ Pattern b;

        public a(int i, Pattern pattern) {
            this.a = i;
            this.b = pattern;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int i = nl1.this.e;
            int i2 = this.a;
            if (i == i2 && qf3.a) {
                if (nl1.this.d != null) {
                    nl1.this.d.b(this.b);
                }
                qf3.C();
                nl1.this.notifyDataSetChanged();
                return;
            }
            nl1.this.e = i2;
            if (nl1.this.d != null) {
                nl1.this.d.a(this.b, false);
            }
            nl1.this.notifyDataSetChanged();
        }
    }

    /* compiled from: ChatLivePatternAdapter.java */
    public interface b {
        void a(Pattern pattern, boolean z);

        void b(Pattern pattern);
    }

    public nl1(List<Pattern> list, Context context, int i) {
        super(list, context, i);
        this.e = -1;
    }

    public void f() {
        int size = (this.e + 1) % this.a.size();
        this.e = size;
        b bVar = this.d;
        if (bVar != null) {
            bVar.a((Pattern) this.a.get(size), true);
        }
        notifyDataSetChanged();
    }

    public void g(b bVar) {
        this.d = bVar;
    }

    public final void h(wj1 wj1Var, Pattern pattern) {
        ImageView imageView = (ImageView) wj1Var.b(R.id.toy_type_1);
        ImageView imageView2 = (ImageView) wj1Var.b(R.id.toy_type_2);
        ImageView imageView3 = (ImageView) wj1Var.b(R.id.toy_type_3);
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

    @Override // dc.vj1
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public void b(wj1 wj1Var, Pattern pattern, int i) {
        TextView textView = (TextView) wj1Var.b(R.id.tv_pattern_name);
        TextView textView2 = (TextView) wj1Var.b(R.id.pattern_author);
        TextView textView3 = (TextView) wj1Var.b(R.id.pattern_timer);
        textView2.setText(WearUtils.e1(pattern.getAuthor()) ? ah4.e(R.string.common_anonymous) : pattern.getAuthor());
        if (pattern.isAnony()) {
            textView2.setText(ah4.e(R.string.common_anonymous));
        }
        textView3.setText(pattern.getTimer());
        textView.setText(pattern.getName());
        h(wj1Var, pattern);
        GifImageView gifImageView = (GifImageView) wj1Var.b(R.id.iv_pattern_playing);
        if (i == this.e) {
            wj1Var.b(R.id.iv_pattern_playing).setVisibility(0);
            if (qf3.a) {
                gifImageView.setImageResource(R.drawable.content_icon_musicewave_playing);
            } else {
                gifImageView.setImageResource(R.drawable.content_icon_musicewave_pause);
            }
        } else {
            gifImageView.setVisibility(8);
        }
        wj1Var.a().setOnClickListener(new a(i, pattern));
    }
}
