public class Arrays {
    public static void main(String[] args) {
        int[] numbers = {5, 2, 8, 1, 4};
        System.out.println("要素数: " + numbers.length);
        System.out.println("先頭: " + numbers[0]);

        numbers[0] = 10;
        java.util.Arrays.sort(numbers);
        System.out.println("並べ替え後: " + java.util.Arrays.toString(numbers));

        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6}
        };

        for (int[] row : matrix) {
            for (int number : row) {
                System.out.print(number + " ");
            }
            System.out.println();
        }

        int[] copy = java.util.Arrays.copyOf(numbers, numbers.length);
        System.out.println("コピー内容は同じ: " + java.util.Arrays.equals(numbers, copy));
    }
}
