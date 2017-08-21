package jp.co.unirita.nippouChan.application;

import java.sql.Timestamp;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.unirita.nippouChan.domain.comment.Comment;
import jp.co.unirita.nippouChan.domain.comment.CommentRepository;
import jp.co.unirita.nippouChan.domain.nippou.Nippou;
import jp.co.unirita.nippouChan.domain.user.User;



@Service
public class CommentService {
    @Autowired
    CommentRepository commentRepository;
    private static final AtomicInteger count = new AtomicInteger(0);

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
        comment.setCommentId(count.incrementAndGet());
        comment.setCommentRegister(new Timestamp(System.currentTimeMillis()));
        comment.setNippou(nippou);
        commentRepository.save(comment);
    }
    public void Edit(Comment comment) {
    	User user = new User();
        user.setUserId("00001");
        comment.setCommentId(1);
        comment.setCommentEdit(new Timestamp(System.currentTimeMillis()));
        commentRepository.save(comment);
    }
}
