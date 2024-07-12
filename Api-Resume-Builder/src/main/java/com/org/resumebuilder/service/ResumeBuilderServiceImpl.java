package com.org.resumebuilder.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.org.resumebuilder.dto.CertificateDTO;
import com.org.resumebuilder.dto.EducationDTO;
import com.org.resumebuilder.dto.ProjectDTO;
import com.org.resumebuilder.dto.ResumeBuilderDTO;
import com.org.resumebuilder.dto.SkillsIntrestDTO;
import com.org.resumebuilder.dto.WorkExperienceDTO;
import com.org.resumebuilder.exception.ResourceNotFoundException;
import com.org.resumebuilder.model.Certificate;
import com.org.resumebuilder.model.Education;
import com.org.resumebuilder.model.Project;
import com.org.resumebuilder.model.ResumeBuilder;
import com.org.resumebuilder.model.SkillsIntrest;
import com.org.resumebuilder.model.WorkExperience;
import com.org.resumebuilder.repository.CertificateRepository;
import com.org.resumebuilder.repository.EducationRepository;
import com.org.resumebuilder.repository.ProjectRepository;
import com.org.resumebuilder.repository.ResumeBuilderRepository;
import com.org.resumebuilder.repository.SkillsIntrestRepository;
import com.org.resumebuilder.repository.WorkExperienceRepository;

@Service
public class ResumeBuilderServiceImpl implements IResumeBuilderService {

	@Autowired
	private ResumeBuilderRepository resumeBuilderRepository;

	@Autowired
	private CertificateRepository certificateRepository;

	@Autowired
	private EducationRepository educationRepository;

	@Autowired
	private ProjectRepository projectRepository;

	@Autowired
	private SkillsIntrestRepository skillsIntrestRepository;

	@Autowired
	private WorkExperienceRepository workExperienceRepository;

	@Autowired
	private ModelMapper modelMapper;

	/*
	 * Get List of Resume Builder Data Start
	 ********************************************************************************************/

	@Override
	public List<ResumeBuilderDTO> getAllUsers() {
		List<ResumeBuilder> all = resumeBuilderRepository.findAll();
		List<ResumeBuilderDTO> resumeBuilderDTOs = all.stream().map(resumeBuildObj -> {
			ResumeBuilderDTO resumeBuilderDTO = modelMapper.map(resumeBuildObj, ResumeBuilderDTO.class);

			// Education entities to EducationDTOs
			List<EducationDTO> educationDTOs = resumeBuildObj.getEducation().stream()
					.map(a -> educationRepository.findById(a.getId())
							.map(education -> modelMapper.map(education, EducationDTO.class))
							.orElseThrow(() -> new RuntimeException("Education not found")))
					.collect(Collectors.toList());
			resumeBuilderDTO.setEducationDTO(educationDTOs);

			// Certificate entities to CertificateDTOs
			List<CertificateDTO> certificateDTOs = resumeBuildObj.getCertificate().stream()
					.map(a -> certificateRepository.findById(a.getId())
							.map(certificate -> modelMapper.map(certificate, CertificateDTO.class))
							.orElseThrow(() -> new RuntimeException("Certificate not found")))
					.collect(Collectors.toList());
			resumeBuilderDTO.setCertificateDTO(certificateDTOs);

			// SkillsIntrest entities to SkillsIntrestDTOs
			List<SkillsIntrestDTO> skillsIntrestDTOs = resumeBuildObj.getSkillsIntrest().stream()
					.map(a -> skillsIntrestRepository.findById(a.getId())
							.map(skillsIntrest -> modelMapper.map(skillsIntrest, SkillsIntrestDTO.class))
							.orElseThrow(() -> new RuntimeException("SkillsIntrest not found")))
					.collect(Collectors.toList());
			resumeBuilderDTO.setSkillsIntrestDTO(skillsIntrestDTOs);

			// WorkExperience entities to WorkExperienceDTOs
			List<WorkExperienceDTO> workExperienceDTOs = resumeBuildObj.getWorkExperience().stream()
					.map(a -> workExperienceRepository.findById(a.getId())
							.map(workExperience -> modelMapper.map(workExperience, WorkExperienceDTO.class))
							.orElseThrow(() -> new RuntimeException("WorkExperience not found")))
					.collect(Collectors.toList());
			resumeBuilderDTO.setWorkExperienceDTO(workExperienceDTOs);

			// Project entities to ProjectDTOs
			List<ProjectDTO> projectDTOs = resumeBuildObj.getProject().stream()
					.map(a -> projectRepository.findById(a.getId())
							.map(project -> modelMapper.map(project, ProjectDTO.class))
							.orElseThrow(() -> new RuntimeException("Project not found")))
					.collect(Collectors.toList());
			resumeBuilderDTO.setProjectDTO(projectDTOs);

			return resumeBuilderDTO;
		}).collect(Collectors.toList());

		return resumeBuilderDTOs;
	}

