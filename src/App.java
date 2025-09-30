import java.util.Random;

public class App {
    public static void main(String[] args) throws Exception {
        //Gerador aleatório de Inteiros
        Random gerarNumero = new Random();

        //loop do jogo
        while(true){
        

            //Construtor Policial e Terrorista
            Terrorista terrorista = new Terrorista("Fred", 10, 5);
            Policial policial = new Policial("Irwin", 10, 5);

            // Ações Policial
            var acaoPolicial = gerarNumero.nextInt(4);
               switch(acaoPolicial){
                    case 0:
                        policial.desarmarBomba();
                        break;
                    case 1:
                        policial.lancarGranada();
                        break;
                    case 2:
                        policial.atacar();
                        break;
                    case 3:
                        policial.passarAVez();
                        break;
                }
            //System.out.println(policial);
            System.out.println("+++++++++++++++++++++++++++++++++++++++");
            Thread.sleep(5000);

            // Ações Terrorista
            var acaoTerrorista = gerarNumero.nextInt(4);
               switch(acaoTerrorista){
                    case 0:
                        terrorista.plantarBomba();
                        break;
                    case 1:
                        terrorista.lancarGranada();
                        break;
                    case 2:
                        terrorista.atacar();
                        break;
                    case 3:
                        terrorista.passarAVez();
                        break;
                }
            //System.out.println(terrorista);
            System.out.println("+++++++++++++++++++++++++++++++++++++++");
            Thread.sleep(2000);
        }
    }
}
