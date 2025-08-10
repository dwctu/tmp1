package dc;

import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.SeekBar;

/* compiled from: SkinCompatSeekBarHelper.java */
/* loaded from: classes5.dex */
public class zi4 extends xi4 {
    public final SeekBar f;
    public int g;

    public zi4(SeekBar seekBar) {
        super(seekBar);
        this.g = 0;
        this.f = seekBar;
    }

    @Override // dc.xi4
    public void b() {
        super.b();
        int iA = vi4.a(this.g);
        this.g = iA;
        if (iA != 0) {
            SeekBar seekBar = this.f;
            seekBar.setThumb(xh4.a(seekBar.getContext(), this.g));
        }
    }

    @Override // dc.xi4
    public void e(AttributeSet attributeSet, int i) {
        super.e(attributeSet, i);
        TypedArray typedArrayObtainStyledAttributes = this.f.getContext().obtainStyledAttributes(attributeSet, lh4.AppCompatSeekBar, i, 0);
        this.g = typedArrayObtainStyledAttributes.getResourceId(lh4.AppCompatSeekBar_android_thumb, 0);
        typedArrayObtainStyledAttributes.recycle();
        b();
    }
}
