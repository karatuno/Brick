import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.sql.SQLException;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import records.rec;


public class NewClass extends Applet implements KeyListener {
    
    int X=175,Y=300, i=0, y=0, x=-183,z=-366, sc=1, o=200,p=400,q=60;
    Random r=new Random();
    int j=r.nextInt(150);
    int k=r.nextInt(150);
    int l=r.nextInt(150);
    
    
    public void init()
	{       
                new rec();
                setSize(400,550);
		addKeyListener(this);
		requestFocus();
		setBackground(Color.white);
		
                
	}
    public void reset(){
        X=175;
        Y=300;
        i=0;
        y=0;
        x=-183;
        z=-366;
        if (sc>rec.highscr)
        {rec.highscr=sc;
            try {
                rec.st.executeUpdate("insert into info values("+rec.highscr+")");
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        sc=0;
        o=200;
        p=400;
        q=60;
        timer2.stop();

    }

    @Override
    public void keyTyped(KeyEvent e) {
        timer.start();
        timer2.start();
        
    }
    
    
    @Override
    public void keyPressed(KeyEvent e) {
        showStatus("KeyDown");
		int key=e.getKeyCode();
               
		switch(key) 
		{
			case KeyEvent.VK_W:{
				showStatus("Move to Up");
                                moveU();
				break;}
			case KeyEvent.VK_S:{
				showStatus("Move to Down");
                                moveD();
				break;}
			case KeyEvent.VK_A:{
				showStatus("Move to Left");
                                moveL();
				break;}
			case KeyEvent.VK_D:{
				showStatus("Move to Right");
                                moveR();
				break;}
                                              
                        
		}
		
    }

    @Override
    public void keyReleased(KeyEvent e) {
       
    }
    
    public void paint(Graphics g)
	{
                g.setFont(new Font("Vermin Vibes 1989", Font.PLAIN,30));
		g.drawString("SCORE ",20,50);
                g.setFont(new Font("Munro", Font.PLAIN,30));
                g.drawString(""+sc ,20,80);
                g.setFont(new Font("Vermin Vibes 1989", Font.PLAIN,30));
		g.drawString("BEST ",300,50);
                g.setFont(new Font("Munro", Font.PLAIN,30));
                g.drawString(""+rec.highscr ,300,80);
                g.setColor(Color.black);
                g.fillRect(X, Y, 30, 30);                         
                g.fillRect(0, y, j, 30);
                g.fillRect(j+o, y, 400, 30);
                g.fillRect(0, x, k, 30);
                g.fillRect(k+o, x, 400, 30);
                g.fillRect(0, z, l, 30);
                g.fillRect(l+o, z, 400, 30);
                
                g.setFont(new Font("ComicSans", Font.BOLD,100));
                g.drawString("B", 30, p);
                g.drawString("R", 95, p);
                g.fillRect(175, 350, 30, q);  
                g.drawString("C", 210, p);
                g.drawString("K", 275, p);
                g.setFont(new Font("ComicSans", Font.PLAIN,25));
                g.drawString("PRESS    W    TO PLAY", 60, p+100);
                g.drawString("A S D", 155, p+120);
	}
        
    Timer timer=new Timer(5,new ActionListener()
            {
            public void actionPerformed(ActionEvent e)
            {   
                y++;
                x++;
                z++;
                Y=(Y+i);
                i++;
                repaint();
                
                    if(Y<=1 || Y>=550 || X<=1 || X>=400)
                    {JOptionPane.showMessageDialog(null,"Game Over!!");
                    timer.stop();
                    reset();
                     repaint();
                    }
                    if(Y>y && Y<y+30 ){
                        if(X>j && X<j+o)
                    {
                        sc++;
                    }else{
                        JOptionPane.showMessageDialog(null,"Game Over!!");
                        timer.stop();
                        reset();
                         repaint();
                    }
                    }
                    
                    if(Y>x && Y<x+30 ){
                        if(X>k && X<k+o)
                    {
                        sc++;
                    }else{
                        JOptionPane.showMessageDialog(null,"Game Over!!");
                        timer.stop();
                        reset();
                        repaint();
                    }
                    }
                    
                    if(Y>z && Y<z+30 ){
                        if(X>l && X<l+o)
                    {
                        sc++;
                    }else{
                        JOptionPane.showMessageDialog(null,"Game Over!!");
                        timer.stop();
                        reset();
                         repaint();
                    }
                    }
                    
                    if(sc%100==0)
                    {o=o-20;
                    sc++;}
                    
                    if(y==550){
                        y=0;
                        j=r.nextInt(150);
                    }
                    if(x==550){
                        x=0;
                        k=r.nextInt(150);
                    }
                    if(z==550){
                        z=0;
                        l=r.nextInt(150);
                    }
            }
            });
    
    Timer timer2=new Timer(5,new ActionListener()
            {
            public void actionPerformed(ActionEvent e)
            {   
                q--;
                p=p+2;
                repaint();
            }
            });
    
        public void moveU()
        {
            i=0;
            Y=Y-100;
        }
        public void moveD()
        {
            i=0;
            Y=Y+100;
        }
        public void moveL()
        {
            i=0;
            X=X-50;
            Y=Y-100;
        }
        public void moveR()
        {
            i=0;
            Y=Y-100;
            X=X+50;
        }
}