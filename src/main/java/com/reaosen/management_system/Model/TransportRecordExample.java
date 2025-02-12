package com.reaosen.management_system.Model;

import java.util.ArrayList;
import java.util.List;

public class TransportRecordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TransportRecordExample() {
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

        public Criteria andTransportidIsNull() {
            addCriterion("TransportID is null");
            return (Criteria) this;
        }

        public Criteria andTransportidIsNotNull() {
            addCriterion("TransportID is not null");
            return (Criteria) this;
        }

        public Criteria andTransportidEqualTo(Integer value) {
            addCriterion("TransportID =", value, "transportid");
            return (Criteria) this;
        }

        public Criteria andTransportidNotEqualTo(Integer value) {
            addCriterion("TransportID <>", value, "transportid");
            return (Criteria) this;
        }

        public Criteria andTransportidGreaterThan(Integer value) {
            addCriterion("TransportID >", value, "transportid");
            return (Criteria) this;
        }

        public Criteria andTransportidGreaterThanOrEqualTo(Integer value) {
            addCriterion("TransportID >=", value, "transportid");
            return (Criteria) this;
        }

        public Criteria andTransportidLessThan(Integer value) {
            addCriterion("TransportID <", value, "transportid");
            return (Criteria) this;
        }

        public Criteria andTransportidLessThanOrEqualTo(Integer value) {
            addCriterion("TransportID <=", value, "transportid");
            return (Criteria) this;
        }

        public Criteria andTransportidIn(List<Integer> values) {
            addCriterion("TransportID in", values, "transportid");
            return (Criteria) this;
        }

        public Criteria andTransportidNotIn(List<Integer> values) {
            addCriterion("TransportID not in", values, "transportid");
            return (Criteria) this;
        }

        public Criteria andTransportidBetween(Integer value1, Integer value2) {
            addCriterion("TransportID between", value1, value2, "transportid");
            return (Criteria) this;
        }

        public Criteria andTransportidNotBetween(Integer value1, Integer value2) {
            addCriterion("TransportID not between", value1, value2, "transportid");
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

        public Criteria andTransporttimeIsNull() {
            addCriterion("TransportTime is null");
            return (Criteria) this;
        }

        public Criteria andTransporttimeIsNotNull() {
            addCriterion("TransportTime is not null");
            return (Criteria) this;
        }

        public Criteria andTransporttimeEqualTo(Integer value) {
            addCriterion("TransportTime =", value, "transporttime");
            return (Criteria) this;
        }

        public Criteria andTransporttimeNotEqualTo(Integer value) {
            addCriterion("TransportTime <>", value, "transporttime");
            return (Criteria) this;
        }

        public Criteria andTransporttimeGreaterThan(Integer value) {
            addCriterion("TransportTime >", value, "transporttime");
            return (Criteria) this;
        }

        public Criteria andTransporttimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("TransportTime >=", value, "transporttime");
            return (Criteria) this;
        }

        public Criteria andTransporttimeLessThan(Integer value) {
            addCriterion("TransportTime <", value, "transporttime");
            return (Criteria) this;
        }

        public Criteria andTransporttimeLessThanOrEqualTo(Integer value) {
            addCriterion("TransportTime <=", value, "transporttime");
            return (Criteria) this;
        }

        public Criteria andTransporttimeIn(List<Integer> values) {
            addCriterion("TransportTime in", values, "transporttime");
            return (Criteria) this;
        }

        public Criteria andTransporttimeNotIn(List<Integer> values) {
            addCriterion("TransportTime not in", values, "transporttime");
            return (Criteria) this;
        }

        public Criteria andTransporttimeBetween(Integer value1, Integer value2) {
            addCriterion("TransportTime between", value1, value2, "transporttime");
            return (Criteria) this;
        }

        public Criteria andTransporttimeNotBetween(Integer value1, Integer value2) {
            addCriterion("TransportTime not between", value1, value2, "transporttime");
            return (Criteria) this;
        }

        public Criteria andTransportvehicleIsNull() {
            addCriterion("TransportVehicle is null");
            return (Criteria) this;
        }

        public Criteria andTransportvehicleIsNotNull() {
            addCriterion("TransportVehicle is not null");
            return (Criteria) this;
        }

