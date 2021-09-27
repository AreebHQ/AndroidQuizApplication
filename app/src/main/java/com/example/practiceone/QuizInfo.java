package com.example.practiceone;

public class QuizInfo {

    public String questionList[] = {
            "How many continents are there in the world?",
            "Which is the largest continent by population?",
            "Which is the largest ocean in the world?",
            "Who was the first man to step on the moon?",
            "How dead is the dead sea?",
            "Which one is the second closed planet to the Sun?",
            "Who is Harry Potter? " };
    private String options[][] = {
            {"Five","Seven","Eight","Six"},
            {"Asia","North America","Africa","Australia"},
            {"Artic Ocean","Indian Ocean","Atlantic Ocean", "Pacific Ocean"},
            { "Spiderman","John Cena","Neil Armstrong","Albert Einstien"},
            {"Dead","Still","Salty","Surviving"},
            {"Mars","Jupiter","Venus","Mercury"},
            {"A Megician","A Wizard","A Human","A Freelancer"} };

    private String answers[] = {"Seven","Asia","Pacific Ocean","Neil Armstrong","Salty", "Venus" ,"A Wizard"};


    public String getQuestion(int num)
    {
        String question = questionList[num];
        return question;
    }
    public String getOption1(int num){
        String option = options[num][0];
        return option;
    }

    public String getOption2(int num){
        String option = options[num][1];
        return option;
    }
    public String getOption3(int num){
        String option = options[num][2];
        return option;
    }
    public String getOption4(int num){
        String option = options[num][3];
        return option;
    }

    public String getAnswer (int num)
    {
        String answer = answers[num];
        return answer;
    }

}