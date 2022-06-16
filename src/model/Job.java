package model;

public class Job implements Comparable {
    private int job_id;
    private int job_employee_id;
    private String job_name;
    private String job_type;
    private String job_description;

    public Job(int job_id, int job_employee_id, String job_name, String job_type, String job_description) {
        this.job_id = job_id;
        this.job_employee_id = job_employee_id;
        this.job_name = job_name;
        this.job_type = job_type;
        this.job_description = job_description;
    }

    public Job(String text) {
        String[] path = text.split(",");
        this.job_id = Integer.parseInt(path[0]);
        this.job_employee_id = Integer.parseInt(path[1]);
        this.job_name = path[2];
        this.job_type = path[3];
        this.job_description = path[4];
    }

    public int getJob_id() {
        return job_id;
    }

    public void setJob_id(int job_id) {
        this.job_id = job_id;
    }

    public int getJob_employee_id() {
        return job_employee_id;
    }

    public void setJob_employee_id(int job_employee_id) {
        this.job_employee_id = job_employee_id;
    }

    public String getJob_name() {
        return job_name;
    }

    public void setJob_name(String job_name) {
        this.job_name = job_name;
    }

    public String getJob_type() {
        return job_type;
    }

    public void setJob_type(String job_type) {
        this.job_type = job_type;
    }

    public String getJob_description() {
        return job_description;
    }

    public void setJob_description(String job_description) {
        this.job_description = job_description;
    }


    public static class Builder {
        private int job_id;
        private int job_employee_id;
        private String job_name;
        private String job_type;
        private String job_description;


        public Builder withId(int job_id) {
            this.job_id = job_id;
            return this;
        }

        public Builder withEmployeeId(int job_employee_id) {
            this.job_employee_id = job_employee_id;
            return this;
        }

        public Builder withName(String job_name) {
            this.job_name = job_name;
            return this;
        }

        public Builder withType(String job_type) {
            this.job_type = job_type;
            return this;
        }

        public Builder withDescription(String job_description) {
            this.job_description = job_description;
            return this;
        }

        public Job build() {
            return new Job(job_id, job_employee_id, job_name, job_type, job_description);
        }

    }

    @Override
    public String toString() {
        String text = "Employee Id: " + this.job_employee_id + "\n";
        text += "Job Name : " + this.job_name + "\n";
        text += "Job Type : " + this.job_type + "\n";
        text += "Job Description : " + this.job_description + "\n";
        return text;
    }

    @Override
    public boolean equals(Object o) {
        Job x = (Job) o;
        return this.getJob_id() == x.getJob_id();
    }

    @Override
    public int compareTo(Object o) {
        Job t = (Job) o;
        if (this.job_id > t.getJob_id()) {
            return 1;
        } else if (this.job_id < t.getJob_id()) {
            return -1;
        } else {
            return 0;
        }
    }

}
