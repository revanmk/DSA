class Solution {
    public int subsetXORSum(int[] nums) {
        if(nums.length==1)
            return nums[0]; 
        ArrayList<ArrayList<Integer>> list=new ArrayList<>();
        ArrayList<Integer> a=new ArrayList<>();
        generateSubSet(0,nums,a,list);
        int sum=0;
        for(ArrayList<Integer> i : list){
            int x=0;
            for(int j : i)
            {
                x^=j;
            }
            sum+=x;
        }
        return sum;

    }
    public static void generateSubSet(int i,int nums[],ArrayList<Integer> temp,ArrayList<ArrayList<Integer>> list){
        if(i>=nums.length){
            list.add(new ArrayList<>(temp));
            return;
        }
        temp.add(nums[i]);
        generateSubSet(i+1,nums,temp,list);
        temp.remove(temp.size()-1);
        generateSubSet(i+1,nums,temp,list);
    }
}