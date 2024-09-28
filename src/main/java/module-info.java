module com.predispit.pripremapredispit {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;

    opens com.predispit.pripremapredispit to javafx.fxml;
    exports com.predispit.pripremapredispit;
}