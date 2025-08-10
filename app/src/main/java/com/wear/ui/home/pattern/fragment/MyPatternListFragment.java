package com.wear.ui.home.pattern.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.lovense.wear.R;
import com.wear.bean.Playlist;
import com.wear.main.BaseFragment;
import com.wear.main.account.login.LoginActivity;
import com.wear.main.closeRange.PlayListDetailsDActivity;
import com.wear.main.patterns.MulChoosePatternsActivity;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import com.yydcdut.sdlv.SlideAndDragListView;
import dc.ah4;
import dc.ao3;
import dc.be3;
import dc.cs3;
import dc.dk1;
import dc.do3;
import dc.is3;
import dc.kn3;
import dc.pj3;
import dc.sg3;
import dc.th4;
import dc.ue3;
import dc.ve2;
import dc.we2;
import dc.xe2;
import dc.yu3;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

/* loaded from: classes3.dex */
public class MyPatternListFragment extends BaseFragment implements dk1.b {

    @BindView(R.id.create_pattern)
    public LinearLayout createPattern;

    @BindView(R.id.create_pattern_image)
    public ImageView createPatternImage;

    @BindView(R.id.create_pattern_playout)
    public LinearLayout createPatternPlayout;

    @BindView(R.id.create_tv_text)
    public TextView createTvText;
    public Unbinder l;

    @BindView(R.id.list_empty_notice)
    public TextView listEmptyNotice;
    public dk1 o;
    public Playlist p;

    @BindView(R.id.pattern_list_empty)
    public LinearLayout patternListEmpty;

    @BindView(R.id.pattern_data_list)
    public SlideAndDragListView pattern_list;
    public List<Playlist> k = new ArrayList();
    public we2 m = (we2) xe2.L0();
    public ve2 n = (ve2) xe2.L0();

    public class a implements AdapterView.OnItemClickListener {

        /* renamed from: com.wear.ui.home.pattern.fragment.MyPatternListFragment$a$a, reason: collision with other inner class name */
        public class C0148a extends HashMap<String, String> {
            public C0148a() {
                String str;
                if (MyPatternListFragment.this.k == null) {
                    str = "0";
                } else {
                    str = "" + MyPatternListFragment.this.k.size();
                }
                put("count", str);
                put("play_time", "0");
            }
        }

