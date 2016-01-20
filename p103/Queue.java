/* Aula 10 - Lista Ligada - by Rafael Ferreira
 * É aconselhado que faças os exercícios por ti e apenas se tiveres alguma dúvida pontual
 * de como terá sido o programa feito recorre a estas resoluções.
 * Estas resoluções poderão não estar optimizadas e até corretas.
 * Aconselhado atitude crítica.
 * rafaelferreira.pt/recursos
 */
@SuppressWarnings(value = "unchecked")
public class Queue<T>{

	class Node<T>{
		Node<T> previous;
		T e;
		Node<T> next;
	}

	Node<T> pin = null;
	Node<T> pout = null;
	int size = 0;

	public void in(T e){
		Node<T> novo = new Node<T>();
		novo.e = e;
		novo.next = null;

		if(pout==null)
			pout=novo;
		else{
			pin.next = novo;
			pin = pout.previous;
		}
		pin = novo;
		size ++; 
	}

	public void out(){
		assert !isEmpty();
		size --;
		pout = pout.next;

		if(pout==null)
			pin = null;
	}

	public boolean isEmpty(){
		return size() == 0;
	}

	public T peek(){
		assert !isEmpty();
		return pout.e;
	}

	public int size(){
		return size;
	}

	public void print(){
		Node<T> t = pout;
		
		String out = "";

		while(t!=null){
			out += " "+t.e;
			t=t.next;
		}
		System.out.print(out);
	}
}