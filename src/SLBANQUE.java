/**
 * @(#)SLBANQUE.java
 *
 * SLBANQUE application
 *
 * @author
 * @version 1.00 2019/5/29
 */
import java.io.*;
import java.util.*;

public class SLBANQUE
{

public static BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws Exception
	{

		Vector<Compte> dbCompte = new Vector<Compte>();
		Vector<Client> dbClient = new Vector<Client>();

		 //Chargement des donnees
		 //Chargement des Comptes----------------------------------------------------------------

			try
		{

    		BufferedReader br = new BufferedReader(new FileReader(new File("C://Users//User1//Desktop//DataBase.csv")));

			String cline;
			while((cline=br.readLine())!=null)
			{
				String[] data = new String[5];
					data=cline.split(",");
				for(String i: data)
				{
					System.out.println(i+"	");
				}
				 int idcpt=Integer.parseInt(data[0]);
				 int idcl=Integer.parseInt(data[1]);
				 double sld=Double.parseDouble(data[2]);
				 String stat=data[3];
				 double MD=Double.parseDouble(data[4]);

					Compte cptinit=new Compte(idcpt,stat, sld, idcl, MD);
					dbCompte.addElement(cptinit);
			}
			br.close();
		}catch(FileNotFoundException a)
				{
             		System.out.println("impossible de trouver ce fichier. Creation d'un nouveau?");

             		File file=new File("C://Users//User1//Desktop//DataBase.csv");
					FileWriter fw=new FileWriter(file);
				}


		//Chargement des clients---------------------------------------------------------------------

		try
		{

    		BufferedReader br = new BufferedReader(new FileReader(new File("C://Users//User1//Desktop//DBClients.csv")));

			String cline;
			while((cline=br.readLine())!=null)
			{
				String[] data = new String[4];
					data=cline.split(",");
				for(String i: data)
				{
					System.out.println(i+"	");
				}
				 int idcl=Integer.parseInt(data[0]);
				 String nm=data[1];
				 String prenon=data[2];
				 String adrs=data[3];

					Client clinit=new Client(idcl, nm, prenon, adrs);
					dbClient.addElement(clinit);
			}
			br.close();
		}catch(FileNotFoundException a)
				{
             		System.out.println("impossible de trouver ce fichier. Creation d'un nouveau?");

             		File file=new File("C://Users//User1//Desktop//DBClients.csv");
					FileWriter fw=new FileWriter(file);
				}



		//Fin chargement---------------------------------------------------------------------

    	System.out.println("---------------L.S BANQUE----------");
    	while(true)
    	{
    		System.out.println("Que voulez vous faire?");
    		System.out.println("**********************");
    		System.out.println("1.- Creer un nouveau compte");
    		System.out.println("2.- Effectuer un depot");
    		System.out.println("3.- Effectuer un retrait");
    		System.out.println("4.- Effectuer un virement");
    		System.out.println("5.- Supprimer un compte");
    		//enregistrer 1 a 5 dans un fichier csv;
    		System.out.println("6.- Rechercher un client");
    		System.out.println("7.- Rechercher un compte");
    		prinText("8.- Quitter le programme");

			int choix=0;
    		do
    		{
    			choix = verifInt();
    			if((choix<1)||(choix>8))
				System.out.println("Votre choix ne figure pas dans le menu. Veuillez essayer a nouveau:");
    		}
    		while((choix<1)||(choix>8));

    		switch(choix)
    		{
    			case 1:

    				prinText("Etes vous un nouveau client?");
    				prinText("1.-non \n2.-oui");
    				int SLClient;
    				int idcl=0;
    				do

    				{
    					SLClient = verifInt();
    					if(!((SLClient==1)||(SLClient==2)))
    					{
							System.out.println("Cette option n'est pas disponible. Veuillez essayer a nouveau:");

    					}
    				}
    		while(!((SLClient==1)||(SLClient==2)));

    			if(SLClient==2)
    			{
    				prinText("Infos sur le client");
    				prinText("Nom");
    				String nm=bfr.readLine();
    				prinText("Prenom");
    				String prenon=bfr.readLine();
    				prinText("Adresse");
    				String adrs=bfr.readLine();
    				idcl=dbClient.size();
    				prinText("----------------------------");
    				Client cl=new Client(idcl, nm, prenon, adrs);
    				dbClient.addElement(cl);
					UpdateClient(dbClient);
    				prinText("Client enregistre avec Succes");
    			}
    			if(SLClient==1)
    			{
    				prinText("Veuillez rentrer votre le numero de votre compte existant");
    				int cptexist=verifInt();
    				if(cptexist<dbCompte.size())
    				{
    					 idcl=cptexist;
    				}
    				else
    				{
    					prinText("Ce compte n'existe pas dans notre systeme");
    					continue;
    				}

    			}



    				prinText("Creation de Compte");
    				int idcpt=dbCompte.size();
    				prinText("Depot");
    				double sld=verifDoub();
    				prinText("Statut");
    				String stat=bfr.readLine();
    				double MD=verifDoub();
    				Compte cpt=new Compte(idcpt,stat, sld, idcl, MD);

    				dbCompte.addElement(cpt);


					prinText("Compte cree avec Succes");

					UpdateCompte(dbCompte);
    				//String idcl=db2.size()+
    				//Compte cpt2=(Compte)(db.elementAt(0));
    				//System.out.println(cpt2.getSolde());
    				//System.out.println(cpt2.getID());


    			continue;

    			case 2:
    				int cptexistd;
    				prinText("Veuillez rentrer votre le numero de votre compte existant");
    				do
    				{
    					cptexistd=verifInt();
    					if(cptexistd>=dbCompte.size())
    						{
    							prinText("Ce compte n'existe pas dans notre systeme");
    						}
    				}
    				while(cptexistd>=dbCompte.size());
    							Compte cptd=dbCompte.elementAt(cptexistd);
    							prinText("Quel est le montant de votre depot?");
    							double dep=verifDoub();
    							cptd.deposer(dep);
    				prinText("Depot effectuer avec succes");

    			continue;

    			case 3:

    				int cptexistr;
    				prinText("Veuillez rentrer votre le numero de votre compte existant");
    				do
    				{
    					cptexistr=verifInt();
    					if(cptexistr>=dbCompte.size())
    						{
    							prinText("Ce compte n'existe pas dans notre systeme");
    						}
    				}
    				while(cptexistr>=dbCompte.size());
    							Compte cptr=dbCompte.elementAt(cptexistr);
    							prinText("Quel est le montant de votre depot?");
    							double ret=verifDoub();
    							cptr.retirer(ret);
    				prinText("Depot effectuer avec succes");

    			continue;

    			case 4:

    				int cptexistv1;
    				prinText("Veuillez rentrer votre le numero de votre compte existant");
    				do
    				{
    					cptexistv1=verifInt();
    					if(cptexistv1>=dbCompte.size())
    						{
    							prinText("Ce compte n'existe pas dans notre systeme");
    						}
    				}
    				while(cptexistv1>=dbCompte.size());


    				prinText("Veuillez rentrer votre le numero du compte sur lequel vous voulez effectuer le virement");
    				int cptexistv2;
    				do
    				{
    					cptexistv2=verifInt();
    					if(cptexistv2>=dbCompte.size())
    						{
    							prinText("Ce compte n'existe pas dans notre systeme");
    						}
    				}
    				while(cptexistv2>=dbCompte.size());
    							Compte cptv=dbCompte.elementAt(cptexistv1);
    							Compte cptv2=dbCompte.elementAt(cptexistv2);
    							prinText("Quel est le montant de votre depot?");
    							double vir=verifDoub();
    							cptv.virer(cptv2,vir);
    				prinText("Depot effectuer avec succes");

				continue;

    			case 5:
					int cptexists;
    				do
    				{
    					cptexists=verifInt();
    					if(cptexists>=dbCompte.size())
    						{
    							prinText("Ce compte n'existe pas dans notre systeme");
    						}
    				}
    				while(cptexists>=dbCompte.size());

    				dbCompte.removeElementAt(cptexists);
    			continue;

    			case 6:
					int cptexistf;
    				prinText("Veuillez rentrer votre le numero du compte");
    				do
    				{
    					cptexistf=verifInt();
    					if(cptexistf>=dbCompte.size())
    						{
    							prinText("Ce compte n'existe pas dans notre systeme");
    						}
    				}
    				while(cptexistf>=dbCompte.size());
    				Compte cptf=dbCompte.elementAt(cptexistf);

						prinText("Le numero du client en question est: "+cptf.getIDClient());
						prinText("Le solde de ce compte est : "+cptf.getSolde());
						prinText("Le compte, peut-il etre a decouvert: "+cptf.getStat());
						prinText("Montant a decouvert: "+cptf.getMD());

    			continue;

    			case 7:

						int clexistf;
    				prinText("Veuillez rentrer l'identifiant du client");
    				do
    				{
    					clexistf=verifInt();
    					if(clexistf>=dbClient.size())
    						{
    							prinText("Ce client n'existe pas dans notre systeme");
    						}
    				}
    				while(clexistf>=dbClient.size());
    				Client clf=dbClient.elementAt(clexistf);

						prinText("Le nom du client en question est: "+clf.getNom());
						prinText("Le prenom du client en question est: "+clf.getPrenom());
						prinText("L'adresse du client en question est: "+clf.getAdresse());

    			continue;

    			case 8:
    				System.exit(0);

    			default:
    				System.out.println("Une erreur s'est produite!");


    		}


    	}
    }

