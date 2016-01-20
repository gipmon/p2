/*Classes, Objectos e Pacotes - Aula 2 - by Rafael Ferreira
 * É aconselhado que faças os exercícios por ti e apenas se tiveres alguma dúvida pontual
 * de como terá sido o programa feito recorre a estas resoluções.
 * Estas resoluções poderão não estar correctamente optimizadas. 
 * Aconselhado atitude crítica.
 * rafaelferreira.pt/recursos
 *  */

package pt.ua.prog2;

public class Contacto{
    
    private String nome, email, telefone;
    private static int contador=0;
    
    public String telefone(){
        return telefone;
    }

    public String nome(){
        return nome;
    }

    public String eMail(){
        return email;
    }
    
    private void validar(String a){
      if(a==null || a.length()==0){
        System.err.println("Contacto inválido!");
        System.exit(0);
      }
    }
    
    public Contacto(String a, String b, String c){
        this.nome=a;
        this.telefone=b;
        this.email=c;
        contador++;
        validar(this.nome);
    }
    public Contacto(String a, String b){
        this.nome=a;
        this.telefone=b;
        this.email=null;
        contador++;
        validar(this.nome);
    }
    public static int contador() {
        return contador;
    }
}
