import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


public class NumberTester {
        private NumberTest oddTester;
        private NumberTest palindromeTester;
        private NumberTest primeTester;

        private List<Map<Integer,Integer>> fileMapList = new ArrayList<>();
//        private Map<Integer,Integer> fileMap = new LinkedHashMap<>();

    private static String FILENAME;
    public NumberTester(String fileName){
        FILENAME = fileName;
        readFile();
    }

    public void setOddEvenTester (NumberTest oddTester){
        this.oddTester = oddTester;
    }

    public void setPrimeTester(NumberTest primeTester){
        this.primeTester = primeTester;
    }

    public void setPalindromeTester(NumberTest palindromeTester){
        this.palindromeTester = palindromeTester;
    }

    public void testFile(){

        fileMapList.forEach((map) -> map.forEach((key, value) -> {
            switch (key){
                case 1 -> System.out.println(oddTester.testNumber(value) ? "EVEN" : "ODD");
                case 2 -> System.out.println(primeTester.testNumber(value) ? "PRIME" : "NO PRIME");
                case 3 -> System.out.println(palindromeTester.testNumber(value) ? "PALINDROME" : "NO PALINDROME");
            }
        }));


    }

    private void readFile(){
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(FILENAME));
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

        scanner.nextLine();

        while(scanner.hasNext()){
            String[] readLine = scanner.nextLine().split(" ");

            HashMap<Integer,Integer> listMap = new HashMap<>();
            listMap.put(Integer.parseInt(readLine[0]),Integer.parseInt(readLine[1]));
            fileMapList.add(listMap);
        }
    }


}
