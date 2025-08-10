package com.wear.bean.controlmutlitoys;

import androidx.annotation.NonNull;
import com.wear.util.WearUtils;
import io.reactivex.disposables.Disposable;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes3.dex */
public class ControlBallBean implements Serializable, Cloneable {
    public static final int CONTROL_MODE_FLOAT = 1;
    public static final int CONTROL_MODE_FYS = 4;
    public static final int CONTROL_MODE_IDLE = 0;
    public static final int CONTROL_MODE_LOOP = 2;
    public static final int CONTROL_MODE_TRAD = 3;
    private int controlMode;
    private boolean isActivate;
    private boolean isLongPressed;
    private boolean isLooping;
    private boolean isMoving;
    private Disposable longPressedDisposable;
    private int loopIndex;
    private int progress;
    private int size;
    private String id = WearUtils.E();
    private List<BaseBallBean> baseBallBeans = new ArrayList();
    private List<String> datas = new ArrayList();
    private float[] originalLocation = new float[2];
    private float[] currentLocation = new float[2];
    private float[] lastDownLocation = new float[2];

    @NonNull
    @NotNull
    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public ControlBallBean m81clone() throws CloneNotSupportedException {
        return this;
    }

    public List<BaseBallBean> getBaseBallBeans() {
        return this.baseBallBeans;
    }

    public int getControlMode() {
        return this.controlMode;
    }

    public float[] getCurrentLocation() {
        return this.currentLocation;
    }

    public List<String> getDatas() {
        return this.datas;
    }

    public String getId() {
        return this.id;
    }

    public float[] getLastDownLocation() {
        return this.lastDownLocation;
    }

    public Disposable getLongPressedDisposable() {
        return this.longPressedDisposable;
    }

    public int getLoopIndex() {
        return this.loopIndex;
    }

    public float[] getOriginalLocation() {
        return this.originalLocation;
    }

    public int getProgress() {
        return this.progress;
    }

    public int getSize() {
        return this.size;
    }

    public boolean isActivate() {
        return this.isActivate;
    }

    public boolean isFunction() {
        List<BaseBallBean> list = this.baseBallBeans;
        if (list == null || list.size() <= 0) {
            return false;
        }
        return this.baseBallBeans.get(0).isFunction();
    }

    public boolean isLongPressed() {
        return this.isLongPressed;
    }

    public boolean isLooping() {
        return this.isLooping;
    }

    public boolean isMergeBall() {
        return this.baseBallBeans.size() > 1;
    }

    public boolean isMoving() {
        return this.isMoving;
    }

    public void resetCurrentLocation() {
        float[] fArr = this.currentLocation;
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
    }

    public void resetLastDownLocation() {
        float[] fArr = this.lastDownLocation;
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
    }

    public void setActivate(boolean z) {
        this.isActivate = z;
    }

    public void setBaseBallBeans(List<BaseBallBean> list) {
        this.baseBallBeans = list;
    }

    public void setControlMode(int i) {
        this.controlMode = i;
    }

    public void setCurrentLocation(float[] fArr) {
        this.currentLocation = fArr;
    }

    public void setDatas(List<String> list) {
        this.datas = list;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setLastDownLocation(float[] fArr) {
        this.lastDownLocation = fArr;
    }

    public void setLongPressed(boolean z) {
        this.isLongPressed = z;
    }

    public void setLongPressedDisposable(Disposable disposable) {
        this.longPressedDisposable = disposable;
    }

    public void setLoopIndex(int i) {
        this.loopIndex = i;
    }

    public void setLooping(boolean z) {
        this.isLooping = z;
    }

    public void setMoving(boolean z) {
        this.isMoving = z;
    }

    public void setOriginalLocation(float[] fArr) {
        this.originalLocation = fArr;
    }

    public void setProgress(int i) {
        this.progress = i;
    }

    public void setSize(int i) {
        this.size = i;
    }
}
