/* Pilhas (stacks) e filas (queues). - Aula 9 - by Rafael Ferreira
 * É aconselhado que faças os exercícios por ti e apenas se tiveres alguma dúvida pontual
 * de como terá sido o programa feito recorre a estas resoluções.
 * Estas resoluções poderão não estar optimizadas e até corretas.
 * Aconselhado atitude crítica.
 * rafaelferreira.pt/recursos
 */
import Types.*;
@SuppressWarnings(value = "unchecked") // isto é para usar tipos genéricos

public class p91{
	public static void main(String args[]){
		String arg = "";
		
		arg=args[0].replace(" ", "");

		Stack<Character> stack = new Stack<Character>(arg.length()); // vão sair invertidos
		Queue<Character> queue = new Queue<Character>(arg.length()); // vão sair pela ordem de inserção

		for(int i=0; i < arg.length(); i++){
			queue.in(Character.toLowerCase(arg.charAt(i)));
			stack.push(Character.toLowerCase(arg.charAt(i)));
		}
		if(compare(stack, queue))
			System.out.println("Text \""+args[0]+"\" is a palindrome!");
		else
			System.out.println("Text \""+args[0]+"\" is not a palindrome!");
	}
	private static void outputs(Stack<Character> stack, Queue<Character> queue){
		while(!stack.isEmpty()){
			System.out.print(stack.pop());
		}
			System.out.println();
		while(!queue.isEmpty()){
			System.out.print(queue.out());
		}
			System.out.println();
		
	}
	private static boolean compare(Stack<Character> stack, Queue<Character> queue){
		for(int i=0;  !stack.isEmpty() ; i++)
			if(queue.out()!=stack.pop())
				return false;		
		return true;
	}
}