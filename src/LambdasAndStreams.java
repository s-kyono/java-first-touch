import java.util.List;
import java.util.Optional;

public class LambdasAndStreams {
    public static void main(String[] args) {
        List<String> names = List.of("Taro", "Hanako", "Jiro", "Nanami");

        names.forEach(name -> System.out.println("名前: " + name));

        List<String> longNames = names.stream()
                .filter(name -> name.length() >= 5)
                .map(String::toUpperCase)
                .sorted()
                .toList();
        System.out.println("5文字以上: " + longNames);

        int totalLength = names.stream()
                .mapToInt(String::length)
                .sum();
        System.out.println("文字数の合計: " + totalLength);

        Optional<String> found = names.stream()
                .filter(name -> name.startsWith("H"))
                .findFirst();
        System.out.println("検索結果: " + found.orElse("見つかりません"));
    }
}
