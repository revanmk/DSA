class Solution {
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
       while(tx>=sx && ty>=sy)
       {
        if(sx==tx && sy==ty)
            return true;
        if(tx>ty)
        {
            if(ty>sy)
                tx=tx%ty;
            else
                return (tx-sx)%ty==0;
        }
        else{
            if(tx>sx)
                ty=ty%tx;
            else
                return (ty-sy)%tx==0;
        }
       }
       return false;
    }
}