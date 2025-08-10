class Solution {
    List<List<Integer>> permutations = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        generatePermutations(nums,0);
        return permutations;
    }
    public void generatePermutations(int[] nums,int index){
        if(index==nums.length){
            List<Integer> temp = new ArrayList<>();
            for(int num:nums){
                temp.add(num);
            }
            permutations.add(new ArrayList<>(temp));
            return;
        }
        Set<Integer> set = new HashSet<>();
        for(int i=index;i<nums.length;i++){
            if(set.contains(nums[i])){
                continue;
            }else{
                set.add(nums[i]);
            }
            swap(i,index,nums);
            generatePermutations(nums,index+1);
            swap(i,index,nums);

        }
    }
    private void swap(int i, int j, int[] arr){
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}