
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.border.Border;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author SHIVAM KHANNA
 */
   /*class DictionaryGETRequestExample
{
    public static Map<String,Object>jsonToMap(String str)
    {
        Map<String,Object> map=new Gson().fromJson(str, new TypeToken<HashMap<String,Object>>() {}.getType());
        return map;
    }}*/
 
public class main extends javax.swing.JFrame {

    /**
     * Creates new form main
     */
    public static Map<String,Object>jsonToMap(String str)
    {
        Map<String,Object> map=new Gson().fromJson(str, new TypeToken<HashMap<String,Object>>() {}.getType());
        return map;
    }
    public main() {
        initComponents();
    Dimension size=Toolkit.getDefaultToolkit().getScreenSize();
    setSize(size);
    Image img=Toolkit.getDefaultToolkit().getImage("src\\images\\wd.png");
    setIconImage(img);
    
            int h=size.height;
            int w=size.width;
           JLabel lb=new JLabel();
           headlb.setVisible(false);
   getContentPane().setBackground(Color.white);
   pn1.setSize(size);
   pn2.setSize(w, 68);
   pn3.setSize(200,h);
  innerfr.setSize(1166,700);
 search.setBounds(1216,10,40,40);
   desklb.setBounds(620, 0, 230,70);
changelabel.setSize(1166,700);
///Icon img=new ImageIcon("src\\images\\9to12am.jpg");
///changelabel.setIcon(img);
   desklb.setVisible(false);
   Thread t1=new Thread(new datafetch());
  t1.start();
   Thread t2=new Thread(new weatherdata());
  t2.start();
  Thread br=new Thread(new backgroundchange());
br.start();

   
    }

    class datafetch implements Runnable
            {

        @Override
        public void run() {
            
            try {
                Thread.sleep(4000);
                loadlb.setVisible(false);
      desklb.setVisible(true);
                /// loadlb.setIcon(new ImageIcon("C:\\Users\\SHIVAM KHANNA\\Desktop\\weather images\\hot.png"));
            } catch (InterruptedException ex) {
                Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
            }
       
        }
            
       
           
        
                
            }
    
    class weatherdata implements Runnable
    {

