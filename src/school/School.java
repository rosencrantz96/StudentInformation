package school;

import java.util.ArrayList;

public class School {
	// 내부에 school 객체를 생성해 준다. 
	private static School instance = new School();
//	private static School instance = null; // 요러케 해도 괜찮당 
	
	private static String SCHOOL_NAME = "Good School"; // 학교 이름 
	private ArrayList<Student> studentList = new ArrayList<Student>(); // 학교에 등록한 학생
	private ArrayList<Subject> subjectList = new ArrayList<Subject>(); // 학교에서 개설한 과목 
	
	// 싱글톤은 생성자가 private -> 외부에서 객체를 여러개 생성하면 안되니깐... 학교는 하나니깐... 
	private School() {} // 클래스 안에서만 객체 생성 가능 
	
	// 싱글톤 메소드 구현: school 객체를 리턴한다 (근데 하나만)
	public static School getInstance() { 
		if (instance == null) {
			instance = new School();
		}
		
		return instance;
	}
	
	// 학생 입학
	public void addStudent(Student student) {
		studentList.add(student);
	}

	// 학생 리스트 출력 
	public ArrayList<Student> getStudentList() {
		return studentList;
	}
	
	// 과목 개설
	public void addSubject(Subject subject) {
		subjectList.add(subject);
	}

	// 과목 리스트 출력 
	public ArrayList<Subject> getSubjectList() {
		return subjectList;
	}
	
	
}

