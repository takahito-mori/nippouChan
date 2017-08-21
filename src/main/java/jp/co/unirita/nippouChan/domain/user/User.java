package jp.co.unirita.nippouChan.domain.user;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import jp.co.unirita.nippouChan.domain.comment.Comment;
import jp.co.unirita.nippouChan.domain.nippou.Nippou;


/**
 * The persistent class for the users database table.
 *
 */
@Entity
@Table(name="users")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="user_id")
	private String userId;

	@Column(name="user_kana")
	private String userKana;

	@Column(name="user_mail")
	private String userMail;

	@Column(name="user_name")
	private String userName;

	@Column(name="user_password")
	private String userPassword;

	//bi-directional many-to-one association to Comment
	@OneToMany(mappedBy="user")
	private List<Comment> comments;

	//bi-directional many-to-one association to Nippou
	@OneToMany(mappedBy="user")
	private List<Nippou> nippous;

	public User() {
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserKana() {
		return this.userKana;
	}

	public void setUserKana(String userKana) {
		this.userKana = userKana;
	}

	public String getUserMail() {
		return this.userMail;
	}

	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return this.userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public List<Comment> getComments() {
		return this.comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public Comment addComment(Comment comment) {
		getComments().add(comment);
		comment.setUser(this);

		return comment;
	}

	public Comment removeComment(Comment comment) {
		getComments().remove(comment);
		comment.setUser(null);

		return comment;
	}

	public List<Nippou> getNippous() {
		return this.nippous;
	}

	public void setNippous(List<Nippou> nippous) {
		this.nippous = nippous;
	}

	public Nippou addNippous(Nippou nippous) {
		getNippous().add(nippous);
		nippous.setUser(this);

		return nippous;
	}

	public Nippou removeNippous(Nippou nippous) {
		getNippous().remove(nippous);
		nippous.setUser(null);

		return nippous;
	}

}