package com.org.resumebuilder.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.org.resumebuilder.model.SkillsInterest;

@Repository
public interface SkillsInterestRepository extends JpaRepository<SkillsInterest, Integer> {

	Optional<SkillsInterest> findById(Long id);

	void deleteByResumeBuilderId(Long id);
}
