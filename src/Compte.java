
public class Compte
{
	private int identifiant;
	private String statutaDecouvert;
	private double solde;
	private int proprio;
	private double MontantaDecouvert=0;

	public Compte(int idcpt, String stat, double sld, int idcl, double MD)
	{
		identifiant=idcpt;
		statutaDecouvert=stat;
		solde=sld;
		proprio=idcl;
		MontantaDecouvert=MD;
	}


	public double getSolde()
	{
		return solde;
	}

	public int getID()
	{
		return identifiant;
	}

	public int getIDClient()
	{
		return proprio;
	}

	public String getStat()
	{
		return statutaDecouvert;
	}

	public double getMD()
	{
		return MontantaDecouvert;
	}

	public void retirer(double ret)
	{
		solde=solde-ret;
	}

	public void deposer(double dep)
	{
		solde=solde+dep;
	}

	public void virer(Compte cptv2, double vir)
	{
		retirer(vir);
		cptv2.deposer(vir);
	}

}
