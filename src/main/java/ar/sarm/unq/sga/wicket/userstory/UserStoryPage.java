package ar.sarm.unq.sga.wicket.userstory;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.PropertyModel;

import ar.sarm.unq.sga.wicket.HomePage;

public class UserStoryPage extends WebPage{

	private static final long serialVersionUID = 1L;
	
	private UserStoryController controller=new UserStoryController();
	
	public UserStoryPage(){
		agregarForm();
	}
	
	private void agregarForm(){
		Form<UserStoryController> crearUserStoryForm = new Form<UserStoryController>("crearUserStoryForm"){
			private static final long serialVersionUID = 1L;
			
			@Override
			protected void onSubmit() {
				UserStoryPage.this.controller.agregarUserStory();;
				this.setResponsePage(new HomePage());
			
			}	
		};
		
		crearUserStoryForm.add(new TextField<>("nombre", new PropertyModel<>(controller, "nombre")));

		crearUserStoryForm.add(new Link<String>("cancelar"){

			private static final long serialVersionUID = 1L;

			@Override
			public void onClick() {
				this.setResponsePage(new HomePage());
				
			}
			
			
		});
		this.add(crearUserStoryForm);
		
	}	
}

