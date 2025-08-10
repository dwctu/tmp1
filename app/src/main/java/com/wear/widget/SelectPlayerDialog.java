package com.wear.widget;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.gson.Gson;
import com.lovense.wear.R;
import com.wear.adapter.localmusic.SelectPlayerDialogAdapter;
import com.wear.bean.MusicAPPBean;
import com.wear.util.WearUtils;
import dc.eg3;
import dc.rd3;
import dc.th4;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class SelectPlayerDialog extends BottomDialog {
    public RecyclerView c;
    public RecyclerView d;
    public TextView e;
    public TextView f;
    public List<MusicAPPBean> g;
    public List<MusicAPPBean> h;
    public Context i;
    public d j;
    public SelectPlayerDialogAdapter k;
    public SelectPlayerDialogAdapter l;
    public String m;
    public MusicAPPBean n;

    public class a implements SelectPlayerDialogAdapter.b {
        public a() {
        }

        @Override // com.wear.adapter.localmusic.SelectPlayerDialogAdapter.b
        public void a(MusicAPPBean musicAPPBean) {
            if (musicAPPBean != null) {
                SelectPlayerDialog selectPlayerDialog = SelectPlayerDialog.this;
                selectPlayerDialog.n = musicAPPBean;
                selectPlayerDialog.f.setTextColor(th4.b(selectPlayerDialog.i, R.color.common_dialog_right_text_color));
                SelectPlayerDialog.this.f(musicAPPBean);
            }
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SelectPlayerDialog.this.dismiss();
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SelectPlayerDialog selectPlayerDialog = SelectPlayerDialog.this;
            MusicAPPBean musicAPPBean = selectPlayerDialog.n;
            if (musicAPPBean != null) {
                selectPlayerDialog.j.a(musicAPPBean);
                rd3.f().t(SelectPlayerDialog.this.n.getPackageName());
            }
            SelectPlayerDialog.this.dismiss();
        }
    }

    public interface d {
        void a(MusicAPPBean musicAPPBean);
    }

    public SelectPlayerDialog(Context context, String str) {
        super(context);
        this.g = new ArrayList();
        this.h = new ArrayList();
        this.m = "";
        this.n = null;
        this.i = context;
        this.m = str;
    }

    @Override // com.wear.widget.BottomDialog
    public View b() {
        return LayoutInflater.from(getContext()).inflate(R.layout.dialog_select_player, (ViewGroup) null);
    }

    @Override // com.wear.widget.BottomDialog
    public void c(View view) {
        d();
        this.c = (RecyclerView) view.findViewById(R.id.supported);
        this.d = (RecyclerView) view.findViewById(R.id.notsupported);
        this.e = (TextView) view.findViewById(R.id.tv_white_btn);
        this.f = (TextView) view.findViewById(R.id.tv_red_btn);
        SelectPlayerDialogAdapter selectPlayerDialogAdapter = new SelectPlayerDialogAdapter(this.i, this.g);
        this.k = selectPlayerDialogAdapter;
        selectPlayerDialogAdapter.J0(new a());
        this.c.setLayoutManager(new LinearLayoutManager(this.i));
        this.c.setAdapter(this.k);
        this.l = new SelectPlayerDialogAdapter(this.i, this.h);
        this.d.setLayoutManager(new LinearLayoutManager(this.i));
        this.d.setAdapter(this.l);
        this.e.setOnClickListener(new b());
        this.f.setOnClickListener(new c());
        if (this.n == null) {
            this.f.setBackground(th4.d(this.i, R.drawable.dialog_select_player_gray_btn_bg));
            this.f.setTextColor(th4.b(this.i, R.color.dialog_select_player_gray_btn_textcolor));
        } else {
            this.f.setBackground(th4.d(this.i, R.drawable.common_dialog_btn_right));
            this.f.setTextColor(th4.b(this.i, R.color.common_dialog_right_text_color));
        }
    }

    public void d() {
        MusicAPPBean musicAPPBean = (MusicAPPBean) new Gson().fromJson(eg3.h(getContext(), rd3.n, ""), MusicAPPBean.class);
        ArrayList<MusicAPPBean> arrayList = new ArrayList(rd3.f().a());
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (MusicAPPBean musicAPPBean2 : arrayList) {
            if (!musicAPPBean2.getIsSupport().booleanValue()) {
                this.h.add(musicAPPBean2);
            } else if (musicAPPBean2.getIsInstalled().booleanValue()) {
                arrayList2.add(musicAPPBean2);
            } else {
                musicAPPBean2.setCheck(Boolean.FALSE);
                arrayList3.add(musicAPPBean2);
            }
            if (musicAPPBean != null) {
                if (TextUtils.equals(musicAPPBean2.getPackageName(), musicAPPBean.getPackageName())) {
                    musicAPPBean2.setCheck(Boolean.TRUE);
                }
            } else if (WearUtils.e1(this.m)) {
                if (arrayList2.size() > 0) {
                    ((MusicAPPBean) arrayList2.get(0)).setCheck(Boolean.TRUE);
                }
            } else if (TextUtils.equals(musicAPPBean2.getPackageName(), this.m)) {
                musicAPPBean2.setCheck(Boolean.TRUE);
                this.n = musicAPPBean2;
            }
            if (musicAPPBean2.getIsCheck().booleanValue()) {
                this.n = musicAPPBean2;
            }
        }
        this.g.addAll(arrayList2);
        this.g.addAll(arrayList3);
    }

    public void e(d dVar) {
        this.j = dVar;
    }

    public void f(MusicAPPBean musicAPPBean) {
        for (MusicAPPBean musicAPPBean2 : this.g) {
            musicAPPBean2.setCheck(Boolean.valueOf(TextUtils.equals(musicAPPBean.getPackageName(), musicAPPBean2.getPackageName())));
        }
        this.k.notifyDataSetChanged();
    }
}
