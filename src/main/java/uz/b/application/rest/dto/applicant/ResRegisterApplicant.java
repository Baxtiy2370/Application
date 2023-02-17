package uz.b.application.rest.dto.applicant;

import lombok.Data;

import java.util.UUID;

@Data
public class ResRegisterApplicant {

    private UUID accessToken;
    private UUID refreshToken;
    private String message;
}
