package dc;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.lovense.wear.R;
import com.wear.activity.discord.DiscordControl;
import com.wear.activity.discord.DiscordEvent;

/* compiled from: DiscordControlWidget.java */
/* loaded from: classes4.dex */
public class mn3 implements View.OnClickListener {
    public View a;
    public View b;
    public TextView c;
    public TextView d;
    public View e;
    public ImageView f;
    public ImageView g;
    public Context h;
    public String i;

    public mn3(Context context, View view) {
        this.h = context;
        this.a = view;
        a();
    }

    public final void a() {
        this.b = this.a.findViewById(R.id.iv_oray_close);
        this.c = (TextView) this.a.findViewById(R.id.tv_gray_bar_top);
        this.d = (TextView) this.a.findViewById(R.id.tv_gray_bar_buttom);
        this.a.findViewById(R.id.layout_orgy_details);
        this.e = this.a.findViewById(R.id.layout_orgy_join);
        this.f = (ImageView) this.a.findViewById(R.id.iv_orgy_join);
        this.g = (ImageView) this.a.findViewById(R.id.iv_right);
        this.c.setText(ah4.e(R.string.discord_orgy_banner_joined));
        this.f.setBackgroundResource(R.drawable.gray_enable);
        this.b.setVisibility(8);
        this.d.setVisibility(8);
        this.g.setVisibility(8);
        this.a.setOnClickListener(this);
        this.e.setOnClickListener(this);
    }

    public void b(DiscordEvent discordEvent) {
        if (discordEvent == null || discordEvent.getEventType() == DiscordEvent.TYPE_ACTIVITY_OVER || (discordEvent.getEventType() == DiscordEvent.TYPE_ACTIVITY_STATUS && TextUtils.equals(DiscordEvent.STATUS_OVER, discordEvent.getStatus()) && TextUtils.equals(discordEvent.getOrderKey(), DiscordControl.getInstance().getOrderKey()))) {
            this.a.setVisibility(8);
            DiscordControl.getInstance().join(false, false, "");
            DiscordControl.getInstance().temporaryExit(false, false);
            pc1.a.u0();
            db2.A().s();
            return;
        }
        int eventType = discordEvent.getEventType();
        int i = DiscordEvent.TYPE_JOIN_ACTIVITY;
        int i2 = R.string.discord_orgy_banner_joined;
        int i3 = R.drawable.gray_enable;
        if (eventType == i) {
            this.a.setVisibility(0);
            this.f.setBackgroundResource(R.drawable.gray_enable);
            this.c.setText(ah4.e(R.string.discord_orgy_banner_joined));
            this.i = discordEvent.getUrl();
            return;
        }
        if (discordEvent.getEventType() == DiscordEvent.TYPE_LEAVE_ACTIVITY) {
            this.f.setBackgroundResource(R.drawable.gray_disable);
            this.c.setText(ah4.e(R.string.discord_orgy_banner_left));
            return;
        }
        if (discordEvent.getEventType() == DiscordEvent.TYPE_ACTIVITY_STATUS && !TextUtils.equals(DiscordEvent.STATUS_OVER, discordEvent.getStatus()) && DiscordControl.getInstance().isJoin()) {
            this.a.setVisibility(0);
            ImageView imageView = this.f;
            if (DiscordControl.getInstance().isTemporaryExit()) {
                i3 = R.drawable.gray_disable;
            }
            imageView.setBackgroundResource(i3);
            TextView textView = this.c;
            if (DiscordControl.getInstance().isTemporaryExit()) {
                i2 = R.string.discord_orgy_banner_left;
            }
            textView.setText(ah4.e(i2));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id != R.id.discord_bar) {
            if (id != R.id.layout_orgy_join) {
                return;
            }
            DiscordControl.getInstance().temporaryExit(!DiscordControl.getInstance().isTemporaryExit(), true);
        } else {
            if (TextUtils.isEmpty(this.i)) {
                return;
            }
            pj3.w(this.h, this.i);
        }
    }
}
