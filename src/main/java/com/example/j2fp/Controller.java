// This program creates an application that allows a user to shop for cars.
// Joshua Eliassaint
package com.example.j2fp;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Controller{

    @FXML
    private FlowPane flowPane;

    // Image Select Properties
    @FXML
    private TextArea carDescription;

    @FXML
    private ImageView imgSelected;


    @FXML
    private Button btnPurchase;

    @FXML
    private Button btnBack;
    //------------------------------

    // Purchase Page Properties
    @FXML
    private TextField fName;

    @FXML
    private TextField lName;

    @FXML
    private TextField ccInfo;

    @FXML
    private TextField expInfo;

    @FXML
    private TextField cvvInfo;


    @FXML
    private VBox checkOutVBox;

    @FXML
    private HBox checkOutButtonsHbox;

    @FXML
    private Label fNameInvalid;

    @FXML
    private Label lNameInvalid;

    @FXML
    private Label ccInvalid;

    @FXML
    private Label expInvalid;

    @FXML
    private Label cvvInvalid;

    @FXML
    private Label paymentLbl;
    //---------------------------------

    // Main Screen Properties
    @FXML
    private ListView<String> brandLV;

    @FXML
    private ListView<String> colorLV;

    @FXML
    private ListView<String> priceLV;

    @FXML
    private Label brandLabel;

    @FXML
    private Label colorLabel;

    @FXML
    private Label priceLabel;

    @FXML
    private Button resetFilterBtn;

    @FXML
    private CheckBox isConvertibleCB;

    @FXML
    private Button showAllCarsBtn;

    @FXML
    private Label instructions;
    //----------------------------------------

    // Receipt Page Properties
    @FXML
    private Label receiptTitleLbl;

    @FXML
    private TextArea descriptionRecTA;
    @FXML
    private Button exitReceiptBtn;
    //---------------------------------------

    // ArrayList for all the cars
    private ArrayList<Car> cars = new ArrayList<>();

    @FXML
    private void initialize(){
        setListView();
        createCars();
        setCars();
        filter();
    }

    // This method sets all the items in the brand, color, and price list views
    public void setListView(){
        brandLV.getItems().addAll("Aston Martin", "Ferrari", "Lamborghini", "McLaren", "Maserati");
        colorLV.getItems().addAll("Black", "Blue", "Green", "Orange", "Red", "White", "Yellow");
        priceLV.getItems().addAll("$0 - $50,000", "$50,001 - $180,000", "$180,001 - $250,000", "$250,001 - $365,000", "$365,001 - $500,000");
    }

    // This method creates all the car objects with the information about the car while also adding them to the cars array list
    public void createCars(){
        // Adding all the cars with their information to the array list
        cars.add(new Car("Aston Martin", 220000, "Black", true, 5, 3.6, "Gas", "Convertible", new ImageView("C:/Users/joshe/Desktop/Java 2/Final Project/j2fp/j2fp/src/main/resources/cars/BlkAstonConvertible.jpg")));
        cars.add(new Car("Aston Martin", 220000, "Blue", false, 6, 3.6, "Gas", "Sedan", new ImageView("C:/Users/joshe/Desktop/Java 2/Final Project/j2fp/j2fp/src/main/resources/cars/BluAston.jpg" )));
        cars.add(new Car("Aston Martin", 220000, "Green", false, 6, 3.6, "Gas", "Sedan", new ImageView("C:/Users/joshe/Desktop/Java 2/Final Project/j2fp/j2fp/src/main/resources/cars/GreenAston.jpg" )));
        cars.add(new Car("Aston Martin", 220000, "Red", true, 6, 3.6, "Gas", "Sedan", new ImageView("C:/Users/joshe/Desktop/Java 2/Final Project/j2fp/j2fp/src/main/resources/cars/RedAstonConvertible.jpg" )));

        cars.add(new Car("Ferrari", 300000, "Black", true, 6, 2.7, "Gas", "Convertible", new ImageView("C:/Users/joshe/Desktop/Java 2/Final Project/j2fp/j2fp/src/main/resources/cars/BlkFerrariConvertible.jpg" )));
        cars.add(new Car("Ferrari", 300000, "Blue", true, 6, 2.7, "Gas", "Convertible", new ImageView("C:/Users/joshe/Desktop/Java 2/Final Project/j2fp/j2fp/src/main/resources/cars/BluFerrariConvertible.jpg" )));
        cars.add(new Car("Ferrari", 300000, "Red", false, 6, 2.7, "Gas", "Sedan", new ImageView("C:/Users/joshe/Desktop/Java 2/Final Project/j2fp/j2fp/src/main/resources/cars/RedFerrari.jpg" )));
        cars.add(new Car("Ferrari", 300000, "White", false, 6, 2.7, "Gas", "Sedan", new ImageView("C:/Users/joshe/Desktop/Java 2/Final Project/j2fp/j2fp/src/main/resources/cars/WhiteFerrari.jpg")));
        cars.add(new Car("Ferrari", 300000, "White", true, 6, 2.7, "Gas", "Convertible", new ImageView("C:/Users/joshe/Desktop/Java 2/Final Project/j2fp/j2fp/src/main/resources/cars/WhiteFerrConvertible.jpg" )));
        cars.add(new Car("Ferrari", 300000, "Yellow", false, 6, 2.7, "Gas", "Sedan", new ImageView("C:/Users/joshe/Desktop/Java 2/Final Project/j2fp/j2fp/src/main/resources/cars/YellowFerrari.jpg" )));

        cars.add(new Car("Lamborghini", 400000, "Black", false, 6, 2.5, "Gas", "Sedan", new ImageView("C:/Users/joshe/Desktop/Java 2/Final Project/j2fp/j2fp/src/main/resources/cars/BlkLambo.jpg" )));
        cars.add(new Car("Lamborghini", 400000, "Black", true, 6, 2.5, "Gas", "Convertible", new ImageView("C:/Users/joshe/Desktop/Java 2/Final Project/j2fp/j2fp/src/main/resources/cars/BlkLamboConvertible.jpg" )));
        cars.add(new Car("Lamborghini", 400000, "Blue", true, 6, 2.5, "Gas", "Convertible", new ImageView("C:/Users/joshe/Desktop/Java 2/Final Project/j2fp/j2fp/src/main/resources/cars/BluLamboConvertible.jpg" )));
        cars.add(new Car("Lamborghini", 400000, "Green", false, 6, 2.5, "Gas", "Sedan", new ImageView("C:/Users/joshe/Desktop/Java 2/Final Project/j2fp/j2fp/src/main/resources/cars/GreenLambo.jpg" )));
        cars.add(new Car("Lamborghini", 400000, "White", false, 6, 2.5, "Gas", "Sedan", new ImageView("C:/Users/joshe/Desktop/Java 2/Final Project/j2fp/j2fp/src/main/resources/cars/WhiteLambo.jpg" )));
        cars.add(new Car("Lamborghini", 400000, "Yellow", false, 6, 2.5, "Gas", "Sedan", new ImageView("C:/Users/joshe/Desktop/Java 2/Final Project/j2fp/j2fp/src/main/resources/cars/YellowLambo.jpg" )));

        cars.add(new Car("McLaren", 365000, "Black", false, 6, 2.5, "Electric", "Sedan", new ImageView("C:/Users/joshe/Desktop/Java 2/Final Project/j2fp/j2fp/src/main/resources/cars/BlkMcLaren.jpg" )));
        cars.add(new Car("McLaren", 365000, "Green", false, 6, 2.5, "Electric", "Sedan", new ImageView("C:/Users/joshe/Desktop/Java 2/Final Project/j2fp/j2fp/src/main/resources/cars/GreenMcLaren.jpg" )));
        cars.add(new Car("McLaren", 365000, "Orange", true, 6, 2.5, "Electric", "Convertible", new ImageView("C:/Users/joshe/Desktop/Java 2/Final Project/j2fp/j2fp/src/main/resources/cars/OranMcLarConvertible.jpg" )));
        cars.add(new Car("McLaren", 365000, "Red", false, 6, 2.5, "Electric", "Sedan", new ImageView("C:/Users/joshe/Desktop/Java 2/Final Project/j2fp/j2fp/src/main/resources/cars/RedMcLaren.jpg" )));
        cars.add(new Car("McLaren", 365000, "Yellow", false, 6, 2.5, "Electric", "Sedan", new ImageView("C:/Users/joshe/Desktop/Java 2/Final Project/j2fp/j2fp/src/main/resources/cars/YellowMcLaren.jpg" )));

        cars.add(new Car("Maserati", 365000, "Black", false, 6, 3.8, "Electric", "Gas", new ImageView("C:/Users/joshe/Desktop/Java 2/Final Project/j2fp/j2fp/src/main/resources/cars/BlkMaserati.jpg" )));
        cars.add(new Car("Maserati", 365000, "Blue", false, 6, 3.8, "Electric", "Gas", new ImageView("C:/Users/joshe/Desktop/Java 2/Final Project/j2fp/j2fp/src/main/resources/cars/BluMaserati.jpg" )));
        cars.add(new Car("Maserati", 365000, "Red", false, 6, 3.8, "Electric", "Gas", new ImageView("C:/Users/joshe/Desktop/Java 2/Final Project/j2fp/j2fp/src/main/resources/cars/RedMaserati.jpg" )));
        cars.add(new Car("Maserati", 365000, "White", false, 6, 3.8, "Electric", "Gas", new ImageView("C:/Users/joshe/Desktop/Java 2/Final Project/j2fp/j2fp/src/main/resources/cars/WhiteMaserConvertible.jpg" )));
    }

    // Method display the default cars
    public void setCars(){
        // For loop to loop through the cars array list
        for (Car car : cars) {
            // Gets the image of the car
            ImageView image = new ImageView(car.getImage().getImage());
            // set the size of the image
            image.setFitWidth(165);
            image.setFitHeight(100);
            // Adds the image to the flowpane
            flowPane.getChildren().add(image);
            // Calls the method to detect if the image has been clicked on
            onImageClick(image, car);
        }
    }

    // Method to filter the images
    public void filter(){
        // Sets the selection mode
        brandLV.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        colorLV.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        priceLV.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);




        // Checks what has been selected for the brand list view
        brandLV.getSelectionModel().selectedItemProperty().addListener(ov -> {
            // Clears the flowpane
            flowPane.getChildren().clear();
            // For loop goes through the cars array list
            for(Car car: cars){
                if(car.getBrand().equals(brandLV.getSelectionModel().getSelectedItem())){
                    // Calls the displayImages() method and passes in the car object
                    displayImages(car);
                }
            }
        });
        // Checks what has been selected for the color list view
        colorLV.getSelectionModel().selectedItemProperty().addListener(ov -> {
            // Clears the flowpane
            flowPane.getChildren().clear();
            // For loop goes through the cars array list
            for(Car car: cars){
                if(car.getColor().equals(colorLV.getSelectionModel().getSelectedItem()) && brandLV.getSelectionModel().isEmpty() && priceLV.getSelectionModel().isEmpty()){
                    // Calls the displayImages() method and passes in the car object
                    displayImages(car);
                }
                else if(car.getColor().equals(colorLV.getSelectionModel().getSelectedItem()) && car.getBrand().equals(brandLV.getSelectionModel().getSelectedItem())){
                    // Calls the displayImages() method and passes in the car object
                    displayImages(car);
                }

            }
        });
        // Checks what has been selected for the price list view
        priceLV.getSelectionModel().selectedItemProperty().addListener(ov -> {
            // Clears the flowpane
            flowPane.getChildren().clear();
            // For loop goes through the cars array list
            for(Car car: cars){
                if(priceLV.getSelectionModel().getSelectedIndex() == 0 && brandLV.getSelectionModel().isEmpty() && colorLV.getSelectionModel().isEmpty()){
                    if(car.getPrice() >= 0 && car.getPrice() <= 50000){
                        // Calls the displayImages() method and passes in the car object
                        displayImages(car);
                    }
                }
                else if(priceLV.getSelectionModel().getSelectedIndex() == 1 && brandLV.getSelectionModel().isEmpty() && colorLV.getSelectionModel().isEmpty()){
                    if(car.getPrice() > 50000 && car.getPrice() <= 180000){
                        // Calls the displayImages() method and passes in the car object
                        displayImages(car);
                    }
                }
                else if(priceLV.getSelectionModel().getSelectedIndex() == 2 && brandLV.getSelectionModel().isEmpty() && colorLV.getSelectionModel().isEmpty()){
                    if(car.getPrice() > 180000 && car.getPrice() <= 250000){
                        // Calls the displayImages() method and passes in the car object
                        displayImages(car);
                    }
                }
                else if(priceLV.getSelectionModel().getSelectedIndex() == 3 && brandLV.getSelectionModel().isEmpty() && colorLV.getSelectionModel().isEmpty()){
                    if(car.getPrice() > 250000 && car.getPrice() <= 365000){
                        // Calls the displayImages() method and passes in the car object
                        displayImages(car);
                    }
                }
                else if(priceLV.getSelectionModel().getSelectedIndex() == 4 && brandLV.getSelectionModel().isEmpty() && colorLV.getSelectionModel().isEmpty()){
                    if(car.getPrice() > 365000 && car.getPrice() <= 500000){
                        // Calls the displayImages() method and passes in the car object
                        displayImages(car);
                    }
                }

                else if(car.getColor().equals(colorLV.getSelectionModel().getSelectedItem()) && brandLV.getSelectionModel().isEmpty()){
                    // Calls priceDisplayHelper() method and passes in the car object
                    priceDisplayHelper(car);
                }

                else if(car.getBrand().equals(brandLV.getSelectionModel().getSelectedItem()) && colorLV.getSelectionModel().isEmpty()){
                    // Calls priceDisplayHelper() method and passes in the car object
                    priceDisplayHelper(car);
                }

                else if(car.getBrand().equals(brandLV.getSelectionModel().getSelectedItem()) && car.getColor().equals(colorLV.getSelectionModel().getSelectedItem())){
                    // Calls priceDisplayHelper() method and passes in the car object
                    priceDisplayHelper(car);
                }
            }
        });
        // Checks to see if the checkbox for convertible has been selected
        isConvertibleCB.setOnAction(e -> {
            // Clears the flowpane
            flowPane.getChildren().clear();
            // For loop goes through the cars array list
            for(Car car: cars){
                if(isConvertibleCB.isSelected()){
                    if(car.isConvertible() && car.getBrand().equals(brandLV.getSelectionModel().getSelectedItem()) && car.getColor().equals(colorLV.getSelectionModel().getSelectedItem())){
                        // Calls priceDisplayHelper() method and passes in the car object
                        priceDisplayHelper(car);
                    }
                    else if(car.isConvertible() && brandLV.getSelectionModel().isEmpty() && colorLV.getSelectionModel().isEmpty() && priceLV.getSelectionModel().isEmpty())
                    {
                        // Calls the displayImages() method and passes in the car object
                        displayImages(car);
                    }
                    else if(car.isConvertible() && car.getBrand().equals(brandLV.getSelectionModel().getSelectedItem()) && colorLV.getSelectionModel().isEmpty() && priceLV.getSelectionModel().isEmpty()){
                        // Calls the displayImages() method and passes in the car object
                        displayImages(car);
                    }
                    else if(car.isConvertible() && car.getBrand().equals(brandLV.getSelectionModel().getSelectedItem()) && car.getColor().equals(colorLV.getSelectionModel().getSelectedItem()) && priceLV.getSelectionModel().isEmpty()){
                        // Calls the displayImages() method and passes in the car object
                        displayImages(car);
                    }
                }

            }

        });
    }

    // Method to clear all the filters
    public void clearFilters(){
        flowPane.getChildren().clear();

        brandLV.getSelectionModel().clearSelection();
        colorLV.getSelectionModel().clearSelection();
        priceLV.getSelectionModel().clearSelection();
        isConvertibleCB.setSelected(false);
        // Calls the setCars() method to display all cars
        setCars();
    }

    // Method to help filtering by price
    public void priceDisplayHelper(Car car){
        // Filters cars based on price
        if(priceLV.getSelectionModel().getSelectedIndex() == 0){
            if(car.getPrice() >= 0 && car.getPrice() <= 50000){
                displayImages(car);
            }
        }
        else if(priceLV.getSelectionModel().getSelectedIndex() == 1){
            if(car.getPrice() > 50000 && car.getPrice() <= 180000){
                displayImages(car);
            }
        }
        else if(priceLV.getSelectionModel().getSelectedIndex() == 2){
            if(car.getPrice() > 180000 && car.getPrice() <= 250000){
                displayImages(car);
            }
        }
        else if(priceLV.getSelectionModel().getSelectedIndex() == 3){
            if(car.getPrice() > 250000 && car.getPrice() <= 365000){
                displayImages(car);
            }
        }
        else if(priceLV.getSelectionModel().getSelectedIndex() == 4){
            if(car.getPrice() > 365000 && car.getPrice() <= 500000){
                displayImages(car);
            }
        }
    }

    // Helps display the images that are filtered
    public void displayImages(Car car){
        // Sets image to the image of the car
        ImageView image = new ImageView(car.getImage().getImage());
        // Sets the size of image
        image.setFitWidth(165);
        image.setFitHeight(100);
        // Calls the method to detect if the image has been clicked on
        onImageClick(image, car);
        // Adds the image to the flowpane
        flowPane.getChildren().add(image);
    }



    // Method to detect what image has been clicked
    public void onImageClick(ImageView image, Car car){
        // Gets image clicked
        image.setOnMousePressed(e ->{
            // Calls the showCarDetails to display the car that was
            // clicked information and passes image, and the car object as arguments
            showCarDetails(image, car);
        });

    }
    // Method to display all the car that was clicked details
    public void showCarDetails(ImageView image, Car car) {
        // Sets image to the imageview
        imgSelected.setImage(image.getImage());
        // Sets the description to the carDescription TextArea
        carDescription.setText("Price : $" + car.getPrice() +
                "\nBrand: " + car.getBrand() +
                "\nColor: " + car.getColor() +
                "\nConvertible: " + car.isConvertible() +
                "\nNumber of Cylinders: " + car.getNumOfCylinders() +
                "\n0 - 60: " + car.getZeroTo60() + "s" +
                "\nPowerTrain: " + car.getPowerTrain() +
                "\nType: " + car.getType());
        enableCarDetails();
        disableMainScreen();
    }
    // Method to disable the car details
    public void disableCarDetails(){
        imgSelected.setVisible(false);
        carDescription.setVisible(false);
        btnBack.setVisible(false);
        btnPurchase.setVisible(false);
    }
    // Method to enable the car details
    public void enableCarDetails(){
        imgSelected.setVisible(true);
        carDescription.setVisible(true);
        btnBack.setVisible(true);
        btnPurchase.setVisible(true);
    }
    // Method to disable the main screen
    public void disableMainScreen(){
        brandLV.setVisible(false);
        colorLV.setVisible(false);
        priceLV.setVisible(false);
        isConvertibleCB.setVisible(false);
        flowPane.setVisible(false);
        brandLabel.setVisible(false);
        colorLabel.setVisible(false);
        priceLabel.setVisible(false);
        resetFilterBtn.setVisible(false);
        showAllCarsBtn.setVisible(false);
        instructions.setVisible(false);
    }
    // Method to enable the main screen
    public void enableMainScreen() {

        brandLV.setVisible(true);
        colorLV.setVisible(true);
        priceLV.setVisible(true);
        isConvertibleCB.setVisible(true);
        flowPane.setVisible(true);
        brandLabel.setVisible(true);
        colorLabel.setVisible(true);
        priceLabel.setVisible(true);
        resetFilterBtn.setVisible(true);
        showAllCarsBtn.setVisible(true);
        instructions.setVisible(true);
    }
    // Method go back to the main screen
    public void back(){
        carDescription.setVisible(false);
        imgSelected.setVisible(false);
        btnBack.setVisible(false);
        btnPurchase.setVisible(false);
        enableMainScreen();
    }
    // Method to purchase
    public void purchase(){
        paymentLbl.setVisible(true);
        checkOutVBox.setVisible(true);
        checkOutButtonsHbox.setVisible(true);

        fName.setText("");
        lName.setText("");
        ccInfo.setText("");
        expInfo.setText("");
        cvvInfo.setText("");

        disableCarDetails();

    }
    // Method to cancel the purchase
    public void cancel(){
        checkOutVBox.setVisible(false);
        checkOutButtonsHbox.setVisible(false);
        fName.setText("");
        lName.setText("");
        ccInfo.setText("");
        expInfo.setText("");
        cvvInfo.setText("");
        paymentLbl.setVisible(false);
        enableCarDetails();
    }
    // Method to submit payment
    public void submit(){
        validateFName();
        validateLName();
        validateCardNum();
        validateExp();
        validateCVV();

        // Checks to see if all method return true
        if(validateFName() && validateLName() && validateCardNum() && validateExp() && validateCVV()){
            // SHow receipt
            showReceipt();
        }
    }
    // Method to show the receipt
    public void showReceipt(){
        checkOutVBox.setVisible(false);
        checkOutButtonsHbox.setVisible(false);
        paymentLbl.setVisible(false);
        descriptionRecTA.setText(carDescription.getText());

        receiptTitleLbl.setVisible(true);
        descriptionRecTA.setVisible(true);
        exitReceiptBtn.setVisible(true);
    }
    // Method to exit the receipt back the main screen
    public void exitReceipt(){
        receiptTitleLbl.setVisible(false);
        descriptionRecTA.setVisible(false);
        exitReceiptBtn.setVisible(false);
        enableMainScreen();
    }
    // Method to check the First Name input
    public boolean validateFName(){
        // Gets the text of the fName field
        String firstName = fName.getText();
        // Checks to see if the field is empty
        if(firstName.isEmpty()){
            fNameInvalid.setText("Enter a First Name!");
            return false;
        }
        else {
            // Checks to see if the first name is a letter A - Z
            for (int i = 0; i < fName.getText().length(); i++) {
                if (!Character.isLetter(firstName.charAt(i))) {
                    fNameInvalid.setText("Enter only letters (A-Z) for the first name!");
                    return false;
                }
            }
        }
        fNameInvalid.setText("");
        return true;
    }

    public boolean validateLName() {
        // Gets the text of the lName field
        String lastName = lName.getText();
        // Checks to see if the field is empty
        if(lastName.isEmpty()){
            lNameInvalid.setText("Enter a Last Name!");
            return false;
        }
        else {
            // Checks to see if the last name is not a letter A - Z
            for (int i = 0; i < lName.getText().length(); i++) {
                if (!Character.isLetter(lastName.charAt(i))) {
                    lNameInvalid.setText("Enter only letters (A-Z) for the last name!");
                    return false;
                }
            }
        }
        lNameInvalid.setText("");
        return true;
    }

    public boolean validateCardNum(){
        // Gets the text of the ccInfo field
        String ccNum = ccInfo.getText();
        // Checks to see if the field is empty
        if(ccNum.isEmpty()){
            ccInvalid.setText("Enter a valid Credit Card Number!");
            return false;
        }
        else {
            // Checks to see if credit card is a not digit
            for (int i = 0; i < ccInfo.getText().length(); i++) {
                if (!Character.isDigit(ccNum.charAt(i))) {
                    ccInvalid.setText("Enter only numbers!");
                    return false;
                }
                // Checks to see if the credit card is not 16 digits
                else if (ccNum.length() != 16) {
                    ccInvalid.setText("A card Number is 16 digits!");
                    return false;
                }
            }
        }
        ccInvalid.setText("");
        return true;
    }


    public boolean validateCVV() {
        // Gets the text of the cvvInfo field
        String cvvNum = cvvInfo.getText();
        // Checks to see if the field is empty
        if(cvvInfo.getText().isEmpty()) {
            cvvInvalid.setText("Enter a valid CVV!");
            return false;
        }
        else {
            // Checks to see if the cvv is a not digit
            for (int i = 0; i < cvvInfo.getText().length(); i++) {
                if (!Character.isDigit(cvvNum.charAt(i))) {
                    cvvInvalid.setText("Enter only numbers!");
                    return false;
                }
                // Checks to see if the cvv is a not 3 digits
                else if (cvvNum.length() != 3) {
                    cvvInvalid.setText("Enter 3 digits!");
                    return false;
                }
            }
        }
        cvvInvalid.setText("");
        return true;
    }

    public boolean validateExp() {
        // String to hold the month
        String month;
        // String to hold the year
        String year;
        // Gets the text of the expInfo field
        String expiration = expInfo.getText();
        // Checks to see if the field is empty
        if(expInfo.getText().isEmpty()){
            expInvalid.setText("Enter a expiration date!");
            return false;
        }
        // Checks to see if expiration is not the length of 5
        else if(expInfo.getLength() != 5){
            expInvalid.setText("Enter a valid date!");
            return false;
        }
        // Sets the month and year
        else{
            if(expiration.charAt(0) == '0'){
                month = String.valueOf(expiration.charAt(1));
            }
            else{
                month = expiration.substring(0, 2);
            }

            if(expiration.charAt(4) == '0'){
                year = String.valueOf(expiration.charAt(5));
            }
            else{
                year = expiration.substring(3, 5);
            }

            int intYear = Integer.parseInt(year);


            // Creates a calender called date
            GregorianCalendar date;

            // Switch to set the date
            switch(month){
                case "1":
                    date = new GregorianCalendar(intYear, Calendar.JANUARY, 1);
                    break;
                case "2":
                    date = new GregorianCalendar(intYear, Calendar.FEBRUARY, 1);
                    break;
                case "3":
                    date = new GregorianCalendar(intYear, Calendar.MARCH, 1);
                    break;
                case "4":
                    date = new GregorianCalendar(intYear, Calendar.APRIL, 1);
                    break;
                case "5":
                    date = new GregorianCalendar(intYear, Calendar.MAY, 1);
                    break;
                case "6":
                    date = new GregorianCalendar(intYear, Calendar.JUNE, 1);
                    break;
                case "7":
                    date = new GregorianCalendar(intYear, Calendar.JULY, 1);
                    break;
                case "8":
                    date = new GregorianCalendar(intYear, Calendar.AUGUST, 1);
                    break;
                case "9":
                    date = new GregorianCalendar(intYear, Calendar.SEPTEMBER, 1);
                    break;
                case "10":
                    date = new GregorianCalendar(intYear, Calendar.OCTOBER, 1);
                    break;
                case "11":
                    date = new GregorianCalendar(intYear, Calendar.NOVEMBER, 1);
                    break;
                case "12":
                    date = new GregorianCalendar(intYear, Calendar.DECEMBER, 1);
                    break;


            }
            expInvalid.setText("");
        }
        return true;
    }




}

