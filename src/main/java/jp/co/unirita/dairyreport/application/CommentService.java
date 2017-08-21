package jp.co.unirita.dairyreport.application;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.unirita.dairyreport.domain.comment.Comment;
import jp.co.unirita.dairyreport.domain.comment.CommentRepository;
import jp.co.unirita.dairyreport.domain.nippou.Nippou;
import jp.co.unirita.dairyreport.domain.user.User;

@Service
public class CommentService {
    @Autowired
    CommentRepository commentRepository;

    /**
     * (サンプル実装)
     * 受け取ったCommentオブジェクトのcreatedに現在日時、userに"test_user"を設定してDBに保存する。
     * @param comment
     * @return
     */
    public void create(Comment comment) {
        User user = new User();
        user.setUserId("00001");
        Nippou nippou = new Nippou();
        nippou.setNippouId(1);
        comment.setUser(user); // TODO: 現在のログインユーザを取得して設定するようにしたい
        comment.setCommentId(1);
        comment.setCommentRegister(new Timestamp(System.currentTimeMillis()));
        comment.setNippou(nippou);
        commentRepository.save(comment);
    }
    public void Edit(Comment comment) {
    	User user = new User();
        user.setUserId("00001");
        comment.setCommentId(1);
        comment.setCommentEdit(new Timestamp(System.currentTimeMillis()));

    }
}
