/* Aula 10 - Lista Ligada - by Rafael Ferreira
 * É aconselhado que faças os exercícios por ti e apenas se tiveres alguma dúvida pontual
 * de como terá sido o programa feito recorre a estas resoluções.
 * Estas resoluções poderão não estar optimizadas e até corretas.
 * Aconselhado atitude crítica.
 * rafaelferreira.pt/recursos
 */
package linkedlist;

public class Array<T>{
	
	class Node<T>{
		T e;
		int indice;
		Node<T> next;
	}
	
	private Node<T> top = null;
	private int sizeReal;
	private int sizeExpected;

	public Array(int length){
		sizeExpected = length;
		sizeReal=0;
	}	
	public void set(int idx, T e){
		Node<T> n = new Node<T>();
		n.e = e;
		n.indice = idx;
		n.next = top;

		top = n;
		sizeReal++;
	}
	public boolean defined(int idx){
		Node<T> t = top;
		
		while(t != null && t.indice != idx){
			t=t.next;
		}
		
		return t != null; 
	}
	public T get(int idx){
		Node<T> t = top;
		
		while(t != null && t.indice != idx){
			t=t.next;
		}
		return t.e;	
	}
	public int length(){
		return sizeExpected;
	}

}