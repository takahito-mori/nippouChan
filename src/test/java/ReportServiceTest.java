import jp.co.unirita.dairyreport.Application;
import jp.co.unirita.dairyreport.application.ReportService;
import jp.co.unirita.dairyreport.domain.report.Report;
import jp.co.unirita.dairyreport.domain.report.ReportRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class ReportServiceTest {
    @Autowired
    ReportService reportService;

    @MockBean
    ReportRepository reportRepository;

    /**
     * ReportService::create(..)のテスト
     * メソッドに渡したオブジェクトに現在日時とユーザがセットされ、DBへの保存が呼び出されていることを確認する
     */
    @Test
    public void 日報の作成_正常系() {
        Report report = new Report();
        report.setTitle("タイトル");
        report.setText("ほげほげ");
        reportService.create(report);

        assertThat(report.getCreated(), is(notNullValue()));
        assertThat(report.getUser().getId(), is("test_user"));
        Mockito.verify(reportRepository).save(report);
    }
}
