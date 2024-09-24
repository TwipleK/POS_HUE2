public class Main {
    public static void main(String[] args) {
        NumberTester numberTester = new NumberTester("testFile.txt");
        numberTester.setPalindromeTester(number -> {
            StringBuilder stringBuilder = new StringBuilder(number);
            stringBuilder.reverse();
            return stringBuilder.equals(number);
        });
        numberTester.setOddEvenTester((number) -> number % 2 == 0);
        numberTester.setPrimeTester();


    }
}
