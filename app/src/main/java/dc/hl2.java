package dc;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.wear.main.MainActivity;
import com.wear.main.account.ChangePasswordActivity;
import com.wear.main.account.FAQActivity;
import com.wear.main.account.HelpActivity;
import com.wear.main.account.MessageNotificationsActivity;
import com.wear.main.account.UserGuidesActivity;
import com.wear.main.account.login.EditEmailActivity;
import com.wear.main.account.login.ForgetPassActivity;
import com.wear.main.account.login.ResetPasswordActivity;
import com.wear.main.account.login.SignUpActivity;
import com.wear.main.longDistance.AddFriendActivity;
import com.wear.main.longDistance.ChatRoomActivity;
import com.wear.main.longDistance.ChatRoomInfoActivity;
import com.wear.main.longDistance.FriendProfileActivity;
import com.wear.main.longDistance.report.ReportActivity;
import com.wear.main.toy.SerialNumberActivity;
import com.wear.main.toy.ToyStrengthActivity;
import com.wear.ui.discover.pattern.PatternSearchActivity;
import com.wear.ui.discover.pattern.PatternUserActivity;
import com.wear.ui.discover.wishlist.WishListCreatGuildActivity;
import com.wear.ui.discover.wishlist.WishListViewActivity;
import com.wear.ui.longDistance.controlLink.ControlLinkEndActivity;
import com.wear.ui.me.PatternsHiddenActivity;
import com.wear.ui.me.ProfileActivity;
import com.wear.ui.me.SettingActivity;
import com.wear.vibematevideo.ui.HtmlVideoActivity;
import dagger.internal.Preconditions;

/* compiled from: DaggerActivityComponent.java */
/* loaded from: classes3.dex */
public final class hl2 implements fl2 {

    /* compiled from: DaggerActivityComponent.java */
    public static final class b {
        public ll2 a;
        public gl2 b;

        public b a(ll2 ll2Var) {
            this.a = (ll2) Preconditions.checkNotNull(ll2Var);
            return this;
        }

        public b b(gl2 gl2Var) {
            this.b = (gl2) Preconditions.checkNotNull(gl2Var);
            return this;
        }

        public fl2 c() {
            Preconditions.checkBuilderRequirement(this.a, ll2.class);
            Preconditions.checkBuilderRequirement(this.b, gl2.class);
            return new hl2(this.a, this.b);
        }

        public b() {
        }
    }

    public static b A() {
        return new b();
    }

    public final sl2 B() {
        return new sl2(new rl2());
    }

    public final xl2 C() {
        return new xl2(new wl2());
    }

    public final yl2 D() {
        return new yl2(new jm2(), new hn2());
    }

    public final zl2 E() {
        return new zl2(new jm2(), new el2());
    }

    public final am2 F() {
        return new am2(new el2());
    }

    public final em2 G() {
        return new em2(new dm2());
    }

    public final gm2 H() {
        return new gm2(new fm2());
    }

    public final km2 I() {
        return new km2(new jm2());
    }

    public final mm2 J() {
        return new mm2(new lm2());
    }

    public final um2 K() {
        return new um2(new tm2());
    }

    public final wm2 L() {
        return new wm2(new vm2());
    }

    public final an2 M() {
        return new an2(new zm2());
    }

    public final cn2 N() {
        return new cn2(new bn2());
    }

    public final ql2 O() {
        return new ql2(new pl2());
    }

    public final gn2 P() {
        return new gn2(new fn2(), new hn2());
    }

    public final im2 Q() {
        return new im2(new hm2());
    }

    public final ln2 R() {
        return new ln2(new kn2());
    }

    public final jn2 S() {
        return new jn2(new in2());
    }

    public final nn2 T() {
        return new nn2(new mn2());
    }

    public final pn2 U() {
        return new pn2(new on2());
    }

    @CanIgnoreReturnValue
    public final AddFriendActivity V(AddFriendActivity addFriendActivity) {
        d82.a(addFriendActivity, B());
        return addFriendActivity;
    }

    @CanIgnoreReturnValue
    public final ChangePasswordActivity W(ChangePasswordActivity changePasswordActivity) {
        vx1.a(changePasswordActivity, C());
        return changePasswordActivity;
    }

