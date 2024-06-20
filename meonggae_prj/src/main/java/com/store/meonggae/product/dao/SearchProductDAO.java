package com.store.meonggae.product.dao;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.store.meonggae.dao.MybatisDAO;
import com.store.meonggae.product.domain.SearchProductDetailDomain;
import com.store.meonggae.product.domain.SearchProductDomain;
import com.store.meonggae.product.vo.SearchProductVO;


@Component
public class SearchProductDAO {
	
	@Autowired
	private MybatisDAO mbDAO;
	

	//전체 상품 조회
	public List<SearchProductDomain> selectAllProduct()throws PersistenceException {
		try (SqlSession ss = mbDAO.getMyBatisHandler(false)) {
			return ss.selectList("com.store.meonggae.product.selectAllProduct");
		}
	};//selectAllProduct
	
	//키워드(상품명&지역) 조회
	public List<SearchProductDomain> selectPrdKey(String keyword)throws PersistenceException {
		try (SqlSession ss = mbDAO.getMyBatisHandler(false)) {
			return ss.selectList("com.store.meonggae.product.selectPrdKey", keyword);
		}
	};//selectPrdGNLoc
	
	//키워드(상품명&지역) 후 카테고리 조회
	public List<SearchProductDomain> selectPrdKeyCate(SearchProductVO spVO)throws PersistenceException {
		try (SqlSession ss = mbDAO.getMyBatisHandler(false)) {
			return ss.selectList("com.store.meonggae.product.selectPrdKeyCate", spVO);
		}
	};//selectPrdGNLocKey
	
	//카테고리 단독 조회
	public List<SearchProductDomain> selectPrdCate(String categoryName)throws PersistenceException {
		try (SqlSession ss = mbDAO.getMyBatisHandler(false)) {
			return ss.selectList("com.store.meonggae.product.selectPrdCate", categoryName);
		}
	};//selectPrdKeyword
	
	//상품 상세 조회
	public SearchProductDetailDomain selectPrdDetail(String goodsNum)throws PersistenceException {
		try (SqlSession ss = mbDAO.getMyBatisHandler(false)) {
			return ss.selectOne("com.store.meonggae.product.selectPrdDetail", goodsNum);
		}
	};//selectPrdKeyword
}