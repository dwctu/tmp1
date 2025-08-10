package com.wear.main.closeRange;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.lovense.wear.R;
import com.wear.BaseActivity;
import com.wear.bean.Pattern;
import com.wear.bean.Playlist;
import com.wear.bean.PlaylistItems;
import com.wear.bean.Toy;
import com.wear.main.patterns.MulChoosePatternsActivity;
import com.wear.main.patterns.SharePatternActivity;
import com.wear.main.toy.ToyActivity;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import com.wear.widget.MyActionBar;
import com.yydcdut.sdlv.SlideAndDragListView;
import dc.ah4;
import dc.ao3;
import dc.ch3;
import dc.ck1;
import dc.cs3;
import dc.do3;
import dc.is3;
import dc.kn3;
import dc.na2;
import dc.pj3;
import dc.sg3;
import dc.te2;
import dc.th4;
import dc.ue2;
import dc.ue3;
import dc.ve2;
import dc.xe2;
import dc.y12;
import dc.yu3;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import org.greenrobot.eventbus.EventBus;

/* loaded from: classes3.dex */
public class PlayListDetailsDActivity extends BaseActivity implements te2.b {
    public Pattern a;
    public int d;
    public MyActionBar e;
    public SlideAndDragListView f;
    public LinearLayout g;
    public LinearLayout h;
    public TextView i;
    public TextView j;
    public TextView k;
    public View l;
    public ck1 m;
    public Playlist o;
    public List<Pattern> b = new ArrayList();
    public ve2 c = (ve2) xe2.L0();
    public List<PlaylistItems> n = new ArrayList();

    public class a implements View.OnClickListener {
        public final /* synthetic */ ao3 a;

        public a(ao3 ao3Var) {
            this.a = ao3Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.a.dismiss();
            PlayListDetailsDActivity playListDetailsDActivity = PlayListDetailsDActivity.this;
            String strE = ah4.e(R.string.pattern_name);
            String strE2 = ah4.e(R.string.pattern_name);
            Pattern pattern = PlayListDetailsDActivity.this.a;
            playListDetailsDActivity.B4(strE, strE2, pattern == null ? "" : pattern.getName());
        }
    }

    public class b implements View.OnClickListener {
        public final /* synthetic */ ao3 a;

        public class a implements is3.d {
            public a() {
            }

            @Override // dc.is3.d
            public void doConfirm() {
                PlayListDetailsDActivity.this.A4();
            }
        }

        public b(ao3 ao3Var) {
            this.a = ao3Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.a.dismiss();
            cs3.c(PlayListDetailsDActivity.this, ah4.e(R.string.toy_program_delete_pattern), ah4.e(R.string.common_yes), ah4.e(R.string.common_no), new a()).show();
        }
    }

    public class c implements kn3.c {
        public final /* synthetic */ do3 a;

        public c(do3 do3Var) {
            this.a = do3Var;
        }

        @Override // dc.kn3.c
        public boolean a() {
            if (!WearUtils.e1(this.a.a().getText().toString())) {
                return true;
            }
            sg3.i(PlayListDetailsDActivity.this, R.string.pattern_name_empty);
            return false;
        }
    }

    public class d implements kn3.d {
        public final /* synthetic */ do3 a;

        public d(do3 do3Var) {
            this.a = do3Var;
        }

        @Override // dc.kn3.d
        public void doCancel() {
            ue3.a(this.a.a(), PlayListDetailsDActivity.this);
        }

