package com.example.renoapp;

public class Reponse {
    private String message, budgetPropose;
    private Integer id_announce;

    public Reponse(String message, String budgetPropose, Integer id_announce) {
        this.message = message;
        this.budgetPropose = budgetPropose;
        this.id_announce = id_announce;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getBudgetPropose() {
        return budgetPropose;
    }

    public void setBudgetPropose(String budgetPropose) {
        this.budgetPropose = budgetPropose;
    }

    public Integer getId_announce() {
        return id_announce;
    }

    public void setId_announce(Integer id_announce) {
        this.id_announce = id_announce;
    }
}
