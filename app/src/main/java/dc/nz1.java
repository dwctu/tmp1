package dc;

import android.graphics.Bitmap;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import com.lovense.wear.R;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.ImageSize;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;
import com.wear.bean.Setting;
import com.wear.dao.DaoUtils;
import com.wear.dao.SettingDao;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import java.io.File;
import java.io.IOException;
import java.util.Hashtable;

/* compiled from: UserSettingManagerImpl.java */
/* loaded from: classes3.dex */
public class nz1 {
    public static nz1 g;
    public mz1 b;
    public String f;
    public int d = -1;
    public int e = 0;
    public MyApplication a = WearUtils.x;
    public Hashtable<Integer, mz1> c = new Hashtable<>();

    /* compiled from: UserSettingManagerImpl.java */
    public class a extends SimpleImageLoadingListener {
        public final /* synthetic */ ImageView a;

        public a(nz1 nz1Var, ImageView imageView) {
            this.a = imageView;
        }

        @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
        public void onLoadingComplete(String str, View view, Bitmap bitmap) {
            if (bitmap != null) {
                this.a.setImageBitmap(bitmap);
            }
        }
    }

    /* compiled from: UserSettingManagerImpl.java */
    public class b implements mz1 {
        public int B;
        public int C;
        public int E;
        public int F;
        public int G;
        public int H;
        public int I;
        public int J;
        public String K;
        public String L;
        public String M;
        public String N;
        public String O;
        public int P;
        public int Q;
        public int R;
        public int S;
        public int V;
        public int W;
        public int a;
        public int b;
        public int g;
        public int p0;
        public int r;
        public int t;
        public int x;
        public int z;
        public int d = R.color.default_theme_i_send_text_color;
        public int f = R.color.default_theme_f_send_text_color;
        public int h = R.color.default_theme_i_call_again_color;
        public int i = R.color.default_theme_f_call_again_color;
        public int s = R.color.defaut_theme_tip_defaut_text_color;
        public int D = R.color.defaut_theme_i_send_audio_text_color;
        public int c = R.drawable.chat_message_self_new_text_default;
        public int e = R.drawable.chat_message_friend_new_text_default;
        public int X = R.drawable.chat_message_self_new_text_default_audio;
        public int Y = R.drawable.chat_message_friend_new_text_default_audio;
        public int Z = R.drawable.chat_message_self_mask_bg_default;
        public int a0 = R.drawable.chat_message_friend_notice_bg_default;
        public int d0 = R.color.lvs_ui_standard_systemStrokeStrong;
        public int e0 = R.color.lvs_ui_standard_systemStrokeStrong;
        public int f0 = R.color.lvs_ui_standard_systemLDText6;
        public int g0 = R.color.lvs_ui_standard_systemText2;
        public int l0 = R.color.lvs_ui_standard_systemText5;
        public int m0 = R.color.lvs_ui_standard_systemLDText6;
        public int h0 = R.drawable.chat_message_friend_notice_bg_default;
        public int i0 = R.drawable.chat_message_self_mask_bg_default;
        public int j0 = R.color.lvs_ui_standard_systemLDText7;
        public int k0 = R.color.lvs_ui_standard_systemStrokeStrong;
        public int n0 = R.color.lvs_ui_standard_systemText;
        public int o0 = R.color.lvs_ui_standard_systemText4;
        public int q0 = R.color.lvs_ui_standard_systemLDText6;
        public int r0 = R.color.lvs_ui_standard_systemText2;
        public int u = R.drawable.chat_send_alarm_self;
        public int v = R.drawable.chat_send_alarm_friend;
        public int m = R.drawable.chat_theme_sync;
        public int q = R.drawable.chat_theme_sync_friend;
        public int j = R.drawable.chat_theme_video;
        public int n = R.drawable.chat_theme_video_friend;
        public int k = R.drawable.chat_theme_voice;
        public int o = R.drawable.chat_theme_voice_friend;
        public int l = R.drawable.chat_theme_live;
        public int p = R.drawable.chat_theme_live_friend;
        public int T = R.drawable.chat_message_self_new_text_default;
        public int U = R.drawable.chat_message_friend_new_text_default;
        public int w = R.color.lvs_ui_standard_systemText;
        public int y = R.color.lvs_ui_standard_systemText;
        public int A = R.color.lvs_ui_standard_systemLDText5;
        public int b0 = R.color.lvs_ui_standard_systemText2;
        public int c0 = R.color.lvs_ui_standard_systemText5;

