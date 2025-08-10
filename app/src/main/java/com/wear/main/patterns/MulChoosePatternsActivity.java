package com.wear.main.patterns;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.lovense.wear.R;
import com.wear.BaseActivity;
import com.wear.bean.Pattern;
import com.wear.bean.Playlist;
import com.wear.bean.PlaylistItems;
import com.wear.bean.Toy;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import dc.ah4;
import dc.ak1;
import dc.do3;
import dc.kd0;
import dc.kn3;
import dc.na2;
import dc.sg3;
import dc.sr3;
import dc.ue3;
import dc.ve2;
import dc.vl2;
import dc.we2;
import dc.xe2;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.greenrobot.eventbus.EventBus;

/* loaded from: classes3.dex */
public class MulChoosePatternsActivity extends BaseActivity<vl2> implements View.OnClickListener {
    public ListView a;
    public MyApplication b;

    @BindView(R.id.iv_back)
    public ImageView ivBack;

    @BindView(R.id.tv_send)
    public TextView tvSend;
    public HashMap<Integer, String> c = new HashMap<>();
    public int d = 0;
    public String e = "";
    public List<Pattern> f = new ArrayList();
    public List<PlaylistItems> g = null;
    public boolean h = false;
    public Toy i = null;
    public we2 j = (we2) xe2.L0();
    public ve2 k = (ve2) xe2.L0();

    public class a implements kn3.d {
        public final /* synthetic */ do3 a;

        public a(do3 do3Var) {
            this.a = do3Var;
        }

        @Override // dc.kn3.d
        public void doCancel() {
            ue3.a(this.a.a(), MulChoosePatternsActivity.this.b);
        }

        @Override // dc.kn3.d
        public void doConfirm() {
            ue3.a(this.a.a(), MulChoosePatternsActivity.this.b);
            String strTrim = this.a.a().getText().toString().trim();
            Playlist playlist = new Playlist();
            playlist.setName(strTrim);
            playlist.setEmail(WearUtils.y.r());
            MulChoosePatternsActivity.this.j.L(playlist, true);
            LinkedHashMap<String, PlaylistItems> linkedHashMap = new LinkedHashMap<>();
            int size = MulChoosePatternsActivity.this.c.size();
            Iterator<Map.Entry<Integer, String>> it = MulChoosePatternsActivity.this.c.entrySet().iterator();
            int i = -1;
            while (it.hasNext()) {
                int iIntValue = it.next().getKey().intValue();
                i++;
                if (!MulChoosePatternsActivity.this.f.get(iIntValue).isExist()) {
                    PlaylistItems playlistItems = new PlaylistItems();
                    playlistItems.setEmail(WearUtils.y.r());
                    playlistItems.setPlaylistId(playlist.getId());
                    playlistItems.setPatternId(MulChoosePatternsActivity.this.f.get(iIntValue).getId());
                    playlistItems.setSortId(size - i);
                    linkedHashMap.put(playlistItems.getId(), playlistItems);
                }
            }
            MulChoosePatternsActivity.this.k.J(linkedHashMap, true);
            MulChoosePatternsActivity.this.finish();
        }
    }

