package me.batizhao.cloud.repository;

import me.batizhao.cloud.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author batizhao
 * @since 2017/2/21
 */
public interface UserRepository extends JpaRepository<User, Long> {
}
