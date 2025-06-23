class Solution {
    public boolean checkPrimeFrequency(int[] nums) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }

        int[] count = new int[max + 1];
        for (int num : nums) {
            count[num]++;
        }

        for (int freq : count) {
            if (isPrime(freq)) {
                return true;
            }
        }

        return false;
    }

    public static boolean isPrime(int num) {
        if (num <= 1)
            return false;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }
}