        @Override
        public void run() {
           /////////////////////loigc//////////
           /// BorderFactory bf=(BorderFactory) BorderFactory.createLineBorder(new Color(0,128,128), 2);
             /*  j9.setBorder(null);
               j1.setBorder(null);
j2.setBorder(null);
j3.setBorder(null);
j5.setBorder(null);*/
           String apikey="8ca47803921d46266315ed034c782e02";
 /// String apikey="49a5b14fd471e2400d9525ce4309105d";
 /// String loc="toronto,canada";
 String loc=tf.getText();
 String loc1=loc.toUpperCase();
 headlb.setText(loc1+" Weather");
 ///  String urlString="http://api.openweathermap.org/data/2.5/weather?q="+loc+"&APPID="+apikey+"&units=imperial";
 /// String urlString="http://api.openweathermap.org/data/2.5/weather?q=amritsar,india&APPID=8ca47803921d46266315ed034c782e02&units=metric";      
  String urlString="http://api.openweathermap.org/data/2.5/weather?q="+loc+"&APPID=307b031a0184f0c7c23eb33187320f6a&units=metric";      
//// System.out.println(urlString);
   try
   {
       StringBuilder result=new StringBuilder();
       URL url=new URL(urlString);
    
       URLConnection conn=url.openConnection();
       System.out.println("connection built");
       InputStreamReader isr=new InputStreamReader(conn.getInputStream());
       BufferedReader rd=new BufferedReader(isr);
       System.out.println("inputs bulud");
       String line;
       while((line=rd.readLine())!=null)
       {
           result.append(line);
           System.out.println("while run");
       }
       rd.close();
       System.out.println(result);
       System.out.println("result produced");
       Map<String,Object> respMap=jsonToMap(result.toString());
     Map<String,Object> mainMap=jsonToMap(respMap.get("main").toString());
       Map<String,Object> windMap=jsonToMap(respMap.get("wind").toString());
       Map<String,Object> sysMap=jsonToMap(respMap.get("sys").toString());
     Map<String,Object> cloudsMap=jsonToMap(respMap.get("clouds").toString());
         ///Map<String,Object> rainMap=jsonToMap(respMap.get("rain").toString());
      ////   w4.setText(rainMap.get("1h").toString()+" mm");
///  Map<String,Object> visibleMap=jsonToMap(respMap.get("visibility").toString());
      w6.setText(mainMap.get("pressure").toString()+" hPa");
       w7.setText(mainMap.get("temp_min").toString()+" C");
        w8.setText(mainMap.get("temp_max").toString()+" C");
        ////////////////sunrise////////
        ///w4.setText(visibleMap.get("value").toString());
       double unix=(double) sysMap.get("sunrise");
        Date date=new Date ((long) (unix*1000F));
        SimpleDateFormat jdf=new SimpleDateFormat(" HH:mm:ss ");
     ///   jdf.setTimeZone(TimeZone.getTimeZone("GMT-4"));
        String java_dt=jdf.format(date);
   
        
          w9.setText(java_dt);
        
          //////////////sunset////////////
          double unix1=(double) sysMap.get("sunset");
        Date date1=new Date ((long) (unix1*1000F));
        SimpleDateFormat jdf1=new SimpleDateFormat(" HH:mm:ss ");
        ///jdf1.setTimeZone(TimeZone.getTimeZone("GMT-4"));
        String java_dt1=jdf1.format(date1);
        
          w10.setText(java_dt1);
        
          w11.setText(cloudsMap.get("all").toString()+"%");
        /*  String clouds=cloudsMap.get("all").toString();
          String temp=mainMap.get("temp").toString();
           int cld=Integer.parseInt(clouds);
           int tmp=Integer.parseInt(temp);
           if(tmp<=10)
           {
               BorderFactory bf=(BorderFactory) BorderFactory.createLineBorder(new Color(0,128,128), 2);
               j9.setBorder((Border) bf);
           }
           else if(tmp>10&&tmp<=29)
           {
           BorderFactory bf=(BorderFactory) BorderFactory.createLineBorder(new Color(0,128,128), 2);
               j1.setBorder((Border) bf);
          
           }
             else if(tmp>=30)
           {
           BorderFactory bf=(BorderFactory) BorderFactory.createLineBorder(new Color(0,128,128), 2);
               j5.setBorder((Border) bf);
          
           }
             else if(cld>=90)
             {
           BorderFactory bf=(BorderFactory) BorderFactory.createLineBorder(new Color(0,128,128), 2);
               j2.setBorder((Border) bf);
                j3.setBorder((Border) bf);
             }
           else if(cld<=50&&cld>=30)
             {
           BorderFactory bf=(BorderFactory) BorderFactory.createLineBorder(new Color(0,128,128), 2);
               j3.setBorder((Border) bf);
                
             }*/
 ///Map<String,Object> weatherMap=jsonToMap(respMap.get("weather").toString());
       ////System.out.println("currnet temperature:"+mainMap.get("temp"));
           Calendar cal1=Calendar.getInstance();
     Date date3=cal1.getTime();
     DateFormat df=new SimpleDateFormat("HH:mm:ss");
     String fd2=df.format(date3);
      w1.setText(fd2);
      w2.setText(windMap.get("speed").toString());
      /// System.out.println("Current humidity:"+mainMap.get("humidity"));
      /// System.out.println("wind speed:"+windMap.get("speed"));
     w3.setText(windMap.get("deg").toString());
   ///System.out.println("description:"+weatherMap.get("main"));
l1.setText(mainMap.get("temp").toString()+" C");
w5.setText(mainMap.get("humidity").toString()+" %");
   System.out.println("try printed");
   }
   catch( Exception e)
   {
       System.out.println(e.getMessage());
       System.out.println("catch run");
   }
        }
        
        
    }
    class backgroundchange implements Runnable
    {

