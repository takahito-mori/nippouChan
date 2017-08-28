package jp.co.unirita.nippouChan.application;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.unirita.nippouChan.domain.user.User;
import jp.co.unirita.nippouChan.domain.user.UserRepository;

@Service
public class AdminService {
    @Autowired
    UserRepository userRepository;

    /**
     * (サンプル実装)
     *
     * @param user
     * @return
     */

    public void create(User user) {
    	userRepository.save(user);
    }

    public List<User> getAll() {
		return userRepository.findAll();
	}
/*	public List<User> getOne(String userId) {
		return userRepository.findByUserId(userId);
	}*/

}
