/* Aula 10 - Lista Ligada - by Rafael Ferreira
 * É aconselhado que faças os exercícios por ti e apenas se tiveres alguma dúvida pontual
 * de como terá sido o programa feito recorre a estas resoluções.
 * Estas resoluções poderão não estar optimizadas e até corretas.
 * Aconselhado atitude crítica.
 * rafaelferreira.pt/recursos
 */
import static java.lang.System.*;

public class p104
{
   public static void main(String[] args)
   {
      if (args.length != 1)
      {
         err.println("Uso: p104 <Max-Number>");
         exit(1);
      }
      int maxNumber = Integer.valueOf(args[0]);

      BlockArrayInt a = new BlockArrayInt(50,1);

      int size = 0;
      for(int n = 2;n <= maxNumber;n++)
         if (ePrimo(n))
         {
            if (size == a.size())
               a.incrementNumberOfBlocks();
            a.put(n,size);
            size++;
         }

      for(int i = 0;i < size;i++)
      {
         out.printf("%8d",a.get(i));
         if ((i+1) % 10 == 0)
            out.println();
      }
      out.println();
      out.println();
      out.println("Number of prime numbers found = "+size);
      out.println();
      out.println("BlockArray:");
      out.println("  Number of blocks = "+a.numberOfBlocks());
      out.println("  Block size = "+a.blockSize());
   }

   static boolean ePrimo(int n)
   {
      assert n >= 1;

      boolean result = (n == 2) || (n % 2 != 0);

      for(int d = 3;result && d*d <= n;d += 2)
         result = (n % d) != 0;

      return result;
   }
}