        public b() {
            th4.b(nz1.this.a, R.color.lvs_ui_standard_systemLDText6);
            th4.b(nz1.this.a, R.color.lvs_ui_standard_systemText5);
            this.p0 = R.drawable.chat_voicemessage_default_reply_voice;
            this.a = R.color.lvs_ui_standard_systemBackground2;
            this.b = R.color.text_color_45;
            this.V = R.color.default_theme_pattern_play_time_color;
            this.P = R.drawable.chat_theme_default_pattern_play_friend;
            this.Q = R.drawable.chat_theme_default_pattern_pause_friend;
            this.t = R.color.lvs_ui_standard_systemBackground2;
            this.W = R.color.lvs_ui_standard_systemBackground3;
            this.B = R.drawable.chat_voicemessage_default_theme_send;
            this.C = R.drawable.chat_voicemessage_default_theme_send;
            this.E = R.drawable.chat_voicemessage_default_theme_receive;
            this.F = R.drawable.chat_voicemessage_default_theme_receive;
            this.G = R.drawable.chat_voicemessage_reply_send;
            this.H = R.drawable.chat_voicemessage_reply_receive;
            this.I = R.drawable.chat_voicemessage_reply_receive;
            this.J = R.drawable.chat_voicemessage_reply_send;
            this.r = R.color.lvs_ui_standard_systemBrandRegular;
            this.L = "voice_default_dark_send_black.json";
            this.M = "voice_default_dark_receive_white.json";
            this.K = "voice_default_white_receive_black.json";
            this.N = "voice_default_reply_black.json";
            this.O = "voice_default_reply_white.json";
        }

        @Override // dc.mz1
        public int A() {
            return this.P;
        }

        @Override // dc.mz1
        public int B() {
            return this.I;
        }

        @Override // dc.mz1
        public int C() {
            return th4.b(nz1.this.a, this.q0);
        }

        @Override // dc.mz1
        public int D() {
            return th4.b(nz1.this.a, this.a);
        }

        @Override // dc.mz1
        public int E() {
            return this.p0;
        }

        @Override // dc.mz1
        public int F() {
            return this.p;
        }

        @Override // dc.mz1
        public int G() {
            return th4.b(nz1.this.a, this.r);
        }

        @Override // dc.mz1
        public String H(boolean z) {
            int i = MyApplication.m0;
            return (i == 2 || (i == 0 && MyApplication.l0)) ? z ? this.O : this.N : this.O;
        }

        @Override // dc.mz1
        public int I() {
            return th4.b(nz1.this.a, this.k0);
        }

        @Override // dc.mz1
        public int J() {
            return th4.b(nz1.this.a, this.i);
        }

        @Override // dc.mz1
        public int K() {
            return th4.b(nz1.this.a, this.d);
        }

        @Override // dc.mz1
        public int L() {
            return this.d0;
        }

        @Override // dc.mz1
        public int M() {
            return th4.b(nz1.this.a, this.c0);
        }

        @Override // dc.mz1
        public int N() {
            return th4.b(nz1.this.a, this.t);
        }

        @Override // dc.mz1
        public int O() {
            return this.i0;
        }

        @Override // dc.mz1
        public int P() {
            return th4.b(nz1.this.a, this.j0);
        }

        @Override // dc.mz1
        public int Q() {
            return this.k;
        }

        @Override // dc.mz1
        public int R() {
            return this.m;
        }

        @Override // dc.mz1
        public int S() {
            return this.H;
        }

        @Override // dc.mz1
        public int T() {
            return this.j;
        }

        @Override // dc.mz1
        public String U(boolean z) {
            int i = MyApplication.m0;
            return (i == 2 || (i == 0 && MyApplication.l0)) ? z ? this.L : this.M : z ? this.L : this.K;
        }

        @Override // dc.mz1
        public int V() {
            return this.G;
        }

