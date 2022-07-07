package com.example.quess;

import java.io.Serializable;

public class GameModel implements Serializable {

    public String firstImage;
    public String secondImage;
    public String thirdImage;
    public String fourImage;
    public String answer;
    public String level;

    public GameModel(String firstImage, String secondImage, String thirdImage, String fourImage, String answer, String level) {
        this.firstImage = firstImage;
        this.secondImage = secondImage;
        this.thirdImage = thirdImage;
        this.fourImage = fourImage;
        this.answer = answer;
        this.level = level;
    }
}