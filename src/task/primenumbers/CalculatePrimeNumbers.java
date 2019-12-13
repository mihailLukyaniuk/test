package task.primenumbers;

import java.util.LinkedList;

/**
 * Main Class that calculates whole prime numbers until selected value of N
 * using algorithm of "Sieve of Eratosthenes"
 * @see PrimeNumbersCalculator
 *
 * @author m.lukyaniuk
 */
public class CalculatePrimeNumbers {
    public static void main(String[] args) {
        int N = 1000000;

        PrimeNumbersCalculator primeNumbersCalculator = new PrimeNumbersCalculator();
        primeNumbersCalculator.fillNaturalNumbers(N);
        primeNumbersCalculator.calculatePrimeNumbers();
    }
}
