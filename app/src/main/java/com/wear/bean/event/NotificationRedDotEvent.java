package com.wear.bean.event;

import android.app.Application;
import com.wear.bean.TestValue;

/* loaded from: classes3.dex */
public class NotificationRedDotEvent {
    public Application application;
    public TestValue testValue;

    public NotificationRedDotEvent(TestValue testValue, Application application) {
        this.testValue = testValue;
        this.application = application;
    }

    public Application getApplication() {
        return this.application;
    }

    public TestValue getTestValue() {
        return this.testValue;
    }

    public void setApplication(Application application) {
        this.application = application;
    }

    public void setTestValue(TestValue testValue) {
        this.testValue = testValue;
    }

    public NotificationRedDotEvent() {
    }
}
