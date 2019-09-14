package com.seguirapp.repository;

import com.seguirapp.model.AuthModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthRepository extends JpaRepository <AuthModel, String> {
}
