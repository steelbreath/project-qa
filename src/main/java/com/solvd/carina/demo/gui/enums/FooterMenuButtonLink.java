package com.solvd.carina.demo.gui.enums;

public enum FooterMenuButtonLink {
    NEWS("News"),
    REVIEWS("Reviews"),
    Compare("Compare"),
    Coverage("Coverage"),
    Glossary("Glossary"),
    FAQ("FAQ"),
    RSS_FEED("RSS feed"),
    YOUTUBE("Youtube"),
    FACEBOOK ("Facebook"),
    TWITTER ("Twitter"),
    INSTAGRAM ("Instagram"),
    GSM_ARENA_COM("GSMArena.com"),
    MOBILE_VERSION("Mobile version"),
    ANDROID_APP("Android app"),
    TOOLS("Tools"),
    CONTACT_US("Contact us"),
    MERCH_STORE("Merch store"),
    PRIVACY("Privacy"),
    TERMS_OF_USE("Terms of use");
    private String value;

    FooterMenuButtonLink(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
