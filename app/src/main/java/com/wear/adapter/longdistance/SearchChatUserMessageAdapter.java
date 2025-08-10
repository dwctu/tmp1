package com.wear.adapter.longdistance;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.airbnb.lottie.LottieAnimationView;
import com.lovense.wear.R;
import com.makeramen.roundedimageview.RoundedImageView;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.assist.ImageSize;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;
import com.wear.adapter.longdistance.SearchChatAudioAdapter;
import com.wear.adapter.longdistance.SearchChatHistoryAdapter;
import com.wear.bean.Account;
import com.wear.bean.Group;
import com.wear.bean.GroupMember;
import com.wear.bean.PictureBean;
import com.wear.bean.handlerbean.IPeopleInfo;
import com.wear.main.longDistance.control.ChatVideoControl;
import com.wear.protocol.CommunMessage;
import com.wear.protocol.EntityAudio;
import com.wear.protocol.EntityChat;
import com.wear.protocol.EntityPicture;
import com.wear.protocol.EntityShortVideo;
import com.wear.protocol.MessageType;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import dc.ToyControlBuilder;
import dc.ah4;
import dc.ce3;
import dc.ch3;
import dc.e82;
import dc.ff3;
import dc.h12;
import dc.kf;
import dc.mp1;
import dc.pc1;
import dc.qo;
import dc.rq1;
import dc.sg3;
import dc.so3;
import dc.th4;
import dc.zb2;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import net.qiujuer.genius.graphics.Blur;
import pl.droidsonroids.gif.GifDrawable;
import pl.droidsonroids.gif.GifImageView;

/* loaded from: classes3.dex */
public class SearchChatUserMessageAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements View.OnClickListener {
    public Context a;
    public List<CommunMessage> b;
    public j c;
    public so3 i;
    public LottieAnimationView j;
    public boolean k;
    public e82 l;
    public IPeopleInfo o;
    public int g = -1;
    public HashMap<String, GifImageView> m = new HashMap<>();
    public HashMap<String, View> n = new HashMap<>();
    public Account d = ch3.n().u();
    public qo e = new qo().h(R.drawable.chat_avatar_default).X(R.drawable.chat_avatar_default);
    public Handler f = new Handler(Looper.getMainLooper());
    public ChatVideoControl h = ChatVideoControl.a1();

