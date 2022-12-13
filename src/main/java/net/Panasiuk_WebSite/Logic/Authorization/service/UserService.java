package net.Panasiuk_WebSite.Logic.Authorization.service;

import net.Panasiuk_WebSite.Sources.Model.User;

public interface UserService {

    void save(User user);

    User findByUsername(String username);

    void delete(Long id);
}
