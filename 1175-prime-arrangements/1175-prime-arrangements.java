class Solution {
    public int numPrimeArrangements(int n) {
        int prime = 0;
        for (int i = 2; i <= n; i++) {
            boolean isPrime = true;
            for (int j = 2; j * j <= i; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                prime++;
            }
        }
        int nonPrime = n - prime;
        long mod = 1000000007;
        long ans = 1;
        for (int i = 1; i <= prime; i++) {
            ans = (ans * i) % mod;
        }
        for (int i = 1; i <= nonPrime; i++) {
            ans = (ans * i) % mod;
        }
        return (int) ans;
    }
}