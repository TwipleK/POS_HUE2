import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class NumberTester {
        private NumberTest oddTester;
        private NumberTest palindromeTester;
        private NumberTest primeTester;
        Map<Integer,Integer> fileMap = new HashMap<>();

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


    }

    public void readFile(){
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(FILENAME));
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }


        while(scanner.hasNext()){
            String[] readLine = scanner.nextLine().split(" ");
            fileMap.put(Integer.parseInt(readLine[0]),Integer.parseInt(readLine[1]));
        }
    }


}
