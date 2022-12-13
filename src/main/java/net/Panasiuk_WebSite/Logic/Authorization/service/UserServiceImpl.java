package net.Panasiuk_WebSite.Logic.Authorization.service;

import net.Panasiuk_WebSite.Logic.Authorization.dao.MarkDao;
import net.Panasiuk_WebSite.Logic.Authorization.dao.RoleDao;
import net.Panasiuk_WebSite.Logic.Authorization.dao.UserDao;
import net.Panasiuk_WebSite.Sources.Model.Mark;
import net.Panasiuk_WebSite.Sources.Model.Role;
import net.Panasiuk_WebSite.Sources.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    public UserServiceImpl(UserDao userDao, RoleDao roleDao, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userDao = userDao;
        this.roleDao = roleDao;
        this.markDao = markDao;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public UserServiceImpl() {
    }

    @Autowired
    private UserDao userDao;

    @Autowired
    private MarkDao markDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        Set<Role> roles = new HashSet<>();
        roles.add(roleDao.getOne(1L));
        user.setRoles(roles);
        userDao.save(user);
        Mark marks = new Mark();
        marks.setId(user.getId());
        markDao.save(marks);
    }

    @Override
    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }

    @Override
    public void delete(Long id) {
        markDao.delete(id);
        userDao.delete(id);
    }
}
