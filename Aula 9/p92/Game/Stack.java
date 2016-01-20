/* Pilhas e Filas - Aula 9 - by Rafael Ferreira
 * É aconselhado que faças os exercícios por ti e apenas se tiveres alguma dúvida pontual
 * de como terá sido o programa feito recorre a estas resoluções.
 * Estas resoluções poderão não estar optimizadas e até corretas.
 * Aconselhado atitude crítica.
 * rafaelferreira.pt/recursos
 */
package Game;

public class Stack{ 
//Pilha First In First Out
	
	private int array[];
	private int size;

	public Stack(int maxSize){
		array = new int[maxSize];
		size = 0;
	}

	public void push(int valor){
		assert !isFull();
			array[size++] = valor; 
		assert !isEmpty() && top() == valor;
	}
	public void pop(){
		assert !isEmpty();
			size--;
	}
	public int top(){
		assert !isEmpty();
		return array[size-1];
	}
	public boolean isEmpty(){
		return (size==0);
	}
	public boolean isFull(){
		return (size==array.length);
	}
	public int size(){
		return size;
	}
	public void clear(){
		size = 0;
	}
	public String toString(){
		String out = "";
		for(int i = 0; i < size - 1; i++)
			out+=array[i]+" ";
		out+=array[size-1];
		return out;
	}

}