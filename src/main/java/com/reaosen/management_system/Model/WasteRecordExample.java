package com.reaosen.management_system.Model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class WasteRecordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WasteRecordExample() {
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

        public Criteria andWasterecordidIsNull() {
            addCriterion("WasteRecordID is null");
            return (Criteria) this;
        }

        public Criteria andWasterecordidIsNotNull() {
            addCriterion("WasteRecordID is not null");
            return (Criteria) this;
        }

        public Criteria andWasterecordidEqualTo(Integer value) {
            addCriterion("WasteRecordID =", value, "wasterecordid");
            return (Criteria) this;
        }

        public Criteria andWasterecordidNotEqualTo(Integer value) {
            addCriterion("WasteRecordID <>", value, "wasterecordid");
            return (Criteria) this;
        }

        public Criteria andWasterecordidGreaterThan(Integer value) {
            addCriterion("WasteRecordID >", value, "wasterecordid");
            return (Criteria) this;
        }

        public Criteria andWasterecordidGreaterThanOrEqualTo(Integer value) {
            addCriterion("WasteRecordID >=", value, "wasterecordid");
            return (Criteria) this;
        }

        public Criteria andWasterecordidLessThan(Integer value) {
            addCriterion("WasteRecordID <", value, "wasterecordid");
            return (Criteria) this;
        }

        public Criteria andWasterecordidLessThanOrEqualTo(Integer value) {
            addCriterion("WasteRecordID <=", value, "wasterecordid");
            return (Criteria) this;
        }

        public Criteria andWasterecordidIn(List<Integer> values) {
            addCriterion("WasteRecordID in", values, "wasterecordid");
            return (Criteria) this;
        }

        public Criteria andWasterecordidNotIn(List<Integer> values) {
            addCriterion("WasteRecordID not in", values, "wasterecordid");
            return (Criteria) this;
        }

        public Criteria andWasterecordidBetween(Integer value1, Integer value2) {
            addCriterion("WasteRecordID between", value1, value2, "wasterecordid");
            return (Criteria) this;
        }

        public Criteria andWasterecordidNotBetween(Integer value1, Integer value2) {
            addCriterion("WasteRecordID not between", value1, value2, "wasterecordid");
            return (Criteria) this;
        }

        public Criteria andWastetypeidIsNull() {
            addCriterion("WasteTypeID is null");
            return (Criteria) this;
        }

        public Criteria andWastetypeidIsNotNull() {
            addCriterion("WasteTypeID is not null");
            return (Criteria) this;
        }

        public Criteria andWastetypeidEqualTo(Integer value) {
            addCriterion("WasteTypeID =", value, "wastetypeid");
            return (Criteria) this;
        }

        public Criteria andWastetypeidNotEqualTo(Integer value) {
            addCriterion("WasteTypeID <>", value, "wastetypeid");
            return (Criteria) this;
        }

        public Criteria andWastetypeidGreaterThan(Integer value) {
            addCriterion("WasteTypeID >", value, "wastetypeid");
            return (Criteria) this;
        }

        public Criteria andWastetypeidGreaterThanOrEqualTo(Integer value) {
            addCriterion("WasteTypeID >=", value, "wastetypeid");
            return (Criteria) this;
        }

        public Criteria andWastetypeidLessThan(Integer value) {
            addCriterion("WasteTypeID <", value, "wastetypeid");
            return (Criteria) this;
        }

        public Criteria andWastetypeidLessThanOrEqualTo(Integer value) {
            addCriterion("WasteTypeID <=", value, "wastetypeid");
            return (Criteria) this;
        }

        public Criteria andWastetypeidIn(List<Integer> values) {
            addCriterion("WasteTypeID in", values, "wastetypeid");
            return (Criteria) this;
        }

        public Criteria andWastetypeidNotIn(List<Integer> values) {
            addCriterion("WasteTypeID not in", values, "wastetypeid");
            return (Criteria) this;
        }

        public Criteria andWastetypeidBetween(Integer value1, Integer value2) {
            addCriterion("WasteTypeID between", value1, value2, "wastetypeid");
            return (Criteria) this;
        }

        public Criteria andWastetypeidNotBetween(Integer value1, Integer value2) {
            addCriterion("WasteTypeID not between", value1, value2, "wastetypeid");
            return (Criteria) this;
        }

        public Criteria andCollectionpointidIsNull() {
            addCriterion("CollectionPointID is null");
            return (Criteria) this;
        }

        public Criteria andCollectionpointidIsNotNull() {
            addCriterion("CollectionPointID is not null");
            return (Criteria) this;
        }

        public Criteria andCollectionpointidEqualTo(Integer value) {
            addCriterion("CollectionPointID =", value, "collectionpointid");
            return (Criteria) this;
        }

        public Criteria andCollectionpointidNotEqualTo(Integer value) {
            addCriterion("CollectionPointID <>", value, "collectionpointid");
            return (Criteria) this;
        }

        public Criteria andCollectionpointidGreaterThan(Integer value) {
            addCriterion("CollectionPointID >", value, "collectionpointid");
            return (Criteria) this;
        }

        public Criteria andCollectionpointidGreaterThanOrEqualTo(Integer value) {
            addCriterion("CollectionPointID >=", value, "collectionpointid");
            return (Criteria) this;
        }

        public Criteria andCollectionpointidLessThan(Integer value) {
            addCriterion("CollectionPointID <", value, "collectionpointid");
            return (Criteria) this;
        }

        public Criteria andCollectionpointidLessThanOrEqualTo(Integer value) {
            addCriterion("CollectionPointID <=", value, "collectionpointid");
            return (Criteria) this;
        }

        public Criteria andCollectionpointidIn(List<Integer> values) {
            addCriterion("CollectionPointID in", values, "collectionpointid");
            return (Criteria) this;
        }

        public Criteria andCollectionpointidNotIn(List<Integer> values) {
            addCriterion("CollectionPointID not in", values, "collectionpointid");
            return (Criteria) this;
        }

        public Criteria andCollectionpointidBetween(Integer value1, Integer value2) {
            addCriterion("CollectionPointID between", value1, value2, "collectionpointid");
            return (Criteria) this;
        }

        public Criteria andCollectionpointidNotBetween(Integer value1, Integer value2) {
            addCriterion("CollectionPointID not between", value1, value2, "collectionpointid");
            return (Criteria) this;
        }

        public Criteria andCollectiontimeIsNull() {
            addCriterion("CollectionTime is null");
            return (Criteria) this;
        }

        public Criteria andCollectiontimeIsNotNull() {
            addCriterion("CollectionTime is not null");
            return (Criteria) this;
        }

        public Criteria andCollectiontimeEqualTo(Integer value) {
            addCriterion("CollectionTime =", value, "collectiontime");
            return (Criteria) this;
        }

        public Criteria andCollectiontimeNotEqualTo(Integer value) {
            addCriterion("CollectionTime <>", value, "collectiontime");
            return (Criteria) this;
        }

        public Criteria andCollectiontimeGreaterThan(Integer value) {
            addCriterion("CollectionTime >", value, "collectiontime");
            return (Criteria) this;
        }

        public Criteria andCollectiontimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("CollectionTime >=", value, "collectiontime");
            return (Criteria) this;
        }

        public Criteria andCollectiontimeLessThan(Integer value) {
            addCriterion("CollectionTime <", value, "collectiontime");
            return (Criteria) this;
        }

        public Criteria andCollectiontimeLessThanOrEqualTo(Integer value) {
            addCriterion("CollectionTime <=", value, "collectiontime");
            return (Criteria) this;
        }

        public Criteria andCollectiontimeIn(List<Integer> values) {
            addCriterion("CollectionTime in", values, "collectiontime");
            return (Criteria) this;
        }

        public Criteria andCollectiontimeNotIn(List<Integer> values) {
            addCriterion("CollectionTime not in", values, "collectiontime");
            return (Criteria) this;
        }

        public Criteria andCollectiontimeBetween(Integer value1, Integer value2) {
            addCriterion("CollectionTime between", value1, value2, "collectiontime");
            return (Criteria) this;
        }

        public Criteria andCollectiontimeNotBetween(Integer value1, Integer value2) {
            addCriterion("CollectionTime not between", value1, value2, "collectiontime");
            return (Criteria) this;
        }

        public Criteria andWeightIsNull() {
            addCriterion("Weight is null");
            return (Criteria) this;
        }

        public Criteria andWeightIsNotNull() {
            addCriterion("Weight is not null");
            return (Criteria) this;
        }

        public Criteria andWeightEqualTo(BigDecimal value) {
            addCriterion("Weight =", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotEqualTo(BigDecimal value) {
            addCriterion("Weight <>", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightGreaterThan(BigDecimal value) {
            addCriterion("Weight >", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("Weight >=", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightLessThan(BigDecimal value) {
            addCriterion("Weight <", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightLessThanOrEqualTo(BigDecimal value) {
            addCriterion("Weight <=", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightIn(List<BigDecimal> values) {
            addCriterion("Weight in", values, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotIn(List<BigDecimal> values) {
            addCriterion("Weight not in", values, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("Weight between", value1, value2, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("Weight not between", value1, value2, "weight");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("Status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("Status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("Status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("Status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("Status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("Status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("Status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("Status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("Status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("Status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("Status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("Status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("Status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("Status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andAccountIdIsNull() {
            addCriterion("account_id is null");
            return (Criteria) this;
        }

        public Criteria andAccountIdIsNotNull() {
            addCriterion("account_id is not null");
            return (Criteria) this;
        }

        public Criteria andAccountIdEqualTo(Integer value) {
            addCriterion("account_id =", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdNotEqualTo(Integer value) {
            addCriterion("account_id <>", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdGreaterThan(Integer value) {
            addCriterion("account_id >", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("account_id >=", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdLessThan(Integer value) {
            addCriterion("account_id <", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdLessThanOrEqualTo(Integer value) {
            addCriterion("account_id <=", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdIn(List<Integer> values) {
            addCriterion("account_id in", values, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdNotIn(List<Integer> values) {
            addCriterion("account_id not in", values, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdBetween(Integer value1, Integer value2) {
            addCriterion("account_id between", value1, value2, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdNotBetween(Integer value1, Integer value2) {
            addCriterion("account_id not between", value1, value2, "accountId");
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