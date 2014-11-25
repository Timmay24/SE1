package edu.haw.se1.sole.benutzerverwaltung;

public interface IBenutzerverwaltung {
    
    /**
     * @return Gibt die Instanz des aktuell angemeldeten Benutzers zurueck
     */
    public IBenutzer getCurrentUser();

}
