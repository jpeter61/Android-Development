package me.jamiepeterson.a32collegecost;
public class StudentCost {
    private int credits;
    private String level;
    private boolean dorm;
    private boolean dining;
    private int cost;

    public StudentCost(){
        credits = 0;
        level = "";
        dorm = false;
        dining = false;
        cost = 0;
    }

    public int getCost() {
        cost = 0;
        switch (level){
            case "Undergraduate":
                cost = credits * 300;
                break;
            case "Graduate":
                cost = credits * 400;
                break;
        }
        if(dorm)
            cost += 1000;
        if(dining)
            cost += 500;
        return cost;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public void setDorm(boolean dorm) {
        this.dorm = dorm;
    }

    public void setDining(boolean dining) {
        this.dining = dining;
    }

    public int getCredits() {
        return credits;
    }

    public String getLevel() {
        return level;
    }

    public boolean isDorm() {
        return dorm;
    }

    public boolean isDining() {
        return dining;
    }
}
