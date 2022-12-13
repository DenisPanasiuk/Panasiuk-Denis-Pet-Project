package net.Panasiuk_WebSite.Logic.Authorization.dao;

import net.Panasiuk_WebSite.Sources.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Long> {
    User findByUsername(String username);
    User findUserById(Long id);
}
