package com.wear.widget;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.lovense.wear.R;
import com.wear.adapter.BaseAdapter;
import com.wear.bean.Pattern;
import com.wear.bean.Playlist;
import com.wear.bean.PlaylistItems;
import com.wear.main.account.login.LoginActivity;
import com.wear.main.patterns.MulChoosePatternsActivity;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import dc.ah4;
import dc.pj3;
import dc.re3;
import dc.sg3;
import dc.ve2;
import dc.we2;
import dc.xe2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

/* loaded from: classes4.dex */
public class AddToPlayListDialog extends BottomDialog {
    public RecyclerView c;
    public LinearLayout d;
    public Pattern e;
    public List<Playlist> f;
    public List<PlaylistItems> g;
    public b h;
    public we2 i;
    public ve2 j;

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AddToPlayListDialog.this.dismiss();
            if (!MyApplication.Z && !MyApplication.O) {
                pj3.f(re3.k(), LoginActivity.class);
                re3.k().finish();
            } else {
                Intent intent = new Intent(re3.k(), (Class<?>) MulChoosePatternsActivity.class);
                intent.putExtra("choose_patterns_playlist_id", "create");
                re3.k().startActivity(intent);
            }
        }
    }

    public class b extends BaseAdapter<Playlist> {

        public class a implements View.OnClickListener {
            public final /* synthetic */ int a;

            public a(int i) {
                this.a = i;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                boolean z;
                AddToPlayListDialog addToPlayListDialog = AddToPlayListDialog.this;
                addToPlayListDialog.g = addToPlayListDialog.j.I(WearUtils.y.r(), ((Playlist) AddToPlayListDialog.this.f.get(this.a)).getId());
                Iterator it = AddToPlayListDialog.this.g.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = false;
                        break;
                    } else if (TextUtils.equals(((PlaylistItems) it.next()).getPatternId(), AddToPlayListDialog.this.e.getId())) {
                        sg3.l(ah4.e(R.string.music_add_playlist_repetitive));
                        z = true;
                        break;
                    }
                }
                if (!z) {
                    LinkedHashMap<String, PlaylistItems> linkedHashMap = new LinkedHashMap<>();
                    PlaylistItems playlistItems = new PlaylistItems();
                    playlistItems.setEmail(WearUtils.y.r());
                    playlistItems.setPlaylistId(((Playlist) AddToPlayListDialog.this.f.get(this.a)).getId());
                    playlistItems.setPatternId(AddToPlayListDialog.this.e.getId());
                    playlistItems.setLastUpdTime(System.currentTimeMillis());
                    playlistItems.setSortId(AddToPlayListDialog.this.g.size());
                    linkedHashMap.put(playlistItems.getId(), playlistItems);
                    AddToPlayListDialog.this.j.J(linkedHashMap, true);
                    sg3.l(ah4.e(R.string.music_add_playlist_success));
                }
                AddToPlayListDialog.this.cancel();
            }
        }

        public b(List<Playlist> list, int i) {
            super(list, i);
        }

        @Override // com.wear.adapter.BaseAdapter
        /* renamed from: z, reason: merged with bridge method [inline-methods] */
        public void y(BaseAdapter.ViewHolder viewHolder, Playlist playlist, int i) {
            viewHolder.itemView.setOnClickListener(new a(i));
            viewHolder.a(R.id.pattern_name, playlist.getName());
        }
    }

    public AddToPlayListDialog(Context context) {
        super(context);
        this.f = new ArrayList();
        this.g = new ArrayList();
        this.i = (we2) xe2.L0();
        this.j = (ve2) xe2.L0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void j(View view) {
        cancel();
    }

    @Override // com.wear.widget.BottomDialog
    public View b() {
        return LayoutInflater.from(getContext()).inflate(R.layout.dialog_add_to_playlist, (ViewGroup) null);
    }

    @Override // com.wear.widget.BottomDialog
    public void c(View view) {
        ((TextView) view.findViewById(R.id.title)).setText(ah4.c(R.string.add_title));
        ((ImageView) view.findViewById(R.id.dropdown)).setOnClickListener(new View.OnClickListener() { // from class: dc.cn3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.a.j(view2);
            }
        });
        this.c = (RecyclerView) view.findViewById(R.id.recyclerView);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.create_playlist);
        this.d = linearLayout;
        linearLayout.setOnClickListener(new a());
        this.h = new b(this.f, R.layout.item_add_to_play_list);
        this.c.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        this.c.setAdapter(this.h);
        h();
    }

    public final void h() {
        this.f.clear();
        List<Playlist> listN = this.i.N(WearUtils.y.r());
        if (listN != null) {
            this.f.addAll(listN);
        }
        this.h.notifyDataSetChanged();
    }

    public void k(Pattern pattern) {
        this.e = pattern;
        if (pattern == null) {
            return;
        }
        show();
    }
}
