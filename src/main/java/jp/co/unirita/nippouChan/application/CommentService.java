package jp.co.unirita.nippouChan.application;

import java.sql.Timestamp;
import java.util.List;

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

    /**
     * (サンプル実装)
     * 受け取ったReportオブジェクトのcreatedに現在日時、userに"test_user"を設定してDBに保存する。
     * @param comment
     * @return
     */

    public void create(Comment comment) {
    	comment.setCommentRegister(new Timestamp(System.currentTimeMillis()));
        comment.setCommentEdit(new Timestamp(System.currentTimeMillis()));
        commentRepository.save(comment);
    }

    public void edit(Comment comment) {
        User user = new User();
        comment.setCommentId(comment.getCommentId());
        user.setUserId(comment.getUser().getUserId());
        comment.setCommentEdit(new Timestamp(System.currentTimeMillis()));
        commentRepository.save(comment);

    }



	/**
	 * (サンプル実装)
	 * userをキーにしてDBから日報のリストを取得して返す
	 * @param user
	 * @return List<Comment>
	 */
    public List<Comment> getByNippou(Nippou nippou) {
        return commentRepository.findByNippou(nippou);
    }

    /**
     * (サンプル実装)
     * commentIdをキーにしてDBから日報を取得して返す
     * @param commentId
     * @return Comment
     */

    public Comment getOne(int commentId) {
        return commentRepository.findOne(commentId);
    }


    public List<Comment> getAll() {
		return commentRepository.findAll();
	}

//annotetionで自動ID割り振り実装しているため使う機会はないだろう
/*    public int getListSize() {
		List<Comment> list=getAll();
		return list.size();
	}

*/

    //最新20件って作成時間順？？編集時間順？？
    /**
     * commentIdをキーにしてDBから日報を取得し、作成日時の降順(最新)でソートして返す
     * @param commentId
     * @return List<Comment>
     */

//    public List<Comment> getListByNewest(int commentId) {
//    	List<Comment> commentList = commentRepository.findByCommentId(commentId);
//    	Collections.sort(commentList, new CreateComparator());
//    	return commentList;
//    }

    /**
     * commentIdをキーにしてDBから日報を取得し、研修日時の降順(最新)でソートして返す
     * @param commentId
     * @return List<Comment>
     /*
    public List<Comment> getListByTraining(int commentId) {
    	List<Comment> commentList = commentRepository.findByCommentId(commentId);
    	Collections.sort(commentList, new TrainingComparator());
    	return commentList;
    }
*/
}

