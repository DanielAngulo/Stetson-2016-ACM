//We did not finish this one!

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
public class D 
{

	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		int height = scan.nextInt() + 2;
		scan.nextLine();
		char[][] map = new char[height][3];
		int[][] distances = new int[height][3];
		for(int i = 0; i < height; i++)
		{
			map[i] = "...".toCharArray();
			Arrays.fill(distances[i], -1);
		}
		P start = new P(height - 1, 1);
		P end = new P(0, 1);
		for(int i = height - 2; i >= 1; i--)
		{
			String input = scan.nextLine();
			if(input.equals("right"))
				map[i][2] = 'x';
			else if(input.equals("left"))
				map[i][0] = 'x';
			else
				map[i][1] = 'x';
		}
		ArrayList<P> queue = new ArrayList<P>();
		queue.add(start);
		distances[start.x][start.y] = 0;
		while(!queue.isEmpty())
		{
			P current = queue.remove(0);
			int x = current.x;
			int y = current.y;
			if(x - 1 >= 0 && map[x - 1][y] == '.' && distances[x - 1][y] == -1)
			{
				distances[x - 1][y] = distances[x][y] + 1;
				queue.add(new P(x - 1, y));
			}
			if(y - 1 >= 0 && map[x][y - 1] == '.' && distances[x][y - 1] == -1)
			{
				distances[x][y - 1] = distances[x][y] + 1;
				queue.add(new P(x, y - 1));
			}
			if(y + 1 < 3 && map[x][y + 1] == '.' && distances[x][y + 1] == -1)
			{
				distances[x][y + 1] = distances[x][y] + 1;
				queue.add(new P(x, y + 1));
			}
		}
		int distance = distances[end.x][end.y];
		int x = 0, y = 1;
		ArrayList<String> directions = new ArrayList<String>();
		while(distance != 0)
		{
			int check = distance - 1;
			boolean up = x + 1 < height && distances[x + 1][y] == check;
			boolean right = y - 1 >= 0 && distances[x][y - 1] == check;
			boolean left = y + 1 < 3 && distances[x][y + 1] == check;
			if(up && right || up && left)
			{
				x++;
				directions.add(0, "nothing");
			}
			else if(right)
			{
				y++;
				directions.add(0, "right");
			}
			else if(left)
			{
				y--;
				directions.add(0, "left");
			}
			distance--;
		}
		for(int i = 0; i < directions.size() - 1; i++)
		{
			if(directions.get(i).equals("right") || directions.get(i).equals("left"))
			{
				directions.remove(i + 1);
			}
		}
		for(String str : directions)
			System.out.println(str);
		scan.close();
	}

}

class P
{
	int x = 0;
	int y = 0;
	
	public P(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
}
