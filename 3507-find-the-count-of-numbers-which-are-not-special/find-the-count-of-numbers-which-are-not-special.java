class Solution {
    List<Integer> specials = new ArrayList<>();
    Solution(){
        generateSpecialNumbers();
    }
    public int nonSpecialCount(int l, int r) {
        int ans = r-l+1;
        for(int a : specials){
            if(a>=l && a<=r){
                ans--;
            }
        }
        return ans;
    }

    public void generateSpecialNumbers() {
        int limit = (int)Math.sqrt(1e9);
        boolean prime[] = new boolean[limit + 1];
        Arrays.fill(prime, true);
        prime[0] = prime[1] = false;
        for (int i = 2; i*i <= limit; i++) {
            if (prime[i]) {
                for (int j = i * i; j <= limit; j+=i) {
                    prime[j] = false;
                }
            }
        }
        for (int i = 0; i < limit + 1; i++) {
            if (prime[i]) {
                specials.add(i * i);
            }
        }
    }
}