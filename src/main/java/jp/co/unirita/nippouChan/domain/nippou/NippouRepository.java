package jp.co.unirita.nippouChan.domain.nippou;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NippouRepository extends CrudRepository<Nippou, Integer> {
    List<Nippou> findByNippouId(int nippouId);
    List<Nippou> findAll();
}

