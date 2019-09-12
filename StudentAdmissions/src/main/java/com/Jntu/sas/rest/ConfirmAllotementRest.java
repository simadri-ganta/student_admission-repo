package com.Jntu.sas.rest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Jntu.sas.beans.Registrationtable;
import com.Jntu.sas.beans.Selectedstudents;
import com.Jntu.sas.repositories.NumberOfCollegesRepo;
import com.Jntu.sas.repositories.RegistrationTableRepo;
import com.Jntu.sas.repositories.SelectedStudentsRepo;

@RestController
@RequestMapping("/Confirm_allotement_rest")
public class ConfirmAllotementRest {
	@Autowired
	NumberOfCollegesRepo college_repo;
	@Autowired
	AllotedDeptCheck chech_depart;
	@Autowired
	Registrationtable registration_entity;
	@Autowired
	RegistrationTableRepo registration_repo;
	@Autowired
	Selectedstudents selected_entity;
	@Autowired
	SelectedStudentsRepo selected_student_repo;

	@GetMapping(value = "/{code}")
	public ArrayList<Integer> meth(@PathVariable String code) {
		System.out.println(Messages.getString("Confirm_allotement_rest.0")); //$NON-NLS-1$
		List<Registrationtable> list = registration_repo.findAllByOrderByJoindateAsc();
		System.out.println(list);
		Iterator<Registrationtable> iter = list.iterator();
		ArrayList<Registrationtable> resultlist = new ArrayList<Registrationtable>();
		while (iter.hasNext()) {
			Registrationtable object = iter.next();
			if (object.getPercentage() > 89 && object.getCollege().equals(code)) {
				resultlist.add(object);
			}

		}
		List<Registrationtable> list1 = registration_repo.findAllByOrderByPercentageDesc();
		System.out.println(list1);
		Iterator<Registrationtable> iter1 = list1.iterator();
		while (iter1.hasNext()) {
			Registrationtable object1 = iter1.next();
			if (object1.getPercentage() < 90 && object1.getCollege().equals(code)) {
				resultlist.add(object1);
			}

		}
		for (int i = 0; i < resultlist.size(); i++) {
			System.out.println(resultlist.get(i).toString());
			System.out.println(Messages.getString("Confirm_allotement_rest.1")); //$NON-NLS-1$
		}
		Iterator<Registrationtable> iterate = resultlist.iterator();
		int i = 1, count = 0;
		while (iterate.hasNext()) {
			Registrationtable eachobject = iterate.next();
			String status = chech_depart.check_and_allot(eachobject.getDepartment(), code);
			if (!status.equals(Messages.getString("Confirm_allotement_rest.2")) && !status.equals(Messages.getString("Confirm_allotement_rest.3"))) { //$NON-NLS-1$ //$NON-NLS-2$
				selected_entity.setName(eachobject.getName());
				selected_entity.setMarks(eachobject.getMarks());
				selected_entity.setGpa(eachobject.getGpa());
				selected_entity.setBoard(eachobject.getBoard());
				selected_entity.setCollegecode(eachobject.getCollege());
				selected_entity.setJoineddate(eachobject.getJoindate());
				selected_entity.setAlloteddepartment(status);
				selected_entity.setPercentage(eachobject.getPercentage());
				selected_entity.setSchool(eachobject.getSchool());
				selected_entity.setDepartment(eachobject.getDepartment());
				selected_entity.setCollegename(college_repo.findById(eachobject.getCollege()).get().getCollege_name());
				System.out.println(i);
				registration_repo.findById(eachobject.getName()).get().setStatus_application(Messages.getString("Confirm_allotement_rest.4")); //$NON-NLS-1$
				selected_student_repo.save(selected_entity);
				count++;

				System.out.println(i++);

			} else {
				System.out.println(Messages.getString("Confirm_allotement_rest.5")); //$NON-NLS-1$
				registration_entity = registration_repo.findById(eachobject.getName()).get();
				if (registration_entity.getStatus_application().equals(Messages.getString("Confirm_allotement_rest.6"))) { //$NON-NLS-1$
					registration_entity.setStatus_application(Messages.getString("Confirm_allotement_rest.7")); //$NON-NLS-1$
					registration_repo.save(registration_entity);
				}
				System.out.println(Messages.getString("Confirm_allotement_rest.8")); //$NON-NLS-1$
			}

		}
		ArrayList<Integer> countlist = new ArrayList<>();
		countlist.add(count);
		return countlist;

	}
}
