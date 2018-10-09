package ar.sarm.unq.sga.wicket.backlog;

import ar.sarm.unq.sga.home.AbstractHome;
import ar.sarm.unq.sga.model.Backlog;

public class BacklogStore extends AbstractHome<Backlog> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static BacklogStore elunico;

	public static BacklogStore elunico() {
		if (elunico == null) {
			elunico = new BacklogStore();
		}
		return elunico;
	}

	public void agregarBacklog(Backlog backlog) {
		this.getSession().save(backlog);
	}

	public void updateBacklo(Backlog backlog) {
		this.getSession().update(backlog);
	}

	public void deleteBacklog(Backlog backlog) {
		this.getSession().delete(backlog);
	}
}
