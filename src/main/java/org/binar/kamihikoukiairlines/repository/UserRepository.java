package org.binar.kamihikoukiairlines.repository;

import org.binar.kamihikoukiairlines.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
}