	/*
	 * Get List of Resume Builder Data End
	 ********************************************************************************************/

	/**************************************************************************************************************/

	/*
	 * Get Resume Builder By Id start
	 ********************************************************************************************/

	@Override
	public ResumeBuilderDTO findById(Long id) {
		ResumeBuilder resumeBuildObj = resumeBuilderRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Resume not found"));

		// Map ResumeBuilder to ResumeBuilderDTO
		ResumeBuilderDTO resumeBuilderDTO = modelMapper.map(resumeBuildObj, ResumeBuilderDTO.class);

		// Education entities to EducationDTOs
		List<EducationDTO> educationDTOs = resumeBuildObj.getEducation().stream()
				.map(a -> educationRepository.findById(a.getId())
						.map(education -> modelMapper.map(education, EducationDTO.class))
						.orElseThrow(() -> new RuntimeException("Education not found")))
				.collect(Collectors.toList());
		resumeBuilderDTO.setEducationDTO(educationDTOs);

		// Certificate entities to CertificateDTOs
		List<CertificateDTO> certificateDTOs = resumeBuildObj.getCertificate().stream()
				.map(a -> certificateRepository.findById(a.getId())
						.map(certificate -> modelMapper.map(certificate, CertificateDTO.class))
						.orElseThrow(() -> new RuntimeException("Certificate not found")))
				.collect(Collectors.toList());
		resumeBuilderDTO.setCertificateDTO(certificateDTOs);

		// SkillsIntrest entities to SkillsIntrestDTOs
		List<SkillsIntrestDTO> skillsIntrestDTOs = resumeBuildObj.getSkillsIntrest().stream()
				.map(a -> skillsIntrestRepository.findById(a.getId())
						.map(skillsIntrest -> modelMapper.map(skillsIntrest, SkillsIntrestDTO.class))
						.orElseThrow(() -> new RuntimeException("SkillsIntrest not found")))
				.collect(Collectors.toList());
		resumeBuilderDTO.setSkillsIntrestDTO(skillsIntrestDTOs);

		// WorkExperience entities to WorkExperienceDTOs
		List<WorkExperienceDTO> workExperienceDTOs = resumeBuildObj.getWorkExperience().stream()
				.map(a -> workExperienceRepository.findById(a.getId())
						.map(workExperience -> modelMapper.map(workExperience, WorkExperienceDTO.class))
						.orElseThrow(() -> new RuntimeException("WorkExperience not found")))
				.collect(Collectors.toList());
		resumeBuilderDTO.setWorkExperienceDTO(workExperienceDTOs);

		// Project entities to ProjectDTOs
		List<ProjectDTO> projectDTOs = resumeBuildObj.getProject().stream()
				.map(a -> projectRepository.findById(a.getId())
						.map(project -> modelMapper.map(project, ProjectDTO.class))
						.orElseThrow(() -> new RuntimeException("Project not found")))
				.collect(Collectors.toList());
		resumeBuilderDTO.setProjectDTO(projectDTOs);

		return resumeBuilderDTO;
	}

	/*
	 * Get Resume Builder By Id End
	 ********************************************************************************************/

	/**************************************************************************************************************/

	/*
	 * Create Resume Builder Data Start
	 ********************************************************************************************/

