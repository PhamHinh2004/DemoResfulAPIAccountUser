package Website.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import Website.Model.User;
import jakarta.transaction.Transactional;

@Repository
public interface UserResponsitory extends JpaRepository<User, Long> {

	@Modifying
	@Transactional
	@Query("UPDATE User u SET u.username = :username, u.password = :password WHERE u.id = :id")
	int updateUser(@Param("id") Long id, @Param("username") String username, @Param("password") String password);
	

	
}