        @Override // dc.mz1
        public int W() {
            return this.Z;
        }

        @Override // dc.mz1
        public int X() {
            return th4.b(nz1.this.a, this.D);
        }

        @Override // dc.mz1
        public int Y() {
            return th4.b(nz1.this.a, this.W);
        }

        @Override // dc.mz1
        public int Z() {
            return th4.b(nz1.this.a, this.b);
        }

        @Override // dc.mz1
        public int a() {
            return th4.b(nz1.this.a, this.n0);
        }

        @Override // dc.mz1
        public int a0() {
            return this.C;
        }

        @Override // dc.mz1
        public int b() {
            return th4.b(nz1.this.a, this.y);
        }

        @Override // dc.mz1
        public int b0() {
            return this.n;
        }

        @Override // dc.mz1
        public int c() {
            return this.o;
        }

        @Override // dc.mz1
        public int c0() {
            return this.Y;
        }

        @Override // dc.mz1
        public int d() {
            return this.l;
        }

        @Override // dc.mz1
        public int d0() {
            return this.F;
        }

        @Override // dc.mz1
        public int e() {
            return this.a0;
        }

        @Override // dc.mz1
        public int e0() {
            return this.e0;
        }

        @Override // dc.mz1
        public int f() {
            return th4.b(nz1.this.a, this.f0);
        }

        @Override // dc.mz1
        public int f0() {
            return th4.b(nz1.this.a, this.s);
        }

        @Override // dc.mz1
        public int g() {
            return this.J;
        }

        @Override // dc.mz1
        public int g0() {
            return this.e;
        }

        @Override // dc.mz1
        public int h() {
            return this.X;
        }

        @Override // dc.mz1
        public int h0() {
            return th4.b(nz1.this.a, this.f);
        }

        @Override // dc.mz1
        public int i() {
            return th4.b(nz1.this.a, this.m0);
        }

        @Override // dc.mz1
        public int i0() {
            return this.B;
        }

        @Override // dc.mz1
        public int j() {
            return this.u;
        }

        @Override // dc.mz1
        public int j0() {
            return th4.b(nz1.this.a, this.l0);
        }

        @Override // dc.mz1
        public int k() {
            return th4.b(nz1.this.a, this.b0);
        }

        @Override // dc.mz1
        public int l() {
            return th4.b(nz1.this.a, this.V);
        }

        @Override // dc.mz1
        public int m() {
            return th4.b(nz1.this.a, this.h);
        }

        @Override // dc.mz1
        public int n() {
            return th4.b(nz1.this.a, this.w);
        }

        @Override // dc.mz1
        public int o() {
            return this.E;
        }

        @Override // dc.mz1
        public int p() {
            return th4.b(nz1.this.a, this.g0);
        }

        @Override // dc.mz1
        public int q() {
            return this.Q;
        }

        @Override // dc.mz1
        public int r() {
            return this.h0;
        }

        @Override // dc.mz1
        public int s() {
            return th4.b(nz1.this.a, this.A);
        }

        @Override // dc.mz1
        public int t() {
            return this.U;
        }

        @Override // dc.mz1
        public int u() {
            return th4.b(nz1.this.a, this.o0);
        }

        @Override // dc.mz1
        public int v() {
            return this.T;
        }

        @Override // dc.mz1
        public int w() {
            return th4.b(nz1.this.a, this.r0);
        }

        @Override // dc.mz1
        public int x() {
            return this.v;
        }

        @Override // dc.mz1
        public int y() {
            return this.c;
        }

        @Override // dc.mz1
        public int z() {
            return this.q;
        }
    }

