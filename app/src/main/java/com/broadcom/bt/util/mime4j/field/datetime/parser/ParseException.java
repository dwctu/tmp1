package com.broadcom.bt.util.mime4j.field.datetime.parser;

import com.broadcom.bt.util.io.IOUtils;

/* loaded from: classes.dex */
public class ParseException extends Exception {
    public Token currentToken;
    public String eol;
    public int[][] expectedTokenSequences;
    public boolean specialConstructor;
    public String[] tokenImage;

    public ParseException(Token token, int[][] iArr, String[] strArr) {
        super("");
        this.eol = System.getProperty("line.separator", IOUtils.LINE_SEPARATOR_UNIX);
        this.specialConstructor = true;
        this.currentToken = token;
        this.expectedTokenSequences = iArr;
        this.tokenImage = strArr;
    }

    public String add_escapes(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt != 0) {
                if (cCharAt == '\"') {
                    stringBuffer.append("\\\"");
                } else if (cCharAt == '\'') {
                    stringBuffer.append("\\'");
                } else if (cCharAt == '\\') {
                    stringBuffer.append("\\\\");
                } else if (cCharAt == '\f') {
                    stringBuffer.append("\\f");
                } else if (cCharAt != '\r') {
                    switch (cCharAt) {
                        case '\b':
                            stringBuffer.append("\\b");
                            break;
                        case '\t':
                            stringBuffer.append("\\t");
                            break;
                        case '\n':
                            stringBuffer.append("\\n");
                            break;
                        default:
                            char cCharAt2 = str.charAt(i);
                            if (cCharAt2 < ' ' || cCharAt2 > '~') {
                                String str2 = "0000" + Integer.toString(cCharAt2, 16);
                                stringBuffer.append("\\u" + str2.substring(str2.length() - 4, str2.length()));
                                break;
                            } else {
                                stringBuffer.append(cCharAt2);
                                break;
                            }
                            break;
                    }
                } else {
                    stringBuffer.append("\\r");
                }
            }
        }
        return stringBuffer.toString();
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        String str;
        int[][] iArr;
        if (!this.specialConstructor) {
            return super.getMessage();
        }
        StringBuffer stringBuffer = new StringBuffer();
        int i = 0;
        int length = 0;
        while (true) {
            int[][] iArr2 = this.expectedTokenSequences;
            if (i >= iArr2.length) {
                break;
            }
            if (length < iArr2[i].length) {
                length = iArr2[i].length;
            }
            int i2 = 0;
            while (true) {
                iArr = this.expectedTokenSequences;
                if (i2 >= iArr[i].length) {
                    break;
                }
                stringBuffer.append(this.tokenImage[iArr[i][i2]]);
                stringBuffer.append(" ");
                i2++;
            }
            if (iArr[i][iArr[i].length - 1] != 0) {
                stringBuffer.append("...");
            }
            stringBuffer.append(this.eol);
            stringBuffer.append("    ");
            i++;
        }
        Token token = this.currentToken.next;
        String str2 = "Encountered \"";
        int i3 = 0;
        while (true) {
            if (i3 >= length) {
                break;
            }
            if (i3 != 0) {
                str2 = str2 + " ";
            }
            if (token.kind == 0) {
                str2 = str2 + this.tokenImage[0];
                break;
            }
            str2 = str2 + add_escapes(token.image);
            token = token.next;
            i3++;
        }
        String str3 = (str2 + "\" at line " + this.currentToken.next.beginLine + ", column " + this.currentToken.next.beginColumn) + "." + this.eol;
        if (this.expectedTokenSequences.length == 1) {
            str = str3 + "Was expecting:" + this.eol + "    ";
        } else {
            str = str3 + "Was expecting one of:" + this.eol + "    ";
        }
        return str + stringBuffer.toString();
    }

    public ParseException() {
        this.eol = System.getProperty("line.separator", IOUtils.LINE_SEPARATOR_UNIX);
        this.specialConstructor = false;
    }

    public ParseException(String str) {
        super(str);
        this.eol = System.getProperty("line.separator", IOUtils.LINE_SEPARATOR_UNIX);
        this.specialConstructor = false;
    }
}
