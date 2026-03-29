package sp.conventer;


import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

class Main{
    public static void main() {

        Scanner scanner = new Scanner(System.in);
        String dir = "mp3music";

        try {
            Files.createDirectories(Paths.get(dir));
        } catch (IOException e){
            System.err.println("Failed to create folder: " + e.getMessage());
        }

        System.out.println("=== REPL YT TO MP3 ===");
        System.out.println("Enter 'exit' to quit.");

        while(true){
            System.out.print("\nEnter your link here: \n");
            String input = scanner.nextLine().trim();

            if(input.equalsIgnoreCase("exit")) break;
            if(input.isEmpty()) continue;

            run(input, dir);

        }

        System.out.println("Bye!");

    }

    private static void run(String url, String folder){
        try{
            ProcessBuilder processbuilder = new ProcessBuilder(
                    "yt-dlp",
                    "--no-playlist",
                    "-x",
                    "--audio-format", "mp3",
                    "-o", folder + "/%(title)s.%(ext)s",
                    url
            );

            processbuilder.redirectErrorStream(true);
            Process p = processbuilder.start();

            try(BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()))){
                String line;
                while((line = r.readLine()) != null){
                    if(line.contains("[download]")){
                        System.out.println("\r" + line);
                    }
                }

            }

            int code = p.waitFor();
            if(code == 0){
                System.out.print("\n[DONE] Music stored in a folder: " + folder);
            }else{
                System.out.print("\n[ERROR] Somethink went wrong!");
            }


        }catch (IOException | InterruptedException e){
            System.out.println("\n Critical Error: " + e.getMessage());
        }
    }

}
