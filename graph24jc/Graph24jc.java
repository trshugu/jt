
//
//    MATSUMOTO, Akira
//    
//    FlyingChickens Software
//
//    JDK

import java.awt.*;
import java.applet.*;
import java.awt.image.*;
import java.util.*;

public class Graph24jc extends Applet {
	
	int winwidth,winheight;
	Font f;
	int honsuu=31;// # of lines
	double graphvalue[][]=new double[honsuu][100];
	String graphvaluestr[][]=new String[honsuu][100];
	int graphvalueint[][]=new int[honsuu][100];
	int valuenum[]=new int[honsuu];
	int linenum;
	int graphheight;
	int p0x,p0y;
	int xbarnum;
	String xbarstr[]=new String[100];
	String ybarstr[]=new String[100];
	int ybarnum;
	int ybarint[]=new int[100];
	Image vbarimg[]=new Image[100];
	int barsize;
	Color fgc,bgc,fontcolor;
	Color barcolor[]=new Color[honsuu];
	int pattern;
	int dotbarint[]=new int[honsuu];
	int dotbarnum;
	
	MediaTracker mt=new MediaTracker(this);
	Image image;
	
	Image outimg;
	
	String gvstr[]=new String[honsuu];
	String title;
	
	Label label0=new Label("Graph24.class");

