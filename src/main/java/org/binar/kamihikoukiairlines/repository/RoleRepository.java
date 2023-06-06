package org.binar.kamihikoukiairlines.repository;

import org.binar.kamihikoukiairlines.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
