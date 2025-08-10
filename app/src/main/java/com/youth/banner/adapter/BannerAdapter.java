package com.youth.banner.adapter;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.youth.banner.R;
import com.youth.banner.holder.IViewHolder;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.util.BannerUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public abstract class BannerAdapter<T, VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> implements IViewHolder<T, VH> {
    public List<T> mDatas = new ArrayList();
    private int mIncreaseCount = 2;
    private OnBannerListener<T> mOnBannerListener;
    private VH mViewHolder;

    public BannerAdapter(List<T> list) {
        setDatas(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void m(Object obj, int i, View view) {
        this.mOnBannerListener.OnBannerClick(obj, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void o(RecyclerView.ViewHolder viewHolder, View view) {
        if (this.mOnBannerListener != null) {
            this.mOnBannerListener.OnBannerClick(viewHolder.itemView.getTag(R.id.banner_data_key), ((Integer) viewHolder.itemView.getTag(R.id.banner_pos_key)).intValue());
        }
    }

    public T getData(int i) {
        return this.mDatas.get(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return getRealCount() > 1 ? getRealCount() + this.mIncreaseCount : getRealCount();
    }

    public int getRealCount() {
        List<T> list = this.mDatas;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public T getRealData(int i) {
        return this.mDatas.get(getRealPosition(i));
    }

    public int getRealPosition(int i) {
        return BannerUtils.getRealPosition(this.mIncreaseCount == 2, i, getRealCount());
    }

    public VH getViewHolder() {
        return this.mViewHolder;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(@NonNull VH vh, int i) {
        this.mViewHolder = vh;
        final int realPosition = getRealPosition(i);
        final T t = this.mDatas.get(realPosition);
        vh.itemView.setTag(R.id.banner_data_key, t);
        vh.itemView.setTag(R.id.banner_pos_key, Integer.valueOf(realPosition));
        onBindView(vh, this.mDatas.get(realPosition), realPosition, getRealCount());
        if (this.mOnBannerListener != null) {
            vh.itemView.setOnClickListener(new View.OnClickListener() { // from class: dc.qu3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.a.m(t, realPosition, view);
                }
            });
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public VH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        final VH vhOnCreateHolder = onCreateHolder(viewGroup, i);
        vhOnCreateHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: dc.pu3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.o(vhOnCreateHolder, view);
            }
        });
        return vhOnCreateHolder;
    }

    public void setDatas(List<T> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        this.mDatas = list;
        notifyDataSetChanged();
    }

    public void setIncreaseCount(int i) {
        this.mIncreaseCount = i;
    }

    public void setOnBannerListener(OnBannerListener<T> onBannerListener) {
        this.mOnBannerListener = onBannerListener;
    }
}