	public void init() {
		
		String v1=getParameter("width");
		if(v1==null)winwidth=426;
		else winwidth=Integer.parseInt(v1);
		
		String v2=getParameter("height");
		if(v2==null)winheight=266;
		else winheight=Integer.parseInt(v2);
		
		String v4=getParameter("graphheight");
		if(v4==null)graphheight=200;
		else graphheight=Integer.parseInt(v4);

		String v5=getParameter("xbarnum");
		if(v5==null)xbarnum=5;
		else xbarnum=Integer.parseInt(v5);
		
		String v17=getParameter("p0x");
		if(v17==null)p0x=winwidth/2;
		else p0x=Integer.parseInt(v17);

		String v18=getParameter("p0y");
		if(v18==null)p0y=winheight/2;
		else p0y=Integer.parseInt(v18);
		
		/*
		String v11=getParameter("letteron");
		if(v11==null)letteron=1;
		else letteron=Integer.parseInt(v11);
		*/
		
		String v180=getParameter("xbar");
		if(v180!=null){
			v180+="_";
			int v180len=v180.length();
			int strnum=0;
			int strp=0;
			for(int i=0;i<v180len;i++){
				String istr=v180.substring(i,i+1);
				if(istr.equals("_")){
					xbarstr[strnum]=v180.substring(strp,i);
					
					strp=i+1;
					strnum++;

				}
			}
			//xbarnum=strnum;
			
		}
		
		String v190=getParameter("ybar");
		if(v190!=null){
			v190+="_";
			int v190len=v190.length();
			int strnum=0;
			int strp=0;
			for(int i=0;i<v190len;i++){
				String istr=v190.substring(i,i+1);
				if(istr.equals("_")){
					ybarstr[strnum]=v190.substring(strp,i);
					
					strp=i+1;
					strnum++;

				}
			}
			ybarnum=strnum;
			
		}
		
		for(int i=0;i<ybarnum;i++){
			
			double ymin=Double.valueOf(ybarstr[0]).doubleValue();
			double ymax=Double.valueOf(ybarstr[ybarnum-1]).doubleValue();
			double yval=Double.valueOf(ybarstr[i]).doubleValue();
			ybarint[i]=(int)Math.floor((graphheight/(ymax-ymin))*(yval-ymin)*-1);
			
		}
		
		String dotbarstr[]=new String[dotbarint.length];
		
		String v200=getParameter("dotbar");
		if(v200!=null){
			v200+="_";
			int v200len=v200.length();
			int strnum=0;
			int strp=0;
			for(int i=0;i<v200len;i++){
				String istr=v200.substring(i,i+1);
				if(istr.equals("_")){
					dotbarstr[strnum]=v200.substring(strp,i);
					
					strp=i+1;
					strnum++;

				}
			}
			dotbarnum=strnum;
			
		}
		
		for(int i=0;i<dotbarnum;i++){
			
			double ymin=Double.valueOf(ybarstr[0]).doubleValue();
			double ymax=Double.valueOf(ybarstr[ybarnum-1]).doubleValue();
			double yval=Double.valueOf(dotbarstr[i]).doubleValue();
			dotbarint[i]=(int)Math.floor((graphheight/(ymax-ymin))*(yval-ymin)*-1);
			
		}
		
		int fontsize=12;
		String v3=getParameter("fontsize");
		if(v3!=null) fontsize=Integer.parseInt(v3);
		
		int fontname=0;
		String v6=getParameter("fontname");
		if(v6!=null) fontname=Integer.parseInt(v6);
		
		
		String fname="Dialog";
		if(fontname==1)fname="DialogInput";
		if(fontname==2)fname="Monospaced";
		if(fontname==3)fname="Serif";
		if(fontname==4)fname="SansSerif";
		if(fontname==5)fname="Symbol";
		
		int fontstyle=0;
		String v7=getParameter("fontstyle");
		if(v7!=null) fontstyle=Integer.parseInt(v7);

		int fs=Font.PLAIN;
		if(fontstyle==1)fs=Font.BOLD;
		if(fontstyle==2)fs=Font.ITALIC;
		if(fontstyle==3)fs=Font.BOLD+Font.ITALIC;

		f=new Font(fname,fs,fontsize);

		String v20=getParameter("fgc");
		if(v20==null) fgc=Color.black;
		else fgc=new Color(Integer.parseInt(v20,16));
		
		String v21=getParameter("bgc");
		if(v21==null) bgc=Color.white;
		else bgc=new Color(Integer.parseInt(v21,16));
		
		String v23=getParameter("fontcolor");
		if(v23==null)fontcolor=new Color(0,0,255);
		else fontcolor=new Color(Integer.parseInt(v23,16));
		
		
		
		String v26=getParameter("pattern");
		if(v26==null) pattern=0;
		else pattern=Integer.parseInt(v26);
		
		
		String v30=getParameter("image");
		if(v30!=null){
			image=getImage(getCodeBase(),v30);
			mt.addImage(image,0);
			//bgimg=true;
		}
		
		
		for(int i=0;i<graphvalue.length;i++){
			String paramstr="graphvalue"+(i+1);
			String valuestr=getParameter(paramstr);
			if(valuestr!=null){
				StringTokenizer st=new StringTokenizer(valuestr,"_");
				
				while (st.hasMoreTokens()) {
					
					String addstr=st.nextToken();
					
					if(valuenum[i]<graphvaluestr[i].length){
						graphvaluestr[i][valuenum[i]]=addstr;
						
						graphvalue[i][valuenum[i]]=Double.valueOf(graphvaluestr[i][valuenum[i]]).doubleValue();
						
						valuenum[i]++;
					}
				}
				double ymin=Double.valueOf(ybarstr[0]).doubleValue();
				double ymax=Double.valueOf(ybarstr[ybarnum-1]).doubleValue();
				
				if(valuenum[i]>=xbarnum)valuenum[i]=xbarnum;
				
				for(int j=0;j<valuenum[i];j++){
					graphvalueint[i][j]=(int)Math.floor((graphheight/(ymax-ymin))*(graphvalue[i][j]-ymin));
				}
			
				linenum++;
			}
		}
		
		for(int i=0;i<linenum;i++){
			String tagstr="barcolor"+(i+1);
			String colorstr=getParameter(tagstr);
			if(colorstr!=null){
				barcolor[i]=new Color(Integer.parseInt(colorstr,16));
			}else{
				float hue=(float)1.0/linenum*i;
				barcolor[i]=Color.getHSBColor(hue,(float)1.0,(float)1.0);
				
			}
				
		}
		
		for(int i=0;i<linenum;i++){
			String v13str="gv"+(i+1)+"str";
			String v13=getParameter(v13str);
			if(v13==null)gvstr[i]="";
			else gvstr[i]=" "+v13;
		}
		
		String v40=getParameter("barsize");
		if(v40==null) barsize=5;
		else barsize=Integer.parseInt(v40);
		
		String v28=getParameter("title");
		if(v28!=null) title=v28;
		
		setLayout(null);
		// addNotify();
		resize(winwidth,winheight);
		
		add(label0);
		label0.setBounds(0,0,winwidth,winheight);
		
		String label0str=getParameter("label0");
		if(label0str!=null)label0.setText(label0str);
		
		graphmake();
		
	}
	
