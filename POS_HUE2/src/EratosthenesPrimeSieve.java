
public class EratosthenesPrimeSieve implements PrimeSieve{

    private boolean[] primes;

    public EratosthenesPrimeSieve(int n)
    {

        primes = new boolean[n+1];

        for (int i = 2; i <= n; i++) primes[i] = true;

        for (int i = 2; i <= Math.sqrt(n); i++) if (primes[i]) for (int j = i*i; j <= n; j+=i) primes[j] = false;




    }


    @Override
    public boolean isPrime(int p) {
        return primes[p];
    }

    @Override
    public void printPrimes() {
        for (int i = 2; i < primes.length; i++) if (primes[i]) System.out.print(i + " ");

    }
}
