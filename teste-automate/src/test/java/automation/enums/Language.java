package automation.enums;


public enum Language {
    EN("English"),
    FR("Française"),
    RO("Română"),
    HU("Magyar");

    private String displayName;

    private Language(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

}