    public nz1() {
        b bVar = new b();
        bVar.U = R.drawable.chat_message_friend_new_text_default;
        bVar.T = R.drawable.chat_message_self_new_text_default;
        bVar.w = R.color.lvs_ui_standard_systemText;
        bVar.y = R.color.lvs_ui_standard_systemText;
        bVar.f = R.color.default_theme_f_send_text_color;
        bVar.X = R.drawable.chat_message_self_new_text_default_audio;
        bVar.Y = R.drawable.chat_message_friend_new_text_default_audio;
        bVar.d0 = R.color.lvs_ui_standard_systemStrokeStrong;
        bVar.e0 = R.color.lvs_ui_standard_systemStrokeStrong;
        bVar.b0 = R.color.lvs_ui_standard_systemText2;
        bVar.c0 = R.color.lvs_ui_standard_systemText5;
        bVar.f0 = R.color.lvs_ui_standard_systemLDText6;
        bVar.g0 = R.color.lvs_ui_standard_systemText2;
        bVar.l0 = R.color.lvs_ui_standard_systemText5;
        bVar.m0 = R.color.lvs_ui_standard_systemLDText6;
        bVar.h0 = R.drawable.chat_message_friend_notice_bg_default;
        bVar.i0 = R.drawable.chat_message_self_mask_bg_default;
        bVar.j0 = R.color.lvs_ui_standard_systemLDText7;
        bVar.k0 = R.color.lvs_ui_standard_systemStrokeStrong;
        bVar.n0 = R.color.lvs_ui_standard_systemText;
        bVar.o0 = R.color.lvs_ui_standard_systemText4;
        bVar.l = R.drawable.chat_theme_live;
        bVar.j = R.drawable.chat_theme_video;
        bVar.m = R.drawable.chat_theme_sync;
        bVar.k = R.drawable.chat_theme_voice;
        bVar.B = R.drawable.chat_voicemessage_default_theme_send;
        bVar.C = R.drawable.chat_voicemessage_default_theme_send;
        bVar.E = R.drawable.chat_voicemessage_default_theme_receive;
        bVar.F = R.drawable.chat_voicemessage_default_theme_receive;
        bVar.G = R.drawable.chat_voicemessage_reply_send;
        bVar.H = R.drawable.chat_voicemessage_reply_receive;
        bVar.I = R.drawable.chat_voicemessage_reply_receive;
        bVar.J = R.drawable.chat_voicemessage_reply_send;
        bVar.r = R.color.lvs_ui_standard_systemBrandRegular;
        bVar.p0 = R.drawable.chat_voicemessage_default_reply_voice;
        bVar.q0 = R.color.lvs_ui_standard_systemLDText6;
        bVar.r0 = R.color.lvs_ui_standard_systemText2;
        bVar.N = "voice_default_reply_black.json";
        bVar.O = "voice_default_reply_white.json";
        this.c.put(0, bVar);
        b bVar2 = new b();
        bVar2.c = R.drawable.chat_message_self_new_text_green;
        bVar2.e = R.drawable.chat_message_friend_new_text_theme2;
        bVar2.U = R.drawable.chat_message_friend_new_text_default;
        bVar2.T = R.drawable.chat_message_self_new_text_default;
        bVar2.d = R.color.lvs_ui_standard_systemLDText5;
        bVar2.f = R.color.lvs_ui_standard_systemText;
        bVar2.X = R.drawable.chat_message_self_audio_theme2;
        bVar2.Y = R.drawable.chat_message_friend_audio_theme2;
        bVar2.d0 = R.color.lvs_ui_standard_systemStrokeStrong;
        bVar2.e0 = R.color.lvs_ui_standard_systemStrokeStrong;
        bVar2.Z = R.drawable.chat_message_self_mask_bg_theme2;
        bVar2.a0 = R.drawable.chat_message_friend_notice_bg_default;
        bVar2.j0 = R.color.lvs_ui_standard_systemLDText7;
        bVar2.k0 = R.color.lvs_ui_standard_systemStrokeStrong;
        bVar2.n0 = R.color.lvs_ui_standard_systemText;
        bVar2.o0 = R.color.lvs_ui_standard_systemText4;
        bVar2.w = R.color.lvs_ui_standard_systemText;
        bVar2.y = R.color.lvs_ui_standard_systemText;
        bVar2.f0 = R.color.lvs_ui_standard_systemLDText6;
        bVar2.g0 = R.color.lvs_ui_standard_systemText2;
        bVar2.l0 = R.color.lvs_ui_standard_systemText5;
        bVar2.m0 = R.color.lvs_ui_standard_systemLDText6;
        bVar2.h0 = R.drawable.chat_message_friend_notice_bg_default;
        bVar2.i0 = R.drawable.chat_message_self_mask_bg_default;
        bVar2.W = R.color.lvs_ui_standard_systemStrokeRegular;
        bVar2.B = R.drawable.chat_voicemessage_whatapp_theme_send;
        bVar2.p0 = R.drawable.chat_voicemessage_default_reply_voice;
        bVar2.q0 = R.color.lvs_ui_standard_systemLDText6;
        bVar2.r0 = R.color.lvs_ui_standard_systemText2;
        bVar2.N = "voice_default_reply_black.json";
        bVar2.O = "voice_default_reply_white.json";
        bVar2.h = R.color.lvs_ui_standard_systemBlueRegular;
        bVar2.i = R.color.lvs_ui_standard_systemBlueRegular;
        bVar2.V = R.color.lvs_ui_standard_systemBlueRegular;
        bVar2.a = R.color.lvs_ui_standard_systemBackground2;
        bVar2.t = R.color.whatapp_theme_tip_bg_color;
        bVar2.A = R.color.whatapp_theme_send_btn_text_color;
        bVar2.C = R.drawable.chat_voicemessage_wechat_theme_send;
        bVar2.E = R.drawable.chat_voicemessage_whatapp_theme_receive;
        bVar2.F = R.drawable.chat_voicemessage_whatapp_theme_receive;
        bVar2.G = R.drawable.chat_voicemessage_reply_send;
        bVar2.H = R.drawable.chat_voicemessage_reply_receive;
        bVar2.J = R.drawable.chat_voicemessage_reply_send;
        bVar2.I = R.drawable.chat_voicemessage_reply_receive;
        bVar2.r = R.color.lvs_ui_standard_systemBrandRegular;
        bVar2.L = "voice_whatapp_dark_send_white.json";
        bVar2.M = "voice_whatapp_dark_receive_white.json";
        bVar2.K = "voice_whatapp_white_receive_black.json";
        h(bVar2);
        this.c.put(1, bVar2);
        b bVar3 = new b();
        bVar3.c = R.drawable.chat_message_self_new_text_blue;
        bVar3.e = R.drawable.chat_message_friend_new_text_theme3;
        bVar3.d = R.color.lvs_ui_standard_systemLDText5;
        bVar3.f = R.color.lvs_ui_standard_systemText;
        bVar3.X = R.drawable.chat_message_self_audio_theme3;
        bVar3.Y = R.drawable.chat_message_friend_audio_theme3;
        bVar3.d0 = R.color.lvs_ui_standard_systemStrokeStrong;
        bVar3.e0 = R.color.lvs_ui_standard_systemStrokeStrong;
        bVar3.Z = R.drawable.chat_message_self_mask_bg_theme3;
        bVar3.a0 = R.drawable.chat_message_friend_notice_bg_default;
        bVar3.f0 = R.color.lvs_ui_standard_systemLDText6;
        bVar3.g0 = R.color.lvs_ui_standard_systemText3;
        bVar3.l0 = R.color.lvs_ui_standard_systemText5;
        bVar3.m0 = R.color.lvs_ui_standard_systemLDText6;
        bVar3.h0 = R.drawable.chat_message_friend_notice_bg_default;
        bVar3.i0 = R.drawable.chat_message_self_mask_bg_default;
        bVar3.j0 = R.color.lvs_ui_standard_systemLDText7;
        bVar3.k0 = R.color.lvs_ui_standard_systemStrokeStrong;
        bVar3.n0 = R.color.lvs_ui_standard_systemText;
        bVar3.o0 = R.color.lvs_ui_standard_systemText4;
        bVar3.p0 = R.drawable.chat_voicemessage_default_reply_voice;
        bVar3.q0 = R.color.lvs_ui_standard_systemLDText6;
        bVar3.r0 = R.color.lvs_ui_standard_systemText2;
        bVar3.N = "voice_default_reply_black.json";
        bVar3.O = "voice_default_reply_white.json";
        bVar3.h = R.color.lvs_ui_standard_systemBlueRegular;
        bVar3.i = R.color.lvs_ui_standard_systemBlueRegular;
        bVar3.V = R.color.lvs_ui_standard_systemBlueRegular;
        bVar3.a = R.color.skype_theme_time_bg_color;
        bVar3.t = R.color.skype_theme_tip_bg_color;
        bVar3.A = R.color.skype_theme_send_btn_text_color;
        bVar3.W = R.color.skype_theme_vertical_line_color;
        bVar3.C = R.drawable.chat_voicemessage_wechat_theme_send;
        bVar3.E = R.drawable.chat_voicemessage_whatapp_theme_receive;
        bVar3.F = R.drawable.chat_voicemessage_whatapp_theme_receive;
        bVar3.G = R.drawable.chat_voicemessage_reply_send;
        bVar3.H = R.drawable.chat_voicemessage_reply_receive;
        bVar3.J = R.drawable.chat_voicemessage_reply_send;
        bVar3.I = R.drawable.chat_voicemessage_reply_receive;
        bVar3.r = R.color.lvs_ui_standard_systemBrandRegular;
        bVar3.L = "voice_whatapp_dark_send_white.json";
        bVar3.M = "voice_whatapp_dark_receive_white.json";
        bVar3.K = "voice_whatapp_white_receive_black.json";
        h(bVar3);
        this.c.put(2, bVar3);
        b bVar4 = new b();
        bVar4.c = R.drawable.chat_message_self_new_text_wechat;
        bVar4.e = R.drawable.chat_message_friend_new_text_theme4;
        bVar4.d = R.color.lvs_ui_standard_systemLDText5;
        bVar4.f = R.color.lvs_ui_standard_systemText;
        bVar4.X = R.drawable.chat_message_self_audio_theme3;
        bVar4.Y = R.drawable.chat_message_friend_audio_theme3;
        bVar4.d0 = R.color.lvs_ui_standard_systemStrokeStrong;
        bVar4.e0 = R.color.lvs_ui_standard_systemStrokeStrong;
        bVar4.Z = R.drawable.chat_message_self_mask_bg_theme3;
        bVar4.a0 = R.drawable.chat_message_friend_notice_bg_default;
        bVar4.f0 = R.color.color_expired_6c7273;
        bVar4.g0 = R.color.lvs_ui_standard_systemText2;
        bVar4.l0 = R.color.lvs_ui_standard_systemText2;
        bVar4.m0 = R.color.color_expired_6c7273;
        bVar4.h0 = R.drawable.chat_message_friend_notice_bg_wechat;
        bVar4.i0 = R.drawable.chat_message_self_mask_bg_default;
        bVar4.j0 = R.color.color_expired_6c7273;
        bVar4.k0 = R.color.lvs_ui_standard_systemStrokeStrong;
        bVar4.n0 = R.color.lvs_ui_standard_systemText;
        bVar4.o0 = R.color.lvs_ui_standard_systemText;
        bVar4.p0 = R.drawable.chat_voicemessage_reply_send_theme4;
        bVar4.q0 = R.color.color_expired_6c7273;
        bVar4.r0 = R.color.lvs_ui_standard_systemText2;
        bVar4.N = "voice_reply_light.json";
        bVar4.O = "voice_reply_dark.json";
        bVar4.h = R.color.lvs_ui_standard_systemBlueRegular;
        bVar4.i = R.color.lvs_ui_standard_systemBlueRegular;
        bVar4.V = R.color.lvs_ui_standard_systemBlueRegular;
        bVar4.a = R.color.wechat_theme_time_bg_color;
        bVar4.t = R.color.wechat_theme_tip_bg_color;
        bVar4.A = R.color.wechat_theme_send_btn_text_color;
        bVar4.W = R.color.wechat_theme_vertical_line_color;
        bVar4.C = R.drawable.chat_voicemessage_wechat_theme_send;
        bVar4.E = R.drawable.chat_voicemessage_whatapp_theme_receive;
        bVar4.F = R.drawable.chat_voicemessage_whatapp_theme_receive;
        bVar4.G = R.drawable.chat_voicemessage_reply_send;
        bVar4.H = R.drawable.chat_voicemessage_reply_receive;
        bVar4.J = R.drawable.chat_voicemessage_reply_send;
        bVar4.I = R.drawable.chat_voicemessage_reply_receive;
        bVar4.r = R.color.lvs_ui_standard_systemBrandRegular;
        bVar4.L = "voice_whatapp_dark_send_white.json";
        bVar4.M = "voice_whatapp_dark_receive_white.json";
        bVar4.K = "voice_whatapp_white_receive_black.json";
        h(bVar4);
        this.c.put(3, bVar4);
    }

