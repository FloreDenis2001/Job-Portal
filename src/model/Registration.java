package model;

public class Registration implements Comparable {

    private int registration_id;
    private int registration_user_id;
    private String registration_number;
    private String registration_date;

    public Registration(int registration_id, int registration_user_id, String registration_number, String registration_date) {
        this.registration_id = registration_id;
        this.registration_user_id = registration_user_id;
        this.registration_number = registration_number;
        this.registration_date = registration_date;
    }

    public Registration(String text) {
        String[] path = text.split(",");
        this.registration_id = Integer.parseInt(path[0]);
        this.registration_user_id = Integer.parseInt(path[1]);
        this.registration_number = path[2];
        this.registration_date = path[3];
    }

    public int getRegistration_id() {
        return registration_id;
    }

    public void setRegistration_id(int registration_id) {
        this.registration_id = registration_id;
    }

    public int getRegistration_user_id() {
        return registration_user_id;
    }

    public void setRegistration_user_id(int registration_user_id) {
        this.registration_user_id = registration_user_id;
    }

    public String getRegistration_number() {
        return registration_number;
    }

    public void setRegistration_number(String registration_number) {
        this.registration_number = registration_number;
    }

    public String getRegistration_date() {
        return registration_date;
    }

    public void setRegistration_date(String registration_date) {
        this.registration_date = registration_date;
    }


    public static class Builder {

        private int registration_id;
        private int registration_user_id;
        private String registration_number;
        private String registration_date;


        public Builder withRegistrationId(int registration_id) {
            this.registration_id = registration_id;
            return this;
        }

        public Builder withRegistrationUserId(int registration_user_id) {
            this.registration_user_id = registration_user_id;
            return this;
        }

        public Builder withRegistrationNumber(String registration_number) {
            this.registration_number = registration_number;
            return this;
        }

        public Builder withRegistrationDate(String registration_date) {
            this.registration_date = registration_date;
            return this;
        }

        public Registration build() {
            return new Registration(registration_id, registration_user_id, registration_number, registration_date);
        }

    }

    @Override
    public String toString() {
        String text = "Registration Number : " + this.registration_number + "\n";
        text += "Date of registration : " + this.registration_date + "\n";
        return text;
    }

    @Override
    public boolean equals(Object o) {
        Registration r = (Registration) o;
        return this.getRegistration_id() == r.getRegistration_id();
    }

    @Override
    public int compareTo(Object o) {
        Registration r = (Registration) o;
        if (this.getRegistration_id() > r.getRegistration_id()) {
            return 1;
        } else if (this.getRegistration_id() < r.getRegistration_id()) {
            return -1;
        } else {
            return 0;
        }
    }


}
