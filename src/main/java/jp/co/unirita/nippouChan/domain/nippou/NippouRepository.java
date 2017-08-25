package jp.co.unirita.nippouChan.domain.nippou;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import jp.co.unirita.nippouChan.domain.user.User;

@Repository
public interface NippouRepository extends CrudRepository<Nippou, Integer> {
    List<Nippou> findByNippouId(int nippouId);
    List<Nippou> findByUser(User user);
    List<Nippou> findAll();
}

