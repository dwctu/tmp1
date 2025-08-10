package org.jivesoftware.smackx.disco.packet;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.util.StringUtils;
import org.jivesoftware.smack.util.TypedCloneable;
import org.jivesoftware.smack.util.XmlStringBuilder;
import org.jxmpp.util.XmppStringUtils;

/* loaded from: classes5.dex */
public class DiscoverInfo extends IQ implements TypedCloneable<DiscoverInfo> {
    public static final String ELEMENT = "query";
    public static final String NAMESPACE = "http://jabber.org/protocol/disco#info";
    private boolean containsDuplicateFeatures;
    private final List<Feature> features;
    private final Set<Feature> featuresSet;
    private final List<Identity> identities;
    private final Set<String> identitiesSet;
    private String node;

    public static class Feature implements TypedCloneable<Feature> {
        private final String variable;

        public Feature(Feature feature) {
            this.variable = feature.variable;
        }

        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            if (obj == this) {
                return true;
            }
            if (obj.getClass() != getClass()) {
                return false;
            }
            return this.variable.equals(((Feature) obj).variable);
        }

        public String getVar() {
            return this.variable;
        }

        public int hashCode() {
            return this.variable.hashCode();
        }

        public XmlStringBuilder toXML() {
            XmlStringBuilder xmlStringBuilder = new XmlStringBuilder();
            xmlStringBuilder.halfOpenElement("feature");
            xmlStringBuilder.attribute("var", this.variable);
            xmlStringBuilder.closeEmptyElement();
            return xmlStringBuilder;
        }

        @Override // org.jivesoftware.smack.util.TypedCloneable
        public Feature clone() {
            return new Feature(this);
        }

