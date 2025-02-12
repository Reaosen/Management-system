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

        public Criteria andDisposalidIsNull() {
            addCriterion("DisposalID is null");
            return (Criteria) this;
        }

        public Criteria andDisposalidIsNotNull() {
            addCriterion("DisposalID is not null");
            return (Criteria) this;
        }

        public Criteria andDisposalidEqualTo(Integer value) {
            addCriterion("DisposalID =", value, "disposalid");
            return (Criteria) this;
        }

        public Criteria andDisposalidNotEqualTo(Integer value) {
            addCriterion("DisposalID <>", value, "disposalid");
            return (Criteria) this;
        }

        public Criteria andDisposalidGreaterThan(Integer value) {
            addCriterion("DisposalID >", value, "disposalid");
            return (Criteria) this;
        }

        public Criteria andDisposalidGreaterThanOrEqualTo(Integer value) {
            addCriterion("DisposalID >=", value, "disposalid");
            return (Criteria) this;
        }

        public Criteria andDisposalidLessThan(Integer value) {
            addCriterion("DisposalID <", value, "disposalid");
            return (Criteria) this;
        }

        public Criteria andDisposalidLessThanOrEqualTo(Integer value) {
            addCriterion("DisposalID <=", value, "disposalid");
            return (Criteria) this;
        }

        public Criteria andDisposalidIn(List<Integer> values) {
            addCriterion("DisposalID in", values, "disposalid");
            return (Criteria) this;
        }

        public Criteria andDisposalidNotIn(List<Integer> values) {
            addCriterion("DisposalID not in", values, "disposalid");
            return (Criteria) this;
        }

        public Criteria andDisposalidBetween(Integer value1, Integer value2) {
            addCriterion("DisposalID between", value1, value2, "disposalid");
            return (Criteria) this;
        }

        public Criteria andDisposalidNotBetween(Integer value1, Integer value2) {
            addCriterion("DisposalID not between", value1, value2, "disposalid");
            return (Criteria) this;
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

        public Criteria andDisposaltimeIsNull() {
            addCriterion("DisposalTime is null");
            return (Criteria) this;
        }

        public Criteria andDisposaltimeIsNotNull() {
            addCriterion("DisposalTime is not null");
            return (Criteria) this;
        }

        public Criteria andDisposaltimeEqualTo(Integer value) {
            addCriterion("DisposalTime =", value, "disposaltime");
            return (Criteria) this;
        }

        public Criteria andDisposaltimeNotEqualTo(Integer value) {
            addCriterion("DisposalTime <>", value, "disposaltime");
            return (Criteria) this;
        }

        public Criteria andDisposaltimeGreaterThan(Integer value) {
            addCriterion("DisposalTime >", value, "disposaltime");
            return (Criteria) this;
        }

        public Criteria andDisposaltimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("DisposalTime >=", value, "disposaltime");
            return (Criteria) this;
        }

        public Criteria andDisposaltimeLessThan(Integer value) {
            addCriterion("DisposalTime <", value, "disposaltime");
            return (Criteria) this;
        }

        public Criteria andDisposaltimeLessThanOrEqualTo(Integer value) {
            addCriterion("DisposalTime <=", value, "disposaltime");
            return (Criteria) this;
        }

        public Criteria andDisposaltimeIn(List<Integer> values) {
            addCriterion("DisposalTime in", values, "disposaltime");
            return (Criteria) this;
        }

        public Criteria andDisposaltimeNotIn(List<Integer> values) {
            addCriterion("DisposalTime not in", values, "disposaltime");
            return (Criteria) this;
        }

        public Criteria andDisposaltimeBetween(Integer value1, Integer value2) {
            addCriterion("DisposalTime between", value1, value2, "disposaltime");
            return (Criteria) this;
        }

        public Criteria andDisposaltimeNotBetween(Integer value1, Integer value2) {
            addCriterion("DisposalTime not between", value1, value2, "disposaltime");
            return (Criteria) this;
        }

        public Criteria andDisposalmethodIsNull() {
            addCriterion("DisposalMethod is null");
            return (Criteria) this;
        }

        public Criteria andDisposalmethodIsNotNull() {
            addCriterion("DisposalMethod is not null");
            return (Criteria) this;
        }

        public Criteria andDisposalmethodEqualTo(String value) {
            addCriterion("DisposalMethod =", value, "disposalmethod");
            return (Criteria) this;
        }

        public Criteria andDisposalmethodNotEqualTo(String value) {
            addCriterion("DisposalMethod <>", value, "disposalmethod");
            return (Criteria) this;
        }

        public Criteria andDisposalmethodGreaterThan(String value) {
            addCriterion("DisposalMethod >", value, "disposalmethod");
            return (Criteria) this;
        }

        public Criteria andDisposalmethodGreaterThanOrEqualTo(String value) {
            addCriterion("DisposalMethod >=", value, "disposalmethod");
            return (Criteria) this;
        }

        public Criteria andDisposalmethodLessThan(String value) {
            addCriterion("DisposalMethod <", value, "disposalmethod");
            return (Criteria) this;
        }

        public Criteria andDisposalmethodLessThanOrEqualTo(String value) {
            addCriterion("DisposalMethod <=", value, "disposalmethod");
            return (Criteria) this;
        }

        public Criteria andDisposalmethodLike(String value) {
            addCriterion("DisposalMethod like", value, "disposalmethod");
            return (Criteria) this;
        }

        public Criteria andDisposalmethodNotLike(String value) {
            addCriterion("DisposalMethod not like", value, "disposalmethod");
            return (Criteria) this;
        }

        public Criteria andDisposalmethodIn(List<String> values) {
            addCriterion("DisposalMethod in", values, "disposalmethod");
            return (Criteria) this;
        }

        public Criteria andDisposalmethodNotIn(List<String> values) {
            addCriterion("DisposalMethod not in", values, "disposalmethod");
            return (Criteria) this;
        }

        public Criteria andDisposalmethodBetween(String value1, String value2) {
            addCriterion("DisposalMethod between", value1, value2, "disposalmethod");
            return (Criteria) this;
        }

        public Criteria andDisposalmethodNotBetween(String value1, String value2) {
            addCriterion("DisposalMethod not between", value1, value2, "disposalmethod");
            return (Criteria) this;
        }

        public Criteria andDisposallocationIsNull() {
            addCriterion("DisposalLocation is null");
            return (Criteria) this;
        }

        public Criteria andDisposallocationIsNotNull() {
            addCriterion("DisposalLocation is not null");
            return (Criteria) this;
        }

        public Criteria andDisposallocationEqualTo(String value) {
            addCriterion("DisposalLocation =", value, "disposallocation");
            return (Criteria) this;
        }

        public Criteria andDisposallocationNotEqualTo(String value) {
            addCriterion("DisposalLocation <>", value, "disposallocation");
            return (Criteria) this;
        }

        public Criteria andDisposallocationGreaterThan(String value) {
            addCriterion("DisposalLocation >", value, "disposallocation");
            return (Criteria) this;
        }

        public Criteria andDisposallocationGreaterThanOrEqualTo(String value) {
            addCriterion("DisposalLocation >=", value, "disposallocation");
            return (Criteria) this;
        }

        public Criteria andDisposallocationLessThan(String value) {
            addCriterion("DisposalLocation <", value, "disposallocation");
            return (Criteria) this;
        }

        public Criteria andDisposallocationLessThanOrEqualTo(String value) {
            addCriterion("DisposalLocation <=", value, "disposallocation");
            return (Criteria) this;
        }

        public Criteria andDisposallocationLike(String value) {
            addCriterion("DisposalLocation like", value, "disposallocation");
            return (Criteria) this;
        }

        public Criteria andDisposallocationNotLike(String value) {
            addCriterion("DisposalLocation not like", value, "disposallocation");
            return (Criteria) this;
        }

        public Criteria andDisposallocationIn(List<String> values) {
            addCriterion("DisposalLocation in", values, "disposallocation");
            return (Criteria) this;
        }

        public Criteria andDisposallocationNotIn(List<String> values) {
            addCriterion("DisposalLocation not in", values, "disposallocation");
            return (Criteria) this;
        }

        public Criteria andDisposallocationBetween(String value1, String value2) {
            addCriterion("DisposalLocation between", value1, value2, "disposallocation");
            return (Criteria) this;
        }

        public Criteria andDisposallocationNotBetween(String value1, String value2) {
            addCriterion("DisposalLocation not between", value1, value2, "disposallocation");
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