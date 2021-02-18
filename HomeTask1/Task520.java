import java.util.Scanner;

public class Task520 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter data first box: ");
        int l1 = scanner.nextInt();
        int w1 = scanner.nextInt();
        int h1 = scanner.nextInt();
        System.out.println("Enter data second box: ");
        int l2 = scanner.nextInt();
        int w2 = scanner.nextInt();
        int h2 = scanner.nextInt();
        System.out.println("Enter data container: ");
        int lc = scanner.nextInt();
        int wc = scanner.nextInt();
        int hc = scanner.nextInt();

        if (l1 > 0 && l1 < 1000 && w1 > 0 && w1 < 1000 && h1 > 0 && h1 < 1000 &&
        l2 > 0 && l2 < 1000 && w2 > 0 && w2 < 1000 && h2 > 0 && h2 < 1000 &&
        lc > 0 && lc < 1000 && wc > 0 && wc < 1000 && hc > 0 && hc < 1000) {
            if(w1 + w2 == wc){
                System.out.println("YES");
            } else if (h1 + h2 == hc) {
                System.out.println("YES");
            } else if (l1 + l2 == lc && h1 + h2 == hc) {
                System.out.println("YES");
            }  else {
                System.out.println("FAILED");
            }
        } else {
            System.out.println("FAILED");
        }
    }
}       
