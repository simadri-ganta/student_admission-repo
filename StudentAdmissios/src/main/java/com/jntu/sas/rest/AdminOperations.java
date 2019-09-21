package com.jntu.sas.rest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jntu.sas.beans.Admin;
import com.jntu.sas.beans.College;
import com.jntu.sas.beans.Registration;
import com.jntu.sas.beans.Student;
import com.jntu.sas.repositories.CollegeRepo;
import com.jntu.sas.repositories.StudentsRepo;
import com.jntu.sas.rest.business.AllotedDeptCheck;
import com.jntu.sas.rest.business.CollegeOperations;
import com.jntu.sas.rest.business.RegisterationDAO;

@RestController
@RequestMapping("/")
public class AdminOperations {
	@Autowired
	CollegeRepo collegeRepo;
	@Autowired
	AllotedDeptCheck checkDepart;
	@Autowired
	Registration registration;
	@Autowired
	Student student;
	@Autowired
	StudentsRepo studentRepo;
	@Autowired
	Admin admin;

	@GetMapping(value = "top10/{code}")
	public List<Student> meth1(@PathVariable String code) {

		List<Student> list = studentRepo.findTop5ByCollegeCode(code,
				new Sort(Sort.Direction.DESC, Messages.getString("Topstudents.0"))); //$NON-NLS-1$

		return list;
	}

	@Autowired
	CollegeOperations collegeOperation;

	@PutMapping(value = "adcollege/")
	public ArrayList<String> meth(@RequestBody College college_entity) {
		ArrayList<String> list1 = new ArrayList<>();
		collegeOperation.extracted(college_entity);
		list1.add("done");
		return list1;

	}
@Autowired
RegisterationDAO register;
	@GetMapping(value = "Confirm_allotement_rest/{code}")
	public ArrayList<Integer> meth(@PathVariable String code) {
		System.out.println("in rest");
		List<Registration> list = register.studentsList();
		Iterator<Registration> iter = list.iterator();
		ArrayList<Registration> resultlist = new ArrayList<Registration>();
		while (iter.hasNext()) {
			Registration object = iter.next();
			if (object.getPercentage() > 89 && object.getFirstCollege().equals(code)) {
				resultlist.add(object);
			}

		}
		List<Registration> list1 = register.StudentsList();
		System.out.println(list1);
		Iterator<Registration> iter1 = list1.iterator();
		while (iter1.hasNext()) {
			Registration object1 = iter1.next();
			if (object1.getPercentage() < 90 && object1.getFirstCollege().equals(code)) {
				resultlist.add(object1);
			}

		}
		Iterator<Registration> iterate = resultlist.iterator();
		int i = 1, count = 0;
		while (iterate.hasNext()) {
			Registration eachobject = iterate.next();
			String status = checkDepart.check_and_allot(eachobject.getDepartment(), code);
			if (!status.equals("no_seat") && !status.equals("no_department")) {
				student.setName(eachobject.getName());
				student.setMarks(eachobject.getMarks());
				student.setGpa(eachobject.getGpa());
				student.setBoard(eachobject.getBoard());
				student.setCollegeCode(eachobject.getFirstCollege());
				student.setJoinDate(eachobject.getJoinDate());
				student.setAllotedDepartment(status);
				student.setPercentage(eachobject.getPercentage());
				student.setSchool(eachobject.getSchool());
				student.setDepartment(eachobject.getDepartment());
				student.setCollegeName(collegeRepo.findById(eachobject.getFirstCollege()).get().getName());
				register.find(eachobject.getName()).get().setApplicationStatus("accepted");
				studentRepo.save(student);
				count++;

				System.out.println(i++);

			} else {
				registration = register.find(eachobject.getName()).get();
				if (registration.getApplicationStatus().equals("pending")) { //$NON-NLS-1$
					registration.setApplicationStatus("rejected");
					register.insert(registration);
				}
			}

		}
		ArrayList<Integer> countlist = new ArrayList<>();
		countlist.add(count);
		return countlist;

	}
	

	
}
