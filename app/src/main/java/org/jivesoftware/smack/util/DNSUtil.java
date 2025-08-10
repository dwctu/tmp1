package org.jivesoftware.smack.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.aspectj.runtime.reflect.SignatureImpl;
import org.jivesoftware.smack.util.dns.DNSResolver;
import org.jivesoftware.smack.util.dns.HostAddress;
import org.jivesoftware.smack.util.dns.SRVRecord;

/* loaded from: classes5.dex */
public class DNSUtil {
    private static final Logger LOGGER = Logger.getLogger(DNSUtil.class.getName());
    private static DNSResolver dnsResolver = null;
    private static StringTransformer idnaTransformer = new StringTransformer() { // from class: org.jivesoftware.smack.util.DNSUtil.1
        @Override // org.jivesoftware.smack.util.StringTransformer
        public String transform(String str) {
            return str;
        }
    };

    /* renamed from: org.jivesoftware.smack.util.DNSUtil$2, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {
        public static final /* synthetic */ int[] $SwitchMap$org$jivesoftware$smack$util$DNSUtil$DomainType;

        static {
            int[] iArr = new int[DomainType.values().length];
            $SwitchMap$org$jivesoftware$smack$util$DNSUtil$DomainType = iArr;
            try {
                iArr[DomainType.Server.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$jivesoftware$smack$util$DNSUtil$DomainType[DomainType.Client.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public enum DomainType {
        Server,
        Client
    }

    private static int bisect(int[] iArr, double d) {
        int length = iArr.length;
        int i = 0;
        for (int i2 = 0; i2 < length && d >= iArr[i2]; i2++) {
            i++;
        }
        return i;
    }

    public static DNSResolver getDNSResolver() {
        return dnsResolver;
    }

    private static List<HostAddress> resolveDomain(String str, DomainType domainType, List<HostAddress> list) {
        String str2;
        ArrayList arrayList = new ArrayList();
        int i = AnonymousClass2.$SwitchMap$org$jivesoftware$smack$util$DNSUtil$DomainType[domainType.ordinal()];
        if (i == 1) {
            str2 = "_xmpp-server._tcp." + str;
        } else {
            if (i != 2) {
                throw new AssertionError();
            }
            str2 = "_xmpp-client._tcp." + str;
        }
        try {
            List<SRVRecord> listLookupSRVRecords = dnsResolver.lookupSRVRecords(str2);
            if (LOGGER.isLoggable(Level.FINE)) {
                String str3 = "Resolved SRV RR for " + str2 + SignatureImpl.INNER_SEP;
                Iterator<SRVRecord> it = listLookupSRVRecords.iterator();
                while (it.hasNext()) {
                    str3 = str3 + " " + it.next();
                }
                LOGGER.fine(str3);
            }
            arrayList.addAll(sortSRVRecords(listLookupSRVRecords));
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "Exception while resovling SRV records for " + str + ". Consider adding '_xmpp-(server|client)._tcp' DNS SRV Records", (Throwable) e);
            if (list != null) {
                HostAddress hostAddress = new HostAddress(str2);
                hostAddress.setException(e);
                list.add(hostAddress);
            }
        }
        arrayList.add(new HostAddress(str));
        return arrayList;
    }

    public static List<HostAddress> resolveXMPPDomain(String str, List<HostAddress> list) {
        String strTransform = idnaTransformer.transform(str);
        if (dnsResolver != null) {
            return resolveDomain(strTransform, DomainType.Client, list);
        }
        LOGGER.warning("No DNS Resolver active in Smack, will be unable to perform DNS SRV lookups");
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(new HostAddress(strTransform, 5222));
        return arrayList;
    }

    public static List<HostAddress> resolveXMPPServerDomain(String str, List<HostAddress> list) {
        String strTransform = idnaTransformer.transform(str);
        if (dnsResolver != null) {
            return resolveDomain(strTransform, DomainType.Server, list);
        }
        LOGGER.warning("No DNS Resolver active in Smack, will be unable to perform DNS SRV lookups");
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(new HostAddress(strTransform, 5269));
        return arrayList;
    }

    public static void setDNSResolver(DNSResolver dNSResolver) {
        dnsResolver = dNSResolver;
    }

    public static void setIdnaTransformer(StringTransformer stringTransformer) {
        java.util.Objects.requireNonNull(stringTransformer);
        idnaTransformer = stringTransformer;
    }

    private static List<HostAddress> sortSRVRecords(List<SRVRecord> list) {
        if (list.size() == 1 && list.get(0).getFQDN().equals(".")) {
            return Collections.emptyList();
        }
        Collections.sort(list);
        TreeMap treeMap = new TreeMap();
        for (SRVRecord sRVRecord : list) {
            Integer numValueOf = Integer.valueOf(sRVRecord.getPriority());
            List linkedList = (List) treeMap.get(numValueOf);
            if (linkedList == null) {
                linkedList = new LinkedList();
                treeMap.put(numValueOf, linkedList);
            }
            linkedList.add(sRVRecord);
        }
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = treeMap.keySet().iterator();
        while (it.hasNext()) {
            List list2 = (List) treeMap.get((Integer) it.next());
            while (true) {
                int size = list2.size();
                if (size > 0) {
                    int[] iArr = new int[list2.size()];
                    Iterator it2 = list2.iterator();
                    int i = 1;
                    while (it2.hasNext()) {
                        if (((SRVRecord) it2.next()).getWeight() > 0) {
                            i = 0;
                        }
                    }
                    Iterator it3 = list2.iterator();
                    int weight = 0;
                    int i2 = 0;
                    while (it3.hasNext()) {
                        weight += ((SRVRecord) it3.next()).getWeight() + i;
                        iArr[i2] = weight;
                        i2++;
                    }
                    arrayList.add((SRVRecord) list2.remove(weight == 0 ? (int) (Math.random() * size) : bisect(iArr, Math.random() * weight)));
                }
            }
        }
        return arrayList;
    }
}
