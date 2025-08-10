package com.sun.jna;

import com.sun.jna.Function;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes3.dex */
public class StringArray extends Memory implements Function.PostCallRead {
    private String encoding;
    private List<NativeString> natives;
    private Object[] original;

    public StringArray(String[] strArr) {
        this(strArr, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v9, types: [com.sun.jna.WString] */
    @Override // com.sun.jna.Function.PostCallRead
    public void read() {
        boolean z = this.original instanceof WString[];
        boolean zEquals = NativeString.WIDE_STRING.equals(this.encoding);
        for (int i = 0; i < this.original.length; i++) {
            Pointer pointer = getPointer(Native.POINTER_SIZE * i);
            String wideString = null;
            if (pointer != null) {
                wideString = zEquals ? pointer.getWideString(0L) : pointer.getString(0L, this.encoding);
                if (z) {
                    wideString = new WString(wideString);
                }
            }
            this.original[i] = wideString;
        }
    }

    @Override // com.sun.jna.Memory, com.sun.jna.Pointer
    public String toString() {
        return (NativeString.WIDE_STRING.equals(this.encoding) ? "const wchar_t*[]" : "const char*[]") + Arrays.asList(this.original);
    }

    public StringArray(String[] strArr, boolean z) {
        this((Object[]) strArr, z ? NativeString.WIDE_STRING : Native.getDefaultStringEncoding());
    }

    public StringArray(String[] strArr, String str) {
        this((Object[]) strArr, str);
    }

    public StringArray(WString[] wStringArr) {
        this(wStringArr, NativeString.WIDE_STRING);
    }

    private StringArray(Object[] objArr, String str) {
        super((objArr.length + 1) * Native.POINTER_SIZE);
        this.natives = new ArrayList();
        this.original = objArr;
        this.encoding = str;
        int i = 0;
        while (true) {
            Pointer pointer = null;
            if (i < objArr.length) {
                if (objArr[i] != null) {
                    NativeString nativeString = new NativeString(objArr[i].toString(), str);
                    this.natives.add(nativeString);
                    pointer = nativeString.getPointer();
                }
                setPointer(Native.POINTER_SIZE * i, pointer);
                i++;
            } else {
                setPointer(Native.POINTER_SIZE * objArr.length, null);
                return;
            }
        }
    }
}
