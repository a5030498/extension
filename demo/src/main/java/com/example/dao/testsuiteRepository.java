//package com.example.dao;
//
//import java.util.List;
//
//import org.springframework.data.repository.PagingAndSortingRepository;
//
//import com.example.vo.testsuite;
//
//public interface testsuiteRepository extends PagingAndSortingRepository<testsuite, Long> {
//
//	public List<testsuite> findByUsersidAndNameLike(int userid,String name);
//	
//	public List<testsuite> findByUsersid(int userid);
//	
//	public List<testsuite> findDistinctByUsersid(String userid);
//	
//	public List<testsuite> findById(int id);
//}
