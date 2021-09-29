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
      out:for (int i = 0; i < t; i++) {
            int n = sc.nextInt(), arr[] = new int[n];
            for (int j = 0; j < n; j++) {
                arr[j] = sc.nextInt();
            }
            if(n%2 == 0)
                System.out.println("no");
            else if(arr[0]!=1 || arr[n-1] !=1)
                System.out.println("no");
            else{
                int currentValue = 1;
                for (int j = 0; j < (n/2) + 1; j++, currentValue++) {
                    if (arr[j] != arr[n-1-j] || arr[j] != currentValue) {
                        System.out.println("no");
                        continue out;
                    }
                }
                System.out.println("yes");
            }
            
        }
    }
    
}
