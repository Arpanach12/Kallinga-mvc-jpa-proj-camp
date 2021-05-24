package com.mindtree.librarymanagementsystem.modules.user.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.librarymanagementsystem.modules.common.enums.RoleName;
import com.mindtree.librarymanagementsystem.modules.user.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

	Optional<Role> findByRoleName(RoleName roleName);

}
