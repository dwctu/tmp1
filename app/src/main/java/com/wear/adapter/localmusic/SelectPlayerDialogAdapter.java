package com.wear.adapter.localmusic;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.lovense.wear.R;
import com.wear.bean.MusicAPPBean;
import dc.th4;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes3.dex */
public class SelectPlayerDialogAdapter extends BaseQuickAdapter<MusicAPPBean, BaseViewHolder> {
    public Context A;
    public b B;
    public List<MusicAPPBean> z;

    public class a implements View.OnClickListener {
        public final /* synthetic */ MusicAPPBean a;

        public a(MusicAPPBean musicAPPBean) {
            this.a = musicAPPBean;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MusicAPPBean musicAPPBean;
            if (this.a.getIsSupport().booleanValue() && this.a.getIsInstalled().booleanValue() && (musicAPPBean = (MusicAPPBean) view.getTag()) != null) {
                SelectPlayerDialogAdapter.this.B.a(musicAPPBean);
            }
        }
    }

    public interface b {
        void a(MusicAPPBean musicAPPBean);
    }

    public SelectPlayerDialogAdapter(Context context, List<MusicAPPBean> list) {
        super(R.layout.dialog_item_select_player, list);
        this.z = list;
        this.A = context;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    @SuppressLint({"UseCompatLoadingForDrawables"})
    /* renamed from: I0, reason: merged with bridge method [inline-methods] */
    public void C(@NotNull BaseViewHolder baseViewHolder, MusicAPPBean musicAPPBean) {
        ImageView imageView = (ImageView) baseViewHolder.getView(R.id.iv_app_name);
        FrameLayout frameLayout = (FrameLayout) baseViewHolder.getView(R.id.ll_item);
        TextView textView = (TextView) baseViewHolder.getView(R.id.tv_app_name);
        textView.setText(musicAPPBean.getLabel());
        if (musicAPPBean.getIsCheck().booleanValue()) {
            imageView.setVisibility(0);
        } else {
            imageView.setVisibility(8);
        }
        if (!musicAPPBean.getIsSupport().booleanValue() || !musicAPPBean.getIsInstalled().booleanValue()) {
            textView.setTextColor(th4.b(this.A, R.color.textcolor_select_player_adapter_un));
        } else if (musicAPPBean.getIsCheck().booleanValue()) {
            textView.setTextColor(th4.b(this.A, R.color.textcolor_selected_player_adapter));
        } else {
            textView.setTextColor(th4.b(this.A, R.color.textcolor_selectun_supported_player_adapter));
        }
        frameLayout.setTag(musicAPPBean);
        frameLayout.setOnClickListener(new a(musicAPPBean));
    }

    public void J0(b bVar) {
        this.B = bVar;
    }
}
