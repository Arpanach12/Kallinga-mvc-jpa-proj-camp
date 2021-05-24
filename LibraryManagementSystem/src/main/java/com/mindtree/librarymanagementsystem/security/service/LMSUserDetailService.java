package com.mindtree.librarymanagementsystem.security.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mindtree.librarymanagementsystem.modules.user.entity.User;
import com.mindtree.librarymanagementsystem.modules.user.repository.UserRepository;
import com.mindtree.librarymanagementsystem.security.entity.LMSUserDetail;

/**
 * @author M1049006
 *
 */
@Service
public class LMSUserDetailService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username).orElseThrow(
				() -> new UsernameNotFoundException("User Not Found with -> username or email : " + username));
		return new LMSUserDetail(user);
	}

	@Transactional
	public User loadUserById(Long id) {
		User user = userRepository.findById(id).get();
		if (user == null) {
			throw new UsernameNotFoundException("User not found!");
		}
		return user;
	}

}
