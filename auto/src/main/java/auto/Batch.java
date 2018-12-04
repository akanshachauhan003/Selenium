package auto;

import java.util.ArrayList;

public class Batch {

	
	public ArrayList<Student> getStudents() {
		
		Student st1 = new Student();
		st1.name= "bharath";
		st1.marks = 20;
		
		Student st2 = new Student();
		st2.name = "kumar";
		st2.marks = 80;
		
		Student st3 = new Student();
		st3.name = "kumar";
		st3.marks = 80;
		ArrayList<Student> list=  new ArrayList<Student>();
		list.add(st1);
		list.add(st2);
		list.add(st3);
		return list;
	}
}