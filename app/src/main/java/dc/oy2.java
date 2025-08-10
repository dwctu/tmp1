package dc;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import androidx.databinding.BindingAdapter;
import com.lovense.wear.R;
import com.wear.bean.RouletteStatus;
import com.wear.widget.RadarScanView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: RouletteDatabindingAdapter.kt */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u001a\u001a\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0007\u001a\u001a\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0007\u001a\u0018\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007\u001a$\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\u0011\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u0012\u001a\u00020\u000fH\u0007¨\u0006\u0013"}, d2 = {"genderIcon", "", "imageView", "Landroid/widget/ImageView;", "gender", "", "hintResultTextMore", "textView", "Landroid/widget/TextView;", "status", "Lcom/wear/bean/RouletteStatus;", "scanSuccess", "radarScanView", "Lcom/wear/widget/RadarScanView;", "isSuccess", "", "setHintResultText", "rouletteStatus", "skipTimeOut", "app_marketRelease"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class oy2 {

    /* compiled from: RouletteDatabindingAdapter.kt */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/wear/ui/discover/roulette/databinding/RouletteDatabindingAdapterKt$hintResultTextMore$action$1", "Ljava/lang/Runnable;", "run", "", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a implements Runnable {
        public final /* synthetic */ TextView a;
        public final /* synthetic */ Ref.ObjectRef<String> b;

        public a(TextView textView, Ref.ObjectRef<String> objectRef) {
            this.a = textView;
            this.b = objectRef;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            this.a.setText(this.b.element);
            this.a.postDelayed(this, 500L);
            Ref.ObjectRef<String> objectRef = this.b;
            objectRef.element = objectRef.element.length() == 0 ? "." : this.b.element.length() == 1 ? ".." : this.b.element.length() == 2 ? "..." : "";
        }
    }

    @BindingAdapter({"genderIcon"})
    public static final void a(@NotNull ImageView imageView, @Nullable String str) {
        Intrinsics.checkNotNullParameter(imageView, "imageView");
        int i = R.drawable.icon_gender_nonbinary;
        if (str != null) {
            int iHashCode = str.hashCode();
            if (iHashCode != -1278174388) {
                if (iHashCode != 3343885) {
                    if (iHashCode == 849481139) {
                        str.equals("non_binary");
                    }
                } else if (str.equals("male")) {
                    i = R.drawable.icon_gender_man;
                }
            } else if (str.equals("female")) {
                i = R.drawable.icon_gender_woman;
            }
        }
        imageView.setImageResource(i);
    }

    @BindingAdapter({"hintResultTextMore"})
    public static final void b(@NotNull TextView textView, @Nullable RouletteStatus rouletteStatus) {
        Intrinsics.checkNotNullParameter(textView, "textView");
        if (rouletteStatus == null) {
            return;
        }
        Object tag = textView.getTag();
        textView.removeCallbacks(tag instanceof Runnable ? (Runnable) tag : null);
        if (!Intrinsics.areEqual(rouletteStatus, RouletteStatus.Matching.INSTANCE)) {
            wi1.c(textView, false);
            return;
        }
        wi1.c(textView, true);
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = "...";
        Runnable aVar = new a(textView, objectRef);
        textView.setTag(aVar);
        textView.post(aVar);
    }

    @BindingAdapter({"scanSuccess"})
    public static final void c(@NotNull RadarScanView radarScanView, boolean z) {
        Intrinsics.checkNotNullParameter(radarScanView, "radarScanView");
        if (z) {
            radarScanView.n();
        } else {
            radarScanView.m();
        }
    }

    @BindingAdapter(requireAll = false, value = {"hintResultText", "skipTimeOut"})
    public static final void d(@NotNull TextView textView, @Nullable RouletteStatus rouletteStatus, boolean z) {
        String strE;
        Intrinsics.checkNotNullParameter(textView, "textView");
        if (rouletteStatus == null) {
            return;
        }
        Resources resources = textView.getResources();
        if (rouletteStatus instanceof RouletteStatus.Idle) {
            strE = ah4.e(R.string.control_roulette_start);
        } else if (rouletteStatus instanceof RouletteStatus.Matching) {
            strE = ah4.e(R.string.control_roulette_looking);
        } else if (rouletteStatus instanceof RouletteStatus.MatchSuccess) {
            strE = ah4.e(R.string.control_roulette_successful_match);
        } else if (rouletteStatus instanceof RouletteStatus.MatchFailedGender) {
            strE = ah4.e(R.string.set_gender_first);
        } else {
            if (!(rouletteStatus instanceof RouletteStatus.MatchFailedTimeoutAgree ? true : Intrinsics.areEqual(rouletteStatus, RouletteStatus.MatchFailedTimeoutNoUser.INSTANCE))) {
                strE = rouletteStatus instanceof RouletteStatus.MatchFailedOtherUserDeclined ? ah4.e(R.string.control_roulette_declined) : "";
            } else if (z) {
                return;
            } else {
                strE = ah4.e(R.string.control_roulette_match_failed);
            }
        }
        boolean z2 = rouletteStatus instanceof RouletteStatus.MatchSuccess;
        Drawable drawable = z2 ? ResourcesCompat.getDrawable(resources, R.drawable.bg_roulette_match_success, textView.getContext().getTheme()) : rouletteStatus instanceof RouletteStatus.MatchFailedOtherUserDeclined ? th4.d(textView.getContext(), R.drawable.bg_roulette_match_failed_user_declined) : null;
        int iB = z2 ? -1 : th4.b(textView.getContext(), R.color.roulette_text_6c_a6);
        textView.setBackground(drawable);
        textView.setTextColor(iB);
        textView.setText(strE);
    }
}
