//package com.example.dao;
//
//import java.util.List;
//
//import org.springframework.data.repository.PagingAndSortingRepository;
//
//import com.example.vo.testcase;
//
//public interface testcaseRepository extends PagingAndSortingRepository<testcase, Long> {
//
//	public List<testcase> findByTestsuiteidAndNameLike(int testsuiteid,String name);
//	
//	public List<testcase> findByTestsuiteid(int id);
//	
//	public Integer countByTestsuiteid(int id);
//	
//	public Integer countByTestsuiteidAndEnabled(int id,String enabled);
//}
