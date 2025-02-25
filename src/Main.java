import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Main {

    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        List<String> games = List.of("/users/admin/Games/src", "/users/admin/Games/res",
                                    "/users/admin/Games/savegames", "/users/admin/Games/temp");
        List<String> src = List.of("/users/admin/Games/src/main", "/users/admin/Games/src/test");
        List<String> res = List.of("/users/admin/Games/res/drawables",
                                "/users/admin/Games/res/vectors", "/users/admin/Games/res/icons");
        List<String> main = List.of("/users/admin/Games/src/main/Main.java", "/users/admin/Games/src/main/Utils.java");
        String tempFile = "/users/admin/Games/temp/temp.txt";

        for (String dir : games) {
            createDir(dir);
        }
        for (String dir : src) {
            createDir(dir);
        }
        for (String dir : res) {
            createDir(dir);
        }
        for (String file : main) {
            createFile(file);
        }
        writeToFile(tempFile);
    }

    public static void createDir(String path) {
        File newDir = new File(path);
        if (newDir.mkdir())
            sb.append(String.format("Каталог %s создан%n", path));
        else
            sb.append(String.format("Не удалось создать каталог %s%n", path));
    }

    public static File createFile(String path) {
        File newFile = new File(path);
        try {
            if (newFile.createNewFile())
                sb.append(String.format("Файл %s создан%n", path));
        } catch ( IOException e) {
            sb.append(String.format("Не удалось создать файл %s%n", path));
        }
        return newFile;
    }

    public static void writeToFile(String path) {
        File newFile = createFile(path);
        try(FileWriter writer = new FileWriter(newFile)) {
            writer.write(String.valueOf(sb));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}