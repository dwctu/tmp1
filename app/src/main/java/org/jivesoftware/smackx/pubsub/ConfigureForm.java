package org.jivesoftware.smackx.pubsub;

import java.util.ArrayList;
import java.util.List;
import org.jivesoftware.smackx.xdata.Form;
import org.jivesoftware.smackx.xdata.FormField;
import org.jivesoftware.smackx.xdata.packet.DataForm;

/* loaded from: classes5.dex */
public class ConfigureForm extends Form {
    public ConfigureForm(DataForm dataForm) {
        super(dataForm);
    }

    private void addField(ConfigureNodeFields configureNodeFields, FormField.Type type) {
        String fieldName = configureNodeFields.getFieldName();
        if (getField(fieldName) == null) {
            FormField formField = new FormField(fieldName);
            formField.setType(type);
            addField(formField);
        }
    }

    private String getFieldValue(ConfigureNodeFields configureNodeFields) {
        FormField field = getField(configureNodeFields.getFieldName());
        if (field.getValues().isEmpty()) {
            return null;
        }
        return field.getValues().get(0);
    }

    private List<String> getFieldValues(ConfigureNodeFields configureNodeFields) {
        return getField(configureNodeFields.getFieldName()).getValues();
    }

    private List<String> getListSingle(String str) {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(str);
        return arrayList;
    }

    private static boolean parseBoolean(String str) {
        return "1".equals(str) || "true".equals(str);
    }

    public AccessModel getAccessModel() {
        String fieldValue = getFieldValue(ConfigureNodeFields.access_model);
        if (fieldValue == null) {
            return null;
        }
        return AccessModel.valueOf(fieldValue);
    }

    public String getBodyXSLT() {
        return getFieldValue(ConfigureNodeFields.body_xslt);
    }

    public List<String> getChildren() {
        return getFieldValues(ConfigureNodeFields.children);
    }

    public ChildrenAssociationPolicy getChildrenAssociationPolicy() {
        String fieldValue = getFieldValue(ConfigureNodeFields.children_association_policy);
        if (fieldValue == null) {
            return null;
        }
        return ChildrenAssociationPolicy.valueOf(fieldValue);
    }

    public List<String> getChildrenAssociationWhitelist() {
        return getFieldValues(ConfigureNodeFields.children_association_whitelist);
    }

    public int getChildrenMax() {
        return Integer.parseInt(getFieldValue(ConfigureNodeFields.children_max));
    }

    public String getCollection() {
        return getFieldValue(ConfigureNodeFields.collection);
    }

    public String getDataType() {
        return getFieldValue(ConfigureNodeFields.type);
    }

    public String getDataformXSLT() {
        return getFieldValue(ConfigureNodeFields.dataform_xslt);
    }

    public ItemReply getItemReply() {
        String fieldValue = getFieldValue(ConfigureNodeFields.itemreply);
        if (fieldValue == null) {
            return null;
        }
        return ItemReply.valueOf(fieldValue);
    }

    public int getMaxItems() {
        return Integer.parseInt(getFieldValue(ConfigureNodeFields.max_items));
    }

    public int getMaxPayloadSize() {
        return Integer.parseInt(getFieldValue(ConfigureNodeFields.max_payload_size));
    }

    public NodeType getNodeType() {
        String fieldValue = getFieldValue(ConfigureNodeFields.node_type);
        if (fieldValue == null) {
            return null;
        }
        return NodeType.valueOf(fieldValue);
    }

    public PublishModel getPublishModel() {
        String fieldValue = getFieldValue(ConfigureNodeFields.publish_model);
        if (fieldValue == null) {
            return null;
        }
        return PublishModel.valueOf(fieldValue);
    }

    public List<String> getReplyRoom() {
        return getFieldValues(ConfigureNodeFields.replyroom);
    }

    public List<String> getReplyTo() {
        return getFieldValues(ConfigureNodeFields.replyto);
    }

    public List<String> getRosterGroupsAllowed() {
        return getFieldValues(ConfigureNodeFields.roster_groups_allowed);
    }

    @Override // org.jivesoftware.smackx.xdata.Form
    public String getTitle() {
        return getFieldValue(ConfigureNodeFields.title);
    }

    public boolean isDeliverPayloads() {
        return parseBoolean(getFieldValue(ConfigureNodeFields.deliver_payloads));
    }

