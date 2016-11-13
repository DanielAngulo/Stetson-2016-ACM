import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
public class A 
{

	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		Point start = null, end = null;
		int cases = scan.nextInt();
		scan.nextLine();
		while(cases -- >0)
		{
			char[][] map = new char[4][5];
			int[][] distances = new int[4][5];
			for(int i = 0; i < 4; i++)
			{
				String input = scan.nextLine();
				char[] line = input.toCharArray();
				if(input.contains("P"))
					start = new Point(i, input.indexOf("P"));
				if(input.contains("O"))
				{
					end = new Point(i, input.indexOf("O"));
					line[input.indexOf("O")] = 'o';
				}
				map[i] = line;
				Arrays.fill(distances[i], -1);
			}
			ArrayList<Point> queue = new ArrayList<Point>();
			queue.add(start);
			distances[start.x][start.y] = 0;
			while(!queue.isEmpty())
			{
				Point current = queue.remove(0);
				int x = current.x;
				int y = current.y;
				if(x - 1 >= 0 && map[x - 1][y] == 'o' && distances[x - 1][y] == -1)
				{
					distances[x - 1][y] = distances[x][y] + 1;
					queue.add(new Point(x - 1, y));
				}
				if(x + 1 < 4 && map[x + 1][y] == 'o' && distances[x + 1][y] == -1)
				{
					distances[x + 1][y] = distances[x][y] + 1;
					queue.add(new Point(x + 1, y));
				}
				if(y - 1 >= 0 && map[x][y - 1] == 'o' && distances[x][y - 1] == -1)
				{
					distances[x][y - 1] = distances[x][y] + 1;
					queue.add(new Point(x, y - 1));
				}
				if(y + 1 < 5 && map[x][y + 1] == 'o' && distances[x][y + 1] == -1)
				{
					distances[x][y + 1] = distances[x][y] + 1;
					queue.add(new Point(x, y + 1));
				}
			}
			int distance = distances[end.x][end.y];
			System.out.println(distance);
			int x = end.x;
			int y = end.y;
			ArrayList<String> instructions = new ArrayList<String>();
			while(distance != 0)
			{
				if(x - 1 >= 0 && distances[x - 1][y] == distance - 1)
				{
					instructions.add(0, "DOWN");
					distance--;
					x--;
				}
				else if(x + 1 < 4 && distances[x + 1][y] == distance -1)
				{
					instructions.add(0, "UP");
					distance--;
					x++;
				}
				else if(y - 1 >= 0 && distances[x][y - 1] == distance - 1)
				{
					instructions.add(0, "RIGHT");
					distance--;
					y--;
				}
				else if(y + 1 < 5 && distances[x][y + 1] == distance - 1)
				{
					instructions.add(0, "LEFT");
					distance--;
					y++;
				}
			}
			for(String str : instructions)
				System.out.println(str);
		}
		scan.close();
	}

}


class Point
{
	int x = 0;
	int y = 0;
	
	public Point(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
}