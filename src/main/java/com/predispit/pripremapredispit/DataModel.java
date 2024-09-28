package com.predispit.pripremapredispit;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class DataModel {
    private final StringProperty id;
    private final StringProperty naziv;
    private final StringProperty kolicina;
    private final StringProperty datum;
    private final StringProperty vrsta;

    public DataModel(String id, String naziv, String kolicina, String datum, String vrsta) {
        this.id = new SimpleStringProperty(id);
        this.naziv = new SimpleStringProperty(naziv);
        this.kolicina = new SimpleStringProperty(kolicina);
        this.datum = new SimpleStringProperty(datum);
        this.vrsta = new SimpleStringProperty(vrsta);
    }

    public String getId() {
        return id.get();
    }

    public StringProperty idProperty() {
        return id;
    }

    public String getNaziv() {
        return naziv.get();
    }

    public StringProperty nazivProperty() {
        return naziv;
    }

    public String getKolicina() {
        return kolicina.get();
    }

    public StringProperty kolicinaProperty() {
        return kolicina;
    }

    public String getDatum() {
        return datum.get();
    }

    public StringProperty datumProperty() {
        return datum;
    }

    public String getVrsta() {
        return vrsta.get();
    }

    public StringProperty vrstaProperty() {
        return vrsta;
    }
}