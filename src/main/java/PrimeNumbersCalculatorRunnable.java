import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrimeNumbersCalculatorRunnable implements Runnable {

    public PrimeNumbersCalculatorRunnable() {
    }

    @Override
    public void run() {
        Integer primeNumber;
        int firstPrimeNumber = 2;
        int lastDigitOne = 1;
        int lastDigitTwo = 7;
        while (PrimeNumbersClass.NATURAL_NUMBERS_CANDIDATES.size() > 0) {

            if ("pool-1-thread-1".equals(Thread.currentThread().getName())) {
                firstPrimeNumber = 5;
                lastDigitOne = 3;
                lastDigitTwo = 9;
            }
            int tempPrime;
            if (PrimeNumbersClass.NATURAL_NUMBERS_CANDIDATES.size() > 0) {
                tempPrime = PrimeNumbersClass.NATURAL_NUMBERS_CANDIDATES.peek();

                if (tempPrime % 10 == lastDigitOne || tempPrime % 10 == lastDigitTwo || tempPrime == firstPrimeNumber) {
                    synchronized (PrimeNumbersClass.NATURAL_NUMBERS_CANDIDATES) {
                        primeNumber = PrimeNumbersClass.NATURAL_NUMBERS_CANDIDATES.poll();
                        PrimeNumbersClass.applyEratosthenesAlgoruthmSearchOfPrimeNumbers(primeNumber);
                    }
                    CustomFileWriter.usingBufferedWritter(primeNumber + " ", "d:/test/" + Thread.currentThread().getName() + ".txt");
                    CustomFileWriter.usingBufferedWritter(primeNumber + " ", "d:/test/Result.txt");
                }
            }
        }
    }
}
