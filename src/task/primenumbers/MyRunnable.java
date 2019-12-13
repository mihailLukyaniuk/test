package task.primenumbers;

import java.util.concurrent.CopyOnWriteArrayList;

public class MyRunnable implements Runnable {
    private CopyOnWriteArrayList<Integer> naturalNumbers = PrimeNumbersCalculator.NATURAL_NUMBERS;
    private String ownFileName;
    private int option;

    public MyRunnable(String ownFileName, int option) {
        this.ownFileName = ownFileName;
        this.option = option;
    }

    @Override
    public void run() {
        for (int i = option; i < naturalNumbers.size(); i += 2) {
            int primeNumber;
            synchronized (naturalNumbers) {
                primeNumber = naturalNumbers.get(i);
            }
            if (PrimeNumbersCalculator.isPrime(primeNumber)) {
                MyFileWriter.usingBufferedWritter(primeNumber + " ", "d:/Result.txt");
                MyFileWriter.usingBufferedWritter(primeNumber + " ", ownFileName);
            }
        }
    }
}