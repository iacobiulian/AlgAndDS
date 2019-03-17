package ro.iim.recursion;

public class TriangularNumbers {

    public static int triangularIterative(int term) {
        if (term <= 0)
            return -1;

        int result = 0;
        for (int i = 1; i <= term; i++) {
            result += i;
        }

        return result;
    }

    public static int triangularRecursive(int term) {
        if (term <= 0)
            return -1;

        if (term == 1)
            return 1;

        return term + triangularRecursive(term - 1);
    }

    public static int factorialRecursive(int term) {
        if (term < 0)
            return -1;

        if (term == 0)
            return 1;

        return term * factorialRecursive(term - 1);
    }

    public static void main(String[] args) {
        System.out.println(triangularIterative(3));

        System.out.println(triangularRecursive(4));

        System.out.println(factorialRecursive(16));
    }

}
