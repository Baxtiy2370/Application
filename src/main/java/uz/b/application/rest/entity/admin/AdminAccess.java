package uz.b.application.rest.entity.admin;

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

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(schema = BaseScheme.DEFAULT)
public class AdminAccess extends BaseEntityUUID {


    private UUID refreshToken;
    private LocalDateTime refreshTokenExpire;
    private UUID accessToken;

    private LocalDateTime accessTokenExpire;
    @OneToOne(fetch = FetchType.LAZY)
    private Admin admin;
}
