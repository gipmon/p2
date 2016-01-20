/* Pilhas (stacks) e filas (queues). - Aula 9 - by Rafael Ferreira
 * É aconselhado que faças os exercícios por ti e apenas se tiveres alguma dúvida pontual
 * de como terá sido o programa feito recorre a estas resoluções.
 * Estas resoluções poderão não estar optimizadas e até corretas.
 * Aconselhado atitude crítica.
 * rafaelferreira.pt/recursos
 */
package Types;
@SuppressWarnings(value = "unchecked") // isto é para usar tipos genéricos

public class Stack<T>{ //Pilha
	// Tipos primitidos: Integer, Double, Long, Byte, Boolean, Character,
	// Float, String
	private T[] array;
	private int size;

	public Stack(int maxSize){
		assert maxSize >= 0 : "ERROR: The size that you type is wrong!";
		array = (T[]) new Object[maxSize];
		size = 0;
	}
	public void push(T num){
		assert !isFull() : "ERROR: Stack full!";
			array[size++] = num;
		assert !isEmpty() && (top() == num) : "ERROR: Has ocorred an error during the push!";
	}
	public T pop(){
		assert !isEmpty() : "ERROR: The Stack is empty! It's impossible to do this action!";
			return array[--size];
		//assert !isFull() : "ERROR: Has ocorred an error during the pop!";
	}
	public T top(){
		assert !isEmpty() : "ERROR: Is impossible to return the top!";
			return array[size-1];
	}
	public boolean isEmpty(){
		return size == 0;
	}
	public boolean isFull(){
		return size == array.length;
	}
	public int size(){
		return size;
	}
	public void clear(){
		size = 0;
	}
}