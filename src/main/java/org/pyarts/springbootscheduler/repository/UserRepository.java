package org.pyarts.springbootscheduler.repository;

import org.pyarts.springbootscheduler.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
