package net.Panasiuk_WebSite.Logic.Authorization.dao;


import net.Panasiuk_WebSite.Sources.Model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleDao extends JpaRepository<Role, Long> {}
