package org.it.domain;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
@AllArgsConstructor
@Getter
public class MusicPageDTO {
	
	private int musicCnt;
	private List<MusicVO> list;

}
