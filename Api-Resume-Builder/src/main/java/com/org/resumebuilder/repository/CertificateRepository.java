package com.org.resumebuilder.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.org.resumebuilder.model.Certificate;

@Repository
public interface CertificateRepository extends JpaRepository<Certificate, Integer> {

	Optional<Certificate> findById(Long id);

	void deleteByResumeBuilderId(long resumeBuilderId);

}
