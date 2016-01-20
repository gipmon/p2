/* Aula 10 - Lista Ligada - by Rafael Ferreira
 * É aconselhado que faças os exercícios por ti e apenas se tiveres alguma dúvida pontual
 * de como terá sido o programa feito recorre a estas resoluções.
 * Estas resoluções poderão não estar optimizadas e até corretas.
 * Aconselhado atitude crítica.
 * rafaelferreira.pt/recursos
 */
@SuppressWarnings(value = "unchecked")
public class Stack<T>{
	
	class Node<T>{
		T e;
		Node next;
	}

	int size = 0;
	Node<T> top = null;

	public void push(T e){
		Node<T> novo = new Node();
		novo.e = e;
		novo.next = top;
		
		top = novo;

		size ++;

		assert !isEmpty();
	}
	public void print(){
		Node<T> t = top;
		
		String out = "";

		while(t!=null){
			out += " "+t.e;
			t = t.next;
		}

		System.out.print(out);
	}
	public void pop(){
		assert !isEmpty();
		top = top.next;
		size--;
	}
	public boolean isEmpty(){
		return size==0;
	}
	public T top(){
		return top.e;
	}
	public int size(){
		return size;
	}
}