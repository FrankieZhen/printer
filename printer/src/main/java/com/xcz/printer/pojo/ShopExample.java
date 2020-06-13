package com.xcz.printer.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ShopExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ShopExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andShopNameIsNull() {
            addCriterion("shop_name is null");
            return (Criteria) this;
        }

        public Criteria andShopNameIsNotNull() {
            addCriterion("shop_name is not null");
            return (Criteria) this;
        }

        public Criteria andShopNameEqualTo(String value) {
            addCriterion("shop_name =", value, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameNotEqualTo(String value) {
            addCriterion("shop_name <>", value, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameGreaterThan(String value) {
            addCriterion("shop_name >", value, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameGreaterThanOrEqualTo(String value) {
            addCriterion("shop_name >=", value, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameLessThan(String value) {
            addCriterion("shop_name <", value, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameLessThanOrEqualTo(String value) {
            addCriterion("shop_name <=", value, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameLike(String value) {
            addCriterion("shop_name like", value, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameNotLike(String value) {
            addCriterion("shop_name not like", value, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameIn(List<String> values) {
            addCriterion("shop_name in", values, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameNotIn(List<String> values) {
            addCriterion("shop_name not in", values, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameBetween(String value1, String value2) {
            addCriterion("shop_name between", value1, value2, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameNotBetween(String value1, String value2) {
            addCriterion("shop_name not between", value1, value2, "shopName");
            return (Criteria) this;
        }

        public Criteria andLocationIsNull() {
            addCriterion("location is null");
            return (Criteria) this;
        }

        public Criteria andLocationIsNotNull() {
            addCriterion("location is not null");
            return (Criteria) this;
        }

        public Criteria andLocationEqualTo(String value) {
            addCriterion("location =", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationNotEqualTo(String value) {
            addCriterion("location <>", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationGreaterThan(String value) {
            addCriterion("location >", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationGreaterThanOrEqualTo(String value) {
            addCriterion("location >=", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationLessThan(String value) {
            addCriterion("location <", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationLessThanOrEqualTo(String value) {
            addCriterion("location <=", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationLike(String value) {
            addCriterion("location like", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationNotLike(String value) {
            addCriterion("location not like", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationIn(List<String> values) {
            addCriterion("location in", values, "location");
            return (Criteria) this;
        }

        public Criteria andLocationNotIn(List<String> values) {
            addCriterion("location not in", values, "location");
            return (Criteria) this;
        }

        public Criteria andLocationBetween(String value1, String value2) {
            addCriterion("location between", value1, value2, "location");
            return (Criteria) this;
        }

        public Criteria andLocationNotBetween(String value1, String value2) {
            addCriterion("location not between", value1, value2, "location");
            return (Criteria) this;
        }

        public Criteria andPropertyIsNull() {
            addCriterion("property is null");
            return (Criteria) this;
        }

        public Criteria andPropertyIsNotNull() {
            addCriterion("property is not null");
            return (Criteria) this;
        }

        public Criteria andPropertyEqualTo(Integer value) {
            addCriterion("property =", value, "property");
            return (Criteria) this;
        }

        public Criteria andPropertyNotEqualTo(Integer value) {
            addCriterion("property <>", value, "property");
            return (Criteria) this;
        }

        public Criteria andPropertyGreaterThan(Integer value) {
            addCriterion("property >", value, "property");
            return (Criteria) this;
        }

        public Criteria andPropertyGreaterThanOrEqualTo(Integer value) {
            addCriterion("property >=", value, "property");
            return (Criteria) this;
        }

        public Criteria andPropertyLessThan(Integer value) {
            addCriterion("property <", value, "property");
            return (Criteria) this;
        }

        public Criteria andPropertyLessThanOrEqualTo(Integer value) {
            addCriterion("property <=", value, "property");
            return (Criteria) this;
        }

        public Criteria andPropertyIn(List<Integer> values) {
            addCriterion("property in", values, "property");
            return (Criteria) this;
        }

        public Criteria andPropertyNotIn(List<Integer> values) {
            addCriterion("property not in", values, "property");
            return (Criteria) this;
        }

        public Criteria andPropertyBetween(Integer value1, Integer value2) {
            addCriterion("property between", value1, value2, "property");
            return (Criteria) this;
        }

        public Criteria andPropertyNotBetween(Integer value1, Integer value2) {
            addCriterion("property not between", value1, value2, "property");
            return (Criteria) this;
        }

        public Criteria andPictureIsNull() {
            addCriterion("picture is null");
            return (Criteria) this;
        }

        public Criteria andPictureIsNotNull() {
            addCriterion("picture is not null");
            return (Criteria) this;
        }

        public Criteria andPictureEqualTo(String value) {
            addCriterion("picture =", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureNotEqualTo(String value) {
            addCriterion("picture <>", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureGreaterThan(String value) {
            addCriterion("picture >", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureGreaterThanOrEqualTo(String value) {
            addCriterion("picture >=", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureLessThan(String value) {
            addCriterion("picture <", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureLessThanOrEqualTo(String value) {
            addCriterion("picture <=", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureLike(String value) {
            addCriterion("picture like", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureNotLike(String value) {
            addCriterion("picture not like", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureIn(List<String> values) {
            addCriterion("picture in", values, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureNotIn(List<String> values) {
            addCriterion("picture not in", values, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureBetween(String value1, String value2) {
            addCriterion("picture between", value1, value2, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureNotBetween(String value1, String value2) {
            addCriterion("picture not between", value1, value2, "picture");
            return (Criteria) this;
        }

        public Criteria andProductIsNull() {
            addCriterion("product is null");
            return (Criteria) this;
        }

        public Criteria andProductIsNotNull() {
            addCriterion("product is not null");
            return (Criteria) this;
        }

        public Criteria andProductEqualTo(String value) {
            addCriterion("product =", value, "product");
            return (Criteria) this;
        }

        public Criteria andProductNotEqualTo(String value) {
            addCriterion("product <>", value, "product");
            return (Criteria) this;
        }

        public Criteria andProductGreaterThan(String value) {
            addCriterion("product >", value, "product");
            return (Criteria) this;
        }

        public Criteria andProductGreaterThanOrEqualTo(String value) {
            addCriterion("product >=", value, "product");
            return (Criteria) this;
        }

        public Criteria andProductLessThan(String value) {
            addCriterion("product <", value, "product");
            return (Criteria) this;
        }

        public Criteria andProductLessThanOrEqualTo(String value) {
            addCriterion("product <=", value, "product");
            return (Criteria) this;
        }

        public Criteria andProductLike(String value) {
            addCriterion("product like", value, "product");
            return (Criteria) this;
        }

        public Criteria andProductNotLike(String value) {
            addCriterion("product not like", value, "product");
            return (Criteria) this;
        }

        public Criteria andProductIn(List<String> values) {
            addCriterion("product in", values, "product");
            return (Criteria) this;
        }

        public Criteria andProductNotIn(List<String> values) {
            addCriterion("product not in", values, "product");
            return (Criteria) this;
        }

        public Criteria andProductBetween(String value1, String value2) {
            addCriterion("product between", value1, value2, "product");
            return (Criteria) this;
        }

        public Criteria andProductNotBetween(String value1, String value2) {
            addCriterion("product not between", value1, value2, "product");
            return (Criteria) this;
        }

        public Criteria andPropriceIsNull() {
            addCriterion("proPrice is null");
            return (Criteria) this;
        }

        public Criteria andPropriceIsNotNull() {
            addCriterion("proPrice is not null");
            return (Criteria) this;
        }

        public Criteria andPropriceEqualTo(String value) {
            addCriterion("proPrice =", value, "proprice");
            return (Criteria) this;
        }

        public Criteria andPropriceNotEqualTo(String value) {
            addCriterion("proPrice <>", value, "proprice");
            return (Criteria) this;
        }

        public Criteria andPropriceGreaterThan(String value) {
            addCriterion("proPrice >", value, "proprice");
            return (Criteria) this;
        }

        public Criteria andPropriceGreaterThanOrEqualTo(String value) {
            addCriterion("proPrice >=", value, "proprice");
            return (Criteria) this;
        }

        public Criteria andPropriceLessThan(String value) {
            addCriterion("proPrice <", value, "proprice");
            return (Criteria) this;
        }

        public Criteria andPropriceLessThanOrEqualTo(String value) {
            addCriterion("proPrice <=", value, "proprice");
            return (Criteria) this;
        }

        public Criteria andPropriceLike(String value) {
            addCriterion("proPrice like", value, "proprice");
            return (Criteria) this;
        }

        public Criteria andPropriceNotLike(String value) {
            addCriterion("proPrice not like", value, "proprice");
            return (Criteria) this;
        }

        public Criteria andPropriceIn(List<String> values) {
            addCriterion("proPrice in", values, "proprice");
            return (Criteria) this;
        }

        public Criteria andPropriceNotIn(List<String> values) {
            addCriterion("proPrice not in", values, "proprice");
            return (Criteria) this;
        }

        public Criteria andPropriceBetween(String value1, String value2) {
            addCriterion("proPrice between", value1, value2, "proprice");
            return (Criteria) this;
        }

        public Criteria andPropriceNotBetween(String value1, String value2) {
            addCriterion("proPrice not between", value1, value2, "proprice");
            return (Criteria) this;
        }

        public Criteria andIscolorfulIsNull() {
            addCriterion("isColorful is null");
            return (Criteria) this;
        }

        public Criteria andIscolorfulIsNotNull() {
            addCriterion("isColorful is not null");
            return (Criteria) this;
        }

        public Criteria andIscolorfulEqualTo(Integer value) {
            addCriterion("isColorful =", value, "iscolorful");
            return (Criteria) this;
        }

        public Criteria andIscolorfulNotEqualTo(Integer value) {
            addCriterion("isColorful <>", value, "iscolorful");
            return (Criteria) this;
        }

        public Criteria andIscolorfulGreaterThan(Integer value) {
            addCriterion("isColorful >", value, "iscolorful");
            return (Criteria) this;
        }

        public Criteria andIscolorfulGreaterThanOrEqualTo(Integer value) {
            addCriterion("isColorful >=", value, "iscolorful");
            return (Criteria) this;
        }

        public Criteria andIscolorfulLessThan(Integer value) {
            addCriterion("isColorful <", value, "iscolorful");
            return (Criteria) this;
        }

        public Criteria andIscolorfulLessThanOrEqualTo(Integer value) {
            addCriterion("isColorful <=", value, "iscolorful");
            return (Criteria) this;
        }

        public Criteria andIscolorfulIn(List<Integer> values) {
            addCriterion("isColorful in", values, "iscolorful");
            return (Criteria) this;
        }

        public Criteria andIscolorfulNotIn(List<Integer> values) {
            addCriterion("isColorful not in", values, "iscolorful");
            return (Criteria) this;
        }

        public Criteria andIscolorfulBetween(Integer value1, Integer value2) {
            addCriterion("isColorful between", value1, value2, "iscolorful");
            return (Criteria) this;
        }

        public Criteria andIscolorfulNotBetween(Integer value1, Integer value2) {
            addCriterion("isColorful not between", value1, value2, "iscolorful");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andLatIsNull() {
            addCriterion("lat is null");
            return (Criteria) this;
        }

        public Criteria andLatIsNotNull() {
            addCriterion("lat is not null");
            return (Criteria) this;
        }

        public Criteria andLatEqualTo(BigDecimal value) {
            addCriterion("lat =", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatNotEqualTo(BigDecimal value) {
            addCriterion("lat <>", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatGreaterThan(BigDecimal value) {
            addCriterion("lat >", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("lat >=", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatLessThan(BigDecimal value) {
            addCriterion("lat <", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatLessThanOrEqualTo(BigDecimal value) {
            addCriterion("lat <=", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatIn(List<BigDecimal> values) {
            addCriterion("lat in", values, "lat");
            return (Criteria) this;
        }

        public Criteria andLatNotIn(List<BigDecimal> values) {
            addCriterion("lat not in", values, "lat");
            return (Criteria) this;
        }

        public Criteria andLatBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("lat between", value1, value2, "lat");
            return (Criteria) this;
        }

        public Criteria andLatNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("lat not between", value1, value2, "lat");
            return (Criteria) this;
        }

        public Criteria andLngIsNull() {
            addCriterion("lng is null");
            return (Criteria) this;
        }

        public Criteria andLngIsNotNull() {
            addCriterion("lng is not null");
            return (Criteria) this;
        }

        public Criteria andLngEqualTo(BigDecimal value) {
            addCriterion("lng =", value, "lng");
            return (Criteria) this;
        }

        public Criteria andLngNotEqualTo(BigDecimal value) {
            addCriterion("lng <>", value, "lng");
            return (Criteria) this;
        }

        public Criteria andLngGreaterThan(BigDecimal value) {
            addCriterion("lng >", value, "lng");
            return (Criteria) this;
        }

        public Criteria andLngGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("lng >=", value, "lng");
            return (Criteria) this;
        }

        public Criteria andLngLessThan(BigDecimal value) {
            addCriterion("lng <", value, "lng");
            return (Criteria) this;
        }

        public Criteria andLngLessThanOrEqualTo(BigDecimal value) {
            addCriterion("lng <=", value, "lng");
            return (Criteria) this;
        }

        public Criteria andLngIn(List<BigDecimal> values) {
            addCriterion("lng in", values, "lng");
            return (Criteria) this;
        }

        public Criteria andLngNotIn(List<BigDecimal> values) {
            addCriterion("lng not in", values, "lng");
            return (Criteria) this;
        }

        public Criteria andLngBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("lng between", value1, value2, "lng");
            return (Criteria) this;
        }

        public Criteria andLngNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("lng not between", value1, value2, "lng");
            return (Criteria) this;
        }

        public Criteria andSinglePurePriceIsNull() {
            addCriterion("single_pure_price is null");
            return (Criteria) this;
        }

        public Criteria andSinglePurePriceIsNotNull() {
            addCriterion("single_pure_price is not null");
            return (Criteria) this;
        }

        public Criteria andSinglePurePriceEqualTo(BigDecimal value) {
            addCriterion("single_pure_price =", value, "singlePurePrice");
            return (Criteria) this;
        }

        public Criteria andSinglePurePriceNotEqualTo(BigDecimal value) {
            addCriterion("single_pure_price <>", value, "singlePurePrice");
            return (Criteria) this;
        }

        public Criteria andSinglePurePriceGreaterThan(BigDecimal value) {
            addCriterion("single_pure_price >", value, "singlePurePrice");
            return (Criteria) this;
        }

        public Criteria andSinglePurePriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("single_pure_price >=", value, "singlePurePrice");
            return (Criteria) this;
        }

        public Criteria andSinglePurePriceLessThan(BigDecimal value) {
            addCriterion("single_pure_price <", value, "singlePurePrice");
            return (Criteria) this;
        }

        public Criteria andSinglePurePriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("single_pure_price <=", value, "singlePurePrice");
            return (Criteria) this;
        }

        public Criteria andSinglePurePriceIn(List<BigDecimal> values) {
            addCriterion("single_pure_price in", values, "singlePurePrice");
            return (Criteria) this;
        }

        public Criteria andSinglePurePriceNotIn(List<BigDecimal> values) {
            addCriterion("single_pure_price not in", values, "singlePurePrice");
            return (Criteria) this;
        }

        public Criteria andSinglePurePriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("single_pure_price between", value1, value2, "singlePurePrice");
            return (Criteria) this;
        }

        public Criteria andSinglePurePriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("single_pure_price not between", value1, value2, "singlePurePrice");
            return (Criteria) this;
        }

        public Criteria andDoublePurePriceIsNull() {
            addCriterion("double_pure_price is null");
            return (Criteria) this;
        }

        public Criteria andDoublePurePriceIsNotNull() {
            addCriterion("double_pure_price is not null");
            return (Criteria) this;
        }

        public Criteria andDoublePurePriceEqualTo(BigDecimal value) {
            addCriterion("double_pure_price =", value, "doublePurePrice");
            return (Criteria) this;
        }

        public Criteria andDoublePurePriceNotEqualTo(BigDecimal value) {
            addCriterion("double_pure_price <>", value, "doublePurePrice");
            return (Criteria) this;
        }

        public Criteria andDoublePurePriceGreaterThan(BigDecimal value) {
            addCriterion("double_pure_price >", value, "doublePurePrice");
            return (Criteria) this;
        }

        public Criteria andDoublePurePriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("double_pure_price >=", value, "doublePurePrice");
            return (Criteria) this;
        }

        public Criteria andDoublePurePriceLessThan(BigDecimal value) {
            addCriterion("double_pure_price <", value, "doublePurePrice");
            return (Criteria) this;
        }

        public Criteria andDoublePurePriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("double_pure_price <=", value, "doublePurePrice");
            return (Criteria) this;
        }

        public Criteria andDoublePurePriceIn(List<BigDecimal> values) {
            addCriterion("double_pure_price in", values, "doublePurePrice");
            return (Criteria) this;
        }

        public Criteria andDoublePurePriceNotIn(List<BigDecimal> values) {
            addCriterion("double_pure_price not in", values, "doublePurePrice");
            return (Criteria) this;
        }

        public Criteria andDoublePurePriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("double_pure_price between", value1, value2, "doublePurePrice");
            return (Criteria) this;
        }

        public Criteria andDoublePurePriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("double_pure_price not between", value1, value2, "doublePurePrice");
            return (Criteria) this;
        }

        public Criteria andSingleColorPriceIsNull() {
            addCriterion("single_color_price is null");
            return (Criteria) this;
        }

        public Criteria andSingleColorPriceIsNotNull() {
            addCriterion("single_color_price is not null");
            return (Criteria) this;
        }

        public Criteria andSingleColorPriceEqualTo(BigDecimal value) {
            addCriterion("single_color_price =", value, "singleColorPrice");
            return (Criteria) this;
        }

        public Criteria andSingleColorPriceNotEqualTo(BigDecimal value) {
            addCriterion("single_color_price <>", value, "singleColorPrice");
            return (Criteria) this;
        }

        public Criteria andSingleColorPriceGreaterThan(BigDecimal value) {
            addCriterion("single_color_price >", value, "singleColorPrice");
            return (Criteria) this;
        }

        public Criteria andSingleColorPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("single_color_price >=", value, "singleColorPrice");
            return (Criteria) this;
        }

        public Criteria andSingleColorPriceLessThan(BigDecimal value) {
            addCriterion("single_color_price <", value, "singleColorPrice");
            return (Criteria) this;
        }

        public Criteria andSingleColorPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("single_color_price <=", value, "singleColorPrice");
            return (Criteria) this;
        }

        public Criteria andSingleColorPriceIn(List<BigDecimal> values) {
            addCriterion("single_color_price in", values, "singleColorPrice");
            return (Criteria) this;
        }

        public Criteria andSingleColorPriceNotIn(List<BigDecimal> values) {
            addCriterion("single_color_price not in", values, "singleColorPrice");
            return (Criteria) this;
        }

        public Criteria andSingleColorPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("single_color_price between", value1, value2, "singleColorPrice");
            return (Criteria) this;
        }

        public Criteria andSingleColorPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("single_color_price not between", value1, value2, "singleColorPrice");
            return (Criteria) this;
        }

        public Criteria andDoubleColorPriceIsNull() {
            addCriterion("double_color_price is null");
            return (Criteria) this;
        }

        public Criteria andDoubleColorPriceIsNotNull() {
            addCriterion("double_color_price is not null");
            return (Criteria) this;
        }

        public Criteria andDoubleColorPriceEqualTo(BigDecimal value) {
            addCriterion("double_color_price =", value, "doubleColorPrice");
            return (Criteria) this;
        }

        public Criteria andDoubleColorPriceNotEqualTo(BigDecimal value) {
            addCriterion("double_color_price <>", value, "doubleColorPrice");
            return (Criteria) this;
        }

        public Criteria andDoubleColorPriceGreaterThan(BigDecimal value) {
            addCriterion("double_color_price >", value, "doubleColorPrice");
            return (Criteria) this;
        }

        public Criteria andDoubleColorPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("double_color_price >=", value, "doubleColorPrice");
            return (Criteria) this;
        }

        public Criteria andDoubleColorPriceLessThan(BigDecimal value) {
            addCriterion("double_color_price <", value, "doubleColorPrice");
            return (Criteria) this;
        }

        public Criteria andDoubleColorPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("double_color_price <=", value, "doubleColorPrice");
            return (Criteria) this;
        }

        public Criteria andDoubleColorPriceIn(List<BigDecimal> values) {
            addCriterion("double_color_price in", values, "doubleColorPrice");
            return (Criteria) this;
        }

        public Criteria andDoubleColorPriceNotIn(List<BigDecimal> values) {
            addCriterion("double_color_price not in", values, "doubleColorPrice");
            return (Criteria) this;
        }

        public Criteria andDoubleColorPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("double_color_price between", value1, value2, "doubleColorPrice");
            return (Criteria) this;
        }

        public Criteria andDoubleColorPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("double_color_price not between", value1, value2, "doubleColorPrice");
            return (Criteria) this;
        }

        public Criteria andDeliverPriceIsNull() {
            addCriterion("deliver_price is null");
            return (Criteria) this;
        }

        public Criteria andDeliverPriceIsNotNull() {
            addCriterion("deliver_price is not null");
            return (Criteria) this;
        }

        public Criteria andDeliverPriceEqualTo(BigDecimal value) {
            addCriterion("deliver_price =", value, "deliverPrice");
            return (Criteria) this;
        }

        public Criteria andDeliverPriceNotEqualTo(BigDecimal value) {
            addCriterion("deliver_price <>", value, "deliverPrice");
            return (Criteria) this;
        }

        public Criteria andDeliverPriceGreaterThan(BigDecimal value) {
            addCriterion("deliver_price >", value, "deliverPrice");
            return (Criteria) this;
        }

        public Criteria andDeliverPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("deliver_price >=", value, "deliverPrice");
            return (Criteria) this;
        }

        public Criteria andDeliverPriceLessThan(BigDecimal value) {
            addCriterion("deliver_price <", value, "deliverPrice");
            return (Criteria) this;
        }

        public Criteria andDeliverPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("deliver_price <=", value, "deliverPrice");
            return (Criteria) this;
        }

        public Criteria andDeliverPriceIn(List<BigDecimal> values) {
            addCriterion("deliver_price in", values, "deliverPrice");
            return (Criteria) this;
        }

        public Criteria andDeliverPriceNotIn(List<BigDecimal> values) {
            addCriterion("deliver_price not in", values, "deliverPrice");
            return (Criteria) this;
        }

        public Criteria andDeliverPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("deliver_price between", value1, value2, "deliverPrice");
            return (Criteria) this;
        }

        public Criteria andDeliverPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("deliver_price not between", value1, value2, "deliverPrice");
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