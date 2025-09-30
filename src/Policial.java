import java.util.Random;

public class Policial{
    private int energia;
    private String nome;
    private int quantidadeGranadas;
    private String armamento;

    Random gerarNumero = new Random();

    //Construtor
    public Policial(String nome, int energia, int quantidadeGranadas) {
        setNome(nome);
        setEnergia(energia);
        setQuantidadeGranadas(quantidadeGranadas);
        gerarArmamento();
    }

    //Setters
    public void setEnergia(int energia) {
        if (energia >= 0 && energia <= 10) this.energia = energia;
    }

    public void setNome(String nome) {
        this.nome = (nome != null && nome.length() >= 4) ? nome : "SemNome";
    }

    public void setQuantidadeGranadas(int quantidadeGranadas) {
        if (quantidadeGranadas >= 0 && quantidadeGranadas <= 5) this.quantidadeGranadas = quantidadeGranadas;
    }

    //Random
    public void gerarArmamento() {
        int opcaoArmas = gerarNumero.nextInt(3);
        switch(opcaoArmas) {
            case 0:
                this.armamento = "Faca";
                break;
            case 1:
                this.armamento = "Pistola";
                break;
            case 2:
                this.armamento = "Fuzil";
                break;
        }
    }

    //Comportamentos
    public void desarmarBomba() {
        System.out.println(nome + " desarmando bomba");
    }

    public void lancarGranada() {
        if (quantidadeGranadas > 0) {
            quantidadeGranadas--;
            System.out.println(nome + " lançou granada (restam " + quantidadeGranadas + ")");
        } else {
            System.out.println(nome + " tentou lançar granada, mas não tem");
            }
    }

    public void atacar() {
        System.out.println(nome + " atacou com " + armamento);
    }

    public void passarAVez() {
        System.out.println(nome + " passou a vez");
    }

    @Override
    public String toString(){
        return String.format("e: %d, f: %d, s: %s",
        energia, quantidadeGranadas, armamento);
    }
}
