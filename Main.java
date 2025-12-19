import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Java 21 Training Sample ===");

        // 1) Variables and basic operations
        int a = 7;
        int b = 5;
        int sum = a + b;
        System.out.printf("%d + %d = %d%n", a, b, sum);

        // 2) Collections and streams
        List<String> names = new ArrayList<>(List.of("Sakura", "Takumi", "Emi", "Daiki"));
        names.stream()
                .sorted(Comparator.naturalOrder())
                .map(String::toUpperCase)
                .forEach(name -> System.out.println("NAME: " + name));

        // 3) Records (immutable data carriers)
        Person person = new Person("Aoi", 21, LocalDate.of(2003, 3, 14));
        System.out.println("Person record: " + person);

        // 4) Switch expression with pattern matching (Java 21)
        Object value = "42";
        String description = switch (value) {
            case Integer i -> "Integer: " + i;
            case String s -> "String: \"" + s + "\" (length=" + s.length() + ")";
            case null -> "null";
            default -> "Unknown type: " + value.getClass().getSimpleName();
        };
        System.out.println("Switch result: " + description);

        // 5) Sealed interface and records
        List<Shape> shapes = List.of(new Circle(2.5), new Rectangle(4, 3));
        for (Shape shape : shapes) {
            System.out.printf("%s area = %.2f%n", shape.name(), shape.area());
        }

        // 6) Text blocks (multi-line strings)
        String message = """
                Java 21 introduces modern language features:
                - Records
                - Sealed types
                - Pattern matching for switch
                - Text blocks
                """;
        System.out.println(message);

        // 7) Simple loop
        int total = 0;
        for (int i = 1; i <= 5; i++) {
            total += i;
        }
        System.out.println("Sum 1..5 = " + total);
    }

    record Person(String name, int age, LocalDate birthday) {
    }

    sealed interface Shape permits Circle, Rectangle {
        double area();
        String name();
    }

    record Circle(double radius) implements Shape {
        @Override
        public double area() {
            return Math.PI * radius * radius;
        }

        @Override
        public String name() {
            return "Circle";
        }
    }

    record Rectangle(double width, double height) implements Shape {
        @Override
        public double area() {
            return width * height;
        }

        @Override
        public String name() {
            return "Rectangle";
        }
    }
}
