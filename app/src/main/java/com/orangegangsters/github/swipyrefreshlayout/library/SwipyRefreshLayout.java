package com.orangegangsters.github.swipyrefreshlayout.library;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Transformation;
import android.widget.AbsListView;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.ViewCompat;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes3.dex */
public class SwipyRefreshLayout extends ViewGroup {
    private static final int ALPHA_ANIMATION_DURATION = 300;
    private static final int ANIMATE_TO_START_DURATION = 200;
    private static final int ANIMATE_TO_TRIGGER_DURATION = 200;
    private static final int CIRCLE_BG_LIGHT = -328966;
    private static final int CIRCLE_DIAMETER = 40;
    private static final int CIRCLE_DIAMETER_LARGE = 56;
    private static final float DECELERATE_INTERPOLATION_FACTOR = 2.0f;
    public static final int DEFAULT = 1;
    private static final int DEFAULT_CIRCLE_TARGET = 64;
    private static final float DRAG_RATE = 0.5f;
    private static final int INVALID_POINTER = -1;
    public static final int LARGE = 0;
    private static final int MAX_ALPHA = 255;
    private static final float MAX_PROGRESS_ANGLE = 0.8f;
    private static final int SCALE_DOWN_DURATION = 150;
    private static final int STARTING_PROGRESS_ALPHA = 76;
    private int mActivePointerId;
    private Animation mAlphaMaxAnimation;
    private Animation mAlphaStartAnimation;
    private final Animation mAnimateToCorrectPosition;
    private final Animation mAnimateToStartPosition;
    private boolean mBothDirection;
    private int mCircleHeight;
    private CircleImageView mCircleView;
    private int mCircleViewIndex;
    private int mCircleWidth;
    private int mCurrentTargetOffsetTop;
    private final DecelerateInterpolator mDecelerateInterpolator;
    private SwipyRefreshLayoutDirection mDirection;
    public int mFrom;
    private float mInitialMotionY;
    private boolean mIsBeingDragged;
    private OnRefreshListener mListener;
    private int mMediumAnimationDuration;
    private boolean mNotify;
    private boolean mOriginalOffsetCalculated;
    public int mOriginalOffsetTop;
    private MaterialProgressDrawable mProgress;
    private Animation.AnimationListener mRefreshListener;
    private boolean mRefreshing;
    private boolean mReturningToStart;
    private boolean mScale;
    private Animation mScaleAnimation;
    private Animation mScaleDownAnimation;
    private Animation mScaleDownToStartAnimation;
    private float mSpinnerFinalOffset;
    private float mStartingScale;
    private View mTarget;
    private float mTotalDragDistance;
    private int mTouchSlop;
    private boolean mUsingCustomStart;
    private static final String LOG_TAG = SwipyRefreshLayout.class.getSimpleName();
    private static final int[] LAYOUT_ATTRS = {android.R.attr.enabled};

    /* renamed from: com.orangegangsters.github.swipyrefreshlayout.library.SwipyRefreshLayout$9, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass9 {
        public static final /* synthetic */ int[] $SwitchMap$com$orangegangsters$github$swipyrefreshlayout$library$SwipyRefreshLayoutDirection;