    public boolean isNotifyConfig() {
        return parseBoolean(getFieldValue(ConfigureNodeFields.notify_config));
    }

    public boolean isNotifyDelete() {
        return parseBoolean(getFieldValue(ConfigureNodeFields.notify_delete));
    }

    public boolean isNotifyRetract() {
        return parseBoolean(getFieldValue(ConfigureNodeFields.notify_retract));
    }

    public boolean isPersistItems() {
        return parseBoolean(getFieldValue(ConfigureNodeFields.persist_items));
    }

    public boolean isPresenceBasedDelivery() {
        return parseBoolean(getFieldValue(ConfigureNodeFields.presence_based_delivery));
    }

    @Deprecated
    public boolean isSubscibe() {
        return isSubscribe();
    }

    public boolean isSubscribe() {
        return parseBoolean(getFieldValue(ConfigureNodeFields.subscribe));
    }

    public void setAccessModel(AccessModel accessModel) {
        ConfigureNodeFields configureNodeFields = ConfigureNodeFields.access_model;
        addField(configureNodeFields, FormField.Type.list_single);
        setAnswer(configureNodeFields.getFieldName(), getListSingle(accessModel.toString()));
    }

    public void setBodyXSLT(String str) {
        ConfigureNodeFields configureNodeFields = ConfigureNodeFields.body_xslt;
        addField(configureNodeFields, FormField.Type.text_single);
        setAnswer(configureNodeFields.getFieldName(), str);
    }

    public void setChildren(List<String> list) {
        ConfigureNodeFields configureNodeFields = ConfigureNodeFields.children;
        addField(configureNodeFields, FormField.Type.text_multi);
        setAnswer(configureNodeFields.getFieldName(), list);
    }

    public void setChildrenAssociationPolicy(ChildrenAssociationPolicy childrenAssociationPolicy) {
        ConfigureNodeFields configureNodeFields = ConfigureNodeFields.children_association_policy;
        addField(configureNodeFields, FormField.Type.list_single);
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(childrenAssociationPolicy.toString());
        setAnswer(configureNodeFields.getFieldName(), arrayList);
    }

    public void setChildrenAssociationWhitelist(List<String> list) {
        ConfigureNodeFields configureNodeFields = ConfigureNodeFields.children_association_whitelist;
        addField(configureNodeFields, FormField.Type.jid_multi);
        setAnswer(configureNodeFields.getFieldName(), list);
    }

    public void setChildrenMax(int i) {
        ConfigureNodeFields configureNodeFields = ConfigureNodeFields.children_max;
        addField(configureNodeFields, FormField.Type.text_single);
        setAnswer(configureNodeFields.getFieldName(), i);
    }

    public void setCollection(String str) {
        ConfigureNodeFields configureNodeFields = ConfigureNodeFields.collection;
        addField(configureNodeFields, FormField.Type.text_single);
        setAnswer(configureNodeFields.getFieldName(), str);
    }

    public void setDataType(String str) {
        ConfigureNodeFields configureNodeFields = ConfigureNodeFields.type;
        addField(configureNodeFields, FormField.Type.text_single);
        setAnswer(configureNodeFields.getFieldName(), str);
    }

    public void setDataformXSLT(String str) {
        ConfigureNodeFields configureNodeFields = ConfigureNodeFields.dataform_xslt;
        addField(configureNodeFields, FormField.Type.text_single);
        setAnswer(configureNodeFields.getFieldName(), str);
    }

    public void setDeliverPayloads(boolean z) {
        ConfigureNodeFields configureNodeFields = ConfigureNodeFields.deliver_payloads;
        addField(configureNodeFields, FormField.Type.bool);
        setAnswer(configureNodeFields.getFieldName(), z);
    }

    public void setItemReply(ItemReply itemReply) {
        ConfigureNodeFields configureNodeFields = ConfigureNodeFields.itemreply;
        addField(configureNodeFields, FormField.Type.list_single);
        setAnswer(configureNodeFields.getFieldName(), getListSingle(itemReply.toString()));
    }

    public void setMaxItems(int i) {
        ConfigureNodeFields configureNodeFields = ConfigureNodeFields.max_items;
        addField(configureNodeFields, FormField.Type.text_single);
        setAnswer(configureNodeFields.getFieldName(), i);
    }