    public static nz1 e() {
        if (g == null) {
            synchronized (nz1.class) {
                if (g == null) {
                    g = new nz1();
                }
            }
        }
        return g;
    }

    public int b() {
        return this.e;
    }

    public final File c() {
        String strValueOf = this.f + "themeBg";
        if (WearUtils.e1(this.f)) {
            strValueOf = String.valueOf(be3.I().getTime());
        }
        return new File(WearUtils.T("cbgf"), WearUtils.r0(strValueOf));
    }

    public mz1 d() {
        return this.c.get(0);
    }

    public mz1 f() {
        mz1 mz1Var = this.b;
        return mz1Var == null ? this.c.get(0) : mz1Var;
    }

    public int g() {
        return this.d;
    }

    public final void h(b bVar) {
        bVar.g = R.color.whats_theme_callback_color;
        bVar.s = R.color.whats_theme_tip_defaut_text_color;
        bVar.x = R.color.lvs_ui_standard_systemText2;
        bVar.z = R.color.whats_theme_f_control_time_text_color;
        bVar.D = R.color.whats_theme_i_send_audio_text_color;
        bVar.R = R.drawable.gif_pattern_playing_othertheme;
        bVar.S = R.drawable.musicewave_pause_othertheme;
        bVar.u = R.drawable.chat_send_alarm_self;
        bVar.m = R.drawable.chat_theme_sync;
        bVar.q = R.drawable.chat_theme_sync;
        bVar.j = R.drawable.chat_theme_video;
        bVar.n = R.drawable.chat_theme_video;
        bVar.k = R.drawable.chat_theme_voice;
        bVar.o = R.drawable.chat_theme_voice;
        bVar.l = R.drawable.chat_theme_live;
        bVar.p = R.drawable.chat_theme_live;
    }