        public Criteria andTransportvehicleEqualTo(String value) {
            addCriterion("TransportVehicle =", value, "transportvehicle");
            return (Criteria) this;
        }

        public Criteria andTransportvehicleNotEqualTo(String value) {
            addCriterion("TransportVehicle <>", value, "transportvehicle");
            return (Criteria) this;
        }

        public Criteria andTransportvehicleGreaterThan(String value) {
            addCriterion("TransportVehicle >", value, "transportvehicle");
            return (Criteria) this;
        }

        public Criteria andTransportvehicleGreaterThanOrEqualTo(String value) {
            addCriterion("TransportVehicle >=", value, "transportvehicle");
            return (Criteria) this;
        }

        public Criteria andTransportvehicleLessThan(String value) {
            addCriterion("TransportVehicle <", value, "transportvehicle");
            return (Criteria) this;
        }

        public Criteria andTransportvehicleLessThanOrEqualTo(String value) {
            addCriterion("TransportVehicle <=", value, "transportvehicle");
            return (Criteria) this;
        }

        public Criteria andTransportvehicleLike(String value) {
            addCriterion("TransportVehicle like", value, "transportvehicle");
            return (Criteria) this;
        }

        public Criteria andTransportvehicleNotLike(String value) {
            addCriterion("TransportVehicle not like", value, "transportvehicle");
            return (Criteria) this;
        }

        public Criteria andTransportvehicleIn(List<String> values) {
            addCriterion("TransportVehicle in", values, "transportvehicle");
            return (Criteria) this;
        }

        public Criteria andTransportvehicleNotIn(List<String> values) {
            addCriterion("TransportVehicle not in", values, "transportvehicle");
            return (Criteria) this;
        }

        public Criteria andTransportvehicleBetween(String value1, String value2) {
            addCriterion("TransportVehicle between", value1, value2, "transportvehicle");
            return (Criteria) this;
        }

        public Criteria andTransportvehicleNotBetween(String value1, String value2) {
            addCriterion("TransportVehicle not between", value1, value2, "transportvehicle");
            return (Criteria) this;
        }

        public Criteria andDrivernameIsNull() {
            addCriterion("DriverName is null");
            return (Criteria) this;
        }

        public Criteria andDrivernameIsNotNull() {
            addCriterion("DriverName is not null");
            return (Criteria) this;
        }

        public Criteria andDrivernameEqualTo(String value) {
            addCriterion("DriverName =", value, "drivername");
            return (Criteria) this;
        }

        public Criteria andDrivernameNotEqualTo(String value) {
            addCriterion("DriverName <>", value, "drivername");
            return (Criteria) this;
        }

        public Criteria andDrivernameGreaterThan(String value) {
            addCriterion("DriverName >", value, "drivername");
            return (Criteria) this;
        }

        public Criteria andDrivernameGreaterThanOrEqualTo(String value) {
            addCriterion("DriverName >=", value, "drivername");
            return (Criteria) this;
        }

        public Criteria andDrivernameLessThan(String value) {
            addCriterion("DriverName <", value, "drivername");
            return (Criteria) this;
        }

        public Criteria andDrivernameLessThanOrEqualTo(String value) {
            addCriterion("DriverName <=", value, "drivername");
            return (Criteria) this;
        }

        public Criteria andDrivernameLike(String value) {
            addCriterion("DriverName like", value, "drivername");
            return (Criteria) this;
        }

        public Criteria andDrivernameNotLike(String value) {
            addCriterion("DriverName not like", value, "drivername");
            return (Criteria) this;
        }

        public Criteria andDrivernameIn(List<String> values) {
            addCriterion("DriverName in", values, "drivername");
            return (Criteria) this;
        }

        public Criteria andDrivernameNotIn(List<String> values) {
            addCriterion("DriverName not in", values, "drivername");
            return (Criteria) this;
        }

        public Criteria andDrivernameBetween(String value1, String value2) {
            addCriterion("DriverName between", value1, value2, "drivername");
            return (Criteria) this;
        }

        public Criteria andDrivernameNotBetween(String value1, String value2) {
            addCriterion("DriverName not between", value1, value2, "drivername");
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