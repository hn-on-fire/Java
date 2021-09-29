package codechef;

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
        int t = sc.nextInt();
        int[] semiPrimes = { 6, 10, 14, 15, 21, 22, 26, 33, 34, 35, 38, 39, 46, 51, 55, 57, 58, 62, 65, 69, 74, 77, 82, 85, 86, 87, 91, 93, 94, 95, 106, 111, 115, 118, 119, 122, 123, 129, 133, 134, 141, 142, 143, 145, 146, 155, 158, 159, 161, 166, 177, 178, 183, 185, 187, 194};
        main:
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            for (int j = 0; j < 58; j++) {
                if (semiPrimes[j] >= n) {
                    break;
                }
                for (int k = 0; k <= j; k++) {
                    if (semiPrimes[j] + semiPrimes[k] > n) {
                        break;
                    }
                    if (semiPrimes[j] + semiPrimes[k] == n) {
                        System.out.println("YES");
                        continue main;
                    }
                }
            }
            System.out.println("NO");
        }
    }

}
