package jp.co.unirita.dairyreport.interfaces;

import jp.co.unirita.dairyreport.application.ReportService;
import jp.co.unirita.dairyreport.domain.report.Report;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

@Controller
public class HomeController {
    @Autowired
    ReportService reportService;

    /**
     * (サンプル実装)
     * ホーム画面。この例ではDBから日報のリストを取得してビューに渡している。
     * @return
     */
    @GetMapping("/")
    public ModelAndView home(Report report) {
        List<Report> reports = reportService.getListByUserId("test_user");
        ModelAndView mav = new ModelAndView("home");
        mav.addObject("currentTime", new Date());
        mav.addObject("reports", reports);
        return mav;
    }
}