        @Override
        public void run() {
     Calendar cal=Calendar.getInstance();
     Date date=cal.getTime();
     DateFormat df=new SimpleDateFormat("HH");
     String fd=df.format(date);
     int hr=Integer.parseInt(fd);
   
     if(hr>=0&&hr<=3)
     {
         Icon img=new ImageIcon("src\\images\\0to3am.png");
changelabel.setIcon(img);

     }
     
     if(hr>=4&&hr<=6)
     {
         Icon img=new ImageIcon("src\\images\\4to6am.jpg");
changelabel.setIcon(img);

     }
     
    if(hr>=7&&hr<=9)
     {
         Icon img=new ImageIcon("src\\images\\dawn.jpeg");
changelabel.setIcon(img);

     }
     
    if(hr>=10&&hr<=15)
     {
         Icon img=new ImageIcon("src\\images\\10to3pm.jpg");
changelabel.setIcon(img);

     }
     
     if(hr>=16&&hr<18)
     {
         Icon img=new ImageIcon("src\\images\\10to3pm.jpg");
changelabel.setIcon(img);

     }
     
     if(hr>=19&&hr<=21)
     {
         Icon img=new ImageIcon("src\\images\\12to3am.png");
changelabel.setIcon(img);

     }
     if(hr>=22&&hr<=23)
     {
         Icon img=new ImageIcon("src\\images\\10to11pm.png");
changelabel.setIcon(img);

     }
     
            System.out.println("time is"+fd);
        
        
        }
        
    }
    class highlight implements Runnable
    {

        @Override
        public void run() {
              
            
            
            
        }
        
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel8 = new javax.swing.JLabel();
        pn1 = new javax.swing.JPanel();
        pn3 = new javax.swing.JPanel();
        lb1 = new javax.swing.JLabel();
        lb2 = new javax.swing.JLabel();
        lb3 = new javax.swing.JLabel();
        lb4 = new javax.swing.JLabel();
        lb5 = new javax.swing.JLabel();
        lb6 = new javax.swing.JLabel();
        j1 = new javax.swing.JLabel();
        j2 = new javax.swing.JLabel();
        j3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        j5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lb7 = new javax.swing.JLabel();
        j9 = new javax.swing.JLabel();
        pn2 = new javax.swing.JPanel();
        loadlb = new javax.swing.JLabel();
        desklb = new javax.swing.JLabel();
        tf = new javax.swing.JTextField();
        search = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        headlb = new javax.swing.JLabel();
        innerfr = new javax.swing.JInternalFrame();
        l3 = new javax.swing.JLabel();
        l4 = new javax.swing.JLabel();
        l5 = new javax.swing.JLabel();
        l6 = new javax.swing.JLabel();
        l7 = new javax.swing.JLabel();
        l8 = new javax.swing.JLabel();
        l9 = new javax.swing.JLabel();
        l2 = new javax.swing.JLabel();
        l10 = new javax.swing.JLabel();
        l11 = new javax.swing.JLabel();
        l1 = new javax.swing.JLabel();
        d1 = new javax.swing.JLabel();
        d2 = new javax.swing.JLabel();
        d3 = new javax.swing.JLabel();
        d4 = new javax.swing.JLabel();
        d5 = new javax.swing.JLabel();
        d6 = new javax.swing.JLabel();
        d7 = new javax.swing.JLabel();
        d8 = new javax.swing.JLabel();
        d9 = new javax.swing.JLabel();
        d10 = new javax.swing.JLabel();
        d11 = new javax.swing.JLabel();
        w1 = new javax.swing.JLabel();
        w2 = new javax.swing.JLabel();
        w3 = new javax.swing.JLabel();
        w4 = new javax.swing.JLabel();
        w6 = new javax.swing.JLabel();
        w7 = new javax.swing.JLabel();
        w8 = new javax.swing.JLabel();
        w5 = new javax.swing.JLabel();
        w9 = new javax.swing.JLabel();
        w10 = new javax.swing.JLabel();
        w11 = new javax.swing.JLabel();
        changelabel = new javax.swing.JLabel();
        changelabel1 = new javax.swing.JLabel();
        d23 = new javax.swing.JLabel();
        d12 = new javax.swing.JLabel();
        d13 = new javax.swing.JLabel();
        d14 = new javax.swing.JLabel();
        d15 = new javax.swing.JLabel();
        d16 = new javax.swing.JLabel();
        d17 = new javax.swing.JLabel();
        d18 = new javax.swing.JLabel();
        d19 = new javax.swing.JLabel();
        d20 = new javax.swing.JLabel();
        d21 = new javax.swing.JLabel();
        d22 = new javax.swing.JLabel();
        w12 = new javax.swing.JLabel();
        w13 = new javax.swing.JLabel();
        w14 = new javax.swing.JLabel();
        w23 = new javax.swing.JLabel();
        w24 = new javax.swing.JLabel();
        w25 = new javax.swing.JLabel();
        w26 = new javax.swing.JLabel();
        w15 = new javax.swing.JLabel();
        w16 = new javax.swing.JLabel();
        w17 = new javax.swing.JLabel();
        w18 = new javax.swing.JLabel();
        w19 = new javax.swing.JLabel();
        w20 = new javax.swing.JLabel();
        w21 = new javax.swing.JLabel();
        w22 = new javax.swing.JLabel();

