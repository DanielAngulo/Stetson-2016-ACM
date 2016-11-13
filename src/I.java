import java.util.ArrayList;
import java.util.Scanner;
public class I
{

	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		int cases = scan.nextInt();
		scan.nextLine();
		while(cases-- > 0)
		{
			ArrayList<String> part = new ArrayList<String>();
			String word = scan.nextLine();
			if(isPalindrome(word))
				part.add(word);
			for(int i = 0; i < word.length(); i++)
			{
				for(int j = word.length() - 1; j > 0; j--)
				{
					try
					{
						String sub = word.substring(i, i + j);
						if(isPalindrome(sub))
						{
							if(!part.contains(sub))
								part.add(sub);
						}
					}
					catch(Exception e){;}
				}
			}
			String result = "";
			for(String str : part)
				result += str + " " ;
			System.out.println(result.trim());
		}
		scan.close();
	}
	
	public static boolean isPalindrome(String str)
	{
		
		return ("" + new StringBuilder(str).reverse()).equals("" + (new StringBuilder(str)));
	}
}
