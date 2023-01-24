package uz.b.application.rest.entity.applicant;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.b.application.base.BaseEntityUUID;
import uz.b.application.base.BaseScheme;
import uz.b.application.rest.entity.StudyFieldEntity;
import uz.b.application.rest.entity.file.Attachment;
import uz.b.application.rest.enums.ApplicationStatus;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(schema = BaseScheme.DEFAULT)
public class ApplicantApplication extends BaseEntityUUID {
    @Enumerated(EnumType.STRING)
    private ApplicationStatus applicationStatus;
    @Column(length = 2000)
    private String reqComment;
    @Column(length = 2000)
    private String resComment;
    @OneToOne(fetch = FetchType.LAZY)
    private Attachment contractAttachment;
    @OneToOne(fetch = FetchType.LAZY)
    private StudyFieldEntity studyField;
    @OneToOne(fetch = FetchType.LAZY)
    private Applicant applicant;

}
