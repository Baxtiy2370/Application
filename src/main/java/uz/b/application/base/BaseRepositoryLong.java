package uz.b.application.base;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseRepositoryLong<R extends BaseEntityLong> extends JpaRepository<R, Long> {
}
