package uz.b.application.rest.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum EStudyType {
    BAKALAVR("B"),
    MAGISTR("M");
    public final String code;

}