        static {
            int[] iArr = new int[SwipyRefreshLayoutDirection.values().length];
            $SwitchMap$com$orangegangsters$github$swipyrefreshlayout$library$SwipyRefreshLayoutDirection = iArr;
            try {
                iArr[SwipyRefreshLayoutDirection.BOTTOM.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$orangegangsters$github$swipyrefreshlayout$library$SwipyRefreshLayoutDirection[SwipyRefreshLayoutDirection.TOP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public interface OnRefreshListener {
        void onRefresh(SwipyRefreshLayoutDirection swipyRefreshLayoutDirection);
    }

    public SwipyRefreshLayout(Context context) {
        this(context, null);
    }

    private void animateOffsetToCorrectPosition(int i, Animation.AnimationListener animationListener) {
        this.mFrom = i;
        this.mAnimateToCorrectPosition.reset();
        this.mAnimateToCorrectPosition.setDuration(200L);
        this.mAnimateToCorrectPosition.setInterpolator(this.mDecelerateInterpolator);
        if (animationListener != null) {
            this.mCircleView.setAnimationListener(animationListener);
        }
        this.mCircleView.clearAnimation();
        this.mCircleView.startAnimation(this.mAnimateToCorrectPosition);
    }

    private void animateOffsetToStartPosition(int i, Animation.AnimationListener animationListener) {
        if (this.mScale) {
            startScaleDownReturnToStartAnimation(i, animationListener);
            return;
        }
        this.mFrom = i;
        this.mAnimateToStartPosition.reset();
        this.mAnimateToStartPosition.setDuration(200L);
        this.mAnimateToStartPosition.setInterpolator(this.mDecelerateInterpolator);
        if (animationListener != null) {
            this.mCircleView.setAnimationListener(animationListener);
        }
        this.mCircleView.clearAnimation();
        this.mCircleView.startAnimation(this.mAnimateToStartPosition);
    }

    private void createProgressView() {
        this.mCircleView = new CircleImageView(getContext(), CIRCLE_BG_LIGHT, 20.0f);
        MaterialProgressDrawable materialProgressDrawable = new MaterialProgressDrawable(getContext(), this);
        this.mProgress = materialProgressDrawable;
        materialProgressDrawable.setBackgroundColor(CIRCLE_BG_LIGHT);
        this.mCircleView.setImageDrawable(this.mProgress);
        this.mCircleView.setVisibility(8);
        addView(this.mCircleView);
    }

    private void ensureTarget() {
        if (this.mTarget == null) {
            for (int i = 0; i < getChildCount(); i++) {
                View childAt = getChildAt(i);
                if (!childAt.equals(this.mCircleView)) {
                    this.mTarget = childAt;
                    return;
                }
            }
        }
    }

    private float getMotionEventY(MotionEvent motionEvent, int i) {
        int iFindPointerIndex = MotionEventCompat.findPointerIndex(motionEvent, i);
        if (iFindPointerIndex < 0) {
            return -1.0f;
        }
        return MotionEventCompat.getY(motionEvent, iFindPointerIndex);
    }

    private boolean isAlphaUsedForScale() {
        return Build.VERSION.SDK_INT < 11;
    }

    private boolean isAnimationRunning(Animation animation) {
        return (animation == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void moveToStart(float f) {
        setTargetOffsetTopAndBottom((this.mFrom + ((int) ((this.mOriginalOffsetTop - r0) * f))) - this.mCircleView.getTop(), false);
    }

    private void onSecondaryPointerUp(MotionEvent motionEvent) {
        int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
        if (MotionEventCompat.getPointerId(motionEvent, actionIndex) == this.mActivePointerId) {
            this.mActivePointerId = MotionEventCompat.getPointerId(motionEvent, actionIndex == 0 ? 1 : 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAnimationProgress(float f) {
        if (isAlphaUsedForScale()) {
            setColorViewAlpha((int) (f * 255.0f));
        } else {
            ViewCompat.setScaleX(this.mCircleView, f);
            ViewCompat.setScaleY(this.mCircleView, f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setColorViewAlpha(int i) {
        this.mCircleView.getBackground().setAlpha(i);
        this.mProgress.setAlpha(i);
    }

    private void setRawDirection(SwipyRefreshLayoutDirection swipyRefreshLayoutDirection) {
        if (this.mDirection == swipyRefreshLayoutDirection) {
            return;
        }
        this.mDirection = swipyRefreshLayoutDirection;
        if (AnonymousClass9.$SwitchMap$com$orangegangsters$github$swipyrefreshlayout$library$SwipyRefreshLayoutDirection[swipyRefreshLayoutDirection.ordinal()] == 1) {
            this.mCurrentTargetOffsetTop = getMeasuredHeight() - this.mCircleView.getMeasuredHeight();
            this.mOriginalOffsetTop = getMeasuredHeight() - this.mCircleView.getMeasuredHeight();
        } else {
            int i = -this.mCircleView.getMeasuredHeight();
            this.mOriginalOffsetTop = i;
            this.mCurrentTargetOffsetTop = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTargetOffsetTopAndBottom(int i, boolean z) {
        this.mCircleView.bringToFront();
        this.mCircleView.offsetTopAndBottom(i);
        if (AnonymousClass9.$SwitchMap$com$orangegangsters$github$swipyrefreshlayout$library$SwipyRefreshLayoutDirection[this.mDirection.ordinal()] != 1) {
            this.mCurrentTargetOffsetTop = this.mCircleView.getTop();
        } else {
            this.mCurrentTargetOffsetTop = getMeasuredHeight() - this.mCircleView.getMeasuredHeight();
        }
        if (!z || Build.VERSION.SDK_INT >= 11) {
            return;
        }
        invalidate();
    }

    private Animation startAlphaAnimation(final int i, final int i2) {
        if (this.mScale && isAlphaUsedForScale()) {
            return null;
        }
        Animation animation = new Animation() { // from class: com.orangegangsters.github.swipyrefreshlayout.library.SwipyRefreshLayout.4
            @Override // android.view.animation.Animation
            public void applyTransformation(float f, Transformation transformation) {
                SwipyRefreshLayout.this.mProgress.setAlpha((int) (i + ((i2 - r0) * f)));
            }
        };
        animation.setDuration(300L);
        this.mCircleView.setAnimationListener(null);
        this.mCircleView.clearAnimation();
        this.mCircleView.startAnimation(animation);
        return animation;
    }

    private void startProgressAlphaMaxAnimation() {
        this.mAlphaMaxAnimation = startAlphaAnimation(this.mProgress.getAlpha(), 255);
    }

    private void startProgressAlphaStartAnimation() {
        this.mAlphaStartAnimation = startAlphaAnimation(this.mProgress.getAlpha(), 76);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startScaleDownAnimation(Animation.AnimationListener animationListener) {
        Animation animation = new Animation() { // from class: com.orangegangsters.github.swipyrefreshlayout.library.SwipyRefreshLayout.3
            @Override // android.view.animation.Animation
            public void applyTransformation(float f, Transformation transformation) {
                SwipyRefreshLayout.this.setAnimationProgress(1.0f - f);
            }
        };
        this.mScaleDownAnimation = animation;
        animation.setDuration(150L);
        this.mCircleView.setAnimationListener(animationListener);
        this.mCircleView.clearAnimation();
        this.mCircleView.startAnimation(this.mScaleDownAnimation);
    }

    private void startScaleDownReturnToStartAnimation(int i, Animation.AnimationListener animationListener) {
        this.mFrom = i;
        if (isAlphaUsedForScale()) {
            this.mStartingScale = this.mProgress.getAlpha();
        } else {
            this.mStartingScale = ViewCompat.getScaleX(this.mCircleView);
        }
        Animation animation = new Animation() { // from class: com.orangegangsters.github.swipyrefreshlayout.library.SwipyRefreshLayout.8
            @Override // android.view.animation.Animation
            public void applyTransformation(float f, Transformation transformation) {
                SwipyRefreshLayout.this.setAnimationProgress(SwipyRefreshLayout.this.mStartingScale + ((-SwipyRefreshLayout.this.mStartingScale) * f));
                SwipyRefreshLayout.this.moveToStart(f);
            }
        };
        this.mScaleDownToStartAnimation = animation;
        animation.setDuration(150L);
        if (animationListener != null) {
            this.mCircleView.setAnimationListener(animationListener);
        }
        this.mCircleView.clearAnimation();
        this.mCircleView.startAnimation(this.mScaleDownToStartAnimation);
    }

    private void startScaleUpAnimation(Animation.AnimationListener animationListener) {
        this.mCircleView.setVisibility(0);
        if (Build.VERSION.SDK_INT >= 11) {
            this.mProgress.setAlpha(255);
        }
        Animation animation = new Animation() { // from class: com.orangegangsters.github.swipyrefreshlayout.library.SwipyRefreshLayout.2
            @Override // android.view.animation.Animation
            public void applyTransformation(float f, Transformation transformation) {
                SwipyRefreshLayout.this.setAnimationProgress(f);
            }
        };
        this.mScaleAnimation = animation;
        animation.setDuration(this.mMediumAnimationDuration);
        if (animationListener != null) {
            this.mCircleView.setAnimationListener(animationListener);
        }
        this.mCircleView.clearAnimation();
        this.mCircleView.startAnimation(this.mScaleAnimation);
    }

    public boolean canChildScrollDown() {
        if (Build.VERSION.SDK_INT >= 14) {
            return ViewCompat.canScrollVertically(this.mTarget, 1);
        }
        View view = this.mTarget;
        if (view instanceof AbsListView) {
            AbsListView absListView = (AbsListView) view;
            try {
                if (absListView.getCount() > 0 && absListView.getLastVisiblePosition() + 1 == absListView.getCount()) {
                    return absListView.getChildAt(absListView.getLastVisiblePosition() - absListView.getFirstVisiblePosition()).getBottom() == absListView.getPaddingBottom();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    public boolean canChildScrollUp() {
        if (Build.VERSION.SDK_INT >= 14) {
            return ViewCompat.canScrollVertically(this.mTarget, -1);
        }
        View view = this.mTarget;
        if (!(view instanceof AbsListView)) {
            return view.getScrollY() > 0;
        }
        AbsListView absListView = (AbsListView) view;
        return absListView.getChildCount() > 0 && (absListView.getFirstVisiblePosition() > 0 || absListView.getChildAt(0).getTop() < absListView.getPaddingTop());
    }

    @Override // android.view.ViewGroup
    public int getChildDrawingOrder(int i, int i2) {
        int i3 = this.mCircleViewIndex;
        return i3 < 0 ? i2 : i2 == i + (-1) ? i3 : i2 >= i3 ? i2 + 1 : i2;
    }

    public SwipyRefreshLayoutDirection getDirection() {
        return this.mBothDirection ? SwipyRefreshLayoutDirection.BOTH : this.mDirection;
    }

    public boolean isRefreshing() {
        return this.mRefreshing;
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x0067  */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r8) {
        /*
            Method dump skipped, instructions count: 246
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.orangegangsters.github.swipyrefreshlayout.library.SwipyRefreshLayout.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (getChildCount() == 0) {
            return;
        }
        if (this.mTarget == null) {
            ensureTarget();
        }
        View view = this.mTarget;
        if (view == null) {
            return;
        }
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        view.layout(paddingLeft, paddingTop, ((measuredWidth - getPaddingLeft()) - getPaddingRight()) + paddingLeft, ((measuredHeight - getPaddingTop()) - getPaddingBottom()) + paddingTop);
        int measuredWidth2 = this.mCircleView.getMeasuredWidth();
        int measuredHeight2 = this.mCircleView.getMeasuredHeight();
        int i5 = measuredWidth / 2;
        int i6 = measuredWidth2 / 2;
        int i7 = this.mCurrentTargetOffsetTop;
        this.mCircleView.layout(i5 - i6, i7, i5 + i6, measuredHeight2 + i7);
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.mTarget == null) {
            ensureTarget();
        }
        View view = this.mTarget;
        if (view == null) {
            return;
        }
        view.measure(View.MeasureSpec.makeMeasureSpec((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), 1073741824), View.MeasureSpec.makeMeasureSpec((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), 1073741824));
        this.mCircleView.measure(View.MeasureSpec.makeMeasureSpec(this.mCircleWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(this.mCircleHeight, 1073741824));
        if (!this.mUsingCustomStart && !this.mOriginalOffsetCalculated) {
            this.mOriginalOffsetCalculated = true;
            if (AnonymousClass9.$SwitchMap$com$orangegangsters$github$swipyrefreshlayout$library$SwipyRefreshLayoutDirection[this.mDirection.ordinal()] != 1) {
                int i3 = -this.mCircleView.getMeasuredHeight();
                this.mOriginalOffsetTop = i3;
                this.mCurrentTargetOffsetTop = i3;
            } else {
                int measuredHeight = getMeasuredHeight() - this.mCircleView.getMeasuredHeight();
                this.mOriginalOffsetTop = measuredHeight;
                this.mCurrentTargetOffsetTop = measuredHeight;
            }
        }
        this.mCircleViewIndex = -1;
        for (int i4 = 0; i4 < getChildCount(); i4++) {
            if (getChildAt(i4) == this.mCircleView) {
                this.mCircleViewIndex = i4;
                return;
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        if (this.mReturningToStart && actionMasked == 0) {
            this.mReturningToStart = false;
        }
        int[] iArr = AnonymousClass9.$SwitchMap$com$orangegangsters$github$swipyrefreshlayout$library$SwipyRefreshLayoutDirection;
        if (iArr[this.mDirection.ordinal()] != 1) {
            if (!isEnabled() || this.mReturningToStart || canChildScrollUp() || this.mRefreshing) {
                return false;
            }
        } else if (!isEnabled() || this.mReturningToStart || canChildScrollDown() || this.mRefreshing) {
            return false;
        }
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    int iFindPointerIndex = MotionEventCompat.findPointerIndex(motionEvent, this.mActivePointerId);
                    if (iFindPointerIndex < 0) {
                        return false;
                    }
                    float y = MotionEventCompat.getY(motionEvent, iFindPointerIndex);
                    float f = iArr[this.mDirection.ordinal()] != 1 ? (y - this.mInitialMotionY) * 0.5f : (this.mInitialMotionY - y) * 0.5f;
                    if (this.mIsBeingDragged) {
                        this.mProgress.showArrow(true);
                        float f2 = f / this.mTotalDragDistance;
                        if (f2 < 0.0f) {
                            return false;
                        }
                        float fMin = Math.min(1.0f, Math.abs(f2));
                        float fMax = (((float) Math.max(fMin - 0.4d, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE)) * 5.0f) / 3.0f;
                        float fAbs = Math.abs(f) - this.mTotalDragDistance;
                        float f3 = this.mUsingCustomStart ? this.mSpinnerFinalOffset - this.mOriginalOffsetTop : this.mSpinnerFinalOffset;
                        double dMax = Math.max(0.0f, Math.min(fAbs, f3 * DECELERATE_INTERPOLATION_FACTOR) / f3) / 4.0f;
                        float fPow = ((float) (dMax - Math.pow(dMax, 2.0d))) * DECELERATE_INTERPOLATION_FACTOR;
                        float f4 = f3 * fPow * DECELERATE_INTERPOLATION_FACTOR;
                        int i = this.mDirection == SwipyRefreshLayoutDirection.TOP ? this.mOriginalOffsetTop + ((int) ((f3 * fMin) + f4)) : this.mOriginalOffsetTop - ((int) ((f3 * fMin) + f4));
                        if (this.mCircleView.getVisibility() != 0) {
                            this.mCircleView.setVisibility(0);
                        }
                        if (!this.mScale) {
                            ViewCompat.setScaleX(this.mCircleView, 1.0f);
                            ViewCompat.setScaleY(this.mCircleView, 1.0f);
                        }
                        float f5 = this.mTotalDragDistance;
                        if (f < f5) {
                            if (this.mScale) {
                                setAnimationProgress(f / f5);
                            }
                            if (this.mProgress.getAlpha() > 76 && !isAnimationRunning(this.mAlphaStartAnimation)) {
                                startProgressAlphaStartAnimation();
                            }
                            this.mProgress.setStartEndTrim(0.0f, Math.min(MAX_PROGRESS_ANGLE, fMax * MAX_PROGRESS_ANGLE));
                            this.mProgress.setArrowScale(Math.min(1.0f, fMax));
                        } else if (this.mProgress.getAlpha() < 255 && !isAnimationRunning(this.mAlphaMaxAnimation)) {
                            startProgressAlphaMaxAnimation();
                        }
                        this.mProgress.setProgressRotation((((fMax * 0.4f) - 0.25f) + (fPow * DECELERATE_INTERPOLATION_FACTOR)) * 0.5f);
                        setTargetOffsetTopAndBottom(i - this.mCurrentTargetOffsetTop, true);
                    }
                } else if (actionMasked != 3) {
                    if (actionMasked == 5) {
                        this.mActivePointerId = MotionEventCompat.getPointerId(motionEvent, MotionEventCompat.getActionIndex(motionEvent));
                    } else if (actionMasked == 6) {
                        onSecondaryPointerUp(motionEvent);
                    }
                }
            }
            int i2 = this.mActivePointerId;
            if (i2 == -1) {
                return false;
            }
            float y2 = MotionEventCompat.getY(motionEvent, MotionEventCompat.findPointerIndex(motionEvent, i2));
            float f6 = iArr[this.mDirection.ordinal()] != 1 ? (y2 - this.mInitialMotionY) * 0.5f : (this.mInitialMotionY - y2) * 0.5f;
            this.mIsBeingDragged = false;
            if (f6 > this.mTotalDragDistance) {
                setRefreshing(true, true);
            } else {
                this.mRefreshing = false;
                this.mProgress.setStartEndTrim(0.0f, 0.0f);
                animateOffsetToStartPosition(this.mCurrentTargetOffsetTop, this.mScale ? null : new Animation.AnimationListener() { // from class: com.orangegangsters.github.swipyrefreshlayout.library.SwipyRefreshLayout.5
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        if (SwipyRefreshLayout.this.mScale) {
                            return;
                        }
                        SwipyRefreshLayout.this.startScaleDownAnimation(null);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }
                });
                this.mProgress.showArrow(false);
            }
            this.mActivePointerId = -1;
            return false;
        }
        this.mActivePointerId = MotionEventCompat.getPointerId(motionEvent, 0);
        this.mIsBeingDragged = false;
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
    }

    @Deprecated
    public void setColorScheme(int... iArr) {
        setColorSchemeResources(iArr);
    }

    public void setColorSchemeColors(int... iArr) {
        ensureTarget();
        this.mProgress.setColorSchemeColors(iArr);
    }

    public void setColorSchemeResources(int... iArr) {
        Resources resources = getResources();
        int[] iArr2 = new int[iArr.length];
        for (int i = 0; i < iArr.length; i++) {
            iArr2[i] = resources.getColor(iArr[i]);
        }
        setColorSchemeColors(iArr2);
    }

    public void setDirection(SwipyRefreshLayoutDirection swipyRefreshLayoutDirection) {
        if (swipyRefreshLayoutDirection == SwipyRefreshLayoutDirection.BOTH) {
            this.mBothDirection = true;
        } else {
            this.mBothDirection = false;
            this.mDirection = swipyRefreshLayoutDirection;
        }
        if (AnonymousClass9.$SwitchMap$com$orangegangsters$github$swipyrefreshlayout$library$SwipyRefreshLayoutDirection[this.mDirection.ordinal()] == 1) {
            this.mCurrentTargetOffsetTop = getMeasuredHeight() - this.mCircleView.getMeasuredHeight();
            this.mOriginalOffsetTop = getMeasuredHeight() - this.mCircleView.getMeasuredHeight();
        } else {
            int i = -this.mCircleView.getMeasuredHeight();
            this.mOriginalOffsetTop = i;
            this.mCurrentTargetOffsetTop = i;
        }
    }

    public void setDistanceToTriggerSync(int i) {
        this.mTotalDragDistance = i;
    }

    public void setOnRefreshListener(OnRefreshListener onRefreshListener) {
        this.mListener = onRefreshListener;
    }

    public void setProgressBackgroundColor(int i) {
        this.mCircleView.setBackgroundColor(i);
        this.mProgress.setBackgroundColor(getResources().getColor(i));
    }

    public void setRefreshing(boolean z) {
        float fAbs;
        int measuredHeight;
        if (!z || this.mRefreshing == z) {
            setRefreshing(z, false);
            return;
        }
        this.mRefreshing = z;
        if (this.mUsingCustomStart) {
            fAbs = this.mSpinnerFinalOffset;
        } else {
            if (AnonymousClass9.$SwitchMap$com$orangegangsters$github$swipyrefreshlayout$library$SwipyRefreshLayoutDirection[this.mDirection.ordinal()] == 1) {
                measuredHeight = getMeasuredHeight() - ((int) this.mSpinnerFinalOffset);
                setTargetOffsetTopAndBottom(measuredHeight - this.mCurrentTargetOffsetTop, true);
                this.mNotify = false;
                startScaleUpAnimation(this.mRefreshListener);
            }
            fAbs = this.mSpinnerFinalOffset - Math.abs(this.mOriginalOffsetTop);
        }
        measuredHeight = (int) fAbs;
        setTargetOffsetTopAndBottom(measuredHeight - this.mCurrentTargetOffsetTop, true);
        this.mNotify = false;
        startScaleUpAnimation(this.mRefreshListener);
    }

    public void setSize(int i) {
        if (i == 0 || i == 1) {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            if (i == 0) {
                int i2 = (int) (displayMetrics.density * 56.0f);
                this.mCircleWidth = i2;
                this.mCircleHeight = i2;
            } else {
                int i3 = (int) (displayMetrics.density * 40.0f);
                this.mCircleWidth = i3;
                this.mCircleHeight = i3;
            }
            this.mCircleView.setImageDrawable(null);
            this.mProgress.updateSizes(i);
            this.mCircleView.setImageDrawable(this.mProgress);
        }
    }

    public SwipyRefreshLayout(Context context, AttributeSet attributeSet) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        super(context, attributeSet);
        this.mRefreshing = false;
        this.mTotalDragDistance = -1.0f;
        this.mOriginalOffsetCalculated = false;
        this.mActivePointerId = -1;
        this.mCircleViewIndex = -1;
        this.mRefreshListener = new Animation.AnimationListener() { // from class: com.orangegangsters.github.swipyrefreshlayout.library.SwipyRefreshLayout.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (SwipyRefreshLayout.this.mRefreshing) {
                    SwipyRefreshLayout.this.mProgress.setAlpha(255);
                    SwipyRefreshLayout.this.mProgress.start();
                    if (SwipyRefreshLayout.this.mNotify && SwipyRefreshLayout.this.mListener != null) {
                        SwipyRefreshLayout.this.mListener.onRefresh(SwipyRefreshLayout.this.mDirection);
                    }
                } else {
                    SwipyRefreshLayout.this.mProgress.stop();
                    SwipyRefreshLayout.this.mCircleView.setVisibility(8);
                    SwipyRefreshLayout.this.setColorViewAlpha(255);
                    if (SwipyRefreshLayout.this.mScale) {
                        SwipyRefreshLayout.this.setAnimationProgress(0.0f);
                    } else {
                        SwipyRefreshLayout swipyRefreshLayout = SwipyRefreshLayout.this;
                        swipyRefreshLayout.setTargetOffsetTopAndBottom(swipyRefreshLayout.mOriginalOffsetTop - swipyRefreshLayout.mCurrentTargetOffsetTop, true);
                    }
                }
                SwipyRefreshLayout swipyRefreshLayout2 = SwipyRefreshLayout.this;
                swipyRefreshLayout2.mCurrentTargetOffsetTop = swipyRefreshLayout2.mCircleView.getTop();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        };
        this.mAnimateToCorrectPosition = new Animation() { // from class: com.orangegangsters.github.swipyrefreshlayout.library.SwipyRefreshLayout.6
            @Override // android.view.animation.Animation
            public void applyTransformation(float f, Transformation transformation) {
                float fAbs;
                int measuredHeight;
                if (SwipyRefreshLayout.this.mUsingCustomStart) {
                    fAbs = SwipyRefreshLayout.this.mSpinnerFinalOffset;
                } else {
                    if (AnonymousClass9.$SwitchMap$com$orangegangsters$github$swipyrefreshlayout$library$SwipyRefreshLayoutDirection[SwipyRefreshLayout.this.mDirection.ordinal()] == 1) {
                        measuredHeight = SwipyRefreshLayout.this.getMeasuredHeight() - ((int) SwipyRefreshLayout.this.mSpinnerFinalOffset);
                        SwipyRefreshLayout swipyRefreshLayout = SwipyRefreshLayout.this;
                        SwipyRefreshLayout.this.setTargetOffsetTopAndBottom((swipyRefreshLayout.mFrom + ((int) ((measuredHeight - r1) * f))) - swipyRefreshLayout.mCircleView.getTop(), false);
                    }
                    fAbs = SwipyRefreshLayout.this.mSpinnerFinalOffset - Math.abs(SwipyRefreshLayout.this.mOriginalOffsetTop);
                }
                measuredHeight = (int) fAbs;
                SwipyRefreshLayout swipyRefreshLayout2 = SwipyRefreshLayout.this;
                SwipyRefreshLayout.this.setTargetOffsetTopAndBottom((swipyRefreshLayout2.mFrom + ((int) ((measuredHeight - r1) * f))) - swipyRefreshLayout2.mCircleView.getTop(), false);
            }
        };
        this.mAnimateToStartPosition = new Animation() { // from class: com.orangegangsters.github.swipyrefreshlayout.library.SwipyRefreshLayout.7
            @Override // android.view.animation.Animation
            public void applyTransformation(float f, Transformation transformation) {
                SwipyRefreshLayout.this.moveToStart(f);
            }
        };
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        this.mMediumAnimationDuration = getResources().getInteger(android.R.integer.config_mediumAnimTime);
        setWillNotDraw(false);
        this.mDecelerateInterpolator = new DecelerateInterpolator(DECELERATE_INTERPOLATION_FACTOR);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, LAYOUT_ATTRS);
        setEnabled(typedArrayObtainStyledAttributes.getBoolean(0, true));
        typedArrayObtainStyledAttributes.recycle();
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, R.styleable.SwipyRefreshLayout);
        SwipyRefreshLayoutDirection fromInt = SwipyRefreshLayoutDirection.getFromInt(typedArrayObtainStyledAttributes2.getInt(R.styleable.SwipyRefreshLayout_direction, 0));
        if (fromInt != SwipyRefreshLayoutDirection.BOTH) {
            this.mDirection = fromInt;
            this.mBothDirection = false;
        } else {
            this.mDirection = SwipyRefreshLayoutDirection.TOP;
            this.mBothDirection = true;
        }
        typedArrayObtainStyledAttributes2.recycle();
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        float f = displayMetrics.density;
        this.mCircleWidth = (int) (f * 40.0f);
        this.mCircleHeight = (int) (f * 40.0f);
        createProgressView();
        ViewCompat.setChildrenDrawingOrderEnabled(this, true);
        float f2 = displayMetrics.density * 64.0f;
        this.mSpinnerFinalOffset = f2;
        this.mTotalDragDistance = f2;
    }

    private void setRefreshing(boolean z, boolean z2) {
        if (this.mRefreshing != z) {
            this.mNotify = z2;
            ensureTarget();
            this.mRefreshing = z;
            if (z) {
                animateOffsetToCorrectPosition(this.mCurrentTargetOffsetTop, this.mRefreshListener);
            } else {
                startScaleDownAnimation(this.mRefreshListener);
            }
        }
    }
}
