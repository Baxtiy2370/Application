package uz.b.application.rest.entity.user;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.b.application.base.BaseEntityUUID;
import uz.b.application.base.BaseScheme;
import uz.b.application.rest.entity.file.Attachment;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(schema = BaseScheme.DEFAULT)
public class ApplicantDiplomaInfo extends BaseEntityUUID {

    private String malumoti;
    private String muassasaTuri;
    private String muassasaNomi;
    private Integer graduatedYear;
    private String region;
    private String district;
    private String diplomaSerial;
    private String diplomaNumber;

    @OneToOne(fetch = FetchType.LAZY)
    private Applicant applicant;
    @OneToOne(fetch = FetchType.LAZY)
    private Attachment diplomaAttachment;
    @OneToOne(fetch = FetchType.LAZY)
    private Attachment tavsiyanomaAttachment;

    @OneToOne(fetch = FetchType.LAZY)
    private Attachment ieltsAttachment;

    @OneToOne(fetch = FetchType.LAZY)
    private Attachment mehnatDaftarAttachment;




}
