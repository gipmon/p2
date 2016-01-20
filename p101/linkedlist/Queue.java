/* Aula 10 - Lista Ligada - by Rafael Ferreira
 * É aconselhado que faças os exercícios por ti e apenas se tiveres alguma dúvida pontual
 * de como terá sido o programa feito recorre a estas resoluções.
 * Estas resoluções poderão não estar optimizadas e até corretas.
 * Aconselhado atitude crítica.
 * rafaelferreira.pt/recursos
 */
package linkedlist;

public class Queue<T>{
	class Node<T>{
		T e;
		Node<T> next;
	}
	
	private Node<T> pin = null;
	private Node<T> pout = null;
	private int size = 0;

	public void in(T novo){
		Node<T> n = new Node<T>();
		n.e = novo;
		n.next = null;

		if(pout == null){
			pout = n;
		}else{
			pin.next = n;
		}
		pin = n;
		size ++;
	}
	public T out(){
		T sai = pout.e;
		pout = pout.next;

		if(pout==null)
			pin = null;
		size --;
		return sai;
	}
	public int size(){
		return size;
	}
	public T peek(){
		return pout.e;
	}
	public void clear(){
		size =0;
		pout=pin =null;
	}
	public boolean isEmpty(){
		return size==0;
	}
	public void print(){
		String out = "";
		Node<T> t = pout;

		while(t!=null){
			out +=" "+t.e;
			t = t.next;
		}
		System.out.print(out);
	}

}