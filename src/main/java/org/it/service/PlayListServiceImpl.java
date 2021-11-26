package org.it.service;

import java.util.List;

import org.it.domain.Criteria;
import org.it.domain.PlayListVO;
import org.it.mapper.BoardMapper;
import org.it.mapper.PlayListMapper;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class PlayListServiceImpl implements PlayListService{
	
	private PlayListMapper mapper;

	@Override
	public void register(PlayListVO playlist) {
		
		mapper.insertSelectKey(playlist);
		
	}

	@Override
	public PlayListVO get(Long pno) {
		
		return mapper.read(pno);
	}

	@Override
	public boolean modify(PlayListVO playlist) {
	
		return mapper.update(playlist)==1;
	}

	@Override
	public boolean remove(Long pno) {
		
		return mapper.delete(pno)==1;
	}

	@Override
	public List<PlayListVO> getList(Criteria cri) {
		
		return mapper.getListWithPaging(cri);
	}

	@Override
	public int getTotal(Criteria cri) {
		
		return mapper.getTotalCount(cri);
	}

}
