import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class NumberTester {
        private NumberTest oddTester;
        private NumberTest palindromeTester;
        private NumberTest primeTester;
        private Map<Integer,Integer> fileMap = new LinkedHashMap<>();

    private static String FILENAME;
    public NumberTester(String fileName){
        FILENAME = fileName;
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
        fileMap.forEach((key, value) -> {
            switch (key){
                case 1:
                    System.out.println(oddTester.testNumber(value));
                case 2:
                    System.out.println(primeTester.testNumber(value));
                case 3:
                    System.out.println(palindromeTester.testNumber(value));
            }
        });


    }

    public void readFile(){
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(FILENAME));
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

        scanner.nextLine();
        while(scanner.hasNext()){
            String[] readLine = scanner.nextLine().split(" ");
            fileMap.put(Integer.parseInt(readLine[0]),Integer.parseInt(readLine[1]));
        }
    }


}
