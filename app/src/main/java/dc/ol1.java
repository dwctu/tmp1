package dc;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.lovense.wear.R;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;
import com.wear.main.longDistance.ChatPicturesActivity;
import com.wear.protocol.CommunMessage;
import com.wear.protocol.EntityPicture;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import java.io.File;
import java.util.HashMap;
import pl.droidsonroids.gif.GifDrawable;
import pl.droidsonroids.gif.GifImageView;

/* compiled from: ChatPictruesGridViewAdapter.java */
/* loaded from: classes3.dex */
public class ol1 extends BaseAdapter {
    public ChatPicturesActivity a;
    public int b;
    public HashMap<String, CommunMessage> c = new HashMap<>();
    public HashMap<String, GifImageView> d = new HashMap<>();
    public HashMap<String, View> e = new HashMap<>();

    /* compiled from: ChatPictruesGridViewAdapter.java */
    public class a extends SimpleImageLoadingListener {
        public final /* synthetic */ c a;
        public final /* synthetic */ String b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ String d;

        public a(c cVar, String str, boolean z, String str2) {
            this.a = cVar;
            this.b = str;
            this.c = z;
            this.d = str2;
        }

        @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
        public void onLoadingComplete(String str, View view, Bitmap bitmap) {
            if (bitmap != null) {
                GifImageView gifImageView = (GifImageView) view;
                ol1.this.d.put(this.b, gifImageView);
                gifImageView.setImageBitmap(bitmap);
                if (this.c) {
                    File file = ImageLoader.getInstance().getDiskCache().get(str);
                    if (file.exists()) {
                        try {
                            this.a.b.setImageDrawable(new GifDrawable(file));
                        } catch (Exception unused) {
                        }
                    }
                }
            }
            ol1.this.e.put(this.b, view);
            this.a.b.setTag(this.d);
        }

        @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
        public void onLoadingFailed(String str, View view, FailReason failReason) {
            this.a.b.setImageResource(R.drawable.content_icon_picture_loading);
            ol1.this.e.put(this.b, view);
        }

        @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
        public void onLoadingStarted(String str, View view) {
            this.a.b.setImageResource(R.drawable.content_icon_picture_loading);
        }
    }

    /* compiled from: ChatPictruesGridViewAdapter.java */
    public class b implements View.OnClickListener {
        public final /* synthetic */ int a;
        public final /* synthetic */ c b;

        public b(int i, c cVar) {
            this.a = i;
            this.b = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!ol1.this.a.o) {
                ol1.this.a.x5();
                return;
            }
            ol1.this.e(this.a);
            ol1 ol1Var = ol1.this;
            if (ol1Var.c.get(ol1Var.getItem(this.a).getId()) == null) {
                this.b.c.setImageResource(R.drawable.content_icon_picture_normal);
            } else {
                this.b.c.setImageResource(R.drawable.content_icon_picture_selected);
            }
        }
    }

    /* compiled from: ChatPictruesGridViewAdapter.java */
    public class c {
        public FrameLayout a;
        public GifImageView b;
        public ImageView c;

        public c(ol1 ol1Var) {
        }

        public /* synthetic */ c(ol1 ol1Var, a aVar) {
            this(ol1Var);
        }
    }

    public ol1(ChatPicturesActivity chatPicturesActivity) {
        this.b = 0;
        this.a = chatPicturesActivity;
        this.b = gg3.e(chatPicturesActivity) / 4;
        this.c.clear();
        this.d.clear();
        this.e.clear();
    }

    @Override // android.widget.Adapter
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public CommunMessage getItem(int i) {
        return this.a.q.get(i);
    }

    public EntityPicture c(int i) {
        return (EntityPicture) getItem(i).getDataBean();
    }

    public int d() {
        return this.c.size();
    }

    public void e(int i) {
        CommunMessage item = getItem(i);
        if (this.c.get(item.getId()) == null) {
            this.c.put(item.getId(), item);
        } else {
            this.c.remove(item.getId());
        }
        this.a.y5();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.a.q.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View viewInflate;
        c cVar;
        if (view == null) {
            cVar = new c(this, null);
            viewInflate = LayoutInflater.from(this.a).inflate(R.layout.item_grid_chat_picture, (ViewGroup) null);
            cVar.a = (FrameLayout) viewInflate.findViewById(R.id.gl_layout);
            cVar.b = (GifImageView) viewInflate.findViewById(R.id.iv_gifImage);
            cVar.c = (ImageView) viewInflate.findViewById(R.id.iv_select);
            viewInflate.setTag(cVar);
        } else {
            viewInflate = view;
            cVar = (c) view.getTag();
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) cVar.a.getLayoutParams();
        int i2 = this.b;
        layoutParams.width = i2;
        layoutParams.height = i2;
        cVar.a.setLayoutParams(layoutParams);
        EntityPicture entityPictureC = c(i);
        String url = entityPictureC.getUrl();
        String type = entityPictureC.getType();
        if (this.a.o) {
            cVar.c.setVisibility(0);
            if (this.c.get(getItem(i).getId()) == null) {
                cVar.c.setImageResource(R.drawable.content_icon_picture_normal);
            } else {
                cVar.c.setImageResource(R.drawable.content_icon_picture_selected);
            }
        } else {
            cVar.c.setVisibility(8);
        }
        boolean z = !WearUtils.e1(type) && type.equals("emoji");
        if (TextUtils.isEmpty(url)) {
            cVar.b.setImageResource(R.drawable.content_icon_picture_loading);
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(WearUtils.e);
            sb.append(z ? url.replace("thum_", "") : url);
            String string = sb.toString();
            if (cVar.b.getTag() == null || !string.equals(cVar.b.getTag())) {
                ImageLoader.getInstance().displayImage(string, cVar.b, MyApplication.Y, new a(cVar, url, z, string));
            }
        }
        cVar.a.setOnClickListener(new b(i, cVar));
        return viewInflate;
    }
}
