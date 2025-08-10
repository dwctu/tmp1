package dc;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.epicgames.unreal.psoservices.PSOProgramService;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.lovense.wear.R;
import com.wear.bean.Pattern;
import com.wear.main.closeRange.PatternPlayActivity;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import org.jivesoftware.smack.sm.packet.StreamManagement;
import pl.droidsonroids.gif.GifImageView;

/* compiled from: PatternPlayAdapter.java */
/* loaded from: classes3.dex */
public class bk1 extends BaseAdapter {
    public LayoutInflater a;
    public PatternPlayActivity b;
    public String c;
    public int d = 0;

    /* compiled from: PatternPlayAdapter.java */
    public class a implements View.OnClickListener {
        public final /* synthetic */ Pattern a;

        public a(Pattern pattern) {
            this.a = pattern;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            bk1.this.b.v6(this.a, view);
        }
    }

    /* compiled from: PatternPlayAdapter.java */
    public class b {
        public String a;
        public GifImageView b;
        public TextView c;
        public ImageView d;
        public ImageView e;
        public ImageView f;
        public ImageView g;
        public TextView h;
        public TextView i;
        public LinearLayout j;

        public b(bk1 bk1Var) {
        }
    }

    public bk1(PatternPlayActivity patternPlayActivity, MyApplication myApplication, String str) {
        this.a = null;
        this.a = LayoutInflater.from(patternPlayActivity);
        this.b = patternPlayActivity;
        this.c = str;
    }

    public void b(boolean z) {
    }

    public void c(int i) {
        this.d = i;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.b.a.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.b.a.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        View viewInflate;
        Pattern pattern = this.b.a.get(i);
        if (view == null) {
            bVar = new b(this);
            viewInflate = this.a.inflate(R.layout.remote_pattern_item, (ViewGroup) null);
            bVar.c = (TextView) viewInflate.findViewById(R.id.pattern_name);
            bVar.d = (ImageView) viewInflate.findViewById(R.id.iv_under_preview);
            bVar.b = (GifImageView) viewInflate.findViewById(R.id.iv_pattern_playing);
            bVar.e = (ImageView) viewInflate.findViewById(R.id.toy_type_1);
            bVar.f = (ImageView) viewInflate.findViewById(R.id.toy_type_2);
            bVar.g = (ImageView) viewInflate.findViewById(R.id.toy_type_3);
            bVar.h = (TextView) viewInflate.findViewById(R.id.pattern_author);
            bVar.i = (TextView) viewInflate.findViewById(R.id.pattern_timer);
            bVar.j = (LinearLayout) viewInflate.findViewById(R.id.pattern_operation);
            viewInflate.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
            viewInflate = view;
        }
        bVar.a = pattern.getId();
        if (this.d == i) {
            bVar.b.setVisibility(0);
        } else {
            bVar.b.setVisibility(8);
        }
        if (((WearUtils.e1(pattern.getIsShowReview()) || !pattern.getIsShowReview().equals("1")) && (WearUtils.e1(pattern.getStatus()) || !pattern.getStatus().equals(AppMeasurementSdk.ConditionalUserProperty.ACTIVE))) || TextUtils.isEmpty(pattern.getPatternStoreTag()) || "MianActivity".equals(this.c) || "ChatActivity".equals(this.c)) {
            bVar.d.setVisibility(8);
            bVar.c.setText(TextUtils.isEmpty(pattern.getName()) ? "" : pattern.getName());
        } else {
            bVar.d.setVisibility(0);
            bVar.c.setText(R.string.patterns_under_review);
        }
        bVar.h.setText(WearUtils.e1(pattern.getAuthor()) ? ah4.e(R.string.common_anonymous) : pattern.getAuthor());
        bVar.i.setText(pattern.getTimer());
        if (WearUtils.e1(pattern.getToyFunc())) {
            if (WearUtils.e1(pattern.getToyTag()) || !pattern.getToyTag().equals("pos")) {
                bVar.e.setImageResource(R.drawable.icon_label_toy_function_vibration);
            } else {
                bVar.e.setImageResource(R.drawable.icon_velvo_position);
            }
            bVar.f.setVisibility(8);
            bVar.g.setVisibility(8);
        } else {
            String[] strArrSplit = pattern.getToyFunc().split(",");
            bVar.f.setVisibility(strArrSplit.length > 1 ? 0 : 8);
            int i2 = 2;
            bVar.g.setVisibility(strArrSplit.length > 2 ? 0 : 8);
            int i3 = 0;
            while (i3 < strArrSplit.length) {
                ImageView imageView = i3 == 0 ? bVar.e : bVar.f;
                if (i3 == i2) {
                    imageView = bVar.g;
                }
                boolean zEquals = TextUtils.equals(strArrSplit[i3], PSOProgramService.VS_Key);
                int i4 = R.drawable.icon_label_toy_function_speed;
                if (zEquals || TextUtils.equals(strArrSplit[i3], "v1")) {
                    if (uu1.b(pattern.getToySymbol())) {
                        imageView.setImageResource(R.drawable.icon_label_toy_function_speed);
                    } else {
                        imageView.setImageResource(R.drawable.icon_label_toy_function_vibration);
                    }
                }
                if (TextUtils.equals(strArrSplit[i3], "v2")) {
                    imageView.setImageResource(R.drawable.icon_label_toy_function_vibration_2);
                }
                if (TextUtils.equals(strArrSplit[i3], "p")) {
                    imageView.setImageResource(R.drawable.icon_label_toy_function_contraction);
                }
                if (TextUtils.equals(strArrSplit[i3], StreamManagement.AckRequest.ELEMENT)) {
                    imageView.setImageResource(R.drawable.icon_label_toy_function_rotation);
                }
                if (TextUtils.equals(strArrSplit[i3], "t")) {
                    if (i3 == 0) {
                        i4 = R.drawable.icon_label_toy_function_thrusting;
                    }
                    imageView.setImageResource(i4);
                }
                if (TextUtils.equals(strArrSplit[i3], "s")) {
                    imageView.setImageResource(R.drawable.icon_white_function_suction);
                }
                if (TextUtils.equals(strArrSplit[i3], "f")) {
                    imageView.setImageResource(R.drawable.icon_label_toy_function_fingering);
                }
                if (TextUtils.equals(strArrSplit[i3], GoogleApiAvailabilityLight.TRACKING_SOURCE_DIALOG)) {
                    imageView.setImageResource(R.drawable.icon_label_toy_function_depth);
                }
                if (TextUtils.equals(strArrSplit[i3], "pos")) {
                    imageView.setImageResource(R.drawable.icon_velvo_position);
                }
                i3++;
                i2 = 2;
            }
        }
        bVar.j.setOnClickListener(new a(pattern));
        this.b.a.get(i).getOnline();
        if (pattern.isSystemPattern()) {
            bVar.j.setVisibility(4);
        } else {
            bVar.j.setVisibility(0);
        }
        if (WearUtils.e1(this.c) || "is_from_vibeMate_pattern".equals(this.c)) {
            bVar.j.setVisibility(8);
        }
        return viewInflate;
    }
}
