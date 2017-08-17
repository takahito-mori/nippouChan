package jp.co.unirita.dairyreport.domain.report;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReportRepository extends CrudRepository<Report, Integer>  {
    List<Report> findByUserId(String userId);
}
