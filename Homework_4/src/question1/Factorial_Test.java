package question1;

public class Factorial_Test {
	

    public long fact(int num)
    {
        if (num >= 1)
            return num * fact(num - 1);
        else
            return 1;
    }
	
	

}
