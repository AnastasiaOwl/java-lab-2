package pack;

import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.time.LocalDate;
import java.util.List;

public class Controller {
    @FXML
    private TextField surnameT;
    @FXML
    private TextField nameT;
    @FXML
    private TextField patronymicT;
    @FXML
    private DatePicker BirthdayT;
    @FXML
    private TextField adressT;
    @FXML
    private TextField cardNumberT;
    @FXML
    private TextField cardBalanceT;
    @FXML
    private Button AddToListT;
    @FXML
    private Button removeT;
    @FXML
    private TextField indexT;
    @FXML
    private TextArea List;
    @FXML
    private TextArea ListR;
    @FXML
    private TextArea ListName;
    @FXML
    private TextArea ListCardNumber;
    @FXML
    private TextField searchNameT;
    @FXML
    private TextField cardNumberFromT;
    @FXML
    private TextField cardNumberToT;
    @FXML
    private Button searchNameB;
    @FXML
    private Button searchCardNumberT;
    @FXML
    private Button debt;
    @FXML
    private TextArea ListDebt;
    @FXML
    private TextArea qCardBalanceT;
    @FXML
    private Button sort;
    @FXML
    private TextArea SortT;
    @FXML
    private TextArea sortYear;
    @FXML
    private Button YearS;
    @FXML
    private Button YearBalance;
    @FXML
    private TextArea YearBalanceT;



    @FXML
    void ToList (){
        Logic logic = new Logic();
        AddToListT.setOnAction(event -> {
            boolean success = true;
            String addSurname = null;
            String addName = null;
            String addPatronymic = null;
            LocalDate addBirthDate = null;
            String addAddress = null;
            double addCardNumber = 0;
            double addCardBalance = 0;
            try {
                addSurname = (surnameT.getText());
                addName = (nameT.getText());
                addPatronymic = (patronymicT.getText());
                addBirthDate = BirthdayT.getValue();
                addAddress = (adressT.getText());
                addCardNumber  = Double.parseDouble(cardNumberT.getText());
                addCardBalance  = (Double.parseDouble(cardBalanceT.getText()));
            } catch (NumberFormatException err) {
                Alert b = new Alert(Alert.AlertType.ERROR);
                b.setTitle("Помилка");
                b.setHeaderText("Некоректно введено значення");
                b.show();
                success = false;
            }
            if (success) {
                List<Customer> list = logic.fillList();
                List.setText(String.valueOf(logic.AddToList(list, addSurname, addName, addPatronymic, addBirthDate, addAddress, (long) addCardNumber, addCardBalance)));
                System.out.println("button clicked");
            }
        });
    }
    @FXML
    void remove() {
        Logic logic = new Logic();
        removeT.setOnAction(event -> {
            boolean success = true;
            int index = 0;
            try {
                index = (Integer.parseInt(indexT.getText()));
            } catch (NumberFormatException err) {
                Alert b = new Alert(Alert.AlertType.ERROR);
                b.setTitle("Помилка");
                b.setHeaderText("Некоректно введено значення");
                b.show();
                success = false;
            }
            if (success) {
                List<Customer> list = logic.fillList();
                ListR.setText(String.valueOf(logic.remove(list, index)));
                System.out.println("button clicked");
            }
        });
    }
    @FXML
    void searchName() {
        Logic logic = new Logic();
        searchNameB.setOnAction(event -> {
            boolean success = true;
            String nameSearch = null;
            try {
                nameSearch = (searchNameT.getText());

            } catch (NumberFormatException err) {
                Alert b = new Alert(Alert.AlertType.ERROR);
                b.setTitle("Помилка");
                b.setHeaderText("Некоректно введено значення");
                b.show();
                success = false;
            }
            if (success) {
                List<Customer> list = logic.fillList();
                ListName.setText(String.valueOf(logic.sortName(list, nameSearch)));
                System.out.println("button clicked");
            }
        });
    }
    @FXML
    void searchCardNumber() {
        Logic logic = new Logic();
        searchCardNumberT.setOnAction(event -> {
            boolean success = true;
            long cardNumberF = Long.valueOf(0);
            long cardNumberT= Long.valueOf(0);
            try {
                cardNumberF = Long.valueOf((cardNumberFromT.getText()));
                cardNumberT = Long.valueOf(( cardNumberToT.getText()));

            } catch (NumberFormatException err) {
                Alert b = new Alert(Alert.AlertType.ERROR);
                b.setTitle("Помилка");
                b.setHeaderText("Некоректно введено значення");
                b.show();
                success = false;
            }
            if (success) {
                List<Customer> list = logic.fillList();
                ListCardNumber.setText(String.valueOf(logic.sortCardNumber(list, cardNumberF,cardNumberT)));
                System.out.println("button clicked");
            }
        });
    }
    @FXML
    void Debt() {
        Logic logic = new Logic();
        int qCardBalance = 0;
        List<Customer> list = logic.fillList();
        List<Customer> r=logic.sortCardBalance(list, qCardBalance);
        qCardBalanceT.setText(String.valueOf(logic.qCardBalance(list,r,qCardBalance)));
        ListDebt.setText(String.valueOf(logic.sortCardBalance(list, qCardBalance)));
        System.out.println("button clicked");
    }
    @FXML
    void Sort() {
        Logic logic = new Logic();
        List<Customer> list = logic.fillList();
        SortT.setText(String.valueOf(logic.sortByCardBalanceCardNumber(list)));
        System.out.println("button clicked");
    }
    @FXML
    void yearSort() {
        Logic logic = new Logic();
        List<Customer> list = logic.fillList();
        sortYear.setText(String.valueOf(logic.sortByBirthYear(list)));
        System.out.println("button clicked");
    }
    @FXML
    void yearBalanceB() {
        Logic logic = new Logic();
        List<Customer> list = logic.fillList();
        YearBalanceT.setText(String.valueOf(logic.sortYearCardBalance(list)));
        System.out.println("button clicked");
    }
}