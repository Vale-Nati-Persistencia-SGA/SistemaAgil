package ar.sarm.unq.sga.hibernate;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class GenerateDataMain {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.scan("ar.sarm.unq.sga.wicket", "ar.sarm.unq.sga.hibernate", "ar.sarm.unq.sga.home");
		ctx.refresh();
		
		DataGenerator dg = (DataGenerator) ctx.getBean("dataGenerator");
		dg.generate();
		
		ctx.close();
	}

}
