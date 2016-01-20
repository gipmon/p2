/*Classes, Objectos e Pacotes - Aula 2 - by Rafael Ferreira
 * É aconselhado que faças os exercícios por ti e apenas se tiveres alguma dúvida pontual
 * de como terá sido o programa feito recorre a estas resoluções.
 * Estas resoluções poderão não estar correctamente optimizadas. 
 * Aconselhado atitude crítica.
 * rafaelferreira.pt/recursos
 *  */
import pt.ua.prog2.Contacto;
import java.util.*;

public  class p24 {
    
    public static void main(String[] args) {
        Contacto[] cl = new Contacto[4];
        Scanner sc = new Scanner(System.in);
        
        for(int i=0; i<4; i++){
          
            System.out.print("Nome: ");
            String a = sc.nextLine();

            System.out.print("Telemovel: ");
            String b = sc.nextLine();

            System.out.print("Email: ");
            String c = sc.nextLine();
            
            if(c.equals(""))
              cl[i] = new Contacto(a, b);
            else
              cl[i] = new Contacto(a, b, c);
        }
        
        System.out.println("Listagem:");
        for (int i = 0; i < cl.length; i++) { 
          System.out.println(cl[i].nome() +": " + cl[i].telefone() + "; " + cl[i].eMail());
        }

        System.out.println("Contactos: "+cl[0].contador());
    }
}
