package application;

import school.*;
import school.report.GenerateGradeReport;
import utils.Define;

public class StudentInfoApplication {
	School goodSchool = School.getInstance(); // 학교 생성 (어차피 얘는 하나라 하나만 옴!(싱글톤))
	Subject korean; // 국어 과목
	Subject math; // 수학 과목 	 
	GenerateGradeReport gradeReport = new GenerateGradeReport();
	
	public static void main(String[] args) {
		StudentInfoApplication test = new StudentInfoApplication();
		
		test.createSubject();
		test.createStudent();
		
		String report = test.gradeReport.getReport(); // 성적 결과 생성 (객체를 생성하고 가져와야 함. 이유가 머였지...)
		System.out.println(report);
	}
	
	// 과목을 생성
	public void createSubject() {
		korean = new Subject("국어", Define.KOREA); // 과목명, 과목코드 
		math = new Subject("수학", Define.MATH);
		
		// 학교에 과목을 넣어준다. 
		goodSchool.addSubject(korean);
		goodSchool.addSubject(math);
	}
	
	// 학생을 생성
	public void createStudent() {
		// 학생 생성
		Student student1 = new Student(181213, "박지은", korean);
		Student student2 = new Student(181518, "차슬기", math);
		Student student3 = new Student(171230, "이현욱", korean);
		Student student4 = new Student(171255, "임지연", korean);
		Student student5 = new Student(171590, "김채현", math);
		
		// 학교에 등록
		goodSchool.addStudent(student1);
		goodSchool.addStudent(student2);
		goodSchool.addStudent(student3);
		goodSchool.addStudent(student4);
		goodSchool.addStudent(student5);
		
		// 수강신청
		korean.register(student1);
		korean.register(student2);
		korean.register(student3);
		korean.register(student4);
		korean.register(student5);
		
		math.register(student1);
		math.register(student2);
		math.register(student3);
		math.register(student4);
		math.register(student5);
		
		// 학생의 과목별 점수 추가
		addScoreForStudent(student1, korean, 95);
		addScoreForStudent(student1, math, 56);
		
		addScoreForStudent(student2, korean, 95);
		addScoreForStudent(student2, math, 98);
		
		addScoreForStudent(student3, korean, 100);
		addScoreForStudent(student3, math, 88);
		
		addScoreForStudent(student4, korean, 89);
		addScoreForStudent(student4, math, 95);
		
		addScoreForStudent(student5, korean, 83);
		addScoreForStudent(student5, math, 56);
	}
	
	// 학생마다 과목별(수학, 국어) 점수 추가
	public void addScoreForStudent(Student student, Subject subject, int point) {
		Score score = new Score(student.getStudentId(), subject, point);
		student.addSubjectScore(score);
	}
}
