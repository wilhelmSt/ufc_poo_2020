public class Fone {
    private String label;
    private String number;

    public Fone(String label, int number) {
        if(validate(number)) {
            this.label = label;
        } else {
            System.out.println("O numero esta errado.");
        }
        
    }

    public boolean validate(int number) {
        if(number > 0) {
            this.number = Integer.toString(number);
            return true;
        }
        return false;
    }

    public String getLabel() {return this.label;}
    public String getNumber() {return this.number;}

    public String toString() {
        return this.label + ":" + this.number;
    }
}
