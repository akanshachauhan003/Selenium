package auto;

public class StMeth {

	
	public void test1() {
		String st = "bharath kumar reddy kristipati";
		int size = st.length();
		System.out.println(size);
		
		char c = st.charAt(0);
		System.out.println(c);
		
		char d = st.charAt(size-1);
		System.out.println(d);
		
		// Reverse a string 
		
		String rev = "";
		
		for (int i = 1; i <= size; i++) {
			rev = rev + st.charAt(size-i);
		}
		System.out.println(rev);
		
		String rev2 = "";
		
		for(int i = size-1;i>=0 ;i--) {
			rev2 = rev2+ st.charAt(i);
		}
		System.out.println(rev2);
		
		//Compare two strings content
		
		
		
		String st1 = "bharath";
		String st2 = "bharatH";
		boolean b = st1.equals(st2);
		System.out.println(b);
		if(st1.equals(st2)) {
			System.out.println("Both are equal");
		}else {
			System.out.println("Both are not equal");
		}
		if(st1.equalsIgnoreCase(st2)) {
			System.out.println("Both are equal");
		}else {
			System.out.println("Both are not equal");
		}
		
		// lower case string -- upper case
		
		System.out.println(st1.toUpperCase());
		
		String st3 = "avNsfYHJaa";
		System.out.println(st3.toUpperCase());
		System.out.println(st3.toLowerCase());
		
		//sub string
		String st4 = "bharath kumar reddy kristipati";
		String subst4 = st4.substring(15);
		System.out.println(subst4);
		
		// Count me the words of the string
		String ar[] = st4.split(" ");
		System.out.println(ar.length);
		
		// Reverse words in string
		String revWord = "";
		for(int i = ar.length-1 ; i>=0 ; i--) {
			revWord = revWord + ar[i] + " ";
		}
		System.out.println(revWord);
		
	}
			
	public static void main(String[] args) {
		StMeth me = new StMeth();
		me.test1();
	}
			
}