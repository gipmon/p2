/* Rafael Ferreira */
import static java.lang.System.*;
import java.util.Scanner;

public class Prog {
  static final Scanner in = new Scanner(System.in);
  public static void main(String[] args) {
    int n[] = new int[3];
    n[0] = in.nextInt();
    n[1] = n[0];
    while(f1(n[1]) != n[1])
      n[1] = f1(n[1]);
    n[2] = f2(n[1]);
    for(int i = 0; i < n.length; i++)
      out.printf("n[%d] = %d\n", i, n[i]);
  }

  static int f1(int n) {
    if (n % 2 == 0)
      n = n/2;
    return n;
  }

  static int f2(int n) {
    final int a[] = {3,5,7,11};
    for(int i = 0; i < a.length; i+)
      if (n % a[i] == 0)
        return a[i];
    return n;
  }
}
/*###########################*
 * Não prometo que este programa compile, não é esse o objectivo principal
 * sendo o valor introduzido 220 temos que:
 * n[0]=220
 * n[1]=220
 * n[1]=110
 * n[1]=55
 * n[2]=f2(55)=5
 *##########################*/
