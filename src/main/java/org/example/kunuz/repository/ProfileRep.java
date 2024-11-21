package org.example.kunuz.repository;

import org.example.kunuz.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRep extends JpaRepository<Profile, Integer> {
}