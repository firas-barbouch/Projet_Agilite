package shiganshina;

/**
 * Décrivez votre classe Titan ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Titan
{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    private double taille;
    private int age;
    private Humain porteur;
    private double dps;
    private double pv;
    
    /**
     * Constructeur d'objets de classe Titan
     */
    public Titan(double taille, int age)
    {
    	if(taille==0 || age==0) {
    		throw new IllegalArgumentException("Veuillez vérifier les paramètres");
    	}
    	
        // initialisation des variables d'instance
        this.taille=taille;
        this.age=age;
        this.porteur=null;
        this.dps=taille*2;
        this.pv=age*taille;
    }
    
    public Titan() 
    {
    	this.taille=5;
    	this.age=5;
    	this.porteur=null;
        this.dps=taille*2;
        this.pv=age*taille;
    }

    /**
     * Un exemple de méthode - remplacez ce commentaire par le vôtre
     *
     * @param  y   le paramètre de la méthode
     * @return     la somme de x et de y
     */
    public double getTaille()
    {
        // Insérez votre code ici
        return this.taille;
    }
    
    public int getAge()
    {
        return this.age;
    }
    
    public Humain getHumain()
    {
    	return this.porteur;
    }
    
    public void setTaille(double taille)
    {
    	if(taille<=0)
    		throw new IllegalArgumentException("Vérifier les paramètres");
        this.taille=taille;
    }
    
    public void setAge(int age)
    {
    	if(age<=0)
    		throw new IllegalArgumentException("Vérifier les paramètres");
        this.age=age;
    }
    
    public void setPorteur(Humain h) 
    {
    	if(h==null)
    		throw new IllegalArgumentException("Vérifier les paramètres");
    	h.ajouterFuturTitan(this);
    }
    
    public double getDps() {
    	return this.dps;
    }
    
    public void attaque(Titan t) 
    {
    	double idx = this.pv-t.getDps();
    	if(idx<0) {
    		idx=0;
    	}
    	this.pv=idx;
    }
    
    public double getPV() 
    {
    	return this.pv;
    }
}