	@Override
	public ResumeBuilderDTO saveResume(ResumeBuilderDTO resumeBuilderDTO) {
		// Map DTO to Entity
		ResumeBuilder resumeBuilder = modelMapper.map(resumeBuilderDTO, ResumeBuilder.class);

		// Save ResumeBuilder entity first to get the ID
		ResumeBuilder savedResumeBuilder = resumeBuilderRepository.save(resumeBuilder);
		long resumeBuilderId = savedResumeBuilder.getId();

		// Save related entities
		List<CertificateDTO> listOfCertificates = null;
		if (resumeBuilderDTO.getCertificateDTO() != null) {
			List<Certificate> certificates = resumeBuilderDTO.getCertificateDTO().stream().map(dto -> {
				Certificate certificate = modelMapper.map(dto, Certificate.class);
				certificate.setResumeBuilderId(resumeBuilderId);
				return certificate;
			}).collect(Collectors.toList());
			List<Certificate> savedCertificates = certificateRepository.saveAll(certificates);
			listOfCertificates = savedCertificates.stream().map(e -> (modelMapper.map(e, CertificateDTO.class)))
					.collect(Collectors.toList());
		}

		List<EducationDTO> listOfEducations = null;
		if (resumeBuilderDTO.getEducationDTO() != null) {
			List<Education> educations = resumeBuilderDTO.getEducationDTO().stream().map(dto -> {
				Education education = modelMapper.map(dto, Education.class);
				education.setResumeBuilderId(resumeBuilderId);
				return education;
			}).collect(Collectors.toList());
			List<Education> savedEducations = educationRepository.saveAll(educations);
			listOfEducations = savedEducations.stream().map(e -> modelMapper.map(e, EducationDTO.class))
					.collect(Collectors.toList());
		}

		List<ProjectDTO> listOfProjects = null;
		if (resumeBuilderDTO.getProjectDTO() != null) {
			List<Project> projects = resumeBuilderDTO.getProjectDTO().stream().map(dto -> {
				Project project = modelMapper.map(dto, Project.class);
				project.setResumeBuilderId(resumeBuilderId);
				return project;
			}).collect(Collectors.toList());
			List<Project> savedProjects = projectRepository.saveAll(projects);
			listOfProjects = savedProjects.stream().map(e -> modelMapper.map(e, ProjectDTO.class))
					.collect(Collectors.toList());
		}

		List<SkillsIntrestDTO> listOfSkillsIntrests = null;
		if (resumeBuilderDTO.getSkillsIntrestDTO() != null) {
			List<SkillsIntrest> skillsIntrests = resumeBuilderDTO.getSkillsIntrestDTO().stream().map(dto -> {
				SkillsIntrest skillsIntrest = modelMapper.map(dto, SkillsIntrest.class);
				skillsIntrest.setResumeBuilderId(resumeBuilderId);
				return skillsIntrest;
			}).collect(Collectors.toList());
			List<SkillsIntrest> savedSkillsIntrests = skillsIntrestRepository.saveAll(skillsIntrests);
			listOfSkillsIntrests = savedSkillsIntrests.stream().map(e -> modelMapper.map(e, SkillsIntrestDTO.class))
					.collect(Collectors.toList());
		}

		List<WorkExperienceDTO> listOfWorkExperiences = null;
		if (resumeBuilderDTO.getWorkExperienceDTO() != null) {
			List<WorkExperience> workExperiences = resumeBuilderDTO.getWorkExperienceDTO().stream().map(dto -> {
				WorkExperience workExperience = modelMapper.map(dto, WorkExperience.class);
				workExperience.setResumeBuilderId(resumeBuilderId);
				return workExperience;
			}).collect(Collectors.toList());
			List<WorkExperience> savedWorkExperiences = workExperienceRepository.saveAll(workExperiences);
			listOfWorkExperiences = savedWorkExperiences.stream().map(e -> modelMapper.map(e, WorkExperienceDTO.class))
					.collect(Collectors.toList());
		}

		// Map back to DTO
		ResumeBuilderDTO resultDTO = modelMapper.map(savedResumeBuilder, ResumeBuilderDTO.class);
		resultDTO.setCertificateDTO(listOfCertificates);
		resultDTO.setEducationDTO(listOfEducations);
		resultDTO.setProjectDTO(listOfProjects);
		resultDTO.setSkillsIntrestDTO(listOfSkillsIntrests);
		resultDTO.setWorkExperienceDTO(listOfWorkExperiences);
		return resultDTO;
	}

	/*
	 * Create Resume Builder Data End
	 ********************************************************************************************/

	/**************************************************************************************************************/

	/*
	 * Update Resume Builder Data Start
	 ********************************************************************************************/

	@Override
	public ResumeBuilderDTO updateResume(long id, ResumeBuilderDTO resumeBuilderDTO) {
		// Find existing ResumeBuilder entity
		ResumeBuilder existingResumeBuilder = resumeBuilderRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Resume not found with id " + id));

		// Update ResumeBuilder entity
		modelMapper.map(resumeBuilderDTO, existingResumeBuilder);
		ResumeBuilder updatedResumeBuilder = resumeBuilderRepository.save(existingResumeBuilder);

		// Update related entities
		List<CertificateDTO> listOfCertificates = updateCertificates(resumeBuilderDTO.getCertificateDTO(), id);
		List<EducationDTO> listOfEducations = updateEducations(resumeBuilderDTO.getEducationDTO(), id);
		List<ProjectDTO> listOfProjects = updateProjects(resumeBuilderDTO.getProjectDTO(), id);
		List<SkillsIntrestDTO> listOfSkillsIntrests = updateSkillsIntrests(resumeBuilderDTO.getSkillsIntrestDTO(), id);
		List<WorkExperienceDTO> listOfWorkExperiences = updateWorkExperiences(resumeBuilderDTO.getWorkExperienceDTO(),
				id);

		// Map back to DTO
		ResumeBuilderDTO resultDTO = modelMapper.map(updatedResumeBuilder, ResumeBuilderDTO.class);
		resultDTO.setCertificateDTO(listOfCertificates);
		resultDTO.setEducationDTO(listOfEducations);
		resultDTO.setProjectDTO(listOfProjects);
		resultDTO.setSkillsIntrestDTO(listOfSkillsIntrests);
		resultDTO.setWorkExperienceDTO(listOfWorkExperiences);
		return resultDTO;
	}

