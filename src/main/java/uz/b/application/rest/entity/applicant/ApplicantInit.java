package uz.b.application.rest.entity.applicant;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.b.application.base.BaseEntityUUID;
import uz.b.application.base.BaseScheme;
import uz.b.application.rest.enums.CodeStatus;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(schema = BaseScheme.DEFAULT)
public class ApplicantInit extends BaseEntityUUID {

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    private Integer code;

    @Column(nullable = false)
    private Byte tryCount = 0;

    @Column(nullable = false)
    private LocalDateTime codeExpire;

    @Enumerated(EnumType.STRING)
    private CodeStatus codeStatus = CodeStatus.ACTIVE;

    @Column(nullable = false)
    private Boolean isReg = Boolean.FALSE;

    private UUID applicantId;
}
