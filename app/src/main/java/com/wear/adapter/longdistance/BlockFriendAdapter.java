package com.wear.adapter.longdistance;

import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lovense.wear.R;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;
import com.wear.bean.BlockFriend;
import com.wear.main.longDistance.block.BlockContactsActivity;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class BlockFriendAdapter extends BaseAdapter {
    public LayoutInflater a;
    public BlockContactsActivity b;
    public ArrayList<BlockFriend> c = new ArrayList<>();

    public static class ViewHolder {

        @BindView(R.id.select_icon)
        public ImageView selectIcon;

        @BindView(R.id.user_img)
        public ImageView userImg;

        @BindView(R.id.user_name)
        public TextView userName;

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }

    public class ViewHolder_ViewBinding implements Unbinder {
        public ViewHolder a;

        @UiThread
        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            this.a = viewHolder;
            viewHolder.userImg = (ImageView) Utils.findRequiredViewAsType(view, R.id.user_img, "field 'userImg'", ImageView.class);
            viewHolder.userName = (TextView) Utils.findRequiredViewAsType(view, R.id.user_name, "field 'userName'", TextView.class);
            viewHolder.selectIcon = (ImageView) Utils.findRequiredViewAsType(view, R.id.select_icon, "field 'selectIcon'", ImageView.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            ViewHolder viewHolder = this.a;
            if (viewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.a = null;
            viewHolder.userImg = null;
            viewHolder.userName = null;
            viewHolder.selectIcon = null;
        }
    }

    public class a extends SimpleImageLoadingListener {
        public a(BlockFriendAdapter blockFriendAdapter) {
        }

        @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
        public void onLoadingComplete(String str, View view, Bitmap bitmap) {
            ((ImageView) view).setImageBitmap(bitmap);
        }

        @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
        public void onLoadingFailed(String str, View view, FailReason failReason) {
            ((ImageView) view).setImageResource(R.drawable.chat_avatar_default);
        }

        @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
        public void onLoadingStarted(String str, View view) {
        }
    }

    public class b implements View.OnClickListener {
        public final /* synthetic */ int a;

        public b(int i) {
            this.a = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            BlockFriendAdapter.this.b.z4(this.a);
        }
    }

    public BlockFriendAdapter(BlockContactsActivity blockContactsActivity, MyApplication myApplication) {
        this.a = null;
        this.b = blockContactsActivity;
        this.a = LayoutInflater.from(blockContactsActivity);
    }

    @Override // android.widget.Adapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public BlockFriend getItem(int i) {
        return this.c.get(i);
    }

    public void b(ArrayList<BlockFriend> arrayList) {
        this.c = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.c.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            view = this.a.inflate(R.layout.remote_block_contacts_item, (ViewGroup) null);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        BlockFriend item = getItem(i);
        viewHolder.userName.setText(item.getName());
        ImageLoader.getInstance().displayImage(WearUtils.e + item.getAvatar(), viewHolder.userImg, MyApplication.Y, new a(this));
        if (item.isChoose()) {
            viewHolder.selectIcon.setImageResource(R.drawable.content_icon_selectpattern_selected);
        } else {
            viewHolder.selectIcon.setImageResource(R.drawable.content_icon_selectpattern_normal);
        }
        viewHolder.selectIcon.setOnClickListener(new b(i));
        return view;
    }
}
