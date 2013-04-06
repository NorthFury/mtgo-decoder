package mtgo.decoder;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 *
 * @author North
 */
public class Main {

    public static final Charset UTF8_CHARSET = Charset.forName("UTF-8");

    public static void main(String[] args) throws IOException {
        DataDecoder dataDecoder = new DataDecoder("E:\\Games\\Magic Online\\");
        List<Card> cardList = dataDecoder.decode();

        outputCardData(cardList);
        outputFullCardData(cardList);
        outputDebugData(cardList);
    }

    private static void outputCardData(List<Card> cardList) throws IOException {
        Path path = Paths.get("cards-data.txt");
        try (BufferedWriter out = Files.newBufferedWriter(path, UTF8_CHARSET)) {
            for (Card card : cardList) {
                out.write(card.getImageData());
                out.newLine();
            }
        }
    }

    private static void outputFullCardData(List<Card> cardList) throws IOException {
        Path path = Paths.get("cards-data-full.txt");
        try (BufferedWriter out = Files.newBufferedWriter(path, UTF8_CHARSET)) {
            for (Card card : cardList) {
                out.write(card.getFullData());
                out.newLine();
            }
        }
    }

    private static void outputDebugData(List<Card> cardList) throws IOException {
        Path path = Paths.get("debug.txt");
        try (BufferedWriter out = Files.newBufferedWriter(path, UTF8_CHARSET)) {
            for (Card card : cardList) {
                out.write(card.getDebugData());
                out.newLine();
            }
        }
    }
}
