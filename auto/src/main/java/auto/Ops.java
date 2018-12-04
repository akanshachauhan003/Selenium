package auto;

import java.util.ArrayList;

import org.testng.annotations.Test;

public class Ops {

	@Test
	public void test2() {
		
		Batch ba = new Batch();
		ArrayList<Student> lis = ba.getStudents();
		for (Student student : lis) {
			System.out.println(student.getName());
			System.out.println(student.getMarks());
		}
	}
}
