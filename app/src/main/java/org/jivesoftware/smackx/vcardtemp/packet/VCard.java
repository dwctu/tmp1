package org.jivesoftware.smackx.vcardtemp.packet;

import com.google.android.vending.expansion.downloader.impl.DownloadsDB;
import com.wear.util.WearUtils;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.util.StringUtils;
import org.jivesoftware.smack.util.stringencoder.Base64;
import org.jivesoftware.smackx.vcardtemp.VCardManager;

/* loaded from: classes5.dex */
public class VCard extends IQ {
    private static final String DEFAULT_MIME_TYPE = "image/jpeg";
    public static final String ELEMENT = "vCard";
    private static final Logger LOGGER = Logger.getLogger(VCard.class.getName());
    public static final String NAMESPACE = "vcard-temp";
    private String firstName;
    private Map<String, String> homeAddr;
    private Map<String, String> homePhones;
    private String lastName;
    private String middleName;
    private String organization;
    private String organizationUnit;
    private Map<String, String> otherSimpleFields;
    private Map<String, String> otherUnescapableFields;
    private String photoBinval;
    private String photoMimeType;
    private String remoteAccountId;
    private Map<String, String> workAddr;
    private Map<String, String> workPhones;

    public VCard() {
        super("vCard", "vcard-temp");
        this.homePhones = new HashMap();
        this.workPhones = new HashMap();
        this.homeAddr = new HashMap();
        this.workAddr = new HashMap();
        this.otherSimpleFields = new HashMap();
        this.otherUnescapableFields = new HashMap();
    }

    private void copyFieldsFrom(VCard vCard) throws IllegalAccessException, IllegalArgumentException {
        for (Field field : VCard.class.getDeclaredFields()) {
            if (field.getDeclaringClass() == VCard.class && !Modifier.isFinal(field.getModifiers())) {
                try {
                    field.setAccessible(true);
                    field.set(this, field.get(vCard));
                } catch (IllegalAccessException e) {
                    throw new RuntimeException("This cannot happen:" + field, e);
                }
            }
        }
    }

    public static byte[] getBytes(URL url) throws IOException {
        File file = new File(url.getPath());
        if (file.exists()) {
            return getFileBytes(file);
        }
        return null;
    }

    private static byte[] getFileBytes(File file) throws Throwable {
        BufferedInputStream bufferedInputStream;
        BufferedInputStream bufferedInputStream2 = null;
        try {
            bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
        } catch (Throwable th) {
            th = th;
        }
        try {
            int length = (int) file.length();
            byte[] bArr = new byte[length];
            if (bufferedInputStream.read(bArr) != length) {
                throw new IOException("Entire file not read");
            }
            bufferedInputStream.close();
            return bArr;
        } catch (Throwable th2) {
            th = th2;
            bufferedInputStream2 = bufferedInputStream;
            if (bufferedInputStream2 != null) {
                bufferedInputStream2.close();
            }
            throw th;
        }
    }

    private boolean hasContent() {
        return hasNameField() || hasOrganizationFields() || this.otherSimpleFields.size() > 0 || this.otherUnescapableFields.size() > 0 || this.homeAddr.size() > 0 || this.homePhones.size() > 0 || this.workAddr.size() > 0 || this.workPhones.size() > 0 || this.photoBinval != null;
    }

    private boolean hasNameField() {
        return (this.firstName == null && this.lastName == null && this.middleName == null) ? false : true;
    }

    private boolean hasOrganizationFields() {
        return (this.organization == null && this.organizationUnit == null) ? false : true;
    }

