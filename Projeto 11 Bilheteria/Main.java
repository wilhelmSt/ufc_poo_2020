public class Main {
    public static void main(String[] args) throws Exception {
        Bilheteria bilheteria = new Bilheteria();
        bilheteria.addPessoa(new Pessoa("steve", false));
        bilheteria.addPessoa(new Pessoa("tony", true));

        bilheteria.addEvento(new Evento("orappa"));
        bilheteria.addSetor("orappa", new Setor("front", 70.0, 5));
        bilheteria.addSetor("orappa", new Setor("pista", 35.0, 3));

        bilheteria.addEvento(new Evento("discoteca"));
        bilheteria.addSetor("discoteca", new Setor("camarote", 100.0, 5));
        bilheteria.addSetor("discoteca", new Setor("arquibancade", 50.0, 2));

        bilheteria.vender("tony", "orappa", "front");

        bilheteria.showPessoas();
        bilheteria.showEventos();
        bilheteria.showVendas();

        
    }
}
