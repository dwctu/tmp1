package com.wear.adapter.longdistance;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lovense.wear.R;
import dc.ah4;
import dc.ce3;
import dc.ie3;
import java.util.List;

/* loaded from: classes3.dex */
public class EmojisAdapter extends RecyclerView.Adapter implements View.OnClickListener, View.OnLongClickListener {
    public Context a;
    public List b;
    public ie3 c;
    public a d;

    public static class EmojiViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_emoji)
        public ImageView iv_emoji;

        public EmojiViewHolder(@NonNull View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    public class EmojiViewHolder_ViewBinding implements Unbinder {
        public EmojiViewHolder a;

        @UiThread
        public EmojiViewHolder_ViewBinding(EmojiViewHolder emojiViewHolder, View view) {
            this.a = emojiViewHolder;
            emojiViewHolder.iv_emoji = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_emoji, "field 'iv_emoji'", ImageView.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            EmojiViewHolder emojiViewHolder = this.a;
            if (emojiViewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.a = null;
            emojiViewHolder.iv_emoji = null;
        }
    }

    public static class TitleViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_emojis_title)
        public TextView tv_emojis_title;

        public TitleViewHolder(@NonNull View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    public class TitleViewHolder_ViewBinding implements Unbinder {
        public TitleViewHolder a;

        @UiThread
        public TitleViewHolder_ViewBinding(TitleViewHolder titleViewHolder, View view) {
            this.a = titleViewHolder;
            titleViewHolder.tv_emojis_title = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_emojis_title, "field 'tv_emojis_title'", TextView.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            TitleViewHolder titleViewHolder = this.a;
            if (titleViewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.a = null;
            titleViewHolder.tv_emojis_title = null;
        }
    }

    public interface a {
        void a(String str, int[] iArr);

        void b(String str);
    }

    public EmojisAdapter(Context context, List list, ie3 ie3Var, a aVar) {
        this.a = context;
        this.b = list;
        this.c = ie3Var;
        this.d = aVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.b.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        return this.b.get(i) instanceof String ? 2 : 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if (viewHolder instanceof TitleViewHolder) {
            ((TitleViewHolder) viewHolder).tv_emojis_title.setText(ah4.e(((Integer) this.b.get(i)).intValue() == 3 ? R.string.emoji_panel_frequently_used : R.string.emoji_panel_all));
            return;
        }
        EmojiViewHolder emojiViewHolder = (EmojiViewHolder) viewHolder;
        String str = (String) this.b.get(i);
        emojiViewHolder.iv_emoji.setImageBitmap(this.c.E(str));
        emojiViewHolder.iv_emoji.setTag(R.id.tag1, this.c.u(str));
        emojiViewHolder.iv_emoji.setOnClickListener(this);
        emojiViewHolder.iv_emoji.setOnLongClickListener(this);
        int iIndexOf = this.b.indexOf(4) + 1;
        int size = this.b.size() - this.b.indexOf(4);
        int i2 = size / 7;
        int i3 = size % 7;
        GridLayoutManager.LayoutParams layoutParams = (GridLayoutManager.LayoutParams) emojiViewHolder.itemView.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams).height = ce3.a(this.a, i < iIndexOf ? 47.0f : 52.0f);
        emojiViewHolder.itemView.setLayoutParams(layoutParams);
        emojiViewHolder.itemView.setPadding(0, 0, 0, ce3.a(this.a, i < iIndexOf ? 20.0f : 25.0f));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.d != null) {
            this.d.b((String) view.getTag(R.id.tag1));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return i == 1 ? new TitleViewHolder(LayoutInflater.from(this.a).inflate(R.layout.item_emoji_title, viewGroup, false)) : new EmojiViewHolder(LayoutInflater.from(this.a).inflate(R.layout.item_emoji, viewGroup, false));
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        if (this.d != null) {
            String str = (String) view.getTag(R.id.tag1);
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            iArr[0] = iArr[0] + (view.getWidth() / 2);
            iArr[1] = iArr[1] + ce3.a(this.a, 14.0f);
            this.d.a(str, iArr);
        }
        return false;
    }
}
