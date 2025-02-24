import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> games = List.of("src", "res", "savegames", "temp");
        List<String> src = List.of("main", "test");
        List<String> res = List.of("drawables", "vectors", "icons");
        List<String> main = List.of("Main.java", "Utils.java");

        StringBuilder sb = new StringBuilder();

        for (String dir : games) {
            String path = "/users/admin/Games/" + dir;
            File newDir = new File(path);
            if (newDir.mkdir())
                sb.append(String.format("Каталог %s создан%n", path));
        }
        for (String dir : src) {
            String path = "/users/admin/Games/src/" + dir;
            File newDir = new File(path);
            if (newDir.mkdir())
                sb.append(String.format("Каталог %s создан%n", path));
        }
        for (String dir : res) {
            String path = "/users/admin/Games/res/" + dir;
            File newDir = new File(path);
            if (newDir.mkdir())
                sb.append(String.format("Каталог %s создан%n", path));
        }
        for (String file : main) {
            String path = "/users/admin/Games/src/main/" + file;
            File newFile = new File(path);
            try {
                if (newFile.createNewFile())
                    sb.append(String.format("Файл %s создан%n", path));
            } catch ( IOException e) {

            }
        }
        String path = "/users/admin/Games/temp/temp.txt";
        File newFile = new File(path);
        try {
            if (newFile.createNewFile())
                sb.append(String.format("Файл %s создан%n", path));
        } catch ( IOException e) {
            System.out.println(e.getMessage());
        }
        try(FileWriter writer = new FileWriter(newFile)) {
            writer.write(String.valueOf(sb));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}