package hh.sof3.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import hh.sof3.bookstore.domain.User;
import hh.sof3.bookstore.domain.UserRepository;

/**
 * This class is used by spring security to authenticate and authorize user
 **/
@Service
public class UserDetailServiceImpl implements UserDetailsService  {
	
	private final UserRepository repository;

	@Autowired
	public UserDetailServiceImpl(UserRepository userRepository) {
		this.repository = userRepository;
	}

    @Override
    public UserDetails loadUserByUsername(String username) {  
    	User curruser = repository.findByUsername(username);

		if (curruser == null || curruser.getPasswordHash() == null) {
			throw new CustomExceptionMessage("Invalid credentials");
		}
        UserDetails user = new org.springframework.security.core.userdetails.User(
			username, 
			curruser.getPasswordHash(), 
        	AuthorityUtils.createAuthorityList(curruser.getRole())
		);
        return user;
    }   
} 

