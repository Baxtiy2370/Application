package uz.b.application.rest.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum EFieldType {
    MAXSUS_SIRTQI("MS"),
    KECHKI("K"),
    SIRTQI("S"),
    KUNDUZGI("K");

    private final String code;

}