    public static class PictureViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_user_img)
        public RoundedImageView iv_user_img;

        @BindView(R.id.iv_user_picture)
        public GifImageView iv_user_picture;

        @BindView(R.id.tv_time)
        public TextView tv_time;

        @BindView(R.id.tv_user_name)
        public TextView tv_user_name;

        public PictureViewHolder(@NonNull View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    public class PictureViewHolder_ViewBinding implements Unbinder {
        public PictureViewHolder a;

        @UiThread
        public PictureViewHolder_ViewBinding(PictureViewHolder pictureViewHolder, View view) {
            this.a = pictureViewHolder;
            pictureViewHolder.iv_user_img = (RoundedImageView) Utils.findRequiredViewAsType(view, R.id.iv_user_img, "field 'iv_user_img'", RoundedImageView.class);
            pictureViewHolder.tv_user_name = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_user_name, "field 'tv_user_name'", TextView.class);
            pictureViewHolder.tv_time = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_time, "field 'tv_time'", TextView.class);
            pictureViewHolder.iv_user_picture = (GifImageView) Utils.findRequiredViewAsType(view, R.id.iv_user_picture, "field 'iv_user_picture'", GifImageView.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            PictureViewHolder pictureViewHolder = this.a;
            if (pictureViewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.a = null;
            pictureViewHolder.iv_user_img = null;
            pictureViewHolder.tv_user_name = null;
            pictureViewHolder.tv_time = null;
            pictureViewHolder.iv_user_picture = null;
        }
    }

    public static class ShortVideoViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_user_img)
        public RoundedImageView iv_user_img;

        @BindView(R.id.iv_user_picture)
        public GifImageView iv_user_picture;

        @BindView(R.id.tv_time)
        public TextView tv_time;

        @BindView(R.id.tv_user_name)
        public TextView tv_user_name;

        public ShortVideoViewHolder(@NonNull View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    public class ShortVideoViewHolder_ViewBinding implements Unbinder {
        public ShortVideoViewHolder a;

        @UiThread
        public ShortVideoViewHolder_ViewBinding(ShortVideoViewHolder shortVideoViewHolder, View view) {
            this.a = shortVideoViewHolder;
            shortVideoViewHolder.iv_user_img = (RoundedImageView) Utils.findRequiredViewAsType(view, R.id.iv_user_img, "field 'iv_user_img'", RoundedImageView.class);
            shortVideoViewHolder.tv_user_name = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_user_name, "field 'tv_user_name'", TextView.class);
            shortVideoViewHolder.tv_time = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_time, "field 'tv_time'", TextView.class);
            shortVideoViewHolder.iv_user_picture = (GifImageView) Utils.findRequiredViewAsType(view, R.id.iv_user_picture, "field 'iv_user_picture'", GifImageView.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            ShortVideoViewHolder shortVideoViewHolder = this.a;
            if (shortVideoViewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.a = null;
            shortVideoViewHolder.iv_user_img = null;
            shortVideoViewHolder.tv_user_name = null;
            shortVideoViewHolder.tv_time = null;
            shortVideoViewHolder.iv_user_picture = null;
        }
    }

    public class a extends SimpleImageLoadingListener {
        public final /* synthetic */ boolean a;
        public final /* synthetic */ String b;
        public final /* synthetic */ PictureViewHolder c;
        public final /* synthetic */ CommunMessage d;

        /* renamed from: com.wear.adapter.longdistance.SearchChatUserMessageAdapter$a$a, reason: collision with other inner class name */
        public class C0079a extends SimpleImageLoadingListener {
            public C0079a() {
            }

            @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
            public void onLoadingComplete(String str, View view, Bitmap bitmap) {
                a aVar = a.this;
                SearchChatUserMessageAdapter searchChatUserMessageAdapter = SearchChatUserMessageAdapter.this;
                String str2 = aVar.b;
                searchChatUserMessageAdapter.G(str, view, bitmap, str2, aVar.d, str2, aVar.a, aVar.c);
            }

            @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
            public void onLoadingFailed(String str, View view, FailReason failReason) {
                ((ImageView) view).setImageResource(R.drawable.content_icon_picture_loading);
                SearchChatUserMessageAdapter.this.n.put(a.this.b, view);
            }

            @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
            public void onLoadingStarted(String str, View view) {
                ((ImageView) view).setImageResource(R.drawable.content_icon_picture_loading);
            }
        }

        public a(boolean z, String str, PictureViewHolder pictureViewHolder, CommunMessage communMessage) {
            this.a = z;
            this.b = str;
            this.c = pictureViewHolder;
            this.d = communMessage;
        }

        @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
        public void onLoadingComplete(String str, View view, Bitmap bitmap) {
            SearchChatUserMessageAdapter searchChatUserMessageAdapter = SearchChatUserMessageAdapter.this;
            String str2 = this.b;
            searchChatUserMessageAdapter.G(str, view, bitmap, str2, this.d, str2, this.a, this.c);
        }

        @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
        public void onLoadingFailed(String str, View view, FailReason failReason) {
            ImageLoader imageLoader = ImageLoader.getInstance();
            StringBuilder sb = new StringBuilder();
            sb.append(WearUtils.e.replace("-api", ""));
            sb.append(this.a ? this.b.replace("thum_", "") : this.b);
            imageLoader.displayImage(sb.toString(), this.c.iv_user_picture, MyApplication.Y, new C0079a());
        }

        @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
        public void onLoadingStarted(String str, View view) {
            ((ImageView) view).setImageResource(R.drawable.content_icon_picture_loading);
        }
    }

    public class b extends SimpleImageLoadingListener {
        public final /* synthetic */ String a;
        public final /* synthetic */ CommunMessage b;
        public final /* synthetic */ String c;
        public final /* synthetic */ boolean d;
        public final /* synthetic */ PictureViewHolder e;

        public b(String str, CommunMessage communMessage, String str2, boolean z, PictureViewHolder pictureViewHolder) {
            this.a = str;
            this.b = communMessage;
            this.c = str2;
            this.d = z;
            this.e = pictureViewHolder;
        }

        @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
        public void onLoadingComplete(String str, View view, Bitmap bitmap) {
            SearchChatUserMessageAdapter.this.G(str, view, bitmap, this.a, this.b, this.c, this.d, this.e);
        }

        @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
        public void onLoadingFailed(String str, View view, FailReason failReason) {
            ((ImageView) view).setImageResource(R.drawable.content_icon_picture_loading);
            SearchChatUserMessageAdapter.this.n.put(str, view);
        }

        @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
        public void onLoadingStarted(String str, View view) {
            ((ImageView) view).setImageResource(R.drawable.content_icon_picture_loading);
        }
    }

    public class c extends SimpleImageLoadingListener {
        public final /* synthetic */ boolean a;
        public final /* synthetic */ String b;
        public final /* synthetic */ PictureViewHolder c;
        public final /* synthetic */ CommunMessage d;

        public class a extends SimpleImageLoadingListener {
            public a() {
            }

            @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
            public void onLoadingComplete(String str, View view, Bitmap bitmap) {
                c cVar = c.this;
                SearchChatUserMessageAdapter searchChatUserMessageAdapter = SearchChatUserMessageAdapter.this;
                String str2 = cVar.b;
                searchChatUserMessageAdapter.G(str, view, bitmap, str2, cVar.d, str2, cVar.a, cVar.c);
            }

            @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
            public void onLoadingFailed(String str, View view, FailReason failReason) {
                ((ImageView) view).setImageResource(R.drawable.content_icon_picture_loading);
                SearchChatUserMessageAdapter.this.n.put(str, view);
            }

            @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
            public void onLoadingStarted(String str, View view) {
                ((ImageView) view).setImageResource(R.drawable.content_icon_picture_loading);
            }
        }

        public c(boolean z, String str, PictureViewHolder pictureViewHolder, CommunMessage communMessage) {
            this.a = z;
            this.b = str;
            this.c = pictureViewHolder;
            this.d = communMessage;
        }

        @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
        public void onLoadingComplete(String str, View view, Bitmap bitmap) {
            SearchChatUserMessageAdapter searchChatUserMessageAdapter = SearchChatUserMessageAdapter.this;
            String str2 = this.b;
            searchChatUserMessageAdapter.G(str, view, bitmap, str2, this.d, str2, this.a, this.c);
        }

        @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
        public void onLoadingFailed(String str, View view, FailReason failReason) {
            ImageLoader imageLoader = ImageLoader.getInstance();
            StringBuilder sb = new StringBuilder();
            sb.append(WearUtils.e.replace("-api", ""));
            sb.append(this.a ? this.b.replace("thum_", "") : this.b);
            imageLoader.displayImage(sb.toString(), this.c.iv_user_picture, MyApplication.Y, new a());
        }

        @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
        public void onLoadingStarted(String str, View view) {
            ((ImageView) view).setImageResource(R.drawable.content_icon_picture_loading);
        }
    }

    public class d extends SimpleImageLoadingListener {
        public final /* synthetic */ String a;
        public final /* synthetic */ ShortVideoViewHolder b;
        public final /* synthetic */ CommunMessage c;

        public class a extends SimpleImageLoadingListener {
            public a() {
            }

            @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
            public void onLoadingComplete(String str, View view, Bitmap bitmap) {
                d dVar = d.this;
                SearchChatUserMessageAdapter searchChatUserMessageAdapter = SearchChatUserMessageAdapter.this;
                String str2 = dVar.a;
                searchChatUserMessageAdapter.G(str, view, bitmap, str2, dVar.c, str2, false, dVar.b);
            }

            @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
            public void onLoadingFailed(String str, View view, FailReason failReason) {
                ((ImageView) view).setImageResource(R.drawable.content_icon_picture_loading);
                if (WearUtils.e1(d.this.a)) {
                    return;
                }
                SearchChatUserMessageAdapter.this.n.put(d.this.a, view);
            }

            @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
            public void onLoadingStarted(String str, View view) {
                ((ImageView) view).setImageResource(R.drawable.content_icon_picture_loading);
            }
        }

        public d(String str, ShortVideoViewHolder shortVideoViewHolder, CommunMessage communMessage) {
            this.a = str;
            this.b = shortVideoViewHolder;
            this.c = communMessage;
        }

        @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
        public void onLoadingComplete(String str, View view, Bitmap bitmap) {
            SearchChatUserMessageAdapter searchChatUserMessageAdapter = SearchChatUserMessageAdapter.this;
            String str2 = this.a;
            searchChatUserMessageAdapter.G(str, view, bitmap, str2, this.c, str2, false, this.b);
        }

        @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
        public void onLoadingFailed(String str, View view, FailReason failReason) {
            ImageLoader.getInstance().displayImage(WearUtils.e.replace("-api", "") + this.a, this.b.iv_user_picture, MyApplication.Y, new a());
        }

        @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
        public void onLoadingStarted(String str, View view) {
            ((ImageView) view).setImageResource(R.drawable.content_icon_picture_loading);
        }
    }

    public class e extends SimpleImageLoadingListener {
        public final /* synthetic */ String a;
        public final /* synthetic */ CommunMessage b;
        public final /* synthetic */ String c;
        public final /* synthetic */ ShortVideoViewHolder d;

        public e(String str, CommunMessage communMessage, String str2, ShortVideoViewHolder shortVideoViewHolder) {
            this.a = str;
            this.b = communMessage;
            this.c = str2;
            this.d = shortVideoViewHolder;
        }

        @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
        public void onLoadingComplete(String str, View view, Bitmap bitmap) {
            SearchChatUserMessageAdapter.this.G(str, view, bitmap, this.a, this.b, this.c, false, this.d);
        }

        @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
        public void onLoadingFailed(String str, View view, FailReason failReason) {
            ((ImageView) view).setImageResource(R.drawable.content_icon_picture_loading);
            SearchChatUserMessageAdapter.this.n.put(str, view);
        }

        @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
        public void onLoadingStarted(String str, View view) {
            ((ImageView) view).setImageResource(R.drawable.content_icon_picture_loading);
        }
    }

    public class f extends SimpleImageLoadingListener {
        public final /* synthetic */ String a;
        public final /* synthetic */ ShortVideoViewHolder b;
        public final /* synthetic */ CommunMessage c;

        public class a extends SimpleImageLoadingListener {
            public a() {
            }

            @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
            public void onLoadingComplete(String str, View view, Bitmap bitmap) {
                f fVar = f.this;
                SearchChatUserMessageAdapter searchChatUserMessageAdapter = SearchChatUserMessageAdapter.this;
                String str2 = fVar.a;
                searchChatUserMessageAdapter.G(str, view, bitmap, str2, fVar.c, str2, false, fVar.b);
            }

            @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
            public void onLoadingFailed(String str, View view, FailReason failReason) {
                ((ImageView) view).setImageResource(R.drawable.content_icon_picture_loading);
                SearchChatUserMessageAdapter.this.n.put(str, view);
            }

            @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
            public void onLoadingStarted(String str, View view) {
                ((ImageView) view).setImageResource(R.drawable.content_icon_picture_loading);
            }
        }

        public f(String str, ShortVideoViewHolder shortVideoViewHolder, CommunMessage communMessage) {
            this.a = str;
            this.b = shortVideoViewHolder;
            this.c = communMessage;
        }

        @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
        public void onLoadingComplete(String str, View view, Bitmap bitmap) {
            SearchChatUserMessageAdapter searchChatUserMessageAdapter = SearchChatUserMessageAdapter.this;
            String str2 = this.a;
            searchChatUserMessageAdapter.G(str, view, bitmap, str2, this.c, str2, false, this.b);
        }

        @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
        public void onLoadingFailed(String str, View view, FailReason failReason) {
            ImageLoader.getInstance().displayImage(WearUtils.e.replace("-api", "") + this.a, this.b.iv_user_picture, MyApplication.Y, new a());
        }

        @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
        public void onLoadingStarted(String str, View view) {
            ((ImageView) view).setImageResource(R.drawable.content_icon_picture_loading);
        }
    }

    public class g extends ff3 {
        public final /* synthetic */ CommunMessage a;
        public final /* synthetic */ LottieAnimationView b;

        public class a extends ff3 {
            public final /* synthetic */ boolean a;

            public a(boolean z) {
                this.a = z;
            }

            @Override // dc.ff3
            public void b(boolean z, Object obj) throws IllegalStateException {
                int iIntValue = obj != null ? ((Integer) obj).intValue() : -1;
                System.out.println("temp." + iIntValue);
                if (iIntValue == -1) {
                    h12.D.isPlayAudio = false;
                    if (this.a) {
                        SearchChatUserMessageAdapter.this.i.G();
                        SearchChatUserMessageAdapter.this.i.x();
                        pc1.a.u0();
                    }
                    SearchChatUserMessageAdapter.this.J(true);
                    return;
                }
                if (this.a) {
                    int i = (iIntValue * 80) / 100;
                    if (mp1.h()) {
                        rq1.d.e(i, new ToyControlBuilder(ToyControlBuilder.a.SPEED));
                        return;
                    }
                    pc1 pc1Var = pc1.a;
                    int i2 = i * 5;
                    pc1Var.W(i2);
                    pc1Var.Y(i2);
                }
            }
        }

        public class b implements Runnable {
            public b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                g gVar = g.this;
                SearchChatUserMessageAdapter.this.j = gVar.b;
                SearchChatUserMessageAdapter.this.j.setAnimation(SearchChatUserMessageAdapter.this.C());
                SearchChatUserMessageAdapter.this.j.p(true);
                SearchChatUserMessageAdapter.this.j.r();
            }
        }

        public g(CommunMessage communMessage, LottieAnimationView lottieAnimationView) {
            this.a = communMessage;
            this.b = lottieAnimationView;
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x002b  */
        @Override // dc.ff3
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void b(boolean r4, java.lang.Object r5) throws java.lang.IllegalStateException {
            /*
                r3 = this;
                if (r4 == 0) goto Lcf
                java.io.File r5 = (java.io.File) r5
                dc.ch3 r4 = com.wear.util.WearUtils.y
                com.wear.adapter.longdistance.SearchChatUserMessageAdapter r0 = com.wear.adapter.longdistance.SearchChatUserMessageAdapter.this
                com.wear.bean.handlerbean.IPeopleInfo r0 = com.wear.adapter.longdistance.SearchChatUserMessageAdapter.n(r0)
                java.lang.String r0 = r0.getId()
                com.wear.bean.UserSetting r4 = r4.z(r0)
                r0 = 0
                if (r4 == 0) goto L2b
                java.lang.Boolean r4 = r4.getAudioVibration()
                boolean r4 = r4.booleanValue()
                com.wear.adapter.longdistance.SearchChatUserMessageAdapter r1 = com.wear.adapter.longdistance.SearchChatUserMessageAdapter.this
                com.wear.bean.handlerbean.IPeopleInfo r1 = com.wear.adapter.longdistance.SearchChatUserMessageAdapter.n(r1)
                boolean r1 = r1.isDateIng()
                if (r1 == 0) goto L2c
            L2b:
                r4 = 0
            L2c:
                if (r4 == 0) goto L52
                dc.na2 r1 = dc.na2.m()
                boolean r1 = r1.i()
                if (r1 == 0) goto L39
                r4 = 0
            L39:
                if (r4 == 0) goto L52
                com.wear.adapter.longdistance.SearchChatUserMessageAdapter r1 = com.wear.adapter.longdistance.SearchChatUserMessageAdapter.this
                dc.so3 r1 = com.wear.adapter.longdistance.SearchChatUserMessageAdapter.o(r1)
                r1.G()
                com.wear.adapter.longdistance.SearchChatUserMessageAdapter r1 = com.wear.adapter.longdistance.SearchChatUserMessageAdapter.this
                dc.so3 r1 = com.wear.adapter.longdistance.SearchChatUserMessageAdapter.o(r1)
                r1.x()
                dc.pc1 r1 = dc.pc1.a
                r1.u0()
            L52:
                com.wear.adapter.longdistance.SearchChatUserMessageAdapter r1 = com.wear.adapter.longdistance.SearchChatUserMessageAdapter.this
                dc.so3 r1 = com.wear.adapter.longdistance.SearchChatUserMessageAdapter.o(r1)
                r1.F()
                com.wear.adapter.longdistance.SearchChatUserMessageAdapter r1 = com.wear.adapter.longdistance.SearchChatUserMessageAdapter.this
                r1.J(r0)
                com.wear.adapter.longdistance.SearchChatUserMessageAdapter r1 = com.wear.adapter.longdistance.SearchChatUserMessageAdapter.this
                java.util.List r1 = com.wear.adapter.longdistance.SearchChatUserMessageAdapter.p(r1)
                com.wear.protocol.CommunMessage r2 = r3.a
                int r1 = r1.indexOf(r2)
                com.wear.adapter.longdistance.SearchChatUserMessageAdapter r2 = com.wear.adapter.longdistance.SearchChatUserMessageAdapter.this
                int r2 = com.wear.adapter.longdistance.SearchChatUserMessageAdapter.q(r2)
                if (r2 != r1) goto L7f
                com.wear.adapter.longdistance.SearchChatUserMessageAdapter r4 = com.wear.adapter.longdistance.SearchChatUserMessageAdapter.this
                r5 = -1
                com.wear.adapter.longdistance.SearchChatUserMessageAdapter.r(r4, r5)
                com.wear.bean.event.MusicPlayEvent r4 = dc.h12.D
                r4.isPlayAudio = r0
                return
            L7f:
                com.wear.main.closeRange.music.MusicControl r0 = com.wear.main.closeRange.music.MusicControl.h0()
                boolean r0 = r0.O()
                if (r0 == 0) goto L97
                com.wear.bean.event.MusicPlayEvent r0 = dc.h12.D
                r2 = 1
                r0.isPlayAudio = r2
                org.greenrobot.eventbus.EventBus r0 = org.greenrobot.eventbus.EventBus.getDefault()
                com.wear.bean.event.MusicPlayEvent r2 = dc.h12.D
                r0.post(r2)
            L97:
                dc.y12$b r0 = dc.y12.c
                dc.y12 r0 = r0.a()
                dc.y12$c r2 = dc.y12.c.TYPE_VOICE_BOOK
                dc.x12 r0 = r0.i(r2)
                dc.k22 r0 = (dc.k22) r0
                if (r0 == 0) goto Laa
                r0.B()
            Laa:
                com.wear.adapter.longdistance.SearchChatUserMessageAdapter r0 = com.wear.adapter.longdistance.SearchChatUserMessageAdapter.this
                com.wear.adapter.longdistance.SearchChatUserMessageAdapter.r(r0, r1)
                com.wear.adapter.longdistance.SearchChatUserMessageAdapter r0 = com.wear.adapter.longdistance.SearchChatUserMessageAdapter.this
                dc.so3 r0 = com.wear.adapter.longdistance.SearchChatUserMessageAdapter.o(r0)
                java.lang.String r5 = r5.getAbsolutePath()
                com.wear.adapter.longdistance.SearchChatUserMessageAdapter$g$a r1 = new com.wear.adapter.longdistance.SearchChatUserMessageAdapter$g$a
                r1.<init>(r4)
                r0.E(r5, r1, r4)
                com.wear.adapter.longdistance.SearchChatUserMessageAdapter r4 = com.wear.adapter.longdistance.SearchChatUserMessageAdapter.this
                android.os.Handler r4 = com.wear.adapter.longdistance.SearchChatUserMessageAdapter.v(r4)
                com.wear.adapter.longdistance.SearchChatUserMessageAdapter$g$b r5 = new com.wear.adapter.longdistance.SearchChatUserMessageAdapter$g$b
                r5.<init>()
                r4.post(r5)
            Lcf:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.wear.adapter.longdistance.SearchChatUserMessageAdapter.g.b(boolean, java.lang.Object):void");
        }
    }

    public class h implements Runnable {
        public final /* synthetic */ boolean a;

        public h(boolean z) {
            this.a = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (SearchChatUserMessageAdapter.this.j != null) {
                SearchChatUserMessageAdapter.this.j.q();
                SearchChatUserMessageAdapter.this.j.g();
                SearchChatUserMessageAdapter.this.j.setImageDrawable(th4.d(SearchChatUserMessageAdapter.this.a, R.drawable.chat_voicemessage_receive));
            }
            if (this.a) {
                SearchChatUserMessageAdapter.this.g = -1;
            }
        }
    }

    public static /* synthetic */ class i {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[MessageType.values().length];
            a = iArr;
            try {
                iArr[MessageType.chat.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[MessageType.audio.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[MessageType.picture.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[MessageType.shortvideo.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public interface j {
        void c(CommunMessage communMessage);

        void s2(CommunMessage communMessage);
    }

    public SearchChatUserMessageAdapter(Context context, IPeopleInfo iPeopleInfo, so3 so3Var, List<CommunMessage> list, e82 e82Var, boolean z, j jVar) {
        this.a = context;
        this.b = list;
        this.o = iPeopleInfo;
        this.c = jVar;
        this.i = so3Var;
        this.l = e82Var;
        this.k = z;
    }

    public final void A(PictureViewHolder pictureViewHolder, CommunMessage communMessage, IPeopleInfo iPeopleInfo, String str) {
        I(pictureViewHolder.iv_user_img, iPeopleInfo);
        pictureViewHolder.tv_user_name.setText(str);
        pictureViewHolder.tv_time.setText(WearUtils.u0(communMessage.getCreated()));
        EntityPicture entityPicture = (EntityPicture) communMessage.getDataBean();
        String type = entityPicture.getType();
        boolean z = !WearUtils.e1(type) && type.equals("emoji");
        String url = entityPicture.getUrl();
        String localUrl = entityPicture.getLocalUrl();
        pictureViewHolder.iv_user_picture.setOnClickListener(this);
        pictureViewHolder.iv_user_picture.setTag(R.id.tag1, communMessage);
        F(communMessage, pictureViewHolder, z, url, localUrl);
    }

    public final void B(ShortVideoViewHolder shortVideoViewHolder, CommunMessage communMessage, IPeopleInfo iPeopleInfo, String str) {
        I(shortVideoViewHolder.iv_user_img, iPeopleInfo);
        shortVideoViewHolder.tv_user_name.setText(str);
        shortVideoViewHolder.tv_time.setText(WearUtils.u0(communMessage.getCreated()));
        shortVideoViewHolder.iv_user_picture.setOnClickListener(this);
        shortVideoViewHolder.iv_user_picture.setTag(R.id.tag1, communMessage);
        H(communMessage, shortVideoViewHolder);
    }

    public final String C() {
        int i2 = MyApplication.m0;
        return i2 != 2 ? (i2 == 0 && MyApplication.l0) ? "voice_default_dark_receive_white.json" : "voice_default_white_receive_black.json" : "voice_default_dark_receive_white.json";
    }

    public HashMap<String, GifImageView> D() {
        return this.m;
    }

    public View E(String str) {
        return this.n.get(str);
    }

    public final void F(CommunMessage communMessage, PictureViewHolder pictureViewHolder, boolean z, String str, String str2) {
        PictureBean pictureBean = (pictureViewHolder.iv_user_picture.getTag() == null || !(pictureViewHolder.iv_user_picture.getTag() instanceof PictureBean)) ? null : (PictureBean) pictureViewHolder.iv_user_picture.getTag();
        boolean zF = this.l.F(communMessage.getId());
        if (!TextUtils.equals(ch3.n().p(), communMessage.getFrom())) {
            if (pictureBean != null && str.equals(pictureBean.url) && zF == pictureBean.isHide) {
                return;
            }
            ImageLoader imageLoader = ImageLoader.getInstance();
            StringBuilder sb = new StringBuilder();
            sb.append(WearUtils.e);
            sb.append(z ? str.replace("thum_", "") : str);
            imageLoader.displayImage(sb.toString(), pictureViewHolder.iv_user_picture, MyApplication.Y, new a(z, str, pictureViewHolder, communMessage));
            return;
        }
        if (!WearUtils.e1(str2) && (WearUtils.c0(str2).exists() || WearUtils.Z(str2).exists() || WearUtils.a0(str2).exists())) {
            if (pictureBean != null && str2.equals(pictureBean.localUrl) && zF == pictureBean.isHide) {
                return;
            }
            ImageLoader.getInstance().displayImage(Uri.fromFile(z ? WearUtils.Z(str2).exists() ? WearUtils.Z(str2) : WearUtils.a0(str2) : WearUtils.c0(str2)).toString(), pictureViewHolder.iv_user_picture, MyApplication.Y, new b(str2, communMessage, str, z, pictureViewHolder));
            return;
        }
        if (WearUtils.e1(str)) {
            pictureViewHolder.iv_user_picture.setImageResource(R.drawable.content_icon_picture_loading);
            this.n.put(str, pictureViewHolder.iv_user_picture);
        } else {
            if (pictureBean != null && str.equals(pictureBean.url) && zF == pictureBean.isHide) {
                return;
            }
            ImageLoader imageLoader2 = ImageLoader.getInstance();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(WearUtils.e);
            sb2.append(z ? str.replace("thum_", "") : str);
            imageLoader2.displayImage(sb2.toString(), pictureViewHolder.iv_user_picture, MyApplication.Y, new c(z, str, pictureViewHolder, communMessage));
        }
    }

    public final void G(String str, View view, Bitmap bitmap, String str2, CommunMessage communMessage, String str3, boolean z, RecyclerView.ViewHolder viewHolder) {
        if ((viewHolder instanceof PictureViewHolder) || (viewHolder instanceof ShortVideoViewHolder)) {
            PictureBean pictureBean = new PictureBean();
            pictureBean.url = str3;
            pictureBean.localUrl = str2;
            pictureBean.isHide = this.l.F(communMessage.getId());
            view.setTag(pictureBean);
            if (bitmap == null) {
                ((ImageView) view).setImageResource(R.drawable.content_icon_picture_loading);
                return;
            }
            int iA = ce3.a(this.a, 180.0f);
            int iA2 = ce3.a(this.a, 80.0f);
            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) view.getLayoutParams();
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            ImageSize imageSizeA = MyApplication.X.a(str);
            if (imageSizeA != null && (imageSizeA.getWidth() != width || imageSizeA.getHeight() != height)) {
                width = imageSizeA.getWidth();
                height = imageSizeA.getHeight();
            }
            if (width >= height) {
                if (width >= iA) {
                    int i2 = (height * iA) / width;
                    if (i2 < iA2) {
                        ((ViewGroup.MarginLayoutParams) layoutParams).width = iA;
                        ((ViewGroup.MarginLayoutParams) layoutParams).height = iA2;
                    } else {
                        ((ViewGroup.MarginLayoutParams) layoutParams).width = iA;
                        ((ViewGroup.MarginLayoutParams) layoutParams).height = i2;
                    }
                } else if (height <= iA2) {
                    ((ViewGroup.MarginLayoutParams) layoutParams).width = (width * iA2) / height;
                    ((ViewGroup.MarginLayoutParams) layoutParams).height = iA2;
                } else {
                    ((ViewGroup.MarginLayoutParams) layoutParams).width = width;
                    ((ViewGroup.MarginLayoutParams) layoutParams).height = height;
                }
            } else if (height >= iA) {
                int i3 = (width * iA) / height;
                if (i3 < iA2) {
                    ((ViewGroup.MarginLayoutParams) layoutParams).width = iA2;
                    ((ViewGroup.MarginLayoutParams) layoutParams).height = iA;
                } else {
                    ((ViewGroup.MarginLayoutParams) layoutParams).width = i3;
                    ((ViewGroup.MarginLayoutParams) layoutParams).height = iA;
                }
            } else if (width <= iA2) {
                ((ViewGroup.MarginLayoutParams) layoutParams).width = iA2;
                ((ViewGroup.MarginLayoutParams) layoutParams).height = (iA2 * height) / width;
            } else {
                ((ViewGroup.MarginLayoutParams) layoutParams).width = width;
                ((ViewGroup.MarginLayoutParams) layoutParams).height = height;
            }
            if (layoutParams != null) {
                if (pictureBean.isHide) {
                    Bitmap bitmapCopy = bitmap.copy(bitmap.getConfig(), true);
                    int width2 = bitmapCopy.getWidth();
                    int height2 = bitmapCopy.getHeight();
                    int[] iArr = new int[width2 * height2];
                    bitmapCopy.getPixels(iArr, 0, width2, 0, 0, width2, height2);
                    Blur.c(iArr, width2, height2, 25);
                    bitmapCopy.setPixels(iArr, 0, width2, 0, 0, width2, height2);
                    Blur.b(bitmapCopy, 25);
                    ((GifImageView) view).setImageBitmap(bitmapCopy);
                }
                GifImageView gifImageView = new GifImageView(this.a);
                gifImageView.setImageBitmap(bitmap);
                gifImageView.setLayoutParams(layoutParams);
                this.m.put(str, gifImageView);
                view.setLayoutParams(layoutParams);
                this.n.put(str, view);
            }
            if (z) {
                File file = ImageLoader.getInstance().getDiskCache().get(str);
                ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
                layoutParams2.width = 200;
                layoutParams2.height = (bitmap.getHeight() * 200) / bitmap.getWidth();
                if (file.exists()) {
                    try {
                        GifDrawable gifDrawable = new GifDrawable(file);
                        if (viewHolder instanceof PictureViewHolder) {
                            ((PictureViewHolder) viewHolder).iv_user_picture.setImageDrawable(gifDrawable);
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            }
        }
    }

    public final void H(CommunMessage communMessage, ShortVideoViewHolder shortVideoViewHolder) {
        EntityShortVideo entityShortVideo = (EntityShortVideo) communMessage.getDataBean();
        String picUrl = entityShortVideo.getPicUrl();
        String picLocalUrl = entityShortVideo.getPicLocalUrl();
        PictureBean pictureBean = (shortVideoViewHolder.iv_user_picture.getTag() == null || !(shortVideoViewHolder.iv_user_picture.getTag() instanceof PictureBean)) ? null : (PictureBean) shortVideoViewHolder.iv_user_picture.getTag();
        boolean zF = this.l.F(communMessage.getId());
        if (!TextUtils.equals(ch3.n().p(), communMessage.getFrom())) {
            if (pictureBean == null || WearUtils.e1(picUrl) || !picUrl.equals(pictureBean.url) || zF != pictureBean.isHide) {
                ImageLoader.getInstance().displayImage(WearUtils.e + picUrl, shortVideoViewHolder.iv_user_picture, MyApplication.Y, new d(picUrl, shortVideoViewHolder, communMessage));
                return;
            }
            return;
        }
        if (!WearUtils.e1(picLocalUrl) && (WearUtils.c0(picLocalUrl).exists() || WearUtils.Z(picLocalUrl).exists() || WearUtils.a0(picLocalUrl).exists())) {
            if (pictureBean != null && picLocalUrl.equals(pictureBean.localUrl) && zF == pictureBean.isHide) {
                return;
            }
            ImageLoader.getInstance().displayImage(Uri.fromFile(WearUtils.c0(picLocalUrl)).toString(), shortVideoViewHolder.iv_user_picture, MyApplication.Y, new e(picLocalUrl, communMessage, picUrl, shortVideoViewHolder));
            return;
        }
        if (WearUtils.e1(picUrl)) {
            shortVideoViewHolder.iv_user_picture.setImageResource(R.drawable.content_icon_picture_loading);
            this.n.put(picUrl, shortVideoViewHolder.iv_user_picture);
        } else {
            if (pictureBean != null && picUrl.equals(pictureBean.url) && zF == pictureBean.isHide) {
                return;
            }
            ImageLoader.getInstance().displayImage(WearUtils.e + picUrl, shortVideoViewHolder.iv_user_picture, MyApplication.Y, new f(picUrl, shortVideoViewHolder, communMessage));
        }
    }

    public final void I(RoundedImageView roundedImageView, IPeopleInfo iPeopleInfo) {
        String strM = zb2.O().M(iPeopleInfo.getUserJid());
        if (!TextUtils.isEmpty(strM) && !strM.startsWith("http")) {
            strM = WearUtils.e + strM;
        }
        kf.w(this.a).v(strM).a(this.e).A0(roundedImageView);
    }

    public void J(boolean z) {
        this.f.post(new h(z));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.b.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i2) {
        int i3 = i.a[this.b.get(i2).getType().ordinal()];
        if (i3 == 1) {
            return 1;
        }
        if (i3 == 2) {
            return 5;
        }
        if (i3 != 3) {
            return i3 != 4 ? 0 : 11;
        }
        return 10;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i2) {
        String showNickName;
        IPeopleInfo iPeopleInfo;
        CommunMessage communMessage = this.b.get(i2);
        viewHolder.itemView.setTag(R.id.tag1, communMessage);
        viewHolder.itemView.setOnClickListener(this);
        if (this.k) {
            Group groupK = ch3.n().k(WearUtils.g0(communMessage.getFrom()));
            if (groupK == null) {
                groupK = ch3.n().k(WearUtils.g0(communMessage.getTo()));
            }
            GroupMember memberByJid = groupK.getMemberByJid(communMessage.getRealFrom());
            showNickName = memberByJid.getNickName();
            iPeopleInfo = memberByJid;
        } else if (TextUtils.equals(ch3.n().p(), communMessage.getFrom())) {
            Account account = this.d;
            showNickName = account.getUserName();
            iPeopleInfo = account;
        } else {
            IPeopleInfo iPeopleInfoS = ch3.n().s(WearUtils.g0(communMessage.getFrom()));
            if (iPeopleInfoS != null) {
                showNickName = iPeopleInfoS.getShowNickName();
                iPeopleInfo = iPeopleInfoS;
            } else {
                showNickName = "";
                iPeopleInfo = iPeopleInfoS;
            }
        }
        if (viewHolder instanceof SearchChatHistoryAdapter.ViewHolder) {
            z((SearchChatHistoryAdapter.ViewHolder) viewHolder, communMessage, iPeopleInfo, showNickName);
            return;
        }
        if (viewHolder instanceof SearchChatAudioAdapter.ViewHolder) {
            y((SearchChatAudioAdapter.ViewHolder) viewHolder, communMessage, iPeopleInfo, showNickName);
        } else if (viewHolder instanceof PictureViewHolder) {
            A((PictureViewHolder) viewHolder, communMessage, iPeopleInfo, showNickName);
        } else if (viewHolder instanceof ShortVideoViewHolder) {
            B((ShortVideoViewHolder) viewHolder, communMessage, iPeopleInfo, showNickName);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        CommunMessage communMessage = (CommunMessage) view.getTag(R.id.tag1);
        int id = view.getId();
        if (id == R.id.iv_user_picture) {
            j jVar = this.c;
            if (jVar != null) {
                jVar.s2(communMessage);
                return;
            }
            return;
        }
        if (id != R.id.ll_audio) {
            j jVar2 = this.c;
            if (jVar2 != null) {
                jVar2.c(communMessage);
                return;
            }
            return;
        }
        if (x()) {
            this.g = -1;
            return;
        }
        CommunMessage communMessage2 = (CommunMessage) view.getTag(R.id.tag1);
        EntityAudio entityAudio = (EntityAudio) communMessage2.getDataBean();
        if (entityAudio == null || entityAudio.isExpired()) {
            return;
        }
        WearUtils.E0(true, entityAudio.getUrl(), new g(communMessage2, (LottieAnimationView) view.findViewById(R.id.lottie_view_audio)));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.a);
        if (i2 == 1) {
            return new SearchChatHistoryAdapter.ViewHolder(layoutInflaterFrom.inflate(R.layout.item_search_chat_history, viewGroup, false));
        }
        if (i2 == 5) {
            return new SearchChatAudioAdapter.ViewHolder(layoutInflaterFrom.inflate(R.layout.item_search_chat_audio, viewGroup, false));
        }
        if (i2 == 10) {
            return new PictureViewHolder(layoutInflaterFrom.inflate(R.layout.item_search_chat_picture, viewGroup, false));
        }
        if (i2 != 11) {
            return null;
        }
        return new ShortVideoViewHolder(layoutInflaterFrom.inflate(R.layout.item_search_chat_shortvideo, viewGroup, false));
    }

    public final boolean x() {
        if (this.h.r()) {
            if (this.d.getCurrentControlType() == MessageType.video) {
                sg3.l(ah4.e(R.string.chat_media_video_busy));
                return true;
            }
            if (this.d.getCurrentControlType() == MessageType.voice) {
                sg3.l(ah4.e(R.string.chat_media_voice_busy));
                return true;
            }
        }
        return false;
    }

    public final void y(SearchChatAudioAdapter.ViewHolder viewHolder, CommunMessage communMessage, IPeopleInfo iPeopleInfo, String str) {
        EntityAudio entityAudio = (EntityAudio) communMessage.getDataBean();
        I(viewHolder.iv_user_img, iPeopleInfo);
        viewHolder.tv_user_name.setText(str);
        viewHolder.tv_time.setText(WearUtils.u0(communMessage.getCreated()));
        boolean zIsExpired = entityAudio.isExpired();
        if (zIsExpired) {
            viewHolder.tv_audio_time.setText("[" + ah4.e(R.string.voice_message_expired) + "]");
        } else {
            viewHolder.tv_audio_time.setText(entityAudio.getTime() + "''");
        }
        int dimensionPixelSize = (this.a.getResources().getDimensionPixelSize(R.dimen.activity_msg_max_lenth) - this.a.getResources().getDimensionPixelSize(R.dimen.activity_msg_min_lenth)) / 60;
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) viewHolder.ll_audio.getLayoutParams();
        if (zIsExpired) {
            ((ViewGroup.MarginLayoutParams) layoutParams).width = -2;
        } else {
            ((ViewGroup.MarginLayoutParams) layoutParams).width = ((int) (dimensionPixelSize * entityAudio.getTime())) + this.a.getResources().getDimensionPixelSize(R.dimen.activity_msg_min_lenth);
        }
        viewHolder.ll_audio.setLayoutParams(layoutParams);
        viewHolder.lottie_view_audio.setImageDrawable(th4.d(this.a, zIsExpired ? R.drawable.chat_voicemessage_receive_expired : R.drawable.chat_voicemessage_receive));
        viewHolder.ll_audio.setTag(R.id.tag1, communMessage);
        viewHolder.ll_audio.setOnClickListener(this);
    }

    public final void z(SearchChatHistoryAdapter.ViewHolder viewHolder, CommunMessage communMessage, IPeopleInfo iPeopleInfo, String str) {
        EntityChat entityChat = (EntityChat) communMessage.getDataBean();
        I(viewHolder.iv_user_img, iPeopleInfo);
        viewHolder.tv_user_name.setText(str);
        viewHolder.tv_time.setText(WearUtils.u0(communMessage.getCreated()));
        viewHolder.tv_content.setText(entityChat.getText());
    }
}
