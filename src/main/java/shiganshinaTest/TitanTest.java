package shiganshinaTest;


import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import shiganshina.*;

/**
 * Classe-test TitanTest.
 *
 * @author  (votre nom)
 * @version (un numéro de version ou une date)
 *
 * Les classes-test sont documentées ici :
 * http://junit.sourceforge.net/javadoc/junit/framework/TestCase.html
 * et sont basées sur le document Š 2002 Robert A. Ballance intitulé
 * "JUnit: Unit Testing Framework".
 *
 * Les objets Test (et TestSuite) sont associés aux classes à tester
 * par la simple relation yyyTest (e.g. qu'un Test de la classe Name.java
 * se nommera NameTest.java); les deux se retrouvent dans le męme paquetage.
 * Les "engagements" (anglais : "fixture") forment un ensemble de conditions
 * qui sont vraies pour chaque méthode Test à exécuter.  Il peut y avoir
 * plus d'une méthode Test dans une classe Test; leur ensemble forme un
 * objet TestSuite.
 * BlueJ découvrira automatiquement (par introspection) les méthodes
 * Test de votre classe Test et générera la TestSuite conséquente.
 * Chaque appel d'une méthode Test sera précédé d'un appel de setUp(),
 * qui réalise les engagements, et suivi d'un appel à tearDown(), qui les
 * détruit.
 */
public class TitanTest
{
    // Définissez ici les variables d'instance nécessaires à vos engagements;
    // Vous pouvez également les saisir automatiquement du présentoir
    // à l'aide du menu contextuel "Présentoir --> Engagements".
    // Notez cependant que ce dernier ne peut saisir les objets primitifs
    // du présentoir (les objets sans constructeur, comme int, float, etc.).
    protected double fValeur1;
    protected double fValeur2;

    /**
     * Constructeur de la classe-test TitanTest
     */
    public TitanTest()
    {
    }

    /**
     * Met en place les engagements.
     *
     * Méthode appelée avant chaque appel de méthode de test.
     */
    @BeforeEach
    public void setUp() // throws java.lang.Exception
    {
        // Initialisez ici vos engagements
        fValeur1= 2.0;
        fValeur2= 3.0;
    }

    /**
     * Supprime les engagements
     *
     * Méthode appelée après chaque appel de méthode de test.
     */
    @AfterEach
    public void tearDown() // throws java.lang.Exception
    {
        //Libérez ici les ressources engagées par setUp()
    }

    @Test
    public void testTitan()
    {
        Titan t1 = new Titan(17.5, 6);
        assertEquals(17.5, t1.getTaille());
        assertEquals(6, t1.getAge());
    }
    
    @Test
    public void testModificationSurTitan()
    {
        Titan t2=new Titan(17.5, 6);
        t2.setTaille(15);
        t2.setAge(8);
        assertEquals(15, t2.getTaille());
        assertEquals(8, t2.getAge());
    }
    
    @Test
    public void testAjoutTitan() 
    {
    	Humain h1 = new Humain();
    	Titan t1 = new Titan();
    	Titan t2 = new Titan();
    	
    	h1.ajouterFuturTitan(t1);
    	t1.setPorteur(h1);
    	
    	//assertEquals(t1.getHumain(), h1);
    	assertTrue(h1.getTitan().contains(t1));
    	assertNotEquals(t2.getHumain(), h1);
    	assertFalse(h1.getTitan().contains(t2));
    }
    
    @Test
    public void testMultiTitan()
    {
    	Humain h1=new Humain("JAEGER", "Eren");
    	
    	ArrayList<Titan> lt1=new ArrayList<Titan>();
    	Titan t1=new Titan(12.5,5);
    	lt1.add(t1);
    	Titan t2=new Titan(50,3);
    	lt1.add(t2);
    	Titan t3=new Titan(25,8);
    	lt1.add(t3);
    	
    	
    	h1.ajouterFuturTitan(t1);
    	h1.ajouterFuturTitan(t2);
    	h1.ajouterFuturTitan(t3);
    	
    	List<Titan> lt2=h1.getTitan();
    	for(int i=0; i<lt1.size(); i++) {
    		assertEquals(lt1.get(i).getAge(),lt2.get(i).getAge());
    	}
    	
    	List<Double> ld1=h1.getTailleFuturTitan();
    	
    	for(int i=0; i<ld1.size(); i++) {
    		assertEquals(ld1.get(i), lt1.get(i).getTaille());
    	}
    }
}

