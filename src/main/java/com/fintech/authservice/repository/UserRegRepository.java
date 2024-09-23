package com.fintech.authservice.repository;

import com.fintech.authservice.entity.UserId;
import com.fintech.authservice.entity.UserRegDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRegRepository extends JpaRepository<UserRegDetails, UserId> {
    public UserRegDetails findByUserIdMobileNumber(String mobileNumber);
    public UserRegDetails findByUserIdId(String userId);
    public UserRegDetails findByUserIdMobileNumberOrUserIdId(String mobileNumber, String userId);
}