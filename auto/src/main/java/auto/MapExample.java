package auto;

import java.util.HashMap;
import java.util.Set;

import org.testng.annotations.Test;

public class MapExample {

	@Test
	public void test1() {
		
		HashMap<Integer,String> map = new HashMap<Integer,String>();
		//Generic  , Wrapper 
		
		/*
		 * 1. bharath
		 * 2. kumar
		 * 3. xyz
		 * 4. abc
		 */
		
		map.put(1, "bharath");
		map.put(2, "kumar");
		map.put(3, "xyz");
		
		System.out.println(map.size());
		
		String st = map.get(3);
		System.out.println(st);
		
		//2 step process to read all values from map :
		
		// Get all keys --> map.get(key) 
		
		Set<Integer>  keys = map.keySet();
		for(Integer key : keys) {
			String val = map.get(key);
			System.out.println(val);
		}
		
		System.out.println(map.containsKey(4));
		
		
	}
}
