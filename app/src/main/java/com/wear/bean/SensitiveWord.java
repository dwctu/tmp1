package com.wear.bean;

import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.wear.util.WearUtils;
import java.io.Serializable;
import java.util.List;

@DatabaseTable(tableName = "tb_sensitive_word")
/* loaded from: classes3.dex */
public class SensitiveWord extends BaseEntity {

    @SerializedName("categoryId")
    @DatabaseField
    private String categoryId;

    @DatabaseField
    private String defaultText;

    @DatabaseField
    private Boolean isActive = Boolean.FALSE;

    @DatabaseField
    private String key;

    @DatabaseField
    private String ruleJsonData;

    @SerializedName("rules")
    private List<RulesDTO> rules;

    public static class RulesDTO implements Serializable {

        @SerializedName("list")
        private List<ListDTO> list;

        @SerializedName("partId")
        private String partId;

        @SerializedName("type")
        private String type;

        @SerializedName("typeInteger")
        private Integer typeInteger;

        public static class ListDTO implements Serializable {

            @SerializedName("defaultText")
            private String defaultText;

            @SerializedName("isActive")
            private Boolean isActive;

            @SerializedName("key")
            private String key;

            @DatabaseField
            private String realSensitive;

            @SerializedName("reg")
            private String reg;

            @SerializedName("sensitive")
            private List<String> sensitive;

            public Boolean getActive() {
                return this.isActive;
            }

            public String getDefaultText() {
                return this.defaultText;
            }

            public String getKey() {
                return this.key;
            }

            public String getReg() {
                return this.reg;
            }

            public List<String> getSensitive() {
                String str;
                if (this.sensitive == null && (str = this.realSensitive) != null) {
                    this.sensitive = (List) WearUtils.A.fromJson(str, new TypeToken<List<String>>() { // from class: com.wear.bean.SensitiveWord.RulesDTO.ListDTO.1
                    }.getType());
                }
                return this.sensitive;
            }

            public void setActive(Boolean bool) {
                this.isActive = bool;
            }

            public void setDefaultText(String str) {
                this.defaultText = str;
            }

            public void setKey(String str) {
                this.key = str;
            }

            public void setReg(String str) {
                this.reg = str;
            }

            public void setSensitive(List<String> list) {
                this.sensitive = list;
                if (list != null) {
                    this.realSensitive = WearUtils.A.toJson(list);
                }
            }
        }

        public List<ListDTO> getList() {
            return this.list;
        }

        public String getPartId() {
            return this.partId;
        }

        public String getType() {
            return this.type;
        }

        public Integer getTypeInteger() {
            return this.typeInteger;
        }

        public void setList(List<ListDTO> list) {
            this.list = list;
        }

        public void setPartId(String str) {
            this.partId = str;
        }

        public void setType(String str) {
            this.type = str;
        }

        public void setTypeInteger(Integer num) {
            this.typeInteger = num;
        }
    }

    public Boolean getActive() {
        return this.isActive;
    }

    public String getCategoryId() {
        return this.categoryId;
    }

    public String getDefaultText() {
        return this.defaultText;
    }

    public String getKey() {
        return this.key;
    }

    public String getRuleJsonData() {
        return this.ruleJsonData;
    }

    public List<RulesDTO> getRules() {
        if (this.rules == null && this.ruleJsonData != null) {
            String str = "get.rule的json数据=" + this.ruleJsonData;
            this.rules = (List) WearUtils.A.fromJson(this.ruleJsonData, new TypeToken<List<RulesDTO>>() { // from class: com.wear.bean.SensitiveWord.1
            }.getType());
        }
        return this.rules;
    }

    public void initData() {
        List<RulesDTO> list = this.rules;
        if (list != null) {
            this.ruleJsonData = WearUtils.A.toJson(list);
            String str = "initData的json数据=" + this.ruleJsonData;
        }
    }

    public void setActive(Boolean bool) {
        this.isActive = bool;
    }

    public void setCategoryId(String str) {
        this.categoryId = str;
    }

    public void setDefaultText(String str) {
        this.defaultText = str;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setRuleJsonData(String str) {
        this.ruleJsonData = str;
    }

    public void setRules(List<RulesDTO> list) {
        this.rules = list;
        setRuleJsonData(WearUtils.A.toJson(list));
        String str = "set.rule的json数据=" + this.ruleJsonData;
    }
}
