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
	private Humain h3= new Humain("Reiner", "DOE");
	private Titan t3=new Titan(20,5);
	
	
	@Given("Un titanA veut se battre contre un titanB")
	public void un_titanA_veut_se_battre_contre_un_titanB() {
	    this.h1=new Humain("Eren", "JAEGER");
	    this.h2=new Humain("Erwin", "SMITH");
	    this.t1=new Titan(20,5);
	    this.t2=new Titan(15,8);		
	}

	@When("Un titanA attaque un autre titanB")
	public void un_titanA_attaque_un_autre_titanB() {
	    this.t1.attaque(t2);
	}

	@Then("Le titanA attaqué perd des {int} equivalent à la {int} du titanB attaquant")
	public void le_titanA_attaqué_perd_des_equivalent_à_la_du_titanB_attaquant(Integer int1, Integer int2) {
	    assertEquals(t2.getPV(), 120);
	}
	
	@Given("Un titanB veut se battre contre un titanC")
	public void un_titanB_veut_se_battre_contre_un_titanC() {
		this.h3 = new Humain("Reiner", "DOE");
	    this.t3=new Titan(20,5);

	}
	
	@When("Un titanB attaque un autre titanC")
	public void un_titanB_attaque_un_autre_titanC() {
	    // Write code here that turns the phrase above into concrete actions
	    this.t2.attaque(t3);
	}
	
	@Then("Le titanB attaqué perd des {int} equivalent à la {int} du titanC attaquant")
	public void le_titanB_attaqué_perd_des_equivalent_à_la_du_titanC_attaquant(Integer int1, Integer int2) {
	    // Write code here that turns the phrase above into concrete actions
	    assertEquals(t2.getPV(), 80);
	}

	@Given("Lorsqu'un humain souhaite transférer son titan à un autre humain")
	public void lorsqu_un_humain_souhaite_transférer_son_titan_à_un_autre_humain() {
	    this.t1.setPorteur(this.h1);
	    this.t2.setPorteur(this.h2);
	}

	@When("Un humain mange un humain qui possède un titan")
	public void un_humain_mange_un_humain_qui_possède_un_titan() {
	    this.h1.transfererTitan(this.t1, this.h2);
	}

	@Then("Le titan de l{string}humain qui l'a mangé")
	public void le_titan_de_l_humain_qui_l_a_mangé(String string) {
	    assertEquals(false, this.h1.getTitan().contains(this.t1));
	    assertEquals(true, this.h2.getTitan().contains(this.t1));
	}

}
