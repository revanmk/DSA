class Solution {
    public boolean lemonadeChange(int[] bills) {
        HashMap<Integer,Integer> hm=new HashMap<>(); 
        hm.put(5, 0); 
        hm.put(10, 0);
        for(int i=0;i<bills.length;i++)
        {
            if(bills[i]==5){
                hm.put(5,hm.get(5)+1);
            }
           else if(bills[i]==10){
               if(hm.get(5)>0){
                hm.put(5,hm.get(5)-1);
                hm.put(10,hm.get(10)+1);
                }           
                else{
                return false;
                }
            }
            else{
                if(hm.get(10)>0&& hm.get(5)>0)
                {
                hm.put(5,hm.get(5)-1);
                hm.put(10,hm.get(10)-1);
                }
                else if(hm.get(5)>=3){
                    hm.put(5,hm.get(5)-3);
                }
                else{
                    return false;
                }
            }
        }
        return true;
    }
}
