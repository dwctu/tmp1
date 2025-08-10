package com.wear.broadcast;

import android.app.Activity;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import com.wear.SyncAccessActivity;
import com.wear.bean.Account;
import com.wear.bean.OpenAppBean;
import com.wear.bean.User;
import com.wear.bean.event.FinishChatPageEvent;
import com.wear.main.FlashActivity;
import com.wear.main.MainActivity;
import com.wear.main.account.login.LoginActivity;
import com.wear.main.longDistance.ChatActivity;
import com.wear.main.longDistance.ChatRoomActivity;
import com.wear.main.longDistance.control.ChatDSControl;
import com.wear.main.longDistance.control.ChatGroupControl;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import dc.eg3;
import dc.na2;
import dc.pd3;
import dc.xe3;
import io.agora.rtc2.internal.AudioRoutingController;
import java.util.Iterator;
import org.greenrobot.eventbus.EventBus;

/* loaded from: classes3.dex */
public class NotificationChatService extends Service {
    public static String a = "com.wear.chat.NOTIFICATION_CHAT";

    public static void b(Context context) {
        Intent intent = new Intent(context, (Class<?>) MainActivity.class);
        intent.setFlags(268435456);
        context.startActivity(intent);
    }

    public final void a() {
        Intent intent = new Intent(WearUtils.x, (Class<?>) SyncAccessActivity.class);
        intent.setFlags(AudioRoutingController.DEVICE_OUT_USB_HEADSET);
        FragmentActivity fragmentActivityH = MyApplication.H();
        if (fragmentActivityH != null) {
            try {
                fragmentActivityH.startActivity(intent);
            } catch (Exception unused) {
                b(this);
            }
        }
    }

