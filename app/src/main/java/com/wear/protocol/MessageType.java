package com.wear.protocol;

import java.util.Locale;

/* loaded from: classes3.dex */
public enum MessageType {
    chat,
    toy,
    pattern,
    audio,
    picture,
    alarm,
    live,
    sync,
    video,
    system,
    partnertoy,
    alexa,
    voice,
    test,
    shortvideo,
    unsupport,
    controllink,
    controllinktimer,
    wishlist,
    burnpicture,
    burnvideo,
    giftcard,
    vmsharecard;

    public static MessageType fromString(String str) {
        str.hashCode();
        switch (str) {
            case "mysendpattern":
            case "resendpattern":
            case "mysendpattern111":
                str = "pattern";
                break;
        }
        return valueOf(str.toLowerCase(Locale.US));
    }
}
