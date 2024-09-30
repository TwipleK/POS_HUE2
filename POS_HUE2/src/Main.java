import java.util.Comparator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        NumberTester numberTester = getNumberTester();
        numberTester.testFile();


        boolean running = true;

            RationalCalculator rationalCalculator = new RationalCalculator((a,b)-> {
                double denominator = a.getB()*b.getB();
                double numerator = a.getA() * a.getB() + b.getA() * b.getB();


                double greatestCommonDivisor = calculateGreatestCommonDivisor(denominator, numerator);

                Number result = new Number();
                result.setA(numerator / greatestCommonDivisor);
                result.setB(denominator / greatestCommonDivisor);

                return result;
            }, (a,b) -> {
                double denominator = a.getB() * b.getB();
                double numerator = a.getA() * b.getB() - b.getA()* a.getB();

                double greatestCommonDivisor = calculateGreatestCommonDivisor(denominator, numerator);

                Number result = new Number();
                result.setA(numerator / greatestCommonDivisor);
                result.setB(denominator / greatestCommonDivisor);

                return result;

            }, (a,b) -> {
                double numerator = a.getA() * b.getA();
                double denominator = a.getB() * b.getB();

                double greatestCommonDivisor = calculateGreatestCommonDivisor(denominator, numerator);

                Number result = new Number();
                result.setA(numerator / greatestCommonDivisor);
                result.setB(denominator / greatestCommonDivisor);

                return result;
            }, (a,b) -> {
                double numerator = a.getA() * b.getB();
                double denominator = a.getB() * b.getA();

                double greatestCommonDivisor = calculateGreatestCommonDivisor(denominator, numerator);

                Number result = new Number();
                result.setA(numerator / greatestCommonDivisor);
                result.setB(denominator / greatestCommonDivisor);

                return result;
            });



            VectorCalculator vectorCalculator = new VectorCalculator((a,b) -> {
                double newA = a.getA() + b.getA();
                double newB = a.getB() + b.getB();

                Number result = new Number();
                result.setA(newA);
                result.setB(newB);

                return result;
            }, (a,b) ->{
                double newA = a.getA() - b.getA();
                double newB = a.getB() - b.getB();

                Number result = new Number();
                result.setA(newA);
                result.setB(newB);

                return result;
            }, (a,b) -> {
                double crossProduct = a.getA() * b.getB() - a.getB() * b.getA();

                Number result = new Number();
                result.setA(crossProduct);
                result.setB(0);

                return result;
            }, (a,b) -> {
                double dotProduct = a.getA() * b.getA() + a.getB() * b.getB();

                Number result = new Number();
                result.setA(dotProduct);
                result.setB(0);

                return result;
            });



            ComplexCalculator complexCalculator = new ComplexCalculator((a,b) -> {
                Number result = new Number();
                result.setA(a.getA() + b.getA());
                result.setB( a.getB() + b.getB());

                return result;
            },(a,b) ->{
                Number result = new Number();
                result.setA(a.getA() - b.getA());
                result.setB(a.getB() - b.getB());

                return result;
            }, (a,b) -> {
                Number result = new Number();
                result.setA(a.getA() * b.getA() - a.getB() * b.getB());
                result.setA(a.getA() * b.getB() + a.getB() * b.getA());

                return result;
            }, (a,b) -> {
                double denominator = b.getA() * b.getA() + b.getB() * b.getB();

                Number result = new Number();
                result.setA((a.getA() * b.getA() + a.getB() * b.getB()) / denominator);
                result.setB((a.getB() * b.getB() - a.getA() * b.getB()) / denominator);

                return result;
            });



        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Choose calculator:");
            System.out.println("1 = Rational calculator");
            System.out.println("2 = Vector calculator");
            System.out.println("3 = Complex calculator");
            System.out.println("4 = Exit program");
            System.out.print("> ");

            int calculatorChoice = 0;
            try {
                calculatorChoice = scanner.nextInt();
            } catch (Exception e) {
                continue;
            }


            if (calculatorChoice == 4) {
                break;
            }


            double xA = 0;
            double xB = 0;
            double yA = 0;
            double yB = 0;
            try {
                System.out.print("Enter number x a> ");
                xA = scanner.nextDouble();
                System.out.print("Enter number x b> ");
                xB = scanner.nextDouble();

                System.out.print("Enter number y a> ");
                yA = scanner.nextDouble();
                System.out.print("Enter number y b> ");
                yB = scanner.nextDouble();
            } catch (Exception e) {
                continue;
            }


            Number numberX = new Number();
            numberX.setA(xA);
            numberX.setB(xB);

            Number numberY = new Number();
            numberY.setA(yA);
            numberY.setB(yB);


                System.out.println("Choose operation:");
                System.out.println("1 = add");
                System.out.println("2 = subtract");
                System.out.println("3 = multiply");
                System.out.println("4 = divide");
                System.out.println("5 = enter calculators again");
                System.out.print("> ");

            int operationChoice = 0;
            try {
                operationChoice = scanner.nextInt();
            } catch (Exception e) {
                continue;
            }

            if (operationChoice == 5) {
                    continue;
                }

                Number result = null;

                switch (calculatorChoice) {
                    case 1: // Rational Calculator
                        switch (operationChoice) {
                            case 1:
                                result = rationalCalculator.add(numberX, numberY);
                                break;
                            case 2:
                                result = rationalCalculator.subtract(numberX, numberY);
                                break;
                            case 3:
                                result = rationalCalculator.multiply(numberX, numberY);
                                break;
                            case 4:
                                result = rationalCalculator.divide(numberX, numberY);
                                break;
                        }
                        break;
                    case 2: // Vector Calculator
                        switch (operationChoice) {
                            case 1:
                                result = vectorCalculator.add(numberX, numberY);
                                break;
                            case 2:
                                result = vectorCalculator.subtract(numberX, numberY);
                                break;
                            case 3:
                                result = vectorCalculator.multiply(numberX, numberY);
                                break;
                            case 4:
                                result = vectorCalculator.divide(numberX, numberY);
                                break;
                        }
                        break;
                    case 3: // Complex Calculator
                        switch (operationChoice) {
                            case 1:
                                result = complexCalculator.add(numberX, numberY);
                                break;
                            case 2:
                                result = complexCalculator.subtract(numberX, numberY);
                                break;
                            case 3:
                                result = complexCalculator.multiply(numberX, numberY);
                                break;
                            case 4:
                                result = complexCalculator.divide(numberX, numberY);
                                break;
                        }
                        break;
                    default: continue;
                }

                if (result != null) {
                    System.out.println("=========================");
                    System.out.println("Solution:");
                    System.out.println("a = " + result.getA());
                    System.out.println("b = " + result.getB());
                    System.out.println("=========================");
                }
            }

    }


    private static NumberTester getNumberTester() {
        NumberTester numberTester = new NumberTester("testFile.txt");
        numberTester.setPalindromeTester(number -> {
            StringBuilder stringBuilder = new StringBuilder(String.valueOf(number));
            stringBuilder.reverse();
            return stringBuilder.toString().equals(String.valueOf(number));
        });

        numberTester.setOddEvenTester((number) -> number % 2 == 0);

        numberTester.setPrimeTester((number) ->{
            EratosthenesPrimeSieve primeTester = new EratosthenesPrimeSieve(number);
            return primeTester.isPrime(number);
        });
        return numberTester;
    }

    private static double calculateGreatestCommonDivisor(double a, double b){
        if (a == 0) return b;
        return calculateGreatestCommonDivisor(b%a,a);
    }

}
