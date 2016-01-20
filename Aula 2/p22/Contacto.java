/*Classes, Objectos e Pacotes - Aula 2 - by Rafael Ferreira
 * É aconselhado que faças os exercícios por ti e apenas se tiveres alguma dúvida pontual
 * de como terá sido o programa feito recorre a estas resoluções.
 * Estas resoluções poderão não estar correctamente optimizadas. 
 * Aconselhado atitude crítica.
 * rafaelferreira.pt/recursos
 *  */
public class Contacto{

  private String nome, email, telefone;

  public String telefone(){
    return this.telefone;
  }
  public String nome(){
    return this.nome;
  } 
  public String eMail(){
    return this.email;
  }

  Contacto(String a, String b, String c){
    this.nome=a;
    this.telefone=b;
    this.email=c;
  }
  Contacto(String a, String b){
    this.nome=a;
    this.telefone=b;
  }
}
