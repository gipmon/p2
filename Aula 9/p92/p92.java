/* Pilhas e Filas - Aula 9 - by Rafael Ferreira
 * É aconselhado que faças os exercícios por ti e apenas se tiveres alguma dúvida pontual
 * de como terá sido o programa feito recorre a estas resoluções.
 * Estas resoluções poderão não estar optimizadas e até corretas.
 * Aconselhado atitude crítica.
 * rafaelferreira.pt/recursos
 */
import Game.*;

public class p92{
	public static void main(String args[]){
		if(args.length != 1){
			System.err.println("Usage: java -ea p92 <n>");
		}else{
			TorresDeHanoi game = new TorresDeHanoi(Integer.parseInt(args[0]));
			
		}
	}
}