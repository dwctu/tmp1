package dc;

import android.app.Activity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.lovense.wear.R;
import com.wear.bean.Playlist;
import com.wear.util.WearUtils;
import java.util.List;

/* compiled from: PlaylistAdapter.java */
/* loaded from: classes3.dex */
public class dk1 extends vj1<Playlist> {
    public b d;

    /* compiled from: PlaylistAdapter.java */
    public class a implements View.OnClickListener {
        public final /* synthetic */ Playlist a;

        public a(Playlist playlist) {
            this.a = playlist;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b bVar = dk1.this.d;
            if (bVar != null) {
                bVar.s(view, this.a);
            }
        }
    }

    /* compiled from: PlaylistAdapter.java */
    public interface b {
        void s(View view, Playlist playlist);
    }

    public dk1(List<Playlist> list, Activity activity, int i) {
        super(list, activity, i);
    }

    public void c(b bVar) {
        this.d = bVar;
    }

    @Override // dc.vj1
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void b(wj1 wj1Var, Playlist playlist, int i) {
        View viewA = wj1Var.a();
        TextView textView = (TextView) viewA.findViewById(R.id.pattern_name);
        ImageView imageView = (ImageView) viewA.findViewById(R.id.pattern_state_icon);
        LinearLayout linearLayout = (LinearLayout) viewA.findViewById(R.id.pattern_operation);
        ImageView imageView2 = (ImageView) viewA.findViewById(R.id.pattern_operation_image);
        ImageView imageView3 = (ImageView) wj1Var.b(R.id.iv_sync_status);
        imageView.setVisibility(0);
        textView.setText(playlist.getName());
        linearLayout.setOnClickListener(new a(playlist));
        if (playlist.getEmail() == null || !playlist.getEmail().equals(WearUtils.y.r())) {
            linearLayout.setAlpha(0.4f);
            imageView2.setBackgroundResource(R.drawable.content_icon_more_b);
        } else {
            linearLayout.setAlpha(1.0f);
            imageView2.setBackgroundResource(R.drawable.home_pattern_more);
        }
        if (playlist.syncSuc() || !ch3.n().X()) {
            imageView3.setVisibility(8);
        } else {
            imageView3.setVisibility(0);
        }
    }
}
