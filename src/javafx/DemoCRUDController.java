/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafx;
 
 
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.mysql.jdbc.Connection;
import javafx.scene.input.MouseEvent;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.stage.Stage;

import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import models.Exercice;
import org.apache.commons.lang3.StringUtils;
import org.codehaus.plexus.util.CollectionUtils;
import services.ServiceExercice;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author 21621
 */
public class DemoCRUDController implements Initializable {
    
    private Stage stage;
    private Scene scene;
    private Parent root;
    
    

    int index = -1 ;
      
    ServiceExercice s = new ServiceExercice();
   
    @FXML
    private TextField tfCode;
    @FXML
    private TextField tfMouvement;
    @FXML
    private TextField tfDescription;
    @FXML
    private TableView<Books> tvBooks;
    @FXML
    private TableColumn<Books, String> colCode;
    @FXML
    private TableColumn<Books, String> colMouvement;
    @FXML
    private TableColumn<Books, String> colDescription;
    @FXML
    private Button btnInsert;
    @FXML
    private Button btnDelete;
    @FXML
    private Button btnUpdate;
    @FXML
    private Button btnregime;
 
 
    @FXML
    private TextField tfId;
    @FXML
    private TextField tfRecherche;
    @FXML
    private Button btnRecherche;

    private Books selectedBook ;
    private ObservableList<Books> bookList ;
    /** 
     * Initializes the controller class.
     */
    
        
  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
            
