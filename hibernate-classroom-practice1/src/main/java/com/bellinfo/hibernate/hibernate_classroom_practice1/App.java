package com.bellinfo.hibernate.hibernate_classroom_practice1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;



/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        MobilePhone mp1 = new MobilePhone("Samsung","s8", 800.00, 8);
        MobilePhone mp2 = new MobilePhone("iphone","s7", 900.00, 8);
        MobilePhone mp3 = new MobilePhone("Lenovo","v6", 600.00, 8);
        MobilePhone mp4 = new MobilePhone("Motorola","Play", 500.00, 8);
        MobilePhone mp5 = new MobilePhone("Google","pixcel", 849.00, 8);
        
        Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();
        
        
        Integer id1 = (Integer)session.save(mp1);
        Integer id2= (Integer)session.save(mp2);
        Integer id3 = (Integer)session.save(mp3);
        Integer id4 = (Integer)session.save(mp4);
        Integer id5 = (Integer)session.save(mp5);
        System.out.println("id value :"+id1+" "+id2+" "+id3+" "+id4+" "+id5);
        transaction.commit();
        
        session.evict(mp1);
        
        session.close();
        
        sf.close();
        
    }
}