    @CanIgnoreReturnValue
    public final ChatRoomActivity X(ChatRoomActivity chatRoomActivity) {
        f82.a(chatRoomActivity, E());
        return chatRoomActivity;
    }

    @CanIgnoreReturnValue
    public final ChatRoomInfoActivity Y(ChatRoomInfoActivity chatRoomInfoActivity) {
        g82.a(chatRoomInfoActivity, D());
        return chatRoomInfoActivity;
    }

    @CanIgnoreReturnValue
    public final ControlLinkEndActivity Z(ControlLinkEndActivity controlLinkEndActivity) {
        a83.a(controlLinkEndActivity, F());
        return controlLinkEndActivity;
    }

    @Override // dc.fl2
    public void a(HtmlVideoActivity htmlVideoActivity) {
        f0(htmlVideoActivity);
    }

    @CanIgnoreReturnValue
    public final EditEmailActivity a0(EditEmailActivity editEmailActivity) {
        dz1.a(editEmailActivity, S());
        return editEmailActivity;
    }

    @Override // dc.fl2
    public void b(ResetPasswordActivity resetPasswordActivity) {
        n0(resetPasswordActivity);
    }

    @CanIgnoreReturnValue
    public final FAQActivity b0(FAQActivity fAQActivity) {
        wx1.a(fAQActivity, G());
        return fAQActivity;
    }

    @Override // dc.fl2
    public void c(ControlLinkEndActivity controlLinkEndActivity) {
        Z(controlLinkEndActivity);
    }

    @CanIgnoreReturnValue
    public final ForgetPassActivity c0(ForgetPassActivity forgetPassActivity) {
        ez1.a(forgetPassActivity, H());
        return forgetPassActivity;
    }

    @Override // dc.fl2
    public void d(HelpActivity helpActivity) {
        e0(helpActivity);
    }

    @CanIgnoreReturnValue
    public final FriendProfileActivity d0(FriendProfileActivity friendProfileActivity) {
        h82.a(friendProfileActivity, I());
        return friendProfileActivity;
    }

    @Override // dc.fl2
    public void e(MainActivity mainActivity) {
        g0(mainActivity);
    }

    @CanIgnoreReturnValue
    public final HelpActivity e0(HelpActivity helpActivity) {
        xx1.a(helpActivity, J());
        return helpActivity;
    }

    @Override // dc.fl2
    public void f(SettingActivity settingActivity) {
        p0(settingActivity);
    }

    @CanIgnoreReturnValue
    public final HtmlVideoActivity f0(HtmlVideoActivity htmlVideoActivity) {
        ul3.a(htmlVideoActivity, new zk3());
        return htmlVideoActivity;
    }

    @Override // dc.fl2
    public void g(PatternsHiddenActivity patternsHiddenActivity) {
        k0(patternsHiddenActivity);
    }

    @CanIgnoreReturnValue
    public final MainActivity g0(MainActivity mainActivity) {
        gx1.a(mainActivity, K());
        return mainActivity;
    }

    @Override // dc.fl2
    public void h(PatternSearchActivity patternSearchActivity) {
        i0(patternSearchActivity);
    }

    @CanIgnoreReturnValue
    public final MessageNotificationsActivity h0(MessageNotificationsActivity messageNotificationsActivity) {
        ay1.a(messageNotificationsActivity, L());
        return messageNotificationsActivity;
    }

    @Override // dc.fl2
    public void i(WishListCreatGuildActivity wishListCreatGuildActivity) {
        t0(wishListCreatGuildActivity);
    }

    @CanIgnoreReturnValue
    public final PatternSearchActivity i0(PatternSearchActivity patternSearchActivity) {
        px2.a(patternSearchActivity, M());
        return patternSearchActivity;
    }

    @Override // dc.fl2
    public void j(ProfileActivity profileActivity) {
        l0(profileActivity);
    }

    @CanIgnoreReturnValue
    public final PatternUserActivity j0(PatternUserActivity patternUserActivity) {
        qx2.a(patternUserActivity, M());
        return patternUserActivity;
    }

    @Override // dc.fl2
    public void k(ForgetPassActivity forgetPassActivity) {
        c0(forgetPassActivity);
    }

