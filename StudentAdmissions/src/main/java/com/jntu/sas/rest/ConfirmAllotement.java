package com.jntu.sas.rest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jntu.sas.beans.Registration;
import com.jntu.sas.beans.Student;
import com.jntu.sas.repositories.NumberOfCollegesRepo;
import com.jntu.sas.repositories.RegistrationTableRepo;
import com.jntu.sas.repositories.SelectedStudentsRepo;

@RestController
@RequestMapping("/Confirm_allotement_rest")
public class ConfirmAllotement {
	@Autowired
	NumberOfCollegesRepo college_repo;
	@Autowired
	AllotedDeptCheck checkDepart;
	@Autowired
	Registration registration;
	@Autowired
	RegistrationTableRepo registrationRepo;
	@Autowired
	Student student;
	@Autowired
	SelectedStudentsRepo studentRepo;

	@GetMapping(value = "/{code}")
	public ArrayList<Integer> meth(@PathVariable String code) {
		System.out.println("in rest");
		List<Registration> list = registrationRepo.findAllByOrderByJoindateAsc();
		System.out.println(list);
		Iterator<Registration> iter = list.iterator();
		ArrayList<Registration> resultlist = new ArrayList<Registration>();
		while (iter.hasNext()) {
			Registration object = iter.next();
			if (object.getPercentage() > 89 && object.getFirstCollege().equals(code)) {
				resultlist.add(object);
			}

		}
		List<Registration> list1 = registrationRepo.findAllByOrderByPercentageDesc();
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
				student.setCollegeName(college_repo.findById(eachobject.getFirstCollege()).get().getName());
				System.out.println(i);
				registrationRepo.findById(eachobject.getName()).get().setApplicationStatus("accepted"); //$NON-NLS-1$
				studentRepo.save(student);
				count++;

				System.out.println(i++);

			} else {
				registration = registrationRepo.findById(eachobject.getName()).get();
				if (registration.getApplicationStatus().equals("pending")) { //$NON-NLS-1$
					registration.setApplicationStatus("rejected"); 
					registrationRepo.save(registration);
				}			}

		}
		ArrayList<Integer> countlist = new ArrayList<>();
		countlist.add(count);
		return countlist;

	}
}
