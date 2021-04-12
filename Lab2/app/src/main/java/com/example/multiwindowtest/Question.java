package com.example.multiwindowtest;

public class Question
{
    private final String m_body;
    private final String[] m_answers;
    private final int m_correctAnswerIndex;

    Question(String body, String[] answers, int correctAnswerIndex)
    {
        m_body = body;
        m_answers = answers;
        m_correctAnswerIndex = correctAnswerIndex;
    }

    public String getBody(){return m_body;}
    public String[] getAnswers(){return m_answers;}
    public int getCorrectAnswerIndex(){return m_correctAnswerIndex;}
}
