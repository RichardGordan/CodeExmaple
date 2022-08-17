package TableWriter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class XmlTableWriter implements TableWriter,OutputFileWriter{
    @Override

        public void writeTable(Row[] table) {
            try {
                FileWriter fileWriter = new FileWriter("table.xlsx");
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                for(int i = 0; i < table.length;i++){
                    Row current = table[i];
                    bufferedWriter.write(current.left + ";" +  current.right + "\n");

                }
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }


    @Override
    public String getOutputPlace() {
        return "xlsx file: table.xlsx";
    }

    @Override
    public String getFileName() {
        return "table.xml";
    }
}
