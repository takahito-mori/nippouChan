package jp.co.unirita.nippouChan.interfaces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import jp.co.unirita.nippouChan.application.NippouService;
import jp.co.unirita.nippouChan.domain.nippou.Nippou;

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
    public ModelAndView showOne(@PathVariable("id") int nippouId) {
        Nippou nippou = nippouService.getOne(nippouId);
        ModelAndView mav = new ModelAndView("nippou/article");
        mav.addObject("nippou", nippou);
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
    public ModelAndView create(@Validated Nippou nippou, BindingResult result) {
        nippouService.create(nippou);
        return new ModelAndView("home_page");
    }
}