    private void updateFN() {
        StringBuilder sb = new StringBuilder();
        String str = this.firstName;
        if (str != null) {
            sb.append(StringUtils.escapeForXML(str));
            sb.append(' ');
        }
        String str2 = this.middleName;
        if (str2 != null) {
            sb.append(StringUtils.escapeForXML(str2));
            sb.append(' ');
        }
        String str3 = this.lastName;
        if (str3 != null) {
            sb.append(StringUtils.escapeForXML(str3));
        }
        setField(DownloadsDB.DownloadColumns.FILENAME, sb.toString());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        VCard vCard = (VCard) obj;
        String str = this.firstName;
        if (str == null ? vCard.firstName != null : !str.equals(vCard.firstName)) {
            return false;
        }
        if (!this.homeAddr.equals(vCard.homeAddr) || !this.homePhones.equals(vCard.homePhones)) {
            return false;
        }
        String str2 = this.lastName;
        if (str2 == null ? vCard.lastName != null : !str2.equals(vCard.lastName)) {
            return false;
        }
        String str3 = this.middleName;
        if (str3 == null ? vCard.middleName != null : !str3.equals(vCard.middleName)) {
            return false;
        }
        String str4 = this.organization;
        if (str4 == null ? vCard.organization != null : !str4.equals(vCard.organization)) {
            return false;
        }
        String str5 = this.organizationUnit;
        if (str5 == null ? vCard.organizationUnit != null : !str5.equals(vCard.organizationUnit)) {
            return false;
        }
        if (!this.otherSimpleFields.equals(vCard.otherSimpleFields) || !this.workAddr.equals(vCard.workAddr)) {
            return false;
        }
        String str6 = this.photoBinval;
        if (str6 == null ? vCard.photoBinval == null : str6.equals(vCard.photoBinval)) {
            return this.workPhones.equals(vCard.workPhones);
        }
        return false;
    }

    public String getAddressFieldHome(String str) {
        return this.homeAddr.get(str);
    }

    public String getAddressFieldWork(String str) {
        return this.workAddr.get(str);
    }

    public byte[] getAvatar() {
        String str = this.photoBinval;
        if (str == null) {
            return null;
        }
        return Base64.decode(str);
    }

    public String getAvatarHash() throws NoSuchAlgorithmException {
        byte[] avatar = getAvatar();
        if (avatar == null) {
            return null;
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
            messageDigest.update(avatar);
            return StringUtils.encodeHex(messageDigest.digest());
        } catch (NoSuchAlgorithmException e) {
            LOGGER.log(Level.SEVERE, "Failed to get message digest", (Throwable) e);
            return null;
        }
    }

    public String getAvatarMimeType() {
        return this.photoMimeType;
    }

    public String getAvatarTemp() {
        return this.photoBinval;
    }

    public String getField(String str) {
        return this.otherSimpleFields.get(str);
    }

    public String getFirstName() {
        return this.firstName;
    }

