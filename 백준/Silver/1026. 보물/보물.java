import java.util.Arrays;
import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();
        
        String a = sc.nextLine();
        String b = sc.nextLine();

        int[] arrayA = Arrays.stream(a.split(" "))
                .mapToInt(Integer::parseInt)
                .sorted()
                .toArray();
        int[] arrayB = Arrays.stream(b.split(" "))
                .mapToInt(Integer::parseInt)
                .sorted()
                .toArray();

        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += arrayA[i] * arrayB[n - 1 - i];
        }

        System.out.println(sum);
    }

}
