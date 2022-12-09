package dojo;

import static org.junit.Assert.*;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import shiganshina.Humain;
import shiganshina.Titan;

public class LiaisonTest {
	private Humain h1;
	private Humain h2;
	private Titan t1;
	private Titan t2;

	@Given("un Humain est propriétaire d'un ou plusieurs titan")
	public void un_Humain_est_propriétaire_d_un_ou_plusieurs_titan() {
	    this.h1=new Humain("Eren", "JAEGER");
	    this.h2=new Humain("Erwin", "SMITH");
	    this.t1=new Titan(20,5);
	    this.t2=new Titan(15,8);	
	}

	@When("un humain veut se lier à un titan")
	public void un_humain_veut_se_lier_à_un_titan() {
	    t1.setPorteur(h1);
	    t2.setPorteur(h2);
	}

	@Then("le titan est automatiquement lié à l'humain")
	public void le_titan_est_automatiquement_lié_à_l_humain() {
	    assertEquals(h1.getTitan().contains(t1), true);
	    assertEquals(h2.getTitan().contains(t2), true);
	}

	@Given("un Humain ne peut pas posséder deux fois le même titan")
	public void un_Humain_ne_peut_pas_posséder_deux_foi_le_même_titan() {
	    this.h1=new Humain("Eren", "JAEGER");
	    this.h2=new Humain("Erwin", "SMITH");
	    this.t1=new Titan(20,5);
	    this.t2=new Titan(15,8);
	}

	@When("un humain veut se lier une deuxième fois avec un titan")
	public void un_humain_veut_se_lier_une_deuxième_fois_avec_un_titan() {
	    t1.setPorteur(h1);
	    t2.setPorteur(h2);
	    h1.ajouterFuturTitan(t1);
	}

	@Then("le titan et l'humain ne seront pas liés une deuxième fois")
	public void le_titan_et_l_humain_ne_seront_pas_liés_une_deuxième_fois() {
		int idx=0;
	    for(int i=0; i<h1.getTitan().size(); i++) {
	    	if(h1.getTitan().get(i)==t1)
	    		idx++;
	    }
	    assertEquals(2, idx);
	}
}
