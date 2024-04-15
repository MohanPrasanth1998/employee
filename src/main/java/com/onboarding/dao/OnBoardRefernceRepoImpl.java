package com.onboarding.dao;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Component;

import com.onboarding.model.OnBoardReference;
import com.onboarding.repository.OnBoardReferenceRepository;

@Component
public class OnBoardRefernceRepoImpl implements OnBoardReferenceRepository {

	@Autowired
	private OnBoardReferenceRepository onBoardReferenceRepository;

	@Override
	public void flush() {
	 

	}

	@Override
	public <S extends OnBoardReference> S saveAndFlush(S entity) {
	 
		return null;
	}

	@Override
	public <S extends OnBoardReference> List<S> saveAllAndFlush(Iterable<S> entities) {
	 
		return null;
	}

	@Override
	public void deleteAllInBatch(Iterable<OnBoardReference> entities) {
	 

	}

	@Override
	public void deleteAllByIdInBatch(Iterable<Long> ids) {
	 

	}

	@Override
	public void deleteAllInBatch() {
	 

	}

	@Override
	public OnBoardReference getOne(Long id) {
	 
		return null;
	}

	@Override
	public OnBoardReference getById(Long id) {
	 
		return null;
	}

	//@Override
//	public OnBoardReference getReferenceById(Long id) {
	 
	//	return null;
//	}

	@Override
	public <S extends OnBoardReference> List<S> findAll(Example<S> example) {
	 
		return null;
	}

	@Override
	public <S extends OnBoardReference> List<S> findAll(Example<S> example, Sort sort) {
	 
		return null;
	}

	@Override
	public <S extends OnBoardReference> List<S> saveAll(Iterable<S> entities) {
	 
		return null;
	}

	@Override
	public List<OnBoardReference> findAll() {

		return onBoardReferenceRepository.findAll();
	}

	@Override
	public List<OnBoardReference> findAllById(Iterable<Long> ids) {
	 
		return null;
	}

	@Override
	public <S extends OnBoardReference> S save(S entity) {

		return onBoardReferenceRepository.save(entity);
	}

	@Override
	public Optional<OnBoardReference> findById(Long id) {
	 
		return null;
	}

	@Override
	public boolean existsById(Long id) {
	 
		return false;
	}

	@Override
	public long count() {
	 
		return 0;
	}

	@Override
	public void deleteById(Long id) {
	 

	}

	@Override
	public void delete(OnBoardReference entity) {
	 

	}

	@Override
	public void deleteAllById(Iterable<? extends Long> ids) {
	 

	}

	@Override
	public void deleteAll(Iterable<? extends OnBoardReference> entities) {
	 

	}

	@Override
	public void deleteAll() {
	 

	}

	@Override
	public List<OnBoardReference> findAll(Sort sort) {
	 
		return null;
	}

	@Override
	public Page<OnBoardReference> findAll(Pageable pageable) {
	 
		return null;
	}

	@Override
	public <S extends OnBoardReference> Optional<S> findOne(Example<S> example) {
	 
		return null;
	}

	@Override
	public <S extends OnBoardReference> Page<S> findAll(Example<S> example, Pageable pageable) {
	 
		return null;
	}

	@Override
	public <S extends OnBoardReference> long count(Example<S> example) {
	 
		return 0;
	}

	@Override
	public <S extends OnBoardReference> boolean exists(Example<S> example) {
	 
		return false;
	}

	@Override
	public <S extends OnBoardReference, R> R findBy(Example<S> example,
			Function<FetchableFluentQuery<S>, R> queryFunction) {
	 
		return null;
	}

	@Override
	public OnBoardReference findByEmailId(String emailId) {
		return onBoardReferenceRepository.findByEmailId(emailId);
	}

	@Override
	public OnBoardReference findByrefId(String refId) {
		return onBoardReferenceRepository.findByrefId(refId);
	}

}
