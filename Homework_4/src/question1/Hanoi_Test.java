package question1;

public class Hanoi_Test {
    static int count = 0;
    public void towerOfHanoi(int n, char from_rod, char to_rod, char aux_rod) 
    { 
    	System.out.println(" Call "+ ++count + " parameters, from : " +from_rod + " "+", to_rod : "+to_rod+", aux_rod : "+aux_rod);
    	
    //	System.out.println(" n "+n);
        if (n == 1) 
        { 
            System.out.println("Move disk 1 from rod " +  from_rod + " to rod " + to_rod); 
            return; 
        } 
        towerOfHanoi(n-1, from_rod, aux_rod, to_rod); 
        System.out.println("Move disk " + n + " from rod " +  from_rod + " to rod " + to_rod); 
        towerOfHanoi(n-1, aux_rod, to_rod, from_rod); 
    } 

    public  void moves(int n, boolean left) {
        if (n == 0) return;
        moves(n-1, !left);
        if (left) {
        	System.out.println(n + " left");
        	
        }
        else      
        	{
        		System.out.println(n + " right");
        	
        	}
        moves(n-1, !left);
    }
	
	
	

}
