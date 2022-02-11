package Personnage;
public class Personnage {
	// Le constructeur
    public Personnage(String name, int life, int endurance){
		this.nom = name;
		this.vie = life;
		this.endurances = endurance;
	}

	//Evennement
	public void Attaque(Personnage NomVictime, int force) {
		NomVictime.vie = NomVictime.vie - force;
		this.vie = this.endurances / 2;
	}

	//Information personnage
	public String LeNom(){
        	return this.nom;
	}
	public int LaVie() {
		return this.vie;
	}
	public boolean isDeath() {
		if (this.vie == 0) {
			return true;
		} else {
			return false;
		}
	}

	//d'autres à créer
	//Les Attributs
	private String nom;
	private int vie;
	private int endurances;
}