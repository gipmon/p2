/* Pilhas (stacks) e filas (queues). - Aula 9 - by Rafael Ferreira
 * É aconselhado que faças os exercícios por ti e apenas se tiveres alguma dúvida pontual
 * de como terá sido o programa feito recorre a estas resoluções.
 * Estas resoluções poderão não estar optimizadas e até corretas.
 * Aconselhado atitude crítica.
 * rafaelferreira.pt/recursos
 */
package Types;
@SuppressWarnings(value = "unchecked") // isto é para usar tipos genéricos

public class Queue<T>{
	// Tipos primitidos: Integer, Double, Long, Byte, Boolean, Character,
	// Float, String
	private T[] array;
	private int size, head, tail;

	public Queue(int maxSize){
		assert maxSize >= 0 : "ERROR: The size that you type is wrong!";
		array = (T[]) new Object[maxSize];
		size = head = tail = 0;
	}
	//não é necessário considerar contratos para estas duas funções privadas
	//porque elas só vão ser usadas internamente e não exteriormente.
	private int nextPosition(int i){ 
		return (i+1)%array.length;
	}
	private int prevPosition(int i){
		return (array.length+i-1)%array.length;
	}
	//função in, para adicionar um elemento à Fila
	public void in(T e){
		assert !isFull() : "ERROR: Stack full!";
			array[tail] = e;
			tail = nextPosition(tail);
			size ++;
		assert !isEmpty() : "ERROR: Has ocorred an error during the in!";
	}
	public T out(){
		assert !isEmpty() : "ERROR: The Stack is empty! It's impossible to do this action!";
			head = nextPosition(head);
			size --;
		assert !isFull() : "ERROR: Has ocorred an error during the out!";
			return array[prevPosition(head)];
	}
	public T peek(){
		assert !isEmpty();
			return array[head];
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
		size = tail = head = 0;
	}
}
