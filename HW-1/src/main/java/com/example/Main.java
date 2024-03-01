package com.example;

import com.google.gson.Gson;

public class Main {
    public static void main(String[] args) {
        // Создание объекта Person
        Person person = new Person("Mikhael", "Smirnov", 30);

        // Сериализация объекта Person в JSON
        Gson gson = new Gson();
        String json = gson.toJson(person);
        System.out.println("Сереализованный объект Person:\n" + json);

        // Десериализация JSON в объект Person
        Person deserializedPerson = gson.fromJson(json, Person.class);
        System.out.println("\nДесериализованный объект Person:\n" + deserializedPerson);
    }
}