/* Aula 12 -  Arvores Bin ́arias de Procura; - by Rafael Ferreira
 * É aconselhado que faças os exercícios por ti e apenas se tiveres alguma dúvida pontual
 * de como terá sido o programa feito recorre a estas resoluções.
 * Estas resoluções poderão não estar optimizadas e até corretas.
 * Aconselhado atitude crítica.
 * rafaelferreira.pt/recursos

 Este exercício não tem a implementação mais correta, mas é um bom exemplo.
 */
public class p122{
	public static void main(String args[]){
		ExpressionTree calculadora = new ExpressionTree();
		
		for(String arg : args)
			calculadora.set(arg);
		
		System.out.println(calculadora.printInfix());
		System.out.println(calculadora.eval());
	}
}