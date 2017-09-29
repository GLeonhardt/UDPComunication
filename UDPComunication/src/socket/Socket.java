package socket;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Guilherme Leonhardt
 */
public class Socket extends Application {
    public static InterfaceController controller;
    
    @Override
    public void start(Stage stage) throws Exception {
        
        FXMLLoader  fxmlLoader = new FXMLLoader(getClass().getResource("Interface.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        controller = (InterfaceController)fxmlLoader.getController();
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
