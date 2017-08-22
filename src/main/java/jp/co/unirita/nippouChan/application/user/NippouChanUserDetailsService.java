package jp.co.unirita.nippouChan.application.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import jp.co.unirita.nippouChan.domain.user.User;
import jp.co.unirita.nippouChan.domain.user.UserRepository;

@Service
public class NippouChanUserDetailsService implements UserDetailsService {
	@Autowired
	UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findOne(username);
		if (user == null) {
			throw new UsernameNotFoundException(username + " is not found.");
		}
		return new NippouChanUserDetails(user);
	}
}