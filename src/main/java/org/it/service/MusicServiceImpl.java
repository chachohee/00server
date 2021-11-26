package org.it.service;

import java.util.List;

import org.it.domain.Criteria;
import org.it.domain.MusicPageDTO;
import org.it.domain.MusicVO;
import org.it.mapper.MusicMapper;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.Setter;

public class MusicServiceImpl implements MusicService{

	@Setter(onMethod_ = @Autowired)
	private MusicMapper mapper;
	
	@Override
	public int register(MusicVO vo) {
		
		return mapper.insert(vo);
	}

	@Override
	public MusicVO get(Long mno) {
		
		return mapper.read(mno);
	}

	@Override
	public int modify(MusicVO vo) {
		
		return mapper.update(vo);
	}

	@Override
	public int remove(Long mno) {
		
		return mapper.delete(mno);
	}

	@Override
	public List<MusicVO> getList(Criteria cri, Long pno) {
		
		return mapper.getListWithPaging(cri, pno);
	}

	@Override
	public MusicPageDTO getListPage(Criteria cri, Long pno) {

		return new MusicPageDTO(
				mapper.getCountByPno(pno),
				mapper.getListWithPaging(cri, pno));
	}

}
