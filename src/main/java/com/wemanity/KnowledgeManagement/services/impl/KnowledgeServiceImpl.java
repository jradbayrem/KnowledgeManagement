package com.wemanity.KnowledgeManagement.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.wemanity.KnowledgeManagement.dto.KnowledgeDto;
import com.wemanity.KnowledgeManagement.exceptions.KnowledgeDtoIsNullException;
import com.wemanity.KnowledgeManagement.exceptions.KnowledgeRepositoryException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wemanity.KnowledgeManagement.entities.Knowledge;
import com.wemanity.KnowledgeManagement.entities.Project;
import com.wemanity.KnowledgeManagement.entities.User;
import com.wemanity.KnowledgeManagement.repositories.IKnowledgeRepository;
import com.wemanity.KnowledgeManagement.services.IKnowledgeService;

@Service
public class KnowledgeServiceImpl implements IKnowledgeService {

	@Autowired
	IKnowledgeRepository knowledgeRepository;

	public KnowledgeServiceImpl(IKnowledgeRepository knowledgeRepository) {
		this.knowledgeRepository = knowledgeRepository;
	}

	@Override
	public Knowledge save(Knowledge knowledge) {
		try {
		knowledge =	this.knowledgeRepository.save(knowledge);
		}catch (KnowledgeRepositoryException e){
			e.printStackTrace();
		}
		return  knowledge;
	}

	@Override
	public Knowledge update(Knowledge knowledge) {
        try {
            knowledge =	this.knowledgeRepository.save(knowledge);
        }catch (KnowledgeRepositoryException e){
            e.printStackTrace();
        }
        return  knowledge;	}

	@Override
	public void delete(Knowledge knowledge) {
        try {
            this.knowledgeRepository.delete(knowledge);
        }catch (KnowledgeRepositoryException e){
            e.printStackTrace();
        }
	}

	@Override
	public List<Knowledge> findAll() {
	    List<Knowledge> knowledges = new ArrayList();
	    try {
	        knowledges = this.knowledgeRepository.findAll();;
        }catch (KnowledgeRepositoryException e){
	        e.printStackTrace();
        }
		return knowledges;
	}

	@Override
	public Optional<Knowledge> findById(Integer id) {
	    Optional<Knowledge> knowledge = Optional.empty();
	    try{
	        knowledge = this.knowledgeRepository.findById(id);
        }catch (KnowledgeRepositoryException e){
	        e.printStackTrace();
        }
		return knowledge;
	}

	@Override
	public List<Knowledge> findByRelatedProject(Project project) {
	    List<Knowledge> knowledges = new ArrayList();
	    try{
            knowledges = this.knowledgeRepository.findByRelatedProject(project);
        }catch (KnowledgeRepositoryException e){
        e.printStackTrace();
    }
		return knowledges;
	}

	@Override
	public List<Knowledge> findByUserCreator(User user) {
        List<Knowledge> knowledges = new ArrayList();
        try{
            knowledges = this.knowledgeRepository.findByUserCreator(user);
        }catch (KnowledgeRepositoryException e){
            e.printStackTrace();
        }
        return knowledges;

	}

    @Override
    public void deleteById(Integer id) {
	    try{
	        this.knowledgeRepository.deleteById(id);
        }catch (KnowledgeRepositoryException e){
            e.printStackTrace();
        }

    }

    @Override
    public Knowledge generateKnowledgeWithRefreshedDataFromKnowledgeDto(KnowledgeDto knowledgeDto) {
        if(knowledgeDto == null){
            throw new KnowledgeDtoIsNullException("The used knowledgeDto is null");
        }
        Knowledge knowledge = new Knowledge();
        try{
            knowledge = this.knowledgeRepository.findById(knowledgeDto.getId()).orElseThrow(
                    () -> new KnowledgeRepositoryException("Knowledge with id" + knowledgeDto.getId() + "not found in" +
                            " Database")     );
        }catch (KnowledgeRepositoryException e){
            e.printStackTrace();
        }
        return knowledge;
    }


}
