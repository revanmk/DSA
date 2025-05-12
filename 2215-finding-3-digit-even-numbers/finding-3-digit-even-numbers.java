class Solution {
    private HashSet<Integer> result=new HashSet<>();
    public int[] findEvenNumbers(int[] digits) {
        boolean[] used=new boolean[digits.length];
        generatePermutations(new ArrayList<>(),digits,used);
        ArrayList<Integer> resultList=new ArrayList<>(result);
        Collections.sort(resultList);
        int ans[]=new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            ans[i] = resultList.get(i);
        }
        return ans;
    }
    public boolean isOdd(int num){
        return (num%2)==0;
    }
    public void generatePermutations(ArrayList<Integer> temp,int[] digits,boolean [] used){
        if(temp.size()==3){
            int num=temp.get(0)*100+temp.get(1)*10+temp.get(2);
            if(num%2==0 && temp.get(0)!=0)
                result.add(num);
            return;
        }
        for(int i=0;i<digits.length;i++)
        {
            if(used[i]==true)   continue;
            used[i]=true;
            temp.add(digits[i]);
            generatePermutations(temp,digits,used);
            temp.remove(temp.size()-1);
            used[i]=false;
        }
    }
}