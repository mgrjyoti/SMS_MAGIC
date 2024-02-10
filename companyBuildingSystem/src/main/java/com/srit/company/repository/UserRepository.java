package com.srit.company.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.srit.company.entity.Users;

public interface UserRepository extends JpaRepository<Users, Long> {

}
