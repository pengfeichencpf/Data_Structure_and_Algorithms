package _01Complexity;

public class Main {
    /*0 1 2 3 4 5 6 7
     * 0 1 1 2 3 5 8 13...
     * */
    public static int fib1(int n) {
        if (n <= 1) return n;
        return fib1(n-1)+fib1(n-2);
    }
    public static int fib2(int n) {
        if (n <= 1) return n;
        int first = 0;
        int second = 1;
        for (int i = 0; i < n - 1; i++) {
            int sum = first + second;
            first = second;
            second = sum;
        }
        return second;
    }

    public static int fib3(int n) {
        if (n <= 1) return n;
        int first = 0;
        int second = 1;
        while (n-- > 0) {
            second += first;
            first = second - first;
        }
        return second;
    }
    public static void main(String[] args) {
        System.out.println(fib2(70));
    }
}

