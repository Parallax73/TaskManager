package br.com.TaskManager.domain.Auth;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface AuthRepository extends JpaRepository<Auth,Long> {
    UserDetails findByLogin(String login);
}
