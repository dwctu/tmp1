package com.wear.net.model;

import androidx.exifinterface.media.ExifInterface;
import com.lovense.wear.R;
import com.wear.net.model.RemoteResponse;
import dc.sg3;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: RemoteResponse.kt */
@Metadata(d1 = {"\u0000 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u001a\"\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0006\b\u0000\u0010\u0001\u0018\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u0002H\u0086\b¢\u0006\u0002\u0010\u0003\u001a:\u0010\u0004\u001a\u00020\u0005\"\u0006\b\u0000\u0010\u0001\u0018\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u0002H\u0086\b\u0082\u0002\u001c\n\f\b\u0000\u0012\u0002\u0018\u0000\u001a\u0004\u0010\u0000(\u0000\n\f\b\u0000\u0012\u0002\u0018\u0001\u001a\u0004\u0010\u0000(\u0001\u001a\n\u0010\b\u001a\u00020\t*\u00020\u0007ò\u0001\u000e\n\b\u0012\u0004\u0012\u00028\u00000\u0006\n\u00020\u0007¨\u0006\n"}, d2 = {"data", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/wear/net/model/RemoteResponse;", "(Lcom/wear/net/model/RemoteResponse;)Ljava/lang/Object;", "isSuccess", "", "Lcom/wear/net/model/RemoteResponse$Success;", "Lcom/wear/net/model/RemoteResponse$Error;", "showToast", "", "app_marketRelease"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class RemoteResponseKt {
    public static final /* synthetic */ <T> T data(RemoteResponse<? extends T> remoteResponse) {
        Intrinsics.checkNotNullParameter(remoteResponse, "<this>");
        if (remoteResponse instanceof RemoteResponse.Success) {
            return (T) ((RemoteResponse.Success) remoteResponse).getData();
        }
        return null;
    }

    public static final /* synthetic */ <T> boolean isSuccess(RemoteResponse<? extends T> remoteResponse) {
        Intrinsics.checkNotNullParameter(remoteResponse, "<this>");
        return remoteResponse instanceof RemoteResponse.Success;
    }

    public static final void showToast(@NotNull RemoteResponse.Error error) {
        Intrinsics.checkNotNullParameter(error, "<this>");
        if (error.getCode() != null) {
            String message = error.getMessage();
            if (!(message == null || message.length() == 0)) {
                sg3.l(error.getMessage());
                return;
            }
        }
        sg3.h(R.string.common_netError);
    }
}
