package ua.kpi.comsys.io8207;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;
import java.util.stream.IntStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);

        lab12();
    }

    public void lab12() {
        System.out.println(" \n\nLab1.2 Start-------------------------------------------------\n\n ");


        //Завдання 1--------------------------------

        String studentsStr = "Дмитренко Олександр - ІП-84; Матвійчук Андрій - ІВ-83; Лесик Сергій - ІО-82;" +
                " Ткаченко Ярослав - ІВ-83; Аверкова Анастасія - ІО-83; Соловйов Даніїл - ІО-83; " +
                "Рахуба Вероніка - ІО-81; Кочерук Давид - ІВ-83; Лихацька Юлія - ІВ-82; " +
                "Головенець Руслан - ІВ-83; Ющенко Андрій - ІО-82; Мінченко Володимир - ІП-83; " +
                "Мартинюк Назар - ІО-82; Базова Лідія - ІВ-81; Снігурець Олег - ІВ-81; " +
                "Роман Олександр - ІО-82; Дудка Максим - ІО-81; Кулініч Віталій - ІВ-81; " +
                "Жуков Михайло - ІП-83; Грабко Михайло - ІВ-81; Іванов Володимир - ІО-81; " +
                "Востриков Нікіта - ІО-82; Бондаренко Максим - ІВ-83; Скрипченко Володимир - ІВ-82; " +
                "Кобук Назар - ІО-81; Дровнін Павло - ІВ-83; Тарасенко Юлія - ІО-82; " +
                "Дрозд Світлана - ІВ-81; Фещенко Кирил - ІО-82; Крамар Віктор - ІО-83; Іванов Дмитро - ІВ-82";

        HashMap<String, ArrayList> studentDict = new HashMap<>();

        String[] studentsList = studentsStr.split("; ");
        String[] ListKey_and_Value;

        for (int i = 0; i < studentsList.length; i++) {
            ListKey_and_Value = studentsList[i].split(" - ");
            ArrayList<String> listValue = new ArrayList<String>();
            if (studentDict.containsKey(ListKey_and_Value[1])) {
                listValue = studentDict.get(ListKey_and_Value[1]);
                listValue.add(ListKey_and_Value[0]);
            } else {
                listValue.add(ListKey_and_Value[0]);
                studentDict.put(ListKey_and_Value[1], listValue);
            }
        }
        System.out.println("Завдання 1");
        System.out.println(studentDict.toString());

        //Завдання 2--------------------------------
        int min = 1;
        int max = 20;
        Random random = new Random();

        HashMap<String, HashMap> studentDict2 = new HashMap<>();

        String[] studentsList2 = studentsStr.split("; ");
        String[] ListKey_and_Value2;


        for (int i = 0; i < studentsList2.length; i++) {
            ListKey_and_Value2 = studentsList2[i].split(" - ");
            HashMap<String, ArrayList> listValue2 = new HashMap<>();
            ArrayList<Integer> listNumber = new ArrayList<Integer>();
            listNumber.add(random.nextInt(max - min + 1) + min);
            listNumber.add(random.nextInt(max - min + 1) + min);
            listNumber.add(random.nextInt(max - min + 1) + min);
            listNumber.add(random.nextInt(max - min + 1) + min);
            listNumber.add(random.nextInt(max - min + 1) + min);
            if (studentDict2.containsKey(ListKey_and_Value2[1])) {
                HashMap<String, ArrayList> stud = new HashMap<>();
                listValue2 = studentDict2.get(ListKey_and_Value2[1]);
                listValue2.put(ListKey_and_Value2[0], listNumber);
            } else {
                HashMap<String, ArrayList> stud = new HashMap<>();
                stud.put(ListKey_and_Value2[0], listNumber);
                studentDict2.put(ListKey_and_Value2[1], stud);
            }
        }
        System.out.println("Завдання 2");
        System.out.println(studentDict2.toString());

        //Завдання 3--------------------------------

        HashMap<String, HashMap> studentDict3 = new HashMap<>();

        String[] studentsList3 = studentsStr.split("; ");
        String[] ListKey_and_Value3;


        for (int i = 0; i < studentsList3.length; i++) {
            ListKey_and_Value3 = studentsList3[i].split(" - ");
            HashMap<String, Integer> listValue3 = new HashMap<>();
            HashMap<String, ArrayList> HashNumber3 = new HashMap<>();
            HashNumber3 = studentDict2.get(ListKey_and_Value3[1]);
            ArrayList<Integer> sums = HashNumber3.get(ListKey_and_Value3[0]);
            int sum = sums.get(0) + sums.get(1) + sums.get(2) + sums.get(3) + sums.get(4);
            if (studentDict3.containsKey(ListKey_and_Value3[1])) {
                HashMap<String, Integer> stud = new HashMap<>();
                listValue3 = studentDict3.get(ListKey_and_Value3[1]);
                listValue3.put(ListKey_and_Value3[0], sum);
            } else {
                HashMap<String, Integer> stud = new HashMap<>();
                stud.put(ListKey_and_Value3[0], sum);
                studentDict3.put(ListKey_and_Value3[1], stud);
            }
        }
        System.out.println("Завдання 3");
        System.out.println(studentDict3.toString());

        //Завдання 4--------------------------------

        HashMap<String, Double> studentDict4 = new HashMap<>();

        Double srznach = 0.0;
        HashMap<String, Integer> temp = new HashMap<>();
        for (String i : studentDict3.keySet()) {
            temp = studentDict3.get(i);
            for (Integer j : temp.values()) {
                srznach += j;
            }
            srznach /= temp.size();
            studentDict4.put(i, srznach);
            srznach = 0.0;
        }
        System.out.println("Завдання 4");
        System.out.println(studentDict4.toString());


        //Завдання 5--------------------------------

        HashMap<String, ArrayList> studentDict5 = new HashMap<>();
        HashMap<String, Integer> temp5 = new HashMap<>();
        for (String i : studentDict3.keySet()) {
            ArrayList<String> goodStudents = new ArrayList<String>();
            temp5 = studentDict3.get(i);
            for (String j : temp5.keySet()) {
                if (temp5.get(j) >= 60) {
                    goodStudents.add(j);
                }
            }
            studentDict5.put(i, goodStudents);
        }
        System.out.println("Завдання 5");
        System.out.println(studentDict5.toString());

        //Завдання 6-12--------------------------------
        System.out.println("Приклад Ініціалізаціх з заданими параметрами (15-16)");
        CoordinateZH a = new CoordinateZH(12,12,12,true);
        System.out.println(a);
        System.out.println("Приклад Ініціалізаціх без заданих параметрів (15-16)");
        CoordinateZH b = new CoordinateZH();
        System.out.println(b);
        System.out.println("Координати в звичайному вигляді (16)");
        System.out.println(a.outCoordinate());
        System.out.println("Координати в десятичному вигляді (16)");
        System.out.println(a.outCoordinate2());
        System.out.println("Середнє між координатами (16)");
        System.out.println(a.outCoordinate3(-24, 48, 48, true));
        System.out.println("Середнє між довільними (17)");
        System.out.println(CoordinateZH.outCoordinate4(12, 12, 12, true, -20, 40, 40, true));
    }
}