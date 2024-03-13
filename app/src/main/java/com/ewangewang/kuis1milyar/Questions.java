package com.ewangewang.kuis1milyar;

public class Questions {
    public String mQuestion[] = {
            "1 + 1 = ? ",
            "2 + 2 = ? ",
            "3 + 3 = ? ",
            "4 + 4 = ? ",
            "5 + 5 = ? ",
            "6 + 6 = ? ",
            "7 + 7 = ? "
    };
    private String mChoice[][] = {
            {"2","4","6","8"},
            {"4","5","6","7"},
            {"1","3","6","8"},
            {"2","4","6","8"},
            {"12","10","6","8"},
            {"12","4","6","8"},
            {"2","14","6","18"},

    };
    private String mCorrectAnswer[] = {"2","4","6","8","10","12","14"};

    public String getQuestion(int a){
        String question = mQuestion[a];
        return question;
    }

    public String getChoice1(int a){
        String choice = mChoice[a][0];
        return choice;
    }
    public String getChoice2(int a){
        String choice = mChoice[a][1];
        return choice;
    }
    public String getChoice3(int a){
        String choice = mChoice[a][2];
        return choice;
    }
    public String getChoice4(int a){
        String choice = mChoice[a][3];
        return choice;
    }
    public String getCorrectAnswer(int a){
        String answer = mCorrectAnswer[a];
        return answer;
    }
}
