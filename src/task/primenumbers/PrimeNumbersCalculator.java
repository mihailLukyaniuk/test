package task.primenumbers;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * This Class calculating prime numbers and while execution
 * adding founded prime numbers to selected files
 * using class MyFileWriter:
 *
 * @author m.lukyaniuk
 * @see MyFileWriter
 */
public class PrimeNumbersCalculator {

    final static CopyOnWriteArrayList<Integer> NATURAL_NUMBERS = new CopyOnWriteArrayList<>();

    public void fillNaturalNumbers(int maxNumber) {
        NATURAL_NUMBERS.add(2);
        for (int i = 3; i <= maxNumber; i += 2) {
            NATURAL_NUMBERS.add(i);
        }
    }

    void calculatePrimeNumbers() {

        new Thread(new MyRunnable("d:/Thread1.txt", 0)).start();
        new Thread(new MyRunnable("d:/Thread2.txt", 1)).start();

    }

    static boolean isPrime(int n) {
        for (int i = 2; i < n; i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }


}

