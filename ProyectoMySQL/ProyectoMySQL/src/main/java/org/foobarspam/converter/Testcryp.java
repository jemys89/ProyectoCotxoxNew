package org.foobarspam.converter;

import org.foobarspam.service.CarreraService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Testcryp {
	


	public static void main(String[] args) {
		BCryptPasswordEncoder pe = new BCryptPasswordEncoder();
		System.out.println(pe.encode("user") );
		 

	}

}
