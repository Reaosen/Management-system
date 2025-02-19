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

        public Criteria andWasteRecordIdIsNull() {
            addCriterion("waste_record_id is null");
            return (Criteria) this;
        }

        public Criteria andWasteRecordIdIsNotNull() {
            addCriterion("waste_record_id is not null");
            return (Criteria) this;
        }

        public Criteria andWasteRecordIdEqualTo(Integer value) {
            addCriterion("waste_record_id =", value, "wasteRecordId");
            return (Criteria) this;
        }

        public Criteria andWasteRecordIdNotEqualTo(Integer value) {
            addCriterion("waste_record_id <>", value, "wasteRecordId");
            return (Criteria) this;
        }

        public Criteria andWasteRecordIdGreaterThan(Integer value) {
            addCriterion("waste_record_id >", value, "wasteRecordId");
            return (Criteria) this;
        }

        public Criteria andWasteRecordIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("waste_record_id >=", value, "wasteRecordId");
            return (Criteria) this;
        }

        public Criteria andWasteRecordIdLessThan(Integer value) {
            addCriterion("waste_record_id <", value, "wasteRecordId");
            return (Criteria) this;
        }

        public Criteria andWasteRecordIdLessThanOrEqualTo(Integer value) {
            addCriterion("waste_record_id <=", value, "wasteRecordId");
            return (Criteria) this;
        }

        public Criteria andWasteRecordIdIn(List<Integer> values) {
            addCriterion("waste_record_id in", values, "wasteRecordId");
            return (Criteria) this;
        }

        public Criteria andWasteRecordIdNotIn(List<Integer> values) {
            addCriterion("waste_record_id not in", values, "wasteRecordId");
            return (Criteria) this;
        }

        public Criteria andWasteRecordIdBetween(Integer value1, Integer value2) {
            addCriterion("waste_record_id between", value1, value2, "wasteRecordId");
            return (Criteria) this;
        }

        public Criteria andWasteRecordIdNotBetween(Integer value1, Integer value2) {
            addCriterion("waste_record_id not between", value1, value2, "wasteRecordId");
            return (Criteria) this;
        }

        public Criteria andWasteTypeIdIsNull() {
            addCriterion("waste_type_id is null");
            return (Criteria) this;
        }

        public Criteria andWasteTypeIdIsNotNull() {
            addCriterion("waste_type_id is not null");
            return (Criteria) this;
        }

        public Criteria andWasteTypeIdEqualTo(Integer value) {
            addCriterion("waste_type_id =", value, "wasteTypeId");
            return (Criteria) this;
        }

        public Criteria andWasteTypeIdNotEqualTo(Integer value) {
            addCriterion("waste_type_id <>", value, "wasteTypeId");
            return (Criteria) this;
        }

        public Criteria andWasteTypeIdGreaterThan(Integer value) {
            addCriterion("waste_type_id >", value, "wasteTypeId");
            return (Criteria) this;
        }

        public Criteria andWasteTypeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("waste_type_id >=", value, "wasteTypeId");
            return (Criteria) this;
        }

        public Criteria andWasteTypeIdLessThan(Integer value) {
            addCriterion("waste_type_id <", value, "wasteTypeId");
            return (Criteria) this;
        }

        public Criteria andWasteTypeIdLessThanOrEqualTo(Integer value) {
            addCriterion("waste_type_id <=", value, "wasteTypeId");
            return (Criteria) this;
        }

        public Criteria andWasteTypeIdIn(List<Integer> values) {
            addCriterion("waste_type_id in", values, "wasteTypeId");
            return (Criteria) this;
        }

        public Criteria andWasteTypeIdNotIn(List<Integer> values) {
            addCriterion("waste_type_id not in", values, "wasteTypeId");
            return (Criteria) this;
        }

        public Criteria andWasteTypeIdBetween(Integer value1, Integer value2) {
            addCriterion("waste_type_id between", value1, value2, "wasteTypeId");
            return (Criteria) this;
        }

        public Criteria andWasteTypeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("waste_type_id not between", value1, value2, "wasteTypeId");
            return (Criteria) this;
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

        public Criteria andCollectionTimeIsNull() {
            addCriterion("collection_time is null");
            return (Criteria) this;
        }

        public Criteria andCollectionTimeIsNotNull() {
            addCriterion("collection_time is not null");
            return (Criteria) this;
        }

        public Criteria andCollectionTimeEqualTo(Integer value) {
            addCriterion("collection_time =", value, "collectionTime");
            return (Criteria) this;
        }

        public Criteria andCollectionTimeNotEqualTo(Integer value) {
            addCriterion("collection_time <>", value, "collectionTime");
            return (Criteria) this;
        }

        public Criteria andCollectionTimeGreaterThan(Integer value) {
            addCriterion("collection_time >", value, "collectionTime");
            return (Criteria) this;
        }

        public Criteria andCollectionTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("collection_time >=", value, "collectionTime");
            return (Criteria) this;
        }

        public Criteria andCollectionTimeLessThan(Integer value) {
            addCriterion("collection_time <", value, "collectionTime");
            return (Criteria) this;
        }

        public Criteria andCollectionTimeLessThanOrEqualTo(Integer value) {
            addCriterion("collection_time <=", value, "collectionTime");
            return (Criteria) this;
        }

        public Criteria andCollectionTimeIn(List<Integer> values) {
            addCriterion("collection_time in", values, "collectionTime");
            return (Criteria) this;
        }

        public Criteria andCollectionTimeNotIn(List<Integer> values) {
            addCriterion("collection_time not in", values, "collectionTime");
            return (Criteria) this;
        }

        public Criteria andCollectionTimeBetween(Integer value1, Integer value2) {
            addCriterion("collection_time between", value1, value2, "collectionTime");
            return (Criteria) this;
        }

        public Criteria andCollectionTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("collection_time not between", value1, value2, "collectionTime");
            return (Criteria) this;
        }

        public Criteria andWeightIsNull() {
            addCriterion("weight is null");
            return (Criteria) this;
        }

        public Criteria andWeightIsNotNull() {
            addCriterion("weight is not null");
            return (Criteria) this;
        }

        public Criteria andWeightEqualTo(BigDecimal value) {
            addCriterion("weight =", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotEqualTo(BigDecimal value) {
            addCriterion("weight <>", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightGreaterThan(BigDecimal value) {
            addCriterion("weight >", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("weight >=", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightLessThan(BigDecimal value) {
            addCriterion("weight <", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightLessThanOrEqualTo(BigDecimal value) {
            addCriterion("weight <=", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightIn(List<BigDecimal> values) {
            addCriterion("weight in", values, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotIn(List<BigDecimal> values) {
            addCriterion("weight not in", values, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("weight between", value1, value2, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("weight not between", value1, value2, "weight");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andCollectionAccountIdIsNull() {
            addCriterion("collection_account_id is null");
            return (Criteria) this;
        }

        public Criteria andCollectionAccountIdIsNotNull() {
            addCriterion("collection_account_id is not null");
            return (Criteria) this;
        }

        public Criteria andCollectionAccountIdEqualTo(Integer value) {
            addCriterion("collection_account_id =", value, "collectionAccountId");
            return (Criteria) this;
        }

        public Criteria andCollectionAccountIdNotEqualTo(Integer value) {
            addCriterion("collection_account_id <>", value, "collectionAccountId");
            return (Criteria) this;
        }

        public Criteria andCollectionAccountIdGreaterThan(Integer value) {
            addCriterion("collection_account_id >", value, "collectionAccountId");
            return (Criteria) this;
        }

        public Criteria andCollectionAccountIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("collection_account_id >=", value, "collectionAccountId");
            return (Criteria) this;
        }

        public Criteria andCollectionAccountIdLessThan(Integer value) {
            addCriterion("collection_account_id <", value, "collectionAccountId");
            return (Criteria) this;
        }

        public Criteria andCollectionAccountIdLessThanOrEqualTo(Integer value) {
            addCriterion("collection_account_id <=", value, "collectionAccountId");
            return (Criteria) this;
        }

        public Criteria andCollectionAccountIdIn(List<Integer> values) {
            addCriterion("collection_account_id in", values, "collectionAccountId");
            return (Criteria) this;
        }

        public Criteria andCollectionAccountIdNotIn(List<Integer> values) {
            addCriterion("collection_account_id not in", values, "collectionAccountId");
            return (Criteria) this;
        }

        public Criteria andCollectionAccountIdBetween(Integer value1, Integer value2) {
            addCriterion("collection_account_id between", value1, value2, "collectionAccountId");
            return (Criteria) this;
        }

        public Criteria andCollectionAccountIdNotBetween(Integer value1, Integer value2) {
            addCriterion("collection_account_id not between", value1, value2, "collectionAccountId");
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