public class Fone {
    public String id;
    public String number;

    public Fone(String idC, String numberC){
        this.id = idC;
        if(validateNumber(numberC)) {
            this.number = numberC;
        } else {
            System.out.println("#ERRO# O numero nao eh valido");
        }
        
    }

    public boolean validateNumber(String numberC) {
        for(int i = 0; i < numberC.length(); i++) {
            if(numberC.charAt(i) < '0' && numberC.charAt(i) > '9') {
                return false;
            }
        }
        return true;
    }

    // Function return String
    public String toString() {
        return this.id + ":" + this.number;
    }
}
