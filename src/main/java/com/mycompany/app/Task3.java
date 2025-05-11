package com.mycompany.app;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Task3 {
    public static void execute() {
        System.out.println("Выполнение Задания №3 - Получение прогноза погоды");
        WebDriver webDriver = new ChromeDriver();
        try {
            String url = "https://api.open-meteo.com/v1/forecast?latitude=56&longitude=44&hourly=temperature_2m,rain&current=cloud_cover&timezone=Europe%2FMoscow&forecast_days=1&wind_speed_unit=ms";
            webDriver.get(url);
            WebElement elem = webDriver.findElement(By.tagName("pre"));
            
            String json_str = elem.getText();
            JSONParser parser = new JSONParser();
            JSONObject obj = (JSONObject) parser.parse(json_str);
            
            // Получаем данные о времени
            JSONObject hourly = (JSONObject) obj.get("hourly");
            JSONArray timeArray = (JSONArray) hourly.get("time");
            JSONArray temperatureArray = (JSONArray) hourly.get("temperature_2m");
            JSONArray rainArray = (JSONArray) hourly.get("rain");
            
            // Выводим заголовок таблицы
            StringBuilder table = new StringBuilder();
            table.append(String.format("|%-5s|%-21s|%-12s|%-12s|\n", "№", "Дата/время", "Температура", "Осадки (мм)"));
            table.append("|-----|---------------------|------------|------------|\n");
            
            // Выводим данные в таблицу
            for (int i = 0; i < timeArray.size(); i++) {
                String time = (String) timeArray.get(i);
                double temperature = ((Number) temperatureArray.get(i)).doubleValue();
                double rain = ((Number) rainArray.get(i)).doubleValue();
                
                table.append(String.format("|%-5d|%-21s|%-12.1f|%-12.2f|\n", i + 1, time, temperature, rain));
            }
            
            // Выводим таблицу на экран
            System.out.println(table.toString());
            
            // Создаем директорию result, если её нет
//            File resultDir = new File("result");
//            if (!resultDir.exists()) {
//                resultDir.mkdir();
//            }
//
            // Сохраняем таблицу в файл
//            try (PrintWriter writer = new PrintWriter(new FileWriter("result/forecast.txt"))) {
//                writer.print(table.toString());
//                System.out.println("Прогноз погоды сохранен в файл result/forecast.txt");
//            } catch (IOException e) {
//                System.out.println("Ошибка при сохранении файла: " + e.getMessage());
//            }
            
        } catch (Exception e) {
            System.out.println("Ошибка при выполнении Задания №3");
            System.out.println(e.toString());
        } finally {
            webDriver.quit();
        }
    }
} 