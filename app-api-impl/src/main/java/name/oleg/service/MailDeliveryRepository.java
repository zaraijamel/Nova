package name.oleg.service;

import name.oleg.entity.MailDelivery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MailDeliveryRepository extends JpaRepository<MailDelivery, Long> {

    @Modifying
    @Query("delete from MailDelivery m where m.email = :email")
    public void removeByEmail(@Param("email") String email);
}
