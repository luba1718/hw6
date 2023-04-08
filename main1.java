import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Map.Entry;

public class main1 {
    public static void main(String[] args) {
        notebook note1 = new notebook("A5", 1236, "Xiaomi");
        note1.setColor("black");
        note1.setHDD(700);
        note1.setOS("Windows");
        note1.setRAM(8);

        notebook note2 = new notebook("ABC30", 6467, "Acer");
        note2.setColor("white");
        note2.setHDD(1000);
        note2.setOS("Windows");
        note2.setRAM(8);

        notebook note3 = new notebook("AB97", 67201, "Acer");
        note3.setColor("rose");
        note3.setHDD(900);
        note3.setOS("Windows");
        note3.setRAM(16);

        notebook note4 = new notebook("OMAN11", 1111, "hp");
        note4.setColor("black");
        note4.setHDD(700);
        note4.setOS("Linux");
        note4.setRAM(8);

        notebook note5 = new notebook("MAC101", 8438483, "Apple");
        note5.setColor("silver");
        note5.setHDD(1000);
        note5.setOS("macOS");
        note5.setRAM(8);

        HashSet<notebook> notebooks = new HashSet<>(Arrays.asList(note1, note2, note3, note4, note5));
        HashSet<notebook> res = new HashSet<>();

        System.out.println("Здравствуйте");
        System.out.print(
                "Введите цифру, соответствующую необходимому критерию:\n 1 - ОЗУ \n 2 - Объем ЖД \n 3 - Операционная система \n 4 - цвет \n или 5, чтобы осуществить поиск\n");
        Scanner sc = new Scanner(System.in);
        Integer n = sc.nextInt();
        sc.nextLine();
        HashMap<String, Object> filters = new HashMap<>();
        while (n != 5) {
            if (n == 1) {
                System.out.println("Введите минимальную оперативную память");
                Integer temp = sc.nextInt();
                sc.nextLine();
                filters.put("RAM", temp);
            }
            if (n == 2) {
                System.out.println("Введите минимальный объем ЖД");
                Integer temp = sc.nextInt();
                sc.nextLine();
                filters.put("HDD", temp);
            }
            if (n == 3) {
                System.out.println("Введите ОС");
                String temp = sc.nextLine();
                filters.put("OS", temp);
            }
            if (n == 4) {
                System.out.println("Введите цвет");
                String temp = sc.nextLine();
                filters.put("color", temp);
            }
            System.out.print(
                    "Введите цифру, соответствующую необходимому критерию:\n 1 - ОЗУ \n 2 - Объем ЖД \n 3 - Операционная система \n 4 - цвет \n или 5, чтобы осуществить поиск\n");
            n = sc.nextInt();
            sc.nextLine();
        }
        for (Entry<String, Object> entry : filters.entrySet()) {
            if (entry.getKey().equals("RAM")) {
                Iterator it = notebooks.iterator();
                while (it.hasNext()) {
                    notebook notebook = (notebook) it.next();
                    if (notebook.getRAM() >= (Integer) entry.getValue()) {
                        res.add(notebook);
                    }
                }
            }
            if (entry.getKey().equals("HDD")) {
                Iterator it = notebook.iterator();
                while (it.hasNext()) {
                    notebook notebook = (notebook) it.next();
                    if (notebook.getHDD() >= (Integer) entry.getValue()) {
                        res.add(notebook);
                    }
                }
            }
            if (entry.getKey().equals("OS")) {
                Iterator it = notebooks.iterator();
                while (it.hasNext()) {
                    notebook note = (notebook) it.next();
                    if (note.getOS().equals(entry.getValue())) {
                        res.add(note);
                    }
                }
            }
            if (entry.getKey().equals("color")) {
                Iterator it = notebooks.iterator();
                while (it.hasNext()) {
                    notebook notebook = (notebook) it.next();
                    if (notebook.getColor().equals(entry.getValue())) {
                        res.add(notebook);
                    }
                }
            }
        }

        Iterator it = res.iterator();
        while (it.hasNext()) {
            notebook notebook = (notebook) it.next();
            System.out.println(notebook.toString());
            System.out.println();
        }

    }
}