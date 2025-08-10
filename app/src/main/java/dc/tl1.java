package dc;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.epicgames.unreal.psoservices.PSOProgramService;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.lovense.wear.R;
import com.wear.bean.Pattern;
import com.wear.bean.Toy;
import com.wear.main.patterns.SingleChoosePatternsActivity;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import org.jivesoftware.smack.sm.packet.StreamManagement;

/* compiled from: PatternSingleChooseAdapter.java */
/* loaded from: classes3.dex */
public class tl1 extends BaseAdapter {
    public LayoutInflater a;
    public SingleChoosePatternsActivity b;

    /* compiled from: PatternSingleChooseAdapter.java */
    public class a {
        public TextView a;
        public TextView b;
        public TextView c;
        public ImageView d;
        public ImageView e;
        public ImageView f;
        public ImageView g;
        public TextView h;

        public a(tl1 tl1Var) {
        }
    }

    public tl1(SingleChoosePatternsActivity singleChoosePatternsActivity, MyApplication myApplication) {
        this.a = null;
        this.a = LayoutInflater.from(singleChoosePatternsActivity);
        this.b = singleChoosePatternsActivity;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.b.h.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.b.h.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        Pattern pattern = this.b.h.get(i);
        a aVar = new a(this);
        View viewInflate = this.a.inflate(R.layout.long_pattern_send_item, (ViewGroup) null);
        aVar.a = (TextView) viewInflate.findViewById(R.id.pattern_name);
        aVar.b = (TextView) viewInflate.findViewById(R.id.pattern_author);
        aVar.c = (TextView) viewInflate.findViewById(R.id.pattern_timer);
        aVar.d = (ImageView) viewInflate.findViewById(R.id.toy_type_1);
        aVar.e = (ImageView) viewInflate.findViewById(R.id.toy_type_2);
        aVar.f = (ImageView) viewInflate.findViewById(R.id.toy_type_3);
        aVar.g = (ImageView) viewInflate.findViewById(R.id.pattern_select_icon);
        aVar.h = (TextView) viewInflate.findViewById(R.id.pattern_toy_name);
        viewInflate.setTag(aVar);
        pattern.getId();
        aVar.a.setText(pattern.getName());
        aVar.b.setText(WearUtils.e1(pattern.getAuthor()) ? ah4.e(R.string.common_anonymous) : pattern.getAuthor());
        aVar.c.setText(pattern.getTimer());
        int i2 = 0;
        aVar.g.setVisibility(0);
        if (WearUtils.e1(pattern.getToyName())) {
            String strD = pattern.getToyTag() != null ? ng3.d(pattern.getToyTag(), pattern.getCdtTime(), pattern.getToyFeature()) : ng3.d(pattern.getToyFunc(), pattern.getCdtTime(), pattern.getToyFeature());
            if (WearUtils.e1(Toy.getFullName(strD))) {
                aVar.h.setVisibility(8);
            } else {
                aVar.h.setVisibility(0);
                aVar.h.setText(ng3.c(Toy.getFullName(strD), pattern.getToyVersion()));
            }
        } else {
            aVar.h.setText(ng3.c(pattern.getToyName(), pattern.getToyVersion()));
            aVar.h.setVisibility(0);
        }
        if (this.b.f.equals(pattern.getId())) {
            aVar.g.setImageResource(R.drawable.chat_pattern_item_select);
        } else {
            aVar.g.setImageResource(R.drawable.chat_pattern_item_unselect);
        }
        if (WearUtils.e1(pattern.getToyFunc())) {
            aVar.d.setImageResource(R.drawable.icon_label_toy_function_vibration);
            aVar.e.setVisibility(8);
            aVar.f.setVisibility(8);
        } else {
            String[] strArrSplit = pattern.getToyFunc().split(",");
            aVar.e.setVisibility(strArrSplit.length > 1 ? 0 : 8);
            aVar.f.setVisibility(strArrSplit.length > 2 ? 0 : 8);
            while (i2 < strArrSplit.length) {
                ImageView imageView = i2 == 0 ? aVar.d : aVar.e;
                if (i2 == 2) {
                    imageView = aVar.f;
                }
                boolean zEquals = TextUtils.equals(strArrSplit[i2], PSOProgramService.VS_Key);
                int i3 = R.drawable.icon_label_toy_function_speed;
                if (zEquals || TextUtils.equals(strArrSplit[i2], "v1")) {
                    if (uu1.b(pattern.getToySymbol())) {
                        imageView.setImageResource(R.drawable.icon_label_toy_function_speed);
                    } else {
                        imageView.setImageResource(R.drawable.icon_label_toy_function_vibration);
                    }
                }
                if (TextUtils.equals(strArrSplit[i2], "v2")) {
                    imageView.setImageResource(R.drawable.icon_label_toy_function_vibration_2);
                }
                if (TextUtils.equals(strArrSplit[i2], "p")) {
                    imageView.setImageResource(R.drawable.icon_label_toy_function_contraction);
                }
                if (TextUtils.equals(strArrSplit[i2], StreamManagement.AckRequest.ELEMENT)) {
                    imageView.setImageResource(R.drawable.icon_label_toy_function_rotation);
                }
                if (TextUtils.equals(strArrSplit[i2], "t")) {
                    if (i2 == 0) {
                        i3 = R.drawable.icon_label_toy_function_thrusting;
                    }
                    imageView.setImageResource(i3);
                }
                if (TextUtils.equals(strArrSplit[i2], "s")) {
                    imageView.setImageResource(R.drawable.icon_white_function_suction);
                }
                if (TextUtils.equals(strArrSplit[i2], "f")) {
                    imageView.setImageResource(R.drawable.icon_label_toy_function_fingering);
                }
                if (TextUtils.equals(strArrSplit[i2], GoogleApiAvailabilityLight.TRACKING_SOURCE_DIALOG)) {
                    imageView.setImageResource(R.drawable.icon_label_toy_function_depth);
                }
                if (TextUtils.equals(strArrSplit[i2], "pos")) {
                    imageView.setImageResource(R.drawable.icon_velvo_position);
                }
                i2++;
            }
        }
        return viewInflate;
    }
}
