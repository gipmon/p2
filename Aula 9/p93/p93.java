/* Pilhas (stacks) e filas (queues). - Aula 9 - by Rafael Ferreira
 * É aconselhado que faças os exercícios por ti e apenas se tiveres alguma dúvida pontual
 * de como terá sido o programa feito recorre a estas resoluções.
 * Estas resoluções poderão não estar optimizadas e até corretas.
 * Aconselhado atitude crítica.
 * rafaelferreira.pt/recursos
 */
import java.util.*;

public class p93{
	public static void main(String[] args){
		Stack calculadora = new Stack(50);
		Scanner sc = new Scanner(System.in);

		String valor = "";

		try{
			do{
				valor = sc.next();
				System.out.println(calculadora.operacao(valor));
			}while(valor!="" && valor!=null);
		}catch(IllegalArgumentException e){
			System.err.println(e.getMessage());
		}catch(java.util.NoSuchElementException e){
			
		}

	}
}