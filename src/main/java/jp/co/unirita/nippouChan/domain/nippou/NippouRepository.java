package jp.co.unirita.nippouChan.domain.nippou;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NippouRepository extends CrudRepository<Nippou, String> {

}

