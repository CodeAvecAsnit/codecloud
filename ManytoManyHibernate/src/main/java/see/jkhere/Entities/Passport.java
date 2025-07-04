package see.jkhere.Entities;

import jakarta.persistence.*;

@Entity
public class Passport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long passportId;
    private String nationality;
    private String visaDetails;
    @OneToOne(mappedBy = "passport")
    private Citizen citizen;

    public Passport(Long passportId, String visaDetails, String nationality,Citizen citizen) {
        this.passportId = passportId;
        this.visaDetails = visaDetails;
        this.nationality = nationality;
        this.citizen = citizen;
    }
    public Passport() {}

    public Long getPassportId() {
        return passportId;
    }

    public void setPassportId(Long passportId) {
        this.passportId = passportId;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getVisaDetails() {
        return this.visaDetails;
    }

    public void setVisaDetails(String visaDetails) {
        this.visaDetails = visaDetails;
    }
}
