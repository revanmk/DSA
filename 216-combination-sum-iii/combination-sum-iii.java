class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        int index=1;
        List<List<Integer>> ans=new ArrayList<>();
        check(index,k,n,ans,new ArrayList<>());
        return ans;
    }
    public void check(int index,int k,int n,List<List<Integer>> ans,List<Integer> temp){
        if(temp.size()==k && n==0){
            ans.add(new ArrayList<>(temp));
            return;
        }
        for(int i=index;i<=9;i++)
        {
           
                temp.add(i);
                check(i+1,k,n-i,ans,temp);
                temp.remove(temp.size()-1);
        }
        }
    }