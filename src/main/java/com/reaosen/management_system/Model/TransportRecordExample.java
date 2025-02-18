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

        public Criteria andTransportIdIsNull() {
            addCriterion("transport_id is null");
            return (Criteria) this;
        }

        public Criteria andTransportIdIsNotNull() {
            addCriterion("transport_id is not null");
            return (Criteria) this;
        }

        public Criteria andTransportIdEqualTo(Integer value) {
            addCriterion("transport_id =", value, "transportId");
            return (Criteria) this;
        }

        public Criteria andTransportIdNotEqualTo(Integer value) {
            addCriterion("transport_id <>", value, "transportId");
            return (Criteria) this;
        }

        public Criteria andTransportIdGreaterThan(Integer value) {
            addCriterion("transport_id >", value, "transportId");
            return (Criteria) this;
        }

        public Criteria andTransportIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("transport_id >=", value, "transportId");
            return (Criteria) this;
        }

        public Criteria andTransportIdLessThan(Integer value) {
            addCriterion("transport_id <", value, "transportId");
            return (Criteria) this;
        }

        public Criteria andTransportIdLessThanOrEqualTo(Integer value) {
            addCriterion("transport_id <=", value, "transportId");
            return (Criteria) this;
        }

        public Criteria andTransportIdIn(List<Integer> values) {
            addCriterion("transport_id in", values, "transportId");
            return (Criteria) this;
        }

        public Criteria andTransportIdNotIn(List<Integer> values) {
            addCriterion("transport_id not in", values, "transportId");
            return (Criteria) this;
        }

        public Criteria andTransportIdBetween(Integer value1, Integer value2) {
            addCriterion("transport_id between", value1, value2, "transportId");
            return (Criteria) this;
        }

        public Criteria andTransportIdNotBetween(Integer value1, Integer value2) {
            addCriterion("transport_id not between", value1, value2, "transportId");
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

        public Criteria andTransportTimeIsNull() {
            addCriterion("transport_time is null");
            return (Criteria) this;
        }

        public Criteria andTransportTimeIsNotNull() {
            addCriterion("transport_time is not null");
            return (Criteria) this;
        }

        public Criteria andTransportTimeEqualTo(Integer value) {
            addCriterion("transport_time =", value, "transportTime");
            return (Criteria) this;
        }

        public Criteria andTransportTimeNotEqualTo(Integer value) {
            addCriterion("transport_time <>", value, "transportTime");
            return (Criteria) this;
        }

        public Criteria andTransportTimeGreaterThan(Integer value) {
            addCriterion("transport_time >", value, "transportTime");
            return (Criteria) this;
        }

        public Criteria andTransportTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("transport_time >=", value, "transportTime");
            return (Criteria) this;
        }

        public Criteria andTransportTimeLessThan(Integer value) {
            addCriterion("transport_time <", value, "transportTime");
            return (Criteria) this;
        }

        public Criteria andTransportTimeLessThanOrEqualTo(Integer value) {
            addCriterion("transport_time <=", value, "transportTime");
            return (Criteria) this;
        }

        public Criteria andTransportTimeIn(List<Integer> values) {
            addCriterion("transport_time in", values, "transportTime");
            return (Criteria) this;
        }

        public Criteria andTransportTimeNotIn(List<Integer> values) {
            addCriterion("transport_time not in", values, "transportTime");
            return (Criteria) this;
        }

        public Criteria andTransportTimeBetween(Integer value1, Integer value2) {
            addCriterion("transport_time between", value1, value2, "transportTime");
            return (Criteria) this;
        }

        public Criteria andTransportTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("transport_time not between", value1, value2, "transportTime");
            return (Criteria) this;
        }

        public Criteria andTransportVehicleIsNull() {
            addCriterion("transport_vehicle is null");
            return (Criteria) this;
        }

        public Criteria andTransportVehicleIsNotNull() {
            addCriterion("transport_vehicle is not null");
            return (Criteria) this;
        }

        public Criteria andTransportVehicleEqualTo(String value) {
            addCriterion("transport_vehicle =", value, "transportVehicle");
            return (Criteria) this;
        }

        public Criteria andTransportVehicleNotEqualTo(String value) {
            addCriterion("transport_vehicle <>", value, "transportVehicle");
            return (Criteria) this;
        }

        public Criteria andTransportVehicleGreaterThan(String value) {
            addCriterion("transport_vehicle >", value, "transportVehicle");
            return (Criteria) this;
        }

        public Criteria andTransportVehicleGreaterThanOrEqualTo(String value) {
            addCriterion("transport_vehicle >=", value, "transportVehicle");
            return (Criteria) this;
        }

        public Criteria andTransportVehicleLessThan(String value) {
            addCriterion("transport_vehicle <", value, "transportVehicle");
            return (Criteria) this;
        }

        public Criteria andTransportVehicleLessThanOrEqualTo(String value) {
            addCriterion("transport_vehicle <=", value, "transportVehicle");
            return (Criteria) this;
        }

        public Criteria andTransportVehicleLike(String value) {
            addCriterion("transport_vehicle like", value, "transportVehicle");
            return (Criteria) this;
        }

        public Criteria andTransportVehicleNotLike(String value) {
            addCriterion("transport_vehicle not like", value, "transportVehicle");
            return (Criteria) this;
        }

        public Criteria andTransportVehicleIn(List<String> values) {
            addCriterion("transport_vehicle in", values, "transportVehicle");
            return (Criteria) this;
        }

        public Criteria andTransportVehicleNotIn(List<String> values) {
            addCriterion("transport_vehicle not in", values, "transportVehicle");
            return (Criteria) this;
        }

        public Criteria andTransportVehicleBetween(String value1, String value2) {
            addCriterion("transport_vehicle between", value1, value2, "transportVehicle");
            return (Criteria) this;
        }

        public Criteria andTransportVehicleNotBetween(String value1, String value2) {
            addCriterion("transport_vehicle not between", value1, value2, "transportVehicle");
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

        public Criteria andTransportusernameIsNull() {
            addCriterion("transportUsername is null");
            return (Criteria) this;
        }

        public Criteria andTransportusernameIsNotNull() {
            addCriterion("transportUsername is not null");
            return (Criteria) this;
        }

        public Criteria andTransportusernameEqualTo(String value) {
            addCriterion("transportUsername =", value, "transportusername");
            return (Criteria) this;
        }

        public Criteria andTransportusernameNotEqualTo(String value) {
            addCriterion("transportUsername <>", value, "transportusername");
            return (Criteria) this;
        }

        public Criteria andTransportusernameGreaterThan(String value) {
            addCriterion("transportUsername >", value, "transportusername");
            return (Criteria) this;
        }

        public Criteria andTransportusernameGreaterThanOrEqualTo(String value) {
            addCriterion("transportUsername >=", value, "transportusername");
            return (Criteria) this;
        }

        public Criteria andTransportusernameLessThan(String value) {
            addCriterion("transportUsername <", value, "transportusername");
            return (Criteria) this;
        }

        public Criteria andTransportusernameLessThanOrEqualTo(String value) {
            addCriterion("transportUsername <=", value, "transportusername");
            return (Criteria) this;
        }

        public Criteria andTransportusernameLike(String value) {
            addCriterion("transportUsername like", value, "transportusername");
            return (Criteria) this;
        }

        public Criteria andTransportusernameNotLike(String value) {
            addCriterion("transportUsername not like", value, "transportusername");
            return (Criteria) this;
        }

        public Criteria andTransportusernameIn(List<String> values) {
            addCriterion("transportUsername in", values, "transportusername");
            return (Criteria) this;
        }

        public Criteria andTransportusernameNotIn(List<String> values) {
            addCriterion("transportUsername not in", values, "transportusername");
            return (Criteria) this;
        }

        public Criteria andTransportusernameBetween(String value1, String value2) {
            addCriterion("transportUsername between", value1, value2, "transportusername");
            return (Criteria) this;
        }

        public Criteria andTransportusernameNotBetween(String value1, String value2) {
            addCriterion("transportUsername not between", value1, value2, "transportusername");
            return (Criteria) this;
        }

        public Criteria andTransportAccountIdIsNull() {
            addCriterion("transport_account_id is null");
            return (Criteria) this;
        }

        public Criteria andTransportAccountIdIsNotNull() {
            addCriterion("transport_account_id is not null");
            return (Criteria) this;
        }

        public Criteria andTransportAccountIdEqualTo(Integer value) {
            addCriterion("transport_account_id =", value, "transportAccountId");
            return (Criteria) this;
        }

        public Criteria andTransportAccountIdNotEqualTo(Integer value) {
            addCriterion("transport_account_id <>", value, "transportAccountId");
            return (Criteria) this;
        }

        public Criteria andTransportAccountIdGreaterThan(Integer value) {
            addCriterion("transport_account_id >", value, "transportAccountId");
            return (Criteria) this;
        }

        public Criteria andTransportAccountIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("transport_account_id >=", value, "transportAccountId");
            return (Criteria) this;
        }

        public Criteria andTransportAccountIdLessThan(Integer value) {
            addCriterion("transport_account_id <", value, "transportAccountId");
            return (Criteria) this;
        }

        public Criteria andTransportAccountIdLessThanOrEqualTo(Integer value) {
            addCriterion("transport_account_id <=", value, "transportAccountId");
            return (Criteria) this;
        }

        public Criteria andTransportAccountIdIn(List<Integer> values) {
            addCriterion("transport_account_id in", values, "transportAccountId");
            return (Criteria) this;
        }

        public Criteria andTransportAccountIdNotIn(List<Integer> values) {
            addCriterion("transport_account_id not in", values, "transportAccountId");
            return (Criteria) this;
        }

        public Criteria andTransportAccountIdBetween(Integer value1, Integer value2) {
            addCriterion("transport_account_id between", value1, value2, "transportAccountId");
            return (Criteria) this;
        }

        public Criteria andTransportAccountIdNotBetween(Integer value1, Integer value2) {
            addCriterion("transport_account_id not between", value1, value2, "transportAccountId");
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