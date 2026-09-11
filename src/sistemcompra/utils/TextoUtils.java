package sistemcompra.utils;

import java.text.Normalizer;

public class TextoUtils {

    public static String quitarTildes(String texto) {
        return Normalizer.normalize(texto, Normalizer.Form.NFD)
                .replaceAll("\\p{M}", "");
    }
}
