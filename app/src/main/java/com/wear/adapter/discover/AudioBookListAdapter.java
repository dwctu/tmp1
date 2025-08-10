package com.wear.adapter.discover;

import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import com.alibaba.fastjson.JSON;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.lovense.wear.R;
import com.wear.bean.data.AudioBookList;
import dc.ce3;
import dc.kf;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: AudioBookListAdapter.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004B\u0005¢\u0006\u0002\u0010\u0005J\u0018\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0002H\u0014J\b\u0010\u0013\u001a\u00020\u0014H\u0014J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u0014\u0010\u0017\u001a\u00020\n2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R0\u0010\b\u001a\u0018\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/wear/adapter/discover/AudioBookListAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/wear/bean/data/AudioBookList;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "Landroid/widget/Filterable;", "()V", "filterList", "", "onFilterListener", "Lkotlin/Function1;", "", "getOnFilterListener", "()Lkotlin/jvm/functions/Function1;", "setOnFilterListener", "(Lkotlin/jvm/functions/Function1;)V", "sourceList", "convert", "holder", "item", "getDefItemCount", "", "getFilter", "Landroid/widget/Filter;", "setSourceList", "list", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class AudioBookListAdapter extends BaseQuickAdapter<AudioBookList, BaseViewHolder> implements Filterable {

    @NotNull
    public List<AudioBookList> A;

    @Nullable
    public Function1<? super List<AudioBookList>, Unit> B;

    @NotNull
    public List<AudioBookList> z;

    /* compiled from: AudioBookListAdapter.kt */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0014J\u001c\u0010\u0006\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0003H\u0014¨\u0006\t"}, d2 = {"com/wear/adapter/discover/AudioBookListAdapter$getFilter$1", "Landroid/widget/Filter;", "performFiltering", "Landroid/widget/Filter$FilterResults;", "constraint", "", "publishResults", "", "results", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a extends Filter {
        public a() {
        }

        @Override // android.widget.Filter
        @NotNull
        public Filter.FilterResults performFiltering(@Nullable CharSequence constraint) {
            List list;
            String strValueOf = String.valueOf(constraint);
            AudioBookListAdapter audioBookListAdapter = AudioBookListAdapter.this;
            if (strValueOf.length() == 0) {
                list = AudioBookListAdapter.this.A;
            } else {
                ArrayList arrayList = new ArrayList();
                for (AudioBookList audioBookList : AudioBookListAdapter.this.A) {
                    Iterator it = JSON.parseArray(audioBookList.getTagNameListDB(), String.class).iterator();
                    while (true) {
                        if (it.hasNext()) {
                            String tagName = (String) it.next();
                            Intrinsics.checkNotNullExpressionValue(tagName, "tagName");
                            if (StringsKt__StringsKt.contains$default((CharSequence) strValueOf, (CharSequence) tagName, false, 2, (Object) null)) {
                                arrayList.add(audioBookList);
                                break;
                            }
                        }
                    }
                }
                list = arrayList;
            }
            audioBookListAdapter.z = list;
            Filter.FilterResults filterResults = new Filter.FilterResults();
            filterResults.values = AudioBookListAdapter.this.z;
            return filterResults;
        }

        @Override // android.widget.Filter
        public void publishResults(@Nullable CharSequence constraint, @Nullable Filter.FilterResults results) {
            AudioBookListAdapter audioBookListAdapter = AudioBookListAdapter.this;
            Object obj = results != null ? results.values : null;
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.MutableList<com.wear.bean.data.AudioBookList>");
            audioBookListAdapter.z = TypeIntrinsics.asMutableList(obj);
            Function1<List<AudioBookList>, Unit> function1M0 = AudioBookListAdapter.this.M0();
            if (function1M0 != null) {
                function1M0.invoke(AudioBookListAdapter.this.z);
            }
            if (AudioBookListAdapter.this.z.isEmpty()) {
                AudioBookListAdapter.this.u0(R.layout.audio_book_empty);
            }
            AudioBookListAdapter audioBookListAdapter2 = AudioBookListAdapter.this;
            audioBookListAdapter2.x0(audioBookListAdapter2.z);
        }
    }

    public AudioBookListAdapter() {
        super(R.layout.item_audio_book_list, new ArrayList());
        this.z = new ArrayList();
        this.A = new ArrayList();
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public int L() {
        return this.z.size();
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: L0, reason: merged with bridge method [inline-methods] */
    public void C(@NotNull BaseViewHolder holder, @NotNull AudioBookList item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        ImageView imageView = (ImageView) holder.getView(R.id.iv_audio_book_cover);
        kf.w(J()).v(item.getCoverUrl()).A0(imageView);
        holder.setText(R.id.tv_audio_book_name, item.getTitle());
        int i = J().getResources().getDisplayMetrics().widthPixels;
        ViewGroup.LayoutParams layoutParams = holder.itemView.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        int iA = (i - ce3.a(J(), 46.0f)) / 2;
        int iA2 = iA - ce3.a(J(), 24.0f);
        imageView.getLayoutParams().width = iA2;
        imageView.getLayoutParams().height = iA2;
        marginLayoutParams.width = iA;
        if (holder.getLayoutPosition() % 2 == 0) {
            marginLayoutParams.leftMargin = ce3.a(J(), 16.0f);
            marginLayoutParams.rightMargin = ce3.a(J(), 7.0f);
        } else {
            marginLayoutParams.leftMargin = ce3.a(J(), 7.0f);
            marginLayoutParams.rightMargin = ce3.a(J(), 16.0f);
        }
        List array = JSON.parseArray(item.getTagNameListDB(), String.class);
        if (array.size() == 1) {
            holder.setText(R.id.tv_audio_book_tags, (CharSequence) array.get(0));
            holder.setVisible(R.id.tv_lab_name, false);
            holder.setVisible(R.id.tv_audio_book_tags, true);
        } else if (array.size() > 1) {
            holder.setText(R.id.tv_audio_book_tags, (CharSequence) array.get(0));
            holder.setText(R.id.tv_lab_name, (CharSequence) array.get(1));
            holder.setVisible(R.id.tv_lab_name, true);
            holder.setVisible(R.id.tv_audio_book_tags, true);
        } else {
            holder.setVisible(R.id.tv_lab_name, false);
            holder.setVisible(R.id.tv_audio_book_tags, false);
        }
        Integer duration = item.getDuration();
        if (duration != null) {
            holder.setText(R.id.tv_audio_book_duration, (duration.intValue() / 60) + " mins");
        }
        holder.setImageResource(R.id.iv_audio_book_play, item.isPlay() ? R.drawable.ic_audio_book_pause : R.drawable.ic_audio_book_play);
    }

    @Nullable
    public final Function1<List<AudioBookList>, Unit> M0() {
        return this.B;
    }

    public final void N0(@Nullable Function1<? super List<AudioBookList>, Unit> function1) {
        this.B = function1;
    }

    public final void O0(@NotNull List<AudioBookList> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.A = list;
        this.z = list;
    }

    @Override // android.widget.Filterable
    @NotNull
    public Filter getFilter() {
        return new a();
    }
}
