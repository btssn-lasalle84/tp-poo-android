package com.lasalle.applicationcompte;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class TestCompteAccesseurs
{
    @Test
    public void testGetSolde()
    {
        Compte compte1 = new Compte("Moi");
        Compte compte2 = new Compte("Bill Gates", 105300000000., "USD");
        Compte compte3 = new Compte("Maria", 1000., "YEN");
        assertEquals(0, compte1.getSolde(), 0.001);
        assertEquals(105300000000., compte2.getSolde(), 0.001);
        assertEquals(1000, compte3.getSolde(), 0.001);
    }

    @Test
    public void testGetTitulaire()
    {
        Compte compte1 = new Compte("Moi");
        Compte compte2 = new Compte("Bill Gates", 105300000000., "USD");
        Compte compte3 = new Compte("Maria", 1000., "YEN");
        assertEquals("Moi", compte1.getTitulaire());
        assertEquals("Bill Gates", compte2.getTitulaire());
        assertEquals("Maria", compte3.getTitulaire());
    }

    @Test
    public void testGetDevise()
    {
        Compte compte1 = new Compte("Moi");
        Compte compte2 = new Compte("Bill Gates", 105300000000., "USD");
        Compte compte3 = new Compte("Maria", 1000., "YEN");
        assertEquals("EUR", compte1.getDevise());
        assertEquals("USD", compte2.getDevise());
        assertEquals("YEN", compte3.getDevise());
    }
}