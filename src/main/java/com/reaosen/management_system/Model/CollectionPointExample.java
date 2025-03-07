package com.reaosen.management_system.Model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CollectionPointExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CollectionPointExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andCollectionPointIdIsNull() {
            addCriterion("collection_point_id is null");
            return (Criteria) this;
        }

        public Criteria andCollectionPointIdIsNotNull() {
            addCriterion("collection_point_id is not null");
            return (Criteria) this;
        }

        public Criteria andCollectionPointIdEqualTo(Integer value) {
            addCriterion("collection_point_id =", value, "collectionPointId");
            return (Criteria) this;
        }

        public Criteria andCollectionPointIdNotEqualTo(Integer value) {
            addCriterion("collection_point_id <>", value, "collectionPointId");
            return (Criteria) this;
        }

        public Criteria andCollectionPointIdGreaterThan(Integer value) {
            addCriterion("collection_point_id >", value, "collectionPointId");
            return (Criteria) this;
        }

        public Criteria andCollectionPointIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("collection_point_id >=", value, "collectionPointId");
            return (Criteria) this;
        }

        public Criteria andCollectionPointIdLessThan(Integer value) {
            addCriterion("collection_point_id <", value, "collectionPointId");
            return (Criteria) this;
        }

        public Criteria andCollectionPointIdLessThanOrEqualTo(Integer value) {
            addCriterion("collection_point_id <=", value, "collectionPointId");
            return (Criteria) this;
        }

        public Criteria andCollectionPointIdIn(List<Integer> values) {
            addCriterion("collection_point_id in", values, "collectionPointId");
            return (Criteria) this;
        }

        public Criteria andCollectionPointIdNotIn(List<Integer> values) {
            addCriterion("collection_point_id not in", values, "collectionPointId");
            return (Criteria) this;
        }

        public Criteria andCollectionPointIdBetween(Integer value1, Integer value2) {
            addCriterion("collection_point_id between", value1, value2, "collectionPointId");
            return (Criteria) this;
        }

        public Criteria andCollectionPointIdNotBetween(Integer value1, Integer value2) {
            addCriterion("collection_point_id not between", value1, value2, "collectionPointId");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("address not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andContactIsNull() {
            addCriterion("contact is null");
            return (Criteria) this;
        }

        public Criteria andContactIsNotNull() {
            addCriterion("contact is not null");
            return (Criteria) this;
        }

        public Criteria andContactEqualTo(String value) {
            addCriterion("contact =", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactNotEqualTo(String value) {
            addCriterion("contact <>", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactGreaterThan(String value) {
            addCriterion("contact >", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactGreaterThanOrEqualTo(String value) {
            addCriterion("contact >=", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactLessThan(String value) {
            addCriterion("contact <", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactLessThanOrEqualTo(String value) {
            addCriterion("contact <=", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactLike(String value) {
            addCriterion("contact like", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactNotLike(String value) {
            addCriterion("contact not like", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactIn(List<String> values) {
            addCriterion("contact in", values, "contact");
            return (Criteria) this;
        }

        public Criteria andContactNotIn(List<String> values) {
            addCriterion("contact not in", values, "contact");
            return (Criteria) this;
        }

        public Criteria andContactBetween(String value1, String value2) {
            addCriterion("contact between", value1, value2, "contact");
            return (Criteria) this;
        }

        public Criteria andContactNotBetween(String value1, String value2) {
            addCriterion("contact not between", value1, value2, "contact");
            return (Criteria) this;
        }

        public Criteria andResponsiblePersonIsNull() {
            addCriterion("responsible_person is null");
            return (Criteria) this;
        }

        public Criteria andResponsiblePersonIsNotNull() {
            addCriterion("responsible_person is not null");
            return (Criteria) this;
        }

        public Criteria andResponsiblePersonEqualTo(String value) {
            addCriterion("responsible_person =", value, "responsiblePerson");
            return (Criteria) this;
        }

        public Criteria andResponsiblePersonNotEqualTo(String value) {
            addCriterion("responsible_person <>", value, "responsiblePerson");
            return (Criteria) this;
        }

        public Criteria andResponsiblePersonGreaterThan(String value) {
            addCriterion("responsible_person >", value, "responsiblePerson");
            return (Criteria) this;
        }

        public Criteria andResponsiblePersonGreaterThanOrEqualTo(String value) {
            addCriterion("responsible_person >=", value, "responsiblePerson");
            return (Criteria) this;
        }

        public Criteria andResponsiblePersonLessThan(String value) {
            addCriterion("responsible_person <", value, "responsiblePerson");
            return (Criteria) this;
        }

        public Criteria andResponsiblePersonLessThanOrEqualTo(String value) {
            addCriterion("responsible_person <=", value, "responsiblePerson");
            return (Criteria) this;
        }

        public Criteria andResponsiblePersonLike(String value) {
            addCriterion("responsible_person like", value, "responsiblePerson");
            return (Criteria) this;
        }

        public Criteria andResponsiblePersonNotLike(String value) {
            addCriterion("responsible_person not like", value, "responsiblePerson");
            return (Criteria) this;
        }

        public Criteria andResponsiblePersonIn(List<String> values) {
            addCriterion("responsible_person in", values, "responsiblePerson");
            return (Criteria) this;
        }

        public Criteria andResponsiblePersonNotIn(List<String> values) {
            addCriterion("responsible_person not in", values, "responsiblePerson");
            return (Criteria) this;
        }

        public Criteria andResponsiblePersonBetween(String value1, String value2) {
            addCriterion("responsible_person between", value1, value2, "responsiblePerson");
            return (Criteria) this;
        }

        public Criteria andResponsiblePersonNotBetween(String value1, String value2) {
            addCriterion("responsible_person not between", value1, value2, "responsiblePerson");
            return (Criteria) this;
        }

        public Criteria andCollectionAccountIdIsNull() {
            addCriterion("collection_Account_id is null");
            return (Criteria) this;
        }

        public Criteria andCollectionAccountIdIsNotNull() {
            addCriterion("collection_Account_id is not null");
            return (Criteria) this;
        }

        public Criteria andCollectionAccountIdEqualTo(Integer value) {
            addCriterion("collection_Account_id =", value, "collectionAccountId");
            return (Criteria) this;
        }

        public Criteria andCollectionAccountIdNotEqualTo(Integer value) {
            addCriterion("collection_Account_id <>", value, "collectionAccountId");
            return (Criteria) this;
        }

        public Criteria andCollectionAccountIdGreaterThan(Integer value) {
            addCriterion("collection_Account_id >", value, "collectionAccountId");
            return (Criteria) this;
        }

        public Criteria andCollectionAccountIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("collection_Account_id >=", value, "collectionAccountId");
            return (Criteria) this;
        }

        public Criteria andCollectionAccountIdLessThan(Integer value) {
            addCriterion("collection_Account_id <", value, "collectionAccountId");
            return (Criteria) this;
        }

        public Criteria andCollectionAccountIdLessThanOrEqualTo(Integer value) {
            addCriterion("collection_Account_id <=", value, "collectionAccountId");
            return (Criteria) this;
        }

        public Criteria andCollectionAccountIdIn(List<Integer> values) {
            addCriterion("collection_Account_id in", values, "collectionAccountId");
            return (Criteria) this;
        }

        public Criteria andCollectionAccountIdNotIn(List<Integer> values) {
            addCriterion("collection_Account_id not in", values, "collectionAccountId");
            return (Criteria) this;
        }

        public Criteria andCollectionAccountIdBetween(Integer value1, Integer value2) {
            addCriterion("collection_Account_id between", value1, value2, "collectionAccountId");
            return (Criteria) this;
        }

        public Criteria andCollectionAccountIdNotBetween(Integer value1, Integer value2) {
            addCriterion("collection_Account_id not between", value1, value2, "collectionAccountId");
            return (Criteria) this;
        }

        public Criteria andGmtCreateIsNull() {
            addCriterion("gmt_create is null");
            return (Criteria) this;
        }

        public Criteria andGmtCreateIsNotNull() {
            addCriterion("gmt_create is not null");
            return (Criteria) this;
        }

        public Criteria andGmtCreateEqualTo(Integer value) {
            addCriterion("gmt_create =", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateNotEqualTo(Integer value) {
            addCriterion("gmt_create <>", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateGreaterThan(Integer value) {
            addCriterion("gmt_create >", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateGreaterThanOrEqualTo(Integer value) {
            addCriterion("gmt_create >=", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateLessThan(Integer value) {
            addCriterion("gmt_create <", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateLessThanOrEqualTo(Integer value) {
            addCriterion("gmt_create <=", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateIn(List<Integer> values) {
            addCriterion("gmt_create in", values, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateNotIn(List<Integer> values) {
            addCriterion("gmt_create not in", values, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateBetween(Integer value1, Integer value2) {
            addCriterion("gmt_create between", value1, value2, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateNotBetween(Integer value1, Integer value2) {
            addCriterion("gmt_create not between", value1, value2, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedIsNull() {
            addCriterion("gmt_modified is null");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedIsNotNull() {
            addCriterion("gmt_modified is not null");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedEqualTo(Integer value) {
            addCriterion("gmt_modified =", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedNotEqualTo(Integer value) {
            addCriterion("gmt_modified <>", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedGreaterThan(Integer value) {
            addCriterion("gmt_modified >", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedGreaterThanOrEqualTo(Integer value) {
            addCriterion("gmt_modified >=", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedLessThan(Integer value) {
            addCriterion("gmt_modified <", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedLessThanOrEqualTo(Integer value) {
            addCriterion("gmt_modified <=", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedIn(List<Integer> values) {
            addCriterion("gmt_modified in", values, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedNotIn(List<Integer> values) {
            addCriterion("gmt_modified not in", values, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedBetween(Integer value1, Integer value2) {
            addCriterion("gmt_modified between", value1, value2, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedNotBetween(Integer value1, Integer value2) {
            addCriterion("gmt_modified not between", value1, value2, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andStorageCapacityIsNull() {
            addCriterion("storage_capacity is null");
            return (Criteria) this;
        }

        public Criteria andStorageCapacityIsNotNull() {
            addCriterion("storage_capacity is not null");
            return (Criteria) this;
        }

        public Criteria andStorageCapacityEqualTo(BigDecimal value) {
            addCriterion("storage_capacity =", value, "storageCapacity");
            return (Criteria) this;
        }

        public Criteria andStorageCapacityNotEqualTo(BigDecimal value) {
            addCriterion("storage_capacity <>", value, "storageCapacity");
            return (Criteria) this;
        }

        public Criteria andStorageCapacityGreaterThan(BigDecimal value) {
            addCriterion("storage_capacity >", value, "storageCapacity");
            return (Criteria) this;
        }

        public Criteria andStorageCapacityGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("storage_capacity >=", value, "storageCapacity");
            return (Criteria) this;
        }

        public Criteria andStorageCapacityLessThan(BigDecimal value) {
            addCriterion("storage_capacity <", value, "storageCapacity");
            return (Criteria) this;
        }

        public Criteria andStorageCapacityLessThanOrEqualTo(BigDecimal value) {
            addCriterion("storage_capacity <=", value, "storageCapacity");
            return (Criteria) this;
        }

        public Criteria andStorageCapacityIn(List<BigDecimal> values) {
            addCriterion("storage_capacity in", values, "storageCapacity");
            return (Criteria) this;
        }

        public Criteria andStorageCapacityNotIn(List<BigDecimal> values) {
            addCriterion("storage_capacity not in", values, "storageCapacity");
            return (Criteria) this;
        }

        public Criteria andStorageCapacityBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("storage_capacity between", value1, value2, "storageCapacity");
            return (Criteria) this;
        }

        public Criteria andStorageCapacityNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("storage_capacity not between", value1, value2, "storageCapacity");
            return (Criteria) this;
        }

        public Criteria andUsedCapacityIsNull() {
            addCriterion("used_capacity is null");
            return (Criteria) this;
        }

        public Criteria andUsedCapacityIsNotNull() {
            addCriterion("used_capacity is not null");
            return (Criteria) this;
        }

        public Criteria andUsedCapacityEqualTo(BigDecimal value) {
            addCriterion("used_capacity =", value, "usedCapacity");
            return (Criteria) this;
        }

        public Criteria andUsedCapacityNotEqualTo(BigDecimal value) {
            addCriterion("used_capacity <>", value, "usedCapacity");
            return (Criteria) this;
        }

        public Criteria andUsedCapacityGreaterThan(BigDecimal value) {
            addCriterion("used_capacity >", value, "usedCapacity");
            return (Criteria) this;
        }

        public Criteria andUsedCapacityGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("used_capacity >=", value, "usedCapacity");
            return (Criteria) this;
        }

        public Criteria andUsedCapacityLessThan(BigDecimal value) {
            addCriterion("used_capacity <", value, "usedCapacity");
            return (Criteria) this;
        }

        public Criteria andUsedCapacityLessThanOrEqualTo(BigDecimal value) {
            addCriterion("used_capacity <=", value, "usedCapacity");
            return (Criteria) this;
        }

        public Criteria andUsedCapacityIn(List<BigDecimal> values) {
            addCriterion("used_capacity in", values, "usedCapacity");
            return (Criteria) this;
        }

        public Criteria andUsedCapacityNotIn(List<BigDecimal> values) {
            addCriterion("used_capacity not in", values, "usedCapacity");
            return (Criteria) this;
        }

        public Criteria andUsedCapacityBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("used_capacity between", value1, value2, "usedCapacity");
            return (Criteria) this;
        }

        public Criteria andUsedCapacityNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("used_capacity not between", value1, value2, "usedCapacity");
            return (Criteria) this;
        }

        public Criteria andRemainingCapacityIsNull() {
            addCriterion("remaining_capacity is null");
            return (Criteria) this;
        }

        public Criteria andRemainingCapacityIsNotNull() {
            addCriterion("remaining_capacity is not null");
            return (Criteria) this;
        }

        public Criteria andRemainingCapacityEqualTo(BigDecimal value) {
            addCriterion("remaining_capacity =", value, "remainingCapacity");
            return (Criteria) this;
        }

        public Criteria andRemainingCapacityNotEqualTo(BigDecimal value) {
            addCriterion("remaining_capacity <>", value, "remainingCapacity");
            return (Criteria) this;
        }

        public Criteria andRemainingCapacityGreaterThan(BigDecimal value) {
            addCriterion("remaining_capacity >", value, "remainingCapacity");
            return (Criteria) this;
        }

        public Criteria andRemainingCapacityGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("remaining_capacity >=", value, "remainingCapacity");
            return (Criteria) this;
        }

        public Criteria andRemainingCapacityLessThan(BigDecimal value) {
            addCriterion("remaining_capacity <", value, "remainingCapacity");
            return (Criteria) this;
        }

        public Criteria andRemainingCapacityLessThanOrEqualTo(BigDecimal value) {
            addCriterion("remaining_capacity <=", value, "remainingCapacity");
            return (Criteria) this;
        }

        public Criteria andRemainingCapacityIn(List<BigDecimal> values) {
            addCriterion("remaining_capacity in", values, "remainingCapacity");
            return (Criteria) this;
        }

        public Criteria andRemainingCapacityNotIn(List<BigDecimal> values) {
            addCriterion("remaining_capacity not in", values, "remainingCapacity");
            return (Criteria) this;
        }

        public Criteria andRemainingCapacityBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("remaining_capacity between", value1, value2, "remainingCapacity");
            return (Criteria) this;
        }

        public Criteria andRemainingCapacityNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("remaining_capacity not between", value1, value2, "remainingCapacity");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}