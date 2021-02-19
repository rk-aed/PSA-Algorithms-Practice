package arrays_and_strings;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.IntStream;

class Result
{

public static int getMostVisited(int n, List sprints)
{
int[] arr=new int[n+2]; //array for storing total times a position is visited.initialised with 0.
int a,b,mx=0;
for(int i=0; i < sprints.size(); i++  ) {
		
	a=(int)sprints.get(i); b=(int)sprints.get(i+1);
  
//increasing the count of smaller position by 1 and decreasing the count of (larger position+1) by 1
	if(a>b)
		{
		arr[b]++;
		arr[a+1]--;
		}
	else
	{
	arr[a]++;
	arr[b+1]--;
	}
}
for(int i=1;i<=n;i++)
{
arr[i]=arr[i]+arr[i-1]; //prefix sum
}
for(int i=1;i < sprints.size(); i++ ) {
if(arr[i]>mx) //checking the position with larger value
mx=arr[i];
}
return mx; //return the max visited position

}

}

public class Solution1 {
public static void main(String[] args) throws IOException {
BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
int n = Integer.parseInt(bufferedReader.readLine().trim());
int sprintsCount = Integer.parseInt(bufferedReader.readLine().trim());
List sprints = IntStream.range(0, sprintsCount).mapToObj(
i -> {
try {
return bufferedReader.readLine().replaceAll("\\s+$", "");
} catch (IOException ex) {
throw new RuntimeException(ex);
}
}).map(String::trim).map(Integer::parseInt).collect();
int result = Result.getMostVisited(n, sprints);
bufferedWriter.write(String.valueOf(result));
bufferedWriter.newLine();
bufferedReader.close();
bufferedWriter.close();
}

}