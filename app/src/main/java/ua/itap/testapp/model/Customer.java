package ua.itap.testapp.model;

import androidx.databinding.ObservableField;

import java.util.Map;


public class Customer {

    static String TITLE = "title";
    static String FIRSTNAME = "first";
    static String LASTNAME =  "last";
    public static String PICTURELARGE = "large";
    public static String PICTUREMEDIUM = "medium";
    public static String PICTURESMALL =  "thumbnail";


    public ObservableField<String> viewName = new ObservableField<>("");
    public ObservableField<String> viewLogin = new ObservableField<>("");
    public ObservableField<String> viewEmail = new ObservableField<>("");
    public ObservableField<String> viewPhone = new ObservableField<>("");
    public ObservableField<String> viewCell = new ObservableField<>("");


    private String gender;
    Map<String,String> name;
//    Location LocationObject;
    private String email;
    Login login;
//    Dob DobObject;
//    Registered RegisteredObject;
    private String phone;
    private String cell;
//    Id IdObject;
    Map<String,String> picture;
    private String nat;


    public void presentView(){
        viewCell.set(this.cell);
        viewEmail.set(this.email);
        viewLogin.set(this.login.getUsername());
        viewPhone.set(this.phone);
        viewName.set(this.getCustomerName());
    }
    // Getter Methods

    public String getGender() {
        return gender;
    }

    public Map<String,String> getName() {
        return name;
    }

//    public Location getLocation() {
//        return LocationObject;
//    }

    public String getEmail() {
        return email;
    }

    public Login getLogin() {
        return login;
    }
//
//    public Dob getDob() {
//        return DobObject;
//    }
//
//    public Registered getRegistered() {
//        return RegisteredObject;
//    }

    public String getPhone() {
        return phone;
    }

    public String getCell() {
        return cell;
    }

//    public Id getId() {
//        return IdObject;
//    }

    public Map<String,String> getPicture() {
        return picture;
    }

    public String getNat() {
        return nat;
    }

    // Setter Methods

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setName(Map<String,String> nameObject) {
        this.name = nameObject;
    }

//    public void setLocation(Location locationObject) {
//        this.LocationObject = locationObject;
//    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setLogin(Login loginObject) {
        this.login = loginObject;
    }
//
//    public void setDob(Dob dobObject) {
//        this.DobObject = dobObject;
//    }
//
//    public void setRegistered(Registered registeredObject) {
//        this.RegisteredObject = registeredObject;
//    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setCell(String cell) {
        this.cell = cell;
    }

//    public void setId(Id idObject) {
//        this.IdObject = idObject;
//    }

    public void setPicture(Map<String,String> pictureObject) {
        this.picture = pictureObject;
    }

    public void setNat(String nat) {
        this.nat = nat;
    }

    public String getCustomerName() {
      return name.get(TITLE) + " " +
              name.get(FIRSTNAME) + " " +
              name.get(LASTNAME);

    }
}
