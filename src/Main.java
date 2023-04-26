import java.io.*;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        StringBuilder sb = new StringBuilder();

        List<File> myFolders = Arrays.asList(
                new File("D://myGames"),

                new File("D://myGames//src"),
                new File("D://myGames//res"),
                new File("D://myGames//savegames"),
                new File("D://myGames//temp"),

                new File("D://myGames//src//main"),
                new File("D://myGames//src//test"),

                new File("D://myGames//res//drawables"),
                new File("D://myGames//res//vectors"),
                new File("D://myGames//res//icons")
        );
        List<File> myFiles = Arrays.asList(
                new File("D://myGames//src//main//Main.java"),
                new File("D://myGames//src//main//Utils.java"),

                new File("D://myGames//temp//temp.txt")
        );

        myFolders.stream()
                .forEach(folder -> {
                    if (folder.mkdir()) {
                        sb.append("Папка " + folder + " создана\n");
                    } else sb.append("Папка " + folder + " не создана\n");
                });

        myFiles.stream()
                .forEach(file -> {
                    try {
                        if (file.createNewFile()) {
                            sb.append("Файл " + file + " создан\n");
                        } else sb.append("Файл " + file + " не создан\n");
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });

        FileWriter writer = new FileWriter("D://myGames//temp//temp.txt");
        writer.write(sb.toString());
        writer.flush();
        writer.close();

        System.out.print(sb);
    }
}