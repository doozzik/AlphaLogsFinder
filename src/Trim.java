import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by doozzik on 4/8/16.
 */
public class Trim
{
    public Trim(JTextArea logsIn, JTextArea logsParam, JTextArea logsOut)
    {
        String[] linesIn = logsIn.getText().split("\n");
        String[] linesParam = logsParam.getText().split("\n");
        List<String> linesOut = new ArrayList<String>();
        String stringOut = "";

        for (String in : linesIn)
        {
            for (String param : linesParam)
            {
                if (in.toLowerCase().contains(param.toLowerCase()) && !in.toLowerCase().contains("<" + param.toLowerCase() + ">"))
                {
                    linesOut.add(in);
                    break;
                }
            }
        }


        List<String> lastParam = new ArrayList<String>();
        for (int i = 0; i < 50; i++)
        {
            for (int k = 0; k < 50; k++)
            {
                lastParam.add("\u001B[0;" + i + ";" + k + "m");
            }
        }

        for (String out : linesOut)
        {
            out = out.replace("[Server thread/INFO]: ", "");
            out = out.replace("\u001B[m", "");
            if (out.contains("[Async Chat Thread - #"))
            {
                out = out.substring(0, 11) + out.substring(43);
            }
            if (out.contains("\u001B[0;"))
            {
                for (String str : lastParam)
                {
                    out = out.replace(str, "");
                }
            }

            stringOut += out + "\n";
        }

        logsOut.setText(stringOut);
    }
}
