package com.seguirapp.repository;

import com.seguirapp.model.Auth;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthRepository extends JpaRepository <Auth, String> {
}
