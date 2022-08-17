package TableWriter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class TextTableWriter implements TableWriter,OutputFileWriter{
    String fileName;
    TextTableWriter(String fileName){
        this.fileName = fileName;
    }
    @Override
    public void writeTable(Row[] table) {
        try {
            FileWriter fileWriter = new FileWriter(fileName);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for(int i = 0; i < table.length;i++){
                Row current = table[i];
               bufferedWriter.write(current.left + "\t\t" + "|"+  current.right + "\n");

            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public String getOutputPlace() {
        return "text file: " + fileName;
    }

    @Override
    public String getFileName() {
        return this.fileName;
    }
}