	public void paint(Graphics g){
			
		if(outimg!=null){
			g.drawImage(outimg,0,0,this);
				
		}
	}
	
	public void graphRewriter(String namestr,String valuestr){
		
		int i=Integer.parseInt(namestr.substring(10,namestr.length()))-1;
		
		valuenum[i]=0;
		
		if(valuestr!=null){
			
			StringTokenizer st=new StringTokenizer(valuestr,"_");
			
			while (st.hasMoreTokens()) {
				
				String addstr=st.nextToken();
				
				if(valuenum[i]<graphvaluestr[i].length){
					graphvaluestr[i][valuenum[i]]=addstr;
					
					graphvalue[i][valuenum[i]]=Double.valueOf(graphvaluestr[i][valuenum[i]]).doubleValue();
					
					valuenum[i]++;
				}
			}
			
			double ymin=Double.valueOf(ybarstr[0]).doubleValue();
			double ymax=Double.valueOf(ybarstr[ybarnum-1]).doubleValue();
			
			if(valuenum[i]>=xbarnum)valuenum[i]=xbarnum;
			
			for(int j=0;j<valuenum[i];j++){
				graphvalueint[i][j]=(int)Math.floor((graphheight/(ymax-ymin))*(graphvalue[i][j]-ymin));
			}
		
			//linenum++;
		}
		
	}
	
