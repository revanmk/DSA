class Solution {
    public int countGoodNumbers(long n) {
        int mod = (int)1e9 + 7;
        return (int)((powerMod(5, (n + 1) / 2, mod) * powerMod(4, n / 2, mod)) % mod);
    }

    public long powerMod(int a, long b, int mod) {
        if (b == 0)
            return 1;
        long x = powerMod(a, b / 2, mod);
        if (b % 2 == 0)
            return (x * x) % mod;
        else
            return (((a * x) % mod) * x) % mod;
    }
}
