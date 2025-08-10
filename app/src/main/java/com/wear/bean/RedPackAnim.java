package com.wear.bean;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import androidx.constraintlayout.motion.widget.Key;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: PackAnim.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0018\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u001dH\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0015\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001e"}, d2 = {"Lcom/wear/bean/RedPackAnim;", "Landroid/view/animation/Animation;", "path", "Landroid/graphics/Path;", Key.ROTATION, "", "view", "Landroid/view/View;", "(Landroid/graphics/Path;FLandroid/view/View;)V", "getPath", "()Landroid/graphics/Path;", "pathMeasure", "Landroid/graphics/PathMeasure;", "getPathMeasure", "()Landroid/graphics/PathMeasure;", "point", "", "getPoint", "()[F", "getRotation", "()F", "tan", "getTan", "getView", "()Landroid/view/View;", "applyTransformation", "", "interpolatedTime", "t", "Landroid/view/animation/Transformation;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class RedPackAnim extends Animation {

    @NotNull
    private final Path path;

    @NotNull
    private final PathMeasure pathMeasure;

    @NotNull
    private final float[] point;
    private final float rotation;

    @NotNull
    private final float[] tan;

    @NotNull
    private final View view;

    public RedPackAnim(@NotNull Path path, float f, @NotNull View view) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(view, "view");
        this.path = path;
        this.rotation = f;
        this.view = view;
        this.pathMeasure = new PathMeasure(path, false);
        this.point = new float[2];
        this.tan = new float[2];
    }

    @Override // android.view.animation.Animation
    public void applyTransformation(float interpolatedTime, @NotNull Transformation t) {
        Intrinsics.checkNotNullParameter(t, "t");
        PathMeasure pathMeasure = this.pathMeasure;
        pathMeasure.getPosTan(pathMeasure.getLength() * interpolatedTime, this.point, this.tan);
        this.view.setX(this.point[0] - (r5.getMeasuredWidth() / 2));
        this.view.setY(this.point[1]);
        this.view.setRotation(this.rotation * interpolatedTime);
    }

    @NotNull
    public final Path getPath() {
        return this.path;
    }

    @NotNull
    public final PathMeasure getPathMeasure() {
        return this.pathMeasure;
    }

    @NotNull
    public final float[] getPoint() {
        return this.point;
    }

    public final float getRotation() {
        return this.rotation;
    }

    @NotNull
    public final float[] getTan() {
        return this.tan;
    }

    @NotNull
    public final View getView() {
        return this.view;
    }
}
