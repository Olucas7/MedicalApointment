package model;

public abstract class User {
    private int id;
    private String name;
    private String email;
    private String address;
    private String phoneNumber;

    public User(String name, String email){
        this.name = name;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        try {
            Integer.parseInt(phoneNumber);
            if(phoneNumber.length() == 10){
                this.phoneNumber = phoneNumber;
                System.out.println("number phone added successful".toLowerCase());
            }else
                System.out.println("couldn't add that number, there's a problem".toUpperCase());

        }catch (NumberFormatException e) {
            System.out.println("this fild accept numbers only".toUpperCase());
        }
    }

    @Override
    public String toString() {
        return
                "id_Usuario = " + id +
                        "\nname = " + name +
                        "\nemail = " + email +
                        "\naddress = " + address +
                        "\nphoneNumber = " + phoneNumber +
                        "\n";
    }

    public abstract void showDataUser();

}
