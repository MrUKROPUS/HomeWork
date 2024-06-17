public class Main {

    public static class MyArraySizeException extends Exception {
        MyArraySizeException(String msg) {
            super(msg);
        }
    }


    public static class MyArrayDataException extends Exception {
        public int i;
        public int j;

        MyArrayDataException(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public static void main(String[] args) {
        String[][] arr = new String[][]{
                {"1", "2", "3", "4"},
                {"2", "2", "2", "3"},
                {"1", "2", "2", "2"},
                {"2", "2", "2", "2"}
        };

        try {
            int result = method(arr);
            System.out.println(result);
        } catch (MyArraySizeException e) {
            System.out.println("Размер массива превышен!");
        } catch (MyArrayDataException e) {
            System.out.println("Неправильное значение массива!");
            System.out.println("Ошибка в ячейке: " + e.i + "x" + e.j);
        }
    }

    public static int method(String[][] arr) throws MyArraySizeException, MyArrayDataException {
        int count = 0;
        if (arr.length != 4) {
            throw new MyArraySizeException("Размер массива превышен!");
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length != 4) {
                throw new MyArraySizeException("Размер массива превышен!");
            }
            for (int j = 0; j < arr[i].length; j++) {
                try {
                    count += Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j);
                }
            }
        }
        return count;
    }
}