    @Override // android.app.Service
    @Nullable
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        System.out.println("NotificationChatService.onCreate()!");
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        System.out.println("NotificationChatService.onDestroy()!");
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        User user;
        if (intent != null && intent.getAction() != null && intent.getAction().equals(a)) {
            if (intent.getBooleanExtra("isPlayService", false)) {
                if (WearUtils.x == null || pd3.j().a.size() == 0) {
                    Intent intent2 = new Intent(this, (Class<?>) FlashActivity.class);
                    intent2.setFlags(268435456);
                    startActivity(intent2);
                } else {
                    FragmentActivity fragmentActivityH = MyApplication.H();
                    if (fragmentActivityH == null) {
                        Intent intent3 = new Intent(this, (Class<?>) MainActivity.class);
                        intent3.setFlags(268435456);
                        startActivity(intent3);
                    } else {
                        try {
                            Intent intent4 = new Intent(fragmentActivityH, (Class<?>) SyncAccessActivity.class);
                            intent4.setFlags(AudioRoutingController.DEVICE_OUT_USB_HEADSET);
                            fragmentActivityH.startActivity(intent4);
                        } catch (Exception unused) {
                            b(this);
                        }
                    }
                }
                return super.onStartCommand(intent, i, i2);
            }
            String stringExtra = intent.getStringExtra("userId");
            String stringExtra2 = intent.getStringExtra("friendId");
            Account accountU = WearUtils.y.u();
            if (!TextUtils.isEmpty(stringExtra2)) {
                if (accountU == null) {
                    Intent intent5 = new Intent(this, (Class<?>) MainActivity.class);
                    intent5.setFlags(268435456);
                    startActivity(intent5);
                } else {
                    FragmentActivity fragmentActivityH2 = MyApplication.H();
                    Intent intent6 = new Intent(fragmentActivityH2, (Class<?>) SyncAccessActivity.class);
                    intent6.putExtra("userId", stringExtra);
                    intent6.setFlags(AudioRoutingController.DEVICE_OUT_USB_HEADSET);
                    if (fragmentActivityH2 != null) {
                        try {
                            fragmentActivityH2.startActivity(intent6);
                        } catch (Exception unused2) {
                            b(this);
                        }
                    }
                }
                return super.onStartCommand(intent, i, i2);
            }
            if (!WearUtils.e1(intent.getStringExtra("linkId"))) {
                if (accountU == null) {
                    Intent intent7 = new Intent(this, (Class<?>) MainActivity.class);
                    intent7.setFlags(268435456);
                    startActivity(intent7);
                } else {
                    a();
                }
                return super.onStartCommand(intent, i, i2);
            }
            if (accountU == null) {
                Intent intent8 = new Intent(this, (Class<?>) MainActivity.class);
                OpenAppBean openAppBean = new OpenAppBean();
                openAppBean.type = -1;
                openAppBean.userId = stringExtra;
                MyApplication.v0(openAppBean);
                intent8.setFlags(268435456);
                startActivity(intent8);
            } else if (WearUtils.e1(eg3.h(WearUtils.x, "gen_token_Key", ""))) {
                Intent intent9 = new Intent(WearUtils.x, (Class<?>) LoginActivity.class);
                intent9.setFlags(AudioRoutingController.DEVICE_OUT_USB_HEADSET);
                FragmentActivity fragmentActivityH3 = MyApplication.H();
                if (fragmentActivityH3 != null) {
                    try {
                        fragmentActivityH3.startActivity(intent9);
                    } catch (Exception unused3) {
                        b(this);
                    }
                }
            } else if (na2.m().i()) {
                Intent intent10 = new Intent(WearUtils.x, (Class<?>) SyncAccessActivity.class);
                intent10.putExtra("userId", stringExtra);
                intent10.setFlags(AudioRoutingController.DEVICE_OUT_USB_HEADSET);
                FragmentActivity fragmentActivityH4 = MyApplication.H();
                if (fragmentActivityH4 != null) {
                    try {
                        fragmentActivityH4.startActivity(intent10);
                    } catch (Exception unused4) {
                        b(this);
                    }
                }
            } else {
                ChatActivity chatActivity = null;
                Iterator<Activity> it = pd3.j().a.iterator();
                while (it.hasNext()) {
                    Activity next = it.next();
                    if (next instanceof ChatActivity) {
                        chatActivity = (ChatActivity) next;
                    }
                }
                if (chatActivity != null && (user = chatActivity.z) != null && user.isDateIng()) {
                    Intent intent11 = new Intent(WearUtils.x, (Class<?>) SyncAccessActivity.class);
                    intent11.putExtra("userId", stringExtra);
                    intent11.setFlags(AudioRoutingController.DEVICE_OUT_USB_HEADSET);
                    FragmentActivity fragmentActivityH5 = MyApplication.H();
                    if (fragmentActivityH5 != null) {
                        try {
                            fragmentActivityH5.startActivity(intent11);
                        } catch (Exception unused5) {
                            b(this);
                        }
                    }
                } else if (WearUtils.e1(stringExtra) || WearUtils.y.u() == null) {
                    Intent intent12 = new Intent(WearUtils.x, (Class<?>) FlashActivity.class);
                    intent12.addFlags(268468224);
                    startActivity(intent12);
                    MyApplication.D();
                } else if (WearUtils.k1(stringExtra)) {
                    EventBus.getDefault().post(new FinishChatPageEvent(1));
                    Intent intent13 = new Intent(WearUtils.x, (Class<?>) ChatActivity.class);
                    intent13.putExtra("userId", stringExtra);
                    intent13.setFlags(268468224);
                    FragmentActivity fragmentActivityH6 = MyApplication.H();
                    if (fragmentActivityH6 != null) {
                        try {
                            fragmentActivityH6.startActivity(intent13);
                        } catch (Exception unused6) {
                            b(this);
                        }
                    }
                } else if (ChatGroupControl.o1().J1()) {
                    int intExtra = intent.getIntExtra("type", 0);
                    xe3.a("NotificationChatService", "type:" + intExtra);
                    int i3 = intExtra & (-4033);
                    if (i3 == 1) {
                        a();
                        ChatGroupControl.o1().r1(stringExtra, true);
                    } else if (i3 == 2) {
                        ChatGroupControl.o1().r1(stringExtra, false);
                    }
                } else if (ChatDSControl.r1().H1()) {
                    int intExtra2 = intent.getIntExtra("type", 0);
                    xe3.a("NotificationChatService", "type:" + intExtra2);
                    int i4 = intExtra2 & (-4033);
                    if (i4 == 4) {
                        a();
                        ChatDSControl.r1().s1(stringExtra, true);
                    } else if (i4 == 5) {
                        ChatDSControl.r1().s1(stringExtra, false);
                    }
                } else {
                    EventBus.getDefault().post(new FinishChatPageEvent(0));
                    Intent intent14 = new Intent(WearUtils.x, (Class<?>) ChatRoomActivity.class);
                    intent14.putExtra("roomId", stringExtra);
                    intent14.setFlags(AudioRoutingController.DEVICE_OUT_USB_HEADSET);
                    FragmentActivity fragmentActivityH7 = MyApplication.H();
                    if (fragmentActivityH7 != null) {
                        try {
                            fragmentActivityH7.startActivity(intent14);
                        } catch (Exception unused7) {
                            b(this);
                        }
                    }
                }
            }
        }
        return super.onStartCommand(intent, i, i2);
    }
}