    public static int verifInt() throws Exception
    {
    	int saisie=0;

		while(true)
		{
    		try
    		{
    			saisie = Integer.parseInt(bfr.readLine());
    		}catch(Exception e)
    		{
    			System.out.println("Le nombre saisie n'est pas un entier! Choisissez a nouveau:");
    			continue;
    		}
    		break;
		}
    	return saisie;
    }


    public static double verifDoub() throws Exception
    {
    	double saisie=0;

		while(true)
		{
    		try
    		{
    			saisie = Double.parseDouble(bfr.readLine());
    		}catch(Exception e)
    		{
    			System.out.println("Le nombre saisie n'est pas un nombre! Choisissez a nouveau:");
    			continue;
    		}
    		break;
		}
    	return saisie;
    }

    public static void prinText(String text)
    {
    	System.out.println(text);
    }

    public static void UpdateCompte(Vector<Compte> dbCompte) throws IOException
    {
    	PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(new File("C:\\Users\\User1\\Desktop\\DataBase.csv"),true)));
		for(Compte cptu: dbCompte)
		{

			pw.print(cptu.getID()+",");
			pw.print(cptu.getIDClient()+",");
			pw.print(cptu.getSolde()+",");
			pw.print(cptu.getStat()+",");
			pw.println(cptu.getMD());
		pw.flush();
		pw.close();
		}
    }

    public static void UpdateClient(Vector<Client> dbClient) throws IOException
    {
    	PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(new File("C:\\Users\\User1\\Desktop\\DBClients.csv"),true)));
		for(Client clu: dbClient)
		{

			pw.print(clu.getID()+",");
			pw.print(clu.getNom()+",");
			pw.print(clu.getPrenom()+",");
			pw.println(clu.getAdresse());
		pw.flush();
		pw.close();
		}
    }



    public static int verifCompte(Vector<Compte> dbCompte)
    {
    				int cptexistd;
    				prinText("Veuillez rentrer votre le numero de votre compte existant");
    				do
    				{
    					cptexistd=verifInt();

    					for(Compte cpte: dbCompte)
    					{
    						if(cptexist==(cpte.getID()))
    						{
    							return cptexistd;
    						}
    					}

    							prinText("Ce compte n'existe pas dans notre systeme");

    				}
    				while(cptexistd!=);

	}

}
