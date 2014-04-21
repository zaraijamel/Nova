package name.oleg.service;

import name.oleg.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("select u from name.oleg.entity.User u where u.login = :login")
    public User findByLogin(@Param("login") String login);
}
