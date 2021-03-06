package jp.co.unirita.nippouChan.interfaces;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import jp.co.unirita.nippouChan.application.CommentService;
import jp.co.unirita.nippouChan.application.NippouService;
import jp.co.unirita.nippouChan.application.user.NippouChanUserDetails;
import jp.co.unirita.nippouChan.domain.comment.Comment;
import jp.co.unirita.nippouChan.domain.nippou.Nippou;
import jp.co.unirita.nippouChan.domain.user.User;

@Controller
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    CommentService commentService;

    @Autowired
    NippouService nippouService;

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

        int flag = 0;
        if(user.getUserId().toString().equals(nippou.getUser().getUserId().toString())) {
        	flag = 1;
        }

        mav.addObject("flag",flag);
        mav.addObject("loginuser",user);
        mav.addObject("comments", comments);
        mav.addObject("commentnum", comments.size());
        mav.addObject("newcomment", new Comment());
        return mav;

    }

/*    @PostMapping("/edit/{id}")
    public ModelAndView edit(@Validated Comment comment, @Validated Comment comments, @Validated Nippou nippou,BindingResult result,@AuthenticationPrincipal NippouChanUserDetails userDetails) {
        User user = userDetails.getUser();
    	commentService.create(comment);
        ModelAndView mav = new ModelAndView("show_page");
        List<Comment> comments2=commentService.getByNippou(nippou);
        mav.addObject("loginuser",user);
        mav.addObject("comments", comments2);
        mav.addObject("commentnum", comments2.size());
        mav.addObject("newcomment", new Comment());
        return mav;

    }
*/
    @PostMapping("/delete/{nid}/{cid}")
    public ModelAndView delete(@PathVariable("nid") int nippouId,@PathVariable("cid") int commentId, @AuthenticationPrincipal NippouChanUserDetails userDetails) {
        User user = userDetails.getUser();
    	commentService.delete(commentId);
        ModelAndView mav = new ModelAndView("show_page");
        Nippou nippou = nippouService.getOne(nippouId);
        List<Comment> comments=commentService.getByNippou(nippou);
        mav.addObject("loginuser",user);
        mav.addObject("comments", comments);
        mav.addObject("commentnum", comments.size());
        mav.addObject("nippou", nippou);
        mav.addObject("newcomment", new Comment());
        return mav;

    }



}