	private List<CertificateDTO> updateCertificates(List<CertificateDTO> certificateDTOs, long resumeBuilderId) {
		if (certificateDTOs == null)
			return null;

		List<Certificate> certificates = certificateDTOs.stream().map(dto -> {
			Certificate certificate = modelMapper.map(dto, Certificate.class);
			certificate.setResumeBuilderId(resumeBuilderId);
			return certificate;
		}).collect(Collectors.toList());
		List<Certificate> savedCertificates = certificateRepository.saveAll(certificates);
		return savedCertificates.stream().map(e -> modelMapper.map(e, CertificateDTO.class))
				.collect(Collectors.toList());
	}

	private List<EducationDTO> updateEducations(List<EducationDTO> educationDTOs, long resumeBuilderId) {
		if (educationDTOs == null)
			return null;

		List<Education> educations = educationDTOs.stream().map(dto -> {
			Education education = modelMapper.map(dto, Education.class);
			education.setResumeBuilderId(resumeBuilderId);
			return education;
		}).collect(Collectors.toList());
		List<Education> savedEducations = educationRepository.saveAll(educations);
		return savedEducations.stream().map(e -> modelMapper.map(e, EducationDTO.class)).collect(Collectors.toList());
	}

	private List<ProjectDTO> updateProjects(List<ProjectDTO> projectDTOs, long resumeBuilderId) {
		if (projectDTOs == null)
			return null;

		List<Project> projects = projectDTOs.stream().map(dto -> {
			Project project = modelMapper.map(dto, Project.class);
			project.setResumeBuilderId(resumeBuilderId);
			return project;
		}).collect(Collectors.toList());
		List<Project> savedProjects = projectRepository.saveAll(projects);
		return savedProjects.stream().map(e -> modelMapper.map(e, ProjectDTO.class)).collect(Collectors.toList());
	}

	private List<SkillsIntrestDTO> updateSkillsIntrests(List<SkillsIntrestDTO> skillsIntrestDTOs,
			long resumeBuilderId) {
		if (skillsIntrestDTOs == null)
			return null;

		List<SkillsIntrest> skillsIntrests = skillsIntrestDTOs.stream().map(dto -> {
			SkillsIntrest skillsIntrest = modelMapper.map(dto, SkillsIntrest.class);
			skillsIntrest.setResumeBuilderId(resumeBuilderId);
			return skillsIntrest;
		}).collect(Collectors.toList());
		List<SkillsIntrest> savedSkillsIntrests = skillsIntrestRepository.saveAll(skillsIntrests);
		return savedSkillsIntrests.stream().map(e -> modelMapper.map(e, SkillsIntrestDTO.class))
				.collect(Collectors.toList());
	}

	private List<WorkExperienceDTO> updateWorkExperiences(List<WorkExperienceDTO> workExperienceDTOs,
			long resumeBuilderId) {
		if (workExperienceDTOs == null)
			return null;

		List<WorkExperience> workExperiences = workExperienceDTOs.stream().map(dto -> {
			WorkExperience workExperience = modelMapper.map(dto, WorkExperience.class);
			workExperience.setResumeBuilderId(resumeBuilderId);
			return workExperience;
		}).collect(Collectors.toList());
		List<WorkExperience> savedWorkExperiences = workExperienceRepository.saveAll(workExperiences);
		return savedWorkExperiences.stream().map(e -> modelMapper.map(e, WorkExperienceDTO.class))
				.collect(Collectors.toList());
	}

	/*
	 * Update Resume Builder Data End
	 ********************************************************************************************/

	/* Delete Resume By Id *****/
	@Override
	@Transactional
	public void deleteResumeBuilder(Long id) {
		certificateRepository.deleteByResumeBuilderId(id);
		educationRepository.deleteByResumeBuilderId(id);
		projectRepository.deleteByResumeBuilderId(id);
		skillsIntrestRepository.deleteByResumeBuilderId(id);
		workExperienceRepository.deleteByResumeBuilderId(id);
		// Delete the resume builder
		resumeBuilderRepository.deleteById(id);
	}

}
