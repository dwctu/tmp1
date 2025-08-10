package com.wear.adapter.game;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.lovense.wear.R;
import com.wear.util.WearUtils;
import dc.t32;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class ToyCtrlGameAdapter extends RecyclerView.Adapter<ViewHolder> {
    public ArrayList<t32.c> a = new ArrayList<>();

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView a;
        public View b;
        public TextView c;

        public ViewHolder(@NonNull ToyCtrlGameAdapter toyCtrlGameAdapter, View view) {
            super(view);
            this.a = (TextView) view.findViewById(R.id.tv_game_name);
            this.b = view.findViewById(R.id.v_tip);
            this.c = (TextView) view.findViewById(R.id.tv_state);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.a.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        String string;
        t32.c cVar = this.a.get(i);
        boolean z = !TextUtils.isEmpty(cVar.a);
        TextView textView = viewHolder.a;
        if (z) {
            string = "[" + cVar.a + "]";
        } else {
            string = WearUtils.x.getString(R.string.game_model_adapter_name_default);
        }
        textView.setText(string);
        viewHolder.b.setBackgroundResource(z ? R.drawable.bg_game_mode_game_tip_connected : R.drawable.bg_game_mode_game_tip_disconnect);
        viewHolder.c.setText(WearUtils.x.getString(z ? R.string.toy_connected : R.string.not_connect));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(this, LayoutInflater.from(WearUtils.x).inflate(R.layout.adapter_toy_ctrl_game_item, viewGroup, false));
    }

    public void n(ArrayList<t32.c> arrayList) {
        this.a = arrayList;
        if (arrayList.size() == 0) {
            this.a.add(new t32.c());
        }
        notifyDataSetChanged();
    }
}
