package com.org.resumebuilder.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.org.resumebuilder.model.Education;

@Repository
public interface EducationRepository extends JpaRepository<Education, Integer> {

	Optional<Education> findById(Long id);

	void deleteByResumeBuilderId(long resumeBuilderId);

}
