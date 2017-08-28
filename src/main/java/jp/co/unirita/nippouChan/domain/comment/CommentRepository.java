package jp.co.unirita.nippouChan.domain.comment;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import jp.co.unirita.nippouChan.domain.nippou.Nippou;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Integer> {
	List<Comment> findByNippou(Nippou nippou);
	//void save(Comment comment);
    List<Comment> findAll();
}
