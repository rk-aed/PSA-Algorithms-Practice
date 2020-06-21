package question2;

import java.util.ArrayList;

public class NGray_Test {
	
    
    public void generateGrayarr(int n)  
    {  
        // base case  
        if (n <= 0)  
            return;  
      
        // 'arr' will store all generated codes  
        ArrayList<String> arr = new ArrayList<String> ();  
      
        // start with one-bit pattern  
        arr.add("0");  
        arr.add("1");  
      
        // Every iteration of this loop generates 2*i codes from previously  
        // generated i codes.  
        int i, j;  
        for (i = 2; i < (1<<n); i = i<<1)  
        {  
        	/*
        	System.out.println("####################################");
        	
        	System.out.println("First for loop : values of i : "+i);
        	System.out.println("####################################");
        	*/
        	// Enter the prviously generated codes again in arr[] in reverse  
            // order. Nor arr[] has double number of codes.  
            for (j = i-1 ; j >= 0 ; j--)
            {
            	//System.out.println("Adding wala for loop : values of i : "+i+ " j : "+j);
                arr.add(arr.get(j));              	
            }

      //      System.out.println("Contents of arr : "+arr);
      
            // append 0 to the first half  
            for (j = 0 ; j < i ; j++)
            {
            	//System.out.println("Third for loop : values of i : "+i+ " j : "+j);
                arr.set(j, "0" + arr.get(j));  
            }
            
//            System.out.println("Contents of arr after apending 0 : "+arr);
            
            // append 1 to the second half  
            for (j = i ; j < 2*i ; j++)  {
  //          	System.out.println("Fourth for loop : values of i : "+i+ " j : "+j);
                arr.set(j, "1" + arr.get(j));              	
            }
    //        System.out.println("Contents of arr after apending 1 : "+arr);

        }  
      
        // print contents of arr[]  
        for (i = 0 ; i < arr.size() ; i++ )  
            System.out.print(" "+arr.get(i)+ " ");
        
    }  
      

	

}
