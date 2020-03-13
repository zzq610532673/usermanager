package com.zzq.usermanager.repository;

import com.zzq.usermanager.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
