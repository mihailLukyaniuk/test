import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Main Class that calculates whole prime numbers until selected value of N
 * using algorithm of "Sieve of Eratosthenes"
 *
 * @author m.lukyaniuk
 */
public class CalculatePrime {
    private static final int MAX_THREADS = 2;
//    static final int N = 1000000;



    public static void main(String[] args) {
        PrimeNumbersClass.fillNaturalNumbersCandidates();

        ExecutorService executor = Executors.newFixedThreadPool(MAX_THREADS);
        for (int i = 0; i < MAX_THREADS; i++) {
            Runnable primeNumbersCalculatorRunnable = new PrimeNumbersCalculatorRunnable();
            executor.execute(primeNumbersCalculatorRunnable);
        }
        executor.shutdown();
    }
}
