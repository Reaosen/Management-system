package com.reaosen.management_system.Model;

import java.util.ArrayList;
import java.util.List;

public class DisposalRecordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DisposalRecordExample() {
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

        public Criteria andDisposalIdIsNull() {
            addCriterion("disposal_id is null");
            return (Criteria) this;
        }

        public Criteria andDisposalIdIsNotNull() {
            addCriterion("disposal_id is not null");
            return (Criteria) this;
        }

        public Criteria andDisposalIdEqualTo(Integer value) {
            addCriterion("disposal_id =", value, "disposalId");
            return (Criteria) this;
        }

        public Criteria andDisposalIdNotEqualTo(Integer value) {
            addCriterion("disposal_id <>", value, "disposalId");
            return (Criteria) this;
        }

        public Criteria andDisposalIdGreaterThan(Integer value) {
            addCriterion("disposal_id >", value, "disposalId");
            return (Criteria) this;
        }

        public Criteria andDisposalIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("disposal_id >=", value, "disposalId");
            return (Criteria) this;
        }

        public Criteria andDisposalIdLessThan(Integer value) {
            addCriterion("disposal_id <", value, "disposalId");
            return (Criteria) this;
        }

        public Criteria andDisposalIdLessThanOrEqualTo(Integer value) {
            addCriterion("disposal_id <=", value, "disposalId");
            return (Criteria) this;
        }

        public Criteria andDisposalIdIn(List<Integer> values) {
            addCriterion("disposal_id in", values, "disposalId");
            return (Criteria) this;
        }

        public Criteria andDisposalIdNotIn(List<Integer> values) {
            addCriterion("disposal_id not in", values, "disposalId");
            return (Criteria) this;
        }

        public Criteria andDisposalIdBetween(Integer value1, Integer value2) {
            addCriterion("disposal_id between", value1, value2, "disposalId");
            return (Criteria) this;
        }

        public Criteria andDisposalIdNotBetween(Integer value1, Integer value2) {
            addCriterion("disposal_id not between", value1, value2, "disposalId");
            return (Criteria) this;
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

        public Criteria andDisposalTimeIsNull() {
            addCriterion("disposal_time is null");
            return (Criteria) this;
        }

        public Criteria andDisposalTimeIsNotNull() {
            addCriterion("disposal_time is not null");
            return (Criteria) this;
        }

        public Criteria andDisposalTimeEqualTo(Integer value) {
            addCriterion("disposal_time =", value, "disposalTime");
            return (Criteria) this;
        }

        public Criteria andDisposalTimeNotEqualTo(Integer value) {
            addCriterion("disposal_time <>", value, "disposalTime");
            return (Criteria) this;
        }

        public Criteria andDisposalTimeGreaterThan(Integer value) {
            addCriterion("disposal_time >", value, "disposalTime");
            return (Criteria) this;
        }

        public Criteria andDisposalTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("disposal_time >=", value, "disposalTime");
            return (Criteria) this;
        }

        public Criteria andDisposalTimeLessThan(Integer value) {
            addCriterion("disposal_time <", value, "disposalTime");
            return (Criteria) this;
        }

        public Criteria andDisposalTimeLessThanOrEqualTo(Integer value) {
            addCriterion("disposal_time <=", value, "disposalTime");
            return (Criteria) this;
        }

        public Criteria andDisposalTimeIn(List<Integer> values) {
            addCriterion("disposal_time in", values, "disposalTime");
            return (Criteria) this;
        }

        public Criteria andDisposalTimeNotIn(List<Integer> values) {
            addCriterion("disposal_time not in", values, "disposalTime");
            return (Criteria) this;
        }

        public Criteria andDisposalTimeBetween(Integer value1, Integer value2) {
            addCriterion("disposal_time between", value1, value2, "disposalTime");
            return (Criteria) this;
        }

        public Criteria andDisposalTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("disposal_time not between", value1, value2, "disposalTime");
            return (Criteria) this;
        }

        public Criteria andDisposalMethodIdIsNull() {
            addCriterion("disposal_method_id is null");
            return (Criteria) this;
        }

        public Criteria andDisposalMethodIdIsNotNull() {
            addCriterion("disposal_method_id is not null");
            return (Criteria) this;
        }

        public Criteria andDisposalMethodIdEqualTo(Integer value) {
            addCriterion("disposal_method_id =", value, "disposalMethodId");
            return (Criteria) this;
        }

        public Criteria andDisposalMethodIdNotEqualTo(Integer value) {
            addCriterion("disposal_method_id <>", value, "disposalMethodId");
            return (Criteria) this;
        }

        public Criteria andDisposalMethodIdGreaterThan(Integer value) {
            addCriterion("disposal_method_id >", value, "disposalMethodId");
            return (Criteria) this;
        }

        public Criteria andDisposalMethodIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("disposal_method_id >=", value, "disposalMethodId");
            return (Criteria) this;
        }

        public Criteria andDisposalMethodIdLessThan(Integer value) {
            addCriterion("disposal_method_id <", value, "disposalMethodId");
            return (Criteria) this;
        }

        public Criteria andDisposalMethodIdLessThanOrEqualTo(Integer value) {
            addCriterion("disposal_method_id <=", value, "disposalMethodId");
            return (Criteria) this;
        }

        public Criteria andDisposalMethodIdIn(List<Integer> values) {
            addCriterion("disposal_method_id in", values, "disposalMethodId");
            return (Criteria) this;
        }

        public Criteria andDisposalMethodIdNotIn(List<Integer> values) {
            addCriterion("disposal_method_id not in", values, "disposalMethodId");
            return (Criteria) this;
        }

        public Criteria andDisposalMethodIdBetween(Integer value1, Integer value2) {
            addCriterion("disposal_method_id between", value1, value2, "disposalMethodId");
            return (Criteria) this;
        }

        public Criteria andDisposalMethodIdNotBetween(Integer value1, Integer value2) {
            addCriterion("disposal_method_id not between", value1, value2, "disposalMethodId");
            return (Criteria) this;
        }

        public Criteria andDisposalPointIdIsNull() {
            addCriterion("disposal_point_id is null");
            return (Criteria) this;
        }

        public Criteria andDisposalPointIdIsNotNull() {
            addCriterion("disposal_point_id is not null");
            return (Criteria) this;
        }

        public Criteria andDisposalPointIdEqualTo(Integer value) {
            addCriterion("disposal_point_id =", value, "disposalPointId");
            return (Criteria) this;
        }

        public Criteria andDisposalPointIdNotEqualTo(Integer value) {
            addCriterion("disposal_point_id <>", value, "disposalPointId");
            return (Criteria) this;
        }

        public Criteria andDisposalPointIdGreaterThan(Integer value) {
            addCriterion("disposal_point_id >", value, "disposalPointId");
            return (Criteria) this;
        }

        public Criteria andDisposalPointIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("disposal_point_id >=", value, "disposalPointId");
            return (Criteria) this;
        }

        public Criteria andDisposalPointIdLessThan(Integer value) {
            addCriterion("disposal_point_id <", value, "disposalPointId");
            return (Criteria) this;
        }

        public Criteria andDisposalPointIdLessThanOrEqualTo(Integer value) {
            addCriterion("disposal_point_id <=", value, "disposalPointId");
            return (Criteria) this;
        }

        public Criteria andDisposalPointIdIn(List<Integer> values) {
            addCriterion("disposal_point_id in", values, "disposalPointId");
            return (Criteria) this;
        }

        public Criteria andDisposalPointIdNotIn(List<Integer> values) {
            addCriterion("disposal_point_id not in", values, "disposalPointId");
            return (Criteria) this;
        }

        public Criteria andDisposalPointIdBetween(Integer value1, Integer value2) {
            addCriterion("disposal_point_id between", value1, value2, "disposalPointId");
            return (Criteria) this;
        }

        public Criteria andDisposalPointIdNotBetween(Integer value1, Integer value2) {
            addCriterion("disposal_point_id not between", value1, value2, "disposalPointId");
            return (Criteria) this;
        }

        public Criteria andDisposalAccountIdIsNull() {
            addCriterion("disposal_account_id is null");
            return (Criteria) this;
        }

        public Criteria andDisposalAccountIdIsNotNull() {
            addCriterion("disposal_account_id is not null");
            return (Criteria) this;
        }

        public Criteria andDisposalAccountIdEqualTo(Integer value) {
            addCriterion("disposal_account_id =", value, "disposalAccountId");
            return (Criteria) this;
        }

        public Criteria andDisposalAccountIdNotEqualTo(Integer value) {
            addCriterion("disposal_account_id <>", value, "disposalAccountId");
            return (Criteria) this;
        }

        public Criteria andDisposalAccountIdGreaterThan(Integer value) {
            addCriterion("disposal_account_id >", value, "disposalAccountId");
            return (Criteria) this;
        }

        public Criteria andDisposalAccountIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("disposal_account_id >=", value, "disposalAccountId");
            return (Criteria) this;
        }

        public Criteria andDisposalAccountIdLessThan(Integer value) {
            addCriterion("disposal_account_id <", value, "disposalAccountId");
            return (Criteria) this;
        }

        public Criteria andDisposalAccountIdLessThanOrEqualTo(Integer value) {
            addCriterion("disposal_account_id <=", value, "disposalAccountId");
            return (Criteria) this;
        }

        public Criteria andDisposalAccountIdIn(List<Integer> values) {
            addCriterion("disposal_account_id in", values, "disposalAccountId");
            return (Criteria) this;
        }

        public Criteria andDisposalAccountIdNotIn(List<Integer> values) {
            addCriterion("disposal_account_id not in", values, "disposalAccountId");
            return (Criteria) this;
        }

        public Criteria andDisposalAccountIdBetween(Integer value1, Integer value2) {
            addCriterion("disposal_account_id between", value1, value2, "disposalAccountId");
            return (Criteria) this;
        }

        public Criteria andDisposalAccountIdNotBetween(Integer value1, Integer value2) {
            addCriterion("disposal_account_id not between", value1, value2, "disposalAccountId");
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