    @CanIgnoreReturnValue
    public final PatternsHiddenActivity k0(PatternsHiddenActivity patternsHiddenActivity) {
        yb3.a(patternsHiddenActivity, N());
        return patternsHiddenActivity;
    }

    @Override // dc.fl2
    public void l(ChatRoomActivity chatRoomActivity) {
        X(chatRoomActivity);
    }

    @CanIgnoreReturnValue
    public final ProfileActivity l0(ProfileActivity profileActivity) {
        zb3.a(profileActivity, O());
        return profileActivity;
    }

    @Override // dc.fl2
    public void m(SerialNumberActivity serialNumberActivity) {
        o0(serialNumberActivity);
    }

    @CanIgnoreReturnValue
    public final ReportActivity m0(ReportActivity reportActivity) {
        wc2.a(reportActivity, P());
        return reportActivity;
    }

    @Override // dc.fl2
    public void n(AddFriendActivity addFriendActivity) {
        V(addFriendActivity);
    }

    @CanIgnoreReturnValue
    public final ResetPasswordActivity n0(ResetPasswordActivity resetPasswordActivity) {
        gz1.a(resetPasswordActivity, Q());
        return resetPasswordActivity;
    }

    @Override // dc.fl2
    public void o(MessageNotificationsActivity messageNotificationsActivity) {
        h0(messageNotificationsActivity);
    }

    @CanIgnoreReturnValue
    public final SerialNumberActivity o0(SerialNumberActivity serialNumberActivity) {
        ui2.a(serialNumberActivity, R());
        return serialNumberActivity;
    }

    @Override // dc.fl2
    public void p(PatternUserActivity patternUserActivity) {
        j0(patternUserActivity);
    }

    @CanIgnoreReturnValue
    public final SettingActivity p0(SettingActivity settingActivity) {
        ac3.a(settingActivity, L());
        return settingActivity;
    }

    @Override // dc.fl2
    public void q(ToyStrengthActivity toyStrengthActivity) {
        r0(toyStrengthActivity);
    }

    @CanIgnoreReturnValue
    public final SignUpActivity q0(SignUpActivity signUpActivity) {
        hz1.a(signUpActivity, S());
        return signUpActivity;
    }

    @Override // dc.fl2
    public void r(UserGuidesActivity userGuidesActivity) {
        s0(userGuidesActivity);
    }

    @CanIgnoreReturnValue
    public final ToyStrengthActivity r0(ToyStrengthActivity toyStrengthActivity) {
        xi2.a(toyStrengthActivity, T());
        return toyStrengthActivity;
    }

    @Override // dc.fl2
    public void s(SignUpActivity signUpActivity) {
        q0(signUpActivity);
    }

    @CanIgnoreReturnValue
    public final UserGuidesActivity s0(UserGuidesActivity userGuidesActivity) {
        by1.a(userGuidesActivity, U());
        return userGuidesActivity;
    }

    @Override // dc.fl2
    public void t(ReportActivity reportActivity) {
        m0(reportActivity);
    }

    @CanIgnoreReturnValue
    public final WishListCreatGuildActivity t0(WishListCreatGuildActivity wishListCreatGuildActivity) {
        p13.a(wishListCreatGuildActivity, new r13());
        return wishListCreatGuildActivity;
    }

    @Override // dc.fl2
    public void u(WishListViewActivity wishListViewActivity) {
        u0(wishListViewActivity);
    }

    @CanIgnoreReturnValue
    public final WishListViewActivity u0(WishListViewActivity wishListViewActivity) {
        q13.a(wishListViewActivity, new u13());
        return wishListViewActivity;
    }

    @Override // dc.fl2
    public void v(EditEmailActivity editEmailActivity) {
        a0(editEmailActivity);
    }

    @Override // dc.fl2
    public void w(ChangePasswordActivity changePasswordActivity) {
        W(changePasswordActivity);
    }

    @Override // dc.fl2
    public void x(FriendProfileActivity friendProfileActivity) {
        d0(friendProfileActivity);
    }

    @Override // dc.fl2
    public void y(FAQActivity fAQActivity) {
        b0(fAQActivity);
    }

    @Override // dc.fl2
    public void z(ChatRoomInfoActivity chatRoomInfoActivity) {
        Y(chatRoomInfoActivity);
    }

    public hl2(ll2 ll2Var, gl2 gl2Var) {
    }
}
