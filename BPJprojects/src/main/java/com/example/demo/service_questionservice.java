package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class service_questionservice {
	
	@Autowired
	private dao_questiondao dqd;
	@Autowired
	private dao_userdao dud;
	  
	public List<entity_questionDTO> eq()
	{
 		List<entity_question> eq=dqd.equestion();
		List<entity_questionDTO> eqDTO=new ArrayList<entity_questionDTO>();
        for(entity_question e:eq)
        {
        	entity_user eu=dud.getfindbyuser(e.getCreaterid());       
        	entity_questionDTO equestion=new entity_questionDTO();
        	BeanUtils.copyProperties(e,equestion);
             equestion.setEu(eu);
            eqDTO.add(equestion);
        }
 		return eqDTO;
	}
	  

}
