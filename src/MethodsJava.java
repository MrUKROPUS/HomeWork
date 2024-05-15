public class MethodsJava {

    public static void main(String[] args) {
        printThreeWords();
        checkSumSign();
        printColor();
        compareNumbers();
        checkingAmountsWithinLimits(5, 20);
        wholeNumber(-5);
        wholeNumberTrueFalse(-10);

    }


    private static void printThreeWords() {
        System.out.println("Orange\nBanana\nApple");


    }

    public static void checkSumSign() {
        int a = 15;
        int b = -10;

        int sum = a + b;

        if (sum >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }


    }

    public static void printColor() {
        int value = 150;
        if (value <= 0) {
            System.out.println("Красный");
        } else if (value >= 0 && value <= 50) {
            System.out.println("Жёлтый");
        } else {
            System.out.println("Зелёный");
        }

    }

    public static void compareNumbers() {
        int a = 50;
        int b = 150;
        if (a >= b) {
            System.out.println("a>=b");
        } else {
            System.out.println("a<b");
        }
    }

    public static void checkingAmountsWithinLimits(int a, int b) {
        int sum = a + b;
        if (sum > 10 && sum <= 20) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }

    }

    public static void wholeNumber(int number) {
        if (number >= 0) {
            System.out.println("Positive number");
        } else {
            System.out.println("Negative number");
        }


    }

    public static boolean wholeNumberTrueFalse (int number) {
         boolean b = number < 0;
        System.out.println(b);
        return b;


    }
}

