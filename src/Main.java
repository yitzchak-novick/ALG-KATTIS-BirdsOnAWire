import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

	static long L, D;
	static int N;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] parts = br.readLine().split(" ");
		L = Long.parseLong(parts[0]) - 12;
		D = Long.parseLong(parts[1]);
		N = Integer.parseInt(parts[2]);
	
		
		long total = 0;
		long canAdd;
		
		PriorityQueue<Long> queue = new PriorityQueue<Long>(); 
		
		for (int i = 0; i < N; i++)
		{
			Long currPos = Long.parseLong(br.readLine()) - 6L;
			queue.add(currPos);
		}
		
		Long start, finish, size;
		start = 0L;
		if (queue.peek() != null)
		{
			finish = queue.poll();
			size = finish - start;
			canAdd = ((size) / D);
			total += (canAdd > 0 ? canAdd : 0);
			start = finish;
		
		
			while ((finish = queue.poll()) != null)
			{
				size = finish - start;
				canAdd = ((size) / D) - 1;
				total += (canAdd > 0 ? canAdd : 0);
				start = finish;
			}
		}
		
		if (start != 0L)
		{
			size = L - start;
			canAdd = ((size) / D);
			total += (canAdd > 0 ? canAdd : 0);
		}
		else
			total = L/D + 1;
		
		System.out.println(total);
	}

}
