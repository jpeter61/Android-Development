package me.jamiepeterson.a16primenumbers;

public class Primes {
    private int primeCount;

    public Primes(int primeCount){
        this.primeCount = primeCount;
    }

    public int[] getPrimes() {

        int[] primes = new int[primeCount];
        for(int i = 0; i < primeCount; i++)
            primes[i]=0;
        int count = 2;
        int i = 0;
        while (primes[primeCount - 1] == 0){
            if(isPrime(count)){
                primes[i] = count;
                i++;
            }
            count ++;
        }
        return primes;
    }

    private boolean isPrime(int maybePrime){
        if (maybePrime == 2 || maybePrime == 3) {
            return true;
        }
        if (maybePrime % 2 == 0) {
            return false;
        }
        int sqrt = (int) Math.sqrt(maybePrime) + 1;
        for (int i = 3; i < sqrt; i += 2) {
            if (maybePrime % i == 0) {
                return false;
            }
        }
        return true;
    }
}
