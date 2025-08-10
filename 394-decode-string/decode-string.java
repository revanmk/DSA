class Solution {
    public String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();
        int num=0;
        StringBuilder curr = new StringBuilder();
        for(char ch : s.toCharArray()){
            if(Character.isDigit(ch)){
                num=num*10+(ch-'0');
            }else if(ch=='['){
                countStack.push(num);
                stringStack.push(curr);
                num=0;
                curr=new StringBuilder();
            }
            else if(ch==']'){
                int freq = countStack.pop();
                StringBuilder temp = stringStack.pop();
                for(int i=0;i<freq;i++){
                    temp.append(curr);
                }
                curr=temp;
            }
            else{
                curr.append(ch);
            }
        }
        return curr.toString();        
    }
}