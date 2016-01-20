/* Pilhas (stacks) e filas (queues). - Aula 9 - by Rafael Ferreira
 * É aconselhado que faças os exercícios por ti e apenas se tiveres alguma dúvida pontual
 * de como terá sido o programa feito recorre a estas resoluções.
 * Estas resoluções poderão não estar optimizadas e até corretas.
 * Aconselhado atitude crítica.
 * rafaelferreira.pt/recursos
 */
public class Stack{

	private double[] array;
	private int realsize;

	public Stack(int size){
		array = new double[size];
		realsize = 0;
	}
	public String operacao(String valor){
		if(isNumber(valor))
			push(Double.parseDouble(valor));
		else if(isOperator(valor) && realsize>=2)
			push(calcular(pop(), valor, pop()));
		else if(isOperator(valor) && realsize<2)
			throw new IllegalArgumentException("ERROR: one operand missing!");
		else
			throw new IllegalArgumentException("ERROR: invalid operator!");
		return printStack();
	}
	private String printStack(){
		String print = "Stack:";
		for(int i=0; i<realsize; i++)
			print+=" "+Double.toString(array[i]);
		return print;
	}
	private double calcular(double a, String operator, double b){
		if(operator.charAt(0)=='/')
			return b/a;
		else if(operator.charAt(0)=='+')
			return a+b;
		else if(operator.charAt(0)=='-')
			return b-a;
		else if(operator.charAt(0)=='*')
			return a*b;
		else 
			return 0;
	}
	private boolean isOperator(String valor){
		if(valor.length()==0)
			return false;
		return (valor.charAt(0)=='/' || valor.charAt(0)=='+' || valor.charAt(0)=='-' || valor.charAt(0)=='*');
	}
	private boolean isNumber(String valor){
		for(int i=0; i<valor.length(); i++)
			if(!Character.isDigit(valor.charAt(i)))
				return false;
		return true;
	}
	private void push(double valor){
		assert !isFull();
		array[realsize] = valor;
		realsize++;
		assert !isEmpty();
	}
	private double pop(){
		assert !isEmpty();
		realsize--;
		return array[realsize];
	}
	private double top(){
		assert !isEmpty();
		return array[realsize-1];
	}
	private boolean isEmpty(){
		return realsize==0;
	}
	private boolean isFull(){
		return realsize==array.length;
	}
	private int size(){
		return realsize;
	}
	private void clear(){
		realsize=0;
	}
}