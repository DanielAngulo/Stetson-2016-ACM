import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class G 
{

	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		int amount = scan.nextInt();
		scan.nextLine();
		ArrayList <Word> original = new ArrayList<Word>();
		for(int i = 0; i < amount; i++)
		{
			String input = scan.nextLine();
			char[] array = input.toUpperCase().toCharArray();
			Arrays.sort(array);
			original.add(new Word(input, new String(array)));
		}
		for(int i = 0; i < original.size() - 1; i++)
		{
			boolean duplicate = false;
			for(int x = i + 1; x < original.size(); x++)
			{
				if(original.get(i).anagram.equals(original.get(x).anagram))
				{
					duplicate = true;
					original.remove(x);
					x--;
				}
			}
			if(duplicate)
			{
				original.remove(i);
				i--;
			}
		}
		for(Word w : original)
			System.out.println(w.actual);
	}

}

class Word
{
	String actual;
	String anagram;
	
	public Word(String actual, String anagram)
	{
		this.actual = actual;
		this.anagram = anagram;
	}
}