    public class b extends HashMap<String, String> {
        public b() {
            put("type", MulChoosePatternsActivity.this.i == null ? "" : MulChoosePatternsActivity.this.i.getDeviceType());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: B4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean C4(do3 do3Var) {
        String string = do3Var.a().getText().toString();
        if (WearUtils.S0(string)) {
            sg3.i(this, R.string.profile_name_error);
            return false;
        }
        if (!WearUtils.e1(string)) {
            return true;
        }
        sg3.i(this, R.string.playlist_name_empty);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: v4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void w4(View view) {
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: x4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void y4(AdapterView adapterView, View view, int i, long j) {
        if (this.c.containsKey(Integer.valueOf(i))) {
            this.c.remove(Integer.valueOf(i));
        } else if (this.c.keySet().size() < this.d) {
            this.c.put(Integer.valueOf(i), this.f.get(i).getId());
        } else {
            sg3.l(ah4.e(R.string.programs_choose_no_more));
        }
        notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: z4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void A4(sr3 sr3Var, Toy toy) {
        Intent intent = new Intent(this, (Class<?>) CreatePatternActivity.class);
        kd0.b("extras_toy", toy);
        intent.putExtra("is_recording_pattern", 1);
        intent.putExtra("is_create_home", false);
        startActivityForResult(intent, 24);
        if (sr3Var.isShowing()) {
            sr3Var.dismiss();
        }
    }

    public final void D4() {
        if (this.h && this.i != null) {
            Intent intent = new Intent(this, (Class<?>) CreatePatternActivity.class);
            intent.putExtra("is_program_pattern", 1);
            kd0.b("extras_toy", this.i);
            startActivityForResult(intent, 24);
            addAnalyticsEventId("toy_program_create_pattern", new b());
        }
        if (this.h) {
            return;
        }
        if (na2.m().i()) {
            na2.m().t();
        } else {
            F4();
        }
    }

    public final void E4() {
        boolean z;
        if (this.c.entrySet().size() == 0) {
            sg3.i(this, R.string.pattern_selectOne);
            return;
        }
        if (WearUtils.e1(this.e)) {
            ArrayList<String> arrayList = new ArrayList<>();
            Iterator<Map.Entry<Integer, String>> it = this.c.entrySet().iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().getValue());
            }
            Intent intent = new Intent();
            intent.putStringArrayListExtra("choose_patterns", arrayList);
            setResult(22, intent);
            finish();
            return;
        }
        if (this.e.equals("create")) {
            G4();
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator<PlaylistItems> it2 = this.g.iterator();
        while (true) {
            boolean z2 = false;
            if (!it2.hasNext()) {
                break;
            }
            PlaylistItems next = it2.next();
            Iterator<Map.Entry<Integer, String>> it3 = this.c.entrySet().iterator();
            while (true) {
                if (it3.hasNext()) {
                    if (TextUtils.equals(next.getPatternId(), it3.next().getValue())) {
                        break;
                    }
                } else {
                    z2 = true;
                    break;
                }
            }
            if (z2) {
                arrayList2.add(next);
            }
        }
        this.k.G(arrayList2, true);
        HashMap map = new HashMap();
        for (Map.Entry<Integer, String> entry : this.c.entrySet()) {
            Iterator<PlaylistItems> it4 = this.g.iterator();
            while (true) {
                if (it4.hasNext()) {
                    if (TextUtils.equals(it4.next().getPatternId(), entry.getValue())) {
                        z = false;
                        break;
                    }
                } else {
                    z = true;
                    break;
                }
            }
            if (z) {
                map.put(entry.getKey(), entry.getValue());
            }
        }
        LinkedHashMap<String, PlaylistItems> linkedHashMap = new LinkedHashMap<>();
        int i = -1;
        int size = map.size();
        Iterator it5 = map.entrySet().iterator();
        while (it5.hasNext()) {
            int iIntValue = ((Integer) ((Map.Entry) it5.next()).getKey()).intValue();
            i++;
            if (!this.f.get(iIntValue).isExist()) {
                PlaylistItems playlistItems = new PlaylistItems();
                playlistItems.setEmail(WearUtils.y.r());
                playlistItems.setPlaylistId(this.e);
                playlistItems.setPatternId(this.f.get(iIntValue).getId());
                playlistItems.setLastUpdTime(System.currentTimeMillis());
                playlistItems.setSortId(size - i);
                linkedHashMap.put(playlistItems.getId(), playlistItems);
            }
        }
        this.k.J(linkedHashMap, true);
        finish();
    }

    public final void F4() {
        final sr3 sr3Var = new sr3(this);
        sr3Var.j(new sr3.c() { // from class: dc.vd2
            @Override // dc.sr3.c
            public final void a(Toy toy) {
                this.a.A4(sr3Var, toy);
            }
        });
        sr3Var.show();
    }

    public final void G4() {
        final do3 do3Var = new do3(this, ah4.e(R.string.common_save), ah4.e(R.string.common_cancel));
        do3Var.g(ah4.e(R.string.playlist_create));
        do3Var.h("");
        do3Var.i(ah4.e(R.string.pattern_playlist_name));
        do3Var.a().setFilters(new InputFilter[]{new InputFilter.LengthFilter(20)});
        do3Var.b(new kn3.c() { // from class: dc.ud2
            @Override // dc.kn3.c
            public final boolean a() {
                return this.a.C4(do3Var);
            }
        });
        do3Var.e();
        do3Var.c(new a(do3Var));
    }

    public final void notifyDataSetChanged() {
        ((ak1) this.a.getAdapter()).notifyDataSetChanged();
    }

    @Override // com.wear.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        int i3;
        Pattern pattern;
        super.onActivityResult(i, i2, intent);
        if (i != 24 || intent == null) {
            return;
        }
        if (this.h) {
            Bundle extras = intent.getExtras();
            if (extras == null || (pattern = (Pattern) extras.getSerializable("program_pattern")) == null || this.i == null) {
                return;
            }
            Intent intent2 = new Intent();
            Bundle bundle = new Bundle();
            bundle.putSerializable("program_pattern", pattern);
            intent2.putExtra("program_pattern_id", pattern.getId());
            intent2.putExtra("is_program_pattern", 1);
            intent2.putExtras(bundle);
            setResult(24, intent2);
            finish();
            return;
        }
        List<Pattern> listC = xe2.L0().C(WearUtils.y.r());
        ArrayList arrayList = new ArrayList();
        Iterator<Pattern> it = listC.iterator();
        while (true) {
            i3 = 0;
            if (!it.hasNext()) {
                break;
            }
            Pattern next = it.next();
            Iterator<Pattern> it2 = this.f.iterator();
            while (true) {
                if (it2.hasNext()) {
                    if (next.getId().equals(it2.next().getId())) {
                        break;
                    }
                } else {
                    i3 = 1;
                    break;
                }
            }
            if (i3 != 0) {
                arrayList.add(next);
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        this.f.addAll(0, arrayList);
        HashMap map = new HashMap();
        for (Map.Entry<Integer, String> entry : this.c.entrySet()) {
            map.put(Integer.valueOf(entry.getKey().intValue() + arrayList.size()), entry.getValue());
        }
        this.c.clear();
        this.c.putAll(map);
        while (i3 < this.f.size()) {
            Iterator it3 = arrayList.iterator();
            while (true) {
                if (it3.hasNext()) {
                    if (this.f.get(i3).getId().equals(((Pattern) it3.next()).getId())) {
                        this.c.put(Integer.valueOf(i3), this.f.get(i3).getId());
                        break;
                    }
                }
            }
            i3++;
        }
        notifyDataSetChanged();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.tv_send) {
            E4();
        } else if (id == R.id.new_pattern_layout) {
            D4();
        }
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.long_pattern_send);
        ButterKnife.bind(this);
        this.b = (MyApplication) getApplication();
        u4();
        this.tvSend.setText(ah4.e(R.string.common_done));
        this.tvSend.setOnClickListener(this);
        this.ivBack.setOnClickListener(new View.OnClickListener() { // from class: dc.td2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.w4(view);
            }
        });
        this.a = (ListView) findViewById(R.id.pattern_list);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.pattern_list_empty);
        TextView textView = (TextView) findViewById(R.id.choose_patterns_notice);
        findViewById(R.id.new_pattern_root).setVisibility(8);
        int i = 0;
        findViewById(R.id.new_pattern_root).setVisibility(0);
        ((TextView) findViewById(R.id.new_pattern_notice)).setText(ah4.e(R.string.pattern_create));
        findViewById(R.id.new_pattern_layout).setOnClickListener(this);
        if (WearUtils.e1(this.e)) {
            textView.setVisibility(0);
        } else {
            textView.setVisibility(8);
        }
        this.a.setAdapter((ListAdapter) new ak1(this, this.b));
        this.a.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: dc.wd2
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i2, long j) {
                this.a.y4(adapterView, view, i2, j);
            }
        });
        this.a.setEmptyView(relativeLayout);
        EventBus.getDefault().register(this);
        if (WearUtils.e1(this.e)) {
            this.f = xe2.L0().z(WearUtils.y.r(), 50);
        } else {
            List<Pattern> listC = xe2.L0().C(WearUtils.y.r());
            this.f = listC;
            Collections.sort(listC, new xe2.o(false));
        }
        if (this.f == null) {
            this.f = new ArrayList();
        }
        if (!WearUtils.e1(this.e) && !this.e.equals("create")) {
            List<PlaylistItems> listI = this.k.I(WearUtils.y.r(), this.e);
            this.g = listI;
            if (listI == null) {
                this.g = new ArrayList();
            }
            for (Pattern pattern : this.f) {
                Iterator<PlaylistItems> it = this.g.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (pattern.getId().equals(it.next().getPatternId())) {
                            this.c.put(Integer.valueOf(i), this.f.get(i).getId());
                            break;
                        }
                    }
                }
                i++;
            }
        }
        notifyDataSetChanged();
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Override // com.wear.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    public final void u4() {
        int intExtra = getIntent().getIntExtra("choose_patterns_number", 0);
        this.d = intExtra;
        this.d = Math.max(intExtra, 0);
        this.h = getIntent().getIntExtra("is_program_pattern", 0) > 0;
        Object objD = kd0.d("extras_toy");
        if (objD != null) {
            this.i = (Toy) objD;
        }
        String stringExtra = getIntent().getStringExtra("choose_patterns_playlist_id");
        this.e = stringExtra;
        if (WearUtils.e1(stringExtra)) {
            return;
        }
        this.d = Integer.MAX_VALUE;
    }
}
