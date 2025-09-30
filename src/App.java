import java.util.Random;

public class App {
    public static void main(String[] args) throws Exception {
        // Gerador aleatório de Inteiros
        Random gerarNumero = new Random();

        // Construtor Policial e Terrorista
        Terrorista terrorista = new Terrorista("Fred", 10, 5);
        Policial policial = new Policial("Irwin", 10, 5);

        // Estados da Bomba
        boolean bombaPlantada = false;
        boolean bombaDesarmada = false;
        boolean bombaAcabarRodada = false;

        boolean rodadaParaPlantar = true;
        boolean rodadaParaDesarmar = false;

        // Loop do jogo
        while (true) {
            var quemMovimenta = gerarNumero.nextInt(2);
            // Check de Bomba Plantada
            if (bombaPlantada == true && bombaDesarmada == false && rodadaParaDesarmar == false) {
                rodadaParaDesarmar = true;
            } else if (bombaPlantada == true && bombaDesarmada == false && rodadaParaDesarmar == true) {
                bombaAcabarRodada = true;
            }
            // Check de Bomba Desarmada
            if (bombaDesarmada == true && bombaPlantada == false && rodadaParaPlantar == false) {
                rodadaParaPlantar = true;
                System.out.println("Apenas uma rodada para plantar");
            } else if (bombaDesarmada == true && bombaPlantada == false && rodadaParaPlantar == true) {
                bombaDesarmada = false;
            }

            if (bombaAcabarRodada == false)
                switch (quemMovimenta) {
                    case 0:
                        // Ações Policial
                        var acaoPolicial = gerarNumero.nextInt(4);
                        switch (acaoPolicial) {
                            case 0:
                                policial.desarmarBomba();
                                bombaDesarmada = true;
                                break;
                            case 1:
                                policial.lancarGranada();
                                terrorista.setEnergia(terrorista.getEnergia() - 4);
                                break;
                            case 2:
                                policial.atacar();
                                int dano = aplicarDano(policial.getArmamento());
                                terrorista.setEnergia(terrorista.getEnergia() - dano);
                                break;
                            case 3:
                                policial.setEnergia(policial.getEnergia() + gerarNumero.nextInt(2) + 1);
                                policial.passarAVez();
                                break;
                        }
                        System.out.println(policial);
                        System.out.println("+++++++++++++++++++++++++++++++++++++++");
                        Thread.sleep(2000);
                        break;
                    case 1:
                        // Ações Terrorista
                        var acaoTerrorista = gerarNumero.nextInt(4);
                        switch (acaoTerrorista) {
                            case 0:
                                terrorista.plantarBomba();
                                bombaPlantada = true;
                                break;
                            case 1:
                                terrorista.lancarGranada();
                                policial.setEnergia(policial.getEnergia() - 4);
                                break;
                            case 2:
                                terrorista.atacar();
                                int dano = aplicarDano(terrorista.getArmamento());
                                policial.setEnergia(policial.getEnergia() - dano);
                                break;
                            case 3:
                                terrorista.setEnergia(terrorista.getEnergia() + gerarNumero.nextInt(2) + 1);
                                terrorista.passarAVez();
                                break;
                        }
                        System.out.println(terrorista);
                        System.out.println("+++++++++++++++++++++++++++++++++++++++");
                        Thread.sleep(2000);
                        break;
                }

            // FIM DE JOGO
            // Bomba
            if (bombaPlantada == true && bombaDesarmada == true)
                break;
            if (bombaAcabarRodada == true)
                break;
            // Um dos personagens sem energia
            if (terrorista.getEnergia() <= 0 && policial.getEnergia() <= 0)
                break;
        }
    }

    static int aplicarDano(String arma) {
        int dano = 0;

        if (arma.equalsIgnoreCase("Faca"))
            dano = 1;
        if (arma.equalsIgnoreCase("Pistola"))
            dano = 2;
        if (arma.equalsIgnoreCase("Fuzil"))
            dano = 3;

        return dano;
    }
}