    @Override // org.jivesoftware.smack.packet.IQ
    public IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(IQ.IQChildElementXmlStringBuilder iQChildElementXmlStringBuilder) {
        if (!hasContent()) {
            iQChildElementXmlStringBuilder.setEmptyElement();
            return iQChildElementXmlStringBuilder;
        }
        iQChildElementXmlStringBuilder.rightAngleBracket();
        if (hasNameField()) {
            iQChildElementXmlStringBuilder.openElement("N");
            iQChildElementXmlStringBuilder.optElement("FAMILY", this.lastName);
            iQChildElementXmlStringBuilder.optElement("GIVEN", this.firstName);
            iQChildElementXmlStringBuilder.optElement("MIDDLE", this.middleName);
            iQChildElementXmlStringBuilder.closeElement("N");
        }
        if (hasOrganizationFields()) {
            iQChildElementXmlStringBuilder.openElement("ORG");
            iQChildElementXmlStringBuilder.optElement("ORGNAME", this.organization);
            iQChildElementXmlStringBuilder.optElement("ORGUNIT", this.organizationUnit);
            iQChildElementXmlStringBuilder.closeElement("ORG");
        }
        for (Map.Entry<String, String> entry : this.otherSimpleFields.entrySet()) {
            iQChildElementXmlStringBuilder.optElement(entry.getKey(), entry.getValue());
        }
        for (Map.Entry<String, String> entry2 : this.otherUnescapableFields.entrySet()) {
            String value = entry2.getValue();
            if (value != null) {
                iQChildElementXmlStringBuilder.openElement(entry2.getKey());
                iQChildElementXmlStringBuilder.append((CharSequence) value);
                iQChildElementXmlStringBuilder.closeElement(entry2.getKey());
            }
        }
        if (this.photoBinval != null) {
            iQChildElementXmlStringBuilder.openElement("PHOTO");
            iQChildElementXmlStringBuilder.escapedElement("BINVAL", this.photoBinval);
            iQChildElementXmlStringBuilder.element("TYPE", this.photoMimeType);
            iQChildElementXmlStringBuilder.closeElement("PHOTO");
        }
        for (Map.Entry<String, String> entry3 : this.workPhones.entrySet()) {
            String value2 = entry3.getValue();
            if (value2 != null) {
                iQChildElementXmlStringBuilder.openElement("TEL");
                iQChildElementXmlStringBuilder.emptyElement("WORK");
                iQChildElementXmlStringBuilder.emptyElement(entry3.getKey());
                iQChildElementXmlStringBuilder.element("NUMBER", value2);
                iQChildElementXmlStringBuilder.closeElement("TEL");
            }
        }
        for (Map.Entry<String, String> entry4 : this.homePhones.entrySet()) {
            String value3 = entry4.getValue();
            if (value3 != null) {
                iQChildElementXmlStringBuilder.openElement("TEL");
                iQChildElementXmlStringBuilder.emptyElement("HOME");
                iQChildElementXmlStringBuilder.emptyElement(entry4.getKey());
                iQChildElementXmlStringBuilder.element("NUMBER", value3);
                iQChildElementXmlStringBuilder.closeElement("TEL");
            }
        }
        if (!this.workAddr.isEmpty()) {
            iQChildElementXmlStringBuilder.openElement("ADR");
            iQChildElementXmlStringBuilder.emptyElement("WORK");
            for (Map.Entry<String, String> entry5 : this.workAddr.entrySet()) {
                String value4 = entry5.getValue();
                if (value4 != null) {
                    iQChildElementXmlStringBuilder.element(entry5.getKey(), value4);
                }
            }
            iQChildElementXmlStringBuilder.closeElement("ADR");
        }
        if (!this.homeAddr.isEmpty()) {
            iQChildElementXmlStringBuilder.openElement("ADR");
            iQChildElementXmlStringBuilder.emptyElement("HOME");
            for (Map.Entry<String, String> entry6 : this.homeAddr.entrySet()) {
                String value5 = entry6.getValue();
                if (value5 != null) {
                    iQChildElementXmlStringBuilder.element(entry6.getKey(), value5);
                }
            }
            iQChildElementXmlStringBuilder.closeElement("ADR");
        }
        return iQChildElementXmlStringBuilder;
    }

