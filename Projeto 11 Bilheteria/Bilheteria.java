import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;

public class Bilheteria {
    private ArrayList<Venda> repVendas;
    private Map<String, Pessoa> repPessoas;
    private Map<String, Evento> repEvento;
    private double caixa;

    public Bilheteria() {
        this.repPessoas = new TreeMap<>();
        this.repEvento = new TreeMap<>();
        this.repVendas = new ArrayList<>();
        this.caixa = 0;
    }

    public void vender(String idCliente, String idEvento, String idSetor) {
        boolean pessoaV = false;
        boolean eventoV = false;
        boolean setorV = false;

        for (String client : this.repPessoas.keySet()) {
            if (client.equals(idCliente)) {
                pessoaV = true;
            }
        }

        for (String event : this.repEvento.keySet()) {
            if (event.equals(idEvento)) {
                eventoV = true;

                for (String sector : this.repEvento.get(event).getRepSetores().keySet()) {
                    if (sector.equals(idSetor)) {
                        setorV = true;
                    }
                }
            }
        }

        if (pessoaV && eventoV && setorV) {
            if (this.repPessoas.get(idCliente).getMeia()) {
                Venda venda = new Venda(this.repPessoas.get(idCliente), this.repEvento.get(idEvento),
                        this.repEvento.get(idEvento).getRepSetores().get(idSetor),
                        (this.repEvento.get(idEvento).getRepSetores().get(idSetor).getPreco()) / 2);
                this.repVendas.add(venda);
                this.caixa += this.repEvento.get(idEvento).getRepSetores().get(idSetor).getPreco() / 2;
            } else {
                Venda venda = new Venda(this.repPessoas.get(idCliente), this.repEvento.get(idEvento),
                        this.repEvento.get(idEvento).getRepSetores().get(idSetor),
                        this.repEvento.get(idEvento).getRepSetores().get(idSetor).getPreco());
                this.repVendas.add(venda);
                this.caixa += this.repEvento.get(idEvento).getRepSetores().get(idSetor).getPreco();
            }

        }
    }

    public String showVendas() {
        for (Venda venda : this.repVendas) {
            System.out.println(venda);
        }
        System.out.print("R$ " + this.caixa + "0");
        return "";
    }

    public String showPessoas() {
        for (Entry<String, Pessoa> entry : this.repPessoas.entrySet()) {
            System.out.println(entry.getValue());
        }
        return "";
    }

    public String showEventos() {
        for(Entry<String, Evento> entry : this.repEvento.entrySet()) {
            System.out.println(entry.getValue());
        }
        return "";
    }

    public void addPessoa(Pessoa pessoa) {
        for(String nome : this.repPessoas.keySet()) {
            if(nome.equals(pessoa.getNome())) {
                System.out.println("fail: pessoa " + nome + " ja existe");
            }
        }

        this.repPessoas.put(pessoa.getNome(), pessoa);
    }

    public void addEvento(Evento evento) {
        for(String nome : this.repEvento.keySet()) {
            if(nome.equals(evento.getNome())) {
                System.out.println("fail: evento " + nome + " ja existe");
            }
        }

        this.repEvento.put(evento.getNome(), evento);
    }

    public void addSetor(String idEvento, Setor setor) {
        for(Entry<String, Evento> entry : this.repEvento.entrySet()) {
            if(entry.getValue().getNome().equals(setor.getNome())) {
                System.out.println("fail: setor " + setor.getNome() + " ja existe");
            }
        }

        for(String id : this.repEvento.keySet()) {
            if(id.equals(idEvento)) {
                repEvento.get(id).addSetor(setor);
                return;
            }
        }
        System.out.println("fail: o evento " + idEvento + " nao existe.");

    }

    public double getCaixa() {return this.caixa;}

    public boolean verifError() {
        return false;
    }
}
