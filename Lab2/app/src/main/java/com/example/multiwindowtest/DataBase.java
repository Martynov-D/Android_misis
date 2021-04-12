package com.example.multiwindowtest;

import java.util.ArrayList;

public class DataBase
{
    private static ArrayList<Question> m_questions;

    DataBase()
    {
        m_questions = new ArrayList<Question>();
        m_questions.add(new Question("Сколько будет 2+2", new String[] {"1", "2", "3", "4"}, 4));
        m_questions.add(new Question("В каком году отменили крепостное право", new String[] {"1862", "1861", "1991", "1816"}, 2));
    }

    public Question getQuestion(int index) {return m_questions.get(index);}
    public int size(){return m_questions.size();}
}
