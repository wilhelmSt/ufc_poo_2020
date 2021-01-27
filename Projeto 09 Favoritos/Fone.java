public class Fone {
    private String label;
    private int number;

    public Fone(String label, int number) {
        
        if(validateNumber(number)) {
            setLabel(label);
            setNumber(number);
        } else {
            System.out.println("#ERRO# Voce inseriu um numero errado!");
        }
        
    }

    private boolean validateNumber(int number) {
        if(number > 0 && number < 10000) {
            return true;
        }
        return false;
    }

    public String toString() {
        return getLabel() + ":" + getNumber();
    }

    // Setters && Getters
    public void setLabel(String label){this.label = label;}
    public String getLabel(){return this.label;}
    public void setNumber(int number){this.number = number;}
    public int getNumber(){return this.number;}
}