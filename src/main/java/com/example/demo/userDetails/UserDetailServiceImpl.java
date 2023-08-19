package com.example.demo.userDetails;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repository.IUserRepository;

@Service
public class UserDetailServiceImpl implements UserDetailsService{
	
	@Autowired
	private IUserRepository userRepository;
	
	@Autowired
	private HttpSession session;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user = userRepository.findByName(username);
		if(user == null) {
			System.out.println("Can't");
			throw new UsernameNotFoundException("Can't find User");
		}
		session.setAttribute("user", user);
		return new UserDetailsImpl(user);
	}

}
