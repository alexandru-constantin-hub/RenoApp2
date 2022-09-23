package com.example.renoapp;

public class Demande {

    private String piece, description, budget, deadline;

    public Demande(String piece, String description, String budget, String deadline) {
        this.piece = piece;
        this.description = description;
        this.budget = budget;
        this.deadline = deadline;
    }

    public Demande() {

    }

    public String getPiece() {
        return piece;
    }

    public void setPiece(String piece) {
        this.piece = piece;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBudget() {
        return budget;
    }

    public void setBudget(String budget) {
        this.budget = budget;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }
}
