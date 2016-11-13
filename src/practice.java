import java.util.Scanner;
public class practice 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		String up = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String down = up.toLowerCase();
		int cases = scan.nextInt() + 1;
		while(cases-- > 0)
		{
			String input = scan.nextLine();
			String result = "";
			for(int i = 0; i < input.length(); i++)
			{
				String current = "" + input.charAt(i);
				if(up.contains(current))
					result += down.charAt(up.indexOf(current));
				else if(down.contains(current))
					result += up.charAt(down.indexOf(current));
				else
					result += current;
			}
			System.out.println(result);
		}
		scan.close();
	}
}