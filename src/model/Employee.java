package model;

public class Employee implements Comparable {
    private int employee_id;
    private String employee_name;
    private String employee_mobile;
    private String employee_email;
    private String employee_username;
    private String employee_password;
    private String employee_address;

    public Employee(int employee_id, String employee_name, String employee_mobile, String employee_email, String employee_username, String employee_password, String employee_address) {
        this.employee_id = employee_id;
        this.employee_name = employee_name;
        this.employee_mobile = employee_mobile;
        this.employee_email = employee_email;
        this.employee_username = employee_username;
        this.employee_password = employee_password;
        this.employee_address = employee_address;
    }


    public Employee (String text){
        String []path=text.split(",");

        this.employee_id=Integer.parseInt(path[0]);
        this.employee_name=path[1];
        this.employee_mobile=path[2];
        this.employee_email=path[3];
        this.employee_username=path[4];
        this.employee_password=path[5];
        this.employee_address=path[6];

    }

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public String getEmployee_name() {
        return employee_name;
    }

    public void setEmployee_name(String employee_name) {
        this.employee_name = employee_name;
    }

    public String getEmployee_mobile() {
        return employee_mobile;
    }

    public void setEmployee_mobile(String employee_mobile) {
        this.employee_mobile = employee_mobile;
    }

    public String getEmployee_email() {
        return employee_email;
    }

    public void setEmployee_email(String employee_email) {
        this.employee_email = employee_email;
    }

    public String getEmployee_username() {
        return employee_username;
    }

    public void setEmployee_username(String employee_username) {
        this.employee_username = employee_username;
    }

    public String getEmployee_password() {
        return employee_password;
    }

    public void setEmployee_password(String employee_password) {
        this.employee_password = employee_password;
    }

    public String getEmployee_address() {
        return employee_address;
    }

    public void setEmployee_address(String employee_address) {
        this.employee_address = employee_address;
    }


    public static class Builder {
        private int employee_id;
        private String employee_name;
        private String employee_mobile;
        private String employee_email;
        private String employee_username;
        private String employee_password;
        private String employee_address;

        public Builder withId(int employee_id) {
            this.employee_id = employee_id;
            return this;
        }

        public Builder withName(String employee_name) {
            this.employee_name = employee_name;
            return this;
        }

        public Builder withMobile(String employee_mobile) {
            this.employee_mobile = employee_mobile;
            return this;
        }

        public Builder withEmail(String employee_email) {
            this.employee_email = employee_email;
            return this;
        }

        public Builder withUserName(String employee_username) {
            this.employee_username = employee_username;
            return this;
        }

        public Builder withPassword(String employee_password) {
            this.employee_password = employee_password;
            return this;
        }

        public Builder withAddress(String employee_address) {
            this.employee_address = employee_address;
            return this;
        }

        public Employee build() {
            return new Employee(employee_id, employee_name, employee_mobile, employee_email, employee_username, employee_password, employee_address);
        }
    }


    @Override
    public String toString() {
        String text = "Name : " + this.employee_name + "\n";
        text += "Mobile : " + this.employee_mobile + "\n";
        text += "Email : " + this.employee_email + "\n";
        text += "UserName : " + this.employee_username + "\n";
        text += "Password : " + this.employee_password + "\n";
        text += "Address : " + this.employee_address + "\n";

        return text;
    }


    @Override
    public boolean equals(Object o) {
        Employee x = (Employee) o;
        return this.getEmployee_id() == x.getEmployee_id();
    }

    @Override
    public int compareTo(Object o) {
        Employee x = (Employee) o;
        if (this.employee_id > x.getEmployee_id()) {
            return 1;
        } else if (this.employee_id < x.getEmployee_id()) {
            return -1;
        } else {
            return 0;
        }
    }



}
