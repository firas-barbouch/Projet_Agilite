package shiganshina;

import java.util.ArrayList;
import java.util.List;

/**
 * Décrivez votre classe Humain ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Humain
{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    private String nom;
    private String prenom;
    private List<Titan> listeTitan;

    /**
     * Constructeur d'objets de classe Humain
     */
    public Humain(String nom, String prenom)
    {
    	if(nom==null || prenom==null)
    	{
    		throw new IllegalArgumentException("Veuillez vérifier les paramètres");
    	}
        // initialisation des variables d'instance
        this.nom=nom;
        this.prenom=prenom;
        this.listeTitan=new ArrayList<Titan>();
    }
    
    public Humain()
    {
        // initialisation des variables d'instance
        this.nom="Doe";
        this.prenom="John";
        this.listeTitan=new ArrayList<Titan>();
    }
    
    public void ajouterFuturTitan(Titan t)
    {
        this.listeTitan.add(t);
    }
    
    public List<Titan> getTitan()
    {
        return listeTitan;
    }
    
    public String getNom()
    {	
        return this.nom;
    }
    
    public String getPrenom()
    {
        return this.prenom;
    }
    
    public List<Double> getTailleFuturTitan()
    {
    	ArrayList<Double> idx = new ArrayList<Double>();
    	creerListeTailleTitan(idx);
        return idx;
    }

	private void creerListeTailleTitan(ArrayList<Double> idx) {
		for(int i=0; i<listeTitan.size(); i++) {
    		idx.add((double) listeTitan.get(i).getTaille());
    	}
	}
	
	public void transfererTitan(Titan t1, Humain h1) {
		if(this.listeTitan.contains(t1)) {
			this.listeTitan.remove(t1);
			h1.ajouterFuturTitan(t1);
		}
	}
}