        showBooks(null);
       
   
    }
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
         if(event.getSource() == btnInsert){
            insertRecord();
        }else if (event.getSource() == btnUpdate){
            
                updateRecord();
    }else if(event.getSource() == btnDelete){
        deleteButton(); 
    }
         
        
    }
    
    
        @FXML
            public void switchtoregime(ActionEvent event) throws IOException{
               
                    root = FXMLLoader.load(getClass().getResource("/javafx/Demoregime.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                scene = new Scene(root);
        
   //  scene.getStylesheets().add(getClass().getResource("/styles/Styles.css").toExternalForm());
      
        stage.setScene(scene);
        stage.show();
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
    
    public ObservableList<Books> getBookList(){  
         bookList = FXCollections.observableArrayList();
        Connection conn = getConnection();
        String query = "SELECT * FROM books";
         Statement st;
         ResultSet rs;
         
         try{
         st = conn.createStatement();
         rs = st.executeQuery(query);
        Books books;
       // bookList.removeAll(bookList);
        while(rs.next()){
            books = new Books(rs.getInt("id"), rs.getString("code_exercice"), rs.getString("mouvement"), rs.getString("description"));
            bookList.add(books);
        }
          
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return bookList;
        
    
    }
    
    public void showBooks(String cher){
       ObservableList<Books> list  ; 
        if(cher != null){
         list = getBookListFromSearch(cher); 
        }
        else{
           list = getBookList();
        }
         
         
         colCode.setCellValueFactory(new PropertyValueFactory<Books, String>("code_exercice"));
         colMouvement.setCellValueFactory(new PropertyValueFactory<Books, String>("mouvement"));
         colDescription.setCellValueFactory(new PropertyValueFactory<Books, String>("description"));

         
         tvBooks.setItems(list);
         
    }
    private void insertRecord(){
        if (tfCode.getText().length()== 0 || tfMouvement.getText().length() == 0 ||  tfDescription.getText().length() == 0){
            
              JOptionPane.showMessageDialog(null, "Elément Vide!");
                                  clear();  

        }
        else{
        String query = "INSERT INTO books (code_exercice,mouvement,description)  VALUES ('" + tfCode.getText() + "','" + tfDescription.getText() + "','"
                            + tfMouvement.getText() + "')";
        
        System.out.println(query);
        executeQuery(query);
        
        JOptionPane.showMessageDialog(null, "exercice ajouter avec succés");
        showBooks(null);
        
        
        
        
        
                    clear();
        }
    }
 
    private void updateRecord(){
        if(selectedBook != null){
               String query = "UPDATE books SET code_exercice = '" + tfCode.getText() + "', description = '" + tfDescription.getText() + "', mouvement = '" 
                            + tfMouvement.getText() + "' WHERE id = " + selectedBook.getId();
             
     System.out.println(query);
        executeQuery(query);
        showBooks(null);  
        
        clear();
        }

    }
    private void clear(){
          tfCode.setText(StringUtils.EMPTY);
          tfMouvement.setText(StringUtils.EMPTY);
          tfDescription.setText(StringUtils.EMPTY);
          selectedBook = null;
          showBooks(null);
    }
    
    private void  deleteButton(){
        if(selectedBook != null) {
         String query = "DELETE FROM books WHERE id =" + selectedBook.getId() ;
         System.out.println(query);
        executeQuery(query);
        showBooks(null);
            clear();
        }
       
    }
    
    
  
   // 
    
     private List<String> searchList(String tvBooks, List<String> listOfStrings) {

        List<String> searchWordsArray = Arrays.asList(tvBooks.trim().split(" "));

        return listOfStrings.stream().filter(input -> {
            return searchWordsArray.stream().allMatch(word ->
                    input.toLowerCase().contains(word.toLowerCase()));
        }).collect(Collectors.toList());
    }
     
       @FXML
   private  void getSelected (MouseEvent event) {
         //index = tvBooks.getSelectionModel().getSelectedIndex();
           selectedBook = tvBooks.getSelectionModel().getSelectedItem();
         if (selectedBook == null){
             
             return; 
         }
         tfCode.setText(selectedBook.getCode_exercice());
          tfMouvement.setText(selectedBook.getMouvement());
          tfDescription.setText(selectedBook.getDescription());
           System.out.println("code "+selectedBook.getCode_exercice()+" ++++ id  "+selectedBook.getId());
         
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
    private void imprimer(ActionEvent event) throws DocumentException, SQLException, ClassNotFoundException {
        
         try {
       Class.forName("com.mysql.jdbc.Driver");
     Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/sportifa", "root","");
      PreparedStatement pt = con.prepareStatement("select * from books");
            ResultSet rs = pt.executeQuery();
            
                       /* Step-2: Initialize PDF documents - logical objects */

                       Document my_pdf_report = new Document();
                       //OutputStream file = new FileOutputStream(new File("ProductReport.pdf"));
                    
                       my_pdf_report.open();  
                       my_pdf_report.add(new Paragraph(new Date().toString())); 
                       my_pdf_report.add(new Paragraph("Match Up"));
                       my_pdf_report.add(new Paragraph("Listes des Exercices"));

                       PdfWriter.getInstance(my_pdf_report, new FileOutputStream("pdf_report_from_sql_using_java.pdf"));
                       
                        my_pdf_report.open();  
                       my_pdf_report.add(new Paragraph(new Date().toString()));
//                            Image img = Image.getInstance("c:/6.png");
//                            my_pdf_report.add(img);
                       my_pdf_report.add(new Paragraph("Listes des Exercices"));
                             //Add Image
//		       Image image1 = Image.getInstance("filmouk.png");
//                       image1.scaleAbsolute(210, 210);
//                       my_pdf_report.add(image1);
                       my_pdf_report.addCreationDate();
              
                       
                       //we have four columns in our table
                       PdfPTable my_report_table = new PdfPTable(3);
                       my_report_table.setWidthPercentage(100); //Width 100%
			my_report_table.setSpacingBefore(10f); //Space before table
			my_report_table.setSpacingAfter(10f); //Space after table
                             
                       //create a cell object
                       PdfPCell table_cell;
                       
                       
                                       table_cell=new PdfPCell(new Phrase(" code_exercice"));
                                      table_cell.setBackgroundColor(BaseColor.YELLOW);
                                       my_report_table.addCell(table_cell);
                                       table_cell=new PdfPCell(new Phrase("mouvement"));
                                       table_cell.setBackgroundColor(BaseColor.GREEN);
                                       my_report_table.addCell(table_cell);
                                       table_cell=new PdfPCell(new Phrase("description"));
                                       table_cell.setBackgroundColor(BaseColor.GREEN);
                                       my_report_table.addCell(table_cell);
                                       

                                      while(rs.next()){
                                      
                                       String code_exercice= rs.getString("code_exercice");
                                       table_cell=new PdfPCell(new Phrase(code_exercice));
                                       my_report_table.addCell(table_cell);
                                       
                                       String mouvement=rs.getString("mouvement");
                                       table_cell=new PdfPCell(new Phrase(mouvement));
                                       my_report_table.addCell(table_cell);
                                       
                                       String description=rs.getString("description");
                                       table_cell=new PdfPCell(new Phrase(description));
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

    @FXML
    private void rech(ActionEvent event) {
      String cher =  tfRecherche.getText();
        if(! bookList.isEmpty() && cher != null){
            showBooks(cher);
        }
        else{
            showBooks(null);
        }
        
    }
    
   
    private ObservableList<Books> getBookListFromSearch(String cher){  
        return 
                      bookList.stream().filter(b->(b.getCode_exercice().toLowerCase().contains(cher.toLowerCase())||b.getDescription().toLowerCase().contains(cher.toLowerCase()) 
                    || b.getMouvement().toLowerCase().contains(cher.toLowerCase()))).collect(Collectors.toCollection(FXCollections::observableArrayList));
       
    }
    
    @FXML
    private void reset(ActionEvent event) throws DocumentException, SQLException, ClassNotFoundException {
        
    
    clear();
 
       tfRecherche.setText(StringUtils.EMPTY);
             ObservableList<Books> list = FXCollections.observableArrayList(); 

   
     }
    
}

 
    
    
   

