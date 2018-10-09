package ar.sarm.unq.sga.wicket.developer;

import ar.sarm.unq.sga.home.AbstractHome;
import ar.sarm.unq.sga.model.Developer;

public class DeveloperStore extends AbstractHome<Developer>{

	private static final long serialVersionUID = 1L;
	
	private static DeveloperStore elUnico;

	public static DeveloperStore elUnico() {
		if(elUnico==null){
			elUnico=new DeveloperStore();
		}
		return elUnico;
	}
	
	public void agregarDeveloper(Developer developer){
		this.getSession().save(developer);
	}
	
	public void updateDeveloper(Developer developer){
		this.getSession().update(developer);
	}
	
	public void deleteDeveloper(Developer developer){
		this.getSession().delete(developer);
	}


}
