package com.configuration;

import com.entity.Role;
import com.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class RoleConverter implements Converter<Object, Role>{

	@Autowired
	RoleService roleService;

	/*
	 * Gets UserProfile by Id
	 * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
	 */
	public Role convert(Object element) {
		Long id = Long.parseLong((String) element);
		Role role= null;
		try {
			role = roleService.findById(id);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Profile : "+role);
		return role;
	}
	
	/*
	 * Gets UserProfile by type
	 * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
	 */
	/*
	public UserProfile convert(Object element) {
		String type = (String)element;
		UserProfile profile= userProfileService.findByType(type);
		System.out.println("Profile ... : "+profile);
		return profile;
	}
	*/

}