        public a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            Bundle bundle = new Bundle();
            bundle.putSerializable("choose_patterns_playlist", MyPatternListFragment.this.k.get(i));
            pj3.g(MyPatternListFragment.this.getActivity(), PlayListDetailsDActivity.class, bundle);
            MyPatternListFragment.this.t("pattern_local_play_bylist", new C0148a());
        }
    }

    public class b implements SlideAndDragListView.a {
        public Playlist a = null;

        public b() {
        }

        @Override // com.yydcdut.sdlv.SlideAndDragListView.a
        public void a(int i, int i2) {
            MyPatternListFragment.this.k.add(i2, MyPatternListFragment.this.k.remove(i));
        }

        @Override // com.yydcdut.sdlv.SlideAndDragListView.a
        public void b(int i) {
            MyPatternListFragment.this.k.set(i, this.a);
            LinkedHashMap<String, Playlist> linkedHashMap = new LinkedHashMap<>();
            int size = MyPatternListFragment.this.k.size();
            int i2 = 0;
            for (Playlist playlist : MyPatternListFragment.this.k) {
                i2++;
                playlist.setSortId(size - i2);
                playlist.setLastUpdTime(be3.r());
                linkedHashMap.put(playlist.getId(), playlist);
            }
            MyPatternListFragment.this.m.i(linkedHashMap, true);
            MyPatternListFragment.this.o.notifyDataSetChanged();
        }

        @Override // com.yydcdut.sdlv.SlideAndDragListView.a
        public void c(int i) {
            this.a = MyPatternListFragment.this.k.get(i);
        }
    }

    public class c implements ao3.a {
        public c(MyPatternListFragment myPatternListFragment) {
        }

        @Override // dc.ao3.a
        public void a(ao3 ao3Var) {
        }

        @Override // dc.ao3.a
        public void b(ao3 ao3Var) {
        }
    }

    public class d implements View.OnClickListener {
        public final /* synthetic */ ao3 a;

        public d(ao3 ao3Var) {
            this.a = ao3Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.a.dismiss();
            MyPatternListFragment.this.e0(ah4.e(R.string.pattern_playlist_name), ah4.e(R.string.pattern_playlist_name), MyPatternListFragment.this.p == null ? "" : MyPatternListFragment.this.p.getName());
        }
    }

    public class e implements View.OnClickListener {
        public final /* synthetic */ ao3 a;

        public class a implements is3.d {
            public a() {
            }

            @Override // dc.is3.d
            public void doConfirm() {
                MyPatternListFragment.this.d0();
            }
        }

        public e(ao3 ao3Var) {
            this.a = ao3Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.a.dismiss();
            cs3.c(MyPatternListFragment.this.getActivity(), ah4.e(R.string.toy_playlist_delete), ah4.e(R.string.common_yes), ah4.e(R.string.common_no), new a()).show();
        }
    }

    public class f implements kn3.c {
        public final /* synthetic */ do3 a;

        public f(do3 do3Var) {
            this.a = do3Var;
        }

        @Override // dc.kn3.c
        public boolean a() {
            String string = this.a.a().getText().toString();
            if (WearUtils.e1(string)) {
                sg3.i(MyPatternListFragment.this.getActivity(), R.string.playlist_name_empty);
                return false;
            }
            if (!WearUtils.S0(string)) {
                return true;
            }
            sg3.i(MyPatternListFragment.this.getActivity(), R.string.input_string_error);
            return false;
        }
    }

    public class g implements kn3.d {
        public final /* synthetic */ do3 a;

        public g(do3 do3Var) {
            this.a = do3Var;
        }

        @Override // dc.kn3.d
        public void doCancel() {
            ue3.a(this.a.a(), MyPatternListFragment.this.getActivity());
        }

        @Override // dc.kn3.d
        public void doConfirm() {
            MyPatternListFragment.this.p.setName(this.a.a().getText().toString().trim());
            MyPatternListFragment.this.p.setLastUpdTime(be3.r());
            MyPatternListFragment myPatternListFragment = MyPatternListFragment.this;
            myPatternListFragment.m.c(myPatternListFragment.p, true);
            ue3.a(this.a.a(), MyPatternListFragment.this.getActivity());
            MyPatternListFragment.this.onResume();
        }
    }

    public final void c0() {
        this.k.clear();
        List<Playlist> listN = this.m.N(WearUtils.y.r());
        if (listN != null) {
            this.k.addAll(listN);
        }
        this.pattern_list.setOnDragDropListener(new b());
        if (this.k.size() == 0) {
            this.createPattern.setVisibility(8);
            this.createPatternPlayout.setVisibility(8);
            this.pattern_list.setVisibility(8);
        } else {
            this.createPattern.setVisibility(0);
            this.createPatternPlayout.setVisibility(0);
            this.pattern_list.setVisibility(0);
        }
        this.o.notifyDataSetChanged();
    }

    public void d0() {
        this.m.a(this.p, true);
        this.n.M(this.n.I(WearUtils.y.r(), this.p.getId()), false);
        this.k.remove(this.p);
        this.o.notifyDataSetChanged();
        if (this.k.size() == 0) {
            this.createPattern.setVisibility(8);
            this.createPatternPlayout.setVisibility(8);
            this.pattern_list.setVisibility(8);
        } else {
            this.createPattern.setVisibility(0);
            this.createPatternPlayout.setVisibility(0);
            this.pattern_list.setVisibility(0);
        }
    }

    public final void e0(String str, String str2, String str3) {
        do3 do3Var = new do3(getActivity(), ah4.e(R.string.common_save), ah4.e(R.string.common_cancel));
        do3Var.g(str);
        do3Var.i(str2);
        do3Var.h(str3);
        do3Var.a().setFilters(new InputFilter[]{new InputFilter.LengthFilter(30)});
        do3Var.b(new f(do3Var));
        do3Var.e();
        do3Var.c(new g(do3Var));
        do3Var.a().requestFocus();
        ue3.d(do3Var.a(), getActivity());
    }

    public void f0(View view, boolean z) {
        ao3 ao3Var = new ao3(getActivity(), R.style.MenuDialogAl, R.layout.select_menu_2_item);
        ao3Var.a(view, 250, 200, 5160, -30, new c(this));
        ao3Var.findViewById(R.id.action_row_1).setOnClickListener(new d(ao3Var));
        ao3Var.findViewById(R.id.action_row_2).setOnClickListener(new e(ao3Var));
        ((TextView) ao3Var.findViewById(R.id.action_row_1_text)).setText(ah4.e(R.string.common_rename));
        ((TextView) ao3Var.findViewById(R.id.action_row_2_text)).setText(ah4.e(R.string.common_delete));
        ao3Var.show();
    }

    public final void g0() {
        cs3.k(getActivity(), ah4.e(R.string.offline_unlock_account), null).show();
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_my_pattern_list, (ViewGroup) null);
        this.l = ButterKnife.bind(this, viewInflate);
        M(WearUtils.x);
        this.createTvText.setText(ah4.e(R.string.playlist_create));
        this.listEmptyNotice.setText(ah4.e(R.string.playlist_create));
        this.pattern_list.setMenu(new yu3(false, 0));
        this.pattern_list.setCacheColorHint(th4.b(getContext(), R.color.pattern_item_drag_bg));
        dk1 dk1Var = new dk1(this.k, getActivity(), R.layout.home_pattern_list_item);
        this.o = dk1Var;
        dk1Var.c(this);
        this.pattern_list.setAdapter((ListAdapter) this.o);
        c0();
        this.pattern_list.setOnItemClickListener(new a());
        return viewInflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.l.unbind();
    }

    @Override // com.wear.main.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        c0();
    }

    @OnClick({R.id.create_pattern, R.id.create_pattern_playout, R.id.create_pattern_image})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.create_pattern /* 2131362472 */:
            case R.id.create_pattern_image /* 2131362473 */:
            case R.id.create_pattern_playout /* 2131362474 */:
                if (!MyApplication.Z && !MyApplication.O) {
                    pj3.f(getActivity(), LoginActivity.class);
                    getActivity().finish();
                    break;
                } else {
                    Intent intent = new Intent(getActivity(), (Class<?>) MulChoosePatternsActivity.class);
                    intent.putExtra("choose_patterns_playlist_id", "create");
                    startActivity(intent);
                    break;
                }
                break;
        }
    }

    @Override // dc.dk1.b
    public void s(View view, Playlist playlist) {
        if (!playlist.getEmail().equals(WearUtils.y.r())) {
            g0();
        } else {
            this.p = playlist;
            f0(view, false);
        }
    }
}
