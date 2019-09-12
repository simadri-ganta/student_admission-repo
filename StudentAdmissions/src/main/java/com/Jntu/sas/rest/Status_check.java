package com.Jntu.sas.rest;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.Jntu.sas.beans.Registration_table;
import com.Jntu.sas.repositories.Registration_table_repo;

@RestController
@RequestMapping("/Status_check")
public class Status_check {
	@Autowired
	Registration_table registeration_entity;
	@Autowired
	Registration_table_repo registeration_repo;

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ArrayList<String> meth(@RequestBody ArrayList<String> list) {
		String name = list.get(0);
		String board = list.get(1);
		String gpa = list.get(2);
		String percentage = list.get(3);
		System.out.println(name+"	"+board+"	"+gpa+"	"+percentage);  
		ArrayList<String> list1=new ArrayList<>();
		if (registeration_repo.findById(name) != null) {
			Registration_table obj = registeration_repo.findById(name).get();
			if(obj.getBoard().equals(board)&&obj.getGpa().equals(gpa)&&obj.getPercentage()==Integer.parseInt(percentage)) {
				list1.add(obj.getStatus_application());
				list1.add(obj.getCollege_choice2());
			}else {
				list1.add("pass_wrong");
			}

		}else
		{
			list1.add("user_invalid");
		}
		System.out.println(list1);
		return list1;
	}

}