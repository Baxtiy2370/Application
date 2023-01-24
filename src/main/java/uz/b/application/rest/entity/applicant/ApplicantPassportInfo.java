package uz.b.application.rest.entity.applicant;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.b.application.base.BaseEntityUUID;
import uz.b.application.base.BaseScheme;
import uz.b.application.rest.entity.file.Attachment;
import uz.b.application.rest.enums.Gender;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(schema = BaseScheme.DEFAULT)
public class ApplicantPassportInfo extends BaseEntityUUID {

    private String citizenship;
    private String nationality;
    private String region;
    private String district;
    private String streetAndHome;
    private LocalDate birthDate;

    @Column(length = 2)
    private String docSerial;
    private Integer docNumber;
    private String docGivenBy;
    private LocalDate docGivenDate;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @OneToOne(fetch = FetchType.LAZY)
    private Applicant applicant;
    @OneToOne(fetch = FetchType.LAZY)
    private Attachment passportAttachment;

}
