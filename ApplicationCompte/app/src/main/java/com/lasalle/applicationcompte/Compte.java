package com.lasalle.applicationcompte;

import android.util.Log;

public class Compte
{
    private static final String TAG = "Compte"; //!< le TAG de la classe pour les logs
    private static final double TAUX_CONVERSION_USD_EUR = 0.90;
    private static final double TAUX_CONVERSION_EUR_USD = 1.10;
    private String titulaire;
    private double solde;
    private String devise;

    public Compte(String titulaire)
    {
        this.titulaire = titulaire;
        this.solde = 0.;
        this.devise = "EUR";
    }

    public Compte(String titulaire, double solde, String devise)
    {
        this.titulaire = titulaire;
        this.solde = solde;
        this.devise = devise;
    }

    public String getTitulaire()
    {
        return this.titulaire;
    }

    public double getSolde()
    {
        return this.solde;
    }

    public String getDevise()
    {
        return this.devise;
    }

    public void crediter(double montant)
    {
        this.solde += montant;
    }

    public boolean debiter(double montant)
    {
        if(this.solde - montant >= 0)
        {
            this.solde -= montant;
            return true;
        }
        return false;
    }

    public static double convertirDollarsEuros(double montant)
    {
        return (montant * TAUX_CONVERSION_USD_EUR);
    }

    public static double convertirEurosDollars(double montant)
    {
        return (montant * TAUX_CONVERSION_EUR_USD);
    }

    public String toString()
    {
        String s = "Titulaire du compte " + this.getTitulaire() + "\nVous disposez de " + this.getSolde() + " " + this.getDevise();
        Log.d(TAG,s);
        return s;
    }

    public boolean virer(Compte compte, double montant)
    {
        Log.d(TAG,"Virement de " + montant + " " + compte.getDevise() + " vers le compte de " + compte.getTitulaire());
        if(this.devise.equals(compte.getDevise()))
        {
            this.debiter(montant);
            compte.crediter(montant);
            return true;
        }
        else if(this.getDevise().equals("USD") && compte.getDevise().equals("EUR"))
        {
            this.debiter(montant);
            compte.crediter(Compte.convertirDollarsEuros(montant));
            return true;
        }
        else if(this.getDevise().equals("EUR") && compte.getDevise().equals("USD"))
        {
            this.debiter(montant);
            compte.crediter(Compte.convertirEurosDollars(montant));
            return true;
        }
        else
        {
            Log.e(TAG,"La conversion " + this.getDevise() + "/" + compte.getDevise() + " n'est pas encore disponible !");
            return false;
        }
    }
}
