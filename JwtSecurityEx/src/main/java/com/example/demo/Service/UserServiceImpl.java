package com.example.demo.Service;
import java.util.Optional;

import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
@Service
public class UserServiceImpl implements IUserService, UserDetailsService{
	@Autowired
    public UserRepository repository;
	@Autowired
	private BCryptPasswordEncoder pwdEncoder;
    //save method
	public Integer saveUser(User user) {
				
		//Encode Password
		user.setPassword(pwdEncoder.encode(user.getPassword()));
		return repository.save(user).getId();
	}
	//get user by username
		public Optional<User>findByUserName(String users){
			return Optional.ofNullable(repository.findByUserName(users));
			
		}
		public UserDetails loadUserByUsername(String users)throws UsernameNotFoundException
		{
			Optional<User> opt=findByUserName(users);
			if(opt.isEmpty())throw new UsernameNotFoundException("User not exists");
			User user =opt.get();
			
			return new org.springframework.security.core.userdetails.User(
					users,
				    user.getPassword(),
				    user.getRoles().stream()
				    .map(role->new SimpleGrantedAuthority(role))
				    .collect(Collectors.toList())
				   );
				
		}
}