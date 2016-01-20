/*Classes, Objectos e Pacotes - Aula 2 - by Rafael Ferreira
 * É aconselhado que faças os exercícios por ti e apenas se tiveres alguma dúvida pontual
 * de como terá sido o programa feito recorre a estas resoluções.
 * Estas resoluções poderão não estar correctamente optimizadas. 
 * Aconselhado atitude crítica.
 * rafaelferreira.pt/recursos
 *  */
public  class p22 {

  public static void main(String[] args) {
    Contacto[] cl = new Contacto[4];


    cl[0] = new Contacto("Ana", "978676760");
    cl[1] = new Contacto("Rita", "867367834", "rita@gmail.com"); 
    cl[2] = new Contacto("Paulo", "897476388", "paulo@hotmail.com"); 
    cl[3] = new Contacto("Carlos", "674767867");

    for (int i = 0; i < cl.length; i++) { 
      System.out.println(cl[i].nome() +": " + cl[i].telefone() + "; " + cl[i].eMail());
    } 
  }
}
