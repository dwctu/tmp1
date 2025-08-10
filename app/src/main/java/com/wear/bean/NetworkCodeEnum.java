package com.wear.bean;

import com.alibaba.fastjson.parser.JSONLexer;
import com.broadcom.bt.util.io.FilenameUtils;
import com.broadcom.bt.util.io.IOUtils;
import com.lovense.wear.R;
import com.wear.util.WearUtils;
import kotlin.text.Typography;
import org.apache.commons.codec.net.RFC1522Codec;
import org.aspectj.runtime.reflect.SignatureImpl;

/* loaded from: classes3.dex */
public class NetworkCodeEnum {

    public enum ErrorCode {
        e0("5000", WearUtils.Z1(R.string.common_serverError)),
        e1("5001", WearUtils.Z1(R.string.common_serverError)),
        e2("5002", WearUtils.Z1(R.string.common_serverError)),
        e3("5003", WearUtils.Z1(R.string.common_serverError)),
        e4("5004", WearUtils.Z1(R.string.refresh_token_expired)),
        e5("5005", WearUtils.Z1(R.string.common_serverError)),
        e6("5006", WearUtils.Z1(R.string.common_serverError)),
        e7("5007", WearUtils.Z1(R.string.common_serverError)),
        e10("50010", WearUtils.Z1(R.string.common_serverError)),
        e11("50011", WearUtils.Z1(R.string.common_serverError)),
        e12("50012", WearUtils.Z1(R.string.common_serverError)),
        e13("50013", WearUtils.Z1(R.string.common_serverError)),
        e14("50014", WearUtils.Z1(R.string.common_serverError)),
        e15("50015", WearUtils.Z1(R.string.common_serverError)),
        e16("50016", WearUtils.Z1(R.string.common_serverError)),
        e17("50017", WearUtils.Z1(R.string.common_serverError)),
        e18("50018", WearUtils.Z1(R.string.common_serverError)),
        e19("50019", WearUtils.Z1(R.string.common_serverError)),
        e20("50020", WearUtils.Z1(R.string.common_serverError)),
        e21("50021", WearUtils.Z1(R.string.common_serverError)),
        e22("50022", WearUtils.Z1(R.string.common_serverError)),
        e23("50023", WearUtils.Z1(R.string.common_serverError)),
        e24("50024", WearUtils.Z1(R.string.common_serverError)),
        e25("50025", WearUtils.Z1(R.string.common_serverError)),
        e26("50026", WearUtils.Z1(R.string.common_serverError)),
        e27("50027", WearUtils.Z1(R.string.common_serverError)),
        e28("50028", WearUtils.Z1(R.string.common_serverError)),
        e29("50029", WearUtils.Z1(R.string.common_serverError)),
        e30("50030", WearUtils.Z1(R.string.common_serverError)),
        e31("50031", WearUtils.Z1(R.string.common_serverError)),
        e32("50032", WearUtils.Z1(R.string.common_serverError)),
        e33("50033", WearUtils.Z1(R.string.common_serverError)),
        e34("50034", WearUtils.Z1(R.string.common_serverError)),
        e35("50035", WearUtils.Z1(R.string.common_serverError)),
        e36("50036", WearUtils.Z1(R.string.common_serverError)),
        e40("50040", WearUtils.Z1(R.string.common_serverError)),
        e41("50041", WearUtils.Z1(R.string.common_serverError)),
        e42("50042", WearUtils.Z1(R.string.common_serverError)),
        e43("50043", WearUtils.Z1(R.string.common_serverError)),
        e44("50044", WearUtils.Z1(R.string.common_serverError)),
        e45("50045", WearUtils.Z1(R.string.common_serverError)),
        e50("50050", WearUtils.Z1(R.string.common_serverError)),
        e51("50051", WearUtils.Z1(R.string.common_serverError)),
        e52("50052", WearUtils.Z1(R.string.common_serverError)),
        e53("50053", WearUtils.Z1(R.string.common_serverError)),
        e54("50054", WearUtils.Z1(R.string.common_serverError)),
        e50087("50087", WearUtils.Z1(R.string.password_is_weak2)),
        e60("50060", WearUtils.Z1(R.string.common_serverError)),
        e401("50401", WearUtils.Z1(R.string.common_serverError)),
        e402("50402", WearUtils.Z1(R.string.common_serverError)),
        e406("50406", WearUtils.Z1(R.string.common_serverError)),
        e408("50408", WearUtils.Z1(R.string.common_serverError)),
        e500("50500", WearUtils.Z1(R.string.common_serverError)),
        e501("50501", WearUtils.Z1(R.string.common_serverError)),
        e504("50504", WearUtils.Z1(R.string.common_serverError)),
        e12500("12500", WearUtils.Z1(R.string.common_serverError)),
        e12502("12502", WearUtils.Z1(R.string.common_serverError)),
        e99999("99999", WearUtils.Z1(R.string.common_serverError)),
        e20001("20001", WearUtils.Z1(R.string.common_serverError)),
        e20002("20002", WearUtils.Z1(R.string.common_serverError)),
        e20003("20003", WearUtils.Z1(R.string.common_serverError)),
        e20004("20004", WearUtils.Z1(R.string.common_serverError)),
        e20005("20005", WearUtils.Z1(R.string.common_serverError)),
        e20006("20006", WearUtils.Z1(R.string.common_serverError)),
        e20007("20007", WearUtils.Z1(R.string.common_serverError)),
        e20008("20008", WearUtils.Z1(R.string.common_serverError)),
        e20009("20009", WearUtils.Z1(R.string.common_serverError)),
        e20010("20010", WearUtils.Z1(R.string.common_serverError)),
        e20011("20011", WearUtils.Z1(R.string.common_serverError)),
        e20012("20012", WearUtils.Z1(R.string.common_serverError)),
        e20013("20013", WearUtils.Z1(R.string.common_serverError)),
        e20014("20014", WearUtils.Z1(R.string.common_serverError)),
        e20015("20015", WearUtils.Z1(R.string.common_serverError)),
        e20016("20016", WearUtils.Z1(R.string.common_serverError)),
        e20017("20017", WearUtils.Z1(R.string.common_serverError)),
        e600000("600000", WearUtils.Z1(R.string.common_serverError)),
        eError("S000", WearUtils.Z1(R.string.common_serverError)),
        eOther("S000", WearUtils.Z1(R.string.common_serverError));

