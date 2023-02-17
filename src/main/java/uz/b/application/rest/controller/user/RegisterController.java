package uz.b.application.rest.controller.user;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.b.application.base.BaseURI;
import uz.b.application.config.core.GenericResponse;
import uz.b.application.config.logger.Logger;
import uz.b.application.rest.dto.applicant.ResRegisterApplicant;
import uz.b.application.rest.service.user.ApplicantSignService;

@RestController
@RequestMapping(BaseURI.API1 + BaseURI.USER)
@Tag(name = "applicant sign module")
public class RegisterController {

    private final ApplicantSignService signService;


    public RegisterController(ApplicantSignService applicantSignService) {
        this.signService = applicantSignService;
    }


    public ResponseEntity<GenericResponse<ResRegisterApplicant>> register(@RequestBody @Valid ResRegisterApplicant resRegisterApplicantDTO) {

        try {
            Logger.req(resRegisterApplicantDTO);
            ResRegisterApplicant register = signService.register(resRegisterApplicantDTO);
            Logger.res(register);
            return GenericResponse.success200(register);
        }catch (Exception e){
            return GenericResponse.error500(e.getMessage());
        }
    }


}
