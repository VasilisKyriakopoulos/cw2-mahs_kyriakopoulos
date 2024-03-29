package gr.uop;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import jdk.internal.joptsimple.util.RegexMatcher;


/**
 * JavaFX App
 */
public class App extends Application {
    
    TextField search = new TextField();
    ListView  list = new ListView<Text>();
    ArrayList<Text>  arrList = new ArrayList<Text>();
    ListView  list2 = new ListView<Text>();
    @Override
    public void start(Stage stage) {
        
        try 
        {
        VBox  vbox = new VBox();
        
        list.setPrefHeight(Integer.MAX_VALUE);
        list.setMaxWidth(200);
        vbox.getChildren().addAll(search,list);
        vbox.setAlignment(Pos.CENTER);
        vbox.setSpacing(10);
        vbox.setPadding(new Insets(10,10,50,10));
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
        list2.setPrefHeight(Integer.MAX_VALUE);
        list2.setMaxWidth(200);
        vbox2.getChildren().addAll(list2);
        vbox2.setAlignment(Pos.CENTER);
        vbox2.setSpacing(10);
        vbox2.setPadding(new Insets(50,10,50,10));
        hbox.getChildren().addAll(vbox,buttonsRightLeft,vbox2,buttonsUpDown);
        hbox.setAlignment(Pos.CENTER);
         
         for(int i=0 ; i<50 ; i++){
            arrList.add(new Text("Item "+ i));
         }
         list.getItems().addAll(arrList);
         buttonRight.setOnAction(new MoveToRightList());
         buttonLeft.setOnAction(new MoveToLeftList());
         buttonUp.setOnAction(new MoveUpToList());
         buttonDown.setOnAction(new MoveDownToList());
         search.setOnAction(new Search());
         search.setOnKeyTyped(e -> {
            list.getItems().clear();
            String text = search.getText();
            for(Text item : arrList){
                String text2 = item.getText();
                boolean flag = Pattern.compile(text).matcher(text2).find();
                if(flag){
                    list.getItems().add(new Text(text2));
                }
            }

         });
        var scene = new Scene(hbox, 640, 480);
        stage.setMinHeight(300);
        stage.setMinWidth(300);
        stage.setTitle("Lists");
        stage.setScene(scene);
        stage.show();
        }
         catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
    
    }
    public class MoveToRightList implements EventHandler <ActionEvent>{
        
        public void handle(ActionEvent event){
            int index = list.getSelectionModel().getSelectedIndex();
            Text text = (Text) list.getSelectionModel().getSelectedItem();
            list2.getItems().add(text);
            list.getItems().remove(index);
            
        }
    }
    public class MoveToLeftList implements EventHandler <ActionEvent>{
        
        public void handle(ActionEvent event){
            int index = list2.getSelectionModel().getSelectedIndex();
            Text text = (Text) list2.getSelectionModel().getSelectedItem();
            list.getItems().add(text);
            list2.getItems().remove(index);
            
        }
    }
    public class MoveUpToList implements EventHandler <ActionEvent>{
        
        public void handle(ActionEvent event){
            int i = list2.getSelectionModel().getSelectedIndex();
            if(i>0){
            
                Text text = (Text)list2.getItems().get(i);
                list2.getItems().add(i-1, text);
                list2.getItems().remove(i+1);  
            }
        }
      
    }
    
    public class MoveDownToList implements EventHandler <ActionEvent>{
        
        public void handle(ActionEvent event){
            int i = list2.getSelectionModel().getSelectedIndex();
            int count = list2.getItems().size();
            if( i!=-1 && i < count -1 ){
            
                Text text = (Text)list2.getItems().get(i);
                list2.getItems().remove(i);
                list2.getItems().add(i+1, text);
                //h parakatw entoli epanaferei to epilegmeno stoixeio stin arxiki epilogi
                list2.getSelectionModel().select(i);  
                
            }
        }
    }
    
    public class Search implements EventHandler <ActionEvent>{
        
        public void handle(ActionEvent event){
            
            list.getItems().clear();
            String text = search.getText();
            for(Text item : arrList){
                String text2 = item.getText();
                boolean flag = Pattern.compile(text).matcher(text2).find();
                if(flag){
                    list.getItems().add(new Text(text2));
                }
            }
        }
      
    }
    public static void main(String[] args) {
        launch(args);
    }

}