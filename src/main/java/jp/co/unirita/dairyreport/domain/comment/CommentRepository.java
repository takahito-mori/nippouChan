package jp.co.unirita.dairyreport.domain.comment;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import jp.co.unirita.dairyreport.domain.user.User;

@Repository
public interface CommentRepository extends CrudRepository<User, String> {

}
