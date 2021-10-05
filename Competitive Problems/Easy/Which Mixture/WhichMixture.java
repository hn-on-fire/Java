import java.util.Scanner;
/**
 *
 * @author Harsh
 */
public class CodeChef {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            if (sc.nextInt() == 0) {
                System.out.println("Liquid");
                sc.nextInt();
            }
            else
            if(sc.nextInt() == 0){
                System.out.println("Solid");
            }
            else{
                System.out.println("Solution");
            }
        }
    }
}