// CarInfo interface
interface CarInfo{
    // Abstract Method to get the brand
    public abstract String getBrand();
    // Abstract Method to get the price
    public abstract double getPrice();
    // Abstract Method to get the color
    public abstract String getColor();
    // Abstract Method to get if it is a convertible
    public abstract boolean isConvertible();
    // Abstract Method to get the number of cylinders
    public abstract int getNumOfCylinders();
    // Abstract Method to get zero to 60 time
    public abstract double getZeroTo60();
    // Abstract Method to get the power train
    public abstract String getPowerTrain();
    // Abstract Method to get the type
    public abstract String getType();
    // Abstract Method to get the image
    public abstract ImageView getImage();
}

class Car implements CarInfo{
    // String to hold the brand
    private String brand;
    // double to hold the price
    private double price;
    // String to hold the color
    private String color;
    // boolean to hold if it is a convertible
    private boolean isConvertible;
    // int to hold the number of cylinders
    private int numOfCylinders;
    // double to hold the time to get from zero to 60
    private double zeroTo60;
    // String to hold the power train
    private String powerTrain;
    // String to golf the type
    private String type;
    // ImageView to hold the image
    private ImageView image;

    // Constructor
    public Car(String brand, double price, String color, boolean convertible, int numOfCylinders, double zeroTo60, String powerTrain, String type, ImageView image){
        this.brand = brand;
        this.price = price;
        this.color = color;
        this.isConvertible = convertible;
        this.numOfCylinders = numOfCylinders;
        this.zeroTo60 = zeroTo60;
        this.powerTrain = powerTrain;
        this.type = type;
        this.image = image;
    }
    // Method to get the brand
    public String getBrand() {
        return this.brand;
    }

    // Method to get the price
    public double getPrice() {
        return this.price;
    }

    // Method to get the color
    public String getColor() {
        return this.color;
    }

    // Method to get if it is a convertible
    public boolean isConvertible() {
        return this.isConvertible;
    }

    // Method to get the number of cylinders
    public int getNumOfCylinders() {
        return this.numOfCylinders;
    }

    // Method to get the power train
    public double getZeroTo60() {
        return this.zeroTo60;
    }

    // Method to get the power train
    public String getPowerTrain() {
        return this.powerTrain;
    }

    // Method to get the type
    public String getType() {
        return this.type;
    }
    // Method to get the image
    public ImageView getImage(){
        return this.image;
    }

}


