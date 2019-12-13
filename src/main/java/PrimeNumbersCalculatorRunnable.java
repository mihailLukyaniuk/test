import java.util.concurrent.CopyOnWriteArrayList;

public class PrimeNumbersCalculatorRunnable implements Runnable {
    private CopyOnWriteArrayList<Integer> naturalNumbers;
    private String ownFileName;
    private int option;

    public PrimeNumbersCalculatorRunnable(String ownFileName, int option) {
        this.ownFileName = ownFileName;
        this.option = option;
        this.naturalNumbers = PrimeNumbersHelper.NATURAL_NUMBERS;
    }

    @Override
    public void run() {
        for (int i = option; i < naturalNumbers.size(); i += 2) {
            int primeNumber;
                primeNumber = naturalNumbers.get(i);
            if (PrimeNumbersHelper.isPrime(primeNumber)) {
                CustomFileWriter.usingBufferedWritter(primeNumber + " ", "d:/Result.txt");
                CustomFileWriter.usingBufferedWritter(primeNumber + " ", ownFileName);
            }
        }
    }
}