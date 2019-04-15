package com.example.t_micha.remaths;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MathResponse{

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("question")
    @Expose
    private String question;
    @SerializedName("choices")
    @Expose
    private List<String> choices = null;
    @SerializedName("correct_choice")
    @Expose
    private Integer correctChoice;
    @SerializedName("instruction")
    @Expose
    private String instruction;
    @SerializedName("category")
    @Expose
    private String category;
    @SerializedName("topic")
    @Expose
    private String topic;
    @SerializedName("difficulty")
    @Expose
    private String difficulty;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<String> getChoices() {
        return choices;
    }

    public void setChoices(List<String> choices) {
        this.choices = choices;
    }

    public Integer getCorrectChoice() {
        return correctChoice;
    }

    public void setCorrectChoice(Integer correctChoice) {
        this.correctChoice = correctChoice;
    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    @Override
    public String toString() {
        return "MathResponse{" +
                "id='" + id + '\'' +
                ", question='" + question + '\'' +
                ", choices=" + choices +
                ", correctChoice=" + correctChoice +
                ", instruction='" + instruction + '\'' +
                ", category='" + category + '\'' +
                ", topic='" + topic + '\'' +
                ", difficulty='" + difficulty + '\'' +
                '}';
    }
}