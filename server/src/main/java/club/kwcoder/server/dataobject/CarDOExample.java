package club.kwcoder.server.dataobject;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class CarDOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CarDOExample() {
        oredCriteria = new ArrayList<>();
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andBrandIsNull() {
            addCriterion("brand is null");
            return (Criteria) this;
        }

        public Criteria andBrandIsNotNull() {
            addCriterion("brand is not null");
            return (Criteria) this;
        }

        public Criteria andBrandEqualTo(String value) {
            addCriterion("brand =", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandNotEqualTo(String value) {
            addCriterion("brand <>", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandGreaterThan(String value) {
            addCriterion("brand >", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandGreaterThanOrEqualTo(String value) {
            addCriterion("brand >=", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandLessThan(String value) {
            addCriterion("brand <", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandLessThanOrEqualTo(String value) {
            addCriterion("brand <=", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandLike(String value) {
            addCriterion("brand like", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandNotLike(String value) {
            addCriterion("brand not like", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandIn(List<String> values) {
            addCriterion("brand in", values, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandNotIn(List<String> values) {
            addCriterion("brand not in", values, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandBetween(String value1, String value2) {
            addCriterion("brand between", value1, value2, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandNotBetween(String value1, String value2) {
            addCriterion("brand not between", value1, value2, "brand");
            return (Criteria) this;
        }

        public Criteria andModelIsNull() {
            addCriterion("model is null");
            return (Criteria) this;
        }

        public Criteria andModelIsNotNull() {
            addCriterion("model is not null");
            return (Criteria) this;
        }

        public Criteria andModelEqualTo(String value) {
            addCriterion("model =", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelNotEqualTo(String value) {
            addCriterion("model <>", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelGreaterThan(String value) {
            addCriterion("model >", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelGreaterThanOrEqualTo(String value) {
            addCriterion("model >=", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelLessThan(String value) {
            addCriterion("model <", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelLessThanOrEqualTo(String value) {
            addCriterion("model <=", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelLike(String value) {
            addCriterion("model like", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelNotLike(String value) {
            addCriterion("model not like", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelIn(List<String> values) {
            addCriterion("model in", values, "model");
            return (Criteria) this;
        }

        public Criteria andModelNotIn(List<String> values) {
            addCriterion("model not in", values, "model");
            return (Criteria) this;
        }

        public Criteria andModelBetween(String value1, String value2) {
            addCriterion("model between", value1, value2, "model");
            return (Criteria) this;
        }

        public Criteria andModelNotBetween(String value1, String value2) {
            addCriterion("model not between", value1, value2, "model");
            return (Criteria) this;
        }

        public Criteria andRegisterDateIsNull() {
            addCriterion("register_date is null");
            return (Criteria) this;
        }

        public Criteria andRegisterDateIsNotNull() {
            addCriterion("register_date is not null");
            return (Criteria) this;
        }

        public Criteria andRegisterDateEqualTo(Date value) {
            addCriterionForJDBCDate("register_date =", value, "registerDate");
            return (Criteria) this;
        }

        public Criteria andRegisterDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("register_date <>", value, "registerDate");
            return (Criteria) this;
        }

        public Criteria andRegisterDateGreaterThan(Date value) {
            addCriterionForJDBCDate("register_date >", value, "registerDate");
            return (Criteria) this;
        }

        public Criteria andRegisterDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("register_date >=", value, "registerDate");
            return (Criteria) this;
        }

        public Criteria andRegisterDateLessThan(Date value) {
            addCriterionForJDBCDate("register_date <", value, "registerDate");
            return (Criteria) this;
        }

        public Criteria andRegisterDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("register_date <=", value, "registerDate");
            return (Criteria) this;
        }

        public Criteria andRegisterDateIn(List<Date> values) {
            addCriterionForJDBCDate("register_date in", values, "registerDate");
            return (Criteria) this;
        }

        public Criteria andRegisterDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("register_date not in", values, "registerDate");
            return (Criteria) this;
        }

        public Criteria andRegisterDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("register_date between", value1, value2, "registerDate");
            return (Criteria) this;
        }

        public Criteria andRegisterDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("register_date not between", value1, value2, "registerDate");
            return (Criteria) this;
        }

        public Criteria andMileageIsNull() {
            addCriterion("mileage is null");
            return (Criteria) this;
        }

        public Criteria andMileageIsNotNull() {
            addCriterion("mileage is not null");
            return (Criteria) this;
        }

        public Criteria andMileageEqualTo(Integer value) {
            addCriterion("mileage =", value, "mileage");
            return (Criteria) this;
        }

        public Criteria andMileageNotEqualTo(Integer value) {
            addCriterion("mileage <>", value, "mileage");
            return (Criteria) this;
        }

        public Criteria andMileageGreaterThan(Integer value) {
            addCriterion("mileage >", value, "mileage");
            return (Criteria) this;
        }

        public Criteria andMileageGreaterThanOrEqualTo(Integer value) {
            addCriterion("mileage >=", value, "mileage");
            return (Criteria) this;
        }

        public Criteria andMileageLessThan(Integer value) {
            addCriterion("mileage <", value, "mileage");
            return (Criteria) this;
        }

        public Criteria andMileageLessThanOrEqualTo(Integer value) {
            addCriterion("mileage <=", value, "mileage");
            return (Criteria) this;
        }

        public Criteria andMileageIn(List<Integer> values) {
            addCriterion("mileage in", values, "mileage");
            return (Criteria) this;
        }

        public Criteria andMileageNotIn(List<Integer> values) {
            addCriterion("mileage not in", values, "mileage");
            return (Criteria) this;
        }

        public Criteria andMileageBetween(Integer value1, Integer value2) {
            addCriterion("mileage between", value1, value2, "mileage");
            return (Criteria) this;
        }

        public Criteria andMileageNotBetween(Integer value1, Integer value2) {
            addCriterion("mileage not between", value1, value2, "mileage");
            return (Criteria) this;
        }

        public Criteria andDisplacementIsNull() {
            addCriterion("displacement is null");
            return (Criteria) this;
        }

        public Criteria andDisplacementIsNotNull() {
            addCriterion("displacement is not null");
            return (Criteria) this;
        }

        public Criteria andDisplacementEqualTo(Integer value) {
            addCriterion("displacement =", value, "displacement");
            return (Criteria) this;
        }

        public Criteria andDisplacementNotEqualTo(Integer value) {
            addCriterion("displacement <>", value, "displacement");
            return (Criteria) this;
        }

        public Criteria andDisplacementGreaterThan(Integer value) {
            addCriterion("displacement >", value, "displacement");
            return (Criteria) this;
        }

        public Criteria andDisplacementGreaterThanOrEqualTo(Integer value) {
            addCriterion("displacement >=", value, "displacement");
            return (Criteria) this;
        }

        public Criteria andDisplacementLessThan(Integer value) {
            addCriterion("displacement <", value, "displacement");
            return (Criteria) this;
        }

        public Criteria andDisplacementLessThanOrEqualTo(Integer value) {
            addCriterion("displacement <=", value, "displacement");
            return (Criteria) this;
        }

        public Criteria andDisplacementIn(List<Integer> values) {
            addCriterion("displacement in", values, "displacement");
            return (Criteria) this;
        }

        public Criteria andDisplacementNotIn(List<Integer> values) {
            addCriterion("displacement not in", values, "displacement");
            return (Criteria) this;
        }

        public Criteria andDisplacementBetween(Integer value1, Integer value2) {
            addCriterion("displacement between", value1, value2, "displacement");
            return (Criteria) this;
        }

        public Criteria andDisplacementNotBetween(Integer value1, Integer value2) {
            addCriterion("displacement not between", value1, value2, "displacement");
            return (Criteria) this;
        }

        public Criteria andGearboxIsNull() {
            addCriterion("gearbox is null");
            return (Criteria) this;
        }

        public Criteria andGearboxIsNotNull() {
            addCriterion("gearbox is not null");
            return (Criteria) this;
        }

        public Criteria andGearboxEqualTo(String value) {
            addCriterion("gearbox =", value, "gearbox");
            return (Criteria) this;
        }

        public Criteria andGearboxNotEqualTo(String value) {
            addCriterion("gearbox <>", value, "gearbox");
            return (Criteria) this;
        }

        public Criteria andGearboxGreaterThan(String value) {
            addCriterion("gearbox >", value, "gearbox");
            return (Criteria) this;
        }

        public Criteria andGearboxGreaterThanOrEqualTo(String value) {
            addCriterion("gearbox >=", value, "gearbox");
            return (Criteria) this;
        }

        public Criteria andGearboxLessThan(String value) {
            addCriterion("gearbox <", value, "gearbox");
            return (Criteria) this;
        }

        public Criteria andGearboxLessThanOrEqualTo(String value) {
            addCriterion("gearbox <=", value, "gearbox");
            return (Criteria) this;
        }

        public Criteria andGearboxLike(String value) {
            addCriterion("gearbox like", value, "gearbox");
            return (Criteria) this;
        }

        public Criteria andGearboxNotLike(String value) {
            addCriterion("gearbox not like", value, "gearbox");
            return (Criteria) this;
        }

        public Criteria andGearboxIn(List<String> values) {
            addCriterion("gearbox in", values, "gearbox");
            return (Criteria) this;
        }

        public Criteria andGearboxNotIn(List<String> values) {
            addCriterion("gearbox not in", values, "gearbox");
            return (Criteria) this;
        }

        public Criteria andGearboxBetween(String value1, String value2) {
            addCriterion("gearbox between", value1, value2, "gearbox");
            return (Criteria) this;
        }

        public Criteria andGearboxNotBetween(String value1, String value2) {
            addCriterion("gearbox not between", value1, value2, "gearbox");
            return (Criteria) this;
        }

        public Criteria andPriceIsNull() {
            addCriterion("price is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("price is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(Double value) {
            addCriterion("price =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(Double value) {
            addCriterion("price <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(Double value) {
            addCriterion("price >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(Double value) {
            addCriterion("price >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(Double value) {
            addCriterion("price <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(Double value) {
            addCriterion("price <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<Double> values) {
            addCriterion("price in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<Double> values) {
            addCriterion("price not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(Double value1, Double value2) {
            addCriterion("price between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(Double value1, Double value2) {
            addCriterion("price not between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andShowPriceIsNull() {
            addCriterion("show_price is null");
            return (Criteria) this;
        }

        public Criteria andShowPriceIsNotNull() {
            addCriterion("show_price is not null");
            return (Criteria) this;
        }

        public Criteria andShowPriceEqualTo(Double value) {
            addCriterion("show_price =", value, "showPrice");
            return (Criteria) this;
        }

        public Criteria andShowPriceNotEqualTo(Double value) {
            addCriterion("show_price <>", value, "showPrice");
            return (Criteria) this;
        }

        public Criteria andShowPriceGreaterThan(Double value) {
            addCriterion("show_price >", value, "showPrice");
            return (Criteria) this;
        }

        public Criteria andShowPriceGreaterThanOrEqualTo(Double value) {
            addCriterion("show_price >=", value, "showPrice");
            return (Criteria) this;
        }

        public Criteria andShowPriceLessThan(Double value) {
            addCriterion("show_price <", value, "showPrice");
            return (Criteria) this;
        }

        public Criteria andShowPriceLessThanOrEqualTo(Double value) {
            addCriterion("show_price <=", value, "showPrice");
            return (Criteria) this;
        }

        public Criteria andShowPriceIn(List<Double> values) {
            addCriterion("show_price in", values, "showPrice");
            return (Criteria) this;
        }

        public Criteria andShowPriceNotIn(List<Double> values) {
            addCriterion("show_price not in", values, "showPrice");
            return (Criteria) this;
        }

        public Criteria andShowPriceBetween(Double value1, Double value2) {
            addCriterion("show_price between", value1, value2, "showPrice");
            return (Criteria) this;
        }

        public Criteria andShowPriceNotBetween(Double value1, Double value2) {
            addCriterion("show_price not between", value1, value2, "showPrice");
            return (Criteria) this;
        }

        public Criteria andImgListIsNull() {
            addCriterion("img_list is null");
            return (Criteria) this;
        }

        public Criteria andImgListIsNotNull() {
            addCriterion("img_list is not null");
            return (Criteria) this;
        }

        public Criteria andImgListEqualTo(String value) {
            addCriterion("img_list =", value, "imgList");
            return (Criteria) this;
        }

        public Criteria andImgListNotEqualTo(String value) {
            addCriterion("img_list <>", value, "imgList");
            return (Criteria) this;
        }

        public Criteria andImgListGreaterThan(String value) {
            addCriterion("img_list >", value, "imgList");
            return (Criteria) this;
        }

        public Criteria andImgListGreaterThanOrEqualTo(String value) {
            addCriterion("img_list >=", value, "imgList");
            return (Criteria) this;
        }

        public Criteria andImgListLessThan(String value) {
            addCriterion("img_list <", value, "imgList");
            return (Criteria) this;
        }

        public Criteria andImgListLessThanOrEqualTo(String value) {
            addCriterion("img_list <=", value, "imgList");
            return (Criteria) this;
        }

        public Criteria andImgListLike(String value) {
            addCriterion("img_list like", value, "imgList");
            return (Criteria) this;
        }

        public Criteria andImgListNotLike(String value) {
            addCriterion("img_list not like", value, "imgList");
            return (Criteria) this;
        }

        public Criteria andImgListIn(List<String> values) {
            addCriterion("img_list in", values, "imgList");
            return (Criteria) this;
        }

        public Criteria andImgListNotIn(List<String> values) {
            addCriterion("img_list not in", values, "imgList");
            return (Criteria) this;
        }

        public Criteria andImgListBetween(String value1, String value2) {
            addCriterion("img_list between", value1, value2, "imgList");
            return (Criteria) this;
        }

        public Criteria andImgListNotBetween(String value1, String value2) {
            addCriterion("img_list not between", value1, value2, "imgList");
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

        public Criteria andStatusIsNull() {
            addCriterion("`status` is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("`status` is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("`status` =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("`status` <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("`status` >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("`status` >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("`status` <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("`status` <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("`status` in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("`status` not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("`status` between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("`status` not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andCreatedGmtIsNull() {
            addCriterion("created_gmt is null");
            return (Criteria) this;
        }

        public Criteria andCreatedGmtIsNotNull() {
            addCriterion("created_gmt is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedGmtEqualTo(Date value) {
            addCriterion("created_gmt =", value, "createdGmt");
            return (Criteria) this;
        }

        public Criteria andCreatedGmtNotEqualTo(Date value) {
            addCriterion("created_gmt <>", value, "createdGmt");
            return (Criteria) this;
        }

        public Criteria andCreatedGmtGreaterThan(Date value) {
            addCriterion("created_gmt >", value, "createdGmt");
            return (Criteria) this;
        }

        public Criteria andCreatedGmtGreaterThanOrEqualTo(Date value) {
            addCriterion("created_gmt >=", value, "createdGmt");
            return (Criteria) this;
        }

        public Criteria andCreatedGmtLessThan(Date value) {
            addCriterion("created_gmt <", value, "createdGmt");
            return (Criteria) this;
        }

        public Criteria andCreatedGmtLessThanOrEqualTo(Date value) {
            addCriterion("created_gmt <=", value, "createdGmt");
            return (Criteria) this;
        }

        public Criteria andCreatedGmtIn(List<Date> values) {
            addCriterion("created_gmt in", values, "createdGmt");
            return (Criteria) this;
        }

        public Criteria andCreatedGmtNotIn(List<Date> values) {
            addCriterion("created_gmt not in", values, "createdGmt");
            return (Criteria) this;
        }

        public Criteria andCreatedGmtBetween(Date value1, Date value2) {
            addCriterion("created_gmt between", value1, value2, "createdGmt");
            return (Criteria) this;
        }

        public Criteria andCreatedGmtNotBetween(Date value1, Date value2) {
            addCriterion("created_gmt not between", value1, value2, "createdGmt");
            return (Criteria) this;
        }

        public Criteria andModifiedGmtIsNull() {
            addCriterion("modified_gmt is null");
            return (Criteria) this;
        }

        public Criteria andModifiedGmtIsNotNull() {
            addCriterion("modified_gmt is not null");
            return (Criteria) this;
        }

        public Criteria andModifiedGmtEqualTo(Date value) {
            addCriterion("modified_gmt =", value, "modifiedGmt");
            return (Criteria) this;
        }

        public Criteria andModifiedGmtNotEqualTo(Date value) {
            addCriterion("modified_gmt <>", value, "modifiedGmt");
            return (Criteria) this;
        }

        public Criteria andModifiedGmtGreaterThan(Date value) {
            addCriterion("modified_gmt >", value, "modifiedGmt");
            return (Criteria) this;
        }

        public Criteria andModifiedGmtGreaterThanOrEqualTo(Date value) {
            addCriterion("modified_gmt >=", value, "modifiedGmt");
            return (Criteria) this;
        }

        public Criteria andModifiedGmtLessThan(Date value) {
            addCriterion("modified_gmt <", value, "modifiedGmt");
            return (Criteria) this;
        }

        public Criteria andModifiedGmtLessThanOrEqualTo(Date value) {
            addCriterion("modified_gmt <=", value, "modifiedGmt");
            return (Criteria) this;
        }

        public Criteria andModifiedGmtIn(List<Date> values) {
            addCriterion("modified_gmt in", values, "modifiedGmt");
            return (Criteria) this;
        }

        public Criteria andModifiedGmtNotIn(List<Date> values) {
            addCriterion("modified_gmt not in", values, "modifiedGmt");
            return (Criteria) this;
        }

        public Criteria andModifiedGmtBetween(Date value1, Date value2) {
            addCriterion("modified_gmt between", value1, value2, "modifiedGmt");
            return (Criteria) this;
        }

        public Criteria andModifiedGmtNotBetween(Date value1, Date value2) {
            addCriterion("modified_gmt not between", value1, value2, "modifiedGmt");
            return (Criteria) this;
        }
    }

    /**
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