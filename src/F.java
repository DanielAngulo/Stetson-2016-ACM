import java.util.Scanner;
public class F
{

	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		int cases = scan.nextInt();
		scan.nextLine();
		for(int i = 0; i < cases; i++)
		{
			String n = scan.nextLine() + "Z";
			String result = "";
			for(int x = 0; x < n.length() - 1; x++)
			{
				if(n.charAt(x) == n.charAt(x + 1))
				{
					char first = n.charAt(x);
					int count = 2;
					x++;
					while(n.charAt(x) == n.charAt(x + 1))
					{
						x++;
						count++;
					}
					result += count + "" + first;
				}
				else
					result += "1" + n.charAt(x);
			}
			System.out.println(result);
		}
		scan.close();
	}

}
