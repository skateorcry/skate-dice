
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class Roll {
	private String[] stance;
	private String[] direction;
	private String[] rotation;
	
	private ArrayList<String> trickFlat;
	
	private ArrayList<String> trickLedgeEasy;
	private ArrayList<String> trickLedge;
	
	private ArrayList<String> trickTrannyEasy;
	private ArrayList<String> trickTrannyMed;
	private ArrayList<String> trickTrannyHard;
	
	public Roll()
	{
		stance=new String[] {"regular","fakie","switch","nollie",""};
		direction=new String[] {"frontside","backside",""};
		rotation=new String[] {"180","360","bigspin","sex change","shuv",""};
		
		trickFlat=new ArrayList<String>();//med only stance, direction
		
		trickLedgeEasy=new ArrayList<String>();//easy tricks dont contain stance, direction, or rotation(same for tranny)
		trickLedge=new ArrayList<String>();//medium contains only stance and direction
		
		trickTrannyEasy=new ArrayList<String>();
		trickTrannyMed=new ArrayList<String>();//contains direction
		trickTrannyHard=new ArrayList<String>();
		
		fillArray(trickFlat, "tricksFlat.txt", "", 2);
		fillArray(trickLedgeEasy, "tricksLedge.txt", "/m", 0);
		fillArray(trickLedge, "tricksLedge.txt", "", 2);
		fillArray(trickTrannyEasy, "tricksTranny.txt", "/m", 0);
		fillArray(trickTrannyMed, "tricksTranny.txt", "/h", 1);
		fillArray(trickTrannyHard, "tricksTranny.txt", "", 2);
	}
	
	
	private void fillArray(ArrayList<String> s, String file, String ind, int difficulty)//0=easy 1=medium 2=hard
	{
		s.add("");
		if(difficulty==0)
		{
			try {
				Scanner sc=new Scanner(new File(file));
				while(sc.hasNextLine())
				{
					String next=sc.nextLine();
					if(next.equals(ind)) 
						return;				
					s.add(next);//infinite loop
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
		if(difficulty==1) 
		{
			try {
				Scanner sc=new Scanner(new File(file));
				while(sc.hasNextLine())
				{
					String next=sc.nextLine();
					if(next.equals("/m"))
						next=sc.nextLine();
					if(next.equals(ind)) 
						return;				
					s.add(next);
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		if(difficulty==2) 
		{
			try {
				Scanner sc=new Scanner(new File(file));
				while(sc.hasNextLine())
				{
					String next=sc.nextLine();
					if(next.equals("/m")||next.equals("/h"))
						next=sc.nextLine();	
					s.add(next);
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}

	}
	
	public String getTrick(String difficulty,String obstacle,boolean berrics)
	{
		if(difficulty=="easy")
			return getTrickEasy(obstacle,berrics);
		else if(difficulty=="medium")
			return getTrickMed(obstacle,berrics);
		else if(difficulty=="hard")
			return getTrickHard(obstacle,berrics);
		else
			return getTrickMed(obstacle,berrics);
	}
	public String getTrickEasy(String obstacle,boolean berrics)
	{
		int trickIndFlat=(int) (Math.random() * trickFlat.size());
		int trickIndLedge=(int) (Math.random() * trickLedgeEasy.size());
		int trickIndTranny=(int) (Math.random() * trickTrannyEasy.size());
		if(berrics==true)
		{
			while(trickFlat.get(trickIndFlat).equals("beanplant")||trickFlat.get(trickIndFlat).equals("boneless")||trickFlat.get(trickIndFlat).equals("no comply"))
				trickIndFlat=(int) (Math.random() * trickFlat.size());
			return trickFlat.get(trickIndFlat);
		}
		if(obstacle=="flat")
			return trickFlat.get(trickIndFlat);
		else if(obstacle=="ledge/curb/rail")
			return trickLedgeEasy.get(trickIndLedge);
		else if(obstacle=="transition")
			return trickTrannyEasy.get(trickIndTranny);
		return "";
	}
	
	public String getTrickMed(String obstacle,boolean berrics)
	{
		int indStc=(int) (Math.random() * stance.length);
		int indDir=(int) (Math.random() * direction.length);
		int trickIndFlat=(int) (Math.random() * trickFlat.size());
		int trickIndLedge=(int) (Math.random() * trickLedge.size());
		int trickIndTranny=(int) (Math.random() * trickTrannyMed.size());
		if(berrics==true)
		{
			while(trickFlat.get(trickIndFlat).equals("beanplant")||trickFlat.get(trickIndFlat).equals("boneless")||trickFlat.get(trickIndFlat).equals("no comply"))
				trickIndFlat=(int) (Math.random() * trickFlat.size());
			return stance[indStc]+" "+direction[indDir]+" "+trickFlat.get(trickIndFlat);
		}
		if(obstacle=="flat")
			return stance[indStc]+" "+direction[indDir]+" "+trickFlat.get(trickIndFlat);
		else if(obstacle=="ledge/curb/rail")
			return direction[indDir]+" "+trickLedge.get(trickIndLedge);
		else if(obstacle=="transition")
			return direction[indDir]+" "+trickTrannyMed.get(trickIndTranny);
		return "";
	}
	
	public String getTrickHard(String obstacle,boolean berrics)
	{
		int indStc=(int) (Math.random() * stance.length);
		int indDir=(int) (Math.random() * direction.length);
		int indRot=(int) (Math.random() * rotation.length);
		int trickIndFlat=(int) (Math.random() * trickFlat.size());
		int trickIndLedge=(int) (Math.random() * trickLedge.size());
		int trickIndTranny=(int) (Math.random() * trickTrannyHard.size());
		if(berrics==true)
		{
			while(trickFlat.get(trickIndFlat).equals("beanplant")||trickFlat.get(trickIndFlat).equals("boneless")||trickFlat.get(trickIndFlat).equals("no comply"))
				trickIndFlat=(int) (Math.random() * trickFlat.size());
			return stance[indStc]+" "+direction[indDir]+" "+rotation[indRot]+" "+trickFlat.get(trickIndFlat);
		}
		if(obstacle=="flat")
			return stance[indStc]+" "+direction[indDir]+" "+rotation[indRot]+" "+trickFlat.get(trickIndFlat);
		else if(obstacle=="ledge/curb/rail")
			return stance[indStc]+" "+direction[indDir]+" "+rotation[indRot]+" "+trickLedge.get(trickIndLedge);
		else if(obstacle=="transition")
			return stance[indStc]+" "+direction[indDir]+" "+rotation[indRot]+" "+trickTrannyHard.get(trickIndTranny);
		return "";
	}
}
