package com.firstcode.cruddemo;

import com.firstcode.cruddemo.dao.StudentDAO;
import com.firstcode.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner -> {
			//createStudent(studentDAO);

			createMultipleStudents(studentDAO);

			//readStudent(studentDAO);

			//queryForStudents(studentDAO);

			// queryForStudentsByLastName(studentDAO);

			//updateStudent(studentDAO);

			//deleteStudent(studentDAO);

			//deleteAllStudents(studentDAO);
		};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		System.out.println("Deleting all students......");
		int numRowsDeleted = studentDAO.deleteAll();
		System.out.println("Delete row count: " + numRowsDeleted);
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId = 3;
		System.out.println("Deleting student id: " + studentId);
		studentDAO.delete(studentId);
	}

	private void updateStudent(StudentDAO studentDAO) {
		// retrieve student based on the id: primary key
		int studentId = 1;
		System.out.println("Getting student with id: " + studentId);
		Student myStudent = studentDAO.findById(studentId);

		// change first name to "Scooby"
		System.out.println("Updating student......");
		myStudent.setFirstName("John");

		// update the student
		studentDAO.update(myStudent);

		// display the updated student
		System.out.println("Updated student: " + myStudent);
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		// get a list of students
		List<Student> theStudents = studentDAO.findByLastName("Doe");

		//Display list of students
		for(Student tempStudent: theStudents){
			System.out.println(tempStudent);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {
		// get a list of students
		List<Student> theStudents = studentDAO.findAll();

		// display the list of students
		for (Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		// create a student object
		System.out.println("Creating a new student object......");
		Student tempStudent = new Student("Daffy", "Duck", "daffy@gmail.com", "123 Sesame Street");

		// save the student
		System.out.println("Saving the student......");
		studentDAO.save(tempStudent);
		// display id of saved student
		int theId = tempStudent.getId();
		System.out.println("Saved student. Generated id: " + theId);

		// retrieve student based on the id: primary key
		System.out.printf("Retrieving student with id: %d\n", theId);
		Student myStudent = studentDAO.findById(theId);
		// display  student
		System.out.println("Found student: " + myStudent);
	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		// create multiple students
		System.out.println("Creating a new student object......");
		Student tempStudent1 = new Student("John", "Doe", "john@gmail.com", "123 Sesame Street");
		Student tempStudent2 = new Student("Mary", "Public", "mary@gmail.com",	"123 Sesame Street");
		Student tempStudent3 = new Student("Bonita", "Applebum", "bonita@gmail.com", "123 Sesame Street");

		// save the student objects
		System.out.println("Saving the students......");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);


	}



	private void createStudent(StudentDAO studentDAO) {

		// create the student object
		System.out.println("Creating a new student object......");
		Student tempStudent = new Student("John", "Doe", "fff@gmail.com", "123 Sesame Street");

		// save the student object
		System.out.println("Saving the student......");
		studentDAO.save(tempStudent);

		// display id of saved student
		System.out.println("Saved student. Generated id: " + tempStudent.getId());
	}

}
