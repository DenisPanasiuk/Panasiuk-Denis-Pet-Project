package net.Panasiuk_WebSite.Logic.Authorization.dao;

import net.Panasiuk_WebSite.Sources.Model.Mark;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarkDao extends JpaRepository<Mark, Long> {
    Mark findById(Long id);
}

