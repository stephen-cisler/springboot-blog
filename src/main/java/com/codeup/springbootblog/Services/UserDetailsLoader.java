package com.codeup.springbootblog.Services;

import com.codeup.springbootblog.Models.User;
import com.codeup.springbootblog.Models.UserWithRoles;
import com.codeup.springbootblog.Repositories.UsersRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsLoader implements UserDetailsService{
    private final UsersRepository users;

    public UserDetailsLoader(UsersRepository usersRepository) {
        this.users = usersRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = users.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("No user found for " + username);
        }

        return new UserWithRoles(user);
    }


}