        @Override // dc.kn3.d
        public void doConfirm() {
            String string = this.a.a().getText().toString();
            Pattern patternK = xe2.L0().K(PlayListDetailsDActivity.this.a.getId());
            patternK.setName(string);
            xe2.L0().E(patternK, true);
            ue3.a(this.a.a(), PlayListDetailsDActivity.this);
            PlayListDetailsDActivity.this.onResume();
        }
    }

    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            PlayListDetailsDActivity.this.y4();
        }
    }

    public class f implements Runnable {
        public f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            PlayListDetailsDActivity.this.y4();
        }
    }

    public class g implements MyActionBar.f {
        public g() {
        }

        @Override // com.wear.widget.MyActionBar.f
        public void performAction(View view) {
            pj3.f(PlayListDetailsDActivity.this, ToyActivity.class);
        }
    }

    public class h implements View.OnClickListener {
        public h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (na2.m().i()) {
                na2.m().t();
                return;
            }
            if (!WearUtils.e1(PlayListDetailsDActivity.this.o.getEmail()) && !PlayListDetailsDActivity.this.o.getEmail().equals(WearUtils.y.r())) {
                PlayListDetailsDActivity.this.showUnlockAccount();
                return;
            }
            Intent intent = new Intent(PlayListDetailsDActivity.this, (Class<?>) MulChoosePatternsActivity.class);
            intent.putExtra("choose_patterns_playlist_id", PlayListDetailsDActivity.this.o.getId());
            PlayListDetailsDActivity.this.startActivity(intent);
        }
    }

    public class i implements AdapterView.OnItemLongClickListener {
        public i(PlayListDetailsDActivity playListDetailsDActivity) {
        }

        @Override // android.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            return false;
        }
    }

    public class j implements AdapterView.OnItemClickListener {
        public j() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (na2.m().i()) {
                na2.m().t();
            } else if (y12.c.a().s(y12.c.TYPE_PATTERN)) {
                PlayListDetailsDActivity.this.z4(i);
            }
        }
    }

    public class k implements SlideAndDragListView.a {
        public Pattern a = null;

        public k() {
        }

        @Override // com.yydcdut.sdlv.SlideAndDragListView.a
        public void a(int i, int i2) {
            PlayListDetailsDActivity.this.b.add(i2, PlayListDetailsDActivity.this.b.remove(i));
        }

        @Override // com.yydcdut.sdlv.SlideAndDragListView.a
        public void b(int i) {
            PlayListDetailsDActivity.this.b.set(i, this.a);
            LinkedHashMap<String, PlaylistItems> linkedHashMap = new LinkedHashMap<>();
            int size = PlayListDetailsDActivity.this.b.size();
            int i2 = 0;
            for (Pattern pattern : PlayListDetailsDActivity.this.b) {
                for (PlaylistItems playlistItems : PlayListDetailsDActivity.this.n) {
                    if (playlistItems != null && pattern.getId().equals(playlistItems.getPatternId())) {
                        i2++;
                        playlistItems.setSortId(size - i2);
                        playlistItems.setLastUpdTime(System.currentTimeMillis());
                        linkedHashMap.put(playlistItems.getId(), playlistItems);
                    }
                }
            }
            PlayListDetailsDActivity.this.c.o(linkedHashMap, true);
        }

        @Override // com.yydcdut.sdlv.SlideAndDragListView.a
        public void c(int i) {
            this.a = PlayListDetailsDActivity.this.b.get(i);
        }
    }

    public class l implements ue2.a {
        public l() {
        }

        @Override // dc.ue2.a
        public void a(int i, String str) {
            if (!ch3.n().X()) {
                sg3.i(PlayListDetailsDActivity.this, R.string.file_notfound);
                PlayListDetailsDActivity.this.A4();
            } else {
                sg3.k(PlayListDetailsDActivity.this, String.format(ah4.e(R.string.pattern_play_failed), PlayListDetailsDActivity.this.a.getName()));
                PlayListDetailsDActivity playListDetailsDActivity = PlayListDetailsDActivity.this;
                playListDetailsDActivity.z4(playListDetailsDActivity.d + 1);
            }
        }

        @Override // dc.ue2.a
        public void b(File file) {
            Bundle bundle = new Bundle();
            bundle.putSerializable("pattern", PlayListDetailsDActivity.this.a);
            bundle.putSerializable("from", "MianActivity");
            ((xe2) xe2.L0()).J1(PlayListDetailsDActivity.this.b);
            pj3.g(PlayListDetailsDActivity.this, PatternPlayActivity.class, bundle);
        }
    }

    public class m implements ao3.a {
        public m(PlayListDetailsDActivity playListDetailsDActivity) {
        }

        @Override // dc.ao3.a
        public void a(ao3 ao3Var) {
        }

        @Override // dc.ao3.a
        public void b(ao3 ao3Var) {
        }
    }

    public class n implements View.OnClickListener {
        public final /* synthetic */ ao3 a;

        public n(ao3 ao3Var) {
            this.a = ao3Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.a.dismiss();
            Bundle bundle = new Bundle();
            bundle.putString("patternId", PlayListDetailsDActivity.this.a.getId());
            bundle.putBoolean("isUpdate", PlayListDetailsDActivity.this.a.isShared());
            if (!WearUtils.e1(PlayListDetailsDActivity.this.a.getToyFeature())) {
                bundle.putString("toyFeature", PlayListDetailsDActivity.this.a.getToyFeature());
            }
            if (PlayListDetailsDActivity.this.a.getToySymbol() != null) {
                bundle.putString("toySymbol", PlayListDetailsDActivity.this.a.getToySymbol());
            }
            if (PlayListDetailsDActivity.this.a.getToyName() != null) {
                bundle.putString("toyName", PlayListDetailsDActivity.this.a.getToyName());
            }
            if (PlayListDetailsDActivity.this.a.getToyVersion() != null) {
                bundle.putString("toyVersion", PlayListDetailsDActivity.this.a.getToyVersion());
            }
            pj3.g(PlayListDetailsDActivity.this, SharePatternActivity.class, bundle);
        }
    }

    public class o implements View.OnClickListener {
        public final /* synthetic */ ao3 a;

        public o(ao3 ao3Var) {
            this.a = ao3Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.a.dismiss();
            Bundle bundle = new Bundle();
            bundle.putString("patternId", PlayListDetailsDActivity.this.a.getId());
            bundle.putBoolean("isUpdate", PlayListDetailsDActivity.this.a.isShared());
            if (!WearUtils.e1(PlayListDetailsDActivity.this.a.getToyFeature()) && PlayListDetailsDActivity.this.a.getToyFeature().toLowerCase().equals(Toy.TOY_FEATURE_XMACHINE.toLowerCase())) {
                bundle.putString("toyFeature", PlayListDetailsDActivity.this.a.getToyFeature());
            }
            if (PlayListDetailsDActivity.this.a.getToySymbol() != null) {
                bundle.putString("toySymbol", PlayListDetailsDActivity.this.a.getToySymbol());
            }
            if (PlayListDetailsDActivity.this.a.getToyName() != null) {
                bundle.putString("toyName", PlayListDetailsDActivity.this.a.getToyName());
            }
            if (PlayListDetailsDActivity.this.a.getToyVersion() != null) {
                bundle.putString("toyVersion", PlayListDetailsDActivity.this.a.getToyVersion());
            }
            pj3.g(PlayListDetailsDActivity.this, SharePatternActivity.class, bundle);
        }
    }

    public void A4() {
        PlaylistItems next;
        Iterator<PlaylistItems> it = this.n.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            } else {
                next = it.next();
                if (this.a.getId().equals(next.getPatternId())) {
                    break;
                }
            }
        }
        if (this.a.getEmail().equals(WearUtils.y.r())) {
            this.c.q(next, true);
        }
        this.n.remove(next);
        this.b.remove(this.a);
        notifyDataSetChanged();
        x4();
    }

    public final void B4(String str, String str2, String str3) {
        do3 do3Var = new do3(this, ah4.e(R.string.common_save), ah4.e(R.string.common_cancel));
        do3Var.g(str);
        do3Var.i(str2);
        do3Var.h(str3);
        do3Var.a().setFilters(new InputFilter[]{new InputFilter.LengthFilter(20)});
        do3Var.b(new c(do3Var));
        do3Var.c(new d(do3Var));
        do3Var.e();
        do3Var.a().requestFocus();
        ue3.d(do3Var.a(), this);
    }

    public void C4(View view, boolean z, boolean z2) {
        ao3 ao3Var = new ao3(this, R.style.MenuDialogAl, R.layout.select_menu_dialog_item);
        ao3Var.a(view, 250, 200, 5160, -30, new m(this));
        ao3Var.findViewById(R.id.action_row_0).setOnClickListener(new n(ao3Var));
        ao3Var.findViewById(R.id.action_row_1).setOnClickListener(new o(ao3Var));
        ao3Var.findViewById(R.id.action_row_2).setOnClickListener(new a(ao3Var));
        ao3Var.findViewById(R.id.action_row_3).setOnClickListener(new b(ao3Var));
        if (!z || MyApplication.Z) {
            ao3Var.findViewById(R.id.action_row_1).setAlpha(0.4f);
            ao3Var.findViewById(R.id.action_row_1).setEnabled(false);
            ao3Var.findViewById(R.id.action_row_1).setOnClickListener(null);
            ((TextView) ao3Var.findViewById(R.id.action_row_1_text)).setText(ah4.e(R.string.common_share));
        } else {
            if (z2) {
                ((TextView) ao3Var.findViewById(R.id.action_row_1_text)).setText(ah4.e(R.string.common_reshared));
            } else {
                ((TextView) ao3Var.findViewById(R.id.action_row_1_text)).setText(ah4.e(R.string.common_share));
            }
            ao3Var.findViewById(R.id.action_row_1).setAlpha(1.0f);
            ao3Var.findViewById(R.id.action_row_1).setEnabled(true);
        }
        if (MyApplication.Z || !this.a.getEmail().equals(WearUtils.y.r())) {
            ao3Var.findViewById(R.id.action_row_0).setVisibility(8);
        } else {
            ao3Var.findViewById(R.id.action_row_0).setVisibility(0);
        }
        ao3Var.show();
    }

    @Override // dc.te2.b
    public void G() {
        runOnMainThread(new e());
    }

    @Override // dc.te2.b
    public void I3(te2.a aVar) {
    }

    @Override // dc.te2.b
    public void Y(te2.a aVar) {
    }

    @Override // dc.te2.b
    public void d() {
        runOnMainThread(new f());
    }

    @Override // dc.te2.b
    public void d4(te2.a aVar) {
    }

    public final void notifyDataSetChanged() {
        this.m.notifyDataSetChanged();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_pattern_list_details);
        this.e = (MyActionBar) findViewById(R.id.actionbar);
        this.o = (Playlist) getIntent().getExtras().get("choose_patterns_playlist");
        this.l = findViewById(R.id.create_pattern_playout);
        this.f = (SlideAndDragListView) findViewById(R.id.pattern_details_data_list);
        this.g = (LinearLayout) findViewById(R.id.pattern_list_empty);
        this.h = (LinearLayout) findViewById(R.id.create_pattern);
        this.i = (TextView) findViewById(R.id.create_tv_text);
        this.j = (TextView) findViewById(R.id.list_empty_notice);
        TextView textView = (TextView) findViewById(R.id.choose_patterns_notice);
        this.k = textView;
        textView.setVisibility(0);
        this.k.setText(ah4.e(R.string.patterns_drag_notice));
        this.i.setText(ah4.e(R.string.programs_add));
        this.j.setText(ah4.e(R.string.pattern_create));
        this.e.setTitle(this.o.getName());
        this.e.setTabVisibility(false);
        this.e.setToysAction(new g(), false, this);
        this.e.n();
        h hVar = new h();
        this.f.setMenu(new yu3(false, 0));
        this.f.setCacheColorHint(th4.b(this, R.color.pattern_item_drag_bg));
        ck1 ck1Var = new ck1(this, this.o);
        this.m = ck1Var;
        this.f.setAdapter((ListAdapter) ck1Var);
        this.f.setOnItemLongClickListener(new i(this));
        this.f.setOnItemClickListener(new j());
        this.f.setOnDragDropListener(new k());
        this.f.setEmptyView(this.g);
        this.h.setOnClickListener(hVar);
        findViewById(R.id.create_pattern_image).setOnClickListener(hVar);
        x4();
        this.c.k(this);
        EventBus.getDefault().register(this);
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.e.s();
        this.c.D(this);
        EventBus.getDefault().unregister(this);
    }

    @Override // com.wear.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        y4();
    }

    public void x4() {
        Playlist playlist = this.o;
        if (playlist == null) {
            this.l.setVisibility(0);
            this.h.setVisibility(0);
        } else if (playlist.getMyPatternPlayListItems() == null || this.o.getMyPatternPlayListItems().size() == 0) {
            this.l.setVisibility(8);
        } else {
            this.l.setVisibility(0);
        }
        this.k.setVisibility(0);
    }

    public final void y4() {
        this.n.clear();
        this.n.addAll(this.c.n(WearUtils.y.r(), this.o.getId()));
        ArrayList arrayList = new ArrayList();
        Iterator<PlaylistItems> it = this.n.iterator();
        while (it.hasNext()) {
            Pattern patternK = xe2.L0().K(it.next().getPatternId());
            if (patternK != null && !arrayList.contains(patternK)) {
                arrayList.add(patternK);
            }
        }
        this.b.clear();
        this.b.addAll(arrayList);
        if (this.m.getCount() == 0) {
            this.l.setVisibility(8);
        } else {
            this.l.setVisibility(0);
        }
        this.h.setVisibility(0);
        notifyDataSetChanged();
    }

    public final void z4(int i2) {
        int size = this.b.size();
        if (size == 0) {
            return;
        }
        int i3 = i2 % size;
        this.d = i3;
        Pattern pattern = this.b.get(i3);
        this.a = pattern;
        l lVar = new l();
        if (!pattern.getFile().exists() && TextUtils.isEmpty(this.a.getPath())) {
            lVar.a(-1, null);
        } else if (this.a.getFile().exists()) {
            lVar.b(this.a.getFile());
        } else {
            xe2.L0().f(this.a.getId(), this.a.getPath(), lVar);
        }
    }
}
