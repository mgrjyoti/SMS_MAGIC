package com.srit.company.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.srit.company.entity.ClientUsers;

public interface ClientUserRepository extends JpaRepository<ClientUsers, Long> {

}
