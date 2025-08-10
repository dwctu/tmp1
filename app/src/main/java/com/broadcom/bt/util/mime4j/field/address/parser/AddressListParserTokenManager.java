package com.broadcom.bt.util.mime4j.field.address.parser;

import com.broadcom.bt.util.io.IOUtils;
import com.j256.ormlite.stmt.query.SimpleComparison;
import java.io.IOException;
import java.io.PrintStream;
import org.apache.commons.codec.net.RFC1522Codec;
import org.aspectj.runtime.reflect.SignatureImpl;

/* loaded from: classes.dex */
public class AddressListParserTokenManager implements AddressListParserConstants {
    public static int commentNest;
    public char curChar;
    public int curLexState;
    public PrintStream debugStream;
    public int defaultLexState;
    public StringBuffer image;
    public SimpleCharStream input_stream;
    public int jjimageLen;
    public int jjmatchedKind;
    public int jjmatchedPos;
    public int jjnewStateCnt;
    public int jjround;
    private final int[] jjrounds;
    private final int[] jjstateSet;
    public int lengthOfMatch;
    public static final long[] jjbitVec0 = {0, 0, -1, -1};
    public static final int[] jjnextStates = new int[0];
    public static final String[] jjstrLiteralImages = {"", "\r", IOUtils.LINE_SEPARATOR_UNIX, ",", SignatureImpl.INNER_SEP, ";", SimpleComparison.LESS_THAN_OPERATION, SimpleComparison.GREATER_THAN_OPERATION, "@", ".", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null};
    public static final String[] lexStateNames = {"DEFAULT", "INDOMAINLITERAL", "INCOMMENT", "NESTED_COMMENT", "INQUOTEDSTRING"};
    public static final int[] jjnewLexState = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, -1, -1, 0, 2, 0, -1, 3, -1, -1, -1, -1, -1, 4, -1, -1, 0, -1, -1};
    public static final long[] jjtoToken = {2147763199L};
    public static final long[] jjtoSkip = {1049600};
    public static final long[] jjtoSpecial = {1024};
    public static final long[] jjtoMore = {2146140160};

    public AddressListParserTokenManager(SimpleCharStream simpleCharStream) {
        this.debugStream = System.out;
        this.jjrounds = new int[3];
        this.jjstateSet = new int[6];
        this.curLexState = 0;
        this.defaultLexState = 0;
        this.input_stream = simpleCharStream;
    }

    private final void ReInitRounds() {
        this.jjround = -2147483647;
        int i = 3;
        while (true) {
            int i2 = i - 1;
            if (i <= 0) {
                return;
            }
            this.jjrounds[i2] = Integer.MIN_VALUE;
            i = i2;
        }
    }

    private final void jjAddStates(int i, int i2) {
        while (true) {
            int[] iArr = this.jjstateSet;
            int i3 = this.jjnewStateCnt;
            this.jjnewStateCnt = i3 + 1;
            iArr[i3] = jjnextStates[i];
            int i4 = i + 1;
            if (i == i2) {
                return;
            } else {
                i = i4;
            }
        }
    }

    private final void jjCheckNAdd(int i) {
        int[] iArr = this.jjrounds;
        int i2 = iArr[i];
        int i3 = this.jjround;
        if (i2 != i3) {
            int[] iArr2 = this.jjstateSet;
            int i4 = this.jjnewStateCnt;
            this.jjnewStateCnt = i4 + 1;
            iArr2[i4] = i;
            iArr[i] = i3;
        }
    }

    private final void jjCheckNAddStates(int i, int i2) {
        while (true) {
            jjCheckNAdd(jjnextStates[i]);
            int i3 = i + 1;
            if (i == i2) {
                return;
            } else {
                i = i3;
            }
        }
    }

    private final void jjCheckNAddTwoStates(int i, int i2) {
        jjCheckNAdd(i);
        jjCheckNAdd(i2);
    }

    private final int jjMoveNfa_0(int i, int i2) {
        this.jjnewStateCnt = 3;
        this.jjstateSet[0] = i;
        int i3 = i2;
        int i4 = 1;
        int i5 = Integer.MAX_VALUE;
        int i6 = 0;
        while (true) {
            int i7 = this.jjround + 1;
            this.jjround = i7;
            if (i7 == Integer.MAX_VALUE) {
                ReInitRounds();
            }
            char c = this.curChar;
            if (c < '@') {
                long j = 1 << c;
                do {
                    i4--;
                    int i8 = this.jjstateSet[i4];
                    if (i8 != 0) {
                        if (i8 != 1) {
                            if (i8 == 2 && (j & (-6629319567980101632L)) != 0) {
                                if (i5 > 14) {
                                    i5 = 14;
                                }
                                jjCheckNAdd(2);
                            }
                        } else if ((j & (-6629389936724279296L)) != 0) {
                            if (i5 > 14) {
                                i5 = 14;
                            }
                            jjCheckNAdd(2);
                        } else if ((j & 4294967808L) != 0) {
                            if (i5 > 10) {
                                i5 = 10;
                            }
                            jjCheckNAdd(0);
                        }
                    } else if ((j & 4294967808L) != 0) {
                        jjCheckNAdd(0);
                        i5 = 10;
                    }
                } while (i4 != i6);
            } else if (c < 128) {
                long j2 = 1 << (c & RFC1522Codec.SEP);
                do {
                    i4--;
                    int i9 = this.jjstateSet[i4];
                    if ((i9 == 1 || i9 == 2) && (9223372035915251710L & j2) != 0) {
                        if (i5 > 14) {
                            i5 = 14;
                        }
                        jjCheckNAdd(2);
                    }
                } while (i4 != i6);
            } else {
                do {
                    i4--;
                    int i10 = this.jjstateSet[i4];
                } while (i4 != i6);
            }
            if (i5 != Integer.MAX_VALUE) {
                this.jjmatchedKind = i5;
                this.jjmatchedPos = i3;
                i5 = Integer.MAX_VALUE;
            }
            i3++;
            i4 = this.jjnewStateCnt;
            this.jjnewStateCnt = i6;
            i6 = 3 - i6;
            if (i4 == i6) {
                return i3;
            }
            try {
                this.curChar = this.input_stream.readChar();
            } catch (IOException unused) {
                return i3;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0073  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final int jjMoveNfa_1(int r18, int r19) {
        /*
            Method dump skipped, instructions count: 213
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.broadcom.bt.util.mime4j.field.address.parser.AddressListParserTokenManager.jjMoveNfa_1(int, int):int");
    }

    private final int jjMoveNfa_2(int i, int i2) {
        this.jjnewStateCnt = 3;
        this.jjstateSet[0] = i;
        int i3 = i2;
        int i4 = 0;
        int i5 = 1;
        int i6 = Integer.MAX_VALUE;
        while (true) {
            int i7 = this.jjround + 1;
            this.jjround = i7;
            if (i7 == Integer.MAX_VALUE) {
                ReInitRounds();
            }
            char c = this.curChar;
            if (c < '@') {
                do {
                    i5--;
                    int i8 = this.jjstateSet[i5];
                    if (i8 != 0) {
                        if (i8 == 1 && i6 > 21) {
                            i6 = 21;
                        }
                    } else if (i6 > 23) {
                        i6 = 23;
                    }
                } while (i5 != i4);
            } else if (c < 128) {
                do {
                    int[] iArr = this.jjstateSet;
                    i5--;
                    int i9 = iArr[i5];
                    if (i9 == 0) {
                        if (i6 > 23) {
                            i6 = 23;
                        }
                        if (this.curChar == '\\') {
                            int i10 = this.jjnewStateCnt;
                            this.jjnewStateCnt = i10 + 1;
                            iArr[i10] = 1;
                        }
                    } else if (i9 != 1) {
                        if (i9 == 2 && i6 > 23) {
                            i6 = 23;
                        }
                    } else if (i6 > 21) {
                        i6 = 21;
                    }
                } while (i5 != i4);
            } else {
                int i11 = (c & 255) >> 6;
                long j = 1 << (c & RFC1522Codec.SEP);
                do {
                    i5--;
                    int i12 = this.jjstateSet[i5];
                    if (i12 != 0) {
                        if (i12 == 1 && (jjbitVec0[i11] & j) != 0 && i6 > 21) {
                            i6 = 21;
                        }
                    } else if ((jjbitVec0[i11] & j) != 0 && i6 > 23) {
                        i6 = 23;
                    }
                } while (i5 != i4);
            }
            if (i6 != Integer.MAX_VALUE) {
                this.jjmatchedKind = i6;
                this.jjmatchedPos = i3;
                i6 = Integer.MAX_VALUE;
            }
            i3++;
            i5 = this.jjnewStateCnt;
            this.jjnewStateCnt = i4;
            i4 = 3 - i4;
            if (i5 == i4) {
                return i3;
            }
            try {
                this.curChar = this.input_stream.readChar();
            } catch (IOException unused) {
                return i3;
            }
        }
    }

    private final int jjMoveNfa_3(int i, int i2) {
        this.jjnewStateCnt = 3;
        this.jjstateSet[0] = i;
        int i3 = i2;
        int i4 = 0;
        int i5 = 1;
        int i6 = Integer.MAX_VALUE;
        while (true) {
            int i7 = this.jjround + 1;
            this.jjround = i7;
            if (i7 == Integer.MAX_VALUE) {
                ReInitRounds();
            }
            char c = this.curChar;
            if (c < '@') {
                do {
                    i5--;
                    int i8 = this.jjstateSet[i5];
                    if (i8 != 0) {
                        if (i8 == 1 && i6 > 24) {
                            i6 = 24;
                        }
                    } else if (i6 > 27) {
                        i6 = 27;
                    }
                } while (i5 != i4);
            } else if (c < 128) {
                do {
                    int[] iArr = this.jjstateSet;
                    i5--;
                    int i9 = iArr[i5];
                    if (i9 == 0) {
                        if (i6 > 27) {
                            i6 = 27;
                        }
                        if (this.curChar == '\\') {
                            int i10 = this.jjnewStateCnt;
                            this.jjnewStateCnt = i10 + 1;
                            iArr[i10] = 1;
                        }
                    } else if (i9 != 1) {
                        if (i9 == 2 && i6 > 27) {
                            i6 = 27;
                        }
                    } else if (i6 > 24) {
                        i6 = 24;
                    }
                } while (i5 != i4);
            } else {
                int i11 = (c & 255) >> 6;
                long j = 1 << (c & RFC1522Codec.SEP);
                do {
                    i5--;
                    int i12 = this.jjstateSet[i5];
                    if (i12 != 0) {
                        if (i12 == 1 && (jjbitVec0[i11] & j) != 0 && i6 > 24) {
                            i6 = 24;
                        }
                    } else if ((jjbitVec0[i11] & j) != 0 && i6 > 27) {
                        i6 = 27;
                    }
                } while (i5 != i4);
            }
            if (i6 != Integer.MAX_VALUE) {
                this.jjmatchedKind = i6;
                this.jjmatchedPos = i3;
                i6 = Integer.MAX_VALUE;
            }
            i3++;
            i5 = this.jjnewStateCnt;
            this.jjnewStateCnt = i4;
            i4 = 3 - i4;
            if (i5 == i4) {
                return i3;
            }
            try {
                this.curChar = this.input_stream.readChar();
            } catch (IOException unused) {
                return i3;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00c7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final int jjMoveNfa_4(int r19, int r20) {
        /*
            Method dump skipped, instructions count: 250
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.broadcom.bt.util.mime4j.field.address.parser.AddressListParserTokenManager.jjMoveNfa_4(int, int):int");
    }

    private final int jjMoveStringLiteralDfa0_0() {
        char c = this.curChar;
        if (c == '\n') {
            return jjStopAtPos(0, 2);
        }
        if (c == '\r') {
            return jjStopAtPos(0, 1);
        }
        if (c == '\"') {
            return jjStopAtPos(0, 28);
        }
        if (c == '(') {
            return jjStopAtPos(0, 19);
        }
        if (c == ',') {
            return jjStopAtPos(0, 3);
        }
        if (c == '.') {
            return jjStopAtPos(0, 9);
        }
        if (c == '>') {
            return jjStopAtPos(0, 7);
        }
        if (c == '@') {
            return jjStopAtPos(0, 8);
        }
        if (c == '[') {
            return jjStopAtPos(0, 15);
        }
        switch (c) {
            case ':':
                return jjStopAtPos(0, 4);
            case ';':
                return jjStopAtPos(0, 5);
            case '<':
                return jjStopAtPos(0, 6);
            default:
                return jjMoveNfa_0(1, 0);
        }
    }

    private final int jjMoveStringLiteralDfa0_1() {
        return this.curChar != ']' ? jjMoveNfa_1(0, 0) : jjStopAtPos(0, 18);
    }

    private final int jjMoveStringLiteralDfa0_2() {
        char c = this.curChar;
        return c != '(' ? c != ')' ? jjMoveNfa_2(0, 0) : jjStopAtPos(0, 20) : jjStopAtPos(0, 22);
    }

    private final int jjMoveStringLiteralDfa0_3() {
        char c = this.curChar;
        return c != '(' ? c != ')' ? jjMoveNfa_3(0, 0) : jjStopAtPos(0, 26) : jjStopAtPos(0, 25);
    }

    private final int jjMoveStringLiteralDfa0_4() {
        return this.curChar != '\"' ? jjMoveNfa_4(0, 0) : jjStopAtPos(0, 31);
    }

    private final int jjStartNfaWithStates_0(int i, int i2, int i3) {
        this.jjmatchedKind = i2;
        this.jjmatchedPos = i;
        try {
            this.curChar = this.input_stream.readChar();
            return jjMoveNfa_0(i3, i + 1);
        } catch (IOException unused) {
            return i + 1;
        }
    }

    private final int jjStartNfaWithStates_1(int i, int i2, int i3) {
        this.jjmatchedKind = i2;
        this.jjmatchedPos = i;
        try {
            this.curChar = this.input_stream.readChar();
            return jjMoveNfa_1(i3, i + 1);
        } catch (IOException unused) {
            return i + 1;
        }
    }

    private final int jjStartNfaWithStates_2(int i, int i2, int i3) {
        this.jjmatchedKind = i2;
        this.jjmatchedPos = i;
        try {
            this.curChar = this.input_stream.readChar();
            return jjMoveNfa_2(i3, i + 1);
        } catch (IOException unused) {
            return i + 1;
        }
    }

    private final int jjStartNfaWithStates_3(int i, int i2, int i3) {
        this.jjmatchedKind = i2;
        this.jjmatchedPos = i;
        try {
            this.curChar = this.input_stream.readChar();
            return jjMoveNfa_3(i3, i + 1);
        } catch (IOException unused) {
            return i + 1;
        }
    }

    private final int jjStartNfaWithStates_4(int i, int i2, int i3) {
        this.jjmatchedKind = i2;
        this.jjmatchedPos = i;
        try {
            this.curChar = this.input_stream.readChar();
            return jjMoveNfa_4(i3, i + 1);
        } catch (IOException unused) {
            return i + 1;
        }
    }

    private final int jjStartNfa_0(int i, long j) {
        return jjMoveNfa_0(jjStopStringLiteralDfa_0(i, j), i + 1);
    }

    private final int jjStartNfa_1(int i, long j) {
        return jjMoveNfa_1(jjStopStringLiteralDfa_1(i, j), i + 1);
    }

    private final int jjStartNfa_2(int i, long j) {
        return jjMoveNfa_2(jjStopStringLiteralDfa_2(i, j), i + 1);
    }

    private final int jjStartNfa_3(int i, long j) {
        return jjMoveNfa_3(jjStopStringLiteralDfa_3(i, j), i + 1);
    }

    private final int jjStartNfa_4(int i, long j) {
        return jjMoveNfa_4(jjStopStringLiteralDfa_4(i, j), i + 1);
    }

    private final int jjStopAtPos(int i, int i2) {
        this.jjmatchedKind = i2;
        this.jjmatchedPos = i;
        return i + 1;
    }

    private final int jjStopStringLiteralDfa_0(int i, long j) {
        return -1;
    }

    private final int jjStopStringLiteralDfa_1(int i, long j) {
        return -1;
    }

    private final int jjStopStringLiteralDfa_2(int i, long j) {
        return -1;
    }

    private final int jjStopStringLiteralDfa_3(int i, long j) {
        return -1;
    }

    private final int jjStopStringLiteralDfa_4(int i, long j) {
        return -1;
    }

    public void MoreLexicalActions() {
        int i = this.jjimageLen;
        int i2 = this.jjmatchedPos + 1;
        this.lengthOfMatch = i2;
        this.jjimageLen = i + i2;
        int i3 = this.jjmatchedKind;
        if (i3 == 16) {
            if (this.image == null) {
                this.image = new StringBuffer();
            }
            this.image.append(this.input_stream.GetSuffix(this.jjimageLen));
            this.jjimageLen = 0;
            StringBuffer stringBuffer = this.image;
            stringBuffer.deleteCharAt(stringBuffer.length() - 2);
        }
        if (i3 == 21) {
            if (this.image == null) {
                this.image = new StringBuffer();
            }
            this.image.append(this.input_stream.GetSuffix(this.jjimageLen));
            this.jjimageLen = 0;
            StringBuffer stringBuffer2 = this.image;
            stringBuffer2.deleteCharAt(stringBuffer2.length() - 2);
            return;
        }
        if (i3 == 22) {
            if (this.image == null) {
                this.image = new StringBuffer();
            }
            this.image.append(this.input_stream.GetSuffix(this.jjimageLen));
            this.jjimageLen = 0;
            commentNest = 1;
            return;
        }
        if (i3 == 28) {
            if (this.image == null) {
                this.image = new StringBuffer();
            }
            this.image.append(this.input_stream.GetSuffix(this.jjimageLen));
            this.jjimageLen = 0;
            StringBuffer stringBuffer3 = this.image;
            stringBuffer3.deleteCharAt(stringBuffer3.length() - 1);
            return;
        }
        if (i3 == 29) {
            if (this.image == null) {
                this.image = new StringBuffer();
            }
            this.image.append(this.input_stream.GetSuffix(this.jjimageLen));
            this.jjimageLen = 0;
            StringBuffer stringBuffer4 = this.image;
            stringBuffer4.deleteCharAt(stringBuffer4.length() - 2);
            return;
        }
        switch (i3) {
            case 24:
                if (this.image == null) {
                    this.image = new StringBuffer();
                }
                this.image.append(this.input_stream.GetSuffix(this.jjimageLen));
                this.jjimageLen = 0;
                StringBuffer stringBuffer5 = this.image;
                stringBuffer5.deleteCharAt(stringBuffer5.length() - 2);
                break;
            case 25:
                if (this.image == null) {
                    this.image = new StringBuffer();
                }
                this.image.append(this.input_stream.GetSuffix(this.jjimageLen));
                this.jjimageLen = 0;
                commentNest++;
                break;
            case 26:
                if (this.image == null) {
                    this.image = new StringBuffer();
                }
                this.image.append(this.input_stream.GetSuffix(this.jjimageLen));
                this.jjimageLen = 0;
                int i4 = commentNest - 1;
                commentNest = i4;
                if (i4 == 0) {
                    SwitchTo(2);
                    break;
                }
                break;
        }
    }

    public void ReInit(SimpleCharStream simpleCharStream) {
        this.jjnewStateCnt = 0;
        this.jjmatchedPos = 0;
        this.curLexState = this.defaultLexState;
        this.input_stream = simpleCharStream;
        ReInitRounds();
    }

    public void SwitchTo(int i) {
        if (i < 5 && i >= 0) {
            this.curLexState = i;
            return;
        }
        throw new TokenMgrError("Error: Ignoring invalid lexical state : " + i + ". State unchanged.", 2);
    }

    public void TokenLexicalActions(Token token) {
        int i = this.jjmatchedKind;
        if (i == 18) {
            if (this.image == null) {
                this.image = new StringBuffer();
            }
            StringBuffer stringBuffer = this.image;
            SimpleCharStream simpleCharStream = this.input_stream;
            int i2 = this.jjimageLen;
            int i3 = this.jjmatchedPos + 1;
            this.lengthOfMatch = i3;
            stringBuffer.append(simpleCharStream.GetSuffix(i2 + i3));
            token.image = this.image.toString();
            return;
        }
        if (i != 31) {
            return;
        }
        if (this.image == null) {
            this.image = new StringBuffer();
        }
        StringBuffer stringBuffer2 = this.image;
        SimpleCharStream simpleCharStream2 = this.input_stream;
        int i4 = this.jjimageLen;
        int i5 = this.jjmatchedPos + 1;
        this.lengthOfMatch = i5;
        stringBuffer2.append(simpleCharStream2.GetSuffix(i4 + i5));
        token.image = this.image.substring(0, r0.length() - 1);
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x00af, code lost:
    
        if (((1 << (r9 & 63)) & com.broadcom.bt.util.mime4j.field.address.parser.AddressListParserTokenManager.jjtoSpecial[r9 >> 6]) == 0) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00b1, code lost:
    
        r7 = jjFillToken();
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00b5, code lost:
    
        if (r4 != null) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00b8, code lost:
    
        r7.specialToken = r4;
        r4.next = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00bc, code lost:
    
        r4 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00bd, code lost:
    
        r7 = com.broadcom.bt.util.mime4j.field.address.parser.AddressListParserTokenManager.jjnewLexState;
        r8 = r18.jjmatchedKind;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00c3, code lost:
    
        if (r7[r8] == (-1)) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00c5, code lost:
    
        r18.curLexState = r7[r8];
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.broadcom.bt.util.mime4j.field.address.parser.Token getNextToken() {
        /*
            Method dump skipped, instructions count: 332
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.broadcom.bt.util.mime4j.field.address.parser.AddressListParserTokenManager.getNextToken():com.broadcom.bt.util.mime4j.field.address.parser.Token");
    }

    public Token jjFillToken() {
        Token tokenNewToken = Token.newToken(this.jjmatchedKind);
        int i = this.jjmatchedKind;
        tokenNewToken.kind = i;
        String strGetImage = jjstrLiteralImages[i];
        if (strGetImage == null) {
            strGetImage = this.input_stream.GetImage();
        }
        tokenNewToken.image = strGetImage;
        tokenNewToken.beginLine = this.input_stream.getBeginLine();
        tokenNewToken.beginColumn = this.input_stream.getBeginColumn();
        tokenNewToken.endLine = this.input_stream.getEndLine();
        tokenNewToken.endColumn = this.input_stream.getEndColumn();
        return tokenNewToken;
    }

    public void setDebugStream(PrintStream printStream) {
        this.debugStream = printStream;
    }

    private final void jjCheckNAddStates(int i) {
        int[] iArr = jjnextStates;
        jjCheckNAdd(iArr[i]);
        jjCheckNAdd(iArr[i + 1]);
    }

    public void ReInit(SimpleCharStream simpleCharStream, int i) {
        ReInit(simpleCharStream);
        SwitchTo(i);
    }

    public AddressListParserTokenManager(SimpleCharStream simpleCharStream, int i) {
        this(simpleCharStream);
        SwitchTo(i);
    }
}
