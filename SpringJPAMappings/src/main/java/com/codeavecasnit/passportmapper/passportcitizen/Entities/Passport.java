package com.codeavecasnit.passportmapper.passportcitizen.Entities;

import jakarta.persistence.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
public class Passport {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date IssueDate;
    private Date ExpiryDate;
    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "passport_id")
    private Citizen citizen;

    public Passport(Long passportId, Citizen citizen, String expiryDate, String issueDate) {
        this.id = passportId;
        this.citizen = citizen;
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            ExpiryDate = dateFormat.parse(expiryDate);
            IssueDate = dateFormat.parse(issueDate);
        }catch (ParseException e) {
            ExpiryDate = null;
            IssueDate = null;
        }
    }

    public Passport() {}

    public Long getPassportId() {
        return id;
    }

    public void setPassportId(Long passportId) {
        this.id = passportId;
    }

    public Date getIssueDate() {
        return IssueDate;
    }

    public void setIssueDate(Date issueDate) {
        IssueDate = issueDate;
    }

    public Date getExpiryDate() {
        return ExpiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        ExpiryDate = expiryDate;
    }

    public Citizen getCitizen() {
        return citizen;
    }

    public void setCitizen(Citizen citizen) {
        this.citizen = citizen;
    }
}