    public void i(String str) {
        this.f = str;
        Setting settingS = WearUtils.x.S();
        this.d = settingS.getTheme();
        this.e = settingS.getChatType();
        mz1 mz1Var = this.c.get(Integer.valueOf(this.d));
        if (mz1Var != null) {
            this.b = mz1Var;
        }
    }

    public void j(int i) {
        this.e = i;
        Setting settingS = this.a.S();
        settingS.setChatType(i);
        DaoUtils.getSettingDao().update((SettingDao) settingS);
    }

    public void k(ImageView imageView) {
        if (this.e == -1) {
            File fileC = c();
            if (fileC.exists()) {
                ImageLoader.getInstance().loadImage(Uri.fromFile(fileC).toString(), new ImageSize(gg3.e(this.a), gg3.c(this.a)), new a(this, imageView));
                return;
            }
        }
        int i = this.e;
        if (i == 1) {
            imageView.setImageDrawable(th4.d(MyApplication.N(), R.drawable.whatapp_chat_background));
            return;
        }
        if (i == 2) {
            imageView.setImageBitmap(null);
            imageView.setBackgroundColor(th4.b(this.a, R.color.lvs_ui_standard_systemBackground6));
        } else if (i == 3) {
            imageView.setImageBitmap(null);
            imageView.setBackgroundColor(th4.b(this.a, R.color.lvs_ui_standard_systemBackground6));
        } else {
            imageView.setImageBitmap(null);
            imageView.setBackgroundColor(th4.b(this.a, R.color.lvs_ui_standard_systemBackground));
        }
    }

    public void l(File file) throws IOException {
        WearUtils.q(file, c());
        this.e = -1;
        Setting settingS = this.a.S();
        settingS.setChatType(this.e);
        DaoUtils.getSettingDao().update((SettingDao) settingS);
    }

    public void m(int i) {
        mz1 mz1Var = this.c.get(Integer.valueOf(i));
        if (mz1Var != null) {
            this.d = i;
            this.b = mz1Var;
            Setting settingS = this.a.S();
            settingS.setTheme(i);
            DaoUtils.getSettingDao().update((SettingDao) settingS);
            j(i);
        }
    }
}
