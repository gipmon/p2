package hashtableChaining;
@SuppressWarnings(value = "unchecked")
/* Aula 11 - Tabelas de Dispers ̃ao e Arrays Associativos. - by Rafael Ferreira
 * É aconselhado que faças os exercícios por ti e apenas se tiveres alguma dúvida pontual
 * de como terá sido o programa feito recorre a estas resoluções.
 * Estas resoluções poderão não estar optimizadas e até corretas.
 * Aconselhado atitude crítica.
 * rafaelferreira.pt/recursos
 */
public class AssociativeArray<T>{
	
	private Node<T> table[] = null;
	private int size = 0;

	class Node<T>{
		String key;
		T value;
		Node<T> next;		
	}

	public AssociativeArray(int n){
		table = (Node<T>[]) new Node[n];
		size = 0;
	}
	public void set(String key, T value){
		int idx = hash(key);

		Node<T> t = searchNode(key);

		if(t==null){
			t = new Node();
			t.key = key;
			size ++;
			t.next = table[idx];
			table[idx] = t;
		}	

		t.value = value;
	}

	private int hash(String chave){
		/*int key = 0;

		for(int i=0; i<chave.length(); i++)
			key+=(int)chave.charAt(i);
		
		return key % table.length;*/
		return chave.hashCode() % table.length;
	}

	private Node<T> searchNode(String chave){
		Node t = table[hash(chave)];

		while(t!=null){
			if(t.key.equals(chave))
				return t;
			t = t.next;
		}

		return null;
	}
	public T get(String chave){
		Node<T> t = searchNode(chave);
		
		if(t!=null)
			return t.value;
		else
			return null;
	}
	public String[] keysToArray(){
		String keys[] = new String[size];
		int k=0;

		for(int i=0; i<table.length; i++){
			Node t = table[i];
			
			while(t!=null){
				keys[k++]=t.key;
				t = t.next;
			}
		}
		return keys;
	}
	public void delete(String chave){
		assert exists(chave);
		Node<T> t = table[hash(chave)];
		
		if(t!=null && t.next==null && t.key.equals(chave))
			table[hash(chave)] = null;	
		else{
			while(t!=null && t.next!=null){
				if(t.next.key.equals(chave)){
					t=t.next.next;
				}
				t = t.next;
			}	
		}
		size--;
	}
	public void clear(){
		table = (Node<T>[]) new Node[table.length];
		size = 0;
	}
	public boolean exists(String chave){
		return searchNode(chave)!=null;
	}
	public int size(){
		return size;
	}
	public boolean isEmpty(){
		return size==0;
	}
}