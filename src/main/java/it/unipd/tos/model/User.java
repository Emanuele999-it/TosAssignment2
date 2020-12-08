////////////////////////////////////////////////////////////////////
// [EMANUELE] [PASE] [1201250]
////////////////////////////////////////////////////////////////////

package it.unipd.tos.model;

public class User {
    String Nome, Cognome;
    int  Age;

    public User(
            String Nome, 
            String Cognome, 
            int Age) {
        /**if(Nome == null) {
            throw new IllegalArgumentException("Nome non valido");
        }*/
        if(Age <= 0) {
            throw new IllegalArgumentException("Data non valida");
        }

        this.Nome = Nome;
        this.Cognome = Cognome;
        this.Age= Age;
    }

    public String getName() {
        return Nome;
    }

    public String getSurname() {
        return Cognome;
    }

    public int getAge() {
        return Age;
    }
}