public class Venda {
    private Pessoa cliente;
    private Evento evento;
    private Setor setor;
    private double valor;

    public Venda(Pessoa cliente, Evento evento, Setor setor, double valor) {
        this.cliente = cliente;
        this.evento = evento;
        this.setor = setor;
        this.valor = valor;
    }

    public Pessoa getCliente() {return this.cliente;}
    public Evento getEvento() {return this.evento;}
    public Setor getSetor() {return this.setor;}
    public double getValor() {return this.valor;}

    public String toString() {
        return "[ " + this.cliente.getNome() + ", " + this.evento.getNome() + ", " + this.setor.getNome() + " ]"; 
    }
}
