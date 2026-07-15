public class RecordsEnumsAndSealedTypes {
    public static void main(String[] args) {
        User user = new User(1, "Taro");
        System.out.println(user.name() + ": " + user);

        OrderStatus status = OrderStatus.SHIPPED;
        System.out.println("注文状態: " + status.label());

        Shape circle = new Circle(3.0);
        Shape rectangle = new Rectangle(4.0, 5.0);
        System.out.printf("円の面積: %.2f%n", circle.area());
        System.out.printf("長方形の面積: %.2f%n", rectangle.area());
    }
}

record User(int id, String name) {
    User {
        if (id <= 0 || name == null || name.isBlank()) {
            throw new IllegalArgumentException("idとnameを正しく指定してください");
        }
    }
}

enum OrderStatus {
    PENDING("受付済み"),
    SHIPPED("発送済み"),
    DELIVERED("配達済み");

    private final String label;

    OrderStatus(String label) {
        this.label = label;
    }

    String label() {
        return label;
    }
}

sealed interface Shape permits Circle, Rectangle {
    double area();
}

record Circle(double radius) implements Shape {
    @Override
    public double area() {
        return Math.PI * radius * radius;
    }
}

record Rectangle(double width, double height) implements Shape {
    @Override
    public double area() {
        return width * height;
    }
}
