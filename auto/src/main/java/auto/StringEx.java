package auto;

import java.util.HashMap;
import java.util.Set;

import org.testng.annotations.Test;

public class StringEx {

	
	@Test
	public void test1() {
		
		String st = "bharath kumar reddy kristipati";
		int size = st.length();

		HashMap<Character,Integer> map = new HashMap<Character,Integer>();
		
		for (int i = 0; i < size; i++) {
			char c = st.charAt(i);
			if(map.containsKey(c)){
				int val = map.get(c);
				val = val+1;
				map.put(c,val); 
			}else {
				map.put(c, 1);
			}
			
		}
		
		
		Set<Character> keys = map.keySet();
		
		for(Character key : keys) {
			System.out.println("Key is " + key + " : value is " + map.get(key));
		}
		
	}
}
