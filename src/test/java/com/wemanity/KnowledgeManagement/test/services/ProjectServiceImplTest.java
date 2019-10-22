package com.wemanity.KnowledgeManagement.test.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.wemanity.KnowledgeManagement.dto.UserDto;
import com.wemanity.KnowledgeManagement.exceptions.ProjectDtoIsNullException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.wemanity.KnowledgeManagement.dto.ProjectDto;
import com.wemanity.KnowledgeManagement.entities.Project;
import com.wemanity.KnowledgeManagement.entities.User;
import com.wemanity.KnowledgeManagement.repositories.IProjectRepository;
import com.wemanity.KnowledgeManagement.services.impl.ProjectServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjectServiceImplTest {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ProjectServiceImplTest.class);
	private ProjectServiceImpl projectService;
	@Mock
	IProjectRepository projectRepository;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		projectService = new ProjectServiceImpl(projectRepository);
	}
	
	@Test
	public void should_store_when_save_is_called() {
		LOGGER.info("--------------- Executing should_store_when_save_is_called test Of ProjectServiceImplTest ---------------");
		Project myProject = new Project();
		projectService.save(myProject);
		Mockito.verify(projectRepository).save(myProject);
	}
	
	@Test
	public void should_update_when_update_is_called() {
		LOGGER.info("--------------- Executing should_update_when_update_is_called test Of ProjectServiceImplTest ---------------");
		Project myProject = new Project();
		projectService.update(myProject);
		Mockito.verify(projectRepository).save(myProject);
	}
	
	@Test
	public void should_delete_when_delete_is_called() {
		LOGGER.info("--------------- Executing should_delete_when_delete_is_called test Of ProjectServiceImplTest ---------------");
		Project myProject = new Project();
		projectService.delete(myProject);
		Mockito.verify(projectRepository).delete(myProject);
	}

	@Test
	public void should_search_by_id_when_findById_is_called() {
		LOGGER.info("--------------- Executing should_search_by_id_when_findById_is_called test Of ProjectServiceImplTest ---------------");
		Integer id = new Integer(1);
		projectService.findById(id);
		Mockito.verify(projectRepository).findById(id);
	}
	
	@Test
	public void should_search_all_when_findAll_is_called() {
		LOGGER.info("--------------- Executing should_search_all_when_findAll_is_called test Of ProjectServiceImplTest ---------------");
		projectService.findAll();
		Mockito.verify(projectRepository).findAll();
	}
	
	@Test
	public void should_get_a_not_null_project_when_project_constructor_for_dto_is_called() {
		LOGGER.info("--------------- Executing should_get_a_not_null_project_when_project_constructor_for_dto_is_called test Of ProjectServiceImplTest ---------------");
		ProjectDto projectDto = ProjectDto.builder()
				.businessField("BFA")
				.id(1)
				.customer("BNP")
				.title("Recouvrement")
				.userCreator(new UserDto())
				.build();
		Project myProject =new Project(projectDto);
		assertNotNull(myProject);
		assertNotNull(myProject.getId());
		assertEquals(myProject.getId(),projectDto.getId());
		assertNotNull(myProject.getBusinessField());
		assertEquals(myProject.getBusinessField(),projectDto.getBusinessField());
		assertNotNull(myProject.getTitle());
		assertEquals(myProject.getTitle(),projectDto.getTitle());
		assertNotNull(myProject.getCustomer());
		assertEquals(myProject.getCustomer(),projectDto.getCustomer());
		assertNotNull(myProject.getUserCreator());

	}

	@Test(expected = ProjectDtoIsNullException.class)
	public void
            should_throw_ProjectDtoIsNullException_when_generateProjectWithRefreshedDataFromProjectDto_is_called_and_proectDto_is_null(){
        LOGGER.info("--------------- Executing should_throw_ProjectDtoIsNullException_when_generateProjectWithRefreshedDataFromProjectDto_is_called_and_proectDto_is_null test Of CommentServiceImplTest ---------------");
ProjectDto projectDto = null;
projectService.generateProjectWithRefreshedDataFromProjectDto(projectDto);
    }
}
