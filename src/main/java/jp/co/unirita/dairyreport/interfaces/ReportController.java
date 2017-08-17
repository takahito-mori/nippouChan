package jp.co.unirita.dairyreport.interfaces;

import jp.co.unirita.dairyreport.application.ReportService;
import jp.co.unirita.dairyreport.domain.report.Report;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/reports")
public class ReportController {
    @Autowired
    ReportService reportService;

    /**
     * (サンプル実装)
     * URLから日報IDを取得し、該当のReportオブジェクトを取得してビューに渡す。
     * @param reportId
     * @return
     */
    @RequestMapping("/{id}")
    public ModelAndView showOne(@PathVariable("id") int reportId) {
        Report report = reportService.getOne(reportId);
        ModelAndView mav = new ModelAndView("report/article");
        mav.addObject("report", report);
        return mav;
    }

    /**
     * (サンプル実装)
     * [作成]ボタンをクリックしたときの処理。
     * 日報オブジェクトをReportServiceの日報作成処理に渡す。
     * @param report
     * @return
     */
    @PostMapping
    public ModelAndView create(Report report) {
        reportService.create(report);
        return new ModelAndView("redirect:/");
    }
}
