/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dictionary_project;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

/**
 *
 * @author Nhat
 */
public class CSVFile {

    public static void readFile(HashMap<String, String> h, String filename) throws FileNotFoundException {
         try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 2) {
                    String key = parts[0];
                    String value = parts[1];
                    h.put(key, value);
                }
            }
        } catch (IOException e) {
        }
    }

    public static void writeFile(HashMap<String, String> h, String filename) throws FileNotFoundException{
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (HashMap.Entry<String, String> entry : h.entrySet()) {
                writer.write(entry.getKey() + "," + entry.getValue());
                writer.newLine(); // xuống hàng
            }
        } catch (IOException e) {
        }
    }
    
}
