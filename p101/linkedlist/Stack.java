/* Aula 10 - Lista Ligada - by Rafael Ferreira
 * É aconselhado que faças os exercícios por ti e apenas se tiveres alguma dúvida pontual
 * de como terá sido o programa feito recorre a estas resoluções.
 * Estas resoluções poderão não estar optimizadas e até corretas.
 * Aconselhado atitude crítica.
 * rafaelferreira.pt/recursos
 */
package linkedlist;

public class Stack<T>{
	class Node<T>{
		T e;
		Node<T> next;
	}
	
	private Node<T> top; // guarda qual é o no que está no topo
	private int size;
	/*
		public Stack<T>(){
			top = null;
			size = 0;
		}
	*/
	public void push(T novo){
		Node<T> n = new Node<T>();
		n.e = novo;
		n.next = top;
		top = n;
		size ++;
	}
	public T pop(){
		//quando fazemos pop temos de dizer que o top é o seguinte pois retiramos
		//o primeiro top
		T sai = top.e;
		// se não guardassemos o valor do top ele depois quando fizessemos o pop iamos perdê-lo
		top = top.next;
		size --;
		return sai;
	}
	public boolean isEmpty(){
		return size == 0 && top == null;
	}
	public boolean isFull(){
		return false;
	}
	public void clear(){
		top = null;
		size = 0;
	}
	public int size(){
		return size;
	}
	public void print(){
		Node<T> t = top;

		String out = "";
		
		while(t != null){
			out += " "+t.e;
			t = t.next;
		}
		System.out.print(out);
	}
}