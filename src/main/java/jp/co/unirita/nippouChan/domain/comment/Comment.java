package jp.co.unirita.nippouChan.domain.comment;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import jp.co.unirita.nippouChan.domain.nippou.Nippou;
import jp.co.unirita.nippouChan.domain.user.User;


/**
 * The persistent class for the comments database table.
 *
 */
@Entity
@Table(name="comments")
@NamedQuery(name="Comment.findAll", query="SELECT c FROM Comment c")
public class Comment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="comment_id")
	private int commentId;

	@Lob
	@Column(name="comment_content")
	private String commentContent;

	@Column(name="comment_edit")
	private Timestamp commentEdit;

	@Column(name="comment_register")
	private Timestamp commentRegister;

	//bi-directional many-to-one association to Nippou
	@ManyToOne
	@JoinColumn(name="nippou_id")
	private Nippou nippou;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;

	public Comment() {
	}

	public int getCommentId() {
		return this.commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	public String getCommentContent() {
		return this.commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	public Timestamp getCommentEdit() {
		return this.commentEdit;
	}

	public void setCommentEdit(Timestamp commentEdit) {
		this.commentEdit = commentEdit;
	}

	public Timestamp getCommentRegister() {
		return this.commentRegister;
	}

	public void setCommentRegister(Timestamp commentRegister) {
		this.commentRegister = commentRegister;
	}

	public Nippou getNippou() {
		return this.nippou;
	}

	public void setNippou(Nippou nippou) {
		this.nippou = nippou;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}