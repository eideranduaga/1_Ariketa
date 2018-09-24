/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author DM3-2-05
 */
public class Person
{
    // Define the members
    private String izena;
    private String abizena;
    private String emaila;
    private String telefonoa;
    
    // Define the constructor
    public Person(String iz, String ab, String em, String tlf)
    {
        izena = iz;
        abizena = ab;
        emaila = em;
        telefonoa = tlf;
    }
    
    // Define the setters
    public void setIzena(String iz)
    {
        izena = iz;
    }
    
    public void setAbizena(String ab)
    {
        abizena = ab;
    }
    
    public void setEmaila(String em)
    {
        emaila = em;
    }
    
    public void setTelefonoa(String tlf)
    {
        telefonoa = tlf;
    }
    
    // Define the getters
    public String getIzena()
    {
        return izena;
    }
    
    public String getAbizena()
    {
        return abizena;
    }
    
    public String getEmaila()
    {
        return emaila;
    }
    
    public String getTelefonoa()
    {
        return telefonoa;
    }
}
