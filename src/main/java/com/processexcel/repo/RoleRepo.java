package com.processexcel.repo;

import com.processexcel.model.authorities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface RoleRepo extends JpaRepository<authorities,Long> {

}
