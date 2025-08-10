package com.wear.bean;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: ChatStatus.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0005\u0003\u0004\u0005\u0006\u0007B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0005\b\t\n\u000b\f¨\u0006\r"}, d2 = {"Lcom/wear/bean/AudioRecordStatus;", "", "()V", "Idle", "RecordingCancelChange", "RecordingTimeUpdate", "StartRecord", "StopRecord", "Lcom/wear/bean/AudioRecordStatus$Idle;", "Lcom/wear/bean/AudioRecordStatus$RecordingCancelChange;", "Lcom/wear/bean/AudioRecordStatus$RecordingTimeUpdate;", "Lcom/wear/bean/AudioRecordStatus$StartRecord;", "Lcom/wear/bean/AudioRecordStatus$StopRecord;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public abstract class AudioRecordStatus {

    /* compiled from: ChatStatus.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/wear/bean/AudioRecordStatus$Idle;", "Lcom/wear/bean/AudioRecordStatus;", "()V", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Idle extends AudioRecordStatus {

        @NotNull
        public static final Idle INSTANCE = new Idle();

        private Idle() {
            super(null);
        }
    }

    /* compiled from: ChatStatus.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/wear/bean/AudioRecordStatus$RecordingCancelChange;", "Lcom/wear/bean/AudioRecordStatus;", "isCancel", "", "(Z)V", "()Z", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class RecordingCancelChange extends AudioRecordStatus {
        private final boolean isCancel;

        public RecordingCancelChange(boolean z) {
            super(null);
            this.isCancel = z;
        }

        /* renamed from: isCancel, reason: from getter */
        public final boolean getIsCancel() {
            return this.isCancel;
        }
    }

    /* compiled from: ChatStatus.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/wear/bean/AudioRecordStatus$RecordingTimeUpdate;", "Lcom/wear/bean/AudioRecordStatus;", "timeCount", "", "(I)V", "getTimeCount", "()I", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class RecordingTimeUpdate extends AudioRecordStatus {
        private final int timeCount;

        public RecordingTimeUpdate(int i) {
            super(null);
            this.timeCount = i;
        }

        public final int getTimeCount() {
            return this.timeCount;
        }
    }

    /* compiled from: ChatStatus.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/wear/bean/AudioRecordStatus$StartRecord;", "Lcom/wear/bean/AudioRecordStatus;", "()V", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class StartRecord extends AudioRecordStatus {

        @NotNull
        public static final StartRecord INSTANCE = new StartRecord();

        private StartRecord() {
            super(null);
        }
    }

    /* compiled from: ChatStatus.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/wear/bean/AudioRecordStatus$StopRecord;", "Lcom/wear/bean/AudioRecordStatus;", "()V", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class StopRecord extends AudioRecordStatus {

        @NotNull
        public static final StopRecord INSTANCE = new StopRecord();

        private StopRecord() {
            super(null);
        }
    }

    private AudioRecordStatus() {
    }

    public /* synthetic */ AudioRecordStatus(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
