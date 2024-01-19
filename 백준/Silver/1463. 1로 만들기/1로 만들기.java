import java.util.Arrays;
import java.util.Scanner;

public class Main
{
	static int d[];

	public static void main(String[] args) throws Exception
	{
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		d = new int[N+1];

		d[1] = 0;
		for (int i = 2; i < N+1; i++)
		{
			d[i] = d[i-1]+1;
			if (i % 2 == 0 && d[i] > d[i/2]+1)
			{
				d[i] = d[i/2]+1;
			}
			if (i % 3 == 0 && d[i] > d[i/3]+1)
			{
				d[i] = d[i/3]+1;
			}
		}
		System.out.println(d[N]);
	}
}
