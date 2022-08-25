//Iteration
//TC=O(log3n)
//SC=O(1)
/*class Solution {
    public boolean isPowerOfThree(int n) {
        
        boolean check = false;
        
        if(n==0)
            return check;
        
      while(n!= 1 && n%3==0){
          n=n/3;
      }
        if(n==1)
            check = true;
        
        return check;
    }
    
    
}
*/
//Recursive
//TC=O(log3n)
//SC=O(log3n)

/*class Solution{
    public boolean isPowerOfThree(int n){
        boolean check = false;
        
        if(n==0) return false;
        
        if(n==1){
            check = true;
        }
        
        if(n%3==0 && n!=1){
           return isPowerOfThree(n/3);       
        }
        
        return check;
    }
}
*/
class Solution {
    public boolean isPowerOfThree(int n) {
        
        if(n == 0) return false;
        if(n == 1) return true;
        
        if(n % 3 != 0) return false;
        
        return isPowerOfThree(n/3);    
    }
}
