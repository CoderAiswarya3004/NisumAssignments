
class SpellChecker {
public void checkSpelling() {
        System.out.println("Spell checking in progress...");
    }
}

class TextEditor {
    private SpellChecker spellChecker;
  
    public TextEditor(SpellChecker spellChecker) {
        this.spellChecker = spellChecker;
        System.out.println("Constructor Injection used.");
    }

    public void setSpellChecker(SpellChecker spellChecker) {
        this.spellChecker = spellChecker;
        System.out.println("Setter Injection used.");
    }

    public void performSpellCheck() {
        if (spellChecker != null) {
            spellChecker.checkSpelling();
        } else {
            System.out.println("No SpellChecker available.");
        }
    }

    public static void main(String[] args) {
       
        SpellChecker sc1 = new SpellChecker();
        TextEditor editor1 = new TextEditor(sc1);
        editor1.performSpellCheck();
      
        TextEditor editor2 = new TextEditor(null);  
        SpellChecker sc2 = new SpellChecker();
        editor2.setSpellChecker(sc2);
        editor2.performSpellCheck();
    }
}
