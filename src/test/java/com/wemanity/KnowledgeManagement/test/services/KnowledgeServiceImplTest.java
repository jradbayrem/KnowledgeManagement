package com.wemanity.KnowledgeManagement.test.services;

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

import com.wemanity.KnowledgeManagement.entities.Knowledge;
import com.wemanity.KnowledgeManagement.entities.Project;
import com.wemanity.KnowledgeManagement.entities.User;
import com.wemanity.KnowledgeManagement.repositories.IKnowledgeRepository;
import com.wemanity.KnowledgeManagement.services.impl.KnowledgeServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class KnowledgeServiceImplTest {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(KnowledgeServiceImplTest.class);
	private KnowledgeServiceImpl knowledgeService;
	@Mock
	IKnowledgeRepository knowledgeRepository;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		knowledgeService = new KnowledgeServiceImpl(knowledgeRepository);
	}
	
	@Test
	public void should_store_when_save_is_called() {
		LOGGER.info("--------------- Executing should_store_when_save_is_called test Of KnowledgeServiceImplTest ---------------");
		Knowledge knowledge = new Knowledge();
		knowledgeService.save(knowledge);
		Mockito.verify(knowledgeRepository).save(knowledge);
	}
	
	@Test
	public void should_update_when_update_is_called() {
		LOGGER.info("--------------- Executing should_update_when_update_is_called test Of KnowledgeServiceImplTest ---------------");
		Knowledge knowledge = new Knowledge();
		knowledgeService.update(knowledge);
		Mockito.verify(knowledgeRepository).save(knowledge);
	}
	
	@Test
	public void should_delete_when_delete_is_called() {
		LOGGER.info("--------------- Executing should_delete_when_delete_is_called test Of KnowledgeServiceImplTest ---------------");
		Knowledge knowledge = new Knowledge();
		knowledgeService.delete(knowledge);
		Mockito.verify(knowledgeRepository).delete(knowledge);
	}
	
	@Test
	public void should_search_all_when_findAll_is_called() {
		LOGGER.info("--------------- Executing should_search_all_when_findAll_is_called test Of KnowledgeServiceImplTest ---------------");
		knowledgeService.findAll();
		Mockito.verify(knowledgeRepository).findAll();
	}
	
	@Test
	public void should_search_by_id_when_findById_is_called() {
		LOGGER.info("--------------- Executing should_search_by_id_when_findById_is_called test Of KnowledgeServiceImplTest ---------------");
		knowledgeService.findById(new Integer(1));
		Mockito.verify(knowledgeRepository).findById(new Integer(1));
	}

	@Test
	public void should_search_by_project_when_findByRelatedProject_is_called() {
		LOGGER.info("--------------- Executing should_search_by_project_when_findByRelatedProject_is_called test Of KnowledgeServiceImplTest ---------------");
		Project myProject = new Project();
		knowledgeService.findByRelatedProject(myProject);
		Mockito.verify(knowledgeRepository).findByRelatedProject(myProject);
	}

	@Test
	public void should_search_by_user_when_findByUserCreator_is_called() {
		LOGGER.info("--------------- Executing should_search_by_user_when_findByUserCreator_is_called test Of KnowledgeServiceImplTest ---------------");
		User myUser = new User();
		knowledgeService.findByUserCreator(myUser);
		Mockito.verify(knowledgeRepository).findByUserCreator(myUser);
	}

}
