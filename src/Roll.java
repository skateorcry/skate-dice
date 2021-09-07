
public class Roll {
	private String[] stance;
	private String[] direction;
	private String[] rotation;
	
	private String[] trickFlat;
	
	private String[] trickLedgeEasy;
	private String[] trickLedge;
	
	private String[] trickTrannyEasy;
	private String[] trickTrannyMed;
	private String[] trickTrannyHard;
	
	public Roll()
	{
		stance=new String[] {"regular","fakie","switch","nollie",""};
		direction=new String[] {"frontside","backside",""};
		rotation=new String[] {"180","360","bigspin","sex change","shuv",""};
		
		trickFlat=new String[] {"beanplant","boneless","heelflip","kickflip","no comply","ollie","shuv",""};//med only stance, direction
		
		trickLedgeEasy=new String[] {"","5050","slappy","board slide"};//easy tricks dont contain stance, direction, or rotation(same for tranny)
		trickLedge=new String[] {"","5-0","5050","board slide","crooked grind","feeble","willy","tailslide","smith","slappy smith","slappy noseslide","slappy feeble","slappy crooked grind","slappy 5-0","slappy","overwilly","overcrook","noseslide","nosegrind","hurricane","lipslide"};//medium contains only stance and direction
		
		trickTrannyEasy=new String[] {"","5050","feeble","rock n roll","rock to fakie"};
		trickTrannyMed=new String[] {"","5050","5-0","beanplant","board slide rock n roll","board slide rock to fakie","boneless","can opener","crooked grind","disaster","fastplant","feeble","indy grab","melon grab","nose grab","nosegrind","nosepick","noseslide/stall","rock n roll","rock to fakie","slob plant","smith","tail grab","tailslide/stall","texas plant","willy","sweeper"};//contains direction
		trickTrannyHard=new String[] {"","5050","5-0","900","air","air walk","beanplant","benihana","board slide rock n roll","board slide rock to fakie","boneless","can opener","christ air","crooked grind","disaster","fastplant","feeble","hoho plant","indy grab","mctwist","melon grab","nose grab","nosegrind","nosepick","noseslide/stall","rock n roll","rock to fakie","slob plant","smith","tail grab","tailslide/stall","texas plant","willy","sweeper"};
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
		int trickIndFlat=(int) (Math.random() * trickFlat.length);
		int trickIndLedge=(int) (Math.random() * trickLedgeEasy.length);
		int trickIndTranny=(int) (Math.random() * trickTrannyEasy.length);
		if(berrics==true)
		{
			while(trickFlat[trickIndFlat]=="beanplant"||trickFlat[trickIndFlat]=="boneless"||trickFlat[trickIndFlat]=="no comply")
				trickIndFlat=(int) (Math.random() * trickFlat.length);
			return trickFlat[trickIndFlat];
		}
		if(obstacle=="flat")
			return trickFlat[trickIndFlat];
		else if(obstacle=="ledge/curb/rail")
			return trickLedgeEasy[trickIndLedge];
		else if(obstacle=="transition")
			return trickTrannyEasy[trickIndTranny];
		return "";
	}
	
	public String getTrickMed(String obstacle,boolean berrics)
	{
		int indStc=(int) (Math.random() * stance.length);
		int indDir=(int) (Math.random() * direction.length);
		int trickIndFlat=(int) (Math.random() * trickFlat.length);
		int trickIndLedge=(int) (Math.random() * trickLedge.length);
		int trickIndTranny=(int) (Math.random() * trickTrannyMed.length);
		if(berrics==true)
		{
			while(trickFlat[trickIndFlat]=="beanplant"||trickFlat[trickIndFlat]=="boneless"||trickFlat[trickIndFlat]=="no comply")
				trickIndFlat=(int) (Math.random() * trickFlat.length);
			return stance[indStc]+" "+direction[indDir]+" "+trickFlat[trickIndFlat];
		}
		if(obstacle=="flat")
			return stance[indStc]+" "+direction[indDir]+" "+trickFlat[trickIndFlat];
		else if(obstacle=="ledge/curb/rail")
			return direction[indDir]+" "+trickLedge[trickIndLedge];
		else if(obstacle=="transition")
			return direction[indDir]+" "+trickTrannyMed[trickIndTranny];
		return "";
	}
	
	public String getTrickHard(String obstacle,boolean berrics)
	{
		int indStc=(int) (Math.random() * stance.length);
		int indDir=(int) (Math.random() * direction.length);
		int indRot=(int) (Math.random() * rotation.length);
		int trickIndFlat=(int) (Math.random() * trickFlat.length);
		int trickIndLedge=(int) (Math.random() * trickLedge.length);
		int trickIndTranny=(int) (Math.random() * trickTrannyHard.length);
		if(berrics==true)
		{
			while(trickFlat[trickIndFlat]=="beanplant"||trickFlat[trickIndFlat]=="boneless"||trickFlat[trickIndFlat]=="no comply")
				trickIndFlat=(int) (Math.random() * trickFlat.length);
			return stance[indStc]+" "+direction[indDir]+" "+rotation[indRot]+" "+trickFlat[trickIndFlat];
		}
		if(obstacle=="flat")
			return stance[indStc]+" "+direction[indDir]+" "+rotation[indRot]+" "+trickFlat[trickIndFlat];
		else if(obstacle=="ledge/curb/rail")
			return stance[indStc]+" "+direction[indDir]+" "+rotation[indRot]+" "+trickLedge[trickIndLedge];
		else if(obstacle=="transition")
			return stance[indStc]+" "+direction[indDir]+" "+rotation[indRot]+" "+trickTrannyHard[trickIndTranny];
		return "";
	}
}
