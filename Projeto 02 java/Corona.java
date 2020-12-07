import java.util.Scanner;
import java.util.Random;

class CoronaVirus {
    int taxaTransmissao;
    int nivelDoenca;

    CoronaVirus() {
        Random nivel = new Random();
        this.taxaTransmissao = 100;
        this.nivelDoenca = nivel.nextInt(4);
    }

}

class Pessoa {
    int idade;
    boolean grupoRisco;
    boolean mascara;
    boolean doente;
    boolean vacinado;
    CoronaVirus nivelDoenca;
    boolean imune;

    Pessoa(int idadeP, boolean grupoRiscoP, boolean mascaraP, boolean doenteP, CoronaVirus virus) {
        if(grupoRiscoP == false && idadeP >= 60) {
            grupoRiscoP = true;
        }

        this.idade = idadeP;
        this.grupoRisco = grupoRiscoP;
        this.mascara = mascaraP;
        this.doente = doenteP;
        this.vacinado = false;
        this.nivelDoenca = virus.nivelDoenca;
        this.imune = false;
    }

    void contatoPessoal(Pessoa other, CoronaVirus virus) {
        if(this.doente && other.doente) {
            System.out.println("Os dois estao doentes, deviam estar em isolamento.");
        } else if (this.doente || other.doente) {
            if(this.mascara == false && other.mascara == false) {
                this.doente = true;
                other.doente = true;
            } else if (this.mascara == true && other.mascara == true) {
                Random taxa = new Random();
                if(this.doente) {
                    if(taxa.nextInt(100) <= virus.taxaTransmissao-80) {
                        other.doente = true;
                    }
                } else if (other.doente) {
                    if(taxa.nextInt(100) <= virus.taxaTransmissao-80) {
                        this.doente = true;
                    }
                }
            } else {
                Random taxa = new Random();
                if(this.doente) {
                    if(taxa.nextInt(100) <= virus.taxaTransmissao-35) {
                        other.doente = true;
                    }
                } else if (other.doente) {
                    if(taxa.nextInt(100) <= virus.taxaTransmissao-35) {
                        this.doente = true;
                    }
                }
            }
        }

    }

    void receberVacina(Pessoa humano, Vacina vacinar) {
        if(this.doente) {
            System.out.println("Voce nao pode tomar a vacina doente.");
        } else {
            Random test = new Random();
            this.vacinado = true;
            int resultadoVacina = test.nextInt(100) + 1;
            resultadoVacina = resultadoVacina - vacinar.nivelEficacia;

            if(resultadoVacina > 5) {
                this.imune = true;
            }
        }
    }

    void tratamento(Pessoa humano) {
        if(this.doente) {
            if(this.nivelDoenca == 0) {
                System.out.println("Voce esta doente porem nao apresenta sintomas, nao precisa de tratamento no momento.");
            } else if (this.nivelDoenca == 1) {
                System.out.println("Voce so esta com falta de ofato e paladar, recebera um tratamento leve.");
            } else if (this.nivelDoenca == 2) {
                System.out.println("Voce tem um pouco de febre, fadiga alem da perca de ofato e paladar, recebera um tratamento mediano.");
            } else {
                System.out.println("Voce tem dificuldade de respiracao, recebera um tratamente intensivo.");
            }
        }
    }

    public String toString() {
        return "Idade: " + idade +  "\nDoente: " + doente;
    }

}

class Vacina {
    int nivelEficacia;

    Vacina() {
        this.nivelEficacia = 95;
    }

    public String toString() {
        return "Nivel de eficacia da vicina e: " + nivelEficacia + "%";
    }
}

public class Main {
    static int Escolha() {
        System.out.println("+---------------------------+");
        System.out.println("|       1 - Napoleao        |");
        System.out.println("|       2 - Bonaparte       |");
        System.out.println("+---------------------------+");

        return aux;
    }
}

public class Interativo {
    public static void main(String[] args) {
        Pessoa Napoleao = new Pessoa(26, false, true, false);
        Pessoa Bonaparte = new Pessoa(60, false, false, false);
        CoronaVirus virus = new CoronaVirus();
        Vacina vacinar = new Vacina();

        System.out.println(Napoleao);
        System.out.println(Bonaparte);

        Scanner input = new Scanner(System.in);

        int aux = 1;
        while (aux != 0) {
            int result;
            System.out.println("+---------------------------+");
            System.out.println("|   1 - Contato Pessoal     |");
            System.out.println("|   2 - Vacinar             |");
            System.out.println("|   3 - Fazer Tratamento    |");
            System.out.println("|   0 - Sair                |");
            System.out.println("+---------------------------+");
            aux = input.nextLine();

            if(aux == 1) {
                result = Escolha();
                if(result == 1) {
                    Napoleao.contatoPessoal(Bonaparte, virus);
                } else {
                    Bonaparte.contatoPessoal(Napoleao, virus);
                }
            } else if (aux == 2) {
                result = Escolha();
                if(result == 1) {
                    Napoleao.receberVacina(Napoleao, vacinar);
                } else {
                    Bonaparte.receberVacina(Bonaparte, vacinar);
                }
            } else if (aux  == 3) {
                result = Escolha();
                if(result == 1) {
                    Napoleao.tratamento(Napoleao);
                } else {
                    Bonaparte.tratamento(Bonaparte);
                }
            } else {
                aux = 0;
            }
            
        }

        System.out.println(Napoleao);
        System.out.println(Bonaparte);

    }
}