        public Feature(String str) {
            this.variable = (String) StringUtils.requireNotNullOrEmpty(str, "variable cannot be null");
        }
    }

    public static class Identity implements Comparable<Identity>, TypedCloneable<Identity> {
        private final String category;
        private final String key;
        private final String lang;
        private final String name;
        private final String type;

        public Identity(Identity identity) {
            this.category = identity.category;
            this.type = identity.type;
            this.key = identity.type;
            this.name = identity.name;
            this.lang = identity.lang;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String getKey() {
            return this.key;
        }

        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            if (obj == this) {
                return true;
            }
            if (obj.getClass() != getClass()) {
                return false;
            }
            Identity identity = (Identity) obj;
            if (!this.key.equals(identity.key)) {
                return false;
            }
            String str = identity.lang;
            if (str == null) {
                str = "";
            }
            String str2 = this.lang;
            if (str2 == null) {
                str2 = "";
            }
            if (!str.equals(str2)) {
                return false;
            }
            String str3 = identity.name;
            return (this.name != null ? str3 : "").equals(str3 == null ? "" : str3);
        }

        public String getCategory() {
            return this.category;
        }

        public String getLanguage() {
            return this.lang;
        }

        public String getName() {
            return this.name;
        }

        public String getType() {
            return this.type;
        }

        public int hashCode() {
            int iHashCode = (this.key.hashCode() + 37) * 37;
            String str = this.lang;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 37;
            String str2 = this.name;
            return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
        }

        public boolean isOfCategoryAndType(String str, String str2) {
            return this.category.equals(str) && this.type.equals(str2);
        }

        public XmlStringBuilder toXML() {
            XmlStringBuilder xmlStringBuilder = new XmlStringBuilder();
            xmlStringBuilder.halfOpenElement("identity");
            xmlStringBuilder.xmllangAttribute(this.lang);
            xmlStringBuilder.attribute("category", this.category);
            xmlStringBuilder.optAttribute("name", this.name);
            xmlStringBuilder.optAttribute("type", this.type);
            xmlStringBuilder.closeEmptyElement();
            return xmlStringBuilder;
        }

        @Override // org.jivesoftware.smack.util.TypedCloneable
        public Identity clone() {
            return new Identity(this);
        }

        @Override // java.lang.Comparable
        public int compareTo(Identity identity) {
            String str = identity.lang;
            if (str == null) {
                str = "";
            }
            String str2 = this.lang;
            if (str2 == null) {
                str2 = "";
            }
            String str3 = identity.type;
            if (str3 == null) {
                str3 = "";
            }
            String str4 = this.type;
            String str5 = str4 != null ? str4 : "";
            if (!this.category.equals(identity.category)) {
                return this.category.compareTo(identity.category);
            }
            if (!str5.equals(str3)) {
                return str5.compareTo(str3);
            }
            if (str2.equals(str)) {
                return 0;
            }
            return str2.compareTo(str);
        }

        public Identity(String str, String str2) {
            this(str, str2, null, null);
        }

        public Identity(String str, String str2, String str3) {
            this(str, str3, str2, null);
        }

        public Identity(String str, String str2, String str3, String str4) {
            this.category = (String) StringUtils.requireNotNullOrEmpty(str, "category cannot be null");
            this.type = (String) StringUtils.requireNotNullOrEmpty(str2, "type cannot be null");
            this.key = XmppStringUtils.generateKey(str, str2);
            this.name = str3;
            this.lang = str4;
        }
    }

    public DiscoverInfo() {
        super("query", NAMESPACE);
        this.features = new LinkedList();
        this.featuresSet = new HashSet();
        this.identities = new LinkedList();
        this.identitiesSet = new HashSet();
    }

    public boolean addFeature(String str) {
        return addFeature(new Feature(str));
    }

    public void addFeatures(Collection<String> collection) {
        if (collection == null) {
            return;
        }
        Iterator<String> it = collection.iterator();
        while (it.hasNext()) {
            addFeature(it.next());
        }
    }

    public void addIdentities(Collection<Identity> collection) {
        if (collection == null) {
            return;
        }
        Iterator<Identity> it = collection.iterator();
        while (it.hasNext()) {
            addIdentity(it.next());
        }
    }

    public void addIdentity(Identity identity) {
        this.identities.add(identity);
        this.identitiesSet.add(identity.getKey());
    }

    public boolean containsDuplicateFeatures() {
        return this.containsDuplicateFeatures;
    }

    public boolean containsDuplicateIdentities() {
        LinkedList linkedList = new LinkedList();
        for (Identity identity : this.identities) {
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                if (identity.equals((Identity) it.next())) {
                    return true;
                }
            }
            linkedList.add(identity);
        }
        return false;
    }

    public boolean containsFeature(String str) {
        return this.features.contains(new Feature(str));
    }

    public List<Feature> getFeatures() {
        return Collections.unmodifiableList(this.features);
    }

    @Override // org.jivesoftware.smack.packet.IQ
    public IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(IQ.IQChildElementXmlStringBuilder iQChildElementXmlStringBuilder) {
        iQChildElementXmlStringBuilder.optAttribute("node", getNode());
        iQChildElementXmlStringBuilder.rightAngleBracket();
        Iterator<Identity> it = this.identities.iterator();
        while (it.hasNext()) {
            iQChildElementXmlStringBuilder.append(it.next().toXML());
        }
        Iterator<Feature> it2 = this.features.iterator();
        while (it2.hasNext()) {
            iQChildElementXmlStringBuilder.append(it2.next().toXML());
        }
        return iQChildElementXmlStringBuilder;
    }

    public List<Identity> getIdentities() {
        return Collections.unmodifiableList(this.identities);
    }

    public String getNode() {
        return this.node;
    }

    public boolean hasIdentity(String str, String str2) {
        return this.identitiesSet.contains(XmppStringUtils.generateKey(str, str2));
    }

    public void setNode(String str) {
        this.node = str;
    }

    public boolean addFeature(Feature feature) {
        this.features.add(feature);
        boolean zAdd = this.featuresSet.add(feature);
        if (!zAdd) {
            this.containsDuplicateFeatures = true;
        }
        return zAdd;
    }

    @Override // org.jivesoftware.smack.util.TypedCloneable
    public DiscoverInfo clone() {
        return new DiscoverInfo(this);
    }

    public List<Identity> getIdentities(String str, String str2) {
        ArrayList arrayList = new ArrayList(this.identities.size());
        for (Identity identity : this.identities) {
            if (identity.getCategory().equals(str) && identity.getType().equals(str2)) {
                arrayList.add(identity);
            }
        }
        return arrayList;
    }

    public DiscoverInfo(DiscoverInfo discoverInfo) {
        super(discoverInfo);
        this.features = new LinkedList();
        this.featuresSet = new HashSet();
        this.identities = new LinkedList();
        this.identitiesSet = new HashSet();
        setNode(discoverInfo.getNode());
        Iterator<Feature> it = discoverInfo.features.iterator();
        while (it.hasNext()) {
            addFeature(it.next().clone());
        }
        Iterator<Identity> it2 = discoverInfo.identities.iterator();
        while (it2.hasNext()) {
            addIdentity(it2.next().clone());
        }
    }
}
