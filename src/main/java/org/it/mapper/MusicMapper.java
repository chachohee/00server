package org.it.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.it.domain.Criteria;
import org.it.domain.MusicVO;

public interface MusicMapper {
	
public int insert(MusicVO vo);
	
	public MusicVO read(Long pno);
	
	public int delete(Long mno);
	
	public int update(MusicVO music);
	
	public List<MusicVO> getListWithPaging(
			@Param("cri") Criteria cri,
			@Param("pno") Long pno);

	public int getCountByPno(Long pno);

}
