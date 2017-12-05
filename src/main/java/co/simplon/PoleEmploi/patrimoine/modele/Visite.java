package co.simplon.PoleEmploi.patrimoine.modele;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "VISITS")
@NamedQueries({
		@NamedQuery(name = "Visite.findAll", query = " SELECT v FROM Visite v ORDER BY v.dateVisite "),
		@NamedQuery(name = "Visite.findAllByMonumentId", query = " SELECT v FROM Visite v JOIN v.monument m WHERE m.identifiant = :id ORDER BY v.dateVisite "), })
public class Visite {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	@Column(name = "DATE_VISITE")
	private Date dateVisite;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "MONUMENT_ID")
	private Monument monument;

	public Visite() {
		super();
	}

	public Visite(Date dateVisite) {
		super();
		this.dateVisite = dateVisite;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDateVisite() {
		return dateVisite;
	}

	public void setDateVisite(Date dateVisite) {
		this.dateVisite = dateVisite;
	}

	public Monument getMonument() {
		return monument;
	}

	public void setMonument(Monument monument) {
		this.monument = monument;
	}

	@Override
	public String toString() {
		return "Visite [id=" + id + ", dateVisite=" + dateVisite + "]";
	}

}
