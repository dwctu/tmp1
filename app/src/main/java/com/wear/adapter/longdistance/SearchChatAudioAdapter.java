package com.wear.adapter.longdistance;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
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
import com.wear.bean.Account;
import com.wear.bean.Group;
import com.wear.bean.GroupMember;
import com.wear.bean.handlerbean.IPeopleInfo;
import com.wear.main.longDistance.control.ChatVideoControl;
import com.wear.protocol.CommunMessage;
import com.wear.protocol.EntityAudio;
import com.wear.protocol.MessageType;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import dc.ToyControlBuilder;
import dc.ah4;
import dc.ch3;
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
import java.util.HashMap;
import java.util.List;

/* loaded from: classes3.dex */
public class SearchChatAudioAdapter extends RecyclerView.Adapter<ViewHolder> implements View.OnClickListener {
    public Context a;
    public List<CommunMessage> b;
    public c c;
    public Account d;
    public qo e;
    public int f;
    public so3 g;
    public boolean h;
    public ChatVideoControl i;
    public Handler j;
    public LottieAnimationView k;
    public IPeopleInfo l;

    public static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_user_img)
        public RoundedImageView iv_user_img;

        @BindView(R.id.ll_audio)
        public LinearLayout ll_audio;

        @BindView(R.id.lottie_view_audio)
        public LottieAnimationView lottie_view_audio;

        @BindView(R.id.tv_audio_time)
        public TextView tv_audio_time;

        @BindView(R.id.tv_time)
        public TextView tv_time;

        @BindView(R.id.tv_user_name)
        public TextView tv_user_name;

        public ViewHolder(@NonNull View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    public class ViewHolder_ViewBinding implements Unbinder {
        public ViewHolder a;

        @UiThread
        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            this.a = viewHolder;
            viewHolder.iv_user_img = (RoundedImageView) Utils.findRequiredViewAsType(view, R.id.iv_user_img, "field 'iv_user_img'", RoundedImageView.class);
            viewHolder.tv_user_name = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_user_name, "field 'tv_user_name'", TextView.class);
            viewHolder.tv_time = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_time, "field 'tv_time'", TextView.class);
            viewHolder.ll_audio = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_audio, "field 'll_audio'", LinearLayout.class);
            viewHolder.lottie_view_audio = (LottieAnimationView) Utils.findRequiredViewAsType(view, R.id.lottie_view_audio, "field 'lottie_view_audio'", LottieAnimationView.class);
            viewHolder.tv_audio_time = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_audio_time, "field 'tv_audio_time'", TextView.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            ViewHolder viewHolder = this.a;
            if (viewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.a = null;
            viewHolder.iv_user_img = null;
            viewHolder.tv_user_name = null;
            viewHolder.tv_time = null;
            viewHolder.ll_audio = null;
            viewHolder.lottie_view_audio = null;
            viewHolder.tv_audio_time = null;
        }
    }

    public class a implements Runnable {
        public final /* synthetic */ boolean a;

        public a(boolean z) {
            this.a = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (SearchChatAudioAdapter.this.k != null) {
                SearchChatAudioAdapter.this.k.q();
                SearchChatAudioAdapter.this.k.g();
                SearchChatAudioAdapter.this.k.setImageDrawable(th4.d(SearchChatAudioAdapter.this.a, R.drawable.chat_voicemessage_receive));
            }
            if (this.a) {
                SearchChatAudioAdapter.this.f = -1;
            }
        }
    }

    public class b extends ff3 {
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
                        SearchChatAudioAdapter.this.g.G();
                        SearchChatAudioAdapter.this.g.x();
                        pc1.a.u0();
                    }
                    SearchChatAudioAdapter.this.A(true);
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

        /* renamed from: com.wear.adapter.longdistance.SearchChatAudioAdapter$b$b, reason: collision with other inner class name */
        public class RunnableC0078b implements Runnable {
            public RunnableC0078b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                b bVar = b.this;
                SearchChatAudioAdapter.this.k = bVar.b;
                SearchChatAudioAdapter.this.k.setAnimation(SearchChatAudioAdapter.this.w());
                SearchChatAudioAdapter.this.k.p(true);
                SearchChatAudioAdapter.this.k.r();
            }
        }

        public b(CommunMessage communMessage, LottieAnimationView lottieAnimationView) {
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
                com.wear.adapter.longdistance.SearchChatAudioAdapter r0 = com.wear.adapter.longdistance.SearchChatAudioAdapter.this
                com.wear.bean.handlerbean.IPeopleInfo r0 = com.wear.adapter.longdistance.SearchChatAudioAdapter.q(r0)
                java.lang.String r0 = r0.getId()
                com.wear.bean.UserSetting r4 = r4.z(r0)
                r0 = 0
                if (r4 == 0) goto L2b
                java.lang.Boolean r4 = r4.getAudioVibration()
                boolean r4 = r4.booleanValue()
                com.wear.adapter.longdistance.SearchChatAudioAdapter r1 = com.wear.adapter.longdistance.SearchChatAudioAdapter.this
                com.wear.bean.handlerbean.IPeopleInfo r1 = com.wear.adapter.longdistance.SearchChatAudioAdapter.q(r1)
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
                com.wear.adapter.longdistance.SearchChatAudioAdapter r1 = com.wear.adapter.longdistance.SearchChatAudioAdapter.this
                dc.so3 r1 = com.wear.adapter.longdistance.SearchChatAudioAdapter.r(r1)
                r1.G()
                com.wear.adapter.longdistance.SearchChatAudioAdapter r1 = com.wear.adapter.longdistance.SearchChatAudioAdapter.this
                dc.so3 r1 = com.wear.adapter.longdistance.SearchChatAudioAdapter.r(r1)
                r1.x()
                dc.pc1 r1 = dc.pc1.a
                r1.u0()
            L52:
                com.wear.adapter.longdistance.SearchChatAudioAdapter r1 = com.wear.adapter.longdistance.SearchChatAudioAdapter.this
                dc.so3 r1 = com.wear.adapter.longdistance.SearchChatAudioAdapter.r(r1)
                r1.F()
                com.wear.adapter.longdistance.SearchChatAudioAdapter r1 = com.wear.adapter.longdistance.SearchChatAudioAdapter.this
                r1.A(r0)
                com.wear.adapter.longdistance.SearchChatAudioAdapter r1 = com.wear.adapter.longdistance.SearchChatAudioAdapter.this
                java.util.List r1 = com.wear.adapter.longdistance.SearchChatAudioAdapter.s(r1)
                com.wear.protocol.CommunMessage r2 = r3.a
                int r1 = r1.indexOf(r2)
                com.wear.adapter.longdistance.SearchChatAudioAdapter r2 = com.wear.adapter.longdistance.SearchChatAudioAdapter.this
                int r2 = com.wear.adapter.longdistance.SearchChatAudioAdapter.o(r2)
                if (r2 != r1) goto L7f
                com.wear.adapter.longdistance.SearchChatAudioAdapter r4 = com.wear.adapter.longdistance.SearchChatAudioAdapter.this
                r5 = -1
                com.wear.adapter.longdistance.SearchChatAudioAdapter.p(r4, r5)
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
                com.wear.adapter.longdistance.SearchChatAudioAdapter r0 = com.wear.adapter.longdistance.SearchChatAudioAdapter.this
                com.wear.adapter.longdistance.SearchChatAudioAdapter.p(r0, r1)
                com.wear.adapter.longdistance.SearchChatAudioAdapter r0 = com.wear.adapter.longdistance.SearchChatAudioAdapter.this
                dc.so3 r0 = com.wear.adapter.longdistance.SearchChatAudioAdapter.r(r0)
                java.lang.String r5 = r5.getAbsolutePath()
                com.wear.adapter.longdistance.SearchChatAudioAdapter$b$a r1 = new com.wear.adapter.longdistance.SearchChatAudioAdapter$b$a
                r1.<init>(r4)
                r0.E(r5, r1, r4)
                com.wear.adapter.longdistance.SearchChatAudioAdapter r4 = com.wear.adapter.longdistance.SearchChatAudioAdapter.this
                android.os.Handler r4 = com.wear.adapter.longdistance.SearchChatAudioAdapter.u(r4)
                com.wear.adapter.longdistance.SearchChatAudioAdapter$b$b r5 = new com.wear.adapter.longdistance.SearchChatAudioAdapter$b$b
                r5.<init>()
                r4.post(r5)
            Lcf:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.wear.adapter.longdistance.SearchChatAudioAdapter.b.b(boolean, java.lang.Object):void");
        }
    }

    public interface c {
        void c(CommunMessage communMessage);
    }

    public SearchChatAudioAdapter(Context context, List<CommunMessage> list, so3 so3Var, boolean z, IPeopleInfo iPeopleInfo, c cVar) {
        new HashMap();
        this.f = -1;
        this.a = context;
        this.l = iPeopleInfo;
        this.b = list;
        this.g = so3Var;
        this.h = z;
        this.c = cVar;
        this.d = ch3.n().u();
        this.e = new qo().h(R.drawable.chat_avatar_default).X(R.drawable.chat_avatar_default);
        this.i = ChatVideoControl.a1();
        this.j = new Handler(Looper.getMainLooper());
    }

    public void A(boolean z) {
        this.j.post(new a(z));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.b.size();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        CommunMessage communMessage = (CommunMessage) view.getTag(R.id.tag1);
        if (view.getId() != R.id.ll_audio) {
            c cVar = this.c;
            if (cVar != null) {
                cVar.c(communMessage);
                return;
            }
            return;
        }
        if (v()) {
            this.f = -1;
            return;
        }
        EntityAudio entityAudio = (EntityAudio) communMessage.getDataBean();
        if (entityAudio == null || entityAudio.isExpired()) {
            return;
        }
        WearUtils.E0(true, entityAudio.getUrl(), new b(communMessage, (LottieAnimationView) view.findViewById(R.id.lottie_view_audio)));
    }

    public final boolean v() {
        if (this.i.r()) {
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

    public final String w() {
        int i = MyApplication.m0;
        return i != 2 ? (i == 0 && MyApplication.l0) ? "voice_default_dark_receive_white.json" : "voice_default_white_receive_black.json" : "voice_default_dark_receive_white.json";
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        String showNickName;
        IPeopleInfo iPeopleInfo;
        CommunMessage communMessage = this.b.get(i);
        if (this.h) {
            Group groupK = ch3.n().k(WearUtils.g0(communMessage.getFrom()));
            if (groupK == null) {
                groupK = ch3.n().k(WearUtils.g0(communMessage.getTo()));
            }
            GroupMember memberByJid = groupK.getMemberByJid(communMessage.getRealFrom());
            showNickName = memberByJid != null ? memberByJid.getNickName() : "";
            iPeopleInfo = memberByJid;
            if (TextUtils.isEmpty(showNickName)) {
                showNickName = communMessage.getRealFromNickName();
                iPeopleInfo = memberByJid;
            }
        } else if (TextUtils.equals(ch3.n().p(), communMessage.getFrom())) {
            Account account = this.d;
            showNickName = account.getUserName();
            iPeopleInfo = account;
        } else {
            IPeopleInfo iPeopleInfoS = ch3.n().s(WearUtils.g0(communMessage.getFrom()));
            showNickName = iPeopleInfoS.getShowNickName();
            iPeopleInfo = iPeopleInfoS;
        }
        EntityAudio entityAudio = (EntityAudio) communMessage.getDataBean();
        boolean zIsExpired = entityAudio.isExpired();
        if (iPeopleInfo != null) {
            z(viewHolder.iv_user_img, iPeopleInfo);
        }
        viewHolder.tv_user_name.setText(showNickName);
        viewHolder.tv_time.setText(WearUtils.u0(communMessage.getCreated()));
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
        viewHolder.itemView.setTag(R.id.tag1, communMessage);
        viewHolder.itemView.setOnClickListener(this);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(this.a).inflate(R.layout.item_search_chat_audio, viewGroup, false));
    }

    public final void z(RoundedImageView roundedImageView, IPeopleInfo iPeopleInfo) {
        String strM = zb2.O().M(iPeopleInfo.getUserJid());
        if (!TextUtils.isEmpty(strM) && !strM.startsWith("http")) {
            strM = WearUtils.e + strM;
        }
        kf.w(this.a).v(strM).a(this.e).A0(roundedImageView);
    }
}
