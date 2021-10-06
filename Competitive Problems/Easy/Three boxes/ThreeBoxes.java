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
            int A = sc.nextInt(), B = sc.nextInt(), C = sc.nextInt(), D = sc.nextInt(), count = 0;
            int temp = D;
            for (; A > 0 || B > 0 || C > 0; count++) {
                temp = D;
                if (temp >= C && C != 0) {
                    temp -= C;
                    C = 0;
                }
                if (temp >= B && B != 0) {
                    temp -= B;
                    B = 0;
                }
                if (temp >= A && A != 0) {
                    A = 0;
                }
            }
            System.out.println(count);
        }
    }
}
