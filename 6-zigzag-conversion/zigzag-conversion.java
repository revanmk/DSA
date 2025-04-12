class Solution {
    public String convert(String s, int numRows) {
        StringBuilder ans=new StringBuilder();
        if(s.length()<=numRows || numRows<=1)
            return s;
        ArrayList<StringBuilder> rows=new ArrayList<>();
        for(int i=0;i<Math.min(s.length(),numRows);i++)
        {
            rows.add(new StringBuilder());
        }
        int currRow=0;
        boolean flag=false;
        for(char c:s.toCharArray()){
            rows.get(currRow).append(c);
            if(currRow==0||currRow==numRows-1)
                flag=!flag;
            currRow+=flag?1:-1;
        }
        for(StringBuilder row:rows){
            ans.append(row);
        }
        return ans.toString();
    }
}