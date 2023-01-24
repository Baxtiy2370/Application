package uz.b.application.rest.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.b.application.base.BaseEntityUUID;
import uz.b.application.base.BaseScheme;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(schema = BaseScheme.DEFAULT)
public class SmsHistoryEntity extends BaseEntityUUID {
    private String phone;
    @Column(length = 3000)
    private String text;

    @Column(length = 3000)
    private String response;
}
