package S1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;
import javax.swing.JFileChooser;
public class wc {
    private static String command = "";
    private static String[] sParameter;
    private static String sFilename;
    private static int linecount = 0;
    private static int wordcount = 0;
    private static int charcount = 0;
    private static int nullLinecount = 0; // 空行数
    private static int codeLinecount = 0; // 代码行数
    private static int noteLinecount = 0; // 注释行数
    private static JFileChooser chooser;
    private static int flag_x = 0;
    public static void main(String[] args) {
        command = ""; // 存储用户命令
        while (true) {
            int flag_s = 0;
            System.out.print("wc.exe ");
            Scanner s = new Scanner(System.in);
            command = s.nextLine();
            // 得到输入命令
            if (command.equals("-x")) {
                ResponseforX();
                continue;
            }
            String[] arrMessSplit = command.split(" "); // 分割命令
            int iMessLength = arrMessSplit.length;
            sParameter = new String[iMessLength - 1];
            // 获取命令参数数组
            for (int i = 0; i < iMessLength - 1; i++) {
                sParameter[i] = arrMessSplit[i];
                if (sParameter[i].equals("-s")) {
                    flag_s = 1;
                }
            }
            // 获取文件名
            sFilename = arrMessSplit[iMessLength - 1];
            if (flag_s == 1) {
                ResponseforS();
            } else {
                BaseAndAdvanceCount();
                Response();
            }
        }
    }
    private static void ResponseforX() {
        // TODO Auto-generated method stub
        flag_x = 1;
        chooser = new JFileChooser();
        int value = chooser.showOpenDialog(null);
        if (value == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            sFilename = file.getAbsolutePath();
            BaseAndAdvanceCount();
            Response();
        }
    }
    private static void ResponseforS() {
        // TODO Auto-generated method stub
        String path = sFilename.substring(0, sFilename.indexOf("*") - 1);
        String type = sFilename.substring(sFilename.indexOf("*") + 1, sFilename.length());
        System.out.print("Path:");
        System.out.println(path + "\n");
        File dir = new File(path);
        if (dir.isDirectory()) {
            File next[] = dir.listFiles();
            for (int i = 0; i < next.length; i++) {
                if (!next[i].isDirectory()) {
                    // System.out.println(next[i].getName());
                    if (next[i].getName().substring(next[i].getName().indexOf("."), next[i].getName().length())
                            .equals(type)) {
                        System.out.println(next[i].getName());
                        sFilename = path + "\\" + next[i].getName();
                        BaseAndAdvanceCount();
                        Response();
                    }
                }
            }
        } else {
            System.out.println("path error");
        }
    }
    private static void Response() {
        if (flag_x == 1) {
            System.out.print("line count：");
            System.out.println(linecount);	
            System.out.print("word count：");
            System.out.println(wordcount);	
            System.out.print("char count：");
            System.out.println(charcount);
            System.out.print("blank lines count：");
            System.out.println(nullLinecount);
            System.out.print("code lines count：");
            System.out.println(codeLinecount);
            System.out.print("note lines count：");
            System.out.println(noteLinecount);
        } else {
            for (int i = 0; i < sParameter.length; i++) {
                if (sParameter[i].equals("-l")) {
                    System.out.print("line count：");
                    System.out.println(linecount);
                } else if (sParameter[i].equals("-w")) {
                    System.out.print("word count：");
                    System.out.println(wordcount);
                } else if (sParameter[i].equals("-c")) {
                    System.out.print("char count：");
                    System.out.println(charcount);
                } else if (sParameter[i].equals("-a")) {
                    System.out.print("blank lines count：");
                    System.out.println(nullLinecount);
                    System.out.print("code lines count：");
                    System.out.println(codeLinecount);
                    System.out.print("note lines count：");
                    System.out.println(noteLinecount);
                }
            }
        }
        System.out.println("");
    }
    private static void BaseAndAdvanceCount() {
        linecount = 0;
        wordcount = 0;
        charcount = 0;
        nullLinecount = 0;
        codeLinecount = 0;
        noteLinecount = 0;
        File file = new File(sFilename);
        if (file.exists()) {
            try {
                FileInputStream fis = new FileInputStream(file);
                InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
                BufferedReader br = new BufferedReader(isr);
                String line = "";
                StringBuffer sb = new StringBuffer();
                while ((line = br.readLine()) != null) {
                    linecount++;
                    sb.append(line);
                    charcount += line.length();
                    line = line.trim();
                    // 空白行
                    if (line == "" || line.length() <= 1) {
                        nullLinecount++;
                        continue;
                    }
                    // 注释行
                    int a = line.indexOf("/");
                    int b = line.substring(a + 1).indexOf("/");
                    if (b == 0) {
                        noteLinecount++;
                        continue;
                    }
                    // 代码行
                    codeLinecount++;
                }
                wordcount = sb.toString().split("\\s+").length;//
                br.close();
                isr.close();
                fis.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("path error");
        }
    }
}