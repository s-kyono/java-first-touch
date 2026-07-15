public class VariablesAndTypes {
    public static void main(String[] args) {
        // プリミティブ型
        byte smallNumber = 127;
        short shortNumber = 32_000;
        int age = 20;
        long population = 8_000_000_000L;
        float rate = 1.5F;
        double price = 1_280.50;
        char grade = 'A';
        boolean isActive = true;

        // 参照型
        String name = "Taro";

        // 再代入できない定数
        final double TAX_RATE = 0.10;

        // ローカル変数の型推論。var にも静的な型が付く
        var message = name + " is " + age + " years old.";

        System.out.println(message);
        System.out.printf("byte=%d, short=%d, long=%d%n", smallNumber, shortNumber, population);
        System.out.printf("float=%.1f, price=%.2f, grade=%c, active=%b%n", rate, price, grade, isActive);
        System.out.println("税込価格: " + price * (1 + TAX_RATE));
    }
}
