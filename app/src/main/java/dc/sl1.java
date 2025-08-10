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
import com.wear.main.longDistance.PatternSendActivity;
import com.wear.util.WearUtils;
import org.jivesoftware.smack.sm.packet.StreamManagement;

/* compiled from: PatternSendAdapter.java */
/* loaded from: classes3.dex */
public class sl1 extends BaseAdapter {
    public LayoutInflater a;
    public PatternSendActivity b;

    /* compiled from: PatternSendAdapter.java */
    public class a {
        public String a;
        public TextView b;
        public TextView c;
        public TextView d;
        public ImageView e;
        public ImageView f;
        public ImageView g;
        public TextView h;
        public ImageView i;

        public a(sl1 sl1Var) {
        }
    }

    public sl1(PatternSendActivity patternSendActivity) {
        this.a = null;
        this.b = patternSendActivity;
        this.a = LayoutInflater.from(patternSendActivity);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.b.f.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.b.f.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View viewInflate;
        a aVar;
        Pattern pattern = this.b.f.get(i);
        if (view == null) {
            aVar = new a(this);
            viewInflate = this.a.inflate(R.layout.long_pattern_send_item, (ViewGroup) null);
            aVar.b = (TextView) viewInflate.findViewById(R.id.pattern_name);
            aVar.c = (TextView) viewInflate.findViewById(R.id.pattern_author);
            aVar.d = (TextView) viewInflate.findViewById(R.id.pattern_timer);
            aVar.e = (ImageView) viewInflate.findViewById(R.id.toy_type_1);
            aVar.f = (ImageView) viewInflate.findViewById(R.id.toy_type_2);
            aVar.g = (ImageView) viewInflate.findViewById(R.id.toy_type_3);
            aVar.h = (TextView) viewInflate.findViewById(R.id.pattern_toy_name);
            aVar.i = (ImageView) viewInflate.findViewById(R.id.pattern_select_icon);
            viewInflate.setTag(aVar);
        } else {
            viewInflate = view;
            aVar = (a) view.getTag();
        }
        aVar.a = pattern.getId();
        aVar.b.setText(pattern.getName());
        aVar.c.setText(WearUtils.e1(pattern.getAuthor()) ? ah4.e(R.string.common_anonymous) : pattern.getAuthor());
        aVar.d.setText(pattern.getTimer());
        aVar.i.setImageDrawable(th4.d(this.b, R.drawable.chat_pattern_item_unselect));
        PatternSendActivity patternSendActivity = this.b;
        if (i == patternSendActivity.e) {
            aVar.i.setImageDrawable(th4.d(patternSendActivity, R.drawable.chat_pattern_item_select));
        }
        int i2 = 0;
        if (pattern.getToyName() != null) {
            aVar.h.setText(ng3.c(pattern.getToyName(), pattern.getToyVersion()));
            aVar.h.setVisibility(0);
        } else {
            String strD = ng3.d(pattern.getToyFunc(), pattern.getCdtTime(), pattern.getToyFeature());
            if (WearUtils.e1(Toy.getFullName(strD))) {
                aVar.h.setVisibility(8);
            } else {
                aVar.h.setVisibility(0);
                aVar.h.setText(ng3.c(Toy.getFullName(strD), pattern.getToyVersion()));
            }
        }
        if (WearUtils.e1(pattern.getToyFunc())) {
            aVar.e.setImageResource(R.drawable.icon_label_toy_function_vibration);
            aVar.f.setVisibility(8);
            aVar.g.setVisibility(8);
        } else {
            String[] strArrSplit = pattern.getToyFunc().split(",");
            aVar.f.setVisibility(strArrSplit.length > 1 ? 0 : 8);
            aVar.g.setVisibility(strArrSplit.length > 2 ? 0 : 8);
            while (i2 < strArrSplit.length) {
                ImageView imageView = i2 == 0 ? aVar.e : aVar.f;
                if (i2 == 2) {
                    imageView = aVar.g;
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
