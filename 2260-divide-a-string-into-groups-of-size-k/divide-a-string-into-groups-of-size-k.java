class Solution {
    public String[] divideString(String s, int k, char fill) {
        int len = s.length();
        int groups = (len + k - 1) / k; // ceil(len / k)
        String[] ans = new String[groups];
        int i = 0;
        for (int j = 0; j < groups; j++) {
            if (i + k <= len) {
                ans[j] = s.substring(i, i + k);
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append(s.substring(i)); // remaining characters
                while (sb.length() < k) {
                    sb.append(fill); // fill to reach size k
                }
                ans[j] = sb.toString();
            }
            i += k;
        }
        return ans;
    }
}
