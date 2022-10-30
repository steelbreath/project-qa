package com.solvd.carina.demo.gui.enums;

public enum HeaderMenuButtonLink {
    NEWS("News"),
    REVIEWS("Reviews"),
    VIDEOS("Videos"),
    FEATURED("Featured"),
    PHONE_FINDER("Phone Finder"),
    DEALS("Deals"),
    MERCH("Merch"),
    COVERAGE("Coverage"),
    CONTACT("Contact");
    private String value;

    HeaderMenuButtonLink(String value){
        this.value = value;
    }

    public  String getValue() {
        return  value;
    }
}
