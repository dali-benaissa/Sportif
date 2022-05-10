/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafx;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.mysql.jdbc.Connection;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
 import java.io.IOException;
import java.net.URL;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import org.apache.commons.lang3.StringUtils;
import services.ServiceRegime;

/**
 *
 * @author 21621
 */
public class DemoregimeController implements Initializable{
    
    private Stage stage;
    private Scene scene;
    private Parent root;
    
    
    int index = -1 ;
      
    ServiceRegime s = new ServiceRegime();
    
    
  

    @FXML
    private Button btnexercice;

    @FXML
    private Label labelautorises;

    @FXML
    private Label labelinterdit;

    @FXML
    private Label labelpetit;

    @FXML
    private Label labelcollation1;

    @FXML
    private Label labeldejeuner;

    @FXML
    private Label labelcollation2;

    @FXML
    private Label labeldiner;

    @FXML
    private Label labelconseils;

    @FXML
    private TextField tfautorises;

    @FXML
    private TextField tfinterdit;

    @FXML
    private TextField tfpetit;

    @FXML
    private TextField tfcollation1;

    @FXML
    private TextField tfdejeuner;

    @FXML
    private TextField tfcollation2;

    @FXML
    private TextField tfdiner;

    @FXML
    private TextField tfconseils;

    @FXML
    private TableView<Booksregime> tvBooksregime;

    @FXML
    private TableColumn<Booksregime, String> colautorises;

    @FXML
    private TableColumn<Booksregime, String> colinterdit;

    @FXML
    private TableColumn<Booksregime, String> colpetit;

    @FXML
    private TableColumn<Booksregime, String> colcollation1;

    @FXML
    private TableColumn<Booksregime, String> coldejeuner;

    @FXML
    private TableColumn<Booksregime, String> colcollation2;

    @FXML
    private TableColumn<Booksregime, String> coldiner;

    @FXML
    private TableColumn<Booksregime, String> colconseils;

    @FXML
    private Button btninsert;

    @FXML
    private Button btndelete;

    @FXML
    private Button btnupdate;

    @FXML
    private Button btnrecherche;

    @FXML
    private TextField tfrecherche;
    
    private Booksregime selectedBookregime ;
    private ObservableList<Booksregime> bookList  ;
    /** 
     * Initializes the controller class.
     */
    
    


    
 

