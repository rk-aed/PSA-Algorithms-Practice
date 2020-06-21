package question3;

public class CountBin {
	
	

    public  int countStrings(int n) 
    { 
        int a[] = new int [n]; 
        int b[] = new int [n]; 
        a[0] = b[0] = 1; 
        for (int i = 1; i < n; i++) 
        { 
            a[i] = a[i-1] + b[i-1]; 
            b[i] = a[i-1]; 
        }
        /*
        System.out.println("A");
        for(int t : a) {System.out.print(t+" ");}
        System.out.println();
        System.out.println("B");
        for(int t : b) { System.out.print(t+ " ");}
        System.out.println();
        
        */
        
        return a[n-1] + b[n-1]; 
    } 
	

}
