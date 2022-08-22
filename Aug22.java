342. Power of Four
//TC-O(log4n)
//SC-O(log4n)
/*
class Solution {
    public boolean isPowerOfFour(int n) {
        
        boolean check = false;       
        if(n==0) return check;        
        if(n==1) {
            check = true;
        }             
        if(n%4==0)
            return isPowerOfFour(n/4);
        
        return check;
    }
}
*/
class Solution{
    public boolean isPowerOfFour(int n){
        boolean check = false;
        if(n==0) return false;
            
        while(n%4==0){
            n=n/4;
        }        
        if(n==1) check = true;
        
        return check;
    }
}
