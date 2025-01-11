package automation.enums;


public enum Language {
    EN("English", "expected_text_en.properties"),
    FR("Francais", "expected_text_fr.properties"),
    RO("Romana", "expected_text_ro.properties"),
    HU("Hungarian", "expected_text_hu.properties");

    private String displayName;
    private String textsFile;

    private Language(String displayName, String textsFile) {
        this.displayName = displayName;
        this.textsFile = textsFile;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getTextsFile() {
        return textsFile;
    }

}
