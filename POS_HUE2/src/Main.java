public class Main {
    public static void main(String[] args) {
        NumberTester numberTester = new NumberTester("testFile.txt");
        numberTester.setPalindromeTester(number -> {
            StringBuilder stringBuilder = new StringBuilder(number);
            stringBuilder.reverse();
            return stringBuilder.toString().equals(String.valueOf(number));
        });

        numberTester.setOddEvenTester((number) -> number % 2 == 0);

        numberTester.setPrimeTester((number) ->{
            EratosthenesPrimeSieve primeTester = new EratosthenesPrimeSieve(number);
            return primeTester.isPrime(number);
        });


    }
}
