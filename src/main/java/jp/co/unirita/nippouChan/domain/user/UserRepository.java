package jp.co.unirita.nippouChan.domain.user;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, String> {
//	List<User> findByUserId(String userId);
	List<User> findAll();
}
