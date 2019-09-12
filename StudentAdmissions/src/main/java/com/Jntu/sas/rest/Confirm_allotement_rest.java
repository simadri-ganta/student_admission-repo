package com.Jntu.sas.rest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.Jntu.sas.beans.Registration_table;
import com.Jntu.sas.beans.Selected_students;
import com.Jntu.sas.repositories.Number_of_colleges_repo;
import com.Jntu.sas.repositories.Registration_table_repo;
import com.Jntu.sas.repositories.Selected_students_repo;

@RestController
@RequestMapping("/Confirm_allotement_rest")
public class Confirm_allotement_rest {
	@Autowired
	Number_of_colleges_repo college_repo;
	@Autowired
	Alloted_dept_check chech_depart;
	@Autowired
	Registration_table registration_entity;
	@Autowired
	Registration_table_repo registration_repo;
	@Autowired
	Selected_students selected_entity;
	@Autowired
	Selected_students_repo selected_student_repo;

	@RequestMapping(value = "/{code}", method = RequestMethod.GET)
	public ArrayList<Integer> meth(@PathVariable String code) {
		System.out.println("in rest");
		List<Registration_table> list = registration_repo.findAllByOrderByJoindateAsc();
		System.out.println(list);
		Iterator<Registration_table> iter = list.iterator();
		ArrayList<Registration_table> resultlist = new ArrayList<Registration_table>();
		while (iter.hasNext()) {
			Registration_table object = iter.next();
			if (object.getPercentage() > 89 && object.getCollege().equals(code)) {
				resultlist.add(object);
			}

		}
		List<Registration_table> list1 = registration_repo.findAllByOrderByPercentageDesc();
		System.out.println(list1);
		Iterator<Registration_table> iter1 = list1.iterator();
		while (iter1.hasNext()) {
			Registration_table object1 = iter1.next();
			if (object1.getPercentage() < 90 && object1.getCollege().equals(code)) {
				resultlist.add(object1);
			}

		}
		for (int i = 0; i < resultlist.size(); i++) {
			System.out.println(resultlist.get(i).toString());
			System.out.println("/n");
		}
		Iterator<Registration_table> iterate = resultlist.iterator();
		int i = 1, count = 0;
		while (iterate.hasNext()) {
			Registration_table eachobject = iterate.next();
			String status = chech_depart.check_and_allot(eachobject.getDepartment(), code);
			if (!status.equals("no_seat") && !status.equals("no_department")) {
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
				registration_repo.findById(eachobject.getName()).get().setStatus_application("accepted");
				selected_student_repo.save(selected_entity);
				count++;

				System.out.println(i++);

			} else {
				System.out.println("reject");
				registration_entity = registration_repo.findById(eachobject.getName()).get();
				if (registration_entity.getStatus_application().equals("pending")) {
					registration_entity.setStatus_application("rejected");
					registration_repo.save(registration_entity);
				}
				System.out.println("reject");
			}

		}
		ArrayList<Integer> countlist = new ArrayList<>();
		countlist.add(count);
		return countlist;

	}
}
