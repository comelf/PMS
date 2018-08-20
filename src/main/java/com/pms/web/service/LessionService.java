package com.doublekick.service;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.doublekick.entity.academy.AcademyBranch;
import com.doublekick.entity.academy.AcademyLession;
import com.doublekick.entity.academy.LessionCategory;
import com.doublekick.entity.academy.OnOffStatus;
import com.doublekick.repository.AcademyLessionRepository;
import com.doublekick.repository.LessionCategoryRepository;
import com.doublekick.repository.OnOffStatusRepository;

@Service
public class LessionService {

	@Autowired
	AcademyLessionRepository lessionRepo;

	@Autowired
	LessionCategoryRepository categoryRepo;

	@Autowired
	OnOffStatusRepository onoffStatusRepo;

	public Page<LessionCategory> getAllAcademyCategoryByPage(Integer branchId, Integer pageNum) {
		OnOffStatus status = onoffStatusRepo.findByTextKey(OnOffStatus.ON);
		Pageable pageable = new PageRequest(pageNum-1, 10, Direction.DESC, "id");
		Page<LessionCategory> pageContent = categoryRepo.findOneByAcademyBranchIdAndStatus(branchId, status, pageable);
		return pageContent;
	}
	
//	@Transactional(rollbackFor=Exception.class)
//	public List<AcademyLession> getAllAcademyLession(Integer branchId) {
//		OnOffStatus status = onoffStatusRepo.findByTextKey(OnOffStatus.ON);
//		List<AcademyLession> lessions = lessionRepo.findAllByAcademyBranchIdAndStatus(branchId, status);
//		return lessions;
//	}

	@Transactional(rollbackFor=Exception.class)
	public List<LessionCategory> getAllAcademyLessionCategory(Integer branchId) {
		OnOffStatus status = onoffStatusRepo.findByTextKey(OnOffStatus.ON);
		List<LessionCategory> category = categoryRepo.findAllByAcademyBranchIdAndStatus(branchId, status);
		
		Iterator<LessionCategory> it = category.iterator();
		while (it.hasNext()) {
			LessionCategory lessionCategory = it.next();
			lessionCategory.setLessions(lessionRepo.findAllByAcademyBranchIdAndLessionCategoryIdAndStatus(branchId, lessionCategory.getId(), status));
		}
		
		return category;
	}

	@Transactional(rollbackFor=Exception.class)
	public List<AcademyLession> getAllAcademyLessionByCategoryId(int branchId, Integer categoryId) {
		OnOffStatus status = onoffStatusRepo.findByTextKey(OnOffStatus.ON);
		List<AcademyLession> lessions = lessionRepo.findAllByAcademyBranchIdAndLessionCategoryIdAndStatus(branchId, categoryId, status);
		return lessions;
	}

	@Transactional(rollbackFor=Exception.class)
	public LessionCategory createLessionCategory(AcademyBranch branch, LessionCategory lessionCategory) {
		lessionCategory.setAcademyBranch(branch);
		OnOffStatus status = onoffStatusRepo.findByTextKey(OnOffStatus.ON);
		lessionCategory.setStatus(status);
		return categoryRepo.saveAndFlush(lessionCategory);
	}

	@Transactional(rollbackFor=Exception.class)
	public boolean deleteLessionCategoryById(AcademyBranch branch, Integer categoryId) {
		try {
			OnOffStatus on = onoffStatusRepo.findByTextKey(OnOffStatus.ON);
			LessionCategory category = categoryRepo.findOneByAcademyBranchAndIdAndStatus(branch, categoryId, on);
			if(category == null){
				return false;
			}
			OnOffStatus off = onoffStatusRepo.findByTextKey(OnOffStatus.OFF);
			category.setStatus(off);
			categoryRepo.saveAndFlush(category);
			
			List<AcademyLession> lessionList = category.getLessions();
			Iterator<AcademyLession> it = lessionList.iterator();
			while (it.hasNext()) {
				AcademyLession academyLession = (AcademyLession) it.next();
				academyLession.setStatus(off);
			}
			lessionRepo.save(lessionList);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Transactional(rollbackFor=Exception.class)
	public LessionCategory editLessionCategoryByCategoryId(AcademyBranch branch, LessionCategory lessionCategory) {
		OnOffStatus status = onoffStatusRepo.findByTextKey(OnOffStatus.ON);
		LessionCategory category = categoryRepo.findOneByAcademyBranchAndIdAndStatus(branch, lessionCategory.getId(), status);
		if(category == null){
			return null;
		}
		category.setName(lessionCategory.getName());
		return category;
	}
	
	public LessionCategory getLessionCategoryByCategoryId(AcademyBranch branch, Integer categoryId) {
		OnOffStatus status = onoffStatusRepo.findByTextKey(OnOffStatus.ON);
		LessionCategory category = categoryRepo.findOneByAcademyBranchAndIdAndStatus(branch, categoryId, status);
		return category;
	}

	public AcademyLession getAcademyLessionByLessionId(AcademyBranch branch, Integer lessionId) {
		OnOffStatus status = onoffStatusRepo.findByTextKey(OnOffStatus.ON);
		return lessionRepo.findOneByAcademyBranchAndIdAndStatus(branch, lessionId, status);
	}

	@Transactional(rollbackFor=Exception.class)
	public AcademyLession createAcademyLession(AcademyBranch branch, AcademyLession academyLession) {
		OnOffStatus status = onoffStatusRepo.findByTextKey(OnOffStatus.ON);
		LessionCategory category = categoryRepo.findOneByAcademyBranchAndIdAndStatus(branch, academyLession.getCategoryId(), status);
		if(category == null){
			return null;
		}
		OnOffStatus lessionStatus = onoffStatusRepo.findByTextKey(academyLession.getStatusText());
		academyLession.setLessionCategory(category);
		academyLession.setAcademyBranch(branch);
		academyLession.setStatus(lessionStatus);
		return lessionRepo.saveAndFlush(academyLession);
	}

	@Transactional(rollbackFor=Exception.class)
	public boolean deleteAcademyLessionByLessionId(AcademyBranch branch, Integer lessionId) {
		try {
			OnOffStatus on = onoffStatusRepo.findByTextKey(OnOffStatus.ON);
			AcademyLession lession = lessionRepo.findOneByAcademyBranchAndIdAndStatus(branch, lessionId, on);
			if(lession == null){
				return false;
			}
			OnOffStatus off = onoffStatusRepo.findByTextKey(OnOffStatus.OFF);
			lession.setStatus(off);
			lessionRepo.saveAndFlush(lession);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Transactional(rollbackFor=Exception.class)
	public AcademyLession editAcademyLession(AcademyBranch branch, AcademyLession academyLession) {
		OnOffStatus status = onoffStatusRepo.findByTextKey(OnOffStatus.ON);
		AcademyLession lession = lessionRepo.findOneByAcademyBranchAndIdAndStatus(branch, academyLession.getId(), status);
		if(lession == null){
			return null;
		}
		OnOffStatus cStatus = onoffStatusRepo.findByTextKey(academyLession.getStatusText());
		
		lession.setLessionFee(academyLession.getLessionFee());
		lession.setLessionMethod(academyLession.getLessionMethod());
		lession.setLessionTime(academyLession.getLessionTime());
		lession.setName(academyLession.getName());
		lession.setStatus(cStatus);
		lessionRepo.saveAndFlush(lession);
		return lession;
	}

}
