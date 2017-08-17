package jp.co.unirita.dairyreport.domain.user;

import jp.co.unirita.dairyreport.domain.report.Report;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
public class User implements Serializable {
    private String id;
    private String firstName;
    private String lastName;
    private Collection<Report> reports;

    @Id
    @Column(name = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @OneToMany(mappedBy = "user")
    public Collection<Report> getReports() {
        return reports;
    }

    public void setReports(Collection<Report> reportsById) {
        this.reports = reportsById;
    }
}
