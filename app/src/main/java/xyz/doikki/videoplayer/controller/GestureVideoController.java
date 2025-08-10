package xyz.doikki.videoplayer.controller;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import dc.gk4;
import dc.nj4;
import dc.oj4;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes5.dex */
public abstract class GestureVideoController extends BaseVideoController implements GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener, View.OnTouchListener {
    public boolean A;
    public boolean B;
    public boolean C;
    public boolean D;
    public int E;
    public boolean F;
    public GestureDetector r;
    public AudioManager s;
    public boolean t;
    public int u;
    public float v;
    public int w;
    public boolean x;
    public boolean y;
    public boolean z;

    public GestureVideoController(@NonNull Context context) {
        super(context);
        this.t = true;
        this.w = -1;
        this.B = true;
        this.F = true;
    }

    public final boolean G() {
        int i;
        return (this.a == null || (i = this.E) == -1 || i == 0 || i == 1 || i == 2 || i == 8 || i == 5) ? false : true;
    }

    public void H(float f) {
        Activity activityL = gk4.l(getContext());
        if (activityL == null) {
            return;
        }
        Window window = activityL.getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        int measuredHeight = getMeasuredHeight();
        if (this.v == -1.0f) {
            this.v = 0.5f;
        }
        float f2 = ((f * 2.0f) / measuredHeight) + this.v;
        if (f2 < 0.0f) {
            f2 = 0.0f;
        }
        if (f2 > 1.0f) {
            f2 = 1.0f;
        }
        int i = (int) (100.0f * f2);
        attributes.screenBrightness = f2;
        window.setAttributes(attributes);
        Iterator<Map.Entry<nj4, Boolean>> it = this.l.entrySet().iterator();
        while (it.hasNext()) {
            nj4 key = it.next().getKey();
            if (key instanceof oj4) {
                ((oj4) key).h(i);
            }
        }
    }

    public void I(float f) {
        int measuredWidth = getMeasuredWidth();
        int duration = (int) this.a.getDuration();
        int currentPosition = (int) this.a.getCurrentPosition();
        int i = (int) ((((-f) / measuredWidth) * 120000.0f) + currentPosition);
        if (i > duration) {
            i = duration;
        }
        if (i < 0) {
            i = 0;
        }
        Iterator<Map.Entry<nj4, Boolean>> it = this.l.entrySet().iterator();
        while (it.hasNext()) {
            nj4 key = it.next().getKey();
            if (key instanceof oj4) {
                ((oj4) key).c(i, currentPosition, duration);
            }
        }
        this.w = i;
    }

    public void J(float f) {
        float streamMaxVolume = this.s.getStreamMaxVolume(3);
        float measuredHeight = this.u + (((f * 2.0f) / getMeasuredHeight()) * streamMaxVolume);
        if (measuredHeight > streamMaxVolume) {
            measuredHeight = streamMaxVolume;
        }
        if (measuredHeight < 0.0f) {
            measuredHeight = 0.0f;
        }
        int i = (int) ((measuredHeight / streamMaxVolume) * 100.0f);
        this.s.setStreamVolume(3, (int) measuredHeight, 0);
        Iterator<Map.Entry<nj4, Boolean>> it = this.l.entrySet().iterator();
        while (it.hasNext()) {
            nj4 key = it.next().getKey();
            if (key instanceof oj4) {
                ((oj4) key).j(i);
            }
        }
    }

    public final void K() {
        Iterator<Map.Entry<nj4, Boolean>> it = this.l.entrySet().iterator();
        while (it.hasNext()) {
            nj4 key = it.next().getKey();
            if (key instanceof oj4) {
                ((oj4) key).g();
            }
        }
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTap(MotionEvent motionEvent) {
        if (!this.F || g() || !G()) {
            return true;
        }
        F();
        return true;
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTapEvent(MotionEvent motionEvent) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        if (G() && this.t && !gk4.k(getContext(), motionEvent)) {
            this.u = this.s.getStreamVolume(3);
            Activity activityL = gk4.l(getContext());
            if (activityL == null) {
                this.v = 0.0f;
            } else {
                this.v = activityL.getWindow().getAttributes().screenBrightness;
            }
            this.x = true;
            this.y = false;
            this.z = false;
            this.A = false;
        }
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (G() && this.t && this.D && !g() && !gk4.k(getContext(), motionEvent)) {
            float x = motionEvent.getX() - motionEvent2.getX();
            float y = motionEvent.getY() - motionEvent2.getY();
            if (this.x) {
                boolean z = Math.abs(f) >= Math.abs(f2);
                this.y = z;
                if (!z) {
                    if (motionEvent2.getX() > gk4.f(getContext(), true) / 2) {
                        this.A = true;
                    } else {
                        this.z = true;
                    }
                }
                if (this.y) {
                    this.y = this.B;
                }
                if (this.y || this.z || this.A) {
                    Iterator<Map.Entry<nj4, Boolean>> it = this.l.entrySet().iterator();
                    while (it.hasNext()) {
                        nj4 key = it.next().getKey();
                        if (key instanceof oj4) {
                            ((oj4) key).f();
                        }
                    }
                }
                this.x = false;
            }
            if (this.y) {
                I(x);
            } else if (this.z) {
                H(y);
            } else if (this.A) {
                J(y);
            }
        }
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        if (!G()) {
            return true;
        }
        this.a.o();
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return this.r.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.r.onTouchEvent(motionEvent)) {
            int action = motionEvent.getAction();
            if (action == 1) {
                K();
                int i = this.w;
                if (i >= 0) {
                    this.a.seekTo(i);
                    this.w = -1;
                }
            } else if (action == 3) {
                K();
                this.w = -1;
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // xyz.doikki.videoplayer.controller.BaseVideoController
    public void s() {
        super.s();
        this.s = (AudioManager) getContext().getSystemService("audio");
        this.r = new GestureDetector(getContext(), this);
        setOnTouchListener(this);
    }

    public void setCanChangePosition(boolean z) {
        this.B = z;
    }

    public void setDoubleTapTogglePlayEnabled(boolean z) {
        this.F = z;
    }

    public void setEnableInNormal(boolean z) {
        this.C = z;
    }

    public void setGestureEnabled(boolean z) {
        this.t = z;
    }

    @Override // xyz.doikki.videoplayer.controller.BaseVideoController
    public void setPlayState(int i) {
        super.setPlayState(i);
        this.E = i;
    }

    @Override // xyz.doikki.videoplayer.controller.BaseVideoController
    public void setPlayerState(int i) {
        super.setPlayerState(i);
        if (i == 10) {
            this.D = this.C;
        } else if (i == 11) {
            this.D = true;
        }
    }

    public GestureVideoController(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.t = true;
        this.w = -1;
        this.B = true;
        this.F = true;
    }

    public GestureVideoController(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.t = true;
        this.w = -1;
        this.B = true;
        this.F = true;
    }
}
