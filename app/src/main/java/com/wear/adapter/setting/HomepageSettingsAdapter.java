package com.wear.adapter.setting;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.google.gson.Gson;
import com.lovense.wear.R;
import com.wear.adapter.BaseAdapter;
import com.wear.main.account.HomepageSettingsActivity;
import com.wear.util.MyApplication;
import dc.ah4;
import dc.eg3;
import java.util.List;

/* loaded from: classes3.dex */
public class HomepageSettingsAdapter extends BaseAdapter<String> {
    public HomepageSettingsAdapter(List<String> list, int i) {
        super(list, i);
    }

    public void A(int i, int i2) {
        String str = (String) this.b.get(i);
        this.b.remove(i);
        this.b.add(i2, str);
        notifyItemMoved(i, i2);
        eg3.i(MyApplication.N(), "homepageSettings", new Gson().toJson(this.b));
    }

    public void B(@Nullable RecyclerView.ViewHolder viewHolder) {
        if (HomepageSettingsActivity.m.equals(this.b.get(viewHolder.getLayoutPosition()))) {
            viewHolder.itemView.findViewById(R.id.item_homepage_settings_alarm).setAlpha(0.8f);
            viewHolder.itemView.findViewById(R.id.item_homepage_settings_sound).setAlpha(0.8f);
        }
    }

    @Override // com.wear.adapter.BaseAdapter
    /* renamed from: C, reason: merged with bridge method [inline-methods] */
    public void y(BaseAdapter.ViewHolder viewHolder, String str, int i) {
        if (HomepageSettingsActivity.m.equals(str)) {
            viewHolder.getView(R.id.item_homepage_settings_ll).setVisibility(0);
            viewHolder.getView(R.id.item_homepage_settings_rl_other).setVisibility(8);
            return;
        }
        viewHolder.getView(R.id.item_homepage_settings_ll).setVisibility(8);
        viewHolder.getView(R.id.item_homepage_settings_rl_other).setVisibility(0);
        if (HomepageSettingsActivity.i.equals(str)) {
            viewHolder.a(R.id.item_homepage_settings_other, ah4.e(R.string.closeRange_remoteControl));
            return;
        }
        if (HomepageSettingsActivity.j.equals(str)) {
            viewHolder.a(R.id.item_homepage_settings_other, ah4.e(R.string.closeRange_patterns));
        } else if (HomepageSettingsActivity.k.equals(str)) {
            viewHolder.a(R.id.item_homepage_settings_other, ah4.e(R.string.closeRange_music));
        } else if (HomepageSettingsActivity.l.equals(str)) {
            viewHolder.a(R.id.item_homepage_settings_other, ah4.e(R.string.closerange_control_link));
        }
    }

    public void z(@Nullable RecyclerView.ViewHolder viewHolder) {
        if (HomepageSettingsActivity.m.equals(this.b.get(viewHolder.getLayoutPosition()))) {
            viewHolder.itemView.findViewById(R.id.item_homepage_settings_alarm).setAlpha(1.0f);
            viewHolder.itemView.findViewById(R.id.item_homepage_settings_sound).setAlpha(1.0f);
        }
    }
}
