package com.org.resumebuilder.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.org.resumebuilder.model.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer> {

	Optional<Project> findById(Long id);

	void deleteByResumeBuilderId(long resumeBuilderId);

}