        jLabel8.setText("jLabel8");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        pn1.setBackground(new java.awt.Color(255, 255, 255));
        pn1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pn1.setLayout(null);

        pn3.setBackground(new java.awt.Color(255, 255, 255));
        pn3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        pn3.setLayout(null);

        lb1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/sun.png"))); // NOI18N
        lb1.setText("jLabel1");
        pn3.add(lb1);
        lb1.setBounds(10, 20, 60, 60);

        lb2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/rain.png"))); // NOI18N
        lb2.setText("jLabel2");
        pn3.add(lb2);
        lb2.setBounds(10, 100, 60, 60);

        lb3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/suncld.png"))); // NOI18N
        lb3.setText("jLabel3");
        pn3.add(lb3);
        lb3.setBounds(10, 180, 60, 60);

        lb4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/thunder.png"))); // NOI18N
        lb4.setText("jLabel4");
        pn3.add(lb4);
        lb4.setBounds(10, 250, 60, 60);

        lb5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nitecld.png"))); // NOI18N
        lb5.setText("jLabel5");
        pn3.add(lb5);
        lb5.setBounds(10, 320, 60, 60);

        lb6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/hot.png"))); // NOI18N
        lb6.setText("jLabel6");
        pn3.add(lb6);
        lb6.setBounds(10, 390, 60, 60);

        j1.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        j1.setText("Sunny");
        pn3.add(j1);
        j1.setBounds(90, 30, 80, 40);

        j2.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        j2.setText("Rain");
        pn3.add(j2);
        j2.setBounds(90, 120, 60, 30);

        j3.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        j3.setText("Cloudy");
        pn3.add(j3);
        j3.setBounds(90, 200, 70, 30);

        jLabel4.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel4.setText("Thunderstorm");
        pn3.add(jLabel4);
        jLabel4.setBounds(80, 270, 110, 30);

        j5.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        j5.setText("Night");
        pn3.add(j5);
        j5.setBounds(90, 330, 80, 30);

        jLabel6.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel6.setText("Hot");
        pn3.add(jLabel6);
        jLabel6.setBounds(90, 400, 29, 30);

        lb7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cold.png"))); // NOI18N
        lb7.setText("jLabel8");
        pn3.add(lb7);
        lb7.setBounds(10, 470, 60, 60);

        j9.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        j9.setText("Cold");
        j9.setToolTipText("");
        pn3.add(j9);
        j9.setBounds(90, 480, 50, 30);

        pn1.add(pn3);
        pn3.setBounds(0, 70, 200, 350);

        pn2.setBackground(new java.awt.Color(255, 255, 255));
        pn2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        pn2.setLayout(null);

        loadlb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/loader.gif"))); // NOI18N
        pn2.add(loadlb);
        loadlb.setBounds(683, 0, 80, 70);

        desklb.setFont(new java.awt.Font("Trebuchet MS", 1, 32)); // NOI18N
        desklb.setForeground(new java.awt.Color(0, 153, 204));
        desklb.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        desklb.setText("Weatherdesk");
        pn2.add(desklb);
        desklb.setBounds(370, 0, 230, 70);

