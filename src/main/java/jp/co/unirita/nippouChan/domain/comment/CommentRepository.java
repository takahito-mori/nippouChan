package jp.co.unirita.nippouChan.domain.comment;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import jp.co.unirita.nippouChan.domain.user.User;

@Repository
public interface CommentRepository extends CrudRepository<User, String> {

	void save(Comment comment);

}
