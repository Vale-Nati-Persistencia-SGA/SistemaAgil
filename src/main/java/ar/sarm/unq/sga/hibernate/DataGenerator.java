package ar.sarm.unq.sga.hibernate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import ar.sarm.unq.sga.home.Home;
import ar.sarm.unq.sga.model.Project;

@Component
@Transactional
public class DataGenerator {
	
	@Autowired
	private Home<Project>projectHome;
	
	public void generate(){
		Project project=new Project("Juan");
		projectHome.saveOrUpdate(project);
	   
	}

}
