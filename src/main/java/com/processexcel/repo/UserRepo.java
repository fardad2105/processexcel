package com.processexcel.repo;

import com.processexcel.model.users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface UserRepo extends JpaRepository<users,String> {
}
