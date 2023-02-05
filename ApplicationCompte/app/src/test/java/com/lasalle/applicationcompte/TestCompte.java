package com.lasalle.applicationcompte;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class TestCompte
{
    @Test
    public void testDeposerArgent()
    {
        Compte compte1 = new Compte("Moi");
        compte1.crediter(100.);
        assertEquals(100., compte1.getSolde(), 0.001);
    }

    @Test
    public void testRetirerArgent()
    {
        Compte compte1 = new Compte("Moi", 1000., "EUR");
        compte1.debiter(100.);
        assertEquals(900., compte1.getSolde(), 0.001);

        Compte compte2 = new Compte("Moi");
        compte2.debiter(100.);
        assertEquals(0, compte2.getSolde(), 0.001);
    }

    @Test
    public void testDeposerRetirerArgent()
    {
        Compte compte1 = new Compte("Moi");
        assertEquals(0, compte1.getSolde(), 0.001);
        compte1.crediter(1.);
        assertEquals(1, compte1.getSolde(), 0.001);
        compte1.debiter(1.);
        assertEquals(0, compte1.getSolde(), 0.001);
    }
}