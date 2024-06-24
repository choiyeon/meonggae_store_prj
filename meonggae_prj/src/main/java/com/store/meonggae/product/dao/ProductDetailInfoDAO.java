package com.store.meonggae.product.dao;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.store.meonggae.dao.MybatisDAO;
import com.store.meonggae.product.vo.SteamVO;


@Component
public class ProductDetailInfoDAO {
	
	@Autowired
	private MybatisDAO mbDAO;
	
//	상품의 전체 찜 횟수 조회
	public int countAllSteam(String goodsNum)throws PersistenceException {
		try (SqlSession ss = mbDAO.getMyBatisHandler(false)) {
			return ss.selectOne("com.store.meonggae.product.ProductDetailInfoMapper.countAllSteam", goodsNum);
		}
	};//countAllSteam
	
//	회원의 찜 여부 조회 찜했으면 1 아니면 0
	public int checkMemSteam(SteamVO steamVO)throws PersistenceException {
		try (SqlSession ss = mbDAO.getMyBatisHandler(false)) {
			return ss.selectOne("com.store.meonggae.product.ProductDetailInfoMapper.checkMemSteam", steamVO);
		}
	};//checkMemSteam
	
	//값이 있으면 다시찜. 없으면 첫찜.
	public int checkFirstSteam(SteamVO steamVO)throws PersistenceException {
		try (SqlSession ss = mbDAO.getMyBatisHandler(false)) {
			return ss.selectOne("com.store.meonggae.product.ProductDetailInfoMapper.checkFirstSteam", steamVO);
		}
	};//checkFirstSteam
	
	//찜 등록(첫 찜)
	public int insertSteam(SteamVO steamVO)throws PersistenceException {
		try (SqlSession ss = mbDAO.getMyBatisHandler(true)) {//auto commit 자동 커밋)
			return ss.insert("com.store.meonggae.product.ProductDetailInfoMapper.insertSteam", steamVO);
		}
	};//checkFirstSteam
	
	//찜 등록(삭제 후 다시 찜)
	public int updateSteamToY(SteamVO steamVO)throws PersistenceException {
		try (SqlSession ss = mbDAO.getMyBatisHandler(true)) {//auto commit 자동 커밋)
			return ss.update("com.store.meonggae.product.ProductDetailInfoMapper.updateSteamToY", steamVO);
		}
	};//checkFirstSteam
	
	//찜 삭제(update STEAM_FLAG='N')
	public int updateSteamToN(SteamVO steamVO)throws PersistenceException {
		try (SqlSession ss = mbDAO.getMyBatisHandler(true)) {//auto commit 자동 커밋)
			return ss.update("com.store.meonggae.product.ProductDetailInfoMapper.updateSteamToN", steamVO);
		}
	};//checkFirstSteam
	
}