package com.example.spring02.service.memo;

import java.util.List; // 인터페이스로 add 할때 저장안할시에 불러오면 에러남

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.example.spring02.model.memo.dao.MemoDAO;
import com.example.spring02.model.memo.dto.MemoDTO;

@Service
public class MemoServiceImpl implements MemoService {

	@Inject
	MemoDAO memoDao;
	
	@Override
	public List<MemoDTO> list() {
		return memoDao.list();
	}

	@Override
	public void insert(MemoDTO dto) {
		// TODO Auto-generated method stub

	}

	@Override
	public void insert(String writer, String memo) {
		memoDao.insert(writer, memo);
	}

	@Override
	public MemoDTO memo_view(int idx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(MemoDTO dto) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(int idx) {
		// TODO Auto-generated method stub

	}

}
