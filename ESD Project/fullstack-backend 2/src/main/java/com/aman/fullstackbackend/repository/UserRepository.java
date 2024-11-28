package com.aman.fullstackbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.aman.fullstackbackend.model.User;

public interface UserRepository extends JpaRepository<User,Long>
{

}
