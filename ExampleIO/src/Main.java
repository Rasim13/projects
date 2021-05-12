import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

public class Main {
    public static void main(String[] args) throws IOException {
//        getReadFile();
//        copyFileToOtherFile();
        //Нужно доработать
//        downloadBinaryFile();
//        downloadWebPage();
        saveDownLoadedPage();

    }

    public static void saveDownLoadedPage() throws IOException {
        String webURL = "https://yandex.ru";
        URL url = new URL(webURL);
        InputStream is =  url.openStream();
        try( BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        }
        catch (MalformedURLException e) {
            e.printStackTrace();
            throw new MalformedURLException("URL is malformed!!");
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void downloadWebPage() {
        String webPage = "https://yandex.ru";

        try {
            URL url = new URL(webPage);
            BufferedReader readr =
                    new BufferedReader(new InputStreamReader(url.openStream()));
            BufferedWriter writer =
                    new BufferedWriter(new FileWriter("Download.html"));

            String line;
            while ((line = readr.readLine()) != null) {
                writer.write(line);
            }

            readr.close();
            writer.close();
            System.out.println("Successfully Downloaded.");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void downloadBinaryFile() {
        BufferedInputStream in = null;
        FileOutputStream out = null;

        try {
            in = new BufferedInputStream(new URL("https://gsgen.ru/tools/fish-text/.jpg").openStream());
            out = new FileOutputStream("D:\\Java\\Projects\\zamaltdinov_javaitis13\\ExampleIO\\DownloadFile.txt");

            byte dataBuffer[] = new byte[1024];
            int bytesRead = 0;
            while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
                out.write(dataBuffer, 0, bytesRead);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void copyFileToOtherFile() throws IOException{
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream("D:\\Java\\Projects\\zamaltdinov_javaitis13\\ExampleIO\\Source.txt");
            os = new FileOutputStream("D:\\Java\\Projects\\zamaltdinov_javaitis13\\ExampleIO\\CopyFile.txt");
            byte[] buffer = new byte[1024];
            int length;
            while((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
        } finally {
            is.close();
            os.close();
        }
    }

    public static void getReadFile() {
        FileInputStream fis = null;
        InputStreamReader isr = null;
        int b = 0;
        try {
            fis = new FileInputStream("D:/Java/Projects/zamaltdinov_javaitis13/ExampleIO/File.txt");
            isr = new InputStreamReader(fis,"UTF-8");
            while((b = isr.read()) != -1) {
                System.out.println((char)b);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
