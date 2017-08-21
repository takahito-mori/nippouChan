package jp.co.unirita.nippouChan.interfaces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import jp.co.unirita.nippouChan.application.NippouService;
import jp.co.unirita.nippouChan.domain.nippou.Nippou;

@Controller
public class HomeController {
    @Autowired
    NippouService nippouService;

    /**
     * (サンプル実装)
     * ホーム画面。この例ではDBから日報のリストを取得してビューに渡している。
     * @return
     */

    @GetMapping("/")
    public ModelAndView home(Nippou nippou) {
//        List<Nippou> reports = nippouService.getListByUserId("test_user");
        ModelAndView mav = new ModelAndView("write_page");
  //      mav.addObject("currentTime", new Date());
        mav.addObject("nippou", nippou);
        return mav;
    }

}
