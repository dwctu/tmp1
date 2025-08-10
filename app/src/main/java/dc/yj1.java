package dc;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.epicgames.unreal.psoservices.PSOProgramService;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.lovense.wear.R;
import com.wear.bean.Pattern;
import com.wear.bean.Toy;
import com.wear.util.WearUtils;
import java.util.List;
import org.jivesoftware.smack.sm.packet.StreamManagement;

/* compiled from: PatternAdapter.java */
/* loaded from: classes3.dex */
public class yj1 extends vj1<Pattern> {
    public Activity d;
    public c e;

    /* compiled from: PatternAdapter.java */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            sg3.i(yj1.this.d, R.string.patterns_reported_notice);
        }
    }

    /* compiled from: PatternAdapter.java */
    public class b implements View.OnClickListener {
        public final /* synthetic */ Pattern a;

        public b(Pattern pattern) {
            this.a = pattern;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c cVar = yj1.this.e;
            if (cVar != null) {
                cVar.o(view, this.a);
            }
        }
    }

    /* compiled from: PatternAdapter.java */
    public interface c {
        void o(View view, Pattern pattern);
    }

    public yj1(List<Pattern> list, Activity activity, int i) {
        super(list, activity, i);
        this.d = activity;
    }

    public void c(c cVar) {
        this.e = cVar;
    }

    @Override // dc.vj1
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void b(wj1 wj1Var, Pattern pattern, int i) {
        ImageView imageView;
        ImageView imageView2;
        int i2;
        int i3;
        TextView textView = (TextView) wj1Var.b(R.id.pattern_name);
        ImageView imageView3 = (ImageView) wj1Var.b(R.id.pattern_func_v1);
        ImageView imageView4 = (ImageView) wj1Var.b(R.id.pattern_func_v2);
        ImageView imageView5 = (ImageView) wj1Var.b(R.id.pattern_func_v3);
        ImageView imageView6 = (ImageView) wj1Var.b(R.id.pattern_func_f);
        ImageView imageView7 = (ImageView) wj1Var.b(R.id.pattern_func_r);
        ImageView imageView8 = (ImageView) wj1Var.b(R.id.pattern_func_p);
        ImageView imageView9 = (ImageView) wj1Var.b(R.id.pattern_func_s);
        ImageView imageView10 = (ImageView) wj1Var.b(R.id.pattern_func_t);
        ImageView imageView11 = (ImageView) wj1Var.b(R.id.pattern_func_d);
        ImageView imageView12 = (ImageView) wj1Var.b(R.id.pattern_func_pos);
        TextView textView2 = (TextView) wj1Var.b(R.id.pattern_toy_name);
        TextView textView3 = (TextView) wj1Var.b(R.id.pattern_author);
        TextView textView4 = (TextView) wj1Var.b(R.id.pattern_timer);
        TextView textView5 = (TextView) wj1Var.b(R.id.shear_action);
        LinearLayout linearLayout = (LinearLayout) wj1Var.b(R.id.pattern_operation);
        ImageView imageView13 = (ImageView) wj1Var.b(R.id.iv_sync_status);
        textView.setText(pattern.getName());
        if (pattern.getToyName() != null) {
            textView2.setText(ng3.c(pattern.getToyName(), pattern.getToyVersion()));
            textView2.setVisibility(0);
            imageView2 = imageView13;
            imageView = imageView3;
            i2 = 8;
        } else {
            imageView = imageView3;
            imageView2 = imageView13;
            String strD = ng3.d(pattern.getToyFunc(), pattern.getCdtTime(), pattern.getToyFeature());
            if (WearUtils.e1(Toy.getFullName(strD))) {
                i2 = 8;
                textView2.setVisibility(8);
            } else {
                i2 = 8;
                textView2.setVisibility(0);
                textView2.setText(ng3.c(Toy.getFullName(strD), pattern.getToyVersion()));
            }
        }
        textView5.setVisibility(i2);
        if (pattern.isShared() || pattern.isDownload()) {
            textView5.setVisibility(0);
            textView5.setTextColor(this.d.getResources().getColor(R.color.color_accent));
            textView5.setText(ah4.e(R.string.common_shared));
            textView5.setOnClickListener(null);
            if (!WearUtils.e1(pattern.getStatus()) && pattern.getStatus().toLowerCase().equals("report")) {
                textView5.setTextColor(this.d.getResources().getColor(R.color.text_secondary_light));
                textView5.setText(ah4.e(R.string.patterns_reported));
                textView5.setOnClickListener(new a());
            }
        }
        textView3.setText(WearUtils.e1(pattern.getAuthor()) ? ah4.e(R.string.common_anonymous) : pattern.getAuthor());
        textView4.setText(pattern.getTimer());
        linearLayout.setOnClickListener(new b(pattern));
        if (pattern.getEmail().equals(WearUtils.y.r())) {
            linearLayout.setAlpha(1.0f);
        } else {
            linearLayout.setAlpha(0.4f);
        }
        String[] strArrSplit = pattern.getToyFunc().split(",");
        ImageView imageView14 = imageView;
        imageView14.setVisibility(8);
        imageView4.setVisibility(8);
        imageView5.setVisibility(8);
        imageView8.setVisibility(8);
        imageView7.setVisibility(8);
        imageView10.setVisibility(8);
        imageView9.setVisibility(8);
        imageView6.setVisibility(8);
        imageView11.setVisibility(8);
        imageView12.setVisibility(8);
        int i4 = 0;
        while (i4 < strArrSplit.length) {
            String str = strArrSplit[i4];
            if (TextUtils.equals(str, PSOProgramService.VS_Key) || TextUtils.equals(str, "v1")) {
                imageView14.setVisibility(0);
                if (uu1.b(pattern.getToySymbol())) {
                    imageView14.setImageResource(R.drawable.icon_label_toy_function_thrusting);
                } else {
                    imageView14.setImageResource(R.drawable.icon_label_toy_function_vibration);
                }
            }
            if (TextUtils.equals(str, "v2")) {
                i3 = 0;
                imageView4.setVisibility(0);
            } else {
                i3 = 0;
            }
            if (TextUtils.equals(str, "v3")) {
                imageView5.setVisibility(i3);
            }
            if (TextUtils.equals(str, "p")) {
                imageView8.setVisibility(i3);
            }
            if (TextUtils.equals(str, StreamManagement.AckRequest.ELEMENT)) {
                imageView7.setVisibility(i3);
            }
            if (TextUtils.equals(str, "t")) {
                imageView10.setVisibility(i3);
                imageView10.setImageResource(i4 == 0 ? R.drawable.icon_label_toy_function_thrusting : R.drawable.icon_label_toy_function_speed);
            }
            if (TextUtils.equals(str, "s")) {
                imageView9.setVisibility(i3);
            }
            if (TextUtils.equals(str, "f")) {
                imageView6.setVisibility(i3);
            }
            if (TextUtils.equals(str, GoogleApiAvailabilityLight.TRACKING_SOURCE_DIALOG)) {
                imageView11.setVisibility(i3);
            }
            if (TextUtils.equals(str, "pos")) {
                imageView10.setVisibility(8);
                imageView12.setVisibility(i3);
            }
            i4++;
        }
        if (pattern.syncSuc() || !ch3.n().X()) {
            imageView2.setVisibility(8);
        } else {
            imageView2.setVisibility(0);
        }
    }
}