	public void graphmake(){
		
		Image osi=createImage(winwidth,winheight);
		Graphics osg=osi.getGraphics();
		
		osg.setColor(bgc);
		osg.fillRect(0,0,winwidth,winheight);
		
		if(image!=null){
			
			try{
				mt.waitForID(0);
			}
			catch(InterruptedException e){
				
			}
			
			int imgwidth=image.getWidth(this);
			int imgheight=image.getHeight(this);
			
			for(int i=0;i<(winwidth/imgwidth)+1;i++){
				for(int j=0;j<(winheight/imgheight)+1;j++){
					osg.drawImage(image,imgwidth*i,imgheight*j,this);
				}
			}
		}
			
		osg.setColor(fontcolor);
		osg.setFont(f);
		
		FontMetrics fm=getFontMetrics(f);
		int asc=fm.getAscent();
		int des=fm.getDescent();
		
		for(int i=0;i<xbarnum;i++){
			if(xbarstr[i]!=null){
				double theta=Math.PI-(((Math.PI*2)/xbarnum)*i);
				int polyx=(int)Math.floor(Math.sin(theta)*(graphheight+asc+des))+p0x;
				int polyy=(int)Math.floor(Math.cos(theta)*(graphheight+asc+des))+p0y;
					
				if(theta>Math.PI/2){
					osg.drawString(xbarstr[i],polyx,polyy);
				}
				if((theta<=Math.PI/2)&&(theta>0)){
					osg.drawString(xbarstr[i],polyx,polyy+asc);
				}
				if((theta<=0)&&(theta>Math.PI/2*-1)){
					int strw=fm.stringWidth(xbarstr[i]);
					osg.drawString(xbarstr[i],polyx-strw,polyy+asc);
				}
				if(theta<=Math.PI/2*-1){
					int strw=fm.stringWidth(xbarstr[i]);
					osg.drawString(xbarstr[i],polyx-strw,polyy);
				}
			}
		}
		
		for(int i=0;i<ybarnum;i++){
			osg.drawString(ybarstr[i],p0x,p0y+ybarint[i]);
		}
		
		int strpos=0;
		for(int i=0;i<linenum;i++){
			if(gvstr[i]!=null){
				osg.setColor(barcolor[i]);
				osg.drawString(gvstr[i],strpos,winheight-des);
				strpos+=fm.stringWidth(gvstr[i]);
			}
		}
		
		if(title!=null){
			osg.setColor(fgc);
			osg.drawString(title,(winwidth-fm.stringWidth(title))/2,asc);
		}
	
		int outimgarr[]=new int[winwidth*winheight];
		
		double basedb[]=new double[winwidth*winheight];
		
		PixelGrabber pg=new PixelGrabber(osi,0,0,winwidth,winheight,outimgarr,0,winwidth);
		try{pg.grabPixels();}
		catch(InterruptedException e){ }
		
		
		for(int i=0;i<xbarnum;i++){
			double theta=(((Math.PI*2)/xbarnum)*i)+Math.PI;
			
			for(int j=0;j<graphheight;j++){
				double posx=((Math.sin(theta)*j)+p0x);
				double posy=((Math.cos(theta)*j)+p0y);
				
				double x0y0=(1.0-(posx%1))*(1.0-(posy%1));
				double x1y0=((posx%1))*(1.0-(posy%1));
				double x0y1=(1.0-(posx%1))*((posy%1));
				double x1y1=((posx%1))*((posy%1));
				
				int posxint=(int)Math.floor(posx);
				int posyint=(int)Math.floor(posy);
				
				basedb[posxint+(posyint*winwidth)]+=x0y0;
				basedb[posxint+1+(posyint*winwidth)]+=x1y0;
				basedb[posxint+((posyint+1)*winwidth)]+=x0y1;
				basedb[posxint+1+((posyint+1)*winwidth)]+=x1y1;
				
			}
			
		}
		
		for(int i=0;i<xbarnum;i++){
			double theta=(((Math.PI*2)/xbarnum)*i)+(Math.PI/2*3);
			for(int j=1;j<ybarnum;j++){
				
				for(int k=0-barsize;k<barsize;k++){
					double bartheta0=Math.atan2(ybarint[j],k);
					double barr=Math.sqrt((double)(k*k)+(ybarint[j]*ybarint[j]));
					
					double posx=((Math.sin(bartheta0+theta)*barr)+p0x);
					double posy=((Math.cos(bartheta0+theta)*barr)+p0y);
					
					double x0y0=(1.0-(posx%1))*(1.0-(posy%1));
					double x1y0=((posx%1))*(1.0-(posy%1));
					double x0y1=(1.0-(posx%1))*((posy%1));
					double x1y1=((posx%1))*((posy%1));
					
					int posxint=(int)Math.floor(posx);
					int posyint=(int)Math.floor(posy);
					
					basedb[posxint+(posyint*winwidth)]+=x0y0;
					
					basedb[posxint+1+(posyint*winwidth)]+=x1y0;
					
					basedb[posxint+((posyint+1)*winwidth)]+=x0y1;
					
					basedb[posxint+1+((posyint+1)*winwidth)]+=x1y1;
					
				}
			}
		}
		
		for(int i=0;i<xbarnum;i++){
			double theta=(((Math.PI*2)/xbarnum)*i);
			for(int j=0;j<dotbarnum;j++){
				double posx0=Math.floor((Math.sin(theta)*dotbarint[j])+p0x);
				double posy0=Math.floor((Math.cos(theta)*dotbarint[j])+p0y);
				double posx1=Math.floor((Math.sin(theta+((Math.PI*2)/xbarnum))*dotbarint[j])+p0x);
				double posy1=Math.floor((Math.cos(theta+((Math.PI*2)/xbarnum))*dotbarint[j])+p0y);
				
				double dottheta=Math.atan2(posx1-posx0,posy1-posy0);
				int dotlength=(int)Math.floor(Math.sqrt(((posx1-posx0)*(posx1-posx0))+((posy0-posy1)*(posy0-posy1))));
				
				for(int k=0;k<dotlength;k+=5){
					double posx2=((Math.sin(dottheta)*k)+posx0);
					double posy2=((Math.cos(dottheta)*k)+posy0);
					
					double x0y0=(1.0-(posx2%1))*(1.0-(posy2%1));
					double x1y0=((posx2%1))*(1.0-(posy2%1));
					double x0y1=(1.0-(posx2%1))*((posy2%1));
					double x1y1=((posx2%1))*((posy2%1));
					
					int posxint=(int)Math.floor(posx2);
					int posyint=(int)Math.floor(posy2);
					
					
					basedb[posxint+(posyint*winwidth)]+=x0y0;
					
					basedb[posxint+1+(posyint*winwidth)]+=x1y0;
					
					basedb[posxint+((posyint+1)*winwidth)]+=x0y1;
					
					basedb[posxint+1+((posyint+1)*winwidth)]+=x1y1;
					
				}
			}
		}
		
		int fgred=fgc.getRed();
		int fggreen=fgc.getGreen();
		int fgblue=fgc.getBlue();
		
		for(int i=0;i<outimgarr.length;i++){
			if(basedb[i]>1)basedb[i]=1.0;
			
			Color bgcolor=new Color(outimgarr[i]);
			
			int red=(int)Math.floor((fgred*basedb[i])+(bgcolor.getRed()*(1-basedb[i])));
			int green=(int)Math.floor((fggreen*basedb[i])+(bgcolor.getGreen()*(1-basedb[i])));
			int blue=(int)Math.floor((fgblue*basedb[i])+(bgcolor.getBlue()*(1-basedb[i])));
			
			if(red>255)red=255;
			if(green>255)green=255;
			if(blue>255)blue=255;
			
			int alpha=255;
			
			outimgarr[i]=alpha<<24|red<<16|green<<8|blue<<0;
		}
		
		for(int i=0;i<linenum;i++){
			
			String barimgvalue=getParameter("barimg"+(i+1));
			Image barimg=null;
			int barimgwidth=0;
			int barimgheight=0;
			if(barimgvalue!=null){
				barimg=getImage(getCodeBase(),barimgvalue);
				mt.addImage(barimg,1+i);
				
				try{
					mt.waitForID(1+i);
				}
				catch(InterruptedException e){
					
				}
			
				barimgwidth=barimg.getWidth(this);
				barimgheight=barimg.getHeight(this);
				
			}
			
			int barimgarr[]=new int[barimgwidth*barimgheight];
			
			if(barimgvalue!=null){
				PixelGrabber pg0=new PixelGrabber(barimg,0,0,barimgwidth,barimgheight,barimgarr,0,barimgwidth);
				try{pg0.grabPixels();}
				catch(InterruptedException e){ }
			}
			
			if((pattern==0)||(pattern==1)){
				int polyx[]=new int[xbarnum+1];
				int polyy[]=new int[xbarnum+1];
				
				for(int j=0;j<xbarnum;j++){
					double theta=Math.PI-(((Math.PI*2)/xbarnum)*j);
					polyx[j]=(int)Math.floor(Math.sin(theta)*graphvalueint[i][j])+p0x;
					polyy[j]=(int)Math.floor(Math.cos(theta)*graphvalueint[i][j])+p0y;
				}
				polyx[xbarnum]=polyx[0];
				polyy[xbarnum]=polyy[0];
				
				Polygon poly=new Polygon(polyx,polyy,xbarnum+1);
				for(int j=0;j<winwidth;j++){
					for(int k=0;k<winheight;k++){
						if(poly.contains(j,k)){
							
							int mixred=new Color(outimgarr[j+(k*winwidth)]).getRed();
							int mixgreen=new Color(outimgarr[j+(k*winwidth)]).getGreen();
							int mixblue=new Color(outimgarr[j+(k*winwidth)]).getBlue();
							
							if(barimg!=null){
								
								int barimgpos=(j%barimgwidth)+((k%barimgheight)*barimgwidth);
								
								mixred=(mixred+new Color(barimgarr[barimgpos]).getRed())/2;
								mixgreen=(mixgreen+new Color(barimgarr[barimgpos]).getGreen())/2;
								mixblue=(mixblue+new Color(barimgarr[barimgpos]).getBlue())/2;
							}else{
								
								mixred=(mixred+barcolor[i].getRed())/2;
								mixgreen=(mixgreen+barcolor[i].getGreen())/2;
								mixblue=(mixblue+barcolor[i].getBlue())/2;
							
							}
							
							int alpha=255;
							
							outimgarr[j+(k*winwidth)]=alpha<<24|mixred<<16|mixgreen<<8|mixblue<<0;
						}
					}
				}
			}
			if((pattern==1)||(pattern==2)){
				
				double linemap[]=new double[winwidth*winheight];
				
				int polyx[]=new int[xbarnum+1];
				int polyy[]=new int[xbarnum+1];
				
				for(int j=0;j<xbarnum;j++){
					double theta=Math.PI-(((Math.PI*2)/xbarnum)*j);
					polyx[j]=(int)Math.floor(Math.sin(theta)*graphvalueint[i][j])+p0x;
					polyy[j]=(int)Math.floor(Math.cos(theta)*graphvalueint[i][j])+p0y;
				}
				polyx[xbarnum]=polyx[0];
				polyy[xbarnum]=polyy[0];
				
				for(int j=0;j<xbarnum;j++){
					int xx=polyx[j]-polyx[j+1];
					int yy=polyy[j]-polyy[j+1];
					int linelength=(int)Math.floor(Math.sqrt((double)(xx*xx)+(yy*yy)));
					double linetheta=Math.atan2((double)xx,(double)yy);
					
					for(int k=0;k<linelength;k++){
						double posx2=(Math.sin(linetheta)*k*-1)+polyx[j];
						double posy2=(Math.cos(linetheta)*k*-1)+polyy[j];
						
						
						double x0y0=(1.0-(posx2%1))*(1.0-(posy2%1));
						double x1y0=((posx2%1))*(1.0-(posy2%1));
						double x0y1=(1.0-(posx2%1))*((posy2%1));
						double x1y1=((posx2%1))*((posy2%1));
						
						int posxint=(int)Math.floor(posx2);
						int posyint=(int)Math.floor(posy2);
						
						
						linemap[posxint+(posyint*winwidth)]+=x0y0;
						
						linemap[posxint+1+(posyint*winwidth)]+=x1y0;
						
						linemap[posxint+((posyint+1)*winwidth)]+=x0y1;
						
						linemap[posxint+1+((posyint+1)*winwidth)]+=x1y1;
						
					}
				}
				for(int j=0;j<outimgarr.length;j++){
					Color pixcolor=new Color(outimgarr[j]);
					
					int red=0;
					int green=0;
					int blue=0;
					
					if(barimg!=null){
						
						int barimgpos=((j%winwidth)%barimgwidth)+(((j/winwidth)%barimgheight)*barimgwidth);
						
						red=(int)Math.floor((new Color(barimgarr[barimgpos]).getRed()*linemap[j])+(pixcolor.getRed()*(1-linemap[j])));
						green=(int)Math.floor((new Color(barimgarr[barimgpos]).getGreen()*linemap[j])+(pixcolor.getGreen()*(1-linemap[j])));
						blue=(int)Math.floor((new Color(barimgarr[barimgpos]).getBlue()*linemap[j])+(pixcolor.getBlue()*(1-linemap[j])));
					}else{
						red=(int)Math.floor((barcolor[i].getRed()*linemap[j])+(pixcolor.getRed()*(1-linemap[j])));
						green=(int)Math.floor((barcolor[i].getGreen()*linemap[j])+(pixcolor.getGreen()*(1-linemap[j])));
						blue=(int)Math.floor((barcolor[i].getBlue()*linemap[j])+(pixcolor.getBlue()*(1-linemap[j])));
					}
					
					int alpha=255;
					
					outimgarr[j]=alpha<<24|red<<16|green<<8|blue<<0;
					
				}
				
			}
		}
		
		MemoryImageSource mis=new MemoryImageSource(winwidth,winheight,outimgarr,0,winwidth);
		outimg=createImage(mis);
		
		label0.setBounds(0,0,0,0);
		
		repaint();
	}
	
}
