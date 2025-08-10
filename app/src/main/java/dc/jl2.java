package dc;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.wear.main.account.login.LoginFragment;
import com.wear.ui.discover.DiscoverFragment;
import com.wear.ui.discover.pattern.PatternsItemFragment;
import com.wear.ui.home.pattern.fragment.MyPatternsFragment;
import dagger.internal.Preconditions;

/* compiled from: DaggerFragmentComponent.java */
/* loaded from: classes3.dex */
public final class jl2 implements kl2 {

    /* compiled from: DaggerFragmentComponent.java */
    public static final class b {
        public ol2 a;
        public gl2 b;

        public b a(gl2 gl2Var) {
            this.b = (gl2) Preconditions.checkNotNull(gl2Var);
            return this;
        }

        public kl2 b() {
            Preconditions.checkBuilderRequirement(this.a, ol2.class);
            Preconditions.checkBuilderRequirement(this.b, gl2.class);
            return new jl2(this.a, this.b);
        }

        public b c(ol2 ol2Var) {
            this.a = (ol2) Preconditions.checkNotNull(ol2Var);
            return this;
        }

        public b() {
        }
    }

    public static b e() {
        return new b();
    }

    @Override // dc.kl2
    public void a(LoginFragment loginFragment) {
        k(loginFragment);
    }

    @Override // dc.kl2
    public void b(MyPatternsFragment myPatternsFragment) {
        l(myPatternsFragment);
    }

    @Override // dc.kl2
    public void c(PatternsItemFragment patternsItemFragment) {
        m(patternsItemFragment);
    }

    @Override // dc.kl2
    public void d(DiscoverFragment discoverFragment) {
        j(discoverFragment);
    }

    public final cm2 f() {
        return new cm2(new bm2());
    }

    public final om2 g() {
        return new om2(new nm2());
    }

    public final en2 h() {
        return new en2(new dn2());
    }

    public final ym2 i() {
        return new ym2(new xm2());
    }

    @CanIgnoreReturnValue
    public final DiscoverFragment j(DiscoverFragment discoverFragment) {
        kv2.a(discoverFragment, f());
        return discoverFragment;
    }

    @CanIgnoreReturnValue
    public final LoginFragment k(LoginFragment loginFragment) {
        fz1.a(loginFragment, g());
        return loginFragment;
    }

    @CanIgnoreReturnValue
    public final MyPatternsFragment l(MyPatternsFragment myPatternsFragment) {
        p53.a(myPatternsFragment, i());
        return myPatternsFragment;
    }

    @CanIgnoreReturnValue
    public final PatternsItemFragment m(PatternsItemFragment patternsItemFragment) {
        rx2.a(patternsItemFragment, h());
        return patternsItemFragment;
    }

    public jl2(ol2 ol2Var, gl2 gl2Var) {
    }
}
