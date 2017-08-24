package jp.co.unirita.nippouChan.interfaces;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import jp.co.unirita.nippouChan.application.NippouService;
import jp.co.unirita.nippouChan.application.user.NippouChanUserDetails;
import jp.co.unirita.nippouChan.domain.nippou.Nippou;
import jp.co.unirita.nippouChan.domain.user.User;

@Controller
@RequestMapping("/nippou")
public class NippouController {
    @Autowired
    NippouService nippouService;

    /**
     * (サンプル実装)
     * URLから日報IDを取得し、該当のNippouオブジェクトを取得してビューに渡す。
     * @param nippouId
     * @return
     */

    @RequestMapping("/{id}")
    public ModelAndView showOne(@PathVariable("id") int nippouId,@AuthenticationPrincipal NippouChanUserDetails userDetails) {
        Nippou nippou = nippouService.getOne(nippouId);
        User user = userDetails.getUser();
        ModelAndView mav = new ModelAndView("show_page");
        mav.addObject("nippou", nippou);
        mav.addObject("loginuser",user);
        int flag = 0;
        System.out.println(nippou.getUser().getUserId());
        System.out.println(user.getUserId());

        if(user.getUserId().toString().equals(nippou.getUser().getUserId().toString())) {
        	flag = 1;
        }
        mav.addObject("flag",flag);
        return mav;
    }

    /**
     * (サンプル実装)
     * [作成]ボタンをクリックしたときの処理。
     * 日報オブジェクトをNippouServiceの日報作成処理に渡す。
     * @param nippou
     * @return
     */
    @PostMapping
    public ModelAndView create(@Validated Nippou nippou, BindingResult result,@AuthenticationPrincipal NippouChanUserDetails userDetails) {
        nippouService.create(nippou);
        List<Nippou> report = nippouService.getAll();
        User user = userDetails.getUser();
        ModelAndView mav = new ModelAndView("home_page");
        mav.addObject("nippou", report);
        mav.addObject("loginuser",user);

        return mav;
    }

    @GetMapping
    public ModelAndView write(@Validated Nippou nippou, BindingResult result) {
        return new ModelAndView("write_page");
    }


}