    public String getJabberId() {
        return this.otherSimpleFields.get("JABBERID");
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getMiddleName() {
        return this.middleName;
    }

    public String getNickName() {
        String str = this.otherSimpleFields.get("NICKNAME");
        return WearUtils.e1(str) ? this.otherSimpleFields.get(DownloadsDB.DownloadColumns.FILENAME) : str;
    }

    public String getOrganization() {
        return this.organization;
    }

    public String getOrganizationUnit() {
        return this.organizationUnit;
    }

    public String getPhoneHome(String str) {
        return this.homePhones.get(str);
    }

    public String getPhoneWork(String str) {
        return this.workPhones.get(str);
    }

    public String getRemoteAccountId() {
        return this.remoteAccountId;
    }

    public int hashCode() {
        int iHashCode = ((((((this.homePhones.hashCode() * 29) + this.workPhones.hashCode()) * 29) + this.homeAddr.hashCode()) * 29) + this.workAddr.hashCode()) * 29;
        String str = this.firstName;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 29;
        String str2 = this.lastName;
        int iHashCode3 = (iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 29;
        String str3 = this.middleName;
        int iHashCode4 = (iHashCode3 + (str3 != null ? str3.hashCode() : 0)) * 29;
        String str4 = this.organization;
        int iHashCode5 = (iHashCode4 + (str4 != null ? str4.hashCode() : 0)) * 29;
        String str5 = this.organizationUnit;
        int iHashCode6 = (((iHashCode5 + (str5 != null ? str5.hashCode() : 0)) * 29) + this.otherSimpleFields.hashCode()) * 29;
        String str6 = this.photoBinval;
        return iHashCode6 + (str6 != null ? str6.hashCode() : 0);
    }

    public boolean isErrorAvatar() {
        String str = this.photoBinval;
        if (str == null) {
            return false;
        }
        return str.contains("UploadFiles/wear/avatar");
    }

    @Deprecated
    public void load(XMPPConnection xMPPConnection) throws SmackException.NotConnectedException, SmackException.NoResponseException, IllegalAccessException, IllegalArgumentException, XMPPException.XMPPErrorException {
        load(xMPPConnection, null);
    }

    public void removeAvatar() {
        this.photoBinval = null;
        this.photoMimeType = null;
    }

    @Deprecated
    public void save(XMPPConnection xMPPConnection) throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        VCardManager.getInstanceFor(xMPPConnection).saveVCard(this);
    }

    public void setAddressFieldHome(String str, String str2) {
        this.homeAddr.put(str, str2);
    }

    public void setAddressFieldWork(String str, String str2) {
        this.workAddr.put(str, str2);
    }

    public void setAvatar(URL url) {
        byte[] bytes = new byte[0];
        try {
            bytes = getBytes(url);
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Error getting bytes from URL: " + url, (Throwable) e);
        }
        setAvatar(bytes);
    }

    @Deprecated
    public void setEncodedImage(String str) {
        setAvatar(str, "image/jpeg");
    }

    public void setField(String str, String str2) {
        setField(str, str2, false);
    }

    public void setFirstName(String str) {
        this.firstName = str;
        updateFN();
    }

    public void setJabberId(String str) {
        this.otherSimpleFields.put("JABBERID", str);
    }

    public void setLastName(String str) {
        this.lastName = str;
        updateFN();
    }

    public void setMiddleName(String str) {
        this.middleName = str;
        updateFN();
    }

    public void setNickName(String str) {
        this.otherSimpleFields.put("NICKNAME", str);
    }

    public void setOrganization(String str) {
        this.organization = str;
    }

    public void setOrganizationUnit(String str) {
        this.organizationUnit = str;
    }

    public void setPhoneHome(String str, String str2) {
        this.homePhones.put(str, str2);
    }

    public void setPhoneWork(String str, String str2) {
        this.workPhones.put(str, str2);
    }

    public void setRemoteAccountId(String str) {
        this.remoteAccountId = str;
    }

    @Deprecated
    public void load(XMPPConnection xMPPConnection, String str) throws SmackException.NotConnectedException, SmackException.NoResponseException, IllegalAccessException, IllegalArgumentException, XMPPException.XMPPErrorException {
        copyFieldsFrom(VCardManager.getInstanceFor(xMPPConnection).loadVCard(str));
    }

    public void setField(String str, String str2, boolean z) {
        if (z) {
            this.otherUnescapableFields.put(str, str2);
        } else {
            this.otherSimpleFields.put(str, str2);
        }
    }

    public void setAvatar(byte[] bArr) {
        setAvatar(bArr, "image/jpeg");
    }

    public void setAvatar(byte[] bArr, String str) {
        if (bArr == null) {
            removeAvatar();
        } else {
            setAvatar(Base64.encodeToString(bArr), str);
        }
    }

    public void setAvatar(String str, String str2) {
        this.photoBinval = str;
        this.photoMimeType = str2;
    }
}
