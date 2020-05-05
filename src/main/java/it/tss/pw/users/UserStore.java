/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.pw.users;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;

/**
 *
 * @author spaceman33
 */
@ApplicationScoped
public class UserStore {

    private Map<Long, User> users = new HashMap<>();

    @PostConstruct
    public void init() {
        System.out.println("init()");
        Stream.of(new User(3l, "marco", "mpwd"), new User(1l, "luca", "lpwd"), new User(2l, "Andrea", "apwd"))
                .forEach(v -> users.put(v.getId(), v));
    }

    public Collection<User> all() {
        return users.values();
    }

    public User create(User u) {
        users.putIfAbsent(u.getId(), u);
        return users.get(u.getId());
    }

    public User update(User u) {
        return users.put(u.getId(), u);
    }

    public void delete(Long id) {
        users.remove(id);
    }

    public User find(Long id) {
        return users.get(id);
    }

    public User updateByName(User u) {
        return users.put(u.getId(), u);
    }

    public Collection<User> search(String search) {
        return users.values().stream()
                .filter(v -> this.filter(v, search))
                .collect(Collectors.toList());
    }

    private boolean filter(User u, String s) {
        return u.getUsr() != null && u.getUsr().contains(s)
                || u.getLastName() != null && u.getUsr().contains(s)
                || u.getFirstName() != null && u.getUsr().contains(s);
    }
}
