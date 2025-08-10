package dc;

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
import dagger.Component;

/* compiled from: ActivityComponent.java */
@Component(dependencies = {gl2.class}, modules = {ll2.class})
/* loaded from: classes3.dex */
public interface fl2 {
    void a(HtmlVideoActivity htmlVideoActivity);

    void b(ResetPasswordActivity resetPasswordActivity);

    void c(ControlLinkEndActivity controlLinkEndActivity);

    void d(HelpActivity helpActivity);

    void e(MainActivity mainActivity);

    void f(SettingActivity settingActivity);

    void g(PatternsHiddenActivity patternsHiddenActivity);

    void h(PatternSearchActivity patternSearchActivity);

    void i(WishListCreatGuildActivity wishListCreatGuildActivity);

    void j(ProfileActivity profileActivity);

    void k(ForgetPassActivity forgetPassActivity);

    void l(ChatRoomActivity chatRoomActivity);

    void m(SerialNumberActivity serialNumberActivity);

    void n(AddFriendActivity addFriendActivity);

    void o(MessageNotificationsActivity messageNotificationsActivity);

    void p(PatternUserActivity patternUserActivity);

    void q(ToyStrengthActivity toyStrengthActivity);

    void r(UserGuidesActivity userGuidesActivity);

    void s(SignUpActivity signUpActivity);

    void t(ReportActivity reportActivity);

    void u(WishListViewActivity wishListViewActivity);

    void v(EditEmailActivity editEmailActivity);

    void w(ChangePasswordActivity changePasswordActivity);

    void x(FriendProfileActivity friendProfileActivity);

    void y(FAQActivity fAQActivity);

    void z(ChatRoomInfoActivity chatRoomInfoActivity);
}
