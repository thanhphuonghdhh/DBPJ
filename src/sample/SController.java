package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Predicate;

public class SController implements Initializable {

    @FXML
    private TableView<Student> table;

    @FXML
    private TableColumn<Student, Integer> idCol;

    @FXML
    private TableColumn<Student, String> nameCol;

    @FXML
    private TableColumn<Student, String> addressCol;

    @FXML
    private TableColumn<Student, String> phoneCol;

    @FXML
    private TableColumn<Student, String> majorCol;

    @FXML
    private TextField idT;

    @FXML
    private TextField nameT;

    @FXML
    private TextField addressT;

    @FXML
    private TextField phoneT;

    @FXML
    private TextField majorT;

    @FXML
    private TextField search;
    private ObservableList<Student> students;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        students = FXCollections.observableArrayList(
            new Student(1,"Vu Thi Anh","0912938129","Ha Nam","Computer Science"),
            new Student(2,"Ngo Hoai Lam","093328129","Nam Dinh","Computer Science"),
            new Student(3,"Vu Van Thanh","091812923","Quang Ninh","Computer Science"),
            new Student(4,"Bui Thi An","0912384329","Ha Noi","Computer Science")
        );
        idCol.setCellValueFactory(new PropertyValueFactory<>("SID"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("Sname"));
        addressCol.setCellValueFactory(new PropertyValueFactory<>("Saddress"));
        phoneCol.setCellValueFactory(new PropertyValueFactory<>("Sphone"));
        majorCol.setCellValueFactory(new PropertyValueFactory<>("Major"));
        table.setItems(students);
        //Student student = new Student();
        FilteredList<Student> filteredList = new FilteredList<>(students, b -> true);

            search.textProperty().addListener((observableValue, oldValue, newValue) -> {
                filteredList.setPredicate(student1 -> {
                    if (newValue == null || newValue.isEmpty()) {
                        return true;
                    }
                    String l = newValue.toLowerCase();

                    if (student1.getSname().toLowerCase().indexOf(l) != -1) {
                        return true;
                    } else return false;
                });
            } );


        table.setItems(filteredList);

    }

    public void add(ActionEvent e) {
        int id = Integer.parseInt(idT.getText());
        Student student = new Student();
        student.setSID(id);
        student.setSname(nameT.getText());
        student.setSaddress(addressT.getText());
        student.setSphone(phoneT.getText());
        student.setMajor(majorT.getText());
        students.add(student);
    }

    public void delete(ActionEvent e) {
        students.remove(table.getSelectionModel().getSelectedItem());
    }

    public void returnMenu(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Sample.fxml"));
        Parent parent = null;
        try {
            parent = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(parent);
        stage.setScene(scene);
    }
}
