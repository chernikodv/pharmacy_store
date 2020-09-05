package com.fpmi.bsu.pharmacy.criteria;

public enum EmployeeCriteriaParam {
    FIRST_NAME("firstName"),
    LAST_NAME("lastName"),
    MIN_SALARY("minSalary"),
    MAX_SALARY("maxSalary"),
    ORDER_BY("orderBy"),
    DIRECTION("direction");

    private String param;

    public String getParam() {
        return param;
    }

    private EmployeeCriteriaParam(String param) {
        this.param = param;
    }
}
