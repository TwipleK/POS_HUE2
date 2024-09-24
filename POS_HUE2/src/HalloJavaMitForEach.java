import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HalloJavaMitForEach {
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>(List.of("a","b","c","d","e"));

        for (String s : stringList) System.out.println(s);

        stringList.forEach(System.out::println);


    }
}