    public void setMaxPayloadSize(int i) {
        ConfigureNodeFields configureNodeFields = ConfigureNodeFields.max_payload_size;
        addField(configureNodeFields, FormField.Type.text_single);
        setAnswer(configureNodeFields.getFieldName(), i);
    }

    public void setNodeType(NodeType nodeType) {
        ConfigureNodeFields configureNodeFields = ConfigureNodeFields.node_type;
        addField(configureNodeFields, FormField.Type.list_single);
        setAnswer(configureNodeFields.getFieldName(), getListSingle(nodeType.toString()));
    }

    public void setNotifyConfig(boolean z) {
        ConfigureNodeFields configureNodeFields = ConfigureNodeFields.notify_config;
        addField(configureNodeFields, FormField.Type.bool);
        setAnswer(configureNodeFields.getFieldName(), z);
    }

    public void setNotifyDelete(boolean z) {
        ConfigureNodeFields configureNodeFields = ConfigureNodeFields.notify_delete;
        addField(configureNodeFields, FormField.Type.bool);
        setAnswer(configureNodeFields.getFieldName(), z);
    }

    public void setNotifyRetract(boolean z) {
        ConfigureNodeFields configureNodeFields = ConfigureNodeFields.notify_retract;
        addField(configureNodeFields, FormField.Type.bool);
        setAnswer(configureNodeFields.getFieldName(), z);
    }

    public void setPersistentItems(boolean z) {
        ConfigureNodeFields configureNodeFields = ConfigureNodeFields.persist_items;
        addField(configureNodeFields, FormField.Type.bool);
        setAnswer(configureNodeFields.getFieldName(), z);
    }

    public void setPresenceBasedDelivery(boolean z) {
        ConfigureNodeFields configureNodeFields = ConfigureNodeFields.presence_based_delivery;
        addField(configureNodeFields, FormField.Type.bool);
        setAnswer(configureNodeFields.getFieldName(), z);
    }

    public void setPublishModel(PublishModel publishModel) {
        ConfigureNodeFields configureNodeFields = ConfigureNodeFields.publish_model;
        addField(configureNodeFields, FormField.Type.list_single);
        setAnswer(configureNodeFields.getFieldName(), getListSingle(publishModel.toString()));
    }

    public void setReplyRoom(List<String> list) {
        ConfigureNodeFields configureNodeFields = ConfigureNodeFields.replyroom;
        addField(configureNodeFields, FormField.Type.list_multi);
        setAnswer(configureNodeFields.getFieldName(), list);
    }

    public void setReplyTo(List<String> list) {
        ConfigureNodeFields configureNodeFields = ConfigureNodeFields.replyto;
        addField(configureNodeFields, FormField.Type.list_multi);
        setAnswer(configureNodeFields.getFieldName(), list);
    }

    public void setRosterGroupsAllowed(List<String> list) {
        ConfigureNodeFields configureNodeFields = ConfigureNodeFields.roster_groups_allowed;
        addField(configureNodeFields, FormField.Type.list_multi);
        setAnswer(configureNodeFields.getFieldName(), list);
    }

    public void setSubscribe(boolean z) {
        ConfigureNodeFields configureNodeFields = ConfigureNodeFields.subscribe;
        addField(configureNodeFields, FormField.Type.bool);
        setAnswer(configureNodeFields.getFieldName(), z);
    }

    @Override // org.jivesoftware.smackx.xdata.Form
    public void setTitle(String str) {
        ConfigureNodeFields configureNodeFields = ConfigureNodeFields.title;
        addField(configureNodeFields, FormField.Type.text_single);
        setAnswer(configureNodeFields.getFieldName(), str);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(getClass().getName() + " Content [");
        for (FormField formField : getFields()) {
            sb.append('(');
            sb.append(formField.getVariable());
            sb.append(':');
            StringBuilder sb2 = new StringBuilder();
            for (String str : formField.getValues()) {
                if (sb2.length() > 0) {
                    sb.append(',');
                }
                sb2.append(str);
            }
            if (sb2.length() == 0) {
                sb2.append("NOT SET");
            }
            sb.append((CharSequence) sb2);
            sb.append(')');
        }
        sb.append(']');
        return sb.toString();
    }

    public ConfigureForm(Form form) {
        super(form.getDataFormToSend());
    }

    public ConfigureForm(DataForm.Type type) {
        super(type);
    }
}
