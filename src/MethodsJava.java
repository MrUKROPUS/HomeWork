public class MethodsJava {

    public static void main(String[] args) {
        printThreeWords();
        checkSumSign();
        printColor();
        compareNumbers();
        checkingAmountsWithinLimits(5, 20);
        wholeNumber(-5);
        wholeNumberTrueFalse(-10);
        stringAndNumber("Я не буду зря тратить место в коде", 3);
        steklovataNoviyGod(1900);
        integerArray();
        integerArrayPartTwo();
        integerArrayTheThird();
        squareTwoDimensionalIntegerArray();
        twoArgumentMethod(10,15);

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

    public static boolean wholeNumberTrueFalse(int number) {
        boolean b = number < 0;
        System.out.println(b);
        return b;


    }

    public static void stringAndNumber(String str, int count) {
        for (int i = 0; i < count; i++) {
            System.out.println(str);
        }

    }

    public static boolean steklovataNoviyGod(int year) {
        if (year % 400 == 0) {
            return true;
        } else if (year % 100 == 0) {
            return false;
        } else {
            return year % 4 == 0;
        }
    }

    public static void integerArray() {
        int array[] = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};

        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                array[i] = 1;
            } else {
                array[i] = 0;
            }
        }
        for (int number : array) {
            System.out.println(number + " ");
        }
        System.out.println();
    }

    public static void integerArrayPartTwo() {
        int[] array = new int[100];

        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public static void integerArrayTheThird() {
        int[] array = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};

        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6) {
                array[i] *= 2;
            }
        }

        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void squareTwoDimensionalIntegerArray() {
        int n = 3;

        int[][] array = new int[n][n];

        for (int i = 0; i < n; i++) {
            array[i][i] = 1;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[] twoArgumentMethod(int len, int initialValue) {
        int[] array = new int[len];
        for (int i = 0; i < len; i++) {
            array[i] = initialValue;
        }
        for (int value : array) {
            System.out.print(value + " ");
        }
        return array;
    }
}

