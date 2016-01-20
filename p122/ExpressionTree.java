/* Aula 12 -  Arvores Bin ́arias de Procura; - by Rafael Ferreira
 * É aconselhado que faças os exercícios por ti e apenas se tiveres alguma dúvida pontual
 * de como terá sido o programa feito recorre a estas resoluções.
 * Estas resoluções poderão não estar optimizadas e até corretas.
 * Aconselhado atitude crítica.
 * rafaelferreira.pt/recursos
 */
public class ExpressionTree{
	
	class Node{
		String key;
		
		Node left;
		Node right;
	}
	
	Node raiz;

	public ExpressionTree(){
		raiz = null;
	}
	
	public void set(String key){
		Node novo = new Node();
		novo.key = key;

		if(!insert(novo, raiz)){
			System.out.println("ERROR: Invalid Expression!");
			System.exit(1);
		}
	}
	public boolean insert(Node novo, Node parent_root){
		if(raiz == null){
			raiz = novo;
			return true;
		}else if(isValidOperation(parent_root))
			if(parent_root.left!=null && isValidOperation(parent_root.left) && insert(novo, parent_root.left))
				return true;
			else if(parent_root.right!=null && isValidOperation(parent_root.right) && insert(novo, parent_root.right))
				return true;
			else if(parent_root.left==null){
				parent_root.left=novo;
				return true;
			}else if(parent_root.right==null){
				parent_root.right=novo;
				return true;
			}else if(insert(novo, parent_root.left))
				return true;
			else if(insert(novo, parent_root.right))
				return true;

		return false;

	}
	public String printInfix(){
		return keysToString(raiz);
	}
	private String keysToString(Node root){
		if(root==null)
			return "";
		return keysToString(root.left)+" "+root.key+" "+keysToString(root.right);
	}
	public double eval(){
		return calculate(raiz);
	}
	private double calculate(Node root){
		if(root==null)
			return 0;
		
		if(!isNumber(root.key) && isNumber(root.left.key) && isNumber(root.right.key))
			return operation(Double.parseDouble(root.left.key), root.key, Double.parseDouble(root.right.key));
		else if(!isNumber(root.left.key) && !isNumber(root.left.key))
			return operation(calculate(root.left), root.key, calculate(root.right));
		else if(!isNumber(root.left.key))
			return operation(calculate(root.left), root.key, Double.parseDouble(root.right.key));
		else if(!isNumber(root.right.key))
			return operation(Double.parseDouble(root.right.key), root.key, calculate(root.right));

		return 0;
	}
	private double operation(Double a, String oper, Double b){
		if(!(oper.length()==0))
			if(oper.charAt(0)=='+')
				return a+b;
			else if(oper.charAt(0)=='*')
				return a*b;
			else if(oper.charAt(0)=='-')
				return a-b;
			else if(oper.charAt(0)=='/')
				return a/b;
		return 0;
	}
	private boolean isValidOperation(Node novo){
		return (((int)novo.key.charAt(0) == 43) || ((int)novo.key.charAt(0) == 42) || ((int)novo.key.charAt(0) == 45) || ((int)novo.key.charAt(0) == 47)) ? true : false;
	}
	private boolean isNumber(String str){
		if(str==null)
			return false;
		for(int i=0; i<str.length(); i++)
			if(!Character.isDigit(str.charAt(i)))
				return false;
		return true;
	}
	public boolean isEmpty(){
		return raiz==null;
	}
	public void clear(){
		raiz = null;
	}

}