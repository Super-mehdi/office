package com.mehdi.office;

public enum Dept {
    CUSTOMER_SERVICE("Customer service"),
    HR("Human Ressources"),
    SALES("Sales"),
    ACCOUNTING("Accounting"),
    QA("Quality assurance"),
    RECEPTION("Reception"),
    MANAGEMENT("Management");

    private final String value ;

    Dept(String s){
        this.value=s;
    }
    public String getValue() {
        return value;
    }

}
