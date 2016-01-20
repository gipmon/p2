/*  ́rvores Bin ́arias de Procura; ́rvores Bin ́arias. - Aula 12 - by Rafael Ferreira
 * É aconselhado que faças os exercícios por ti e apenas se tiveres alguma dúvida pontual
 * de como terá sido o programa feito recorre a estas resoluções.
 * Estas resoluções poderão não estar optimizadas e até corretas.
 * Aconselhado atitude crítica.
 * rafaelferreira.pt/recursos
 */
package hashtableChaining;
@SuppressWarnings(value = "unchecked")

public class AssociativeArray<T>{
	
	public class Node<T>{
		String key;
		T value;
		Node<T> right;
		Node<T> left;
	}

	Node<T> raiz;

	public AssociativeArray(int n){
		raiz = null;
	}
	//SET
	public void set(String key, T value){
		Node<T> novo = new Node();
		novo.key = key;
		novo.value = value;

		raiz = insert(novo, raiz); //O nó que queremos inserir, e o nó de procura
	}
	private Node<T> insert(Node<T> novo, Node<T> root){
		if(root==null)
			return novo;
		//}else if(novo.key < root.key){
		else if(novo.key.compareTo(root.key) < 0){
			//System.out.println("aqui");
			root.left = insert(novo, root.left);
		//else if(novo.key > root.key){
		}else if(novo.key.compareTo(root.key) > 0){
			//System.out.println("aqui1");
			root.right = insert(novo, root.right);
		}else{ //não contemplando valores repetidos
			root.value = novo.value;
		}

		return root;
	}
	//SET
	//GET
	public T get(String key){
		Node<T> t = search(key, raiz);
		if(t==null)
			return null;
		else
			return t.value;
	}
	private Node search(String key, Node root){
		if(root == null)
			return null;
		//else if(key < root.key)
		else if(key.compareTo(root.key) < 0)
			return search(key, root.left);
		//else if(key > root.key)
		else if(key.compareTo(root.key) > 0)
			return search(key, root.right);
		else
			return root;
	}
	//GET
	//EXISTS
	public boolean exists(String key){
		Node t = search(key, raiz);
		return (t==null) ? false : true;
	}
	//EXISTS
	//DELETE
	//Remoção por Insercão como Folha
	public void delete(String key){
		Node d = search(key, raiz);
		//if(d != null)
		raiz = delete(d, raiz);
	}
	private Node delete(Node d, Node root){
		if(d==null || root == null)
			return null;

		//if(d.key<root.key)
		if(d.key.compareTo(root.key) < 0)
			root.left = delete(d, root.left);
		//else if(d.key > root.key)
		else if(d.key.compareTo(root.key) > 0)
			root.right = delete(d, root.right);
		else{
			if(root.left == null && root.right == null) //if desnecessário
				return null;
			else if(root.left == null){
				return root.right;
			}else if(root.right == null){
				return root.left;
			}else{
				return insert(root.left, root.right);
			}
		}
		return root;
	}
	//isEmpty
	public boolean isEmpty(){
		return size()==0;
	}
	//isEmpty
	//clear
	public void clear(){
		raiz = null;
	}
	//clear
	//DELETE
	public String[] keysToArray(){
		return keysToArray(raiz);
	}
	private String[] keysToArray(Node root){
		String[] vazio = new String[0];

		if(root == null) return vazio;

		String[] left = keysToArray(root.left);
		String[] right = keysToArray(root.right);
		String[] keys = new String[left.length + 1 + right.length];

		int i = 0;
		
		for(String k : left)
			keys[i++] = k;
		keys[i++] = root.key;
		for(String k : right)
			keys[i++] = k;

		return keys;
	}
	public String toString(){
		String out = "";
		
		for(String key : keysToArray())
			out += key +" : "+get(key) + "\t";
		
		return out;
	}
	public int size(){
		return keysToArray().length;
	}
}
