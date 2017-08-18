package jp.co.unirita.dairyreport.domain.nippou;

import java.io.Serializable;
import javax.persistence.*;

import jp.co.unirita.dairyreport.domain.comment.Comment;
import jp.co.unirita.dairyreport.domain.user.User;

import java.util.Date;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the nippou database table.
 * 
 */
@Entity
@NamedQuery(name="Nippou.findAll", query="SELECT n FROM Nippou n")
public class Nippou implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="nippou_id")
	private int nippouId;

	@Lob
	@Column(name="nippou_contents")
	private String nippouContents;

	@Column(name="nippou_edit")
	private Timestamp nippouEdit;

	@Column(name="nippou_register")
	private Timestamp nippouRegister;

	@Column(name="nippou_title")
	private String nippouTitle;

	@Temporal(TemporalType.DATE)
	@Column(name="nippou_training")
	private Date nippouTraining;

	//bi-directional many-to-one association to Comment
	@OneToMany(mappedBy="nippou")
	private List<Comment> comments;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;

	public Nippou() {
	}

	public int getNippouId() {
		return this.nippouId;
	}

	public void setNippouId(int nippouId) {
		this.nippouId = nippouId;
	}

	public String getNippouContents() {
		return this.nippouContents;
	}

	public void setNippouContents(String nippouContents) {
		this.nippouContents = nippouContents;
	}

	public Timestamp getNippouEdit() {
		return this.nippouEdit;
	}

	public void setNippouEdit(Timestamp nippouEdit) {
		this.nippouEdit = nippouEdit;
	}

	public Timestamp getNippouRegister() {
		return this.nippouRegister;
	}

	public void setNippouRegister(Timestamp nippouRegister) {
		this.nippouRegister = nippouRegister;
	}

	public String getNippouTitle() {
		return this.nippouTitle;
	}

	public void setNippouTitle(String nippouTitle) {
		this.nippouTitle = nippouTitle;
	}

	public Date getNippouTraining() {
		return this.nippouTraining;
	}

	public void setNippouTraining(Date nippouTraining) {
		this.nippouTraining = nippouTraining;
	}

	public List<Comment> getComments() {
		return this.comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public Comment addComment(Comment comment) {
		getComments().add(comment);
		comment.setNippou(this);

		return comment;
	}

	public Comment removeComment(Comment comment) {
		getComments().remove(comment);
		comment.setNippou(null);

		return comment;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}