import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CollectionsAndGenerics {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Taro");
        names.add("Hanako");
        names.add("Jiro");
        System.out.println("List: " + names);

        Set<Integer> uniqueNumbers = new HashSet<>(List.of(1, 2, 2, 3));
        System.out.println("Set: " + uniqueNumbers);

        Map<String, Integer> scores = new HashMap<>();
        scores.put("Taro", 80);
        scores.put("Hanako", 95);
        scores.forEach((name, score) -> System.out.println(name + ": " + score));

        Box<String> box = new Box<>("Java");
        System.out.println("Box: " + box.get());
        System.out.println("Listの先頭: " + first(names));
    }

    static <T> T first(List<T> values) {
        if (values.isEmpty()) {
            throw new IllegalArgumentException("空のListです");
        }
        return values.getFirst(); // Java 21 の SequencedCollection API
    }
}

class Box<T> {
    private final T value;

    Box(T value) {
        this.value = value;
    }

    T get() {
        return value;
    }
}
