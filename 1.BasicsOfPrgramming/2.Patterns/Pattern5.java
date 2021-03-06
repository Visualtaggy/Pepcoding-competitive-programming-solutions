import java.util.Scanner;

public class Pattern5 {
    public static void main(String[] args) {
        // 1. You are given a number n.
        // 2. You've to create a pattern of * and separated by tab as shown in output
        // format.

        Scanner scn = new Scanner(System.in);
        System.out.println("Enter the size:");
        int n = scn.nextInt();

        int space = n / 2;
        int star = 1;

        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= space; j++) {
                System.out.print("	");
            }

            for (int j = 1; j <= star; j++) {
                System.out.print("*	");
            }

            if (i <= n / 2) {
                space--;
                star += 2;
            } else {
                space++;
                star -= 2;
            }

            System.out.println("");
        }
        scn.close();
    }
}
