package model;

public class Interview implements Comparable {
    private int interview_id;
    private int interview_job_id;
    private String interview_title;
    private String interview_description;
    private String interview_date;

    public Interview(int interview_id, int interview_job_id, String interview_title, String interview_description, String interview_date) {
        this.interview_id = interview_id;
        this.interview_job_id = interview_job_id;
        this.interview_title = interview_title;
        this.interview_description = interview_description;
        this.interview_date = interview_date;
    }

    public Interview(String text) {
        String[] path = text.split(",");
        this.interview_id = Integer.parseInt(path[0]);
        this.interview_job_id = Integer.parseInt(path[1]);
        this.interview_title = path[2];
        this.interview_description = path[3];
        this.interview_date = path[4];
    }

    public int getInterview_id() {
        return interview_id;
    }

    public void setInterview_id(int interview_id) {
        this.interview_id = interview_id;
    }

    public int getInterview_job_id() {
        return interview_job_id;
    }

    public void setInterview_job_id(int interview_job_id) {
        this.interview_job_id = interview_job_id;
    }

    public String getInterview_title() {
        return interview_title;
    }

    public void setInterview_title(String interview_title) {
        this.interview_title = interview_title;
    }

    public String getInterview_description() {
        return interview_description;
    }

    public void setInterview_description(String interview_description) {
        this.interview_description = interview_description;
    }

    public String getInterview_date() {
        return interview_date;
    }

    public void setInterview_date(String interview_date) {
        this.interview_date = interview_date;
    }


    public static class Builder {
        private int interview_id;
        private int interview_job_id;
        private String interview_title;
        private String interview_description;
        private String interview_date;


        public Builder withId(int interview_id) {
            this.interview_id = interview_id;
            return this;
        }

        public Builder withJobId(int interview_job_id) {
            this.interview_job_id = interview_job_id;
            return this;
        }

        public Builder withTitle(String interview_title) {
            this.interview_title = interview_title;
            return this;
        }

        public Builder withDescription(String interview_description) {
            this.interview_description = interview_description;
            return this;
        }

        public Builder withDate(String interview_date) {
            this.interview_date = interview_date;
            return this;
        }

        public Interview build() {
            return new Interview(interview_id, interview_job_id, interview_title, interview_description, interview_date);
        }
    }

    @Override
    public String toString() {
        String text = "Job Id : " + this.interview_job_id + "\n";
        text += "Title : " + this.interview_title + "\n";
        text += "Description : " + this.interview_description + "\n";
        text += "Date : " + this.interview_date + "\n";
        return text;
    }

    @Override
    public boolean equals(Object o) {
        Interview x = (Interview) o;
        return this.interview_id == x.getInterview_id();
    }


    @Override
    public int compareTo(Object o) {
        Interview x = (Interview) o;
        if (this.getInterview_id() > x.getInterview_id()) {
            return 1;
        } else if (this.getInterview_id() < x.getInterview_id()) {
            return -1;
        } else {
            return 0;
        }
    }

}
