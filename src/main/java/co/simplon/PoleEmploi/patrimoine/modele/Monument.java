package co.simplon.PoleEmploi.patrimoine.modele;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "MONUMENTS")
@NamedQueries({
		@NamedQuery(name = "Monument.findAll", query = " SELECT m FROM Monument m ORDER BY m.nom "),
		@NamedQuery(name = "Monument.findAllByVilleId", query = " SELECT m FROM Monument m JOIN m.ville v WHERE v.id = :id ORDER BY m.nom "),
		@NamedQuery(name = "Monument.deleteById", query = " DELETE FROM Monument m WHERE m.identifiant = :id") })
public class Monument {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long identifiant;

	@Column(name = "NAME", nullable = false, length = 100)
	private String nom;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "CITIES_ID")
	private Ville ville;
	
	@JsonIgnore
	@OneToMany(mappedBy = "monument", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	private Set<Visite> visites;

	public Monument(String nom) {
		super();
		this.nom = nom;
	}

	public Monument() {
	}

	public Long getIdentifiant() {
		return this.identifiant;
	}

	public void setIdentifiant(Long identifiant) {
		this.identifiant = identifiant;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Ville getVille() {
		return ville;
	}

	public void setVille(Ville ville) {
		this.ville = ville;
	}

	@Override
	public String toString() {
		return "Monument [identifiant=" + identifiant + ", nom=" + nom
				+ ", ville=" + ville + "]";
	}
}
