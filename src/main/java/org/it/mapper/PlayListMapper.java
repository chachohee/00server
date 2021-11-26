package org.it.mapper;

import java.util.List;


import org.it.domain.Criteria;
import org.it.domain.PlayListVO;

public interface PlayListMapper {
	
	public List<PlayListVO> getList();
	
	public void insertSelectKey(PlayListVO playlist);
	
	public PlayListVO read(Long pno);
	
	public int delete(Long pno);
	
	public int update(PlayListVO playlist);
	
	public List<PlayListVO> getListWithPaging(Criteria cri);
	
	public int getTotalCount(Criteria cri);

}
