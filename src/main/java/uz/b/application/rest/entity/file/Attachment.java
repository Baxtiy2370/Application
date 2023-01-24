package uz.b.application.rest.entity.file;

import jakarta.persistence.*;
import lombok.*;
import uz.b.application.base.BaseEntityUUID;
import uz.b.application.base.BaseScheme;
import uz.b.application.rest.enums.attachment.FileStatus;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(schema = BaseScheme.DEFAULT)
public class Attachment extends BaseEntityUUID {

    private String name;

    private String originalName;
    @Column(nullable = false)
    private String contentType;
    @Column(nullable = false)
    private Long size;

    private String fullPath;
    @Enumerated(EnumType.STRING)
    private FileStatus fileStatus;

}
