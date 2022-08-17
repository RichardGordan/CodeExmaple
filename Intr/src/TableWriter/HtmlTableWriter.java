package TableWriter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class HtmlTableWriter implements TableWriter,OutputFileWriter{
    @Override

        public void writeTable(Row[] table) {
            try {
                FileWriter fileWriter = new FileWriter("table.html");
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                bufferedWriter.write("<table><tr><td>");
                Row header = table[0];
                bufferedWriter.write(header.left);
                bufferedWriter.write("</td><td>");
                bufferedWriter.write(header.right);
                bufferedWriter.write("</td></tr>");
                for(int i = 1; i < table.length;i++){
                    Row current = table[i];
                    bufferedWriter.write("<tr><td>" + current.left + "</td><td>" +  current.right + "</td></tr>");

                }
                bufferedWriter.write("</table>");
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
        return "table.HTML";
    }
}
