package com.mycompany.app;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class App
{
    public static void main( String[] args )
    {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Deus\\Downloads\\chromedriver-win64\\chromedriver.exe");

//        WebDriver webDriver = new ChromeDriver();
//        try {
//            webDriver.get("https://www.calculator.net/password-generator.html");
//        } catch (Exception e) {
//            System.out.println("Error");
//            System.out.println(e.toString());
//        } finally {
//            webDriver.quit();
//        }
        
        // Выполнение Задания 2
        Task2.execute();
        
        // Выполнение Задания 3
        Task3.execute();
    }
}