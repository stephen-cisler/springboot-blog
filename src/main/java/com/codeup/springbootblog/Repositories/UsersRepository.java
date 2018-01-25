package com.codeup.springbootblog.Repositories;

import com.codeup.springbootblog.Models.User;
import org.springframework.data.repository.CrudRepository;

public interface UsersRepository extends CrudRepository<User, Long>{
}
