import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Main Class that calculates whole prime numbers until selected value of N
 * using algorithm of "Sieve of Eratosthenes"
 *
 * @author m.lukyaniuk
 * @see PrimeNumbersHelper
 */
public class CalculatePrime {
    private static final int MAX_THREADS = 2;
    private static final int N = 100;

    public static void main(String[] args) {
        PrimeNumbersHelper primeNumbersCalculator = new PrimeNumbersHelper();
        primeNumbersCalculator.fillNaturalNumbers(N);

        ExecutorService executor = Executors.newFixedThreadPool(MAX_THREADS);
        for (int i = 0; i < MAX_THREADS; i++) {
            Runnable worker = new PrimeNumbersCalculatorRunnable("d:/Thread" + (i+1) + ".txt", i);
            executor.execute(worker);

        }
    }
}

