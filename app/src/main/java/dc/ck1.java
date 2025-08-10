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
import com.lovense.wear.R;
import com.wear.bean.Pattern;
import com.wear.bean.Playlist;
import com.wear.bean.PlaylistItems;
import com.wear.bean.Toy;
import com.wear.main.closeRange.PlayListDetailsDActivity;
import com.wear.util.WearUtils;
import org.jivesoftware.smack.sm.packet.StreamManagement;

/* compiled from: PlayListDetailsAdapter.java */
/* loaded from: classes3.dex */
public class ck1 extends BaseAdapter {
    public Playlist a;
    public ve2 b = (ve2) xe2.L0();
    public LayoutInflater c;
    public PlayListDetailsDActivity d;

    /* compiled from: PlayListDetailsAdapter.java */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            sg3.i(ck1.this.d, R.string.patterns_reported_notice);
        }
    }

    /* compiled from: PlayListDetailsAdapter.java */
    public class b implements View.OnClickListener {
        public final /* synthetic */ Pattern a;

        public b(Pattern pattern) {
            this.a = pattern;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!this.a.getEmail().equals(WearUtils.y.r())) {
                ck1.this.d.showUnlockAccount();
                return;
            }
            PlayListDetailsDActivity playListDetailsDActivity = ck1.this.d;
            Pattern pattern = this.a;
            playListDetailsDActivity.a = pattern;
            ck1.this.d.C4(view, !pattern.isDownload() && this.a.getCreator().equals(WearUtils.y.r()), this.a.isShared());
        }
    }

    /* compiled from: PlayListDetailsAdapter.java */
    public class c {
        public String a;
        public TextView b;
        public ImageView c;
        public ImageView d;
        public ImageView e;
        public TextView f;
        public TextView g;
        public TextView h;
        public LinearLayout i;
        public ImageView j;
        public ImageView k;

        public c(ck1 ck1Var) {
        }
    }

    public ck1(PlayListDetailsDActivity playListDetailsDActivity, Playlist playlist) {
        this.c = null;
        this.c = LayoutInflater.from(playListDetailsDActivity);
        this.d = playListDetailsDActivity;
        this.a = playlist;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.d.b.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.d.b.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        c cVar;
        Playlist playlist;
        PlaylistItems playlistItemsU;
        Pattern pattern = this.d.b.get(i);
        if (view == null) {
            c cVar2 = new c(this);
            View viewInflate = this.c.inflate(R.layout.remote_pattern_item, (ViewGroup) null);
            cVar2.b = (TextView) viewInflate.findViewById(R.id.pattern_name);
            cVar2.c = (ImageView) viewInflate.findViewById(R.id.toy_type_1);
            cVar2.d = (ImageView) viewInflate.findViewById(R.id.toy_type_2);
            cVar2.e = (ImageView) viewInflate.findViewById(R.id.toy_type_3);
            cVar2.f = (TextView) viewInflate.findViewById(R.id.pattern_author);
            cVar2.g = (TextView) viewInflate.findViewById(R.id.pattern_timer);
            cVar2.h = (TextView) viewInflate.findViewById(R.id.pattern_toy_name);
            cVar2.i = (LinearLayout) viewInflate.findViewById(R.id.pattern_operation);
            cVar2.j = (ImageView) viewInflate.findViewById(R.id.pattern_operation_image);
            cVar2.k = (ImageView) viewInflate.findViewById(R.id.iv_sync_status);
            viewInflate.setTag(cVar2);
            cVar = cVar2;
            view = viewInflate;
        } else {
            cVar = (c) view.getTag();
        }
        TextView textView = (TextView) view.findViewById(R.id.shear_action);
        textView.setVisibility(8);
        if (pattern.isShared() || pattern.isDownload()) {
            textView.setVisibility(0);
            textView.setTextColor(this.d.getResources().getColor(R.color.color_accent));
            textView.setText(ah4.e(R.string.common_shared));
            textView.setOnClickListener(null);
            if (!WearUtils.e1(pattern.getStatus()) && pattern.getStatus().toLowerCase().equals("report")) {
                textView.setTextColor(this.d.getResources().getColor(R.color.text_secondary_light));
                textView.setText(ah4.e(R.string.patterns_reported));
                textView.setOnClickListener(new a());
            }
        }
        cVar.a = pattern.getId();
        cVar.b.setText(pattern.getName());
        cVar.f.setText(WearUtils.e1(pattern.getAuthor()) ? ah4.e(R.string.common_anonymous) : pattern.getAuthor());
        if (WearUtils.e1(pattern.getToyName())) {
            String strD = !WearUtils.e1(pattern.getToyTag()) ? ng3.d(pattern.getToyTag(), pattern.getCdtTime(), pattern.getToyFeature()) : ng3.d(pattern.getToyFunc(), pattern.getCdtTime(), pattern.getToyFeature());
            if (WearUtils.e1(Toy.getFullName(strD))) {
                cVar.h.setVisibility(8);
            } else {
                cVar.h.setVisibility(0);
                cVar.h.setText(ng3.c(Toy.getFullName(strD), pattern.getToyVersion()));
            }
        } else {
            cVar.h.setText(ng3.c(pattern.getToyName(), pattern.getToyVersion()));
            cVar.h.setVisibility(0);
        }
        cVar.g.setText(pattern.getTimer());
        cVar.i.setOnClickListener(new b(pattern));
        if (pattern.getEmail().equals(WearUtils.y.r())) {
            cVar.i.setAlpha(1.0f);
            cVar.j.setBackgroundResource(R.drawable.content_icon_more);
        } else {
            cVar.i.setAlpha(0.4f);
            cVar.j.setBackgroundResource(R.drawable.content_icon_more_b);
        }
        if (WearUtils.e1(pattern.getToyFunc())) {
            cVar.c.setImageResource(R.drawable.icon_label_toy_function_vibration);
            cVar.d.setVisibility(8);
            cVar.e.setVisibility(8);
        } else {
            String[] strArrSplit = pattern.getToyFunc().split(",");
            cVar.d.setVisibility(strArrSplit.length > 1 ? 0 : 8);
            cVar.e.setVisibility(strArrSplit.length > 2 ? 0 : 8);
            int i2 = 0;
            while (i2 < strArrSplit.length) {
                ImageView imageView = i2 == 0 ? cVar.c : cVar.d;
                if (i2 == 2) {
                    imageView = cVar.e;
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
        if ((!ch3.n().X() || (playlist = this.a) == null || (playlistItemsU = this.b.u(playlist.getId(), pattern.getId())) == null) ? false : !playlistItemsU.syncSuc()) {
            cVar.k.setVisibility(0);
        } else {
            cVar.k.setVisibility(8);
        }
        return view;
    }
}
