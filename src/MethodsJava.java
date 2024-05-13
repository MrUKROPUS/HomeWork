public class MethodsJava {

    public static void main(String[] args) {
        printThreeWords();
        checkSumSign ();


    }

    private static void printThreeWords() {
        System.out.println("Orange\nBanana\nApple");


    }

    public static void checkSumSign()
    {
        int a = 15;
        int b = -10;

        int sum = a + b;

        if (sum >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }

    }

}
