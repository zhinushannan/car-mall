package club.kwcoder.server.dataobject;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BrowseDOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BrowseDOExample() {
        oredCriteria = new ArrayList<>();
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
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
            criteria = new ArrayList<>();
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

        public Criteria andCarIdIsNull() {
            addCriterion("car_id is null");
            return (Criteria) this;
        }

        public Criteria andCarIdIsNotNull() {
            addCriterion("car_id is not null");
            return (Criteria) this;
        }

        public Criteria andCarIdEqualTo(String value) {
            addCriterion("car_id =", value, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdNotEqualTo(String value) {
            addCriterion("car_id <>", value, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdGreaterThan(String value) {
            addCriterion("car_id >", value, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdGreaterThanOrEqualTo(String value) {
            addCriterion("car_id >=", value, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdLessThan(String value) {
            addCriterion("car_id <", value, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdLessThanOrEqualTo(String value) {
            addCriterion("car_id <=", value, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdLike(String value) {
            addCriterion("car_id like", value, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdNotLike(String value) {
            addCriterion("car_id not like", value, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdIn(List<String> values) {
            addCriterion("car_id in", values, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdNotIn(List<String> values) {
            addCriterion("car_id not in", values, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdBetween(String value1, String value2) {
            addCriterion("car_id between", value1, value2, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdNotBetween(String value1, String value2) {
            addCriterion("car_id not between", value1, value2, "carId");
            return (Criteria) this;
        }

        public Criteria andUserEmailIsNull() {
            addCriterion("user_email is null");
            return (Criteria) this;
        }

        public Criteria andUserEmailIsNotNull() {
            addCriterion("user_email is not null");
            return (Criteria) this;
        }

        public Criteria andUserEmailEqualTo(String value) {
            addCriterion("user_email =", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailNotEqualTo(String value) {
            addCriterion("user_email <>", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailGreaterThan(String value) {
            addCriterion("user_email >", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailGreaterThanOrEqualTo(String value) {
            addCriterion("user_email >=", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailLessThan(String value) {
            addCriterion("user_email <", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailLessThanOrEqualTo(String value) {
            addCriterion("user_email <=", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailLike(String value) {
            addCriterion("user_email like", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailNotLike(String value) {
            addCriterion("user_email not like", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailIn(List<String> values) {
            addCriterion("user_email in", values, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailNotIn(List<String> values) {
            addCriterion("user_email not in", values, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailBetween(String value1, String value2) {
            addCriterion("user_email between", value1, value2, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailNotBetween(String value1, String value2) {
            addCriterion("user_email not between", value1, value2, "userEmail");
            return (Criteria) this;
        }

        public Criteria andFrequencyIsNull() {
            addCriterion("frequency is null");
            return (Criteria) this;
        }

        public Criteria andFrequencyIsNotNull() {
            addCriterion("frequency is not null");
            return (Criteria) this;
        }

        public Criteria andFrequencyEqualTo(Integer value) {
            addCriterion("frequency =", value, "frequency");
            return (Criteria) this;
        }

        public Criteria andFrequencyNotEqualTo(Integer value) {
            addCriterion("frequency <>", value, "frequency");
            return (Criteria) this;
        }

        public Criteria andFrequencyGreaterThan(Integer value) {
            addCriterion("frequency >", value, "frequency");
            return (Criteria) this;
        }

        public Criteria andFrequencyGreaterThanOrEqualTo(Integer value) {
            addCriterion("frequency >=", value, "frequency");
            return (Criteria) this;
        }

        public Criteria andFrequencyLessThan(Integer value) {
            addCriterion("frequency <", value, "frequency");
            return (Criteria) this;
        }

        public Criteria andFrequencyLessThanOrEqualTo(Integer value) {
            addCriterion("frequency <=", value, "frequency");
            return (Criteria) this;
        }

        public Criteria andFrequencyIn(List<Integer> values) {
            addCriterion("frequency in", values, "frequency");
            return (Criteria) this;
        }

        public Criteria andFrequencyNotIn(List<Integer> values) {
            addCriterion("frequency not in", values, "frequency");
            return (Criteria) this;
        }

        public Criteria andFrequencyBetween(Integer value1, Integer value2) {
            addCriterion("frequency between", value1, value2, "frequency");
            return (Criteria) this;
        }

        public Criteria andFrequencyNotBetween(Integer value1, Integer value2) {
            addCriterion("frequency not between", value1, value2, "frequency");
            return (Criteria) this;
        }

        public Criteria andLastBrowseIsNull() {
            addCriterion("last_browse is null");
            return (Criteria) this;
        }

        public Criteria andLastBrowseIsNotNull() {
            addCriterion("last_browse is not null");
            return (Criteria) this;
        }

        public Criteria andLastBrowseEqualTo(Date value) {
            addCriterion("last_browse =", value, "lastBrowse");
            return (Criteria) this;
        }

        public Criteria andLastBrowseNotEqualTo(Date value) {
            addCriterion("last_browse <>", value, "lastBrowse");
            return (Criteria) this;
        }

        public Criteria andLastBrowseGreaterThan(Date value) {
            addCriterion("last_browse >", value, "lastBrowse");
            return (Criteria) this;
        }

        public Criteria andLastBrowseGreaterThanOrEqualTo(Date value) {
            addCriterion("last_browse >=", value, "lastBrowse");
            return (Criteria) this;
        }

        public Criteria andLastBrowseLessThan(Date value) {
            addCriterion("last_browse <", value, "lastBrowse");
            return (Criteria) this;
        }

        public Criteria andLastBrowseLessThanOrEqualTo(Date value) {
            addCriterion("last_browse <=", value, "lastBrowse");
            return (Criteria) this;
        }

        public Criteria andLastBrowseIn(List<Date> values) {
            addCriterion("last_browse in", values, "lastBrowse");
            return (Criteria) this;
        }

        public Criteria andLastBrowseNotIn(List<Date> values) {
            addCriterion("last_browse not in", values, "lastBrowse");
            return (Criteria) this;
        }

        public Criteria andLastBrowseBetween(Date value1, Date value2) {
            addCriterion("last_browse between", value1, value2, "lastBrowse");
            return (Criteria) this;
        }

        public Criteria andLastBrowseNotBetween(Date value1, Date value2) {
            addCriterion("last_browse not between", value1, value2, "lastBrowse");
            return (Criteria) this;
        }
    }

    /**
     *
     */
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
    }
}