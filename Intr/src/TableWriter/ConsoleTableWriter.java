package TableWriter;

public class ConsoleTableWriter implements TableWriter, OutputFileWriter {
    @Override
    public void writeTable(Row[] table) {
        for(int i = 0; i < table.length;i++){
            Row current = table[i];
            System.out.println(current.left + "\t\t" + "|"+  current.right + "\n");

        }
    }

    @Override
    public String getOutputPlace() {
        return "console";
    }

    @Override
    public String getFileName() {
        return "console";
    }
}
