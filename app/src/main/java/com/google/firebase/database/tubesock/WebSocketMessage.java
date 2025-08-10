package com.google.firebase.database.tubesock;

/* loaded from: classes2.dex */
public class WebSocketMessage {
    private byte[] byteMessage;
    private byte opcode = 1;
    private String stringMessage;

    public WebSocketMessage(byte[] bArr) {
        this.byteMessage = bArr;
    }

    public byte[] getBytes() {
        return this.byteMessage;
    }

    public String getText() {
        return this.stringMessage;
    }

    public boolean isBinary() {
        return this.opcode == 2;
    }

    public boolean isText() {
        return this.opcode == 1;
    }

    public WebSocketMessage(String str) {
        this.stringMessage = str;
    }
}
