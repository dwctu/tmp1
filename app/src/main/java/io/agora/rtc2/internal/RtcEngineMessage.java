package io.agora.rtc2.internal;

import android.text.TextUtils;
import com.google.common.primitives.UnsignedInts;
import io.agora.rtc2.Constants;
import io.agora.rtc2.IRtcEngineEventHandler;
import io.agora.rtc2.LocalTranscoderConfiguration;
import io.agora.rtc2.live.LiveInjectStreamConfig;
import io.agora.rtc2.live.LiveTranscoding;
import io.agora.rtc2.video.AgoraImage;
import io.agora.rtc2.video.ContentInspectConfig;
import io.agora.rtc2.video.VideoCompositingLayout;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes4.dex */
public class RtcEngineMessage {

    public static class PActiveSpeaker extends Marshallable {
        public int uid;

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void clear() {
            super.clear();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ ByteBuffer getBuffer() {
            return super.getBuffer();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void marshall(ByteBuffer byteBuffer) {
            super.marshall(byteBuffer);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public byte[] marshall() {
            return super.marshall();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popAll() {
            return super.popAll();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ Boolean popBool() {
            return super.popBool();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte popByte() {
            return super.popByte();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes() {
            return super.popBytes();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes32() {
            return super.popBytes32();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ double popDouble() {
            return super.popDouble();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ int popInt() {
            return super.popInt();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ long popInt64() {
            return super.popInt64();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ int[] popIntArray() {
            return super.popIntArray();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ short popShort() {
            return super.popShort();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ short[] popShortArray() {
            return super.popShortArray();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16() {
            return super.popString16();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16UTF8() {
            return super.popString16UTF8();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBool(Boolean bool) {
            super.pushBool(bool);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushByte(byte b) {
            super.pushByte(b);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes(byte[] bArr) {
            super.pushBytes(bArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes32(byte[] bArr) {
            super.pushBytes32(bArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushDouble(double d) {
            super.pushDouble(d);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt(int i) {
            super.pushInt(i);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt64(long j) {
            super.pushInt64(j);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(int[] iArr) {
            super.pushIntArray(iArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(Integer[] numArr) {
            super.pushIntArray(numArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShort(short s) {
            super.pushShort(s);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShortArray(short[] sArr) {
            super.pushShortArray(sArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushString16(String str) {
            super.pushString16(str);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushStringArray(ArrayList arrayList) {
            super.pushStringArray(arrayList);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void unmarshall(ByteBuffer byteBuffer) {
            super.unmarshall(byteBuffer);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.uid = popInt();
        }
    }

    public static class PAudioMixingPositionChanged extends Marshallable {
        public long position;

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void clear() {
            super.clear();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ ByteBuffer getBuffer() {
            return super.getBuffer();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void marshall(ByteBuffer byteBuffer) {
            super.marshall(byteBuffer);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public byte[] marshall() {
            return super.marshall();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popAll() {
            return super.popAll();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ Boolean popBool() {
            return super.popBool();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte popByte() {
            return super.popByte();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes() {
            return super.popBytes();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes32() {
            return super.popBytes32();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ double popDouble() {
            return super.popDouble();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ int popInt() {
            return super.popInt();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ long popInt64() {
            return super.popInt64();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ int[] popIntArray() {
            return super.popIntArray();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ short popShort() {
            return super.popShort();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ short[] popShortArray() {
            return super.popShortArray();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16() {
            return super.popString16();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16UTF8() {
            return super.popString16UTF8();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBool(Boolean bool) {
            super.pushBool(bool);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushByte(byte b) {
            super.pushByte(b);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes(byte[] bArr) {
            super.pushBytes(bArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes32(byte[] bArr) {
            super.pushBytes32(bArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushDouble(double d) {
            super.pushDouble(d);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt(int i) {
            super.pushInt(i);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt64(long j) {
            super.pushInt64(j);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(int[] iArr) {
            super.pushIntArray(iArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(Integer[] numArr) {
            super.pushIntArray(numArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShort(short s) {
            super.pushShort(s);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShortArray(short[] sArr) {
            super.pushShortArray(sArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushString16(String str) {
            super.pushString16(str);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushStringArray(ArrayList arrayList) {
            super.pushStringArray(arrayList);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void unmarshall(ByteBuffer byteBuffer) {
            super.unmarshall(byteBuffer);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.position = popInt64();
        }
    }

    public static class PAudioMixingStateChanged extends Marshallable {
        public int reasonCode;
        public int state;

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void clear() {
            super.clear();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ ByteBuffer getBuffer() {
            return super.getBuffer();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void marshall(ByteBuffer byteBuffer) {
            super.marshall(byteBuffer);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public byte[] marshall() {
            return super.marshall();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popAll() {
            return super.popAll();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ Boolean popBool() {
            return super.popBool();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte popByte() {
            return super.popByte();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes() {
            return super.popBytes();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes32() {
            return super.popBytes32();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ double popDouble() {
            return super.popDouble();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ int popInt() {
            return super.popInt();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ long popInt64() {
            return super.popInt64();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ int[] popIntArray() {
            return super.popIntArray();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ short popShort() {
            return super.popShort();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ short[] popShortArray() {
            return super.popShortArray();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16() {
            return super.popString16();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16UTF8() {
            return super.popString16UTF8();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBool(Boolean bool) {
            super.pushBool(bool);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushByte(byte b) {
            super.pushByte(b);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes(byte[] bArr) {
            super.pushBytes(bArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes32(byte[] bArr) {
            super.pushBytes32(bArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushDouble(double d) {
            super.pushDouble(d);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt(int i) {
            super.pushInt(i);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt64(long j) {
            super.pushInt64(j);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(int[] iArr) {
            super.pushIntArray(iArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(Integer[] numArr) {
            super.pushIntArray(numArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShort(short s) {
            super.pushShort(s);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShortArray(short[] sArr) {
            super.pushShortArray(sArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushString16(String str) {
            super.pushString16(str);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushStringArray(ArrayList arrayList) {
            super.pushStringArray(arrayList);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void unmarshall(ByteBuffer byteBuffer) {
            super.unmarshall(byteBuffer);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.state = popInt();
            this.reasonCode = popInt();
        }
    }

    public static class PAudioRoutingChanged extends Marshallable {
        public int routing;

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void clear() {
            super.clear();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ ByteBuffer getBuffer() {
            return super.getBuffer();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void marshall(ByteBuffer byteBuffer) {
            super.marshall(byteBuffer);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public byte[] marshall() {
            return super.marshall();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popAll() {
            return super.popAll();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ Boolean popBool() {
            return super.popBool();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte popByte() {
            return super.popByte();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes() {
            return super.popBytes();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes32() {
            return super.popBytes32();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ double popDouble() {
            return super.popDouble();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ int popInt() {
            return super.popInt();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ long popInt64() {
            return super.popInt64();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ int[] popIntArray() {
            return super.popIntArray();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ short popShort() {
            return super.popShort();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ short[] popShortArray() {
            return super.popShortArray();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16() {
            return super.popString16();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16UTF8() {
            return super.popString16UTF8();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBool(Boolean bool) {
            super.pushBool(bool);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushByte(byte b) {
            super.pushByte(b);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes(byte[] bArr) {
            super.pushBytes(bArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes32(byte[] bArr) {
            super.pushBytes32(bArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushDouble(double d) {
            super.pushDouble(d);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt(int i) {
            super.pushInt(i);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt64(long j) {
            super.pushInt64(j);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(int[] iArr) {
            super.pushIntArray(iArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(Integer[] numArr) {
            super.pushIntArray(numArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShort(short s) {
            super.pushShort(s);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShortArray(short[] sArr) {
            super.pushShortArray(sArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushString16(String str) {
            super.pushString16(str);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushStringArray(ArrayList arrayList) {
            super.pushStringArray(arrayList);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void unmarshall(ByteBuffer byteBuffer) {
            super.unmarshall(byteBuffer);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.routing = popInt();
        }
    }

    public static class PCameraExposureAreaChanged extends Marshallable {
        public int height;
        public int width;
        public int x;
        public int y;

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void clear() {
            super.clear();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ ByteBuffer getBuffer() {
            return super.getBuffer();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void marshall(ByteBuffer byteBuffer) {
            super.marshall(byteBuffer);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public byte[] marshall() {
            pushInt(this.x);
            pushInt(this.y);
            pushInt(this.width);
            pushInt(this.height);
            return super.marshall();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popAll() {
            return super.popAll();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ Boolean popBool() {
            return super.popBool();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte popByte() {
            return super.popByte();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes() {
            return super.popBytes();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes32() {
            return super.popBytes32();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ double popDouble() {
            return super.popDouble();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ int popInt() {
            return super.popInt();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ long popInt64() {
            return super.popInt64();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ int[] popIntArray() {
            return super.popIntArray();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ short popShort() {
            return super.popShort();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ short[] popShortArray() {
            return super.popShortArray();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16() {
            return super.popString16();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16UTF8() {
            return super.popString16UTF8();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBool(Boolean bool) {
            super.pushBool(bool);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushByte(byte b) {
            super.pushByte(b);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes(byte[] bArr) {
            super.pushBytes(bArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes32(byte[] bArr) {
            super.pushBytes32(bArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushDouble(double d) {
            super.pushDouble(d);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt(int i) {
            super.pushInt(i);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt64(long j) {
            super.pushInt64(j);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(int[] iArr) {
            super.pushIntArray(iArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(Integer[] numArr) {
            super.pushIntArray(numArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShort(short s) {
            super.pushShort(s);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShortArray(short[] sArr) {
            super.pushShortArray(sArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushString16(String str) {
            super.pushString16(str);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushStringArray(ArrayList arrayList) {
            super.pushStringArray(arrayList);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void unmarshall(ByteBuffer byteBuffer) {
            super.unmarshall(byteBuffer);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.x = popInt();
            this.y = popInt();
            this.width = popInt();
            this.height = popInt();
        }
    }

    public static class PCameraFocusAreaChanged extends Marshallable {
        public int height;
        public int width;
        public int x;
        public int y;

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void clear() {
            super.clear();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ ByteBuffer getBuffer() {
            return super.getBuffer();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void marshall(ByteBuffer byteBuffer) {
            super.marshall(byteBuffer);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public byte[] marshall() {
            pushInt(this.x);
            pushInt(this.y);
            pushInt(this.width);
            pushInt(this.height);
            return super.marshall();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popAll() {
            return super.popAll();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ Boolean popBool() {
            return super.popBool();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte popByte() {
            return super.popByte();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes() {
            return super.popBytes();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes32() {
            return super.popBytes32();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ double popDouble() {
            return super.popDouble();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ int popInt() {
            return super.popInt();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ long popInt64() {
            return super.popInt64();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ int[] popIntArray() {
            return super.popIntArray();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ short popShort() {
            return super.popShort();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ short[] popShortArray() {
            return super.popShortArray();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16() {
            return super.popString16();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16UTF8() {
            return super.popString16UTF8();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBool(Boolean bool) {
            super.pushBool(bool);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushByte(byte b) {
            super.pushByte(b);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes(byte[] bArr) {
            super.pushBytes(bArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes32(byte[] bArr) {
            super.pushBytes32(bArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushDouble(double d) {
            super.pushDouble(d);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt(int i) {
            super.pushInt(i);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt64(long j) {
            super.pushInt64(j);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(int[] iArr) {
            super.pushIntArray(iArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(Integer[] numArr) {
            super.pushIntArray(numArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShort(short s) {
            super.pushShort(s);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShortArray(short[] sArr) {
            super.pushShortArray(sArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushString16(String str) {
            super.pushString16(str);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushStringArray(ArrayList arrayList) {
            super.pushStringArray(arrayList);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void unmarshall(ByteBuffer byteBuffer) {
            super.unmarshall(byteBuffer);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.x = popInt();
            this.y = popInt();
            this.width = popInt();
            this.height = popInt();
        }
    }

    public static class PClientRoleChangeFailed extends Marshallable {
        public int currentRole;
        public int reason;

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void clear() {
            super.clear();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ ByteBuffer getBuffer() {
            return super.getBuffer();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void marshall(ByteBuffer byteBuffer) {
            super.marshall(byteBuffer);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public byte[] marshall() {
            return super.marshall();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popAll() {
            return super.popAll();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ Boolean popBool() {
            return super.popBool();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte popByte() {
            return super.popByte();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes() {
            return super.popBytes();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes32() {
            return super.popBytes32();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ double popDouble() {
            return super.popDouble();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ int popInt() {
            return super.popInt();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ long popInt64() {
            return super.popInt64();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ int[] popIntArray() {
            return super.popIntArray();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ short popShort() {
            return super.popShort();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ short[] popShortArray() {
            return super.popShortArray();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16() {
            return super.popString16();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16UTF8() {
            return super.popString16UTF8();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBool(Boolean bool) {
            super.pushBool(bool);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushByte(byte b) {
            super.pushByte(b);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes(byte[] bArr) {
            super.pushBytes(bArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes32(byte[] bArr) {
            super.pushBytes32(bArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushDouble(double d) {
            super.pushDouble(d);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt(int i) {
            super.pushInt(i);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt64(long j) {
            super.pushInt64(j);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(int[] iArr) {
            super.pushIntArray(iArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(Integer[] numArr) {
            super.pushIntArray(numArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShort(short s) {
            super.pushShort(s);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShortArray(short[] sArr) {
            super.pushShortArray(sArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushString16(String str) {
            super.pushString16(str);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushStringArray(ArrayList arrayList) {
            super.pushStringArray(arrayList);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void unmarshall(ByteBuffer byteBuffer) {
            super.unmarshall(byteBuffer);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.reason = popInt();
            this.currentRole = popInt();
        }
    }

    public static class PClientRoleChanged extends Marshallable {
        public int newRole;
        public int newRoleLatencyLevel;
        public int oldRole;

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void clear() {
            super.clear();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ ByteBuffer getBuffer() {
            return super.getBuffer();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void marshall(ByteBuffer byteBuffer) {
            super.marshall(byteBuffer);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public byte[] marshall() {
            return super.marshall();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popAll() {
            return super.popAll();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ Boolean popBool() {
            return super.popBool();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte popByte() {
            return super.popByte();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes() {
            return super.popBytes();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes32() {
            return super.popBytes32();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ double popDouble() {
            return super.popDouble();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ int popInt() {
            return super.popInt();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ long popInt64() {
            return super.popInt64();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ int[] popIntArray() {
            return super.popIntArray();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ short popShort() {
            return super.popShort();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ short[] popShortArray() {
            return super.popShortArray();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16() {
            return super.popString16();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16UTF8() {
            return super.popString16UTF8();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBool(Boolean bool) {
            super.pushBool(bool);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushByte(byte b) {
            super.pushByte(b);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes(byte[] bArr) {
            super.pushBytes(bArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes32(byte[] bArr) {
            super.pushBytes32(bArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushDouble(double d) {
            super.pushDouble(d);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt(int i) {
            super.pushInt(i);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt64(long j) {
            super.pushInt64(j);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(int[] iArr) {
            super.pushIntArray(iArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(Integer[] numArr) {
            super.pushIntArray(numArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShort(short s) {
            super.pushShort(s);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShortArray(short[] sArr) {
            super.pushShortArray(sArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushString16(String str) {
            super.pushString16(str);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushStringArray(ArrayList arrayList) {
            super.pushStringArray(arrayList);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void unmarshall(ByteBuffer byteBuffer) {
            super.unmarshall(byteBuffer);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.oldRole = popInt();
            this.newRole = popInt();
            this.newRoleLatencyLevel = popInt();
        }
    }

    public static class PConnectionState extends Marshallable {
        public int reason;
        public int state;

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void clear() {
            super.clear();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ ByteBuffer getBuffer() {
            return super.getBuffer();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void marshall(ByteBuffer byteBuffer) {
            super.marshall(byteBuffer);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public byte[] marshall() {
            pushInt(this.state);
            pushInt(this.reason);
            return super.marshall();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popAll() {
            return super.popAll();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ Boolean popBool() {
            return super.popBool();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte popByte() {
            return super.popByte();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes() {
            return super.popBytes();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes32() {
            return super.popBytes32();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ double popDouble() {
            return super.popDouble();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ int popInt() {
            return super.popInt();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ long popInt64() {
            return super.popInt64();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ int[] popIntArray() {
            return super.popIntArray();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ short popShort() {
            return super.popShort();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ short[] popShortArray() {
            return super.popShortArray();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16() {
            return super.popString16();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16UTF8() {
            return super.popString16UTF8();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBool(Boolean bool) {
            super.pushBool(bool);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushByte(byte b) {
            super.pushByte(b);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes(byte[] bArr) {
            super.pushBytes(bArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes32(byte[] bArr) {
            super.pushBytes32(bArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushDouble(double d) {
            super.pushDouble(d);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt(int i) {
            super.pushInt(i);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt64(long j) {
            super.pushInt64(j);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(int[] iArr) {
            super.pushIntArray(iArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(Integer[] numArr) {
            super.pushIntArray(numArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShort(short s) {
            super.pushShort(s);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShortArray(short[] sArr) {
            super.pushShortArray(sArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushString16(String str) {
            super.pushString16(str);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushStringArray(ArrayList arrayList) {
            super.pushStringArray(arrayList);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void unmarshall(ByteBuffer byteBuffer) {
            super.unmarshall(byteBuffer);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.state = popInt();
            this.reason = popInt();
        }
    }

    public static class PContentInspectConfig extends Marshallable {
        private void marshall(Marshallable marshallable, ContentInspectConfig contentInspectConfig) {
            int i;
            if (contentInspectConfig == null || (i = contentInspectConfig.moduleCount) <= 0 || i > 32) {
                return;
            }
            marshallable.pushString16(contentInspectConfig.extraInfo);
            pushShort((short) contentInspectConfig.moduleCount);
            for (int i2 = 0; i2 < contentInspectConfig.moduleCount; i2++) {
                marshallable.pushInt(contentInspectConfig.modules[i2].type);
                marshallable.pushInt(contentInspectConfig.modules[i2].interval);
            }
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void clear() {
            super.clear();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ ByteBuffer getBuffer() {
            return super.getBuffer();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void marshall(ByteBuffer byteBuffer) {
            super.marshall(byteBuffer);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] marshall() {
            return super.marshall();
        }

        public byte[] marshall(ContentInspectConfig contentInspectConfig) {
            marshall(this, contentInspectConfig);
            return super.marshall();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popAll() {
            return super.popAll();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ Boolean popBool() {
            return super.popBool();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte popByte() {
            return super.popByte();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes() {
            return super.popBytes();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes32() {
            return super.popBytes32();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ double popDouble() {
            return super.popDouble();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ int popInt() {
            return super.popInt();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ long popInt64() {
            return super.popInt64();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ int[] popIntArray() {
            return super.popIntArray();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ short popShort() {
            return super.popShort();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ short[] popShortArray() {
            return super.popShortArray();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16() {
            return super.popString16();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16UTF8() {
            return super.popString16UTF8();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBool(Boolean bool) {
            super.pushBool(bool);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushByte(byte b) {
            super.pushByte(b);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes(byte[] bArr) {
            super.pushBytes(bArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes32(byte[] bArr) {
            super.pushBytes32(bArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushDouble(double d) {
            super.pushDouble(d);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt(int i) {
            super.pushInt(i);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt64(long j) {
            super.pushInt64(j);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(int[] iArr) {
            super.pushIntArray(iArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(Integer[] numArr) {
            super.pushIntArray(numArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShort(short s) {
            super.pushShort(s);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShortArray(short[] sArr) {
            super.pushShortArray(sArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushString16(String str) {
            super.pushString16(str);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushStringArray(ArrayList arrayList) {
            super.pushStringArray(arrayList);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void unmarshall(ByteBuffer byteBuffer) {
            super.unmarshall(byteBuffer);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
        }
    }

    public static class PContentInspectResult extends Marshallable {
        public int result;

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void clear() {
            super.clear();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ ByteBuffer getBuffer() {
            return super.getBuffer();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void marshall(ByteBuffer byteBuffer) {
            super.marshall(byteBuffer);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public byte[] marshall() {
            pushInt(this.result);
            return super.marshall();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popAll() {
            return super.popAll();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ Boolean popBool() {
            return super.popBool();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte popByte() {
            return super.popByte();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes() {
            return super.popBytes();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes32() {
            return super.popBytes32();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ double popDouble() {
            return super.popDouble();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ int popInt() {
            return super.popInt();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ long popInt64() {
            return super.popInt64();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ int[] popIntArray() {
            return super.popIntArray();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ short popShort() {
            return super.popShort();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ short[] popShortArray() {
            return super.popShortArray();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16() {
            return super.popString16();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16UTF8() {
            return super.popString16UTF8();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBool(Boolean bool) {
            super.pushBool(bool);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushByte(byte b) {
            super.pushByte(b);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes(byte[] bArr) {
            super.pushBytes(bArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes32(byte[] bArr) {
            super.pushBytes32(bArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushDouble(double d) {
            super.pushDouble(d);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt(int i) {
            super.pushInt(i);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt64(long j) {
            super.pushInt64(j);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(int[] iArr) {
            super.pushIntArray(iArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(Integer[] numArr) {
            super.pushIntArray(numArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShort(short s) {
            super.pushShort(s);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShortArray(short[] sArr) {
            super.pushShortArray(sArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushString16(String str) {
            super.pushString16(str);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushStringArray(ArrayList arrayList) {
            super.pushStringArray(arrayList);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void unmarshall(ByteBuffer byteBuffer) {
            super.unmarshall(byteBuffer);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.result = popInt();
        }
    }

    public static class PCrossChannelEvent extends Marshallable {
        public int code;

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void clear() {
            super.clear();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ ByteBuffer getBuffer() {
            return super.getBuffer();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void marshall(ByteBuffer byteBuffer) {
            super.marshall(byteBuffer);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public byte[] marshall() {
            pushInt(this.code);
            return super.marshall();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popAll() {
            return super.popAll();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ Boolean popBool() {
            return super.popBool();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte popByte() {
            return super.popByte();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes() {
            return super.popBytes();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes32() {
            return super.popBytes32();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ double popDouble() {
            return super.popDouble();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ int popInt() {
            return super.popInt();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ long popInt64() {
            return super.popInt64();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ int[] popIntArray() {
            return super.popIntArray();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ short popShort() {
            return super.popShort();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ short[] popShortArray() {
            return super.popShortArray();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16() {
            return super.popString16();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16UTF8() {
            return super.popString16UTF8();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBool(Boolean bool) {
            super.pushBool(bool);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushByte(byte b) {
            super.pushByte(b);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes(byte[] bArr) {
            super.pushBytes(bArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes32(byte[] bArr) {
            super.pushBytes32(bArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushDouble(double d) {
            super.pushDouble(d);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt(int i) {
            super.pushInt(i);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt64(long j) {
            super.pushInt64(j);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(int[] iArr) {
            super.pushIntArray(iArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(Integer[] numArr) {
            super.pushIntArray(numArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShort(short s) {
            super.pushShort(s);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShortArray(short[] sArr) {
            super.pushShortArray(sArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushString16(String str) {
            super.pushString16(str);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushStringArray(ArrayList arrayList) {
            super.pushStringArray(arrayList);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void unmarshall(ByteBuffer byteBuffer) {
            super.unmarshall(byteBuffer);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.code = popInt();
        }
    }

    public static class PCrossChannelState extends Marshallable {
        public int code;
        public int state;

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void clear() {
            super.clear();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ ByteBuffer getBuffer() {
            return super.getBuffer();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void marshall(ByteBuffer byteBuffer) {
            super.marshall(byteBuffer);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public byte[] marshall() {
            pushInt(this.state);
            pushInt(this.code);
            return super.marshall();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popAll() {
            return super.popAll();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ Boolean popBool() {
            return super.popBool();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte popByte() {
            return super.popByte();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes() {
            return super.popBytes();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes32() {
            return super.popBytes32();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ double popDouble() {
            return super.popDouble();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ int popInt() {
            return super.popInt();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ long popInt64() {
            return super.popInt64();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ int[] popIntArray() {
            return super.popIntArray();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ short popShort() {
            return super.popShort();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ short[] popShortArray() {
            return super.popShortArray();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16() {
            return super.popString16();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16UTF8() {
            return super.popString16UTF8();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBool(Boolean bool) {
            super.pushBool(bool);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushByte(byte b) {
            super.pushByte(b);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes(byte[] bArr) {
            super.pushBytes(bArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes32(byte[] bArr) {
            super.pushBytes32(bArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushDouble(double d) {
            super.pushDouble(d);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt(int i) {
            super.pushInt(i);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt64(long j) {
            super.pushInt64(j);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(int[] iArr) {
            super.pushIntArray(iArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(Integer[] numArr) {
            super.pushIntArray(numArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShort(short s) {
            super.pushShort(s);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShortArray(short[] sArr) {
            super.pushShortArray(sArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushString16(String str) {
            super.pushString16(str);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushStringArray(ArrayList arrayList) {
            super.pushStringArray(arrayList);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void unmarshall(ByteBuffer byteBuffer) {
            super.unmarshall(byteBuffer);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.state = popInt();
            this.code = popInt();
        }
    }

    public static class PDownlinkNetworkInfoUpdated extends Marshallable {
        public int bandwidth_estimation_bps;
        public int lastmile_buffer_delay_time_ms;

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void clear() {
            super.clear();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ ByteBuffer getBuffer() {
            return super.getBuffer();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void marshall(ByteBuffer byteBuffer) {
            super.marshall(byteBuffer);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public byte[] marshall() {
            return super.marshall();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popAll() {
            return super.popAll();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ Boolean popBool() {
            return super.popBool();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte popByte() {
            return super.popByte();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes() {
            return super.popBytes();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes32() {
            return super.popBytes32();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ double popDouble() {
            return super.popDouble();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ int popInt() {
            return super.popInt();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ long popInt64() {
            return super.popInt64();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ int[] popIntArray() {
            return super.popIntArray();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ short popShort() {
            return super.popShort();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ short[] popShortArray() {
            return super.popShortArray();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16() {
            return super.popString16();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16UTF8() {
            return super.popString16UTF8();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBool(Boolean bool) {
            super.pushBool(bool);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushByte(byte b) {
            super.pushByte(b);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes(byte[] bArr) {
            super.pushBytes(bArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes32(byte[] bArr) {
            super.pushBytes32(bArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushDouble(double d) {
            super.pushDouble(d);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt(int i) {
            super.pushInt(i);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt64(long j) {
            super.pushInt64(j);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(int[] iArr) {
            super.pushIntArray(iArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(Integer[] numArr) {
            super.pushIntArray(numArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShort(short s) {
            super.pushShort(s);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShortArray(short[] sArr) {
            super.pushShortArray(sArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushString16(String str) {
            super.pushString16(str);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushStringArray(ArrayList arrayList) {
            super.pushStringArray(arrayList);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void unmarshall(ByteBuffer byteBuffer) {
            super.unmarshall(byteBuffer);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.lastmile_buffer_delay_time_ms = popInt();
            this.bandwidth_estimation_bps = popInt();
        }
    }

    public static class PEncryptionError extends Marshallable {
        public int errorType;

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void clear() {
            super.clear();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ ByteBuffer getBuffer() {
            return super.getBuffer();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void marshall(ByteBuffer byteBuffer) {
            super.marshall(byteBuffer);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public byte[] marshall() {
            pushInt(this.errorType);
            return super.marshall();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popAll() {
            return super.popAll();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ Boolean popBool() {
            return super.popBool();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte popByte() {
            return super.popByte();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes() {
            return super.popBytes();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes32() {
            return super.popBytes32();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ double popDouble() {
            return super.popDouble();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ int popInt() {
            return super.popInt();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ long popInt64() {
            return super.popInt64();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ int[] popIntArray() {
            return super.popIntArray();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ short popShort() {
            return super.popShort();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ short[] popShortArray() {
            return super.popShortArray();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16() {
            return super.popString16();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16UTF8() {
            return super.popString16UTF8();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBool(Boolean bool) {
            super.pushBool(bool);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushByte(byte b) {
            super.pushByte(b);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes(byte[] bArr) {
            super.pushBytes(bArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes32(byte[] bArr) {
            super.pushBytes32(bArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushDouble(double d) {
            super.pushDouble(d);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt(int i) {
            super.pushInt(i);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt64(long j) {
            super.pushInt64(j);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(int[] iArr) {
            super.pushIntArray(iArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(Integer[] numArr) {
            super.pushIntArray(numArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShort(short s) {
            super.pushShort(s);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShortArray(short[] sArr) {
            super.pushShortArray(sArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushString16(String str) {
            super.pushString16(str);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushStringArray(ArrayList arrayList) {
            super.pushStringArray(arrayList);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void unmarshall(ByteBuffer byteBuffer) {
            super.unmarshall(byteBuffer);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.errorType = popInt();
        }
    }

    public static class PError extends Marshallable {
        public int err;

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void clear() {
            super.clear();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ ByteBuffer getBuffer() {
            return super.getBuffer();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void marshall(ByteBuffer byteBuffer) {
            super.marshall(byteBuffer);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public byte[] marshall() {
            return super.marshall();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popAll() {
            return super.popAll();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ Boolean popBool() {
            return super.popBool();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte popByte() {
            return super.popByte();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes() {
            return super.popBytes();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes32() {
            return super.popBytes32();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ double popDouble() {
            return super.popDouble();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ int popInt() {
            return super.popInt();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ long popInt64() {
            return super.popInt64();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ int[] popIntArray() {
            return super.popIntArray();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ short popShort() {
            return super.popShort();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ short[] popShortArray() {
            return super.popShortArray();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16() {
            return super.popString16();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16UTF8() {
            return super.popString16UTF8();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBool(Boolean bool) {
            super.pushBool(bool);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushByte(byte b) {
            super.pushByte(b);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes(byte[] bArr) {
            super.pushBytes(bArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes32(byte[] bArr) {
            super.pushBytes32(bArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushDouble(double d) {
            super.pushDouble(d);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt(int i) {
            super.pushInt(i);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt64(long j) {
            super.pushInt64(j);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(int[] iArr) {
            super.pushIntArray(iArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(Integer[] numArr) {
            super.pushIntArray(numArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShort(short s) {
            super.pushShort(s);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShortArray(short[] sArr) {
            super.pushShortArray(sArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushString16(String str) {
            super.pushString16(str);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushStringArray(ArrayList arrayList) {
            super.pushStringArray(arrayList);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void unmarshall(ByteBuffer byteBuffer) {
            super.unmarshall(byteBuffer);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.err = popInt();
        }
    }

    public static class PFacePositionChanged extends Marshallable {
        public int imageHeight;
        public int imageWidth;
        public int num;
        public FaceRect[] rectArr = null;
        public int[] disArr = null;

        public static class FaceRect {
            public int height;
            public int width;
            public int x;
            public int y;
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void clear() {
            super.clear();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ ByteBuffer getBuffer() {
            return super.getBuffer();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void marshall(ByteBuffer byteBuffer) {
            super.marshall(byteBuffer);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] marshall() {
            return super.marshall();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popAll() {
            return super.popAll();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ Boolean popBool() {
            return super.popBool();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte popByte() {
            return super.popByte();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes() {
            return super.popBytes();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes32() {
            return super.popBytes32();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ double popDouble() {
            return super.popDouble();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ int popInt() {
            return super.popInt();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ long popInt64() {
            return super.popInt64();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ int[] popIntArray() {
            return super.popIntArray();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ short popShort() {
            return super.popShort();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ short[] popShortArray() {
            return super.popShortArray();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16() {
            return super.popString16();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16UTF8() {
            return super.popString16UTF8();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBool(Boolean bool) {
            super.pushBool(bool);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushByte(byte b) {
            super.pushByte(b);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes(byte[] bArr) {
            super.pushBytes(bArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes32(byte[] bArr) {
            super.pushBytes32(bArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushDouble(double d) {
            super.pushDouble(d);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt(int i) {
            super.pushInt(i);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt64(long j) {
            super.pushInt64(j);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(int[] iArr) {
            super.pushIntArray(iArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(Integer[] numArr) {
            super.pushIntArray(numArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShort(short s) {
            super.pushShort(s);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShortArray(short[] sArr) {
            super.pushShortArray(sArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushString16(String str) {
            super.pushString16(str);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushStringArray(ArrayList arrayList) {
            super.pushStringArray(arrayList);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void unmarshall(ByteBuffer byteBuffer) {
            super.unmarshall(byteBuffer);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.imageWidth = popInt();
            this.imageHeight = popInt();
            int iPopShort = popShort();
            if (iPopShort > 0) {
                this.rectArr = new FaceRect[iPopShort];
                for (int i = 0; i < iPopShort; i++) {
                    this.rectArr[i] = new FaceRect();
                    this.rectArr[i].x = popInt();
                    this.rectArr[i].y = popInt();
                    this.rectArr[i].width = popInt();
                    this.rectArr[i].height = popInt();
                }
            }
            int iPopShort2 = popShort();
            if (iPopShort2 > 0) {
                this.disArr = new int[iPopShort2];
                for (int i2 = 0; i2 < iPopShort2; i2++) {
                    this.disArr[i2] = popInt();
                }
            }
        }
    }

    public static class PFirstLocalAudioFrame extends Marshallable {
        public int elapsed;

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void clear() {
            super.clear();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ ByteBuffer getBuffer() {
            return super.getBuffer();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void marshall(ByteBuffer byteBuffer) {
            super.marshall(byteBuffer);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public byte[] marshall() {
            pushInt(this.elapsed);
            return super.marshall();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popAll() {
            return super.popAll();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ Boolean popBool() {
            return super.popBool();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte popByte() {
            return super.popByte();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes() {
            return super.popBytes();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes32() {
            return super.popBytes32();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ double popDouble() {
            return super.popDouble();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ int popInt() {
            return super.popInt();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ long popInt64() {
            return super.popInt64();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ int[] popIntArray() {
            return super.popIntArray();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ short popShort() {
            return super.popShort();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ short[] popShortArray() {
            return super.popShortArray();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16() {
            return super.popString16();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16UTF8() {
            return super.popString16UTF8();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBool(Boolean bool) {
            super.pushBool(bool);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushByte(byte b) {
            super.pushByte(b);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes(byte[] bArr) {
            super.pushBytes(bArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes32(byte[] bArr) {
            super.pushBytes32(bArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushDouble(double d) {
            super.pushDouble(d);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt(int i) {
            super.pushInt(i);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt64(long j) {
            super.pushInt64(j);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(int[] iArr) {
            super.pushIntArray(iArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(Integer[] numArr) {
            super.pushIntArray(numArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShort(short s) {
            super.pushShort(s);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShortArray(short[] sArr) {
            super.pushShortArray(sArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushString16(String str) {
            super.pushString16(str);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushStringArray(ArrayList arrayList) {
            super.pushStringArray(arrayList);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void unmarshall(ByteBuffer byteBuffer) {
            super.unmarshall(byteBuffer);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.elapsed = popInt();
        }
    }

    public static class PFirstLocalVideoFrame extends Marshallable {
        public int elapsed;
        public int height;
        public int source;
        public int width;

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void clear() {
            super.clear();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ ByteBuffer getBuffer() {
            return super.getBuffer();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void marshall(ByteBuffer byteBuffer) {
            super.marshall(byteBuffer);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public byte[] marshall() {
            pushByte((byte) this.source);
            pushInt(this.width);
            pushInt(this.height);
            pushInt(this.elapsed);
            return super.marshall();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popAll() {
            return super.popAll();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ Boolean popBool() {
            return super.popBool();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte popByte() {
            return super.popByte();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes() {
            return super.popBytes();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes32() {
            return super.popBytes32();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ double popDouble() {
            return super.popDouble();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ int popInt() {
            return super.popInt();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ long popInt64() {
            return super.popInt64();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ int[] popIntArray() {
            return super.popIntArray();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ short popShort() {
            return super.popShort();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ short[] popShortArray() {
            return super.popShortArray();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16() {
            return super.popString16();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16UTF8() {
            return super.popString16UTF8();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBool(Boolean bool) {
            super.pushBool(bool);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushByte(byte b) {
            super.pushByte(b);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes(byte[] bArr) {
            super.pushBytes(bArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes32(byte[] bArr) {
            super.pushBytes32(bArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushDouble(double d) {
            super.pushDouble(d);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt(int i) {
            super.pushInt(i);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt64(long j) {
            super.pushInt64(j);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(int[] iArr) {
            super.pushIntArray(iArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(Integer[] numArr) {
            super.pushIntArray(numArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShort(short s) {
            super.pushShort(s);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShortArray(short[] sArr) {
            super.pushShortArray(sArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushString16(String str) {
            super.pushString16(str);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushStringArray(ArrayList arrayList) {
            super.pushStringArray(arrayList);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void unmarshall(ByteBuffer byteBuffer) {
            super.unmarshall(byteBuffer);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.source = popByte();
            this.width = popInt();
            this.height = popInt();
            this.elapsed = popInt();
        }
    }

    public static class PFirstLocalVideoFramePublished extends Marshallable {
        public int elapsed;
        public int source;

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void clear() {
            super.clear();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ ByteBuffer getBuffer() {
            return super.getBuffer();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void marshall(ByteBuffer byteBuffer) {
            super.marshall(byteBuffer);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public byte[] marshall() {
            pushByte((byte) this.source);
            pushInt(this.elapsed);
            return super.marshall();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popAll() {
            return super.popAll();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ Boolean popBool() {
            return super.popBool();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte popByte() {
            return super.popByte();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes() {
            return super.popBytes();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes32() {
            return super.popBytes32();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ double popDouble() {
            return super.popDouble();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ int popInt() {
            return super.popInt();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ long popInt64() {
            return super.popInt64();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ int[] popIntArray() {
            return super.popIntArray();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ short popShort() {
            return super.popShort();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ short[] popShortArray() {
            return super.popShortArray();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16() {
            return super.popString16();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16UTF8() {
            return super.popString16UTF8();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBool(Boolean bool) {
            super.pushBool(bool);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushByte(byte b) {
            super.pushByte(b);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes(byte[] bArr) {
            super.pushBytes(bArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes32(byte[] bArr) {
            super.pushBytes32(bArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushDouble(double d) {
            super.pushDouble(d);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt(int i) {
            super.pushInt(i);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt64(long j) {
            super.pushInt64(j);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(int[] iArr) {
            super.pushIntArray(iArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(Integer[] numArr) {
            super.pushIntArray(numArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShort(short s) {
            super.pushShort(s);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShortArray(short[] sArr) {
            super.pushShortArray(sArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushString16(String str) {
            super.pushString16(str);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushStringArray(ArrayList arrayList) {
            super.pushStringArray(arrayList);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void unmarshall(ByteBuffer byteBuffer) {
            super.unmarshall(byteBuffer);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.source = popByte();
            this.elapsed = popInt();
        }
    }

    public static class PFirstRemoteAudioDecoded extends Marshallable {
        public int elapsed;
        public int uid;

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void clear() {
            super.clear();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ ByteBuffer getBuffer() {
            return super.getBuffer();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void marshall(ByteBuffer byteBuffer) {
            super.marshall(byteBuffer);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public byte[] marshall() {
            pushInt(this.uid);
            pushInt(this.elapsed);
            return super.marshall();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popAll() {
            return super.popAll();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ Boolean popBool() {
            return super.popBool();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte popByte() {
            return super.popByte();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes() {
            return super.popBytes();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes32() {
            return super.popBytes32();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ double popDouble() {
            return super.popDouble();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ int popInt() {
            return super.popInt();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ long popInt64() {
            return super.popInt64();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ int[] popIntArray() {
            return super.popIntArray();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ short popShort() {
            return super.popShort();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ short[] popShortArray() {
            return super.popShortArray();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16() {
            return super.popString16();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16UTF8() {
            return super.popString16UTF8();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBool(Boolean bool) {
            super.pushBool(bool);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushByte(byte b) {
            super.pushByte(b);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes(byte[] bArr) {
            super.pushBytes(bArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes32(byte[] bArr) {
            super.pushBytes32(bArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushDouble(double d) {
            super.pushDouble(d);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt(int i) {
            super.pushInt(i);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt64(long j) {
            super.pushInt64(j);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(int[] iArr) {
            super.pushIntArray(iArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(Integer[] numArr) {
            super.pushIntArray(numArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShort(short s) {
            super.pushShort(s);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShortArray(short[] sArr) {
            super.pushShortArray(sArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushString16(String str) {
            super.pushString16(str);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushStringArray(ArrayList arrayList) {
            super.pushStringArray(arrayList);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void unmarshall(ByteBuffer byteBuffer) {
            super.unmarshall(byteBuffer);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.uid = popInt();
            this.elapsed = popInt();
        }
    }

    public static class PFirstRemoteAudioFrame extends Marshallable {
        public int elapsed;
        public int uid;

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void clear() {
            super.clear();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ ByteBuffer getBuffer() {
            return super.getBuffer();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void marshall(ByteBuffer byteBuffer) {
            super.marshall(byteBuffer);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public byte[] marshall() {
            pushInt(this.uid);
            pushInt(this.elapsed);
            return super.marshall();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popAll() {
            return super.popAll();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ Boolean popBool() {
            return super.popBool();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte popByte() {
            return super.popByte();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes() {
            return super.popBytes();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes32() {
            return super.popBytes32();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ double popDouble() {
            return super.popDouble();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ int popInt() {
            return super.popInt();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ long popInt64() {
            return super.popInt64();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ int[] popIntArray() {
            return super.popIntArray();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ short popShort() {
            return super.popShort();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ short[] popShortArray() {
            return super.popShortArray();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16() {
            return super.popString16();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16UTF8() {
            return super.popString16UTF8();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBool(Boolean bool) {
            super.pushBool(bool);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushByte(byte b) {
            super.pushByte(b);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes(byte[] bArr) {
            super.pushBytes(bArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes32(byte[] bArr) {
            super.pushBytes32(bArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushDouble(double d) {
            super.pushDouble(d);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt(int i) {
            super.pushInt(i);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt64(long j) {
            super.pushInt64(j);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(int[] iArr) {
            super.pushIntArray(iArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(Integer[] numArr) {
            super.pushIntArray(numArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShort(short s) {
            super.pushShort(s);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShortArray(short[] sArr) {
            super.pushShortArray(sArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushString16(String str) {
            super.pushString16(str);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushStringArray(ArrayList arrayList) {
            super.pushStringArray(arrayList);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void unmarshall(ByteBuffer byteBuffer) {
            super.unmarshall(byteBuffer);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.uid = popInt();
            this.elapsed = popInt();
        }
    }

    public static class PFirstRemoteVideoDecoded extends Marshallable {
        public int elapsed;
        public int height;
        public int uid;
        public int width;

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void clear() {
            super.clear();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ ByteBuffer getBuffer() {
            return super.getBuffer();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void marshall(ByteBuffer byteBuffer) {
            super.marshall(byteBuffer);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public byte[] marshall() {
            pushInt(this.uid);
            pushInt(this.width);
            pushInt(this.height);
            pushInt(this.elapsed);
            return super.marshall();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popAll() {
            return super.popAll();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ Boolean popBool() {
            return super.popBool();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte popByte() {
            return super.popByte();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes() {
            return super.popBytes();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes32() {
            return super.popBytes32();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ double popDouble() {
            return super.popDouble();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ int popInt() {
            return super.popInt();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ long popInt64() {
            return super.popInt64();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ int[] popIntArray() {
            return super.popIntArray();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ short popShort() {
            return super.popShort();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ short[] popShortArray() {
            return super.popShortArray();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16() {
            return super.popString16();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16UTF8() {
            return super.popString16UTF8();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBool(Boolean bool) {
            super.pushBool(bool);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushByte(byte b) {
            super.pushByte(b);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes(byte[] bArr) {
            super.pushBytes(bArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes32(byte[] bArr) {
            super.pushBytes32(bArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushDouble(double d) {
            super.pushDouble(d);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt(int i) {
            super.pushInt(i);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt64(long j) {
            super.pushInt64(j);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(int[] iArr) {
            super.pushIntArray(iArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(Integer[] numArr) {
            super.pushIntArray(numArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShort(short s) {
            super.pushShort(s);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShortArray(short[] sArr) {
            super.pushShortArray(sArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushString16(String str) {
            super.pushString16(str);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushStringArray(ArrayList arrayList) {
            super.pushStringArray(arrayList);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void unmarshall(ByteBuffer byteBuffer) {
            super.unmarshall(byteBuffer);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.uid = popInt();
            this.width = popInt();
            this.height = popInt();
            this.elapsed = popInt();
        }
    }

    public static class PFirstRemoteVideoFrame extends Marshallable {
        public int elapsed;
        public int height;
        public int uid;
        public int width;

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void clear() {
            super.clear();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ ByteBuffer getBuffer() {
            return super.getBuffer();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void marshall(ByteBuffer byteBuffer) {
            super.marshall(byteBuffer);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public byte[] marshall() {
            pushInt(this.uid);
            pushInt(this.width);
            pushInt(this.height);
            pushInt(this.elapsed);
            return super.marshall();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popAll() {
            return super.popAll();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ Boolean popBool() {
            return super.popBool();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte popByte() {
            return super.popByte();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes() {
            return super.popBytes();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes32() {
            return super.popBytes32();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ double popDouble() {
            return super.popDouble();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ int popInt() {
            return super.popInt();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ long popInt64() {
            return super.popInt64();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ int[] popIntArray() {
            return super.popIntArray();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ short popShort() {
            return super.popShort();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ short[] popShortArray() {
            return super.popShortArray();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16() {
            return super.popString16();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16UTF8() {
            return super.popString16UTF8();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBool(Boolean bool) {
            super.pushBool(bool);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushByte(byte b) {
            super.pushByte(b);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes(byte[] bArr) {
            super.pushBytes(bArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes32(byte[] bArr) {
            super.pushBytes32(bArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushDouble(double d) {
            super.pushDouble(d);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt(int i) {
            super.pushInt(i);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt64(long j) {
            super.pushInt64(j);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(int[] iArr) {
            super.pushIntArray(iArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(Integer[] numArr) {
            super.pushIntArray(numArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShort(short s) {
            super.pushShort(s);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShortArray(short[] sArr) {
            super.pushShortArray(sArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushString16(String str) {
            super.pushString16(str);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushStringArray(ArrayList arrayList) {
            super.pushStringArray(arrayList);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void unmarshall(ByteBuffer byteBuffer) {
            super.unmarshall(byteBuffer);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.uid = popInt();
            this.width = popInt();
            this.height = popInt();
            this.elapsed = popInt();
        }
    }

    public static class PHostInRequest extends Marshallable {
        public int uid;

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void clear() {
            super.clear();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ ByteBuffer getBuffer() {
            return super.getBuffer();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void marshall(ByteBuffer byteBuffer) {
            super.marshall(byteBuffer);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public byte[] marshall() {
            return super.marshall();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popAll() {
            return super.popAll();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ Boolean popBool() {
            return super.popBool();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte popByte() {
            return super.popByte();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes() {
            return super.popBytes();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes32() {
            return super.popBytes32();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ double popDouble() {
            return super.popDouble();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ int popInt() {
            return super.popInt();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ long popInt64() {
            return super.popInt64();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ int[] popIntArray() {
            return super.popIntArray();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ short popShort() {
            return super.popShort();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ short[] popShortArray() {
            return super.popShortArray();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16() {
            return super.popString16();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16UTF8() {
            return super.popString16UTF8();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBool(Boolean bool) {
            super.pushBool(bool);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushByte(byte b) {
            super.pushByte(b);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes(byte[] bArr) {
            super.pushBytes(bArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes32(byte[] bArr) {
            super.pushBytes32(bArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushDouble(double d) {
            super.pushDouble(d);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt(int i) {
            super.pushInt(i);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt64(long j) {
            super.pushInt64(j);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(int[] iArr) {
            super.pushIntArray(iArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(Integer[] numArr) {
            super.pushIntArray(numArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShort(short s) {
            super.pushShort(s);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShortArray(short[] sArr) {
            super.pushShortArray(sArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushString16(String str) {
            super.pushString16(str);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushStringArray(ArrayList arrayList) {
            super.pushStringArray(arrayList);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void unmarshall(ByteBuffer byteBuffer) {
            super.unmarshall(byteBuffer);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.uid = popInt();
        }
    }

    public static class PHostInResponse extends Marshallable {
        public boolean accepted;
        public int error;
        public int uid;

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void clear() {
            super.clear();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ ByteBuffer getBuffer() {
            return super.getBuffer();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void marshall(ByteBuffer byteBuffer) {
            super.marshall(byteBuffer);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public byte[] marshall() {
            return super.marshall();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popAll() {
            return super.popAll();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ Boolean popBool() {
            return super.popBool();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte popByte() {
            return super.popByte();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes() {
            return super.popBytes();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes32() {
            return super.popBytes32();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ double popDouble() {
            return super.popDouble();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ int popInt() {
            return super.popInt();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ long popInt64() {
            return super.popInt64();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ int[] popIntArray() {
            return super.popIntArray();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ short popShort() {
            return super.popShort();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ short[] popShortArray() {
            return super.popShortArray();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16() {
            return super.popString16();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16UTF8() {
            return super.popString16UTF8();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBool(Boolean bool) {
            super.pushBool(bool);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushByte(byte b) {
            super.pushByte(b);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes(byte[] bArr) {
            super.pushBytes(bArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes32(byte[] bArr) {
            super.pushBytes32(bArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushDouble(double d) {
            super.pushDouble(d);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt(int i) {
            super.pushInt(i);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt64(long j) {
            super.pushInt64(j);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(int[] iArr) {
            super.pushIntArray(iArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(Integer[] numArr) {
            super.pushIntArray(numArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShort(short s) {
            super.pushShort(s);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShortArray(short[] sArr) {
            super.pushShortArray(sArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushString16(String str) {
            super.pushString16(str);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushStringArray(ArrayList arrayList) {
            super.pushStringArray(arrayList);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void unmarshall(ByteBuffer byteBuffer) {
            super.unmarshall(byteBuffer);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.uid = popInt();
            this.accepted = popBool().booleanValue();
            this.error = popInt();
        }
    }

    public static class PHostInStopped extends Marshallable {
        public int uid;

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void clear() {
            super.clear();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ ByteBuffer getBuffer() {
            return super.getBuffer();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void marshall(ByteBuffer byteBuffer) {
            super.marshall(byteBuffer);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public byte[] marshall() {
            return super.marshall();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popAll() {
            return super.popAll();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ Boolean popBool() {
            return super.popBool();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte popByte() {
            return super.popByte();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes() {
            return super.popBytes();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes32() {
            return super.popBytes32();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ double popDouble() {
            return super.popDouble();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ int popInt() {
            return super.popInt();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ long popInt64() {
            return super.popInt64();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ int[] popIntArray() {
            return super.popIntArray();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ short popShort() {
            return super.popShort();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ short[] popShortArray() {
            return super.popShortArray();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16() {
            return super.popString16();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16UTF8() {
            return super.popString16UTF8();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBool(Boolean bool) {
            super.pushBool(bool);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushByte(byte b) {
            super.pushByte(b);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes(byte[] bArr) {
            super.pushBytes(bArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes32(byte[] bArr) {
            super.pushBytes32(bArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushDouble(double d) {
            super.pushDouble(d);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt(int i) {
            super.pushInt(i);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt64(long j) {
            super.pushInt64(j);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(int[] iArr) {
            super.pushIntArray(iArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(Integer[] numArr) {
            super.pushIntArray(numArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShort(short s) {
            super.pushShort(s);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShortArray(short[] sArr) {
            super.pushShortArray(sArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushString16(String str) {
            super.pushString16(str);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushStringArray(ArrayList arrayList) {
            super.pushStringArray(arrayList);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void unmarshall(ByteBuffer byteBuffer) {
            super.unmarshall(byteBuffer);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.uid = popInt();
        }
    }

    public static class PInjectStreamConfig extends Marshallable {
        private static final short SERVER_TYPE = 0;
        private static final short URI = 25;

        private void marshall(Marshallable marshallable, LiveInjectStreamConfig liveInjectStreamConfig) {
            marshallable.pushShort((short) 0);
            marshallable.pushShort(URI);
            marshallable.pushInt(liveInjectStreamConfig.width);
            marshallable.pushInt(liveInjectStreamConfig.height);
            marshallable.pushInt(liveInjectStreamConfig.videoGop);
            marshallable.pushInt(liveInjectStreamConfig.videoFramerate);
            marshallable.pushInt(liveInjectStreamConfig.videoBitrate);
            marshallable.pushInt(LiveInjectStreamConfig.AudioSampleRateType.getValue(liveInjectStreamConfig.audioSampleRate));
            marshallable.pushInt(liveInjectStreamConfig.audioBitrate);
            marshallable.pushInt(liveInjectStreamConfig.audioChannels);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void clear() {
            super.clear();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ ByteBuffer getBuffer() {
            return super.getBuffer();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void marshall(ByteBuffer byteBuffer) {
            super.marshall(byteBuffer);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] marshall() {
            return super.marshall();
        }

        public byte[] marshall(LiveInjectStreamConfig liveInjectStreamConfig) {
            marshall(this, liveInjectStreamConfig);
            return super.marshall();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popAll() {
            return super.popAll();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ Boolean popBool() {
            return super.popBool();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte popByte() {
            return super.popByte();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes() {
            return super.popBytes();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes32() {
            return super.popBytes32();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ double popDouble() {
            return super.popDouble();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ int popInt() {
            return super.popInt();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ long popInt64() {
            return super.popInt64();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ int[] popIntArray() {
            return super.popIntArray();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ short popShort() {
            return super.popShort();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ short[] popShortArray() {
            return super.popShortArray();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16() {
            return super.popString16();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16UTF8() {
            return super.popString16UTF8();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBool(Boolean bool) {
            super.pushBool(bool);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushByte(byte b) {
            super.pushByte(b);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes(byte[] bArr) {
            super.pushBytes(bArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes32(byte[] bArr) {
            super.pushBytes32(bArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushDouble(double d) {
            super.pushDouble(d);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt(int i) {
            super.pushInt(i);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt64(long j) {
            super.pushInt64(j);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(int[] iArr) {
            super.pushIntArray(iArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(Integer[] numArr) {
            super.pushIntArray(numArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShort(short s) {
            super.pushShort(s);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShortArray(short[] sArr) {
            super.pushShortArray(sArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushString16(String str) {
            super.pushString16(str);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushStringArray(ArrayList arrayList) {
            super.pushStringArray(arrayList);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void unmarshall(ByteBuffer byteBuffer) {
            super.unmarshall(byteBuffer);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
        }
    }

    public static class PLicenseVerifyFailed extends Marshallable {
        public int reason;

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void clear() {
            super.clear();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ ByteBuffer getBuffer() {
            return super.getBuffer();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void marshall(ByteBuffer byteBuffer) {
            super.marshall(byteBuffer);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public byte[] marshall() {
            return super.marshall();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popAll() {
            return super.popAll();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ Boolean popBool() {
            return super.popBool();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte popByte() {
            return super.popByte();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes() {
            return super.popBytes();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes32() {
            return super.popBytes32();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ double popDouble() {
            return super.popDouble();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ int popInt() {
            return super.popInt();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ long popInt64() {
            return super.popInt64();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ int[] popIntArray() {
            return super.popIntArray();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ short popShort() {
            return super.popShort();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ short[] popShortArray() {
            return super.popShortArray();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16() {
            return super.popString16();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16UTF8() {
            return super.popString16UTF8();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBool(Boolean bool) {
            super.pushBool(bool);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushByte(byte b) {
            super.pushByte(b);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes(byte[] bArr) {
            super.pushBytes(bArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes32(byte[] bArr) {
            super.pushBytes32(bArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushDouble(double d) {
            super.pushDouble(d);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt(int i) {
            super.pushInt(i);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt64(long j) {
            super.pushInt64(j);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(int[] iArr) {
            super.pushIntArray(iArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(Integer[] numArr) {
            super.pushIntArray(numArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShort(short s) {
            super.pushShort(s);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShortArray(short[] sArr) {
            super.pushShortArray(sArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushString16(String str) {
            super.pushString16(str);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushStringArray(ArrayList arrayList) {
            super.pushStringArray(arrayList);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void unmarshall(ByteBuffer byteBuffer) {
            super.unmarshall(byteBuffer);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.reason = popInt();
        }
    }

    public static class PLiveTranscoding extends Marshallable {
        private static final short SERVER_TYPE = 0;
        private static final short URI = 23;

        private void marshall(Marshallable marshallable, LiveTranscoding liveTranscoding) {
            marshallable.pushShort((short) 0);
            marshallable.pushShort((short) 23);
            marshallable.pushInt(liveTranscoding.width);
            marshallable.pushInt(liveTranscoding.height);
            marshallable.pushInt(liveTranscoding.videoGop);
            marshallable.pushInt(liveTranscoding.videoFramerate);
            marshallable.pushInt(LiveTranscoding.VideoCodecProfileType.getValue(liveTranscoding.videoCodecProfile));
            marshallable.pushInt(LiveTranscoding.VideoCodecType.getValue(liveTranscoding.videoCodecType));
            marshallable.pushInt(liveTranscoding.videoBitrate);
            marshallWatermarks(marshallable, liveTranscoding);
            marshallBackgroundImage(marshallable, liveTranscoding);
            marshallable.pushBool(Boolean.valueOf(liveTranscoding.lowLatency));
            marshallable.pushInt(LiveTranscoding.AudioSampleRateType.getValue(liveTranscoding.audioSampleRate));
            marshallable.pushInt(liveTranscoding.audioBitrate);
            marshallable.pushInt(liveTranscoding.audioChannels);
            marshallable.pushInt(LiveTranscoding.AudioCodecProfileType.getValue(liveTranscoding.audioCodecProfile));
            marshallable.pushInt(liveTranscoding.backgroundColor & 16777215);
            if (TextUtils.isEmpty(liveTranscoding.userConfigExtraInfo)) {
                liveTranscoding.userConfigExtraInfo = "";
            }
            marshallable.pushString16(liveTranscoding.userConfigExtraInfo);
            if (TextUtils.isEmpty(liveTranscoding.metadata)) {
                liveTranscoding.metadata = "";
            }
            marshallable.pushString16(liveTranscoding.metadata);
            if (liveTranscoding.getUsers() == null || liveTranscoding.getUsers().size() <= 0) {
                pushShort((short) 0);
            } else {
                pushShort((short) liveTranscoding.getUserCount());
                Iterator<LiveTranscoding.TranscodingUser> it = liveTranscoding.getUsers().iterator();
                while (it.hasNext()) {
                    marshallUserConfig(marshallable, it.next());
                }
            }
            pushShort((short) liveTranscoding.getAdvancedFeatures().size());
            for (Map.Entry<String, Boolean> entry : liveTranscoding.getAdvancedFeatures().entrySet()) {
                marshallable.pushString16(entry.getKey());
                marshallable.pushBool(entry.getValue());
            }
        }

        private void marshallBackgroundImage(Marshallable marshallable, LiveTranscoding liveTranscoding) {
            ArrayList arrayList = new ArrayList();
            if (liveTranscoding.getBackgroundImageList() != null && !liveTranscoding.getBackgroundImageList().isEmpty()) {
                arrayList.addAll(liveTranscoding.getBackgroundImageList());
            }
            pushShort((short) arrayList.size());
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                marshallImage(marshallable, (AgoraImage) it.next());
            }
        }

        private void marshallImage(Marshallable marshallable, AgoraImage agoraImage) {
            marshallable.pushString16(agoraImage.url);
            marshallable.pushInt(agoraImage.x);
            marshallable.pushInt(agoraImage.y);
            marshallable.pushInt(agoraImage.width);
            marshallable.pushInt(agoraImage.height);
            marshallable.pushInt(agoraImage.zOrder);
            marshallable.pushDouble(agoraImage.alpha);
        }

        private void marshallUserConfig(Marshallable marshallable, LiveTranscoding.TranscodingUser transcodingUser) {
            marshallable.pushInt(transcodingUser.uid);
            String str = transcodingUser.userId;
            if (str == null) {
                str = "";
            }
            pushBytes(str.getBytes());
            marshallable.pushInt(transcodingUser.x);
            marshallable.pushInt(transcodingUser.y);
            marshallable.pushInt(transcodingUser.width);
            marshallable.pushInt(transcodingUser.height);
            marshallable.pushInt(transcodingUser.zOrder);
            marshallable.pushDouble(transcodingUser.alpha);
            marshallable.pushInt(transcodingUser.audioChannel);
        }

        private void marshallWatermarks(Marshallable marshallable, LiveTranscoding liveTranscoding) {
            ArrayList arrayList = new ArrayList();
            if (liveTranscoding.getWatermarkList() != null && !liveTranscoding.getWatermarkList().isEmpty()) {
                arrayList.addAll(liveTranscoding.getWatermarkList());
            }
            pushShort((short) arrayList.size());
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                marshallImage(marshallable, (AgoraImage) it.next());
            }
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void clear() {
            super.clear();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ ByteBuffer getBuffer() {
            return super.getBuffer();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void marshall(ByteBuffer byteBuffer) {
            super.marshall(byteBuffer);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] marshall() {
            return super.marshall();
        }

        public byte[] marshall(LiveTranscoding liveTranscoding) {
            marshall(this, liveTranscoding);
            return super.marshall();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popAll() {
            return super.popAll();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ Boolean popBool() {
            return super.popBool();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte popByte() {
            return super.popByte();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes() {
            return super.popBytes();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes32() {
            return super.popBytes32();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ double popDouble() {
            return super.popDouble();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ int popInt() {
            return super.popInt();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ long popInt64() {
            return super.popInt64();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ int[] popIntArray() {
            return super.popIntArray();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ short popShort() {
            return super.popShort();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ short[] popShortArray() {
            return super.popShortArray();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16() {
            return super.popString16();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16UTF8() {
            return super.popString16UTF8();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBool(Boolean bool) {
            super.pushBool(bool);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushByte(byte b) {
            super.pushByte(b);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes(byte[] bArr) {
            super.pushBytes(bArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes32(byte[] bArr) {
            super.pushBytes32(bArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushDouble(double d) {
            super.pushDouble(d);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt(int i) {
            super.pushInt(i);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt64(long j) {
            super.pushInt64(j);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(int[] iArr) {
            super.pushIntArray(iArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(Integer[] numArr) {
            super.pushIntArray(numArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShort(short s) {
            super.pushShort(s);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShortArray(short[] sArr) {
            super.pushShortArray(sArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushString16(String str) {
            super.pushString16(str);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushStringArray(ArrayList arrayList) {
            super.pushStringArray(arrayList);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void unmarshall(ByteBuffer byteBuffer) {
            super.unmarshall(byteBuffer);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
        }
    }

    public static class PLocalAudioStat extends Marshallable {
        public IRtcEngineEventHandler.LocalAudioStats stats = new IRtcEngineEventHandler.LocalAudioStats();

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void clear() {
            super.clear();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ ByteBuffer getBuffer() {
            return super.getBuffer();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void marshall(ByteBuffer byteBuffer) {
            super.marshall(byteBuffer);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public byte[] marshall() {
            pushInt(this.stats.numChannels);
            pushInt(this.stats.sentSampleRate);
            pushInt(this.stats.sentBitrate);
            pushInt(this.stats.internalCodec);
            pushShort((short) this.stats.txPacketLossRate);
            pushInt(this.stats.audioDeviceDelay);
            return super.marshall();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popAll() {
            return super.popAll();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ Boolean popBool() {
            return super.popBool();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte popByte() {
            return super.popByte();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes() {
            return super.popBytes();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes32() {
            return super.popBytes32();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ double popDouble() {
            return super.popDouble();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ int popInt() {
            return super.popInt();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ long popInt64() {
            return super.popInt64();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ int[] popIntArray() {
            return super.popIntArray();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ short popShort() {
            return super.popShort();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ short[] popShortArray() {
            return super.popShortArray();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16() {
            return super.popString16();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16UTF8() {
            return super.popString16UTF8();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBool(Boolean bool) {
            super.pushBool(bool);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushByte(byte b) {
            super.pushByte(b);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes(byte[] bArr) {
            super.pushBytes(bArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes32(byte[] bArr) {
            super.pushBytes32(bArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushDouble(double d) {
            super.pushDouble(d);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt(int i) {
            super.pushInt(i);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt64(long j) {
            super.pushInt64(j);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(int[] iArr) {
            super.pushIntArray(iArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(Integer[] numArr) {
            super.pushIntArray(numArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShort(short s) {
            super.pushShort(s);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShortArray(short[] sArr) {
            super.pushShortArray(sArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushString16(String str) {
            super.pushString16(str);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushStringArray(ArrayList arrayList) {
            super.pushStringArray(arrayList);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void unmarshall(ByteBuffer byteBuffer) {
            super.unmarshall(byteBuffer);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.stats.numChannels = popInt();
            this.stats.sentSampleRate = popInt();
            this.stats.sentBitrate = popInt();
            this.stats.internalCodec = popInt();
            this.stats.txPacketLossRate = popShort();
            this.stats.audioDeviceDelay = popInt();
        }
    }

    public static class PLocalAudioState extends Marshallable {
        public int errorCode;
        public int state;

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void clear() {
            super.clear();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ ByteBuffer getBuffer() {
            return super.getBuffer();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void marshall(ByteBuffer byteBuffer) {
            super.marshall(byteBuffer);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public byte[] marshall() {
            pushByte((byte) this.state);
            pushByte((byte) this.errorCode);
            return super.marshall();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popAll() {
            return super.popAll();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ Boolean popBool() {
            return super.popBool();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte popByte() {
            return super.popByte();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes() {
            return super.popBytes();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes32() {
            return super.popBytes32();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ double popDouble() {
            return super.popDouble();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ int popInt() {
            return super.popInt();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ long popInt64() {
            return super.popInt64();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ int[] popIntArray() {
            return super.popIntArray();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ short popShort() {
            return super.popShort();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ short[] popShortArray() {
            return super.popShortArray();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16() {
            return super.popString16();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16UTF8() {
            return super.popString16UTF8();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBool(Boolean bool) {
            super.pushBool(bool);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushByte(byte b) {
            super.pushByte(b);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes(byte[] bArr) {
            super.pushBytes(bArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes32(byte[] bArr) {
            super.pushBytes32(bArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushDouble(double d) {
            super.pushDouble(d);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt(int i) {
            super.pushInt(i);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt64(long j) {
            super.pushInt64(j);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(int[] iArr) {
            super.pushIntArray(iArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(Integer[] numArr) {
            super.pushIntArray(numArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShort(short s) {
            super.pushShort(s);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShortArray(short[] sArr) {
            super.pushShortArray(sArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushString16(String str) {
            super.pushString16(str);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushStringArray(ArrayList arrayList) {
            super.pushStringArray(arrayList);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void unmarshall(ByteBuffer byteBuffer) {
            super.unmarshall(byteBuffer);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.state = popByte();
            this.errorCode = popByte();
        }
    }

    public static class PLocalFallbackStatus extends Marshallable {
        public boolean state;

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void clear() {
            super.clear();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ ByteBuffer getBuffer() {
            return super.getBuffer();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void marshall(ByteBuffer byteBuffer) {
            super.marshall(byteBuffer);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public byte[] marshall() {
            return super.marshall();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popAll() {
            return super.popAll();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ Boolean popBool() {
            return super.popBool();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte popByte() {
            return super.popByte();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes() {
            return super.popBytes();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes32() {
            return super.popBytes32();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ double popDouble() {
            return super.popDouble();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ int popInt() {
            return super.popInt();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ long popInt64() {
            return super.popInt64();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ int[] popIntArray() {
            return super.popIntArray();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ short popShort() {
            return super.popShort();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ short[] popShortArray() {
            return super.popShortArray();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16() {
            return super.popString16();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16UTF8() {
            return super.popString16UTF8();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBool(Boolean bool) {
            super.pushBool(bool);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushByte(byte b) {
            super.pushByte(b);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes(byte[] bArr) {
            super.pushBytes(bArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes32(byte[] bArr) {
            super.pushBytes32(bArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushDouble(double d) {
            super.pushDouble(d);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt(int i) {
            super.pushInt(i);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt64(long j) {
            super.pushInt64(j);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(int[] iArr) {
            super.pushIntArray(iArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(Integer[] numArr) {
            super.pushIntArray(numArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShort(short s) {
            super.pushShort(s);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShortArray(short[] sArr) {
            super.pushShortArray(sArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushString16(String str) {
            super.pushString16(str);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushStringArray(ArrayList arrayList) {
            super.pushStringArray(arrayList);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void unmarshall(ByteBuffer byteBuffer) {
            super.unmarshall(byteBuffer);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.state = popBool().booleanValue();
        }
    }

    public static class PLocalLiveTranscoderConfiguration extends Marshallable {
        private void marshall(Marshallable marshallable, LocalTranscoderConfiguration localTranscoderConfiguration) {
            marshallable.pushInt(localTranscoderConfiguration.transcodingVideoStreams.size());
            marshallable.pushBool(Boolean.valueOf(localTranscoderConfiguration.syncWithPrimaryCamera));
            marshallVideoEncoderConfiguration(marshallable, localTranscoderConfiguration);
            marshallTranscodingVideoStream(marshallable, localTranscoderConfiguration);
        }

        private void marshallLocalTranscodingVideoStream(Marshallable marshallable, LocalTranscoderConfiguration.TranscodingVideoStream transcodingVideoStream) {
            marshallable.pushInt(Constants.VideoSourceType.getValue(transcodingVideoStream.sourceType));
            marshallable.pushInt(transcodingVideoStream.remoteUserUid);
            marshallable.pushString16(transcodingVideoStream.imageUrl);
            marshallable.pushInt(transcodingVideoStream.mediaPlayerId);
            marshallable.pushInt(transcodingVideoStream.x);
            marshallable.pushInt(transcodingVideoStream.y);
            marshallable.pushInt(transcodingVideoStream.width);
            marshallable.pushInt(transcodingVideoStream.height);
            marshallable.pushInt(transcodingVideoStream.zOrder);
            marshallable.pushDouble(transcodingVideoStream.alpha);
            marshallable.pushBool(Boolean.valueOf(transcodingVideoStream.mirror));
        }

        private void marshallTranscodingVideoStream(Marshallable marshallable, LocalTranscoderConfiguration localTranscoderConfiguration) {
            ArrayList arrayList = new ArrayList();
            ArrayList<LocalTranscoderConfiguration.TranscodingVideoStream> arrayList2 = localTranscoderConfiguration.transcodingVideoStreams;
            if (arrayList2 != null && !arrayList2.isEmpty()) {
                arrayList.addAll(localTranscoderConfiguration.transcodingVideoStreams);
            }
            pushShort((short) localTranscoderConfiguration.transcodingVideoStreams.size());
            Iterator<LocalTranscoderConfiguration.TranscodingVideoStream> it = localTranscoderConfiguration.transcodingVideoStreams.iterator();
            while (it.hasNext()) {
                marshallLocalTranscodingVideoStream(marshallable, it.next());
            }
        }

        private void marshallVideoEncoderConfiguration(Marshallable marshallable, LocalTranscoderConfiguration localTranscoderConfiguration) {
            marshallable.pushInt(localTranscoderConfiguration.videoOutputConfiguration.dimensions.width);
            marshallable.pushInt(localTranscoderConfiguration.videoOutputConfiguration.dimensions.height);
            marshallable.pushInt(localTranscoderConfiguration.videoOutputConfiguration.frameRate);
            marshallable.pushInt(localTranscoderConfiguration.videoOutputConfiguration.bitrate);
            marshallable.pushInt(localTranscoderConfiguration.videoOutputConfiguration.minBitrate);
            marshallable.pushInt(localTranscoderConfiguration.videoOutputConfiguration.orientationMode.getValue());
            marshallable.pushInt(localTranscoderConfiguration.videoOutputConfiguration.mirrorMode.getValue());
            marshallable.pushInt(localTranscoderConfiguration.videoOutputConfiguration.degradationPrefer.getValue());
            marshallable.pushInt(localTranscoderConfiguration.videoOutputConfiguration.advanceOptions.compressionPreference.getValue());
            marshallable.pushInt(localTranscoderConfiguration.videoOutputConfiguration.advanceOptions.encodingPreference.getValue());
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void clear() {
            super.clear();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ ByteBuffer getBuffer() {
            return super.getBuffer();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void marshall(ByteBuffer byteBuffer) {
            super.marshall(byteBuffer);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] marshall() {
            return super.marshall();
        }

        public byte[] marshall(LocalTranscoderConfiguration localTranscoderConfiguration) {
            marshall(this, localTranscoderConfiguration);
            return super.marshall();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popAll() {
            return super.popAll();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ Boolean popBool() {
            return super.popBool();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte popByte() {
            return super.popByte();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes() {
            return super.popBytes();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes32() {
            return super.popBytes32();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ double popDouble() {
            return super.popDouble();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ int popInt() {
            return super.popInt();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ long popInt64() {
            return super.popInt64();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ int[] popIntArray() {
            return super.popIntArray();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ short popShort() {
            return super.popShort();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ short[] popShortArray() {
            return super.popShortArray();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16() {
            return super.popString16();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16UTF8() {
            return super.popString16UTF8();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBool(Boolean bool) {
            super.pushBool(bool);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushByte(byte b) {
            super.pushByte(b);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes(byte[] bArr) {
            super.pushBytes(bArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes32(byte[] bArr) {
            super.pushBytes32(bArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushDouble(double d) {
            super.pushDouble(d);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt(int i) {
            super.pushInt(i);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt64(long j) {
            super.pushInt64(j);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(int[] iArr) {
            super.pushIntArray(iArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(Integer[] numArr) {
            super.pushIntArray(numArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShort(short s) {
            super.pushShort(s);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShortArray(short[] sArr) {
            super.pushShortArray(sArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushString16(String str) {
            super.pushString16(str);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushStringArray(ArrayList arrayList) {
            super.pushStringArray(arrayList);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void unmarshall(ByteBuffer byteBuffer) {
            super.unmarshall(byteBuffer);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
        }
    }

    public static class PLocalVideoStat extends Marshallable {
        public int source;
        public IRtcEngineEventHandler.LocalVideoStats stats = new IRtcEngineEventHandler.LocalVideoStats();

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void clear() {
            super.clear();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ ByteBuffer getBuffer() {
            return super.getBuffer();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void marshall(ByteBuffer byteBuffer) {
            super.marshall(byteBuffer);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public byte[] marshall() {
            pushByte((byte) this.source);
            pushInt(this.stats.uid);
            pushInt(this.stats.sentBitrate);
            pushInt(this.stats.sentFrameRate);
            pushInt(this.stats.captureFrameRate);
            pushInt(this.stats.regulatedCaptureFrameRate);
            pushInt(this.stats.captureFrameWidth);
            pushInt(this.stats.captureFrameHeight);
            pushInt(this.stats.regulatedCaptureFrameWidth);
            pushInt(this.stats.regulatedCaptureFrameHeight);
            pushInt(this.stats.encoderOutputFrameRate);
            pushInt(this.stats.rendererOutputFrameRate);
            pushInt(this.stats.targetBitrate);
            pushInt(this.stats.targetFrameRate);
            pushInt(this.stats.encodedBitrate);
            pushInt(this.stats.encodedFrameWidth);
            pushInt(this.stats.encodedFrameHeight);
            pushInt(this.stats.encodedFrameCount);
            pushInt(this.stats.codecType);
            pushInt(this.stats.qualityAdaptIndication);
            pushShort((short) this.stats.txPacketLossRate);
            pushInt(this.stats.captureBrightnessLevel);
            pushBool(Boolean.valueOf(this.stats.dualStreamEnabled));
            pushInt(this.stats.hwEncoderAccelerating);
            return super.marshall();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popAll() {
            return super.popAll();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ Boolean popBool() {
            return super.popBool();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte popByte() {
            return super.popByte();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes() {
            return super.popBytes();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes32() {
            return super.popBytes32();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ double popDouble() {
            return super.popDouble();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ int popInt() {
            return super.popInt();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ long popInt64() {
            return super.popInt64();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ int[] popIntArray() {
            return super.popIntArray();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ short popShort() {
            return super.popShort();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ short[] popShortArray() {
            return super.popShortArray();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16() {
            return super.popString16();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16UTF8() {
            return super.popString16UTF8();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBool(Boolean bool) {
            super.pushBool(bool);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushByte(byte b) {
            super.pushByte(b);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes(byte[] bArr) {
            super.pushBytes(bArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes32(byte[] bArr) {
            super.pushBytes32(bArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushDouble(double d) {
            super.pushDouble(d);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt(int i) {
            super.pushInt(i);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt64(long j) {
            super.pushInt64(j);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(int[] iArr) {
            super.pushIntArray(iArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(Integer[] numArr) {
            super.pushIntArray(numArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShort(short s) {
            super.pushShort(s);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShortArray(short[] sArr) {
            super.pushShortArray(sArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushString16(String str) {
            super.pushString16(str);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushStringArray(ArrayList arrayList) {
            super.pushStringArray(arrayList);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void unmarshall(ByteBuffer byteBuffer) {
            super.unmarshall(byteBuffer);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.source = popByte();
            this.stats.uid = popInt();
            this.stats.sentBitrate = popInt();
            this.stats.sentFrameRate = popInt();
            this.stats.captureFrameRate = popInt();
            this.stats.regulatedCaptureFrameRate = popInt();
            this.stats.captureFrameWidth = popInt();
            this.stats.captureFrameHeight = popInt();
            this.stats.regulatedCaptureFrameWidth = popInt();
            this.stats.regulatedCaptureFrameHeight = popInt();
            this.stats.encoderOutputFrameRate = popInt();
            this.stats.rendererOutputFrameRate = popInt();
            this.stats.targetBitrate = popInt();
            this.stats.targetFrameRate = popInt();
            this.stats.encodedBitrate = popInt();
            this.stats.encodedFrameWidth = popInt();
            this.stats.encodedFrameHeight = popInt();
            this.stats.encodedFrameCount = popInt();
            this.stats.codecType = popInt();
            this.stats.qualityAdaptIndication = popInt();
            this.stats.txPacketLossRate = popShort();
            this.stats.captureBrightnessLevel = popInt();
            this.stats.dualStreamEnabled = popBool().booleanValue();
            this.stats.hwEncoderAccelerating = popInt();
        }
    }

    public static class PLocalVideoState extends Marshallable {
        public int errorCode;
        public int source;
        public int state;

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void clear() {
            super.clear();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ ByteBuffer getBuffer() {
            return super.getBuffer();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void marshall(ByteBuffer byteBuffer) {
            super.marshall(byteBuffer);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public byte[] marshall() {
            pushByte((byte) this.source);
            pushByte((byte) this.state);
            pushByte((byte) this.errorCode);
            return super.marshall();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popAll() {
            return super.popAll();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ Boolean popBool() {
            return super.popBool();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte popByte() {
            return super.popByte();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes() {
            return super.popBytes();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes32() {
            return super.popBytes32();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ double popDouble() {
            return super.popDouble();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ int popInt() {
            return super.popInt();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ long popInt64() {
            return super.popInt64();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ int[] popIntArray() {
            return super.popIntArray();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ short popShort() {
            return super.popShort();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ short[] popShortArray() {
            return super.popShortArray();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16() {
            return super.popString16();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16UTF8() {
            return super.popString16UTF8();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBool(Boolean bool) {
            super.pushBool(bool);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushByte(byte b) {
            super.pushByte(b);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes(byte[] bArr) {
            super.pushBytes(bArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes32(byte[] bArr) {
            super.pushBytes32(bArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushDouble(double d) {
            super.pushDouble(d);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt(int i) {
            super.pushInt(i);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt64(long j) {
            super.pushInt64(j);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(int[] iArr) {
            super.pushIntArray(iArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(Integer[] numArr) {
            super.pushIntArray(numArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShort(short s) {
            super.pushShort(s);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShortArray(short[] sArr) {
            super.pushShortArray(sArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushString16(String str) {
            super.pushString16(str);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushStringArray(ArrayList arrayList) {
            super.pushStringArray(arrayList);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void unmarshall(ByteBuffer byteBuffer) {
            super.unmarshall(byteBuffer);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.source = popByte();
            this.state = popByte();
            this.errorCode = popByte();
        }
    }

    public static class PMediaEngineEvent extends Marshallable {
        public int code;

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void clear() {
            super.clear();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ ByteBuffer getBuffer() {
            return super.getBuffer();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void marshall(ByteBuffer byteBuffer) {
            super.marshall(byteBuffer);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public byte[] marshall() {
            return super.marshall();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popAll() {
            return super.popAll();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ Boolean popBool() {
            return super.popBool();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte popByte() {
            return super.popByte();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes() {
            return super.popBytes();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes32() {
            return super.popBytes32();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ double popDouble() {
            return super.popDouble();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ int popInt() {
            return super.popInt();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ long popInt64() {
            return super.popInt64();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ int[] popIntArray() {
            return super.popIntArray();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ short popShort() {
            return super.popShort();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ short[] popShortArray() {
            return super.popShortArray();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16() {
            return super.popString16();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16UTF8() {
            return super.popString16UTF8();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBool(Boolean bool) {
            super.pushBool(bool);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushByte(byte b) {
            super.pushByte(b);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes(byte[] bArr) {
            super.pushBytes(bArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes32(byte[] bArr) {
            super.pushBytes32(bArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushDouble(double d) {
            super.pushDouble(d);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt(int i) {
            super.pushInt(i);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt64(long j) {
            super.pushInt64(j);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(int[] iArr) {
            super.pushIntArray(iArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(Integer[] numArr) {
            super.pushIntArray(numArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShort(short s) {
            super.pushShort(s);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShortArray(short[] sArr) {
            super.pushShortArray(sArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushString16(String str) {
            super.pushString16(str);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushStringArray(ArrayList arrayList) {
            super.pushStringArray(arrayList);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void unmarshall(ByteBuffer byteBuffer) {
            super.unmarshall(byteBuffer);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.code = popInt();
        }
    }

    public static class PMediaResAudioEffectFinished extends Marshallable {
        public int soundId;

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void clear() {
            super.clear();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ ByteBuffer getBuffer() {
            return super.getBuffer();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void marshall(ByteBuffer byteBuffer) {
            super.marshall(byteBuffer);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public byte[] marshall() {
            return super.marshall();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popAll() {
            return super.popAll();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ Boolean popBool() {
            return super.popBool();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte popByte() {
            return super.popByte();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes() {
            return super.popBytes();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes32() {
            return super.popBytes32();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ double popDouble() {
            return super.popDouble();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ int popInt() {
            return super.popInt();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ long popInt64() {
            return super.popInt64();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ int[] popIntArray() {
            return super.popIntArray();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ short popShort() {
            return super.popShort();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ short[] popShortArray() {
            return super.popShortArray();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16() {
            return super.popString16();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16UTF8() {
            return super.popString16UTF8();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBool(Boolean bool) {
            super.pushBool(bool);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushByte(byte b) {
            super.pushByte(b);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes(byte[] bArr) {
            super.pushBytes(bArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes32(byte[] bArr) {
            super.pushBytes32(bArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushDouble(double d) {
            super.pushDouble(d);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt(int i) {
            super.pushInt(i);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt64(long j) {
            super.pushInt64(j);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(int[] iArr) {
            super.pushIntArray(iArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(Integer[] numArr) {
            super.pushIntArray(numArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShort(short s) {
            super.pushShort(s);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShortArray(short[] sArr) {
            super.pushShortArray(sArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushString16(String str) {
            super.pushString16(str);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushStringArray(ArrayList arrayList) {
            super.pushStringArray(arrayList);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void unmarshall(ByteBuffer byteBuffer) {
            super.unmarshall(byteBuffer);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.soundId = popInt();
        }
    }

    public static class PMediaResAudioQuality extends Marshallable {
        public short delay;
        public short lost;
        public int quality;
        public int uid;

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void clear() {
            super.clear();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ ByteBuffer getBuffer() {
            return super.getBuffer();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void marshall(ByteBuffer byteBuffer) {
            super.marshall(byteBuffer);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public byte[] marshall() {
            return super.marshall();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popAll() {
            return super.popAll();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ Boolean popBool() {
            return super.popBool();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte popByte() {
            return super.popByte();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes() {
            return super.popBytes();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes32() {
            return super.popBytes32();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ double popDouble() {
            return super.popDouble();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ int popInt() {
            return super.popInt();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ long popInt64() {
            return super.popInt64();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ int[] popIntArray() {
            return super.popIntArray();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ short popShort() {
            return super.popShort();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ short[] popShortArray() {
            return super.popShortArray();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16() {
            return super.popString16();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16UTF8() {
            return super.popString16UTF8();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBool(Boolean bool) {
            super.pushBool(bool);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushByte(byte b) {
            super.pushByte(b);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes(byte[] bArr) {
            super.pushBytes(bArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes32(byte[] bArr) {
            super.pushBytes32(bArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushDouble(double d) {
            super.pushDouble(d);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt(int i) {
            super.pushInt(i);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt64(long j) {
            super.pushInt64(j);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(int[] iArr) {
            super.pushIntArray(iArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(Integer[] numArr) {
            super.pushIntArray(numArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShort(short s) {
            super.pushShort(s);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShortArray(short[] sArr) {
            super.pushShortArray(sArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushString16(String str) {
            super.pushString16(str);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushStringArray(ArrayList arrayList) {
            super.pushStringArray(arrayList);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void unmarshall(ByteBuffer byteBuffer) {
            super.unmarshall(byteBuffer);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.uid = popInt();
            this.quality = popInt();
            this.delay = popShort();
            this.lost = popShort();
        }
    }

    public static class PMediaResJoinMedia extends Marshallable {
        public String channel;
        public int elapsed;
        public boolean firstSuccess;
        public int uid;

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void clear() {
            super.clear();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ ByteBuffer getBuffer() {
            return super.getBuffer();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void marshall(ByteBuffer byteBuffer) {
            super.marshall(byteBuffer);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public byte[] marshall() {
            return super.marshall();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popAll() {
            return super.popAll();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ Boolean popBool() {
            return super.popBool();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte popByte() {
            return super.popByte();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes() {
            return super.popBytes();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes32() {
            return super.popBytes32();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ double popDouble() {
            return super.popDouble();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ int popInt() {
            return super.popInt();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ long popInt64() {
            return super.popInt64();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ int[] popIntArray() {
            return super.popIntArray();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ short popShort() {
            return super.popShort();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ short[] popShortArray() {
            return super.popShortArray();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16() {
            return super.popString16();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16UTF8() {
            return super.popString16UTF8();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBool(Boolean bool) {
            super.pushBool(bool);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushByte(byte b) {
            super.pushByte(b);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes(byte[] bArr) {
            super.pushBytes(bArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes32(byte[] bArr) {
            super.pushBytes32(bArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushDouble(double d) {
            super.pushDouble(d);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt(int i) {
            super.pushInt(i);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt64(long j) {
            super.pushInt64(j);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(int[] iArr) {
            super.pushIntArray(iArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(Integer[] numArr) {
            super.pushIntArray(numArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShort(short s) {
            super.pushShort(s);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShortArray(short[] sArr) {
            super.pushShortArray(sArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushString16(String str) {
            super.pushString16(str);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushStringArray(ArrayList arrayList) {
            super.pushStringArray(arrayList);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void unmarshall(ByteBuffer byteBuffer) {
            super.unmarshall(byteBuffer);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.channel = popString16UTF8();
            this.uid = popInt();
            this.elapsed = popInt();
            this.firstSuccess = popBool().booleanValue();
        }
    }

    public static class PMediaResLastmileProbeResult extends Marshallable {
        public LastmileProbeOneWayResult downlinkReport;
        public int rtt;
        public short state;
        public LastmileProbeOneWayResult uplinkReport;

        public static class LastmileProbeOneWayResult {
            public int availableBandwidth;
            public int jitter;
            public int packetLossRate;
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void clear() {
            super.clear();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ ByteBuffer getBuffer() {
            return super.getBuffer();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void marshall(ByteBuffer byteBuffer) {
            super.marshall(byteBuffer);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public byte[] marshall() {
            pushShort(this.state);
            pushInt(this.uplinkReport.packetLossRate);
            pushInt(this.uplinkReport.jitter);
            pushInt(this.uplinkReport.availableBandwidth);
            pushInt(this.downlinkReport.packetLossRate);
            pushInt(this.downlinkReport.jitter);
            pushInt(this.downlinkReport.availableBandwidth);
            pushInt(this.rtt);
            return super.marshall();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popAll() {
            return super.popAll();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ Boolean popBool() {
            return super.popBool();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte popByte() {
            return super.popByte();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes() {
            return super.popBytes();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes32() {
            return super.popBytes32();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ double popDouble() {
            return super.popDouble();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ int popInt() {
            return super.popInt();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ long popInt64() {
            return super.popInt64();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ int[] popIntArray() {
            return super.popIntArray();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ short popShort() {
            return super.popShort();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ short[] popShortArray() {
            return super.popShortArray();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16() {
            return super.popString16();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16UTF8() {
            return super.popString16UTF8();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBool(Boolean bool) {
            super.pushBool(bool);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushByte(byte b) {
            super.pushByte(b);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes(byte[] bArr) {
            super.pushBytes(bArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes32(byte[] bArr) {
            super.pushBytes32(bArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushDouble(double d) {
            super.pushDouble(d);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt(int i) {
            super.pushInt(i);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt64(long j) {
            super.pushInt64(j);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(int[] iArr) {
            super.pushIntArray(iArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(Integer[] numArr) {
            super.pushIntArray(numArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShort(short s) {
            super.pushShort(s);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShortArray(short[] sArr) {
            super.pushShortArray(sArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushString16(String str) {
            super.pushString16(str);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushStringArray(ArrayList arrayList) {
            super.pushStringArray(arrayList);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void unmarshall(ByteBuffer byteBuffer) {
            super.unmarshall(byteBuffer);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.state = popShort();
            this.uplinkReport = new LastmileProbeOneWayResult();
            this.downlinkReport = new LastmileProbeOneWayResult();
            this.uplinkReport.packetLossRate = popInt();
            this.uplinkReport.jitter = popInt();
            this.uplinkReport.availableBandwidth = popInt();
            this.downlinkReport.packetLossRate = popInt();
            this.downlinkReport.jitter = popInt();
            this.downlinkReport.availableBandwidth = popInt();
            this.rtt = popInt();
        }
    }

    public static class PMediaResLastmileQuality extends Marshallable {
        public int quality;

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void clear() {
            super.clear();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ ByteBuffer getBuffer() {
            return super.getBuffer();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void marshall(ByteBuffer byteBuffer) {
            super.marshall(byteBuffer);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public byte[] marshall() {
            return super.marshall();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popAll() {
            return super.popAll();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ Boolean popBool() {
            return super.popBool();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte popByte() {
            return super.popByte();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes() {
            return super.popBytes();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes32() {
            return super.popBytes32();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ double popDouble() {
            return super.popDouble();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ int popInt() {
            return super.popInt();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ long popInt64() {
            return super.popInt64();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ int[] popIntArray() {
            return super.popIntArray();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ short popShort() {
            return super.popShort();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ short[] popShortArray() {
            return super.popShortArray();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16() {
            return super.popString16();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16UTF8() {
            return super.popString16UTF8();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBool(Boolean bool) {
            super.pushBool(bool);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushByte(byte b) {
            super.pushByte(b);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes(byte[] bArr) {
            super.pushBytes(bArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes32(byte[] bArr) {
            super.pushBytes32(bArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushDouble(double d) {
            super.pushDouble(d);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt(int i) {
            super.pushInt(i);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt64(long j) {
            super.pushInt64(j);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(int[] iArr) {
            super.pushIntArray(iArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(Integer[] numArr) {
            super.pushIntArray(numArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShort(short s) {
            super.pushShort(s);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShortArray(short[] sArr) {
            super.pushShortArray(sArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushString16(String str) {
            super.pushString16(str);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushStringArray(ArrayList arrayList) {
            super.pushStringArray(arrayList);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void unmarshall(ByteBuffer byteBuffer) {
            super.unmarshall(byteBuffer);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.quality = popInt();
        }
    }

    public static class PMediaResNetworkQuality extends Marshallable {
        public int rxQuality;
        public int txQuality;
        public int uid;

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void clear() {
            super.clear();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ ByteBuffer getBuffer() {
            return super.getBuffer();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void marshall(ByteBuffer byteBuffer) {
            super.marshall(byteBuffer);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public byte[] marshall() {
            return super.marshall();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popAll() {
            return super.popAll();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ Boolean popBool() {
            return super.popBool();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte popByte() {
            return super.popByte();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes() {
            return super.popBytes();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes32() {
            return super.popBytes32();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ double popDouble() {
            return super.popDouble();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ int popInt() {
            return super.popInt();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ long popInt64() {
            return super.popInt64();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ int[] popIntArray() {
            return super.popIntArray();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ short popShort() {
            return super.popShort();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ short[] popShortArray() {
            return super.popShortArray();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16() {
            return super.popString16();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16UTF8() {
            return super.popString16UTF8();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBool(Boolean bool) {
            super.pushBool(bool);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushByte(byte b) {
            super.pushByte(b);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes(byte[] bArr) {
            super.pushBytes(bArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes32(byte[] bArr) {
            super.pushBytes32(bArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushDouble(double d) {
            super.pushDouble(d);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt(int i) {
            super.pushInt(i);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt64(long j) {
            super.pushInt64(j);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(int[] iArr) {
            super.pushIntArray(iArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(Integer[] numArr) {
            super.pushIntArray(numArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShort(short s) {
            super.pushShort(s);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShortArray(short[] sArr) {
            super.pushShortArray(sArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushString16(String str) {
            super.pushString16(str);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushStringArray(ArrayList arrayList) {
            super.pushStringArray(arrayList);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void unmarshall(ByteBuffer byteBuffer) {
            super.unmarshall(byteBuffer);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.uid = popInt();
            this.txQuality = popInt();
            this.rxQuality = popInt();
        }
    }

    public static class PMediaResRtcStats extends Marshallable {
        public int connectTimeMs;
        public int cpuAppUsage;
        public int cpuTotalUsage;
        public int gatewayRtt;
        public int lastmileDelay;
        public int memoryAppUsageInKbytes;
        public double memoryAppUsageRatio;
        public double memoryTotalUsageRatio;
        public int rxAudioBytes;
        public int rxAudioKBitRate;
        public int rxKBitRate;
        public int rxPacketLossRate;
        public int rxVideoBytes;
        public int rxVideoKBitRate;
        public int totalDuration;
        public int totalRxBytes;
        public int totalTxBytes;
        public int txAudioBytes;
        public int txAudioKBitRate;
        public int txKBitRate;
        public int txPacketLossRate;
        public int txVideoBytes;
        public int txVideoKBitRate;
        public int users;

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void clear() {
            super.clear();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ ByteBuffer getBuffer() {
            return super.getBuffer();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void marshall(ByteBuffer byteBuffer) {
            super.marshall(byteBuffer);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public byte[] marshall() {
            return super.marshall();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popAll() {
            return super.popAll();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ Boolean popBool() {
            return super.popBool();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte popByte() {
            return super.popByte();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes() {
            return super.popBytes();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes32() {
            return super.popBytes32();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ double popDouble() {
            return super.popDouble();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ int popInt() {
            return super.popInt();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ long popInt64() {
            return super.popInt64();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ int[] popIntArray() {
            return super.popIntArray();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ short popShort() {
            return super.popShort();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ short[] popShortArray() {
            return super.popShortArray();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16() {
            return super.popString16();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16UTF8() {
            return super.popString16UTF8();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBool(Boolean bool) {
            super.pushBool(bool);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushByte(byte b) {
            super.pushByte(b);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes(byte[] bArr) {
            super.pushBytes(bArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes32(byte[] bArr) {
            super.pushBytes32(bArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushDouble(double d) {
            super.pushDouble(d);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt(int i) {
            super.pushInt(i);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt64(long j) {
            super.pushInt64(j);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(int[] iArr) {
            super.pushIntArray(iArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(Integer[] numArr) {
            super.pushIntArray(numArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShort(short s) {
            super.pushShort(s);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShortArray(short[] sArr) {
            super.pushShortArray(sArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushString16(String str) {
            super.pushString16(str);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushStringArray(ArrayList arrayList) {
            super.pushStringArray(arrayList);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void unmarshall(ByteBuffer byteBuffer) {
            super.unmarshall(byteBuffer);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.totalDuration = popInt();
            this.totalTxBytes = popInt();
            this.totalRxBytes = popInt();
            this.txAudioBytes = popInt();
            this.rxAudioBytes = popInt();
            this.txVideoBytes = popInt();
            this.rxVideoBytes = popInt();
            this.txKBitRate = popShort();
            this.rxKBitRate = popShort();
            this.txAudioKBitRate = popShort();
            this.rxAudioKBitRate = popShort();
            this.txVideoKBitRate = popShort();
            this.rxVideoKBitRate = popShort();
            this.lastmileDelay = popShort();
            this.txPacketLossRate = popInt();
            this.rxPacketLossRate = popInt();
            this.cpuTotalUsage = popInt();
            this.gatewayRtt = popInt();
            this.cpuAppUsage = popInt();
            this.memoryAppUsageRatio = popDouble();
            this.memoryTotalUsageRatio = popDouble();
            this.memoryAppUsageInKbytes = popInt();
            this.users = popInt();
            this.connectTimeMs = popInt();
        }
    }

    public static class PMediaResSpeakersReport extends Marshallable {
        public int mixVolume;
        public Speaker[] speakers;

        public static class Speaker {
            public int uid;
            public int vad;
            public double voicePitch;
            public int volume;
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void clear() {
            super.clear();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ ByteBuffer getBuffer() {
            return super.getBuffer();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void marshall(ByteBuffer byteBuffer) {
            super.marshall(byteBuffer);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public byte[] marshall() {
            pushInt(this.mixVolume);
            int length = this.speakers.length;
            pushShort((short) length);
            for (int i = 0; i < length; i++) {
                pushInt(this.speakers[i].uid);
                pushInt(this.speakers[i].volume);
                pushInt(this.speakers[i].vad);
                pushDouble(this.speakers[i].voicePitch);
            }
            return super.marshall();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popAll() {
            return super.popAll();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ Boolean popBool() {
            return super.popBool();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte popByte() {
            return super.popByte();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes() {
            return super.popBytes();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes32() {
            return super.popBytes32();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ double popDouble() {
            return super.popDouble();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ int popInt() {
            return super.popInt();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ long popInt64() {
            return super.popInt64();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ int[] popIntArray() {
            return super.popIntArray();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ short popShort() {
            return super.popShort();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ short[] popShortArray() {
            return super.popShortArray();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16() {
            return super.popString16();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16UTF8() {
            return super.popString16UTF8();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBool(Boolean bool) {
            super.pushBool(bool);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushByte(byte b) {
            super.pushByte(b);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes(byte[] bArr) {
            super.pushBytes(bArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes32(byte[] bArr) {
            super.pushBytes32(bArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushDouble(double d) {
            super.pushDouble(d);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt(int i) {
            super.pushInt(i);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt64(long j) {
            super.pushInt64(j);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(int[] iArr) {
            super.pushIntArray(iArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(Integer[] numArr) {
            super.pushIntArray(numArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShort(short s) {
            super.pushShort(s);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShortArray(short[] sArr) {
            super.pushShortArray(sArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushString16(String str) {
            super.pushString16(str);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushStringArray(ArrayList arrayList) {
            super.pushStringArray(arrayList);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void unmarshall(ByteBuffer byteBuffer) {
            super.unmarshall(byteBuffer);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.mixVolume = popInt();
            int iPopShort = popShort();
            if (iPopShort > 0) {
                this.speakers = new Speaker[iPopShort];
                for (int i = 0; i < iPopShort; i++) {
                    this.speakers[i] = new Speaker();
                    this.speakers[i].uid = popInt();
                    this.speakers[i].volume = popInt();
                    this.speakers[i].vad = popInt();
                    this.speakers[i].voicePitch = popDouble();
                }
            }
        }
    }

    public static class PMediaResTransportQuality extends Marshallable {
        public int bitrate;
        public short delay;
        public boolean isAudio;
        public short lost;
        public int uid;

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void clear() {
            super.clear();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ ByteBuffer getBuffer() {
            return super.getBuffer();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void marshall(ByteBuffer byteBuffer) {
            super.marshall(byteBuffer);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public byte[] marshall() {
            return super.marshall();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popAll() {
            return super.popAll();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ Boolean popBool() {
            return super.popBool();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte popByte() {
            return super.popByte();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes() {
            return super.popBytes();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes32() {
            return super.popBytes32();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ double popDouble() {
            return super.popDouble();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ int popInt() {
            return super.popInt();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ long popInt64() {
            return super.popInt64();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ int[] popIntArray() {
            return super.popIntArray();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ short popShort() {
            return super.popShort();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ short[] popShortArray() {
            return super.popShortArray();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16() {
            return super.popString16();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16UTF8() {
            return super.popString16UTF8();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBool(Boolean bool) {
            super.pushBool(bool);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushByte(byte b) {
            super.pushByte(b);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes(byte[] bArr) {
            super.pushBytes(bArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes32(byte[] bArr) {
            super.pushBytes32(bArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushDouble(double d) {
            super.pushDouble(d);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt(int i) {
            super.pushInt(i);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt64(long j) {
            super.pushInt64(j);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(int[] iArr) {
            super.pushIntArray(iArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(Integer[] numArr) {
            super.pushIntArray(numArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShort(short s) {
            super.pushShort(s);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShortArray(short[] sArr) {
            super.pushShortArray(sArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushString16(String str) {
            super.pushString16(str);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushStringArray(ArrayList arrayList) {
            super.pushStringArray(arrayList);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void unmarshall(ByteBuffer byteBuffer) {
            super.unmarshall(byteBuffer);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.isAudio = popBool().booleanValue();
            this.uid = popInt();
            this.bitrate = popInt();
            this.delay = popShort();
            this.lost = popShort();
        }
    }

    public static class PMediaResUserJoinedEvent extends Marshallable {
        public int elapsed;
        public int uid;

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void clear() {
            super.clear();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ ByteBuffer getBuffer() {
            return super.getBuffer();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void marshall(ByteBuffer byteBuffer) {
            super.marshall(byteBuffer);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public byte[] marshall() {
            return super.marshall();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popAll() {
            return super.popAll();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ Boolean popBool() {
            return super.popBool();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte popByte() {
            return super.popByte();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes() {
            return super.popBytes();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes32() {
            return super.popBytes32();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ double popDouble() {
            return super.popDouble();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ int popInt() {
            return super.popInt();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ long popInt64() {
            return super.popInt64();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ int[] popIntArray() {
            return super.popIntArray();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ short popShort() {
            return super.popShort();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ short[] popShortArray() {
            return super.popShortArray();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16() {
            return super.popString16();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16UTF8() {
            return super.popString16UTF8();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBool(Boolean bool) {
            super.pushBool(bool);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushByte(byte b) {
            super.pushByte(b);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes(byte[] bArr) {
            super.pushBytes(bArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes32(byte[] bArr) {
            super.pushBytes32(bArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushDouble(double d) {
            super.pushDouble(d);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt(int i) {
            super.pushInt(i);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt64(long j) {
            super.pushInt64(j);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(int[] iArr) {
            super.pushIntArray(iArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(Integer[] numArr) {
            super.pushIntArray(numArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShort(short s) {
            super.pushShort(s);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShortArray(short[] sArr) {
            super.pushShortArray(sArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushString16(String str) {
            super.pushString16(str);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushStringArray(ArrayList arrayList) {
            super.pushStringArray(arrayList);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void unmarshall(ByteBuffer byteBuffer) {
            super.unmarshall(byteBuffer);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.uid = popInt();
            this.elapsed = popInt();
        }
    }

    public static class PMediaResUserOfflineEvent extends Marshallable {
        public int reason;
        public int uid;

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void clear() {
            super.clear();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ ByteBuffer getBuffer() {
            return super.getBuffer();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void marshall(ByteBuffer byteBuffer) {
            super.marshall(byteBuffer);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public byte[] marshall() {
            return super.marshall();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popAll() {
            return super.popAll();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ Boolean popBool() {
            return super.popBool();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte popByte() {
            return super.popByte();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes() {
            return super.popBytes();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes32() {
            return super.popBytes32();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ double popDouble() {
            return super.popDouble();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ int popInt() {
            return super.popInt();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ long popInt64() {
            return super.popInt64();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ int[] popIntArray() {
            return super.popIntArray();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ short popShort() {
            return super.popShort();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ short[] popShortArray() {
            return super.popShortArray();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16() {
            return super.popString16();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16UTF8() {
            return super.popString16UTF8();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBool(Boolean bool) {
            super.pushBool(bool);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushByte(byte b) {
            super.pushByte(b);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes(byte[] bArr) {
            super.pushBytes(bArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes32(byte[] bArr) {
            super.pushBytes32(bArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushDouble(double d) {
            super.pushDouble(d);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt(int i) {
            super.pushInt(i);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt64(long j) {
            super.pushInt64(j);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(int[] iArr) {
            super.pushIntArray(iArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(Integer[] numArr) {
            super.pushIntArray(numArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShort(short s) {
            super.pushShort(s);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShortArray(short[] sArr) {
            super.pushShortArray(sArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushString16(String str) {
            super.pushString16(str);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushStringArray(ArrayList arrayList) {
            super.pushStringArray(arrayList);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void unmarshall(ByteBuffer byteBuffer) {
            super.unmarshall(byteBuffer);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.uid = popInt();
            this.reason = popInt();
        }
    }

    public static class PMediaResUserState extends Marshallable {
        public boolean state;
        public int uid;

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void clear() {
            super.clear();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ ByteBuffer getBuffer() {
            return super.getBuffer();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void marshall(ByteBuffer byteBuffer) {
            super.marshall(byteBuffer);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public byte[] marshall() {
            return super.marshall();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popAll() {
            return super.popAll();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ Boolean popBool() {
            return super.popBool();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte popByte() {
            return super.popByte();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes() {
            return super.popBytes();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes32() {
            return super.popBytes32();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ double popDouble() {
            return super.popDouble();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ int popInt() {
            return super.popInt();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ long popInt64() {
            return super.popInt64();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ int[] popIntArray() {
            return super.popIntArray();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ short popShort() {
            return super.popShort();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ short[] popShortArray() {
            return super.popShortArray();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16() {
            return super.popString16();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16UTF8() {
            return super.popString16UTF8();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBool(Boolean bool) {
            super.pushBool(bool);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushByte(byte b) {
            super.pushByte(b);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes(byte[] bArr) {
            super.pushBytes(bArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes32(byte[] bArr) {
            super.pushBytes32(bArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushDouble(double d) {
            super.pushDouble(d);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt(int i) {
            super.pushInt(i);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt64(long j) {
            super.pushInt64(j);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(int[] iArr) {
            super.pushIntArray(iArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(Integer[] numArr) {
            super.pushIntArray(numArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShort(short s) {
            super.pushShort(s);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShortArray(short[] sArr) {
            super.pushShortArray(sArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushString16(String str) {
            super.pushString16(str);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushStringArray(ArrayList arrayList) {
            super.pushStringArray(arrayList);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void unmarshall(ByteBuffer byteBuffer) {
            super.unmarshall(byteBuffer);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.uid = popInt();
            this.state = popBool().booleanValue();
        }
    }

    public static class PMediaResWlAccMessage extends Marshallable {
        public int action;
        public int reason;
        public String wlAccMsg;

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void clear() {
            super.clear();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ ByteBuffer getBuffer() {
            return super.getBuffer();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void marshall(ByteBuffer byteBuffer) {
            super.marshall(byteBuffer);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public byte[] marshall() {
            pushInt(this.reason);
            pushInt(this.action);
            pushString16(this.wlAccMsg);
            return super.marshall();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popAll() {
            return super.popAll();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ Boolean popBool() {
            return super.popBool();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte popByte() {
            return super.popByte();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes() {
            return super.popBytes();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes32() {
            return super.popBytes32();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ double popDouble() {
            return super.popDouble();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ int popInt() {
            return super.popInt();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ long popInt64() {
            return super.popInt64();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ int[] popIntArray() {
            return super.popIntArray();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ short popShort() {
            return super.popShort();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ short[] popShortArray() {
            return super.popShortArray();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16() {
            return super.popString16();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16UTF8() {
            return super.popString16UTF8();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBool(Boolean bool) {
            super.pushBool(bool);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushByte(byte b) {
            super.pushByte(b);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes(byte[] bArr) {
            super.pushBytes(bArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes32(byte[] bArr) {
            super.pushBytes32(bArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushDouble(double d) {
            super.pushDouble(d);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt(int i) {
            super.pushInt(i);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt64(long j) {
            super.pushInt64(j);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(int[] iArr) {
            super.pushIntArray(iArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(Integer[] numArr) {
            super.pushIntArray(numArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShort(short s) {
            super.pushShort(s);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShortArray(short[] sArr) {
            super.pushShortArray(sArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushString16(String str) {
            super.pushString16(str);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushStringArray(ArrayList arrayList) {
            super.pushStringArray(arrayList);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void unmarshall(ByteBuffer byteBuffer) {
            super.unmarshall(byteBuffer);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.reason = popInt();
            this.action = popInt();
            this.wlAccMsg = popString16UTF8();
        }
    }

    public static class PMediaResWlAccStats extends Marshallable {
        public short e2eDelayPercentAve;
        public short e2eDelayPercentCur;
        public short frozenRatioPercentAve;
        public short frozenRatioPercentCur;
        public short lossRatePercentAve;
        public short lossRatePercentCur;

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void clear() {
            super.clear();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ ByteBuffer getBuffer() {
            return super.getBuffer();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void marshall(ByteBuffer byteBuffer) {
            super.marshall(byteBuffer);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public byte[] marshall() {
            pushShort(this.e2eDelayPercentCur);
            pushShort(this.frozenRatioPercentCur);
            pushShort(this.lossRatePercentCur);
            pushShort(this.e2eDelayPercentAve);
            pushShort(this.frozenRatioPercentAve);
            pushShort(this.lossRatePercentAve);
            return super.marshall();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popAll() {
            return super.popAll();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ Boolean popBool() {
            return super.popBool();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte popByte() {
            return super.popByte();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes() {
            return super.popBytes();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes32() {
            return super.popBytes32();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ double popDouble() {
            return super.popDouble();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ int popInt() {
            return super.popInt();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ long popInt64() {
            return super.popInt64();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ int[] popIntArray() {
            return super.popIntArray();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ short popShort() {
            return super.popShort();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ short[] popShortArray() {
            return super.popShortArray();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16() {
            return super.popString16();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16UTF8() {
            return super.popString16UTF8();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBool(Boolean bool) {
            super.pushBool(bool);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushByte(byte b) {
            super.pushByte(b);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes(byte[] bArr) {
            super.pushBytes(bArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes32(byte[] bArr) {
            super.pushBytes32(bArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushDouble(double d) {
            super.pushDouble(d);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt(int i) {
            super.pushInt(i);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt64(long j) {
            super.pushInt64(j);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(int[] iArr) {
            super.pushIntArray(iArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(Integer[] numArr) {
            super.pushIntArray(numArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShort(short s) {
            super.pushShort(s);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShortArray(short[] sArr) {
            super.pushShortArray(sArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushString16(String str) {
            super.pushString16(str);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushStringArray(ArrayList arrayList) {
            super.pushStringArray(arrayList);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void unmarshall(ByteBuffer byteBuffer) {
            super.unmarshall(byteBuffer);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.e2eDelayPercentCur = popShort();
            this.frozenRatioPercentCur = popShort();
            this.lossRatePercentCur = popShort();
            this.e2eDelayPercentAve = popShort();
            this.frozenRatioPercentAve = popShort();
            this.lossRatePercentAve = popShort();
        }
    }

    public static class PNetworkTypeChanged extends Marshallable {
        public int type;

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void clear() {
            super.clear();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ ByteBuffer getBuffer() {
            return super.getBuffer();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void marshall(ByteBuffer byteBuffer) {
            super.marshall(byteBuffer);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public byte[] marshall() {
            pushInt(this.type);
            return super.marshall();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popAll() {
            return super.popAll();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ Boolean popBool() {
            return super.popBool();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte popByte() {
            return super.popByte();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes() {
            return super.popBytes();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes32() {
            return super.popBytes32();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ double popDouble() {
            return super.popDouble();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ int popInt() {
            return super.popInt();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ long popInt64() {
            return super.popInt64();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ int[] popIntArray() {
            return super.popIntArray();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ short popShort() {
            return super.popShort();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ short[] popShortArray() {
            return super.popShortArray();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16() {
            return super.popString16();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16UTF8() {
            return super.popString16UTF8();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBool(Boolean bool) {
            super.pushBool(bool);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushByte(byte b) {
            super.pushByte(b);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes(byte[] bArr) {
            super.pushBytes(bArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes32(byte[] bArr) {
            super.pushBytes32(bArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushDouble(double d) {
            super.pushDouble(d);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt(int i) {
            super.pushInt(i);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt64(long j) {
            super.pushInt64(j);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(int[] iArr) {
            super.pushIntArray(iArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(Integer[] numArr) {
            super.pushIntArray(numArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShort(short s) {
            super.pushShort(s);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShortArray(short[] sArr) {
            super.pushShortArray(sArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushString16(String str) {
            super.pushString16(str);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushStringArray(ArrayList arrayList) {
            super.pushStringArray(arrayList);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void unmarshall(ByteBuffer byteBuffer) {
            super.unmarshall(byteBuffer);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.type = popInt();
        }
    }

    public static class PPermissionError extends Marshallable {
        public int permission;

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void clear() {
            super.clear();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ ByteBuffer getBuffer() {
            return super.getBuffer();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void marshall(ByteBuffer byteBuffer) {
            super.marshall(byteBuffer);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public byte[] marshall() {
            pushInt(this.permission);
            return super.marshall();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popAll() {
            return super.popAll();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ Boolean popBool() {
            return super.popBool();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte popByte() {
            return super.popByte();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes() {
            return super.popBytes();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes32() {
            return super.popBytes32();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ double popDouble() {
            return super.popDouble();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ int popInt() {
            return super.popInt();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ long popInt64() {
            return super.popInt64();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ int[] popIntArray() {
            return super.popIntArray();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ short popShort() {
            return super.popShort();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ short[] popShortArray() {
            return super.popShortArray();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16() {
            return super.popString16();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16UTF8() {
            return super.popString16UTF8();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBool(Boolean bool) {
            super.pushBool(bool);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushByte(byte b) {
            super.pushByte(b);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes(byte[] bArr) {
            super.pushBytes(bArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes32(byte[] bArr) {
            super.pushBytes32(bArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushDouble(double d) {
            super.pushDouble(d);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt(int i) {
            super.pushInt(i);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt64(long j) {
            super.pushInt64(j);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(int[] iArr) {
            super.pushIntArray(iArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(Integer[] numArr) {
            super.pushIntArray(numArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShort(short s) {
            super.pushShort(s);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShortArray(short[] sArr) {
            super.pushShortArray(sArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushString16(String str) {
            super.pushString16(str);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushStringArray(ArrayList arrayList) {
            super.pushStringArray(arrayList);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void unmarshall(ByteBuffer byteBuffer) {
            super.unmarshall(byteBuffer);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.permission = popInt();
        }
    }

    public static class PPrivilegeWillExpire extends Marshallable {
        public String token;

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void clear() {
            super.clear();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ ByteBuffer getBuffer() {
            return super.getBuffer();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void marshall(ByteBuffer byteBuffer) {
            super.marshall(byteBuffer);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public byte[] marshall() {
            pushBytes(this.token.getBytes());
            return super.marshall();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popAll() {
            return super.popAll();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ Boolean popBool() {
            return super.popBool();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte popByte() {
            return super.popByte();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes() {
            return super.popBytes();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes32() {
            return super.popBytes32();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ double popDouble() {
            return super.popDouble();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ int popInt() {
            return super.popInt();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ long popInt64() {
            return super.popInt64();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ int[] popIntArray() {
            return super.popIntArray();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ short popShort() {
            return super.popShort();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ short[] popShortArray() {
            return super.popShortArray();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16() {
            return super.popString16();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16UTF8() {
            return super.popString16UTF8();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBool(Boolean bool) {
            super.pushBool(bool);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushByte(byte b) {
            super.pushByte(b);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes(byte[] bArr) {
            super.pushBytes(bArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes32(byte[] bArr) {
            super.pushBytes32(bArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushDouble(double d) {
            super.pushDouble(d);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt(int i) {
            super.pushInt(i);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt64(long j) {
            super.pushInt64(j);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(int[] iArr) {
            super.pushIntArray(iArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(Integer[] numArr) {
            super.pushIntArray(numArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShort(short s) {
            super.pushShort(s);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShortArray(short[] sArr) {
            super.pushShortArray(sArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushString16(String str) {
            super.pushString16(str);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushStringArray(ArrayList arrayList) {
            super.pushStringArray(arrayList);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void unmarshall(ByteBuffer byteBuffer) {
            super.unmarshall(byteBuffer);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.token = popString16UTF8();
        }
    }

    public static class PProxyConnect extends Marshallable {
        public String channel;
        public int elapsed;
        public String localProxyIp;
        public int proxyType;
        public int uid;

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void clear() {
            super.clear();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ ByteBuffer getBuffer() {
            return super.getBuffer();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void marshall(ByteBuffer byteBuffer) {
            super.marshall(byteBuffer);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public byte[] marshall() {
            return super.marshall();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popAll() {
            return super.popAll();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ Boolean popBool() {
            return super.popBool();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte popByte() {
            return super.popByte();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes() {
            return super.popBytes();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes32() {
            return super.popBytes32();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ double popDouble() {
            return super.popDouble();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ int popInt() {
            return super.popInt();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ long popInt64() {
            return super.popInt64();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ int[] popIntArray() {
            return super.popIntArray();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ short popShort() {
            return super.popShort();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ short[] popShortArray() {
            return super.popShortArray();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16() {
            return super.popString16();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16UTF8() {
            return super.popString16UTF8();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBool(Boolean bool) {
            super.pushBool(bool);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushByte(byte b) {
            super.pushByte(b);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes(byte[] bArr) {
            super.pushBytes(bArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes32(byte[] bArr) {
            super.pushBytes32(bArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushDouble(double d) {
            super.pushDouble(d);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt(int i) {
            super.pushInt(i);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt64(long j) {
            super.pushInt64(j);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(int[] iArr) {
            super.pushIntArray(iArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(Integer[] numArr) {
            super.pushIntArray(numArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShort(short s) {
            super.pushShort(s);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShortArray(short[] sArr) {
            super.pushShortArray(sArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushString16(String str) {
            super.pushString16(str);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushStringArray(ArrayList arrayList) {
            super.pushStringArray(arrayList);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void unmarshall(ByteBuffer byteBuffer) {
            super.unmarshall(byteBuffer);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.channel = popString16UTF8();
            this.uid = popInt();
            this.proxyType = popInt();
            this.localProxyIp = popString16UTF8();
            this.elapsed = popInt();
        }
    }

    public static class PPublishAudioStateChanged extends Marshallable {
        public String channelId;
        public int elapseSinceLastState;
        public short newState;
        public short oldState;

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void clear() {
            super.clear();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ ByteBuffer getBuffer() {
            return super.getBuffer();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void marshall(ByteBuffer byteBuffer) {
            super.marshall(byteBuffer);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public byte[] marshall() {
            return super.marshall();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popAll() {
            return super.popAll();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ Boolean popBool() {
            return super.popBool();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte popByte() {
            return super.popByte();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes() {
            return super.popBytes();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes32() {
            return super.popBytes32();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ double popDouble() {
            return super.popDouble();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ int popInt() {
            return super.popInt();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ long popInt64() {
            return super.popInt64();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ int[] popIntArray() {
            return super.popIntArray();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ short popShort() {
            return super.popShort();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ short[] popShortArray() {
            return super.popShortArray();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16() {
            return super.popString16();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16UTF8() {
            return super.popString16UTF8();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBool(Boolean bool) {
            super.pushBool(bool);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushByte(byte b) {
            super.pushByte(b);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes(byte[] bArr) {
            super.pushBytes(bArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes32(byte[] bArr) {
            super.pushBytes32(bArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushDouble(double d) {
            super.pushDouble(d);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt(int i) {
            super.pushInt(i);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt64(long j) {
            super.pushInt64(j);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(int[] iArr) {
            super.pushIntArray(iArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(Integer[] numArr) {
            super.pushIntArray(numArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShort(short s) {
            super.pushShort(s);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShortArray(short[] sArr) {
            super.pushShortArray(sArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushString16(String str) {
            super.pushString16(str);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushStringArray(ArrayList arrayList) {
            super.pushStringArray(arrayList);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void unmarshall(ByteBuffer byteBuffer) {
            super.unmarshall(byteBuffer);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.channelId = popString16UTF8();
            this.oldState = popShort();
            this.newState = popShort();
            this.elapseSinceLastState = popInt();
        }
    }

    public static class PPublishVideoStateChanged extends Marshallable {
        public String channelId;
        public int elapseSinceLastState;
        public short newState;
        public short oldState;
        public int source;

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void clear() {
            super.clear();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ ByteBuffer getBuffer() {
            return super.getBuffer();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void marshall(ByteBuffer byteBuffer) {
            super.marshall(byteBuffer);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public byte[] marshall() {
            return super.marshall();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popAll() {
            return super.popAll();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ Boolean popBool() {
            return super.popBool();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte popByte() {
            return super.popByte();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes() {
            return super.popBytes();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes32() {
            return super.popBytes32();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ double popDouble() {
            return super.popDouble();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ int popInt() {
            return super.popInt();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ long popInt64() {
            return super.popInt64();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ int[] popIntArray() {
            return super.popIntArray();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ short popShort() {
            return super.popShort();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ short[] popShortArray() {
            return super.popShortArray();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16() {
            return super.popString16();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16UTF8() {
            return super.popString16UTF8();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBool(Boolean bool) {
            super.pushBool(bool);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushByte(byte b) {
            super.pushByte(b);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes(byte[] bArr) {
            super.pushBytes(bArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes32(byte[] bArr) {
            super.pushBytes32(bArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushDouble(double d) {
            super.pushDouble(d);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt(int i) {
            super.pushInt(i);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt64(long j) {
            super.pushInt64(j);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(int[] iArr) {
            super.pushIntArray(iArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(Integer[] numArr) {
            super.pushIntArray(numArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShort(short s) {
            super.pushShort(s);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShortArray(short[] sArr) {
            super.pushShortArray(sArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushString16(String str) {
            super.pushString16(str);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushStringArray(ArrayList arrayList) {
            super.pushStringArray(arrayList);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void unmarshall(ByteBuffer byteBuffer) {
            super.unmarshall(byteBuffer);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.source = popByte();
            this.channelId = popString16UTF8();
            this.oldState = popShort();
            this.newState = popShort();
            this.elapseSinceLastState = popInt();
        }
    }

    public static class PRemoteAudioStat extends Marshallable {
        public IRtcEngineEventHandler.RemoteAudioStats stats = new IRtcEngineEventHandler.RemoteAudioStats();

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void clear() {
            super.clear();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ ByteBuffer getBuffer() {
            return super.getBuffer();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void marshall(ByteBuffer byteBuffer) {
            super.marshall(byteBuffer);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public byte[] marshall() {
            pushInt(this.stats.uid);
            pushInt(this.stats.quality);
            pushInt(this.stats.networkTransportDelay);
            pushInt(this.stats.jitterBufferDelay);
            pushInt(this.stats.audioLossRate);
            pushInt(this.stats.numChannels);
            pushInt(this.stats.receivedSampleRate);
            pushInt(this.stats.receivedBitrate);
            pushInt(this.stats.totalFrozenTime);
            pushInt(this.stats.frozenRate);
            pushInt64(this.stats.totalActiveTime);
            pushInt64(this.stats.publishDuration);
            pushInt(this.stats.qoeQuality);
            pushInt(this.stats.qualityChangedReason);
            pushInt(this.stats.mosValue);
            pushInt(this.stats.frozenRateByCustomPlcCount);
            pushInt(this.stats.plcCount);
            pushInt(this.stats.rxAudioBytes);
            return super.marshall();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popAll() {
            return super.popAll();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ Boolean popBool() {
            return super.popBool();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte popByte() {
            return super.popByte();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes() {
            return super.popBytes();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes32() {
            return super.popBytes32();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ double popDouble() {
            return super.popDouble();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ int popInt() {
            return super.popInt();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ long popInt64() {
            return super.popInt64();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ int[] popIntArray() {
            return super.popIntArray();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ short popShort() {
            return super.popShort();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ short[] popShortArray() {
            return super.popShortArray();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16() {
            return super.popString16();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16UTF8() {
            return super.popString16UTF8();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBool(Boolean bool) {
            super.pushBool(bool);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushByte(byte b) {
            super.pushByte(b);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes(byte[] bArr) {
            super.pushBytes(bArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes32(byte[] bArr) {
            super.pushBytes32(bArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushDouble(double d) {
            super.pushDouble(d);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt(int i) {
            super.pushInt(i);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt64(long j) {
            super.pushInt64(j);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(int[] iArr) {
            super.pushIntArray(iArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(Integer[] numArr) {
            super.pushIntArray(numArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShort(short s) {
            super.pushShort(s);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShortArray(short[] sArr) {
            super.pushShortArray(sArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushString16(String str) {
            super.pushString16(str);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushStringArray(ArrayList arrayList) {
            super.pushStringArray(arrayList);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void unmarshall(ByteBuffer byteBuffer) {
            super.unmarshall(byteBuffer);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.stats.uid = popInt();
            this.stats.quality = popInt();
            this.stats.networkTransportDelay = popInt();
            this.stats.jitterBufferDelay = popInt();
            this.stats.audioLossRate = popInt();
            this.stats.numChannels = popInt();
            this.stats.receivedSampleRate = popInt();
            this.stats.receivedBitrate = popInt();
            this.stats.totalFrozenTime = popInt();
            this.stats.frozenRate = popInt();
            this.stats.totalActiveTime = popInt64();
            this.stats.publishDuration = popInt64();
            this.stats.qoeQuality = popInt();
            this.stats.qualityChangedReason = popInt();
            this.stats.mosValue = popInt();
            this.stats.frozenRateByCustomPlcCount = popInt();
            this.stats.plcCount = popInt();
            this.stats.rxAudioBytes = popInt();
        }
    }

    public static class PRemoteAudioState extends Marshallable {
        public int elapsed;
        public int reason;
        public int state;
        public int uid;

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void clear() {
            super.clear();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ ByteBuffer getBuffer() {
            return super.getBuffer();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void marshall(ByteBuffer byteBuffer) {
            super.marshall(byteBuffer);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public byte[] marshall() {
            pushInt(this.uid);
            pushByte((byte) this.state);
            pushByte((byte) this.reason);
            pushByte((byte) this.elapsed);
            return super.marshall();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popAll() {
            return super.popAll();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ Boolean popBool() {
            return super.popBool();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte popByte() {
            return super.popByte();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes() {
            return super.popBytes();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes32() {
            return super.popBytes32();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ double popDouble() {
            return super.popDouble();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ int popInt() {
            return super.popInt();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ long popInt64() {
            return super.popInt64();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ int[] popIntArray() {
            return super.popIntArray();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ short popShort() {
            return super.popShort();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ short[] popShortArray() {
            return super.popShortArray();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16() {
            return super.popString16();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16UTF8() {
            return super.popString16UTF8();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBool(Boolean bool) {
            super.pushBool(bool);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushByte(byte b) {
            super.pushByte(b);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes(byte[] bArr) {
            super.pushBytes(bArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes32(byte[] bArr) {
            super.pushBytes32(bArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushDouble(double d) {
            super.pushDouble(d);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt(int i) {
            super.pushInt(i);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt64(long j) {
            super.pushInt64(j);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(int[] iArr) {
            super.pushIntArray(iArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(Integer[] numArr) {
            super.pushIntArray(numArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShort(short s) {
            super.pushShort(s);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShortArray(short[] sArr) {
            super.pushShortArray(sArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushString16(String str) {
            super.pushString16(str);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushStringArray(ArrayList arrayList) {
            super.pushStringArray(arrayList);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void unmarshall(ByteBuffer byteBuffer) {
            super.unmarshall(byteBuffer);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.uid = popInt();
            this.state = popByte();
            this.reason = popByte();
            this.elapsed = popInt();
        }
    }

    public static class PRemoteVideoStat extends Marshallable {
        public IRtcEngineEventHandler.RemoteVideoStats stats = new IRtcEngineEventHandler.RemoteVideoStats();

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void clear() {
            super.clear();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ ByteBuffer getBuffer() {
            return super.getBuffer();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void marshall(ByteBuffer byteBuffer) {
            super.marshall(byteBuffer);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public byte[] marshall() {
            pushInt(this.stats.uid);
            pushInt(this.stats.delay);
            pushInt(this.stats.e2eDelay);
            pushInt(this.stats.width);
            pushInt(this.stats.height);
            pushInt(this.stats.receivedBitrate);
            pushInt(this.stats.decoderOutputFrameRate);
            pushInt(this.stats.rendererOutputFrameRate);
            pushInt(this.stats.frameLossRate);
            pushInt(this.stats.packetLossRate);
            pushInt(this.stats.rxStreamType);
            pushInt(this.stats.totalFrozenTime);
            pushInt(this.stats.frozenRate);
            pushInt(this.stats.avSyncTimeMs);
            pushInt64(this.stats.totalActiveTime);
            pushInt64(this.stats.publishDuration);
            pushInt(this.stats.mosValue);
            pushInt(this.stats.rxVideoBytes);
            return super.marshall();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popAll() {
            return super.popAll();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ Boolean popBool() {
            return super.popBool();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte popByte() {
            return super.popByte();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes() {
            return super.popBytes();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes32() {
            return super.popBytes32();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ double popDouble() {
            return super.popDouble();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ int popInt() {
            return super.popInt();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ long popInt64() {
            return super.popInt64();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ int[] popIntArray() {
            return super.popIntArray();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ short popShort() {
            return super.popShort();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ short[] popShortArray() {
            return super.popShortArray();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16() {
            return super.popString16();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16UTF8() {
            return super.popString16UTF8();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBool(Boolean bool) {
            super.pushBool(bool);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushByte(byte b) {
            super.pushByte(b);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes(byte[] bArr) {
            super.pushBytes(bArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes32(byte[] bArr) {
            super.pushBytes32(bArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushDouble(double d) {
            super.pushDouble(d);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt(int i) {
            super.pushInt(i);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt64(long j) {
            super.pushInt64(j);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(int[] iArr) {
            super.pushIntArray(iArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(Integer[] numArr) {
            super.pushIntArray(numArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShort(short s) {
            super.pushShort(s);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShortArray(short[] sArr) {
            super.pushShortArray(sArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushString16(String str) {
            super.pushString16(str);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushStringArray(ArrayList arrayList) {
            super.pushStringArray(arrayList);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void unmarshall(ByteBuffer byteBuffer) {
            super.unmarshall(byteBuffer);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.stats.uid = popInt();
            this.stats.delay = popInt();
            this.stats.e2eDelay = popInt();
            this.stats.width = popInt();
            this.stats.height = popInt();
            this.stats.receivedBitrate = popInt();
            this.stats.decoderOutputFrameRate = popInt();
            this.stats.rendererOutputFrameRate = popInt();
            this.stats.frameLossRate = popInt();
            this.stats.packetLossRate = popInt();
            this.stats.rxStreamType = popInt();
            this.stats.totalFrozenTime = popInt();
            this.stats.frozenRate = popInt();
            this.stats.avSyncTimeMs = popInt();
            this.stats.totalActiveTime = popInt64();
            this.stats.publishDuration = popInt64();
            this.stats.mosValue = popInt();
            this.stats.rxVideoBytes = popInt();
        }
    }

    public static class PRemoteVideoState extends Marshallable {
        public int elapsed;
        public int reason;
        public int state;
        public int uid;

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void clear() {
            super.clear();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ ByteBuffer getBuffer() {
            return super.getBuffer();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void marshall(ByteBuffer byteBuffer) {
            super.marshall(byteBuffer);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public byte[] marshall() {
            pushInt(this.uid);
            pushInt(this.state);
            return super.marshall();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popAll() {
            return super.popAll();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ Boolean popBool() {
            return super.popBool();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte popByte() {
            return super.popByte();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes() {
            return super.popBytes();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes32() {
            return super.popBytes32();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ double popDouble() {
            return super.popDouble();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ int popInt() {
            return super.popInt();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ long popInt64() {
            return super.popInt64();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ int[] popIntArray() {
            return super.popIntArray();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ short popShort() {
            return super.popShort();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ short[] popShortArray() {
            return super.popShortArray();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16() {
            return super.popString16();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16UTF8() {
            return super.popString16UTF8();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBool(Boolean bool) {
            super.pushBool(bool);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushByte(byte b) {
            super.pushByte(b);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes(byte[] bArr) {
            super.pushBytes(bArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes32(byte[] bArr) {
            super.pushBytes32(bArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushDouble(double d) {
            super.pushDouble(d);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt(int i) {
            super.pushInt(i);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt64(long j) {
            super.pushInt64(j);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(int[] iArr) {
            super.pushIntArray(iArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(Integer[] numArr) {
            super.pushIntArray(numArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShort(short s) {
            super.pushShort(s);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShortArray(short[] sArr) {
            super.pushShortArray(sArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushString16(String str) {
            super.pushString16(str);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushStringArray(ArrayList arrayList) {
            super.pushStringArray(arrayList);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void unmarshall(ByteBuffer byteBuffer) {
            super.unmarshall(byteBuffer);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.uid = popInt();
            this.state = popByte();
            this.reason = popByte();
            this.elapsed = popInt();
        }
    }

    public static class PRhythmPlayerStateChanged extends Marshallable {
        public int errorCode;
        public int state;

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void clear() {
            super.clear();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ ByteBuffer getBuffer() {
            return super.getBuffer();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void marshall(ByteBuffer byteBuffer) {
            super.marshall(byteBuffer);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public byte[] marshall() {
            return super.marshall();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popAll() {
            return super.popAll();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ Boolean popBool() {
            return super.popBool();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte popByte() {
            return super.popByte();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes() {
            return super.popBytes();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes32() {
            return super.popBytes32();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ double popDouble() {
            return super.popDouble();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ int popInt() {
            return super.popInt();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ long popInt64() {
            return super.popInt64();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ int[] popIntArray() {
            return super.popIntArray();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ short popShort() {
            return super.popShort();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ short[] popShortArray() {
            return super.popShortArray();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16() {
            return super.popString16();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16UTF8() {
            return super.popString16UTF8();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBool(Boolean bool) {
            super.pushBool(bool);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushByte(byte b) {
            super.pushByte(b);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes(byte[] bArr) {
            super.pushBytes(bArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes32(byte[] bArr) {
            super.pushBytes32(bArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushDouble(double d) {
            super.pushDouble(d);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt(int i) {
            super.pushInt(i);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt64(long j) {
            super.pushInt64(j);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(int[] iArr) {
            super.pushIntArray(iArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(Integer[] numArr) {
            super.pushIntArray(numArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShort(short s) {
            super.pushShort(s);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShortArray(short[] sArr) {
            super.pushShortArray(sArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushString16(String str) {
            super.pushString16(str);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushStringArray(ArrayList arrayList) {
            super.pushStringArray(arrayList);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void unmarshall(ByteBuffer byteBuffer) {
            super.unmarshall(byteBuffer);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.state = popInt();
            this.errorCode = popInt();
        }
    }

    public static class PSnapshotTaken extends Marshallable {
        public int errCode;
        public String filepath;
        public int height;
        public int uid;
        public int width;

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void clear() {
            super.clear();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ ByteBuffer getBuffer() {
            return super.getBuffer();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void marshall(ByteBuffer byteBuffer) {
            super.marshall(byteBuffer);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public byte[] marshall() {
            pushInt(this.uid);
            pushBytes(this.filepath.getBytes());
            pushInt(this.width);
            pushInt(this.height);
            pushInt(this.errCode);
            return super.marshall();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popAll() {
            return super.popAll();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ Boolean popBool() {
            return super.popBool();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte popByte() {
            return super.popByte();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes() {
            return super.popBytes();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes32() {
            return super.popBytes32();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ double popDouble() {
            return super.popDouble();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ int popInt() {
            return super.popInt();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ long popInt64() {
            return super.popInt64();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ int[] popIntArray() {
            return super.popIntArray();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ short popShort() {
            return super.popShort();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ short[] popShortArray() {
            return super.popShortArray();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16() {
            return super.popString16();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16UTF8() {
            return super.popString16UTF8();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBool(Boolean bool) {
            super.pushBool(bool);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushByte(byte b) {
            super.pushByte(b);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes(byte[] bArr) {
            super.pushBytes(bArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes32(byte[] bArr) {
            super.pushBytes32(bArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushDouble(double d) {
            super.pushDouble(d);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt(int i) {
            super.pushInt(i);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt64(long j) {
            super.pushInt64(j);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(int[] iArr) {
            super.pushIntArray(iArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(Integer[] numArr) {
            super.pushIntArray(numArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShort(short s) {
            super.pushShort(s);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShortArray(short[] sArr) {
            super.pushShortArray(sArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushString16(String str) {
            super.pushString16(str);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushStringArray(ArrayList arrayList) {
            super.pushStringArray(arrayList);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void unmarshall(ByteBuffer byteBuffer) {
            super.unmarshall(byteBuffer);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.uid = popInt();
            this.filepath = popString16UTF8();
            this.width = popInt();
            this.height = popInt();
            this.errCode = popInt();
        }
    }

    public static class PStreamInjectedStatus extends Marshallable {
        public int status;
        public String url;
        public int userId;

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void clear() {
            super.clear();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ ByteBuffer getBuffer() {
            return super.getBuffer();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void marshall(ByteBuffer byteBuffer) {
            super.marshall(byteBuffer);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public byte[] marshall() {
            pushBytes(this.url.getBytes());
            pushInt(this.userId);
            pushInt(this.status);
            return super.marshall();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popAll() {
            return super.popAll();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ Boolean popBool() {
            return super.popBool();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte popByte() {
            return super.popByte();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes() {
            return super.popBytes();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes32() {
            return super.popBytes32();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ double popDouble() {
            return super.popDouble();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ int popInt() {
            return super.popInt();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ long popInt64() {
            return super.popInt64();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ int[] popIntArray() {
            return super.popIntArray();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ short popShort() {
            return super.popShort();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ short[] popShortArray() {
            return super.popShortArray();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16() {
            return super.popString16();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16UTF8() {
            return super.popString16UTF8();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBool(Boolean bool) {
            super.pushBool(bool);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushByte(byte b) {
            super.pushByte(b);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes(byte[] bArr) {
            super.pushBytes(bArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes32(byte[] bArr) {
            super.pushBytes32(bArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushDouble(double d) {
            super.pushDouble(d);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt(int i) {
            super.pushInt(i);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt64(long j) {
            super.pushInt64(j);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(int[] iArr) {
            super.pushIntArray(iArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(Integer[] numArr) {
            super.pushIntArray(numArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShort(short s) {
            super.pushShort(s);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShortArray(short[] sArr) {
            super.pushShortArray(sArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushString16(String str) {
            super.pushString16(str);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushStringArray(ArrayList arrayList) {
            super.pushStringArray(arrayList);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void unmarshall(ByteBuffer byteBuffer) {
            super.unmarshall(byteBuffer);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.url = popString16UTF8();
            this.userId = popInt();
            this.status = popInt();
        }
    }

    public static class PStreamMessage extends Marshallable {
        public byte[] payload;
        public long sentTs;
        public int streamId;
        public int uid;

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void clear() {
            super.clear();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ ByteBuffer getBuffer() {
            return super.getBuffer();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void marshall(ByteBuffer byteBuffer) {
            super.marshall(byteBuffer);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public byte[] marshall() {
            return super.marshall();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popAll() {
            return super.popAll();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ Boolean popBool() {
            return super.popBool();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte popByte() {
            return super.popByte();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes() {
            return super.popBytes();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes32() {
            return super.popBytes32();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ double popDouble() {
            return super.popDouble();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ int popInt() {
            return super.popInt();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ long popInt64() {
            return super.popInt64();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ int[] popIntArray() {
            return super.popIntArray();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ short popShort() {
            return super.popShort();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ short[] popShortArray() {
            return super.popShortArray();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16() {
            return super.popString16();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16UTF8() {
            return super.popString16UTF8();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBool(Boolean bool) {
            super.pushBool(bool);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushByte(byte b) {
            super.pushByte(b);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes(byte[] bArr) {
            super.pushBytes(bArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes32(byte[] bArr) {
            super.pushBytes32(bArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushDouble(double d) {
            super.pushDouble(d);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt(int i) {
            super.pushInt(i);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt64(long j) {
            super.pushInt64(j);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(int[] iArr) {
            super.pushIntArray(iArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(Integer[] numArr) {
            super.pushIntArray(numArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShort(short s) {
            super.pushShort(s);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShortArray(short[] sArr) {
            super.pushShortArray(sArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushString16(String str) {
            super.pushString16(str);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushStringArray(ArrayList arrayList) {
            super.pushStringArray(arrayList);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void unmarshall(ByteBuffer byteBuffer) {
            super.unmarshall(byteBuffer);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.uid = popInt();
            this.streamId = popInt();
            this.sentTs = popInt64();
            this.payload = popBytes();
        }
    }

    public static class PStreamMessageError extends Marshallable {
        public int cached;
        public int error;
        public int missed;
        public int streamId;
        public int uid;

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void clear() {
            super.clear();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ ByteBuffer getBuffer() {
            return super.getBuffer();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void marshall(ByteBuffer byteBuffer) {
            super.marshall(byteBuffer);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public byte[] marshall() {
            return super.marshall();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popAll() {
            return super.popAll();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ Boolean popBool() {
            return super.popBool();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte popByte() {
            return super.popByte();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes() {
            return super.popBytes();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes32() {
            return super.popBytes32();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ double popDouble() {
            return super.popDouble();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ int popInt() {
            return super.popInt();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ long popInt64() {
            return super.popInt64();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ int[] popIntArray() {
            return super.popIntArray();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ short popShort() {
            return super.popShort();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ short[] popShortArray() {
            return super.popShortArray();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16() {
            return super.popString16();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16UTF8() {
            return super.popString16UTF8();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBool(Boolean bool) {
            super.pushBool(bool);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushByte(byte b) {
            super.pushByte(b);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes(byte[] bArr) {
            super.pushBytes(bArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes32(byte[] bArr) {
            super.pushBytes32(bArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushDouble(double d) {
            super.pushDouble(d);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt(int i) {
            super.pushInt(i);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt64(long j) {
            super.pushInt64(j);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(int[] iArr) {
            super.pushIntArray(iArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(Integer[] numArr) {
            super.pushIntArray(numArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShort(short s) {
            super.pushShort(s);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShortArray(short[] sArr) {
            super.pushShortArray(sArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushString16(String str) {
            super.pushString16(str);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushStringArray(ArrayList arrayList) {
            super.pushStringArray(arrayList);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void unmarshall(ByteBuffer byteBuffer) {
            super.unmarshall(byteBuffer);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.uid = popInt();
            this.streamId = popInt();
            this.error = popInt();
            this.missed = popInt();
            this.cached = popInt();
        }
    }

    public static class PStreamPublishEvent extends Marshallable {
        public int event;
        public String url;

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void clear() {
            super.clear();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ ByteBuffer getBuffer() {
            return super.getBuffer();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void marshall(ByteBuffer byteBuffer) {
            super.marshall(byteBuffer);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public byte[] marshall() {
            return super.marshall();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popAll() {
            return super.popAll();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ Boolean popBool() {
            return super.popBool();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte popByte() {
            return super.popByte();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes() {
            return super.popBytes();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes32() {
            return super.popBytes32();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ double popDouble() {
            return super.popDouble();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ int popInt() {
            return super.popInt();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ long popInt64() {
            return super.popInt64();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ int[] popIntArray() {
            return super.popIntArray();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ short popShort() {
            return super.popShort();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ short[] popShortArray() {
            return super.popShortArray();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16() {
            return super.popString16();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16UTF8() {
            return super.popString16UTF8();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBool(Boolean bool) {
            super.pushBool(bool);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushByte(byte b) {
            super.pushByte(b);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes(byte[] bArr) {
            super.pushBytes(bArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes32(byte[] bArr) {
            super.pushBytes32(bArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushDouble(double d) {
            super.pushDouble(d);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt(int i) {
            super.pushInt(i);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt64(long j) {
            super.pushInt64(j);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(int[] iArr) {
            super.pushIntArray(iArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(Integer[] numArr) {
            super.pushIntArray(numArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShort(short s) {
            super.pushShort(s);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShortArray(short[] sArr) {
            super.pushShortArray(sArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushString16(String str) {
            super.pushString16(str);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushStringArray(ArrayList arrayList) {
            super.pushStringArray(arrayList);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void unmarshall(ByteBuffer byteBuffer) {
            super.unmarshall(byteBuffer);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.url = popString16UTF8();
            this.event = popInt();
        }
    }

    public static class PStreamPublishState extends Marshallable {
        public int error;
        public int state;
        public String url;

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void clear() {
            super.clear();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ ByteBuffer getBuffer() {
            return super.getBuffer();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void marshall(ByteBuffer byteBuffer) {
            super.marshall(byteBuffer);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public byte[] marshall() {
            return super.marshall();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popAll() {
            return super.popAll();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ Boolean popBool() {
            return super.popBool();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte popByte() {
            return super.popByte();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes() {
            return super.popBytes();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes32() {
            return super.popBytes32();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ double popDouble() {
            return super.popDouble();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ int popInt() {
            return super.popInt();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ long popInt64() {
            return super.popInt64();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ int[] popIntArray() {
            return super.popIntArray();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ short popShort() {
            return super.popShort();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ short[] popShortArray() {
            return super.popShortArray();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16() {
            return super.popString16();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16UTF8() {
            return super.popString16UTF8();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBool(Boolean bool) {
            super.pushBool(bool);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushByte(byte b) {
            super.pushByte(b);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes(byte[] bArr) {
            super.pushBytes(bArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes32(byte[] bArr) {
            super.pushBytes32(bArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushDouble(double d) {
            super.pushDouble(d);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt(int i) {
            super.pushInt(i);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt64(long j) {
            super.pushInt64(j);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(int[] iArr) {
            super.pushIntArray(iArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(Integer[] numArr) {
            super.pushIntArray(numArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShort(short s) {
            super.pushShort(s);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShortArray(short[] sArr) {
            super.pushShortArray(sArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushString16(String str) {
            super.pushString16(str);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushStringArray(ArrayList arrayList) {
            super.pushStringArray(arrayList);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void unmarshall(ByteBuffer byteBuffer) {
            super.unmarshall(byteBuffer);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.url = popString16UTF8();
            this.state = popInt();
            this.error = popInt();
        }
    }

    public static class PStreamPublished extends Marshallable {
        public int error;
        public String url;

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void clear() {
            super.clear();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ ByteBuffer getBuffer() {
            return super.getBuffer();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void marshall(ByteBuffer byteBuffer) {
            super.marshall(byteBuffer);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public byte[] marshall() {
            return super.marshall();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popAll() {
            return super.popAll();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ Boolean popBool() {
            return super.popBool();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte popByte() {
            return super.popByte();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes() {
            return super.popBytes();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes32() {
            return super.popBytes32();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ double popDouble() {
            return super.popDouble();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ int popInt() {
            return super.popInt();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ long popInt64() {
            return super.popInt64();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ int[] popIntArray() {
            return super.popIntArray();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ short popShort() {
            return super.popShort();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ short[] popShortArray() {
            return super.popShortArray();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16() {
            return super.popString16();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16UTF8() {
            return super.popString16UTF8();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBool(Boolean bool) {
            super.pushBool(bool);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushByte(byte b) {
            super.pushByte(b);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes(byte[] bArr) {
            super.pushBytes(bArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes32(byte[] bArr) {
            super.pushBytes32(bArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushDouble(double d) {
            super.pushDouble(d);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt(int i) {
            super.pushInt(i);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt64(long j) {
            super.pushInt64(j);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(int[] iArr) {
            super.pushIntArray(iArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(Integer[] numArr) {
            super.pushIntArray(numArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShort(short s) {
            super.pushShort(s);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShortArray(short[] sArr) {
            super.pushShortArray(sArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushString16(String str) {
            super.pushString16(str);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushStringArray(ArrayList arrayList) {
            super.pushStringArray(arrayList);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void unmarshall(ByteBuffer byteBuffer) {
            super.unmarshall(byteBuffer);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.url = popString16UTF8();
            this.error = popInt();
        }
    }

    public static class PStreamUnPublished extends Marshallable {
        public String url;

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void clear() {
            super.clear();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ ByteBuffer getBuffer() {
            return super.getBuffer();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void marshall(ByteBuffer byteBuffer) {
            super.marshall(byteBuffer);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public byte[] marshall() {
            return super.marshall();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popAll() {
            return super.popAll();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ Boolean popBool() {
            return super.popBool();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte popByte() {
            return super.popByte();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes() {
            return super.popBytes();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes32() {
            return super.popBytes32();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ double popDouble() {
            return super.popDouble();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ int popInt() {
            return super.popInt();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ long popInt64() {
            return super.popInt64();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ int[] popIntArray() {
            return super.popIntArray();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ short popShort() {
            return super.popShort();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ short[] popShortArray() {
            return super.popShortArray();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16() {
            return super.popString16();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16UTF8() {
            return super.popString16UTF8();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBool(Boolean bool) {
            super.pushBool(bool);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushByte(byte b) {
            super.pushByte(b);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes(byte[] bArr) {
            super.pushBytes(bArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes32(byte[] bArr) {
            super.pushBytes32(bArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushDouble(double d) {
            super.pushDouble(d);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt(int i) {
            super.pushInt(i);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt64(long j) {
            super.pushInt64(j);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(int[] iArr) {
            super.pushIntArray(iArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(Integer[] numArr) {
            super.pushIntArray(numArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShort(short s) {
            super.pushShort(s);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShortArray(short[] sArr) {
            super.pushShortArray(sArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushString16(String str) {
            super.pushString16(str);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushStringArray(ArrayList arrayList) {
            super.pushStringArray(arrayList);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void unmarshall(ByteBuffer byteBuffer) {
            super.unmarshall(byteBuffer);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.url = popString16UTF8();
        }
    }

    public static class PSubscribeAudioStateChanged extends Marshallable {
        public String channelId;
        public int elapseSinceLastState;
        public short newState;
        public short oldState;
        public int uid;

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void clear() {
            super.clear();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ ByteBuffer getBuffer() {
            return super.getBuffer();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void marshall(ByteBuffer byteBuffer) {
            super.marshall(byteBuffer);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public byte[] marshall() {
            return super.marshall();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popAll() {
            return super.popAll();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ Boolean popBool() {
            return super.popBool();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte popByte() {
            return super.popByte();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes() {
            return super.popBytes();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes32() {
            return super.popBytes32();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ double popDouble() {
            return super.popDouble();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ int popInt() {
            return super.popInt();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ long popInt64() {
            return super.popInt64();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ int[] popIntArray() {
            return super.popIntArray();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ short popShort() {
            return super.popShort();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ short[] popShortArray() {
            return super.popShortArray();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16() {
            return super.popString16();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16UTF8() {
            return super.popString16UTF8();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBool(Boolean bool) {
            super.pushBool(bool);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushByte(byte b) {
            super.pushByte(b);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes(byte[] bArr) {
            super.pushBytes(bArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes32(byte[] bArr) {
            super.pushBytes32(bArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushDouble(double d) {
            super.pushDouble(d);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt(int i) {
            super.pushInt(i);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt64(long j) {
            super.pushInt64(j);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(int[] iArr) {
            super.pushIntArray(iArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(Integer[] numArr) {
            super.pushIntArray(numArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShort(short s) {
            super.pushShort(s);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShortArray(short[] sArr) {
            super.pushShortArray(sArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushString16(String str) {
            super.pushString16(str);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushStringArray(ArrayList arrayList) {
            super.pushStringArray(arrayList);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void unmarshall(ByteBuffer byteBuffer) {
            super.unmarshall(byteBuffer);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.channelId = popString16UTF8();
            this.uid = popInt();
            this.oldState = popShort();
            this.newState = popShort();
            this.elapseSinceLastState = popInt();
        }
    }

    public static class PSubscribeVideoStateChanged extends Marshallable {
        public String channelId;
        public int elapseSinceLastState;
        public short newState;
        public short oldState;
        public int uid;

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void clear() {
            super.clear();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ ByteBuffer getBuffer() {
            return super.getBuffer();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void marshall(ByteBuffer byteBuffer) {
            super.marshall(byteBuffer);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public byte[] marshall() {
            return super.marshall();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popAll() {
            return super.popAll();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ Boolean popBool() {
            return super.popBool();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte popByte() {
            return super.popByte();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes() {
            return super.popBytes();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes32() {
            return super.popBytes32();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ double popDouble() {
            return super.popDouble();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ int popInt() {
            return super.popInt();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ long popInt64() {
            return super.popInt64();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ int[] popIntArray() {
            return super.popIntArray();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ short popShort() {
            return super.popShort();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ short[] popShortArray() {
            return super.popShortArray();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16() {
            return super.popString16();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16UTF8() {
            return super.popString16UTF8();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBool(Boolean bool) {
            super.pushBool(bool);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushByte(byte b) {
            super.pushByte(b);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes(byte[] bArr) {
            super.pushBytes(bArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes32(byte[] bArr) {
            super.pushBytes32(bArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushDouble(double d) {
            super.pushDouble(d);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt(int i) {
            super.pushInt(i);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt64(long j) {
            super.pushInt64(j);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(int[] iArr) {
            super.pushIntArray(iArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(Integer[] numArr) {
            super.pushIntArray(numArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShort(short s) {
            super.pushShort(s);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShortArray(short[] sArr) {
            super.pushShortArray(sArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushString16(String str) {
            super.pushString16(str);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushStringArray(ArrayList arrayList) {
            super.pushStringArray(arrayList);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void unmarshall(ByteBuffer byteBuffer) {
            super.unmarshall(byteBuffer);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.channelId = popString16UTF8();
            this.uid = popInt();
            this.oldState = popShort();
            this.newState = popShort();
            this.elapseSinceLastState = popInt();
        }
    }

    public static class PTranscodingVideoStream extends Marshallable {
        public double alpha;
        public int error;
        public int height;
        public String imageUrl;
        public boolean mirror;
        public int remoteUserUid;
        public int sourceType;
        public int width;
        public int x;
        public int y;
        public int zOrder;

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void clear() {
            super.clear();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ ByteBuffer getBuffer() {
            return super.getBuffer();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void marshall(ByteBuffer byteBuffer) {
            super.marshall(byteBuffer);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public byte[] marshall() {
            return super.marshall();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popAll() {
            return super.popAll();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ Boolean popBool() {
            return super.popBool();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte popByte() {
            return super.popByte();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes() {
            return super.popBytes();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes32() {
            return super.popBytes32();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ double popDouble() {
            return super.popDouble();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ int popInt() {
            return super.popInt();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ long popInt64() {
            return super.popInt64();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ int[] popIntArray() {
            return super.popIntArray();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ short popShort() {
            return super.popShort();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ short[] popShortArray() {
            return super.popShortArray();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16() {
            return super.popString16();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16UTF8() {
            return super.popString16UTF8();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBool(Boolean bool) {
            super.pushBool(bool);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushByte(byte b) {
            super.pushByte(b);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes(byte[] bArr) {
            super.pushBytes(bArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes32(byte[] bArr) {
            super.pushBytes32(bArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushDouble(double d) {
            super.pushDouble(d);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt(int i) {
            super.pushInt(i);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt64(long j) {
            super.pushInt64(j);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(int[] iArr) {
            super.pushIntArray(iArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(Integer[] numArr) {
            super.pushIntArray(numArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShort(short s) {
            super.pushShort(s);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShortArray(short[] sArr) {
            super.pushShortArray(sArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushString16(String str) {
            super.pushString16(str);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushStringArray(ArrayList arrayList) {
            super.pushStringArray(arrayList);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void unmarshall(ByteBuffer byteBuffer) {
            super.unmarshall(byteBuffer);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.error = popInt();
            this.sourceType = popInt();
            this.remoteUserUid = popInt();
            this.imageUrl = popString16UTF8();
            this.x = popInt();
            this.y = popInt();
            this.width = popInt();
            this.height = popInt();
            this.zOrder = popInt();
            this.alpha = popDouble();
            this.mirror = popBool().booleanValue();
        }
    }

    public static class PUplinkNetworkInfoUpdated extends Marshallable {
        public int videoEncoderTargetBitrateBps;

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void clear() {
            super.clear();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ ByteBuffer getBuffer() {
            return super.getBuffer();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void marshall(ByteBuffer byteBuffer) {
            super.marshall(byteBuffer);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public byte[] marshall() {
            return super.marshall();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popAll() {
            return super.popAll();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ Boolean popBool() {
            return super.popBool();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte popByte() {
            return super.popByte();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes() {
            return super.popBytes();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes32() {
            return super.popBytes32();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ double popDouble() {
            return super.popDouble();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ int popInt() {
            return super.popInt();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ long popInt64() {
            return super.popInt64();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ int[] popIntArray() {
            return super.popIntArray();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ short popShort() {
            return super.popShort();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ short[] popShortArray() {
            return super.popShortArray();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16() {
            return super.popString16();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16UTF8() {
            return super.popString16UTF8();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBool(Boolean bool) {
            super.pushBool(bool);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushByte(byte b) {
            super.pushByte(b);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes(byte[] bArr) {
            super.pushBytes(bArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes32(byte[] bArr) {
            super.pushBytes32(bArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushDouble(double d) {
            super.pushDouble(d);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt(int i) {
            super.pushInt(i);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt64(long j) {
            super.pushInt64(j);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(int[] iArr) {
            super.pushIntArray(iArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(Integer[] numArr) {
            super.pushIntArray(numArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShort(short s) {
            super.pushShort(s);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShortArray(short[] sArr) {
            super.pushShortArray(sArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushString16(String str) {
            super.pushString16(str);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushStringArray(ArrayList arrayList) {
            super.pushStringArray(arrayList);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void unmarshall(ByteBuffer byteBuffer) {
            super.unmarshall(byteBuffer);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.videoEncoderTargetBitrateBps = popInt();
        }
    }

    public static class PUploadLogResult extends Marshallable {
        public int reason;
        public String requestId;
        public boolean success;

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void clear() {
            super.clear();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ ByteBuffer getBuffer() {
            return super.getBuffer();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void marshall(ByteBuffer byteBuffer) {
            super.marshall(byteBuffer);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] marshall() {
            return super.marshall();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popAll() {
            return super.popAll();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ Boolean popBool() {
            return super.popBool();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte popByte() {
            return super.popByte();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes() {
            return super.popBytes();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes32() {
            return super.popBytes32();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ double popDouble() {
            return super.popDouble();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ int popInt() {
            return super.popInt();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ long popInt64() {
            return super.popInt64();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ int[] popIntArray() {
            return super.popIntArray();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ short popShort() {
            return super.popShort();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ short[] popShortArray() {
            return super.popShortArray();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16() {
            return super.popString16();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16UTF8() {
            return super.popString16UTF8();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBool(Boolean bool) {
            super.pushBool(bool);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushByte(byte b) {
            super.pushByte(b);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes(byte[] bArr) {
            super.pushBytes(bArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes32(byte[] bArr) {
            super.pushBytes32(bArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushDouble(double d) {
            super.pushDouble(d);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt(int i) {
            super.pushInt(i);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt64(long j) {
            super.pushInt64(j);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(int[] iArr) {
            super.pushIntArray(iArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(Integer[] numArr) {
            super.pushIntArray(numArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShort(short s) {
            super.pushShort(s);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShortArray(short[] sArr) {
            super.pushShortArray(sArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushString16(String str) {
            super.pushString16(str);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushStringArray(ArrayList arrayList) {
            super.pushStringArray(arrayList);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void unmarshall(ByteBuffer byteBuffer) {
            super.unmarshall(byteBuffer);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.requestId = popString16();
            this.success = popBool().booleanValue();
            this.reason = popInt();
        }
    }

    public static class PUserInfoState extends Marshallable {
        public int uid;
        public String userAccount;

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void clear() {
            super.clear();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ ByteBuffer getBuffer() {
            return super.getBuffer();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void marshall(ByteBuffer byteBuffer) {
            super.marshall(byteBuffer);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public byte[] marshall() {
            pushInt(this.uid);
            pushBytes(this.userAccount.getBytes());
            return super.marshall();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popAll() {
            return super.popAll();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ Boolean popBool() {
            return super.popBool();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte popByte() {
            return super.popByte();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes() {
            return super.popBytes();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes32() {
            return super.popBytes32();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ double popDouble() {
            return super.popDouble();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ int popInt() {
            return super.popInt();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ long popInt64() {
            return super.popInt64();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ int[] popIntArray() {
            return super.popIntArray();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ short popShort() {
            return super.popShort();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ short[] popShortArray() {
            return super.popShortArray();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16() {
            return super.popString16();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16UTF8() {
            return super.popString16UTF8();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBool(Boolean bool) {
            super.pushBool(bool);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushByte(byte b) {
            super.pushByte(b);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes(byte[] bArr) {
            super.pushBytes(bArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes32(byte[] bArr) {
            super.pushBytes32(bArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushDouble(double d) {
            super.pushDouble(d);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt(int i) {
            super.pushInt(i);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt64(long j) {
            super.pushInt64(j);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(int[] iArr) {
            super.pushIntArray(iArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(Integer[] numArr) {
            super.pushIntArray(numArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShort(short s) {
            super.pushShort(s);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShortArray(short[] sArr) {
            super.pushShortArray(sArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushString16(String str) {
            super.pushString16(str);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushStringArray(ArrayList arrayList) {
            super.pushStringArray(arrayList);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void unmarshall(ByteBuffer byteBuffer) {
            super.unmarshall(byteBuffer);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.uid = popInt();
            this.userAccount = popString16UTF8();
        }
    }

    public static class PUserStateChanged extends Marshallable {
        public int state;
        public int uid;

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void clear() {
            super.clear();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ ByteBuffer getBuffer() {
            return super.getBuffer();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void marshall(ByteBuffer byteBuffer) {
            super.marshall(byteBuffer);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public byte[] marshall() {
            return super.marshall();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popAll() {
            return super.popAll();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ Boolean popBool() {
            return super.popBool();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte popByte() {
            return super.popByte();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes() {
            return super.popBytes();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes32() {
            return super.popBytes32();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ double popDouble() {
            return super.popDouble();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ int popInt() {
            return super.popInt();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ long popInt64() {
            return super.popInt64();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ int[] popIntArray() {
            return super.popIntArray();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ short popShort() {
            return super.popShort();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ short[] popShortArray() {
            return super.popShortArray();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16() {
            return super.popString16();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16UTF8() {
            return super.popString16UTF8();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBool(Boolean bool) {
            super.pushBool(bool);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushByte(byte b) {
            super.pushByte(b);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes(byte[] bArr) {
            super.pushBytes(bArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes32(byte[] bArr) {
            super.pushBytes32(bArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushDouble(double d) {
            super.pushDouble(d);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt(int i) {
            super.pushInt(i);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt64(long j) {
            super.pushInt64(j);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(int[] iArr) {
            super.pushIntArray(iArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(Integer[] numArr) {
            super.pushIntArray(numArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShort(short s) {
            super.pushShort(s);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShortArray(short[] sArr) {
            super.pushShortArray(sArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushString16(String str) {
            super.pushString16(str);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushStringArray(ArrayList arrayList) {
            super.pushStringArray(arrayList);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void unmarshall(ByteBuffer byteBuffer) {
            super.unmarshall(byteBuffer);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.uid = popInt();
            this.state = popInt();
        }
    }

    public static class PUserTransportStat extends Marshallable {
        public short delay;
        public boolean isAudio;
        public short lost;
        public int peer_uid;
        public short rxKBitRate;

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void clear() {
            super.clear();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ ByteBuffer getBuffer() {
            return super.getBuffer();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void marshall(ByteBuffer byteBuffer) {
            super.marshall(byteBuffer);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public byte[] marshall() {
            return super.marshall();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popAll() {
            return super.popAll();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ Boolean popBool() {
            return super.popBool();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte popByte() {
            return super.popByte();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes() {
            return super.popBytes();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes32() {
            return super.popBytes32();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ double popDouble() {
            return super.popDouble();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ int popInt() {
            return super.popInt();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ long popInt64() {
            return super.popInt64();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ int[] popIntArray() {
            return super.popIntArray();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ short popShort() {
            return super.popShort();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ short[] popShortArray() {
            return super.popShortArray();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16() {
            return super.popString16();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16UTF8() {
            return super.popString16UTF8();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBool(Boolean bool) {
            super.pushBool(bool);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushByte(byte b) {
            super.pushByte(b);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes(byte[] bArr) {
            super.pushBytes(bArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes32(byte[] bArr) {
            super.pushBytes32(bArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushDouble(double d) {
            super.pushDouble(d);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt(int i) {
            super.pushInt(i);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt64(long j) {
            super.pushInt64(j);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(int[] iArr) {
            super.pushIntArray(iArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(Integer[] numArr) {
            super.pushIntArray(numArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShort(short s) {
            super.pushShort(s);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShortArray(short[] sArr) {
            super.pushShortArray(sArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushString16(String str) {
            super.pushString16(str);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushStringArray(ArrayList arrayList) {
            super.pushStringArray(arrayList);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void unmarshall(ByteBuffer byteBuffer) {
            super.unmarshall(byteBuffer);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.isAudio = popBool().booleanValue();
            this.peer_uid = popInt();
            this.delay = popShort();
            this.lost = popShort();
            this.rxKBitRate = popShort();
        }
    }

    public static class PVideoCompositingLayout extends Marshallable {
        private static final short SERVER_TYPE = 0;
        private static final short URI = 20;

        private void marshall(Marshallable marshallable, VideoCompositingLayout videoCompositingLayout) {
            int i = 0;
            marshallable.pushShort((short) 0);
            marshallable.pushShort((short) 20);
            marshallable.pushInt(videoCompositingLayout.canvasWidth);
            marshallable.pushInt(videoCompositingLayout.canvasHeight);
            String str = videoCompositingLayout.backgroundColor;
            if (str != null) {
                marshallable.pushBytes(str.getBytes());
            } else {
                marshallable.pushBytes("".getBytes());
            }
            byte[] bArr = videoCompositingLayout.appData;
            if (bArr != null) {
                marshallable.pushBytes(bArr);
            } else {
                marshallable.pushBytes("".getBytes());
            }
            marshallable.pushShort((short) videoCompositingLayout.regions.length);
            while (true) {
                VideoCompositingLayout.Region[] regionArr = videoCompositingLayout.regions;
                if (i >= regionArr.length) {
                    return;
                }
                marshallRegion(marshallable, regionArr[i]);
                i++;
            }
        }

        private void marshallRegion(Marshallable marshallable, VideoCompositingLayout.Region region) {
            marshallable.pushInt(region.uid);
            if (TextUtils.isEmpty(region.userId)) {
                marshallable.pushBytes("".getBytes());
            } else {
                marshallable.pushBytes(region.userId.getBytes());
            }
            marshallable.pushDouble(region.x);
            marshallable.pushDouble(region.y);
            marshallable.pushDouble(region.width);
            marshallable.pushDouble(region.height);
            marshallable.pushInt(region.zOrder);
            marshallable.pushDouble(region.alpha);
            marshallable.pushInt(region.renderMode);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void clear() {
            super.clear();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ ByteBuffer getBuffer() {
            return super.getBuffer();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void marshall(ByteBuffer byteBuffer) {
            super.marshall(byteBuffer);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] marshall() {
            return super.marshall();
        }

        public byte[] marshall(VideoCompositingLayout videoCompositingLayout) {
            marshall(this, videoCompositingLayout);
            return super.marshall();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popAll() {
            return super.popAll();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ Boolean popBool() {
            return super.popBool();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte popByte() {
            return super.popByte();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes() {
            return super.popBytes();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes32() {
            return super.popBytes32();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ double popDouble() {
            return super.popDouble();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ int popInt() {
            return super.popInt();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ long popInt64() {
            return super.popInt64();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ int[] popIntArray() {
            return super.popIntArray();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ short popShort() {
            return super.popShort();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ short[] popShortArray() {
            return super.popShortArray();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16() {
            return super.popString16();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16UTF8() {
            return super.popString16UTF8();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBool(Boolean bool) {
            super.pushBool(bool);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushByte(byte b) {
            super.pushByte(b);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes(byte[] bArr) {
            super.pushBytes(bArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes32(byte[] bArr) {
            super.pushBytes32(bArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushDouble(double d) {
            super.pushDouble(d);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt(int i) {
            super.pushInt(i);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt64(long j) {
            super.pushInt64(j);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(int[] iArr) {
            super.pushIntArray(iArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(Integer[] numArr) {
            super.pushIntArray(numArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShort(short s) {
            super.pushShort(s);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShortArray(short[] sArr) {
            super.pushShortArray(sArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushString16(String str) {
            super.pushString16(str);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushStringArray(ArrayList arrayList) {
            super.pushStringArray(arrayList);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void unmarshall(ByteBuffer byteBuffer) {
            super.unmarshall(byteBuffer);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
        }
    }

    public static class PVideoNetOptions extends Marshallable {
        public short bitrate;
        public short frameRate;
        public short height;
        public short width;

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void clear() {
            super.clear();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ ByteBuffer getBuffer() {
            return super.getBuffer();
        }

        public void marshall(Marshallable marshallable) {
            marshallable.pushShort(this.width);
            marshallable.pushShort(this.height);
            marshallable.pushShort(this.frameRate);
            marshallable.pushShort(this.bitrate);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void marshall(ByteBuffer byteBuffer) {
            super.marshall(byteBuffer);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public byte[] marshall() {
            marshall(this);
            return super.marshall();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popAll() {
            return super.popAll();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ Boolean popBool() {
            return super.popBool();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte popByte() {
            return super.popByte();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes() {
            return super.popBytes();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes32() {
            return super.popBytes32();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ double popDouble() {
            return super.popDouble();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ int popInt() {
            return super.popInt();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ long popInt64() {
            return super.popInt64();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ int[] popIntArray() {
            return super.popIntArray();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ short popShort() {
            return super.popShort();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ short[] popShortArray() {
            return super.popShortArray();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16() {
            return super.popString16();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16UTF8() {
            return super.popString16UTF8();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBool(Boolean bool) {
            super.pushBool(bool);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushByte(byte b) {
            super.pushByte(b);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes(byte[] bArr) {
            super.pushBytes(bArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes32(byte[] bArr) {
            super.pushBytes32(bArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushDouble(double d) {
            super.pushDouble(d);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt(int i) {
            super.pushInt(i);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt64(long j) {
            super.pushInt64(j);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(int[] iArr) {
            super.pushIntArray(iArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(Integer[] numArr) {
            super.pushIntArray(numArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShort(short s) {
            super.pushShort(s);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShortArray(short[] sArr) {
            super.pushShortArray(sArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushString16(String str) {
            super.pushString16(str);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushStringArray(ArrayList arrayList) {
            super.pushStringArray(arrayList);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void unmarshall(ByteBuffer byteBuffer) {
            super.unmarshall(byteBuffer);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.width = popShort();
            this.height = popShort();
            this.frameRate = popShort();
            this.bitrate = popShort();
        }
    }

    public static class PVideoRenderingTracingInfo extends Marshallable {
        public int elapsedTime;
        public short event;
        public int join2JoinSuccess;
        public int joinSuccess2RemoteJoined;
        public int remoteJoined2PacketReceived;
        public int remoteJoined2SetView;
        public int remoteJoined2UnmuteVideo;
        public int start2JoinChannel;
        public int uid;

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void clear() {
            super.clear();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ ByteBuffer getBuffer() {
            return super.getBuffer();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void marshall(ByteBuffer byteBuffer) {
            super.marshall(byteBuffer);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public byte[] marshall() {
            pushInt(this.uid);
            pushShort(this.event);
            pushInt(this.elapsedTime);
            pushInt(this.start2JoinChannel);
            pushInt(this.join2JoinSuccess);
            pushInt(this.joinSuccess2RemoteJoined);
            pushInt(this.remoteJoined2SetView);
            pushInt(this.remoteJoined2UnmuteVideo);
            pushInt(this.remoteJoined2PacketReceived);
            return super.marshall();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popAll() {
            return super.popAll();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ Boolean popBool() {
            return super.popBool();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte popByte() {
            return super.popByte();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes() {
            return super.popBytes();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes32() {
            return super.popBytes32();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ double popDouble() {
            return super.popDouble();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ int popInt() {
            return super.popInt();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ long popInt64() {
            return super.popInt64();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ int[] popIntArray() {
            return super.popIntArray();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ short popShort() {
            return super.popShort();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ short[] popShortArray() {
            return super.popShortArray();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16() {
            return super.popString16();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16UTF8() {
            return super.popString16UTF8();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBool(Boolean bool) {
            super.pushBool(bool);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushByte(byte b) {
            super.pushByte(b);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes(byte[] bArr) {
            super.pushBytes(bArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes32(byte[] bArr) {
            super.pushBytes32(bArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushDouble(double d) {
            super.pushDouble(d);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt(int i) {
            super.pushInt(i);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt64(long j) {
            super.pushInt64(j);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(int[] iArr) {
            super.pushIntArray(iArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(Integer[] numArr) {
            super.pushIntArray(numArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShort(short s) {
            super.pushShort(s);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShortArray(short[] sArr) {
            super.pushShortArray(sArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushString16(String str) {
            super.pushString16(str);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushStringArray(ArrayList arrayList) {
            super.pushStringArray(arrayList);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void unmarshall(ByteBuffer byteBuffer) {
            super.unmarshall(byteBuffer);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.uid = popInt();
            this.event = popShort();
            this.elapsedTime = popInt();
            this.start2JoinChannel = popInt();
            this.join2JoinSuccess = popInt();
            this.joinSuccess2RemoteJoined = popInt();
            this.remoteJoined2SetView = popInt();
            this.remoteJoined2UnmuteVideo = popInt();
            this.remoteJoined2PacketReceived = popInt();
        }
    }

    public static class PVideoSizeChanged extends Marshallable {
        public int height;
        public int rotation;
        public int source;
        public int uid;
        public int width;

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void clear() {
            super.clear();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ ByteBuffer getBuffer() {
            return super.getBuffer();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void marshall(ByteBuffer byteBuffer) {
            super.marshall(byteBuffer);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public byte[] marshall() {
            pushByte((byte) this.source);
            pushInt(this.uid);
            pushInt(this.width);
            pushInt(this.height);
            pushInt(this.rotation);
            return super.marshall();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popAll() {
            return super.popAll();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ Boolean popBool() {
            return super.popBool();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte popByte() {
            return super.popByte();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes() {
            return super.popBytes();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes32() {
            return super.popBytes32();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ double popDouble() {
            return super.popDouble();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ int popInt() {
            return super.popInt();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ long popInt64() {
            return super.popInt64();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ int[] popIntArray() {
            return super.popIntArray();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ short popShort() {
            return super.popShort();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ short[] popShortArray() {
            return super.popShortArray();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16() {
            return super.popString16();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16UTF8() {
            return super.popString16UTF8();
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBool(Boolean bool) {
            super.pushBool(bool);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushByte(byte b) {
            super.pushByte(b);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes(byte[] bArr) {
            super.pushBytes(bArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes32(byte[] bArr) {
            super.pushBytes32(bArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushDouble(double d) {
            super.pushDouble(d);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt(int i) {
            super.pushInt(i);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt64(long j) {
            super.pushInt64(j);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(int[] iArr) {
            super.pushIntArray(iArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(Integer[] numArr) {
            super.pushIntArray(numArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShort(short s) {
            super.pushShort(s);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShortArray(short[] sArr) {
            super.pushShortArray(sArr);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushString16(String str) {
            super.pushString16(str);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushStringArray(ArrayList arrayList) {
            super.pushStringArray(arrayList);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public /* bridge */ /* synthetic */ void unmarshall(ByteBuffer byteBuffer) {
            super.unmarshall(byteBuffer);
        }

        @Override // io.agora.rtc2.internal.Marshallable
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.source = popByte();
            this.uid = popInt();
            this.width = popInt();
            this.height = popInt();
            this.rotation = popInt();
        }
    }

    public static int toIntegerUserId(String str) {
        if (str == null) {
            return 0;
        }
        try {
            return (int) Long.parseLong(str);
        } catch (Exception unused) {
            return 0;
        }
    }

    public static long toIntegerUserId(int i) {
        return i & UnsignedInts.INT_MASK;
    }

    public static String toStringUserId(int i) {
        return String.valueOf(toIntegerUserId(i));
    }
}
