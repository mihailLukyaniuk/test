import com.sun.istack.internal.NotNull;

import java.util.Arrays;
import java.util.concurrent.LinkedBlockingQueue;

public class PrimeNumbersClass {

    final static LinkedBlockingQueue<Integer> NATURAL_NUMBERS_CANDIDATES = new LinkedBlockingQueue<>();

    static void fillNaturalNumbersCandidates() {
        NATURAL_NUMBERS_CANDIDATES.addAll(Arrays.asList(2, 3, 5));
        for (int i = 7; i <= 500000; i += 2) {
            if (i % 10 != 5) {
                NATURAL_NUMBERS_CANDIDATES.add(i);
            }
        }
    }

    static void applyEratosthenesAlgoruthmSearchOfPrimeNumbers(@NotNull int prime) {
        NATURAL_NUMBERS_CANDIDATES.removeIf(number -> number % prime == 0);
    }
}
