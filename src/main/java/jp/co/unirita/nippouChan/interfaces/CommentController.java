package jp.co.unirita.nippouChan.interfaces;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import jp.co.unirita.nippouChan.application.CommentService;
import jp.co.unirita.nippouChan.application.user.NippouChanUserDetails;
import jp.co.unirita.nippouChan.domain.comment.Comment;
import jp.co.unirita.nippouChan.domain.nippou.Nippou;
import jp.co.unirita.nippouChan.domain.user.User;

@Controller
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    CommentService commentService;

    /**
     * (サンプル実装)
     * ホーム画面。この例ではDBから日報のリストを取得してビューに渡している。
     * @return
     */



    @PostMapping
    public ModelAndView create(@Validated Comment comment, @Validated Nippou nippou,BindingResult result,@AuthenticationPrincipal NippouChanUserDetails userDetails) {
        User user = userDetails.getUser();
        comment.setUser(user);
        comment.setNippou(nippou);
    	commentService.create(comment);
        ModelAndView mav = new ModelAndView("show_page");
        List<Comment> comments=commentService.getByNippou(nippou);
        mav.addObject("loginuser",user);
        mav.addObject("comments", comments);
        mav.addObject("newcomment", new Comment());
        return mav;

    }




}
