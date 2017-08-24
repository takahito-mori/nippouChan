package jp.co.unirita.nippouChan.interfaces;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import jp.co.unirita.nippouChan.application.NippouService;
import jp.co.unirita.nippouChan.application.user.NippouChanUserDetails;
import jp.co.unirita.nippouChan.domain.nippou.Nippou;
import jp.co.unirita.nippouChan.domain.user.User;
@Controller
public class HomeController {
    @Autowired
    NippouService nippouService;

    /**
     * (サンプル実装)
     * ホーム画面。この例ではDBから日報のリストを取得してビューに渡している。
     * @return
     */

    @GetMapping("/home")
    public ModelAndView home(Nippou nippou,@AuthenticationPrincipal NippouChanUserDetails userDetails) {
      List<Nippou> report = nippouService.getAll();
      User user = userDetails.getUser();

    	        ModelAndView mav = new ModelAndView("home_page");

        mav.addObject("nippou", report);
        mav.addObject("loginuser",user);
        return mav;
    }

}
