package jp.co.unirita.dairyreport.application;

import jp.co.unirita.dairyreport.domain.report.Report;
import jp.co.unirita.dairyreport.domain.report.ReportRepository;
import jp.co.unirita.dairyreport.domain.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ReportService {
    @Autowired
    ReportRepository reportRepository;

    /**
     * (サンプル実装)
     * 受け取ったReportオブジェクトのcreatedに現在日時、userに"test_user"を設定してDBに保存する。
     * @param report
     * @return
     */
    public void create(Report report) {
        User user = new User();
        user.setId("test_user");
        report.setUser(user); // TODO: 現在のログインユーザを取得して設定するようにしたい
        report.setCreated(new Date());
        reportRepository.save(report);
    }

    /**
     * (サンプル実装)
     * userIdをキーにしてDBから日報のリストを取得して返す
     * @param userId
     * @return
     */
    public List<Report> getListByUserId(String userId) {
        return reportRepository.findByUserId(userId);
    }

    /**
     * (サンプル実装)
     * reportIdをキーにしてDBから日報を取得して返す
     * @param reportId
     * @return
     */
    public Report getOne(int reportId) {
        return reportRepository.findOne(reportId);
    }
}
