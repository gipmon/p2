/* Programação por contratos - Aula 4 - by Rafael Ferreira
 * É aconselhado que faças os exercícios por ti e apenas se tiveres alguma dúvida pontual.
 * de como terá sido o programa feito recorre a estas resoluções.
 * Estas resoluções poderão não estar correctamente optimizadas.
 * Aconselhado atitude crítica.
 * rafaelferreira.pt/recursos
 * */
public class Nota{
  private Data inicio;
  private Data fim;
  private String texto;

  public Nota(Data inicio, Data fim, String texto) throws IllegalArgumentException{
    
    if(!inicio.dataValida())
      throw new IllegalArgumentException("ERRO: Data inicial inválida!");
    else if(!fim.dataValida())
      throw new IllegalArgumentException("ERRO: Data final inválida!");

    //Data de iniciod
    this.inicio = new Data(inicio.getDia(), inicio.getMes(), inicio.getAno());
    //Data de fim
    this.fim = new Data(fim.getDia(), fim.getMes(), fim.getAno());
    //Texto
    this.texto=texto;
  } 
  public void escreve(){
    System.out.printf("%02d-%02d-%04d <-> %02d-%02d-%04d: %s\n",this.inicio.getDia(), this.inicio.getMes(), this.inicio.getAno(), this.fim.getDia(), this.fim.getMes(), this.fim.getAno(), this.texto);
  }

}
