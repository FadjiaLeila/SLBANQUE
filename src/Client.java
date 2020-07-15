/**
 * @(#)Client.java
 *
 *
 * @author
 * @version 1.00 2019/6/3
 */

public class Client
{
	private int idclient;
    private String nom;
    private String prenom;
    private String adresse;
//    private Date birth;


	public Client(int idcl, String nm, String prenon, String adrs)
	{
		idclient=idcl;
		nom=nm;
		prenom=prenon;
		adresse=adrs;
//		birth=birthd;
	}

	public void setidcl(int idcl)
	{
		idclient=idcl;
	}

	public void setNom(String nm)
	{
		nom=nm;
	}

	public void setPrenom(String prenon)
	{
		prenom=prenon;
	}

	public void setAdresse(String adrs)
	{
		adresse=adrs;
	}

	public String getNom()
	{
		return nom;
	}

	public String getPrenom()
	{
		return prenom;
	}

	public String getAdresse()
	{
		return adresse;
	}

	public int getID()
	{
		return idclient;
	}

}