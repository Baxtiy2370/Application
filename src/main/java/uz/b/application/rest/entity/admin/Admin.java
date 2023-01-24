package uz.b.application.rest.entity.admin;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.b.application.base.BaseEntity;
import uz.b.application.base.BaseEntityUUID;
import uz.b.application.base.BaseScheme;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(schema = BaseScheme.DEFAULT)
public class Admin extends BaseEntityUUID {
    @Column(nullable = false, unique = true)
    private String username;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String role;

    private boolean blocked = Boolean.FALSE;
    @OneToOne(mappedBy = "admin")
    private AdminAccess adminAccess;

}
