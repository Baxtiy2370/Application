package uz.b.application.rest.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.b.application.base.BaseEntityUUID;
import uz.b.application.base.BaseScheme;
import uz.b.application.rest.enums.EFieldType;
import uz.b.application.rest.enums.EStudyType;
import uz.b.application.rest.enums.StudyLang;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(schema = BaseScheme.DEFAULT)
public class UniverConfigEntity extends BaseEntityUUID {


    private String contractCode;
    private String fieldCode;
    private String fieldName;
    private Double contractCost;
    private String contractCostInLetters;
    private String bankAccount;
    private String bankMFO;
    private String bankName;
    private Integer duration;
    private Boolean isVisible;



    @Enumerated(EnumType.STRING)
    private EFieldType fieldType;

    @Enumerated(EnumType.STRING)
    private EStudyType studyType;

    @Enumerated(EnumType.STRING)
    private StudyLang language;

}
