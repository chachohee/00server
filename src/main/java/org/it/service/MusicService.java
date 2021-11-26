package org.it.service;

import java.util.List;

import org.it.domain.Criteria;
import org.it.domain.MusicPageDTO;
import org.it.domain.MusicVO;

public interface MusicService {
	
	public int register(MusicVO vo);
	
	public MusicVO get(Long mno);
	
	public int modify(MusicVO vo);
	
	public int remove(Long mno);
	
	public List<MusicVO> getList(Criteria cri, Long pno);
	
	public MusicPageDTO getListPage(Criteria cri, Long pno);

}
