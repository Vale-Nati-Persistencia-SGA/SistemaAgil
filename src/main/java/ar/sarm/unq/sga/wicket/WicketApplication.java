package ar.sarm.unq.sga.wicket;


import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.spring.injection.annot.SpringComponentInjector;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ar.sarm.unq.sga.hibernate.HibernateConf;

public class WicketApplication extends WebApplication
{
	/**
	 * @see org.apache.wicket.Application#getHomePage()
	 */
	@Override
	public Class<? extends WebPage> getHomePage()
	{
		return HomePage.class;
	}

	/**
	 * @see org.apache.wicket.Application#init()
	 */
	@Override
	public void init()
	{
		super.init();
		HibernateConf.modo = "update"; // Esto lo hago para que al crearse el contexto no vuelva a crear la bd

		// Acá se crea el contexto de Spring configurado con Annotations
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.scan("ar.sarm.unq.sga.wicket", "ar.sarm.unq.sga.hibernate");
		ctx.refresh();
		
		// Acá se integra Wicket con Spring
		getComponentInstantiationListeners().add(new SpringComponentInjector(this, ctx));
	}
}