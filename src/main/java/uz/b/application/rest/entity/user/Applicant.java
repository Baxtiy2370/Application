package uz.b.application.rest.entity.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.b.application.base.BaseEntityUUID;
import uz.b.application.base.BaseScheme;
import uz.b.application.rest.entity.file.Attachment;
import uz.b.application.rest.enums.ApplicantStatus;
import uz.b.application.rest.enums.ApplicantZone;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(schema = BaseScheme.DEFAULT)
public class Applicant extends BaseEntityUUID {
    @Column(nullable = false, unique = true)
    private String phone;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String middleName;
    @Column(nullable = false)
    private String lastName;
    private String email;

    private String mobilePhone;
    @Enumerated(EnumType.STRING)
    private ApplicantStatus applicantStatus;
    @Enumerated(EnumType.STRING)
    private ApplicantZone zone;
    @OneToOne(fetch = FetchType.LAZY)
    private Attachment profilePhoto;
    @OneToOne(mappedBy = "applicant")
    private ApplicantAccess applicantAccess;
    @OneToOne(mappedBy = "applicant")
    private ApplicantDiplomaInfo applicantDiplomaInfo;
    @OneToOne(mappedBy = "applicant")
    private ApplicantPassportInfo passportInfo;
    @OneToOne(mappedBy = "applicant")
    private ApplicantApplication application;




}