    @FXML



    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        showBooksregime(null);
            
        
   
    }
    
      public void switchtoexercice(ActionEvent event) throws IOException{
               
             root = FXMLLoader.load(getClass().getResource("/javafx/DemoCRUD.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
          scene = new Scene(root);
        
     scene.getStylesheets().add(getClass().getResource("/styles/Styles.css").toExternalForm());
      
        
       stage.setScene(scene);
        stage.show();
           }
    
          public void switchtoImc(ActionEvent event) throws IOException{
               
             root = FXMLLoader.load(getClass().getResource("/javafx/Imc.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
          scene = new Scene(root);
        
     scene.getStylesheets().add(getClass().getResource("/styles/Styles.css").toExternalForm());
      
        
       stage.setScene(scene);
        stage.show();
           }
      
      
        @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
         if(event.getSource() == btninsert){
            insertRecord();
        }else if (event.getSource() == btnupdate){
            
                updateRecord();
    }else if(event.getSource() == btndelete){
        deleteButton(); 
    }
         
    }
    
    
     public Connection getConnection(){
            Connection conn;
            try{
                conn = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/sportifa", "root","");
                return conn;
                
            }catch(Exception ex){
                System.out.println("Error : "+ex.getMessage());
                return null;
            
            }
        
    }
     
         
    public ObservableList<Booksregime> getBookList(){  
        bookList = FXCollections.observableArrayList();
        Connection conn = getConnection();
        String query = "SELECT * FROM booksregime";
         Statement st;
         ResultSet rs; 
         
         try{
         st = conn.createStatement();
         rs = st.executeQuery(query);
        Booksregime booksregime;
       // bookList.removeAll(bookList);
        while(rs.next()){
            booksregime = new Booksregime(rs.getInt("id"),rs.getString("aliments_autorises"), rs.getString("aliments_interdits"), rs.getString("petit_dejeuner"), rs.getString("collation1"), rs.getString("dejeuner"), rs.getString("collation2"), rs.getString("diner"), rs.getString("conseils"));
            bookList.add(booksregime);
            System.out.println("from showbook "+booksregime.getId());
        }
          
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return bookList;
        
    
    }
   
      public void showBooksregime(String cher){
       ObservableList<Booksregime> list  ; 
        if(cher != null){
         list = getBookListFromSearch(cher); 
        }
        else{
           list = getBookList();
        }
         
         
         colautorises.setCellValueFactory(new PropertyValueFactory<Booksregime, String>("aliments_autorises"));
         colinterdit.setCellValueFactory(new PropertyValueFactory<Booksregime, String>("aliments_interdits"));
         colpetit.setCellValueFactory(new PropertyValueFactory<Booksregime, String>("petit_dejeuner"));
         colcollation1.setCellValueFactory(new PropertyValueFactory<Booksregime, String>("collation1"));
         coldejeuner.setCellValueFactory(new PropertyValueFactory<Booksregime, String>("dejeuner"));
         colcollation2.setCellValueFactory(new PropertyValueFactory<Booksregime, String>("collation2"));
         coldiner.setCellValueFactory(new PropertyValueFactory<Booksregime, String>("diner"));
         colconseils.setCellValueFactory(new PropertyValueFactory<Booksregime, String>("conseils"));

         
         tvBooksregime.setItems(list);
         
    }
     
          private void insertRecord(){
              if (tfautorises.getText().length()== 0 || tfcollation1.getText().length() == 0 ||  tfcollation2.getText().length() == 0 || tfconseils.getText().length() == 0 || tfdejeuner.getText().length() == 0 || tfdiner.getText().length() == 0 || tfinterdit.getText().length() == 0 || tfpetit.getText().length() == 0){
            
              JOptionPane.showMessageDialog(null, "Elément Vide!"); 
                                  clear(); 

        }
              else{
        String query = "INSERT INTO booksregime (aliments_autorises,aliments_interdits,petit_dejeuner,collation1,dejeuner,collation2,diner,conseils)  VALUES ('" + tfautorises.getText() + "','" + tfinterdit.getText() + "','" + tfpetit.getText() + "','" + tfcollation1.getText() + "','" + tfdejeuner.getText() + "','" + tfcollation2.getText() + "','" + tfdiner.getText() + "','"
                            + tfconseils.getText() + "')";
        
        System.out.println(query);
        executeQuery(query);
        
        JOptionPane.showMessageDialog(null, "regime ajouter avec succés"); 
        showBooksregime(null);
                    clear();

    }
          }
          
              private void updateRecord(){
        if(selectedBookregime != null){
               String query = "UPDATE booksregime SET aliments_autorises = '" + tfautorises.getText() + "', aliments_interdits = '" + tfinterdit.getText() + "', petit_dejeuner = '" 
                            + tfpetit.getText() + "', collation1 = '" + tfcollation1.getText() + "', dejeuner ='" + tfdejeuner.getText() + "', collation2 ='" + tfcollation2.getText() + "', diner = '" + tfdiner.getText() + "', conseils = '" + tfconseils.getText() +  "' WHERE id = " + selectedBookregime.getId();
             
     System.out.println(query);
        executeQuery(query);
        showBooksregime(null);  
        
        clear();
        }

    }
              
             private void clear(){
          tfautorises.setText(StringUtils.EMPTY);
          tfinterdit.setText(StringUtils.EMPTY);
          tfpetit.setText(StringUtils.EMPTY);
          tfcollation1.setText(StringUtils.EMPTY);
          tfcollation2.setText(StringUtils.EMPTY);
          tfdiner.setText(StringUtils.EMPTY);
          tfconseils.setText(StringUtils.EMPTY);
          tfdejeuner.setText(StringUtils.EMPTY);

          selectedBookregime = null;
                 showBooksregime(null);
    }
             
             
              private void  deleteButton(){
        if(selectedBookregime != null) {
             
         String query = "DELETE FROM booksregime WHERE id =" + selectedBookregime.getId() ;
         System.out.println(query);
        executeQuery(query);
        showBooksregime(null); 
        
         
        
            clear();
        }
       
    }   
    
           private List<String> searchList(String tvBooksregime, List<String> listOfStrings) {

        List<String> searchWordsArray = Arrays.asList(tvBooksregime.trim().split(" "));

        return listOfStrings.stream().filter(input -> {
            return searchWordsArray.stream().allMatch(word ->
                    input.toLowerCase().contains(word.toLowerCase()));
        }).collect(Collectors.toList());
    }
           
           
           
                @FXML
   private  void getSelected (MouseEvent event) {
         //index = tvBooksregime.getSelectionModel().getSelectedIndex();
           selectedBookregime = tvBooksregime.getSelectionModel().getSelectedItem();
         if (selectedBookregime == null){
             System.out.println("regime is nulll");
             return; 
         }
                      System.out.println("regime is not nulll "+selectedBookregime.getPetit_dejeuner());

         tfautorises.setText(selectedBookregime.getAliments_autorises());
          tfinterdit.setText(selectedBookregime.getAliments_interdits());
          tfpetit.setText(selectedBookregime.getPetit_dejeuner());
          tfcollation1.setText(selectedBookregime.getCollation1());
          tfdejeuner.setText(selectedBookregime.getDejeuner());
          tfcollation2.setText(selectedBookregime.getCollation2());
          tfdiner.setText(selectedBookregime.getDiner());
          tfconseils.setText(selectedBookregime.getConseils());

           System.out.println("Aliment_autorises "+selectedBookregime.getAliments_autorises()+" ++++ id  "+selectedBookregime.getId());
        
     }
   
      private void executeQuery(String query) {
        Connection conn = getConnection();
        Statement st;
        try{
            
            st = conn.createStatement();
            st.executeUpdate(query);
        }catch(Exception ex){
             ex.printStackTrace();
        }
     }
      
      
       @FXML
    private void rech(ActionEvent event) {
      String cher =  tfrecherche.getText();
        if(! bookList.isEmpty() && cher != null){
            showBooksregime(cher);
        }
        else{
            showBooksregime(null);
        }
        
    }
    
   
    private ObservableList<Booksregime> getBookListFromSearch(String cher){  
        return 
                      bookList.stream().filter(b->(b.getAliments_autorises().toLowerCase().contains(cher.toLowerCase())||b.getAliments_interdits().toLowerCase().contains(cher.toLowerCase())||b.getPetit_dejeuner().toLowerCase().contains(cher.toLowerCase())||b.getCollation1().toLowerCase().contains(cher.toLowerCase())||b.getDejeuner().toLowerCase().contains(cher.toLowerCase())||b.getCollation2().toLowerCase().contains(cher.toLowerCase())||b.getDiner().toLowerCase().contains(cher.toLowerCase()) 
                    || b.getConseils().toLowerCase().contains(cher.toLowerCase()))).collect(Collectors.toCollection(FXCollections::observableArrayList));
       
    }
    
    @FXML
    private void reset(ActionEvent event) throws DocumentException, SQLException, ClassNotFoundException {
        
    
    clear();
 
       tfrecherche.setText(StringUtils.EMPTY);
             ObservableList<Booksregime> list = FXCollections.observableArrayList(); 
             
             
              
       }   

         
        @FXML
    private void imprimer(ActionEvent event) throws DocumentException, SQLException, ClassNotFoundException {
        
         try {
       Class.forName("com.mysql.jdbc.Driver");
     Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/sportifa", "root","");
      PreparedStatement pt = con.prepareStatement("select * from booksregime");
            ResultSet rs = pt.executeQuery();
            
                       /* Step-2: Initialize PDF documents - logical objects */

                       Document my_pdf_report = new Document();
                       //OutputStream file = new FileOutputStream(new File("ProductReport.pdf"));
                    
                       my_pdf_report.open();  
                       my_pdf_report.add(new Paragraph(new Date().toString())); 
                       my_pdf_report.add(new Paragraph("Match Up"));
                       my_pdf_report.add(new Paragraph("Listes des Regime"));

                       PdfWriter.getInstance(my_pdf_report, new FileOutputStream("pdf_report_from_sql_using_java.pdf"));
                       
                        my_pdf_report.open();  
                       my_pdf_report.add(new Paragraph(new Date().toString()));
//                            Image img = Image.getInstance("c:/6.png");
//                            my_pdf_report.add(img);
                       my_pdf_report.add(new Paragraph("Listes des Regime"));
                             //Add Image
//		       Image image1 = Image.getInstance("filmouk.png");
//                       image1.scaleAbsolute(210, 210);
//                       my_pdf_report.add(image1);
                       my_pdf_report.addCreationDate();
              
                       
                       //we have four columns in our table
                       PdfPTable my_report_table = new PdfPTable(8);
                       my_report_table.setWidthPercentage(100); //Width 100%
			my_report_table.setSpacingBefore(10f); //Space before table
			my_report_table.setSpacingAfter(10f); //Space after table
 

                             
                       //create a cell object
                       PdfPCell table_cell;
                       
                       
                                       table_cell=new PdfPCell(new Phrase(" aliments_autorises"));
                                      table_cell.setBackgroundColor(BaseColor.GREEN);
                                       my_report_table.addCell(table_cell);
                                       table_cell=new PdfPCell(new Phrase("aliments_interdits"));
                                       table_cell.setBackgroundColor(BaseColor.YELLOW);
                                       my_report_table.addCell(table_cell);
                                       table_cell=new PdfPCell(new Phrase("petit_dejeuner"));
                                       table_cell.setBackgroundColor(BaseColor.YELLOW);
                                       my_report_table.addCell(table_cell);
                                          table_cell=new PdfPCell(new Phrase(" collation1"));
                                      table_cell.setBackgroundColor(BaseColor.YELLOW);
                                       my_report_table.addCell(table_cell); 
                                       table_cell=new PdfPCell(new Phrase(" dejeuner"));
                                      table_cell.setBackgroundColor(BaseColor.YELLOW);
                                       my_report_table.addCell(table_cell);
                                          table_cell=new PdfPCell(new Phrase(" collation2"));
                                      table_cell.setBackgroundColor(BaseColor.YELLOW);
                                       my_report_table.addCell(table_cell);
                                          table_cell=new PdfPCell(new Phrase(" diner"));
                                      table_cell.setBackgroundColor(BaseColor.YELLOW);
                                       my_report_table.addCell(table_cell);
                                          table_cell=new PdfPCell(new Phrase(" conseils"));
                                      table_cell.setBackgroundColor(BaseColor.CYAN);
                                       my_report_table.addCell(table_cell);
                                       

                                      while(rs.next()){
                                      
                                       String aliments_autorises= rs.getString("aliments_autorises");
                                       table_cell=new PdfPCell(new Phrase(aliments_autorises));
                                       my_report_table.addCell(table_cell);
                                       
                                       String aliments_interdits=rs.getString("aliments_interdits");
                                       table_cell=new PdfPCell(new Phrase(aliments_interdits));
                                       my_report_table.addCell(table_cell);
                                       
                                       String petit_dejeuner=rs.getString("petit_dejeuner");
                                       table_cell=new PdfPCell(new Phrase(petit_dejeuner));
                                       my_report_table.addCell(table_cell);
                                                 
                                       String collation1= rs.getString("collation1");
                                       table_cell=new PdfPCell(new Phrase(collation1));
                                       my_report_table.addCell(table_cell);
                                                 
                                       String dejeuner= rs.getString("dejeuner");
                                       table_cell=new PdfPCell(new Phrase(dejeuner));
                                       my_report_table.addCell(table_cell);
                                                 
                                       String collation2= rs.getString("collation2");
                                       table_cell=new PdfPCell(new Phrase(collation2));
                                       my_report_table.addCell(table_cell);
                                                 
                                       String diner= rs.getString("diner");
                                       table_cell=new PdfPCell(new Phrase(diner));
                                       my_report_table.addCell(table_cell);
                                                 
                                       String conseils= rs.getString("conseils");
                                       table_cell=new PdfPCell(new Phrase(conseils));
                                       my_report_table.addCell(table_cell);
                                       
                                      
                       }
                       /* Attach report table to PDF */
                       
                       my_pdf_report.add(my_report_table); 
                       
             System.out.println(my_pdf_report);
                       my_pdf_report.close();
                       JOptionPane.showMessageDialog(null, "imprimer avec succes");

                       /* Close all DB related objects */
                       rs.close();
                       pt.close(); 
                       con.close();               


       } catch (FileNotFoundException e) {
       // TODO Auto-generated catch block
       e.printStackTrace();
   
          
       }
            
  
     }
    
    
    
    
    
    
//     //@FXML
//     private void calc(ActionEvent event){
//         
//          int s = Integer.parseInt(tfautorises.getText()) ;
//         //   JOptionPane.showMessageDialog(this, Integer.parseInt(s));
//
//         
//     }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
    
    
   
   
   
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
        
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
 