        tf.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        tf.setText("Enter city name,country name");
        tf.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tfMouseClicked(evt);
            }
        });
        tf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfActionPerformed(evt);
            }
        });
        tf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfKeyReleased(evt);
            }
        });
        pn2.add(tf);
        tf.setBounds(1000, 10, 190, 40);

        search.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search.png"))); // NOI18N
        search.setText("jLabel1");
        search.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchMouseClicked(evt);
            }
        });
        search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchKeyReleased(evt);
            }
        });
        pn2.add(search);
        search.setBounds(520, 10, 40, 40);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/wd.png"))); // NOI18N
        jLabel7.setText("jLabel7");
        pn2.add(jLabel7);
        jLabel7.setBounds(20, 0, 70, 70);

        headlb.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        pn2.add(headlb);
        headlb.setBounds(110, 0, 250, 70);

        pn1.add(pn2);
        pn2.setBounds(0, 0, 480, 70);

        innerfr.setBackground(new java.awt.Color(255, 255, 255));
        innerfr.setVisible(true);
        innerfr.getContentPane().setLayout(null);

        l3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/windir.png"))); // NOI18N
        l3.setText("jLabel2");
        innerfr.getContentPane().add(l3);
        l3.setBounds(600, 20, 120, 120);

        l4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/rain5.png"))); // NOI18N
        l4.setText("jLabel3");
        innerfr.getContentPane().add(l4);
        l4.setBounds(890, 20, 120, 120);

        l5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pressure1.png"))); // NOI18N
        l5.setText("jLabel4");
        innerfr.getContentPane().add(l5);
        l5.setBounds(330, 220, 120, 120);

        l6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pressure.png"))); // NOI18N
        l6.setText("jLabel5");
        innerfr.getContentPane().add(l6);
        l6.setBounds(600, 220, 120, 120);

        l7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/maxtemp2.png"))); // NOI18N
        l7.setText("jLabel6");
        innerfr.getContentPane().add(l7);
        l7.setBounds(890, 220, 120, 120);

        l8.setIcon(new javax.swing.ImageIcon("C:\\Users\\SHIVAM KHANNA\\Desktop\\weather images\\humidity.png")); // NOI18N
        l8.setText("jLabel7");
        innerfr.getContentPane().add(l8);
        l8.setBounds(20, 420, 120, 120);

        l9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/sunrise.png"))); // NOI18N
        l9.setText("jLabel8");
        innerfr.getContentPane().add(l9);
        l9.setBounds(330, 420, 120, 120);

        l2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/windmill2.gif"))); // NOI18N
        l2.setText("jLabel9");
        innerfr.getContentPane().add(l2);
        l2.setBounds(330, 20, 120, 120);

        l10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/sunset.png"))); // NOI18N
        l10.setText("jLabel10");
        innerfr.getContentPane().add(l10);
        l10.setBounds(600, 420, 120, 120);

        l11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cloud.png"))); // NOI18N
        l11.setText("jLabel11");
        innerfr.getContentPane().add(l11);
        l11.setBounds(890, 420, 120, 120);

        l1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        l1.setText("Calculating...");
        innerfr.getContentPane().add(l1);
        l1.setBounds(20, 20, 250, 50);

        d1.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        d1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        d1.setText("temp");
        innerfr.getContentPane().add(d1);
        d1.setBounds(20, 70, 120, 30);

        d2.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        d2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        d2.setText("Wind-Speed");
        innerfr.getContentPane().add(d2);
        d2.setBounds(330, 140, 120, 30);

        d3.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        d3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        d3.setText("Wind-Angle");
        innerfr.getContentPane().add(d3);
        d3.setBounds(600, 140, 120, 30);

        d4.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        d4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        d4.setText("Rain");
        innerfr.getContentPane().add(d4);
        d4.setBounds(890, 140, 120, 30);

        d5.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        d5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        d5.setText("Humidity");
        innerfr.getContentPane().add(d5);
        d5.setBounds(20, 540, 120, 30);

        d6.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        d6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        d6.setText("Pressure");
        innerfr.getContentPane().add(d6);
        d6.setBounds(330, 340, 120, 30);

        d7.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        d7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        d7.setText("Min-Temp");
        innerfr.getContentPane().add(d7);
        d7.setBounds(600, 340, 120, 30);

        d8.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        d8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        d8.setText("Max-temp");
        innerfr.getContentPane().add(d8);
        d8.setBounds(890, 340, 120, 30);

        d9.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        d9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        d9.setText("Sunrise");
        innerfr.getContentPane().add(d9);
        d9.setBounds(330, 540, 120, 30);

        d10.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        d10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        d10.setText("Sunset");
        innerfr.getContentPane().add(d10);
        d10.setBounds(600, 540, 120, 30);

        d11.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        d11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        d11.setText("Clouds");
        innerfr.getContentPane().add(d11);
        d11.setBounds(890, 540, 120, 30);

        w1.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 14)); // NOI18N
        w1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        w1.setText("calculating...");
        innerfr.getContentPane().add(w1);
        w1.setBounds(20, 100, 120, 30);

        w2.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 14)); // NOI18N
        w2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        w2.setText("calculating...");
        innerfr.getContentPane().add(w2);
        w2.setBounds(330, 170, 120, 30);

        w3.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 14)); // NOI18N
        w3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        w3.setText("calculating...");
        innerfr.getContentPane().add(w3);
        w3.setBounds(600, 170, 120, 30);

        w4.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 14)); // NOI18N
        w4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        w4.setText("20 mm");
        innerfr.getContentPane().add(w4);
        w4.setBounds(890, 170, 120, 30);

        w6.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 14)); // NOI18N
        w6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        w6.setText("calculating...");
        innerfr.getContentPane().add(w6);
        w6.setBounds(330, 370, 120, 30);

        w7.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 14)); // NOI18N
        w7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        w7.setText("calculating...");
        innerfr.getContentPane().add(w7);
        w7.setBounds(600, 370, 120, 30);

        w8.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 14)); // NOI18N
        w8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        w8.setText("calculating...");
        innerfr.getContentPane().add(w8);
        w8.setBounds(890, 370, 120, 30);

        w5.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 14)); // NOI18N
        w5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        w5.setText("calculating...");
        innerfr.getContentPane().add(w5);
        w5.setBounds(20, 570, 120, 30);

        w9.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 14)); // NOI18N
        w9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        w9.setText("calculating...");
        innerfr.getContentPane().add(w9);
        w9.setBounds(330, 570, 120, 30);

        w10.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 14)); // NOI18N
        w10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        w10.setText("calculating...");
        innerfr.getContentPane().add(w10);
        w10.setBounds(600, 570, 120, 30);

        w11.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 14)); // NOI18N
        w11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        w11.setText("calculating...");
        innerfr.getContentPane().add(w11);
        w11.setBounds(890, 570, 120, 30);

        changelabel.setText("jLabel1");
        innerfr.getContentPane().add(changelabel);
        changelabel.setBounds(0, 0, 260, 320);

        changelabel1.setText("jLabel1");
        innerfr.getContentPane().add(changelabel1);
        changelabel1.setBounds(0, 0, 260, 320);

        d23.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        d23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        d23.setText("Humidity");
        innerfr.getContentPane().add(d23);
        d23.setBounds(20, 540, 120, 30);

        d12.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        d12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        d12.setText("Humidity");
        innerfr.getContentPane().add(d12);
        d12.setBounds(20, 540, 120, 30);

        d13.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        d13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        d13.setText("Rain");
        innerfr.getContentPane().add(d13);
        d13.setBounds(890, 140, 120, 30);

        d14.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        d14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        d14.setText("Pressure");
        innerfr.getContentPane().add(d14);
        d14.setBounds(330, 340, 120, 30);

        d15.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        d15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        d15.setText("Wind-Angle");
        innerfr.getContentPane().add(d15);
        d15.setBounds(600, 140, 120, 30);

        d16.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        d16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        d16.setText("temp");
        innerfr.getContentPane().add(d16);
        d16.setBounds(20, 70, 120, 30);

        d17.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        d17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        d17.setText("Wind-Speed");
        innerfr.getContentPane().add(d17);
        d17.setBounds(330, 140, 120, 30);

        d18.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        d18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        d18.setText("Min-Temp");
        innerfr.getContentPane().add(d18);
        d18.setBounds(600, 340, 120, 30);

        d19.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        d19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        d19.setText("Max-temp");
        innerfr.getContentPane().add(d19);
        d19.setBounds(890, 340, 120, 30);

        d20.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        d20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        d20.setText("Sunrise");
        innerfr.getContentPane().add(d20);
        d20.setBounds(330, 540, 120, 30);

        d21.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        d21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        d21.setText("Sunset");
        innerfr.getContentPane().add(d21);
        d21.setBounds(600, 540, 120, 30);

        d22.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        d22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        d22.setText("Clouds");
        innerfr.getContentPane().add(d22);
        d22.setBounds(890, 540, 120, 30);

        w12.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 14)); // NOI18N
        w12.setForeground(new java.awt.Color(255, 255, 255));
        w12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        w12.setText("calculating...");
        innerfr.getContentPane().add(w12);
        w12.setBounds(20, 100, 120, 30);

        w13.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 14)); // NOI18N
        w13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        w13.setText("calculating...");
        innerfr.getContentPane().add(w13);
        w13.setBounds(330, 170, 120, 30);

        w14.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 14)); // NOI18N
        w14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        w14.setText("calculating...");
        innerfr.getContentPane().add(w14);
        w14.setBounds(600, 170, 120, 30);

        w23.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 14)); // NOI18N
        w23.setForeground(new java.awt.Color(255, 255, 255));
        w23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        w23.setText("calculating...");
        innerfr.getContentPane().add(w23);
        w23.setBounds(20, 100, 120, 30);

        w24.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 14)); // NOI18N
        w24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        w24.setText("calculating...");
        innerfr.getContentPane().add(w24);
        w24.setBounds(330, 170, 120, 30);

        w25.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 14)); // NOI18N
        w25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        w25.setText("calculating...");
        innerfr.getContentPane().add(w25);
        w25.setBounds(600, 170, 120, 30);

        w26.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 14)); // NOI18N
        w26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        w26.setText("20 mm");
        innerfr.getContentPane().add(w26);
        w26.setBounds(890, 170, 120, 30);

        w15.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 14)); // NOI18N
        w15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        w15.setText("20 mm");
        innerfr.getContentPane().add(w15);
        w15.setBounds(890, 170, 120, 30);

        w16.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 14)); // NOI18N
        w16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        w16.setText("calculating...");
        innerfr.getContentPane().add(w16);
        w16.setBounds(330, 370, 120, 30);

        w17.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 14)); // NOI18N
        w17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        w17.setText("calculating...");
        innerfr.getContentPane().add(w17);
        w17.setBounds(600, 370, 120, 30);

        w18.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 14)); // NOI18N
        w18.setForeground(new java.awt.Color(255, 255, 255));
        w18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        w18.setText("calculating...");
        innerfr.getContentPane().add(w18);
        w18.setBounds(20, 100, 120, 30);

        w19.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 14)); // NOI18N
        w19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        w19.setText("calculating...");
        innerfr.getContentPane().add(w19);
        w19.setBounds(330, 170, 120, 30);

        w20.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 14)); // NOI18N
        w20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        w20.setText("calculating...");
        innerfr.getContentPane().add(w20);
        w20.setBounds(600, 170, 120, 30);

        w21.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 14)); // NOI18N
        w21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        w21.setText("20 mm");
        innerfr.getContentPane().add(w21);
        w21.setBounds(890, 170, 120, 30);

        w22.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 14)); // NOI18N
        w22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        w22.setText("calculating...");
        innerfr.getContentPane().add(w22);
        w22.setBounds(330, 370, 120, 30);

        pn1.add(innerfr);
        innerfr.setBounds(200, 70, 280, 350);

        getContentPane().add(pn1);
        pn1.setBounds(0, 0, 480, 420);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfActionPerformed

    private void searchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchMouseClicked
        // TODO add your handling code here:
        String str=tf.getText();
        if(str.equals(null))
        {
            tf.setText("enter some valid city");
        }
        desklb.setVisible(false);
        loadlb.setVisible(true);
        Thread tt1=new Thread(new datafetch());
  tt1.start();
   Thread tt2=new Thread(new weatherdata());
  tt2.start();
   
    }//GEN-LAST:event_searchMouseClicked

    private void tfMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tfMouseClicked
        // TODO add your handling code here:
        tf.setText("");
        headlb.setText("");
        headlb.setVisible(true);
    }//GEN-LAST:event_tfMouseClicked

    private void tfKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfKeyReleased
        // TODO add your handling code here:
        
   
   
    }//GEN-LAST:event_tfKeyReleased

    private void searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchKeyReleased
    
    }//GEN-LAST:event_searchKeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel changelabel;
    private javax.swing.JLabel changelabel1;
    private javax.swing.JLabel d1;
    private javax.swing.JLabel d10;
    private javax.swing.JLabel d11;
    private javax.swing.JLabel d12;
    private javax.swing.JLabel d13;
    private javax.swing.JLabel d14;
    private javax.swing.JLabel d15;
    private javax.swing.JLabel d16;
    private javax.swing.JLabel d17;
    private javax.swing.JLabel d18;
    private javax.swing.JLabel d19;
    private javax.swing.JLabel d2;
    private javax.swing.JLabel d20;
    private javax.swing.JLabel d21;
    private javax.swing.JLabel d22;
    private javax.swing.JLabel d23;
    private javax.swing.JLabel d3;
    private javax.swing.JLabel d4;
    private javax.swing.JLabel d5;
    private javax.swing.JLabel d6;
    private javax.swing.JLabel d7;
    private javax.swing.JLabel d8;
    private javax.swing.JLabel d9;
    private javax.swing.JLabel desklb;
    private javax.swing.JLabel headlb;
    private javax.swing.JInternalFrame innerfr;
    private javax.swing.JLabel j1;
    private javax.swing.JLabel j2;
    private javax.swing.JLabel j3;
    private javax.swing.JLabel j5;
    private javax.swing.JLabel j9;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel l1;
    private javax.swing.JLabel l10;
    private javax.swing.JLabel l11;
    private javax.swing.JLabel l2;
    private javax.swing.JLabel l3;
    private javax.swing.JLabel l4;
    private javax.swing.JLabel l5;
    private javax.swing.JLabel l6;
    private javax.swing.JLabel l7;
    private javax.swing.JLabel l8;
    private javax.swing.JLabel l9;
    private javax.swing.JLabel lb1;
    private javax.swing.JLabel lb2;
    private javax.swing.JLabel lb3;
    private javax.swing.JLabel lb4;
    private javax.swing.JLabel lb5;
    private javax.swing.JLabel lb6;
    private javax.swing.JLabel lb7;
    private javax.swing.JLabel loadlb;
    private javax.swing.JPanel pn1;
    private javax.swing.JPanel pn2;
    private javax.swing.JPanel pn3;
    private javax.swing.JLabel search;
    private javax.swing.JTextField tf;
    private javax.swing.JLabel w1;
    private javax.swing.JLabel w10;
    private javax.swing.JLabel w11;
    private javax.swing.JLabel w12;
    private javax.swing.JLabel w13;
    private javax.swing.JLabel w14;
    private javax.swing.JLabel w15;
    private javax.swing.JLabel w16;
    private javax.swing.JLabel w17;
    private javax.swing.JLabel w18;
    private javax.swing.JLabel w19;
    private javax.swing.JLabel w2;
    private javax.swing.JLabel w20;
    private javax.swing.JLabel w21;
    private javax.swing.JLabel w22;
    private javax.swing.JLabel w23;
    private javax.swing.JLabel w24;
    private javax.swing.JLabel w25;
    private javax.swing.JLabel w26;
    private javax.swing.JLabel w3;
    private javax.swing.JLabel w4;
    private javax.swing.JLabel w5;
    private javax.swing.JLabel w6;
    private javax.swing.JLabel w7;
    private javax.swing.JLabel w8;
    private javax.swing.JLabel w9;
    // End of variables declaration//GEN-END:variables
}
