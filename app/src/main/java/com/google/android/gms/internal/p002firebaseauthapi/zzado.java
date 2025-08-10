package com.google.android.gms.internal.p002firebaseauthapi;

import com.broadcom.bt.util.io.IOUtils;
import com.spotify.sdk.android.player.Config;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import kotlin.text.Typography;
import org.jivesoftware.smackx.rsm.packet.RSMSet;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public final class zzado {
    public static String zza(zzadm zzadmVar, String str) throws SecurityException {
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(str);
        zzd(zzadmVar, sb, 0);
        return sb.toString();
    }

    public static final void zzb(StringBuilder sb, int i, String str, Object obj) throws SecurityException {
        if (obj instanceof List) {
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                zzb(sb, i, str, it.next());
            }
            return;
        }
        if (obj instanceof Map) {
            Iterator it2 = ((Map) obj).entrySet().iterator();
            while (it2.hasNext()) {
                zzb(sb, i, str, (Map.Entry) it2.next());
            }
            return;
        }
        sb.append('\n');
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            sb.append(' ');
        }
        sb.append(str);
        if (obj instanceof String) {
            sb.append(": \"");
            sb.append(zzaen.zza(zzabe.zzp((String) obj)));
            sb.append(Typography.quote);
            return;
        }
        if (obj instanceof zzabe) {
            sb.append(": \"");
            sb.append(zzaen.zza((zzabe) obj));
            sb.append(Typography.quote);
            return;
        }
        if (obj instanceof zzach) {
            sb.append(" {");
            zzd((zzach) obj, sb, i + 2);
            sb.append(IOUtils.LINE_SEPARATOR_UNIX);
            while (i2 < i) {
                sb.append(' ');
                i2++;
            }
            sb.append("}");
            return;
        }
        if (!(obj instanceof Map.Entry)) {
            sb.append(": ");
            sb.append(obj);
            return;
        }
        sb.append(" {");
        Map.Entry entry = (Map.Entry) obj;
        int i4 = i + 2;
        zzb(sb, i4, "key", entry.getKey());
        zzb(sb, i4, "value", entry.getValue());
        sb.append(IOUtils.LINE_SEPARATOR_UNIX);
        while (i2 < i) {
            sb.append(' ');
            i2++;
        }
        sb.append("}");
    }

    private static final String zzc(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (Character.isUpperCase(cCharAt)) {
                sb.append(Config.IN_FIELD_SEPARATOR);
            }
            sb.append(Character.toLowerCase(cCharAt));
        }
        return sb.toString();
    }

    private static void zzd(zzadm zzadmVar, StringBuilder sb, int i) throws SecurityException {
        boolean zEquals;
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        TreeSet<String> treeSet = new TreeSet();
        for (Method method : zzadmVar.getClass().getDeclaredMethods()) {
            map2.put(method.getName(), method);
            if (method.getParameterTypes().length == 0) {
                map.put(method.getName(), method);
                if (method.getName().startsWith("get")) {
                    treeSet.add(method.getName());
                }
            }
        }
        for (String str : treeSet) {
            String strSubstring = str.startsWith("get") ? str.substring(3) : str;
            if (strSubstring.endsWith("List") && !strSubstring.endsWith("OrBuilderList") && !strSubstring.equals("List")) {
                String strConcat = String.valueOf(strSubstring.substring(0, 1).toLowerCase()).concat(String.valueOf(strSubstring.substring(1, strSubstring.length() - 4)));
                Method method2 = (Method) map.get(str);
                if (method2 != null && method2.getReturnType().equals(List.class)) {
                    zzb(sb, i, zzc(strConcat), zzach.zzC(method2, zzadmVar, new Object[0]));
                }
            }
            if (strSubstring.endsWith("Map") && !strSubstring.equals("Map")) {
                String strConcat2 = String.valueOf(strSubstring.substring(0, 1).toLowerCase()).concat(String.valueOf(strSubstring.substring(1, strSubstring.length() - 3)));
                Method method3 = (Method) map.get(str);
                if (method3 != null && method3.getReturnType().equals(Map.class) && !method3.isAnnotationPresent(Deprecated.class) && Modifier.isPublic(method3.getModifiers())) {
                    zzb(sb, i, zzc(strConcat2), zzach.zzC(method3, zzadmVar, new Object[0]));
                }
            }
            if (((Method) map2.get(RSMSet.ELEMENT.concat(String.valueOf(strSubstring)))) != null && (!strSubstring.endsWith("Bytes") || !map.containsKey("get".concat(String.valueOf(strSubstring.substring(0, strSubstring.length() - 5)))))) {
                String strConcat3 = String.valueOf(strSubstring.substring(0, 1).toLowerCase()).concat(String.valueOf(strSubstring.substring(1)));
                Method method4 = (Method) map.get("get".concat(String.valueOf(strSubstring)));
                Method method5 = (Method) map.get("has".concat(String.valueOf(strSubstring)));
                if (method4 != null) {
                    Object objZzC = zzach.zzC(method4, zzadmVar, new Object[0]);
                    if (method5 == null) {
                        if (objZzC instanceof Boolean) {
                            if (((Boolean) objZzC).booleanValue()) {
                                zzb(sb, i, zzc(strConcat3), objZzC);
                            }
                        } else if (objZzC instanceof Integer) {
                            if (((Integer) objZzC).intValue() != 0) {
                                zzb(sb, i, zzc(strConcat3), objZzC);
                            }
                        } else if (objZzC instanceof Float) {
                            if (Float.floatToRawIntBits(((Float) objZzC).floatValue()) != 0) {
                                zzb(sb, i, zzc(strConcat3), objZzC);
                            }
                        } else if (!(objZzC instanceof Double)) {
                            if (objZzC instanceof String) {
                                zEquals = objZzC.equals("");
                            } else if (objZzC instanceof zzabe) {
                                zEquals = objZzC.equals(zzabe.zzb);
                            } else if (objZzC instanceof zzadm) {
                                if (objZzC != ((zzadm) objZzC).zzH()) {
                                    zzb(sb, i, zzc(strConcat3), objZzC);
                                }
                            } else if (!(objZzC instanceof Enum) || ((Enum) objZzC).ordinal() != 0) {
                                zzb(sb, i, zzc(strConcat3), objZzC);
                            }
                            if (!zEquals) {
                                zzb(sb, i, zzc(strConcat3), objZzC);
                            }
                        } else if (Double.doubleToRawLongBits(((Double) objZzC).doubleValue()) != 0) {
                            zzb(sb, i, zzc(strConcat3), objZzC);
                        }
                    } else if (((Boolean) zzach.zzC(method5, zzadmVar, new Object[0])).booleanValue()) {
                        zzb(sb, i, zzc(strConcat3), objZzC);
                    }
                }
            }
        }
        if (zzadmVar instanceof zzace) {
            zzabz zzabzVar = ((zzace) zzadmVar).zzb;
            throw null;
        }
        zzaeq zzaeqVar = ((zzach) zzadmVar).zzc;
        if (zzaeqVar != null) {
            zzaeqVar.zzg(sb, i);
        }
    }
}
