package com.org.resumebuilder.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.org.resumebuilder.model.SkillsIntrest;

@Repository
public interface SkillsIntrestRepository extends JpaRepository<SkillsIntrest, Integer> {

	Optional<SkillsIntrest> findById(Long id);

	void deleteByResumeBuilderId(Long id);

}
