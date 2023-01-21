package uz.b.application.config.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import uz.b.application.config.core.GenericResponse;
import uz.b.application.config.core.GlobalVar;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.List;

@Component
public class BeforeFilter extends OncePerRequestFilter {

    List<String> withoutToken = Arrays.asList(
            "/api/v1/file/upload",
            "/api/v1/sign/user/check",
            "/api/v1/sign/send/code",
            "/api/v1/sign/register",
            "/api/v1/admin/sign/login",
            "/api/v1/admin/sign/refresh",
            "/api/v1/field/get/list",
            "/api/v1/student/sign/login",
            "/api/v1/student/sign/refresh",
            "/v3/api-docs",
            "/swagger-ui.html",
            "/swagger-ui/index.css",
            "/swagger-ui/index.html",
            "/swagger-ui/swagger-ui.css",
            "/v3/api-docs/swagger-config",
            "/swagger-ui/favicon-16x16.png",
            "/swagger-ui/favicon-32x32.png",
            "/swagger-ui/swagger-ui.css.map",
            "/swagger-ui/swagger-ui-bundle.js.map",
            "/swagger-ui/swagger-ui-bundle.js",
            "/swagger-ui/swagger-initializer.js",
            "/swagger-ui/swagger-ui-standalone-preset.js",
            "/swagger-ui/swagger-ui-standalone-preset.js.map",
            "/api/v1/doc/download",
            "/api/v1/sign/delete"
    );


    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

    }


    private boolean validForCheckHeader(String uri) {
        for (String permitUrls : this.withoutToken) {
            if (uri.contains(permitUrls)) {
                return false;
            }
        }
        return true;
    }


    private void exception(String message, HttpStatus status, HttpServletResponse response) throws IOException {
        SecurityContextHolder.clearContext();
        GlobalVar.clearContext();
        response.setStatus(status.value());
        OutputStream outStream =response.getOutputStream();
        ObjectMapper mapper =new ObjectMapper();
        mapper.writeValue(outStream, GenericResponse.errorStatus(message,status).getBody());
        outStream.flush();
    }





}
