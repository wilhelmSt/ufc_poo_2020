enum Moeda {
    M10(0.10, 1),
    M25(0.25, 2),
    M50(0.50, 3),
    M100(1.00, 4);

    double valor;
    int volume;

    Moeda(double valor, int volume) {
        this.valor = valor;
        this.volume = volume;
    }

    public String toString() {
        return "Valor: " + valor + " Volume: " + volume;
    }
}

class Item {
    public String descricao;
    public int volume;

    public Item(String descricao, int volume) {
        this.descricao = descricao;
        this.volume = volume;
    }
}

class Porco {
    public String itens;
    public double valor;
    public int volume;
    public int volumeMax;
    public boolean estaQuebrado;

    public Porco(int volumeMax) {
        this.volumeMax = volumeMax;
        this.estaQuebrado = false;
        this.valor = 0.0;
        this.itens = null;
        this.volume = 0;
    }

    public void addMoeda(Moeda moeda) {
        if(estaQuebrado == false) {
            this.valor += moeda.valor;
            this.volume += moeda.volume;
        } else {
            System.out.println("O cofre esta quebrado!");
        }
    }
    public void addItem(Item item) {
        if(estaQuebrado == false) {
            this.volume = item.volume;
            if(this.itens == null) {
                this.itens = item.descricao;
            } else {
                this.itens += ", " + item.descricao;
            }
        } else {
            System.out.println("O cofre esta quebrado!");
        }
    }
    public void quebrar() {
        if(estaQuebrado == false) {
            this.estaQuebrado = true;
        } else {
            System.out.println("O cofre ja esta quebrado.");
        }
    }
    public double pegarMoedas() {
        if(estaQuebrado == true) {
            double aux = this.valor;
            this.valor = 0.0;
            return aux;
        } else {
            System.out.println("Voce deve quebrar o cofre primeiro.");
        }
        return 0;
    }
    public String pegarItens() {
        if(estaQuebrado == true) {
            String aux = this.itens;
            this.itens = null;
            return aux;
        } else {
            System.out.println("Voce deve quebrar o cofre primeiro.");
        }
        return null;
    }

    public String toString() {
        return "Item: " +  this.itens + " Moedas: " + this.valor + " Volume: " + this.volume + "/" + this.volumeMax + " EQ: " + this.estaQuebrado;
    }
}

class Cofre {
    public static void main(String[] args) {
        Porco porco = new Porco(20);
        System.out.println(porco); //I:() M:0 V:0/20 EQ:false
        porco.addMoeda(Moeda.M10);
        porco.addMoeda(Moeda.M50);
        System.out.println(porco); //I:() M:0.6 V:4/20 EQ:false

        porco.addItem(new Item("ouro", 3));
        System.out.println(porco); //I:(ouro) M:0.6 V:7/20 EQ:false

        porco.addItem(new Item("passaporte", 2));
        System.out.println(porco); //I:(ouro, passaporte) M:0.6 V:9/20 EQ:false

        porco.pegarItens();  //Voce deve quebrar o cofre primeiro
        porco.pegarMoedas(); //Voce deve quebrar o cofre primeiro
        System.out.println(porco); //I:(ouro, passaporte) M:0.6 V:9/20 EQ:false

        porco.quebrar();
        porco.quebrar(); //O cofre ja esta quebrado

        System.out.println(porco.pegarItens());  //ouro, passaporte
        System.out.println(porco.pegarMoedas()); //0.6
        System.out.println(porco); //I:() M:0.0 V:9/20 EQ:true
    }
}