package com.wear.adapter.longdistance;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.lovense.wear.R;
import com.wear.adapter.BaseAdapter;
import com.wear.bean.Group;
import com.wear.bean.handlerbean.IPeopleInfo;
import com.wear.bean.official.OfficialAcount;
import com.wear.bean.official.OfficialLangInfo;
import com.wear.main.longDistance.AddFriendActivity;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import dc.ah4;
import dc.ch3;
import dc.ie3;
import dc.kf;
import dc.pj3;
import dc.qo;
import dc.tg3;
import java.util.HashMap;
import java.util.List;
import org.jivesoftware.smack.packet.Presence;

/* loaded from: classes3.dex */
public class NewUserAdapter extends BaseAdapter<IPeopleInfo> {
    public ie3 j;
    public qo k;
    public MyApplication l;
    public b m;

    public class a extends HashMap<String, String> {
        public a() {
            put("count", "" + ch3.i.size());
        }
    }

    public interface b {
        void a(IPeopleInfo iPeopleInfo);

        void b(IPeopleInfo iPeopleInfo);
    }

    public NewUserAdapter(List<IPeopleInfo> list, int i) {
        super(list, i);
        this.k = new qo().h(R.drawable.icon_default_new).X(R.drawable.icon_default_new);
        this.l = MyApplication.N();
        this.j = new ie3();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: B, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void C(View view) {
        WearUtils.x.q("longDistance_add_friend", new a());
        Intent intent = new Intent(z(), (Class<?>) AddFriendActivity.class);
        pj3.d(intent);
        z().startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: D, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void E(IPeopleInfo iPeopleInfo, View view) {
        b bVar = this.m;
        if (bVar != null) {
            bVar.a(iPeopleInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: F, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean G(IPeopleInfo iPeopleInfo, View view) {
        b bVar = this.m;
        if (bVar == null) {
            return true;
        }
        bVar.b(iPeopleInfo);
        return true;
    }

    public String A(OfficialLangInfo officialLangInfo) {
        if (!TextUtils.isEmpty(officialLangInfo.getTitle())) {
            return officialLangInfo.getTitle();
        }
        if (!TextUtils.isEmpty(officialLangInfo.getContent())) {
            return officialLangInfo.getContent();
        }
        if (officialLangInfo.getVideoList() != null && officialLangInfo.getVideoList().size() > 0) {
            return "[" + ah4.e(R.string.chat_shortvideo) + "]";
        }
        if (officialLangInfo.getPictureList() == null || officialLangInfo.getPictureList().size() <= 0) {
            return "";
        }
        return "[" + ah4.e(R.string.message_notification_type_picture) + "]";
    }

    public void H(b bVar) {
        this.m = bVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:140:0x045c  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0479  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0491  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0502  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0532  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x053a  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0540  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x0583  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x05ea  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x05f5  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x05fb  */
    @Override // com.wear.adapter.BaseAdapter
    @androidx.annotation.RequiresApi(api = 21)
    /* renamed from: I, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void y(com.wear.adapter.BaseAdapter.ViewHolder r24, final com.wear.bean.handlerbean.IPeopleInfo r25, int r26) {
        /*
            Method dump skipped, instructions count: 1561
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wear.adapter.longdistance.NewUserAdapter.y(com.wear.adapter.BaseAdapter$ViewHolder, com.wear.bean.handlerbean.IPeopleInfo, int):void");
    }

    public final void J(IPeopleInfo iPeopleInfo, ImageView imageView, String str) {
        if (iPeopleInfo instanceof Group) {
            tg3.i(imageView, (Group) iPeopleInfo);
            return;
        }
        if (iPeopleInfo instanceof OfficialAcount) {
            return;
        }
        if (WearUtils.e1(str)) {
            imageView.setImageResource(R.drawable.icon_default_new);
            return;
        }
        if (!str.startsWith("http")) {
            str = WearUtils.e + str;
        }
        kf.w(imageView.getContext()).v(str).X(R.drawable.icon_default_new).a(this.k).A0(imageView);
    }

    public void K(IPeopleInfo iPeopleInfo, ImageView imageView, View view) {
        if (iPeopleInfo == null) {
            return;
        }
        if (iPeopleInfo.isGroup()) {
            view.setVisibility(4);
            return;
        }
        Presence.Mode statusMode = iPeopleInfo.getStatusMode();
        if (!iPeopleInfo.isOnline() || statusMode == null) {
            view.setVisibility(4);
            return;
        }
        if (statusMode == Presence.Mode.chat) {
            view.setVisibility(0);
            imageView.setImageResource(R.drawable.status_available);
        } else if (statusMode == Presence.Mode.dnd) {
            view.setVisibility(0);
            imageView.setImageResource(R.drawable.status_busy);
        } else if (statusMode == Presence.Mode.away) {
            view.setVisibility(4);
        }
    }

    @Override // com.wear.adapter.BaseAdapter
    public boolean m() {
        return true;
    }

    @Override // com.wear.adapter.BaseAdapter
    public void q() {
        this.d.put(-1, Integer.valueOf(R.layout.view_no_friend_show));
    }

    @Override // com.wear.adapter.BaseAdapter
    public void u(BaseAdapter.ViewHolder viewHolder) {
        viewHolder.getView(R.id.iv_img).setOnClickListener(new View.OnClickListener() { // from class: dc.ml1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.C(view);
            }
        });
    }

    public Activity z() {
        Context context = this.c;
        return !(context instanceof Activity) ? MyApplication.H() : (Activity) context;
    }
}
