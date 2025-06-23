public class TextEditor {
    private SpellChecker spellChecker;
    private String language;

    public TextEditor(SpellChecker spellChecker) {
        this.spellChecker = spellChecker;
        System.out.println("Constructor Injection for SpellChecker");
    }

    public void setLanguage(String language) {
        this.language = language;
        System.out.println("Setter Injection for Language");
    }

    public void spellCheck() {
        System.out.println("Language: " + language);
        spellChecker.checkSpelling();
    }
}
