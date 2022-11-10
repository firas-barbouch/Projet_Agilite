package dojo;

import static org.junit.jupiter.api.Assertions.*;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import shiganshina.*;

public class InteractionTest {
	
	private Humain h1=new Humain("Eren", "JAEGER");
	private Titan t1=new Titan(20,5);
	private Humain h2=new Humain("Erwin", "SMITH");
	private Titan t2=new Titan(15,8);
	
	
	@Given(": Un titan veut se battre contre un titan")
	public void un_titan_veut_se_battre_contre_un_titan() {
	    this.h1=new Humain("Eren", "JAEGER");
	    this.h2=new Humain("Erwin", "SMITH");
	    this.t1=new Titan(20,5);
	    this.t2=new Titan(15,8);		
	}

	@When(": Un titan attaque un autre titan")
	public void un_titan_attaque_un_autre_titan() {
	    this.t1.attaque(t2);
	}

	@Then(": Le titan attaqué perd des points equivalent à la force du titan attaquant")
	public void le_titan_attaqué_perd_des_points_equivalent_à_la_force_du_titan_attaquant() {
	    assertEquals(t2.getPV(), 120);
	}

	@Given(": Lorsqu'un humain souhaite transférer son titan à un autre humain")
	public void lorsqu_un_humain_souhaite_transférer_son_titan_à_un_autre_humain() {
	    this.t1.setPorteur(this.h1);
	    this.t2.setPorteur(this.h2);
	}

	@When(": Un humain mange un humain qui possède un titan")
	public void un_humain_mange_un_humain_qui_possède_un_titan() {
	    this.h1.transfererTitan(this.t1, this.h2);
	}

	@Then(": Le titan de l{string}humain qui l'a mangé")
	public void le_titan_de_l_humain_qui_l_a_mangé(String string) {
	    assertEquals(false, this.h1.getTitan().contains(this.t1));
	    assertEquals(true, this.h2.getTitan().contains(this.t1));
	}

}
