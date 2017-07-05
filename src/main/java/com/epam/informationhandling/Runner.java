package com.epam.informationhandling;

import com.epam.informationhandling.chain.TextSeparator;
import com.epam.informationhandling.entity.Component;
import com.epam.informationhandling.util.TextReader;
import com.sun.deploy.util.StringUtils;

import java.util.Arrays;

public class Runner {
    private static String pathToFile = "text.txt";
    final static String VOVA = "\tIt has survived not only five centuries, but also the leap into 13+ i-- electronic\n" +
            "typesetting, remaining 3+5 essentially 6+9*(3-4) unchanged. It was popularised in the\n" +
            "5*(1*2*(3*(4*(5- --j + 4)-3)-2)-1) with the release of Letraset sheets containing Lorem\n" +
            "Ipsum passages, and more recently with desktop publishing software like Aldus\n" +
            "PageMaker including versions of Lorem Ipsum.\n" +

            "\tIt is a long established fact that a reader will be distracted by the readable\n" +
            "content of a page when looking at its layout. The point of using (71-(2*i--*(3*(2-1/2*2)-\n" +
            "2)-10/2))*++i Ipsum is that it has a more-or-less normal distribution of letters, as\n" +
            "opposed to using 'Content here, content here', making it look like readable English.\n" +

            "\tIt is a (-5+1/2*(2+5*2- --j))*1200 established fact that a reader will be of a page\n" +
            "when looking at its layout?\n" +

            "\tBye.";

    final static String my = "\tIt has survived not only five centuries, but also the leap into 13+(3++) electronic --3 typesetting, remaining 3+5- essentially 6+9*(3-4) unchanged.\n" +
            "\tIt was popularised in the 5*(1*2*(3*(4*(5-4)-3)-2)-1) with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.\n" +
            "\tIt is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using (0-(2*2*(3*(2-1/2*2)-2)-10/2))*(++5) Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English.\n" +
            "\tIt is a (-5+1/2*(2+5*2))*1200 established fact that a reader will be of a page when looking at its layout.\n" +
            "\tBye.";

    public static void main(String[] args) {
        String [] arr = "5*(1*2*(3*(4*(5-4)-3)-2)-1)".split("");
        Arrays.sort(arr);
        TextReader textReader = new TextReader();
        String content = textReader.readText(pathToFile);
        TextSeparator textSeparator = new TextSeparator();
        Component composite = textSeparator.separate(my);
    }
}
