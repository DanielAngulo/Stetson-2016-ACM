import java.util.Scanner;
public class C 
{

	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		int cases = scan.nextInt();
		while(cases-->0)
		{
			int size = scan.nextInt();
			scan.nextLine();
			char[][] map = new char[size][size];
			for(int i = 0; i < size; i++)
			{
				map[i] = scan.nextLine().toCharArray();
			}
			int total = 0;
			for(int j = 1; j < size; j++)
			{
				for(int x = 0; x < size; x++)
				{
					for(int y = 0; y < size; y++)
					{
						try
						{
							if(map[x][y] == 'o' && (x + j < size && y + j < size) && map[x + j][y] == 'o' && map[x][y + j] == 'o' && map[x + j][y + j] == 'o')
							{
								total++;
							}
						}
						catch(Exception e){;}
					}
				}
			}
			System.out.println(total);
		}
		scan.close();
	}

}
