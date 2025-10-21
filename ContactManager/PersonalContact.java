public class PersonalContact extends Contact {
    private String birthday;

    public PersonalContact(String name, String phoneNumber, String email, String birthday) {
        super(name, phoneNumber, email);
        setBirthday(birthday);
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        if (birthday == null || birthday.trim().isEmpty()) {
            throw new IllegalArgumentException("Birthday cannot be null or empty");
        }
        if (!birthday.matches("\\d{2}/\\d{2}/\\d{4}")) {
            throw new IllegalArgumentException("Birthday must be in MM/DD/YYYY format");
        }
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return super.toString().replace("Contact{", "PersonalContact{")
                .replace("}", ", birthday='" + birthday + "'}");
    }
}
