package jp.co.unirita.dairyreport.domain.nippou;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NippouRepository extends CrudRepository<Nippou, String> {
    List<Nippou> findByNippouId(int nippouId);

}