        private String code;
        private String notice;

        ErrorCode(String str, String str2) {
            this.code = str;
            this.notice = str2;
        }

        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        public static ErrorCode fromString(String str, String str2) {
            if (str == null) {
                return eError;
            }
            str.hashCode();
            char c = 65535;
            switch (str.hashCode()) {
                case 1626587:
                    if (str.equals("5000")) {
                        c = 0;
                        break;
                    }
                    break;
                case 1626588:
                    if (str.equals("5001")) {
                        c = 1;
                        break;
                    }
                    break;
                case 1626589:
                    if (str.equals("5002")) {
                        c = 2;
                        break;
                    }
                    break;
                case 1626590:
                    if (str.equals("5003")) {
                        c = 3;
                        break;
                    }
                    break;
                case 1626591:
                    if (str.equals("5004")) {
                        c = 4;
                        break;
                    }
                    break;
                case 1626592:
                    if (str.equals("5005")) {
                        c = 5;
                        break;
                    }
                    break;
                case 1626593:
                    if (str.equals("5006")) {
                        c = 6;
                        break;
                    }
                    break;
                case 1626594:
                    if (str.equals("5007")) {
                        c = 7;
                        break;
                    }
                    break;
                case 46794548:
                    if (str.equals("12500")) {
                        c = '\b';
                        break;
                    }
                    break;
                case 46794550:
                    if (str.equals("12502")) {
                        c = '\t';
                        break;
                    }
                    break;
                case 47653683:
                    if (str.equals("20001")) {
                        c = '\n';
                        break;
                    }
                    break;
                case 47653684:
                    if (str.equals("20002")) {
                        c = 11;
                        break;
                    }
                    break;
                case 47653685:
                    if (str.equals("20003")) {
                        c = '\f';
                        break;
                    }
                    break;
                case 47653686:
                    if (str.equals("20004")) {
                        c = '\r';
                        break;
                    }
                    break;
                case 47653687:
                    if (str.equals("20005")) {
                        c = 14;
                        break;
                    }
                    break;
                case 47653688:
                    if (str.equals("20006")) {
                        c = 15;
                        break;
                    }
                    break;
                case 47653689:
                    if (str.equals("20007")) {
                        c = 16;
                        break;
                    }
                    break;
                case 47653690:
                    if (str.equals("20008")) {
                        c = 17;
                        break;
                    }
                    break;
                case 47653691:
                    if (str.equals("20009")) {
                        c = 18;
                        break;
                    }
                    break;
                case 47653713:
                    if (str.equals("20010")) {
                        c = 19;
                        break;
                    }
                    break;
                case 47653714:
                    if (str.equals("20011")) {
                        c = 20;
                        break;
                    }
                    break;
                case 47653715:
                    if (str.equals("20012")) {
                        c = 21;
                        break;
                    }
                    break;
                case 47653716:
                    if (str.equals("20013")) {
                        c = 22;
                        break;
                    }
                    break;
                case 47653717:
                    if (str.equals("20014")) {
                        c = 23;
                        break;
                    }
                    break;
                case 47653718:
                    if (str.equals("20015")) {
                        c = 24;
                        break;
                    }
                    break;
                case 47653719:
                    if (str.equals("20016")) {
                        c = 25;
                        break;
                    }
                    break;
                case 47653720:
                    if (str.equals("20017")) {
                        c = JSONLexer.EOI;
                        break;
                    }
                    break;
                case 50424276:
                    if (str.equals("50010")) {
                        c = 27;
                        break;
                    }
                    break;
                case 50424277:
                    if (str.equals("50011")) {
                        c = 28;
                        break;
                    }
                    break;
                case 50424278:
                    if (str.equals("50012")) {
                        c = 29;
                        break;
                    }
                    break;
                case 50424279:
                    if (str.equals("50013")) {
                        c = 30;
                        break;
                    }
                    break;
                case 50424280:
                    if (str.equals("50014")) {
                        c = 31;
                        break;
                    }
                    break;
                case 50424281:
                    if (str.equals("50015")) {
                        c = ' ';
                        break;
                    }
                    break;
                case 50424282:
                    if (str.equals("50016")) {
                        c = '!';
                        break;
                    }
                    break;
                case 50424283:
                    if (str.equals("50017")) {
                        c = Typography.quote;
                        break;
                    }
                    break;
                case 50424284:
                    if (str.equals("50018")) {
                        c = '#';
                        break;
                    }
                    break;
                case 50424285:
                    if (str.equals("50019")) {
                        c = Typography.dollar;
                        break;
                    }
                    break;
                case 50424307:
                    if (str.equals("50020")) {
                        c = '%';
                        break;
                    }
                    break;
                case 50424308:
                    if (str.equals("50021")) {
                        c = Typography.amp;
                        break;
                    }
                    break;
                case 50424309:
                    if (str.equals("50022")) {
                        c = '\'';
                        break;
                    }
                    break;
                case 50424310:
                    if (str.equals("50023")) {
                        c = '(';
                        break;
                    }
                    break;
                case 50424311:
                    if (str.equals("50024")) {
                        c = ')';
                        break;
                    }
                    break;
                case 50424312:
                    if (str.equals("50025")) {
                        c = '*';
                        break;
                    }
                    break;
                case 50424313:
                    if (str.equals("50026")) {
                        c = '+';
                        break;
                    }
                    break;
                case 50424314:
                    if (str.equals("50027")) {
                        c = ',';
                        break;
                    }
                    break;
                case 50424315:
                    if (str.equals("50028")) {
                        c = SignatureImpl.SEP;
                        break;
                    }
                    break;
                case 50424316:
                    if (str.equals("50029")) {
                        c = FilenameUtils.EXTENSION_SEPARATOR;
                        break;
                    }
                    break;
                case 50424338:
                    if (str.equals("50030")) {
                        c = IOUtils.DIR_SEPARATOR_UNIX;
                        break;
                    }
                    break;
                case 50424339:
                    if (str.equals("50031")) {
                        c = '0';
                        break;
                    }
                    break;
                case 50424340:
                    if (str.equals("50032")) {
                        c = '1';
                        break;
                    }
                    break;
                case 50424341:
                    if (str.equals("50033")) {
                        c = '2';
                        break;
                    }
                    break;
                case 50424342:
                    if (str.equals("50034")) {
                        c = '3';
                        break;
                    }
                    break;
                case 50424343:
                    if (str.equals("50035")) {
                        c = '4';
                        break;
                    }
                    break;
                case 50424344:
                    if (str.equals("50036")) {
                        c = '5';
                        break;
                    }
                    break;
                case 50424369:
                    if (str.equals("50040")) {
                        c = '6';
                        break;
                    }
                    break;
                case 50424370:
                    if (str.equals("50041")) {
                        c = '7';
                        break;
                    }
                    break;
                case 50424371:
                    if (str.equals("50042")) {
                        c = '8';
                        break;
                    }
                    break;
                case 50424372:
                    if (str.equals("50043")) {
                        c = '9';
                        break;
                    }
                    break;
                case 50424373:
                    if (str.equals("50044")) {
                        c = ':';
                        break;
                    }
                    break;
                case 50424374:
                    if (str.equals("50045")) {
                        c = ';';
                        break;
                    }
                    break;
                case 50424400:
                    if (str.equals("50050")) {
                        c = Typography.less;
                        break;
                    }
                    break;
                case 50424401:
                    if (str.equals("50051")) {
                        c = '=';
                        break;
                    }
                    break;
                case 50424402:
                    if (str.equals("50052")) {
                        c = Typography.greater;
                        break;
                    }
                    break;
                case 50424403:
                    if (str.equals("50053")) {
                        c = RFC1522Codec.SEP;
                        break;
                    }
                    break;
                case 50424404:
                    if (str.equals("50054")) {
                        c = '@';
                        break;
                    }
                    break;
                case 50424431:
                    if (str.equals("50060")) {
                        c = 'A';
                        break;
                    }
                    break;
                case 50428090:
                    if (str.equals("50401")) {
                        c = 'B';
                        break;
                    }
                    break;
                case 50428091:
                    if (str.equals("50402")) {
                        c = 'C';
                        break;
                    }
                    break;
                case 50428095:
                    if (str.equals("50406")) {
                        c = 'D';
                        break;
                    }
                    break;
                case 50428097:
                    if (str.equals("50408")) {
                        c = 'E';
                        break;
                    }
                    break;
                case 50429050:
                    if (str.equals("50500")) {
                        c = 'F';
                        break;
                    }
                    break;
                case 50429051:
                    if (str.equals("50501")) {
                        c = 'G';
                        break;
                    }
                    break;
                case 50429054:
                    if (str.equals("50504")) {
                        c = 'H';
                        break;
                    }
                    break;
                case 54395385:
                    if (str.equals("99999")) {
                        c = 'I';
                        break;
                    }
                    break;
                case 1591780794:
                    if (str.equals("600000")) {
                        c = 'J';
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    return e0;
                case 1:
                    return e1;
                case 2:
                    return e2;
                case 3:
                    return e3;
                case 4:
                    return e4;
                case 5:
                    return e5;
                case 6:
                    return e6;
                case 7:
                    return e7;
                case '\b':
                    return e12500;
                case '\t':
                    return e12502;
                case '\n':
                    return e20001;
                case 11:
                    return e20002;
                case '\f':
                    return e20003;
                case '\r':
                    return e20004;
                case 14:
                    return e20005;
                case 15:
                    return e20006;
                case 16:
                    return e20007;
                case 17:
                    return e20008;
                case 18:
                    return e20009;
                case 19:
                    return e20010;
                case 20:
                    return e20011;
                case 21:
                    return e20012;
                case 22:
                    return e20013;
                case 23:
                    return e20014;
                case 24:
                    return e20015;
                case 25:
                    return e20016;
                case 26:
                    return e20017;
                case 27:
                    return e10;
                case 28:
                    return e11;
                case 29:
                    return e12;
                case 30:
                    return e13;
                case 31:
                    return e14;
                case ' ':
                    return e15;
                case '!':
                    return e16;
                case '\"':
                    return e17;
                case '#':
                    return e18;
                case '$':
                    return e19;
                case '%':
                    return e20;
                case '&':
                    return e21;
                case '\'':
                    return e22;
                case '(':
                    return e23;
                case ')':
                    return e24;
                case '*':
                    return e25;
                case '+':
                    return e26;
                case ',':
                    return e27;
                case '-':
                    return e28;
                case '.':
                    return e29;
                case '/':
                    return e30;
                case '0':
                    return e31;
                case '1':
                    return e32;
                case '2':
                    return e33;
                case '3':
                    return e34;
                case '4':
                    return e35;
                case '5':
                    return e36;
                case '6':
                    return e40;
                case '7':
                    return e41;
                case '8':
                    return e42;
                case '9':
                    return e43;
                case ':':
                    return e44;
                case ';':
                    return e45;
                case '<':
                    return e50;
                case '=':
                    return e51;
                case '>':
                    return e52;
                case '?':
                    return e53;
                case '@':
                    return e54;
                case 'A':
                    return e60;
                case 'B':
                    return e401;
                case 'C':
                    return e402;
                case 'D':
                    return e406;
                case 'E':
                    return e408;
                case 'F':
                    return e500;
                case 'G':
                    return e501;
                case 'H':
                    return e504;
                case 'I':
                    return e99999;
                case 'J':
                    return e600000;
                default:
                    ErrorCode errorCode = eOther;
                    errorCode.setCode(str);
                    return errorCode;
            }
        }

        public String getCode() {
            return this.code;
        }

        public String getNotice() {
            return this.notice;
        }

        public void setCode(String str) {
            this.code = str;
        }

        public void setNotice(String str) {
            this.notice = str;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.code;
        }
    }
}
