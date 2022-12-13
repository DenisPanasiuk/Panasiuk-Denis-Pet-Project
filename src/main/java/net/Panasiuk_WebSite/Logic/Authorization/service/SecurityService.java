package net.Panasiuk_WebSite.Logic.Authorization.service;

public interface SecurityService {

    String findLoggedInUsername();

    void autoLogin(String username, String password);
}
