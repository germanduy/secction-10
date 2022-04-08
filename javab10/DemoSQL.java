package javab10;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.*;

public class DemoSQL extends Application {
    //Tao cac string ket noi
    public final static String connectionString = "jdbc:mysql://localhost:3306/t2108m";
    public final static String user = "root" ;
    public final static String password = "" ;

    public static ObservableList<javab10.Person> personList = FXCollections.observableArrayList();


    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("list.fxml"));
        primaryStage.setTitle("T2108M");
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }

    public static void main(String args[]){
        try{
            // goi drive
            Class.forName("com.mysql.jdbc.Driver");
            //tao connect
            Connection conn = DriverManager.getConnection(connectionString,user,password);
            //khai bao Statement de truy van sql
            Statement stt = conn.createStatement();

//            String insert_sql = "insert into persons(fullname,email,age) values('duy1','duy1','22')";
//            stt.execute(insert_sql);

            //truy van sql
            String txt_sql = "select * from persons";
            ResultSet rs = stt.executeQuery(txt_sql);

            while (rs.next()){
//                System.out.println(rs);
                personList.add(new Person(rs.getString("fullname"),rs.getString("email"),rs.getInt("age")));
            }
            launch(args);
        }catch (Exception e){
            System.out.println("Error");
        }
    }
}
