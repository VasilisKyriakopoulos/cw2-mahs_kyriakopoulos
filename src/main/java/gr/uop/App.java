package gr.uop;

import java.io.FileInputStream;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        
        try 
        {
        VBox  vbox = new VBox();
        TextField search = new TextField();
        ListView  list = new ListView<Text>();
        list.maxHeight(Double.MAX_VALUE);
        list.setMaxWidth(150);
        vbox.getChildren().addAll(search,list);
        vbox.setAlignment(Pos.CENTER);
        vbox.setSpacing(10);
        vbox.setPadding(new Insets(10,10,50,10));
        vbox.maxHeight(Double.MAX_VALUE);
        HBox hbox = new HBox();
        ImageView rightImageView = new ImageView(new Image(getClass().getResourceAsStream("images/right.png")));
        ImageView leftImageView = new ImageView(new Image(getClass().getResourceAsStream("images/left.png")));
        ImageView upImageView = new ImageView(new Image(getClass().getResourceAsStream("images/up.png")));
        ImageView downImageView = new ImageView(new Image(getClass().getResourceAsStream("images/down.png")));
        Button buttonRight = new Button("",rightImageView);
        Button buttonLeft = new Button("",leftImageView);
        Button buttonUp = new Button("",upImageView);
        Button buttonDown = new Button("",downImageView);

        VBox buttonsRightLeft = new VBox();
        buttonsRightLeft.getChildren().addAll(buttonRight,buttonLeft);
        buttonsRightLeft.setAlignment(Pos.CENTER);
        VBox buttonsUpDown = new VBox();
        buttonsUpDown.getChildren().addAll(buttonUp,buttonDown);
        buttonsUpDown.setAlignment(Pos.CENTER);
        VBox  vbox2 = new VBox();
        ListView  list2 = new ListView<Text>();
        list2.setMaxWidth(150);
        vbox2.getChildren().addAll(list2);
        vbox2.setAlignment(Pos.CENTER);
        vbox2.setSpacing(10);
        vbox2.setPadding(new Insets(50,10,50,10));
        hbox.getChildren().addAll(vbox,buttonsRightLeft,vbox2,buttonsUpDown);
        hbox.setAlignment(Pos.CENTER);
        var scene = new Scene(hbox, 640, 480);
        stage.setTitle("Lists");
        stage.setScene(scene);
        stage.show();
        }
         catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
    
    }

    public static void main(String[] args) {
        launch(args);
    }

}