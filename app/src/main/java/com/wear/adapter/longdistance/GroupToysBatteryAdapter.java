package com.wear.adapter.longdistance;

import android.widget.ImageView;
import com.lovense.wear.R;
import com.wear.adapter.BaseAdapter;
import com.wear.bean.Toy;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes3.dex */
public class GroupToysBatteryAdapter extends BaseAdapter<Toy> {
    public HashMap<String, ImageView> j;

    public GroupToysBatteryAdapter(ArrayList<Toy> arrayList, int i) {
        super(arrayList, i);
        this.j = new HashMap<>();
    }

    @Override // com.wear.adapter.BaseAdapter
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public void y(BaseAdapter.ViewHolder viewHolder, Toy toy, int i) {
        ImageView imageView = (ImageView) viewHolder.getView(R.id.iv_battery);
        toy.updateToyBattery(imageView);
        this.j.put(toy.getAndUpdateDeviceId(), imageView);
        viewHolder.a(R.id.tv_toy_name, toy.getToyUINameSpecialForMiniXMachine(1));
    }

    @Override // com.wear.adapter.BaseAdapter
    public void q() {
    }

    public void z(ArrayList<Toy> arrayList) {
        this.b = arrayList;
        notifyDataSetChanged();
    }
}
