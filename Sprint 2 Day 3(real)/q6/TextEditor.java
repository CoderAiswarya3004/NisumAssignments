public class TextEditor {
    private SpellChecker spellChecker;

    public TextEditor() {
        System.out.println("TextEditor bean created.");
    }

    public void setSpellChecker(SpellChecker spellChecker) {
        this.spellChecker = spellChecker;
        System.out.println("Setter Injection applied.");
    }

    public void spellCheck() {
        spellChecker.checkSpelling();
    }
}
