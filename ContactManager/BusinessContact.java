public class BusinessContact extends Contact {
    private String company;

    public BusinessContact(String name, String phoneNumber, String email, String company) {
        super(name, phoneNumber, email);
        setCompany(company);
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        if (company == null || company.trim().isEmpty()) {
            throw new IllegalArgumentException("Company cannot be null or empty");
        }
        this.company = company;
    }

    @Override
    public String toString() {
        return super.toString().replace("Contact{", "BusinessContact{")
                .replace("}", ", company='" + company + "'}");
    }
}
