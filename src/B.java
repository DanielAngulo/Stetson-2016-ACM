import java.util.Scanner;
public class B 
{

	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		int cases = scan.nextInt();
		scan.nextLine();
		for(int i = 0; i < cases; i++)
		{
			String input = scan.nextLine();
			if(input.charAt(0) == '0')
			{
				System.out.println(Long.parseLong(input, 2));
			}
			else
			{
				String result = "";
				char[] array = new char[input.length()];
				for(int x = 0; x < array.length; x++)
				{
					if(input.charAt(x) == '0')
						result += "1";
					else
						result += "0";
				}
				long l = -Long.parseLong(result, 2) - 1;
				System.out.println(l);
			}
		}
		scan.close();
	}

}
